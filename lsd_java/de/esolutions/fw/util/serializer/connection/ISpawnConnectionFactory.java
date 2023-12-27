/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.ISpawnedConnectionListener;

public interface ISpawnConnectionFactory {
    default public void setListener(ISpawnedConnectionListener iSpawnedConnectionListener) {
    }

    default public void enableSpawning() {
    }

    default public void disableSpawning() {
    }

    default public String getDescription() {
    }
}

