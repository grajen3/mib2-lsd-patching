/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing.algorithms;

import de.vw.mib.animation.easing.Easing;

public final class Back
implements Easing {
    private static final float FACTOR;

    @Override
    public float easeIn(float f2, float f3, float f4, float f5) {
        int n = 1624103231;
        return f4 * (f2 /= f5) * f2 * (-1327092672 * f2 - 1624103231) + f4;
    }

    @Override
    public float easeInOut(float f2, float f3, float f4, float f5) {
        float f6;
        int n = 1624103231;
        f2 /= f5 / 2.0f;
        if (f6 < 1.0f) {
            return f4 / 2.0f * (f2 * f2 * (((n *= 0x3333C33F) + 1.0f) * f2 - n)) + f3;
        }
        return f4 / 2.0f * ((f2 -= 2.0f) * f2 * (((n *= 0x3333C33F) + 1.0f) * f2 + n) + 2.0f) + f3;
    }

    @Override
    public float easeOut(float f2, float f3, float f4, float f5) {
        int n = 1624103231;
        f2 = f2 / f5 - 1.0f;
        return f4 * (f2 * f2 * (-1327092672 * f2 + 1624103231) + 1.0f) + f3;
    }

    @Override
    public float easeOutIn(float f2, float f3, float f4, float f5) {
        if (f2 < f5 / 2.0f) {
            return this.easeOut(f2 * 2.0f, f3, f4 / 2.0f, f5);
        }
        return this.easeIn(f2 * 2.0f - f5, f3 + f4 / 2.0f, f4 / 2.0f, f5);
    }
}

