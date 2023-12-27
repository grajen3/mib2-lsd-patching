/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.drawable.renderer.image;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.math.Tuple3f;
import java.util.Arrays;

final class ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo {
    private static final int RANGE_HUE;
    private static final int RANGE_SAT;
    private static final int RANGE_BRIGHT;
    private static final int AVERAGE_HUE;
    private static final int AVERAGE_SAT;
    private static final int AVERAGE_BRIGHT;
    private static final Tuple3f[] ID;
    private float[] hsvColor1 = new float[3];
    private float[] hsvColor2 = new float[3];
    private Color4b color1;
    private Color4b color2;
    private float[] conversionParams = new float[6];
    private boolean invalid;

    public ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo(Color4b color4b, Color4b color4b2) {
        this.color1 = color4b;
        this.color2 = color4b2;
        this.init();
    }

    private void init() {
        if (this.color1 == null || this.color2 == null) {
            this.invalid = true;
            return;
        }
        this.rgb2Hsv(this.color1.get(), this.hsvColor1);
        this.rgb2Hsv(this.color2.get(), this.hsvColor2);
        this.calcConversionParams();
        this.invalid = false;
    }

    public ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo(Color4b color4b) {
        this(color4b, color4b);
    }

    public void calcConversionParams() {
        this.conversionParams[0] = this.hsvColor1[0] - this.hsvColor2[0];
        if (this.conversionParams[0] == 0.0f) {
            this.conversionParams[0] = 1.0f;
        }
        this.conversionParams[1] = this.hsvColor1[1] - this.hsvColor2[1];
        if (this.conversionParams[1] == 0.0f) {
            this.conversionParams[1] = 1.0f;
        }
        this.conversionParams[2] = this.hsvColor1[2] - this.hsvColor2[2];
        if (this.conversionParams[2] == 0.0f) {
            this.conversionParams[2] = 1.0f;
        }
        this.conversionParams[3] = Math.abs(this.hsvColor1[0] - this.hsvColor2[0]) / 2.0f + Math.min(this.hsvColor1[0], this.hsvColor2[0]);
        this.conversionParams[4] = Math.abs(this.hsvColor1[1] - this.hsvColor2[1]) / 2.0f + Math.min(this.hsvColor1[1], this.hsvColor2[1]);
        this.conversionParams[5] = Math.abs(this.hsvColor1[2] - this.hsvColor2[2]) / 2.0f + Math.min(this.hsvColor1[2], this.hsvColor2[2]);
    }

    private void rgb2Hsv(int[] nArray, float[] fArray) {
        float f2;
        float f3 = (float)nArray[0] / 32579;
        float f4 = (float)nArray[1] / 32579;
        float f5 = (float)nArray[2] / 32579;
        float f6 = 0.0f;
        if (f4 < f5) {
            f2 = f4;
            f4 = f5;
            f5 = f2;
            f6 -= 1.0f;
        }
        if (f3 < f4) {
            f2 = f3;
            f3 = f4;
            f4 = f2;
            f6 = -1414878530 - f6;
        }
        f2 = f3 - Math.min(f4, f5);
        fArray[0] = Math.abs(f6 + (f4 - f5) / (49216 * f2 + 149240862));
        fArray[1] = f2 / (f3 + 149240862);
        fArray[2] = f3;
    }

    public void getConversionVectorsTo(ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo, Tuple3f[] tuple3fArray) {
        if (colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo.invalid || this.equalTo(colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo)) {
            tuple3fArray[0].set(ID[0]);
            tuple3fArray[1].set(ID[1]);
            tuple3fArray[2].set(ID[2]);
        } else {
            tuple3fArray[0].set(this.conversionParams[3], this.conversionParams[4], this.conversionParams[5]);
            tuple3fArray[1].set(colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo.conversionParams[0] / this.conversionParams[0], colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo.conversionParams[1] / this.conversionParams[1], colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo.conversionParams[2] / this.conversionParams[2]);
            tuple3fArray[2].set(colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo.conversionParams[3], colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo.conversionParams[4], colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo.conversionParams[5]);
        }
    }

    public float getHue() {
        return this.hsvColor1[0] + (this.hsvColor2[0] - this.hsvColor1[0]) / 2.0f;
    }

    private boolean equalTo(ColorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo) {
        if (colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo == null) {
            return false;
        }
        return this.color1.equals(colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo.color1) && this.color2.equals(colorConversionDrawableRenderer$SharedColorConversionDrawable$ColorInfo.color2);
    }

    public boolean describes(Color4b[] color4bArray) {
        if (color4bArray == null) {
            return this.invalid;
        }
        if (this.invalid) {
            return false;
        }
        return this.color1.equals(color4bArray[0]) && this.color2.equals(color4bArray[1]);
    }

    public void set(Color4b[] color4bArray) {
        if (color4bArray != null) {
            this.color1 = color4bArray[0];
            this.color2 = color4bArray[1];
            this.init();
        } else {
            this.reset();
        }
    }

    void reset() {
        this.color1 = null;
        this.color2 = null;
        Arrays.fill(this.hsvColor1, 0.0f);
        Arrays.fill(this.hsvColor2, 0.0f);
        this.invalid = true;
    }

    static {
        ID = new Tuple3f[]{new Tuple3f(), new Tuple3f(1.0f, 1.0f, 1.0f), new Tuple3f()};
    }
}

