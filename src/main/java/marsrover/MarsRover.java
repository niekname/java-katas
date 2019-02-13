package marsrover;

import static java.util.Arrays.stream;

public class MarsRover {
    private Position position;

    public MarsRover() {
        this(new Position(0, 0, Position.Direction.NORTH));
    }

    public MarsRover(final Position position) {
        this.position = position;
    }

    public Position currentPosition() {
        return position;
    }

    public void execute(final String... commands) {
        stream(commands).forEach(this::execute);
    }

    private void execute(final String command) {
        if (command.equals("B")) this.position.backward();
        if (command.equals("F")) this.position.forward();
        if (command.equals("L")) this.position.turnLeft();
        if (command.equals("R")) this.position.turnRight();
    }
}
