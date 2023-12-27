/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations.references;

import de.vw.mib.animation.easing.EasingParams;

public interface ValueReferenceMetric
extends Cloneable {
    default public Object clone() {
    }

    default public short getReferenceClass() {
    }

    default public EasingParams getEasing() {
    }

    default public void setEasing(EasingParams easingParams) {
    }

    default public boolean isRelativeValue() {
    }

    default public void setRelativeValue(boolean bl) {
    }
}

