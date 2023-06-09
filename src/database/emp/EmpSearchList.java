package database.emp;

import database.Database;

import java.sql.ResultSet;
import java.util.Scanner;

public class EmpSearchList {
    public static void main(String[] args) throws Exception {
        System.out.println("[ 사원검색 프로그램 ]");
        System.out.println("1. 사원명 검색");
        System.out.println("2. 부서별 검색");
        System.out.println("3. 업무별 검색");
        System.out.println("4. 매니저별 검색");
        System.out.println("5. 급여별 검색");
        System.out.print("번호 입력 >> ");

        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        switch (num) {
            case 1 -> empSelectEname();
            case 2 -> empSelectDname();
            case 3 -> empSelectJob();
            case 4 -> empSelectManager();
            case 5 -> empSelectSal();
            default -> System.out.println("잘못된 번호 입니다.");
        }

    }

    public static void empSelectEname() throws Exception {
        System.out.print("사원명 입력 >> ");
        Scanner scn = new Scanner(System.in);
        String ename = scn.next();

        ResultSet rs = Database.getResult(
                " select empno, job, sal, mgr, deptno," +
                        "(select ename from emp where empno=e.mgr) mgr_name," +
                        "(select dname from dept where deptno=e.deptno) dname " +
                        "from emp e " +
                        "where e.ename=UPPER('"+ename+"')"
        );
        if(rs.next()) {
            String empno = rs.getString("empno");
            String job = rs.getString("job");
            String sal = rs.getString("sal");
            String mgr = rs.getString("mgr");
            String deptno = rs.getString("deptno");
            String mgr_name = rs.getString("mgr_name");
            String dname = rs.getString("dname");
            System.out.println("1.사원명 : "+ename.toUpperCase()+"("+empno+")");
            System.out.println("2.업무 : "+job);
            System.out.println("3.급여 : "+sal);
            System.out.println("4.매니저 : "+mgr_name);
            System.out.println("5.부서 : "+dname);
        } else {
            System.out.println(" *** 검색 결과가 없습니다. *** ");
        }
    }

    public static void empSelectDname() throws Exception{
        System.out.print("부서명 입력 >> ");
        Scanner scn = new Scanner(System.in);
        String dname = scn.next();

        ResultSet rs = Database.getResult(
                "select ename, empno, job " +
                        "from emp " +
                        "where deptno=" +
                        "(select deptno from dept where dname=UPPER('"+dname+"'))"
        );
        int cnt = 0;
        System.out.println("번호\t사원명(사원번호)\t업무\t부서명");
        while(rs.next()) {
            cnt ++;
            String ename = rs.getString("ename");
            String empno = rs.getString("empno");
            String job = rs.getString("job");
            System.out.println(cnt + "\t" + ename + "(" + empno + ")\t" + job + "\t" + dname.toUpperCase());
        }

        if(cnt == 0) {
            System.out.println(" *** 검색 결과가 없습니다. *** ");
        }
    }

    public static void empSelectJob() throws Exception {
        System.out.print("업무 입력 >> ");
        Scanner scn = new Scanner(System.in);
        String job = scn.next();

        ResultSet rs = Database.getResult(
                "select e.empno, e.ename, d.dname " +
                        "from emp e, dept d " +
                        "where " +
                        "job=upper('"+job+"') " +
                        "and " +
                        "d.deptno=e.deptno"
        );
        int cnt = 0;
        System.out.println("번호\t사원명(사원번호)\t업무\t부서명");
        while(rs.next()) {
            cnt ++;
            String ename = rs.getString("ename");
            String empno = rs.getString("empno");
            String dname = rs.getString("dname");
            System.out.println(cnt + "\t" + ename + "(" + empno + ")\t" + job.toUpperCase() + "\t" + dname);
        }

        if(cnt == 0) {
            System.out.println(" *** 검색 결과가 없습니다. *** ");
        }
    }

    public static void empSelectManager() throws Exception {
        System.out.print("메니저명 입력 >> ");
        Scanner scn = new Scanner(System.in);
        String manager = scn.next();
        ResultSet rs = Database.getResult(
                "select empno, ename, job " +
                        "from emp " +
                        "where " +
                        "mgr=(select empno from emp where ename=upper('jones'))"
        );
        int cnt = 0;
        System.out.println("번호\t사원명(사원번호)\t메니저명\t업무");
        while(rs.next()) {
            cnt ++;
            String ename = rs.getString("ename");
            String empno = rs.getString("empno");
            String job = rs.getString("job");
            System.out.println(cnt + "\t" + ename + "(" + empno + ")\t" + manager.toUpperCase() + "\t" + job);
        }

        if(cnt == 0) {
            System.out.println(" *** 검색 결과가 없습니다. *** ");
        }
    }

    public static void empSelectSal() throws Exception {
        System.out.print("급여 등급 입력 >> ");
        Scanner scn = new Scanner(System.in);
        int sal = scn.nextInt();

        ResultSet rs = Database.getResult(
                "select " +
                        "e.empno, " +
                        "e.ename, " +
                        "e.job, " +
                        "e.sal, " +
                        "s.grade " +
                        "from emp e, sal_grade s " +
                        "where " +
                        "e.sal between losal and hisal and " +
                        "s.grade="+sal
        );
        int cnt = 0;
        System.out.println("번호\t사원명(사원번호)\t급여\t업무");
        while(rs.next()) {
            cnt ++;
            String ename = rs.getString("ename");
            String empno = rs.getString("empno");
            String job = rs.getString("job");
            String salStr = rs.getString("sal");
            System.out.println(cnt + "\t" + ename + "(" + empno + ")\t" + salStr + "\t" + job);
        }

        if(cnt == 0) {
            System.out.println(" *** 검색 결과가 없습니다. *** ");
        }
    }
}
