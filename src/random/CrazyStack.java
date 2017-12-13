package random;

import java.util.Scanner;

public class CrazyStack {

    static // List<Integer> stack = new ArrayList<>();
            int[] stac = new int[100];

    public static void main(String[] args) {
        Scanner inputString = new Scanner(System.in);
        int count = inputString.nextInt();
        inputString.nextLine();
        int start = 0;
        int end = 0;
        int counter = 0;

        try {
            //while (counter < 0) {

            while (count-- != 0) {
                String inputline = inputString.nextLine();
                // check for empty lines
                if (inputline != null || !inputline.trim().isEmpty()) {

                    String[] commands = inputline.split(" ");
                    if (commands[0].equals("push")) {
                        int no = Integer.parseInt(commands[1]);
                        stac[++end] = no;
                        System.out.println(stac[end]);

                    } else if (commands[0].equals("pop")) {

                        if (end == 0)
                            System.out.println("EMPTY");
                        else
                            System.out.println(stac[end]);
                        end--;

                    } else if (commands[0].equals("inc")) {

                        int x = Integer.parseInt(commands[1]);
                        int d = Integer.parseInt(commands[2]);
                        for (int i = start; i <= start + x; i++) {
                            stac[i] = stac[i] + d;
                        }
                        System.out.println(stac[end]);

                    }

                }

            }
            //	}
        } finally {
            inputString.close();
        }

    }

}