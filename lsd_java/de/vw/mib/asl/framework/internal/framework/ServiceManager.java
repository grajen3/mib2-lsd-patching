/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentFactory;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.api.framework.speller.ASLAPISpellerFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.reflection.ContainerReflectionFactory;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.asl.internal.registry.ASLDeviceRegistry;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.error.ErrorHandler;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.format.FixFormat4Asl;
import de.vw.mib.framework4u.Framework4U;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.graphics.image.ImageManager;
import de.vw.mib.log4mib.ClassifiedLogger;
import de.vw.mib.log4mib.LogManagerDiag;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.sound.SoundWaveplayer;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.dsi.ifc.base.ServiceAdmin;
import org.osgi.framework.BundleContext;

public final class ServiceManager {
    public static final String TASK_HSM;
    public static Logger logger;
    public static Logger logger2;
    public static LogManagerDiag logManagerDiag;
    public static ErrorHandler errorHandler;
    public static TimerManager timerManager;
    public static GenericEvents eventMain;
    public static EventFactory mGenericEventFactory;
    public static ContainerReflectionFactory reflectionFactory;
    public static DSIServiceLocator dsiServiceLocator;
    public static Logger dsiTraceLogger;
    public static ASLPropertyManager aslPropertyManager;
    public static SystemEventDispatcher eventDispatcher;
    public static AslPersistenceSyncApi persistence;
    public static AdaptionApi adaptionApi;
    public static ImageManager imageManager;
    public static SoundWaveplayer soundWaveplayer;
    public static StartupEventDispatcher startupEventDispatcher;
    public static ServiceAdmin dsiServiceAdmin;
    public static PerfService perfService;
    public static BundleContext bundleContext;
    public static ConfigurationManagerDiag configManagerDiag;
    public static Framework4U framework4U;
    public static FixFormat4Asl fixFormat4Asl;
    public static ASLComponentFactory componentFactory;
    public static ASLComponentRegistry componentRegistry;
    public static ASLDeviceRegistry deviceRegistry;
    public static ASLListManager listManager;
    public static ThreadSwitchingTarget aslThreadSwitch;
    public static AsyncServiceFactory aslAsyncServiceFactory;
    public static ASLAPISpellerFactory spellerFactory;
    static Logger loggerFW;
    public static ClassifiedLogger loggerFWCore;
    public static ClassifiedLogger loggerDSIProxy;

    private ServiceManager() {
    }

    static {
        logger = null;
        logger2 = null;
        logManagerDiag = null;
        errorHandler = null;
        timerManager = null;
        eventMain = null;
        mGenericEventFactory = null;
        reflectionFactory = null;
        dsiServiceLocator = null;
        dsiTraceLogger = null;
        aslPropertyManager = null;
        eventDispatcher = null;
        persistence = null;
        adaptionApi = null;
        imageManager = null;
        soundWaveplayer = null;
        startupEventDispatcher = null;
        dsiServiceAdmin = null;
        perfService = null;
        bundleContext = null;
        configManagerDiag = null;
        framework4U = null;
        fixFormat4Asl = null;
    }
}

