package dev.verzano.monospaced.core.ansi;

public abstract class ControlSequence {
    private final String baseString;

    public ControlSequence(String baseString) {
        this.baseString = baseString;
    }

    public String getBaseString() {
        return baseString;
    }

    public static class NullaryControlSequence extends ControlSequence {
        public NullaryControlSequence(String baseString) {
            super(baseString);
        }

        public String apply() {
            return getBaseString();
        }
    }

    public static class UnaryControlSequence<N> extends ControlSequence {
        public UnaryControlSequence(String baseString) {
            super(baseString);
        }

        public String apply(N n) {
            return getBaseString().formatted(n);
        }
    }

    public static class BinaryControlSequence<N, M> extends ControlSequence {
        public BinaryControlSequence(String baseString) {
            super(baseString);
        }

        public String apply(N n, M m) {
            return getBaseString().formatted(n, m);
        }
    }
}
