/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.mainmap.duallistview;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.map.MapViewerUtils;
import de.vw.mib.asl.internal.navigation.map.mainmap.duallistview.DualListViewHsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;

public class DualListViewStateActive
extends AbstractHsmState {
    private static final int MINIMAL_ZOOM_LEVEL;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[DualListViewStateActive]");
    private final DualListViewHsmTarget target;
    private INavigationDP navigationDP;

    public DualListViewStateActive(DualListViewHsmTarget dualListViewHsmTarget, String string, HsmState hsmState) {
        super(dualListViewHsmTarget.getHsm(), string, hsmState);
        this.target = dualListViewHsmTarget;
        this.navigationDP = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
    }

    public HsmState dsiMapViewerControlConfigureFlags(long[] lArray) {
        this.logger.trace("dsiMapViewerControlConfigureFlags()");
        int[][] nArray = this.navigationDP.getVisibleLocationIDs();
        if (lArray != null && nArray != null && lArray.length == nArray.length) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                nArray[i2][1] = (int)lArray[i2];
            }
            this.navigationDP.storeVisibleLocationIDs(nArray);
        }
        return null;
    }

    private void configureMapFlags(int n, List list) {
        this.logger.trace("configureMapFlags()");
        MapFlag[] mapFlagArray = new MapFlag[list.size()];
        int n2 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            NavLocation navLocation = (NavLocation)iterator.next();
            int n3 = this.findMapFlagForIndexAndFlagType(n2, n);
            mapFlagArray[n2] = new MapFlag(navLocation.longitude, navLocation.latitude, n3, 0L);
            ++n2;
        }
        if (mapFlagArray != null && mapFlagArray.length != 0) {
            this.target.notifierDSI.configureFlagsAdd(mapFlagArray);
        }
    }

    private List configureViewPort(NavLocation[] navLocationArray) {
        this.logger.trace("configureViewPort()");
        int n = 128;
        int n2 = -129;
        int n3 = -129;
        int n4 = 128;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
            if (this.isNavLocationValid(navLocationArray[i2])) {
                if (this.logger.isTraceEnabled()) {
                    this.logger.makeTrace().append("visibleNavLocations[").append(i2).append("](long,lat)=").append(navLocationArray[i2].longitude).append(",").append(navLocationArray[i2].latitude).log();
                }
                if (navLocationArray[i2].latitude > n) {
                    n = navLocationArray[i2].latitude;
                }
                if (navLocationArray[i2].longitude > n4) {
                    n4 = navLocationArray[i2].longitude;
                }
                if (navLocationArray[i2].latitude < n3) {
                    n3 = navLocationArray[i2].latitude;
                }
                if (navLocationArray[i2].longitude < n2) {
                    n2 = navLocationArray[i2].longitude;
                }
                arrayList.add(navLocationArray[i2]);
                continue;
            }
            if (!this.logger.isTraceEnabled()) continue;
            this.logger.makeTrace().append("handleListViewUpdate() invalid navLocation at idx=").append(i2).log();
        }
        if (arrayList.size() == 0) {
            this.logger.warn("handleListViewUpdate() only null items found");
            return null;
        }
        if (arrayList.size() == 1) {
            this.logger.trace("handleListViewUpdate() only one valid item found");
            n4 = ((NavLocation)arrayList.get((int)0)).longitude;
            n2 = ((NavLocation)arrayList.get((int)0)).longitude;
            n3 = ((NavLocation)arrayList.get((int)0)).latitude;
            n = ((NavLocation)arrayList.get((int)0)).latitude;
        }
        NavLocation navLocation = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n, n2).getLocation();
        NavLocation navLocation2 = ASLNavigationUtilFactory.getNavigationUtilApi().getLocationWrapper(n3, n4).getLocation();
        this.target.datapool.setCornerLowerRight(navLocation2);
        this.target.datapool.setCornerUpperLeft(navLocation);
        this.target.notifierDSI.setMapViewPortByLD(navLocation, navLocation2, -1);
        return arrayList;
    }

    private int findMapFlagForIndexAndFlagType(int n, int n2) {
        this.logger.trace("findMapFlagForIndexAndFlagType");
        if (n2 == 1) {
            switch (n) {
                case 0: {
                    return 3;
                }
                case 1: {
                    return 4;
                }
                case 2: {
                    return 5;
                }
                case 3: {
                    return 6;
                }
                case 4: {
                    return 7;
                }
                case 5: {
                    return 8;
                }
            }
            return 2;
        }
        switch (n) {
            case 0: {
                return 71;
            }
            case 1: {
                return 72;
            }
            case 2: {
                return 73;
            }
            case 3: {
                return 74;
            }
            case 4: {
                return 75;
            }
            case 5: {
                return 76;
            }
        }
        return 90;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 3499005: {
                this.handleListViewUpdate(eventGeneric);
                break;
            }
            case 3499006: {
                this.handleListViewStartScroll(eventGeneric);
                break;
            }
            case 1074841826: {
                this.handleRestoreMap(eventGeneric);
                break;
            }
            case 1074841837: {
                this.handleSetClickInMap(eventGeneric);
                break;
            }
            case 1073742382: {
                this.handleSetContent(eventGeneric);
                break;
            }
            case 3499022: {
                this.handleGetInfoForScreenPositionResult(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleGetInfoForScreenPositionResult(EventGeneric eventGeneric) {
        int[][] nArray;
        this.logger.trace("handleGetInfoForScreenPositionResult()");
        PosInfo[] posInfoArray = (PosInfo[])eventGeneric.getObject(0);
        PosInfo posInfo = this.getFirstPoiInfo(posInfoArray);
        if (posInfo != null && (nArray = this.navigationDP.getVisibleLocationIDs()) != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2][1] != (int)posInfo.getObjectId()) continue;
                this.logger.trace(new StringBuffer().append("Clicked on Pin with ID:").append(nArray[i2][0]).toString());
                this.target.notifierModel.setLocationIDForClickedPin(nArray[i2][0]);
            }
        }
    }

    private PosInfo getFirstPoiInfo(PosInfo[] posInfoArray) {
        for (int i2 = 0; i2 < posInfoArray.length; ++i2) {
            if (posInfoArray[i2].eInfoType != 5) continue;
            return posInfoArray[i2];
        }
        return null;
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        this.target.sendEventGoToLocation(this.target.datapool.getContent());
        this.target.notifierDSI.viewFreeze(true);
        this.target.notifierDSI.setEnableSoftJump(false);
        this.target.notifierDSI.setMode(2);
        if (this.target.datapool.getViewType() != 0) {
            this.target.notifierDSI.setViewType(0);
        }
        if (this.target.datapool.getOrientation() != 2) {
            this.target.notifierDSI.setOrientation(2);
        }
        if (this.target.datapool.isGeneralPOIVisibility()) {
            this.target.datapool.setGeneralPOIVisibilityWasActive(true);
            this.target.notifierDSI.setGeneralPoiVisibility(false);
        }
        if (this.target.datapool.isShowTmcMessages() && this.target.datapool.getContent() != 36) {
            this.target.datapool.setShowTmcMessageWasActive(true);
            this.target.notifierDSI.setTMCVisibility(false);
        }
        this.target.notifierDSI.configureFlagsClear();
        this.target.notifierDSI.viewFreeze(false);
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.target.datapool.setCornerLowerRight(null);
        this.target.datapool.setCornerUpperLeft(null);
        this.target.notifierDSI.configureFlagsClear();
    }

    private void handleListViewStartScroll(EventGeneric eventGeneric) {
        this.logger.trace("handleListViewStartScroll()");
        List list = this.target.datapool.getFlagLocations();
        if (list == null || list.size() == 0) {
            return;
        }
        int n = this.target.datapool.getFlagType();
        int n2 = n == 1 ? 2 : 90;
        MapFlag[] mapFlagArray = new MapFlag[list.size()];
        int n3 = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            MapFlag mapFlag;
            NavLocation navLocation = (NavLocation)iterator.next();
            mapFlagArray[n3] = mapFlag = new MapFlag(navLocation.longitude, navLocation.latitude, n2, n3);
            ++n3;
        }
        this.target.notifierDSI.configureFlagsClear();
        this.target.notifierDSI.configureFlagsAdd(mapFlagArray);
    }

    private void handleListViewUpdate(EventGeneric eventGeneric) {
        List list;
        this.logger.trace("handleListViewUpdate()");
        NavLocation[] navLocationArray = (NavLocation[])eventGeneric.getObject(0);
        int n = eventGeneric.getInt(1);
        this.target.datapool.setFlagType(n);
        this.target.notifierDSI.configureFlagsClear();
        if (navLocationArray == null || navLocationArray.length == 0) {
            this.logger.trace("handleListViewUpdate() received with null or empty list");
            this.target.datapool.setFlagLocations(null);
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleListViewUpdate(visibleNavLocations.length=").append(navLocationArray.length).append(", flagType=").append(n).append(")").log();
        }
        if ((list = this.configureViewPort(navLocationArray)) == null) {
            this.logger.trace("handleListViewUpdate() no valid NavLocations found");
            return;
        }
        this.target.datapool.setFlagLocations(list);
        this.configureMapFlags(n, list);
        this.target.notifierModel.setMapReady();
    }

    private void handleRestoreMap(EventGeneric eventGeneric) {
        this.logger.trace("handleRestoreMap()");
        NavLocation navLocation = this.target.datapool.getCornerUpperLeft();
        NavLocation navLocation2 = this.target.datapool.getCornerLowerRight();
        if (navLocation != null && navLocation2 != null) {
            this.target.notifierDSI.setMapViewPortByLD(navLocation, navLocation2, -1);
        }
    }

    private void handleSetClickInMainMapDragged(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapDragged()");
        this.target.updateSelectedXandY(eventGeneric);
        this.target.transStateDragged();
    }

    private void handleSetClickInMainMapPressed(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapPressed()");
        this.target.updateSelectedXandY(eventGeneric);
    }

    private void handleSetClickInMainMapSelected(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMainMapSelected()");
        this.target.updateSelectedXandY(eventGeneric);
    }

    private void handleSetClickInMap(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMap()");
        int n = eventGeneric.getInt(0);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleSetClickInMap(), actionType=").append(n).log();
        }
        switch (n) {
            case 0: {
                this.handleSetClickInMainMapPressed(eventGeneric);
                break;
            }
            case 1: {
                this.handleSetClickInMainMapDragged(eventGeneric);
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                this.handleSetClickInMapClicked(eventGeneric);
                break;
            }
            case 4: {
                this.handleSetClickInMainMapSelected(eventGeneric);
                break;
            }
            default: {
                this.logger.trace("Unknown action type");
            }
        }
    }

    private void handleSetClickInMapClicked(EventGeneric eventGeneric) {
        this.logger.trace("handleSetClickInMapClicked()");
        this.target.updateSelectedXandY(eventGeneric);
        this.target.notifierDSI.getInfoForScreenPosition(this.target, new Point(this.target.datapool.getSelectedX(), this.target.datapool.getSelectedY()));
    }

    private void handleSetContent(EventGeneric eventGeneric) {
        int n = eventGeneric.getInt(0);
        this.target.datapool.setContent(n);
        if (n == 255) {
            this.logger.trace("handleSetContent(content = 255");
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(this.target.getTargetId(), 1598755840, 1608594176);
            eventGeneric2.setBoolean(0, false);
            this.target.send(eventGeneric2);
            this.target.transStateInactive();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        if (!this.target.datapool.isDragged()) {
            this.target.notifierDSI.configureFlagsClear();
        } else {
            this.target.datapool.setDragged(false);
        }
    }

    private boolean isNavLocationValid(NavLocation navLocation) {
        if (navLocation == null) {
            this.logger.trace("isNavLocationValid() - invalid, the navlocation is null");
            return false;
        }
        return MapViewerUtils.isPositionValid(navLocation.latitude, navLocation.longitude);
    }
}

