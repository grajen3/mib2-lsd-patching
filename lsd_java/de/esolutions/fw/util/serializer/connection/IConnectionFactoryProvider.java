/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.IConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;

public interface IConnectionFactoryProvider {
    default public IConnectionFactory createConnectionFactory(String string, String string2) {
    }

    default public ISpawnConnectionFactory createSpawnConnectionFactory(String string, String string2) {
    }
}

