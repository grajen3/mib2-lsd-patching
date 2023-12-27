/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink;

import org.dsi.ifc.mirrorlink.ClientCapabilities;
import org.dsi.ifc.mirrorlink.Event;

public interface DSIMirrorLinkC {
    default public void requestClientCapabilities(ClientCapabilities clientCapabilities) {
    }

    default public void requestAccessMode(int n) {
    }

    default public void requestDayNightMode(int n) {
    }

    default public void requestUsableViewport(int n, int n2, int n3, int n4) {
    }

    default public void requestContextVisible(boolean bl) {
    }

    default public void requestConnectDevice(int n) {
    }

    default public void requestDisconnectDevice(int n) {
    }

    default public void requestRotateScreen(int n) {
    }

    default public void requestChangeOrientation(int n) {
    }

    default public void requestSoftKeyEvent(int n, int n2) {
    }

    default public void requestLaunchApp(int n) {
    }

    default public void requestTerminateApp(int n) {
    }

    default public void requestStartSpeller(String string) {
    }

    default public void requestAddSpellerChars(String string) {
    }

    default public void requestRemoveSpellerChar() {
    }

    default public void requestClearSpeller() {
    }

    default public void requestSendString(String string) {
    }

    default public void requestAudioOption(int n) {
    }

    default public void requestAudioConnectionAudible(int n, boolean bl) {
    }

    default public void requestSendTouchEvents(Event[] eventArray, int n) {
    }

    default public void requestKeyboardMode(int n) {
    }

    default public void requestAvailableApplicationsWindow(int n, int n2) {
    }

    default public void requestDisplayKeyboard() {
    }

    default public void requestDismissHMIKeyboard() {
    }

    default public void requestFactorySettings() {
    }

    default public void requestPhoneView() {
    }

    default public void requestContextSwitched(boolean bl) {
    }

    default public void invokeNotiAction(int n, int n2) {
    }

    default public void requestNotificationServiceEnabled(boolean bl, int n, int n2, int n3, int n4) {
    }

    default public void requestLocationDataServicesEnabled(boolean bl) {
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

