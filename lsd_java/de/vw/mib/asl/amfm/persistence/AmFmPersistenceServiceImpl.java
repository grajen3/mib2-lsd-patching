/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationListPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.AmFmPersistenceModule;
import de.vw.mib.asl.amfm.persistence.AmFmPersistenceService;
import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettings;
import de.vw.mib.asl.amfm.persistence.AmFmPresetSettingsImpl;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.amfm.persistence.ComponentPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.DabPersistence;
import de.vw.mib.asl.amfm.persistence.DabPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.DabPresetPersistence;
import de.vw.mib.asl.amfm.persistence.DabPresetPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.DsiAMFMTunerAdapter;
import de.vw.mib.asl.amfm.persistence.DsiDABTunerAdapter;
import de.vw.mib.asl.amfm.persistence.DsiRadioDataAdapter;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistenceImpl;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettings;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettingsImpl;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.SatImage;
import de.vw.mib.asl.amfm.persistence.SatImageImpl;
import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.amfm.persistence.SatPersistenceImpl;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistenceImpl;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistenceImpl;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public class AmFmPersistenceServiceImpl
extends AbstractModulePersistenceService
implements AmFmPersistenceService {
    private static AmFmPersistenceServiceImpl instance;
    private static boolean registeredAdapter;
    private final AmFmPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public AmFmPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new AmFmPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
        this.registerAdapter();
    }

    public static AmFmPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new AmFmPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public RadioAmFmSettings loadRadioAmFmSettings() {
        try {
            return (RadioAmFmSettings)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'RadioAmFmSettings' from module 'AmFm'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'RadioAmFmSettings' from module 'AmFm'", throwable);
        }
        return this.createRadioAmFmSettings();
    }

    @Override
    public AmFmPresetSettings loadAmFmPresetSettings() {
        try {
            return (AmFmPresetSettings)this.persistenceApi.loadPersistable(this.module, 5);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'AmFmPresetSettings' from module 'AmFm'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'AmFmPresetSettings' from module 'AmFm'", throwable);
        }
        return this.createAmFmPresetSettings();
    }

    @Override
    public AmFmFixedStationListPersistence loadAmFmFixedStationListPersistence() {
        try {
            return (AmFmFixedStationListPersistence)this.persistenceApi.loadPersistable(this.module, 6);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'AmFmFixedStationListPersistence' from module 'AmFm'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'AmFmFixedStationListPersistence' from module 'AmFm'", throwable);
        }
        return this.createAmFmFixedStationListPersistence();
    }

    @Override
    public DabPersistence loadDabPersistence() {
        try {
            return (DabPersistence)this.persistenceApi.loadPersistable(this.module, 8);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'DabPersistence' from module 'AmFm'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'DabPersistence' from module 'AmFm'", throwable);
        }
        return this.createDabPersistence();
    }

    @Override
    public SatPersistence loadSatPersistence() {
        try {
            return (SatPersistence)this.persistenceApi.loadPersistable(this.module, 14);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'SatPersistence' from module 'AmFm'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'SatPersistence' from module 'AmFm'", throwable);
        }
        return this.createSatPersistence();
    }

    @Override
    public RadioAmFmSettings createRadioAmFmSettings() {
        return new RadioAmFmSettingsImpl(this.module);
    }

    @Override
    public AmFmStationPersistence createAmFmStationPersistence() {
        return new AmFmStationPersistenceImpl(this.module);
    }

    @Override
    public AmFmPresetPersistence createAmFmPresetPersistence() {
        return new AmFmPresetPersistenceImpl(this.module);
    }

    @Override
    public ResourceLocatorPersistence createResourceLocatorPersistence() {
        return new ResourceLocatorPersistenceImpl(this.module);
    }

    @Override
    public AmFmPresetSettings createAmFmPresetSettings() {
        return new AmFmPresetSettingsImpl(this.module);
    }

    @Override
    public AmFmFixedStationListPersistence createAmFmFixedStationListPersistence() {
        return new AmFmFixedStationListPersistenceImpl(this.module);
    }

    @Override
    public AmFmFixedStationPersistence createAmFmFixedStationPersistence() {
        return new AmFmFixedStationPersistenceImpl(this.module);
    }

    @Override
    public DabPersistence createDabPersistence() {
        return new DabPersistenceImpl(this.module);
    }

    @Override
    public FrequencyPersistence createFrequencyPersistence() {
        return new FrequencyPersistenceImpl(this.module);
    }

    @Override
    public EnsemblePersistence createEnsemblePersistence() {
        return new EnsemblePersistenceImpl(this.module);
    }

    @Override
    public ServicePersistence createServicePersistence() {
        return new ServicePersistenceImpl(this.module);
    }

    @Override
    public ComponentPersistence createComponentPersistence() {
        return new ComponentPersistenceImpl(this.module);
    }

    @Override
    public DabPresetPersistence createDabPresetPersistence() {
        return new DabPresetPersistenceImpl(this.module);
    }

    @Override
    public SatPersistence createSatPersistence() {
        return new SatPersistenceImpl(this.module);
    }

    @Override
    public StationInfoPersistence createStationInfoPersistence() {
        return new StationInfoPersistenceImpl(this.module);
    }

    @Override
    public SatImage createSatImage() {
        return new SatImageImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }

    private void registerAdapter() {
        if (!registeredAdapter) {
            GenericEvents genericEvents = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents();
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.persistenceApi.registerDsiAdapter(this.module, new DsiAMFMTunerAdapter(genericEvents, dSIProxy));
            this.persistenceApi.registerDsiAdapter(this.module, new DsiDABTunerAdapter(genericEvents, dSIProxy));
            this.persistenceApi.registerDsiAdapter(this.module, new DsiRadioDataAdapter(genericEvents, dSIProxy));
            registeredAdapter = true;
        }
    }
}

