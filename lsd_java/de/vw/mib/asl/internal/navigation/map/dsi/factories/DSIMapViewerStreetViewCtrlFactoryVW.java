/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories;

import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerStreetViewCtrlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.streetview.DSIMapViewerStreetViewCtrlTarget;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.streetview.DSIMapViewerStreetViewCtrlTargetDatapool;
import de.vw.mib.genericevents.AbstractTarget;

public class DSIMapViewerStreetViewCtrlFactoryVW {
    public static DSIMapViewerStreetViewCtrlFactoryVW INSTANCE;
    private DSIMapViewerStreetViewCtrlTarget target;

    public static DSIMapViewerStreetViewCtrlVW createMapViewerGoogleCtrl(AbstractTarget abstractTarget, int[] nArray) {
        return DSIMapViewerStreetViewCtrlFactoryVW.INSTANCE.target.createStreetViewCtrl(abstractTarget, nArray);
    }

    public static AbstractTarget getGoolgeStreetViewStatusTarget() {
        return DSIMapViewerStreetViewCtrlFactoryVW.INSTANCE.target;
    }

    public static DSIMapViewerStreetViewCtrlTargetDatapool getStreetViewCtrlDataPool() {
        return DSIMapViewerStreetViewCtrlFactoryVW.INSTANCE.target.getDatapool();
    }

    private DSIMapViewerStreetViewCtrlFactoryVW() {
        try {
            this.target = new DSIMapViewerStreetViewCtrlTarget(ServiceManager.eventMain, -1119153152, "hsmtask");
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, this.target);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public static void initFactory() {
        if (INSTANCE != null) {
            return;
        }
        INSTANCE = new DSIMapViewerStreetViewCtrlFactoryVW();
    }
}

