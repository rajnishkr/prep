package design.snakeLadder;

import java.util.ArrayList;
import java.util.List;

public class Point {
    private int index;
    private List<Point> toPoint;
    private ConnectionType connectionType;


    public Point(int index, ConnectionType connectionType) {
        this.connectionType = connectionType;
        this.toPoint = null;
        this.index = index;
        this.toPoint = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public List<Point> getToPoint() {
        return toPoint;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setToPoint(List<Point> toPoint) {
        this.toPoint = toPoint;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    @Override
    public String toString() {
        if (toPoint != null && toPoint.size() != 0) {
            return this.index + " type : " + this.getConnectionType().name() + " connected to :";
        } else {
            return this.index + " type : " + this.getConnectionType().name();
        }
    }
}
