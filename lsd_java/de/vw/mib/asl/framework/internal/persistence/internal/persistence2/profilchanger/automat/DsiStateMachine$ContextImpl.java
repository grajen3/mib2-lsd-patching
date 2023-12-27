/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.Context;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiStateMachine;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiStateMachine$ContextImpl$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.DsiUtil;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat.State;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

class DsiStateMachine$ContextImpl
implements Context {
    boolean isActive = true;
    private final Invoker invoker;
    private final PersistenceLogger logger;
    private Timer timer = null;
    private final TimerManager timerManager;
    private final /* synthetic */ DsiStateMachine this$0;

    public DsiStateMachine$ContextImpl(DsiStateMachine dsiStateMachine) {
        this.this$0 = dsiStateMachine;
        this.logger = dsiStateMachine.persistenceServices.getPersistenceLogger();
        this.timerManager = dsiStateMachine.persistenceServices.getTimerManager();
        this.invoker = dsiStateMachine.persistenceServices.getThreadSwitchingTarget();
    }

    @Override
    public AbstractPersonalizedAppDsiAdapter getDsiAdapter() {
        return this.this$0.dsiAdapter;
    }

    @Override
    public PersistenceServices getServices() {
        return this.this$0.persistenceServices;
    }

    @Override
    public void logError(String string) {
        this.logger.error(string);
    }

    @Override
    public void logError(String string, Exception exception) {
        this.logger.error(string, exception);
    }

    @Override
    public void logInformation(String string) {
        this.logger.info(string);
    }

    @Override
    public void logTrace(String string) {
        this.logger.trace(string);
    }

    @Override
    public void logWarning(String string) {
        this.logger.warning(string);
    }

    @Override
    public void startTimer(long l) {
        if (!this.isActive) {
            return;
        }
        if (this.timer != null) {
            throw new IllegalStateException("A timer was already started! If you want to restart the timer call stopTimer() first!");
        }
        this.timer = this.timerManager.createTimer("Some Timeout Name", l, false, this.createTimeoutTimerRunnable(), this.invoker);
        this.timer.start();
    }

    @Override
    public void stopTimer() {
        if (this.timer == null) {
            return;
        }
        this.timer.stop();
        this.timer = null;
    }

    @Override
    public void transitionToState(State state) {
        if (this.isActive) {
            this.this$0.changeToState(state);
        }
    }

    void deactivate() {
        this.isActive = false;
        this.stopTimer();
    }

    private Runnable createTimeoutTimerRunnable() {
        return new DsiStateMachine$ContextImpl$1(this);
    }

    public String toString() {
        Class clazz = this.getDsiAdapter().getDsiClass();
        String string = DsiUtil.getSimpleClassName(clazz);
        return new StringBuffer().append("ContextImpl [dsiAdapter=").append(string).append(", isActive=").append(this.isActive).append("]").toString();
    }

    static /* synthetic */ DsiStateMachine access$000(DsiStateMachine$ContextImpl dsiStateMachine$ContextImpl) {
        return dsiStateMachine$ContextImpl.this$0;
    }
}

