/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.hknav;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.gateway.INavGateway;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;

public class MapViewerHKNavDatapool {
    private final INavGateway navGateway = ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway();
    private final MapDataPool dataPoolMainMap = DSIMapViewerControlFactoryVW.getMapDatapoolMain();

    public boolean isFeatureShowEnhancedCityModelAllViewtypes() {
        return this.dataPoolMainMap.isFeatureShowEnhancedCityModelAllViewtypes();
    }

    public boolean isRgActive() {
        return this.navGateway.isRgActiveValid();
    }
}

