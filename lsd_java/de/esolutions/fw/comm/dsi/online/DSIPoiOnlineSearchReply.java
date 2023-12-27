/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public interface DSIPoiOnlineSearchReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void poiResult(int n, int n2, int n3) {
    }

    default public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
    }

    default public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
    }

    default public void precheckDynamicPOICategoryResponse(int n, OSRServiceState oSRServiceState) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

