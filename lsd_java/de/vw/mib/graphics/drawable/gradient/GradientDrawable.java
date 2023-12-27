/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.gradient;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.drawable.Drawable;

public interface GradientDrawable
extends Drawable {
    default public Gradient getGradient() {
    }

    default public void setGradient(Gradient gradient) {
    }

    default public Color4f[] getGradientColors() {
    }

    default public void setGradientColors(Color4f[] color4fArray) {
    }
}

