/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.HsmTargetLaneGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

class HsmTargetLaneGuidance$1
extends AbstractHsmState {
    private boolean isServiceStateListenerAdded;
    private final /* synthetic */ HsmTargetLaneGuidance this$0;

    HsmTargetLaneGuidance$1(HsmTargetLaneGuidance hsmTargetLaneGuidance, Hsm hsm, String string, HsmState hsmState) {
        this.this$0 = hsmTargetLaneGuidance;
        super(hsm, string, hsmState);
        this.isServiceStateListenerAdded = false;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.this$0.trace(new StringBuffer((HsmTargetLaneGuidance.class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance == null ? (HsmTargetLaneGuidance.class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance = HsmTargetLaneGuidance.class$("de.vw.mib.asl.internal.navigation.guidance.HsmTargetLaneGuidance")) : HsmTargetLaneGuidance.class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance).getName()).append(" HSM_ENTRY").toString());
                if (this.isServiceStateListenerAdded) break;
                this.isServiceStateListenerAdded = true;
                ServiceManager.dsiServiceLocator.addServiceStateListener(HsmTargetLaneGuidance.class$org$dsi$ifc$navigation$DSINavigation == null ? (HsmTargetLaneGuidance.class$org$dsi$ifc$navigation$DSINavigation = HsmTargetLaneGuidance.class$("org.dsi.ifc.navigation.DSINavigation")) : HsmTargetLaneGuidance.class$org$dsi$ifc$navigation$DSINavigation, this.this$0);
                break;
            }
            case 4: {
                this.this$0.trace(new StringBuffer((HsmTargetLaneGuidance.class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance == null ? (HsmTargetLaneGuidance.class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance = HsmTargetLaneGuidance.class$("de.vw.mib.asl.internal.navigation.guidance.HsmTargetLaneGuidance")) : HsmTargetLaneGuidance.class$de$vw$mib$asl$internal$navigation$guidance$HsmTargetLaneGuidance).getName()).append(" HSM_EXIT").toString());
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

