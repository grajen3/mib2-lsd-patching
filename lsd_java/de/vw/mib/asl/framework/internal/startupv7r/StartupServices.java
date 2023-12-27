/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.systemstate.SystemStateService;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.internal.startupv7r.DsiInformationService;
import de.vw.mib.asl.framework.internal.startupv7r.PersistableEarlyData;
import de.vw.mib.asl.framework.internal.startupv7r.PersistenceInformationService;
import de.vw.mib.asl.framework.internal.startupv7r.api.impl.StartupStateServiceImpl;
import de.vw.mib.asl.framework.internal.startupv7r.entryconditions.EntryConditionService;
import de.vw.mib.asl.framework.internal.startupv7r.model.DomainStates;
import de.vw.mib.asl.framework.internal.startupv7r.restart.RestartHandler;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.StartupEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.threads.AsyncServiceFactory;
import de.vw.mib.timer.TimerManager;

public interface StartupServices {
    default public ASLPropertyManager getAslPropertyManager() {
    }

    default public ASLStartupv7rAPI getASLStartupv7rAPI() {
    }

    default public ConfigurationManagerDiag getConfigurationManagerDiag() {
    }

    default public ASLDiagnosisAPI getDiagnosisAPI() {
    }

    default public EntryConditionService getEntryConditionService() {
    }

    default public EventDispatcherHSM getEventDispatcher() {
    }

    default public EventFactory getEventFactory() {
    }

    default public Logger getLogger() {
    }

    default public ASLPersistenceAPI getPersistenceApi() {
    }

    default public StartupStateServiceImpl getStartupStateService() {
    }

    default public SystemStateService getSystemStateService() {
    }

    default public ThreadSwitchingTarget getAslThreadSwitchingTarget() {
    }

    default public TimerManager getTimerManager() {
    }

    default public DsiInformationService getDsiInformationService() {
    }

    default public PersistenceInformationService getPersistenceInformationService() {
    }

    default public Services getAslFrameworkServices() {
    }

    default public PerfService getPerfService() {
    }

    default public DSIProxy getDSIProxy() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public RestartHandler getRestartHandler() {
    }

    default public DomainStates getDomainStates() {
    }

    default public PersistableEarlyData getPersistableEarlyData() {
    }

    default public ASLSystemAPI getAslSystemApi() {
    }

    default public StartupEventDispatcher getStartupEventDispatcher() {
    }

    default public AsyncServiceFactory getAsyncServiceFactory() {
    }
}

