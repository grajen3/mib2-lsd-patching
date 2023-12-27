/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceListener;

public interface OnlineNetworkServiceProvider {
    default public OnlineNetworkService getOnlineNetworkService() {
    }

    default public void registerOnlineNetworkServiceListener(OnlineNetworkServiceListener onlineNetworkServiceListener) {
    }

    default public void unRegisterOnlineNetworkServiceListener(OnlineNetworkServiceListener onlineNetworkServiceListener) {
    }
}

