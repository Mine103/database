package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PostImportService extends Database{
    public static void main(String[] args) throws Exception {
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
        for(int i = 0; i < lines.length; i ++) {

        }
    }
}
