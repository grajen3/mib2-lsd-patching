/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager.core;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.log4mib.Logger;

public class PrefixLogger
implements Loggable {
    private final Logger logger;
    private final int subclassifier;
    private final Loggable prefix;

    public PrefixLogger(Logger logger, int n, Loggable loggable) {
        this.logger = logger;
        this.subclassifier = n;
        this.prefix = loggable != null ? loggable : this;
    }

    public void trace(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append(string).log();
        }
    }

    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled(this.subclassifier);
    }

    public LogMessage trace() {
        return this.logger.trace(this.subclassifier).append(this.prefix);
    }

    public LogMessage info() {
        return this.logger.info(this.subclassifier).append(this.prefix);
    }

    public LogMessage warn() {
        return this.logger.warn(this.subclassifier).append(this.prefix);
    }

    public LogMessage error() {
        return this.logger.error(this.subclassifier).append(this.prefix);
    }

    public void error(String string, Throwable throwable) {
        this.logger.error(this.subclassifier).append(this.prefix).append(string).attachThrowable(throwable).log();
    }

    @Override
    public void toString(LogMessage logMessage) {
    }
}

