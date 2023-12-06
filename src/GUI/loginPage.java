package GUI;
import insert.*;
import objects.Customers;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class loginPage extends JFrame implements ActionListener {

    //定义组件
    JButton jb1,jb2=null;
    JRadioButton jrb1,jrb2=null;
    JPanel jp1,jp2,jp3,jp4=null;
    JTextField jtf=null;
    JLabel jlb1,jlb2,jlb3=null;
    JPasswordField jpf=null;
    ButtonGroup bg=null;
    Customers customers = new Customers();
    //设定用户名和密码
    final String admin_name="admin";
    final String admin_ID="99999";

    public static void main(String[] args) {
        loginPage ms=new loginPage();
    }
    public loginPage()
    {
        //创建组件
        jb1=new JButton("登录");
        jb2=new JButton("注册");
        //设置监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        jrb1=new JRadioButton("管理员");
        jrb2=new JRadioButton("会员");
        bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        jrb2.setSelected(true);

        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();

        jlb1=new JLabel("用户名：");
        jlb2=new JLabel("编    号：");
        jlb3=new JLabel("权    限：");

        jtf=new JTextField(10);
        jpf=new JPasswordField(10);
        //加入到JPanel中
        jp1.add(jlb1);
        jp1.add(jtf);

        jp2.add(jlb2);
        jp2.add(jpf);

        jp3.add(jlb3);
        jp3.add(jrb1);
        jp3.add(jrb2);

        jp4.add(jb1);
        jp4.add(jb2);

        //加入JFrame中
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        //设置布局管理器
        this.setLayout(new GridLayout(4,1));
        //给窗口设置标题
        this.setTitle("旅程管理系统");
        //设置窗体大小
        this.setSize(300,200);
        //设置窗体初始位置
        this.setLocation(200, 150);
        //设置当关闭窗口时，保证JVM也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示窗体
        this.setVisible(true);
        this.setResizable(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        customers.setCustName(jtf.getText());
        customers.setCustID(jpf.getText());
        if(Objects.equals(e.getActionCommand(), "登录"))
        {
            if(jrb1.isSelected())
            {

                adminLogin();
            }else if(jrb2.isSelected())
            {
                custLogin();
            }

        }else if(Objects.equals(e.getActionCommand(), "注册"))
        {
            System.out.println(customers.getCustID()+"   "+customers.getCustName());
            register();
        }

    }
    public void register(){
        if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }
        else if(new insertCustomer().register(customers.getCustID(),customers.getCustName())&&!jtf.getText().isEmpty()&&!jpf.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"注册成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            clear();
        }
        else {
            JOptionPane.showMessageDialog(null,"用户已经存在！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            //清空输入框
            clear();
        }
    }
    public void custLogin()
    {
        //System.out.println(new insertCustomer().login(customers));
        if(new insertCustomer().login(customers))
        {
//			System.out.println("登录成功");
            JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            clear();
            dispose();
            welcomePage welcomePage = new welcomePage(customers);
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            //清空输入框
            clear();
        }
    }

    public void adminLogin()
    {
        if(admin_name.equals(jtf.getText())&&admin_ID.equals(jpf.getText()))
        {
//			System.out.println("登录成功");
            JOptionPane.showMessageDialog(null,"管理员登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            clear();
            dispose();
            new adminPage();
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else if(jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
            //清空输入框
            clear();
        }
    }
    //清空文本框和密码框
    public	void clear()
    {
        jtf.setText("");
        jpf.setText("");
    }

}
