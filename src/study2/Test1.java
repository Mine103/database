package study2;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.println("= 드시려는 커피 번호를 입력해주세요. =");
        System.out.println("1. 아메리카노");
        System.out.println("2. 다방커피");
        System.out.print("* 커피번호 >> ");
        int coffee = sca.nextInt();
        if(coffee == 1) {
            System.out.println("");
        }
    }
}
