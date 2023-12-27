/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.map.Point;

public interface DSIMapViewerLandmarkPlayer
extends DSIBase {
    public static final String VERSION;
    public static final int RT_HIDELANDMARK;
    public static final int RT_SHOWLANDMARK;
    public static final int RP_SHOWLANDMARK;

    default public void hideLandmark() {
    }

    default public void showLandmark(Point point, long l) {
    }
}

