package tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Grid {

    Map<Field, Player> grid = new HashMap<Field, Player>();

    void set(final Field field, Player player) {
        grid.put(field, player);
    }

    public boolean leftColumn(final Player p) {
        return p.equals(grid.get(Field.L1))
                && p.equals(grid.get(Field.L2))
                && p.equals(grid.get(Field.L3));

    }

    public boolean middleColumn(final Player p) {
        return p.equals(grid.get(Field.M1))
                && p.equals(grid.get(Field.M2))
                && p.equals(grid.get(Field.M3));
    }

    enum Field {L1, L2, L3, M1, M2, M3, R1, R2, R3}
}
