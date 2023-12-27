/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemearly.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemearly.persistence.SystemEarly;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyImpl;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyPersistenceModule;
import de.vw.mib.asl.systemearly.persistence.SystemEarlyPersistenceService;
import de.vw.mib.log4mib.Logger;

public class SystemEarlyPersistenceServiceImpl
extends AbstractModulePersistenceService
implements SystemEarlyPersistenceService {
    private static SystemEarlyPersistenceServiceImpl instance;
    private final SystemEarlyPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public SystemEarlyPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new SystemEarlyPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static SystemEarlyPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new SystemEarlyPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public SystemEarly loadSystemEarly() {
        try {
            return (SystemEarly)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'SystemEarly' from module 'SystemEarly'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'SystemEarly' from module 'SystemEarly'", throwable);
        }
        return this.createSystemEarly();
    }

    @Override
    public SystemEarly createSystemEarly() {
        return new SystemEarlyImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

