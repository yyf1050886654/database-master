package select;

import objects.Hotels;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class selectHotels {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    List<Hotels> list = null;
    public List<Hotels> findAll(){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from HOTELS";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Hotels hotels = null;
            list = new ArrayList<Hotels>();
            while(rs.next()){
                //获取数据
                String hotelNum = rs.getString("hotelNum");
                String location = rs.getString("location");
                int price = rs.getInt(3);
                int numRooms = rs.getInt(4);
                int numAvail = rs.getInt(5);
                // 创建emp对象,并赋值
                hotels = new Hotels();
                hotels.setHotelNum(hotelNum);
                hotels.setPrice(price);
                hotels.setLocation(location);
                hotels.setNumAvail(numAvail);
                hotels.setNumRooms(numRooms);
                //装载集合
                list.add(hotels);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
    public List<Hotels> chooseHotel(String city,int Price){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "select * from HOTELS where price<="+Price+" and location = '"+city+"'order by price desc;";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Hotels hotels = null;
            list = new ArrayList<Hotels>();
            while(rs.next()){
                //获取数据
                String hotelNum = rs.getString("hotelNum");
                String location = rs.getString("location");
                int price = rs.getInt(3);
                int numRooms = rs.getInt(4);
                int numAvail = rs.getInt(5);
                // 创建emp对象,并赋值
                hotels = new Hotels();
                hotels.setHotelNum(hotelNum);
                hotels.setPrice(price);
                hotels.setLocation(location);
                hotels.setNumAvail(numAvail);
                hotels.setNumRooms(numRooms);
                //装载集合
                list.add(hotels);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }
}
