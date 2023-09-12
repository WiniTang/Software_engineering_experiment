package org.test1;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class JMain {
	private JFrame frame;
	private JTextField jTextField1,jTextField2;
	private JButton[] b;
	private CArray a;
	public JMain() {
		frame=new JFrame();
		a=new CArray();
		frame.setBounds(400,400,600,400);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		Panel panel[]=new Panel[2];
		JLabel pl1=new JLabel("Current Array");//panel0标题
		JLabel pl2=new JLabel("New Array");//panel1标题
		panel[0]=new Panel();
		panel[0].add(pl1);
		panel[1]=new Panel();
		panel[1].add(pl2);
		b=new JButton[9];
		b[0]=new JButton("Sort");
		b[1]=new JButton("Insert");
		b[2]=new JButton("Delete");
		b[3]=new JButton("Reverse");
		b[4]=new JButton("Search");
		b[5]=new JButton("MAX");
		b[6]=new JButton("MIN");
		b[7]=new JButton("SUM");
		b[8]=new JButton("AVERAGE");
		//文本框
		jTextField1=new JTextField(50);//panel1,2用户输入
		jTextField2=new JTextField(50);
		jTextField1.setText(a.array2String(a.getData()));
		jTextField2.setText(a.array2String(a.getData()));
		panel[0].add(pl1);
		panel[0].add(jTextField1);
		panel[1].add(pl2);
		panel[1].add(jTextField2);
		frame.add(panel[0]);
		frame.add(panel[1]);
		for(int i=0;i<9;i++)
		{
			frame.add(b[i]);
		}
		b[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a.sort();
				jTextField2.setText(a.array2String(a.getData()));
			
			}
			
		});
		b[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a.insert(10);
				jTextField2.setText(a.array2String(a.getData()));
		
			}
			
		});
		b[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Dialog delDlg=new Dialog(frame,"Delete",false);
				delDlg.setLayout(new GridLayout(2,1));
				delDlg.setBounds(400,400,100,100);
				delDlg.setVisible(true);
				JTextField tField=new JTextField(5);
				delDlg.add(tField);
				JButton ok=new JButton("OK");
				delDlg.add(ok);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						int l=a.delete(Integer.valueOf(tField.getText()));
						jTextField2.setText(a.array2String(a.getData(),l));
						delDlg.dispose();
					}
				});
			}
			
		});
		b[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a.reverse();
				jTextField2.setText(a.array2String(a.getData()));
			}
		});
		b[4].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Dialog shDlg=new Dialog(frame,"Search",false);
				shDlg.setLayout(new GridLayout(2,1));
				shDlg.setBounds(50,50,100,150);
				shDlg.setVisible(true);
				JTextField tField=new JTextField(5);
				shDlg.add(tField);
				JButton ok=new JButton("OK");
				shDlg.add(ok);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(-1==a.search(Integer.valueOf(tField.getText())))
						{
							JOptionPane.showMessageDialog(ok, "Not Found!","消息提示",JOptionPane.WARNING_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(ok, "Found Successfully!","消息提示",JOptionPane.PLAIN_MESSAGE);
						}
						shDlg.dispose();
					}
					
				});
			}
		});
		b[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Dialog shDlg=new Dialog(frame,"MAX",false);
				shDlg.setLayout(new GridLayout(2,1));
				shDlg.setBounds(200,200,100,150);
				shDlg.setVisible(true);
				JLabel l=new JLabel(String.valueOf(a.getMax()),JLabel.CENTER);
				JButton ok=new JButton("Confirm");
				shDlg.add(l);
				shDlg.add(ok);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						shDlg.dispose();
					}
					
				});
			}
		});
		b[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Dialog shDlg=new Dialog(frame,"MIN",false);
				shDlg.setLayout(new GridLayout(2,1));
				shDlg.setBounds(50,50,100,150);
				shDlg.setVisible(true);
				JLabel l=new JLabel(String.valueOf(a.getMin()),JLabel.CENTER);
				JButton ok=new JButton("Confirm");
				shDlg.add(l);
				shDlg.add(ok);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						shDlg.dispose();
					}
					
				});
			}
		});
		b[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Dialog shDlg=new Dialog(frame,"SUM",false);
				shDlg.setLayout(new GridLayout(2,1));
				shDlg.setBounds(200,200,100,150);
				shDlg.setVisible(true);
				JLabel l=new JLabel(String.valueOf(a.getSum()),JLabel.CENTER);
				JButton ok=new JButton("Confirm");
				shDlg.add(l);
				shDlg.add(ok);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						shDlg.dispose();
					}
					
				});
			}
		});
		b[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Dialog shDlg=new Dialog(frame,"AVERAGE",false);
				shDlg.setLayout(new GridLayout(2,1));
				shDlg.setBounds(200,200,100,150);
				shDlg.setVisible(true);
				JLabel l=new JLabel(String.valueOf(a.getAverage()),JLabel.CENTER);
				JButton ok=new JButton("Confirm");
				shDlg.add(l);
				shDlg.add(ok);
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						shDlg.dispose();
					}
					
				});
				
			}
		});
		frame.setVisible(true);
	}
	
	//get set
	public JFrame getFrame() {
		return frame;
	}




	public void setFrame(JFrame frame) {
		this.frame = frame;
	}




	public JTextField getjTextField1() {
		return jTextField1;
	}




	public void setjTextField1(JTextField jTextField1) {
		this.jTextField1 = jTextField1;
	}




	public JTextField getjTextField2() {
		return jTextField2;
	}




	public void setjTextField2(JTextField jTextField2) {
		this.jTextField2 = jTextField2;
	}




	public JButton[] getB() {
		return b;
	}




	public void setB(JButton[] b) {
		this.b = b;
	}




	public CArray getA() {
		return a;
	}




	public void setA(CArray a) {
		this.a = a;
	}




	public static void main(String[] args)
	{
		JMain f=new JMain();
	}
}
