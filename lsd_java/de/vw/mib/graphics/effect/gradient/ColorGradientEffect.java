/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.gradient;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.gradient.LinearGradientEffect;
import de.vw.mib.graphics.effect.image.ImageEffect;

public interface ColorGradientEffect
extends LinearGradientEffect,
ImageEffect {
    default public Color4f getColorStart() {
    }

    default public void setColorStart(Color4f color4f) {
    }

    default public Color4f getEndColor() {
    }

    default public void setColorEnd(Color4f color4f) {
    }
}

