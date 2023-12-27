/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.error.internal;

import de.vw.mib.debug.spi.DebugSPI;
import de.vw.mib.error.RebootExecutor;
import de.vw.mib.error.ShowErrorPopupExecutor;
import de.vw.mib.error.SwitchToMenuExecutor;
import de.vw.mib.log4mib.LoggerFactory;

final class ServiceManager {
    static DebugSPI debugSpi;
    static LoggerFactory loggerFactory;
    static RebootExecutor rebootExecutor;
    static ShowErrorPopupExecutor showErrorPopupExecutor;
    static SwitchToMenuExecutor switchToMenuExecutor;

    private ServiceManager() {
    }
}

