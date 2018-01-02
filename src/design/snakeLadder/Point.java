package design.snakeLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
            return this.index + " type : " + this.getConnectionType().name() + " connected to :" +
                    toPoint.stream().map(x -> x.getIndex()).collect(Collectors.toList());
        } else {
            return this.index + " type : " + this.getConnectionType().name();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return getIndex() == point.getIndex() &&
                getConnectionType() == point.getConnectionType();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIndex(), getConnectionType());
    }
}
