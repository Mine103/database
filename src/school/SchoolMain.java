package school;

import database.Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.sql.ResultSet;
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

        String query = "insert into school " +
                "values(" +
                "'" + id + "'," +
                "'" + name + "'," +
                "'" + school + "'," +
                "'" + birthday + "'," +
                "upper('" + gender + "'))";

        int result = stmt.executeUpdate(query);
        if(result == 1) System.out.println("데이터 추가 성공");
        else System.out.println("데이터 추가 실패");
    }

    public static void studentModify() throws Exception {

        Statement stmt = getStatement();

        Scanner scn = new Scanner(System.in);
        System.out.print("학생 ID >> ");
        String id = scn.next();
        ResultSet rs = getResult(
                "select " +
                        "studentid," +
                        "studentname," +
                        "schoolname," +
                        "birthday," +
                        "gender " +
                        "from school " +
                        "where studentid='" + id + "'"
        );
        if(rs.next()) {
            String studentName = rs.getString("studentname");
            String schoolName = rs.getString("schoolname");
            Date birthday = rs.getDate("birthday");
            String gender = rs.getString("gender");
            System.out.println("학생 ID: " + id + "\n1. 학생 이름: " + studentName + "\n2. 학교 이름: " + schoolName + "\n3. 학생 생일: " + birthday + "\n4. 학생 성별: " + gender);
            System.out.print("수정할 정보 >> ");
            int modify = scn.nextInt();
            if (modify == 1) {
                System.out.print("학생 이름 >> ");
                String name = scn.next();
                String query = "update school set " +
                        "studentname='" + name + "' " +
                        "where studentid='" + id + "'";
                int result = stmt.executeUpdate(query);
                if(result == 1) System.out.println("변경이 완료되었습니다.");
            }
            if (modify == 2) {
                System.out.print("학교 이름 >> ");
                String name = scn.next();
                String query = "update school set " +
                        "schoolname='" + name + "' " +
                        "where studentid='" + id + "'";
                int result = stmt.executeUpdate(query);
                if(result == 1) System.out.println("변경이 완료되었습니다.");
            }
            if (modify == 3) {
                System.out.print("생년월일(yyyy-MM-dd) >> ");
                String birth = scn.next();
                String query = "update school set " +
                        "birthday='" + birth + "' " +
                        "where studentid='" + id + "'";
                int result = stmt.executeUpdate(query);
                if(result == 1) System.out.println("변경이 완료되었습니다.");
            }
            if (modify == 4) {
                System.out.print("성별(M / F) >> ");
                String gender1 = scn.next();
                String query = "update school set " +
                        "gender='" + gender1 + "' " +
                        "where studentid='" + id + "'";
                int result = stmt.executeUpdate(query);
                if(result == 1) System.out.println("변경이 완료되었습니다.");
            }
        }
    }

    public static void studentDelete() throws Exception {
        Statement stmt = getStatement();

        Scanner scn = new Scanner(System.in);
        System.out.print("삭제할 학생 아이디 >> ");
        String id = scn.next();
        String query1 = "delete from school where id='" + id + "'";
        String query2 = "delete from score where id='" + id + "'";
        int result1 = stmt.executeUpdate(query1);
        int result2 = stmt.executeUpdate(query2);
        if(result1 == 1 && result2 == 2) {
            System.out.println("삭제가 완료되었습니다.");
        }
    }

    public static void studentAll() throws Exception {
        System.out.println("번호\t학생 ID\t이름\t성별\t생년월일");
        ResultSet rs = getResult(
                "select " +
                        "studentid," +
                        "studentname," +
                        "gender," +
                        "birthday from school"
        );
        int cnt = 0;
        while (rs.next()) {
            cnt += 1;
            System.out.println(cnt + "\t" + rs.getString("studentid") +
                    "\t" + rs.getString("studentname") +
                    "\t" + rs.getString("gender") +
                    "\t" + rs.getDate("birthday"));
        }
    }

    public static void scoreSearch(int scoreInput) throws Exception {
        Statement stmt = getStatement();

        String query = "select " +
                "sh.studentid as id," +
                "sh.studentname as name," +
                "sh.schoolname as school," +
                "sc.eng as eng," +
                "sc.kor as kor," +
                "sc.math as math," +
                "sc.grade as grade," +
                "sc.class as class," +
                "(eng+kor+math) as sum," +
                "round((eng+kor+math)/3) as avg," +
                "dense_rank() over (order by round((eng+kor+math)/3) desc) as rank" +
                "from school sh, score sc " +
                "where sh.studentid=sc.studentid";

        ResultSet rs = stmt.executeQuery(query);

        String id = "id2";
        rs.next();
        System.out.println(rs.getString("반 석차"));
    }

    public static void dataImport() throws Exception {
        Statement stmt = getStatement();

        Scanner scn = new Scanner(System.in);
        System.out.println("임포트 할 테이블");
        System.out.println("1. school, 2. score");
        System.out.print("숫자 입력 >> ");
        int table = scn.nextInt();
        System.out.print("파일 경로 >> ");
        String path = scn.next();

        File file = new File(path);
        if(!file.exists()) System.out.println("파일이 존재하지 않습니다");
        else {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder str = new StringBuilder();
            String line = "";
            while ((line = br.readLine()) != null) {
                str.append(line).append("\n");
            }
            String[] lines = str.toString().split("\n");
            int cnt = 0;
            for (String s : lines) {
                String[] data = s.split("/");
                if (table == 1) {
                    String id = data[0];
                    String name = data[1];
                    String school = data[2];
                    String birthday = data[3];
                    String gender = data[4];
                    String query = "insert into school values(" +
                            "'" + id + "'," +
                            "'" + name + "'," +
                            "'" + school + "'," +
                            "'" + birthday + "'," +
                            "'" + gender + "')";
                    int result = stmt.executeUpdate(query);
                    if (result == 1) cnt += 1;
                }
                if(table == 2) {
                    int eng = number(data[0]);
                    int kor = number(data[1]);
                    int math = number(data[2]);
                    int grade = number(data[3]);
                    int class1 = number(data[4]);
                    int semestar = number(data[5]);
                    String id = data[7];
                    String query = "insert into score values(" +
                            eng + "," +
                            kor + "," +
                            math + "," +
                            grade + "," +
                            semestar + "," +
                            "'" + id + "'" +
                            class1 + ")";
                    int result = stmt.executeUpdate(query);
                    if(result == 1) cnt += 1;
                }
            }
            System.out.println("데이터 임포트를 완료했습니다.");
            System.out.println("추가 데이터 갯수: " + cnt);
        }
    }

    public static int number(String str) {
        return Integer.parseInt(str);
    }
}
