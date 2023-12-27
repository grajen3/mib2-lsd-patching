/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.Point;

public interface DSIMapViewerRouteBlock
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_RBINFOOFSELECTEDSEGMENTS;
    public static final int RT_RBMARKNEXTSEGMENT;
    public static final int RT_RBMARKPREVIOUSSEGMENT;
    public static final int RT_RBSETSEGMENTSCALES;
    public static final int RT_RBSTARTOFSELECTION;
    public static final int RT_PICKSEGMENTUIDSINSCREENSPACE;
    public static final int RT_HIGHLIGHTSEGMENTUIDSINMAP;
    public static final int RP_PICKSEGMENTUIDSINSCREENSPACERESULT;
    public static final int RP_HIGHLIGHTSEGMENTUIDSINMAPRESULT;
    public static final int RP_RBSTARTOFSELECTIONRESULT;
    public static final int RP_RBMARKNEXTSEGMENTRESULT;
    public static final int RP_RBMARKPREVIOUSSEGMENTRESULT;

    default public void rBMarkNextSegment() {
    }

    default public void rBMarkPreviousSegment() {
    }

    default public void rBSetSegmentScales(long l, long l2) {
    }

    default public void rBStartOfSelection() {
    }

    default public void pickSegmentUidsInScreenSpace(Point point, int n) {
    }

    default public void highLightSegmentUidsInMap(long[] lArray, boolean bl) {
    }
}

