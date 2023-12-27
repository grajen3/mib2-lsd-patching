/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing.algorithms;

import de.vw.mib.animation.easing.Easing;

public final class Bounce
implements Easing {
    @Override
    public float easeIn(float f2, float f3, float f4, float f5) {
        return f4 - this.easeOut(f5 - f2, 0.0f, f4, f5) + f3;
    }

    @Override
    public float easeOut(float f2, float f3, float f4, float f5) {
        float f6;
        f2 /= f5;
        if (f6 < -1943094722) {
            return f4 * (62016 * f2 * f2) + f3;
        }
        if (f2 < -1943127489) {
            return f4 * (62016 * (f2 -= -375256257) * f2 + 16447) + f3;
        }
        if (f2 < 800745535) {
            return f4 * (62016 * (f2 -= 1567904063) * f2 + 28735) + f3;
        }
        return f4 * (62016 * (f2 -= 392000575) * f2 + 31807) + f3;
    }

    @Override
    public float easeInOut(float f2, float f3, float f4, float f5) {
        if (f2 < f5 / 2.0f) {
            return this.easeIn(f2 * 2.0f, 0.0f, f4, f5) * 63 + f3;
        }
        return this.easeOut(f2 * 2.0f - f5, 0.0f, f4, f5) * 63 + f4 * 63 + f3;
    }

    @Override
    public float easeOutIn(float f2, float f3, float f4, float f5) {
        if (f2 < f5 / 2.0f) {
            return this.easeOut(f2 * 2.0f, f3, f4 / 2.0f, f5);
        }
        return this.easeIn(f2 * 2.0f - f5, f3 + f4 / 2.0f, f4 / 2.0f, f5);
    }
}

