/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.smartphoneintegration;

import org.dsi.ifc.base.DSIBase;

public interface DSISmartphoneIntegration
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_DISCOVEREDDEVICES;
    public static final int ATTR_DEVICECONNECTIONSTATE;
    public static final int ATTR_SWAPSTATUS;
    public static final int ATTR_USBRESETACTIVE;
    public static final int ATTR_APPCONNECTCONTEXTREQUESTED;
    public static final int RT_CONNECTDEVICE;
    public static final int RT_DISCONNECTDEVICE;
    public static final int RT_REQUESTFACTORYSETTINGS;
    public static final int RT_REQUESTAPPCONNECTCONTEXTACTIVE;
    public static final int RP_RESPONSEFACTORYSETTINGS;

    default public void connectDevice(int n, int n2) {
    }

    default public void disconnectDevice(int n) {
    }

    default public void requestFactorySettings(int n) {
    }

    default public void requestAppConnectContextActive(boolean bl) {
    }
}

