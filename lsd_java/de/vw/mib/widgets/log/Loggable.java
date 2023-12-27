/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.log;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.log.Logger;

public interface Loggable {
    default public LogMessage error(Logger logger) {
    }

    default public LogMessage normal(Logger logger) {
    }

    default public LogMessage trace(Logger logger) {
    }

    default public LogMessage warn(Logger logger) {
    }
}

