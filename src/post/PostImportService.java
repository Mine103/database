package post;

import database.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Statement;
import java.util.Calendar;

public class PostImportService extends Database {
    public static void main(String[] args) throws Exception {

        Calendar cal = Calendar.getInstance();
        long start = cal.getTimeInMillis();

        System.out.println("데이터 추가 시작");

        String path = "C://java_io_test/post1.csv";
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder str = new StringBuilder();
        String line = "";
        while((line = br.readLine()) != null) {
            str.append(line).append("\n");
        }
        String[] lines = str.toString().split("\n");
        Statement stmt = getStatement();
        int cnt = 0;
        for (String s : lines) {
            String[] values = s.split(",");
            int result = stmt.executeUpdate(
                    "insert into " +
                            "post2 " +
                            "values('" + values[0] + "'," +
                            "'" + values[1] + "'," +
                            "'" + values[2] + "'," +
                            "'" + values[3] + "'," +
                            "'" + values[4] + "'," +
                            "'" + values[5] + "'," +
                            "'" + values[6] + "')"
            );
            if (result == 1) cnt += 1;
        }

        cal = Calendar.getInstance();
        long end = cal.getTimeInMillis();

        System.out.println(((end - start) / 1000) + "초 소요");
        System.out.println(cnt + "건 추가");
    }
}
