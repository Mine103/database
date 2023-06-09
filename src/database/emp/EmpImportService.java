package database.emp;

import database.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

public class EmpImportService extends Database {
    public static void main(String[] args) throws Exception {
        String path = "C://java_io_test/emp_import.txt";
        empImport(path);
    }

    public static void empImport(String path) throws Exception {

        Statement stmt = getStatement();

        Calendar cal = Calendar.getInstance();
        long t1 = cal.getTimeInMillis();

        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder str = new StringBuilder();
        String line = "";
        int cnt = 0;
        while((line = br.readLine()) != null) {
            String[] value = line.split("／");
            ResultSet rs = getResult(
                    "insert into " +
                            "emp(empno, ename, job, mgr, hiredate, sal, comm, deptno) " +
                            "values((select max(empno)+1 from emp), " +
                            "'" + value[0] + "', " +
                            "'" + value[1] + "', " +
                            "'" + value[2] + "', " +
                            "'" + value[3] + "', " +
                            "'" + value[4] + "', " +
                            "'" + value[5] + "', " +
                            "'" + value[6] + "')"
            );
            if(rs.next()) cnt += 1;
        }
        System.out.println("데이터 " + cnt + "건 추가 완료");

        cal = Calendar.getInstance();
        long t2 = cal.getTimeInMillis();

        System.out.println("소요시간: " + (t2 - t1) + "ms");
    }
}
