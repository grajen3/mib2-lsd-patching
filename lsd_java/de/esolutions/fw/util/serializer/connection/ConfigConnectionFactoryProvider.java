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
import de.esolutions.fw.util.serializer.factory.ConfigSerializerFactoryProvider;
import de.esolutions.fw.util.transport.config.TransportConfig;
import de.esolutions.fw.util.transport.exception.TransportFactoryException;
import de.esolutions.fw.util.transport.factory.ConfigTransportFactoryProvider;

public class ConfigConnectionFactoryProvider
implements IConnectionFactoryProvider {
    private ConfigTransportFactoryProvider transport;
    private ConfigSerializerFactoryProvider serializer;

    public ConfigConnectionFactoryProvider(TransportConfig transportConfig) {
        try {
            this.transport = new ConfigTransportFactoryProvider(transportConfig);
            this.serializer = new ConfigSerializerFactoryProvider(transportConfig);
        }
        catch (TransportFactoryException transportFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Transport Problem: ").append(transportFactoryException.getMessage()).toString());
        }
        catch (SerializerFactoryException serializerFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Serializer Problem: ").append(serializerFactoryException.getMessage()).toString());
        }
    }

    @Override
    public IConnectionFactory createConnectionFactory(String string, String string2) {
        try {
            return new GenericConnectionFactory(this.transport.createSingleTransportFactory(string, string2), this.serializer.createSerializerFactory(string, string2));
        }
        catch (TransportFactoryException transportFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Transport failed: ").append(transportFactoryException.toString()).toString());
        }
        catch (SerializerFactoryException serializerFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Serializer failed: ").append(serializerFactoryException.toString()).toString());
        }
    }

    @Override
    public ISpawnConnectionFactory createSpawnConnectionFactory(String string, String string2) {
        try {
            return new GenericSpawnConnectionFactory(this.transport.createSpawnTransportFactory(string, string2), this.serializer.createMySerializerFactory(string, string2));
        }
        catch (TransportFactoryException transportFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Transport failed: ").append(transportFactoryException.toString()).toString());
        }
        catch (SerializerFactoryException serializerFactoryException) {
            throw new ConnectionFactoryException(new StringBuffer().append("Serializer failed: ").append(serializerFactoryException.toString()).toString());
        }
    }
}

