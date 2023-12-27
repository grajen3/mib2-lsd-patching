/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.states;

import de.vw.mib.asl.internal.mostkombi.common.controller.Controller;
import de.vw.mib.asl.internal.mostkombi.navinfo.states.NavInfoHsmContext;
import de.vw.mib.asl.internal.mostkombi.navinfo.states.NavInfoState;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;

class InitializeState
extends NavInfoState {
    private boolean _initialized;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$navinfo$states$InitializeState;

    public InitializeState(NavInfoHsmContext navInfoHsmContext, HsmState hsmState) {
        super(navInfoHsmContext, (class$de$vw$mib$asl$internal$mostkombi$navinfo$states$InitializeState == null ? (class$de$vw$mib$asl$internal$mostkombi$navinfo$states$InitializeState = InitializeState.class$("de.vw.mib.asl.internal.mostkombi.navinfo.states.InitializeState")) : class$de$vw$mib$asl$internal$mostkombi$navinfo$states$InitializeState).getName(), hsmState);
    }

    private boolean isInitialized() {
        return this._initialized;
    }

    private void setInitialized(boolean bl) {
        this._initialized = bl;
    }

    private void _initialize() {
        int[] nArray = new int[]{1112230912, 1129008128, 1095453696};
        this.getContextDelegate().addObservers(nArray);
    }

    private void informThatMostKombiControllerStarted(Controller controller) {
        this.sendSafe(1078676480, controller);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = super.handle(eventGeneric);
        if (eventGeneric.getReceiverEventId() == 1112230912) {
            hsmState = null;
            this.getContextDelegate().initialize();
        } else if (eventGeneric.getReceiverEventId() == 1129008128) {
            hsmState = null;
            this.goToState(this.getHsmContext().getRunningState());
        } else if (eventGeneric.getReceiverEventId() == 1095453696) {
            this.informThatMostKombiControllerStarted(this.getContextDelegate().getController());
        }
        return hsmState;
    }

    @Override
    protected void stateEntry() {
    }

    @Override
    protected void stateStart() {
        if (!this.isInitialized()) {
            this._initialize();
            this.setInitialized(true);
            this.informThatMostKombiControllerStarted(this.getContextDelegate().getController());
        }
    }

    @Override
    protected void stateExit() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

