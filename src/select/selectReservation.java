package select;

import objects.Customers;
import objects.Reservations;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class selectReservation {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Reservations> list = null;
    public List<Reservations> findAll(){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from RESERVATIONS";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Reservations reservations = null;
            list = new ArrayList<Reservations>();
            while(rs.next()){
                //获取数据
                String resvNum = rs.getString("resvNum");
                String custID = rs.getString("custID");
                int type = rs.getInt(3);
                String key = rs.getString("resvKey");
                // 创建emp对象,并赋值
                reservations = new Reservations();
                reservations.setResvNum(resvNum);
                reservations.setCustID(custID);
                reservations.setResvKey(key);
                reservations.setResvType(type);
                //装载集合
                list.add(reservations);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
    public void findFlight(Customers customers){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select FromCity,ArivCity\n" +
                    "from FLIGHTS,RESERVATIONS\n" +
                    "where resvType = 1 and resvKey = flightNum and custID = '"+customers.getCustID()+"';";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            int count =0;
            //6.遍历结果集，封装对象，装载集合
            while(rs.next()){
                //获取数据
                String fromCity = rs.getString("FromCity");
                String arivCity = rs.getString("ArivCity");
                System.out.println("航班"+(++count)+"-------出发地："+fromCity+"------目的地："+arivCity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
    }
    public void findHotel(Customers customers){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select location\n" +
                    "from HOTELS,RESERVATIONS\n" +
                    "where resvType = 2 and resvKey = hotelNum and custID = '"+customers.getCustID()+"';";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            int count =0;
            //6.遍历结果集，封装对象，装载集合
            while(rs.next()){
                //获取数据
                String location = rs.getString("location");
                System.out.println("酒店"+(++count)+"-------地址："+location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
    }
    public void findBus(Customers customers){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select location\n" +
                    "from BUS,RESERVATIONS\n" +
                    "where resvType = 3 and resvKey = BusNum and custID = '"+customers.getCustID()+"';";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            int count =0;
            //6.遍历结果集，封装对象，装载集合
            while(rs.next()){
                //获取数据
                String location = rs.getString("location");
                System.out.println("大巴车"+(++count)+"-------地址："+location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
    }

    public List<Reservations> findCustomer(Customers customers,int resvType){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from RESERVATIONS where resvType = "+resvType+" and custID = "+customers.getCustID();
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Reservations reservations = null;
            list = new ArrayList<Reservations>();
            while(rs.next()){
                //获取数据
                String resvNum = rs.getString("resvNum");
                String custID = rs.getString("custID");
                int type = rs.getInt(3);
                String key = rs.getString("resvKey");
                // 创建emp对象,并赋值
                reservations = new Reservations();
                reservations.setResvNum(resvNum);
                reservations.setCustID(custID);
                reservations.setResvKey(key);
                reservations.setResvType(type);
                //装载集合
                list.add(reservations);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }

}
