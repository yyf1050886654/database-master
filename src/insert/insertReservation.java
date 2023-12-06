package insert;

import objects.Customers;
import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


public class insertReservation {
    Connection conn = null;
    Statement stmt =  null;
    ResultSet rs = null;
    public void reserve(int resvType, String resvKey, Customers customer){
        Random random = new Random();
        String  resvNum = random.nextInt(99999)+"";

        try {
            conn = JDBCUtils.getConnection();
            //3.定义sql
            String sql = "insert into RESERVATIONS values('"+resvNum+"','"+customer.getCustID()+"',"+resvType+","+resvKey+");";
            //4.获取执行sql的对象
            System.out.println(sql);
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);//影响的行数
            //6.处理结果
            //System.out.println(count);
            if(count > 0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
    }
}
