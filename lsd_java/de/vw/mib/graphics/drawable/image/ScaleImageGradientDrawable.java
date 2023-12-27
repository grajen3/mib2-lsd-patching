/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.image;

import de.vw.mib.graphics.drawable.gradient.GradientDrawable;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;

public interface ScaleImageGradientDrawable
extends ScaleImageDrawable,
GradientDrawable {
    default public void setAbsolutePosition(int n, int n2) {
    }

    default public void setReferenceAreaSize(int n, int n2) {
    }
}

