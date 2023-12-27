/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth;

public interface DSIBluetoothC {
    default public void abortConnectService(String string) {
    }

    default public void abortInquiry() {
    }

    default public void requestAcceptIncomingServiceRequest(String string, int n, boolean bl) {
    }

    default public void requestConnectService(String string, int n, int n2) {
    }

    default public void requestConnectServiceToInstance(String string, int n, int n2) {
    }

    default public void requestDisconnectService(String string, int n) {
    }

    default public void requestGetServices(String string) {
    }

    default public void requestInquiry(int n, int n2, int n3) {
    }

    default public void requestPasskeyResponse(String string, String string2, int n) {
    }

    default public void requestReconnectSuspend(boolean bl) {
    }

    default public void requestRemoveAuthentication(String string) {
    }

    default public void requestRestoreFactorySettings() {
    }

    default public void requestSetA2DPUserSetting(boolean bl) {
    }

    default public void requestSwitchBTState(int n) {
    }

    default public void setAccessibleMode(int n) {
    }

    default public void setUserFriendlyName(String string) {
    }

    default public void requestSetPriorizedDeviceReconnect(boolean bl, String string) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

