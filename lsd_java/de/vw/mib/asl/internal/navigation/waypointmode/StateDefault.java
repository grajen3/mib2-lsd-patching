/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.waypointmode;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForFullFactoryReset;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.waypointmode.HsmTargetWayPointMode;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmDataPool;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmDsiNotifier;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmModelNotifier;
import de.vw.mib.asl.internal.navigation.waypointmode.WpmPersistence;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import de.vw.mib.properties.values.SpellerData;
import java.util.Arrays;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;
import org.dsi.ifc.navigation.util.RouteHelper;

public class StateDefault
extends AbstractHsmState
implements TargetForFullFactoryReset {
    private final HsmTargetWayPointMode target;
    private SpellerData spellerData = new SpellerData();
    private NavSegmentID renameTourID = null;
    private FactoryResetParticipantWithCallback fullFactoryResetParticipant;

    public StateDefault(HsmTargetWayPointMode hsmTargetWayPointMode, String string, HsmState hsmState) {
        super(hsmTargetWayPointMode.getHsm(), string, hsmState);
        this.target = hsmTargetWayPointMode;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.target.traceState(this, "HSM_ENTRY");
                if (this.fullFactoryResetParticipant != null) break;
                this.fullFactoryResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForFullFactoryResetAndAddToService(this);
                break;
            }
            case 3: {
                this.target.traceState(this, "HSM_START");
                this.target.getModelNotifier().setCurrentWPMModeDefault();
                this.target.getInternalAPINotifier().setCurrentWPMModeDefault();
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmMode(0);
                break;
            }
            case 4: {
                this.target.traceState(this, "HSM_EXIT");
                if (this.fullFactoryResetParticipant == null) break;
                ASLNavigationUtilFactory.getNavigationUtilApi().removeFullFactoryResetParticipantFromService(this.fullFactoryResetParticipant);
                this.fullFactoryResetParticipant = null;
                break;
            }
            case 1073744735: {
                this.target.traceState(this, "START_RECORD");
                this.caseStartRecord(eventGeneric);
                break;
            }
            case 1073744739: {
                this.target.traceState(this, "DELETE_TRACK_FROM_WPM_TOUR_LIST");
                this.caseDeleteTrackFromWPMTourList(eventGeneric);
                break;
            }
            case 1073744738: {
                this.target.traceState(this, "LOAD_DETAILS_OF_WPM_TOUR_LIST_ELEMENT");
                this.caseLoadDetailsOfTour(eventGeneric);
                break;
            }
            case 1073744782: {
                this.target.traceState(this, "TOGGLE_SPLIT_SCREEN_DEFAULT");
                this.caseToggleSplitScreen();
                break;
            }
            case 1073744747: {
                this.target.traceState(this, "SET_CURRENT_CONTENT_DEFAULT");
                this.caseSetSSCurrentContentDefault(eventGeneric);
                break;
            }
            case 1073744748: {
                this.target.traceState(this, "SET_CURRENT_CONTENT_DRIVE_OR_RECORD");
                this.caseSetSSContentDriveRecord(eventGeneric);
                break;
            }
            case 1073744760: {
                this.target.traceState(this, "SPELLER_INIT");
                this.caseSpellerInit(eventGeneric);
                break;
            }
            case 1073744761: {
                this.target.traceState(this, "SPELLER_SET_CHAR");
                this.caseSpellerSetChar(eventGeneric);
                break;
            }
            case 1073744762: {
                this.target.traceState(this, "SPELLER_DELETE_CHAR");
                this.caseSpellerDeleteChar();
                break;
            }
            case 1073744763: {
                this.target.traceState(this, "SPELLER_SET_CURSOR_POSITION");
                this.caseSpellerSetCursorPosition(eventGeneric);
                break;
            }
            case 1073744765: {
                this.target.traceState(this, "SPELLER_SAVE");
                this.caseSpellerSave(eventGeneric);
                break;
            }
            case 1073744764: {
                this.target.traceState(this, "SPELLER_CHECK_TRACK_LIST_NAME");
                this.caseSpellerCheckTrackListName(eventGeneric);
                break;
            }
            case 1073744729: {
                this.target.traceState(this, "CHANGE_EXECUTION_MODE");
                int n = eventGeneric.getInt(0);
                this.target.changeExecutionMode(n);
                break;
            }
            case 1073744767: {
                this.target.traceState(this, "EXPORT_TRACK_FROM_WPM_TOUR_LIST");
                this.caseExportTrackFromWPMTourList(eventGeneric);
                break;
            }
            case 1073744759: {
                this.target.traceState(this, "IMPORT_WPM_TRACKS");
                this.caseImportWPMTracks(eventGeneric);
                break;
            }
            case 1074841918: {
                this.target.traceState(this, "SET_RECORD_TOUR_NAME");
                this.caseSetRecordTourName(eventGeneric);
                break;
            }
            case 0x355C35: {
                this.target.traceState(this, "EV_GUIDANCE_RESUME_GUIDANCE");
                this.caseGuidanceResume();
                break;
            }
            case 100100: {
                this.target.traceState(this, "EV_ASL_INT_STOP");
                ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmLocation(null);
                this.resetDirectionDistance();
                break;
            }
            default: {
                return this.myParent;
            }
        }
        return null;
    }

    private void caseSetRecordTourName(EventGeneric eventGeneric) {
        this.target.getDataPool().setStoreTourName(eventGeneric.getString(0));
    }

    private void caseExportTrackFromWPMTourList(EventGeneric eventGeneric) {
        NavTraceListData navTraceListData;
        int n = eventGeneric.getInt(0);
        GenericASLList genericASLList = this.target.getDataPool().getTrackList();
        if (genericASLList.isValidItem(navTraceListData = (NavTraceListData)genericASLList.getRowItemCacheOnly(n))) {
            NavSegmentID navSegmentID = navTraceListData.getTraceID();
            String string = navTraceListData.getName().concat(".gpx");
            string = this.formatStringForFileSystem(string);
            this.target.getDsiNotifier().exportTour(navSegmentID, string);
        }
    }

    private String formatStringForFileSystem(String string) {
        this.target.traceState(this, "formatStringForFileSystem()");
        if (string != null) {
            char[] cArray = string.toCharArray();
            for (int i2 = 0; i2 < cArray.length; ++i2) {
                if (cArray[i2] > '\uf80000') {
                    this.target.traceState(this, "Format character");
                    cArray[i2] = (char)(cArray[i2] - 0xF80000);
                }
                if (cArray[i2] != ':') continue;
                cArray[i2] = 46;
            }
            return new String(cArray);
        }
        return null;
    }

    private void caseImportWPMTracks(EventGeneric eventGeneric) {
        ResourceLocator resourceLocator = null;
        ResourceLocator resourceLocator2 = (ResourceLocator)eventGeneric.getObject(0);
        if (resourceLocator2 != null) {
            resourceLocator = resourceLocator2;
        }
        if (resourceLocator != null) {
            this.target.getModelNotifier().setImportStateImporting();
            this.target.getDsiNotifier().importTour(resourceLocator);
        }
    }

    private void caseStartRecord(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.getDataPool().setRecordMode(n);
        this.trans(this.target.stateRecord);
    }

    private void caseDeleteTrackFromWPMTourList(EventGeneric eventGeneric) {
        int n;
        NavTraceListData navTraceListData;
        GenericASLList genericASLList = this.target.getDataPool().getTrackList();
        if (genericASLList.isValidItem(navTraceListData = (NavTraceListData)genericASLList.getRowItemCacheOnly(n = eventGeneric.getInt(0)))) {
            NavSegmentID navSegmentID = navTraceListData.getTraceID();
            this.target.getModelNotifier().setDeletionStateDeleting();
            this.target.getDsiNotifier().deleteTour(navSegmentID);
        }
    }

    private void caseToggleSplitScreen() {
        this.target.getDataPool().setSplitScreenActive(!this.target.getDataPool().getSplitScreenActive());
        this.target.getModelNotifier().setSplitScreenActive(this.target.getDataPool().getSplitScreenActive());
    }

    private void caseSetSSCurrentContentDefault(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.getDataPool().setSplitScreenCurrentContentDefault(n);
        this.target.getModelNotifier().setSplitScreenContentDefaultMode(n);
    }

    private void caseSetSSContentDriveRecord(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.getDataPool().setSplitScreenCurrentContentDriveRecord(n);
        this.target.getModelNotifier().setSplitScreenContentDriveRecordMode(n);
    }

    private void caseLoadDetailsOfTour(EventGeneric eventGeneric) {
        NavTraceListData navTraceListData;
        int n = eventGeneric.getInt(0);
        GenericASLList genericASLList = this.target.getDataPool().getTrackList();
        if (genericASLList.isValidItem(navTraceListData = (NavTraceListData)genericASLList.getRowItemCacheOnly(n))) {
            this.target.getDataPool().setSelectedtTour(navTraceListData);
            this.target.getModelNotifier().setNumberOfWaypointsInTour(navTraceListData.getNumberOfTrackPoints());
            this.target.getDataPool().setNumberOfWaypointsInTour(navTraceListData.getNumberOfTrackPoints());
            NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navTraceListData.getTraceID()).getLocation();
            Route route = new Route();
            RouteDestination routeDestination = new RouteDestination();
            routeDestination.setRouteLocation(navLocation);
            RouteHelper.addDestinationAtPosition(route, routeDestination, 0);
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setTourmodeRoute(route);
            this.target.getModelNotifier().setActionResultOk();
        } else {
            ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().resetNavigationModel();
        }
    }

    private void caseSpellerInit(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().clear(this.spellerData);
        GenericASLList genericASLList = this.target.getDataPool().getTrackList();
        NavTraceListData navTraceListData = (NavTraceListData)genericASLList.getRowItemCacheOnly(n);
        this.renameTourID = navTraceListData.getTraceID();
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().addChar(this.spellerData, navTraceListData.name);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().selectAll(this.spellerData);
        this.updateSpellerData();
        this.target.getModelNotifier().setActionResultOk();
    }

    private void caseSpellerSetChar(EventGeneric eventGeneric) {
        String string = eventGeneric.getString(0);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().addChar(this.spellerData, string);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("spellerString: ").append(this.spellerData.getEnteredText()).log();
        }
        this.updateSpellerData();
    }

    private void caseSpellerDeleteChar() {
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().deleteChar(this.spellerData);
        if (this.target.isTraceEnabled()) {
            this.target.trace().append("spellerString: ").append(this.spellerData.getEnteredText()).log();
        }
        this.updateSpellerData();
    }

    private void caseSpellerSetCursorPosition(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        ASLNavigationUtilFactory.getNavigationUtilApi().getSpellerDataHelper().deselectAll(this.spellerData);
        this.spellerData.setCursorPosition(n);
        this.updateSpellerData();
    }

    private void updateSpellerData() {
        this.target.getModelNotifier().setSpellerCharEntered(this.spellerData.getEnteredText().length() > 0);
        this.target.getModelNotifier().setSpellerData(this.spellerData);
    }

    private void caseSpellerSave(EventGeneric eventGeneric) {
        this.target.getDsiNotifier().renameTour(this.renameTourID, this.spellerData.getEnteredText());
        this.renameTourID = null;
    }

    private void caseSpellerCheckTrackListName(EventGeneric eventGeneric) {
        String string = this.spellerData.getEnteredText();
        boolean bl = false;
        GenericASLList genericASLList = this.target.getDataPool().getTrackList();
        for (int i2 = 0; i2 < genericASLList.getSize(); ++i2) {
            NavTraceListData navTraceListData = (NavTraceListData)genericASLList.getRowItemCacheOnly(i2);
            if (!genericASLList.isValidItem(navTraceListData) || navTraceListData.getName() == null || !navTraceListData.getName().equals(string)) continue;
            bl = true;
            break;
        }
        this.target.getModelNotifier().setTrackListRenameString(this.spellerData.getEnteredText());
        this.target.getModelNotifier().setTourNameExists(bl);
        this.target.getModelNotifier().setActionResultOk();
    }

    private void caseGuidanceResume() {
        NavTraceListData navTraceListData = this.getPersistedNavTraceListData();
        GenericASLList genericASLList = this.target.getDataPool().getTrackList();
        if (navTraceListData != null && genericASLList.isValidItem(navTraceListData)) {
            this.target.getDataPool().setSelectedtTour(navTraceListData);
            this.target.getModelNotifier().setNumberOfWaypointsInTour(navTraceListData.getNumberOfTrackPoints());
            this.target.getDataPool().setNumberOfWaypointsInTour(navTraceListData.getNumberOfTrackPoints());
            this.trans(this.target.stateGuidance);
        }
    }

    private NavTraceListData getPersistedNavTraceListData() {
        NavTraceListData navTraceListData = null;
        int[] nArray = WpmPersistence.getInstance().getLastActiveTrack();
        if (nArray != null) {
            GenericASLList genericASLList = this.target.getDataPool().getTrackList();
            int n = genericASLList.getItemCount();
            for (int i2 = 0; i2 < n; ++i2) {
                NavTraceListData navTraceListData2 = (NavTraceListData)genericASLList.getRowItemCacheOnly(i2);
                NavSegmentID navSegmentID = navTraceListData2.getTraceID();
                boolean bl = false;
                if (nArray.length == navSegmentID.elements.length) {
                    bl = true;
                    for (int i3 = 0; i3 < nArray.length; ++i3) {
                        if (navSegmentID.elements[i3] == nArray[i3]) continue;
                        bl = false;
                        break;
                    }
                }
                if (!bl) continue;
                navTraceListData = navTraceListData2;
                break;
            }
        }
        return navTraceListData;
    }

    public HsmState dsiNavigationTrRenameTraceResult(int n, int n2) {
        this.target.getModelNotifier().setActionResultOk();
        return null;
    }

    public HsmState dsiNavigationTrDeleteTraceResult(int n, int n2) {
        this.target.getModelNotifier().setDeletionStateIdle();
        this.target.getModelNotifier().setActionResultOk();
        return null;
    }

    public HsmState dsiNavigationUpdateTrTraceList(NavTraceListData[] navTraceListDataArray, int n) {
        if (navTraceListDataArray != null) {
            this.target.getModelNotifier().setNumberOfTracksInMemory(navTraceListDataArray.length);
            this.target.getModelNotifier().setTrackList(navTraceListDataArray);
        }
        return null;
    }

    public HsmState dsiNavigationUpdateSoPosPosition(PosPosition posPosition, int n) {
        this.target.traceState(this, "updateSoPosPosition()");
        if (posPosition != null) {
            NavNextWayPointInfo navNextWayPointInfo = this.target.getDataPool().getInfoForNextWP();
            if (navNextWayPointInfo != null) {
                NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navNextWayPointInfo.getLatitude(), navNextWayPointInfo.getLongitude()).getLocation();
                if (navLocation != null) {
                    this.updateWaypointValues(posPosition, navNextWayPointInfo, navLocation);
                } else {
                    this.target.traceState(this, "Waypoint NavLocation is null");
                    this.resetDirectionDistance();
                }
            } else {
                this.target.traceState(this, "WpInfo is null or latitude/longitude <= 0");
                this.resetDirectionDistance();
            }
        } else {
            this.target.traceState(this, "CCP is null or latitude/longitude <= 0");
            this.resetDirectionDistance();
        }
        return null;
    }

    private void updateWaypointValues(PosPosition posPosition, NavNextWayPointInfo navNextWayPointInfo, NavLocation navLocation) {
        this.target.traceState(this, "updateDirectionDistance()");
        int n = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDirectionIndexCCP2Loc(navLocation, 16);
        this.sendBAPManeuverDirection(n);
        int n2 = (int)Math.floor((double)n * 22.5);
        int n3 = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().calculateDistance(posPosition.getLongitude(), posPosition.getLatitude(), navNextWayPointInfo.getLongitude(), navNextWayPointInfo.getLatitude());
        int n4 = this.target.getDataPool().getNumberOfWaypointsInTour();
        int n5 = n4 - navNextWayPointInfo.getRemainingWaypoints() + 1;
        this.target.getModelNotifier().setDirectionToWP(n2);
        this.target.getInternalAPINotifier().setDirectionToWP(n2);
        this.target.getModelNotifier().setDistanceToWP(n3);
        this.target.getInternalAPINotifier().setDistanceToWP(n3);
        this.target.getModelNotifier().setIndexOfNextWaypoint(Math.min(n4, n5));
    }

    private void resetDirectionDistance() {
        this.target.getModelNotifier().setDirectionToWP(0);
        this.target.getInternalAPINotifier().setDirectionToWP(0);
        this.target.getModelNotifier().setDistanceToWP(0);
        this.target.getInternalAPINotifier().setDistanceToWP(0);
    }

    public HsmState dsiNavigationUpdateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo, int n) {
        this.target.traceState(this, "updateTrInfoForNextWaypoint()");
        if (navNextWayPointInfo != null) {
            this.target.getDataPool().setInfoForNextWP(navNextWayPointInfo);
            NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(navNextWayPointInfo.getLatitude(), navNextWayPointInfo.getLongitude()).getLocation();
            ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().setWpmLocation(navLocation);
            this.updateWaypointValues(ASLNavigationUtilFactory.getNavigationUtilApi().getNavGateway().getSoPosPosition(), navNextWayPointInfo, navLocation);
        } else {
            this.target.traceState(this, "WpInfo is null or latitude/longitude <= 0");
            this.target.getDataPool().setInfoForNextWP(null);
            this.resetDirectionDistance();
        }
        return this.myParent;
    }

    private void sendBAPManeuverDirection(int n) {
        this.target.traceState(this, "sendBAPManeuverDirection()");
        int[] nArray = new int[]{0, 240, 224, 208, 192, 176, 160, 144, 128, 112, 96, 80, 64, 48, 32, 16};
        if (n >= 0 && n < nArray.length) {
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
            eventGeneric.setReceiverTargetId(1732973568);
            eventGeneric.setReceiverEventId(75956480);
            eventGeneric.setInt(0, nArray[n]);
            this.target.send(eventGeneric);
        } else {
            this.target.traceState(this, "Maneuver index out of range!");
        }
    }

    public HsmState dsiNavigationUpdateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization, int n) {
        if (navTraceMemoryUtilization != null) {
            boolean bl;
            int n2 = (int)(navTraceMemoryUtilization.getMaximumNumberOfTrackPoints() - navTraceMemoryUtilization.getTotalNumberOfTrackPoints());
            this.target.getModelNotifier().setNumberOfFreeWaypointsInMemory(n2);
            this.target.getInternalAPINotifier().setNumberOfFreePointsInMemory(n2);
            int n3 = (int)navTraceMemoryUtilization.getMaximumNumberOfTrackPoints();
            this.target.getModelNotifier().setNumberOfMaxWaypointsinMemory(n3);
            this.target.getInternalAPINotifier().setNumberOfMaxWaypointsinMemory(n3);
            int n4 = (int)navTraceMemoryUtilization.getNumberOfTrackpoints();
            this.target.getModelNotifier().setNumberOfWaypointsCurrentRecord(n4);
            this.target.getInternalAPINotifier().setNumberOfWaypointsinCurrentRecord(n4);
            boolean bl2 = bl = n2 <= 200;
            if (bl != this.target.getDataPool().isOldBelowThreshold()) {
                this.target.getDataPool().setOldBelowThreshold(bl);
                this.target.getModelNotifier().setFreeWaypointMemoryBelowThreshold(bl);
            }
            if (n2 == 0 && ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().isWpmActive()) {
                this.target.sendHMIEvent(66064384);
            }
        }
        return null;
    }

    public HsmState dsiNavigationTrExportTrailsResult(int n) {
        switch (n) {
            case 0: {
                this.target.getModelNotifier().setExportResultSuccess();
                break;
            }
            default: {
                this.target.getModelNotifier().setExportResultError();
            }
        }
        this.target.getModelNotifier().setImportStateIdle();
        this.target.getModelNotifier().setActionResultOk();
        return null;
    }

    public HsmState dsiNavigationTrImportTrailsResult(NavSegmentID[] navSegmentIDArray, int n) {
        switch (n) {
            case 0: {
                this.target.getModelNotifier().setImportResultSuccess();
                break;
            }
            case 2: 
            case 6: 
            case 7: {
                this.target.getModelNotifier().setImportResultMemFull();
                break;
            }
            default: {
                this.target.getModelNotifier().setImportResultError();
            }
        }
        this.target.getModelNotifier().setImportStateIdle();
        this.target.getModelNotifier().setActionResultOk();
        return null;
    }

    public void dsiNavigationUpdateRgActive(boolean bl, int n) {
        boolean bl2;
        boolean bl3 = bl2 = this.target.getDataPool().getExecutionMode() == 1;
        if (bl2 && bl) {
            this.trans(this.target.stateGuidance);
        }
    }

    public HsmState dsiNavigationAsyncException(int n, String string, int n2) {
        if (0 <= Arrays.binarySearch(WpmDsiNotifier.DSI_REQUEST_TYPES, n2)) {
            this.trans(this.target.stateDefault);
        }
        return null;
    }

    @Override
    public void handleFullFacotryReset() {
        this.target.getDsiNotifier().deleteAllTraces();
        WpmDataPool wpmDataPool = this.target.getDataPool();
        wpmDataPool.resetDefaults();
        WpmModelNotifier wpmModelNotifier = this.target.getModelNotifier();
        wpmModelNotifier.setExecutionMode(wpmDataPool.getExecutionMode());
        wpmModelNotifier.setSplitScreenContentDefaultMode(wpmDataPool.getSplitScreenCurrentContentDefault());
        wpmModelNotifier.setSplitScreenContentDriveRecordMode(wpmDataPool.getSplitScreenCurrentContentDriveRecord());
        wpmModelNotifier.setSplitScreenActive(wpmDataPool.getSplitScreenActive());
        this.fullFactoryResetParticipant.notifyResetDone();
    }
}

