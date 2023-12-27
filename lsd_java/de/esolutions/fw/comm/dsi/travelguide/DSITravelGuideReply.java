/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.travelguide;

import org.dsi.ifc.travelguide.TravelGuideMemoryListElement;

public interface DSITravelGuideReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void importTravelGuideResult(int n, int n2) {
    }

    default public void updateTravelGuideMemoryListElement(TravelGuideMemoryListElement travelGuideMemoryListElement, int n, int n2) {
    }

    default public void deleteTravelGuideResult(int n) {
    }

    default public void updateTravelGuideMemoryList(TravelGuideMemoryListElement[] travelGuideMemoryListElementArray, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

