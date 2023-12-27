/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10;

public interface OnlineNetworkServiceResponseListener$OperationResult {
    public static final int SUCCESSFUL;
    public static final int NOT_SUCCESSFUL;
    public static final int NOT_SUCCESSFUL_SERVICE_BUSY;
    public static final int TERMINATED_BY_USER;
    public static final int NO_NETWORK_CONNECTION;
    public static final int NO_VERIFIED_ACCOUNT_FOUND;
    public static final int BACKEND_SERVICE_UNAVAILABLE;
    public static final int MISC_BACKEND_ERROR;
    public static final int TIMEOUT;
    public static final int WRONG_REGISTRATION_CODE_0_REPRIMARYING;
    public static final int WRONG_REGISTRATION_CODE_1_REPRIMARYING;
    public static final int WRONG_REGISTRATION_CODE;
    public static final int WRONG_REGISTRATION_CODE_PIN_EXPIRED;
    public static final int WRONG_REGISTRATION_CODE_NO_PIN_CREATED_UNPAIRED;

    default public int value() {
    }
}

