package dev.verzano.monospaced.core.ansi;

// TODO make this a class with something like an apply function, might be faster than String.format()
// TODO then there might be like nullary/unary/binary versions of this
// TODO CUU is unary, CUP is binary, SCU is nullary
public class ControlSequence {
    private ControlSequence() {
    }

    /**
     * Name: Control Sequence Introducer
     * Short Name: CSI
     * Code: <code>ESC [</code>
     * Description: The opening set of characters to ANSI command sequences.
     */
    public static final String CSI = "\u001B[";

    /**
     * Name: Cursor Up
     * Short Name: CUP
     * Code: <code>CSI <i>n</i> A</code>
     * Description: Moves the cursor <i>n</i> (default 1) cells up.
     */
    public static final String CUU = CSI + "%dA";

    /**
     * Name: Cursor Down
     * Short Name: CUD
     * Code: <code>CSI <i>n</i> B</code>
     * Description: Moves the cursor <i>n</i> (default 1) cells down.
     */
    public static final String CUD = CSI + "%dB";

    /**
     * Name: Cursor Forward
     * Short Name: CUF
     * Code: <code>CSI <i>n</i> C</code>
     * Description: Moves the cursor <i>n</i> (default 1) cells forward (right).
     */
    public static final String CUF = CSI + "%dC";

    /**
     * Name: Cursor Down
     * Short Name: CUD
     * Code: <code>CSI <i>n</i> D</code>
     * Description: Moves the cursor <i>n</i> (default 1) cells back (left).
     */
    public static final String CUB = CSI + "%dD";

    /**
     * Name: Cursor Next Line
     * Short Name: CNL
     * Code: <code>CSI <i>n</i> E</code>
     * Description: Moves cursor to beginning of the line <i>n</i> (default 1) lines down.
     */
    public static final String CNL = CSI + "%dE";

    /**
     * Name: Cursor Previous Line
     * Short Name: CPL
     * Code: <code>CSI <i>n</i> F</code>
     * Description: Moves cursor to beginning of the line <i>n</i> (default 1) lines up.
     */
    public static final String CPL = CSI + "%dF";

    /**
     * Name: Cursor Horizontal Absolute
     * Short Name: CHA
     * Code: <code>CSI <i>n</i> G</code>
     * Description: Moves the cursor to column n (default 1).
     */
    public static final String CHA = CSI + "%dG";

    /**
     * Name: Cursor Position
     * Short Name: CUP
     * Code: <code>CSI <i>n</i>;<i>m</i> H</code>
     * Description: Moves the cursor to row <i>n</i>, column <i>m</i>.
     */
    public static final String CUP = CSI + "%d;%dH";

    /**
     * Name: Select Graphic Rendition
     * Short Name: SGR
     * Code: <code>CSI <i>n</i> m</code>
     * Description: Sets the appearance of the following characters.
     */
    public static final String SGR = CSI + "%sm";

    /**
     * Name: Show Cursor
     * Short Name: SCU
     * Code: <code>CSI ? 25 h</code>
     * Description: Shows the cursor
     */
    public static final String SCU = CSI + "?25h";

    /**
     * Name: Hide Cursor
     * Short Name: HCU
     * Code: <code>CSI ? 25 l</code>
     * Description: Hides the cursor
     */
    public static final String HCU = CSI + "?25l";
}
