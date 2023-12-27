/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10.data;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus$CellularNetworkState;

public interface OnlineNetworkServiceStatus {
    default public boolean isCommunicationAvailable() {
    }

    default public boolean isServiceUserActionsBlocked() {
    }

    default public CellularNetworkState getConnectionToCellularNetworkState() {
    }
}

