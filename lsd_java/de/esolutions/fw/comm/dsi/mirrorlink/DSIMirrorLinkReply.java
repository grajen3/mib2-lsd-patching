/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink;

import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.Notification;

public interface DSIMirrorLinkReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void responseClientCapabilities(int n) {
    }

    default public void responseAccessMode(int n, int n2) {
    }

    default public void responseDayNightMode(int n, int n2) {
    }

    default public void responseUsableViewPort(int n, int n2, int n3, int n4, int n5) {
    }

    default public void responseContextVisible(boolean bl, int n) {
    }

    default public void responseConnectDevice(int n, int n2) {
    }

    default public void responseDisconnectDevice(int n, int n2) {
    }

    default public void responseRotateScreen(int n, int n2) {
    }

    default public void responseSoftKeyEvent(int n, int n2, int n3) {
    }

    default public void responseLaunchApp(int n, int n2) {
    }

    default public void responseTerminateApp(int n, int n2) {
    }

    default public void responseSpellerResult(String string, String string2, boolean bl, int n) {
    }

    default public void responseSendString(int n) {
    }

    default public void responseAudioOption(int n, int n2) {
    }

    default public void responseAudioConnectionAudible(int n, boolean bl, int n2) {
    }

    default public void responseSendTouchEvents(int n) {
    }

    default public void updateDiscoveredDevices(Device[] deviceArray, int n) {
    }

    default public void updateDeviceConnectionStatus(int n, int n2, int n3) {
    }

    default public void updateDeviceSoftKeys(int[] nArray, int n) {
    }

    default public void updateApplicationStatus(int n, int n2, int n3, int n4) {
    }

    default public void updateScreenOrientation(int n, int n2) {
    }

    default public void updateShowKeyboard(int n, String string, int n2) {
    }

    default public void updateScreenOrientationAvailable(boolean bl, int n) {
    }

    default public void updateScreenRotationAvailable(boolean bl, int n) {
    }

    default public void updateAudioConnectionRequested(int n, boolean bl, int n2) {
    }

    default public void responseKeyboardMode(int n, int n2) {
    }

    default public void updateAvailableApplicationsList(int n, int n2) {
    }

    default public void responseAvailableApplicationsWindow(int n, Application[] applicationArray, int n2) {
    }

    default public void updateSingleApplicationMode(boolean bl, int n) {
    }

    default public void responseDisplayKeyboard(int n, int n2) {
    }

    default public void responseDismissHMIKeyboard(int n) {
    }

    default public void responseFactorySettings(int n) {
    }

    default public void updatePhoneViewAvailable(boolean bl, int n) {
    }

    default public void responsePhoneView(int n) {
    }

    default public void updateUncertifiedContent(boolean bl, int n) {
    }

    default public void updateDeviceStatus(int n, int n2) {
    }

    default public void updateSWaPStatus(int n, int n2) {
    }

    default public void responseContextSwitched() {
    }

    default public void updateShowNotification(Notification notification, int n) {
    }

    default public void updateNotificationServiceEnabled(boolean bl, int n) {
    }

    default public void updateLocationDataServicesEnabled(boolean bl, int n) {
    }

    default public void updateSwitchToClientNativeUI(int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

