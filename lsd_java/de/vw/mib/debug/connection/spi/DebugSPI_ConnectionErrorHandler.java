/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.connection.spi;

import de.vw.mib.debug.connection.spi.DebugSPI_Connection;

public interface DebugSPI_ConnectionErrorHandler {
    default public void handleConnectionLoss(DebugSPI_Connection debugSPI_Connection) {
    }
}

