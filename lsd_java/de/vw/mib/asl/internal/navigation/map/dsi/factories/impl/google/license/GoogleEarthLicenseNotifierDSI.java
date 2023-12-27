/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerGoogleCtrlVW;

public class GoogleEarthLicenseNotifierDSI {
    private DSIMapViewerGoogleCtrlVW dsiMapViewerGoogleCtrl;

    public void setConnectionInformationAllow() {
        this.dsiMapViewerGoogleCtrl.setConnectionInformation(0);
    }

    public void setConnectionInformationForbidden() {
        this.dsiMapViewerGoogleCtrl.setConnectionInformation(255);
    }

    public void setDsiMapViewerGoogleCtrl(DSIMapViewerGoogleCtrlVW dSIMapViewerGoogleCtrlVW) {
        this.dsiMapViewerGoogleCtrl = dSIMapViewerGoogleCtrlVW;
    }
}

