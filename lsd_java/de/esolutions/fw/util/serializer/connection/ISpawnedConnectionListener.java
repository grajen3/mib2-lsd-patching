/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import java.io.IOException;

public interface ISpawnedConnectionListener {
    default public void spawnedConnection(Connection connection) {
    }

    default public boolean spawningRetry(ISpawnConnectionFactory iSpawnConnectionFactory, IOException iOException, int n) {
    }

    default public void spawningEnabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
    }

    default public void spawningDisabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
    }
}

