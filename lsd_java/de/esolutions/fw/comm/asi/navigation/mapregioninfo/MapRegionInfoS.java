/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoReply;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;

public interface MapRegionInfoS {
    default public void requestGetDatabaseInfo(NavLocationWgs84 navLocationWgs84, int n, MapRegionInfoReply mapRegionInfoReply) {
    }

    default public void requestGetMultipleDatabaseInfo(NavLocationWgs84[] navLocationWgs84Array, int n, MapRegionInfoReply mapRegionInfoReply) {
    }

    default public void requestGetRegionsInVicinity(NavRectangle navRectangle, int n, MapRegionInfoReply mapRegionInfoReply) {
    }
}

