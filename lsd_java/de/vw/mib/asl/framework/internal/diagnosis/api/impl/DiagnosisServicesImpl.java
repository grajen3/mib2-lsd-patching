/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.api.impl;

import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.framework.api.diagnosis.AdaptionApi;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkAPI;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.DiagnosisServices;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.EventDispatcherHSM;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.perf.service.PerfService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class DiagnosisServicesImpl
implements DiagnosisServices {
    private final ASLRadioAPI radioAPI;
    private final SystemEventDispatcher systemEventDispatcher;
    private final EventFactory eventFactory;
    private final Logger logger;
    private final ServiceRegister serviceRegister;
    private final ConfigurationManagerDiag configurationManager;
    private final PerfService perfService;
    private AdaptionApi adaptionApi;
    private ASLPersistenceAPI persistenceApi;
    private EventDispatcherHSM eventDispatcher;
    private CioDictionary cioDictionary;
    private CioDispatcher cioDispatcher;
    static /* synthetic */ Class class$de$vw$mib$perf$service$PerfService;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDictionary;
    static /* synthetic */ Class class$de$vw$mib$cio$CioDispatcher;

    public DiagnosisServicesImpl() {
        ASLFrameworkAPI aSLFrameworkAPI = ASLFrameworkFactory.getASLFrameworkAPI();
        Services services = aSLFrameworkAPI.getServices();
        BundleContext bundleContext = services.getBundleContext();
        this.logger = aSLFrameworkAPI.getASLLogger();
        this.systemEventDispatcher = services.getSystemEventDispatcher();
        this.serviceRegister = services.getGenericEvents().getServiceRegister();
        this.configurationManager = services.getConfigurationManagerDiag();
        this.eventFactory = services.getEventFactory();
        this.radioAPI = ASLRadioFactory.getRadioApi();
        this.perfService = (PerfService)this.retrieveServiceFromOsgi(class$de$vw$mib$perf$service$PerfService == null ? (class$de$vw$mib$perf$service$PerfService = DiagnosisServicesImpl.class$("de.vw.mib.perf.service.PerfService")) : class$de$vw$mib$perf$service$PerfService, bundleContext);
        this.cioDictionary = (CioDictionary)this.retrieveServiceFromOsgi(class$de$vw$mib$cio$CioDictionary == null ? (class$de$vw$mib$cio$CioDictionary = DiagnosisServicesImpl.class$("de.vw.mib.cio.CioDictionary")) : class$de$vw$mib$cio$CioDictionary, bundleContext);
        this.cioDispatcher = (CioDispatcher)this.retrieveServiceFromOsgi(class$de$vw$mib$cio$CioDispatcher == null ? (class$de$vw$mib$cio$CioDispatcher = DiagnosisServicesImpl.class$("de.vw.mib.cio.CioDispatcher")) : class$de$vw$mib$cio$CioDispatcher, bundleContext);
    }

    @Override
    public AdaptionApi getAdaptionApi() {
        return this.adaptionApi;
    }

    public void setAdaptionApi(AdaptionApi adaptionApi) {
        this.adaptionApi = adaptionApi;
    }

    @Override
    public ASLRadioAPI getRadioApi() {
        return this.radioAPI;
    }

    @Override
    public SystemEventDispatcher getSystemEventDispatcher() {
        return this.systemEventDispatcher;
    }

    @Override
    public EventFactory getEventFactory() {
        return this.eventFactory;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ServiceRegister getServiceRegister() {
        return this.serviceRegister;
    }

    @Override
    public ConfigurationManagerDiag getConfigurationManager() {
        return this.configurationManager;
    }

    @Override
    public PerfService getPerfService() {
        return this.perfService;
    }

    @Override
    public ASLPersistenceAPI getAslPersistenceApi() {
        if (this.persistenceApi == null) {
            this.persistenceApi = ASLPersistenceFactory.getPersistenceApi();
        }
        return this.persistenceApi;
    }

    @Override
    public EventDispatcherHSM getEventDispatcher() {
        if (this.eventDispatcher == null) {
            this.eventDispatcher = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents().getEventDispatcher();
        }
        return this.eventDispatcher;
    }

    @Override
    public CioDictionary getCioDictionary() {
        return this.cioDictionary;
    }

    @Override
    public CioDispatcher getCioDispatcher() {
        return this.cioDispatcher;
    }

    private Object retrieveServiceFromOsgi(Class clazz, BundleContext bundleContext) {
        ServiceReference serviceReference = bundleContext.getServiceReference(clazz.getName());
        return bundleContext.getService(serviceReference);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

