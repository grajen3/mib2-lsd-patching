/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.spi.messages;

import java.io.InputStream;

public class SyncMarkerHelper {
    public static int matchesSyncMarker(byte[] byArray, InputStream inputStream) {
        return SyncMarkerHelper.matchesSyncMarker(byArray.length, SyncMarkerHelper.calculateExpectedMask(byArray), SyncMarkerHelper.calculateClearMask(byArray), inputStream);
    }

    public static int matchesSyncMarker(int n, long l, long l2, InputStream inputStream) {
        long l3 = 0L;
        int n2 = 0;
        int n3 = 0;
        while ((n2 = inputStream.read()) > -1) {
            ++n3;
            l3 = (l3 << 8) + (long)((byte)n2 & 0xFF);
            if ((l3 &= l2 ^ 0xFFFFFFFFFFFFFFFFL) != l) continue;
            return n3 - n;
        }
        return -1;
    }

    public static long calculateClearMask(byte[] byArray) {
        if (byArray.length > 8) {
            throw new IllegalArgumentException("Sync marker can only has a size of maximum 8 byte.");
        }
        long l = -1L;
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            l &= 0 << i2 * 8 ^ 0xFFFFFFFFFFFFFFFFL;
        }
        return l;
    }

    public static long calculateExpectedMask(byte[] byArray) {
        if (byArray.length > 8) {
            throw new IllegalArgumentException("Sync marker can only has a size of maximum 8 byte.");
        }
        long l = 0L;
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            l = (l << 8) + (long)(byArray[i2] & 0xFF);
        }
        return l;
    }
}

