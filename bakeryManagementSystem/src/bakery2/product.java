package bakery2;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class product  implements MouseListener,ActionListener {
	JFrame myframe;
	JButton add;
	JLabel code,name,price,home,back,bake;
	JTextField codef,namef,pricef;
	Font f;
	String n;
	int i,c,p,y;
	boolean flag=true;
	public void productFrame(){
		myframe=new JFrame("Add Products");
		myframe.setLayout(null);
		//myframe.setResizable(true);
		//myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=1000;
		int windowHeight=700;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		myframe.setVisible(true);
		
		f=new Font("Courier",Font.BOLD,18);
		code=new JLabel("Product Code");
		name=new JLabel("Product Name");
		
		bake=new JLabel(new ImageIcon("images/Untitled-2.png"));
		back=new JLabel(new ImageIcon("images/center2.png"));
		price=new JLabel("Price per unit");
		home=new JLabel(new ImageIcon("images/homebt.png"));
		add=new JButton("ADD");
		codef=new JTextField();
		namef=new JTextField();
		
		pricef=new JTextField();
		
		price.setForeground(Color.WHITE);
		code.setForeground(Color.WHITE);
		name.setForeground(Color.WHITE);
		
		code.setFont(f);		codef.setFont(f);   
		name.setFont(f);	namef.setFont(f);
		price.setFont(f);	pricef.setFont(f);
		add.setFont(f);
		
		bake.setBounds(400, 20, 200, 200);
		home.setBounds(600, 50, 100, 100);   back.setBounds(0,0,1000,720);
		code.setBounds(100, 250, 200, 30);		codef.setBounds(400, 250, 250, 30);
		name.setBounds(100, 350, 200, 30);		namef.setBounds(400, 350, 250, 30);
		price.setBounds(100, 450, 200, 30);       pricef.setBounds(400, 450, 250, 30);		
		add.setBounds(400, 550, 200, 30);
		
		myframe.add(home);   
		myframe.add(bake);
		myframe.add(code);	myframe.add(codef);
		myframe.add(name); myframe.add(namef);
		myframe.add(price);	myframe.add(pricef);
		myframe.add(add);
		myframe.add(back);
		
		home.addMouseListener(this);
		add.addActionListener(this);
		Connection con=DBconnection.getConnection();
		try{
			PreparedStatement pstmt=con.prepareStatement("Select * from addproduct");
			ResultSet rs=pstmt.executeQuery();
			if(rs.last()){
				c=rs.getInt("code");
				codef.setText(String.valueOf(c+1));
			}
		}
		catch(Exception e)
		{
			
		}
	}//end of product frame
	
	public void mouseClicked(MouseEvent e){
		if(e.getSource()==home)
		{
			myframe.dispose();
			infoProduct in=new infoProduct();
			in.productInfo();
		}
		
		
	}

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
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		n=namef.getText();
		Connection con2=DBconnection.getConnection();
		if(e.getSource()==add)
		{
			if(codef.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter Product Code.....");
				flag=false;
			}
			else
			{
				flag=true;
				try
				{
					c=Integer.parseInt(codef.getText());
				}
				catch(NumberFormatException ne)
				{
					JOptionPane.showMessageDialog(null,"Code Must Numeric....");
					flag=false;
				}
				
			}
			if(flag==true)
			{
				if(n.trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Product Name Required");
					flag=false;
				}
				else
				{
					flag=true;
				}
			}
			
			
			if(flag==true)
			{
				if(pricef.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter Product Price");
					flag=false;
				}
				else
				{
					flag=true;
					try
					{
					p=Integer.parseInt(pricef.getText());
					}
					catch(NumberFormatException ne)
					{
						JOptionPane.showMessageDialog(null,"Price Must Numeric....");
						flag=false;
					}
				
				}
			}
			if(flag==true)
			{
				try
				{
					PreparedStatement pstmt2=con2.prepareStatement("insert into addproduct values(?,?,?)");
					pstmt2.setInt(1,c);
					pstmt2.setString(2,n);
					pstmt2.setDouble(3,p);
					y=pstmt2.executeUpdate();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "SQL Query Error");
				
				}
			}
			
			if(flag==true)
			{
				if(y>0)
				{
					JOptionPane.showMessageDialog(null, "Added Successfully!");
					codef.setText(String.valueOf(c+1));
					namef.setText("");
					pricef.setText("");
			
				}
				else
				{
					JOptionPane.showMessageDialog(null, " After SQL Error");
				}
			}
		
	}
	}}
	


