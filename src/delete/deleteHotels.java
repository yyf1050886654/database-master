package delete;

import objects.Customers;
import objects.Hotels;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteHotels {
    Connection conn = null;
    Statement stmt =  null;
    ResultSet rs = null;
    public boolean delete(String input){
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from HOTELS where hotelNum = '"+input+"';";
            System.out.println(sql);
            stmt = conn.createStatement();
            int count = stmt.executeUpdate(sql);//影响的行数
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
