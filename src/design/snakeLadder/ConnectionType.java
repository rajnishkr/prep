package design.snakeLadder;

public enum ConnectionType {

    SNAKE(-1),NO_VALUE(0), LADDER(1);

    private int value;

    ConnectionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}