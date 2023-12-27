/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.log4mib.writer;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.writer.AbstractStringLogWriter;
import de.vw.mib.log4mib.writer.LogMessageHeaderAppender;

public final class ConsoleLogWriter
extends AbstractStringLogWriter {
    private static final String SUPPRESS_HEARTBEAT_PROPERTY;
    private static final boolean SUPPRESS_TRACES;
    private static final boolean SUPPRESS_HEARTBEAT;

    public ConsoleLogWriter() {
    }

    public ConsoleLogWriter(LogMessageHeaderAppender logMessageHeaderAppender) {
        super(logMessageHeaderAppender);
    }

    @Override
    protected void write(LogMessage logMessage, String string, String string2) {
        if (logMessage.getLevel() > 4) {
            System.out.println(string);
        } else {
            System.err.println(string);
            if (string2 != null) {
                System.err.print(string2);
            }
        }
    }

    @Override
    protected boolean suppressThisMessage(LogMessage logMessage) {
        if (SUPPRESS_HEARTBEAT && logMessage.getClassifier() == 512 && logMessage.getSubClassifier() == 2) {
            return true;
        }
        return SUPPRESS_TRACES && logMessage.getLevel() > 8;
    }

    static {
        SUPPRESS_TRACES = !Boolean.getBoolean("de.vw.mib.log4mib.console.traces.enabled");
        SUPPRESS_HEARTBEAT = Boolean.getBoolean("suppress.heartbeat");
    }
}

