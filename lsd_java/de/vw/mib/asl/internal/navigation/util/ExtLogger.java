/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

public interface ExtLogger
extends IExtLogger {
    @Override
    default public void error(String string) {
    }

    @Override
    default public void info(String string) {
    }

    @Override
    default public boolean isTraceEnabled() {
    }

    @Override
    default public LogMessage makeError() {
    }

    @Override
    default public LogMessage makeInfo() {
    }

    @Override
    default public LogMessage makeTrace() {
    }

    @Override
    default public LogMessage makeWarn() {
    }

    @Override
    default public void removeHandlingState() {
    }

    @Override
    default public void setHandlingState(HsmState hsmState) {
    }

    @Override
    default public void trace(String string) {
    }

    @Override
    default public boolean traceEnabled(int n) {
    }

    @Override
    default public void warn(String string) {
    }
}

