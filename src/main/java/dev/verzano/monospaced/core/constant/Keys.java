package dev.verzano.monospaced.core.constant;

import static java.util.stream.Collectors.toUnmodifiableSet;

import java.util.Set;
import java.util.stream.IntStream;

// TODO something with extended ASCII or Unicode...
// TODO it is tricky though as Unicode is massive and extended ASCII depends on who extended it
public class Keys {
    private Keys() {
    }

    private static Set<Character> printableAscii;

    public static Set<Character> printableAscii() {
        if (printableAscii == null) {
            printableAscii = IntStream.range(32, 127)
                    .mapToObj(i -> (char) i)
                    .collect(toUnmodifiableSet());
        }

        return printableAscii;
    }

    // Control Keys
    public static final char ESC = '\u001B';
    public static final char BACKSPACE = '\u0008';
    public static final char DELETE = '\u007F';

    // Arrow Keys
    public static final String UP_ARROW = ESC + "[A";
    public static final String DOWN_ARROW = ESC + "[B";
    public static final String RIGHT_ARROW = ESC + "[C";
    public static final String LEFT_ARROW = ESC + "[D";

    // Whitespace Keys
    public static final char SPACE = ' ';
    public static final char TAB = '\u0009';
    public static final char ENTER = '\r';

    // Letter Keys
    public static final char A_LOWER = 'a';
    public static final char B_LOWER = 'b';
    public static final char C_LOWER = 'c';
    public static final char D_LOWER = 'd';
    public static final char E_LOWER = 'e';
    public static final char F_LOWER = 'f';
    public static final char G_LOWER = 'g';
    public static final char H_LOWER = 'h';
    public static final char I_LOWER = 'i';
    public static final char J_LOWER = 'j';
    public static final char K_LOWER = 'k';
    public static final char L_LOWER = 'l';
    public static final char M_LOWER = 'm';
    public static final char N_LOWER = 'n';
    public static final char O_LOWER = 'o';
    public static final char P_LOWER = 'p';
    public static final char Q_LOWER = 'q';
    public static final char R_LOWER = 'r';
    public static final char S_LOWER = 's';
    public static final char T_LOWER = 't';
    public static final char U_LOWER = 'u';
    public static final char V_LOWER = 'v';
    public static final char W_LOWER = 'w';
    public static final char X_LOWER = 'x';
    public static final char Y_LOWER = 'y';
    public static final char Z_LOWER = 'z';
    public static final char A_UPPER = 'A';
    public static final char B_UPPER = 'B';
    public static final char C_UPPER = 'C';
    public static final char D_UPPER = 'D';
    public static final char E_UPPER = 'E';
    public static final char F_UPPER = 'F';
    public static final char G_UPPER = 'G';
    public static final char H_UPPER = 'H';
    public static final char I_UPPER = 'I';
    public static final char J_UPPER = 'J';
    public static final char K_UPPER = 'K';
    public static final char L_UPPER = 'L';
    public static final char M_UPPER = 'M';
    public static final char N_UPPER = 'N';
    public static final char O_UPPER = 'O';
    public static final char P_UPPER = 'P';
    public static final char Q_UPPER = 'Q';
    public static final char R_UPPER = 'R';
    public static final char S_UPPER = 'S';
    public static final char T_UPPER = 'T';
    public static final char U_UPPER = 'U';
    public static final char V_UPPER = 'V';
    public static final char W_UPPER = 'W';
    public static final char X_UPPER = 'X';
    public static final char Y_UPPER = 'Y';
    public static final char Z_UPPER = 'Z';
}
