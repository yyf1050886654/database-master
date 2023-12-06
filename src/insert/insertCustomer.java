package insert;

import objects.Customers;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class insertCustomer {
    Connection conn = null;
    Statement stmt =  null;
    ResultSet rs = null;
    public boolean login(Customers customer){
        if(customer.getCustID() == null){
            return false;
        }
        try {
            conn =  JDBCUtils.getConnection();
            //2.定义sql
            String sql = "select * from CUSTOMERS where custID ='"+customer.getCustID()+"';";
            //System.out.println(sql);
            //3.获取执行sql的对象
            stmt = conn.createStatement();
            //4.执行查询
            rs = stmt.executeQuery(sql);
            //5.判断
            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }

    public boolean register(String custID,String custName){
        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "insert into CUSTOMERS values('"+custID+"','"+custName+"')";
            //4.获取执行sql的对象
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);//影响的行数
            //6.处理结果
            //System.out.println(count);
            if(count > 0){
                System.out.println("添加成功！");
                return true;
            }else{
                System.out.println("添加失败！");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return false;
    }

}
