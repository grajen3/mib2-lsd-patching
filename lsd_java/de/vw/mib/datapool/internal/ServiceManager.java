/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool.internal;

import de.vw.mib.event.dispatcher.DatapoolEventDispatcher;
import de.vw.mib.list.DynamicListManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;

public final class ServiceManager {
    public static DynamicListManager dynamicListManager;
    public static DatapoolEventDispatcher eventDispatcher;
    public static LoggerFactory loggerFactory;
    public static TimerManager timerManager;

    private ServiceManager() {
    }
}

