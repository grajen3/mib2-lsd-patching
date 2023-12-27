/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.asl.api.exlap.ASLExLAPFactory;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.internal.navigation.api.impl.has.HsmTargetHas;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.global.NavLocation;

public class StateActive
extends AbstractHsmState {
    private HsmTargetHas target;

    StateActive(HsmTargetHas hsmTargetHas, Hsm hsm, String string, HsmState hsmState) {
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
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            case 100105: {
                this.target.traceState(this, "EV_ASL_INT_IMPORT_GPX_RESULT");
                NavLocation navLocation = (NavLocation)eventGeneric.getObject(0);
                if (ASLExLAPFactory.getExLAPApi().isChauffeurModeActive()) {
                    this.target.importGpxResultLocation = navLocation;
                    this.trans(this.target.stateStopStartGuidanceImportGpx);
                    break;
                }
                this.target.alternativeRouteCalcEnabled = ASLNavigationGuidanceFactory.getNavigationGuidanceApi().isAlternativeRouteCalculation();
                if (this.target.alternativeRouteCalcEnabled) {
                    this.target.disableAlternativeRouteCalculation();
                }
                this.target.setRouteToNavLocation(navLocation);
                ASLNavigationGuidanceFactory.getNavigationGuidanceApi().calculateRouteWithConfirmation(this.target.route, 7);
                break;
            }
            case 1074841942: {
                this.target.traceState(this, "STOP_ROUTE_IMPORT");
                if (!this.target.alternativeRouteCalcEnabled) break;
                this.target.enableAlternativeRouteCalculation();
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

