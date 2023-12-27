/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.api.impl;

import de.vw.mib.asl.api.navigation.ASLNavigationEventFactory;
import de.vw.mib.asl.api.navigation.NavigationConfiguration;
import de.vw.mib.asl.api.navigation.NavigationDefinitions;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapAPI;
import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.ASLNavigationServiceMainMap;
import de.vw.mib.asl.api.navigation.map.MapConfiguration;
import de.vw.mib.asl.api.navigation.map.TrafficDualListViewConfiguration;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationStartupFactory;
import de.vw.mib.asl.api.navigation.traffic.TrafficMessageDetails;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.diagnosis.ASLDiagnosisFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.GoogleEarthUtils;
import de.vw.mib.asl.internal.navigation.map.api.impl.listeners.FunctionBlockResponseImpl;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapDatapool;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapEvents;
import de.vw.mib.asl.internal.navigation.map.asl.service.ASLNavigationServiceMainMapFactory;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIAdbEditFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerControlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerGoogleCtrlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerStreetViewCtrlFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMapViewerZoomEngineFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSIMobilityHorizonVWFactory;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.DSINavigationFactoryVW;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.google.license.GoogleEarthLicenseTargetHSM;
import de.vw.mib.asl.internal.navigation.map.dsi.factories.impl.mapviewer.status.DSIMapViewerStatusTarget;
import de.vw.mib.asl.internal.navigation.map.kombi.MapViewerKombiTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerDatapoolShared;
import de.vw.mib.asl.internal.navigation.map.mainmap.MapViewerTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.autozoom.MapViewerAutoZoomTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.content.MapContentChangerTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.destinput.gps.GPSInputTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.focus.MapViewerFocusTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.google.streetview.MapViewerStreetviewTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.hknav.MapViewerHKNavTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.mapswitch.MapViewerMapSwitchTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.perspectives.MapViewerPerspectivesTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.rocketzoom.MapViewerRocketzoomTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mainmap.rubberband.RubberBandHsmTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchapproach.TouchApproachTarget;
import de.vw.mib.asl.internal.navigation.map.mainmap.touchgestures.MapViewerTouchgesturesTargetHSM;
import de.vw.mib.asl.internal.navigation.map.mapinmap.MapInMapViewerTargetHsm;
import de.vw.mib.asl.internal.navigation.map.setup.MapSetupTargetHSM;
import de.vw.mib.asl.internal.navigation.map.setup.PersistedMapSetup;
import de.vw.mib.asl.internal.navigation.map.setup.google.earth.GoogleEarthSetupTargetHSM;
import de.vw.mib.asl.internal.navigation.map.setup.mobilityhorizon.MobilityHorizonSetupHsmTarget;
import de.vw.mib.asl.internal.navigation.map.setup.trafficmap.TrafficMapSetupHsmTarget;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.organizer.AdbEntry;

