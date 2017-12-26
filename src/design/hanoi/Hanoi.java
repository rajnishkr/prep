package design.hanoi;

public class Hanoi {

    public static void main(String[] args) {
        Tower[] towers = new Tower[3];

        int n = 3;
        towers[0] = new Tower();
        towers[1] = new Tower();
        towers[2] = new Tower();
        for (int i = n-1 ; i >= 0; i--) {
            towers[0].pushToTop(i);
        }
        System.out.println(towers[0]);


        towers[0].moveDisks(n, towers[2], towers[1]);

        System.out.println(towers[2]);
    }
}
