/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travelguide;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.travelguide.TravelGuideMemoryListElement;

public interface DSITravelGuideListener
extends DSIListener {
    default public void importTravelGuideResult(int n, int n2) {
    }

    default public void updateTravelGuideMemoryListElement(TravelGuideMemoryListElement travelGuideMemoryListElement, int n, int n2) {
    }

    default public void deleteTravelGuideResult(int n) {
    }

    default public void updateTravelGuideMemoryList(TravelGuideMemoryListElement[] travelGuideMemoryListElementArray, int n) {
    }
}

