/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.google.earth;

import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;

public class GoogleEarthSetupDatapool {
    private final MapDataPool mapDataPool;
    private final PersistedMapSetup persistedMapSetup = PersistedMapSetup.getInstance();

    public GoogleEarthSetupDatapool() {
        this.mapDataPool = DSIMapViewerControlFactoryVW.getMapDatapoolMain();
    }

    public int[] getGoogleEarthVisibleLayer() {
        return this.persistedMapSetup.getGoogleEarthVisibleLayer();
    }

    public int getMapMode() {
        return this.mapDataPool.getMapMode();
    }

    public void setGoogleEarthVisibleLayer(int[] nArray) {
        this.persistedMapSetup.setGoogleEarthVisibleLayer(nArray);
    }
}

