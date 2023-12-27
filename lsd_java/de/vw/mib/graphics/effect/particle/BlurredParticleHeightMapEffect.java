/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.particle;

import de.vw.mib.graphics.effect.particle.BlurredParticleEffect;
import de.vw.mib.graphics.math.Tuple4f;

public interface BlurredParticleHeightMapEffect
extends BlurredParticleEffect {
    default public int getAnimationStartMap1Sampler() {
    }

    default public void setAnimationStartMap1Sampler(int n) {
    }

    default public Tuple4f getAnimationStartMap1Rect() {
    }

    default public void setAnimationStartMap1Rect(Tuple4f tuple4f) {
    }

    default public int getAnimationStartMap2Sampler() {
    }

    default public void setAnimationStartMap2Sampler(int n) {
    }

    default public Tuple4f getAnimationStartMap2Rect() {
    }

    default public void setAnimationStartMap2Rect(Tuple4f tuple4f) {
    }

    default public int getAnimationEndMap1Sampler() {
    }

    default public void setAnimationEndMap1Sampler(int n) {
    }

    default public Tuple4f getAnimationEndMap1Rect() {
    }

    default public void setAnimationEndMap1Rect(Tuple4f tuple4f) {
    }

    default public int getAnimationEndMap2Sampler() {
    }

    default public void setAnimationEndMap2Sampler(int n) {
    }

    default public Tuple4f getAnimationEndMap2Rect() {
    }

    default public void setAnimationEndMap2Rect(Tuple4f tuple4f) {
    }
}

