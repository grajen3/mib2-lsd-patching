/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.states;

import de.vw.mib.asl.internal.kombipictureserver.states.PictureServerHsmContext;
import de.vw.mib.asl.internal.kombipictureserver.states.PictureServerState;
import de.vw.mib.genericevents.hsm.HsmState;

final class InitializeState
extends PictureServerState {
    private boolean _initialized = false;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$kombipictureserver$states$InitializeState;

    public InitializeState(PictureServerHsmContext pictureServerHsmContext, HsmState hsmState) {
        super(pictureServerHsmContext, (class$de$vw$mib$asl$internal$kombipictureserver$states$InitializeState == null ? (class$de$vw$mib$asl$internal$kombipictureserver$states$InitializeState = InitializeState.class$("de.vw.mib.asl.internal.kombipictureserver.states.InitializeState")) : class$de$vw$mib$asl$internal$kombipictureserver$states$InitializeState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
    }

    @Override
    public void stateStart() {
        this._initialize();
        this.goToState(this.getHsmContext().getRunningState());
    }

    @Override
    public void stateExit() {
    }

    private void _initialize() {
        if (!this.isInitialized()) {
            this.getContextDelegate().initialize();
            this.setInitialized(true);
        }
    }

    private boolean isInitialized() {
        return this._initialized;
    }

    private void setInitialized(boolean bl) {
        this._initialized = bl;
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

