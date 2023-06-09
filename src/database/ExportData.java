package database;

import java.sql.Statement;
import java.util.Scanner;

public class ExportData extends Database{
    public static void main(String[] args) {
        System.out.println("Export Data");
        System.out.println("1. 우편 번호, 2. 사원 정보");
        Scanner scn = new Scanner(System.in);
        System.out.print("번호 입력 >> ");
        int num = scn.nextInt();
    }
    public static void exportPost() throws Exception {
        Statement stmt = getStatement();
    }
}