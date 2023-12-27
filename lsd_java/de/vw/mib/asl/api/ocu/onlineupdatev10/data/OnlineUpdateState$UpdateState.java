/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlineupdatev10.data;

public interface OnlineUpdateState$UpdateState {
    public static final int NO_UPDATE_AVAILABLE;
    public static final int SPIN_INVALID;
    public static final int SPIN_FAILED;
    public static final int SPIN_ERROR;
    public static final int DOWNLOAD_CONFIRM_PENDING;
    public static final int DOWNLOAD_RUNNING;
    public static final int DOWNLOAD_WITHDRAWN_CONFIRM_PENDING;
    public static final int DOWNLOAD_ERROR_CONFIRM_PENDING;
    public static final int INSTALLATION_CONFIRM_PENDING;
    public static final int INSTALLATION_RUNNING;
    public static final int INSTALLATION_ERROR_CONFIRM_PENDING;
    public static final int INSTALLATION_FATAL_ERROR_CONFIRM_PENDING;
    public static final int INSTALLATION_FINISHED_CONFIRM_PENDING;
    public static final int INSTALLATION_PRECONDITION_NOT_MET;

    default public int value() {
    }
}

