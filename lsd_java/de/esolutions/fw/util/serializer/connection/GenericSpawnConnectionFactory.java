/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.GenericSpawnConnectionFactory$TransportListenerAdapter;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;
import de.esolutions.fw.util.serializer.factory.ISerializerFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;

public class GenericSpawnConnectionFactory
implements ISpawnConnectionFactory {
    protected ISpawnTransportFactory transportFactory;
    protected GenericSpawnConnectionFactory$TransportListenerAdapter adapter;

    public GenericSpawnConnectionFactory(ISpawnTransportFactory iSpawnTransportFactory, ISerializerFactory iSerializerFactory) {
        this.transportFactory = iSpawnTransportFactory;
        this.adapter = new GenericSpawnConnectionFactory$TransportListenerAdapter(this, iSerializerFactory);
        iSpawnTransportFactory.setListener(this.adapter);
    }

    @Override
    public void enableSpawning() {
        this.transportFactory.enableSpawning();
    }

    @Override
    public void disableSpawning() {
        this.transportFactory.disableSpawning();
    }

    @Override
    public void setListener(ISpawnedConnectionListener iSpawnedConnectionListener) {
        this.adapter.setListener(iSpawnedConnectionListener);
    }

    @Override
    public String getDescription() {
        return this.transportFactory.getDescription();
    }
}

