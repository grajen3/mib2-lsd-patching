/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

public final class AudioSDCommon {
    public static final int SOURCE_POS_FM;
    public static final int SOURCE_POS_AM;
    public static final int SOURCE_POS_DAB;
    public static final int SOURCE_POS_SIRIUS;
    public static final int SOURCE_POS_TV;
    private static final int PI_BIT_SIZE;
    private static final int FREQUENCY_BIT_SIZE;
    private static final int CHANNEL_NUMBER_BIT_SIZE;
    private static final long STATION_ID_PI_FILTER_MASK;
    private static final int WAVE_BAND_BIT_SIZE;

    public static int computeUniquePresetID(int n, int n2) {
        return n << 8 | n2;
    }

    public static long computeUniqueID(int n, int n2, int n3, int n4) {
        long l = n;
        l = l << 16 | (long)n2;
        l = l << 32 | (long)n3;
        l = l << 8 | (long)(n4 > 0 ? n4 : 0);
        return l;
    }

    public static long filterOutPIFromUniqueID(long l) {
        return l & 0xFF0000FFFFFFFFFFL;
    }
}

