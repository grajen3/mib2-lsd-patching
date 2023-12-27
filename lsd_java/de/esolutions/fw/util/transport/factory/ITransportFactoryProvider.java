/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;

public interface ITransportFactoryProvider {
    default public ISingleTransportFactory createSingleTransportFactory(String string, String string2) {
    }

    default public ISpawnTransportFactory createSpawnTransportFactory(String string, String string2) {
    }
}

