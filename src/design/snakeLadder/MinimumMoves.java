package design.snakeLadder;

import java.util.*;

public class MinimumMoves {

    public static void main(String[] args) {
        int size = 5;
        Board board = new Board(size, 4, 4);
        board.init();
        board.display();


        bfs(board);

    }

    private static void bfs(Board board) {
        Stack<Point> directions = new Stack();
        Queue<Point> points = new LinkedList<>();
        Map<Point, Point> prev = new HashMap<Point, Point>();
        Set<Point> visited = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            points.add(board.getBoard()[i / board.getSize()][i % board.getSize()]);
            visited.add(board.getBoard()[i / board.getSize()][i % board.getSize()]);
        }
        while (!points.isEmpty()) {
            Point point = points.poll();

            if (point.getIndex() == (board.getSize() * board.getSize())) {
                break;
            }
            for (Point p : point.getToPoint()) {
                if (p.getConnectionType() != ConnectionType.SNAKE &&  !visited.contains(p)) {
                    visited.add(p);
                    points.add(p);
                    prev.put(p, point);
                }
            }
        }
        for (Point node = board.getBoard()[board.getSize() - 1][board.getSize() - 1]; node != null; node = prev.get(node)) {
            directions.push(node);
        }
        System.out.println("\n\n Path is");
        while (!directions.isEmpty()) {
            Point current = directions.pop();
            System.out.println(current.getIndex() + " " + current.getConnectionType());
        }
    }
}
