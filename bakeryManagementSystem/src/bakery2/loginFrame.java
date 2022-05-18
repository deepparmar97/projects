package bakery2;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DragUndecoratedJFrame.RavDragUndecoratedJFrame;

public class loginFrame implements MouseListener{
	JFrame frame;
	JLabel backlab,loginlb1,ulab,plab,exit,register;
	JTextField usertxt;
	JPasswordField passtxt;
	Font f;
	String n,pwd;
	char p[];
	
	public void Login(){
		frame=new JFrame();
		JPanel cp=new JPanel();
		Point p=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int winwidth=400;
		int winheight=450;
		frame.setBounds(p.x-winwidth/2,p.y-winheight/2,winwidth,winheight);
		 RavDragUndecoratedJFrame m=new RavDragUndecoratedJFrame(cp,frame);
		
		backlab=new JLabel(new ImageIcon("images/witoutreg.png"));
		loginlb1=new JLabel(new ImageIcon("images/login.png"));
		
		exit=new JLabel(new ImageIcon("images/close-button_3.png"));
		ulab=new JLabel(new ImageIcon("images/ico-unknown1.png"));
		plab=new JLabel(new ImageIcon("images/pass.png"));
		usertxt=new JTextField();
		
		passtxt=new JPasswordField(10);
		frame.setUndecorated(true);
		cp.setLayout(null);
		
		
		f=new Font("SANS_SERIF",Font.PLAIN,24);
		
		usertxt.setFont(f);
		passtxt.setFont(f);
		backlab.setBounds(0,0,400,450);
		
		exit.setBounds(350,3,50,50);
		ulab.setBounds(50, 120, 50, 50);
		plab.setBounds(50, 220, 50, 50);
		usertxt.setBounds(100,120,250,50);
		passtxt.setBounds(100,220,250,50);
		loginlb1.setBounds(75,375,250,50);
		
		frame.add(cp);
		cp.add(loginlb1);
		
		cp.add(exit);
		cp.add(usertxt);
		cp.add(passtxt);
		cp.add(ulab);
		cp.add(plab);
		cp.add(backlab);
		
		cp.addMouseListener(m);
		cp.addMouseMotionListener(m);
		loginlb1.addMouseListener(this);
		exit.addMouseListener(this);
		
		frame.setVisible(true);
		
		
		
	}
	@Override

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		n=usertxt.getText();
		p=passtxt.getPassword();
		pwd=null;
        pwd=String.copyValueOf(p);
		if(e.getSource()==loginlb1){
			
		Connection con=DBconnection.getConnection();
		try{
			PreparedStatement pstmt=con.prepareStatement("Select * from login where user=? and pass=?");
            pstmt.setString(1, n);
            pstmt.setString(2, pwd);
			ResultSet rst=pstmt.executeQuery();
			if(rst.next()){
					frame.dispose();
					info in=new info();
					in.frameInfo();		
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid Username & Password");
			}
			
		
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "SQL Error!");
		}
		}
		
		if(e.getSource()==exit)
			System.exit(0);
	}//end of exit button
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginlb1)
		{
			loginlb1.setIcon(new ImageIcon("images/loginh.png"));
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginlb1)
		{
			loginlb1.setIcon(new ImageIcon("images/login.png"));
		}
		
	}
}
