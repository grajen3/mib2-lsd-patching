/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math.function;

import de.vw.mib.graphics.math.function.curve.Curve;
import de.vw.mib.graphics.math.geometry.Point2f;

public interface Function2f
extends Curve {
    default public void evaluate(float f2, Point2f point2f) {
    }
}

