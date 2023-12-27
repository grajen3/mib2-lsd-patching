/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.backend.AbstractTraceBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.util.TraceTimeStamp;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileBackend
extends AbstractTraceBackend {
    private ITraceMessageFormatter formatter;
    private ITraceEntityResolver resolver;
    private Writer fileWriter;
    private String fileName;
    private int session;
    private String curFileName;
    private String outputDirectory;
    private String suffix;
    private static final String chn;

    public FileBackend() {
        super("File");
    }

    public FileBackend(String string) {
        this(string, 0);
    }

    public FileBackend(String string, int n) {
        super("File");
        this.fileName = string;
        this.session = n;
        this.curFileName = this.appendSession(string);
    }

    public void setFormatter(ITraceMessageFormatter iTraceMessageFormatter) {
        this.formatter = iTraceMessageFormatter;
    }

    @Override
    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        super.init(s, iTraceBackendListener, traceConfigBackend);
        String string = null;
        if (traceConfigBackend != null) {
            IConfigQuery iConfigQuery = traceConfigBackend.getQuery();
            string = iConfigQuery.getStringValue("formatter");
            this.outputDirectory = traceConfigBackend.getOutputDirectory("");
            this.suffix = iConfigQuery.getStringValue("logfileSuffix", ".log");
            this.fileName = traceConfigBackend.getFileName(this.fileName, this.suffix);
            this.fileName = new StringBuffer().append(this.outputDirectory).append(this.fileName).toString();
            this.curFileName = this.appendSession(this.fileName);
        }
        if (this.formatter == null) {
            this.formatter = iTraceBackendListener.createFormatter(string, true);
        }
        this.resolver = iTraceBackendListener.getEntityResolver();
    }

    private String appendSession(String string) {
        if (this.session == 0) {
            return string;
        }
        int n = string.lastIndexOf(46);
        if (n == -1) {
            return new StringBuffer().append(string).append("_s").append(this.session).toString();
        }
        return new StringBuffer().append(string.substring(0, n)).append("_s").append(this.session).append(string.substring(n)).toString();
    }

    @Override
    public boolean connect() {
        TraceMe.msg(TraceMe.DEBUG, "FileBackend", "open log at %1", this.curFileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.curFileName);
            this.fileWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
            this.listener.connected(this.bid, true);
            return true;
        }
        catch (IOException iOException) {
            TraceMe.msg(TraceMe.ERROR, "FileBackend", "failed open with %1", iOException);
            return false;
        }
        catch (Exception exception) {
            TraceMe.msg(TraceMe.ERROR, "FileBackend", "can't write to %1: %2", this.curFileName, exception);
            return false;
        }
    }

    public String getCurrentFileName() {
        return this.curFileName;
    }

    @Override
    public void disconnect() {
        try {
            ++this.session;
            this.curFileName = this.appendSession(this.fileName);
            TraceMe.msg(TraceMe.INFO, "File: closing %1", this.fileName);
            this.fileWriter.close();
            this.fileWriter = null;
        }
        catch (IOException iOException) {
            TraceMe.msg(TraceMe.ERROR, "FileBackend", "error close with ", iOException);
        }
        catch (NullPointerException nullPointerException) {
            TraceMe.msg(TraceMe.ERROR, "FileBackend", "NullPointerException catched ");
        }
    }

    @Override
    public boolean log(ITraceMessage iTraceMessage) {
        try {
            String[] stringArray = this.formatter.formatMessage(iTraceMessage, this.resolver);
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.fileWriter.write(stringArray[i2]);
                this.fileWriter.write("\n");
                this.fileWriter.flush();
            }
        }
        catch (IOException iOException) {
            this.fileWriter = null;
            this.listener.disconnected(this.bid);
            return false;
        }
        catch (NullPointerException nullPointerException) {
            TraceMe.msg(TraceMe.ERROR, "FileBackend", "NullPointerException catched ");
            return false;
        }
        return true;
    }

    @Override
    public boolean droppedMessages(int n) {
        try {
            this.fileWriter.write(new StringBuffer().append("DROPPED ").append(n).append(" MESSAGES\n").toString());
        }
        catch (IOException iOException) {
            this.fileWriter = null;
            this.listener.disconnected(this.bid);
            return false;
        }
        catch (NullPointerException nullPointerException) {
            TraceMe.msg(TraceMe.ERROR, "FileBackend", "NullPointerException catched ");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateTimeZone(int n, long l, long l2) {
        String string = this.listener.getTimeZoneName(n);
        TraceTimeStamp traceTimeStamp = new TraceTimeStamp(l);
        TraceTimeStamp traceTimeStamp2 = new TraceTimeStamp(l2);
        String string2 = new StringBuffer().append(traceTimeStamp2.toUTCTimeString(false)).append("  time zone  ").append(string).append("  ").append(traceTimeStamp.toUTCTimeString(false)).toString();
        try {
            this.fileWriter.write(string2);
        }
        catch (IOException iOException) {
            this.fileWriter = null;
            this.listener.disconnected(this.bid);
            return false;
        }
        catch (NullPointerException nullPointerException) {
            TraceMe.msg(TraceMe.ERROR, "FileBackend", "NullPointerException catched ");
            return false;
        }
        return true;
    }
}

