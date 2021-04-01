package dev.verzano.monospaced.core.metric;

import java.util.Objects;

// TODO might not make sense outside the GUI lib
public class Spacing {
    private int top;
    private int right;
    private int bottom;
    private int left;

    public Spacing() {
        this(0, 0, 0, 0);
    }

    public Spacing(int rightLeftTopBottom) {
        this(rightLeftTopBottom, rightLeftTopBottom, rightLeftTopBottom, rightLeftTopBottom);
    }

    public Spacing(int top, int rightLeft, int bottom) {
        this(top, rightLeft, bottom, rightLeft);
    }

    public Spacing(int topBottom, int rightLeft) {
        this(topBottom, rightLeft, topBottom, rightLeft);
    }

    public Spacing(int top, int right, int bottom, int left) {
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Spacing spacing = (Spacing) o;
        return top == spacing.top && right == spacing.right && bottom == spacing.bottom && left == spacing.left;
    }

    @Override
    public int hashCode() {
        return Objects.hash(top, right, bottom, left);
    }

    @Override
    public String toString() {
        return "Spacing{" +
                "top=" + top +
                ", right=" + right +
                ", bottom=" + bottom +
                ", left=" + left +
                '}';
    }
}
