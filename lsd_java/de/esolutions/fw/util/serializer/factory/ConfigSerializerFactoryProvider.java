/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.factory;

import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.serializer.exception.SerializerFactoryException;
import de.esolutions.fw.util.serializer.factory.BEDefaultSerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.serializer.factory.ISerializerFactoryProvider;
import de.esolutions.fw.util.serializer.factory.LEDefaultSerializerFactory;
import de.esolutions.fw.util.transport.config.SerializerParam;
import de.esolutions.fw.util.transport.config.TransportConfig;

public class ConfigSerializerFactoryProvider
implements ISerializerFactoryProvider {
    private TransportConfig config;

    public ConfigSerializerFactoryProvider(TransportConfig transportConfig) {
        this.config = transportConfig;
        if (!transportConfig.isValid()) {
            throw new SerializerFactoryException(new StringBuffer().append("Can't create factory provider with inavlid config:\n").append(transportConfig.getFailString()).toString());
        }
    }

    private ISerializerFactory fromQuery(IConfigQuery iConfigQuery, String string) {
        SerializerParam serializerParam = SerializerParam.create(iConfigQuery);
        if (serializerParam == null) {
            throw new SerializerFactoryException(new StringBuffer().append("Invalid serializer for ").append(string).toString());
        }
        int n = serializerParam.getType();
        if (n == 0) {
            return new BEDefaultSerializerFactory();
        }
        if (n == 1) {
            return new LEDefaultSerializerFactory();
        }
        throw new SerializerFactoryException(new StringBuffer().append("Unsupported serializer for ").append(string).toString());
    }

    @Override
    public ISerializerFactory createSerializerFactory(String string, String string2) {
        String string3 = new StringBuffer().append(string).append(":").append(string2).toString();
        ConfigOverlayPathQuery configOverlayPathQuery = this.config.getQueryForService(string, string2);
        if (configOverlayPathQuery == null) {
            throw new SerializerFactoryException(new StringBuffer().append("Can't find serializer for proc ").append(string3).toString());
        }
        return this.fromQuery(configOverlayPathQuery, string3);
    }

    @Override
    public ISerializerFactory createMySerializerFactory(String string, String string2) {
        String string3 = new StringBuffer().append(string).append(":").append(string2).toString();
        ConfigOverlayPathQuery configOverlayPathQuery = this.config.getQueryForMyService(string, string2);
        if (configOverlayPathQuery == null) {
            throw new SerializerFactoryException(new StringBuffer().append("Can't find serializer for node ").append(string3).toString());
        }
        return this.fromQuery(configOverlayPathQuery, string3);
    }
}

