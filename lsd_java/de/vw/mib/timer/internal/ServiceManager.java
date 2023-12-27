/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.error.ErrorHandler;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.timer.diag.TimerDiag;
import de.vw.mib.timer.internal.EmptyTimerDiag;
import de.vw.mib.timer.spi.TimerSPI;

final class ServiceManager {
    static LoggerFactory loggerFactory;
    static ErrorHandler errorHandler;
    static MIBThreadManager threadManager;
    static TimerDiag timerDiag;
    static TimerSPI timerSPI;

    private ServiceManager() {
    }

    static {
        timerDiag = new EmptyTimerDiag();
    }
}

