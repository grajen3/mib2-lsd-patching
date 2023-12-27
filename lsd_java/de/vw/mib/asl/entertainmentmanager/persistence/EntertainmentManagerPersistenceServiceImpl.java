/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.entertainmentmanager.persistence;

import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentManagerPersistenceModule;
import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentManagerPersistenceService;
import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentPersistence;
import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentPersistenceImpl;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;

public class EntertainmentManagerPersistenceServiceImpl
extends AbstractModulePersistenceService
implements EntertainmentManagerPersistenceService {
    private static EntertainmentManagerPersistenceServiceImpl instance;
    private final EntertainmentManagerPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public EntertainmentManagerPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new EntertainmentManagerPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static EntertainmentManagerPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new EntertainmentManagerPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public EntertainmentPersistence loadEntertainmentPersistence() {
        try {
            return (EntertainmentPersistence)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'EntertainmentPersistence' from module 'EntertainmentManager'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'EntertainmentPersistence' from module 'EntertainmentManager'", throwable);
        }
        return this.createEntertainmentPersistence();
    }

    @Override
    public EntertainmentPersistence createEntertainmentPersistence() {
        return new EntertainmentPersistenceImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

