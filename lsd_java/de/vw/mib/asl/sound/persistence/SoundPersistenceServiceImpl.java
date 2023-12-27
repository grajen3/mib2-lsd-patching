/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.sound.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.sound.persistence.DsiSoundAdapter;
import de.vw.mib.asl.sound.persistence.SoundPersistenceModule;
import de.vw.mib.asl.sound.persistence.SoundPersistenceService;
import de.vw.mib.asl.sound.persistence.SoundSettings;
import de.vw.mib.asl.sound.persistence.SoundSettingsImpl;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;

public class SoundPersistenceServiceImpl
extends AbstractModulePersistenceService
implements SoundPersistenceService {
    private static SoundPersistenceServiceImpl instance;
    private static boolean registeredAdapter;
    private final SoundPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public SoundPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new SoundPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
        this.registerAdapter();
    }

    public static SoundPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new SoundPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public SoundSettings loadSoundSettings() {
        try {
            return (SoundSettings)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'SoundSettings' from module 'Sound'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'SoundSettings' from module 'Sound'", throwable);
        }
        return this.createSoundSettings();
    }

    @Override
    public SoundSettings createSoundSettings() {
        return new SoundSettingsImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }

    private void registerAdapter() {
        if (!registeredAdapter) {
            GenericEvents genericEvents = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getGenericEvents();
            DSIProxy dSIProxy = DSIProxyFactory.getDSIProxyAPI().getDSIProxy();
            this.persistenceApi.registerDsiAdapter(this.module, new DsiSoundAdapter(genericEvents, dSIProxy));
            registeredAdapter = true;
        }
    }
}

