/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.master.states;

import de.vw.mib.asl.internal.mostkombi.master.states.MostKombiHsmContextDelegate;
import de.vw.mib.asl.internal.mostkombi.master.states.RunningState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class MostKombiHsmContext {
    private final Hsm _hsm;
    private final HsmState _defaultParentState;
    private MostKombiHsmContextDelegate _delegate;
    private HsmState _runningState;

    public MostKombiHsmContext(Hsm hsm, HsmState hsmState) {
        this._hsm = hsm;
        this._defaultParentState = hsmState;
    }

    public Hsm getHsm() {
        return this._hsm;
    }

    public MostKombiHsmContextDelegate getContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(MostKombiHsmContextDelegate mostKombiHsmContextDelegate) {
        this._delegate = mostKombiHsmContextDelegate;
    }

    private HsmState getDefaultParentState() {
        return this._defaultParentState;
    }

    public HsmState getStartState() {
        return this.getRunningState();
    }

    public HsmState getRunningState() {
        if (this._runningState == null) {
            this._runningState = new RunningState(this, this.getDefaultParentState());
        }
        return this._runningState;
    }
}

