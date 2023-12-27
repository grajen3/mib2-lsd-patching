/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.RouteBrowserInfo;

public interface DSIMapViewerRouteBlockListener
extends DSIListener {
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
}

