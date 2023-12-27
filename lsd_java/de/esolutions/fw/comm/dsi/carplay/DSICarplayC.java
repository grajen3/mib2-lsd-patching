/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay;

import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public interface DSICarplayC {
    default public void startService(ServiceConfiguration serviceConfiguration) {
    }

    default public void postButtonEvent(int n, int n2) {
    }

    default public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
    }

    default public void postRotaryEvent(int n) {
    }

    default public void postCharacterEvent(int n, String[] stringArray) {
    }

    default public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
    }

    default public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
    }

    default public void responseBTDeactivation() {
    }

    default public void requestUI(int n) {
    }

    default public void requestNightMode(boolean bl) {
    }

    default public void requestSIRIAction(int n) {
    }

    default public void responseUpdateMainAudioType(int n) {
    }

    default public void requestUI2(String string) {
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

