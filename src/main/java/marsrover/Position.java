package marsrover;

import java.util.Objects;

public class Position {

    private int x;
    private int y;
    private Direction direction;

    public Position(final int x, final int y, final Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Position position = (Position) o;

        if (x != position.x) return false;
        if (y != position.y) return false;
        return Objects.equals(direction, position.direction);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "," + direction + "]";
    }

    public void forward() {
        if (direction == Direction.WEST)
            x--;
        else if (direction == Direction.SOUTH)
            y--;
        else if (direction == Direction.EAST)
            x++;
        else
            y++;
    }

    public void backward() {
        this.y--;
    }

    public void turnLeft() {
        this.direction = direction.leftNeighbour();

    }


    public void turnRight() {
        this.direction = direction.rightNeighbour();
    }

    enum Direction {

        NORTH() {
            Direction leftNeighbour() { return WEST; }
            Direction rightNeighbour() { return EAST; }
        }, EAST {
            Direction leftNeighbour() { return NORTH; }
            Direction rightNeighbour() { return SOUTH; }
        }, SOUTH {
            Direction leftNeighbour() { return EAST; }
            Direction rightNeighbour() { return WEST; }
        }, WEST {
            Direction leftNeighbour() { return SOUTH; }
            Direction rightNeighbour() { return NORTH; }
        };

        abstract Direction leftNeighbour();
        abstract Direction rightNeighbour();
    }
}
