/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics;

import java.io.Serializable;

public final class Gradient
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    public static final int GRADIENT_TYPE_DISABLED;
    public static final int GRADIENT_TYPE_LINEAR;
    public static final int GRADIENT_TYPE_CIRCULAR;
    private final int gradientType;
    public static final int CENTER_POSITION_TYPE_RELATIVE_PC;
    public static final int CENTER_POSITION_TYPE_RELATIVE_PX;
    public static final int CENTER_POSITION_TYPE_ABSOLUTE_PX;
    private final int centerPositionType;
    public static final int BLENDMODE_MODULATE;
    public static final int BLENDMODE_REPLACE;
    public static final int BLENDMODE_DECAL;
    public static final int BLENDMODE_BLEND;
    public static final int BLENDMODE_ADD;
    private final int blendMode;
    private final boolean scale;
    private final int centerX;
    private final int centerY;
    private final float rotation;
    private final float[] colorPositions;
    private final float[] colorTransitions;

    public Gradient() {
        this.gradientType = 0;
        this.centerPositionType = 0;
        this.blendMode = 0;
        this.scale = true;
        this.centerX = 0;
        this.centerY = 0;
        this.rotation = 0.0f;
        this.colorPositions = null;
        this.colorTransitions = null;
    }

    public Gradient(int n, int n2, int n3, float f2, float[] fArray, float[] fArray2) {
        this(n, 0, 1, true, n2, n3, f2, fArray, fArray2);
    }

    public Gradient(int n, int n2, int n3, boolean bl, int n4, int n5, float f2, float[] fArray, float[] fArray2) {
        this.gradientType = n;
        this.centerPositionType = n2;
        this.blendMode = n3;
        this.scale = bl;
        this.centerX = n4;
        this.centerY = n5;
        this.rotation = f2;
        this.colorPositions = fArray;
        this.colorTransitions = fArray2;
    }

    public boolean isScale() {
        return this.scale;
    }

    public int getGradientType() {
        return this.gradientType;
    }

    public int getCenterPositionType() {
        return this.centerPositionType;
    }

    public int getBlendMode() {
        return this.blendMode;
    }

    public int getCenterX() {
        return this.centerX;
    }

    public int getCenterY() {
        return this.centerY;
    }

    public float getRotation() {
        return this.rotation;
    }

    public float[] getColorPositions() {
        return this.colorPositions;
    }

    public float[] getColorTransitions() {
        return this.colorTransitions;
    }

    public Object clone() {
        try {
            Gradient gradient = (Gradient)super.clone();
            return gradient;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }
}

