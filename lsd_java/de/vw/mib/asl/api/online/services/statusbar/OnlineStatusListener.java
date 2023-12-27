/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.services.statusbar;

public interface OnlineStatusListener {
    public static final int DATA_CONNECTION_AVAILABLE;
    public static final int DATA_CONNECTION_NOT_AVAILABLE;
    public static final int PRIVACY_MODE_ACTIVE;
    public static final int PERSONAL_SETUP_OR_NEW_UPDATE;
    public static final int ACTIVE_TRACKING_SERVICES;
    public static final int ACTIVE_TRACKING_SERVICES_WITH_NO_SERVICE_LIST;

    default public void updateOnlineStatus(int n) {
    }
}

