/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.api.onlinev10.data;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList$OnlineNetworkListState;
import java.util.List;

public class OnlineNetworkList
implements de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList {
    private final OnlineNetworkList$OnlineNetworkListState listState;
    private final List listData;

    public OnlineNetworkList(OnlineNetworkList$OnlineNetworkListState onlineNetworkList$OnlineNetworkListState, List list) {
        this.listState = onlineNetworkList$OnlineNetworkListState;
        this.listData = list;
    }

    @Override
    public OnlineNetworkList$OnlineNetworkListState getListState() {
        return this.listState;
    }

    @Override
    public List getListData() {
        return this.listData;
    }
}

