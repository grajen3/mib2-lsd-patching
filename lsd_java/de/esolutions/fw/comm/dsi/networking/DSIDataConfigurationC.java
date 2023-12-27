/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

import org.dsi.ifc.networking.CDataProfile;

public interface DSIDataConfigurationC {
    default public void setDataProfile(CDataProfile cDataProfile) {
    }

    default public void automaticProfile(int n) {
    }

    default public void setRoamingState(int n) {
    }

    default public void setConnectionMode(int n) {
    }

    default public void setRequestSetting(int n, int n2) {
    }

    default public void acceptDataRequest(int n, boolean bl) {
    }

    default public void resetPacketCounter() {
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

