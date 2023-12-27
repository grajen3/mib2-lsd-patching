/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.startup;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.navigation.startup.NavStartupTarget;

public class NavStartupTarget$DSIMapServiceStateListener
implements DSIServiceStateListener {
    private boolean googleStreetViewRegistered;
    private final /* synthetic */ NavStartupTarget this$0;

    protected NavStartupTarget$DSIMapServiceStateListener(NavStartupTarget navStartupTarget) {
        this.this$0 = navStartupTarget;
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((NavStartupTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl == null ? (NavStartupTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl = NavStartupTarget.class$("org.dsi.ifc.map.DSIMapViewerStreetViewCtrl")) : NavStartupTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl).getName())) {
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace("The Google StreetView Ctrl was registred");
            }
            if (this.googleStreetViewRegistered) {
                this.this$0.error("Google StreetView is already registered, a second registration is an Error!");
                return;
            }
            this.googleStreetViewRegistered = true;
            this.this$0.googleStreetViewAvaiable();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((NavStartupTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl == null ? (NavStartupTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl = NavStartupTarget.class$("org.dsi.ifc.map.DSIMapViewerStreetViewCtrl")) : NavStartupTarget.class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrl).getName())) {
            if (this.this$0.isTraceEnabled()) {
                this.this$0.trace("The Google StreetView Ctrl was unregistred");
            }
            if (!this.googleStreetViewRegistered) {
                this.this$0.error("Google StreetView is was not yet registered, a unregistration is an error!");
                return;
            }
            this.googleStreetViewRegistered = false;
            this.this$0.googleStreetViewNotAvaiable();
        }
    }
}

