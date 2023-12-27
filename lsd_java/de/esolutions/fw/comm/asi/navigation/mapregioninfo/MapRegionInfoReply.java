/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;

public interface MapRegionInfoReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void replyGetDatabaseInfo(int n, ComponentInfo componentInfo, int n2) {
    }

    default public void replyGetMultipleDatabaseInfo(int n, ComponentInfo[] componentInfoArray, int n2) {
    }

    default public void replyGetRegionsInVicinity(int n, ComponentInfo[] componentInfoArray, int n2) {
    }
}

