package design.snakeLadder;

import java.util.Random;

public class Board {


    private int size;
    private int numberOfLadder;
    private int numberOfSnakes;
    private Point board[][];

    public Board(int size, int numberOfLadder, int numberOfSnakes) {
        this.size = size;
        this.board = new Point[size + 1][size + 1];
        this.numberOfLadder = numberOfLadder;
        this.numberOfSnakes = numberOfSnakes;
    }

    public int getSize() {
        return size;
    }

    public Point[][] getBoard() {
        return board;
    }

    public void init() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Point((i + 1) * (j + 1), ConnectionType.NO_VALUE);
            }
        }

        for (int i = 0; i < size * size; i++) {
            for (int j = i + 1; j <= i + 6 &&  j < size * size; j++) {
                board[i / size][i % size].getToPoint().add(board[j / size][j % size]);
            }
        }

        Random random = new Random();
        for (int i = 0; i < numberOfSnakes; i++) {
            int fromRow = random.nextInt(size);
            int fromColumn = random.nextInt(size);
            int toRow = random.nextInt(size);
            int toColumn = random.nextInt(size);
            board[fromRow][fromColumn].setConnectionType(ConnectionType.SNAKE);
            board[fromRow][fromColumn].getToPoint().add(board[toRow][toColumn]);
        }

        for (int i = 0; i < numberOfLadder; i++) {
            int fromRow = random.nextInt(size);
            int fromColumn = random.nextInt(size);
            int toRow = random.nextInt(size);
            int toColumn = random.nextInt(size);
            board[fromRow][fromColumn].setConnectionType(ConnectionType.LADDER);
            board[fromRow][fromColumn].getToPoint().add(board[toRow][toColumn]);
        }

    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println(board[i][j]);

            }


        }
    }
}
