/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.states;

import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.states.FsgHsmContext;
import de.vw.mib.bap.mqbab2.telephone2.states.RunningState;
import de.vw.mib.bap.mqbab2.telephone2.states.Telephone2HsmContextDelegate;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class Telephone2HsmContext
extends FsgHsmContext {
    private HsmState _runningState;
    private Telephone2HsmContextDelegate _delegate;

    public Telephone2HsmContext(Hsm hsm, HsmState hsmState) {
        super(hsm, hsmState);
    }

    @Override
    public HsmState getRunningState() {
        if (this._runningState == null) {
            this._runningState = new RunningState(this, this.getTopState());
        }
        return this._runningState;
    }

    @Override
    public HsmContextDelegate getContextDelegate() {
        return this.getTelephone2ContextDelegate();
    }

    public Telephone2HsmContextDelegate getTelephone2ContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(Telephone2HsmContextDelegate telephone2HsmContextDelegate) {
        this._delegate = telephone2HsmContextDelegate;
    }
}

