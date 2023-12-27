/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class VicsStateVenm
extends AbstractHsmState {
    private final VicsTarget target;

    public VicsStateVenm(VicsTarget vicsTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = vicsTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceMsg("HSM_ENTRY - VicsStateVenm", this);
                break;
            }
            case 3: {
                this.target.venmHandler.handleEnterContext();
                break;
            }
            case 4: {
                this.target.traceMsg("HSM_EXIT - VicsStateVenm", this);
                break;
            }
            case 1079341885: {
                this.target.venmHandler.handleLeaveContext();
                break;
            }
            case 1079341896: {
                this.target.venmHandler.handleLeaveContextToNav();
                break;
            }
            case 1079341887: {
                this.target.venmHandler.handleVenmTwoFingerZoom(eventGeneric);
                break;
            }
            case 1079341875: {
                this.target.venmHandler.handleVenmZoomIn(eventGeneric);
                break;
            }
            case 1079341876: {
                this.target.venmHandler.handleVenmZoomOut(eventGeneric);
                break;
            }
            default: {
                this.target.traceMsg("default - VicsStateVenm", this);
                return this.myParent;
            }
        }
        return null;
    }
}

