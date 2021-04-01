package dev.verzano.monospaced.core.constant;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class KeysTest {
    static Object[][] charKeyValues() {
        return new Object[][]{
                // Control Keys
                {"ESC", Keys.ESC, '\u001B'},
                {"BACKSPACE", Keys.BACKSPACE, '\u0008'},
                {"DELETE", Keys.DELETE, '\u007F'},

                // Whitespace Keys
                {"SPACE", Keys.SPACE, ' '},
                {"TAB", Keys.TAB, '\u0009'},
                {"ENTER", Keys.ENTER, '\r'},

                // Letter Keys
                {"A_LOWER", Keys.A_LOWER, 'a'},
                {"B_LOWER", Keys.B_LOWER, 'b'},
                {"C_LOWER", Keys.C_LOWER, 'c'},
                {"D_LOWER", Keys.D_LOWER, 'd'},
                {"E_LOWER", Keys.E_LOWER, 'e'},
                {"F_LOWER", Keys.F_LOWER, 'f'},
                {"G_LOWER", Keys.G_LOWER, 'g'},
                {"H_LOWER", Keys.H_LOWER, 'h'},
                {"I_LOWER", Keys.I_LOWER, 'i'},
                {"J_LOWER", Keys.J_LOWER, 'j'},
                {"K_LOWER", Keys.K_LOWER, 'k'},
                {"L_LOWER", Keys.L_LOWER, 'l'},
                {"M_LOWER", Keys.M_LOWER, 'm'},
                {"N_LOWER", Keys.N_LOWER, 'n'},
                {"O_LOWER", Keys.O_LOWER, 'o'},
                {"P_LOWER", Keys.P_LOWER, 'p'},
                {"Q_LOWER", Keys.Q_LOWER, 'q'},
                {"R_LOWER", Keys.R_LOWER, 'r'},
                {"S_LOWER", Keys.S_LOWER, 's'},
                {"T_LOWER", Keys.T_LOWER, 't'},
                {"U_LOWER", Keys.U_LOWER, 'u'},
                {"V_LOWER", Keys.V_LOWER, 'v'},
                {"W_LOWER", Keys.W_LOWER, 'w'},
                {"X_LOWER", Keys.X_LOWER, 'x'},
                {"Y_LOWER", Keys.Y_LOWER, 'y'},
                {"Z_LOWER", Keys.Z_LOWER, 'z'},
                {"A_UPPER", Keys.A_UPPER, 'A'},
                {"B_UPPER", Keys.B_UPPER, 'B'},
                {"C_UPPER", Keys.C_UPPER, 'C'},
                {"D_UPPER", Keys.D_UPPER, 'D'},
                {"E_UPPER", Keys.E_UPPER, 'E'},
                {"F_UPPER", Keys.F_UPPER, 'F'},
                {"G_UPPER", Keys.G_UPPER, 'G'},
                {"H_UPPER", Keys.H_UPPER, 'H'},
                {"I_UPPER", Keys.I_UPPER, 'I'},
                {"J_UPPER", Keys.J_UPPER, 'J'},
                {"K_UPPER", Keys.K_UPPER, 'K'},
                {"L_UPPER", Keys.L_UPPER, 'L'},
                {"M_UPPER", Keys.M_UPPER, 'M'},
                {"N_UPPER", Keys.N_UPPER, 'N'},
                {"O_UPPER", Keys.O_UPPER, 'O'},
                {"P_UPPER", Keys.P_UPPER, 'P'},
                {"Q_UPPER", Keys.Q_UPPER, 'Q'},
                {"R_UPPER", Keys.R_UPPER, 'R'},
                {"S_UPPER", Keys.S_UPPER, 'S'},
                {"T_UPPER", Keys.T_UPPER, 'T'},
                {"U_UPPER", Keys.U_UPPER, 'U'},
                {"V_UPPER", Keys.V_UPPER, 'V'},
                {"W_UPPER", Keys.W_UPPER, 'W'},
                {"X_UPPER", Keys.X_UPPER, 'X'},
                {"Y_UPPER", Keys.Y_UPPER, 'Y'},
                {"Z_UPPER", Keys.Z_UPPER, 'Z'}
        };
    }

    static String[][] stringKeyValues() {
        return new String[][]{
                // Arrow Keys
                {"UP_ARROW", Keys.UP_ARROW, "\u001B[A"},
                {"DOWN_ARROW", Keys.DOWN_ARROW, "\u001B[B"},
                {"RIGHT_ARROW", Keys.RIGHT_ARROW, "\u001B[C"},
                {"LEFT_ARROW", Keys.LEFT_ARROW, "\u001B[D"},
        };
    }

    @ParameterizedTest
    @MethodSource("charKeyValues")
    void charKeyValues(String keyName, char actual, char expected) {
        assertEquals(expected, actual, "Key " + keyName + " has wrong value");
    }

    @ParameterizedTest
    @MethodSource("stringKeyValues")
    void stringKeyValues(String keyName, String actual, String expected) {
        assertEquals(expected, actual, "Key " + keyName + " has wrong value");
    }

    @Test
    void printableAsciiIsUnmodifiable() {
        var printableAscii = Keys.printableAscii();
        var chars = new HashSet<Character>();
        chars.add('/');
        chars.add('\\');

        assertAll(
                () -> assertThrows(
                        UnsupportedOperationException.class,
                        () -> printableAscii.add('*'),
                        "set.add() should fail but didn't"),
                () -> assertThrows(
                        UnsupportedOperationException.class,
                        () -> printableAscii.addAll(chars),
                        "set.addAll() should fail but didn't"),
                () -> assertThrows(
                        UnsupportedOperationException.class,
                        () -> printableAscii.remove('*'),
                        "set.remove() should fail but didn't"),
                () -> assertThrows(
                        UnsupportedOperationException.class,
                        () -> printableAscii.removeAll(chars),
                        "set.removeAll() should fail but didn't"),
                () -> assertThrows(
                        UnsupportedOperationException.class,
                        printableAscii::clear,
                        "set.clear() should fail but didn't")
        );
    }

    @Test
    void printableAsciiValues() {
        var printableAscii = Keys.printableAscii();

        assertEquals(95, printableAscii.size(), "wrong number of items in the printableAscii set");
        for (var pa : printableAscii) {
            assertTrue(32 <= (int) pa && 127 > (int) pa, "value " + pa + " is outside the range of [32, 127)");
        }
    }
}