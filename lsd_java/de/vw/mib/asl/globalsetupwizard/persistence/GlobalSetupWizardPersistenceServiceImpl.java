/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.globalsetupwizard.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.AbstractModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptor;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptorImpl;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardPersistenceModule;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardPersistenceService;
import de.vw.mib.log4mib.Logger;

public class GlobalSetupWizardPersistenceServiceImpl
extends AbstractModulePersistenceService
implements GlobalSetupWizardPersistenceService {
    private static GlobalSetupWizardPersistenceServiceImpl instance;
    private final GlobalSetupWizardPersistenceModule module;
    private final AslPersistenceSyncApi persistenceApi;
    private final Logger logger = ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();

    public GlobalSetupWizardPersistenceServiceImpl() {
        super(ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi());
        this.module = new GlobalSetupWizardPersistenceModule(this.logger);
        this.persistenceApi = ASLPersistenceFactory.getPersistenceApi().getPersistenceSyncApi();
    }

    public static GlobalSetupWizardPersistenceServiceImpl getInstance() {
        if (instance == null) {
            instance = new GlobalSetupWizardPersistenceServiceImpl();
        }
        return instance;
    }

    @Override
    public GlobalSetupWizardDescriptor loadGlobalSetupWizardDescriptor() {
        try {
            return (GlobalSetupWizardDescriptor)this.persistenceApi.loadPersistable(this.module, 1);
        }
        catch (ClassCastException classCastException) {
            this.logger.error(32, "Persistence Service returned wrong instance when loading persistenabe 'GlobalSetupWizardDescriptor' from module 'GlobalSetupWizard'. This is probably caused by a invalid 'persistenceIds.res' file.", classCastException);
        }
        catch (Throwable throwable) {
            this.logger.error(32, "Error while loading persistable 'GlobalSetupWizardDescriptor' from module 'GlobalSetupWizard'", throwable);
        }
        return this.createGlobalSetupWizardDescriptor();
    }

    @Override
    public GlobalSetupWizardDescriptor createGlobalSetupWizardDescriptor() {
        return new GlobalSetupWizardDescriptorImpl(this.module);
    }

    @Override
    protected PersistenceModule getPersistenceModule() {
        return this.module;
    }
}

