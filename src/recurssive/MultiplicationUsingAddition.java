package recurssive;

public class MultiplicationUsingAddition {

    public static void main(String[] args) {
        int firstNumber = 23;
        int secondNumber = 44;

        System.out.println(getProduct(firstNumber, secondNumber));
    }

    private static int getProduct(int num1, int num2) {
        int minNum = Math.max(num1, num2);
        int maxNum = num1 + num2 - minNum;

        return getProductHelper(minNum, maxNum);
    }

    private static int getProductHelper(int minNum, int maxNum) {
        if (minNum == 0) {
            return 0;
        }
        if (minNum == 1) {
            return maxNum;
        }
        int partialSum = getProduct(minNum >> 1, maxNum);
        if (minNum % 2 == 0) {
            return partialSum + partialSum;
        } else {
            return partialSum + partialSum + maxNum;
        }
    }


}
