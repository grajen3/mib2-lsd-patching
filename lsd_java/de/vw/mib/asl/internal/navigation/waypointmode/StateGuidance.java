/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.internal.navigation.waypointmode.HsmTargetWayPointMode;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmPersistence;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateGuidance
extends AbstractHsmState
implements TargetForFullFactoryReset {
    private final HsmTargetWayPointMode target;
    private FactoryResetParticipantWithCallback fullFactoryResetParticipant;

    public StateGuidance(HsmTargetWayPointMode hsmTargetWayPointMode, String string, HsmState hsmState) {
        super(hsmTargetWayPointMode.getHsm(), string, hsmState);
        this.target = hsmTargetWayPointMode;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                if (this.fullFactoryResetParticipant != null) break;
                this.fullFactoryResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForFullFactoryResetAndAddToService(this);
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.target.getModelNotifier().setCurrentWPMModeDrive();
                this.target.getInternalAPINotifier().setCurrentWPMModeDrive();
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmMode(1);
                WpmPersistence.getInstance().setLastActiveTrack(this.target.getDataPool().getSelectedtTour().getTraceID().getElements());
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmLocation(null);
                if (this.fullFactoryResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeFullFactoryResetParticipantFromService(this.fullFactoryResetParticipant);
                this.fullFactoryResetParticipant = null;
                break;
            }
            case 1073744732: {
                this.target.traceState(this, "SKIP_NEXT_WAY_POINT");
                this.target.getDsiNotifier().skipWayPoints(1);
                break;
            }
            default: {
                return this.myParent;
            }
        }
        return null;
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        if (!bl) {
            this.trans(this.target.stateDefault);
        }
    }

    @Override
    public void handleFullFacotryReset() {
        this.fullFactoryResetParticipant.notifyResetDone();
        this.trans(this.target.stateDefault);
        this.target.getHsm().activateTransition();
    }
}

