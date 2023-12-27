/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sse;

public interface DSISSEC {
    default public void requestSetMode(int n) {
    }

    default public void requestSetMicGainLevel(int n) {
    }

    default public void requestSetMicMuteState(int n) {
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

