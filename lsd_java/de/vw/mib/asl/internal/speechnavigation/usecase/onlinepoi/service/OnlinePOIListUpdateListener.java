/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.service;

import de.vw.mib.asl.internal.speechnavigation.usecase.onlinepoi.model.OnlinePOI;

public interface OnlinePOIListUpdateListener {
    default public void onNewDataReceived(OnlinePOI[] onlinePOIArray) {
    }

    default public void onError(int n) {
    }
}

