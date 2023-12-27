/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import com.sun.gluegen.runtime.BufferFactory;
import de.eso.mib.MIFImageInfo;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

public class MIF {
    public static final int MIF_IMAGE_RGBA;
    public static final int MIF_IMAGE_GRAY;
    public static final int MIF_IMAGE_GRAY_ALPHA;
    public static final int MIF_IMAGE_RGB;

    public static native void MifDeinitFW() {
    }

    public static void MifInitFW(ByteBuffer byteBuffer) {
        boolean bl = BufferFactory.isDirect(byteBuffer);
        if (bl) {
            MIF.MifInitFW0(byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
        } else {
            MIF.MifInitFW1(BufferFactory.getArray(byteBuffer), BufferFactory.getIndirectBufferByteOffset(byteBuffer));
        }
    }

    private static native void MifInitFW0(Object object, int n) {
    }

    private static native void MifInitFW1(Object object, int n) {
    }

    public static void MifInitFW(byte[] byArray, int n) {
        if (byArray != null && byArray.length <= n) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"name_offset\" (").append(n).append(") equals or exceeds array length (").append(byArray.length).append(")").toString());
        }
        MIF.MifInitFW1(byArray, n);
    }

    public static native int addImage(int n, String string) {
    }

    public static native int addMetaData(int n, String string, String string2) {
    }

    public static native void closeMCF(long l) {
    }

    public static native void closeMIF() {
    }

    public static native long createMCF(int n, int n2) {
    }

    public static native int createMIF(String string) {
    }

    public static native void deinitMifinator() {
    }

    public static ByteBuffer getChunkData(long l, int n, IntBuffer intBuffer) {
        if (!BufferFactory.isDirect(intBuffer)) {
            throw new RuntimeException("Argument \"datasize\" was not a direct buffer");
        }
        ByteBuffer byteBuffer = MIF.getChunkData0(l, n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer getChunkData0(long l, int n, Object object, int n2) {
    }

    public static int getChunkIDs(long l, int n, int n2, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return MIF.getChunkIDs0(l, n, n2, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return MIF.getChunkIDs1(l, n, n2, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native int getChunkIDs0(long l, int n, int n2, Object object, int n3) {
    }

    private static native int getChunkIDs1(long l, int n, int n2, Object object, int n3) {
    }

    public static int getChunkIDs(long l, int n, int n2, int[] nArray, int n3) {
        if (nArray != null && nArray.length <= n3) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"chunkIDs_offset\" (").append(n3).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return MIF.getChunkIDs1(l, n, n2, nArray, 4 * n3);
    }

    public static int getChunkTypes(long l, int n, IntBuffer intBuffer) {
        boolean bl = BufferFactory.isDirect(intBuffer);
        if (bl) {
            return MIF.getChunkTypes0(l, n, intBuffer, BufferFactory.getDirectBufferByteOffset(intBuffer));
        }
        return MIF.getChunkTypes1(l, n, BufferFactory.getArray(intBuffer), BufferFactory.getIndirectBufferByteOffset(intBuffer));
    }

    private static native int getChunkTypes0(long l, int n, Object object, int n2) {
    }

    private static native int getChunkTypes1(long l, int n, Object object, int n2) {
    }

    public static int getChunkTypes(long l, int n, int[] nArray, int n2) {
        if (nArray != null && nArray.length <= n2) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"chunIDs_offset\" (").append(n2).append(") equals or exceeds array length (").append(nArray.length).append(")").toString());
        }
        return MIF.getChunkTypes1(l, n, nArray, 4 * n2);
    }

    public static ByteBuffer getImage(int n, MIFImageInfo mIFImageInfo) {
        ByteBuffer byteBuffer = MIF.getImage0(n, mIFImageInfo == null ? null : mIFImageInfo.getBuffer());
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        return byteBuffer;
    }

    private static native ByteBuffer getImage0(int n, ByteBuffer byteBuffer) {
    }

    public static native void initMifinator() {
    }

    public static long loadChunk(long l, int n, int n2, ByteBuffer byteBuffer) {
        if (!BufferFactory.isDirect(byteBuffer)) {
            throw new RuntimeException("Argument \"status\" was not a direct buffer");
        }
        return MIF.loadChunk0(l, n, n2, byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
    }

    private static native long loadChunk0(long l, int n, int n2, Object object, int n3) {
    }

    public static int mcfAddData(long l, int n, String string, ByteBuffer byteBuffer, int n2, int n3) {
        boolean bl = BufferFactory.isDirect(byteBuffer);
        if (bl) {
            return MIF.mcfAddData0(l, n, string, byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer), n2, n3);
        }
        return MIF.mcfAddData1(l, n, string, BufferFactory.getArray(byteBuffer), BufferFactory.getIndirectBufferByteOffset(byteBuffer), n2, n3);
    }

    private static native int mcfAddData0(long l, int n, String string, Object object, int n2, int n3, int n4) {
    }

    private static native int mcfAddData1(long l, int n, String string, Object object, int n2, int n3, int n4) {
    }

    public static int mcfAddData(long l, int n, String string, byte[] byArray, int n2, int n3, int n4) {
        if (byArray != null && byArray.length <= n2) {
            throw new RuntimeException(new StringBuffer().append("array offset argument \"data_offset\" (").append(n2).append(") equals or exceeds array length (").append(byArray.length).append(")").toString());
        }
        return MIF.mcfAddData1(l, n, string, byArray, n2, n3, n4);
    }

    public static native int mcfAddImage(long l, int n, String string) {
    }

    public static void mcfConvertImageHeader(Buffer buffer, MIFImageInfo mIFImageInfo) {
        boolean bl = BufferFactory.isDirect(buffer);
        if (bl) {
            MIF.mcfConvertImageHeader0(buffer, BufferFactory.getDirectBufferByteOffset(buffer), mIFImageInfo == null ? null : mIFImageInfo.getBuffer());
        } else {
            MIF.mcfConvertImageHeader1(BufferFactory.getArray(buffer), BufferFactory.getIndirectBufferByteOffset(buffer), mIFImageInfo == null ? null : mIFImageInfo.getBuffer());
        }
    }

    private static native void mcfConvertImageHeader0(Object object, int n, ByteBuffer byteBuffer) {
    }

    private static native void mcfConvertImageHeader1(Object object, int n, ByteBuffer byteBuffer) {
    }

    public static long openMCF(String string, int n, int n2, ByteBuffer byteBuffer) {
        if (!BufferFactory.isDirect(byteBuffer)) {
            throw new RuntimeException("Argument \"status\" was not a direct buffer");
        }
        return MIF.openMCF0(string, n, n2, byteBuffer, BufferFactory.getDirectBufferByteOffset(byteBuffer));
    }

    private static native long openMCF0(String string, int n, int n2, Object object, int n3) {
    }

    public static native int openMIF(String string) {
    }

    public static native void releaseChunk(long l) {
    }

    public static native int saveMCF(long l, String string) {
    }

    public static native void saveMIF() {
    }
}

