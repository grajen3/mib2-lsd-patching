/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.personalization;

import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.util.personalization.HsmTargetProfileChange;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class StatePostDsiForProfileChange
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[StatePostDsiForProfileChange]");
    private HsmTargetProfileChange target;

    public StatePostDsiForProfileChange(HsmTargetProfileChange hsmTargetProfileChange, String string, HsmState hsmState) {
        super(hsmTargetProfileChange.getHsm(), string, hsmState);
        this.target = hsmTargetProfileChange;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 1073742285: {
                this.handleModelResetDone();
                break;
            }
            case 3497005: {
                this.handleCalculationState(eventGeneric);
                break;
            }
            case 3497006: {
                this.handleGuidanceState(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleGuidanceState(EventGeneric eventGeneric) {
        this.logger.trace("handleGuidanceState()");
        int n = eventGeneric.getInt(0);
        if (n == 1) {
            this.logger.trace("handleGuidanceState(): Route guidance restarted");
            this.notifyProfileChangeDone();
        }
    }

    private void handleCalculationState(EventGeneric eventGeneric) {
        int n;
        ASLCalculationState[] aSLCalculationStateArray = (ASLCalculationState[])eventGeneric.getObject(0);
        if (this.logger.isTraceEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ASLNavigationGuidanceAPI.EV_NAVI_GUIDANCE_CALCULATION_STATE:");
            for (n = 0; n < aSLCalculationStateArray.length; ++n) {
                stringBuffer.append(" calculationState: ");
                stringBuffer.append(aSLCalculationStateArray[n].getCalculationState());
                stringBuffer.append(" progress: ");
                stringBuffer.append(aSLCalculationStateArray[n].getProgress());
            }
            this.logger.trace(stringBuffer.toString());
        }
        boolean bl = true;
        for (n = 0; n < aSLCalculationStateArray.length; ++n) {
            if (aSLCalculationStateArray[n].getCalculationState() == 2) continue;
            bl = false;
        }
        if (bl) {
            this.logger.trace("handleCalculationState: Route calculation finished");
            this.startGuidance();
        }
    }

    private void startGuidance() {
        this.target.startGuidanceOfPreviousRoute();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.profileChangeHandler.loadPersonalizedPersistedValues();
    }

    private void handleModelResetDone() {
        this.logger.trace("handleModelResetDone()");
        this.notifyProfileChangeCompletedAndRestartGuidance();
    }

    public void dsiPredictiveNavigationUpdateOperationMode(int n, int n2) {
        if (n2 == 1) {
            this.target.currentPnavOperationMode = n;
            int n3 = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().getPersonalNaviPersistence().isPnavEnabled() ? 1 : 0;
            if (n == n3) {
                this.logger.trace(new StringBuffer().append("dsiPredictiveNavigationUpdateOperationMode(): Update that predictive navigation mode was correctly set to ").append(n3).toString());
            } else {
                this.logger.error("dsiPredictiveNavigationUpdateOperationMode: Unexpected update call from DSIPredictiveNavigation for setOperationMode. Wrong operation mode as response");
            }
        }
    }

    private void notifyProfileChangeCompletedAndRestartGuidance() {
        if (this.target.isPreviousRoutePresent()) {
            this.target.recalculatePreviousRoute();
        } else {
            this.notifyProfileChangeDone();
        }
    }

    private void notifyProfileChangeDone() {
        this.logger.trace("notifyProfileChangeDone(): Profile change finished");
        this.target.profileChangeHandler.notifyTaskDone(true);
        this.target.profileChangeHandler = null;
        this.target.transStateIdle();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }
}

