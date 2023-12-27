/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.adbedit.DSIAdbEditTarget;

class DSIAdbEditTarget$1
implements DSIServiceStateListener {
    private final /* synthetic */ DSIAdbEditTarget this$0;

    DSIAdbEditTarget$1(DSIAdbEditTarget dSIAdbEditTarget) {
        this.this$0 = dSIAdbEditTarget;
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((DSIAdbEditTarget.class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (DSIAdbEditTarget.class$org$dsi$ifc$organizer$DSIAdbEdit = DSIAdbEditTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : DSIAdbEditTarget.class$org$dsi$ifc$organizer$DSIAdbEdit).getName()) && !this.this$0.isFirstStartupDone) {
            this.this$0.isFirstStartupDone = true;
            if (this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.error("the service 'DSIAdbEdit' is already registered, DSIServiceStateListener().registered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesInit();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((DSIAdbEditTarget.class$org$dsi$ifc$organizer$DSIAdbEdit == null ? (DSIAdbEditTarget.class$org$dsi$ifc$organizer$DSIAdbEdit = DSIAdbEditTarget.class$("org.dsi.ifc.organizer.DSIAdbEdit")) : DSIAdbEditTarget.class$org$dsi$ifc$organizer$DSIAdbEdit).getName())) {
            if (!this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.error("the service 'DSIAdbEdit' is not yet registered, DSIServiceStateListener().unregistered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesDisable();
        }
    }
}

