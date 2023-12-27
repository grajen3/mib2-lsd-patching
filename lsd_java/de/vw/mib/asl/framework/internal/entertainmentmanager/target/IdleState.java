/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.target;

import de.vw.mib.asl.framework.internal.entertainmentmanager.target.EntertainmentManagerTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class IdleState
extends AbstractHsmState
implements HsmState {
    private final EntertainmentManagerTarget target;

    public IdleState(EntertainmentManagerTarget entertainmentManagerTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = entertainmentManagerTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        switch (eventGeneric.getReceiverEventId()) {
            case 1400000: 
            case 1400002: {
                this.target.getController().activated();
                break;
            }
            case 0x155CC1: {
                this.target.getController().deactivated();
                break;
            }
            default: {
                if (this.target.getController().checkActivate("Idle", eventGeneric)) break;
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }
}

