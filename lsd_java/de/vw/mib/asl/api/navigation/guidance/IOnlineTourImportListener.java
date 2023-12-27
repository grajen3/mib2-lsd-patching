/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.guidance;

import org.dsi.ifc.navigation.NavRmRouteListArrayData;

public interface IOnlineTourImportListener {
    default public void onTourDownload() {
    }

    default public void abortTourDownload() {
    }

    default public void importToursFromGpxResult(int n) {
    }

    default public void updateTourList(NavRmRouteListArrayData navRmRouteListArrayData) {
    }

    default public void updateTourMemoryCapacityManually(Integer n) {
    }

    default public void updateTourMemoryCapacity() {
    }
}

