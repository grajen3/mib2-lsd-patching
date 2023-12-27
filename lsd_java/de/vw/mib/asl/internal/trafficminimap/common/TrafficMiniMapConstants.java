/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.trafficminimap.common;

import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.global.ResourceLocator;

public interface TrafficMiniMapConstants {
    public static final int TRAFFIC_MINI_MAP_INVALID_VALUE;
    public static final int TRAFFIC_MINI_MAP_DEFAULT_VALUE;
    public static final int TRAFFIC_MINI_MAP_LANGUAGE_SETTING;
    public static final int TRAFFIC_MINI_MAP_PREFECTURE_SETTING;
    public static final int TRAFFIC_MINI_MAP_PROBEDATA_SETTING;
    public static final int TRAFFIC_MINI_MAP_PRIORITY_LOW;
    public static final int TRAFFIC_MINI_MAP_PRIORITY_BELOW_MEDIUM;
    public static final int TRAFFIC_MINI_MAP_PRIORITY_MEDIUM;
    public static final int TRAFFIC_MINI_MAP_PRIORITY_ABOVE_MEDIUM;
    public static final int TRAFFIC_MINI_MAP_PRIORITY_HIGH;
    public static final int TRAFFIC_MINI_MAP_PRIORITY_HIGHEST;
    public static final ResourceInformation EMPTY_RESOURCE_INFORMATION;
    public static final ResourceLocator EMPTY_RESOURCE_LOCATOR;

    static {
        EMPTY_RESOURCE_INFORMATION = new ResourceInformation();
        EMPTY_RESOURCE_LOCATOR = new ResourceLocator();
    }
}

