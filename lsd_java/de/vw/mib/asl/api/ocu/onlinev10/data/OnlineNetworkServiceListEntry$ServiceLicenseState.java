/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10.data;

public interface OnlineNetworkServiceListEntry$ServiceLicenseState {
    public static final int NOT_LICENSED;
    public static final int NOT_ACTIVATED;
    public static final int ACTIVATED;
    public static final int EXPIRED;
    public static final int TEPORARY_OFFER;
    public static final int LICENSE_ERROR;

    default public int value() {
    }
}

