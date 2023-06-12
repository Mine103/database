package school;

import database.Database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ScoreSearch extends Database {

    public static void main(String[] args) throws Exception {
        System.out.println("[ 성적 조회 ]");
        Scanner scn = new Scanner(System.in);
        System.out.println("1.학생명 검색 \n2.학생ID 검색");
        System.out.print("번호 선택 >> ");
        int num = scn.nextInt();

        switch(num) {
            case 1 : nameSearch();
                break;
            case 2 : idSearch();
                break;
            default : System.out.println("정확한 번호를 입력해주세요.");

        }
    }
    public static void nameSearch() throws Exception {
        Statement stmt = getStatement();

        Scanner scn = new Scanner(System.in);
        System.out.print("학생명 >> ");
        String name = scn.next();

        System.out.print("학년 >> ");
        String grade = scn.next();

        System.out.print("학기 >> ");
        String semester = scn.next();


        String sql  = "select 	a.* from "
                +"(select "
                + "			sc.semester 			as 	semester, "
                +"			sh.studentid 			as id, "
                +"			sh.studentname 			as name, "
                +"			sh.schoolname 			as school, "
                +"			sc.eng 					as eng, "
                +"			sc.kor 					as kor, "
                +"			sc.math 				as math, "
                +"			sc.grade 				as grade, "
                +"			sc.class 				as class, "
                +"			(eng+kor+math) 			as sum, "
                +"			round((eng+kor+math)/3) as avg, "
                +"			dense_rank() over (order by round((eng+kor+math)/3) desc) as t_rank, "
                +"			dense_rank() over (partition by class order by (eng+kor+math) desc) as c_rank "
                +"from 		school sh, score sc "
                +"where 	sh.studentid=sc.studentid) a "
                +"where 	a.name='"+ name +"' "
                + "and 		a.grade='"+ grade +"' "
                + "and 		a.semester='"+ semester +"'";


        ResultSet rs = stmt.executeQuery(sql);

        int cnt = 0;
        while( rs.next() ) {
            String id 		= rs.getString("id");
            String school 	= rs.getString("school");
            String clas 	= rs.getString("class");
            String eng 		= rs.getString("eng");
            String kor 		= rs.getString("kor");
            String math 	= rs.getString("math");
            String sum 		= rs.getString("sum");
            String avg 		= rs.getString("avg");
            String c_rank 	= rs.getString("c_rank");
            String t_rank 	= rs.getString("t_rank");
            cnt++;

            System.out.println( "학생ID: " 	+ id );
            System.out.println( "학생명: " 	+ name );
            System.out.println( "학교명: " 	+ school );
            System.out.println( "학년반: " 	+ grade + "학년 " + clas + "반" );
            System.out.println( "학년: " 		+ grade );
            System.out.println( "학기: " 		+ semester );
            System.out.println("-----------------------------------------------------------");
            System.out.println( "학기\t영어\t국어\t수학\t합계\t평균\t전교석차\t반석차" );
            System.out.println( semester + "\t" + eng+ "\t" + kor + "\t" + math + "\t"
                    + sum + "\t" + avg +  "\t" + t_rank + "\t" + c_rank);
        }
        if( cnt == 0 ) {
            System.out.println("검색결과가 없습니다.");
        }
    }

    public static void idSearch() throws Exception {
        Statement stmt = getStatement();

        Scanner scn = new Scanner(System.in);
        System.out.print("학생ID >> ");
        String id = scn.next();

        System.out.print("학년 >> ");
        int grade = scn.nextInt();

        System.out.print("학기 >> ");
        int semester = scn.nextInt();


        String sql = "select a.* from "
                +"(select "
                + "			sc.semester 			as semester, "
                +"			sh.studentid 			as id, "
                +"			sh.studentname 			as name, "
                +"			sh.schoolname 			as school, "
                +"			sc.eng 					as eng, "
                +"			sc.kor 					as kor, "
                +"			sc.math 				as math, "
                +"			sc.grade 				as grade, "
                +"			sc.class 				as class, "
                +"			(eng+kor+math) 			as sum, "
                +"			round((eng+kor+math)/3) as avg, "
                +"			dense_rank() over (order by round((eng+kor+math)/3) desc) 			as t_rank, "
                +"			dense_rank() over (partition by class order by (eng+kor+math) desc) as c_rank "
                +"from 		school sh, score sc "
                +"where 	sh.studentid=sc.studentid" +
                "and sc.grade='1'" +
                "and sc.semester='1') a "
                +"where a.id='"+ id +"' ";



        ResultSet rs = stmt.executeQuery(sql);

        int cnt = 0;
        while( rs.next() ) {
            String name 	= rs.getString("name");
            String school 	= rs.getString("school");
            String clas 	= rs.getString("class");
            String eng 		= rs.getString("eng");
            String kor 		= rs.getString("kor");
            String math 	= rs.getString("math");
            String sum 		= rs.getString("sum");
            String avg 		= rs.getString("avg");
            String c_rank 	= rs.getString("c_rank");
            String t_rank 	= rs.getString("t_rank");
            cnt++;

            System.out.println( "학생ID: " 	+ id );
            System.out.println( "학생명: " 	+ name );
            System.out.println( "학교명: " 	+ school );
            System.out.println( "학년반: " 	+ grade + "학년 " + clas + "반" );
            System.out.println( "학년: " 		+ grade );
            System.out.println( "학기: " 		+ semester );
            System.out.println("-----------------------------------------------------------");
            System.out.println( "학기\t영어\t국어\t수학\t합계\t평균\t전교석차\t반석차" );
            System.out.println( semester + "\t" + eng+ "\t" + kor + "\t" + math + "\t"
                    + sum + "\t" + avg + "\t" + t_rank + "\t" + c_rank);
        }
        if( cnt == 0 ) {
            System.out.println("검색결과가 없습니다.");
        }
    }




}
