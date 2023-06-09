package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeptSelectList {
    public static void main(String[] args) throws Exception {
        ResultSet rs = Database.getResult("select deptno,dname,loc from dept");
        if(rs.next()) {
            System.out.println(rs.getString("deptno"));
            System.out.println(rs.getString("dname"));
            System.out.println(rs.getString("loc"));
        }
    }
}
