/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps;

import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputTargetHSM;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class GPSInputNotifierDSI {
    private DSIMapViewerControlVW dsiMapViewerControl;
    private final GPSInputTargetHSM target;

    public GPSInputNotifierDSI(GPSInputTargetHSM gPSInputTargetHSM) {
        this.target = gPSInputTargetHSM;
    }

    public void dragMap() {
        int n = this.target.datapool.getSelectedX();
        int n2 = this.target.datapool.getSelectedY();
        int n3 = this.target.datapool.getDraggedX();
        int n4 = this.target.datapool.getDraggedY();
        short s = (short)(n3 - n);
        short s2 = (short)(n4 - n2);
        this.target.datapool.setSelectedX(n3);
        this.target.datapool.setSelectedY(n4);
        this.dsiMapViewerControl.dragMap(s, s2);
    }

    public void getInfoForScreenPosition() {
        this.dsiMapViewerControl.getInfoForScreenPosition(this.target, this.target.datapool.getHotPoint());
    }

    public void getInfoForScreenPosition(AbstractTarget abstractTarget, Point point) {
        this.dsiMapViewerControl.getInfoForScreenPosition(abstractTarget, point);
    }

    public void registerDsiServicesHSM() {
        this.dsiMapViewerControl = DSIMapViewerControlFactoryVW.createMapViewerMain(this.target, GPSInputTargetHSM.ATTRIBUTES_MAPVIEWER);
    }

    public void setHotPoint(Point point) {
        this.dsiMapViewerControl.setHotPoint(point);
    }

    public void setLocationByLocation(NavLocation navLocation) {
        this.dsiMapViewerControl.setLocationByLocation(navLocation);
    }

    public void setMode(int n) {
        this.dsiMapViewerControl.setMode(n);
    }

    public void setOrientation(int n, Point point) {
        this.dsiMapViewerControl.setOrientation(n, point);
    }

    public void setViewType(int n) {
        this.dsiMapViewerControl.setViewType(n);
    }

    public void setZoomArea(Rect rect) {
        this.dsiMapViewerControl.setZoomArea(rect);
    }

    public void setZoomIndex(int n) {
        this.dsiMapViewerControl.setZoomLevel(32959, n);
    }

    public void stopScrollToDirection() {
        this.dsiMapViewerControl.stopScrollToDirection();
    }

    public void viewFreezeFalse() {
        this.dsiMapViewerControl.viewFreeze(false);
    }

    public void viewFreezeTrue() {
        this.dsiMapViewerControl.viewFreeze(true);
    }
}

