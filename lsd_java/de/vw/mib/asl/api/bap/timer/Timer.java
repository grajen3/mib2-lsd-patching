/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.bap.timer;

public interface Timer {
    default public void retrigger(int n) {
    }

    default public void stop() {
    }

    default public boolean isRunning() {
    }

    default public void setUserInfo(int n) {
    }
}

