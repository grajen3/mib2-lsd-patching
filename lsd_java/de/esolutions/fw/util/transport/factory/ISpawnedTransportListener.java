/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import java.io.IOException;

public interface ISpawnedTransportListener {
    default public void spawnedTransport(ITransport iTransport) {
    }

    default public boolean spawningRetry(ISpawnTransportFactory iSpawnTransportFactory, IOException iOException, int n) {
    }

    default public void spawningEnabled(ISpawnTransportFactory iSpawnTransportFactory) {
    }

    default public void spawningDisabled(ISpawnTransportFactory iSpawnTransportFactory) {
    }
}

