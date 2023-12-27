/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.picturestore.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.picturestore.persistence.PictureStore;
import de.vw.mib.asl.picturestore.persistence.PictureStoreImpl;
import de.vw.mib.asl.picturestore.persistence.PictureStorePersistenceModule;
import de.vw.mib.asl.picturestore.persistence.PictureStorePersistenceService;
import de.vw.mib.asl.picturestore.persistence.StoredPicture;
import de.vw.mib.asl.picturestore.persistence.StoredPictureImpl;
import de.vw.mib.log4mib.Logger;

public class PictureStorePersistenceServiceImpl
extends AbstractModulePersistenceService
implements PictureStorePersistenceService {
    private static PictureStorePersistenceServiceImpl instance;
    private final PictureStorePersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public PictureStorePersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new PictureStorePersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static PictureStorePersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new PictureStorePersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public PictureStore loadPictureStore() {
        try {
            return (PictureStore)this.persistenceApi.loadPersistable(this.module, 2);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'PictureStore' from module 'PictureStore'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'PictureStore' from module 'PictureStore'", throwable);
        }
        return this.createPictureStore();
    }

    @Override
    public StoredPicture createStoredPicture() {
        return new StoredPictureImpl(this.module);
    }

    @Override
    public PictureStore createPictureStore() {
        return new PictureStoreImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

