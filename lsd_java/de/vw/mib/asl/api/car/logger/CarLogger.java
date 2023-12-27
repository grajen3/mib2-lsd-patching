/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.car.logger;

import de.vw.mib.log4mib.LogMessage;

public interface CarLogger {
    default public boolean isTraceEnabled() {
    }

    default public void trace(String string) {
    }

    default public void error(String string) {
    }

    default public LogMessage error() {
    }

    default public void warn(String string) {
    }

    default public void normal(String string) {
    }

    default public void info(String string) {
    }

    default public void fatal(String string) {
    }
}

