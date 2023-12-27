/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.system;

public interface DSIHMIWatchDogC {
    default public void heartbeat(int n) {
    }

    default public void errorlogDumpResult(int n) {
    }

    default public void hmiReady() {
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

