package school;

import database.Database;

import java.sql.Statement;
import java.util.Scanner;

public class SchoolMain extends Database {
    public static void main(String[] args) throws Exception {
        System.out.println("1. 학생 목록\t2. 성적 조회\t3. 데이터 임포트");
        Scanner scn = new Scanner(System.in);
        System.out.print("숫자 입력 >> ");
        int num = scn.nextInt();
        switch (num) {
            case 1 -> {
                System.out.println("1: 정보 입력 / 2: 정보 변경 / 3: 정보 삭제 / 4: 정보 출력");
                System.out.print("숫자 입력 >> ");
                int studentInput = scn.nextInt();
                studentSearch(studentInput);
            }
            case 2 -> {
                System.out.print("1. 이름 검색 / 2. 아이디 검색");
                int scoreInput = scn.nextInt();
                scoreSearch(scoreInput);
            }
            case 3 -> dataImport();
            default -> System.out.println("잘못된 숫자 입니다.");
        }
    }

    public static void studentSearch(int studentInput) throws Exception {
        switch (studentInput) {
            case 1 -> studentInput();
            case 2 -> studentModify();
            case 3 -> studentDelete();
            case 4 -> studentAll();
            default -> System.out.println("잘못된 숫자입니다.");
        }
    }

    public static void studentInput() throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.print("학생 ID >> ");
        String id = scn.next();

        System.out.print("학생 이름 >> ");
        String name = scn.next();

        System.out.print("학교 이름 >> ");
        String school = scn.next();

        System.out.print("학생 성별(M / F) >> ");
        String gender = scn.next();

        System.out.print("학생 생년월일(yyyy-MM-dd) >> ");
        String birthday = scn.next();

        Statement stmt = getStatement();

        String query = "insert into school values" +
                "('" + id + "'," +
                "'" + name + "'," +
                "'" + school + "'," +
                "'" + birthday + "'," +
                "upper('" + gender + "')";

        int result = stmt.executeUpdate(query);
        if(result == 1) System.out.println("데이터 추가 성공");
        else System.out.println("데이터 추가 실패");
    }

    public static void studentModify() throws Exception {

    }

    public static void studentDelete() throws Exception {

    }

    public static void studentAll() throws Exception {

    }
    
    public static void scoreSearch(int scoreInput) throws Exception {
        
    }

    public static void dataImport() throws Exception {

    }
}
