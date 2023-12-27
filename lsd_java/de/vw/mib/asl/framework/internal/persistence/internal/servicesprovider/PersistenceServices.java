/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider;

import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisAPI;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;
import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupService;
import de.vw.mib.asl.framework.api.startupv7r.ASLStartupv7rAPI;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;
import de.vw.mib.asl.framework.internal.persistence.AslPersistenceAsyncApi;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDb;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.GenericDeserializer;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceKeyProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceLogger;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistenceTracing;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileCopyService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileOperationRegistry;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileResetService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.RawPersistenceIdsDataProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAdapterProvider;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.dsi.DsiAwareProfileChangeListenerFactory;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.ModuleDescriptorRegistry;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import de.vw.mib.timer.TimerManager;
import org.osgi.framework.BundleContext;

public interface PersistenceServices {
    default public ApiPersDb getApiPersDb() {
    }

    default public AslPersistenceAsyncApi getAslPersistenceAsyncApi() {
    }

    default public ASLStartupv7rAPI getAslStartupApi() {
    }

    default public BundleContext getBundleContext() {
    }

    default public ASLDiagnosisAPI getDiagnosisAPI() {
    }

    default public DsiAdapterProvider getDsiAdapterProvider() {
    }

    default public DsiAwareProfileChangeListenerFactory getDsiAwareProfileChangeListenerFactory() {
    }

    default public GenericDeserializer getGenericDeserializer() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public Logger getLogger() {
    }

    default public PerfService getPerfService() {
    }

    default public PersistableService getPersistableService() {
    }

    default public PersistenceKeyProvider getPersistenceKeyProvider() {
    }

    default public PersistenceLogger getPersistenceLogger() {
    }

    default public PersistenceStartupService getPersistenceStartupService() {
    }

    default public PersistenceTracing getPersistenceTracing() {
    }

    default public ProfileCopyService getProfileCopyService() {
    }

    default public ProfileResetService getProfileResetService() {
    }

    default public RawPersistenceIdsDataProvider getRawPersistenceIdsDataProvider() {
    }

    default public StartupStateService getStartupStateService() {
    }

    default public ThreadSwitchingTarget getThreadSwitchingTarget() {
    }

    default public TimerManager getTimerManager() {
    }

    default public ModuleDescriptorRegistry getModuleDescriptorRegistry() {
    }

    default public DSIProxy getDsiProxy() {
    }

    default public ProfileOperationRegistry getProfileOperationRegistry() {
    }

    default public ASLPersistenceAPI getASLPersistenceAPI() {
    }
}

