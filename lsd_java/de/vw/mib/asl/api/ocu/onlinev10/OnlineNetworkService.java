/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.ocu.onlinev10;

import de.vw.mib.asl.api.ocu.onlinev10.OnlineNetworkServiceResponseListener;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkList;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceListEntry;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkServiceStatus;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkSupportedServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.OnlineNetworkTrackingServices;
import de.vw.mib.asl.api.ocu.onlinev10.data.ServiceListSynchronisationState;

public interface OnlineNetworkService {
    default public void pairMainUser(String string, String string2, OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
    }

    default public void restoreFactorySettings(OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
    }

    default public void confirmServiceExpiryWarning(OnlineNetworkServiceListEntry onlineNetworkServiceListEntry, OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
    }

    default public void confirmServiceExpiryWarnings(OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
    }

    default public void setServicesBlocking(boolean bl) {
    }

    default public void setServiceBlocking(OnlineNetworkServiceListEntry onlineNetworkServiceListEntry, boolean bl) {
    }

    default public void setPrivacyMode(boolean bl) {
    }

    default public void synchronizeServiceListWithBackend(OnlineNetworkServiceResponseListener onlineNetworkServiceResponseListener) {
    }

    default public OnlineNetworkList getOnlineNetworkUserList() {
    }

    default public OnlineNetworkList getOnlineNetworkServiceList() {
    }

    default public OnlineNetworkServiceStatus getOnlineNetworkServiceStatus() {
    }

    default public OnlineNetworkSupportedServices getOnlineNetworkSupportedServices() {
    }

    default public OnlineNetworkTrackingServices getOnlineNetworkTrackingServices() {
    }

    default public boolean getPrivacyModeActive() {
    }

    default public ServiceListSynchronisationState getServiceListSynchronisationState() {
    }
}

