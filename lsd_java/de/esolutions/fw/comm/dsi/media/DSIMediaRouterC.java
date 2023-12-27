/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import org.dsi.ifc.media.AudioRoute;

public interface DSIMediaRouterC {
    default public void registerClient(int n, String string, String string2) {
    }

    default public void unregisterClient(int n) {
    }

    default public void startStreaming(int n) {
    }

    default public void stopStreaming(int n) {
    }

    default public void requestConfiguration(int n, int n2, int n3, int n4) {
    }

    default public void setAudioRoutes(AudioRoute[] audioRouteArray) {
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

