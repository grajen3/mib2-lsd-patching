/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public interface DSIPoiOnlineSearchC {
    default public void poiStartSelectionZoom(String string, int n, int n2, int n3, int n4, int n5) {
    }

    default public void dynamicPoiStartSelectionZoom(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    default public void poiStartSelection(String string, int n, int n2, int n3, int n4) {
    }

    default public void dynamicPoiStartSelection(int n, int n2, int n3, int n4, int n5, int n6) {
    }

    default public void poiStopSelection() {
    }

    default public void poiRequestValueList(int n, int n2) {
    }

    default public void poiStartVoiceSelection(int n, int n2, int n3, int n4, boolean bl, int n5) {
    }

    default public void poiRawVoiceDataAvailable(String string, int n) {
    }

    default public void poiRequestSpellingSuggestion() {
    }

    default public void usedPoi(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n) {
    }

    default public void setLanguage(String string) {
    }

    default public void setFallbackLanguage(String string) {
    }

    default public void poiVoiceSearchActive() {
    }

    default public void precheckDynamicPOICategory(int n) {
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

