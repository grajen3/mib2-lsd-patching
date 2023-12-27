/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.asl.api.exlap.ASLExLAPFactory;
import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.api.impl.has.HsmTargetHas;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.has.containers.AddressContainer;
import org.dsi.ifc.global.NavLocation;

public class StateNoGuidance
extends AbstractHsmState {
    private HsmTargetHas target;
    private boolean isRouteImport;

    StateNoGuidance(HsmTargetHas hsmTargetHas, Hsm hsm, String string, HsmState hsmState) {
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
                this.target.startGuidanceCallId = -1;
                this.target.hasProperties.updateGuidanceState(0);
                this.target.guidanceRemaining.unsetDistanceToDestination();
                this.target.guidanceRemaining.unsetTimeToDestination();
                this.target.hasProperties.updateGuidanceRemaining(this.target.guidanceRemaining);
                AddressContainer addressContainer = (AddressContainer)this.target.factory.createContainer(1);
                this.target.hasProperties.updateGuidanceDestination(addressContainer);
                this.isRouteImport = false;
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            case 100100: {
                this.target.traceState(this, "EV_ASL_INT_HAS_START_GUIDANCE");
                this.target.startGuidanceCallId = eventGeneric.getInt(0);
                this.target.startGuidanceAddressContainer = (AddressContainer)eventGeneric.getObject(1);
                this.transformLocation();
                break;
            }
            case 3497006: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_GUIDANCE_STATE");
                int n = eventGeneric.getInt(0);
                if (n != 1) break;
                this.restoreAlternativeRouteCalculationEnabled();
                this.trans(this.target.stateGuidance);
                break;
            }
            case 1074841942: {
                this.target.traceState(this, "STOP_ROUTE_IMPORT");
                this.restoreAlternativeRouteCalculationEnabled();
                break;
            }
            case 100105: {
                NavLocation navLocation = (NavLocation)eventGeneric.getObject(0);
                this.isRouteImport = true;
                this.triggerCalculation(navLocation);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void restoreAlternativeRouteCalculationEnabled() {
        if (this.target.alternativeRouteCalcEnabled) {
            this.target.enableAlternativeRouteCalculation();
        }
    }

    private void transformLocation() {
        int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(this.target.startGuidanceAddressContainer.getLatitude());
        int n2 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().decimalToDsi(this.target.startGuidanceAddressContainer.getLongitude());
        this.target.services.getNavigation().liGetLocationDescriptionTransform(ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2).getLocation());
    }

    public void dsiNavigationLiGetLocationDescriptionTransformResult(NavLocation navLocation) {
        this.target.traceState(this, "dsiNavigationLiGetLocationDescriptionTransformResult");
        this.triggerCalculation(navLocation);
    }

    private void triggerCalculation(NavLocation navLocation) {
        ILocationWrapper iLocationWrapper = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navLocation);
        int n = 1;
        this.target.traceState(this, new StringBuffer().append("triggerCalculation, isNavigable()=").append(iLocationWrapper.isNavigable()).toString());
        if (iLocationWrapper != null && iLocationWrapper.isNavigable()) {
            this.target.setRouteToNavLocation(navLocation);
            if (ASLExLAPFactory.getExLAPApi().isChauffeurModeActive()) {
                this.target.traceState(this, "Chauffeurmode is active");
                this.trans(this.target.stateCalculate);
                this.target.startGuidanceResult.setResult(0);
            } else {
                this.target.traceState(this, "Chauffeurmode is not active, guidance will be handled by model ");
                if (this.isRouteImport) {
                    this.target.alternativeRouteCalcEnabled = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().isAlternativeRouteCalculation();
                    if (this.target.alternativeRouteCalcEnabled) {
                        this.target.disableAlternativeRouteCalculation();
                    }
                    ASLNavigationGuidanceFactory.getNavigationGuidanceApi().calculateRouteWithConfirmation(this.target.route, 7);
                } else {
                    ASLNavigationGuidanceFactory.getNavigationGuidanceApi().calculateRouteWithConfirmation(this.target.route, 0);
                }
                this.target.startGuidanceResult.setResult(1);
                this.trans(this.target.stateConfirmationPending);
            }
            n = 0;
        } else {
            this.target.startGuidanceResult.setResult(5);
            this.trans(this.target.stateNoGuidance);
        }
        this.target.hasResults.startGuidanceResult(this.target.startGuidanceCallId, n, this.target.startGuidanceResult);
    }
}

