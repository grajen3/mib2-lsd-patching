/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.states;

import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.states.FsgHsmContext;
import de.vw.mib.bap.mqbab2.sdssd.states.RunningState;
import de.vw.mib.bap.mqbab2.sdssd.states.SDSSDHsmContextDelegate;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class SDSSDHsmContext
extends FsgHsmContext {
    private HsmState _runningState;
    private SDSSDHsmContextDelegate _delegate;

    public SDSSDHsmContext(Hsm hsm, HsmState hsmState) {
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
        return this.getSDSSDContextDelegate();
    }

    public SDSSDHsmContextDelegate getSDSSDContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(SDSSDHsmContextDelegate sDSSDHsmContextDelegate) {
        this._delegate = sDSSDHsmContextDelegate;
    }
}

