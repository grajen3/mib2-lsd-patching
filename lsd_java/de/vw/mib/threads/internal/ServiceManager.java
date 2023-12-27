/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads.internal;

import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.log4mib.LoggerFactory;

final class ServiceManager {
    static DebugSPI debugSpi;
    static ErrorHandler errorHandler;
    static LoggerFactory loggerFactory;

    private ServiceManager() {
    }
}

