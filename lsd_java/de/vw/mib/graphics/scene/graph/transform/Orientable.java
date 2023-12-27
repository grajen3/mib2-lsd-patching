/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.scene.graph.transform;

import de.vw.mib.graphics.math.algebra.Matrix3f;
import de.vw.mib.graphics.math.algebra.Rotation;

public interface Orientable {
    default public void getOrientation(Matrix3f matrix3f) {
    }

    default public void getOrientation(Rotation rotation) {
    }

    default public void setOrientation(Matrix3f matrix3f) {
    }

    default public void setOrientation(Rotation rotation) {
    }

    default public Orientable rotate(Matrix3f matrix3f) {
    }

    default public Orientable rotate(Rotation rotation) {
    }

    default public Orientable rotate(float f2, float f3, float f4, float f5) {
    }
}

