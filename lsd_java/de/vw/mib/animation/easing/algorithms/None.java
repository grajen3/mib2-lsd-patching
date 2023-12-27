/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.easing.algorithms;

import de.vw.mib.animation.easing.Easing;

public final class None
implements Easing {
    @Override
    public float easeIn(float f2, float f3, float f4, float f5) {
        return f3 + f4;
    }

    @Override
    public float easeInOut(float f2, float f3, float f4, float f5) {
        return f3 + f4;
    }

    @Override
    public float easeOut(float f2, float f3, float f4, float f5) {
        return f3 + f4;
    }

    @Override
    public float easeOutIn(float f2, float f3, float f4, float f5) {
        return f3 + f4;
    }
}

