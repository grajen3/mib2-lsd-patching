/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.util.LocationWrapper;
import org.dsi.ifc.global.NavLocation;

public final class LocationHelper {
    private LocationHelper() {
    }

    public static NavLocation cloneLocation(NavLocation navLocation) {
        if (navLocation != null) {
            return new LocationWrapper(navLocation).getLocation();
        }
        ServiceManager.logger.error(16384, "LocationHelper.cloneLocation(null) called!");
        return null;
    }
}

