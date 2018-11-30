package red;
import java.sql.*;
public class link {
    static {
        try{
            String driverName="com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection con=null;
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/tudou","root","");
        }catch (Exception e){
            e.printStackTrace();
        }
        return  con;
    }
    public static void close(ResultSet rs,Connection con,Statement statement,PreparedStatement pstmt){//关闭数据库连接
        try {
            if(rs !=null)rs.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if(statement !=null) statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if(con !=null) con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if(pstmt !=null) pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}