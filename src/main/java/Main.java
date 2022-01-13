import java.util.HashMap;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n; j++) {
                int z = getSize(Math.max(a[i], a[j]));
                int k = i == j ? a[i] : a[i] + a[j];
                Integer ans = map.get(k);
                if (ans == null) {
                    int mid = k + k * powerOfTen(z);
                    sum += mid;
                    map.put(k, mid);
                } else {
                    sum += ans;
                }
            }
        }

        System.out.println(sum);
    }

    final static int [] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE };

    static int getSize(int x) {
        for (int i=0; ; i++)
            if (x <= sizeTable[i])
                return i+1;
    }

    static final int[] POWERS_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    static int powerOfTen(int pow) {
        return POWERS_OF_10[pow];
    }

}
