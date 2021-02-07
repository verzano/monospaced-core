package dev.verzano.monospaced.core.metric;

import java.util.Objects;

public class Spacing {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Spacing() {
        this(0);
    }

    public Spacing(int leftRightTopBottom) {
        this(leftRightTopBottom, leftRightTopBottom);
    }

    public Spacing(int leftRight, int topBottom) {
        this(leftRight, topBottom, leftRight, topBottom);
    }

    public Spacing(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var spacing = (Spacing) o;
        return left == spacing.left && top == spacing.top && right == spacing.right && bottom == spacing.bottom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, top, right, bottom);
    }

    @Override
    public String toString() {
        return "Spacing{" +
                "left=" + left +
                ", top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                '}';
    }
}
