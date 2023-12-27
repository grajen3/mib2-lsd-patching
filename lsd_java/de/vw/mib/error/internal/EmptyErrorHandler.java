/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.error.internal;

import de.vw.mib.error.ErrorHandler;
import de.vw.mib.error.HMIDumpInformationProvider;
import java.util.List;

public class EmptyErrorHandler
implements ErrorHandler {
    @Override
    public void addHMIDumpInformationProvider(HMIDumpInformationProvider hMIDumpInformationProvider) {
    }

    @Override
    public void clearStartupErrors() {
    }

    @Override
    public void dump() {
    }

    @Override
    public List getStartupErrors() {
        return null;
    }

    @Override
    public void handleDsiError(Throwable throwable) {
    }

    @Override
    public void handleError(Throwable throwable) {
    }

    @Override
    public void handleError(Throwable throwable, Thread thread) {
    }

    @Override
    public void handleScriptError(Throwable throwable) {
    }

    @Override
    public void handleStartupError(Throwable throwable) {
    }

    @Override
    public void handleStatemachineError(Throwable throwable, boolean bl) {
    }

    @Override
    public void handleViewCreationError(Throwable throwable, boolean bl) {
    }

    @Override
    public void rebootSystem(Throwable throwable) {
    }
}

