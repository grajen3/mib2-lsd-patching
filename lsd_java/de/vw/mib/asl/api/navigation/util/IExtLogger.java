/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.log4mib.LogMessage;

public interface IExtLogger {
    default public void error(String string) {
    }

    default public void info(String string) {
    }

    default public boolean isTraceEnabled() {
    }

    default public LogMessage makeError() {
    }

    default public LogMessage makeInfo() {
    }

    default public LogMessage makeTrace() {
    }

    default public LogMessage makeWarn() {
    }

    default public void removeHandlingState() {
    }

    default public void setHandlingState(HsmState hsmState) {
    }

    default public void trace(String string) {
    }

    default public boolean traceEnabled(int n) {
    }

    default public void warn(String string) {
    }
}

