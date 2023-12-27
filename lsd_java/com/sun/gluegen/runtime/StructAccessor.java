/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class StructAccessor {
    private ByteBuffer bb;
    private FloatBuffer fb;
    private IntBuffer ib;
    private ShortBuffer sb;

    public StructAccessor(ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
    }

    public ByteBuffer getBuffer() {
        return this.bb;
    }

    public ByteBuffer slice(int n, int n2) {
        this.bb.position(n);
        this.bb.limit(n + n2);
        ByteBuffer byteBuffer = this.bb.slice();
        this.bb.position(0);
        this.bb.limit(this.bb.capacity());
        return byteBuffer;
    }

    public byte getByteAt(int n) {
        return this.bb.get(n);
    }

    public void setByteAt(int n, byte by) {
        this.bb.put(n, by);
    }

    public float getFloatAt(int n) {
        return this.floatBuffer().get(n);
    }

    public void setFloatAt(int n, float f2) {
        this.floatBuffer().put(n, f2);
    }

    public int getIntAt(int n) {
        return this.intBuffer().get(n);
    }

    public void setIntAt(int n, int n2) {
        this.intBuffer().put(n, n2);
    }

    public short getShortAt(int n) {
        return this.shortBuffer().get(n);
    }

    public void setShortAt(int n, short s) {
        this.shortBuffer().put(n, s);
    }

    private FloatBuffer floatBuffer() {
        if (this.fb == null) {
            this.fb = this.bb.asFloatBuffer();
        }
        return this.fb;
    }

    private IntBuffer intBuffer() {
        if (this.ib == null) {
            this.ib = this.bb.asIntBuffer();
        }
        return this.ib;
    }

    private ShortBuffer shortBuffer() {
        if (this.sb == null) {
            this.sb = this.bb.asShortBuffer();
        }
        return this.sb;
    }
}

