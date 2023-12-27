/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.gradient;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.gradient.GradientEffect;
import de.vw.mib.graphics.effect.image.ImageCompositionEffect;

public interface WeightedGradientEffect
extends GradientEffect,
ImageCompositionEffect {
    default public Color4f[] getColors() {
    }

    default public void setColors(Color4f[] color4fArray) {
    }

    default public float[] getColorTransitions() {
    }

    default public void setColorTransitions(float[] fArray) {
    }

    default public float[] getColorPositions() {
    }

    default public void setColorPositions(float[] fArray) {
    }
}

