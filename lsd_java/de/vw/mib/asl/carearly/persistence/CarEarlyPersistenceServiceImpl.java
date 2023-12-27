/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.carearly.persistence;

import de.vw.mib.asl.carearly.persistence.CarEarly;
import de.vw.mib.asl.carearly.persistence.CarEarlyImpl;
import de.vw.mib.asl.carearly.persistence.CarEarlyPersistenceModule;
import de.vw.mib.asl.carearly.persistence.CarEarlyPersistenceService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;

public class CarEarlyPersistenceServiceImpl
extends AbstractModulePersistenceService
implements CarEarlyPersistenceService {
    private static CarEarlyPersistenceServiceImpl instance;
    private final CarEarlyPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public CarEarlyPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new CarEarlyPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static CarEarlyPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new CarEarlyPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public CarEarly loadCarEarly() {
        try {
            return (CarEarly)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'CarEarly' from module 'CarEarly'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'CarEarly' from module 'CarEarly'", throwable);
        }
        return this.createCarEarly();
    }

    @Override
    public CarEarly createCarEarly() {
        return new CarEarlyImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

