/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.lsc;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.internal.impl.lsc.LscLogger;
import de.vw.mib.asl.framework.internal.lsc.AutomaticLanguageModeInstaller;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;

public interface LscServices {
    default public AutomaticLanguageModeInstaller getAutomaticLanguageModeInstaller() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public ConfigurationManagerDiag getConfigManagerDiag() {
    }

    default public AslPersistenceSyncApi getPersistenceSyncApi() {
    }

    default public AdaptionApi getAdaptionApi() {
    }

    default public LscLogger getLscLogger() {
    }

    default public ASLPropertyManager getPropertyManager() {
    }

    default public FactoryResetService getFactoryResetService() {
    }

    default public ASLComponentRegistry getAslComponentRegistry() {
    }

    default public AsyncServiceFactory getAsyncServiceFactory() {
    }

    default public BundleContext getBundleContext() {
    }
}

