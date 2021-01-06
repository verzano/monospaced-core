package dev.verzano.monospaced.core.ansi.sgr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SgrFormatTest {
    static Object[][] setNewBackground() {
        return new Object[][]{
                {Background._42, Background._4, true},
                {Background._42, Background._42, false}
        };
    }

    static Object[][] setNewForeground() {
        return new Object[][]{
                {Foreground._42, Foreground._4, true},
                {Foreground._42, Foreground._42, false}
        };
    }

    static Object[][] setNewAttributes() {
        return new Object[][]{
                {new Attribute[]{Attribute.NORMAL}, new Attribute[]{Attribute.NORMAL}, false},
                {new Attribute[]{Attribute.NORMAL}, new Attribute[]{Attribute.BOLD_ON}, true},
                {new Attribute[]{Attribute.NORMAL}, new Attribute[]{Attribute.BOLD_ON, Attribute.UNDERLINE_ON}, true}
        };
    }

    static Object[][] getFormatString() {
        return new Object[][]{
                {Background._120, Foreground._249, new Attribute[]{Attribute.BLINK_ON}, "\u001B[5;38;5;249;48;5;120m"},
                {null, Foreground._249, new Attribute[]{Attribute.BLINK_ON}, "\u001B[5;38;5;249m"},
                {Background._120, null, new Attribute[]{Attribute.BLINK_ON}, "\u001B[5;48;5;120m"},
                {null, null, new Attribute[]{Attribute.BLINK_ON}, "\u001B[5m"},
                {null, null, null, ""},
        };
    }

    static Object[][] attributeSetsEqual() {
        return new Object[][]{
                {Set.of(), Set.of(), true, "Empty sets should not be equal"},
                {Set.of(), Set.of(Attribute.NORMAL), false, "An empty set should not equal a populated set (xs empty)"},
                {Set.of(Attribute.NORMAL), Set.of(), false, "An empty set should not equal a populated set (ys empty)"},
                {Set.of(Attribute.NORMAL), Set.of(Attribute.NORMAL), true, "Identically populated sets should be equal"},
                {Set.of(Attribute.NORMAL), Set.of(Attribute.NONE), false, "Differently populated sets should not be equal"},
                {Set.of(Attribute.NORMAL, Attribute.BLINK_ON), Set.of(Attribute.NORMAL), false, "Differently sized sets should not be equal"},
                {Set.of(Attribute.NORMAL, Attribute.BLINK_ON), Set.of(Attribute.BLINK_ON, Attribute.NORMAL), true, "Identically populated, differently ordered sets should be equal"},
                {Set.of(Attribute.NORMAL, Attribute.BLINK_ON), Set.of(Attribute.NORMAL, Attribute.BLINK_ON), true, "Identically populated, identically ordered sets should be equal"}
        };
    }

    static Object[][] toAttributeSet() {
        return new Object[][]{
                {new Attribute[]{Attribute.BLINK_ON, Attribute.FRAKTUR_ON}, Set.of(Attribute.BLINK_ON, Attribute.FRAKTUR_ON)},
                {new Attribute[]{Attribute.BLINK_ON, null}, Set.of(Attribute.BLINK_ON)},
                {new Attribute[]{Attribute.BLINK_ON}, Set.of(Attribute.BLINK_ON)},
                {new Attribute[]{null, null}, Set.of()},
                {new Attribute[]{null}, Set.of()},
                {null, Set.of()}
        };
    }

    @Test
    void flush() {
        SgrFormat sgrf = new SgrFormat(Background._2, Foreground._3);

        assertTrue(sgrf.isDirty());
        sgrf.flush();
        assertFalse(sgrf.isDirty());
    }

    @Test
    void normalAnsiFormatFormatAttributes() {
        String actual = SgrFormat.normalSgrFormat();
        assertEquals("\u001B[0m", actual);
    }

    @Test
    void setNullBackgroundInConstructor() {
        SgrFormat sgrf = new SgrFormat(null, Foreground._0);

        assertEquals(Background.NONE, sgrf.getBackground());
    }

    @Test
    void setNullBackground() {
        SgrFormat sgrf = new SgrFormat(Background._0, Foreground._0);
        sgrf.setBackground(null);

        assertEquals(Background.NONE, sgrf.getBackground());
    }

    @Test
    void setNullForegroundInConstructor() {
        SgrFormat sgrf = new SgrFormat(Background._0, null);

        assertEquals(Foreground.NONE, sgrf.getForeground());
    }

    @Test
    void setNullForeground() {
        SgrFormat sgrf = new SgrFormat(Background._0, Foreground._0);
        sgrf.setForeground(null);

        assertEquals(Foreground.NONE, sgrf.getForeground());
    }

    @Test
    void setNullSingleAttributeInConstructor() {
        SgrFormat sgrf = new SgrFormat(Background._0, Foreground._0, (Attribute) null);

        assertTrue(sgrf.getAttributes().isEmpty());
    }

    @Test
    void setNullAttributesSetInConstructor() {
        SgrFormat sgrf = new SgrFormat(Background._0, Foreground._0, (Set<Attribute>) null);

        assertTrue(sgrf.getAttributes().isEmpty());
    }

    @Test
    void setNullSingleAttribute() {
        SgrFormat sgrf = new SgrFormat(Background._0, Foreground._0, Attribute.INVERSE_ON);
        sgrf.setAttributes((Attribute) null);

        assertTrue(sgrf.getAttributes().isEmpty());
    }

    @Test
    void setNullAttributesSet() {
        SgrFormat sgrf = new SgrFormat(Background._0, Foreground._0, Attribute.INVERSE_ON);
        sgrf.setAttributes((Set<Attribute>) null);

        assertTrue(sgrf.getAttributes().isEmpty());
    }

    @ParameterizedTest
    @MethodSource("setNewBackground")
    void setNewBackground(Background oldBg, Background newBg, boolean shouldBeDirty) {
        SgrFormat sgrf = new SgrFormat(oldBg, Foreground.NONE);
        sgrf.flush();

        sgrf.setBackground(newBg);

        assertEquals(newBg, sgrf.getBackground());
        assertEquals(shouldBeDirty, sgrf.isDirty());
    }

    @ParameterizedTest
    @MethodSource("setNewForeground")
    void setNewForeground(Foreground oldFg, Foreground newFg, boolean shouldBeDirty) {
        SgrFormat sgrf = new SgrFormat(Background.NONE, oldFg);
        sgrf.flush();

        sgrf.setForeground(newFg);

        assertEquals(newFg, sgrf.getForeground());
        assertEquals(shouldBeDirty, sgrf.isDirty());
    }

    @ParameterizedTest
    @MethodSource("setNewAttributes")
    void setNewAttributesAsArray(Attribute[] oldAttrs, Attribute[] newAttrs, boolean shouldBeDirty) {
        SgrFormat sgrf = new SgrFormat(Background.NONE, Foreground.NONE, oldAttrs);
        sgrf.flush();

        sgrf.setAttributes(newAttrs);

        assertEquals(Set.of(newAttrs), sgrf.getAttributes());
        assertEquals(shouldBeDirty, sgrf.isDirty());
    }

    @ParameterizedTest
    @MethodSource("setNewAttributes")
    void setNewAttributesAsSet(Attribute[] oldAttrs, Attribute[] newAttrs, boolean shouldBeDirty) {
        SgrFormat sgrf = new SgrFormat(Background.NONE, Foreground.NONE, Set.of(oldAttrs));
        sgrf.flush();

        sgrf.setAttributes(Set.of(newAttrs));

        assertEquals(Set.of(newAttrs), sgrf.getAttributes());
        assertEquals(shouldBeDirty, sgrf.isDirty());
    }

    @ParameterizedTest
    @MethodSource("getFormatString")
    void getFormatString(Background bg, Foreground fg, Attribute[] attrs, String expected) {
        SgrFormat sgrf = new SgrFormat(bg, fg, attrs);

        assertTrue(sgrf.isDirty());
        String actual = sgrf.getFormatString();

        assertFalse(sgrf.isDirty());
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("attributeSetsEqual")
    void attributeSetsEqual(Set<Attribute> xs, Set<Attribute> ys, boolean shouldBeEqual, String message) {
        assertEquals(shouldBeEqual, SgrFormat.attributeSetsEqual(xs, ys), message);
    }

    @ParameterizedTest
    @MethodSource("toAttributeSet")
    void toAttributeSet(Attribute[] as, Set<Attribute> expected) {
        assertTrue(SgrFormat.attributeSetsEqual(SgrFormat.toAttributeSet(as), expected));
    }
}
