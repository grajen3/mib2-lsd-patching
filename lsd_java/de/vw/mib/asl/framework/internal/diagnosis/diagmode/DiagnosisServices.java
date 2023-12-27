/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.diagmode;

import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;

public interface DiagnosisServices {
    default public AdaptionApi getAdaptionApi() {
    }

    default public ASLRadioAPI getRadioApi() {
    }

    default public SystemEventDispatcher getSystemEventDispatcher() {
    }

    default public EventFactory getEventFactory() {
    }

    default public Logger getLogger() {
    }

    default public ServiceRegister getServiceRegister() {
    }

    default public ConfigurationManagerDiag getConfigurationManager() {
    }

    default public PerfService getPerfService() {
    }

    default public ASLPersistenceAPI getAslPersistenceApi() {
    }

    default public EventDispatcherHSM getEventDispatcher() {
    }

    default public CioDictionary getCioDictionary() {
    }

    default public CioDispatcher getCioDispatcher() {
    }
}

