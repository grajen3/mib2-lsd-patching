/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.graphics.internal.util.AbstractMatrixStack;
import de.vw.mib.graphics.internal.util.MatrixStack;
import de.vw.mib.graphics.math.Transform;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Matrix4f;
import de.vw.mib.util.StringBuilder;

public final class TransformStack
extends AbstractMatrixStack {
    private Transform[] stack;
    private int index;

    public TransformStack(int n) {
        this.stack = new Transform[n];
        for (int i2 = 0; i2 < this.stack.length; ++i2) {
            Transform transform = new Transform();
            transform.setIdentity();
            this.stack[i2] = transform;
        }
        this.index = 0;
    }

    @Override
    public Object clone() {
        TransformStack transformStack = (TransformStack)super.clone();
        transformStack.stack = (Transform[])this.stack.clone();
        for (int i2 = 0; i2 < this.stack.length; ++i2) {
            transformStack.stack[i2] = (Transform)this.stack[i2].clone();
        }
        return transformStack;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[super=").append(super.toString());
        stringBuilder.append(",stack=").append(this.stack);
        stringBuilder.append(",index=").append(this.index);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void reset() {
        for (int i2 = 0; i2 < this.stack.length; ++i2) {
            this.stack[i2].setIdentity();
        }
        this.index = 0;
    }

    @Override
    public void push() {
        if (this.index + 1 == this.stack.length) {
            Transform[] transformArray = new Transform[this.stack.length * 2];
            System.arraycopy((Object)this.stack, 0, (Object)transformArray, 0, this.stack.length);
            for (int i2 = this.stack.length; i2 < transformArray.length; ++i2) {
                transformArray[i2] = new Transform();
            }
            this.stack = transformArray;
        }
        this.stack[this.index + 1].set(this.stack[this.index]);
        ++this.index;
    }

    @Override
    public void pop() {
        --this.index;
        if (this.index < 0) {
            throw new IllegalStateException("Stack underflow");
        }
    }

    @Override
    public Matrix4f peek() {
        return this.stack[this.index].getAsMatrix();
    }

    @Override
    public Transform peekTransform() {
        return this.stack[this.index];
    }

    @Override
    public void set(Matrix4f matrix4f) {
        this.stack[this.index].setFromMatrix(matrix4f);
    }

    @Override
    public void set(Transform transform) {
        this.stack[this.index].set(transform);
    }

    @Override
    public MatrixStack mul(Matrix4f matrix4f) {
        this.stack[this.index].transform(matrix4f);
        return this;
    }

    @Override
    public MatrixStack mul(Transform transform) {
        this.stack[this.index].transform(transform);
        return this;
    }

    @Override
    public void setIdentity() {
        this.stack[this.index].setIdentity();
    }

    @Override
    public MatrixStack rotate(float f2, float f3, float f4, float f5) {
        this.stack[this.index].rotate(Util.toRadians(f2), f3, f4, f5);
        return this;
    }

    @Override
    public MatrixStack translate(float f2, float f3, float f4) {
        this.stack[this.index].translate(f2, f3, f4);
        return this;
    }

    @Override
    public MatrixStack scale(float f2, float f3, float f4) {
        this.stack[this.index].scale(f2, f3, f4);
        return this;
    }
}

