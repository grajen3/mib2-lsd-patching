/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.laneguidance;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.guidance.laneguidance.HsmTargetLaneGuidance;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateWork
extends AbstractHsmState {
    private HsmTargetLaneGuidance target;
    private boolean isServiceStateListenerAdded = false;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$navigation$guidance$laneguidance$HsmTargetLaneGuidance;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;

    public StateWork(HsmTargetLaneGuidance hsmTargetLaneGuidance, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetLaneGuidance;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.trace(new StringBuffer((class$de$vw$mib$asl$internal$navigation$guidance$laneguidance$HsmTargetLaneGuidance == null ? (class$de$vw$mib$asl$internal$navigation$guidance$laneguidance$HsmTargetLaneGuidance = StateWork.class$("de.vw.mib.asl.internal.navigation.guidance.laneguidance.HsmTargetLaneGuidance")) : class$de$vw$mib$asl$internal$navigation$guidance$laneguidance$HsmTargetLaneGuidance).getName()).append(" HSM_ENTRY").toString());
                if (this.isServiceStateListenerAdded) break;
                this.isServiceStateListenerAdded = true;
                ServiceManager.dsiServiceLocator.addServiceStateListener(class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = StateWork.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation, this.target);
                break;
            }
            case 4: {
                this.target.trace(new StringBuffer((class$de$vw$mib$asl$internal$navigation$guidance$laneguidance$HsmTargetLaneGuidance == null ? (class$de$vw$mib$asl$internal$navigation$guidance$laneguidance$HsmTargetLaneGuidance = StateWork.class$("de.vw.mib.asl.internal.navigation.guidance.laneguidance.HsmTargetLaneGuidance")) : class$de$vw$mib$asl$internal$navigation$guidance$laneguidance$HsmTargetLaneGuidance).getName()).append(" HSM_EXIT").toString());
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

