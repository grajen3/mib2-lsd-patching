/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkSupportedServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState;

public interface OnlineNetworkServiceListener {
    default public void updateOnlineNetworkServiceStatus(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceStatus onlineNetworkServiceStatus) {
    }

    default public void updateOnlineNetworkSupportedServices(OnlineNetworkService onlineNetworkService, OnlineNetworkSupportedServices onlineNetworkSupportedServices) {
    }

    default public void updateOnlineNetworkUserList(OnlineNetworkService onlineNetworkService, OnlineNetworkList onlineNetworkList) {
    }

    default public void updateOnlineNetworkServiceList(OnlineNetworkService onlineNetworkService, OnlineNetworkList onlineNetworkList) {
    }

    default public void updateOnlineNetworkServiceSetBlocking(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceListEntry onlineNetworkServiceListEntry) {
    }

    default public void updateOnlineNetworkTrackingServices(OnlineNetworkService onlineNetworkService, OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
    }

    default public void updatePrivacyModeActive(OnlineNetworkService onlineNetworkService, boolean bl) {
    }

    default public void updateServiceListSynchronisationState(OnlineNetworkService onlineNetworkService, ServiceListSynchronisationState serviceListSynchronisationState) {
    }
}

