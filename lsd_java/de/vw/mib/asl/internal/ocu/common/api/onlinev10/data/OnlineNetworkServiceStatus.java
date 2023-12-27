/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.data;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus$CellularNetworkState;

public class OnlineNetworkServiceStatus
implements de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus {
    private final boolean communicationAvailable;
    private final boolean serviceUserActionsBlocked;
    private final OnlineNetworkServiceStatus$CellularNetworkState cellularNetworkState;

    public OnlineNetworkServiceStatus(boolean bl, boolean bl2, OnlineNetworkServiceStatus$CellularNetworkState onlineNetworkServiceStatus$CellularNetworkState) {
        this.communicationAvailable = bl;
        this.serviceUserActionsBlocked = bl2;
        this.cellularNetworkState = onlineNetworkServiceStatus$CellularNetworkState;
    }

    @Override
    public boolean isCommunicationAvailable() {
        return this.communicationAvailable;
    }

    @Override
    public boolean isServiceUserActionsBlocked() {
        return this.serviceUserActionsBlocked;
    }

    @Override
    public OnlineNetworkServiceStatus$CellularNetworkState getConnectionToCellularNetworkState() {
        return this.cellularNetworkState;
    }

    public OnlineNetworkServiceStatus setCommunicationAvailable(boolean bl) {
        return new OnlineNetworkServiceStatus(bl, this.serviceUserActionsBlocked, this.cellularNetworkState);
    }

    public OnlineNetworkServiceStatus setServiceUserActionsBlocked(boolean bl) {
        return new OnlineNetworkServiceStatus(this.communicationAvailable, bl, this.cellularNetworkState);
    }

    public OnlineNetworkServiceStatus setConnectionToCellularNetworkState(OnlineNetworkServiceStatus$CellularNetworkState onlineNetworkServiceStatus$CellularNetworkState) {
        return new OnlineNetworkServiceStatus(this.communicationAvailable, this.serviceUserActionsBlocked, onlineNetworkServiceStatus$CellularNetworkState);
    }

    public boolean equals(Object object) {
        OnlineNetworkServiceStatus onlineNetworkServiceStatus = (OnlineNetworkServiceStatus)object;
        return onlineNetworkServiceStatus.communicationAvailable == this.communicationAvailable && onlineNetworkServiceStatus.serviceUserActionsBlocked == this.serviceUserActionsBlocked && onlineNetworkServiceStatus.cellularNetworkState == this.cellularNetworkState;
    }

    public int hashCode() {
        return super.hashCode();
    }
}

