package dev.verzano.monospaced.core.ansi.sgr;

import dev.verzano.monospaced.core.ansi.ControlSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SgrFormat {

    private Background background;
    private Foreground foreground;
    private Set<Attribute> attributes;
    private boolean dirty = true;
    private String formatString;

    public SgrFormat(Background background, Foreground foreground) {
        this(background, foreground, new HashSet<>());
    }

    public SgrFormat(Background background, Foreground foreground, Attribute... attributes) {
        this(background, foreground, toAttributeSet(attributes));
    }

    public SgrFormat(Background background, Foreground foreground, Set<Attribute> attributes) {
        this.background = background == null ? Background.NONE : background;
        this.foreground = foreground == null ? Foreground.NONE : foreground;
        this.attributes = attributes == null ? new HashSet<>() : attributes;
    }

    public static SgrFormat normalSgrFormat() {
        return new SgrFormat(Background.NONE, Foreground.NONE, Attribute.NORMAL);
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        background = background == null ? Background.NONE : background;
        if (this.background != background) {
            this.background = background;
            dirty = true;
        }
    }

    public Foreground getForeground() {
        return foreground;
    }

    public void setForeground(Foreground foreground) {
        foreground = foreground == null ? Foreground.NONE : foreground;
        if (this.foreground != foreground) {
            this.foreground = foreground;
            dirty = true;
        }
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Attribute... attributes) {
        setAttributes(toAttributeSet(attributes));
    }

    public void setAttributes(Set<Attribute> attributes) {
        attributes = attributes == null ? new HashSet<>() : attributes;
        if (!attributeSetsEqual(this.attributes, attributes)) {
            this.attributes = attributes;
            dirty = true;
        }
    }

    public boolean isDirty() {
        return dirty;
    }

    public String getFormatString() {
        flush();
        return formatString;
    }

    public void flush() {
        if (dirty) {
            Set<Attribute> cleanAttributes = attributes.stream()
                    .filter(a -> a != Attribute.NONE)
                    .collect(Collectors.toSet());

            if (cleanAttributes.isEmpty() && foreground == Foreground.NONE && background == Background.NONE) {
                formatString = "";
            } else {
                var parameters = "";
                var hasOne = false;
                if (!cleanAttributes.isEmpty()) {
                    parameters += cleanAttributes.stream()
                            .map(Attribute::getCode)
                            .reduce((a, b) -> a + ";" + b)
                            .orElse("0");
                    hasOne = true;
                }

                if (foreground != Foreground.NONE) {
                    parameters += (hasOne ? ";" : "") + foreground.getCode();
                    hasOne = true;
                }

                if (background != Background.NONE) {
                    parameters += (hasOne ? ";" : "") + background.getCode();
                }

                formatString = ControlSequence.SGR.formatted(parameters);
            }

            dirty = false;
        }
    }

    static boolean attributeSetsEqual(Set<Attribute> set1, Set<Attribute> set2) {
        return !(set1 == null || set2 == null) && set1.size() == set2.size() && set1.containsAll(set2);
    }

    static Set<Attribute> toAttributeSet(Attribute[] attributes) {
        return attributes == null
                ? new HashSet<>()
                : Arrays.stream(attributes).filter(Objects::nonNull).collect(Collectors.toSet());
    }
}
