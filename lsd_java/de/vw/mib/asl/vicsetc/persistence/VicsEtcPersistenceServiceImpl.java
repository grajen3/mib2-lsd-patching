/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.vicsetc.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.vicsetc.persistence.VicsEtc;
import de.vw.mib.asl.vicsetc.persistence.VicsEtcImpl;
import de.vw.mib.asl.vicsetc.persistence.VicsEtcPersistenceModule;
import de.vw.mib.asl.vicsetc.persistence.VicsEtcPersistenceService;
import de.vw.mib.log4mib.Logger;

public class VicsEtcPersistenceServiceImpl
extends AbstractModulePersistenceService
implements VicsEtcPersistenceService {
    private static VicsEtcPersistenceServiceImpl instance;
    private final VicsEtcPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public VicsEtcPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new VicsEtcPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static VicsEtcPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new VicsEtcPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public VicsEtc loadVicsEtc() {
        try {
            return (VicsEtc)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'VicsEtc' from module 'VicsEtc'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'VicsEtc' from module 'VicsEtc'", throwable);
        }
        return this.createVicsEtc();
    }

    @Override
    public VicsEtc createVicsEtc() {
        return new VicsEtcImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

