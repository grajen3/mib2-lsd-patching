/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.states;

import de.vw.mib.asl.internal.mostkombi.common.states.HsmContextDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.states.NavInfoHsmContext;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.genericevents.internal.ServiceManager;

abstract class NavInfoState
extends AbstractHsmState {
    private final NavInfoHsmContext _hsmContext;

    public NavInfoState(NavInfoHsmContext navInfoHsmContext, String string, HsmState hsmState) {
        super(navInfoHsmContext.getHsm(), string, hsmState);
        this._hsmContext = navInfoHsmContext;
    }

    protected NavInfoHsmContext getHsmContext() {
        return this._hsmContext;
    }

    public HsmContextDelegate getContextDelegate() {
        return this.getHsmContext().getContextDelegate();
    }

    protected void sendSafe(int n, Object object) {
        EventGeneric eventGeneric = ServiceManager.mEventFactory.newEvent(n);
        if (object != null) {
            eventGeneric.setObject(0, object);
        }
        ServiceManager.mEventContext.getEventDispatcher().sendSafe(eventGeneric);
    }

    protected void goToState(HsmState hsmState) {
        try {
            this.trans(hsmState);
            this.getHsmContext().getHsm().activateTransition();
        }
        catch (Exception exception) {
            this.getContextDelegate().getLogger().error(this.getContextDelegate().getSubClassifier(), "Error during transition", exception);
        }
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
}

