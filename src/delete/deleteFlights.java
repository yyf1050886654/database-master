package delete;

import objects.Customers;
import objects.Flights;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteFlights {
    Connection conn = null;
    Statement stmt =  null;
    ResultSet rs = null;
    public boolean delete(String input){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "delete from FLIGHTS where flightNum = '"+input+"'";
            //4.获取执行sql的对象
            System.out.println(sql);
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);//影响的行数
            //6.处理结果
            //System.out.println(count);
            if(count > 0){
                System.out.println("删除成功！");
            }else{
                System.out.println("删除失败，请输入正确的编号！");
            }
            return count==1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }
}
