/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.properties.values;

public final class LayoutAttribs
implements Cloneable {
    public static final int DEFAULT_GAP;
    public static final int DEFAULT_INSETS;
    public static final int LAYOUT_ORIENTATION_FIT_TO_PARENT;
    public static final int LAYOUT_ORIENTATION_HORIZONTAL;
    public static final int LAYOUT_ORIENTATION_HORIZONTAL_RTL;
    public static final int LAYOUT_ORIENTATION_HORIZONTAL_WRAP;
    public static final int LAYOUT_ORIENTATION_HORIZONTAL_WRAP_RTL;
    public static final int LAYOUT_ORIENTATION_NONE;
    public static final int LAYOUT_ORIENTATION_VERTICAL;
    public static final int LAYOUT_ORIENTATION_VERTICAL_BTT;
    public static final int WIDGET_ALIGNMENT_CENTER;
    public static final int WIDGET_ALIGNMENT_FILL;
    public static final int WIDGET_ALIGNMENT_LEADING;
    public static final int WIDGET_ALIGNMENT_NONE;
    public static final int WIDGET_ALIGNMENT_TRAILING;
    private final int gap;
    private final int insetBottom;
    private final int insetLeft;
    private final int insetRight;
    private final int insetTop;
    private final int layoutOrientation;
    private final int widgetHorAlignment;
    private final int[] widgetSizes;
    private final int widgetVerAlignment;

    public LayoutAttribs() {
        this(-1, 1, 1, 0, 0, 0, 0, 0, new int[0]);
    }

    public LayoutAttribs(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int[] nArray) {
        this.layoutOrientation = n;
        this.widgetVerAlignment = n3;
        this.widgetHorAlignment = n2;
        this.insetLeft = n4;
        this.insetRight = n5;
        this.insetTop = n6;
        this.insetBottom = n7;
        this.gap = n8;
        this.widgetSizes = nArray;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int getGap() {
        return this.gap;
    }

    public int getInsetBottom() {
        return this.insetBottom;
    }

    public int getInsetLeft() {
        return this.insetLeft;
    }

    public int getInsetRight() {
        return this.insetRight;
    }

    public int getInsetTop() {
        return this.insetTop;
    }

    public int getLayoutOrientation() {
        return this.layoutOrientation;
    }

    public int getRawWidgetSizeValue(int n) {
        return this.widgetSizes[n];
    }

    public int getWidgetHorAlignment() {
        return this.widgetHorAlignment;
    }

    public int getWidgetSizesCount() {
        return this.widgetSizes == null ? 0 : this.widgetSizes.length;
    }

    public int getWidgetSizeValue(int n) {
        return Math.abs(this.widgetSizes[n]);
    }

    public int getWidgetVerAlignment() {
        return this.widgetVerAlignment;
    }

    public boolean isWidgetSizeRelative(int n) {
        return this.widgetSizes[n] < 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("layoutOrientation:    ").append(this.layoutOrientation).append("\n");
        stringBuffer.append("widgetVerAlignment:   ").append(this.widgetVerAlignment).append("\n");
        stringBuffer.append("widgetHorAlignment:   ").append(this.widgetHorAlignment).append("\n");
        stringBuffer.append("insetLeft:            ").append(this.insetLeft).append("\n");
        stringBuffer.append("insetRight:           ").append(this.insetRight).append("\n");
        stringBuffer.append("insetTop:             ").append(this.insetTop).append("\n");
        stringBuffer.append("insetBottom:          ").append(this.insetBottom).append("\n");
        stringBuffer.append("gap:                  ").append(this.gap).append("\n");
        stringBuffer.append("widgetSizes:").append("\n");
        for (int i2 = 0; i2 < this.widgetSizes.length; ++i2) {
            stringBuffer.append("  ").append(i2).append(":  ").append(this.widgetSizes[i2]).append("\n");
        }
        return stringBuffer.toString();
    }
}

