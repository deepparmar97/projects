package bakery2;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class calculateIncome implements ActionListener {
JFrame myframe;
JLabel totallb,totaltxt;
JLabel totallb2,totaltxt2;
JButton bt,bt2;
JDateChooser ch,ch2;
Date box1,box2;
Date cdate=new Date();
DateFormat dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
Font f;
Font flb;
String dobstr,dd,dd2;
int d1,d2;
	
	public void incomeFrame(){
		myframe=new JFrame("bill");
		myframe.setLayout(null);
		myframe.setResizable(false);
		//myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=900;
		int windowHeight=720;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		myframe.setVisible(true);
		
		totaltxt=new JLabel();
		totallb=new JLabel("Today Current Income :");
		totaltxt2=new JLabel("sfsg ");
		totallb2=new JLabel("Today Current Income :");
		ch=new JDateChooser();
		ch2=new JDateChooser();
		bt=new JButton("VIEW");
		bt2=new JButton("VIEW");
		
		totallb.setBounds(150,100,300,40);
		totaltxt.setBounds(500,100,250,40);
		totallb2.setBounds(150,400,300,40);
		totaltxt2.setBounds(500,400,250,40);
		bt.setBounds(650,0,150,40);
		
		ch2.setBounds(150,200,300,40);
		ch.setBounds(500,200,250,40);
		bt2.setBounds(800,200,150,40);
		
		//set Font
		f=new Font("Ubuntu",Font.PLAIN,18);
		flb=new Font("Courier",Font.BOLD,18);
		
		totaltxt.setFont(flb);
		totallb.setFont(flb);
		
		myframe.add(totallb);
		myframe.add(totaltxt);
		myframe.add(totallb2);
		myframe.add(totaltxt2);
		myframe.add(bt);
		myframe.add(ch);
		myframe.add(ch2);
		myframe.add(bt2);
		
		bt.addActionListener(this);
		bt2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		Connection con=DBconnection.getConnection();
		dobstr=dateFormat.format(cdate);
		if(e.getSource()==bt)
		{
			bt.hide();
		try
		{
			PreparedStatement pstmt=con.prepareStatement("SELECT total FROM tab where currentdate=? ");
			//pstmt.setString(1, "total");
			pstmt.setString(1, dobstr);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				d1+=rs.getInt("total");
				totaltxt.setText(String.valueOf("Rs. "+d1));
				//System.out.print(cdate);
			}
		}
		catch(SQLException se)
		{
			JOptionPane.showMessageDialog(null, "SQL Error 1");
		}
		
	}
		if(e.getSource()==bt2)
		{
			//bt.hide();
			box1=ch.getDate();
			dd=dateFormat.format(box1);
			box2=ch2.getDate();
			dd2=dateFormat.format(box2);
		try
		{
			PreparedStatement pstmt2=con.prepareStatement("SELECT total FROM tab where currentdate >= ? AND currentdate <= ?");
			pstmt2.setString(1, dd);
			pstmt2.setString(1, dd2);
			ResultSet rs2=pstmt2.executeQuery();
			while(rs2.next())
			{
				d2+=rs2.getInt("total2");
				totaltxt2.setText(String.valueOf("Rs. "+d2));
				//System.out.print(cdate);
			}
		}
		catch(SQLException se)
		{
			JOptionPane.showMessageDialog(null, "SQL Error 2");
		}
		
	}

	}

	
	}

