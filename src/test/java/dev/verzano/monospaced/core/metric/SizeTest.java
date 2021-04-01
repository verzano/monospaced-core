package dev.verzano.monospaced.core.metric;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SizeTest {
    @Test
    void defaultConstructor() {
        var size = new Size();

        assertAll(
                () -> assertEquals(0, size.getWidth(), "Width is incorrect"),
                () -> assertEquals(0, size.getHeight(), "Height is incorrect")
        );
    }

    @Test
    void twoArgConstructor() {
        final var w = 33;
        final var h = 44;
        var size = new Size(w, h);

        assertAll(
                () -> assertEquals(w, size.getWidth(), "Width is incorrect"),
                () -> assertEquals(h, size.getHeight(), "Height is incorrect")
        );
    }
}
