/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.streetview;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.streetview.DSIMapViewerStreetViewCtrlTarget;

class DSIMapViewerStreetViewCtrlTarget$1
implements DSIServiceStateListener {
    private final /* synthetic */ DSIMapViewerStreetViewCtrlTarget this$0;

    DSIMapViewerStreetViewCtrlTarget$1(DSIMapViewerStreetViewCtrlTarget dSIMapViewerStreetViewCtrlTarget) {
        this.this$0 = dSIMapViewerStreetViewCtrlTarget;
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((DSIMapViewerStreetViewCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl == null ? (DSIMapViewerStreetViewCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl = DSIMapViewerStreetViewCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerStreetViewCtrl")) : DSIMapViewerStreetViewCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl).getName()) && !this.this$0.isFirstStartupDone) {
            this.this$0.isFirstStartupDone = true;
            if (this.this$0.datapool.isServiceAvailable()) {
                this.this$0.LOGGER.error("the service 'DSIMapViewerStreetViewCtrl' is already registered, DSIServiceStateListener().registered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesInit();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((DSIMapViewerStreetViewCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl == null ? (DSIMapViewerStreetViewCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl = DSIMapViewerStreetViewCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerStreetViewCtrl")) : DSIMapViewerStreetViewCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl).getName())) {
            if (!this.this$0.datapool.isServiceAvailable()) {
                this.this$0.LOGGER.error("the service 'DSIMapViewerStreetViewCtrl' is not yet registered, DSIServiceStateListener().unregistered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesDisable();
        }
    }
}

