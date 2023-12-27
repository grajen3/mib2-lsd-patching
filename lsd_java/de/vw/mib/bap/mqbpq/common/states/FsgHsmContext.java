/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.states;

import de.vw.mib.bap.mqbpq.common.states.CommonHsmContext;
import de.vw.mib.bap.mqbpq.common.states.InitializingState;
import de.vw.mib.bap.mqbpq.common.states.NotInitializedState;
import de.vw.mib.bap.mqbpq.common.states.PreloadState;
import de.vw.mib.bap.mqbpq.common.states.TopState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public abstract class FsgHsmContext
implements CommonHsmContext {
    private final Hsm _hsm;
    private final HsmState _defaultStateParent;
    private HsmState _preloadState;
    private HsmState _topState;
    private HsmState _notInitializedState;
    private HsmState _initializingState;
    private int _currentBapState;
    private int _currentHMIState;

    public FsgHsmContext(Hsm hsm, HsmState hsmState) {
        this._hsm = hsm;
        this._defaultStateParent = hsmState;
    }

    @Override
    public Hsm getHsm() {
        return this._hsm;
    }

    private HsmState getDefaultParentState() {
        return this._defaultStateParent;
    }

    @Override
    public HsmState getStartState() {
        if (this._preloadState == null) {
            this._preloadState = new PreloadState(this, this.getDefaultParentState());
        }
        return this._preloadState;
    }

    @Override
    public HsmState getTopState() {
        if (this._topState == null) {
            this._topState = new TopState(this, this.getStartState());
        }
        return this._topState;
    }

    @Override
    public HsmState getNotInitializedState() {
        if (this._notInitializedState == null) {
            this._notInitializedState = new NotInitializedState(this, this.getTopState());
        }
        return this._notInitializedState;
    }

    @Override
    public HsmState getInitializingState() {
        if (this._initializingState == null) {
            this._initializingState = new InitializingState(this, this.getTopState());
        }
        return this._initializingState;
    }

    final int getCurrentBapState() {
        return this._currentBapState;
    }

    final void setCurrentBapState(int n) {
        this._currentBapState = n;
    }

    final int getCurrentHMIState() {
        return this._currentHMIState;
    }

    final void setCurrentHMIState(int n) {
        this._currentHMIState = n;
    }
}

