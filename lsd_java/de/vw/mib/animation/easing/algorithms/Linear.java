/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing.algorithms;

import de.vw.mib.animation.easing.Easing;

public final class Linear
implements Easing {
    @Override
    public float easeIn(float f2, float f3, float f4, float f5) {
        return f4 * f2 / f5 + f3;
    }

    @Override
    public float easeOut(float f2, float f3, float f4, float f5) {
        return f4 * f2 / f5 + f3;
    }

    @Override
    public float easeInOut(float f2, float f3, float f4, float f5) {
        return f4 * f2 / f5 + f3;
    }

    @Override
    public float easeOutIn(float f2, float f3, float f4, float f5) {
        return f4 * f2 / f5 + f3;
    }
}

