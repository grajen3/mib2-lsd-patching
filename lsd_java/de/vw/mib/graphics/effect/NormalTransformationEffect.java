/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect;

import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.math.algebra.Matrix3f;

public interface NormalTransformationEffect
extends Effect {
    default public Matrix3f getNormalMatrix() {
    }

    default public void setNormalMatrix(Matrix3f matrix3f) {
    }

    default public boolean getNormalizeNormal() {
    }

    default public void setNormalizeNormal(boolean bl) {
    }

    default public boolean getRescaleNormal() {
    }

    default public void setRescaleNormal(boolean bl) {
    }

    default public float getRescaleNormalFactor() {
    }

    default public void setRescaleNormalFactor(float f2) {
    }
}

