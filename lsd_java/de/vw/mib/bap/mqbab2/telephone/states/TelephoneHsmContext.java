/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.states;

import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.states.FsgHsmContext;
import de.vw.mib.bap.mqbab2.telephone.states.RunningState;
import de.vw.mib.bap.mqbab2.telephone.states.TelephoneHsmContextDelegate;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class TelephoneHsmContext
extends FsgHsmContext {
    private HsmState _runningState;
    private TelephoneHsmContextDelegate _delegate;

    public TelephoneHsmContext(Hsm hsm, HsmState hsmState) {
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
        return this.getTelephoneContextDelegate();
    }

    public TelephoneHsmContextDelegate getTelephoneContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(TelephoneHsmContextDelegate telephoneHsmContextDelegate) {
        this._delegate = telephoneHsmContextDelegate;
    }
}

