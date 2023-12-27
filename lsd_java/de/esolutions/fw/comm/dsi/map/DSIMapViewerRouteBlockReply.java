/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.RouteBrowserInfo;

public interface DSIMapViewerRouteBlockReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateRBInfoOfSelectedSegments(RouteBrowserInfo routeBrowserInfo, int n) {
    }

    default public void pickSegmentUidsInScreenSpaceResult(Point point, int n, long[] lArray, int n2) {
    }

    default public void highLightSegmentUidsInMapResult(long[] lArray, boolean bl, int n) {
    }

    default public void rBStartOfSelectionResult(long l, int n) {
    }

    default public void rBMarkNextSegmentResult(long l, int n) {
    }

    default public void rBMarkPreviousSegmentResult(long l, int n) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

