/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.startup.internal;

import de.vw.mib.event.dispatcher.EventDispatcherManager;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;

final class ServiceManager {
    static EventDispatcherManager eventDispatcherManager;
    static FrameworkEventDispatcher frameworkEventDispatcher;
    static LoggerFactory loggerFactory;
    static StartupEventDispatcher startupEventDispatcher;
    static MIBThreadManager threadManager;

    private ServiceManager() {
    }
}

