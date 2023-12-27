/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib;

import de.vw.mib.log4mib.LogMessage;

public interface ClassifiedLogger {
    default public boolean isTraceEnabled() {
    }

    default public LogMessage trace() {
    }

    default public LogMessage normal() {
    }

    default public LogMessage info() {
    }

    default public LogMessage warn() {
    }

    default public LogMessage error() {
    }

    default public LogMessage fatal() {
    }
}

