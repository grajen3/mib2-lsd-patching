/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote.push;

import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.GenericConnectionFactory;
import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.serializer.factory.BEDefaultSerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.remote.AbstractRemoteBackend;
import de.esolutions.fw.util.transport.factory.BaseTransportFactory;
import de.esolutions.fw.util.transport.factory.FileSingleTransportFactory;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.factory.MultiOutputFileSingleTransportFactory;
import java.io.File;

public class BinaryFileBackend
extends AbstractRemoteBackend {
    private String fileName;
    private int splitSize;
    private String outDir;
    private int numDigits;
    private int session;
    private String curPath;

    public BinaryFileBackend() {
        super("remoteDump");
    }

    public BinaryFileBackend(String string, String string2, int n, int n2) {
        this(string, string2, n, n2, 0);
    }

    public BinaryFileBackend(String string, String string2, int n, int n2, int n3) {
        super("remoteDump");
        this.fileName = string;
        this.outDir = string2;
        this.splitSize = n;
        this.numDigits = n2;
        this.session = n3;
    }

    @Override
    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        super.init(s, iTraceBackendListener, traceConfigBackend);
        if (traceConfigBackend != null) {
            this.splitSize = traceConfigBackend.getQuery().getIntegerValue("splitSize", 1024);
            this.fileName = traceConfigBackend.getFileName(this.fileName, this.splitSize == 0 ? "esotrace" : null);
            this.outDir = traceConfigBackend.getOutputDirectory(this.outDir);
            this.numDigits = traceConfigBackend.getQuery().getIntegerValue("numDigits", 4);
        }
        this.splitSize *= 1024;
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
        super.connect();
        IConnectionFactory iConnectionFactory = this.setupFactory();
        if (iConnectionFactory == null) {
            return false;
        }
        Connection connection = iConnectionFactory.createConnection();
        try {
            this.remoteConnect(connection, true, true, false);
            this.listener.connected(this.bid, true);
        }
        catch (InterruptedException interruptedException) {
            this.listener.logMessage(this.bid, "failed connection to proto file");
            this.listener.connected(this.bid, false);
        }
        return true;
    }

    @Override
    public void disconnect() {
        this.listener.logMessage(this.bid, new StringBuffer().append("closing eso proto file ").append(this.fileName).toString());
        this.remoteDisconnect();
        super.disconnect();
    }

    private IConnectionFactory setupFactory() {
        Object object;
        BaseTransportFactory baseTransportFactory;
        if (this.splitSize == 0) {
            this.curPath = this.appendSession(this.fileName);
            this.listener.logMessage(this.bid, new StringBuffer().append("setting dump to single file ").append(this.curPath).toString());
            baseTransportFactory = new FileSingleTransportFactory(this.curPath);
        } else {
            this.curPath = this.appendSession(this.outDir);
            object = new StringBuffer().append(this.curPath).append(File.separator).append("log").toString();
            this.listener.logMessage(this.bid, new StringBuffer().append("setting dump to multi file in base dir ").append(this.curPath).toString());
            File file = new File(this.curPath);
            if (!file.isDirectory() && !file.mkdirs()) {
                this.listener.logMessage(this.bid, new StringBuffer().append("error creating dir ").append(this.curPath).toString());
                return null;
            }
            baseTransportFactory = new MultiOutputFileSingleTransportFactory((String)object, "esotrace", this.numDigits, 0, this.splitSize);
        }
        object = new BEDefaultSerializerFactory();
        return new GenericConnectionFactory((ISingleTransportFactory)((Object)baseTransportFactory), (ISerializerFactory)object);
    }

    public String getCurrentPath() {
        return this.curPath;
    }
}

