/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.image;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.drawable.image.ImageBaseDrawable;

public interface ColorGradientDrawable
extends ImageBaseDrawable {
    default public Color4f getColorStart() {
    }

    default public void setColorStart(Color4f color4f) {
    }

    default public Color4f getColorEnd() {
    }

    default public void setColorEnd(Color4f color4f) {
    }
}

