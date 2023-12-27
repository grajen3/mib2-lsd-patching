/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.asl.api.navigation.guidance.ASLCalculationState;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.internal.navigation.api.impl.has.HsmTargetHas;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.has.containers.AddressContainer;

public class StateCalculate
extends AbstractHsmState {
    private HsmTargetHas target;
    private boolean isCalc;

    StateCalculate(HsmTargetHas hsmTargetHas, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = hsmTargetHas;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.isCalc = false;
                this.target.startGuidanceResult.setResult(4);
                this.target.hasResults.startGuidanceResult(this.target.startGuidanceCallId, 0, this.target.startGuidanceResult);
                this.target.alternativeRouteCalcEnabled = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().isAlternativeRouteCalculation();
                if (this.target.alternativeRouteCalcEnabled) {
                    this.target.disableAlternativeRouteCalculation();
                }
                ASLNavigationGuidanceFactory.getNavigationGuidanceApi().calculateRoute(this.target.route, false);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                if (!this.target.alternativeRouteCalcEnabled) break;
                this.target.enableAlternativeRouteCalculation();
                break;
            }
            case 3497005: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_CALCULATION_STATE");
                ASLCalculationState[] aSLCalculationStateArray = (ASLCalculationState[])eventGeneric.getObject(0);
                if (aSLCalculationStateArray == null || aSLCalculationStateArray.length <= 0) break;
                this.isCalc = aSLCalculationStateArray[0].getCalculationState() == 1;
                break;
            }
            case 3497007: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_ERROR_STATE");
                int n = eventGeneric.getInt(0);
                if (this.isCalc) {
                    if (n != 5) break;
                    if (this.target.alternativeRouteCalcEnabled) {
                        this.target.enableAlternativeRouteCalculation();
                    }
                    this.target.startGuidanceResult.setResult(3);
                    this.target.hasResults.startGuidanceResult(this.target.startGuidanceCallId, 1, this.target.startGuidanceResult);
                    this.trans(this.target.stateNoGuidance);
                    break;
                }
                if (n == 1) {
                    this.trans(this.target.stateStopStartGuidance);
                    break;
                }
                this.target.startGuidanceResult.setResult(2);
                this.target.hasResults.startGuidanceResult(this.target.startGuidanceCallId, -1, this.target.startGuidanceResult);
                this.trans(this.target.stateNoGuidance);
                break;
            }
            case 100100: {
                this.target.traceState(this, "EV_ASL_INT_HAS_START_GUIDANCE");
                this.target.startGuidanceCallId = eventGeneric.getInt(0);
                this.target.startGuidanceAddressContainer = (AddressContainer)eventGeneric.getObject(1);
                this.trans(this.target.stateStopStartGuidance);
                break;
            }
            case 3497006: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_GUIDANCE_STATE");
                int n = eventGeneric.getInt(0);
                if (n == 1) {
                    this.trans(this.target.stateGuidance);
                    break;
                }
                if (n != 0) break;
                this.trans(this.target.stateNoGuidance);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

