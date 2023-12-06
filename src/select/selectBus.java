package select;

import objects.Bus;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class selectBus {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Bus> list = null;
    public List<Bus> findAll(){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from BUS";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Bus bus = null;
            list = new ArrayList<Bus>();
            while(rs.next()){
                //获取数据
                String BusNum = rs.getString("BusNum");
                String location = rs.getString("location");
                int price = rs.getInt(3);
                int numSeats = rs.getInt(4);
                int numAvail = rs.getInt(5);
                // 创建emp对象,并赋值
                bus = new Bus();
                bus.setBusNum(BusNum);
                bus.setPrice(price);
                bus.setLocation(location);
                bus.setNumAvail(numAvail);
                bus.setNumSeats(numSeats);
                //装载集合
                list.add(bus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
    public List<Bus> chooseBus(String city,int Price){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from BUS where price<="+Price+" and location = '"+city+"'order by price desc;";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Bus bus = null;
            list = new ArrayList<Bus>();
            while(rs.next()){
                //获取数据
                String BusNum = rs.getString("BusNum");
                String location = rs.getString("location");
                int price = rs.getInt(3);
                int numSeats = rs.getInt(4);
                int numAvail = rs.getInt(5);
                // 创建emp对象,并赋值
                bus = new Bus();
                bus.setBusNum(BusNum);
                bus.setPrice(price);
                bus.setLocation(location);
                bus.setNumAvail(numAvail);
                bus.setNumSeats(numSeats);
                //装载集合
                list.add(bus);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
