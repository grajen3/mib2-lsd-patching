/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.smartphoneintegration;

import org.dsi.ifc.smartphoneintegration.Device;

public interface DSISmartphoneIntegrationReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateDiscoveredDevices(Device[] deviceArray, int n) {
    }

    default public void updateDeviceConnectionState(int n, int n2, int n3, int n4) {
    }

    default public void responseFactorySettings(int n, boolean bl) {
    }

    default public void updateSWaPStatus(int n, int n2) {
    }

    default public void updateUSBResetActive(boolean bl, int n) {
    }

    default public void updateAppConnectContextRequested(boolean bl, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

