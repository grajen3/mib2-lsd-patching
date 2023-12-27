/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface AmFmPresetPersistence
extends Persistable {
    default public AmFmStationPersistence getAmFmStation() {
    }

    default public void setAmFmStation(AmFmStationPersistence amFmStationPersistence) {
    }

    default public boolean isManualAsssignedLogo() {
    }

    default public void setManualAsssignedLogo(boolean bl) {
    }

    default public boolean isLogoDeletedIntentionallyForNar() {
    }

    default public void setLogoDeletedIntentionallyForNar(boolean bl) {
    }

    default public ResourceLocatorPersistence getStationImage() {
    }

    default public void setStationImage(ResourceLocatorPersistence resourceLocatorPersistence) {
    }

    default public int getAutoStoredLogoState() {
    }

    default public void setAutoStoredLogoState(int n) {
    }

    default public int getStationLogoType() {
    }

    default public void setStationLogoType(int n) {
    }

    default public long getDatabaseStationId() {
    }

    default public void setDatabaseStationId(long l) {
    }
}

