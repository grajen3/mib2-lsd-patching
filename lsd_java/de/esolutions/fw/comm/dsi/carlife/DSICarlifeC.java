/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife;

import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;

public interface DSICarlifeC {
    default public void startService(ServiceConfiguration serviceConfiguration) {
    }

    default public void postButtonEvent(int n, int n2) {
    }

    default public void postTouchEvent(int n, TouchEvent[] touchEventArray, int n2) {
    }

    default public void postRotaryEvent(int n) {
    }

    default public void postCharacterEvent(int n, String[] stringArray) {
    }

    default public void setMode(Resource[] resourceArray, AppState[] appStateArray) {
    }

    default public void requestNightMode(boolean bl) {
    }

    default public void responseModeChange(Resource[] resourceArray, AppState[] appStateArray) {
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

