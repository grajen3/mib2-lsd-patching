/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.internal.util.MatrixStack;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractMatrixStack
implements MatrixStack {
    @Override
    public Object clone() {
        try {
            AbstractMatrixStack abstractMatrixStack = (AbstractMatrixStack)super.clone();
            return abstractMatrixStack;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            throw new RuntimeException(cloneNotSupportedException);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public abstract void reset() {
    }

    @Override
    public abstract void push() {
    }

    @Override
    public abstract void pop() {
    }

    @Override
    public abstract Matrix4f peek() {
    }

    @Override
    public abstract Transform peekTransform() {
    }

    @Override
    public abstract void set(Matrix4f matrix4f) {
    }

    @Override
    public abstract void set(Transform transform) {
    }

    @Override
    public abstract MatrixStack mul(Matrix4f matrix4f) {
    }

    @Override
    public abstract MatrixStack mul(Transform transform) {
    }

    @Override
    public abstract void setIdentity() {
    }

    @Override
    public abstract MatrixStack rotate(float f2, float f3, float f4, float f5) {
    }

    @Override
    public abstract MatrixStack translate(float f2, float f3, float f4) {
    }

    @Override
    public abstract MatrixStack scale(float f2, float f3, float f4) {
    }
}

