/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.getinfoforscreenposition;

import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.map.Point;

public class DSIMapViewerGetInfoForScreenPositionRequest {
    private final AbstractTarget target;
    private Point point;

    public DSIMapViewerGetInfoForScreenPositionRequest(AbstractTarget abstractTarget, Point point) {
        this.target = abstractTarget;
        this.point = point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public AbstractTarget getTarget() {
        return this.target;
    }

    public Point getPoint() {
        return this.point;
    }
}

