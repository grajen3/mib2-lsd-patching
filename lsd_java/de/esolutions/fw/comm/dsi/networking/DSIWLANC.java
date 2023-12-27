/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

import org.dsi.ifc.networking.Profile;

public interface DSIWLANC {
    default public void factoryReset() {
    }

    default public void setRole(int n) {
    }

    default public void setRFActive(boolean bl) {
    }

    default public void setProfile(Profile profile) {
    }

    default public void requestNetworkSearch(int n, int n2) {
    }

    default public void requestAbortSearch() {
    }

    default public void requestConnectNetwork(String string, String string2, String string3, int n) {
    }

    default public void requestDisconnectNetwork(String string, String string2) {
    }

    default public void requestDeleteTrustedNetwork(String string, String string2) {
    }

    default public void requestActivateWps(int n, int n2, int n3) {
    }

    default public void requestCancelWPS() {
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

