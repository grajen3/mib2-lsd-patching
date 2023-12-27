/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.FCDPosition;
import org.dsi.ifc.online.LocatablePosition;

public interface DSIOnlineTrafficListener
extends DSIListener {
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
}

