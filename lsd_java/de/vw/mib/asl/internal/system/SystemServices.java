/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.car.parking.ASLParkingAPI;
import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.api.car.vehicle.ASLCarVehicleAPI;
import de.vw.mib.asl.api.globalsetupwizard.wizard.WizardService;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.system.content.ContentIdValidator;
import de.vw.mib.asl.api.system.content.StageContentRequestProcessor;
import de.vw.mib.asl.api.system.contentprocessor.ContentProcessorManager;
import de.vw.mib.asl.api.system.daynight.DayNightService;
import de.vw.mib.asl.api.system.emergency.EmergencyAnnouncementService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.input.UserInteractionLockService;
import de.vw.mib.asl.api.system.powerstate.ClampSignalService;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.api.testmode.valetparking.ValetParkingTestmodeService;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.internal.impl.system.clock.PropagatingDateTimeService;
import de.vw.mib.asl.internal.impl.system.powerstate.PropagatingPowerStateService;
import de.vw.mib.asl.internal.system.AslTargetSystemProximity;
import de.vw.mib.asl.internal.system.SystemData;
import de.vw.mib.asl.internal.system.abtfeatures.AbtFeatureServiceImpl;
import de.vw.mib.asl.internal.system.has.SystemHasBridge;
import de.vw.mib.asl.internal.system.input.gesture.PropagatingSpaceGestureService;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockManager;
import de.vw.mib.asl.internal.system.processor.manager.ClockManager;
import de.vw.mib.asl.internal.system.processor.stage.StageContentProcessor;
import de.vw.mib.asl.internal.system.processor.stage.StageContentRequestAdmin;
import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.util.SystemKeyUtil;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyPersistenceService;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.configuration.ConfigurationManagerAsyncValueSetterService;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;

public interface SystemServices {
    default public ASLCarVehicleAPI getAslCarVehicleApi() {
    }

    default public ASLDiagnosisAPI getAslDiagnosisApi() {
    }

    default public ASLStartupv7rAPI getAslStartupv7rAPI() {
    }

    default public AsyncServiceFactory getAsyncServiceFactory() {
    }

    default public BundleContext getBundleContext() {
    }

    default public ConfigurationManagerDiag getConfigManagerDiag() {
    }

    default public DSIProxy getDsiProxy() {
    }

    default public DSIProxyAdapterFactory getDsiProxyAdapterFactory() {
    }

    default public EventFactory getEventFactory() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public Logger getAsl1Logger() {
    }

    default public Logger getAsl2Logger() {
    }

    default public IPersistableEarlyData getPersistableEarlyData() {
    }

    default public AslPersistenceSyncApi getPersistence() {
    }

    default public PersonalizationService getPersonalizationService() {
    }

    default public PropagatingPowerStateService getPowerStateService() {
    }

    default public ASLPropertyManager getPropertyManager() {
    }

    default public AslTargetSystemProximity getProximityTarget() {
    }

    default public ServiceRegister getServiceRegister() {
    }

    default public SystemEventDispatcher getSystemEventDispatcher() {
    }

    default public ThreadSwitchingTarget getThreadSwitcher() {
    }

    default public TimerManager getTimerManager() {
    }

    default public AbtFeatureServiceImpl getAbtFeatureServiceImpl() {
    }

    default public SystemEarlyPersistenceService getEarlyPersistenceService() {
    }

    default public KeyLockManager getKeyLockManager() {
    }

    default public SystemStateService getSystemStateService() {
    }

    default public SystemCommonPersistenceService getSystemCommonPersistenceService() {
    }

    default public FactoryResetService getFactoryResetService() {
    }

    default public CioDispatcher getCioDispatcher() {
    }

    default public CioDictionary getCioDictionary() {
    }

    default public ValetParkingService getValetParkingService() {
    }

    default public ValetParkingTestmodeService getValetParkingTestmodeService() {
    }

    default public ProximityServiceImpl getProximityService() {
    }

    default public ClockManager getClockManager() {
    }

    default public ClockManager getDisplayOffClockManager() {
    }

    default public SystemKeyUtil getSystemKeyUtil() {
    }

    default public EventDispatcherHSM getEventDispatcher() {
    }

    default public CioFactory getCioFactory() {
    }

    default public SystemHasBridge getSystemHasBridge() {
    }

    default public WizardService getWizardService() {
    }

    default public ASLOnlineCoreServices getOnlineCoreServices() {
    }

    default public ASLParkingAPI getParkingAPI() {
    }

    default public PropagatingDateTimeService getDateTimeService() {
    }

    default public PropagatingSpaceGestureService getSpaceGestureService() {
    }

    default public ClampSignalService getClampSignalService() {
    }

    default public DayNightService getDayNightService() {
    }

    default public UserInteractionLockService getUserInteractionLockService() {
    }

    default public ConfigurationManagerAsyncValueSetterService getConfigurationManagerAsyncValueSetterService() {
    }

    default public ContentProcessorManager getContentProcessorManager() {
    }

    default public SystemData getSystemData() {
    }

    default public EmergencyAnnouncementService getEmergencyAnnouncementService() {
    }

    default public StageContentProcessor getStageContentProcessor() {
    }

    default public StageContentRequestProcessor getStageContentRequestProcessor() {
    }

    default public StageContentRequestAdmin getStageContentRequestAdmin() {
    }

    default public ContentIdValidator getContentIdValidator() {
    }
}

