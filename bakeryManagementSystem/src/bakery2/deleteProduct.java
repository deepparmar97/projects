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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class deleteProduct implements ActionListener{
JFrame myframe;
JButton updatebt,go;
JLabel code,name,price,home,main,back;
JTextField codef,namef,pricef;
Font f;
String n;
int i,cd,pr,y;
Double p;
boolean flag=true;
	
	public void deleteFrame(){
		myframe=new JFrame("RETAIL");
		myframe.setLayout(null);
		myframe.setResizable(false);
		//myframe.setUndecorated(true);
		myframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Point center=GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		int windowWidth=1000;
		int windowHeight=700;
		myframe.setBounds(center.x-windowWidth/2,center.y-windowHeight/2,windowWidth,windowHeight);
		
		myframe.setVisible(true);
		f=new Font("Courier",Font.BOLD,20);
		
		main=new JLabel(new ImageIcon("images/Untitled-2.png"));
		back=new JLabel(new ImageIcon("images/center2.png"));
		code=new JLabel("Product Code");
		name=new JLabel("Product Name");
		price=new JLabel("Price per unit");
		home=new JLabel(new ImageIcon("images/homebt.png"));
		updatebt=new JButton("DELETE");
		codef=new JTextField();
		namef=new JTextField();
		go=new JButton("Go");
		pricef=new JTextField();
		
		code.setFont(f);		codef.setFont(f);   
		name.setFont(f);	namef.setFont(f);
		price.setFont(f);	pricef.setFont(f);
		go.setFont(f);		updatebt.setFont(f);
		
		code.setForeground(Color.WHITE);
		name.setForeground(Color.WHITE);
		price.setForeground(Color.WHITE);
		
		back.setBounds(0,0,1000,700);
		main.setBounds(400, 20, 200, 200);
		go.setBounds(700, 250, 80, 30);	home.setBounds(700, 50, 100, 100);
		code.setBounds(150, 250, 200, 30);		codef.setBounds(400, 250, 250, 30);
		name.setBounds(150, 350, 200, 30);		namef.setBounds(400, 350, 250, 30);
		price.setBounds(150, 450, 200, 30);       pricef.setBounds(400, 450, 250, 30);		
		updatebt.setBounds(400, 550, 200, 40);
		
		myframe.add(main);
		myframe.add(go);	//myframe.add(home);
		myframe.add(code);	myframe.add(codef);
		myframe.add(name); myframe.add(namef);
		myframe.add(price);	myframe.add(pricef);
		myframe.add(updatebt);
		myframe.add(back);
		
		//home.addMouseListener(this);
		updatebt.addActionListener(this);
		go.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Connection con2=DBconnection.getConnection();
		cd=Integer.parseInt(codef.getText());
		if(e.getSource()==go)
		{
			try
			{
				PreparedStatement pstmt2=con2.prepareStatement("Select * from addproduct where code=?");
				pstmt2.setInt(1, cd);
				ResultSet rs2=pstmt2.executeQuery();
				if(rs2.next())
				{
					n=rs2.getString("name");
					namef.setText(n);
					pr=rs2.getInt("price");
 					pricef.setText(Integer.toString(pr));
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
			flag=false;
		}//end of go
			if(e.getSource()==updatebt)
			{
				flag=true;
				cd=Integer.parseInt(codef.getText());
				try{
					PreparedStatement pstmt=con2.prepareStatement("Delete From addproduct where code=?");
					pstmt.setInt(1, cd);
					 y=pstmt.executeUpdate();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "SQL Error 1");
				}
				flag=false;
			}
			if(y>0)
			{
				JOptionPane.showMessageDialog(null, "Deleted Successfully!");
				codef.setText("");
				namef.setText("");
				pricef.setText("");
			}
	}
}
