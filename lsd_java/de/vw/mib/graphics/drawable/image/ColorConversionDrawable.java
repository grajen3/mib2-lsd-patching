/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.image;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.drawable.image.ImageBaseDrawable;

public interface ColorConversionDrawable
extends ImageBaseDrawable {
    default public void setFirstSourceColors(Color4b[] color4bArray) {
    }

    default public void setSecondSourceColors(Color4b[] color4bArray) {
    }

    default public void setFirstDestinationColors(Color4b[] color4bArray) {
    }

    default public void setSecondDestinationColors(Color4b[] color4bArray) {
    }
}

