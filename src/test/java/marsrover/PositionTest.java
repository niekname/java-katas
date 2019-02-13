package marsrover;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    public void equality() {
        final Position p = new Position(0, 0, Position.Direction.NORTH);
        assertThat(p).isEqualTo(new Position(0, 0, Position.Direction.NORTH));
        assertThat(p).isNotEqualTo(new Position(1, 0, Position.Direction.NORTH));
        assertThat(p).isNotEqualTo(new Position(0, 1, Position.Direction.NORTH));
        assertThat(p).isNotEqualTo(new Position(0, 0, Position.Direction.SOUTH));
    }
}
