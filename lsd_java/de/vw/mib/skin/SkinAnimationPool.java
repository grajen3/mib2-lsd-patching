/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.skin;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;

public interface SkinAnimationPool {
    default public EasingParams[] getEasingParamsArray(int n) {
    }

    default public KeyframeAnimation[] getKeyframeAnimationArray(int n) {
    }
}

