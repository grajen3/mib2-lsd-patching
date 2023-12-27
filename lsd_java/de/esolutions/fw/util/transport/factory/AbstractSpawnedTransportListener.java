/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnedTransportListener;
import java.io.IOException;

public abstract class AbstractSpawnedTransportListener
implements ISpawnedTransportListener {
    @Override
    public boolean spawningRetry(ISpawnTransportFactory iSpawnTransportFactory, IOException iOException, int n) {
        return true;
    }

    @Override
    public void spawningEnabled(ISpawnTransportFactory iSpawnTransportFactory) {
    }

    @Override
    public void spawningDisabled(ISpawnTransportFactory iSpawnTransportFactory) {
    }
}

