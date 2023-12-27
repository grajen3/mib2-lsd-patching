/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.image;

import de.vw.mib.graphics.drawable.shape.RectangularShapeDrawable;
import de.vw.mib.graphics.image.BufferImage;

public interface ImageBaseDrawable
extends RectangularShapeDrawable {
    public static final int IMAGE_FILTER_NEAREST;
    public static final int IMAGE_FILTER_LINEAR;

    default public BufferImage getImage() {
    }

    default public void setImage(BufferImage bufferImage) {
    }

    default public int getImageFilter() {
    }

    default public void setImageFilter(int n) {
    }
}

