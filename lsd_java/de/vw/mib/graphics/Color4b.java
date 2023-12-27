/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.util.StringBuilder;
import java.io.Serializable;

public final class Color4b
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    public static final Color4b WHITE;
    public static final Color4b LIGHT_GRAY;
    public static final Color4b GRAY;
    public static final Color4b DARK_GRAY;
    public static final Color4b BLACK;
    public static final Color4b BLACK_TRANSPARENT;
    public static final Color4b RED;
    public static final Color4b PINK;
    public static final Color4b ORANGE;
    public static final Color4b YELLOW;
    public static final Color4b GREEN;
    public static final Color4b MAGENTA;
    public static final Color4b CYAN;
    public static final Color4b BLUE;
    private static final int CHANNELS;
    private static final int MASK_CLEAR_ALPHA;
    private static final int MASK_CLEAR_RED;
    private static final int MASK_CLEAR_GREEN;
    private static final int MASK_CLEAR_BLUE;
    private int value;

    public Color4b(int n, int n2, int n3) {
        this(n, n2, n3, 255);
    }

    public Color4b(int n, int n2, int n3, int n4) {
        this.value = (n4 & 0xFF) << 24 | (n & 0xFF) << 16 | (n2 & 0xFF) << 8 | n3 & 0xFF;
    }

    public Color4b(int n) {
        this.value = n;
    }

    public Color4b(Color4b color4b) {
        this.value = color4b.value;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public int hashCode() {
        return this.value;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object != null && super.getClass() == object.getClass()) {
            return this.value == ((Color4b)object).value;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[red=0x").append(Integer.toHexString(this.getRed()));
        stringBuilder.append(",green=0x").append(Integer.toHexString(this.getGreen()));
        stringBuilder.append(",blue=0x").append(Integer.toHexString(this.getBlue()));
        stringBuilder.append(",alpha=0x").append(Integer.toHexString(this.getAlpha()));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int getChannels() {
        return 4;
    }

    public int[] get() {
        return new int[]{this.getRed(), this.getGreen(), this.getBlue(), this.getAlpha()};
    }

    public int getRed() {
        return this.value >> 16 & 0xFF;
    }

    public void setRed(int n) {
        this.value = (n & 0xFF) << 16 | this.value & 0xFFFF00FF;
    }

    public int getGreen() {
        return this.value >> 8 & 0xFF;
    }

    public void setGreen(int n) {
        this.value = (n & 0xFF) << 8 | this.value & 0xFF00FFFF;
    }

    public int getBlue() {
        return this.value & 0xFF;
    }

    public void setBlue(int n) {
        this.value = n & 0xFF | this.value & 0xFFFFFF00;
    }

    public int getAlpha() {
        return this.value >> 24 & 0xFF;
    }

    public void setAlpha(int n) {
        this.value = (n & 0xFF) << 24 | this.value & 0xFFFFFF00;
    }

    public int getRGBA() {
        return this.value;
    }

    public void setRGBA(int n) {
        this.value = n;
    }

    public void set(Color4b color4b) {
        if (this != color4b) {
            this.value = color4b.value;
        }
    }

    public boolean hasAlpha() {
        return true;
    }

    public boolean isFullyTransparent() {
        return this.getAlpha() == 0;
    }

    static {
        WHITE = new Color4b(255, 255, 255);
        LIGHT_GRAY = new Color4b(192, 192, 192);
        GRAY = new Color4b(128, 128, 128);
        DARK_GRAY = new Color4b(64, 64, 64);
        BLACK = new Color4b(0, 0, 0);
        BLACK_TRANSPARENT = new Color4b(0, 0, 0, 0);
        RED = new Color4b(255, 0, 0);
        PINK = new Color4b(255, 175, 175);
        ORANGE = new Color4b(255, 200, 0);
        YELLOW = new Color4b(255, 255, 0);
        GREEN = new Color4b(0, 255, 0);
        MAGENTA = new Color4b(255, 0, 255);
        CYAN = new Color4b(0, 255, 255);
        BLUE = new Color4b(0, 0, 255);
    }
}

