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

public class StatePrepareForProfileChange
extends AbstractHsmState {
    private IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[StatePrepareForProfileChange]");
    private HsmTargetProfileChange target;

    public StatePrepareForProfileChange(HsmTargetProfileChange hsmTargetProfileChange, String string, HsmState hsmState) {
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
            case 100101: {
                this.target.transStateProfileChangeRunning();
                break;
            }
            case 3497006: {
                int n = eventGeneric.getInt(0);
                this.handleGuidanceState(n);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleGuidanceState(int n) {
        this.logger.trace("handleGuidanceState()");
        if (n == 0) {
            this.logger.trace("handleGuidanceState(): ASLNavigationGuidanceAPI.GUIDANCE_STATE_IDLE");
            this.setPnavOperationModeToInactiveAndSetLastPnavMode();
        }
    }

    private void setPnavOperationModeToInactiveAndSetLastPnavMode() {
        this.logger.trace("setPnavOperationModeToInactiveAndSetLastPnavMode(): Set predictive navigation mode to DSIPredictiveNavigation.OPERATIONMODE_INACTIVE");
        if (this.target.dsiPredictiveNavigation != null) {
            if (this.target.currentPnavOperationMode != 0) {
                this.target.dsiPredictiveNavigation.setOperationMode(0);
            } else {
                this.logger.trace("setPnavOperationModeToInactiveAndSetLastPnavMode(): operation mode already OPERATIONMODE_INACTIVE. Skipping DSI call");
                this.target.transStateProfileChangeRunning();
            }
        } else {
            this.logger.trace("DSIPredictiveNavigation is not available!");
            this.target.transStateProfileChangeRunning();
        }
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): ev.Id=").append(eventGeneric.getReceiverEventId()).append(" Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.target.startTimer(92733696, (long)0, false);
        this.target.resetProfileChangeParameters();
        this.logger.trace("handleStart(): start changing profile");
        if (this.target.navGuidanceApi.getGuidanceState() == 1) {
            this.logger.trace("handleStart(): stop guidance");
            this.target.cacheCurrentRouteAndStopGuidance();
        } else {
            ASLCalculationState[] aSLCalculationStateArray = this.target.navGuidanceApi.getCalculationState();
            boolean bl = false;
            for (int i2 = 0; i2 < aSLCalculationStateArray.length; ++i2) {
                if (aSLCalculationStateArray[i2].getCalculationState() == 0) continue;
                bl = true;
                break;
            }
            if (bl) {
                this.target.stopGuidance();
            } else {
                this.logger.trace("handleStart(): set predictive nav mode");
                this.setPnavOperationModeToInactiveAndSetLastPnavMode();
            }
        }
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.stopTimer(92733696);
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    public void dsiPredictiveNavigationUpdateOperationMode(int n, int n2) {
        if (n2 == 1) {
            this.target.currentPnavOperationMode = n;
            if (n == 0) {
                this.logger.trace("dsiPredictiveNavigationUpdateOperationMode(): Update that predictive navigation mode was set to DSIPredictiveNavigation.OPERATIONMODE_INACTIVE");
                this.target.transStateProfileChangeRunning();
            } else {
                this.logger.error("dsiPredictiveNavigationUpdateOperationMode(): Unexpected update call from DSIPredictiveNavigation for setOperationMode. Wrong operation mode as response");
            }
        }
    }
}

