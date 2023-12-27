/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.internal;

import de.vw.mib.cio.framework.diag.CioDiagService;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.datapool.diag.DebugDatapool;
import de.vw.mib.debug.screenshot.ScreenshotProvider;
import de.vw.mib.debuginterface.ViewStackProvider;
import de.vw.mib.debugmanager.unifiedlogging.BinaryLogger;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.event.dispatcher.StatemachineEventDispatcher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.graphics.display.spi.DisplaySPI;
import de.vw.mib.list.DynamicListManager;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.threads.MIBThreadManager;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.viewmanager.DesktopDiag;
import org.osgi.framework.BundleContext;

public final class ServiceManager {
    public static LoggerFactory loggerFactory = null;
    public static GenericEvents ge = null;
    public static EventFactory mEventFactory = null;
    public static boolean monitorConnected = false;
    public static ConfigurationManager configurationManager;
    public static DebugDatapool datapool;
    public static StatemachineEventDispatcher statemachineEventDispatcher;
    public static SystemEventDispatcher systemEventDispatcher;
    public static FrameworkEventDispatcher frameworkEventDispatcher;
    public static ViewStackProvider viewManager;
    public static DesktopDiag desktopDiag;
    public static TimerManager timerManager;
    public static MIBThreadManager threadManager;
    public static ErrorHandler errorHandler;
    public static DynamicListManager dynamicListManager;
    public static CioDiagService cioDiagService;
    public static ScreenshotProvider screenshotProvider;
    public static DisplaySPI displaySPI;
    public static BundleContext context;
    public static BinaryLogger binaryLogger;

    private ServiceManager() {
    }
}

