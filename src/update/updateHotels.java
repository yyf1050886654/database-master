package update;

import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class updateHotels {
    Connection conn = null;
    Statement stmt =  null;
    ResultSet rs = null;
    public boolean updatePrice(String hotelNum,int price){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "update HOTELS set price = "+price+" where hotelNum = '"+hotelNum+"'";
            //4.获取执行sql的对象
            System.out.println(sql);
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);//影响的行数
            //6.处理结果
            //System.out.println(count);
            return count==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }
}
