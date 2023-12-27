/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing.algorithms;

import de.vw.mib.animation.easing.Easing;

public final class Cubic
implements Easing {
    @Override
    public float easeIn(float f2, float f3, float f4, float f5) {
        return f4 * (f2 /= f5) * f2 * f2 + f3;
    }

    @Override
    public float easeInOut(float f2, float f3, float f4, float f5) {
        float f6;
        f2 /= f5 / 2.0f;
        if (f6 < 1.0f) {
            return f4 / 2.0f * f2 * f2 * f2 + f3;
        }
        return f4 / 2.0f * ((f2 -= 2.0f) * f2 * f2 + 2.0f) + f3;
    }

    @Override
    public float easeOut(float f2, float f3, float f4, float f5) {
        f2 = f2 / f5 - 1.0f;
        return f4 * (f2 * f2 * f2 + 1.0f) + f3;
    }

    @Override
    public float easeOutIn(float f2, float f3, float f4, float f5) {
        if (f2 < f5 / 2.0f) {
            return this.easeOut(f2 * 2.0f, f3, f4 / 2.0f, f5);
        }
        return this.easeIn(f2 * 2.0f - f5, f3 + f4 / 2.0f, f4 / 2.0f, f5);
    }
}

