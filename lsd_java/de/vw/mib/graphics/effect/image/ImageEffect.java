/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.image;

import de.vw.mib.graphics.effect.ColorEffect;

public interface ImageEffect
extends ColorEffect {
    default public int getImageSampler() {
    }

    default public void setImageSampler(int n) {
    }
}

