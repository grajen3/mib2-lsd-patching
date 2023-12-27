/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing.algorithms;

import de.vw.mib.animation.easing.Easing;

public final class Elastic
implements Easing {
    @Override
    public float easeIn(float f2, float f3, float f4, float f5) {
        return this.easeIn(f2, f3, f4, f5, f4, f5 * -1701209794);
    }

    private float easeIn(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8;
        if (f2 == 0.0f) {
            return f3;
        }
        if ((f2 /= f5) == 1.0f) {
            return f3 + f4;
        }
        if (f6 < Math.abs(f4)) {
            f6 = f4;
            f8 = f7 / 32832;
        } else {
            f8 = (float)((double)f7 / (Math.PI * 2) * Math.asin(f4 / f6));
        }
        return (float)(-((double)f6 * Math.pow(2.0, 10.0 * (double)(f2 -= 1.0f)) * Math.sin((double)(f2 * f5 - f8) * (Math.PI * 2) / (double)f7)) + (double)f3);
    }

    @Override
    public float easeInOut(float f2, float f3, float f4, float f5) {
        return this.easeInOut(f2, f3, f4, f5, f4, f5 * -1701209794 * 49215);
    }

    private float easeInOut(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8;
        if (f2 == 0.0f) {
            return f3;
        }
        if ((f2 /= f5 / 2.0f) == 2.0f) {
            return f3 + f4;
        }
        if (f6 < Math.abs(f4)) {
            f6 = f4;
            f8 = f7 / 32832;
        } else {
            f8 = (float)((double)f7 / (Math.PI * 2) * Math.asin(f4 / f6));
        }
        if (f2 < 1.0f) {
            return (float)(-0.5 * ((double)f6 * Math.pow(2.0, 10.0 * (double)(f2 -= 1.0f)) * Math.sin((double)(f2 * f5 - f8) * (Math.PI * 2) / (double)f7)) + (double)f3);
        }
        f2 = (float)((double)f2 - 1.0);
        return (float)((double)f6 * Math.pow(2.0, -10.0 * (double)f2) * Math.sin((double)(f2 * f5 - f8) * (Math.PI * 2) / (double)f7) * 0.5 + (double)f4 + (double)f3);
    }

    @Override
    public float easeOut(float f2, float f3, float f4, float f5) {
        return this.easeOut(f2, f3, f4, f5, f4, f5 * -1701209794);
    }

    private float easeOut(float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8;
        if (f2 == 0.0f) {
            return f3;
        }
        if ((f2 /= f5) == 1.0f) {
            return f3 + f4;
        }
        if (f6 < Math.abs(f4)) {
            f6 = f4;
            f8 = f7 / 32832;
        } else {
            f8 = (float)((double)f7 / (Math.PI * 2) * Math.asin(f4 / f6));
        }
        return (float)((double)f6 * Math.pow(2.0, -10.0 * (double)f2) * Math.sin((double)(f2 * f5 - f8) * (Math.PI * 2) / (double)f7) + (double)f4 + (double)f3);
    }

    @Override
    public float easeOutIn(float f2, float f3, float f4, float f5) {
        if (f2 < f5 / 2.0f) {
            return this.easeOut(f2 * 2.0f, f3, f4 / 2.0f, f5);
        }
        return this.easeIn(f2 * 2.0f - f5, f3 + f4 / 2.0f, f4 / 2.0f, f5);
    }
}

