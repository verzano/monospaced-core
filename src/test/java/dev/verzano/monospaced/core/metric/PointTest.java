package dev.verzano.monospaced.core.metric;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PointTest {
    @Test
    void twoArgConstructor() {
        final var x = -1919191;
        final var y = 1492;

        var point = new Point(x, y);

        assertAll(
                () -> assertEquals(x, point.getX(), "X coordinate is incorrect"),
                () -> assertEquals(y, point.getY(), "Y coordinate is incorect")
        );
    }
}
