/*
 * Decompiled with CFR 0.152.
 */
package com.sun.gluegen.runtime;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class BufferFactory {
    public static final int SIZEOF_BYTE;
    public static final int SIZEOF_SHORT;
    public static final int SIZEOF_INT;
    public static final int SIZEOF_FLOAT;

    public static ByteBuffer newDirectByteBuffer(int n) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n);
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    public static boolean isDirect(Buffer buffer) {
        if (buffer == null) {
            return true;
        }
        if (buffer instanceof ByteBuffer) {
            return ((ByteBuffer)buffer).isDirect();
        }
        if (buffer instanceof FloatBuffer) {
            return ((FloatBuffer)buffer).isDirect();
        }
        if (buffer instanceof ShortBuffer) {
            return ((ShortBuffer)buffer).isDirect();
        }
        if (buffer instanceof IntBuffer) {
            return ((IntBuffer)buffer).isDirect();
        }
        throw new RuntimeException(new StringBuffer().append("Unexpected buffer type ").append(super.getClass().getName()).toString());
    }

    public static int getDirectBufferByteOffset(Buffer buffer) {
        if (buffer == null) {
            return 0;
        }
        if (buffer instanceof ByteBuffer) {
            return buffer.position();
        }
        if (buffer instanceof FloatBuffer) {
            return buffer.position() * 4;
        }
        if (buffer instanceof IntBuffer) {
            return buffer.position() * 4;
        }
        if (buffer instanceof ShortBuffer) {
            return buffer.position() * 2;
        }
        throw new RuntimeException(new StringBuffer().append("Disallowed array backing store type in buffer ").append(super.getClass().getName()).toString());
    }

    public static Object getArray(Buffer buffer) {
        if (buffer == null) {
            return null;
        }
        if (buffer instanceof ByteBuffer) {
            return ((ByteBuffer)buffer).array();
        }
        if (buffer instanceof FloatBuffer) {
            return ((FloatBuffer)buffer).array();
        }
        if (buffer instanceof IntBuffer) {
            return ((IntBuffer)buffer).array();
        }
        if (buffer instanceof ShortBuffer) {
            return ((ShortBuffer)buffer).array();
        }
        throw new RuntimeException(new StringBuffer().append("Disallowed array backing store type in buffer ").append(super.getClass().getName()).toString());
    }

    public static int getIndirectBufferByteOffset(Buffer buffer) {
        if (buffer == null) {
            return 0;
        }
        int n = buffer.position();
        if (buffer instanceof ByteBuffer) {
            return ((ByteBuffer)buffer).arrayOffset() + n;
        }
        if (buffer instanceof FloatBuffer) {
            return 4 * (((FloatBuffer)buffer).arrayOffset() + n);
        }
        if (buffer instanceof IntBuffer) {
            return 4 * (((IntBuffer)buffer).arrayOffset() + n);
        }
        if (buffer instanceof ShortBuffer) {
            return 2 * (((ShortBuffer)buffer).arrayOffset() + n);
        }
        throw new RuntimeException(new StringBuffer().append("Unknown buffer type ").append(super.getClass().getName()).toString());
    }

    public static void rangeCheck(byte[] byArray, int n, int n2) {
        if (byArray == null) {
            return;
        }
        if (byArray.length < n + n2) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Required ").append(n2).append(" elements in array, only had ").append(byArray.length - n).toString());
        }
    }

    public static void rangeCheck(char[] cArray, int n, int n2) {
        if (cArray == null) {
            return;
        }
        if (cArray.length < n + n2) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Required ").append(n2).append(" elements in array, only had ").append(cArray.length - n).toString());
        }
    }

    public static void rangeCheck(short[] sArray, int n, int n2) {
        if (sArray == null) {
            return;
        }
        if (sArray.length < n + n2) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Required ").append(n2).append(" elements in array, only had ").append(sArray.length - n).toString());
        }
    }

    public static void rangeCheck(int[] nArray, int n, int n2) {
        if (nArray == null) {
            return;
        }
        if (nArray.length < n + n2) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Required ").append(n2).append(" elements in array, only had ").append(nArray.length - n).toString());
        }
    }

    public static void rangeCheck(float[] fArray, int n, int n2) {
        if (fArray == null) {
            return;
        }
        if (fArray.length < n + n2) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Required ").append(n2).append(" elements in array, only had ").append(fArray.length - n).toString());
        }
    }

    public static void rangeCheck(Buffer buffer, int n) {
        if (buffer == null) {
            return;
        }
        if (buffer.remaining() < n) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Required ").append(n).append(" remaining elements in buffer, only had ").append(buffer.remaining()).toString());
        }
    }

    public static void rangeCheckBytes(Buffer buffer, int n) {
        if (buffer == null) {
            return;
        }
        int n2 = buffer.remaining();
        int n3 = 0;
        if (buffer instanceof ByteBuffer) {
            n3 = n2;
        } else if (buffer instanceof FloatBuffer) {
            n3 = n2 * 4;
        } else if (buffer instanceof IntBuffer) {
            n3 = n2 * 4;
        } else if (buffer instanceof ShortBuffer) {
            n3 = n2 * 2;
        }
        if (n3 < n) {
            throw new IndexOutOfBoundsException(new StringBuffer().append("Required ").append(n).append(" remaining bytes in buffer, only had ").append(n3).toString());
        }
    }

    public static void dispose(Buffer buffer) {
        buffer.dispose();
    }
}

