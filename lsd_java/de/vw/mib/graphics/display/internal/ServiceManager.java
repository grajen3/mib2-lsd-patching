/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.display.internal;

import de.vw.mib.graphics.display.spi.DisplaySPI;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;

final class ServiceManager {
    static LoggerFactory loggerFactory;
    static DisplaySPI displaySPI;
    static TimerManager timerManager;

    private ServiceManager() {
    }
}

