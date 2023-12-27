/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.INavigationDP;
import de.vw.mib.asl.internal.navigation.AbstractResettableAslHsmTarget;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconDescriptor;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.traffic.TrafficASLNotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficDSINotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficDataPool;
import de.vw.mib.asl.internal.navigation.traffic.TrafficEvents;
import de.vw.mib.asl.internal.navigation.traffic.TrafficLists;
import de.vw.mib.asl.internal.navigation.traffic.TrafficModelNotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficStateList;
import de.vw.mib.asl.internal.navigation.traffic.TrafficStateListReFetch;
import de.vw.mib.asl.internal.navigation.traffic.TrafficStateMain;
import de.vw.mib.asl.internal.navigation.traffic.TrafficStateMapInputMessageDetails;
import de.vw.mib.asl.internal.navigation.traffic.TrafficStateMapMessageDetails;
import de.vw.mib.asl.internal.navigation.traffic.TrafficStateMessageDetails;
import de.vw.mib.asl.internal.navigation.traffic.TrafficStateReRouteMessageDetails;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageIcon;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashMap;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public final class TrafficTargetHSM
extends AbstractResettableAslHsmTarget {
    private static final String EMPTY_STRING;
    private final IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficTargetHSM]");
    protected TrafficDSINotifier dsiNotifier;
    protected TrafficModelNotifier modelNotifier;
    protected TrafficStateList stateList;
    protected TrafficStateMain stateMain;
    protected TrafficStateMapMessageDetails stateMapMessageDetails;
    protected TrafficStateMessageDetails stateMessageDetails;
    protected TrafficStateReRouteMessageDetails stateReRouteMessageDetails;
    protected TrafficStateListReFetch stateListReFetch;
    protected TrafficStateMapInputMessageDetails stateMapInputMessageDetails;
    protected TrafficDataPool trafficDataPool;
    protected TrafficLists trafficLists;
    protected TrafficASLNotifier aslNotifier;
    protected INavigationDP navigationDataPool;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmc;
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRoute;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSTuner;

    public TrafficTargetHSM(GenericEvents genericEvents, int n, String string) {
        super(genericEvents, n, string);
        this.LOGGER.trace("TrafficTargetHSM");
        this.initLocalVariables();
    }

    TmcListElement createTmcListElementByEventText(TmcMessage tmcMessage) {
        this.LOGGER.trace("createTmcListElementByEventText()");
        TmcListElement tmcListElement = new TmcListElement();
        tmcListElement.streetSignId = tmcMessage.streetSignId;
        tmcListElement.message = tmcMessage;
        tmcListElement.type = 2;
        tmcListElement.description = tmcMessage.eventText[0];
        tmcListElement.hasChild = false;
        tmcListElement.uID = tmcMessage.messageID;
        tmcListElement.parentID = 0L;
        tmcListElement.numberOfMessagesInNode = 0;
        tmcListElement.positionInCompleteList = 1;
        tmcListElement.directionOfRoad1 = tmcMessage.directionOfRoad1;
        tmcListElement.directionOfRoad2 = tmcMessage.directionOfRoad2;
        tmcListElement.isBidirectional = tmcMessage.isBidirectional;
        tmcListElement.roadName = tmcMessage.roadName;
        tmcListElement.roadNumber = tmcMessage.roadNumber;
        return tmcListElement;
    }

    TmcListElement createTmcListElementByRoadName(TmcMessage tmcMessage) {
        this.LOGGER.trace("createTmcListElementByRoadName()");
        TmcListElement tmcListElement = new TmcListElement();
        tmcListElement.streetSignId = tmcMessage.streetSignId;
        tmcListElement.message = tmcMessage;
        tmcListElement.type = 2;
        tmcListElement.description = tmcMessage.roadName == null ? "" : tmcMessage.roadName;
        tmcListElement.hasChild = false;
        tmcListElement.uID = tmcMessage.messageID;
        tmcListElement.parentID = 0L;
        tmcListElement.numberOfMessagesInNode = 0;
        tmcListElement.positionInCompleteList = 0;
        tmcListElement.directionOfRoad1 = tmcMessage.directionOfRoad1 == null ? "" : tmcMessage.directionOfRoad1;
        tmcListElement.directionOfRoad2 = tmcMessage.directionOfRoad2 == null ? "" : tmcMessage.directionOfRoad2;
        tmcListElement.isBidirectional = tmcMessage.isBidirectional;
        tmcListElement.roadName = tmcMessage.roadName == null ? "" : tmcMessage.roadName;
        tmcListElement.roadNumber = tmcMessage.roadNumber == null ? "" : tmcMessage.roadNumber;
        return tmcListElement;
    }

    TmcListElement createTmcListElementByRoadNamenAndIndex(TmcMessage tmcMessage, int n) {
        this.LOGGER.trace("createTmcListElementByRoadNamenAndIndex()");
        TmcListElement tmcListElement = new TmcListElement();
        tmcListElement.streetSignId = tmcMessage.streetSignId;
        tmcListElement.message = tmcMessage;
        tmcListElement.type = 2;
        tmcListElement.description = tmcMessage.roadName == null ? "" : tmcMessage.roadName;
        tmcListElement.hasChild = false;
        tmcListElement.uID = tmcMessage.messageID;
        tmcListElement.parentID = 0L;
        tmcListElement.numberOfMessagesInNode = 0;
        tmcListElement.positionInCompleteList = n;
        tmcListElement.directionOfRoad1 = tmcMessage.directionOfRoad1 == null ? "" : tmcMessage.directionOfRoad1;
        tmcListElement.directionOfRoad2 = tmcMessage.directionOfRoad2 == null ? "" : tmcMessage.directionOfRoad2;
        tmcListElement.isBidirectional = tmcMessage.isBidirectional;
        tmcListElement.roadName = tmcMessage.roadName == null ? "" : tmcMessage.roadName;
        tmcListElement.roadNumber = tmcMessage.roadNumber == null ? "" : tmcMessage.roadNumber;
        return tmcListElement;
    }

    @Override
    protected HsmState getDefaultState() {
        return this.stateMain;
    }

    public static boolean isMessageOnRoute(TmcMessage tmcMessage) {
        return tmcMessage.routeRelevance == 0;
    }

    void setMessageFilter(EventGeneric eventGeneric) {
        this.LOGGER.trace("setMessageFilter()");
        if (eventGeneric == null) {
            this.LOGGER.error("(event == null)!");
            return;
        }
        try {
            int n = eventGeneric.getInt(0);
            this.trafficDataPool.setCurrentMessageFilter(n);
            this.activeCurrentMessageFilterOnSouthside(n);
        }
        catch (Exception exception) {
            this.LOGGER.error(exception.toString());
        }
    }

    protected void activeCurrentMessageFilterOnSouthside(int n) {
        if (n == 0) {
            this.dsiNotifier.notifySetMessageFilterAll();
        } else if (n == 1) {
            this.dsiNotifier.notifySetMessageFilterOnRoad();
        } else if (n == 2) {
            this.LOGGER.trace("setMessageFilter() mapclick");
        } else if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeWarn().append("setMessageFilter() UNKNOWN FILTER, val=").append(n).log();
        }
    }

    void setPositionInCompleteListForSubList(TmcListElement[] tmcListElementArray, int n) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("setPositionInCompleteListForSubList(), parentPositionInCompleteList=").append(n).log();
        }
        if (tmcListElementArray == null) {
            this.LOGGER.trace("tmcListElements == null");
            return;
        }
        for (int i2 = 0; i2 < tmcListElementArray.length; ++i2) {
            if (tmcListElementArray[i2] == null) {
                if (!this.LOGGER.isTraceEnabled()) continue;
                this.LOGGER.makeTrace().append("tmcListElements[").append(i2).append("] == null").log();
                continue;
            }
            tmcListElementArray[i2].positionInCompleteList = n + i2;
        }
    }

    void stopTimerForRequestTmcMessage() {
        this.LOGGER.trace("stopTimerForRequestTmcMessage()");
        this.stopTimer(176619776);
    }

    void startTimerForRequestTmcMessage() {
        this.LOGGER.trace("startTimerForRequestTmcMessage()");
        this.startTimer(176619776, (long)0, false);
    }

    void startTimerForListLoadPopUp() {
        this.LOGGER.trace("startTimerForListLoadPopUp()");
        this.startTimer(193396992, (long)0, false);
        this.trafficDataPool.setPopUpTimerRunning(true);
    }

    ResourceLocator getResourceLocatorForTMCEventIcon(TmcListElement tmcListElement, TrafficMessageIcon trafficMessageIcon, CacheClient cacheClient) {
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("getResourceLocatorForTMCEventIcon() Relevance=").append(tmcListElement.message.getRouteRelevance()).append(", iconListId[0]=").append(tmcListElement.message.iconListId[0]).log();
        }
        if (this.navigationDataPool.getRGIsActive()) {
            switch (tmcListElement.message.getRouteRelevance()) {
                case 0: {
                    return ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTMCEventIcon(tmcListElement.message.iconListId[0], 0, 1, cacheClient, trafficMessageIcon);
                }
                case 2: {
                    return ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTMCEventIcon(tmcListElement.message.iconListId[0], 2, 1, cacheClient, trafficMessageIcon);
                }
                case 3: {
                    return ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTMCEventIcon(tmcListElement.message.iconListId[0], 3, 1, cacheClient, trafficMessageIcon);
                }
            }
            return ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTMCEventIcon(tmcListElement.message.iconListId[0], 1, 1, cacheClient, trafficMessageIcon);
        }
        return ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForTMCEventIcon(tmcListElement.message.iconListId[0], 0, 1, cacheClient, trafficMessageIcon);
    }

    void handleIconUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        TrafficMessageIcon trafficMessageIcon = (TrafficMessageIcon)object;
        if (resourceLocator == null || resourceLocator.id == -1 && resourceLocator.url == null) {
            this.LOGGER.trace("handleIconUpdate() RL is not valid, NOT updating!");
            return;
        }
        if (this.LOGGER.isTraceEnabled()) {
            this.LOGGER.makeTrace().append("handleIconUpdate() uID=").append(trafficMessageIcon.tmcElement_uID).append(", rLocator.url=").append(resourceLocator.url).append(", rLocator.id=").append(resourceLocator.id).log();
        }
        if (trafficMessageIcon.isRoadIconDescriptor) {
            TextRenderingInfo textRenderingInfo = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().getTextRenderingInfo(iconKey);
            if (textRenderingInfo != null) {
                if (this.LOGGER.isTraceEnabled()) {
                    this.LOGGER.makeTrace().append("handleIconUpdate() TextRenderingInfo=").append(textRenderingInfo.toString()).log();
                }
                trafficMessageIcon.roadIconDescriptor = new IconDescriptor(resourceLocator, textRenderingInfo);
            } else {
                this.LOGGER.trace("handleIconUpdate() TextRenderingInfo=null");
                trafficMessageIcon.iconDescriptor = new IconDescriptor(resourceLocator, new TextRenderingInfo());
            }
        } else {
            trafficMessageIcon.iconDescriptor = new IconDescriptor(resourceLocator, new TextRenderingInfo());
        }
        this.trafficLists.insertResourceLocatorIntoOverviewList(trafficMessageIcon);
    }

    @Override
    public void reset(HashMap hashMap) {
        boolean bl = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmc == null ? (class$org$dsi$ifc$tmc$DSITmc = TrafficTargetHSM.class$("org.dsi.ifc.tmc.DSITmc")) : class$org$dsi$ifc$tmc$DSITmc).getName(), 0);
        boolean bl2 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$tmc$DSITmcOnRoute == null ? (class$org$dsi$ifc$tmc$DSITmcOnRoute = TrafficTargetHSM.class$("org.dsi.ifc.tmc.DSITmcOnRoute")) : class$org$dsi$ifc$tmc$DSITmcOnRoute).getName(), 0);
        boolean bl3 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = TrafficTargetHSM.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation).getName(), 0);
        boolean bl4 = this.isDsiInHashMap(hashMap, (class$org$dsi$ifc$sdars$DSISDARSTuner == null ? (class$org$dsi$ifc$sdars$DSISDARSTuner = TrafficTargetHSM.class$("org.dsi.ifc.sdars.DSISDARSTuner")) : class$org$dsi$ifc$sdars$DSISDARSTuner).getName(), 0);
        if (bl || bl2 || bl3 || bl4) {
            if (this.isTraceEnabled()) {
                this.trace("TrafficTargetHSM: resetting values after DSI restart");
            }
            this.resetHsmToState(this.stateMain);
            if (bl) {
                TrafficEvents.initDsiTMC();
            }
            if (bl2) {
                TrafficEvents.initDsiTMCOnRoute();
            }
            if (bl3) {
                TrafficEvents.initDsiNavigation();
            }
            if (bl4) {
                TrafficEvents.initSDARS();
            }
        } else if (this.isTraceEnabled()) {
            this.trace("TrafficTargetHSM: no reset necessary because restarted DSI(s) is/are not used in target");
        }
    }

    private void initLocalVariables() {
        this.modelNotifier = new TrafficModelNotifier(this);
        this.trafficDataPool = new TrafficDataPool();
        this.trafficLists = new TrafficLists(this);
        this.aslNotifier = new TrafficASLNotifier(this);
        this.dsiNotifier = new TrafficDSINotifier(this);
        this.navigationDataPool = ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp();
        this.stateMain = new TrafficStateMain(this, this.hsm, "stateMain", this.getWorkStateParent());
        this.stateList = new TrafficStateList(this, this.hsm, "stateList", this.stateMain);
        this.stateMapMessageDetails = new TrafficStateMapMessageDetails(this, this.hsm, "stateMapMessageDetails", this.stateMain);
        this.stateMessageDetails = new TrafficStateMessageDetails(this, this.hsm, "stateMessageDetails", this.stateList);
        this.stateReRouteMessageDetails = new TrafficStateReRouteMessageDetails(this, this.hsm, "stateReRouteMessageDetails", this.stateMain);
        this.stateListReFetch = new TrafficStateListReFetch(this, this.hsm, "stateListReFetch", this.stateMain);
        this.stateMapInputMessageDetails = new TrafficStateMapInputMessageDetails(this, this.hsm, "stateMapInputMessageDetails", this.stateMain);
        this.modelNotifier.notifyTmcMessageSource(0);
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

