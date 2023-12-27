/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.gridmenu.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.gridmenu.persistence.GridMenu;
import de.vw.mib.asl.gridmenu.persistence.GridMenuImpl;
import de.vw.mib.asl.gridmenu.persistence.GridMenuPersistenceModule;
import de.vw.mib.asl.gridmenu.persistence.GridMenuPersistenceService;
import de.vw.mib.log4mib.Logger;

public class GridMenuPersistenceServiceImpl
extends AbstractModulePersistenceService
implements GridMenuPersistenceService {
    private static GridMenuPersistenceServiceImpl instance;
    private final GridMenuPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public GridMenuPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new GridMenuPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static GridMenuPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new GridMenuPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public GridMenu loadGridMenu() {
        try {
            return (GridMenu)this.persistenceApi.loadPersistable(this.module, 2);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'GridMenu' from module 'GridMenu'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'GridMenu' from module 'GridMenu'", throwable);
        }
        return this.createGridMenu();
    }

    @Override
    public GridMenu createGridMenu() {
        return new GridMenuImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

