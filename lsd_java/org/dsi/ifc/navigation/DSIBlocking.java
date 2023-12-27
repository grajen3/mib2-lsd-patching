/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public interface DSIBlocking
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_NAVICOREAVAILABLETOSETBLOCKS;
    public static final int ATTR_LISTOFBLOCKS;
    public static final int ATTR_MAXIMUMNUMBEROFBLOCKEDAREAS;
    public static final int ATTR_MAXIMUMNUMBEROFBLOCKEDROUTESEGMENTS;
    public static final int ATTR_MAXIMUMNUMBEROFBLOCKEDROADSEGMENTS;
    public static final int ATTR_MAXIMUMDIMENSIONSOFBLOCKEDAREA;
    public static final int ATTR_MAXIMUMSEGMENTLENGTHOFBLOCKEDROUTESEGMENT;
    public static final int ATTR_MAXIMUMLENGTHOFBLOCKROUTEBASEDONLENGTH;
    public static final int BLOCKREQUESTRESULTCODE_OK;
    public static final int BLOCKREQUESTRESULTCODE_FAILED;
    public static final int BLOCKREQUESTRESULTCODE_FAILEDOUTOFMEMORY;
    public static final int BLOCKINGELEMENTTYPE_RECTANGULARAREA;
    public static final int BLOCKINGELEMENTTYPE_ROUTE_SEGMENT;
    public static final int BLOCKINGELEMENTTYPE_ROAD_SEGMENT;
    public static final int BLOCKINGELEMENTTYPE_ROUTEBASESONLENGTH;
    public static final int NAVICOREAVAILABLETOSETBLOCKS_READYTOBLOCK;
    public static final int NAVICOREAVAILABLETOSETBLOCKS_BUSY;
    public static final int RT_BLOCKAREA;
    public static final int RT_BLOCKROUTESEGMENTS;
    public static final int RT_BLOCKROADSEGMENTS;
    public static final int RT_BLOCKROUTEBASEDONLENGTH;
    public static final int RT_PERSISTBLOCK;
    public static final int RT_DELETEBLOCK;
    public static final int RT_SETBLOCKDESCRIPTION;
    public static final int RT_GETBOUNDINGRECTANGLEOFBLOCKS;
    public static final int RP_BLOCKAREARESULT;
    public static final int RP_BLOCKROUTESEGMENTSRESULT;
    public static final int RP_BLOCKROADSEGMENTSRESULT;
    public static final int RP_BLOCKROUTEBASEDONLENGTHRESULT;
    public static final int RP_PERSISTBLOCKRESULT;
    public static final int RP_DELETEBLOCKRESULT;
    public static final int RP_SETBLOCKDESCRIPTIONRESULT;
    public static final int RP_GETBOUNDINGRECTANGLEOFBLOCKSRESULT;

    default public void blockArea(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
    }

    default public void blockRouteSegments(long l, long l2) {
    }

    default public void blockRoadSegments(NavLocation navLocation) {
    }

    default public void blockRouteBasedOnLength(int n, int n2) {
    }

    default public void persistBlock(long[] lArray) {
    }

    default public void deleteBlock(long[] lArray) {
    }

    default public void setBlockDescription(long[] lArray, String string) {
    }

    default public void getBoundingRectangleOfBlocks(long[] lArray) {
    }
}

