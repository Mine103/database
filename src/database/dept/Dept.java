package database.dept;

import database.Database;

import java.sql.ResultSet;
import java.util.Scanner;

public class Dept {

    private static Scanner scn = null;

    public static void main(String[] args) throws Exception {
        System.out.println("[ 부서정보관리 시스템 ]");
        System.out.println("1. 부서 목록");
        System.out.println("2. 부서 입력");
        System.out.println("3. 부서 변경");
        System.out.println("4. 부서 삭제");

        scn = new Scanner(System.in);
        int num = scn.nextInt();

        switch (num) {
            case 1: deptSelect();
                break;
            case 2: deptInsert();
                break;
            case 3: deptUpdate();
                break;
            case 4: deptDelete();
                break;
        }
    }

    public static void deptSelect() throws Exception {
        ResultSet rs1 = Database.getResult("select count(*) from dept");
        int count = 0;
        if(rs1.next()) count = rs1.getInt(0);
    }

    public static void deptInsert() {

    }

    public static void deptUpdate() {

    }

    public static void deptDelete() {

    }
}
