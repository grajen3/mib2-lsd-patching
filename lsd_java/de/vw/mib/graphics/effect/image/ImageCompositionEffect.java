/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.image;

import de.vw.mib.graphics.effect.image.ImageBlendingEffect;
import de.vw.mib.graphics.effect.image.ImageTransformationEffect;

public interface ImageCompositionEffect
extends ImageBlendingEffect,
ImageTransformationEffect {
    public static final int INVALID_SAMPLER;

    default public int getMaximumImageLayerCount() {
    }

    default public int getImageSampler(int n) {
    }

    default public void setImageSampler(int n, int n2) {
    }
}

