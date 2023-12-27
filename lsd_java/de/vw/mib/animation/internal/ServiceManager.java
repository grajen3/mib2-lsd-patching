/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.internal;

import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;

public final class ServiceManager {
    public static LoggerFactory loggerFactory;
    static FrameworkEventDispatcher eventDispatcher;
    static TimerManager timerManager;

    private ServiceManager() {
    }
}

