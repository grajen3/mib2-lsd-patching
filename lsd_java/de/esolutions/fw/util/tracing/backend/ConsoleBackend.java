/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.backend.AbstractTraceBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;

public class ConsoleBackend
extends AbstractTraceBackend {
    private ITraceMessageFormatter formatter;
    private ITraceEntityResolver resolver;

    public ConsoleBackend() {
        super("Console");
    }

    public void setFormatter(ITraceMessageFormatter iTraceMessageFormatter) {
        this.formatter = iTraceMessageFormatter;
    }

    @Override
    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        super.init(s, iTraceBackendListener, traceConfigBackend);
        if (this.formatter == null) {
            String string = null;
            if (traceConfigBackend != null) {
                string = traceConfigBackend.getQuery().getStringValue("formatter");
            }
            this.formatter = iTraceBackendListener.createFormatter(string, true);
        }
        this.resolver = iTraceBackendListener.getEntityResolver();
    }

    @Override
    public boolean log(ITraceMessage iTraceMessage) {
        String[] stringArray = this.formatter.formatMessage(iTraceMessage, this.resolver);
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            System.out.println(stringArray[i2]);
        }
        System.out.flush();
        return true;
    }

    @Override
    public boolean droppedMessages(int n) {
        System.out.println(new StringBuffer().append("DROPPED ").append(n).append(" MESSAGES").toString());
        return true;
    }

    @Override
    public boolean updateTimeZone(int n, long l, long l2) {
        String string = this.listener.getTimeZoneName(n);
        TraceTimeStamp traceTimeStamp = new TraceTimeStamp(l);
        TraceTimeStamp traceTimeStamp2 = new TraceTimeStamp(l2);
        System.out.println(new StringBuffer().append(traceTimeStamp2.toUTCTimeString(false)).append("  time zone  ").append(string).append("  ").append(traceTimeStamp.toUTCTimeString(false)).toString());
        return true;
    }
}

