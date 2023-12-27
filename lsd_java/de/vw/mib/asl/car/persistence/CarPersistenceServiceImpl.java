/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.Car;
import de.vw.mib.asl.car.persistence.CarImpl;
import de.vw.mib.asl.car.persistence.CarOffroad;
import de.vw.mib.asl.car.persistence.CarOffroadImpl;
import de.vw.mib.asl.car.persistence.CarPersistenceModule;
import de.vw.mib.asl.car.persistence.CarPersistenceService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;

public class CarPersistenceServiceImpl
extends AbstractModulePersistenceService
implements CarPersistenceService {
    private static CarPersistenceServiceImpl instance;
    private final CarPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public CarPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new CarPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static CarPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new CarPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public Car loadCar() {
        try {
            return (Car)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'Car' from module 'Car'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'Car' from module 'Car'", throwable);
        }
        return this.createCar();
    }

    @Override
    public Car createCar() {
        return new CarImpl(this.module);
    }

    @Override
    public CarOffroad createCarOffroad() {
        return new CarOffroadImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

