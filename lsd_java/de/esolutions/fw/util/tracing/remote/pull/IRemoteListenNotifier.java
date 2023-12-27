/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote.pull;

import de.esolutions.fw.util.serializer.connection.Connection;

public interface IRemoteListenNotifier {
    default public void connectedLogger(String string, Connection connection) {
    }

    default public void disconnectedLogger(String string, Connection connection) {
    }
}

