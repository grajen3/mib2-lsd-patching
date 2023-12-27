/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechgeneral.ptt;

import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateConsumer;
import de.vw.mib.asl.internal.speechgeneral.ptt.DialogActivatorManager;

public class StateTracker
implements ApplicationStateConsumer {
    private boolean isMultipleApplicants;
    private int engineApplicationState;
    private final DialogActivatorManager activatorManager;

    public StateTracker(boolean bl, int n, DialogActivatorManager dialogActivatorManager) {
        this.isMultipleApplicants = bl;
        this.engineApplicationState = n;
        this.activatorManager = dialogActivatorManager;
    }

    private void setMultipleApplicants(boolean bl) {
        this.isMultipleApplicants = bl;
    }

    public boolean isMultipleApplicants() {
        return this.isMultipleApplicants;
    }

    private void setEngineState(int n) {
        this.engineApplicationState = n;
    }

    public int getEngineState() {
        return this.engineApplicationState;
    }

    void updateApplicantsCount(int n) {
        this.setMultipleApplicants(n > 1);
        this.activatorManager.updateActivator();
    }

    @Override
    public void onApplicationStateChanged(int n) {
        this.setEngineState(n);
        this.activatorManager.updateActivator();
    }
}

