package bit_manipulation;

public class HigherNumberSameSetBit {

    public static void main(String[] args) {
        int i = 29;
        System.out.println(Integer.toBinaryString(i));
        int sol = getHigherNumber(i);
        if (sol == -1) {
            System.out.println("x cannot have such value");
        } else {

            System.out.println(Integer.toBinaryString(sol));
        }
    }

    private static int getHigherNumber(int i) {
        if (((i + 1) & i) == 0) {
            return -1;
        }
        int temp = i, count = 0, index = 0;
        while ((temp & 1) == 0) {
            temp = temp >> 1;
            index++;
        }
        while ((temp & 1) != 0) {
            count++;
            temp = temp >> 1;
            index++;
        }
        System.out.println(count+" "+index);
        i = i | (1 << index);
        System.out.println(Integer.toBinaryString(i));
        i = i & ~((1 << index )- 1);
        System.out.println(Integer.toBinaryString(i));
        i = i | ((1 << (count-1) )- 1);
        return i;

    }
}
