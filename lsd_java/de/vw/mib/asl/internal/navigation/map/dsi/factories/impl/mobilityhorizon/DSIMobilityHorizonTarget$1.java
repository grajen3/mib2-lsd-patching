/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon;

import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mobilityhorizon.DSIMobilityHorizonTarget;

class DSIMobilityHorizonTarget$1
implements DSIServiceStateListener {
    private final /* synthetic */ DSIMobilityHorizonTarget this$0;

    DSIMobilityHorizonTarget$1(DSIMobilityHorizonTarget dSIMobilityHorizonTarget) {
        this.this$0 = dSIMobilityHorizonTarget;
    }

    @Override
    public void registered(String string, int n) {
        if (string.equals((DSIMobilityHorizonTarget.class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon == null ? (DSIMobilityHorizonTarget.class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon = DSIMobilityHorizonTarget.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon")) : DSIMobilityHorizonTarget.class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon).getName())) {
            if (this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.error("the service 'DSIMobilityHorizon' is already registered, DSIServiceStateListener().registered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesInit();
        }
    }

    @Override
    public void unregistered(String string, int n) {
        if (string.equals((DSIMobilityHorizonTarget.class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon == null ? (DSIMobilityHorizonTarget.class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon = DSIMobilityHorizonTarget.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizon")) : DSIMobilityHorizonTarget.class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizon).getName())) {
            if (!this.this$0.datapool.isServiceAvailable()) {
                this.this$0.logger.error("the service 'DSIMobilityHorizon' is not yet registered, DSIServiceStateListener().unregistered(String, int) will be ignored.");
                return;
            }
            this.this$0.serviceInstancesDisable();
        }
    }
}

