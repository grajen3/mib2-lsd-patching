/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemearly.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.systemearly.persistence.SystemEarly;

class SystemEarlyImpl
extends AbstractPersistable
implements SystemEarly {
    private final PersistenceModule module;
    private boolean lastValueFeatureFlagSdsCoding;
    private boolean lastValueFeatureFlagSdsSwap;

    SystemEarlyImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
    }

    @Override
    public boolean isLastValueFeatureFlagSdsCoding() {
        return this.lastValueFeatureFlagSdsCoding;
    }

    @Override
    public void setLastValueFeatureFlagSdsCoding(boolean bl) {
        this.lastValueFeatureFlagSdsCoding = bl;
        this.markDirty();
    }

    @Override
    public boolean isLastValueFeatureFlagSdsSwap() {
        return this.lastValueFeatureFlagSdsSwap;
    }

    @Override
    public void setLastValueFeatureFlagSdsSwap(boolean bl) {
        this.lastValueFeatureFlagSdsSwap = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

