/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

public interface DSINADC {
    default public void requestNetworkRegistration(String string, int n) {
    }

    default public void requestAbortNetworkRegistration() {
    }

    default public void requestNetworkSearch() {
    }

    default public void requestAbortNetworkSearch() {
    }

    default public void requestSetAutomaticPinEntryActive(boolean bl) {
    }

    default public void requestTelPower(int n) {
    }

    default public void requestUnlockSIM(int n, String string, String string2) {
    }

    default public void requestCheckSIMPINCode(String string) {
    }

    default public void requestChangeSIMCode(int n, String string, String string2) {
    }

    default public void requestSIMPINRequired(String string, boolean bl) {
    }

    default public void restoreFactorySettings() {
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

