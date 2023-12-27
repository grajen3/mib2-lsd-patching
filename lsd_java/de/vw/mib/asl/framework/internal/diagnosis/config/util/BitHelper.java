/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.config.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class BitHelper {
    public static byte setBit(byte by, byte by2) {
        return (byte)(by | 1 << by2);
    }

    public static int setBit(int n, int n2) {
        return n | 1 << n2;
    }

    public static byte clearBit(byte by, byte by2) {
        return (byte)(by & ~(1 << by2));
    }

    public static boolean testBit(byte by, int n) {
        return (by & 1 << n) != 0;
    }

    public static byte getBitsFromByte(byte by, int n, int n2) {
        byte by2 = 0;
        for (int i2 = n; i2 <= n2; ++i2) {
            if (!BitHelper.testBit(by, i2)) continue;
            by2 = BitHelper.setBit(by2, (byte)(i2 - n));
        }
        return by2;
    }

    public static byte setBitsInByte(byte by, byte by2, int n, int n2) {
        if (n >= 0 && n2 <= 7) {
            for (int i2 = n; i2 <= n2; ++i2) {
                by = BitHelper.testBit(by2, i2 - n) ? BitHelper.setBit(by, (byte)i2) : BitHelper.clearBit(by, (byte)i2);
            }
        }
        return by;
    }

    public static int unsignedByteToInt(byte by) {
        return by & 0xFF;
    }

    public static void traceError(String string, int n) {
        ServiceManager.logger.error(16384).append("DIAGNOSTIC ").append(string).append(" == ").append(String.valueOf(n)).log();
    }
}

