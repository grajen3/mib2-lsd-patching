/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class OverlaysStateInit
extends AbstractHsmState
implements ReloadPersistedDataListener {
    private static final int[] OBSERVERS = new int[]{-355987392, -322432960, -339210176, -372764608, 956432448, 973209664, 989986880, 1006764096, 75956480};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[OverlaysTargetHSM - OverlaysStateInit]");
    private final OverlaysTargetHSM target;

    public OverlaysStateInit(OverlaysTargetHSM overlaysTargetHSM, String string, HsmState hsmState) {
        super(overlaysTargetHSM.getHsm(), string, hsmState);
        this.target = overlaysTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): receiverEventId: ").append(eventGeneric.getReceiverEventId()).append(", Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().removeReloadPersistedDataListener(this);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.notifierDSI.registerDSI();
        this.initASL();
        this.initModel();
        this.initMotorwayInfo();
        this.initIsHIGH();
        this.target.transStateWork();
    }

    private void initIsHIGH() {
        this.target.datapool.setIsHIGH(ServiceManager.configManagerDiag.isFeatureFlagSet(70));
    }

    void initMotorwayInfo() {
        this.target.notifierDSI.enableRgMotorwayInfo(this.target.datapool.isMotorwayInfoActive());
    }

    void initModel() {
        this.logger.trace("initModel()");
        this.target.notifierModel.notifyKanbanActiveChanged(this.target.datapool.isKanbanActive());
        this.target.notifierModel.notifyManeuverDetailViewActiveChanged(this.target.datapool.isManeuverDetailViewActive());
        this.target.notifierModel.notifyMotorwayInfoActiveChanged(this.target.datapool.isMotorwayInfoActive());
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.target.addObservers(OBSERVERS);
    }

    @Override
    public void reloadPersistedData() {
        this.initModel();
    }
}

