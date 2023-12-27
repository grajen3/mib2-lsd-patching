/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.instrumentcluster.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.instrumentcluster.persistence.AudioSD_ASGCapabilities;

class AudioSD_ASGCapabilitiesImpl
extends AbstractPersistable
implements AudioSD_ASGCapabilities {
    private final PersistenceModule module;
    private boolean useDABLongLabel;
    private boolean useSDARSLongLabel;

    AudioSD_ASGCapabilitiesImpl(PersistenceModule persistenceModule) {
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
    public boolean isUseDABLongLabel() {
        return this.useDABLongLabel;
    }

    @Override
    public void setUseDABLongLabel(boolean bl) {
        this.useDABLongLabel = bl;
        this.markDirty();
    }

    @Override
    public boolean isUseSDARSLongLabel() {
        return this.useSDARSLongLabel;
    }

    @Override
    public void setUseSDARSLongLabel(boolean bl) {
        this.useSDARSLongLabel = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

