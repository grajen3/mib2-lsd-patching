/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status.DSIMapViewerStatusTarget;

class DSIMapViewerStatusTarget$1
implements DSIServiceStateListener {
    private final /* synthetic */ DSIMapViewerStatusTarget this$0;

    DSIMapViewerStatusTarget$1(DSIMapViewerStatusTarget dSIMapViewerStatusTarget) {
        this.this$0 = dSIMapViewerStatusTarget;
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((DSIMapViewerStatusTarget.class$org$dsi$ifc$map$DSIMapViewerControl == null ? (DSIMapViewerStatusTarget.class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerStatusTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : DSIMapViewerStatusTarget.class$org$dsi$ifc$map$DSIMapViewerControl).getName()) && n == this.this$0.datapool.getServiceInstanceId() && !this.this$0.isFirstStartupDone) {
            this.this$0.isFirstStartupDone = true;
            if (this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.makeError().append("the service 'DSIMapViewerControl' with instance id '").append(this.this$0.datapool.getServiceInstanceId()).append("' is already registered, DSIServiceStateListener().registered(String, int) will be ignored.").log();
                return;
            }
            this.this$0.logger.info("registered");
            this.this$0.startMapViewer();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((DSIMapViewerStatusTarget.class$org$dsi$ifc$map$DSIMapViewerControl == null ? (DSIMapViewerStatusTarget.class$org$dsi$ifc$map$DSIMapViewerControl = DSIMapViewerStatusTarget.class$("org.dsi.ifc.map.DSIMapViewerControl")) : DSIMapViewerStatusTarget.class$org$dsi$ifc$map$DSIMapViewerControl).getName()) && n == this.this$0.datapool.getServiceInstanceId()) {
            if (!this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.makeError().append("the service 'DSIMapViewerControl' with instance id '").append(this.this$0.datapool.getServiceInstanceId()).append("' is not yet registered, DSIServiceStateListener().unregistered(String, int) will be ignored.");
                return;
            }
            this.this$0.logger.info("unregistered");
            this.this$0.stopMapViewer();
        }
    }
}

