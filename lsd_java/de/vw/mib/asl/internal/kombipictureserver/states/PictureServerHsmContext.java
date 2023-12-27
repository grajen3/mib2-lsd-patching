/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.states;

import de.vw.mib.asl.internal.kombipictureserver.common.states.HsmContextDelegate;
import de.vw.mib.asl.internal.kombipictureserver.states.InitializeState;
import de.vw.mib.asl.internal.kombipictureserver.states.RunningState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class PictureServerHsmContext {
    private final Hsm _hsm;
    private final HsmState _defaultStateParent;
    private HsmState _initializeState;
    private HsmState _runningState;
    private HsmContextDelegate _delegate;

    public PictureServerHsmContext(Hsm hsm, HsmState hsmState) {
        this._hsm = hsm;
        this._defaultStateParent = hsmState;
        this._initializeState = null;
        this._runningState = null;
        this._delegate = null;
    }

    public HsmContextDelegate getDelegate() {
        return this._delegate;
    }

    public void setDelegate(HsmContextDelegate hsmContextDelegate) {
        this._delegate = hsmContextDelegate;
    }

    private HsmState getDefaultParentState() {
        return this._defaultStateParent;
    }

    Hsm getHsm() {
        return this._hsm;
    }

    public HsmState getInitializeState() {
        if (this._initializeState == null) {
            this._initializeState = new InitializeState(this, this.getDefaultParentState());
        }
        return this._initializeState;
    }

    HsmState getRunningState() {
        if (this._runningState == null) {
            this._runningState = new RunningState(this, this.getDefaultParentState());
        }
        return this._runningState;
    }
}

