package study5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class IOTest {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("C://java_io_test/post1.csv");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while( ( line = br.readLine() ) != null ) {
            if(line.contains("구리시")) {
                System.out.println(line);
            }
        }
    }
}
