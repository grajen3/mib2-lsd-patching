/*
 * Decompiled with CFR 0.152.
 */
package com.sun.opengl.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class BufferUtil {
    public static final int SIZEOF_BYTE;
    public static final int SIZEOF_SHORT;
    public static final int SIZEOF_INT;
    public static final int SIZEOF_FLOAT;

    private BufferUtil() {
    }

    public static ByteBuffer newByteBuffer(int n) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    public static FloatBuffer newFloatBuffer(int n) {
        ByteBuffer byteBuffer = BufferUtil.newByteBuffer(n * 4);
        return byteBuffer.asFloatBuffer();
    }

    public static IntBuffer newIntBuffer(int n) {
        ByteBuffer byteBuffer = BufferUtil.newByteBuffer(n * 4);
        return byteBuffer.asIntBuffer();
    }

    public static ShortBuffer newShortBuffer(int n) {
        ByteBuffer byteBuffer = BufferUtil.newByteBuffer(n * 2);
        return byteBuffer.asShortBuffer();
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = BufferUtil.newByteBuffer(byteBuffer.remaining());
        int n = byteBuffer.position();
        byteBuffer2.put(byteBuffer);
        byteBuffer.position(n);
        byteBuffer2.rewind();
        return byteBuffer2;
    }

    public static FloatBuffer copyFloatBuffer(FloatBuffer floatBuffer) {
        return BufferUtil.copyFloatBufferAsByteBuffer(floatBuffer).asFloatBuffer();
    }

    public static IntBuffer copyIntBuffer(IntBuffer intBuffer) {
        return BufferUtil.copyIntBufferAsByteBuffer(intBuffer).asIntBuffer();
    }

    public static ShortBuffer copyShortBuffer(ShortBuffer shortBuffer) {
        return BufferUtil.copyShortBufferAsByteBuffer(shortBuffer).asShortBuffer();
    }

    public static ByteBuffer copyFloatBufferAsByteBuffer(FloatBuffer floatBuffer) {
        ByteBuffer byteBuffer = BufferUtil.newByteBuffer(floatBuffer.remaining() * 4);
        int n = floatBuffer.position();
        byteBuffer.asFloatBuffer().put(floatBuffer);
        floatBuffer.position(n);
        byteBuffer.rewind();
        return byteBuffer;
    }

    public static ByteBuffer copyIntBufferAsByteBuffer(IntBuffer intBuffer) {
        ByteBuffer byteBuffer = BufferUtil.newByteBuffer(intBuffer.remaining() * 4);
        int n = intBuffer.position();
        byteBuffer.asIntBuffer().put(intBuffer);
        intBuffer.position(n);
        byteBuffer.rewind();
        return byteBuffer;
    }

    public static ByteBuffer copyShortBufferAsByteBuffer(ShortBuffer shortBuffer) {
        ByteBuffer byteBuffer = BufferUtil.newByteBuffer(shortBuffer.remaining() * 2);
        int n = shortBuffer.position();
        byteBuffer.asShortBuffer().put(shortBuffer);
        shortBuffer.position(n);
        byteBuffer.rewind();
        return byteBuffer;
    }

    public static void printIntBuffer(ByteBuffer byteBuffer) {
        int n = byteBuffer.capacity();
        for (int i2 = 0; i2 < n; ++i2) {
            System.out.println(new StringBuffer().append("buf.get(").append(i2).append(") = ").append(byteBuffer.get(i2)).toString());
        }
    }

    public static void printIntBuffer(ShortBuffer shortBuffer) {
        int n = shortBuffer.capacity();
        for (int i2 = 0; i2 < n; ++i2) {
            System.out.println(new StringBuffer().append("buf.get(").append(i2).append(") = ").append(shortBuffer.get(i2)).toString());
        }
    }

    public static void printIntBuffer(IntBuffer intBuffer) {
        int n = intBuffer.capacity();
        for (int i2 = 0; i2 < n; ++i2) {
            System.out.println(new StringBuffer().append("buf.get(").append(i2).append(") = ").append(intBuffer.get(i2)).toString());
        }
    }

    public static void printFloatBuffer(FloatBuffer floatBuffer) {
        int n = floatBuffer.capacity();
        for (int i2 = 0; i2 < n; ++i2) {
            System.out.println(new StringBuffer().append("buf.get(").append(i2).append(") = ").append(floatBuffer.get(i2)).toString());
        }
    }
}

