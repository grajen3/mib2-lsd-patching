/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

public interface ASIHMISyncTVC {
    default public void setActiveStation(long l) {
    }

    default public void logonToTV() {
    }

    default public void logoffFromTV() {
    }

    default public void sendPressedPanelKey(byte by) {
    }

    default public void searchChannel(byte by) {
    }

    default public void setTerminalMode(byte by) {
    }

    default public void setNotification() {
    }

    default public void setNotification(long l) {
    }

    default public void setNotification(long[] lArray) {
    }

    default public void clearNotification() {
    }

    default public void clearNotification(long l) {
    }

    default public void clearNotification(long[] lArray) {
    }
}

