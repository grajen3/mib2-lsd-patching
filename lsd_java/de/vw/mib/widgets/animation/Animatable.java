/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.animation;

import de.vw.mib.animation.control.AnimatedPropertiesAccessor;

public interface Animatable {
    default public void startKeyframeAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n) {
    }

    default public void stopKeyframeAnimation(int n) {
    }
}

