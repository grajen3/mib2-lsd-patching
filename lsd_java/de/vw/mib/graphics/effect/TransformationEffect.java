/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.effect;

import de.vw.mib.graphics.effect.Effect;
import de.vw.mib.graphics.math.algebra.Matrix4f;

public interface TransformationEffect
extends Effect {
    default public Matrix4f getModelViewMatrix() {
    }

    default public void setModelViewMatrix(Matrix4f matrix4f) {
    }

    default public Matrix4f getProjectionMatrix() {
    }

    default public void setProjectionMatrix(Matrix4f matrix4f) {
    }

    default public Matrix4f getModelViewProjectionMatrix() {
    }

    default public void setModelViewProjectionMatrix(Matrix4f matrix4f) {
    }
}

