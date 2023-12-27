/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;

public class GenericConnectionFactory
implements IConnectionFactory {
    protected ISingleTransportFactory transportFactory;
    protected ISerializerFactory serializerFactory;

    public GenericConnectionFactory(ISingleTransportFactory iSingleTransportFactory, ISerializerFactory iSerializerFactory) {
        this.transportFactory = iSingleTransportFactory;
        this.serializerFactory = iSerializerFactory;
    }

    @Override
    public Connection createConnection() {
        ITransport iTransport = this.transportFactory.createTransport();
        ISerializer iSerializer = this.serializerFactory.createExtendedSerializer();
        IDeserializer iDeserializer = this.serializerFactory.createExtendedDeserializer();
        return new Connection(iTransport, iSerializer, iDeserializer);
    }
}

