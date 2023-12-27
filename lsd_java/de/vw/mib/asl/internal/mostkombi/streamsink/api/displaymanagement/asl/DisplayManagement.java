/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl;

public interface DisplayManagement {
    public static final int KOMBI_DISPLAY_CONTEXT_MAP;
    public static final int KOMBI_DISPLAY_ACTIVE_CONTEXT_MAP;
    public static final int KOMBI_DISPLAY_STATUS_CONTEXT_NOT_SET;
    public static final int KOMBI_DISPLAY_STATUS_NOT_STARTED;
    public static final int DATA_FRAME_RATE_OFF;
    public static final int DATA_FRAME_RATE_REDUCED;
    public static final int DATA_FRAME_RATE_FULL;

    default public void switchToKombiDisplayContext(int n) {
    }

    default public void setDataFrameRate(int n) {
    }
}

