/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.image.filter.convolution;

import de.vw.mib.graphics.effect.image.filter.ImageFilterEffect;

public interface ConvolutionFilterEffect
extends ImageFilterEffect {
    default public boolean getAlphaOnly() {
    }

    default public void setAlphaOnly(boolean bl) {
    }

    default public float[] getKernel() {
    }

    default public void setKernel(float[] fArray) {
    }

    default public void setTexelSize(float f2, float f3) {
    }
}

