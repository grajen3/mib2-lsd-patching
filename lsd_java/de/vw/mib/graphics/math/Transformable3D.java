/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.math;

import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Transformable;
import de.vw.mib.graphics.math.algebra.Matrix4f;

public interface Transformable3D
extends Transformable {
    default public void transform(Matrix4f matrix4f) {
    }

    default public void transform(Transform transform) {
    }
}

