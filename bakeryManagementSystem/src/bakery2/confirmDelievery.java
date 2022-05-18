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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class confirmDelievery implements ActionListener {
JFrame myframe;
JLabel proid,pname,price,cname,quantity,ddate,address,orderlb;
JLabel proidtxt,pnametxt,pricetxt,cnametxt,quantitytxt,ddatetxt,addresstxt;
JLabel total,totaltxt,yeslb;
JCheckBox yes,no;
JTextField ordertxt;
String n,cn,dd,add,check;
int pid,p,t,q,c,oid;
JButton get,update;
Font f,ff;
int y;
	
	public void delieveryInfo(){
		myframe=new JFrame("bill");
		myframe.setLayout(null);
		myframe.setResizable(false);
		//myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=900;
		int windowHeight=700;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		
		myframe.setVisible(true);
		
		get=new JButton("GET");
		update=new JButton("UPDATE");
		//proid=new JLabel();
		orderlb=new JLabel("Order ID");
		ordertxt=new JTextField();
		pname=new JLabel();
		cname=new JLabel();
		quantity=new JLabel();
		price=new JLabel();
		total=new JLabel();
		address=new JLabel();
		ddate=new JLabel();
		yeslb=new JLabel("Confirmation");
		yes=new JCheckBox("Delievered");
		no=new JCheckBox("Not delievered yet");
		pnametxt=new JLabel("Product   :");
		cnametxt=new JLabel("Customer Name    :");
		quantitytxt=new JLabel("Quantity");
		pricetxt=new JLabel("Price Per Piece");
		totaltxt=new JLabel("Total Amount");
		addresstxt=new JLabel("Address");
		ddatetxt=new JLabel("Delivery Date");
		
		//proid.setBounds(50,50,200,40);	
		orderlb.setBounds(150,50,200,40);   ordertxt.setBounds(450,50,200,40);
		get.setBounds(700,50,100,40);
		pnametxt.setBounds(150,100,200,40);pname.setBounds(450,100,300,40);
		cnametxt.setBounds(150,150,200,40);cname.setBounds(450,150,300,40);
		pricetxt.setBounds(150,200,200,40);price.setBounds(450,200,300,40);
		quantitytxt.setBounds(150,250,200,40);quantity.setBounds(450,250,300,40);
		totaltxt.setBounds(150,300,200,40);total.setBounds(450,300,300,40);
		ddatetxt.setBounds(150,350,200,40);ddate.setBounds(450,350,300,40);
		addresstxt.setBounds(150,400,200,50);address.setBounds(450,400,300,50);
		yeslb.setBounds(150,450,200,50);    yes.setBounds(450,450,300,30);
																		no.setBounds(450,510,300,30);
		update.setBounds(450,580,200,40);
		
		//set Font
		f=new Font("Ubuntu",Font.PLAIN,18);
		ff=new Font("Courier",Font.BOLD,18);
		yeslb.setFont(f); 	yes.setFont(ff); no.setFont(ff);
		pname.setFont(ff);		pnametxt.setFont(f);
		cname.setFont(ff);		cnametxt.setFont(f);
		price.setFont(ff);		pricetxt.setFont(f);
		quantity.setFont(ff);		quantitytxt.setFont(f);
		total.setFont(ff);		totaltxt.setFont(f);
		ddate.setFont(ff);		ddatetxt.setFont(f);
		address.setFont(ff);		addresstxt.setFont(f);
		get.setFont(f);				orderlb.setFont(f);		ordertxt.setFont(f);
		update.setFont(ff);
		
		//myframe.add(proid);
		myframe.add(yeslb);
		myframe.add(yes);
		myframe.add(no);
		myframe.add(orderlb);
		myframe.add(ordertxt);
		myframe.add(get);
		myframe.add(pname);
		myframe.add(cname);
		myframe.add(price);
		myframe.add(quantity);
		myframe.add(total);
		myframe.add(address);
		myframe.add(ddate);
		myframe.add(pnametxt);
		myframe.add(cnametxt);
		myframe.add(pricetxt);
		myframe.add(quantitytxt);
		myframe.add(totaltxt);
		myframe.add(addresstxt);
		myframe.add(ddatetxt);
		myframe.add(update);
		
		get.addActionListener(this);
		update.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con=DBconnection.getConnection();
		c=Integer.parseInt(ordertxt.getText());
		if(e.getSource()==get)
		{
		try
		{
			PreparedStatement pstmt=con.prepareStatement("Select * from tab where orderid=? ");
			pstmt.setInt(1, c);
			ResultSet rs=pstmt.executeQuery();
			if(rs.last())
			{
				dd=rs.getString("Deliverydate");
				ddate.setText(dd);
				
				n=rs.getString("proname");
				pname.setText(n);
				cn=rs.getString("cname");
				cname.setText(cn);
				q=rs.getInt("quan");
				quantity.setText(String.valueOf(q));
				add=rs.getString("add");
				address.setText(add);
				t=rs.getInt("total");
				total.setText(String.valueOf(t));
				p=rs.getInt("pricep");
				price.setText(String.valueOf(p));
				
			}
		}
		catch(SQLException se)
		{
			JOptionPane.showMessageDialog(null, "SQL Error 1");
		}
		
	}
		if(e.getSource()==update)
		{
			oid=Integer.parseInt(ordertxt.getText());
			check="";
			if(yes.isSelected()==true)
				check="Delievered";
			if(no.isSelected()==true)
				check="Not delievered yet!";
		try
		{
			PreparedStatement pstmt=con.prepareStatement("Update tab set confirm=? where orderid=?");
			pstmt.setString(1, check);
			pstmt.setInt(2, oid);
			
			y=pstmt.executeUpdate();
		}
		catch(SQLException se)
		{
			JOptionPane.showMessageDialog(null, "SQL Error 2");
		}
		if(y>0)
		{
			JOptionPane.showMessageDialog(null, "Update Successfully");
		}
	}

	}
}
