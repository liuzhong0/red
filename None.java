package red;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.text.ParseException;

public class None{
    Connection con;
    ResultSet rs;
    Statement statement;
    PreparedStatement pstmt;

    public Statement getStatement() {
        return statement;
    }

    public ResultSet getRs() {
        return rs;
    }

    public Connection getCon() {
        return con;
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public None(Connection con){
        this.con=con;
        try {
            statement=con.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void createTable() throws  SQLException{
        try{
            String sql="create table if not exists test1(id int,age int,name varchar(100))";
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void  Insert()throws SQLException{
        String s1="insert into test1 values(1,19,'dark')";
        String s2 ="insert into test1 values(2,20,'blue')";
        String s3="insert into test1 values(3,21,'arm')";
        pstmt.setInt1,5);
        pstmt.setString(2,"蛤？");
        statement.addBatch(s1);
        statement.addBatch(s2);
        statement.addBatch(s3);
        int[] results=statement.executeBatch();
        pstmt.executeUpdate();
    }
    public void Select() throws SQLException{
        String sql="select id,age,name from test1";
        rs=statement.executeQuery(sql);
        while(rs.next()){
            String id=rs.getString("id");
            int age=rs.getInt("age");
            String name=rs.getString("name");
            System.out.println(id+"\t"+age+"\t"+name);
        }

    }
    public void Delete() throws  SQLException{
        String sql="delete from test1 where id=2";
        statement.executeUpdate(sql);
    }
    public static void main(String[] args) {
        Connection con=link.getConnection();
        None start=new None(con);
        try {
            start.createTable();
            start.Insert();
            start.Select();
            start.Delete();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            link.close(start.getRs(),start.getCon(),start.getStatement(),start.getPstmt());
        }
    }
}
