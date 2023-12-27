/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.factoryreset;

import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetParticipant;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;

public class FactoryResetParticipantNavigation
extends AbstractFactoryResetParticipant
implements FactoryResetParticipantWithCallback,
FactoryResetParticipant {
    private final TargetForResetNavigation target;
    private FactoryResetCallback factoryResetCallback;

    public FactoryResetParticipantNavigation(TargetForResetNavigation targetForResetNavigation) {
        this.target = targetForResetNavigation;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.factoryResetCallback = factoryResetCallback;
        try {
            this.traceState(new StringBuffer("Resetting navigation domain settings for ").append(super.getClass().getName()).toString());
            this.target.handleNavigationSettingsReset();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    @Override
    public void notifyResetDone() {
        if (this.factoryResetCallback != null) {
            this.factoryResetCallback.notifyResetDone();
            this.traceState("Resetting done!");
        }
    }

    private void traceState(String string) {
        if (ServiceManager.logger2.isTraceEnabled(this.getSubClassifier())) {
            LogMessage logMessage = ServiceManager.logger2.trace(this.getSubClassifier());
            logMessage.append(super.getClass());
            logMessage.append(": ");
            logMessage.append(string);
            logMessage.log();
        }
    }

    private int getSubClassifier() {
        return 32;
    }
}

