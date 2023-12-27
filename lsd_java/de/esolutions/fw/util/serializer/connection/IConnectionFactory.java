/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.serializer.connection;

import de.esolutions.fw.util.serializer.connection.Connection;

public interface IConnectionFactory {
    default public Connection createConnection() {
    }
}

