/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.speech.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.speech.persistence.SpeechPersistenceModule;
import de.vw.mib.asl.speech.persistence.SpeechPersistenceService;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistable;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistableImpl;
import de.vw.mib.log4mib.Logger;

public class SpeechPersistenceServiceImpl
extends AbstractModulePersistenceService
implements SpeechPersistenceService {
    private static SpeechPersistenceServiceImpl instance;
    private final SpeechPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public SpeechPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new SpeechPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static SpeechPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new SpeechPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public SpeechSettingsPersistable loadSpeechSettingsPersistable() {
        try {
            return (SpeechSettingsPersistable)this.persistenceApi.loadPersistable(this.module, 2);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'SpeechSettingsPersistable' from module 'Speech'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'SpeechSettingsPersistable' from module 'Speech'", throwable);
        }
        return this.createSpeechSettingsPersistable();
    }

    @Override
    public SpeechSettingsPersistable createSpeechSettingsPersistable() {
        return new SpeechSettingsPersistableImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

