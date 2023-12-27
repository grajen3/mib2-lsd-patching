/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.factoryreset;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetExecutionParticipantData;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator$1;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator$2;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator$FactoryResetCallbackImpl;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetNotificator$FactoryResetNotificatorCallback;
import de.vw.mib.asl.internal.impl.system.factoryreset.FactoryResetTimer$TimeoutListener;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.Invoker;
import java.util.HashSet;
import java.util.Iterator;

class FactoryResetNotificator {
    private final String componentName;
    private final Invoker invoker;
    private final Logger logger;
    private final FactoryResetNotificator$FactoryResetNotificatorCallback notificatorCallback;
    private final HashSet pendingResetParticipants = new HashSet();
    private final FactoryResetTimer$TimeoutListener timeoutListener = this.createTimeoutListener();
    private boolean timeoutOccured;

    FactoryResetNotificator(FactoryResetExecutionParticipantData factoryResetExecutionParticipantData, FactoryResetNotificator$FactoryResetNotificatorCallback factoryResetNotificator$FactoryResetNotificatorCallback, SystemServices systemServices) {
        Preconditions.checkArgumentNotNull(factoryResetExecutionParticipantData);
        Preconditions.checkArgumentNotNull(factoryResetNotificator$FactoryResetNotificatorCallback);
        Preconditions.checkArgumentNotNull(systemServices, "No system services given.");
        this.notificatorCallback = factoryResetNotificator$FactoryResetNotificatorCallback;
        this.logger = systemServices.getAsl1Logger();
        this.invoker = systemServices.getThreadSwitcher();
        this.componentName = factoryResetExecutionParticipantData.getComponentName();
        this.performResetNotification(factoryResetExecutionParticipantData);
    }

    FactoryResetCallback createCallback(FactoryResetParticipant factoryResetParticipant) {
        return new FactoryResetNotificator$FactoryResetCallbackImpl(this, factoryResetParticipant);
    }

    FactoryResetTimer$TimeoutListener getTimeoutListener() {
        return this.timeoutListener;
    }

    void markAsFinished(FactoryResetNotificator$FactoryResetCallbackImpl factoryResetNotificator$FactoryResetCallbackImpl) {
        Preconditions.checkArgumentNotNull(factoryResetNotificator$FactoryResetCallbackImpl);
        if (!this.pendingResetParticipants.remove(factoryResetNotificator$FactoryResetCallbackImpl) || this.timeoutOccured) {
            this.logCallbackWarning(factoryResetNotificator$FactoryResetCallbackImpl.getParticipant());
            return;
        }
        if (this.isTraceEnabled()) {
            String string = super.getClass().getName();
            this.logTrace(new StringBuffer().append("Participant >").append(string).append("< returned successful.").toString());
        }
        if (this.pendingResetParticipants.isEmpty()) {
            if (this.isTraceEnabled()) {
                this.logTrace(new StringBuffer().append("All callbacks for >").append(this.componentName).append("< returned successful.").toString());
            }
            this.notificatorCallback.notificationCompleted();
        }
    }

    void processTimeoutNotification() {
        if (this.pendingResetParticipants.isEmpty()) {
            if (this.isTraceEnabled()) {
                this.logTrace(new StringBuffer().append("Timeout occured for component >").append(this.componentName).append("< after all participants returned.").toString());
            }
            return;
        }
        this.logTimeoutWarnings();
        this.timeoutOccured = true;
        this.pendingResetParticipants.clear();
        this.notificatorCallback.notificationCompleted();
    }

    private FactoryResetTimer$TimeoutListener createTimeoutListener() {
        return new FactoryResetNotificator$1(this);
    }

    private boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(2048);
    }

    private void logCallbackWarning(FactoryResetParticipant factoryResetParticipant) {
        String string = super.getClass().getName();
        String string2 = "Unexpected callback from ";
        string2 = string == null ? new StringBuffer().append(string2).append("unknown participant").toString() : new StringBuffer().append(string2).append("participant >").append(string).append("<").toString();
        string2 = this.timeoutOccured ? new StringBuffer().append(string2).append(" after timeout occured.").toString() : new StringBuffer().append(string2).append(".").toString();
        this.logger.warn(2048, string2);
    }

    private void logTimeoutWarnings() {
        this.logger.warn(2048, new StringBuffer().append("A timeout occured during factory reset of component >").append(this.componentName).append("<.").toString());
        Iterator iterator = this.pendingResetParticipants.iterator();
        while (iterator.hasNext()) {
            FactoryResetNotificator$FactoryResetCallbackImpl factoryResetNotificator$FactoryResetCallbackImpl = (FactoryResetNotificator$FactoryResetCallbackImpl)iterator.next();
            FactoryResetParticipant factoryResetParticipant = factoryResetNotificator$FactoryResetCallbackImpl.getParticipant();
            String string = super.getClass().getName();
            this.logger.warn(2048, new StringBuffer().append(">").append(string).append("< did not answer until timeout.").toString());
        }
    }

    private void logTrace(String string) {
        this.logger.trace(2048, new StringBuffer().append("[FactoryResetNotificator] ").append(string).toString());
    }

    private void performResetNotification(FactoryResetExecutionParticipantData factoryResetExecutionParticipantData) {
        int n = factoryResetExecutionParticipantData.getTrigger();
        FactoryResetParticipant[] factoryResetParticipantArray = factoryResetExecutionParticipantData.getParticipants();
        for (int i2 = 0; i2 < factoryResetParticipantArray.length; ++i2) {
            FactoryResetParticipant factoryResetParticipant = factoryResetParticipantArray[i2];
            FactoryResetCallback factoryResetCallback = this.createCallback(factoryResetParticipant);
            this.pendingResetParticipants.add(factoryResetCallback);
            this.invoker.invoke(new FactoryResetNotificator$2(this, factoryResetParticipant, factoryResetCallback, n));
        }
    }
}

