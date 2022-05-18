package bakery2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class bill implements ActionListener,Printable {
JFrame myframe;
JLabel orderid,pname,price,cname,quantity,ddate,address,confirmlb;
JLabel orderidtxt,pricetxt,cnametxt,pnametxt,quantitytxt,ddatetxt,addresstxt,confirmtxt;
JLabel total,totaltxt,back,main;
Component comp;
String n,cn,dd,add,cm;
int pid,p,t,q,id;
JButton bt,printbt;
Font f;
Font flb;
	
	public void billFrame(){
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
		
		bt=new JButton("VIEW");
		printbt=new JButton("PRINT");
		confirmlb=new JLabel("Delivery Confirmation");
		confirmtxt=new JLabel();
		orderid=new JLabel("Order ID");
		orderidtxt=new JLabel();
		pname=new JLabel();
		cname=new JLabel();
		quantity=new JLabel();
		price=new JLabel();
		total=new JLabel();
		address=new JLabel();
		ddate=new JLabel();
		pnametxt=new JLabel("Product   :");
		cnametxt=new JLabel("Customer Name    :");
		quantitytxt=new JLabel("Quantity");
		pricetxt=new JLabel("Price Per Piece");
		totaltxt=new JLabel("Total Amount");
		addresstxt=new JLabel("Address");
		ddatetxt=new JLabel("Delivery Date");
		back=new JLabel();
		main=new JLabel(new ImageIcon("images/Untitled-2.png"));
		back.setBackground(Color.WHITE);			
		
		back.setBounds(0,0,900,700);
		main.setBounds(300, 0, 300, 200);
		bt.setBounds(650,0,150,40);
		orderid.setBounds(150,170,200,40);	orderidtxt.setBounds(450,170,200,40);	
		pnametxt.setBounds(150,220,200,40);pname.setBounds(450,220,300,40);
		cnametxt.setBounds(150,270,200,40);cname.setBounds(450,270,200,40);
		pricetxt.setBounds(150,320,200,40);price.setBounds(450,320,200,40);
		quantitytxt.setBounds(150,370,200,40);quantity.setBounds(450,370,200,40);
		totaltxt.setBounds(150,420,200,40);total.setBounds(450,420,200,40);
		ddatetxt.setBounds(150,470,200,40);ddate.setBounds(450,470,200,40);
		addresstxt.setBounds(150,520,200,50);address.setBounds(450,520,200,50);
		confirmlb.setBounds(150,570,200,50);confirmtxt.setBounds(450,570,200,50);
		printbt.setBounds(450,640,100,40);
		
		//set Font
		f=new Font("Ubuntu",Font.PLAIN,18);
		flb=new Font("Courier",Font.BOLD,18);
		pname.setFont(flb);		pnametxt.setFont(f);
		cname.setFont(flb);		cnametxt.setFont(f);
		price.setFont(flb);		pricetxt.setFont(f);
		quantity.setFont(flb);		quantitytxt.setFont(f);
		total.setFont(flb);		totaltxt.setFont(f);
		ddate.setFont(flb);		ddatetxt.setFont(f);
		address.setFont(flb);		addresstxt.setFont(f);
		bt.setFont(f);	orderid.setFont(f); orderidtxt.setFont(f);
		confirmlb.setFont(f);	confirmtxt.setFont(flb);
		printbt.setFont(flb);
		
		
		
		myframe.add(orderid);
		myframe.add(confirmlb);
		myframe.add(confirmtxt);
		myframe.add(orderidtxt);
		myframe.add(bt);
		myframe.add(printbt);
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
		myframe.add(main);
		myframe.add(back);
		
		
		bt.addActionListener(this);
		printbt.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==printbt){
			printbt.setVisible(false);
			
			
		PrinterJob job = PrinterJob.getPrinterJob();
	    job.setPrintable(this);
	    boolean ok = job.printDialog();
	    if (ok) {
	      try {
	        job.print();
	      } catch (PrinterException ex) {
	        /* The job did not successfully complete */
	      }
	    }
	    myframe.dispose();
		}
		
		
		
		
		Connection con=DBconnection.getConnection();
		if(e.getSource()==bt)
			
		{
		try
		{
			PreparedStatement pstmt=con.prepareStatement("Select * from tab ");
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.last())
			{
				dd=rs.getString("Deliverydate");
				ddate.setText(dd);
				id=rs.getInt("orderid");
				orderidtxt.setText(String.valueOf(id));
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
				cm=rs.getString("confirm");
				confirmtxt.setText(cm);
				System.out.print(p);
			}
			bt.setVisible(false);
		}
		catch(SQLException se)
		{
			JOptionPane.showMessageDialog(null, "SQL Error 1");
		}
		
	}

	}

	@Override
	public int print(Graphics g, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		
		if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        // get the bounds of the component
        Dimension dim = myframe.getSize();
        double cHeight = dim.getHeight();
        double cWidth = dim.getWidth();

        // get the bounds of the printable area
        double pHeight = pageFormat.getImageableHeight();
        double pWidth = pageFormat.getImageableWidth();

        double pXStart = pageFormat.getImageableX();
        double pYStart = pageFormat.getImageableY();

        double xRatio = pWidth / cWidth;
        double yRatio = pHeight / cHeight;


        Graphics2D g2 = (Graphics2D) g;
        g2.translate(pXStart, pYStart);
        g2.scale(xRatio, yRatio);
        myframe.paint(g2);

        return Printable.PAGE_EXISTS;
    }
	}

