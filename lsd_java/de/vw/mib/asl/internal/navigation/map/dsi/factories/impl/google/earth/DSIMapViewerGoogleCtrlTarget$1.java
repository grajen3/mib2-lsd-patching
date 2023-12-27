/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth.DSIMapViewerGoogleCtrlTarget;

class DSIMapViewerGoogleCtrlTarget$1
implements DSIServiceStateListener {
    private final /* synthetic */ DSIMapViewerGoogleCtrlTarget this$0;

    DSIMapViewerGoogleCtrlTarget$1(DSIMapViewerGoogleCtrlTarget dSIMapViewerGoogleCtrlTarget) {
        this.this$0 = dSIMapViewerGoogleCtrlTarget;
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((DSIMapViewerGoogleCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (DSIMapViewerGoogleCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = DSIMapViewerGoogleCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : DSIMapViewerGoogleCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl).getName()) && !this.this$0.isFirstStartupDone) {
            this.this$0.isFirstStartupDone = true;
            if (this.this$0.datapool.isServiceAvailable()) {
                this.this$0.LOGGER.error("the service 'DSIMapViewerGoogleCtrl' is already registered, DSIServiceStateListener().registered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesInit();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((DSIMapViewerGoogleCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl == null ? (DSIMapViewerGoogleCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl = DSIMapViewerGoogleCtrlTarget.class$("org.dsi.ifc.map.DSIMapViewerGoogleCtrl")) : DSIMapViewerGoogleCtrlTarget.class$org$dsi$ifc$map$DSIMapViewerGoogleCtrl).getName())) {
            if (!this.this$0.datapool.isServiceAvailable()) {
                this.this$0.LOGGER.error("the service 'DSIMapViewerGoogleCtrl' is not yet registered, DSIServiceStateListener().unregistered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesDisable();
        }
    }
}

