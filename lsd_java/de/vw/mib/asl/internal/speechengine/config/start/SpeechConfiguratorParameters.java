/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.start;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigRegistry;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.threads.AsyncServiceFactory;

public interface SpeechConfiguratorParameters {
    default public DialogSystemConfigRegistry getDialogSystemConfig() {
    }

    default public AbstractClassifiedLogger getClassifiedLogger() {
    }

    default public GenericEvents getGenericEvents() {
    }

    default public String getGenericEventsTaskId() {
    }

    default public AsyncServiceFactory getAsyncServiceFactory() {
    }

    default public FactoryResetService getFactoryResetService() {
    }

    default public ConfigurationManager getMIBConfigurationManager() {
    }

    default public AdaptionApi getAdaptionApi() {
    }
}

