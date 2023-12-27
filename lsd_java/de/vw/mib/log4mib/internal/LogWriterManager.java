/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.internal;

import de.vw.mib.log4mib.Settings;
import de.vw.mib.log4mib.internal.LogClassifierNames;
import de.vw.mib.log4mib.internal.LogWriterAdapter;
import de.vw.mib.log4mib.internal.MessageFactory;
import de.vw.mib.log4mib.internal.PooledBinaryMessage;
import de.vw.mib.log4mib.internal.PooledLogMessage;
import de.vw.mib.log4mib.internal.TextualHeaderAppender;
import de.vw.mib.log4mib.writer.ConsoleLogWriter;
import de.vw.mib.log4mib.writer.LogMessageHeaderAppender;
import edu.emory.mathcs.backport.java.util.ArrayDeque;

final class LogWriterManager {
    private static final boolean TEXTUAL_CLASSIFIERS = Boolean.getBoolean("de.vw.mib.log4mib.console.textual.classifiers.enabled");
    private final ConsoleLogWriter consoleLogWriter;
    private final boolean consoleLogWriterEnabled;
    private LogWriterAdapter logWriter;
    private boolean logWriterRegistered = false;
    private boolean logWriterRegistering = false;
    private final MessageFactory factory;
    private ArrayDeque messageCache;
    private final int messageCacheSize;

    LogWriterManager(Settings settings, MessageFactory messageFactory) {
        this.factory = messageFactory;
        this.consoleLogWriterEnabled = settings.isConsoleLoggingEnabled();
        if (this.consoleLogWriterEnabled) {
            LogMessageHeaderAppender logMessageHeaderAppender = TEXTUAL_CLASSIFIERS ? new TextualHeaderAppender(new LogClassifierNames()) : LogMessageHeaderAppender.DEFAULT;
            this.consoleLogWriter = new ConsoleLogWriter(logMessageHeaderAppender);
        } else {
            this.consoleLogWriter = null;
        }
        this.messageCacheSize = settings.getLogMessageCacheSize();
        this.messageCache = new ArrayDeque(this.messageCacheSize);
    }

    void clearMessageCache() {
        ArrayDeque arrayDeque = this.messageCache;
        this.messageCache = new ArrayDeque(this.messageCache);
        arrayDeque.clear();
    }

    void dispatch(PooledBinaryMessage pooledBinaryMessage) {
        if (this.logWriterRegistered) {
            this.logWriter.writeMessage(pooledBinaryMessage);
        }
        this.factory.releaseObject(pooledBinaryMessage);
    }

    void dispatch(PooledLogMessage pooledLogMessage) {
        if (this.consoleLogWriterEnabled) {
            this.consoleLogWriter.write(pooledLogMessage);
        }
        if (this.logWriterRegistered) {
            this.logWriter.writeMessage(pooledLogMessage);
            this.factory.releaseObject(pooledLogMessage);
        } else {
            this.cacheLogMessage(pooledLogMessage);
            if (this.logWriterRegistering) {
                this.flushCacheToLogWriter();
                this.logWriterRegistered = true;
                this.logWriterRegistering = false;
            }
        }
    }

    void emitOSEvent(int n, String string) {
        if (this.logWriterRegistered) {
            this.logWriter.writeOSSystemLog(n, string);
        }
    }

    void registerLogWriter(LogWriterAdapter logWriterAdapter) {
        if (logWriterAdapter == null) {
            return;
        }
        this.logWriter = logWriterAdapter;
        this.logWriterRegistering = true;
        PooledLogMessage pooledLogMessage = this.factory.createLogMessage(12, 512, 1);
        pooledLogMessage.append("Log writer registered!").log();
    }

    void unregisterLogWriter() {
        if (this.logWriter == null) {
            return;
        }
        this.logWriterRegistered = false;
        this.logWriterRegistering = false;
        this.messageCache = new ArrayDeque(this.messageCacheSize);
        this.logWriter = null;
    }

    private void cacheLogMessage(PooledLogMessage pooledLogMessage) {
        if (this.messageCache.size() == this.messageCacheSize) {
            PooledLogMessage pooledLogMessage2 = (PooledLogMessage)this.messageCache.pollFirst();
            this.factory.releaseObject(pooledLogMessage2);
        }
        this.messageCache.add(pooledLogMessage);
    }

    private void flushCacheToLogWriter() {
        PooledLogMessage pooledLogMessage = (PooledLogMessage)this.messageCache.poll();
        while (pooledLogMessage != null) {
            this.logWriter.writeMessage(pooledLogMessage);
            this.factory.releaseObject(pooledLogMessage);
            pooledLogMessage = (PooledLogMessage)this.messageCache.poll();
        }
        this.messageCache = null;
    }
}

