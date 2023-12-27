/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.globalsetupwizard.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptorImpl;

class GlobalSetupWizardPersistableFactory
implements PersistableFactory {
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardPersistableFactory;

    GlobalSetupWizardPersistableFactory(PersistenceModule persistenceModule) {
        if (!$assertionsDisabled && persistenceModule == null) {
            throw new AssertionError();
        }
        this.module = persistenceModule;
    }

    @Override
    public Persistable createPersistable(int n) {
        switch (n) {
            case 1: {
                return new GlobalSetupWizardDescriptorImpl(this.module);
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module GlobalSetupWizard").toString());
    }

    @Override
    public Persistable createPersistableWithDefaults(int n) {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        switch (n) {
            case 1: {
                GlobalSetupWizardDescriptorImpl globalSetupWizardDescriptorImpl = new GlobalSetupWizardDescriptorImpl(this.module);
                handlerFactory.createCommonHandler(globalSetupWizardDescriptorImpl).finish();
                handlerFactory.createUserHandler(globalSetupWizardDescriptorImpl).finish();
                return globalSetupWizardDescriptorImpl;
            }
        }
        throw new PersistenceException(new StringBuffer().append("The persistable ID '").append(n).append("' is unknown in the module GlobalSetupWizard").toString());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardPersistableFactory == null ? (class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardPersistableFactory = GlobalSetupWizardPersistableFactory.class$("de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardPersistableFactory")) : class$de$vw$mib$asl$globalsetupwizard$persistence$GlobalSetupWizardPersistableFactory).desiredAssertionStatus();
    }
}

