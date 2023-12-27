/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.eni.states;

import de.vw.mib.asl.internal.ocu.common.HsmContextDelegate;
import de.vw.mib.asl.internal.ocu.common.states.CommonHsmContext;
import de.vw.mib.asl.internal.ocu.common.states.Initializing;
import de.vw.mib.asl.internal.ocu.common.states.VersionCheckState;
import de.vw.mib.asl.internal.ocu.common.states.WaitForFsgOperationState;
import de.vw.mib.asl.internal.ocu.common.states.WaitForLcuStartState;
import de.vw.mib.asl.internal.ocu.common.states.WaitForMiddlewareState;
import de.vw.mib.asl.internal.ocu.eni.states.ENIHsmContextDelegate;
import de.vw.mib.asl.internal.ocu.eni.states.ENIStartupTopState;
import de.vw.mib.asl.internal.ocu.eni.states.InitializeState;
import de.vw.mib.asl.internal.ocu.eni.states.RunningState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public class ENIHsmContext
implements CommonHsmContext {
    private final Hsm _hsm;
    private final HsmState _defaultStateParent;
    private HsmState _initializeState;
    private HsmState _startupTopState;
    private HsmState _runningState;
    private HsmState _waitForLcuStart;
    private HsmState _waitForMiddlewareState;
    private HsmState _versionCheckState;
    private HsmState _waitForFsgOperationState;
    private HsmState _initializingState;
    private ENIHsmContextDelegate _delegate;

    public ENIHsmContext(Hsm hsm, HsmState hsmState) {
        this._hsm = hsm;
        this._defaultStateParent = hsmState;
    }

    @Override
    public HsmContextDelegate getContextDelegate() {
        return this.getENIContextDelegate();
    }

    public ENIHsmContextDelegate getENIContextDelegate() {
        return this._delegate;
    }

    public void setDelegate(ENIHsmContextDelegate eNIHsmContextDelegate) {
        this._delegate = eNIHsmContextDelegate;
    }

    private HsmState getDefaultParentState() {
        return this._defaultStateParent;
    }

    @Override
    public Hsm getHsm() {
        return this._hsm;
    }

    public HsmState getStartState() {
        if (this._initializeState == null) {
            this._initializeState = new InitializeState(this, this.getDefaultParentState());
        }
        return this._initializeState;
    }

    private HsmState getStartupTopState() {
        if (this._startupTopState == null) {
            this._startupTopState = new ENIStartupTopState(this, this.getDefaultParentState());
        }
        return this._startupTopState;
    }

    @Override
    public HsmState getRunningState() {
        if (this._runningState == null) {
            this._runningState = new RunningState(this, this.getDefaultParentState());
        }
        return this._runningState;
    }

    @Override
    public HsmState getWaitForLcuStartState() {
        if (this._waitForLcuStart == null) {
            this._waitForLcuStart = new WaitForLcuStartState(this, this.getStartupTopState());
        }
        return this._waitForLcuStart;
    }

    @Override
    public HsmState getWaitForMiddlewareState() {
        if (this._waitForMiddlewareState == null) {
            this._waitForMiddlewareState = new WaitForMiddlewareState(this, this.getStartupTopState());
        }
        return this._waitForMiddlewareState;
    }

    @Override
    public HsmState getVersionCheckState() {
        if (this._versionCheckState == null) {
            this._versionCheckState = new VersionCheckState(this, this.getStartupTopState());
        }
        return this._versionCheckState;
    }

    @Override
    public HsmState getWaitForFsgOperationState() {
        if (this._waitForFsgOperationState == null) {
            this._waitForFsgOperationState = new WaitForFsgOperationState(this, this.getStartupTopState());
        }
        return this._waitForFsgOperationState;
    }

    @Override
    public HsmState getInitializingState() {
        if (this._initializingState == null) {
            this._initializingState = new Initializing(this, this.getStartupTopState());
        }
        return this._initializingState;
    }
}

