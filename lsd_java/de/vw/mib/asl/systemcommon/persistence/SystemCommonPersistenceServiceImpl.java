/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;
import de.vw.mib.asl.systemcommon.persistence.AbtFeaturesImpl;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonImpl;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceModule;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;
import de.vw.mib.asl.systemcommon.persistence.Units;
import de.vw.mib.asl.systemcommon.persistence.UnitsImpl;
import de.vw.mib.log4mib.Logger;

public class SystemCommonPersistenceServiceImpl
extends AbstractModulePersistenceService
implements SystemCommonPersistenceService {
    private static SystemCommonPersistenceServiceImpl instance;
    private final SystemCommonPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public SystemCommonPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new SystemCommonPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static SystemCommonPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new SystemCommonPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public SystemCommon loadSystemCommon() {
        try {
            return (SystemCommon)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'SystemCommon' from module 'SystemCommon'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'SystemCommon' from module 'SystemCommon'", throwable);
        }
        return this.createSystemCommon();
    }

    @Override
    public Units loadUnits() {
        try {
            return (Units)this.persistenceApi.loadPersistable(this.module, 3);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'Units' from module 'SystemCommon'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'Units' from module 'SystemCommon'", throwable);
        }
        return this.createUnits();
    }

    @Override
    public AbtFeatures loadAbtFeatures() {
        try {
            return (AbtFeatures)this.persistenceApi.loadPersistable(this.module, 2);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'AbtFeatures' from module 'SystemCommon'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'AbtFeatures' from module 'SystemCommon'", throwable);
        }
        return this.createAbtFeatures();
    }

    @Override
    public SystemCommon createSystemCommon() {
        return new SystemCommonImpl(this.module);
    }

    @Override
    public Units createUnits() {
        return new UnitsImpl(this.module);
    }

    @Override
    public AbtFeatures createAbtFeatures() {
        return new AbtFeaturesImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

