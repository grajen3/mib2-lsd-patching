/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.homescreen.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfo;
import de.vw.mib.asl.homescreen.persistence.HomescreenInfoImpl;
import de.vw.mib.asl.homescreen.persistence.HomescreenPersistenceModule;
import de.vw.mib.asl.homescreen.persistence.HomescreenPersistenceService;
import de.vw.mib.asl.homescreen.persistence.TileContent;
import de.vw.mib.asl.homescreen.persistence.TileContentImpl;
import de.vw.mib.log4mib.Logger;

public class HomescreenPersistenceServiceImpl
extends AbstractModulePersistenceService
implements HomescreenPersistenceService {
    private static HomescreenPersistenceServiceImpl instance;
    private final HomescreenPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public HomescreenPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new HomescreenPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static HomescreenPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new HomescreenPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public HomescreenInfo loadHomescreenInfo() {
        try {
            return (HomescreenInfo)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'HomescreenInfo' from module 'Homescreen'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'HomescreenInfo' from module 'Homescreen'", throwable);
        }
        return this.createHomescreenInfo();
    }

    @Override
    public HomescreenInfo createHomescreenInfo() {
        return new HomescreenInfoImpl(this.module);
    }

    @Override
    public TileContent createTileContent() {
        return new TileContentImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

