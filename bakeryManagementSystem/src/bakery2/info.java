package bakery2;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DragUndecoratedJFrame.RavDragUndecoratedJFrame;

public class info implements MouseListener {
	JFrame myframe;
	JLabel min,close,back,main,product,raw,order,income,readymade,bill,confirm,remorder;
	JButton bt;
	Point mouseDownCompCoords;
	JPanel cp;
	
	
	public void frameInfo(){
		myframe=new JFrame("Info");
		//myframe.setResizable(false);
		myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 cp=new JPanel();
	
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=1000;
		int windowHeight=720;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		
		RavDragUndecoratedJFrame m=new RavDragUndecoratedJFrame(cp,myframe);
		
		min=new JLabel(new ImageIcon("images/minimize_03.png"));
		close=new JLabel(new ImageIcon("images/close_03.png"));
		main=new JLabel(new ImageIcon("images/Untitled-2.png"));
		product=new JLabel(new ImageIcon("images/mproh.png"));
		raw=new JLabel(new ImageIcon("images/ORDER_03.png"));
		order=new JLabel(new ImageIcon("images/orderh.png"));
		income=new JLabel(new ImageIcon("images/income.png"));
		readymade=new JLabel(new ImageIcon("images/pcode.png"));
		bill=new JLabel(new ImageIcon("images/bill.png"));
		confirm=new JLabel(new ImageIcon("images/confirm.png"));
		remorder=new JLabel(new ImageIcon("images/remorderh.png"));
		back=new JLabel(new ImageIcon("images/center2.png"));
		//back.setBackground(Color.WHITE);
		
		cp.setLayout(null);
		 
		back.setBounds(0, 0,1000, 700);
		min.setBounds(900, 10, 24,23);
		close.setBounds(950, 10, 24,23);
		main.setBounds(400, 20, 200, 200);
		product.setBounds(125, 300, 350, 50);     income.setBounds(530, 300, 350, 50);         
 		raw.setBounds(125, 400, 350, 50);			  readymade.setBounds(530, 400, 350, 50);
		order.setBounds(125, 500, 350, 50);		  bill.setBounds(530, 500, 350, 50);
		confirm.setBounds(125, 600, 350, 50);	  remorder.setBounds(530, 600, 350, 50);
		
		myframe.add(cp);
		cp.add(close);
		cp.add(min);
		cp.add(main);
		cp.add(product);
		cp.add(raw);
		cp.add(order);
		cp.add(income);
		cp.add(readymade);
		cp.add(bill);
		cp.add(confirm);
		cp.add(remorder);
		cp.add(back);
		
		cp.addMouseListener(m);
		cp.addMouseMotionListener(m);
		min.addMouseListener(this);
		close.addMouseListener(this);
		product.addMouseListener(this);
		raw.addMouseListener(this);
		order.addMouseListener(this);
		income.addMouseListener(this);
		readymade.addMouseListener(this);
		bill.addMouseListener(this);
		confirm.addMouseListener(this);
		remorder.addMouseListener(this);
		myframe.setVisible(true);
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==product)
		{
			myframe.dispose();
			infoProduct pro=new infoProduct();
			pro.productInfo();
		}
		if(e.getSource()==raw)
		{
			myframe.dispose();
			PlaceOrder ra=new PlaceOrder();
			ra.rawFrame();
		}
		if(e.getSource()==order)
		{
			myframe.dispose();
			vieworder ord=new vieworder();
			ord.orderFrame();
		}
		if(e.getSource()==income)
		{
			income inc=new income();
			inc.incomeFrame();
		}
		if(e.getSource()==readymade)
		{
			viewPCode rem=new viewPCode();
			rem.codeFrame();
		}
		if(e.getSource()==bill)
		{
			//myframe.dispose();
			bill bil=new bill();
			bil.billFrame();
		}
		if(e.getSource()==close)
		{
			System.exit(0);
		}
		if(e.getSource()==min)
		{
			
			myframe.setState(JFrame.ICONIFIED);
		}
		if(e.getSource()==confirm)
		{
			myframe.dispose();
			confirmDelievery pro=new confirmDelievery();
			pro.delieveryInfo();
		}
		if(e.getSource()==remorder)
		{
			myframe.dispose();
			calculateIncome pro=new calculateIncome();
			pro.incomeFrame();
		}
	}
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==product)
		{
			product.setIcon(new ImageIcon("images/mpro.png"));
		}
		if(e.getSource()==raw)
		{
			raw.setIcon(new ImageIcon("images/ORDER3_03.png"));
		}
		if(e.getSource()==order)
		{
			order.setIcon(new ImageIcon("images/order.png"));
		}
		if(e.getSource()==income)
		{
			income.setIcon(new ImageIcon("images/incomeh.png"));
		}
		if(e.getSource()==readymade)
		{
			readymade.setIcon(new ImageIcon("images/pcodeh.png"));
		}
		if(e.getSource()==bill)
		{
			bill.setIcon(new ImageIcon("images/billh.png"));
		}
		if(e.getSource()==confirm)
		{
			confirm.setIcon(new ImageIcon("images/confirmh.png"));
		}
		if(e.getSource()==remorder)
		{
			remorder.setIcon(new ImageIcon("images/remorderh.png"));
		}
		}
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==product)
		{
			product.setIcon(new ImageIcon("images/mproh.png"));
		}
		if(e.getSource()==raw)
		{
			raw.setIcon(new ImageIcon("images/ORDER_03.png"));
		}
		if(e.getSource()==order)
		{
			order.setIcon(new ImageIcon("images/orderh.png"));
		}
		
		if(e.getSource()==income)
		{
			income.setIcon(new ImageIcon("images/income.png"));
		}
		if(e.getSource()==readymade)
		{
			readymade.setIcon(new ImageIcon("images/pcode.png"));
		}
		if(e.getSource()==bill)
		{
			bill.setIcon(new ImageIcon("images/bill.png"));
		}
		if(e.getSource()==confirm)
		{
			confirm.setIcon(new ImageIcon("images/confirm.png"));
		}
		if(e.getSource()==remorder)
		{
			remorder.setIcon(new ImageIcon("images/remorder.png"));
		}
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
