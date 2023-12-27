/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine;

import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine.DSIMapViewerZoomEngineVWImpl;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.map.DSIMapViewerZoomEngineListener;

public class DSIMapViewerZoomEngineTargetData {
    private int[] attributes;
    private DSIMapViewerZoomEngine dsiMapViewerZoomEngine;
    private DSIMapViewerZoomEngineListener dsiMapViewerZoomEngineListener;
    private AbstractTarget target;
    private DSIMapViewerZoomEngineVWImpl dsiMapViewerZoomEngineVW;

    public int[] getAttributes() {
        return this.attributes;
    }

    public DSIMapViewerZoomEngine getDsiMapViewerZoomEngine() {
        return this.dsiMapViewerZoomEngine;
    }

    public DSIMapViewerZoomEngineListener getDsiMapViewerZoomEngineListener() {
        return this.dsiMapViewerZoomEngineListener;
    }

    public DSIMapViewerZoomEngineVWImpl getDsiMapViewerZoomEngineVW() {
        return this.dsiMapViewerZoomEngineVW;
    }

    public AbstractTarget getTarget() {
        return this.target;
    }

    public void setAttributes(int[] nArray) {
        this.attributes = nArray;
    }

    public void setDsiMapViewerZoomEngine(DSIMapViewerZoomEngine dSIMapViewerZoomEngine) {
        this.dsiMapViewerZoomEngine = dSIMapViewerZoomEngine;
    }

    public void setDsiMapViewerZoomEngineListener(DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener) {
        this.dsiMapViewerZoomEngineListener = dSIMapViewerZoomEngineListener;
    }

    public void setDsiMapViewerZoomEngineVW(DSIMapViewerZoomEngineVWImpl dSIMapViewerZoomEngineVWImpl) {
        this.dsiMapViewerZoomEngineVW = dSIMapViewerZoomEngineVWImpl;
    }

    public void setTarget(AbstractTarget abstractTarget) {
        this.target = abstractTarget;
    }
}

