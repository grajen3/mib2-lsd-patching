/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.trafficmap;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;

public class TrafficMapSetupNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;

    void dsiMapViewerMainSetTrafficMapStyleFalse() {
        this.dsiMapViewerControl.setTrafficMapStyle(false);
    }

    void dsiMapViewerMainSetTrafficMapStyleTrue() {
        this.dsiMapViewerControl.setTrafficMapStyle(true);
    }

    void setMapViewerControl(DSIMapViewerControlVW dSIMapViewerControlVW) {
        this.dsiMapViewerControl = dSIMapViewerControlVW;
    }

    void setSpeedAndFlowRoadClass(int n) {
        this.dsiMapViewerControl.setSpeedAndFlowRoadClass(n);
    }

    void setTrafficShowCongestion(boolean bl) {
        this.dsiMapViewerControl.showSpeedAndFlowCongestions(bl);
    }

    void setTrafficShowFreeFlow(boolean bl) {
        this.dsiMapViewerControl.showSpeedAndFlowFreeFlow(bl);
    }

    void setTrafficShowIncidents(boolean bl) {
        this.dsiMapViewerControl.showTMCMessages(bl);
    }
}

