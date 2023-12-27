/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.exboxkorea.persistence;

import de.vw.mib.asl.exboxkorea.persistence.ExboxKorea;
import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaImpl;
import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaPersistenceModule;
import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaPersistenceService;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;

public class ExboxKoreaPersistenceServiceImpl
extends AbstractModulePersistenceService
implements ExboxKoreaPersistenceService {
    private static ExboxKoreaPersistenceServiceImpl instance;
    private final ExboxKoreaPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public ExboxKoreaPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new ExboxKoreaPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static ExboxKoreaPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new ExboxKoreaPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public ExboxKorea loadExboxKorea() {
        try {
            return (ExboxKorea)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'ExboxKorea' from module 'ExboxKorea'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'ExboxKorea' from module 'ExboxKorea'", throwable);
        }
        return this.createExboxKorea();
    }

    @Override
    public ExboxKorea createExboxKorea() {
        return new ExboxKoreaImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

