/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.GenericSpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnedTransportListener;
import java.io.IOException;

public class GenericSpawnConnectionFactory$TransportListenerAdapter
implements ISpawnedTransportListener {
    protected ISerializerFactory serializerFactory;
    protected ISpawnedConnectionListener connectionListener;
    private final /* synthetic */ GenericSpawnConnectionFactory this$0;

    public GenericSpawnConnectionFactory$TransportListenerAdapter(GenericSpawnConnectionFactory genericSpawnConnectionFactory, ISerializerFactory iSerializerFactory) {
        this.this$0 = genericSpawnConnectionFactory;
        this.serializerFactory = iSerializerFactory;
    }

    public void setListener(ISpawnedConnectionListener iSpawnedConnectionListener) {
        this.connectionListener = iSpawnedConnectionListener;
    }

    @Override
    public void spawnedTransport(ITransport iTransport) {
        ISerializer iSerializer = this.serializerFactory.createExtendedSerializer();
        IDeserializer iDeserializer = this.serializerFactory.createExtendedDeserializer();
        Connection connection = new Connection(iTransport, iSerializer, iDeserializer);
        if (this.connectionListener != null) {
            this.connectionListener.spawnedConnection(connection);
        }
    }

    @Override
    public boolean spawningRetry(ISpawnTransportFactory iSpawnTransportFactory, IOException iOException, int n) {
        if (this.connectionListener != null) {
            return this.connectionListener.spawningRetry(this.this$0, iOException, n);
        }
        return true;
    }

    @Override
    public void spawningEnabled(ISpawnTransportFactory iSpawnTransportFactory) {
        if (this.connectionListener != null) {
            this.connectionListener.spawningEnabled(this.this$0);
        }
    }

    @Override
    public void spawningDisabled(ISpawnTransportFactory iSpawnTransportFactory) {
        if (this.connectionListener != null) {
            this.connectionListener.spawningDisabled(this.this$0);
        }
    }
}

