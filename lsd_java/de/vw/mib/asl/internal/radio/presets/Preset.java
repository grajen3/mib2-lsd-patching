/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.presets;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.global.ResourceLocator;

public class Preset {
    protected ResourceLocator stationImage = null;
    protected long databaseStationId;
    public static final int INVALID_PRESET_INDEX;
    public static final int INVALID_BANK_INDEX;
    public static final int INVALID_PRESET_INDEX_TO_MODEL;
    public boolean logoDeletedIntentionallyForNar = false;

    public void setLogoDeletedIntentionallyForNar(boolean bl) {
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
            this.logoDeletedIntentionallyForNar = bl;
        }
    }

    public boolean isLogoDeletedIntentionallyForNar() {
        return this.logoDeletedIntentionallyForNar;
    }

    public long getDatabaseStationId() {
        return this.databaseStationId;
    }

    public void setDatabaseStationId(long l) {
        this.databaseStationId = l;
    }

    public ResourceLocator getImage() {
        return this.stationImage;
    }

    public void deleteDatabaseStationId() {
        this.setDatabaseStationId(-1L);
    }
}