public class ASLNavigationMapAPIImpl
implements ASLNavigationMapAPI,
ASLNavigationContainer {
    private IExtLogger LOGGER = null;

    public ASLNavigationMapAPIImpl() {
        ASLNavigationStartupFactory.getNavigationStartupApi().registerContainer(this);
    }

    @Override
    public void createTargets() {
        GenericEvents genericEvents = ServiceManager.eventMain;
        String string = "hsmtask";
        ASLDiagnosisFactory.getDiagnosisApi().getAdaptionApi().requestHmiFuncBlockTbl(new FunctionBlockResponseImpl(ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[FunctionBlockResponseImpl]"), MapViewerDatapoolShared.getInstance()));
        DSIMapViewerControlFactoryVW.initFactory();
        DSIMapViewerGoogleCtrlFactoryVW.initFactory();
        DSIMapViewerZoomEngineFactoryVW.initFactory();
        DSIAdbEditFactoryVW.initFactory();
        DSINavigationFactoryVW.initFactory();
        DSIMapViewerStreetViewCtrlFactoryVW.initFactory();
        DSIMobilityHorizonVWFactory.initFactory();
        DSIMapViewerStatusTarget[] dSIMapViewerStatusTargetArray = DSIMapViewerControlFactoryVW.getInstance().getMapViewerStatusTargets();
        for (int i2 = 0; i2 < dSIMapViewerStatusTargetArray.length; ++i2) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, dSIMapViewerStatusTargetArray[i2]);
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, DSIMapViewerZoomEngineFactoryVW.getDSIMapViewerZoomEngineFactoryVW());
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, DSIAdbEditFactoryVW.getDSIAdbEditFactoryVW());
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, DSINavigationFactoryVW.getDSINavigationFactoryVW());
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new ASLNavigationServiceMainMapFactory(genericEvents, -1152707584, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapContentChangerTargetHSM(genericEvents, 1632310272, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerTargetHSM(genericEvents, 1867191296, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerPerspectivesTargetHSM(genericEvents, -1689578496, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerAutoZoomTargetHSM(genericEvents, -1672801280, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerRocketzoomTargetHSM(genericEvents, -984935424, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerFocusTargetHSM(genericEvents, -1656024064, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerTouchgesturesTargetHSM(genericEvents, -1605692416, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, DSIMapViewerStreetViewCtrlFactoryVW.getGoolgeStreetViewStatusTarget());
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, DSIMapViewerGoogleCtrlFactoryVW.getGoogleEarthViewStatusTarget());
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, DSIMapViewerControlFactoryVW.getTargetMapViewerSwitchMain());
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(187)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new GoogleEarthLicenseTargetHSM(genericEvents, -1639246848, string));
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new GoogleEarthSetupTargetHSM(genericEvents, -1370811392, string));
        }
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(188)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerStreetviewTargetHSM(genericEvents, -1622469632, string));
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerKombiTargetHSM(ServiceManager.eventMain, -1555360768, "hsmtask"));
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(139)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerMapSwitchTargetHSM(genericEvents, -800386048, string));
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new GPSInputTargetHSM(genericEvents, -1874127872, string));
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(163)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapInMapViewerTargetHsm(genericEvents, -2041900032, string));
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MobilityHorizonSetupHsmTarget(genericEvents, 1414206464, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new RubberBandHsmTarget(genericEvents, -1354034176, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new MapViewerHKNavTargetHSM(genericEvents, -1169484800, string));
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new TrafficMapSetupHsmTarget(genericEvents, 1447760896, string));
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(121) || ServiceManager.configManagerDiag.isFeatureFlagSet(153)) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new DualListViewHsmTarget(genericEvents, -1588915200, string));
        }
        if (NavigationConfiguration.TOUCH_APPROACH_IN_MAP_FEATURE_AVAILABLE) {
            ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(3, new TouchApproachTarget(genericEvents, -1907682304, string));
        } else if (NavigationDefinitions.NAVI_LOGGER.isTraceEnabled(16384)) {
            LogMessage logMessage = NavigationDefinitions.NAVI_LOGGER.trace(16384);
            logMessage.append("NAVI-STARTUP: ASL_NAVI_TOUCH_APPROACH target not started, because feature flag is disabled.");
            logMessage.log();
        }
        ASLNavigationStartupFactory.getNavigationStartupApi().addTarget(1, new MapSetupTargetHSM(genericEvents, 1581978624, string));
    }

    @Override
    public boolean isGoogleEarthActive() {
        return GoogleEarthUtils.isGoogleEarthActive();
    }

    @Override
    public boolean isSplitScreenGuidance() {
        return PersistedMapSetup.getInstance().isSplitScreenGuidance();
    }

    @Override
    public void setSplitScreenGuidance(boolean bl) {
        PersistedMapSetup.getInstance().setSplitScreenGuidance(bl);
    }

    @Override
    public boolean isSplitScreenNoGuidance() {
        return PersistedMapSetup.getInstance().isSplitScreenNoGuidance();
    }

    @Override
    public void setSplitScreenNoGuidance(boolean bl) {
        PersistedMapSetup.getInstance().setSplitScreenNoGuidance(bl);
    }

    @Override
    public int getSplitScreenContentGuidance() {
        return PersistedMapSetup.getInstance().getSplitScreenContentGuidance();
    }

    @Override
    public void setSplitScreenContentGuidance(int n) {
        PersistedMapSetup.getInstance().setSplitScreenContentGuidance(n);
    }

    @Override
    public int getSplitScreenContentNoGuidance() {
        return PersistedMapSetup.getInstance().getSplitScreenContentNoGuidance();
    }

    @Override
    public void setSplitScreenContentNoGuidance(int n) {
        PersistedMapSetup.getInstance().setSplitScreenContentNoGuidance(n);
    }

    @Override
    public void preRegisterServices() {
        ASLNavigationServiceMainMapEvents.preRegisterServices();
    }

    @Override
    public ASLNavigationServiceMainMap createMainMapService(AbstractTarget abstractTarget, int[] nArray) {
        return ASLNavigationServiceMainMapFactory.createMainMapService(abstractTarget, nArray);
    }

    @Override
    public void sendEvAddressBookEntryChanged(AbstractTarget abstractTarget, AdbEntry adbEntry) {
        this.getLOGGER().trace("sendEvAddressBookEntryChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(409220352);
        eventGeneric.setObject(0, adbEntry);
        ASLNavigationEventFactory.sendEventToTarget(abstractTarget.getTargetId(), 1581978624, eventGeneric);
    }

    @Override
    public void sendEvDestInputHomeLocationChanged() {
        this.getLOGGER().trace("sendEvDestInputHomeLocationChanged()");
        ASLNavigationEventFactory.sendEventToAllObservers(ASLNavigationEventFactory.createEvent(-77384448));
    }

    @Override
    public void sendEvLicenseValidChangedGoogleEarth(boolean bl) {
        this.getLOGGER().trace("sendEvLicenseValidChangedGoogleEarth()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(761541888);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvListViewStartScroll() {
        this.getLOGGER().trace("sendEvListViewStartScroll()");
        ASLNavigationEventFactory.sendEventToService(ASLNavigationEventFactory.createEvent(-27052800));
    }

    @Override
    public void sendEvListViewUpdate(NavLocation[] navLocationArray, int n) {
        this.getLOGGER().trace("sendEvListViewUpdate()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-43830016);
        eventGeneric.setObject(0, navLocationArray);
        eventGeneric.setInt(1, n);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceGoogleNotReady() {
        this.getLOGGER().trace("sendEvMapInstanceGoogleNotReady()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(191116544);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapShowTMCDualList(TrafficDualListViewConfiguration trafficDualListViewConfiguration) {
        this.getLOGGER().trace("sendEvShowTrafficList()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1029977344);
        eventGeneric.setObject(0, trafficDualListViewConfiguration);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceGoogleReady() {
        this.getLOGGER().trace("sendEvMapInstanceGoogleReady()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(174339328);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceKombiNotReady() {
        this.getLOGGER().trace("sendEvMapInstanceKombiNotReady()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(90453248);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceKombiReady() {
        this.getLOGGER().trace("sendEvMapInstanceKombiReady()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(73676032);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceMainNotReady() {
        this.getLOGGER().trace("sendEvMapInstanceMainNotReady()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(124007680);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceMainNotReadyToNavStartupTarget() {
        this.getLOGGER().trace("sendEvMapInstanceMainNotReadyToNavStartupTarget()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1337256960, 1581978624, 124007680);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceMainReady() {
        this.getLOGGER().trace("sendEvMapInstanceMainReady()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(107230464);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceMainReadyToNavStartupTarget() {
        this.getLOGGER().trace("sendEvMapInstanceMainReadyToNavStartupTarget()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1337256960, 1581978624, 107230464);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceMapInMapNotReady() {
        this.getLOGGER().trace("sendEvMapInstanceMapInMapNotReady()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(157562112);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceMapInMapNotReadyToNavStartupTarget() {
        this.getLOGGER().trace("sendEvMapInstanceMapInMapNotReadyToNavStartupTarget()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1337256960, 1581978624, 157562112);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceMapInMapReady() {
        this.getLOGGER().trace("sendEvMapInstanceGoogleReady()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(140784896);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapInstanceMapInMapReadyToNavStartupTarget() {
        this.getLOGGER().trace("sendEvMapInstanceMapInMapReadyToNavStartupTarget()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1337256960, 1581978624, 140784896);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainActivateDestinationZoom() {
        this.getLOGGER().trace("sendEventMapMainActivateDestinationZoom()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(358888704);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainActivateFinalDestinationZoom() {
        this.getLOGGER().trace("sendEventMapMainActivateFinalDestinationZoom()");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(342111488);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainContentGotoLocation(int n, MapConfiguration mapConfiguration) {
        if (this.getLOGGER().isTraceEnabled()) {
            this.getLOGGER().makeTrace().append("sendEvMapMainContentGotoLocation(type=").append(n).append(", mapConfiguration=").append(mapConfiguration.toString()).append(")").log();
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-60607232);
        eventGeneric.setInt(0, n);
        eventGeneric.setObject(1, mapConfiguration);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainDrawn() {
        this.getLOGGER().trace("sendEvMapMainDrawn()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(644101376);
        ASLNavigationEventFactory.sendEventToTarget(1581978624, 1783305216, eventGeneric);
    }

    @Override
    public void sendEvMapMainEhSetCategoryVisibility(int[] nArray, boolean[] blArray) {
        this.getLOGGER().trace("sendEvMapMainEhSetCategoryVisibility()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(275002624);
        eventGeneric.setObject(0, nArray);
        eventGeneric.setObject(1, blArray);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainEhSetCategoryVisibilityResult(int[] nArray) {
        this.getLOGGER().trace("sendEvMapMainEhSetCategoryVisibilityResult()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(308557056);
        eventGeneric.setObject(0, nArray);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainEhSetCategoryVisibilityToDefault() {
        this.getLOGGER().trace("sendEvMapMainEhSetCategoryVisibilityToDefault()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(291779840);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainGetInfoForScreenPosition(AbstractTarget abstractTarget, Point point) {
        if (this.getLOGGER().isTraceEnabled()) {
            this.getLOGGER().makeTrace().append("sendEvMapMainGetInfoForScreenPosition(target.id=").append(abstractTarget.getTargetId()).append(", point=").append(point.toString()).log();
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(224670976);
        eventGeneric.setObject(0, abstractTarget);
        eventGeneric.setObject(1, point);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainGetInfoForScreenPositionResult(AbstractTarget abstractTarget, AbstractTarget abstractTarget2, PosInfo[] posInfoArray) {
        if (this.getLOGGER().isTraceEnabled()) {
            this.getLOGGER().makeTrace().append("sendEvMapMainGetInfoForScreenPositionResult(target.id=").append(abstractTarget2.getTargetId()).append(", posInfos.length=").append(posInfoArray.length).log();
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(241448192);
        eventGeneric.setObject(0, posInfoArray);
        ASLNavigationEventFactory.sendEventToTarget(abstractTarget.getTargetId(), abstractTarget2.getTargetId(), eventGeneric);
    }

    @Override
    public void sendEvMapMainGetInfoForScreenPositionResultAsyncException(AbstractTarget abstractTarget, AbstractTarget abstractTarget2, int n, int n2) {
        if (this.getLOGGER().isTraceEnabled()) {
            this.getLOGGER().makeTrace().append("sendEvMapMainGetInfoForScreenPositionResultAsyncException(target.id=").append(abstractTarget2.getTargetId()).append(", requestType=").append(n).append(", errorCode=").append(n2).append(" )").log();
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(778319104);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        ASLNavigationEventFactory.sendEventToTarget(abstractTarget.getTargetId(), abstractTarget2.getTargetId(), eventGeneric);
    }

    @Override
    public void sendEvMapMainGoogleEarthCheckCrosshairVisibility() {
        if (ASLNavigationMapFactory.getNavigationMapApi().isGoogleEarthActive()) {
            this.getLOGGER().trace("sendEvGooglEarthCheckCrosshairVisibility()");
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(593769728);
            ASLNavigationEventFactory.sendEventToService(eventGeneric);
        }
    }

    @Override
    public void sendEvMapMainGoogleEarthClearCache() {
        this.getLOGGER().trace("sendEvMapMainGoogleEarthClearCache()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(610546944);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainGoogleEarthMapPositionChanged() {
        this.getLOGGER().trace("sendEvMapMainGoogleEarthMapPositionChanged()");
        if (ASLNavigationMapFactory.getNavigationMapApi().isGoogleEarthActive()) {
            EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(576992512);
            ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
        }
    }

    @Override
    public void sendEvMapMainMapMovedByUser() {
        this.getLOGGER().trace("sendEvMapMainMapMovedByUser()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(543438080);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainRbSelectAlternativeRoute(int n) {
        this.getLOGGER().trace("sendEvMapMainRbSelectAlternativeRoute()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(325334272);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainRouteVisibility(boolean bl) {
        if (this.getLOGGER().isTraceEnabled()) {
            this.getLOGGER().makeTrace().append("sendEvMapMainRouteVisibility( routeVisible=").append(bl).append(")").log();
        }
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(811873536);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainServiceAvailableChangedGoogleEarth(boolean bl) {
        this.getLOGGER().trace("sendEvServiceAvailableChangeGoogleEarth()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(442774784);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainServiceAvailableChangedGoogleStreetView(boolean bl) {
        this.getLOGGER().trace("sendEvServiceAvailableChangeGoogleStreetView()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(459552000);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainSwitchMapViewerDone() {
        this.getLOGGER().trace("sendEvMapMainSwitchMapViewerDone()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(627324160);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainTwoFingersZoomDone() {
        this.getLOGGER().trace("sendEvMapMainTwoFingersZoomDone()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(375665920);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainWaypointModeRecordDestinationFlag(NavLocation navLocation, int n) {
        this.getLOGGER().trace("sendEvMapMainWaypointModeRecordDestinationFlag()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(795096320);
        eventGeneric.setObject(0, navLocation);
        eventGeneric.setInt(1, n);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMapMainZoomIndexChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainZoomLevelChangedByUser()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(476329216);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainZoomLevelChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainZoomLevelChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(727987456);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    @Override
    public void sendEvMobilityHorizonServiceAvailable() {
        this.getLOGGER().trace("sendEvMobilityHorizonServiceAvailable()");
        ASLNavigationEventFactory.sendEventToAllObservers(ASLNavigationEventFactory.createEvent(-110938880));
    }

    @Override
    public void sendEvMobilityHorizonServiceNotAvailable() {
        this.getLOGGER().trace("sendEvMobilityHorizonServiceAvailable()");
        ASLNavigationEventFactory.sendEventToAllObservers(ASLNavigationEventFactory.createEvent(-94161664));
    }

    @Override
    public void sendEvNaviPostStartup() {
        this.getLOGGER().trace("sendEvNaviPostStartup()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(425997568);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvShowTMCMessageInMap(TrafficMessageDetails trafficMessageDetails) {
        this.getLOGGER().trace("sendEvShowTMCMessageInMap()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-10275584);
        eventGeneric.setObject(0, trafficMessageDetails);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }

    private IExtLogger getLOGGER() {
        if (this.LOGGER == null) {
            this.LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[ASLNavigationInternalAPIImpl]");
        }
        return this.LOGGER;
    }

    @Override
    public void sendEvMapInMapPerspectiveChanged() {
        this.getLOGGER().trace("sendEvMapInMapPerspectiveChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(862205184);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapInMapZoomLevelChanged() {
        this.getLOGGER().trace("sendEvMapInMapZoomLevelChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(878982400);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainGoogleStreetViewAvailable(boolean bl, int n, int n2) {
        this.getLOGGER().trace("sendEvMapMainGoogleStreetViewAvailable()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(912536832);
        eventGeneric.setBoolean(0, bl);
        eventGeneric.setInt(1, n);
        eventGeneric.setInt(2, n2);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainSpeechRecognizerActive() {
        this.getLOGGER().trace("sendEvMapMainSpeechRecognizerActive()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(929314048);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainSpeechRecognizerInactive() {
        this.getLOGGER().trace("sendEvMapMainSpeechRecognizerInactive()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(946091264);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public boolean isMainMapReady() {
        return ASLNavigationServiceMainMapDatapool.getInstance().isMapReady();
    }

    @Override
    public void sendEvKombiMapDisplayableMapHidden() {
        this.getLOGGER().trace("sendEvKombiMapDisplayableMapHidden()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(962868480);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvKombiMapDisplayableMapShown() {
        this.getLOGGER().trace("sendEvKombiMapDisplayableMapShown()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(979645696);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapViewSwitchToABT() {
        this.getLOGGER().trace("sendEvMapViewSwitchToABT()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(996422912);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapViewSwitchToKombi() {
        this.getLOGGER().trace("sendEvMapViewSwitchToKombi()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1013200128);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainGuidanceStateChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainGuidanceStateChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1046754560);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapForwardTrafficVisibilityToKombi(boolean bl, boolean bl2) {
        this.getLOGGER().trace("sendEvMapFowardTrafficVisibilityToKombi()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1063531776);
        eventGeneric.setBoolean(0, bl);
        eventGeneric.setBoolean(1, bl2);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapForwardTrafficIncidentVisibilityToKombi(boolean bl) {
        this.getLOGGER().trace("sendEvMapForwardTrafficIncidentVisibilityToKombi()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(-1928658880);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendMapViewMapSwitchFinished() {
        this.getLOGGER().trace("sendMapViewMapSwitchFinished()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1080308992);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendMapMainSetStreetViewPosition(NavLocationWgs84 navLocationWgs84) {
        this.getLOGGER().trace("sendMapMainSetStreetViewPosition()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1097086208);
        eventGeneric.setObject(0, navLocationWgs84);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendMapViewMapTriggerSwitch() {
        this.getLOGGER().trace("sendMapViewMapTriggerSwitch()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1113863424);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainHeadingValueChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainHeadingValueChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1130640640);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainZoomValueChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainZoomValueChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1147417856);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainAltitudeValueChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainAltitudeValueChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1164195072);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainAutozoomStatusChanged(boolean bl) {
        this.getLOGGER().trace("sendEvMapMainAutozoomStatusChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1180972288);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapVisibleInAnotherContext(boolean bl) {
        this.getLOGGER().trace("sendEvMapVisibleInAnotherContext()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1197749504);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainOrientationChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainOrientationChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1214526720);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainViewTypeChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainViewTypeChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1231303936);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainMapPerspectiveStateChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainMapPerspectiveStateChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1298412800);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainMapModeChanged(int n) {
        this.getLOGGER().trace("sendEvMapMainMapModeChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1248081152);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainActivateOverviewZoom() {
        this.getLOGGER().trace("sendEvMapMainActivateOverviewZoom()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1342308416);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainHotPointChanged(int n, int n2) {
        this.getLOGGER().trace("sendEvMapMainHotPointChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(420151360);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainCarsorPositionChanged(int n, int n2) {
        this.getLOGGER().trace("sendEvMapMainCarsorPositionChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1325531200);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainMapTypeChanged(int n) {
        this.getLOGGER().makeTrace().append("sendEvMapMainMapTypeChanged(").append(n).append(" )").log();
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1264858368);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapICMapServiceStateChanged(int n) {
        this.getLOGGER().trace("sendEvMapICMapServiceStateChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1281635584);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public boolean isAutozoomActivated() {
        return PersistedMapSetup.getInstance().isAutoZoomMainMap();
    }

    @Override
    public boolean isAutozoomDeactivatedWhileDrag() {
        return MapViewerDatapoolShared.getInstance().isAutozoomDeactivatedWhileDrag();
    }

    @Override
    public void sendEvAutozoomForcedByOtherContext(boolean bl) {
        this.getLOGGER().trace("sendEvAutozoomForcedByOtherContext()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1331967232);
        eventGeneric.setBoolean(0, bl);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainSetZoomArea(int n, int n2, int n3, int n4) {
        this.getLOGGER().trace("sendEvMapMainSetZoomArea()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1399076096);
        eventGeneric.setInt(0, n);
        eventGeneric.setInt(1, n2);
        eventGeneric.setInt(2, n3);
        eventGeneric.setInt(3, n4);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainMapLastTypeChanged(int n) {
        this.getLOGGER().makeTrace().append("sendEvMapMainMapLastTypeChanged(").append(n).append(" )").log();
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1415853312);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvGoogleEarthDataStatusChanged(int n) {
        this.getLOGGER().trace("sendEvGoogleEarthDataStatusChanged()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1432630528);
        eventGeneric.setInt(0, n);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapMainSwitchMapViewerRunning() {
        this.getLOGGER().trace("sendEvMapMainSwitchMapViewerRunning()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1449407744);
        ASLNavigationEventFactory.sendEventToAllObservers(eventGeneric);
    }

    @Override
    public void sendEvMapSwitcherReady() {
        this.getLOGGER().trace("sendEvMapSwitcherReady()");
        EventGeneric eventGeneric = ASLNavigationEventFactory.createEvent(1466184960);
        ASLNavigationEventFactory.sendEventToService(eventGeneric);
    }
}

