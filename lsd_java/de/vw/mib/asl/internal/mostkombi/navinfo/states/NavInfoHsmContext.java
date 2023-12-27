/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.states;

import de.vw.mib.asl.internal.mostkombi.navinfo.states.InitializeState;
import de.vw.mib.asl.internal.mostkombi.navinfo.states.NavInfoHsmContextDelegate;
import de.vw.mib.asl.internal.mostkombi.navinfo.states.RunningState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class NavInfoHsmContext {
    private final Hsm _hsm;
    private final HsmState _defaultParentState;
    private NavInfoHsmContextDelegate _delegate;
    private HsmState _initializeState;
    private HsmState _runningState;

    public NavInfoHsmContext(Hsm hsm, HsmState hsmState) {
        this._hsm = hsm;
        this._defaultParentState = hsmState;
    }

    public Hsm getHsm() {
        return this._hsm;
    }

    public NavInfoHsmContextDelegate getContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(NavInfoHsmContextDelegate navInfoHsmContextDelegate) {
        this._delegate = navInfoHsmContextDelegate;
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

