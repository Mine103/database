package database.emp;

import database.Database;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class EmpSelectList {
    public static void main(String[] args) throws Exception {
        ResultSet rs1 = Database.getResult("select count(*) from emp");
        if(rs1.next()) System.out.println(rs1.getString(1));
        ResultSet rs2 = Database.getResult("select * from emp");
        List<List<String>> allData = new LinkedList<>();
        while(rs2.next()) {
            List<String> data = new LinkedList<>();
            data.add(rs2.getString("empno"));
            data.add(rs2.getString("ename"));
            data.add(rs2.getString("job"));
            data.add(rs2.getString("hiredate"));
            data.add(rs2.getString("sal"));
            data.add(rs2.getString("comm"));
            data.add(rs2.getString("DEPTNO"));

            allData.add(data);
        }
        for (List<String> allDatum : allData) {
            System.out.println(allDatum);
        }
    }
}
