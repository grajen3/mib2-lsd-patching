/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.corecommon;

public class CoreServiceBitUtil {
    public static int setBit(int n, int n2) {
        return n2 | CoreServiceBitUtil.bitValue(n);
    }

    public static int clearBit(int n, int n2) {
        return n2 & ~CoreServiceBitUtil.bitValue(n);
    }

    public static int toggleBit(int n, int n2) {
        return n2 ^= CoreServiceBitUtil.bitValue(n);
    }

    public static int bitValue(int n) {
        return 1 << n;
    }
}

