package marsrover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static marsrover.Position.Direction.EAST;
import static marsrover.Position.Direction.NORTH;
import static marsrover.Position.Direction.SOUTH;
import static marsrover.Position.Direction.WEST;
import static org.assertj.core.api.Assertions.assertThat;

public class MarsRoverTest {

    @Test
    public void defaultPosition() {
        final MarsRover marsRover = new MarsRover();

        final Position expected = new Position(0, 0, NORTH);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void specificInitialPosition() {
        final Position landingCoordinate = new Position(1, 1, SOUTH);
        final MarsRover marsRover = new MarsRover(landingCoordinate);

        final Position expected = new Position(1, 1, SOUTH);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void forward() {
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("F");

        final Position expected = new Position(0, 1, NORTH);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void towStepsForward() {
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("F", "F");

        final Position expected = new Position(0, 2, NORTH);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void backward() {
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("B");

        final Position expected = new Position(0, -1, NORTH);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void twoStepsBackward() {
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("B", "B");

        final Position expected = new Position(0, -2, NORTH);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void left() {
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("L");

        final Position expected = new Position(0, 0, WEST);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void right() {
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("R");

        final Position expected = new Position(0, 0, EAST);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void double_left() {
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("L", "L");

        final Position expected = new Position(0, 0, SOUTH);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    public void three_times_left() {
        final MarsRover marsRover = new MarsRover();

        marsRover.execute("L", "L", "L");

        final Position expected = new Position(0, 0, EAST);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @EnumSource(Position.Direction.class)
    public void four_times_left_ends_up_in_same_direction(Position.Direction startDirection) {
        final MarsRover marsRover = new MarsRover(new Position(0, 0, startDirection));

        marsRover.execute("L", "L", "L", "L");

        final Position expected = new Position(0, 0, startDirection);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @EnumSource(Position.Direction.class)
    public void four_times_right_ends_up_in_same_direction(Position.Direction startDirection) {
        final MarsRover marsRover = new MarsRover(new Position(0, 0, startDirection));

        marsRover.execute("R", "R", "R", "R");

        final Position expected = new Position(0, 0, startDirection);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    void west_forward() {
        final MarsRover marsRover = new MarsRover(new Position(0, 0, WEST));

        marsRover.execute("F");

        final Position expected = new Position(-1, 0, WEST);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    void south_forward() {
        final MarsRover marsRover = new MarsRover(new Position(0, 0, SOUTH));

        marsRover.execute("F");

        final Position expected = new Position(0, -1, SOUTH);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }

    @Test
    void east_forward() {
        final MarsRover marsRover = new MarsRover(new Position(0, 0, EAST));

        marsRover.execute("F");

        final Position expected = new Position(1, 0, EAST);
        assertThat(marsRover.currentPosition()).isEqualTo(expected);
    }


}
