/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.connectivity;

import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityService;

public interface ConnectivityServiceListener {
    public static final int CONNECTIVITY_SREVICE__WLAN_ACTIVATION;
    public static final int CONNECTIVITY_SERVICE__WLAN_CONCEALING;
    public static final int CONNECTIVITY_SERVICE__CONNECTION_CLEAR;
    public static final int CONNECTIVITY_SERVICE__CURRENT_CONNECTION_DETAILS;

    default public void updateConnectivityData(ConnectivityService connectivityService, int n) {
    }
}

