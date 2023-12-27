/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.globalsetupwizard.persistence;

import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializerFactory;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardHandlerFactory;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardPersistableFactory;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardSerializerFactory;
import de.vw.mib.log4mib.Logger;

class GlobalSetupWizardPersistenceModule
implements PersistenceModule {
    private final HandlerFactory handlerFactory;
    private final PersistableFactory persistableFactory;
    private final PersistableSerializerFactory serializerFactory;

    GlobalSetupWizardPersistenceModule(Logger logger) {
        this.handlerFactory = new GlobalSetupWizardHandlerFactory(logger, this);
        this.persistableFactory = new GlobalSetupWizardPersistableFactory(this);
        this.serializerFactory = new GlobalSetupWizardSerializerFactory();
    }

    @Override
    public String getName() {
        return "GlobalSetupWizard";
    }

    @Override
    public long getVersion() {
        return 0L;
    }

    @Override
    public HandlerFactory getHandlerFactory() {
        return this.handlerFactory;
    }

    @Override
    public PersistableFactory getPersistableFactory() {
        return this.persistableFactory;
    }

    @Override
    public PersistableSerializerFactory getSerializerFactory() {
        return this.serializerFactory;
    }

    @Override
    public boolean isUserSpecific() {
        return true;
    }

    @Override
    public byte[] getDeclaration() {
        return new byte[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 2, 22, 5, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2};
    }
}

