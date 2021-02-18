package java_quiz_application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FirstPage  implements ActionListener {

	JFrame f=new JFrame("Main Page");
	JLabel l1,l2;
	JButton Register;
	
	public void main_page()
	{
		l1=new JLabel("Welcome to Java Quiz Application,");
		l1.setBounds(20, 100, 800, 30);
		l1.setFont(new Font("Arial Black", Font.BOLD, 18));
		f.add(l1);
		
		l2=new JLabel("Register yourself first.");
		l2.setBounds(50, 130, 300, 50);
		l2.setFont(new Font("Arial Black", Font.BOLD, 18));
		f.add(l2);
		
		Register=new JButton("Register");
		Register.setBounds(130, 200, 100, 30);
		f.add(Register);
		
		
		f.setLayout(null);
		f.setSize(400,400);
		f.setVisible(true);
		f.getContentPane().setBackground(Color.ORANGE);
		Register.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		RegistrationPage rp=new RegistrationPage();
		if(e.getSource()==Register)
		{
			f.dispose();
			rp.registration_page();
		}
	}
}
