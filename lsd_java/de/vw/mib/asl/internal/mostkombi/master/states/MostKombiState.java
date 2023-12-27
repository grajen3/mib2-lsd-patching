/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.master.states;

import de.vw.mib.asl.internal.mostkombi.common.controller.Controller;
import de.vw.mib.asl.internal.mostkombi.master.states.MostKombiHsmContext;
import de.vw.mib.asl.internal.mostkombi.master.states.MostKombiHsmContextDelegate;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

abstract class MostKombiState
extends AbstractHsmState {
    private final MostKombiHsmContext _hsmContext;

    public MostKombiState(MostKombiHsmContext mostKombiHsmContext, String string, HsmState hsmState) {
        super(mostKombiHsmContext.getHsm(), string, hsmState);
        this._hsmContext = mostKombiHsmContext;
    }

    protected MostKombiHsmContext getHsmContext() {
        return this._hsmContext;
    }

    public MostKombiHsmContextDelegate getContextDelegate() {
        return this.getHsmContext().getContextDelegate();
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
            case 5000000: {
                Controller controller = (Controller)eventGeneric.getObject(0);
                this.mostKombiControllerStarted(controller);
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

    protected abstract void mostKombiControllerStarted(Controller controller) {
    }
}

