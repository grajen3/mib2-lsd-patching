/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license;

import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;

public class GoogleEarthLicenseDatapool {
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();
    private final MapViewerDatapoolShared mapViewerDatapoolShared = MapViewerDatapoolShared.getInstance();
    private boolean googleEarthNotAvailableAfterdisabling;

    public int getMainMapMapTypeLast() {
        return this.persistedMapSetup.getMainMapMapTypeLast();
    }

    public boolean isConnectionStateAllow() {
        return this.mapViewerDatapoolShared.isConnectionStateAllow();
    }

    public void setConnectionStateAllow(boolean bl) {
        this.mapViewerDatapoolShared.setConnectionStateAllow(bl);
    }

    public void setMainMapLastMapType(int n) {
        this.persistedMapSetup.setMainMapLastMapType(n);
    }

    public void setGoogleEarthNotAvailableAfterDisabling(boolean bl) {
        this.googleEarthNotAvailableAfterdisabling = bl;
    }

    public boolean isGoogleEarthNotAvailableAfterdisabling() {
        return this.googleEarthNotAvailableAfterdisabling;
    }
}

