/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.transport.ITransport;

public class Connection {
    protected ITransport transport;
    protected ISerializer serializer;
    protected IDeserializer deserializer;

    public Connection(ITransport iTransport, ISerializer iSerializer, IDeserializer iDeserializer) {
        this.transport = iTransport;
        this.serializer = iSerializer;
        this.deserializer = iDeserializer;
    }

    public ITransport getTransport() {
        return this.transport;
    }

    public ISerializer getSerializer() {
        return this.serializer;
    }

    public IDeserializer getDeserializer() {
        return this.deserializer;
    }

    public void open() {
        this.transport.open();
    }

    public void close(boolean bl) {
        this.transport.close(bl);
    }

    public String getDescription() {
        return new StringBuffer().append("[t=").append(this.transport.getDescription()).append(",sd=").append(this.serializer.getDescription()).append(",").append(this.deserializer.getDescription()).append("]").toString();
    }
}

