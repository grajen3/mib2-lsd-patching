/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.speller.internal;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.speller.internal.ServiceManager;

class Log {
    private static final int SUB_CLASSIFIER;
    private static final String PREFIX;

    Log() {
    }

    static boolean isTraceEnabled() {
        Logger logger = Log.getLogger();
        return null != logger && logger.isTraceEnabled(4);
    }

    static LogMessage trace() {
        Logger logger = Log.getLogger();
        return null != logger && logger.isTraceEnabled(4) ? logger.trace(4).append("[SpellerController] ") : (LogMessage)null;
    }

    static LogMessage info() {
        Logger logger = Log.getLogger();
        return null != logger ? logger.info(4).append("[SpellerController] ") : (LogMessage)null;
    }

    static LogMessage normal() {
        Logger logger = Log.getLogger();
        return null != logger ? logger.normal(4).append("[SpellerController] ") : (LogMessage)null;
    }

    static LogMessage warn() {
        Logger logger = Log.getLogger();
        return null != logger ? logger.warn(4).append("[SpellerController] ") : (LogMessage)null;
    }

    static LogMessage error() {
        Logger logger = Log.getLogger();
        return null != logger ? logger.error(4).append("[SpellerController] ") : (LogMessage)null;
    }

    static LogMessage fatal() {
        Logger logger = Log.getLogger();
        return null != logger ? logger.fatal(4).append("[SpellerController] ") : (LogMessage)null;
    }

    static Logger getLogger() {
        return ServiceManager.logger;
    }
}

