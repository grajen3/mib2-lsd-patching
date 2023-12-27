/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmPresetPersistence;
import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class AmFmPresetPersistenceImpl
extends AbstractPersistable
implements AmFmPresetPersistence {
    private final PersistenceModule module;
    private AmFmStationPersistence amFmStation;
    private boolean manualAsssignedLogo;
    private boolean logoDeletedIntentionallyForNar;
    private ResourceLocatorPersistence stationImage;
    private int autoStoredLogoState;
    private int stationLogoType;
    private long databaseStationId;

    AmFmPresetPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        if (this.getAmFmStation() != null) {
            this.getAmFmStation().updateRootPersistable(persistable);
        }
        if (this.getStationImage() != null) {
            this.getStationImage().updateRootPersistable(persistable);
        }
    }

    @Override
    public AmFmStationPersistence getAmFmStation() {
        return this.amFmStation;
    }

    @Override
    public void setAmFmStation(AmFmStationPersistence amFmStationPersistence) {
        this.amFmStation = amFmStationPersistence;
        this.markDirty();
    }

    @Override
    public boolean isManualAsssignedLogo() {
        return this.manualAsssignedLogo;
    }

    @Override
    public void setManualAsssignedLogo(boolean bl) {
        this.manualAsssignedLogo = bl;
        this.markDirty();
    }

    @Override
    public boolean isLogoDeletedIntentionallyForNar() {
        return this.logoDeletedIntentionallyForNar;
    }

    @Override
    public void setLogoDeletedIntentionallyForNar(boolean bl) {
        this.logoDeletedIntentionallyForNar = bl;
        this.markDirty();
    }

    @Override
    public ResourceLocatorPersistence getStationImage() {
        return this.stationImage;
    }

    @Override
    public void setStationImage(ResourceLocatorPersistence resourceLocatorPersistence) {
        this.stationImage = resourceLocatorPersistence;
        this.markDirty();
    }

    @Override
    public int getAutoStoredLogoState() {
        return this.autoStoredLogoState;
    }

    @Override
    public void setAutoStoredLogoState(int n) {
        this.autoStoredLogoState = n;
        this.markDirty();
    }

    @Override
    public int getStationLogoType() {
        return this.stationLogoType;
    }

    @Override
    public void setStationLogoType(int n) {
        this.stationLogoType = n;
        this.markDirty();
    }

    @Override
    public long getDatabaseStationId() {
        return this.databaseStationId;
    }

    @Override
    public void setDatabaseStationId(long l) {
        this.databaseStationId = l;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

