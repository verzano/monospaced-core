package dev.verzano.monospaced.core.ansi;

import static dev.verzano.monospaced.core.ansi.ControlSequences.CHA;
import static dev.verzano.monospaced.core.ansi.ControlSequences.CNL;
import static dev.verzano.monospaced.core.ansi.ControlSequences.CPL;
import static dev.verzano.monospaced.core.ansi.ControlSequences.CSI;
import static dev.verzano.monospaced.core.ansi.ControlSequences.CUB;
import static dev.verzano.monospaced.core.ansi.ControlSequences.CUD;
import static dev.verzano.monospaced.core.ansi.ControlSequences.CUF;
import static dev.verzano.monospaced.core.ansi.ControlSequences.CUP;
import static dev.verzano.monospaced.core.ansi.ControlSequences.CUU;
import static dev.verzano.monospaced.core.ansi.ControlSequences.HCU;
import static dev.verzano.monospaced.core.ansi.ControlSequences.SCU;
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

    static Object[][] cud() {
        return new Object[][] {
                {1, "\u001B[1B"},
                {2, "\u001B[2B"},
                {10, "\u001B[10B"},
                {20, "\u001B[20B"},
        };
    }

    static Object[][] cuf() {
        return new Object[][] {
                {1, "\u001B[1C"},
                {2, "\u001B[2C"},
                {10, "\u001B[10C"},
                {20, "\u001B[20C"},
        };
    }

    static Object[][] cub() {
        return new Object[][] {
                {1, "\u001B[1D"},
                {2, "\u001B[2D"},
                {10, "\u001B[10D"},
                {20, "\u001B[20D"},
        };
    }

    static Object[][] cnl() {
        return new Object[][] {
                {1, "\u001B[1E"},
                {2, "\u001B[2E"},
                {10, "\u001B[10E"},
                {20, "\u001B[20E"},
        };
    }

    static Object[][] cpl() {
        return new Object[][] {
                {1, "\u001B[1F"},
                {2, "\u001B[2F"},
                {10, "\u001B[10F"},
                {20, "\u001B[20F"},
        };
    }

    static Object[][] cha() {
        return new Object[][] {
                {1, "\u001B[1G"},
                {2, "\u001B[2G"},
                {10, "\u001B[10G"},
                {20, "\u001B[20G"},
        };
    }

    static Object[][] cup() {
        return new Object[][] {
                {1, 2, "\u001B[1;2H"},
                {2, 3, "\u001B[2;3H"},
                {10, 100, "\u001B[10;100H"},
                {20, 200, "\u001B[20;200H"},
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

    @ParameterizedTest
    @MethodSource("cud")
    void cud(int n, String expected) {
        assertEquals(expected, CUD.apply(n));
    }

    @ParameterizedTest
    @MethodSource("cuf")
    void cuf(int n, String expected) {
        assertEquals(expected, CUF.apply(n));
    }

    @ParameterizedTest
    @MethodSource("cub")
    void cub(int n, String expected) {
        assertEquals(expected, CUB.apply(n));
    }

    @ParameterizedTest
    @MethodSource("cnl")
    void cnl(int n, String expected) {
        assertEquals(expected, CNL.apply(n));
    }

    @ParameterizedTest
    @MethodSource("cpl")
    void cpl(int n, String expected) {
        assertEquals(expected, CPL.apply(n));
    }

    @ParameterizedTest
    @MethodSource("cha")
    void cha(int n, String expected) {
        assertEquals(expected, CHA.apply(n));
    }

    @ParameterizedTest
    @MethodSource("cup")
    void cup(int n, int m, String expected) {
        assertEquals(expected, CUP.apply(n, m));
    }

    @Test
    void scu() {
        assertEquals("\u001B[?25h", SCU.apply());
    }

    @Test
    void hcu() {
        assertEquals("\u001B[?25l", HCU.apply());
    }
}