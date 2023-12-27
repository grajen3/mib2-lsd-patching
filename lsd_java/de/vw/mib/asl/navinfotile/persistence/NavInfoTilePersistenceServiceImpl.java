/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navinfotile.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTile;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTileImpl;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTilePersistenceModule;
import de.vw.mib.asl.navinfotile.persistence.NavInfoTilePersistenceService;
import de.vw.mib.log4mib.Logger;

public class NavInfoTilePersistenceServiceImpl
extends AbstractModulePersistenceService
implements NavInfoTilePersistenceService {
    private static NavInfoTilePersistenceServiceImpl instance;
    private final NavInfoTilePersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public NavInfoTilePersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new NavInfoTilePersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static NavInfoTilePersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new NavInfoTilePersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public NavInfoTile loadNavInfoTile() {
        try {
            return (NavInfoTile)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'NavInfoTile' from module 'NavInfoTile'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'NavInfoTile' from module 'NavInfoTile'", throwable);
        }
        return this.createNavInfoTile();
    }

    @Override
    public NavInfoTile createNavInfoTile() {
        return new NavInfoTileImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

