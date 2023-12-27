/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Resource;

public interface Drawable
extends Resource {
    default public Color4f getColor() {
    }

    default public void setColor(Color4b color4b) {
    }

    default public void setColor(Color4f color4f) {
    }

    default public float getAlpha() {
    }

    default public void setAlpha(float f2) {
    }

    default public void draw() {
    }

    default public void draw(float f2, float f3) {
    }
}

