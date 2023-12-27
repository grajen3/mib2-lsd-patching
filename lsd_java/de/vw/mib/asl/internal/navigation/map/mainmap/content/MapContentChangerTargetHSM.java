/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.content;

import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerDatapool;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerNotifierDSI;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateChnCrosshairMapInput;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateDetailScreen;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateDetailScreenChnCrosshairInput;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateDetailScreenDualList;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateDetailScreenGPSInput;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateDetailScreenHome;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateDetailScreenPOI;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateDetailScreenRubberband;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateDetailScreenTMC;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateInit;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateMain;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateMainMap;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateNoMap;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStatePNavShowInMap;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateTrafficDualList;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerStateWPMDetail;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;

public class MapContentChangerTargetHSM
extends AbstractResettableAslHsmTarget {
    protected final MapContentChangerDatapool datapool;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[MapContentChangerTargetHSM]");
    protected final MapContentChangerNotifierDSI notifierDSI = new MapContentChangerNotifierDSI();
    private final MapContentChangerStateDetailScreen stateDetailScreen;
    private final MapContentChangerStateDetailScreenDualList stateDetailScreenDualList;
    private final MapContentChangerStateDetailScreenGPSInput stateDetailScreenGPSInput;
    private final MapContentChangerStateDetailScreenHome stateDetailScreenHome;
    private final MapContentChangerStateChnCrosshairMapInput stateChnCrosshairMapInput;
    private final MapContentChangerStateDetailScreenPOI stateDetailScreenPOI;
    private final MapContentChangerStateDetailScreenTMC stateDetailScreenTMC;
    private final MapContentChangerStateDetailScreenChnCrosshairInput stateDetailScreenChnCrosshairInput;
    private final MapContentChangerStateInit stateInit;
    private final MapContentChangerStateMain stateMain;
    private final MapContentChangerStateMainMap stateMainMap;
    private final MapContentChangerStateDetailScreenRubberband stateRubberbandMap;
    private final MapContentChangerStateNoMap stateNoMap;
    private final MapContentChangerStatePNavShowInMap statePredictiveNavigationShowInMap;
    private final MapContentChangerStateWPMDetail stateWPMDetail;
    private HsmState stateTrafficDualList;
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControl;

    public MapContentChangerTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.datapool = new MapContentChangerDatapool();
        this.stateInit = new MapContentChangerStateInit(this, "stateInit", this.getWorkStateParent());
        this.stateMain = new MapContentChangerStateMain(this, "stateMain", this.getWorkStateParent());
        this.stateMainMap = new MapContentChangerStateMainMap(this, "stateMainMap", (HsmState)this.stateMain);
        this.stateRubberbandMap = new MapContentChangerStateDetailScreenRubberband(this, "stateRubberbandMap", (HsmState)this.stateMain);
        this.stateNoMap = new MapContentChangerStateNoMap(this, "", (HsmState)this.stateMain);
        this.stateDetailScreen = new MapContentChangerStateDetailScreen(this, "stateDetailScreen", (HsmState)this.stateMain);
        this.stateDetailScreenTMC = new MapContentChangerStateDetailScreenTMC(this, "screenDetailScreenTMC", (HsmState)this.stateMain);
        this.stateChnCrosshairMapInput = new MapContentChangerStateChnCrosshairMapInput(this, "stateChnCrosshairMapInput", (HsmState)this.stateMain);
        this.stateDetailScreenHome = new MapContentChangerStateDetailScreenHome(this, "stateDetailScreenHome", (HsmState)this.stateMain);
        this.stateDetailScreenPOI = new MapContentChangerStateDetailScreenPOI(this, "stateDetailScreenPOI", (HsmState)this.stateMain);
        this.stateDetailScreenGPSInput = new MapContentChangerStateDetailScreenGPSInput(this, "stateDetailScreenGPSInput", (HsmState)this.stateMain);
        this.stateDetailScreenDualList = new MapContentChangerStateDetailScreenDualList(this, "stateDetailScreenDualList", (HsmState)this.stateMain);
        this.stateDetailScreenChnCrosshairInput = new MapContentChangerStateDetailScreenChnCrosshairInput(this, "stateDetailScreenChnCrosshairInput", (HsmState)this.stateMain);
        this.statePredictiveNavigationShowInMap = new MapContentChangerStatePNavShowInMap(this, "statePredictiveNavigationShowInMap", (HsmState)this.stateMain);
        this.stateWPMDetail = new MapContentChangerStateWPMDetail(this, "stateWPMDetail", (HsmState)this.stateMain);
        this.stateTrafficDualList = new MapContentChangerStateTrafficDualList(this, "stateTrafficDualList", (HsmState)this.stateMain);
    }

    protected void configureDetailMapFlag(MapConfiguration mapConfiguration) {
        this.logger.trace("configureDetailMapFlag()");
        if (mapConfiguration.getFlagType() == 29) {
            this.logger.trace("Flag styleType is NONE, no flag will be configured");
            return;
        }
        NavLocation navLocation = mapConfiguration.getNavLocation();
        if (navLocation == null) {
            this.logger.error("The NavLocation is null, no flag will be configured!");
            return;
        }
        MapFlag[] mapFlagArray = new MapFlag[]{new MapFlag(navLocation.longitude, navLocation.latitude, mapConfiguration.getFlagType(), 1L)};
        this.notifierDSI.configureFlags(1, null);
        this.notifierDSI.configureFlags(0, mapFlagArray);
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateInit;
    }

    @Override
    public int getSubClassifier() {
        return 256;
    }

    protected void moveMap(MapConfiguration mapConfiguration) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("moveMap(mapConfiguration=").append(mapConfiguration).append(")").log();
        }
        switch (mapConfiguration.getHmiGotoType()) {
            case 0: {
                this.moveMapWithSetLocationByLocation(mapConfiguration);
                break;
            }
            case 1: {
                this.moveMapWithSetLocation(mapConfiguration);
                break;
            }
            default: {
                this.logger.makeError().append("hmiGoToType '").append("' not defined, doing nothing.").log();
            }
        }
    }

    @Override
    public void reset(HashMap hashMap) {
        if (this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$map$DSIMapViewerControl == null ? (class$org$dsi$ifc$map$DSIMapViewerControl = MapContentChangerTargetHSM.class$("org.dsi.ifc.map.DSIMapViewerControl")) : class$org$dsi$ifc$map$DSIMapViewerControl).getName(), 0)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace("no restart neccessary");
            }
        } else if (this.logger.isTraceEnabled()) {
            this.logger.trace("no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void moveMapWithSetLocation(MapConfiguration mapConfiguration) {
        this.logger.trace("moveMapWithSetLocation()");
        this.notifierDSI.setLocation(mapConfiguration.getLocationType(), mapConfiguration.getStopOverNumber());
    }

    private void moveMapWithSetLocationByLocation(MapConfiguration mapConfiguration) {
        this.logger.trace("moveMapWithSetLocationByLocation()");
        this.notifierDSI.setLocationByLocation(mapConfiguration.getNavLocation());
    }

    protected void setDetailScreenDefaultDSIValues(boolean bl) {
        this.logger.trace("setDetailScreenDefaultDSIValues()");
        this.notifierDSI.setMode(2);
        this.notifierDSI.set3DLandmarksVisible(bl);
        this.notifierDSI.setViewType(0);
        this.notifierDSI.setOrientation(2, null);
        this.setCityModelMode();
        this.notifierDSI.setZoomArea(this.datapool.getZoomArea());
        this.notifierDSI.setHotPoint(this.datapool.getHotPoint());
    }

    void sendEventContentReadyMainSetup() {
        this.logger.trace("sendEventContentReadyMainSetup()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(this.getTargetId(), 1581978624, 1205940992);
        eventGeneric.setInt(0, 0);
        this.send(eventGeneric);
    }

    protected void transStateDetailscreen() {
        this.logger.trace("transStateDetailscreen()");
        this.getHsm().trans(this.stateDetailScreen);
    }

    protected void transStateDetailScreenChnCrosshairInput() {
        this.logger.trace("transStateDetailScreenChnCrosshairInput()");
        this.getHsm().trans(this.stateDetailScreenChnCrosshairInput);
    }

    protected void transStateDetailScreenDualList() {
        this.logger.trace("transStateMainDetailScreenDualList()");
        this.getHsm().trans(this.stateDetailScreenDualList);
    }

    protected void transStateDetailScreenGPSInput() {
        this.logger.trace("transStateDetailScreenGPSInput()");
        this.getHsm().trans(this.stateDetailScreenGPSInput);
    }

    protected void transStateDetailScreenHome() {
        this.logger.trace("transStateDetailScreenHome()");
        this.getHsm().trans(this.stateDetailScreenHome);
    }

    protected void transStateChnCrosshairMapInput() {
        this.logger.trace("transStateChnCrosshairMapInput()");
        this.getHsm().trans(this.stateChnCrosshairMapInput);
    }

    protected void transStateDetailScreenPOI() {
        this.logger.trace("transStateDetailScreenPOI()");
        this.getHsm().trans(this.stateDetailScreenPOI);
    }

    protected void transStateDetailScreenTMC() {
        this.logger.trace("transStateDetailScreenTMC()");
        this.getHsm().trans(this.stateDetailScreenTMC);
    }

    protected void transStateMain() {
        this.logger.trace("transStateMain()");
        this.getHsm().trans(this.stateMain);
    }

    protected void transStateMainMap() {
        this.logger.trace("transStateMainMap()");
        this.getHsm().trans(this.stateMainMap);
    }

    protected void transStateNoMap() {
        this.logger.trace("transStateNoMap()");
        this.getHsm().trans(this.stateNoMap);
    }

    protected void transStateRubberbandMap() {
        this.logger.trace("transStateRubberbandMap()");
        this.getHsm().trans(this.stateRubberbandMap);
    }

    protected void transStatePNavShowInMap() {
        this.logger.trace("transStatePNavShowInMap()");
        this.getHsm().trans(this.statePredictiveNavigationShowInMap);
    }

    protected void transStateWPMDetail() {
        this.logger.trace("transStateWPMDetail()");
        this.getHsm().trans(this.stateWPMDetail);
    }

    protected void transStateTrafficDualListView() {
        this.logger.trace("transStateTrafficDualListView()");
        this.getHsm().trans(this.stateTrafficDualList);
    }

    public boolean isPerspectiveOverviewType() {
        return this.datapool.isPerspectiveFinalDestinationZoom() || this.datapool.isPerspectiveDestinationZoom() || this.datapool.isPerspectiveMobilityHorizon() || this.datapool.isPerspectiveOverviewZoom();
    }

    private void setCityModelMode() {
        if (this.datapool.isFeatureShowEnhancedCityModelAllViewtypes()) {
            this.notifierDSI.setCityModelMode(2);
        } else {
            this.notifierDSI.setCityModelMode(0);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

