/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.backend.AbstractTraceBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.message.TraceMessageBuffer;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class EmergencyRecorderBackend
extends AbstractTraceBackend {
    private TraceMessageBuffer buffer;
    private String filePath;
    private ITraceMessageFormatter formatter;
    private ITraceEntityResolver resolver;

    public EmergencyRecorderBackend() {
        super("EmergencyRecorder");
    }

    @Override
    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        super.init(s, iTraceBackendListener, traceConfigBackend);
        IConfigQuery iConfigQuery = traceConfigBackend.getQuery();
        String string = iConfigQuery.getStringValue("formatter");
        this.formatter = iTraceBackendListener.createFormatter(string, true);
        this.resolver = iTraceBackendListener.getEntityResolver();
        int n = iConfigQuery.getIntegerValue("numMessages", 100);
        this.filePath = iConfigQuery.getStringValue("path", "er.log");
        this.buffer = new TraceMessageBuffer(n);
    }

    @Override
    public void exit() {
        this.buffer = null;
    }

    @Override
    public boolean log(ITraceMessage iTraceMessage) {
        this.buffer.put(iTraceMessage, true);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void handleBreak() {
        ITraceMessage[] iTraceMessageArray = this.buffer.getAll();
        if (iTraceMessageArray == null) {
            return;
        }
        System.out.println(new StringBuffer().append("Dumping ").append(iTraceMessageArray.length).append(" messages").toString());
        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(this.filePath), "UTF-8");
            for (int i2 = 0; i2 < iTraceMessageArray.length; ++i2) {
                String[] stringArray = this.formatter.formatMessage(iTraceMessageArray[i2], this.resolver);
                for (int i3 = 0; i3 < stringArray.length; ++i3) {
                    writer.write(stringArray[i3]);
                    writer.write("\n");
                }
            }
        }
        catch (IOException iOException) {
            System.out.println(new StringBuffer().append("ERROR writing ER log: ").append(iOException).toString());
        }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                }
                catch (IOException iOException) {}
            }
        }
    }
}

