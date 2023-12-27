/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.image;

import de.vw.mib.graphics.drawable.image.CompositeImageDrawable;
import de.vw.mib.graphics.image.ScaleImage;

public interface ScaleImageDrawable
extends CompositeImageDrawable {
    default public ScaleImage getScaleImage() {
    }

    default public void setScaleImage(ScaleImage scaleImage) {
    }

    default public int getWidth() {
    }

    default public void setWidth(int n) {
    }

    default public int getHeight() {
    }

    default public void setHeight(int n) {
    }
}

