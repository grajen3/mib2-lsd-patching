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
import de.vw.mib.asl.instrumentcluster.persistence.SDSSD_ASGCapabilities;

class SDSSD_ASGCapabilitiesImpl
extends AbstractPersistable
implements SDSSD_ASGCapabilities {
    private final PersistenceModule module;
    private int instrumentClusterDisplaySize;

    SDSSD_ASGCapabilitiesImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 2;
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
    public int getInstrumentClusterDisplaySize() {
        return this.instrumentClusterDisplaySize;
    }

    @Override
    public void setInstrumentClusterDisplaySize(int n) {
        this.instrumentClusterDisplaySize = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

