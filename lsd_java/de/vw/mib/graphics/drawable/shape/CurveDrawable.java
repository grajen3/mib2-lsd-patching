/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.shape;

import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.LineDrawable;
import de.vw.mib.graphics.drawable.shape.RectangularShapeDrawable;

public interface CurveDrawable
extends RectangularShapeDrawable,
LineDrawable {
    default public void getBounds(Rectangle rectangle) {
    }

    default public void setBounds(Rectangle rectangle) {
    }
}

