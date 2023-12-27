/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.particle;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.math.Tuple4f;

public interface ParticleHeightMapDrawable
extends Drawable {
    default public BufferImage getAnimationStartMap1() {
    }

    default public void setAnimationStartMap1(BufferImage bufferImage) {
    }

    default public BufferImage getAnimationStartMap2() {
    }

    default public void setAnimationStartMap2(BufferImage bufferImage) {
    }

    default public BufferImage getAnimationEndMap1() {
    }

    default public void setAnimationEndMap1(BufferImage bufferImage) {
    }

    default public BufferImage getAnimationEndMap2() {
    }

    default public void setAnimationEndMap2(BufferImage bufferImage) {
    }

    default public Tuple4f[] getAttributeStartValues() {
    }

    default public void setAttributeStartValues(Tuple4f[] tuple4fArray) {
    }

    default public Tuple4f[] getAttributeEndValues() {
    }

    default public void setAttributeEndValues(Tuple4f[] tuple4fArray) {
    }

    default public Tuple4f[] getAttributeAnimationValues() {
    }

    default public void setAttributeAnimationValues(Tuple4f[] tuple4fArray) {
    }

    default public Color4f getTintColor() {
    }

    default public void setTintColor(Color4f color4f) {
    }
}

