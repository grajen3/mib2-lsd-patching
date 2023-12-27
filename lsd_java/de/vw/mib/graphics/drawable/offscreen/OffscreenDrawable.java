/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.offscreen;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;

public interface OffscreenDrawable
extends Drawable {
    default public void setX(int n) {
    }

    default public void setY(int n) {
    }

    default public int getWidth() {
    }

    default public int getHeight() {
    }

    default public boolean isValid() {
    }

    default public boolean isMaintainPerspective() {
    }

    default public void setFilterParams(float[] fArray, int n, int n2, boolean bl, Color4f color4f) {
    }

    default public void prepareGraphics(Graphics3D graphics3D, Rectangle rectangle, int n) {
    }

    default public void prepareGraphics(Graphics3D graphics3D, Rectangle rectangle, int n, Color4f color4f) {
    }

    default public void restoreGraphics(Graphics3D graphics3D, Rectangle rectangle) {
    }
}

