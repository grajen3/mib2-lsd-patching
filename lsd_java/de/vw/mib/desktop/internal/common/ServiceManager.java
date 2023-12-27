/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.desktop.internal.common;

import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.debugmanager.performance.PerformanceTracingService;
import de.vw.mib.desktop.internal.DesktopManagerImpl;
import de.vw.mib.desktop.internal.common.ServiceManager$1;
import de.vw.mib.desktop.internal.popup.PopupStackManager;
import de.vw.mib.desktop.internal.screenarea.ScreenTree;
import de.vw.mib.desktop.internal.viewhandler.SmartViewHandlerProvider;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.FrameworkEventDispatcher;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.proximation.ProximityInstaller;
import de.vw.mib.repaint.RepaintManager;
import de.vw.mib.skin.SkinClassLoader;
import de.vw.mib.skin.V2vAnimationIndexProvider;
import de.vw.mib.sm.StatemachineManager;
import de.vw.mib.timer.TimerManager;
import de.vw.mib.view.ViewCompositor;
import de.vw.mib.viewmanager.internal.DiagViewListListener;
import de.vw.mib.viewmanager.internal.ViewHandlerFactory;
import de.vw.mib.viewmanager.internal.popup.PopupInformationTable;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

public final class ServiceManager {
    public static BundleContext bundleContext;
    public static DesktopManagerImpl desktopManager;
    public static PopupStackManager popupStackManager;
    public static ViewHandlerFactory viewHandlerFactory;
    public static LoggerFactory loggerFactory;
    public static PerformanceTracingService performanceTracer;
    public static ErrorHandler errorHandler;
    public static FrameworkEventDispatcher eventDispatcher;
    public static ConfigurationManager configurationManager;
    public static PopupInformationTable popupInformationTable;
    public static SkinClassLoader skinClassLoader;
    public static SmartViewHandlerProvider smartViewHandlerProvider;
    public static ViewCompositor viewCompositor;
    public static RepaintManager repaintManager;
    public static ScreenTree screenAreaTree;
    public static PerfService perfService;
    public static ProximityInstaller proximityInstaller;
    public static ServiceTracker popupInformationHandlerServiceTracker;
    public static ServiceTracker desktopInformationReceiverServiceTracker;
    public static boolean speechIsReady;
    public static V2vAnimationIndexProvider v2vAnimationIndexProvider;
    public static boolean infotainmentRecorderInfoDirty;
    public static boolean viewTreeIsDirty;
    public static DiagViewListListener diagViewListListener;
    public static StatemachineManager statemachineManager;
    public static TimerManager timerManager;

    private ServiceManager() {
    }

    static {
        speechIsReady = false;
        infotainmentRecorderInfoDirty = false;
        viewTreeIsDirty = false;
        diagViewListListener = new ServiceManager$1();
    }
}

