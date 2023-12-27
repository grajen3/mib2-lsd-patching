/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth.DSIMapViewerGoogleCtrlVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrl;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener;

public class DSIMapViewerGoogleCtrlTargetData {
    private int[] attributes;
    private DSIMapViewerGoogleCtrl dsiMapViewerGoogleCtrl;
    private DSIMapViewerGoogleCtrlListener dsiMapViewerGoogleCtrlListener;
    private DSIMapViewerGoogleCtrlVWImpl dsiMapViewerGoogleCtrlVW;
    private AbstractTarget target;

    public int[] getAttributes() {
        return this.attributes;
    }

    public DSIMapViewerGoogleCtrl getDsiMapViewerGoogleCtrl() {
        return this.dsiMapViewerGoogleCtrl;
    }

    public DSIMapViewerGoogleCtrlListener getDsiMapViewerGoogleCtrlListener() {
        return this.dsiMapViewerGoogleCtrlListener;
    }

    public DSIMapViewerGoogleCtrlVWImpl getDsiMapViewerGoogleCtrlVW() {
        return this.dsiMapViewerGoogleCtrlVW;
    }

    public AbstractTarget getTarget() {
        return this.target;
    }

    public void setAttributes(int[] nArray) {
        this.attributes = nArray;
    }

    public void setDsiMapViewerGoogleCtrl(DSIMapViewerGoogleCtrl dSIMapViewerGoogleCtrl) {
        this.dsiMapViewerGoogleCtrl = dSIMapViewerGoogleCtrl;
    }

    public void setDsiMapViewerGoogleCtrlListener(DSIMapViewerGoogleCtrlListener dSIMapViewerGoogleCtrlListener) {
        this.dsiMapViewerGoogleCtrlListener = dSIMapViewerGoogleCtrlListener;
    }

    public void setDsiMapViewerGoogleCtrlVW(DSIMapViewerGoogleCtrlVWImpl dSIMapViewerGoogleCtrlVWImpl) {
        this.dsiMapViewerGoogleCtrlVW = dSIMapViewerGoogleCtrlVWImpl;
    }

    public void setTarget(AbstractTarget abstractTarget) {
        this.target = abstractTarget;
    }
}

