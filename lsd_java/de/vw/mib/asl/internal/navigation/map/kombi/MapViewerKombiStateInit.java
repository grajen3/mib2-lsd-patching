/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.kombi;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerZoomEngineFactoryVW;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;

public class MapViewerKombiStateInit
extends AbstractHsmState {
    private static final int[] ASL_OBSERVERS = new int[]{278741248, -154660800, -171438016, 73676032, 90453248, 929314048, 946091264, 1506349120, -1928658880, 1063531776, 1674121280, 1774784576, -1274412992};
    private static final boolean AUTOZOOM_RASTERIZING_DEFAULT;
    private static final int AUTOZOOM_ZOOM_LIMIT_DOWNWARDS;
    private static final int AUTOZOOM_ZOOM_LIMIT_UPWARDS;
    private static final int AUTOZOOM_LEVEL_LOW;
    private static final String LSD_SH_PARAMETER_AUTOZOOM_RASTERINZING;
    private static final String LSD_SH_PARAMETER_AUTOZOOM_ZOOMLIMIT_DOWNWARDS;
    private static final String LSD_SH_PARAMETER_AUTOZOOM_ZOOMLIMIT_UPWARDS;
    private static final String LSD_SH_PARAMETER_AUTOZOOM_ZOOMLEVEL_LOW;
    private int[] ATTRIBUTES_MAPVIEWER_ZOOMENGINE = new int[]{3};
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapViewerKombiTargetHSM - MapViewerKombiStateInit]");
    private final MapViewerKombiTargetHSM target;

    public MapViewerKombiStateInit(MapViewerKombiTargetHSM mapViewerKombiTargetHSM, String string, HsmState hsmState) {
        super(mapViewerKombiTargetHSM.getHsm(), string, hsmState);
        this.target = mapViewerKombiTargetHSM;
    }

    public HsmState dsiMapViewerZoomEngineUpdateRecommendedZoom(float f2, int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiMapViewerZoomEngineUpdateRecommendedZoom(recommendedZoom=").append(f2).append(")").log();
        }
        if (this.target.datapool.isAutozoomRaserizing()) {
            f2 = this.target.rasterizeZoomLevel(f2);
        }
        f2 = MapViewerUtils.checkZoomLevelIsInRange(f2);
        if (this.target.datapool.getRecommendedZoom() == f2) {
            this.logger.trace("the value has not been changed");
            return null;
        }
        this.target.datapool.setRecommendedZoom(f2);
        return null;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3499012: {
                this.handleMapKombiReady();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(receiverEventId=").append(eventGeneric.getReceiverEventId()).append(", params= ").append(eventGeneric.getParamString()).append(")").log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleMapKombiReady() {
        this.logger.trace("handleMapKombiReady()");
        this.target.datapool.setServiceMapViewerRegistred(true);
        this.target.transStateInitMapViewer();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.initAutoZoomRasterizing();
        this.initAutoZoomLevel();
        this.initASL();
        this.initDSI();
        this.initModel();
    }

    private void initASL() {
        this.logger.trace("initASL()");
        this.target.addObservers(ASL_OBSERVERS);
    }

    private void initAutoZoomLevel() {
        String string;
        String string2;
        this.logger.trace("initAutoZoomLevel()");
        int n = 1083965440;
        int n2 = 30000;
        int n3 = 3000;
        String string3 = System.getProperty("de.vw.mib.asl.internal.navigation.map.kombi.autozoom.zoomlimit_downwards");
        if (string3 != null) {
            n2 = Integer.parseInt(string3);
            this.logger.makeInfo().append("initAutoZoomLevel - using lsd.sh parameter for autoZoomLimitDownwards, zoomLevel=").append(n2).log();
        }
        if ((string2 = System.getProperty("de.vw.mib.asl.internal.navigation.map.kombi.autozoom.zoomlimit_upwards")) != null) {
            n = Integer.parseInt(string2);
            this.logger.makeInfo().append("initAutoZoomLevel - using lsd.sh parameter for autoZoomLimitUpwards, zoomLevel=").append(n).log();
        }
        if ((string = System.getProperty("de.vw.mib.asl.internal.navigation.map.kombi.autozoom.zoomlevel_low")) != null) {
            n3 = Integer.parseInt(string);
            this.logger.makeInfo().append("initAutoZoomLevel - using lsd.sh parameter for autozoom zoomLevelLow, zoomLevelLow=").append(n3).log();
        }
        this.target.datapool.setZoomLevelDownwards(n2);
        this.target.datapool.setZoomLevelUpwards(n);
        this.target.datapool.setZoomLevelLow(n3);
    }

    private void initAutoZoomRasterizing() {
        this.logger.trace("initAutoZoomRasterizing()");
        boolean bl = false;
        String string = System.getProperty("de.vw.mib.asl.internal.navigation.map.kombi.autozoom_rasterizing");
        if (string != null) {
            bl = Boolean.getBoolean(string);
            this.logger.makeInfo().append("initAutoZoomRasterizing - using lsd.sh parameter for autozoom rasterizing, rasterizing active=").append(bl).log();
        }
        this.target.datapool.setAutozoomRaserizing(bl);
    }

    private void initDSI() {
        this.logger.trace("initDSI()");
        DSIMapViewerZoomEngineFactoryVW.createMapViewerZoomEngine(this.target, this.ATTRIBUTES_MAPVIEWER_ZOOMENGINE);
    }

    private void initModel() {
        this.logger.trace("initModel()");
        this.target.notifierModel.notifyKombiStatusNotStarted();
    }
}

