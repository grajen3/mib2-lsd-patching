/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public interface DSIPoiOnlineSearchListener
extends DSIListener {
    default public void poiResult(int n, int n2, int n3) {
    }

    default public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
    }

    default public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
    }

    default public void precheckDynamicPOICategoryResponse(int n, OSRServiceState oSRServiceState) {
    }
}

