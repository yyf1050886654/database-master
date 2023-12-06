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

public class selectReservation_forGUI {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    StringBuilder ans;
    public String findFlight(Customers customers){
        ans= new StringBuilder();
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
                ans.append("航班").append(++count).append("-------出发地：").append(fromCity).append("------目的地：").append(arivCity).append("\n");
                //System.out.println("航班"+(++count)+"-------出发地："+fromCity+"------目的地："+arivCity);
            }
            return ans.toString();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return ans.toString();
    }
    public String findHotel(Customers customers){
        ans= new StringBuilder();
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
                //System.out.println("酒店"+(++count)+"-------地址："+location);
                ans.append("酒店").append(++count).append("-------地址：").append(location).append("\n");
            }
            return ans.toString();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return ans.toString();
    }
    public String findBus(Customers customers){
        ans= new StringBuilder();
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
                // System.out.println("大巴车"+(++count)+"-------地址："+location);
                ans.append("大巴车").append(++count).append("-------地址：").append(location).append("\n");
            }
            return ans.toString();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return ans.toString();
    }
}
