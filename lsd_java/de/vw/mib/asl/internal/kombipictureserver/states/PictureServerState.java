/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.states;

import de.vw.mib.asl.internal.kombipictureserver.common.states.HsmContextDelegate;
import de.vw.mib.asl.internal.kombipictureserver.states.PictureServerHsmContext;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

abstract class PictureServerState
extends AbstractHsmState {
    private final PictureServerHsmContext _hsmContext;

    public PictureServerState(PictureServerHsmContext pictureServerHsmContext, String string, HsmState hsmState) {
        super(pictureServerHsmContext.getHsm(), string, hsmState);
        this._hsmContext = pictureServerHsmContext;
    }

    protected PictureServerHsmContext getHsmContext() {
        return this._hsmContext;
    }

    protected HsmContextDelegate getContextDelegate() {
        return this.getHsmContext().getDelegate();
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        boolean bl = true;
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.stateEntry();
                break;
            }
            case 3: {
                this.stateStart();
                break;
            }
            case 4: {
                this.stateExit();
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl ? null : this.getParent();
    }

    protected abstract void stateEntry() {
    }

    protected abstract void stateStart() {
    }

    protected abstract void stateExit() {
    }

    protected void goToState(HsmState hsmState) {
        try {
            this.trans(hsmState);
        }
        catch (Exception exception) {
            this.getContextDelegate().getLogger().error(1, "Error during transition", exception);
        }
    }
}

