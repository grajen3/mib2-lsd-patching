/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.kombiview.states;

import de.vw.mib.asl.internal.mostkombi.kombiview.states.InitializeState;
import de.vw.mib.asl.internal.mostkombi.kombiview.states.KombiViewHsmContextDelegate;
import de.vw.mib.asl.internal.mostkombi.kombiview.states.RunningState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class KombiViewHsmContext {
    private final Hsm _hsm;
    private final HsmState _defaultParentState;
    private KombiViewHsmContextDelegate _delegate;
    private HsmState _initializeState;
    private HsmState _runningState;

    public KombiViewHsmContext(Hsm hsm, HsmState hsmState) {
        this._hsm = hsm;
        this._defaultParentState = hsmState;
    }

    public Hsm getHsm() {
        return this._hsm;
    }

    public KombiViewHsmContextDelegate getContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(KombiViewHsmContextDelegate kombiViewHsmContextDelegate) {
        this._delegate = kombiViewHsmContextDelegate;
    }

    private HsmState getDefaultParentState() {
        return this._defaultParentState;
    }

    public HsmState getStartState() {
        return this.getInitializeState();
    }

    public HsmState getInitializeState() {
        if (this._initializeState == null) {
            this._initializeState = new InitializeState(this, this.getDefaultParentState());
        }
        return this._initializeState;
    }

    public HsmState getRunningState() {
        if (this._runningState == null) {
            this._runningState = new RunningState(this, this.getDefaultParentState());
        }
        return this._runningState;
    }
}

