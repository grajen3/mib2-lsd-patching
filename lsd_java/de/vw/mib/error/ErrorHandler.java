/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.error;

import de.vw.mib.error.HMIDumpInformationProvider;
import java.util.List;

public interface ErrorHandler {
    public static final String SHOW_DSI_ERRORS;
    public static final String SHOW_STARTUP_ERRORS;

    default public void addHMIDumpInformationProvider(HMIDumpInformationProvider hMIDumpInformationProvider) {
    }

    default public void clearStartupErrors() {
    }

    default public void dump() {
    }

    default public List getStartupErrors() {
    }

    default public void handleDsiError(Throwable throwable) {
    }

    default public void handleError(Throwable throwable) {
    }

    default public void handleError(Throwable throwable, Thread thread) {
    }

    default public void handleScriptError(Throwable throwable) {
    }

    default public void handleStartupError(Throwable throwable) {
    }

    default public void handleStatemachineError(Throwable throwable, boolean bl) {
    }

    default public void handleViewCreationError(Throwable throwable, boolean bl) {
    }

    default public void rebootSystem(Throwable throwable) {
    }
}

