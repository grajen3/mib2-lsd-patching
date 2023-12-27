/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.navigation.DSINavigationTarget;

class DSINavigationTarget$1
implements DSIServiceStateListener {
    private final /* synthetic */ DSINavigationTarget this$0;

    DSINavigationTarget$1(DSINavigationTarget dSINavigationTarget) {
        this.this$0 = dSINavigationTarget;
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((DSINavigationTarget.class$org$dsi$ifc$navigation$DSINavigation == null ? (DSINavigationTarget.class$org$dsi$ifc$navigation$DSINavigation = DSINavigationTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : DSINavigationTarget.class$org$dsi$ifc$navigation$DSINavigation).getName())) {
            if (this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.error("the service 'DSINavigation' is already registered, DSIServiceStateListener().registered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesInit();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((DSINavigationTarget.class$org$dsi$ifc$navigation$DSINavigation == null ? (DSINavigationTarget.class$org$dsi$ifc$navigation$DSINavigation = DSINavigationTarget.class$("org.dsi.ifc.navigation.DSINavigation")) : DSINavigationTarget.class$org$dsi$ifc$navigation$DSINavigation).getName())) {
            if (!this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.error("the service 'DSINavigation' is not yet registered, DSIServiceStateListener().unregistered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesDisable();
        }
    }
}

