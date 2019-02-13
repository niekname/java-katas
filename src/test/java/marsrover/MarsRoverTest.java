package marsrover;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static marsrover.Position.Direction.EAST;
import static marsrover.Position.Direction.NORTH;
import static marsrover.Position.Direction.SOUTH;
import static marsrover.Position.Direction.WEST;
import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    @Test
    public void defaultPosition() {
        final Position expected = new Position(0, 0, NORTH);
        final MarsRover marsRover = new MarsRover();

        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void specificInitialPosition() {
        final Position expected = new Position(1, 1, SOUTH);
        final Position landingCoordinate = new Position(1, 1, SOUTH);
        final MarsRover marsRover = new MarsRover(landingCoordinate);

        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void forward() {
        final Position expected = new Position(0, 1, NORTH);
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("F");

        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void towStepsForward() {
        final Position expected = new Position(0, 2, NORTH);
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("F", "F");

        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void backward() {
        final Position expected = new Position(0, -1, NORTH);
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("B");

        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void twoStepsBackward() {
        final Position expected = new Position(0, -2, NORTH);
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("B", "B");

        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void left() {
        final Position expected = new Position(0, 0, WEST);
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("L");

        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void right() {
        final Position expected = new Position(0, 0, EAST);
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("R");

        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    @Disabled // TODO
    public void left_left() {
        final Position expected = new Position(0, 0, SOUTH);
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("L", "L");

        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }
}
