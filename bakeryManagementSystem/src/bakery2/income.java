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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class income implements ActionListener {
	JFrame myframe;
	JDateChooser date1;
	JButton view,view2,home;
	JTextField text;
	Date d1;
	JTable table,table1;
	JScrollPane sc;
	String dobstr1,dobstr2;
	String headings[]={"Order ID","Product ID","Product Name","Customer Name","quantity","Address","Price per.(Rs.)","Total in Rs.","Today","Delivery Date","Confirmation"};
	Object data [][]=new Object[20][11];
	Date cdate = new Date();
	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	
	public void incomeFrame(){
		myframe=new JFrame("Info");
		myframe.setLayout(null);
		myframe.setResizable(false);
		//myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=1200;
		int windowHeight=700;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		
		myframe.setVisible(true);
		
		date1=new JDateChooser();
		view=new JButton("View Acc. Date");
		view2=new JButton("Today's Order");
		home=new JButton(new ImageIcon("images/homebt.png"));
		
		home.setBounds(900, 20, 60, 65);
		date1.setBounds(50,50,200,40); 	 view.setBounds(320,50,200,40);
		 view2.setBounds(670,50,200,40);
		
		myframe.add(home);	myframe.add(view); myframe.add(view2);
		myframe.add(date1);	
		
		home.addActionListener(this);
		view.addActionListener(this);
		view2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home){
			myframe.dispose();
			info in=new info();
			in.frameInfo();
		}
		if(e.getSource()==view){
			Connection con=DBconnection.getConnection();
			d1=date1.getDate();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			dobstr1=sdf.format(d1);
			try{
				PreparedStatement pstmt=con.prepareStatement("Select * From tab where Deliverydate=?");
				pstmt.setString(1, dobstr1);
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
					//data[row][10]=rst.getString("confirm");
					row++;
				}
				
				table=new JTable(data,headings);
				table.setEnabled(false);
				table.setForeground(Color.RED);
				table.setGridColor(Color.BLUE);
				table.setRowHeight(30);
				table.getTableHeader().setFont(new Font("Courier", Font.BOLD, 16));
				table.setBackground(Color.CYAN);
				//table.setShowGrid(false);
				table.setFont(new Font("Courier", Font.BOLD, 12));
				
				sc=new JScrollPane(table);
				sc.setBounds(25,200,1150,400);
				myframe.add(sc);
			}
			catch(Exception a){
				JOptionPane.showMessageDialog(null, "Connection Error");
			}
		}
		if(e.getSource()==view2){
			
			Connection con=DBconnection.getConnection();
			dobstr2=dateFormat.format(cdate);
			try{
				PreparedStatement pstmt1=con.prepareStatement("Select * From tab where currentdate=?");
				pstmt1.setString(1, dobstr2);
				ResultSet rst1=pstmt1.executeQuery();
				int row=0;
				while(rst1.next())
				{
					
					data[row][0]=rst1.getInt("orderid");
					data[row][1]=rst1.getInt("proid");
					data[row][2]=rst1.getString("proname");
					data[row][3]=rst1.getString("cname");
					data[row][4]=rst1.getString("quan");
					data[row][5]=rst1.getString("add");
					data[row][6]=rst1.getInt("pricep");
					data[row][7]=rst1.getInt("total");
					data[row][8]=rst1.getString("currentdate");
					data[row][9]=rst1.getString("Deliverydate");
					data[row][10]=rst1.getString("confirm");
					row++;
				}
				
				table1=new JTable(data,headings);
				table1.setEnabled(false);
				table1.setForeground(Color.RED);
				table1.setGridColor(Color.BLUE);
				table1.setRowHeight(30);
				table1.getTableHeader().setFont(new Font("Courier", Font.BOLD, 12));
				table1.setBackground(Color.CYAN);
				//table.setShowGrid(false);
				table1.setFont(new Font("Courier", Font.BOLD, 12));
				
				sc=new JScrollPane(table1);
				sc.setBounds(25,200,1150,400);
				myframe.add(sc);
			}
			catch(Exception a){
				JOptionPane.showMessageDialog(null, "Connection Error");
			}
		}
	}

}
