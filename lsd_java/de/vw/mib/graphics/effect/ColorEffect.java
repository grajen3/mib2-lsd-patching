/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.effect.TransformationEffect;

public interface ColorEffect
extends TransformationEffect {
    default public Color4f getColor() {
    }

    default public void setColor(Color4f color4f) {
    }
}

