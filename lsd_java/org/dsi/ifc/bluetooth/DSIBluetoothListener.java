/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public interface DSIBluetoothListener
extends DSIListener {
    default public void responseAbortConnectService(int n) {
    }

    default public void responseAbortInquiry(int n) {
    }

    default public void responseAcceptIncomingServiceRequest(int n) {
    }

    default public void responseConnectService(String string, String string2, int n, int n2, int n3) {
    }

    default public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
    }

    default public void responseDisconnectService(String string, int n, int n2) {
    }

    default public void responseGetServices(String string, String string2, int n, int n2) {
    }

    default public void responseInquiry(int n, int n2) {
    }

    default public void responsePasskeyResponse(String string, String string2, int n) {
    }

    default public void responseRemoveAuthentication(String string, String string2, int n) {
    }

    default public void responseRestoreFactorySettings(int n) {
    }

    default public void responseSetA2DPUserSetting(int n) {
    }

    default public void responseSetAccessibleMode(int n) {
    }

    default public void responseSwitchBTState(int n) {
    }

    default public void removeAuthenticationNoSupport(String string, String string2) {
    }

    default public void updateAccessibleMode(int n, boolean bl, int n2) {
    }

    default public void updateBTState(int n, int n2) {
    }

    default public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
    }

    default public void updateHUCandBTHSState(int n, int n2) {
    }

    default public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
    }

    default public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
    }

    default public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
    }

    default public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
    }

    default public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
    }

    default public void updateSupportedBTProfiles(int n, int n2) {
    }

    default public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
    }

    default public void updateUserFriendlyName(String string, int n) {
    }

    default public void updateA2DPUserSetting(boolean bl, int n) {
    }

    default public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
    }

    default public void deviceDisonnectionInfo(String string, String string2, int n) {
    }

    default public void serviceRejectNoSupport(String string, String string2) {
    }

    default public void responseReconnectSuspend(int n) {
    }

    default public void responseSetPriorizedDeviceReconnect(int n) {
    }
}

