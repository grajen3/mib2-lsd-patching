/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10;

public interface OnlineNetworkServiceResponseListener$OperationStatus {
    public static final int NO_INFORMATION;
    public static final int NO_REQUEST_ACTIVE;
    public static final int IN_PROGRESS;
    public static final int SEARCHING_FOR_NETWORK;
    public static final int CONNECTING_TO_SERVER;
    public static final int WAITING_FOR_AUTHENTICATION;
    public static final int DATA_TRANSMISSION;

    default public int value() {
    }
}

