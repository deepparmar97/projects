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




public class infoProduct implements MouseListener {
	JFrame myframe;
	JLabel min,close,back,main,addproduct,updatepro,deletepro;
	JButton bt;
	Point mouseDownCompCoords;
	JPanel cp;
	
	
	public void productInfo(){
		myframe=new JFrame("Info");
		//myframe.setResizable(false);
		myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 cp=new JPanel();
	
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=1000;
		int windowHeight=700;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		
		RavDragUndecoratedJFrame m=new RavDragUndecoratedJFrame(cp,myframe);
		
		min=new JLabel(new ImageIcon("images/minimize_03.png"));
		close=new JLabel(new ImageIcon("images/close_03.png"));
		main=new JLabel(new ImageIcon("images/Untitled-2.png"));
		addproduct=new JLabel(new ImageIcon("images/product.png"));
		deletepro=new JLabel(new ImageIcon("images/delpro.png"));
		updatepro=new JLabel(new ImageIcon("images/uppro.png"));
		back=new JLabel(new ImageIcon("images/center2.png"));
		
		cp.setLayout(null);
		 
		back.setBounds(0, 0,1000, 700);
		min.setBounds(900, 10, 24,23);
		close.setBounds(950,10, 24,23);
		main.setBounds(400, 20, 200, 200);
		addproduct.setBounds(325, 300, 350, 50);              
		updatepro.setBounds(325, 400, 350, 50);
		deletepro.setBounds(325, 500, 350, 50);
		
		myframe.add(cp);
		cp.add(close);
		cp.add(min);
		cp.add(main);
		cp.add(addproduct);
		cp.add(updatepro);
		cp.add(deletepro);
		cp.add(back);
		
		cp.addMouseListener(m);
		cp.addMouseMotionListener(m);
		min.addMouseListener(this);
		close.addMouseListener(this);
		addproduct.addMouseListener(this);
		updatepro.addMouseListener(this);
		deletepro.addMouseListener(this);
		
		myframe.setVisible(true);
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addproduct)
		{
			myframe.dispose();
			product pro=new product();
			pro.productFrame();
		}
		if(e.getSource()==updatepro)
		{
			updateProduct ret=new updateProduct();
			ret.retailFrame();
		}
		if(e.getSource()==deletepro)
		{
			myframe.dispose();
			deleteProduct del=new deleteProduct();
			del.deleteFrame();
		}
		if(e.getSource()==close)
		{
			myframe.dispose();
			
		}
		if(e.getSource()==min)
		{
			myframe.setState(JFrame.ICONIFIED);
			}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addproduct)
		{
			addproduct.setIcon(new ImageIcon("images/producth.png"));
		}
		if(e.getSource()==updatepro)
		{
			updatepro.setIcon(new ImageIcon("images/huppro.png"));
		}
		if(e.getSource()==deletepro)
		{
			deletepro.setIcon(new ImageIcon("images/hdelpro.png"));
		}
		}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addproduct)
		{
			addproduct.setIcon(new ImageIcon("images/product.png"));
		}
		
		if(e.getSource()==updatepro)
		{
			updatepro.setIcon(new ImageIcon("images/uppro.png"));
		}
		if(e.getSource()==deletepro)
		{
			deletepro.setIcon(new ImageIcon("images/delpro.png"));
		}
}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}}
