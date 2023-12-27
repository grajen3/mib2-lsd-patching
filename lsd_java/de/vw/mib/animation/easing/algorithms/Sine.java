/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing.algorithms;

import de.vw.mib.animation.easing.Easing;

public final class Sine
implements Easing {
    @Override
    public float easeIn(float f2, float f3, float f4, float f5) {
        return (float)((double)(-f4) * Math.cos((double)(f2 / f5) * 1.5707963267948966) + (double)f4 + (double)f3);
    }

    @Override
    public float easeInOut(float f2, float f3, float f4, float f5) {
        return (float)((double)(-f4 / 2.0f) * (Math.cos(Math.PI * (double)f2 / (double)f5) - 1.0) + (double)f3);
    }

    @Override
    public float easeOut(float f2, float f3, float f4, float f5) {
        return (float)((double)f4 * Math.sin((double)(f2 / f5) * 1.5707963267948966) + (double)f3);
    }

    @Override
    public float easeOutIn(float f2, float f3, float f4, float f5) {
        if (f2 < f5 / 2.0f) {
            return this.easeOut(f2 * 2.0f, f3, f4 / 2.0f, f5);
        }
        return this.easeIn(f2 * 2.0f - f5, f3 + f4 / 2.0f, f4 / 2.0f, f5);
    }
}

