/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.dsi.factories;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyFactory;
import de.vw.mib.asl.internal.navigation.map.dsi.DSIMapViewerControlVW;
import de.vw.mib.asl.internal.navigation.map.dsi.citymodel.CityModelService;
import de.vw.mib.asl.internal.navigation.map.dsi.datapool.MapDataPool;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManager;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.DSIMapViewerManagerClientData;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status.DSIMapViewerStatusTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.genericevents.AbstractTarget;

public final class DSIMapViewerControlFactoryVW {
    private static DSIMapViewerControlFactoryVW INSTANCE;
    private static IExtLogger LOGGER;
    public static final int MAP_INSTANCE_KOMBI_ONBOARD;
    public static final int MAP_INSTANCE_KOMBI_GOOGLE_EARTH;
    public static final int MAP_INSTANCE_MAIN_GOOGLE_EARTH;
    public static final int MAP_INSTANCE_MAIN_ONBOARD;
    public static final int MAP_INSTANCE_SPLITSCREEN_ONBOARD;
    private final CityModelService cityModelService;
    private DSIMapViewerManager mapViewerManager = new DSIMapViewerManager();

    public static DSIMapViewerControlVW createMapViewerKombi(AbstractTarget abstractTarget, int[] nArray) {
        DSIMapViewerManagerClientData dSIMapViewerManagerClientData = new DSIMapViewerManagerClientData();
        dSIMapViewerManagerClientData.setTarget(abstractTarget);
        dSIMapViewerManagerClientData.setAttributes(nArray);
        return DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.createMapViewerKombi(dSIMapViewerManagerClientData);
    }

    public static DSIMapViewerControlVW createMapViewerMain(AbstractTarget abstractTarget, int[] nArray) {
        DSIMapViewerManagerClientData dSIMapViewerManagerClientData = new DSIMapViewerManagerClientData();
        dSIMapViewerManagerClientData.setTarget(abstractTarget);
        dSIMapViewerManagerClientData.setAttributes(nArray);
        return DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.createMapViewerMainMap(dSIMapViewerManagerClientData);
    }

    public static DSIMapViewerControlVW createMapViewerSplitscreen(AbstractTarget abstractTarget, int[] nArray) {
        DSIMapViewerManagerClientData dSIMapViewerManagerClientData = new DSIMapViewerManagerClientData();
        dSIMapViewerManagerClientData.setTarget(abstractTarget);
        dSIMapViewerManagerClientData.setAttributes(nArray);
        return DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.createMapViewerSpliscreenMapOnboard(dSIMapViewerManagerClientData);
    }

    public static MapDataPool getMapDatapoolKombi() {
        return DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.getDatapoolKombiMap();
    }

    public static MapDataPool getMapDatapoolMain() {
        return DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.getDatapoolMainMap();
    }

    public static MapDataPool getMapDatapoolSplitScreen() {
        return DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.getDatapoolSplitScreenMap();
    }

    public static int getMapViewerInstanceIdCurrentMain() {
        return DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.getMapViewerMainMapCurrentInstanceId();
    }

    public static int getMapViewerInstanceIdCurrentKombi() {
        return 3;
    }

    public static int getMapViewerInstanceIdCurrentSplitscreen() {
        return 2;
    }

    public static AbstractTarget getTargetMapViewerSwitchMain() {
        return DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.getMapViewerManagerTargetSwitchMainMap();
    }

    public static CityModelService getCityModelService() {
        if (INSTANCE == null) {
            String string = "DSIMapViewerControlFactoryVW.initFactory has not been called!";
            DSIMapViewerControlFactoryVW.getLogger().error("DSIMapViewerControlFactoryVW.initFactory has not been called!");
            throw new IllegalStateException("DSIMapViewerControlFactoryVW.initFactory has not been called!");
        }
        return DSIMapViewerControlFactoryVW.INSTANCE.cityModelService;
    }

    public static void initFactory() {
        if (INSTANCE != null) {
            DSIMapViewerControlFactoryVW.getLogger().error("The Factory was already initialized");
            return;
        }
        INSTANCE = new DSIMapViewerControlFactoryVW();
    }

    public static DSIMapViewerControlFactoryVW getInstance() {
        return INSTANCE;
    }

    public static void setEhCategoryVisibilityOnMapViewer(int n, int[] nArray, boolean[] blArray) {
        DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.setEhCategoryVisibilityOnMapViewer(n, nArray, blArray);
    }

    public static void setGeneralPoiVisibilityOnMapViewer(int n, boolean bl) {
        DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.setGeneralPoiVisibilityOnMapViewer(n, bl);
    }

    public static void setEhCategoryVisibilityOnMapViewer0ToDefault() {
        DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.setEhCategoryVisibilityToOnMapViewer0ToDefault();
    }

    public static void setEhCategoryVisibilityOnMapViewerToDefault(int n) {
        DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.setEhCategoryVisibilityToOnMapViewerToDefault(n);
    }

    public static void setBrandIconStyleOnMapViewer(int n, int[] nArray, int n2) {
        DSIMapViewerControlFactoryVW.INSTANCE.mapViewerManager.setBrandIconStyleOnMapViewer(n, nArray, n2);
    }

    private DSIMapViewerControlFactoryVW() {
        this.cityModelService = new CityModelService(ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[CityModelService]"), DSIProxyFactory.getDSIProxyAPI().getDSIProxy(), ASLSystemFactory.getSystemApi().getDriverDistractionPreventionService(), MapViewerDatapoolShared.getInstance());
    }

    private static IExtLogger getLogger() {
        if (LOGGER == null) {
            LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DSIMapViewerControlFactoryVW]");
        }
        return LOGGER;
    }

    public DSIMapViewerStatusTarget[] getMapViewerStatusTargets() {
        return this.mapViewerManager.getMapViewerManagerTargetStatus();
    }

    static {
        LOGGER = null;
    }
}

