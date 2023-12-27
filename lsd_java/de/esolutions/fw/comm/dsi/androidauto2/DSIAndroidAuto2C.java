/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2;

import org.dsi.ifc.androidauto2.ServiceConfiguration;
import org.dsi.ifc.androidauto2.TouchEvent;

public interface DSIAndroidAuto2C {
    default public void videoFocusNotification(int n, boolean bl) {
    }

    default public void audioFocusNotification(int n, boolean bl) {
    }

    default public void microphoneNotification(int n, boolean bl) {
    }

    default public void navFocusNotification(int n, boolean bl) {
    }

    default public void startService(ServiceConfiguration serviceConfiguration) {
    }

    default public void postButtonEvent(int n, int n2) {
    }

    default public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2, int n3) {
    }

    default public void postRotaryEvent(int n) {
    }

    default public void setNightMode(boolean bl) {
    }

    default public void bluetoothPairingResponse(boolean bl) {
    }

    default public void bluetoothAuthenticationData(String string) {
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

