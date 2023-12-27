/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractStartupTarget
implements Target {
    private static final String TASK_ID;
    private final Logger logger;
    private final GenericEvents genericEvents;
    private int targetId;

    public AbstractStartupTarget(GenericEvents genericEvents, Logger logger, int n) {
        this.genericEvents = genericEvents;
        this.logger = logger;
        this.targetId = n;
        this.registerTargetWithTargetId();
    }

    public AbstractStartupTarget(GenericEvents genericEvents, Logger logger) {
        this.genericEvents = genericEvents;
        this.logger = logger;
        this.registerTargetWithoutTargetId();
    }

    @Override
    public final void setTargetId(int n) {
        this.targetId = n;
    }

    @Override
    public final int getTargetId() {
        return this.targetId;
    }

    @Override
    public final GenericEvents getMainObject() {
        return this.genericEvents;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    private void registerTargetWithTargetId() {
        try {
            this.genericEvents.getEventDispatcher().registerTarget(this.getTargetId(), this, "hsmtask");
        }
        catch (Exception exception) {
            this.logError(new StringBuffer().append("Could not register target ").append(super.getClass().getName()).toString(), exception);
        }
    }

    private void registerTargetWithoutTargetId() {
        try {
            this.genericEvents.getEventDispatcher().registerTarget(this, "hsmtask");
        }
        catch (Exception exception) {
            this.logError(new StringBuffer().append("Could not register target ").append(super.getClass().getName()).toString(), exception);
        }
    }

    protected final void logWarning(String string) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.warn(1, string);
        }
    }

    protected final void logError(String string) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.error(1, string);
        }
    }

    protected final void logError(String string, Throwable throwable) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.error(1).append(string).append(throwable).log();
        }
    }

    protected final void logTrace(String string) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.trace(1, string);
        }
    }

    protected final void logInfo(String string) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.info(1, string);
        }
    }

    protected final void logFatal(String string, Throwable throwable) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.fatal(1, string, throwable);
        }
    }

    protected final void logFatal(String string) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.fatal(1, string);
        }
    }
}

