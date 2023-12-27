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

public final class Matrix4fStack
extends AbstractMatrixStack {
    private static Transform tempTransform = new Transform();
    private Matrix4f[] stack;
    private int index;

    public Matrix4fStack(int n) {
        this.stack = new Matrix4f[n];
        for (int i2 = 0; i2 < this.stack.length; ++i2) {
            this.stack[i2] = new Matrix4f(true);
        }
        this.index = 0;
    }

    @Override
    public Object clone() {
        Matrix4fStack matrix4fStack = (Matrix4fStack)super.clone();
        matrix4fStack.stack = (Matrix4f[])this.stack.clone();
        for (int i2 = 0; i2 < this.stack.length; ++i2) {
            matrix4fStack.stack[i2] = (Matrix4f)this.stack[i2].clone();
        }
        return matrix4fStack;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[stack=").append(this.stack);
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
            Matrix4f[] matrix4fArray = new Matrix4f[this.stack.length * 2];
            System.arraycopy((Object)this.stack, 0, (Object)matrix4fArray, 0, this.stack.length);
            for (int i2 = this.stack.length; i2 < matrix4fArray.length; ++i2) {
                matrix4fArray[i2] = new Matrix4f(true);
            }
            this.stack = matrix4fArray;
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
        return this.stack[this.index];
    }

    @Override
    public Transform peekTransform() {
        tempTransform.setFromMatrix(this.stack[this.index]);
        return tempTransform;
    }

    @Override
    public void set(Matrix4f matrix4f) {
        this.stack[this.index].set(matrix4f);
    }

    @Override
    public void set(Transform transform) {
        this.set(transform.getAsMatrix());
    }

    @Override
    public MatrixStack mul(Matrix4f matrix4f) {
        this.stack[this.index].mul(matrix4f);
        return this;
    }

    @Override
    public MatrixStack mul(Transform transform) {
        this.stack[this.index].mul(transform.getAsMatrix());
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

