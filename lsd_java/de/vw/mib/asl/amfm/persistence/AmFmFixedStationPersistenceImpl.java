/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class AmFmFixedStationPersistenceImpl
extends AbstractPersistable
implements AmFmFixedStationPersistence {
    private final PersistenceModule module;
    private int frequency;
    private int pi;
    private String name;
    private String shortName;
    private int subChannel;
    private short ratingCounter;

    AmFmFixedStationPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 7;
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
    public int getFrequency() {
        return this.frequency;
    }

    @Override
    public void setFrequency(int n) {
        this.frequency = n;
        this.markDirty();
    }

    @Override
    public int getPi() {
        return this.pi;
    }

    @Override
    public void setPi(int n) {
        this.pi = n;
        this.markDirty();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String string) {
        this.name = string;
        this.markDirty();
    }

    @Override
    public String getShortName() {
        return this.shortName;
    }

    @Override
    public void setShortName(String string) {
        this.shortName = string;
        this.markDirty();
    }

    @Override
    public int getSubChannel() {
        return this.subChannel;
    }

    @Override
    public void setSubChannel(int n) {
        this.subChannel = n;
        this.markDirty();
    }

    @Override
    public short getRatingCounter() {
        return this.ratingCounter;
    }

    @Override
    public void setRatingCounter(short s) {
        this.ratingCounter = s;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

