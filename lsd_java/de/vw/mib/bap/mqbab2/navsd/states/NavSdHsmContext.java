/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.states;

import de.vw.mib.bap.mqbab2.common.HsmContextDelegate;
import de.vw.mib.bap.mqbab2.common.states.FsgHsmContext;
import de.vw.mib.bap.mqbab2.navsd.states.NavSdHsmContextDelegate;
import de.vw.mib.bap.mqbab2.navsd.states.RunningState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class NavSdHsmContext
extends FsgHsmContext {
    private HsmState _runningState;
    private NavSdHsmContextDelegate _delegate;

    public NavSdHsmContext(Hsm hsm, HsmState hsmState) {
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
        return this.getNavSdContextDelegate();
    }

    public NavSdHsmContextDelegate getNavSdContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(NavSdHsmContextDelegate navSdHsmContextDelegate) {
        this._delegate = navSdHsmContextDelegate;
    }
}

