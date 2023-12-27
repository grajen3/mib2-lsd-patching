/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10.data;

import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList$OnlineNetworkListState;
import java.util.List;

public interface OnlineNetworkList {
    default public OnlineNetworkListState getListState() {
    }

    default public List getListData() {
    }
}

