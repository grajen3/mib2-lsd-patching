/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.seats;

public interface SeatTargetService {
    public static final int LOGKEY_APPEND;
    public static final int LOGKEY_WARN;
    public static final int LOGKEY_LOG;
    public static final int LOGKEY_INFO;

    default public void writeToLog(int n, Object object) {
    }
}

