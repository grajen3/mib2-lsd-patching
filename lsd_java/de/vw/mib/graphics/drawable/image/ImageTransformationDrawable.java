/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.image;

import de.vw.mib.graphics.drawable.image.ImageBaseDrawable;
import de.vw.mib.graphics.math.algebra.Matrix4f;

public interface ImageTransformationDrawable
extends ImageBaseDrawable {
    default public Matrix4f getImageTransformation() {
    }

    default public void setImageTransformation(Matrix4f matrix4f) {
    }
}

