package select;

import objects.Flights;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class selectFlights {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Flights> list = null;
    public List<Flights> findAll(){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from FLIGHTS";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Flights flights = null;
            list = new ArrayList<Flights>();
            while(rs.next()){
                //获取数据
                String flightNum = rs.getString("flightNum");
                int price = rs.getInt(2);
                int numSeats = rs.getInt(3);
                int numAvail = rs.getInt(4);
                String FromCity = rs.getString("FromCity");
                String ArivCity = rs.getString("ArivCity");
                // 创建emp对象,并赋值
                flights = new Flights();
                flights.setFlightNum(flightNum);
                flights.setPrice(price);
                flights.setNumSeats(numSeats);
                flights.setNumAvail(numAvail);
                flights.setFromCity(FromCity);
                flights.setAricCity(ArivCity);
                //装载集合
                list.add(flights);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
    public List<Flights> chooseFlight(String fromCity,String arivCity){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from FLIGHTS where FromCity = '"+fromCity+"' and ArivCity = '"+arivCity+"';";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Flights flights = null;
            list = new ArrayList<Flights>();
            while(rs.next()){
                //获取数据
                String flightNum = rs.getString("flightNum");
                int price = rs.getInt(2);
                int numSeats = rs.getInt(3);
                int numAvail = rs.getInt(4);
                String FromCity = rs.getString("FromCity");
                String ArivCity = rs.getString("ArivCity");
                // 创建emp对象,并赋值
                flights = new Flights();
                flights.setFlightNum(flightNum);
                flights.setPrice(price);
                flights.setNumSeats(numSeats);
                flights.setNumAvail(numAvail);
                flights.setFromCity(FromCity);
                flights.setAricCity(ArivCity);
                //装载集合
                list.add(flights);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
