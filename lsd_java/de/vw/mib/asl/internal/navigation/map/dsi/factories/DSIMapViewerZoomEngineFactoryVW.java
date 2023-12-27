/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerZoomEngineVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.zoomengine.DSIMapViewerZoomEngineTarget;
import de.vw.mib.genericevents.AbstractTarget;

public class DSIMapViewerZoomEngineFactoryVW {
    public static DSIMapViewerZoomEngineFactoryVW INSTANCE;
    private DSIMapViewerZoomEngineTarget target;

    public static DSIMapViewerZoomEngineVW createMapViewerZoomEngine(AbstractTarget abstractTarget, int[] nArray) {
        return DSIMapViewerZoomEngineFactoryVW.INSTANCE.target.createMapViewerZoomEngine(abstractTarget, nArray);
    }

    public static DSIMapViewerZoomEngineTarget getDSIMapViewerZoomEngineFactoryVW() {
        return DSIMapViewerZoomEngineFactoryVW.INSTANCE.target;
    }

    DSIMapViewerZoomEngineFactoryVW() {
        try {
            this.target = new DSIMapViewerZoomEngineTarget(ServiceManager.eventMain, -716499968, "hsmtask");
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void initFactory() {
        if (INSTANCE != null) {
            return;
        }
        INSTANCE = new DSIMapViewerZoomEngineFactoryVW();
    }
}

