/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.gradient;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.gradient.GradientEffect;
import de.vw.mib.graphics.math.Tuple2f;

public interface RadialGradientEffect
extends GradientEffect {
    default public Tuple2f getCenter() {
    }

    default public void setCenter(Tuple2f tuple2f) {
    }

    default public float getInnerRadius() {
    }

    default public void setInnerRadius(float f2) {
    }

    default public float getOuterRadius() {
    }

    default public void setOuterRadius(float f2) {
    }

    default public Color4f getGradientColor() {
    }

    default public void setGradientColor(Color4f color4f) {
    }
}

