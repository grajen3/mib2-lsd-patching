/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombisync;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.KombiPopupStatus;

public interface DSIKombiSyncListener
extends DSIListener {
    default public void updateKombiCommunicationState(boolean bl, int n) {
    }

    default public void updateKombiMessageStateDisplayStatus(int n, int n2) {
    }

    default public void updateKombiMessageStateDisplayRequest(int n, int n2) {
    }

    default public void updateKombiMessageStatePopupStatus(int n, int n2) {
    }

    default public void responseKombiDisplayStatus(KombiDisplayStatus kombiDisplayStatus, int n) {
    }

    default public void responseKombiDisplayRequest(KombiDisplayRequest kombiDisplayRequest) {
    }

    default public void responseKombiPopupStatus(KombiPopupStatus kombiPopupStatus, int n) {
    }
}

