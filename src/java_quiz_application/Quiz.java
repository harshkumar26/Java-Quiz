package java_quiz_application;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class Quiz implements ActionListener{
	JLabel l1;
	JRadioButton r1,r2,r3,r4;
	JButton submit,start,next;
	JTextArea t1;
	ButtonGroup bg;
	int count=0;
	static int ansCount=0;
	static int answered=0;
	static int correct=0;
	public String userAns[]=new String[10];
	String userName;
	String rollNo;
	
	
	public void get_User(String name,String roll)
	{
		userName=name;
		rollNo=roll;
	}
	
  public void start_quiz()
  {
	  JFrame jf=new JFrame("Welcome  "+userName+"  RollNo.  "+rollNo);
		jf.setLayout(new FlowLayout());
	  jf.setVisible(true);
		jf.setSize(650,650);
	  jf.getContentPane().setBackground(Color.ORANGE);
		
	  l1=new JLabel("JAVA QUIZ");
	  l1.setFont(new Font("Arial Black",Font.BOLD,15));
		l1.getHorizontalAlignment();
		
		Image st,nxt,sub;
		try {
			st = ImageIO.read(new File("icon\\start.jpg")).getScaledInstance(100,25,Image.SCALE_DEFAULT);
			start=new JButton(new ImageIcon(st));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    start.setPreferredSize(new Dimension(100,25));
	    
	    try {
			nxt= ImageIO.read(new File("icon\\next.jpg")).getScaledInstance(100,25,Image.SCALE_DEFAULT);
			next=new JButton(new ImageIcon(nxt));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    next.setPreferredSize(new Dimension(100,37));
	    next.setEnabled(false);
		
	    try {
			sub= ImageIO.read(new File("icon\\submit.jpg")).getScaledInstance(100,25,Image.SCALE_SMOOTH);
			 submit=new JButton(new ImageIcon(sub));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    submit.setPreferredSize(new Dimension(100,37));
		submit.setEnabled(false);
		
		r1=new JRadioButton("a");
		r1.setActionCommand("A");
		
		r2=new JRadioButton("b");
		r2.setActionCommand("B");
		
		r3=new JRadioButton("c");
		r3.setActionCommand("C");
		
		r4=new JRadioButton("d");
		r4.setActionCommand("D");
		bg=new ButtonGroup();
		disableRadio();
		
		t1=new JTextArea(20,50);
		t1.setLocation(200, 100);
		t1.setEditable(false);
		t1.setText("PRESS START TO BEGIN");
		t1.append("\n\n\n\nJAVA QUIZ BY \n Harsh Kumar\n 1810992024");
	     t1.setFont(new Font("Times New Roman",Font.PLAIN,15));
	    
		submit.addActionListener(this);
		start.addActionListener(this);
		next.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		
		Panel p1=new Panel();
		p1.add(l1);
		Panel p2=new Panel();
		p2.add(t1);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, p1, p2);
		jf.add(splitPane);
		Panel p3=new Panel();
		bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);
		p3.add(r1);p3.add(r2);p3.add(r3);p3.add(r4);
		Panel p4=new Panel();
		p4.add(start);
		p4.add(next);
		p4.add(submit);
		JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, p3, p4);
		jf.add(splitPane1);
		

  }
	
  public void disableRadio()
  {
  	r1.setEnabled(false);
  	r2.setEnabled(false);
  	r3.setEnabled(false);
  	r4.setEnabled(false);
  	
  }

  public void compare_ans()
  {
  	Quess q2=new Quess();
  	for(int i=0;i<ansCount;i++)
  	{
  		int j=i+1;
  		if(userAns[i]==q2.crctAns[i])
  		{
  			t1.append(j+")"+userAns[i]+"\tCORRECT"+"\n");
  			correct++;
  		}
  		else
  		{
  			t1.append(j+")"+userAns[i]+"\tWRONG"+"\t\t CORRECT ANS:"+q2.crctAns[i]+"\n");
  		}
  	}
  }
  
  public void actionPerformed(ActionEvent e)
  {
  	Quess q1=new Quess();
  	try
  	{
  		if(e.getSource()==start)
  		{
  			start.setEnabled(false);
  			next.setEnabled(true);
  			submit.setEnabled(true);
  			
  			r1.setEnabled(true);
  			r2.setEnabled(true);
  			r3.setEnabled(true);
  			r4.setEnabled(true);
  			
  			t1.setText(q1.getQuess(count));
  			count++;
  			
  		}
  		else if(e.getSource()==next)
  		{
  			try
  			{
  			userAns[ansCount]=bg.getSelection().getActionCommand();
  			
  			}
  			catch(Exception er)
  			{
  				userAns[ansCount]="Not Answered";
  			}
  			bg.clearSelection();
  			t1.setText(q1.getQuess(count));
  			if(userAns[ansCount]!="Not Answered")
  			{
  				answered++;
  			}
  			ansCount++;
  		    count++;   
  		}
  		else if(e.getSource()==submit)
  		{
  			try
  			{
  			userAns[ansCount]=bg.getSelection().getActionCommand();
  			
  			}
  			catch(Exception er)
  			{
  				userAns[ansCount]="Not Answered";
  			}
  			if(userAns[ansCount]!="Not Answered")
  			{
  				answered++;
  			}
  			ansCount++;
  			bg.clearSelection();
  			next.setEnabled(false);
  			disableRadio();
  			
  			t1.setText("\n\n\n\n------QUIZ OVER----- \n You have answered "+answered+" questions out of 10");
  		       t1.append("\nYour answers are:\n");
  		       compare_ans();  
  		       t1.append("\n\n---------RESULT :"+correct+"/"+10+"----------");
  		 }
  				
  	}
  	catch(Exception ex)
  	{
  		bg.clearSelection();
  		disableRadio();
  		t1.setText("NO MORE QUESTIONS \n PRESS SUBMIT TO SUBMIT THE PAPER");
  		System.err.println(ex);
  	}
  }


	
	public static void main(String h[])
	{
		FirstPage mp=new FirstPage();
		mp.main_page();
				
	}

}
