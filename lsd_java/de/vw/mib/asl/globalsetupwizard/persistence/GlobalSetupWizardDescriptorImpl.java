/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.globalsetupwizard.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.collections.maps.PersistenceHashMap;
import de.vw.mib.asl.globalsetupwizard.persistence.GlobalSetupWizardDescriptor;
import java.util.Map;

class GlobalSetupWizardDescriptorImpl
extends AbstractPersistable
implements GlobalSetupWizardDescriptor {
    private final PersistenceModule module;
    private final PersistenceHashMap mapWizardPages = new PersistenceHashMap();
    private boolean dontShowAgain;

    GlobalSetupWizardDescriptorImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        this.mapWizardPages.setRootPersistable(persistable);
    }

    @Override
    public Map getMapWizardPages() {
        return this.mapWizardPages;
    }

    @Override
    public boolean isDontShowAgain() {
        return this.dontShowAgain;
    }

    @Override
    public void setDontShowAgain(boolean bl) {
        this.dontShowAgain = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

