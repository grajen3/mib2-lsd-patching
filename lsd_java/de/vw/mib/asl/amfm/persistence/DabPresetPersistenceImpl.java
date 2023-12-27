/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.DabPresetPersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class DabPresetPersistenceImpl
extends AbstractPersistable
implements DabPresetPersistence {
    private final PersistenceModule module;
    private ServicePersistence service;
    private EnsemblePersistence ensemble;
    private FrequencyPersistence frequency;
    private ResourceLocatorPersistence stationImage;
    private long databaseStationId;

    DabPresetPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 13;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        if (this.getService() != null) {
            this.getService().updateRootPersistable(persistable);
        }
        if (this.getEnsemble() != null) {
            this.getEnsemble().updateRootPersistable(persistable);
        }
        if (this.getFrequency() != null) {
            this.getFrequency().updateRootPersistable(persistable);
        }
        if (this.getStationImage() != null) {
            this.getStationImage().updateRootPersistable(persistable);
        }
    }

    @Override
    public ServicePersistence getService() {
        return this.service;
    }

    @Override
    public void setService(ServicePersistence servicePersistence) {
        this.service = servicePersistence;
        this.markDirty();
    }

    @Override
    public EnsemblePersistence getEnsemble() {
        return this.ensemble;
    }

    @Override
    public void setEnsemble(EnsemblePersistence ensemblePersistence) {
        this.ensemble = ensemblePersistence;
        this.markDirty();
    }

    @Override
    public FrequencyPersistence getFrequency() {
        return this.frequency;
    }

    @Override
    public void setFrequency(FrequencyPersistence frequencyPersistence) {
        this.frequency = frequencyPersistence;
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

