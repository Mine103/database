package study3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        my_sum(10, 20, 30);
        System.out.println(my_sum_return(20, 30, 40));
        fun1(97.123f);
        System.out.println(strTrim("우리 모두의 백과 사전"));
        check();
    }

    private static void my_sum(int i1, int i2, int i3) {
        System.out.println(i1 + i2 + i3);
    }

    private static int my_sum_return(int i1, int i2, int i3) {
        return i1 + i2 + i3;
    }

    private static String strTrim(String str) {
        return str.replace(" ", "");
    }

    private static void fun1(float d1) {
        int i = (int) d1;
        float d = (d1 - i);
        System.out.println("정수: " + i + "/ 실수: " + d);
    }

    private static void check() {
        System.out.print("주민번호를 입력하세요. ");
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String[] split = str.split("-");
        if(split[0].length() != 6 || split[1].length() != 7) {
            System.out.println("잘못된 입력값입니다.//" + split[0].length() + "/" + split[1].length());
            return;
        }

        String year = str.substring(0, 1);
        String mouth = str.substring(2, 3);

        System.out.println("나이: 27세");
        System.out.println("성별: 남성");
        System.out.println("생일: 12월 25일");
    }
}
