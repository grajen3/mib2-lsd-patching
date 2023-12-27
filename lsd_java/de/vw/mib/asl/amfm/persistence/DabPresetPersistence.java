/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface DabPresetPersistence
extends Persistable {
    default public ServicePersistence getService() {
    }

    default public void setService(ServicePersistence servicePersistence) {
    }

    default public EnsemblePersistence getEnsemble() {
    }

    default public void setEnsemble(EnsemblePersistence ensemblePersistence) {
    }

    default public FrequencyPersistence getFrequency() {
    }

    default public void setFrequency(FrequencyPersistence frequencyPersistence) {
    }

    default public ResourceLocatorPersistence getStationImage() {
    }

    default public void setStationImage(ResourceLocatorPersistence resourceLocatorPersistence) {
    }

    default public long getDatabaseStationId() {
    }

    default public void setDatabaseStationId(long l) {
    }
}

