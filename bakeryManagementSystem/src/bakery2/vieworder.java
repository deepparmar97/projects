package bakery2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class vieworder implements ActionListener  {
	JFrame myframe;
	JButton home;
	JTable table;
	JButton bt;
	JScrollPane sc;
	String headings[]={"Order ID","Product ID","Product Name","Customer Name","quantity","Address","Price per.(Rs.)","Total in Rs.","Today","Delivery Date"};
	Object data [][]=new Object[20][11];
	public void orderFrame(){
		myframe=new JFrame("VIEW ORDER");
		myframe.setLayout(null);
		myframe.setResizable(false);
		bt=new JButton("View");
		//myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=1200;
		int windowHeight=700;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		
		myframe.setVisible(true);
		bt.setBounds(50,50,100,40);
		myframe.add(bt);
		
		home=new JButton(new ImageIcon("images/homebt.png"));
		
		home.setBounds(600, 50, 100, 100);
		//myframe.add(home);
		
		bt.addActionListener(this);
		home.addActionListener(this);

	
			//JOptionPane.showMessageDialog(null, "Hi View Button");

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home){
			myframe.dispose();
			info in=new info();
			in.frameInfo();
		}
		if(e.getSource()==bt){
			Connection con=DBconnection.getConnection();
				try
				{
					PreparedStatement pstmt=con.prepareStatement("Select * From tab");
			
					ResultSet rst=pstmt.executeQuery();
					int row=0;
					while(rst.next())
					{
						data[row][0]=rst.getInt("orderid");
						data[row][1]=rst.getInt("proid");
						data[row][2]=rst.getString("proname");
						data[row][3]=rst.getString("cname");
						data[row][4]=rst.getInt("quan");
						data[row][5]=rst.getString("add");
						data[row][6]=rst.getInt("pricep");
						data[row][7]=rst.getInt("total");
						data[row][8]=rst.getString("currentdate");
						data[row][9]=rst.getString("Deliverydate");
						data[row][10]=rst.getString("confirm");
						row++;
					}
					
					table=new JTable(data,headings);
					table.setEnabled(false);
					table.setForeground(Color.BLUE);
					table.setGridColor(Color.BLACK);
					table.setRowHeight(30);
					table.getTableHeader().setFont(new Font("Courier", Font.BOLD, 14));
					table.setBackground(Color.WHITE);
					//table.setShowGrid(false);
					table.setFont(new Font("Courier", Font.BOLD, 12));
					
					sc=new JScrollPane(table);
					sc.setBounds(0,100,1200,600);
					myframe.add(sc);
					
					
					
				}
				catch(SQLException ea)
				{
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
			}
			
		}
	}

