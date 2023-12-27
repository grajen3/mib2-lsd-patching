/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.streetview;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.streetview.DSIMapViewerStreetViewCtrlVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.map.DSIMapViewerStreetViewCtrl;
import org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener;

public class DSIMapViewerStreetViewCtrlTargetData {
    private int[] attributes;
    private DSIMapViewerStreetViewCtrl dsiMapViewerStreetViewCtrl;
    private DSIMapViewerStreetViewCtrlListener dsiMapViewerStreetViewCtrlListener;
    private DSIMapViewerStreetViewCtrlVWImpl dsiMapViewerStreetViewCtrlVW;
    private AbstractTarget target;

    public int[] getAttributes() {
        return this.attributes;
    }

    public DSIMapViewerStreetViewCtrl getDsiMapViewerStreetViewCtrl() {
        return this.dsiMapViewerStreetViewCtrl;
    }

    public DSIMapViewerStreetViewCtrlListener getDsiMapViewerStreetViewCtrlListener() {
        return this.dsiMapViewerStreetViewCtrlListener;
    }

    public DSIMapViewerStreetViewCtrlVWImpl getDsiMapViewerStreetViewCtrlVW() {
        return this.dsiMapViewerStreetViewCtrlVW;
    }

    public AbstractTarget getTarget() {
        return this.target;
    }

    public void setAttributes(int[] nArray) {
        this.attributes = nArray;
    }

    public void setDsiMapViewerStreetViewCtrl(DSIMapViewerStreetViewCtrl dSIMapViewerStreetViewCtrl) {
        this.dsiMapViewerStreetViewCtrl = dSIMapViewerStreetViewCtrl;
    }

    public void setDsiMapViewerStreetViewCtrlListener(DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener) {
        this.dsiMapViewerStreetViewCtrlListener = dSIMapViewerStreetViewCtrlListener;
    }

    public void setDsiMapViewerStreetViewCtrlVW(DSIMapViewerStreetViewCtrlVWImpl dSIMapViewerStreetViewCtrlVWImpl) {
        this.dsiMapViewerStreetViewCtrlVW = dSIMapViewerStreetViewCtrlVWImpl;
    }

    public void setTarget(AbstractTarget abstractTarget) {
        this.target = abstractTarget;
    }
}

