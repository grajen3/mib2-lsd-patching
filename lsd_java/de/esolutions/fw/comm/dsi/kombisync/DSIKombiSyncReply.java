/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync;

import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.KombiPopupStatus;

public interface DSIKombiSyncReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

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

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

