/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.image;

import de.vw.mib.graphics.drawable.image.ImageBlendingDrawable;
import de.vw.mib.graphics.drawable.image.ImageTransformationDrawable;
import de.vw.mib.graphics.image.BufferImage;

public interface CompositeImageDrawable
extends ImageBlendingDrawable,
ImageTransformationDrawable {
    public static final int IMAGE_LAYER_0;
    public static final int IMAGE_LAYER_1;
    public static final int IMAGE_LAYER_COUNT;

    default public void setImage(int n, BufferImage bufferImage) {
    }

    default public BufferImage getImage(int n) {
    }
}

