package dev.verzano.monospaced.core.metric;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SpacingTest {
    @Test
    void defaultConstructor() {
        var spacing = new Spacing();

        assertAll(
                () -> assertEquals(0, spacing.getTop(), "Top spacing is incorrect"),
                () -> assertEquals(0, spacing.getRight(), "Right spacing is incorrect"),
                () -> assertEquals(0, spacing.getBottom(), "Bottom spacing is incorrect"),
                () -> assertEquals(0, spacing.getLeft(), "Left spacing is incorrect"));
    }

    @Test
    void oneArgConstructor() {
        final var trbl = 22;

        var spacing = new Spacing(trbl);

        assertAll(
                () -> assertEquals(trbl, spacing.getTop(), "Top spacing is incorrect"),
                () -> assertEquals(trbl, spacing.getRight(), "Right spacing is incorrect"),
                () -> assertEquals(trbl, spacing.getBottom(), "Bottom spacing is incorrect"),
                () -> assertEquals(trbl, spacing.getLeft(), "Left spacing is incorrect"));
    }

    @Test
    void twoArgConstructor() {
        final var tb = 22;
        final var rl = 11;

        var spacing = new Spacing(tb, rl);

        assertAll(
                () -> assertEquals(tb, spacing.getTop(), "Top spacing is incorrect"),
                () -> assertEquals(rl, spacing.getRight(), "Right spacing is incorrect"),
                () -> assertEquals(tb, spacing.getBottom(), "Bottom spacing is incorrect"),
                () -> assertEquals(rl, spacing.getLeft(), "Left spacing is incorrect"));
    }

    @Test
    void threeArgConstructor() {
        final var t = 22;
        final var rl = 44;
        final var b = 11;

        var spacing = new Spacing(t, rl, b);

        assertAll(
                () -> assertEquals(t, spacing.getTop(), "Top spacing is incorrect"),
                () -> assertEquals(rl, spacing.getRight(), "Right spacing is incorrect"),
                () -> assertEquals(b, spacing.getBottom(), "Bottom spacing is incorrect"),
                () -> assertEquals(rl, spacing.getLeft(), "Left spacing is incorrect"));
    }

    @Test
    void fourArgConstructor() {
        final var t = 22;
        final var r = 44;
        final var b = 11;
        final var l = 99;

        var spacing = new Spacing(t, r, b, l);

        assertAll(
                () -> assertEquals(t, spacing.getTop(), "Top spacing is incorrect"),
                () -> assertEquals(r, spacing.getRight(), "Right spacing is incorrect"),
                () -> assertEquals(b, spacing.getBottom(), "Bottom spacing is incorrect"),
                () -> assertEquals(l, spacing.getLeft(), "Left spacing is incorrect"));
    }
}
