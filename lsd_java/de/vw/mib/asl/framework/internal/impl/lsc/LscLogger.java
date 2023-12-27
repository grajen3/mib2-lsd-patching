/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.lsc;

import de.vw.mib.asl.framework.internal.impl.lsc.Preconditions;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.internal.EmptyLoggerFactory;

public class LscLogger {
    public static final LscLogger EMPTY_LOGGER = new LscLogger(new EmptyLoggerFactory().getLogger(0));
    private static final int CLASSIFIER;
    private final Logger log;

    public LscLogger(Logger logger) {
        Preconditions.checkArgumentNotNull(logger, "Argument >log< must not be null!");
        this.log = logger;
    }

    public void error(String string) {
        this.log.error(64, string);
    }

    public void error(String string, Exception exception) {
        this.log.error(64, string, exception);
    }

    public void info(String string) {
        this.log.info(64, string);
    }

    public boolean isTraceEnabled() {
        return this.log.isTraceEnabled(64);
    }

    public void trace(String string) {
        if (this.isTraceEnabled()) {
            this.log.trace(64, string);
        }
    }

    public void warn(String string) {
        this.log.warn(64, string);
    }
}

