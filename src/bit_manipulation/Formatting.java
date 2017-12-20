package bit_manipulation;

public class Formatting {

    public static void main(String[] args) {
        int i = (int) Math.pow(2, 10);
        int j = 19;
        int start = 2;
        int end = 6;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(j));
        int mask = (int) Math.pow(2, (end + 1)) - 1;
        System.out.println(Integer.toBinaryString(mask));

        mask = (mask >> start) << start;

        System.out.println(Integer.toBinaryString(mask));
        mask = ~mask;
        System.out.println(Integer.toBinaryString(mask));
        int out = (i & mask) | (j << start);
        System.out.println(Integer.toBinaryString(out));

        i >>>= 1;
        System.out.println(Integer.toBinaryString(i));
    }
}
