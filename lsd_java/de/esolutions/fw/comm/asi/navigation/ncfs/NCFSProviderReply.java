/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sEdge;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLGIEvent;
import de.esolutions.fw.comm.asi.navigation.ncfs.sRestriction;
import de.esolutions.fw.comm.asi.navigation.ncfs.sTileInfo;

public interface NCFSProviderReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateVZOTileIndexes(int[] nArray, sBoundingBox sBoundingBox2, int n) {
    }

    default public void updateVZORestrictions(sTileInfo[] sTileInfoArray, sEdge[] sEdgeArray, sRestriction[] sRestrictionArray, int n) {
    }

    default public void updateLGITileIndexes(int[] nArray, sBoundingBox sBoundingBox2, int n) {
    }

    default public void updateLGIEvents(sTileInfo[] sTileInfoArray, sLGIEvent[] sLGIEventArray, int n) {
    }
}

