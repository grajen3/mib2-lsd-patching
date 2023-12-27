/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset.participant;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.impl.system.factoryreset.participant.AbstractLegacyFactoryResetParticipant$1;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Invoker;
import de.vw.mib.timer.Timer;
import de.vw.mib.timer.TimerManager;

public abstract class AbstractLegacyFactoryResetParticipant
extends AbstractFactoryResetParticipant {
    public static final long DEFAULT_TIMEOUT_TOLERANCE;
    public static final long DEFAULT_TIMER;
    private static final String TRANSITION_PARTICIPANT_LOGGER_PREFIX;
    protected final ServiceRegister serviceRegister;
    private final Logger logger;
    private final int serviceId;
    private final Invoker timerInvoker;
    private final TimerManager timerManager;

    public AbstractLegacyFactoryResetParticipant(SystemServices systemServices, int n) {
        Preconditions.checkArgumentNotNull(systemServices);
        Preconditions.checkArgument(n > 0);
        this.serviceId = n;
        this.serviceRegister = systemServices.getServiceRegister();
        this.timerManager = systemServices.getTimerManager();
        this.timerInvoker = systemServices.getThreadSwitcher();
        this.logger = systemServices.getAsl1Logger();
    }

    public abstract long getCallbackTimeout() {
    }

    public abstract String getComponentName() {
    }

    @Override
    public long getTimeout() {
        return this.getCallbackTimeout() + 0;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.triggerObserver();
        String string = new StringBuffer().append("Reset timer for >").append(this.getComponentName()).append("< with trigger ").append(n).toString();
        Timer timer = this.createTimer(string, this.getCallbackTimeout(), this.createDefaultCallbackRunnable(factoryResetCallback));
        timer.start();
    }

    protected Runnable createDefaultCallbackRunnable(FactoryResetCallback factoryResetCallback) {
        Preconditions.checkArgumentNotNull(factoryResetCallback);
        return new AbstractLegacyFactoryResetParticipant$1(this, factoryResetCallback);
    }

    protected Timer createTimer(String string, long l, Runnable runnable) {
        Preconditions.checkNotNullOrEmpty(string, "Timer name must be set.");
        Preconditions.checkArgument(l > 0L, "Invalid timeout.");
        Preconditions.checkArgumentNotNull(runnable, "Timer Runnable must be set.");
        return this.timerManager.createTimer(string, l, false, runnable, this.timerInvoker);
    }

    protected void logWarn(String string) {
        this.logger.warn(2048, new StringBuffer().append("[TransitionFactoryResetParticipant] ").append(string).toString());
    }

    protected void triggerObserver() {
        this.serviceRegister.triggerObserver(this.serviceId);
    }
}

