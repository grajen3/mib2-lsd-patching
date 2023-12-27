/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.splitscreen.ASLManeuverViewElement;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.internal.navigation.maneuverviewtenitems.transformer.NavigationManeuverViewDataTenItemsCollector;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitscreenInternalAPINotifier;
import de.vw.mib.asl.internal.navigation.splitscreen.Target10Plus0Box;
import java.util.LinkedList;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class Handler2Plus0CHNJPN {
    private NavigationManeuverViewDataTenItemsCollector[] elementList2Plus0 = new NavigationManeuverViewDataTenItemsCollector[0];
    public static final int MAX_LIST_SIZE;
    private TurnListElement[] turnList = new TurnListElement[0];
    private TmcMessage[] tmcList = new TmcMessage[0];
    Target10Plus0Box target = null;
    SplitscreenInternalAPINotifier internalAPINotifier;

    public Handler2Plus0CHNJPN(Target10Plus0Box target10Plus0Box) {
        this.target = target10Plus0Box;
    }

    public void disposeAndRefreshTurnListElements2Plus0List() {
        if (this.elementList2Plus0 != null) {
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < this.elementList2Plus0.length; ++i2) {
                if (this.elementList2Plus0[i2].type != 13) continue;
                linkedList.add(this.elementList2Plus0[i2]);
            }
            this.elementList2Plus0 = (NavigationManeuverViewDataTenItemsCollector[])linkedList.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
            this.updateTurnListElements();
            this.updateInternalAPI(this.elementList2Plus0);
        }
    }

    private void updateTurnListElements() {
        int n;
        LinkedList linkedList = new LinkedList();
        for (n = 0; n < this.turnList.length && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(this.turnList[n]); ++n) {
        }
        int n2 = this.elementList2Plus0.length - 1;
        while ((n2 >= 0 || n < this.turnList.length) && linkedList.size() < 2) {
            if (n >= this.turnList.length) {
                linkedList.addFirst(this.elementList2Plus0[n2]);
                --n2;
                continue;
            }
            if (n2 < 0 || ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.turnList[n]) < ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList2Plus0[n2].distanceToNextDestination, this.elementList2Plus0[n2].destinationIndex)) {
                NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = this.target.createManeuverListElement(this.turnList[n]);
                if (navigationManeuverViewDataTenItemsCollector.type != 255) {
                    linkedList.addFirst(navigationManeuverViewDataTenItemsCollector);
                }
                ++n;
                continue;
            }
            if (this.elementList2Plus0[n2].type != 13 && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.turnList[n]) == ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList2Plus0[n2].distanceToNextDestination, this.elementList2Plus0[n2].destinationIndex)) {
                ++n;
            }
            linkedList.addFirst(this.elementList2Plus0[n2]);
            --n2;
        }
        this.elementList2Plus0 = (NavigationManeuverViewDataTenItemsCollector[])linkedList.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
    }

    public void disposeAndRefreshTMCElements2Plus0List() {
        if (this.elementList2Plus0 != null) {
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < this.elementList2Plus0.length; ++i2) {
                if (this.elementList2Plus0[i2].type == 13) continue;
                linkedList.add(this.elementList2Plus0[i2]);
            }
            this.elementList2Plus0 = (NavigationManeuverViewDataTenItemsCollector[])linkedList.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
            this.updateTMCElements();
            this.ensureManeuverExistenceInList();
            this.updateInternalAPI(this.elementList2Plus0);
        }
    }

    private void ensureManeuverExistenceInList() {
        this.target.traceState("Handler2+0: ensureManeuverExistenceInList");
        if (!this.isManeuverElementInList()) {
            this.target.traceState("Handler2+0: No maneuver in list found.");
            if (this.elementList2Plus0 != null && this.elementList2Plus0.length > 0 && this.turnList != null && this.turnList.length > 0) {
                boolean bl = false;
                for (int i2 = 0; i2 < this.turnList.length && !bl; ++i2) {
                    NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = this.target.createManeuverListElement(this.turnList[i2]);
                    if (navigationManeuverViewDataTenItemsCollector.type == 255) continue;
                    this.elementList2Plus0[0] = navigationManeuverViewDataTenItemsCollector;
                    this.target.traceState(new StringBuffer().append("Handler2+0: Turnlist element No. ").append(i2).append(" added maneuver to list.").toString());
                    bl = true;
                }
                if (!bl) {
                    this.target.traceState("Handler2+0: No turnlist could be added maneuver to list.");
                }
            }
        }
    }

    private boolean isManeuverElementInList() {
        this.target.traceState("Handler2+0: isManeuverElementInList");
        if (this.elementList2Plus0 != null) {
            for (int i2 = 0; i2 < this.elementList2Plus0.length; ++i2) {
                if (this.elementList2Plus0[i2].type == 13 || this.elementList2Plus0[i2].type == 255) continue;
                return true;
            }
        }
        return false;
    }

    private void updateTMCElements() {
        int n;
        LinkedList linkedList = new LinkedList();
        for (n = 0; n < this.tmcList.length && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(this.tmcList[n]); ++n) {
        }
        int n2 = this.elementList2Plus0.length - 1;
        while ((n2 >= 0 || n < this.tmcList.length) && linkedList.size() < 2) {
            if (n >= this.tmcList.length) {
                linkedList.addFirst(this.elementList2Plus0[n2]);
                --n2;
                continue;
            }
            if (n2 < 0 || ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.tmcList[n]) < ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList2Plus0[n2].distanceToNextDestination, this.elementList2Plus0[n2].destinationIndex)) {
                NavigationManeuverViewDataTenItemsCollector navigationManeuverViewDataTenItemsCollector = this.target.createManeuverListElement(this.tmcList[n]);
                linkedList.addFirst(navigationManeuverViewDataTenItemsCollector);
                ++n;
                continue;
            }
            if (this.elementList2Plus0[n2].type == 13 && ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.tmcList[n]) == ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList2Plus0[n2].distanceToNextDestination, this.elementList2Plus0[n2].destinationIndex)) {
                ++n;
            }
            linkedList.addFirst(this.elementList2Plus0[n2]);
            --n2;
        }
        this.elementList2Plus0 = (NavigationManeuverViewDataTenItemsCollector[])linkedList.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
    }

    public void updateCurrentTurnList(TurnListElement[] turnListElementArray) {
        this.turnList = turnListElementArray;
    }

    public void updateCurrentTMCList(TmcMessage[] tmcMessageArray) {
        this.tmcList = tmcMessageArray;
    }

    private void updateTimeAndDistance() {
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < this.elementList2Plus0.length; ++i2) {
            if (ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().isAlreadyPassed(this.elementList2Plus0[i2].destinationIndex, this.elementList2Plus0[i2].distanceToNextDestination)) continue;
            this.elementList2Plus0[i2].dtm = (int)ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getDistanceToRouteElement(this.elementList2Plus0[i2].distanceToNextDestination, this.elementList2Plus0[i2].destinationIndex);
            if (this.elementList2Plus0[i2].type != 13) {
                int[] nArray = ASLNavigationUtilFactory.getNavigationUtilApi().getNaviHelper().getRttHMToRouteElement(this.elementList2Plus0[i2].rtt * 0, this.elementList2Plus0[i2].destinationIndex);
                this.elementList2Plus0[i2].rtth = nArray[0];
                this.elementList2Plus0[i2].rttm = nArray[1];
            }
            linkedList.add(this.elementList2Plus0[i2]);
        }
        this.elementList2Plus0 = (NavigationManeuverViewDataTenItemsCollector[])linkedList.toArray(new NavigationManeuverViewDataTenItemsCollector[0]);
    }

    public void updateAllLists() {
        this.updateTimeAndDistance();
        this.updateTurnListElements();
        this.updateTMCElements();
        this.ensureManeuverExistenceInList();
        this.updateInternalAPI(this.elementList2Plus0);
    }

    private void updateInternalAPI(NavigationManeuverViewDataTenItemsCollector[] navigationManeuverViewDataTenItemsCollectorArray) {
        if (navigationManeuverViewDataTenItemsCollectorArray != null) {
            ASLManeuverViewElement[] aSLManeuverViewElementArray = new ASLManeuverViewElement[navigationManeuverViewDataTenItemsCollectorArray.length];
            for (int i2 = 0; i2 < aSLManeuverViewElementArray.length; ++i2) {
                aSLManeuverViewElementArray[i2] = new ASLManeuverViewElement();
                aSLManeuverViewElementArray[i2].setDestinationIndex(navigationManeuverViewDataTenItemsCollectorArray[i2].destinationIndex);
                aSLManeuverViewElementArray[i2].setDirection(navigationManeuverViewDataTenItemsCollectorArray[i2].direction);
                aSLManeuverViewElementArray[i2].setDistanceToNextDestination(navigationManeuverViewDataTenItemsCollectorArray[i2].distanceToNextDestination);
                aSLManeuverViewElementArray[i2].setDtm(navigationManeuverViewDataTenItemsCollectorArray[i2].dtm);
                aSLManeuverViewElementArray[i2].setMainElement(navigationManeuverViewDataTenItemsCollectorArray[i2].mainElement);
                aSLManeuverViewElementArray[i2].setName(navigationManeuverViewDataTenItemsCollectorArray[i2].name);
                aSLManeuverViewElementArray[i2].setNumberOfPoiIcons(navigationManeuverViewDataTenItemsCollectorArray[i2].numberOfPoiIcons);
                aSLManeuverViewElementArray[i2].setPoiIcons(navigationManeuverViewDataTenItemsCollectorArray[i2].poiIcons);
                aSLManeuverViewElementArray[i2].setPoiNavLocation(navigationManeuverViewDataTenItemsCollectorArray[i2].poiNavLocation);
                aSLManeuverViewElementArray[i2].setRtt(navigationManeuverViewDataTenItemsCollectorArray[i2].rtt);
                aSLManeuverViewElementArray[i2].setRtth(navigationManeuverViewDataTenItemsCollectorArray[i2].rtth);
                aSLManeuverViewElementArray[i2].setRttm(navigationManeuverViewDataTenItemsCollectorArray[i2].rttm);
                aSLManeuverViewElementArray[i2].setSignPost(navigationManeuverViewDataTenItemsCollectorArray[i2].signPost);
                aSLManeuverViewElementArray[i2].setTmcEndLocation(navigationManeuverViewDataTenItemsCollectorArray[i2].tmcEndLocation);
                aSLManeuverViewElementArray[i2].setTmcListIcon(navigationManeuverViewDataTenItemsCollectorArray[i2].tmcListIcon);
                aSLManeuverViewElementArray[i2].setTmcMessageID(navigationManeuverViewDataTenItemsCollectorArray[i2].messageID);
                aSLManeuverViewElementArray[i2].setTmcMessageText(navigationManeuverViewDataTenItemsCollectorArray[i2].tmcMessageText);
                aSLManeuverViewElementArray[i2].setTmcRoadName(navigationManeuverViewDataTenItemsCollectorArray[i2].tmcRoadName);
                aSLManeuverViewElementArray[i2].setTmcStartLocation(navigationManeuverViewDataTenItemsCollectorArray[i2].tmcStartLocation);
                aSLManeuverViewElementArray[i2].setType(navigationManeuverViewDataTenItemsCollectorArray[i2].type);
                aSLManeuverViewElementArray[i2].setTmcRoadNumber(navigationManeuverViewDataTenItemsCollectorArray[i2].tmcRoadNumber);
                aSLManeuverViewElementArray[i2].setExitNumber(navigationManeuverViewDataTenItemsCollectorArray[i2].exitNumber);
                aSLManeuverViewElementArray[i2].setAddress(navigationManeuverViewDataTenItemsCollectorArray[i2].address);
                aSLManeuverViewElementArray[i2].setTmcDelay(navigationManeuverViewDataTenItemsCollectorArray[i2].tmcDelay);
                aSLManeuverViewElementArray[i2].setTollGateDirections(navigationManeuverViewDataTenItemsCollectorArray[i2].tollGateDirections);
                aSLManeuverViewElementArray[i2].setTollGateInfos(navigationManeuverViewDataTenItemsCollectorArray[i2].tollGateInfos);
                aSLManeuverViewElementArray[i2].setTollGateMarkingsLeft(navigationManeuverViewDataTenItemsCollectorArray[i2].tollGateMarkingsLeft);
                aSLManeuverViewElementArray[i2].setTollGateMarkingsRight(navigationManeuverViewDataTenItemsCollectorArray[i2].tollGateMarkingsRight);
                aSLManeuverViewElementArray[i2].setColorIndicatorIcon(navigationManeuverViewDataTenItemsCollectorArray[i2].colorIndicatorIcon);
                aSLManeuverViewElementArray[i2].setTrafficLightIcon(navigationManeuverViewDataTenItemsCollectorArray[i2].trafficLightIcon);
                aSLManeuverViewElementArray[i2].setTrafficLightIconVisibility(navigationManeuverViewDataTenItemsCollectorArray[i2].trafficLightIconVisibility);
                aSLManeuverViewElementArray[i2].setLaneDirections(navigationManeuverViewDataTenItemsCollectorArray[i2].laneDirections);
                aSLManeuverViewElementArray[i2].setLaneInfos(navigationManeuverViewDataTenItemsCollectorArray[i2].laneInfos);
                aSLManeuverViewElementArray[i2].setLaneMarkingsLeft(navigationManeuverViewDataTenItemsCollectorArray[i2].laneMarkingsLeft);
                aSLManeuverViewElementArray[i2].setLaneMarkingsRight(navigationManeuverViewDataTenItemsCollectorArray[i2].laneMarkingsRight);
                aSLManeuverViewElementArray[i2].setRoadSignLabeledIcon(navigationManeuverViewDataTenItemsCollectorArray[i2].roadSignLabeledIcon);
                aSLManeuverViewElementArray[i2].setTollGateCost(navigationManeuverViewDataTenItemsCollectorArray[i2].tollGateCost);
                aSLManeuverViewElementArray[i2].setTollGateCostCurrency(navigationManeuverViewDataTenItemsCollectorArray[i2].tollGateCostCurrency);
                aSLManeuverViewElementArray[i2].setLength(navigationManeuverViewDataTenItemsCollectorArray[i2].length);
                aSLManeuverViewElementArray[i2].setStopoverFlagIcon(navigationManeuverViewDataTenItemsCollectorArray[i2].stopoverFlagIcon);
                aSLManeuverViewElementArray[i2].setFixFormatterFieldForAddressData(navigationManeuverViewDataTenItemsCollectorArray[i2].fixFormatterFieldForAddressData);
            }
            this.sendUpdateTo2Plus0(aSLManeuverViewElementArray);
        }
    }

    public SplitscreenInternalAPINotifier getInternalAPINotifier() {
        return this.internalAPINotifier;
    }

    public void setInternalAPINotifier(SplitscreenInternalAPINotifier splitscreenInternalAPINotifier) {
        this.internalAPINotifier = splitscreenInternalAPINotifier;
    }

    private void sendUpdateTo2Plus0(ASLManeuverViewElement[] aSLManeuverViewElementArray) {
        this.target.traceState("Handler2+0: sendEventTo2Plus0");
        for (int i2 = 0; i2 < aSLManeuverViewElementArray.length; ++i2) {
            this.target.traceState(new StringBuffer("2+0 Element: ").append(i2).append(" :").append(aSLManeuverViewElementArray[i2].toString()).toString());
        }
        this.internalAPINotifier.sendEvSplitScreen10Plus0ContentUpdate(aSLManeuverViewElementArray);
    }
}

