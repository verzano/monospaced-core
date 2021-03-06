package dev.verzano.monospaced.core.ansi.sgr;

import java.util.Set;

public enum Attribute {
    NONE(""),
    NORMAL("0"),
    BOLD_ON("1"),
    ITALICS_ON("3"),
    UNDERLINE_ON("4"),
    BLINK_ON("5"),
    INVERSE_ON("7"),
    INVISIBLE_ON("8"),
    STRIKETHROUGH_ON("9"),
    FRAKTUR_ON("20"),
    BOLD_OFF("22"),
    ITALICS_OFF("23"),
    UNDERLINE_OFF("24"),
    BLINK_OFF("25"),
    INVERSE_OFF("27"),
    INVISIBLE_OFF("28"),
    STRIKETHROUGH_OFF("29");

    private final String code;

    Attribute(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}