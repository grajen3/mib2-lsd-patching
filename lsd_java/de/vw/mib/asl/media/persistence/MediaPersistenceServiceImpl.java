/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.media.persistence.DsiMediaBaseAdapter;
import de.vw.mib.asl.media.persistence.MediaPersistenceModule;
import de.vw.mib.asl.media.persistence.MediaPersistenceService;
import de.vw.mib.asl.media.persistence.PersistedListEntry;
import de.vw.mib.asl.media.persistence.PersistedListEntryImpl;
import de.vw.mib.asl.media.persistence.PersistedSelection;
import de.vw.mib.asl.media.persistence.PersistedSelectionImpl;
import de.vw.mib.asl.media.persistence.PlayerPersistence;
import de.vw.mib.asl.media.persistence.PlayerPersistenceImpl;
import de.vw.mib.asl.media.persistence.SourcesPersistence;
import de.vw.mib.asl.media.persistence.SourcesPersistenceImpl;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public class MediaPersistenceServiceImpl
extends AbstractModulePersistenceService
implements MediaPersistenceService {
    private static MediaPersistenceServiceImpl instance;
    private static boolean registeredAdapter;
    private final MediaPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public MediaPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new MediaPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
        this.registerAdapter();
    }

    public static MediaPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new MediaPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public SourcesPersistence loadSourcesPersistence() {
        try {
            return (SourcesPersistence)this.persistenceApi.loadPersistable(this.module, 6);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'SourcesPersistence' from module 'Media'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'SourcesPersistence' from module 'Media'", throwable);
        }
        return this.createSourcesPersistence();
    }

    @Override
    public PlayerPersistence loadPlayerPersistence() {
        try {
            return (PlayerPersistence)this.persistenceApi.loadPersistable(this.module, 7);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'PlayerPersistence' from module 'Media'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'PlayerPersistence' from module 'Media'", throwable);
        }
        return this.createPlayerPersistence();
    }

    @Override
    public SourcesPersistence createSourcesPersistence() {
        return new SourcesPersistenceImpl(this.module);
    }

    @Override
    public PlayerPersistence createPlayerPersistence() {
        return new PlayerPersistenceImpl(this.module);
    }

    @Override
    public PersistedSelection createPersistedSelection() {
        return new PersistedSelectionImpl(this.module);
    }

    @Override
    public PersistedListEntry createPersistedListEntry() {
        return new PersistedListEntryImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }

    private void registerAdapter() {
        if (!registeredAdapter) {
            GenericEvents genericEvents = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents();
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.persistenceApi.registerDsiAdapter(this.module, new DsiMediaBaseAdapter(genericEvents, dSIProxy));
            registeredAdapter = true;
        }
    }
}

