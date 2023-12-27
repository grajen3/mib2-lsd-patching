/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.smartphoneintegration;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.smartphoneintegration.Device;

public interface DSISmartphoneIntegrationListener
extends DSIListener {
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
}

