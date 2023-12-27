/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class StationInfoPersistenceImpl
extends AbstractPersistable
implements StationInfoPersistence {
    private final PersistenceModule module;
    private int categoryNumber;
    private int subscription;
    private int sid;
    private int stationNumber;
    private String shortLabel;
    private String fullLabel;
    private boolean mature;

    StationInfoPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 15;
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
    public int getCategoryNumber() {
        return this.categoryNumber;
    }

    @Override
    public void setCategoryNumber(int n) {
        this.categoryNumber = n;
        this.markDirty();
    }

    @Override
    public int getSubscription() {
        return this.subscription;
    }

    @Override
    public void setSubscription(int n) {
        this.subscription = n;
        this.markDirty();
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
    public int getStationNumber() {
        return this.stationNumber;
    }

    @Override
    public void setStationNumber(int n) {
        this.stationNumber = n;
        this.markDirty();
    }

    @Override
    public String getShortLabel() {
        return this.shortLabel;
    }

    @Override
    public void setShortLabel(String string) {
        this.shortLabel = string;
        this.markDirty();
    }

    @Override
    public String getFullLabel() {
        return this.fullLabel;
    }

    @Override
    public void setFullLabel(String string) {
        this.fullLabel = string;
        this.markDirty();
    }

    @Override
    public boolean isMature() {
        return this.mature;
    }

    @Override
    public void setMature(boolean bl) {
        this.mature = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

