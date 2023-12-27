/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.datapool;

import de.vw.mib.datapool.internal.ServiceManager;
import de.vw.mib.event.dispatcher.DatapoolEventDispatcher;
import de.vw.mib.list.DynamicListManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.TimerManager;

public abstract class DatapoolActivator {
    protected final void setupDatapoolServiceManager(LoggerFactory loggerFactory, DatapoolEventDispatcher datapoolEventDispatcher, TimerManager timerManager) {
        ServiceManager.loggerFactory = loggerFactory;
        ServiceManager.eventDispatcher = datapoolEventDispatcher;
        ServiceManager.timerManager = timerManager;
    }

    protected final void setupDatapoolServiceManager(DynamicListManager dynamicListManager) {
        if (ServiceManager.dynamicListManager == null) {
            ServiceManager.dynamicListManager = dynamicListManager;
        }
    }
}

