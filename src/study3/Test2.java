package study3;

public class Test2 {
    public static void main(String[] args) {
        int[] aa = {70, 10, 20, 30, 100, 80};
        System.out.println("최대: " + arrayMax(aa));
        System.out.println("최소: " + arrayMin(aa));

        System.out.println( (double) 15 / 7 );
        System.out.println( point((double) 15 / 7, 3) );
    }

    public static int arrayMax(int[] aa) {
        int max = aa[0];

        for(int i = 1; i < aa.length; i ++) {
            int m = Math.max(max, aa[i]);
            if(max < m) {
                max = m;
            }
        }

        return max;
    }

    public static int arrayMin(int[] aa) {
        int min = aa[0];

        for(int i = 1; i < aa.length; i ++) {
            int m = Math.min(min, aa[i]);
            if(min > m) {
                min = m;
            }
        }

        return min;
    }

    public static int arrayCenter(int[] aa) {
        int center = 0;
        return center;
    }

    public static double point(double number, int line) {
        int n = (int) Math.pow(10, line);
        int pow = (int) (number * n);
        return (double) pow / n;
    }
}
