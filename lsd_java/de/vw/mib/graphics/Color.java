/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.collections.HashCodeBuilder;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Color
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    public static final Color WHITE;
    public static final Color LIGHT_GRAY;
    public static final Color GRAY;
    public static final Color DARK_GRAY;
    public static final Color BLACK;
    public static final Color RED;
    public static final Color PINK;
    public static final Color ORANGE;
    public static final Color YELLOW;
    public static final Color GREEN;
    public static final Color MAGENTA;
    public static final Color CYAN;
    public static final Color BLUE;
    private static final boolean DEFAULT_IS_DYNAMIC;
    private static int currentMode;
    private static Color4b globalDynamicColor;
    private static HashCodeBuilder hcb;
    private Color4b dayColor;
    private Color4b nightColor;
    private Color4b dynamicDayColor;
    private Color4b dynamicNightColor;
    private boolean isDynamic;

    public Color(int n) {
        this(new Color4b(n));
    }

    public Color(Color4b color4b) {
        this(color4b, color4b);
    }

    public Color(Color4b color4b, Color4b color4b2) {
        this(color4b, color4b2, Color4b.WHITE, Color4b.WHITE, false);
    }

    public Color(Color4b color4b, Color4b color4b2, Color4b color4b3, Color4b color4b4, boolean bl) {
        this.dayColor = color4b;
        this.nightColor = color4b2;
        this.dynamicDayColor = color4b3;
        this.dynamicNightColor = color4b4;
        this.isDynamic = bl;
    }

    public Color(Color color) {
        this.dayColor = color.dayColor;
        this.nightColor = color.nightColor;
    }

    public Object clone() {
        try {
            Color color = (Color)super.clone();
            color.dayColor = (Color4b)this.dayColor.clone();
            color.nightColor = (Color4b)this.nightColor.clone();
            color.dynamicDayColor = (Color4b)this.dynamicDayColor.clone();
            color.dynamicNightColor = (Color4b)this.dynamicNightColor.clone();
            color.isDynamic = this.isDynamic;
            return color;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public Color4b getDayColor() {
        return this.dayColor;
    }

    public Color4b getNightColor() {
        return this.nightColor;
    }

    public Color4b getDynamicDayColor() {
        return this.dynamicDayColor;
    }

    public Color4b getDynamicNightColor() {
        return this.dynamicNightColor;
    }

    public boolean isDynamic() {
        return this.isDynamic;
    }

    private static Color4b mix(Color4b color4b, Color4b color4b2) {
        return new Color4b(color4b.getRed() * color4b2.getRed() / 255, color4b.getGreen() * color4b2.getGreen() / 255, color4b.getBlue() * color4b2.getBlue() / 255, color4b.getAlpha() * color4b2.getAlpha() / 255);
    }

    public Color4b getCurrentColor() {
        if (this.isDynamic() && globalDynamicColor != null) {
            switch (currentMode) {
                case 0: {
                    return Color.mix(globalDynamicColor, this.getDynamicDayColor());
                }
                case 1: {
                    return Color.mix(globalDynamicColor, this.getDynamicNightColor());
                }
            }
            throw new IllegalArgumentException("Invalid day/night mode");
        }
        switch (currentMode) {
            case 0: {
                return this.getDayColor();
            }
            case 1: {
                return this.getNightColor();
            }
        }
        throw new IllegalArgumentException("Invalid day/night mode");
    }

    public int hashCode() {
        if (hcb == null) {
            hcb = new HashCodeBuilder();
        }
        hcb.reset();
        hcb.append(this.dayColor);
        hcb.append(this.nightColor);
        hcb.append(this.dynamicDayColor);
        hcb.append(this.dynamicNightColor);
        hcb.append(this.isDynamic);
        return hcb.hashCode();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            Color color = (Color)object;
            return this.isDynamic == color.isDynamic && this.dayColor.equals(color.dayColor) && this.nightColor.equals(color.nightColor) && this.dynamicDayColor.equals(color.dynamicDayColor) && this.dynamicNightColor.equals(color.dynamicNightColor);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[dayColor=").append(this.dayColor);
        stringBuilder.append(",nightColor=").append(this.nightColor);
        stringBuilder.append(",dynamicDayColor=").append(this.dynamicDayColor);
        stringBuilder.append(",dynamicNightColor=").append(this.dynamicNightColor);
        stringBuilder.append(",isDynamic=").append(this.isDynamic);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void setDayNightMode(int n) {
        currentMode = n;
    }

    public static void setGlobalDynamicColor(Color4b color4b) {
        globalDynamicColor = color4b;
    }

    static {
        WHITE = new Color(Color4b.WHITE);
        LIGHT_GRAY = new Color(Color4b.LIGHT_GRAY);
        GRAY = new Color(Color4b.GRAY);
        DARK_GRAY = new Color(Color4b.DARK_GRAY);
        BLACK = new Color(Color4b.BLACK);
        RED = new Color(Color4b.RED);
        PINK = new Color(Color4b.PINK);
        ORANGE = new Color(Color4b.ORANGE);
        YELLOW = new Color(Color4b.YELLOW);
        GREEN = new Color(Color4b.GREEN);
        MAGENTA = new Color(Color4b.MAGENTA);
        CYAN = new Color(Color4b.CYAN);
        BLUE = new Color(Color4b.BLUE);
        currentMode = 0;
        globalDynamicColor = null;
    }
}

