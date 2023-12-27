/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.ConnectionFactoryException;
import de.esolutions.fw.util.serializer.connection.GenericConnectionFactory;
import de.esolutions.fw.util.serializer.connection.GenericSpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.serializer.connection.IConnectionFactoryProvider;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.exception.SerializerFactoryException;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactoryProvider;
import de.esolutions.fw.util.transport.exception.TransportFactoryException;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ITransportFactoryProvider;

public class GenericConnectionFactoryProvider
implements IConnectionFactoryProvider {
    protected ITransportFactoryProvider transportFactoryProvider;
    protected ISerializerFactoryProvider serializerFactoryProvider;

    public GenericConnectionFactoryProvider(ITransportFactoryProvider iTransportFactoryProvider, ISerializerFactoryProvider iSerializerFactoryProvider) {
        this.transportFactoryProvider = iTransportFactoryProvider;
        this.serializerFactoryProvider = iSerializerFactoryProvider;
    }

    @Override
    public IConnectionFactory createConnectionFactory(String string, String string2) {
        try {
            ISingleTransportFactory iSingleTransportFactory = this.transportFactoryProvider.createSingleTransportFactory(string, string2);
            ISerializerFactory iSerializerFactory = this.serializerFactoryProvider.createSerializerFactory(string, string2);
            return new GenericConnectionFactory(iSingleTransportFactory, iSerializerFactory);
        }
        catch (TransportFactoryException transportFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Transport failed for peer ").append(string).append(":").append(string2).append(" -> ").append(transportFactoryException.toString()).toString());
        }
        catch (SerializerFactoryException serializerFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Serializer failed for peer ").append(string).append(":").append(string2).append(" -> ").append(serializerFactoryException.toString()).toString());
        }
    }

    @Override
    public ISpawnConnectionFactory createSpawnConnectionFactory(String string, String string2) {
        try {
            ISpawnTransportFactory iSpawnTransportFactory = this.transportFactoryProvider.createSpawnTransportFactory(string, string2);
            ISerializerFactory iSerializerFactory = this.serializerFactoryProvider.createMySerializerFactory(string, string2);
            return new GenericSpawnConnectionFactory(iSpawnTransportFactory, iSerializerFactory);
        }
        catch (TransportFactoryException transportFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Transport failed: ").append(transportFactoryException.toString()).toString());
        }
        catch (SerializerFactoryException serializerFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Serializer failed: ").append(serializerFactoryException.toString()).toString());
        }
    }
}

