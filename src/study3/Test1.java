package study3;

public class Test1 {
    public static void main(String[] args) {
        int[][] classA = {{90, 80, 70}, {50, 100, 100}};

        int sum1 = 0;
        for(int i = 0; i < classA[0].length; i ++) {
            sum1 += classA[0][i];
        }
        int sum2 = 0;
        for(int i = 0; i < classA[1].length; i++) {
            sum2 += classA[1][i];
        }
        System.out.println("1반 총합: " + sum1 + "/평균" + sum1 / classA[0].length);
        System.out.println("2반 총합: " + sum2 + "/평균" + sum2 / classA[1].length);
        System.out.println("전체 평균: " + ((sum1 + sum2) / (classA[0].length + classA[1].length)));
    }
}
