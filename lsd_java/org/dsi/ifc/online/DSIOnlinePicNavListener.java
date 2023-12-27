/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.PicNavSyncInfo;

public interface DSIOnlinePicNavListener
extends DSIListener {
    default public void updateSyncStatus(int n, int n2) {
    }

    default public void synchronizeResult(int n, PicNavSyncInfo picNavSyncInfo) {
    }

    default public void getPendingTransactionsResult(int n, PicNavSyncInfo picNavSyncInfo) {
    }

    default public void setActiveProfileResult(int n) {
    }
}

