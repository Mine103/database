package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

    public static Statement getStatement() throws Exception {
        String url = "jdbc:oracle:thin:@//localhost:1521/xe";
        String userName = "c##java";
        String userPwd = "1234";
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(url, userName, userPwd);
        return con.createStatement();
    }

    public static ResultSet getResult(String query) throws Exception {
        Statement stmt = getStatement();
        return stmt.executeQuery(query);
    }
}
