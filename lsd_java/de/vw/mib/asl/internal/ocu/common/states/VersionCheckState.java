/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.states;

import de.vw.mib.asl.api.bap.observer.BAPValueObserver;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.internal.ocu.common.states.AsgControlUnitState;
import de.vw.mib.asl.internal.ocu.common.states.CommonHsmContext;
import de.vw.mib.asl.internal.ocu.common.timer.TimerObj;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.genericevents.hsm.HsmState;

public class VersionCheckState
extends AsgControlUnitState
implements TimerNotifier,
BAPValueObserver {
    private boolean _compatibleBapConfigReceived;
    private int _versionCheckAttempts;
    private Timer _versionCheckTimer;
    private static final int VERSION_CHECK_REPEAT_TIME;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$common$states$VersionCheckState;

    public VersionCheckState(CommonHsmContext commonHsmContext, HsmState hsmState) {
        super(commonHsmContext, (class$de$vw$mib$asl$internal$ocu$common$states$VersionCheckState == null ? (class$de$vw$mib$asl$internal$ocu$common$states$VersionCheckState = VersionCheckState.class$("de.vw.mib.asl.internal.ocu.common.states.VersionCheckState")) : class$de$vw$mib$asl$internal$ocu$common$states$VersionCheckState).getName(), hsmState);
    }

    @Override
    public void stateEntry() {
    }

    @Override
    public void stateStart() {
        this._startObservingBapConfig();
        this.setVersionCheckAttempts(0);
        this.setHMIState(1);
    }

    @Override
    public void stateExit() {
        this._stopVersionCheckTimer();
        this._stopObservingBapConfig();
    }

    @Override
    public void bapStateStatus(int n, int n2) {
        super.bapStateStatus(n, n2);
        if (n2 == 0) {
            this.goToState(this.getHsmContext().getWaitForMiddlewareState());
        }
    }

    @Override
    public void acknowledge(int n, int n2, int n3) {
        super.acknowledge(n, n2, n3);
        if (n3 == 20) {
            this._requestBapVersion();
        }
    }

    @Override
    public void indicationVoid(int n, int n2, int n3) {
        if (n2 == 1 && n3 == 9) {
            this._requestBapVersion();
        } else {
            super.indicationVoid(n, n2, n3);
        }
    }

    private void setCompatibleBapConfigReceived(boolean bl) {
        this._compatibleBapConfigReceived = bl;
    }

    private boolean getCompatibleBapConfigReceived() {
        return this._compatibleBapConfigReceived;
    }

    private void setVersionCheckAttempts(int n) {
        this._versionCheckAttempts = n;
    }

    private void incrementVersionCheckAttempts() {
        ++this._versionCheckAttempts;
    }

    private int getVersionCheckAttempts() {
        return this._versionCheckAttempts;
    }

    private void _requestBapVersion() {
        this.getContextDelegate().getLogicalControlUnit().getFunctionListenerRegistry().getFunctionController(2).initialize(true);
    }

    private boolean _checkBapConfig(BAPEntity bAPEntity) {
        return this.getContextDelegate().getLogicalControlUnit().getFunctionListenerRegistry().getBapConfigVersionCheckFunction().checkVersion(bAPEntity);
    }

    private void _performActionAfterVersionCheck(boolean bl) {
        if (this.getVersionCheckAttempts() > 0 && !this.getCompatibleBapConfigReceived()) {
            this._stopVersionCheckTimer();
            if (bl) {
                this._versionCheckSucceeded();
            }
        } else if (bl) {
            this._versionCheckSucceeded();
        } else {
            this._startVersionCheckTimer();
        }
        this.incrementVersionCheckAttempts();
    }

    private void _versionCheckSucceeded() {
        this.setCompatibleBapConfigReceived(true);
        this.goToState(this.getHsmContext().getInitializingState());
    }

    private Timer getVerionCheckTimer() {
        if (this._versionCheckTimer == null) {
            this._versionCheckTimer = new TimerObj(this, 0);
        }
        return this._versionCheckTimer;
    }

    private void _startVersionCheckTimer() {
        this.getVerionCheckTimer().retrigger(null);
    }

    private void _stopVersionCheckTimer() {
        if (this._versionCheckTimer != null && this.getVerionCheckTimer().isRunning()) {
            this.getVerionCheckTimer().stop();
        }
    }

    @Override
    public void timerFired(Timer timer) {
        this._requestBapVersion();
    }

    private void _startObservingBapConfig() {
        this.getContextDelegate().getLogicalControlUnit().getBapObserverRegistry().getBapValueObservable(2).addObserver(this, null);
    }

    private void _stopObservingBapConfig() {
        this.getContextDelegate().getLogicalControlUnit().getBapObserverRegistry().getBapValueObservable(2).removeObserver(this);
    }

    @Override
    public void bapValueChanged(BAPValueObserverable bAPValueObserverable, BAPEntity bAPEntity, BAPEntity bAPEntity2, Object object) {
        this._performActionAfterVersionCheck(this._checkBapConfig(bAPEntity));
    }

    @Override
    public void bapValueError(BAPValueObserverable bAPValueObserverable, int n, Object object) {
        switch (n) {
            case 34: 
            case 50: 
            case 51: {
                this._performActionAfterVersionCheck(false);
                break;
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

