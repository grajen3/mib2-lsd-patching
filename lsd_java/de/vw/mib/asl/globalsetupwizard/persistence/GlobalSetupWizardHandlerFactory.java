/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.globalsetupwizard.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptor;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptorHandler;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptorUserHandler;
import de.vw.mib.log4mib.Logger;

class GlobalSetupWizardHandlerFactory
implements HandlerFactory {
    private final Logger logger;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardHandlerFactory;

    GlobalSetupWizardHandlerFactory(Logger logger, PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && logger == null) {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.logger = logger;
        this.module = persistenceModule;
    }

    @Override
    public PersistenceDataHandler createCommonHandler(Persistable persistable) {
        if (persistable == null) {
            throw new IllegalArgumentException("Cannot create PersistenceDataHandler for null persistable.");
        }
        switch (persistable.getId()) {
            case 1: {
                return new GlobalSetupWizardDescriptorHandler((GlobalSetupWizardDescriptor)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'GlobalSetupWizard'").toString());
    }

    @Override
    public PersistenceDataHandler createUserHandler(Persistable persistable) {
        if (persistable == null) {
            throw new IllegalArgumentException("Cannot create PersistenceDataHandler for null persistable.");
        }
        switch (persistable.getId()) {
            case 1: {
                return new GlobalSetupWizardDescriptorUserHandler((GlobalSetupWizardDescriptor)persistable, this.logger, this.module);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("The persistable with id '").append(persistable.getId()).append("' is unknown for the persistence module 'GlobalSetupWizard'").toString());
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardHandlerFactory == null ? (class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardHandlerFactory = GlobalSetupWizardHandlerFactory.class$("de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardHandlerFactory")) : class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardHandlerFactory).desiredAssertionStatus();
    }
}

