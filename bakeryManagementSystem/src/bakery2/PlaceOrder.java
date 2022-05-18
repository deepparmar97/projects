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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class PlaceOrder implements ActionListener {
JFrame myframe;
JDateChooser dchooser;
JLabel back,orderlb,customername,productid,deliverydate,price,quantity,productlb,address,gtotal,curdatelb;
JTextField ordertxt,nametxt,product,date,quantxt,pricetxt,proname,totaltxt,curdate;
JButton go,placeorder,stotal;
JTextArea addresstxt;
int cd,p,qq,msg,oid,orderc;
String n,nn,cn,dobstr,add;
Date dd;
Font f;
Double t,gt,pp;
Date cdate = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	
	public void rawFrame(){
		myframe=new JFrame("Place Order Form");
		myframe.setLayout(null);
		myframe.setResizable(false);
		//myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=900;
		int windowHeight=700;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		
		myframe.setVisible(true);
		f=new Font("Courier",Font.PLAIN,18);
		
		back=new JLabel(new ImageIcon("images/center2.png"));
		productid=new JLabel("Product ID");
		customername=new JLabel("Customer Name");
		productlb=new JLabel("Product");
		deliverydate=new JLabel("Delievery Date");
		quantity=new JLabel("Quantity");
		price=new JLabel("Price per");
		address=new JLabel("Address");
		gtotal=new JLabel("Grand Total");
		orderlb=new JLabel("Order ID");
		ordertxt=new JTextField();
		product=new JTextField();
		nametxt=new JTextField();
		addresstxt=new JTextArea();
		dchooser=new JDateChooser();
		quantxt=new JTextField();
		pricetxt=new JTextField();
		proname=new JTextField();
		totaltxt=new JTextField();
		curdatelb=new JLabel("Order Date");
		curdate=new JTextField();
		curdate.setText(dateFormat.format(cdate));
		
		go=new JButton("Go");
		stotal=new JButton("Total");
		placeorder=new JButton("Place order");
		
		back.setBounds(0,0,900,700);
		orderlb.setBounds(100,50,200,35); 	ordertxt.setBounds(350,50,250,35);
		productid.setBounds(100,100,200,35); 				product.setBounds(350,100,250,35);
		go.setBounds(605,100,100,35);
		productlb.setBounds(100,150,200,35);	proname.setBounds(350,150,250,35);
		customername.setBounds(100,200,200,35);				nametxt.setBounds(350,200,250,35);
		deliverydate.setBounds(100,250,200,35);				dchooser.setBounds(350,250,250,35);
		price.setBounds(100,300,200,35);				pricetxt.setBounds(350,300,250,35);
		quantity.setBounds(100,350,200,35);				quantxt.setBounds(350,350,250,35);
		address.setBounds(100,400,200,35);				addresstxt.setBounds(350,400,250,100);
		gtotal.setBounds(100,510,200,35);				totaltxt.setBounds(350,510,250,35);
		stotal.setBounds(605,510,100,35);
		curdatelb.setBounds(100,560,200,35); 	curdate.setBounds(350,560,250,35);
		placeorder.setBounds(350,610,250,35);
		
		//set Font
		orderlb.setFont(f);											ordertxt.setFont(f);
		customername.setFont(f);								nametxt.setFont(f);
		productid.setFont(f);										product.setFont(f);
		deliverydate.setFont(f);									dchooser.setFont(f);
		price.setFont(f);												quantxt.setFont(f);
		quantity.setFont(f);											pricetxt.setFont(f);
		productlb.setFont(f);										proname.setFont(f);
		address.setFont(f);											totaltxt.setFont(f);
		gtotal.setFont(f);												curdate.setFont(f);
		curdatelb.setFont(f);										stotal.setFont(f);
		go.setFont(f);														placeorder.setFont(f);
		
		productid.setForeground(Color.WHITE);
		customername.setForeground(Color.WHITE);
		productlb.setForeground(Color.WHITE);
		deliverydate.setForeground(Color.WHITE);
		quantity.setForeground(Color.WHITE);
		price.setForeground(Color.WHITE);
		address.setForeground(Color.WHITE);
		gtotal.setForeground(Color.WHITE);
		orderlb.setForeground(Color.WHITE);
		
		myframe.add(orderlb);		myframe.add(ordertxt);
		myframe.add(productid);		myframe.add(product);  myframe.add(go);
		myframe.add(customername);		myframe.add(nametxt);
		myframe.add(productlb);		myframe.add(proname);
		myframe.add(deliverydate);		myframe.add(dchooser);
		myframe.add(quantity);		myframe.add(quantxt);
		myframe.add(price);		myframe.add(pricetxt);
		myframe.add(address);		myframe.add(addresstxt);
		myframe.add(gtotal);		myframe.add(totaltxt);	myframe.add(stotal);
		myframe.add(curdatelb);	 	myframe.add(curdate);
		myframe.add(placeorder);
		myframe.add(back);
		
		go.addActionListener(this);
		stotal.addActionListener(this);
		placeorder.addActionListener(this);
		
		Connection con=DBconnection.getConnection();
		try{
			PreparedStatement pstmt=con.prepareStatement("Select * from tab");
			//pstmt.setString(1, "oderid");
			ResultSet rs=pstmt.executeQuery();
			if(rs.last()){
				orderc=rs.getInt("orderid");
				ordertxt.setText(String.valueOf(orderc+1));
			}
			else
			{
				ordertxt.setText(String.valueOf(1000));
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error 1");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con2=DBconnection.getConnection();
		cd=Integer.parseInt(product.getText());
		
		if(e.getSource()==go)
		{
			
			
			try{
				PreparedStatement pstmt2=con2.prepareStatement("Select * from addproduct where code=?");
				pstmt2.setInt(1, cd);
				ResultSet rs2=pstmt2.executeQuery();
				if(rs2.next())
				{
					n=rs2.getString("name");
					proname.setText(n);
					
					p=rs2.getInt("price");
 					pricetxt.setText(Integer.toString(p));
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Record Not Found");
				}
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "SQL Error 1");
			}
		}//end of go button
		if(e.getSource()==stotal)
		{
			qq=Integer.parseInt(quantxt.getText());
			gt=Double.parseDouble(pricetxt.getText())*Integer.parseInt(quantxt.getText());
			totaltxt.setText(Double.toString(gt));
		}
		

		if(e.getSource()==placeorder)
		{
			oid=Integer.parseInt(ordertxt.getText());
			cd=Integer.parseInt(product.getText());
			pp=Double.parseDouble(pricetxt.getText());
			//nn=proname.getText();
			cn=nametxt.getText();
			
			qq=Integer.parseInt(quantxt.getText());
			add=addresstxt.getText();
			t=Double.parseDouble(totaltxt.getText());
			dd=dchooser.getDate();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
			dobstr=sdf.format(dd);
			String curd=curdate.getText();
			System.out.println(cd+" "+n+" "+cn+""+dobstr+" "+qq+" "+add+" "+t+" "+p+" "+oid);
			
			
			try{
				PreparedStatement pstmt3=con2.prepareStatement("insert into tab values(?,?,?,?,?,?,?,?,?,?,?)");
				pstmt3.setInt(1, oid);
				pstmt3.setInt(2, cd);
				pstmt3.setString(3, n);
				pstmt3.setString(4, cn);
				pstmt3.setInt(5,qq );
				pstmt3.setString(6, add);
				pstmt3.setDouble(7, p);
				pstmt3.setDouble(8, t);
				pstmt3.setString(9, curd);
				pstmt3.setString(10, dobstr);
				pstmt3.setString(11, " ");
				msg=pstmt3.executeUpdate();	
				
				}
			
			catch(SQLException sq)
			{
				JOptionPane.showMessageDialog(null, "SQL Error!");
			}
			if(msg>0)
			{
				JOptionPane.showMessageDialog(null, "Added Successfully!");
				ordertxt.setText(String.valueOf(orderc+2));
				product.setText("");
				proname.setText("");
				nametxt.setText("");
				proname.setText("");
				dchooser.setDate(null);
				addresstxt.setText("");
				pricetxt.setText("");
				quantxt.setText("");
				totaltxt.setText("");
				
			}
		}//end of placeorder button
		
	}


}
