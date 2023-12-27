/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;

public interface MatrixStack
extends Cloneable {
    default public Object clone() {
    }

    default public void reset() {
    }

    default public void push() {
    }

    default public void pop() {
    }

    default public Matrix4f peek() {
    }

    default public Transform peekTransform() {
    }

    default public void set(Matrix4f matrix4f) {
    }

    default public void set(Transform transform) {
    }

    default public MatrixStack mul(Matrix4f matrix4f) {
    }

    default public MatrixStack mul(Transform transform) {
    }

    default public void setIdentity() {
    }

    default public MatrixStack rotate(float f2, float f3, float f4, float f5) {
    }

    default public MatrixStack translate(float f2, float f3, float f4) {
    }

    default public MatrixStack scale(float f2, float f3, float f4) {
    }
}

