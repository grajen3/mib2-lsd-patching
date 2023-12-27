/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect.image;

import de.vw.mib.graphics.effect.image.ImageEffect;
import de.vw.mib.graphics.math.algebra.Matrix4f;

public interface ImageTransformationEffect
extends ImageEffect {
    default public Matrix4f getImageTransformation() {
    }

    default public void setImageTransformation(Matrix4f matrix4f) {
    }
}

