package GUI;

import insert.*;
import objects.*;
import select.*;
import delete.*;
import update.*;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class adminPage extends JFrame implements ActionListener{
    private JScrollPane scpDemo;
    private JTableHeader jth;
    private JTable tabDemo;
    private JButton btnShow,btnShow1,btnShow2;
    private JButton jb1,jb2,jb3,jb4=null;
    private Choice cC;

    public adminPage() {
        super("管理员菜单");        //JFrame的标题名称
        //创建组件
        jb1=new JButton("数据插入");
        jb2=new JButton("数据更改");
        jb3=new JButton("数据删除");
        jb4=new JButton("管理员退出");

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);

        cC = new Choice();
        cC.add("航班管理");
        cC.add("酒店管理");
        cC.add("大巴管理");
        cC.setBounds(10,50,150,30);
        this.add(cC);


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

        this.jb1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) {
               jb1_ActionPerformed(ae);
            }
        });
        this.jb2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) {
                jb2_ActionPerformed(ae);

            }
        });
        this.jb3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) {
                jb3_ActionPerformed(ae);
            }
        });
        this.jb4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
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
        new adminPage();
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
    public String selectIndex(){
        switch (cC.getSelectedIndex()){
            case 0:
                return "航班";
            case 1:
                return "酒店";
            case 2:
                return "大巴";
        }
        return null;
    }
    public void showQuery(ActionEvent ae){
        switch (cC.getSelectedIndex()){
            case 0:
                btnShow_ActionPerformed(ae);
                break;
            case 1:
                btnShow1_ActionPerformed(ae);
                break;
            case 2:
                btnShow2_ActionPerformed(ae);
                break;
        }
    }
    public void jb1_ActionPerformed(ActionEvent ae) {
        showQuery(ae);
        String getData = JOptionPane.showInputDialog("请输入"+selectIndex()+"信息（用空格分开）：");
        if (getData != null){
            String[] insertData = getData.split(" ");
            System.out.println(Arrays.toString(insertData));
            switch (cC.getSelectedIndex()){
                case 0:
                    Flights flight = new Flights();
                    flight.setFlightNum(insertData[0]);
                    flight.setPrice(Integer.parseInt(insertData[1]));
                    flight.setNumSeats(Integer.parseInt(insertData[2]));
                    flight.setNumAvail(Integer.parseInt(insertData[3]));
                    flight.setFromCity(insertData[4]);
                    flight.setAricCity(insertData[5]);
                    if(new insertFlights().insert(flight)){
                        JOptionPane.showMessageDialog(null,selectIndex()+"增加成功！");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,selectIndex()+"增加失败！");
                    }
                    break;
                case 1:
                    Hotels hotel = new Hotels();
                    hotel.setHotelNum(insertData[0]);
                    hotel.setLocation(insertData[1]);
                    hotel.setPrice(Integer.parseInt(insertData[2]));
                    hotel.setNumRooms(Integer.parseInt(insertData[3]));
                    hotel.setNumAvail(Integer.parseInt(insertData[4]));
                    if(new insertHotels().insert(hotel)){
                        JOptionPane.showMessageDialog(null,selectIndex()+"增加成功！");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,selectIndex()+"增加失败！");
                    }
                    break;
                case 2:
                    Bus bus = new Bus();
                    bus.setBusNum(insertData[0]);
                    bus.setLocation(insertData[1]);
                    bus.setPrice(Integer.parseInt(insertData[2]));
                    bus.setNumSeats(Integer.parseInt(insertData[3]));
                    bus.setNumAvail(Integer.parseInt(insertData[4]));
                    if(new insertBus().insert(bus)){
                        JOptionPane.showMessageDialog(null,selectIndex()+"增加成功！");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,selectIndex()+"增加失败！");
                    }
                    break;
            }
        }
    }
    public void jb2_ActionPerformed(ActionEvent ae) {
        showQuery(ae);
        String getData = JOptionPane.showInputDialog("请输入要更改的"+selectIndex()
                +"数据（格式："+selectIndex()+
                "编号+列号+变更数据）：");
        System.out.println(getData);
        if(getData != null){
            String[] updateData = getData.split(" ");
            switch (cC.getSelectedIndex()){
                case 0:
                    if (new updateFlights().updatePrice(updateData[0], Integer.parseInt(updateData[2]))){
                        JOptionPane.showMessageDialog(null,selectIndex()+"变更成功！");
                    }
                    else JOptionPane.showMessageDialog(null,selectIndex()+"变更失败！");
                    break;
                case 1:
                    if (new updateHotels().updatePrice(updateData[0], Integer.parseInt(updateData[2]))){
                        JOptionPane.showMessageDialog(null,selectIndex()+"变更成功！");
                    }
                    else JOptionPane.showMessageDialog(null,selectIndex()+"变更失败！");
                    break;
                case 2:
                    if (new updateBus().updatePrice(updateData[0], Integer.parseInt(updateData[2]))){
                        JOptionPane.showMessageDialog(null,selectIndex()+"变更成功！");
                    }
                    else JOptionPane.showMessageDialog(null,selectIndex()+"变更失败！");
                    break;
            }
        }
    }

    public void jb3_ActionPerformed(ActionEvent ae) {
        showQuery(ae);
        String getData = JOptionPane.showInputDialog("请输入要删除的"+selectIndex()+"编号（不超过五位）：");
        if (getData != null){
            switch (cC.getSelectedIndex()){
                case 0:
                    if (new deleteFlights().delete(getData)){
                        JOptionPane.showMessageDialog(null,selectIndex()+"删除成功！");
                    }
                    else JOptionPane.showMessageDialog(null,selectIndex()+"删除失败！");
                    break;
                case 1:
                    if (new deleteHotels().delete(getData)){
                        JOptionPane.showMessageDialog(null,selectIndex()+"删除成功！");
                    }
                    else JOptionPane.showMessageDialog(null,selectIndex()+"删除失败！");
                    break;
                case 2:
                    if (new deleteBus().delete(getData)){
                        JOptionPane.showMessageDialog(null,selectIndex()+"删除成功！");
                    }
                    else JOptionPane.showMessageDialog(null,selectIndex()+"删除失败！");
                    break;
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
 
 
