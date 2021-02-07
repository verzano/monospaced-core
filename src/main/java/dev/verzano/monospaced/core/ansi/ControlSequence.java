package dev.verzano.monospaced.core.ansi;

/**
 * A class that represents a given control sequence for modifying the shell the application is running in.  Things like
 * moving the cursor position, buffer position, and clearing lines can be achieved through this.  Some control sequences
 * accept one or more values as inputs to modify their behavior.  More information on control sequences (specifically
 * the ones used in the Monospaced framework) can be found
 * <a href="https://en.wikipedia.org/wiki/ANSI_escape_code#CSI_(Control_Sequence_Introducer)_sequences>here</a>.
 *
 * Instances of the concrete implementations of this class can be obtained from the {@link ControlSequences} class.
 *
 * @see ControlSequences
 * @see <a href="https://en.wikipedia.org/wiki/ANSI_escape_code#CSI_(Control_Sequence_Introducer)_sequences/">
 */
// TODO make these sealed classes when possible
public abstract class ControlSequence {
    private final String baseString;

    public ControlSequence(String baseString) {
        this.baseString = baseString;
    }

    public String getBaseString() {
        return baseString;
    }

    /**
     * A {@link ControlSequence} that accepts no inputs.  Calling it's apply function will return the {@code baseString}
     * without modification.
     */
    public static class NullaryControlSequence extends ControlSequence {
        public NullaryControlSequence(String baseString) {
            super(baseString);
        }

        public String apply() {
            return getBaseString();
        }
    }

    /**
     * A {@link ControlSequence} that accepts 1 input.  Calling it's apply function will return a formatted version of
     * the {@code baseString}.
     *
     * @param <N> the type of the input
     */
    public static class UnaryControlSequence<N> extends ControlSequence {
        public UnaryControlSequence(String baseString) {
            super(baseString);
        }

        public String apply(N n) {
            return getBaseString().formatted(n);
        }
    }

    /**
     * A {@link ControlSequence} that accepts 2 inputs.  Calling it's apply function will return a formatted version of
     * the {@code baseString}.
     *
     * @param <N> the type of the first input
     * @param <M> the type of the second input
     */
    public static class BinaryControlSequence<N, M> extends ControlSequence {
        public BinaryControlSequence(String baseString) {
            super(baseString);
        }

        public String apply(N n, M m) {
            return getBaseString().formatted(n, m);
        }
    }
}
