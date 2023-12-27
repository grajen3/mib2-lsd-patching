/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.guidance.ASLNavigationGuidanceFactory;
import de.vw.mib.asl.internal.navigation.api.impl.has.HsmTargetHas;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class StateStopStartGuidanceImportGpx
extends AbstractHsmState {
    private HsmTargetHas target;

    StateStopStartGuidanceImportGpx(HsmTargetHas hsmTargetHas, Hsm hsm, String string, HsmState hsmState) {
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
                ASLNavigationGuidanceFactory.getNavigationGuidanceApi().stopGuidance();
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                break;
            }
            case 3497006: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_GUIDANCE_STATE");
                int n = eventGeneric.getInt(0);
                if (n != 0) break;
                this.trans(this.target.stateNoGuidance);
                EventGeneric eventGeneric2 = ASLNavigationEventFactory.createEvent(159842560);
                eventGeneric2.setObject(0, this.target.importGpxResultLocation);
                ASLNavigationEventFactory.sendEventToTarget(1430983680, 1430983680, eventGeneric2);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

