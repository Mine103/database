package school;

import database.Database;

import java.io.*;

public class Test1 extends Database {
    public static void main(String[] args) throws Exception {
        File file = new File("C://java_io_test/score.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        StringBuilder str = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            str.append(line).append("\n");
        }
        String[] lines = str.toString().split("\n");
        StringBuilder allQuery = new StringBuilder();
        for(String s: lines) {
            String[] data = s.split(",");
            String query = "insert into score(studentid, grade, class, semester, kor, math, eng)\n" +
                    "values('" + data[6] + "', '" + data[3] + "', '"+data[4]+"', '"+data[5]+"', '"+data[1]+"', '"+data[2]+"', '"+data[0]+"');";
            allQuery.append(query).append("\n");
        }
        File file1 = new File("C://java_io_test/allQuery.txt");
        FileWriter fw = new FileWriter(file1);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(allQuery.toString());
        bw.close();
    }
}
