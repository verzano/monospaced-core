package dev.verzano.monospaced.core.ansi;

import dev.verzano.monospaced.core.ansi.ControlSequence.BinaryControlSequence;
import dev.verzano.monospaced.core.ansi.ControlSequence.NullaryControlSequence;
import dev.verzano.monospaced.core.ansi.ControlSequence.UnaryControlSequence;
import dev.verzano.monospaced.core.constant.Keys;

// TODO implement defaults for these somehow...
public final class ControlSequences {
    private ControlSequences() {
    }

    /**
     * <strong>Name:</strong> Control Sequence Introducer<br>
     * <strong>Short Name:</strong> CSI<br>
     * <strong>Code:</strong> <code>ESC [</code><br>
     * <strong>Description:</strong> The opening set of characters to ANSI command sequences.
     */
    public static final String CSI = Keys.ESC + "[";

    /**
     * <strong>Name:</strong> Cursor Up<br>
     * <strong>Short Name:</strong> CUU<br>
     * <strong>Code:</strong> <code>CSI <i>n</i> A</code><br>
     * <strong>Description:</strong> Moves the cursor <i>n</i> (default 1) cells up.
     */
    public static final UnaryControlSequence<Integer> CUU = new UnaryControlSequence<>(CSI + "%dA");

    /**
     * <strong>Name:</strong> Cursor Down<br>
     * <strong>Short Name:</strong> CUD<br>
     * <strong>Code:</strong> <code>CSI <i>n</i> B</code><br>
     * <strong>Description:</strong> Moves the cursor <i>n</i> (default 1) cells down.
     */
    public static final UnaryControlSequence<Integer> CUD = new UnaryControlSequence<>(CSI + "%dB");

    /**
     * <strong>Name:</strong> Cursor Forward<br>
     * <strong>Short Name:</strong> CUF<br>
     * <strong>Code:</strong> <code>CSI <i>n</i> C</code><br>
     * <strong>Description:</strong> Moves the cursor <i>n</i> (default 1) cells forward (right).
     */
    public static final UnaryControlSequence<Integer> CUF = new UnaryControlSequence<>(CSI + "%dC");

    /**
     * <strong>Name:</strong> Cursor Back<br>
     * <strong>Short Name:</strong> CUB<br>
     * <strong>Code:</strong> <code>CSI <i>n</i> D</code><br>
     * <strong>Description:</strong> Moves the cursor <i>n</i> (default 1) cells back (left).
     */
    public static final UnaryControlSequence<Integer> CUB = new UnaryControlSequence<>(CSI + "%dD");

    /**
     * <strong>Name:</strong> Cursor Next Line<br>
     * <strong>Short Name:</strong> CNL<br>
     * <strong>Code:</strong> <code>CSI <i>n</i> E</code><br>
     * <strong>Description:</strong> Moves cursor to beginning of the line <i>n</i> (default 1) lines down.
     */
    public static final UnaryControlSequence<Integer> CNL = new UnaryControlSequence<>(CSI + "%dE");

    /**
     * <strong>Name:</strong> Cursor Previous Line<br>
     * <strong>Short Name:</strong> CPL<br>
     * <strong>Code:</strong> <code>CSI <i>n</i> F</code><br>
     * <strong>Description:</strong> Moves cursor to beginning of the line <i>n</i> (default 1) lines up.
     */
    public static final UnaryControlSequence<Integer> CPL = new UnaryControlSequence<>(CSI + "%dF");

    /**
     * <strong>Name:</strong> Cursor Horizontal Absolute<br>
     * <strong>Short Name:</strong> CHA<br>
     * <strong>Code:</strong> <code>CSI <i>n</i> G</code><br>
     * <strong>Description:</strong> Moves the cursor to column n (default 0).
     */
    public static final UnaryControlSequence<Integer> CHA = new UnaryControlSequence<>(CSI + "%dG");

    /**
     * <strong>Name:</strong> Cursor Position<br>
     * <strong>Short Name:</strong> CUP<br>
     * <strong>Code:</strong> <code>CSI <i>n</i>;<i>m</i> H</code><br>
     * <strong>Description:</strong> Moves the cursor to row <i>n</i>, column <i>m</i> (default 0, 0).
     */
    public static final BinaryControlSequence<Integer, Integer> CUP = new BinaryControlSequence<>(CSI + "%d;%dH");

    /**
     * <strong>Name:</strong> Select Graphic Rendition<br>
     * <strong>Short Name:</strong> SGR<br>
     * <strong>Code:</strong> <code>CSI <i>n</i> m</code><br>
     * <strong>Description:</strong> Sets the appearance of the following characters.
     */
    public static final UnaryControlSequence<String> SGR = new UnaryControlSequence<>(CSI + "%sm");

    /**
     * <strong>Name:</strong> Show Cursor<br>
     * <strong>Short Name:</strong> SCU<br>
     * <strong>Code:</strong> <code>CSI ? 25 h</code><br>
     * <strong>Description:</strong> Shows the cursor
     */
    public static final NullaryControlSequence SCU = new NullaryControlSequence(CSI + "?25h");

    /**
     * <strong>Name:</strong> Hide Cursor<br>
     * <strong>Short Name:</strong> HCU<br>
     * <strong>Code:</strong> <code>CSI ? 25 l</code><br>
     * <strong>Description:</strong> Hides the cursor
     */
    public static final NullaryControlSequence HCU = new NullaryControlSequence(CSI + "?25l");
}
