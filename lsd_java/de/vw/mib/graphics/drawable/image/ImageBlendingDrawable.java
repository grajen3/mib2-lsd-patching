/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.image;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.drawable.image.ImageBaseDrawable;

public interface ImageBlendingDrawable
extends ImageBaseDrawable {
    public static final int IMAGE_BLEND_MODULATE;
    public static final int IMAGE_BLEND_REPLACE;
    public static final int IMAGE_BLEND_DECAL;
    public static final int IMAGE_BLEND_BLEND;
    public static final int IMAGE_BLEND_ADD;

    default public int getImageBlending() {
    }

    default public void setImageBlending(int n) {
    }

    default public Color4f getImageBlendingColor() {
    }

    default public void setImageBlendingColor(Color4f color4f) {
    }
}

