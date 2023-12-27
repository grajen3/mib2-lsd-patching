/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi.ext.api.online;

import de.vw.mib.asl.framework.internal.framework.dsi.ext.api.ComplexAnalyzer;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public class DSIPoiOnlineSearchComplexAnalyzer
extends ComplexAnalyzer
implements DSIPoiOnlineSearchListener {
    private final int poiStartSelectionMid;
    private int dynamicPoiStartSelectionMid;
    private final int poiStartVoiceSelectionMid;
    private final int poiRequestValueListMid;
    private int[] methodHistory = new int[4];
    private static final int MARK_POI_VALUE_LIST;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearch;

    private void pushHistoryItem(int n) {
        for (int i2 = 1; i2 < this.methodHistory.length; ++i2) {
            this.methodHistory[i2 - 1] = this.methodHistory[i2];
        }
        this.methodHistory[this.methodHistory.length - 1] = n;
    }

    private void checkComplete() {
        if (this.analyzedServiceMethodId == this.poiStartSelectionMid || this.analyzedServiceMethodId == this.poiStartVoiceSelectionMid || this.analyzedServiceMethodId == this.poiRequestValueListMid || this.analyzedServiceMethodId == this.dynamicPoiStartSelectionMid) {
            if (this.methodHistory[this.methodHistory.length - 1] + this.methodHistory[this.methodHistory.length - 2] == 10011) {
                this.finished = true;
            } else if (this.methodHistory[this.methodHistory.length - 1] != 11 && this.methodHistory[this.methodHistory.length - 1] != 10000 && this.methodHistory[this.methodHistory.length - 1] != 10) {
                this.finished = true;
            }
        }
    }

    public DSIPoiOnlineSearchComplexAnalyzer() {
        this.poiStartSelectionMid = this.getServiceMethodId(class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = DSIPoiOnlineSearchComplexAnalyzer.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch, "poiStartSelection");
        this.dynamicPoiStartSelectionMid = this.getServiceMethodId(class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = DSIPoiOnlineSearchComplexAnalyzer.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch, "dynamicPoiStartSelection");
        this.poiStartVoiceSelectionMid = this.getServiceMethodId(class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = DSIPoiOnlineSearchComplexAnalyzer.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch, "poiStartVoiceSelection");
        this.poiRequestValueListMid = this.getServiceMethodId(class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = DSIPoiOnlineSearchComplexAnalyzer.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch, "poiRequestValueList");
    }

    @Override
    public void setPrecondition(int n) {
        super.setPrecondition(n);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void poiResult(int n, int n2, int n3) {
        this.pushHistoryItem(n3);
        this.checkComplete();
    }

    @Override
    public void poiSpellingSuggestion(int n, String string, String[] stringArray) {
    }

    @Override
    public void poiValueList(int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        this.pushHistoryItem(10000);
        this.checkComplete();
    }

    @Override
    public void precheckDynamicPOICategoryResponse(int n, OSRServiceState oSRServiceState) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

