/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;

public interface DSIDataConfigurationReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
    }

    default public void updateActiveProfile(int n, int n2) {
    }

    default public void updateRoamingState(int n, int n2) {
    }

    default public void updateConnectionMode(int n, int n2) {
    }

    default public void updateDataRequest(int n, int n2) {
    }

    default public void updateRequestSetting(int n, int n2, int n3) {
    }

    default public void setDataProfileResponse(CDataProfile cDataProfile, int n) {
    }

    default public void automaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
    }

    default public void setRoamingStateResponse(int n) {
    }

    default public void setConnectionModeResponse(int n) {
    }

    default public void setRequestSettingResponse(int n) {
    }

    default public void acceptDataRequestResponse(int n) {
    }

    default public void resetPacketCounterResponse(int n) {
    }

    default public void restoreFactorySettingsResponse(int n) {
    }

    default public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

