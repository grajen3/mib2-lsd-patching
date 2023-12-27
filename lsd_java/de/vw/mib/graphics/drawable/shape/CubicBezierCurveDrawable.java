/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.drawable.shape;

import de.vw.mib.graphics.drawable.image.ImageBaseDrawable;
import de.vw.mib.graphics.drawable.shape.CurveDrawable;
import de.vw.mib.graphics.math.geometry.Point2f;

public interface CubicBezierCurveDrawable
extends CurveDrawable,
ImageBaseDrawable {
    default public void getP0(Point2f point2f) {
    }

    default public void setP0(Point2f point2f) {
    }

    default public void getP1(Point2f point2f) {
    }

    default public void setP1(Point2f point2f) {
    }

    default public void getP2(Point2f point2f) {
    }

    default public void setP2(Point2f point2f) {
    }

    default public void getP3(Point2f point2f) {
    }

    default public void setP3(Point2f point2f) {
    }
}

