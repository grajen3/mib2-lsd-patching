/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.internal;

import de.vw.mib.appui.cio.CioVisualizationRegister;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.event.dispatcher.ViewEventDispatcher;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.view.internal.GlobalViewHandlerRegister;
import de.vw.mib.view.internal.ViewHandlerServices;

public interface AppSystemServices {
    default public LoggerFactory getLoggerFactory() {
    }

    default public StatemachineEventDispatcher getEventDispatcher() {
    }

    default public PerfService getPerfService() {
    }

    default public SkinClassLoader getSkinClassLoader() {
    }

    default public GlobalViewHandlerRegister getGlobalViewHandlerRegister() {
    }

    default public ViewHandlerServices getViewHandlerServices() {
    }

    default public CioVisualizationRegister getCioVisualizationRegister() {
    }

    default public ViewEventDispatcher getViewEventDispatcher() {
    }
}

