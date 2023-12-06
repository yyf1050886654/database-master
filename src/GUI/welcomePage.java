package GUI;
 
import menu.dir;
import objects.Customers;
import select.selectReservation_forGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

import javax.swing.*;
 
public class welcomePage extends JFrame implements ActionListener
{
	     //定义组件
		JButton jb1,jb2,jb3,jb4,jb5=null;
		JPanel jp1,jp2,jp3,jp4,jp5,jp6=null;
		JLabel jlb1=null;
		Customers customers;
	    dir dir = new dir();
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Customers customers = new Customers();
			customers.setCustName("杨逸帆");
			customers.setCustID("10000");
			welcomePage welcomePage =new welcomePage(customers);
		}
		
	    //构造函数
		public welcomePage(Customers customers)    //不能申明为void!!!!!否则弹不出新界面
		{

			this.customers = customers;
			//创建组件
			jb1=new JButton("旅程预约");
			jb2=new JButton("查询预约");
			jb3=new JButton("取消预约");
			jb4=new JButton("查询航线");
			jb5=new JButton("退出系统");

			jb1.addActionListener(this);
			jb2.addActionListener(this);
			jb3.addActionListener(this);
			jb4.addActionListener(this);
			jb5.addActionListener(this);



			jp1=new JPanel();
			jp2=new JPanel();
			jp3=new JPanel();
			jp4=new JPanel();
			jp5=new JPanel();
			jp6=new JPanel();


			jlb1=new JLabel(customers.getCustName()+",欢迎您!");

			jp1.add(jlb1);
			jp2.add(jb1);
			jp3.add(jb2);
			jp4.add(jb3);
			jp5.add(jb4);
			jp6.add(jb5);

			this.add(jp1);
			this.add(jp2);
			this.add(jp3);
			this.add(jp4);
			this.add(jp5);
			this.add(jp6);
			
			//设置布局管理器
			this.setLayout(new GridLayout(6,1));
			this.setTitle("旅程管理系统");
			this.setSize(400,300);
			this.setLocation(200, 200);		
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Objects.equals(e.getActionCommand(), "旅程预约"))
		{
			//dir.makeReservationPage();
			dispose();
			new makeReservationPage(customers);
		}else if(Objects.equals(e.getActionCommand(), "查询预约"))
		{
			//dir.queryReservation();
			dispose();
			new queryReservationPage(customers);
		}else if(Objects.equals(e.getActionCommand(), "取消预约"))
		{
			dispose();
			new deleteReservationPage(customers);
			//dir.deleteReservation();
		}else if(Objects.equals(e.getActionCommand(), "查询航线"))
		{
			selectReservation_forGUI selectReservation_forGUI= new selectReservation_forGUI();
			JOptionPane.showMessageDialog(null,selectReservation_forGUI.findFlight(customers)+selectReservation_forGUI.findHotel(customers)+selectReservation_forGUI.findBus(customers));
			//dir.queryLine();
		}else if(Objects.equals(e.getActionCommand(), "退出系统"))
		{
			System.exit(0);
		}

	}

}
