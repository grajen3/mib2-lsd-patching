/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing.algorithms;

import de.vw.mib.animation.easing.Easing;

public final class Exponential
implements Easing {
    @Override
    public float easeIn(float f2, float f3, float f4, float f5) {
        return f2 == 0.0f ? f3 : f4 * (float)Math.pow(2.0, 10.0 * ((double)(f2 / f5) - 1.0)) + f3;
    }

    @Override
    public float easeOut(float f2, float f3, float f4, float f5) {
        return f2 == f5 ? f3 + f4 : f4 * (float)(-Math.pow(2.0, -10.0 * (double)f2 / (double)f5) + 1.0) + f3;
    }

    @Override
    public float easeInOut(float f2, float f3, float f4, float f5) {
        float f6;
        if (f2 == 0.0f) {
            return f3;
        }
        if (f2 == f5) {
            return f3 + f4;
        }
        f2 /= f5 / 2.0f;
        if (f6 < 1.0f) {
            return f4 / 2.0f * (float)Math.pow(2.0, 10.0 * ((double)f2 - 1.0)) + f3;
        }
        return f4 / 2.0f * (float)(-Math.pow(2.0, -10.0 * (double)(f2 -= 1.0f)) + 2.0) + f3;
    }

    @Override
    public float easeOutIn(float f2, float f3, float f4, float f5) {
        if (f2 < f5 / 2.0f) {
            return this.easeOut(f2 * 2.0f, f3, f4 / 2.0f, f5);
        }
        return this.easeIn(f2 * 2.0f - f5, f3 + f4 / 2.0f, f4 / 2.0f, f5);
    }
}

