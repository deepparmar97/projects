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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class viewPCode implements ActionListener{
	JFrame myframe;
	JButton home;
	JTable table;
	JLabel back;
	JScrollPane sc;
	String headings[]={"Product ID","Product Name"};
	Object data [][]=new Object[20][2];
	public void codeFrame(){
		myframe=new JFrame("VIEW ORDER");
		myframe.setLayout(null);
		myframe.setResizable(false);
		//myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=1000;
		int windowHeight=700;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		
		myframe.setVisible(true);
		home=new JButton(new ImageIcon("images/homebt.png"));
		back=new JLabel(new ImageIcon("images/center2.png"));
		
		home.setBounds(1000, 50, 100, 100);
		back.setBounds(0, 0, 1000, 700);
		
		myframe.add(home);
		
		
		
		home.addActionListener(this);

	
			//JOptionPane.showMessageDialog(null, "Hi View Button");
		Connection con=DBconnection.getConnection();
		try
		{
			PreparedStatement pstmt=con.prepareStatement("Select * From tab");
	
			ResultSet rst=pstmt.executeQuery();
			int row=0;
			while(rst.next())
			{
				data[row][0]=rst.getInt("proid");
				data[row][1]=rst.getString("proname");
				row++;
			}
			
			table=new JTable(data,headings);
			table.setEnabled(false);
			table.setForeground(Color.RED);
			table.setGridColor(Color.BLUE);
			table.setRowHeight(30);
			table.getTableHeader().setFont(new Font("Courier", Font.BOLD, 20));
			//table.setBackground(Color.CYAN);
			//table.setShowGrid(false);
			table.setFont(new Font("Courier", Font.BOLD, 16));
			
			sc=new JScrollPane(table);
			sc.setBounds(200,50,600,600);
			myframe.add(sc);
			myframe.add(back);
			
			
			
		}
		catch(SQLException ea)
		{
			JOptionPane.showMessageDialog(null, "Connection Error");
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home){
			myframe.dispose();
			info in=new info();
			in.frameInfo();
		}
	}
}
