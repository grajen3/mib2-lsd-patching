/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.amfm.persistence.SatImage;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class SatImageImpl
extends AbstractPersistable
implements SatImage {
    private final PersistenceModule module;
    private int sid;
    private ResourceLocatorPersistence resourceLocator;

    SatImageImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 16;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        if (this.getResourceLocator() != null) {
            this.getResourceLocator().updateRootPersistable(persistable);
        }
    }

    @Override
    public int getSid() {
        return this.sid;
    }

    @Override
    public void setSid(int n) {
        this.sid = n;
        this.markDirty();
    }

    @Override
    public ResourceLocatorPersistence getResourceLocator() {
        return this.resourceLocator;
    }

    @Override
    public void setResourceLocator(ResourceLocatorPersistence resourceLocatorPersistence) {
        this.resourceLocator = resourceLocatorPersistence;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

