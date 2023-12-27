/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.connectivity;

import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityServiceListener;
import de.vw.mib.bap.mqbab2.common.api.connectivity.datatypes.ConnectivityCurrentConnectionDetails;

public interface ConnectivityService {
    default public void addConnectivityServiceListener(ConnectivityServiceListener connectivityServiceListener, int[] nArray) {
    }

    default public void removeConnectivityServiceListener(ConnectivityServiceListener connectivityServiceListener, int[] nArray) {
    }

    default public boolean isWlanActivated() {
    }

    default public boolean isWlanConcealed() {
    }

    default public boolean getConnectionClear() {
    }

    default public ConnectivityCurrentConnectionDetails getCurrentConnectionDetails() {
    }
}

