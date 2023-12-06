package insert;

import objects.Bus;
import objects.Flights;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class insertBus {
    Connection conn = null;
    Statement stmt =  null;
    ResultSet rs = null;

    public boolean insert(Bus bus){
        try {
            conn =  JDBCUtils.getConnection();
            //2.定义sql
            String sql = "insert into BUS values('"+bus.getBusNum()
                    +"', '"+bus.getLocation()+"', "+bus.getPrice()+
                    ", "+bus.getNumSeats()+", "+bus.getNumAvail()+");";
            //System.out.println(sql);
            //3.获取执行sql的对象
            stmt = conn.createStatement();
            //4.执行查询
            int count = stmt.executeUpdate(sql);//影响的行数
            //5.判断
            return count==1;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }


}
