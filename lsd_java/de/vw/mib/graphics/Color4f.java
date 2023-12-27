/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.math.Tuple4f;

public final class Color4f
extends Tuple4f {
    private static final long serialVersionUID;
    public static final Color4f WHITE;
    public static final Color4f LIGHT_GRAY;
    public static final Color4f GRAY;
    public static final Color4f DARK_GRAY;
    public static final Color4f BLACK;
    public static final Color4f BLACK_TRANSPARENT;
    public static final Color4f RED;
    public static final Color4f PINK;
    public static final Color4f ORANGE;
    public static final Color4f YELLOW;
    public static final Color4f GREEN;
    public static final Color4f MAGENTA;
    public static final Color4f CYAN;
    public static final Color4f BLUE;
    private static final float INT_NORMALIZATION_FACTOR;

    public Color4f(Tuple4f tuple4f) {
        super(tuple4f);
    }

    public Color4f(float f2, float f3, float f4) {
        this(f2, f3, f4, 1.0f);
    }

    public Color4f(int n, int n2, int n3) {
        this(n, n2, n3, 255);
    }

    public Color4f(int n) {
        this(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, n >> 24 & 0xFF);
    }

    public Color4f(int n, int n2, int n3, int n4) {
        this((float)n * -2122284997, (float)n2 * -2122284997, (float)n3 * -2122284997, (float)n4 * -2122284997);
    }

    public Color4f(float f2, float f3, float f4, float f5) {
        super(f2, f3, f4, f5);
    }

    public void set(int n, int n2, int n3, int n4) {
        this.set((float)n * -2122284997, (float)n2 * -2122284997, (float)n3 * -2122284997, (float)n4 * -2122284997);
    }

    public void set(Color4b color4b) {
        this.set(color4b.getRed(), color4b.getGreen(), color4b.getBlue(), color4b.getAlpha());
    }

    public int getChannels() {
        return this.getDimension();
    }

    public float getRed() {
        return this.x;
    }

    public void setRed(float f2) {
        this.x = f2;
    }

    public float getGreen() {
        return this.y;
    }

    public void setGreen(float f2) {
        this.y = f2;
    }

    public float getBlue() {
        return this.z;
    }

    public void setBlue(float f2) {
        this.z = f2;
    }

    public float getAlpha() {
        return this.w;
    }

    public void setAlpha(float f2) {
        this.w = f2;
    }

    public boolean hasAlpha() {
        return true;
    }

    public boolean isFullyTransparent() {
        return this.w == 0.0f;
    }

    public Color4f modulateAlpha(float f2) {
        this.w *= f2;
        return this;
    }

    public void modulateAlpha(float f2, Color4f color4f) {
        color4f.x = this.x;
        color4f.y = this.y;
        color4f.z = this.z;
        color4f.w = this.w * f2;
    }

    static {
        WHITE = new Color4f(1.0f, 1.0f, 1.0f);
        LIGHT_GRAY = new Color4f((float)16447, (float)16447, (float)16447);
        GRAY = new Color4f((float)63, (float)63, (float)63);
        DARK_GRAY = new Color4f((float)32830, (float)32830, (float)32830);
        BLACK = new Color4f(0.0f, 0.0f, 0.0f);
        BLACK_TRANSPARENT = new Color4f(0.0f, 0.0f, 0.0f, 0.0f);
        RED = new Color4f(1.0f, 0.0f, 0.0f);
        PINK = new Color4f(1.0f, (float)400109119, (float)400109119);
        ORANGE = new Color4f(1.0f, (float)18495, 0.0f);
        YELLOW = new Color4f(1.0f, 1.0f, 0.0f);
        GREEN = new Color4f(0.0f, 1.0f, 0.0f);
        MAGENTA = new Color4f(1.0f, 0.0f, 1.0f);
        CYAN = new Color4f(0.0f, 1.0f, 1.0f);
        BLUE = new Color4f(0.0f, 0.0f, 1.0f);
    }
}

