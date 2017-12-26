package recurssive;

public class PaintFill {

    public static void main(String[] args) {
        int r, c;
        r = 5;
        c = 5;

        Color[][] image = new Color[r][c];

        paintFill(image, 2, 1, Color.red);

        System.out.println("Image");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(image[i][j].name() + " ");

            }
            System.out.println();

        }


    }

    private static boolean paintFill(Color[][] image, int r, int c, Color color) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] == color) {
            return false;
        }

        return paintFillHelper(image, r, c, image[r][c], color);

    }

    private static boolean paintFillHelper(Color[][] image, int r, int c, Color old, Color newColor) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return false;
        }
        if (image[r][c] == old) {
            image[r][c] = newColor;
            paintFillHelper(image, r - 1, c, old, newColor);
            paintFillHelper(image, r, c - 1, old, newColor);
            paintFillHelper(image, r + 1, c, old, newColor);
            paintFillHelper(image, r, c + 1, old, newColor);
        }
        return true;
    }

    enum Color {
        green, red, pink, black, blue;

        @Override
        public String toString() {
            return "Color{}";
        }
    }
}
