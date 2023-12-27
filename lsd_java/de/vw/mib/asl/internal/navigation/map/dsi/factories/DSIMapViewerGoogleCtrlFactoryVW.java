/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories;

import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerGoogleCtrlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth.DSIMapViewerGoogleCtrlDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.earth.DSIMapViewerGoogleCtrlTarget;
import de.vw.mib.genericevents.AbstractTarget;

public class DSIMapViewerGoogleCtrlFactoryVW {
    public static DSIMapViewerGoogleCtrlFactoryVW INSTANCE;
    private final DSIMapViewerGoogleCtrlDataPool dataPool = new DSIMapViewerGoogleCtrlDataPool();
    private DSIMapViewerGoogleCtrlTarget target;

    public static DSIMapViewerGoogleCtrlVW createMapViewerGoogleCtrl(AbstractASLHsmTarget abstractASLHsmTarget, int[] nArray) {
        return DSIMapViewerGoogleCtrlFactoryVW.INSTANCE.target.createGoogleCtrl(abstractASLHsmTarget, nArray);
    }

    public static DSIMapViewerGoogleCtrlVW createMapViewerGoogleCtrl(AbstractTarget abstractTarget, int[] nArray) {
        return DSIMapViewerGoogleCtrlFactoryVW.INSTANCE.target.createGoogleCtrl(abstractTarget, nArray);
    }

    public static DSIMapViewerGoogleCtrlDataPool getDataPool() {
        return DSIMapViewerGoogleCtrlFactoryVW.INSTANCE.dataPool;
    }

    public static AbstractTarget getGoogleEarthViewStatusTarget() {
        return DSIMapViewerGoogleCtrlFactoryVW.INSTANCE.target;
    }

    public static void initFactory() {
        if (INSTANCE != null) {
            return;
        }
        INSTANCE = new DSIMapViewerGoogleCtrlFactoryVW();
    }

    private DSIMapViewerGoogleCtrlFactoryVW() {
        try {
            this.target = new DSIMapViewerGoogleCtrlTarget(ServiceManager.eventMain, -1135930368, "hsmtask");
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, this.target);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

