package GUI;

import insert.insertReservation;
import objects.*;
import select.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class makeReservationPage extends JFrame implements ActionListener{
    private JScrollPane scpDemo;
    private JTableHeader jth;
    private JTable tabDemo;
    private JButton btnShow,btnShow1,btnShow2;
    private JButton jb1,jb2,jb3,jb4=null;
    Customers customers;

    public makeReservationPage(Customers customers) {
        super("旅程预约菜单");        //JFrame的标题名称
        this.customers = customers;
        //创建组件
        jb1=new JButton("航班预约");
        jb2=new JButton("酒店预约");
        jb3=new JButton("大巴预约");
        jb4=new JButton("返回上一级菜单");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);


        this.setSize(800, 600);        //控制窗体大小
        this.setLayout(null);        //自定义布局
        this.setLocation(400, 100);    //点击运行以后，窗体在屏幕的位置
        this.scpDemo = new JScrollPane();
        this.btnShow = new JButton("显示航班数据");
        this.btnShow1 = new JButton("显示酒店数据");
        this.btnShow2 = new JButton("显示大巴数据");

        this.scpDemo.setBounds(180, 50, 580, 500);    //设置滚动框大小
        this.btnShow.setBounds(180, 10, 120, 30);    //设置按钮
        this.btnShow1.setBounds(360, 10, 120, 30);    //设置按钮
        this.btnShow2.setBounds(540, 10, 120, 30);    //设置按钮

        this.jb1.setBounds(10,100,150,30);
        this.jb2.setBounds(10,150,150,30);
        this.jb3.setBounds(10,200,150,30);
        this.jb4.setBounds(10,250,150,30);


        this.btnShow.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                btnShow_ActionPerformed(ae);
            }
        });
        this.btnShow1.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                btnShow1_ActionPerformed(ae);
            }
        });
        this.btnShow2.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                btnShow2_ActionPerformed(ae);
            }
        });

        this.jb1.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
               jb1_ActionPerformed(ae);
            }
        });
        this.jb2.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                jb2_ActionPerformed(ae);

            }
        });
        this.jb3.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                jb3_ActionPerformed(ae);
            }
        });
        this.jb4.addActionListener(new ActionListener()    //给“显示数据”按钮添加事件响应。
        {
            public void actionPerformed(ActionEvent ae) {
                dispose();
                new welcomePage(customers);
            }
        });

        /******* 将组件加入到窗体中******/

        add(this.scpDemo);
        add(this.btnShow);
        add(this.btnShow1);
        add(this.btnShow2);

        add(this.jb1);
        add(this.jb2);
        add(this.jb3);
        add(this.jb4);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Customers customers = new Customers();
        customers.setCustName("杨逸帆");
        customers.setCustID("10000");
        new makeReservationPage(customers);
    }

    /***连接数据库并显示到表格中***/
    public void btnShow_ActionPerformed(ActionEvent ae) {
        List<Flights> flightsList = new selectFlights().findAll();
        Object[][] info = new Object[flightsList.size()][6];
        String[] title = {"航班序号", "价格", " 座位数量", "座位余量", "出发城市", "到达城市"};
        for (int i=0;i<flightsList.size();i++){
            info[i][0] = flightsList.get(i).getFlightNum();
            info[i][1] = flightsList.get(i).getPrice();
            info[i][2] = flightsList.get(i).getNumSeats();
            info[i][3] = flightsList.get(i).getNumAvail();
            info[i][4] = flightsList.get(i).getFromCity();
            info[i][5] = flightsList.get(i).getAricCity();
        }
        // 创建JTable
        this.tabDemo = new JTable(info, title);
        // 显示表头
        this.jth = this.tabDemo.getTableHeader();
        // 将JTable加入到带滚动条的面板中
        this.scpDemo.getViewport().add(tabDemo);

    }
    public void btnShow1_ActionPerformed(ActionEvent ae) {
        List<Hotels> hotelsList = new selectHotels().findAll();
        Object[][] info = new Object[hotelsList.size()][5];
        String[] title = {"酒店序号", "所在地", "价格", "房间总量", "房间余量"};
        for (int i=0;i<hotelsList.size();i++){
            info[i][0] = hotelsList.get(i).getHotelNum();
            info[i][1] = hotelsList.get(i).getLocation();
            info[i][2] = hotelsList.get(i).getPrice();
            info[i][3] = hotelsList.get(i).getNumRooms();
            info[i][4] = hotelsList.get(i).getNumAvail();
        }
        // 创建JTable
        this.tabDemo = new JTable(info, title);
        // 显示表头
        this.jth = this.tabDemo.getTableHeader();
        // 将JTable加入到带滚动条的面板中
        this.scpDemo.getViewport().add(tabDemo);

    }
    public void btnShow2_ActionPerformed(ActionEvent ae) {
        List<Bus> busList = new selectBus().findAll();
        Object[][] info = new Object[busList.size()][5];
        String[] title = {"大巴序号", "所在地", "价格", "座位总量", "座位余量"};
        for (int i=0;i<busList.size();i++){
            info[i][0] = busList.get(i).getBusNum();
            info[i][1] = busList.get(i).getLocation();
            info[i][2] = busList.get(i).getPrice();
            info[i][3] = busList.get(i).getNumSeats();
            info[i][4] = busList.get(i).getNumAvail();
        }
        // 创建JTable
        this.tabDemo = new JTable(info, title);
        // 显示表头
        this.jth = this.tabDemo.getTableHeader();
        // 将JTable加入到带滚动条的面板中
        this.scpDemo.getViewport().add(tabDemo);

    }
    public void jb1_ActionPerformed(ActionEvent ae) {
        btnShow_ActionPerformed(ae);
        String fromcity = JOptionPane.showInputDialog("请输入出发城市");
        String arivcity = JOptionPane.showInputDialog("请输入到达城市");
        System.out.println(fromcity+"     "+arivcity);
        List<Flights> flightsList = new selectFlights().chooseFlight(fromcity,arivcity);
        Object[][] info = new Object[flightsList.size()][6];
        String[] title = {"航班序号", "价格", " 座位数量", "座位余量", "出发城市", "到达城市"};
        for (int i=0;i<flightsList.size();i++){
            info[i][0] = flightsList.get(i).getFlightNum();
            info[i][1] = flightsList.get(i).getPrice();
            info[i][2] = flightsList.get(i).getNumSeats();
            info[i][3] = flightsList.get(i).getNumAvail();
            info[i][4] = flightsList.get(i).getFromCity();
            info[i][5] = flightsList.get(i).getAricCity();
        }
        // 创建JTable
        this.tabDemo = new JTable(info, title);
        // 显示表头
        this.jth = this.tabDemo.getTableHeader();
        // 将JTable加入到带滚动条的面板中
        this.scpDemo.getViewport().add(tabDemo);
        tableListener(1);


    }
    public void jb2_ActionPerformed(ActionEvent ae) {
        btnShow1_ActionPerformed(ae);
        String location = JOptionPane.showInputDialog("请输入目的城市");
        int price = Integer.parseInt(JOptionPane.showInputDialog("请输入目标价位"));
        System.out.println(location+"     "+price);
        List<Hotels> hotelsList = new selectHotels().chooseHotel(location,price);
        Object[][] info = new Object[hotelsList.size()][5];
        String[] title = {"酒店序号", "所在地", "价格", "房间总量", "房间余量"};
        for (int i=0;i<hotelsList.size();i++){
            info[i][0] = hotelsList.get(i).getHotelNum();
            info[i][1] = hotelsList.get(i).getLocation();
            info[i][2] = hotelsList.get(i).getPrice();
            info[i][3] = hotelsList.get(i).getNumRooms();
            info[i][4] = hotelsList.get(i).getNumAvail();
        }
        // 创建JTable
        this.tabDemo = new JTable(info, title);
        // 显示表头
        this.jth = this.tabDemo.getTableHeader();
        // 将JTable加入到带滚动条的面板中
        this.scpDemo.getViewport().add(tabDemo);
        tableListener(2);
    }

    public void jb3_ActionPerformed(ActionEvent ae) {
        btnShow2_ActionPerformed(ae);
        String location = JOptionPane.showInputDialog("请输入目的城市");
        int price = Integer.parseInt(JOptionPane.showInputDialog("请输入目标价位"));
        System.out.println(location+"     "+price);
        List<Bus> busList = new selectBus().chooseBus(location,price);
        Object[][] info = new Object[busList.size()][5];
        String[] title = {"大巴序号", "所在地", "价格", "座位总量", "座位余量"};
        for (int i=0;i<busList.size();i++){
            info[i][0] = busList.get(i).getBusNum();
            info[i][1] = busList.get(i).getLocation();
            info[i][2] = busList.get(i).getPrice();
            info[i][3] = busList.get(i).getNumSeats();
            info[i][4] = busList.get(i).getNumAvail();
        }
        // 创建JTable
        this.tabDemo = new JTable(info, title);
        // 显示表头
        this.jth = this.tabDemo.getTableHeader();
        // 将JTable加入到带滚动条的面板中
        this.scpDemo.getViewport().add(tabDemo);
        tableListener(3);
        //new insertReservation().reserve(choice,scanner.next(),customer);
    }

    private void tableListener(int select) {
        tabDemo.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent event)
            {
                int row = tabDemo.rowAtPoint(event.getPoint());
                //System.out.println(tabDemo.getSelectedRow()+"     "+tabDemo.getSelectedColumn());
                Object valueAt = tabDemo.getValueAt(row, 0);
                System.out.println(valueAt);
                if(JOptionPane.showConfirmDialog(null,"预定订单为"+valueAt) == JOptionPane.YES_OPTION){
                    new insertReservation().reserve(select, (String) valueAt,customers);
                    JOptionPane.showMessageDialog(null,"预定成功！");
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
 
 
