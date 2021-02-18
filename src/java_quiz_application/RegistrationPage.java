package java_quiz_application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RegistrationPage implements ActionListener{
JFrame jf=new JFrame("Registration Page");
	JButton submit,reset;
	JTextField t1,t2;
	JLabel l,l1,l2,l3;
	JComboBox sem;
	
	public String semesters[]= {"1","2","3","4","5","6","7","8"};
	String userName;
	String rollNo;
	public void registration_page()
	{
		jf.setLayout(null);
		jf.setSize(500,500);
		jf.setVisible(true);
		jf.getContentPane().setBackground(Color.ORANGE);
		
		submit=new JButton("Submit");
		submit.setBounds(107, 150, 100, 30);
		reset=new JButton("Reset");
		reset.setBounds(210, 150, 100, 30);
		
		l=new JLabel("Register  For  Quiz");
		l.setBounds(130, 5, 250, 30);
		l.setFont(new Font("Arial Black",Font.BOLD,20));
		
		l1=new JLabel("Name :");
		l1.setBounds(100, 35, 60, 35);
		l1.setFont(new Font("Arial Black",Font.PLAIN,14));
		t1=new JTextField(60);
		t1.setBounds(200, 45, 100, 17);

		l2=new JLabel("Roll No :");
		l2.setBounds(100, 55, 90, 35);
		l2.setFont(new Font("Arial Black",Font.PLAIN,14));
		t2=new JTextField(60);
		t2.setBounds(200, 65, 100, 17);
		
		l3=new JLabel("Semester :");
		l3.setBounds(100, 90, 100, 35);
		l3.setFont(new Font("Arial Black",Font.PLAIN,14));
		sem=new JComboBox(semesters);
		sem.setBounds(200, 95, 50, 20);
		
		
		submit.addActionListener(this);
		reset.addActionListener(this);
		t1.addActionListener(this);
		t2.addActionListener(this);

		jf.add(l);
		jf.add(l1);
		jf.add(t1);
		jf.add(l2);
		jf.add(t2);
		jf.add(l3);
		jf.add(sem);
		jf.add(submit);
		jf.add(reset);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		Quiz q=new Quiz();
		userName=t1.getText();
		rollNo=t2.getText();
	if(e.getSource()==submit)
	{
		q.get_User(userName, rollNo);
        jf.dispose();
		q.start_quiz();
	}
	if(e.getSource()==reset)
	{
		
		t1.setText("");
		t2.setText("");
	}
	}
}
