package tictactoe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeTest {

    Game game = new Game();

    @Test
    public void newGame_inProgress() {
        assertThat(game.result()).isEqualTo(Result.INPROGRESS);

        playerXtakes(Grid.Field.L1);
        assertThat(game.result()).isEqualTo(Result.INPROGRESS);

        playerOtakes(Grid.Field.M1);
        assertThat(game.result()).isEqualTo(Result.INPROGRESS);

        playerXtakes(Grid.Field.L2);
        assertThat(game.result()).isEqualTo(Result.INPROGRESS);

        playerOtakes(Grid.Field.M2);
        assertThat(game.result()).isEqualTo(Result.INPROGRESS);
    }

    private void playerXtakes(Grid.Field field) {
        game.takeField(field);
    }

    private void playerOtakes(Grid.Field field) {
        game.takeField(field);
    }

    @Test
    public void playerXwins_leftColumn() {
        playerXtakes(Grid.Field.L1);
        playerOtakes(Grid.Field.M1);
        playerXtakes(Grid.Field.L2);
        playerOtakes(Grid.Field.M2);
        playerXtakes(Grid.Field.L3);
        assertThat(game.result()).isEqualTo(Result.X);
    }

    @Test
    public void playerOwins_leftColumn() {
        playerXtakes(Grid.Field.M1);
        playerOtakes(Grid.Field.L1);
        playerXtakes(Grid.Field.M2);
        playerOtakes(Grid.Field.L2);
        playerXtakes(Grid.Field.R1);
        playerOtakes(Grid.Field.L3);
        assertThat(game.result()).isEqualTo(Result.O);
    }

    @Test
    public void playerXwins_middleColumn() {
        playerXtakes(Grid.Field.M1);
        playerOtakes(Grid.Field.R1);
        playerXtakes(Grid.Field.M2);
        playerOtakes(Grid.Field.R2);
        playerXtakes(Grid.Field.M3);
        assertThat(game.result()).isEqualTo(Result.X);
    }

    @Test
    public void playerOwins_middleColumn() {
        playerXtakes(Grid.Field.L1);
        playerOtakes(Grid.Field.M1);
        playerXtakes(Grid.Field.L2);
        playerOtakes(Grid.Field.M2);
        playerXtakes(Grid.Field.R1);
        playerOtakes(Grid.Field.M3);
        assertThat(game.result()).isEqualTo(Result.O);
    }

    enum Result {X, O, DRAW, INPROGRESS}

    private class Game {
        Player currentPlayer = Player.X;
        Grid grid = new Grid();

        public Result result() {
            if (grid.leftColumn(Player.X))
                return Result.X;

            if (grid.leftColumn(Player.O))
                return Result.O;

            if (grid.middleColumn(Player.X))
                return Result.X;

            if (grid.middleColumn(Player.O))
                return Result.O;
            else
                return Result.INPROGRESS;
        }

        public void takeField(final Grid.Field field) {
            grid.set(field, currentPlayer);
            currentPlayer = currentPlayer == Player.X ? Player.O : Player.X;
        }
    }
}
