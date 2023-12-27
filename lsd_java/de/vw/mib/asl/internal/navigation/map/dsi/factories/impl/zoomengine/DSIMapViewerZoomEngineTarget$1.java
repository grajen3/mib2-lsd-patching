/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine.DSIMapViewerZoomEngineTarget;

class DSIMapViewerZoomEngineTarget$1
implements DSIServiceStateListener {
    private final /* synthetic */ DSIMapViewerZoomEngineTarget this$0;

    DSIMapViewerZoomEngineTarget$1(DSIMapViewerZoomEngineTarget dSIMapViewerZoomEngineTarget) {
        this.this$0 = dSIMapViewerZoomEngineTarget;
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((DSIMapViewerZoomEngineTarget.class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (DSIMapViewerZoomEngineTarget.class$org$dsi$ifc$map$DSIMapViewerZoomEngine = DSIMapViewerZoomEngineTarget.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : DSIMapViewerZoomEngineTarget.class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName()) && !this.this$0.isFirstStartupDone) {
            this.this$0.isFirstStartupDone = true;
            if (this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.error("the service 'DSIMapViewerZoomEngine' is already registered, DSIServiceStateListener().registered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesInit();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((DSIMapViewerZoomEngineTarget.class$org$dsi$ifc$map$DSIMapViewerZoomEngine == null ? (DSIMapViewerZoomEngineTarget.class$org$dsi$ifc$map$DSIMapViewerZoomEngine = DSIMapViewerZoomEngineTarget.class$("org.dsi.ifc.map.DSIMapViewerZoomEngine")) : DSIMapViewerZoomEngineTarget.class$org$dsi$ifc$map$DSIMapViewerZoomEngine).getName())) {
            if (!this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.error("the service 'DSIMapViewerZoomEngine' is not yet registered, DSIServiceStateListener().unregistered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesDisable();
        }
    }
}

