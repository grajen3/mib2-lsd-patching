/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.factory.ISpawnedTransportListener;

public interface ISpawnTransportFactory {
    default public void setListener(ISpawnedTransportListener iSpawnedTransportListener) {
    }

    default public void enableSpawning() {
    }

    default public void disableSpawning() {
    }

    default public String getDescription() {
    }
}

