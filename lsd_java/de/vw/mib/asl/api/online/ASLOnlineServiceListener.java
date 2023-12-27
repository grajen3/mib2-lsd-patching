/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online;

public interface ASLOnlineServiceListener {
    public static final int RESULT_SERVICE_OK;
    public static final int RESULT_SERVICE_ERROR;
    public static final int RESULT_SERVICE_NOT_AVAILABLE;
    public static final int RESULT_SERVICE_DEACTIVATED;
    public static final int RESULT_SERVICE_CONNECTIVITY_ERROR;
    public static final int RESULT_SERVICE_LICENSE_ERROR;
    public static final int RESULT_SERVICE_NOT_VALID;
    public static final int RESULT_SERVICE_IN_ROAMING;
    public static final int RESULT_SERVICE_NOT_REGISTERED;

    default public void updateServiceStatusOnChange(int n) {
    }
}

