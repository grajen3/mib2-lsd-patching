/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.vo;

public interface CarFunctionState {
    public static final int STATE_NORMAL_OPERATION;
    public static final int STATE_NOT_EXISTING;
    public static final int STATE_NOT_ACCESSIBLE;

    default public int getState() {
    }

    default public int getAvailableReason() {
    }
}

