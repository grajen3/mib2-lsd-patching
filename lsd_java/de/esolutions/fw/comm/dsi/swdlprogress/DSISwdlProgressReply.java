/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlprogress;

import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public interface DSISwdlProgressReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateGeneralProgress(GeneralProgress generalProgress, int n) {
    }

    default public void updateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray, int n) {
    }

    default public void updateTriggerPanel(int n, int n2) {
    }

    default public void updateLostDevices(String[] stringArray, int n) {
    }

    default public void updateOverviewStatus(int n, int n2) {
    }

    default public void updateActiveDevices(String[] stringArray, int n) {
    }

    default public void getStaticProgressDetails(int n, int n2, short s, String string) {
    }

    default public void getDynamicProgressDetails(int n, byte by, String string) {
    }

    default public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
    }

    default public void indicateDismissPopUp(int n, String string) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

