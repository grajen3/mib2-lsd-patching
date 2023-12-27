/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;
import java.io.IOException;

public abstract class AbstractSpawnedConnectionListener
implements ISpawnedConnectionListener {
    @Override
    public boolean spawningRetry(ISpawnConnectionFactory iSpawnConnectionFactory, IOException iOException, int n) {
        return true;
    }

    @Override
    public void spawningEnabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
    }

    @Override
    public void spawningDisabled(ISpawnConnectionFactory iSpawnConnectionFactory) {
    }
}

