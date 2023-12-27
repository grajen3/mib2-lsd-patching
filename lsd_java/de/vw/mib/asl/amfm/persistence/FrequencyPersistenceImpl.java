/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class FrequencyPersistenceImpl
extends AbstractPersistable
implements FrequencyPersistence {
    private final PersistenceModule module;
    private long frequency;
    private String label;

    FrequencyPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 9;
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
    public long getFrequency() {
        return this.frequency;
    }

    @Override
    public void setFrequency(long l) {
        this.frequency = l;
        this.markDirty();
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public void setLabel(String string) {
        this.label = string;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

