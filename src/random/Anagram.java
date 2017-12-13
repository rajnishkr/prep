package random;

import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] a = new String[N];
        String[] b = new String[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.next();
        }
        N = sc.nextInt();
        for (int j = 0; j < N; j++) {
            b[j] = sc.next();
        }

        int[] result = getMinimumDifference(a, b);

        for (int res : result) {
            System.out.println(res);
        }
    }

    public static int[] getMinimumDifference(String a[], String[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() != b[i].length()) {
                result[i] = -1;
            } else {
                result[i] = getDifference(a[i], b[i]);
            }
        }

        return result;
    }

    public static int getDifference(String a, String b) {
        int[] index = new int[26];
        for (int i = 0; i < a.length(); i++) {
            index[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            index[b.charAt(i)- 'a']--;
        }
        int modification = 0;
        for (int i = 0; i < 26; i++) {
            modification += Math.abs(index[i]);
        }
        return modification/2;
    }
}
