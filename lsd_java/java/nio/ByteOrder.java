/*
 * Decompiled with CFR 0.152.
 */
package java.nio;

import java.nio.ByteBufferImpl;

public class ByteOrder {
    public static final ByteOrder BIG_ENDIAN = new ByteOrder();
    public static final ByteOrder LITTLE_ENDIAN = new ByteOrder();
    public static final ByteOrder NATIVE_ORDER = ByteBufferImpl.isNativeLittleEndian() ? LITTLE_ENDIAN : BIG_ENDIAN;

    public static ByteOrder nativeOrder() {
        return NATIVE_ORDER;
    }

    public String toString() {
        return this == BIG_ENDIAN ? "BIG_ENDIAN" : (this == LITTLE_ENDIAN ? "LITTLE_ENDIAN" : "");
    }
}

