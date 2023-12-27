/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.tracing.config.TraceConfigFormatter;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;

public interface ITraceMessageFormatter {
    default public void init(TraceConfigFormatter traceConfigFormatter) {
    }

    default public String[] formatMessage(ITraceMessage iTraceMessage, ITraceEntityResolver iTraceEntityResolver) {
    }
}

