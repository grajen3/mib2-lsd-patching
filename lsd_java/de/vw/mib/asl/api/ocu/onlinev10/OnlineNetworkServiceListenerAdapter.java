/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkService;
import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceListener;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkSupportedServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState;

public class OnlineNetworkServiceListenerAdapter
implements OnlineNetworkServiceListener {
    @Override
    public void updateOnlineNetworkServiceStatus(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceStatus onlineNetworkServiceStatus) {
    }

    @Override
    public void updateOnlineNetworkSupportedServices(OnlineNetworkService onlineNetworkService, OnlineNetworkSupportedServices onlineNetworkSupportedServices) {
    }

    @Override
    public void updateOnlineNetworkUserList(OnlineNetworkService onlineNetworkService, OnlineNetworkList onlineNetworkList) {
    }

    @Override
    public void updateOnlineNetworkServiceList(OnlineNetworkService onlineNetworkService, OnlineNetworkList onlineNetworkList) {
    }

    @Override
    public void updateOnlineNetworkTrackingServices(OnlineNetworkService onlineNetworkService, OnlineNetworkTrackingServices onlineNetworkTrackingServices) {
    }

    @Override
    public void updatePrivacyModeActive(OnlineNetworkService onlineNetworkService, boolean bl) {
    }

    @Override
    public void updateServiceListSynchronisationState(OnlineNetworkService onlineNetworkService, ServiceListSynchronisationState serviceListSynchronisationState) {
    }

    @Override
    public void updateOnlineNetworkServiceSetBlocking(OnlineNetworkService onlineNetworkService, OnlineNetworkServiceListEntry onlineNetworkServiceListEntry) {
    }
}

