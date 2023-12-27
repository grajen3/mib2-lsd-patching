/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.google.earth;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerGoogleCtrlVW;

public class GoogleEarthSetupNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControlVW;
    private DSIMapViewerGoogleCtrlVW mapViewerGoogleCtrl;

    public void googleEarthSetLanguage(String string) {
        this.mapViewerGoogleCtrl.setLanguage(string);
    }

    public void requestClearCache() {
        this.mapViewerGoogleCtrl.requestClearCache();
    }

    public void setDsiMapViewerControlVW(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControlVW = dSIMapViewerControlVW;
    }

    public void setLayerVisibility(int[] nArray) {
        this.mapViewerGoogleCtrl.setLayerVisibility(nArray);
    }

    public void setMapViewerGoogleCtrl(DSIMapViewerGoogleCtrlVW dSIMapViewerGoogleCtrlVW) {
        this.mapViewerGoogleCtrl = dSIMapViewerGoogleCtrlVW;
    }

    public void setMode(int n) {
        this.dsiMapViewerControlVW.setMode(n);
    }
}

