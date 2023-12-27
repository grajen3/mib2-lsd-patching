/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math;

import de.vw.mib.graphics.math.Transformable;
import de.vw.mib.graphics.math.algebra.Matrix3f;

public interface Transformable2D
extends Transformable {
    default public void transform(Matrix3f matrix3f) {
    }
}

