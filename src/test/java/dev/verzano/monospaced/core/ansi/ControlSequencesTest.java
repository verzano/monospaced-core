package dev.verzano.monospaced.core.ansi;

import static dev.verzano.monospaced.core.ansi.ControlSequences.CSI;
import static dev.verzano.monospaced.core.ansi.ControlSequences.CUU;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class ControlSequencesTest {
    static Object[][] cuu() {
        return new Object[][] {
                {1, "\u001B[1A"},
                {2, "\u001B[2A"},
                {10, "\u001B[10A"},
                {20, "\u001B[20A"},
        };
    }

    @Test
    void csi() {
        assertEquals("\u001B[", CSI);
    }

    @ParameterizedTest
    @MethodSource("cuu")
    void cuu(int n, String expected) {
        assertEquals(expected, CUU.apply(n));
    }
}