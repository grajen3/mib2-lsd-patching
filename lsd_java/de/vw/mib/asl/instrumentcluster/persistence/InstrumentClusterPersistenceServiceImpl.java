/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.instrumentcluster.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.instrumentcluster.persistence.AudioSD_ASGCapabilities;
import de.vw.mib.asl.instrumentcluster.persistence.AudioSD_ASGCapabilitiesImpl;
import de.vw.mib.asl.instrumentcluster.persistence.InstrumentClusterPersistenceModule;
import de.vw.mib.asl.instrumentcluster.persistence.InstrumentClusterPersistenceService;
import de.vw.mib.asl.instrumentcluster.persistence.SDSSD_ASGCapabilities;
import de.vw.mib.asl.instrumentcluster.persistence.SDSSD_ASGCapabilitiesImpl;
import de.vw.mib.log4mib.Logger;

public class InstrumentClusterPersistenceServiceImpl
extends AbstractModulePersistenceService
implements InstrumentClusterPersistenceService {
    private static InstrumentClusterPersistenceServiceImpl instance;
    private final InstrumentClusterPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public InstrumentClusterPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new InstrumentClusterPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static InstrumentClusterPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new InstrumentClusterPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public AudioSD_ASGCapabilities loadAudioSD_ASGCapabilities() {
        try {
            return (AudioSD_ASGCapabilities)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'AudioSD_ASGCapabilities' from module 'InstrumentCluster'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'AudioSD_ASGCapabilities' from module 'InstrumentCluster'", throwable);
        }
        return this.createAudioSD_ASGCapabilities();
    }

    @Override
    public SDSSD_ASGCapabilities loadSDSSD_ASGCapabilities() {
        try {
            return (SDSSD_ASGCapabilities)this.persistenceApi.loadPersistable(this.module, 2);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'SDSSD_ASGCapabilities' from module 'InstrumentCluster'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'SDSSD_ASGCapabilities' from module 'InstrumentCluster'", throwable);
        }
        return this.createSDSSD_ASGCapabilities();
    }

    @Override
    public AudioSD_ASGCapabilities createAudioSD_ASGCapabilities() {
        return new AudioSD_ASGCapabilitiesImpl(this.module);
    }

    @Override
    public SDSSD_ASGCapabilities createSDSSD_ASGCapabilities() {
        return new SDSSD_ASGCapabilitiesImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

