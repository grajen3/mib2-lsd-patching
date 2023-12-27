/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.framework.internal.startupv7r.StartupTask;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractStartupTask
implements StartupTask {
    private final Logger logger;
    private boolean wasStarted;
    private boolean wasFinished;
    private Runnable callback;

    public AbstractStartupTask(Logger logger) {
        this.logger = logger;
    }

    @Override
    public final void run(Runnable runnable) {
        Preconditions.checkArgument(runnable != null, "Given callback must not be null.");
        Preconditions.checkState(!this.wasStarted, "Cannot run taks since it was started before.");
        this.callback = runnable;
        this.wasStarted = true;
        this.prepare();
        this.runTask();
    }

    protected abstract void runTask() {
    }

    protected void prepare() {
    }

    protected void cleanUp() {
    }

    protected final void finish() {
        Preconditions.checkState(this.wasStarted, "Cannot finish task since it hasn't been started yet.");
        if (!this.wasFinished) {
            this.wasFinished = true;
            this.callback.run();
            this.cleanUp();
        }
    }

    protected final void error(String string) {
        this.logger.error(1, this.buildMesasge(string));
    }

    protected final void error(String string, Exception exception) {
        this.logger.error(1, this.buildMesasge(string), exception);
    }

    protected final void warn(String string) {
        this.logger.warn(1, this.buildMesasge(string));
    }

    protected final void info(String string) {
        this.logger.info(1, this.buildMesasge(string));
    }

    protected final void trace(String string) {
        if (this.logger.isTraceEnabled(1)) {
            this.logger.trace(1, this.buildMesasge(string));
        }
    }

    protected final Logger getLogger() {
        return this.logger;
    }

    private String buildMesasge(String string) {
        return new StringBuffer().append("[").append(super.getClass().getName()).append("] ").append(string).toString();
    }
}

