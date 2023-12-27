/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlineupdatev10;

public interface OnlineUpdateServiceResponseListener$OperationType {
    public static final int NO_OPERATION;
    public static final int POSTPONE_ONLINE_DOWNLOAD;
    public static final int AUTHENTICATE_ONLINE_DOWNLOAD;
    public static final int POSTPONE_INSTALLATION;
    public static final int CONFIRM_INSTALLATION;
    public static final int CONFIRM_UPDATE_ERROR;
    public static final int CONFIRM_INSTALLATION_FINISHED;
    public static final int CONFIRM_UPDATE_WITHDRAWN;
    public static final int REQUEST_CHALLENGE;

    default public int value() {
    }
}

