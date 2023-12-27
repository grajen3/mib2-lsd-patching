/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.writer;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.LogWriter;
import de.vw.mib.log4mib.writer.AbstractStringLogWriter$LogMessageToStringConverter;
import de.vw.mib.log4mib.writer.LogMessageHeaderAppender;

public abstract class AbstractStringLogWriter
implements LogWriter {
    protected static final String HEADER_TEXT_SEPARATOR;
    private final AbstractStringLogWriter$LogMessageToStringConverter converter;

    public AbstractStringLogWriter() {
        this(LogMessageHeaderAppender.DEFAULT);
    }

    public AbstractStringLogWriter(LogMessageHeaderAppender logMessageHeaderAppender) {
        this.converter = new AbstractStringLogWriter$LogMessageToStringConverter(logMessageHeaderAppender);
    }

    @Override
    public void close() {
    }

    @Override
    public final void write(LogMessage logMessage) {
        if (this.suppressThisMessage(logMessage)) {
            return;
        }
        this.converter.convert(logMessage);
        this.write(logMessage, this.converter.getMessage(), this.converter.getStackTrace());
    }

    protected abstract void write(LogMessage logMessage, String string, String string2) {
    }

    @Override
    public void flush() {
    }

    @Override
    public void emitOSEvent(int n, String string) {
    }

    protected abstract boolean suppressThisMessage(LogMessage logMessage) {
    }
}

