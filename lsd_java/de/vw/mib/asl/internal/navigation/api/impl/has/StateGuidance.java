/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.asl.internal.navigation.api.impl.has.HsmTargetHas;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.has.containers.AddressContainer;

public class StateGuidance
extends AbstractHsmState {
    private HsmTargetHas target;

    StateGuidance(HsmTargetHas hsmTargetHas, Hsm hsm, String string, HsmState hsmState) {
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
                this.target.hasProperties.updateGuidanceState(1);
                if (this.target.startGuidanceCallId == -1) break;
                this.target.startGuidanceResult.setResult(0);
                this.target.hasResults.startGuidanceResult(this.target.startGuidanceCallId, 0, this.target.startGuidanceResult);
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
                this.trans(this.target.stateStopStartGuidance);
                break;
            }
            case 3497007: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_ERROR_STATE");
                int n = eventGeneric.getInt(0);
                if (n != 5) break;
                this.target.startGuidanceResult.setResult(3);
                this.target.hasResults.startGuidanceResult(this.target.startGuidanceCallId, 1, this.target.startGuidanceResult);
                this.trans(this.target.stateNoGuidance);
                break;
            }
            case 3497006: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_GUIDANCE_STATE");
                int n = eventGeneric.getInt(0);
                if (n == 0) {
                    this.target.traceState(this, "GUIDANCE_STATE_IDLE");
                    this.trans(this.target.stateNoGuidance);
                    break;
                }
                if (n != 1) break;
                this.target.traceState(this, "GUIDANCE_STATE_GUIDING");
                this.target.hasProperties.updateGuidanceState(1);
                break;
            }
            case 3497030: {
                this.target.traceState(this, "EV_NAVI_GUIDANCE_FINAL_DEST_REACHED");
                this.target.hasProperties.updateGuidanceState(2);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

