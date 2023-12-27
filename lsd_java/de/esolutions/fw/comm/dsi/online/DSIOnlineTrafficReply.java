/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import org.dsi.ifc.online.FCDPosition;
import org.dsi.ifc.online.LocatablePosition;

public interface DSIOnlineTrafficReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateConsumerReady(int n, int n2) {
    }

    default public void updateWantOnlineTrafficData(int n, int n2) {
    }

    default public void getNewDataResult(int n, LocatablePosition[] locatablePositionArray) {
    }

    default public void setNewDataResult(String string, int n) {
    }

    default public void getNewSession() {
    }

    default public void setTimeoutForFallbackResult(int n) {
    }

    default public void getNewFCDInformationResult(FCDPosition fCDPosition) {
    }

    default public void getInventoryResult(String string) {
    }

    default public void getDownloadFileResult(String string) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

