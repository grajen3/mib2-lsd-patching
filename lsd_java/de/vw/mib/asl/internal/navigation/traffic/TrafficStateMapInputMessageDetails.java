/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.traffic.TrafficMessageDetails;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconDescriptor;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.traffic.TrafficASLNotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficDSINotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficDataPool;
import de.vw.mib.asl.internal.navigation.traffic.TrafficLists;
import de.vw.mib.asl.internal.navigation.traffic.TrafficModelNotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageCollector;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageIcon;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import generated.de.vw.mib.asl.internal.navigation.traffic.transformer.NavigationTrafficTMCMessageDetailCollector;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class TrafficStateMapInputMessageDetails
extends AbstractHsmState
implements ASLListElementFetcher,
CacheClient {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficStateMapInputMessageDetails]");
    private final TrafficTargetHSM target;
    private final TrafficDSINotifier dsiNotifier;
    private final TrafficLists trafficLists;
    private final TrafficModelNotifier modelNotifier;
    private final TrafficASLNotifier aslNotifier;
    private final TrafficDataPool trafficDataPool;

    public TrafficStateMapInputMessageDetails(TrafficTargetHSM trafficTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = trafficTargetHSM;
        this.dsiNotifier = trafficTargetHSM.dsiNotifier;
        this.trafficLists = trafficTargetHSM.trafficLists;
        this.modelNotifier = trafficTargetHSM.modelNotifier;
        this.aslNotifier = trafficTargetHSM.aslNotifier;
        this.trafficDataPool = trafficTargetHSM.trafficDataPool;
    }

    public void dsiTmcOnRouteTmcMessage(TmcMessage tmcMessage) {
        this.logger.trace("dsiTmcOnRouteTmcMessage()");
        this.target.stopTimerForRequestTmcMessage();
        GenericASLList genericASLList = this.trafficLists.getTmcOverviewList();
        GenericASLList genericASLList2 = this.trafficLists.getTmcMessageDetailList();
        if (tmcMessage == null || genericASLList == null || genericASLList2 == null) {
            block3: {
                this.logger.warn("dsiTmcOnRouteTmcMessage() (null == tmcMessage) || (null == tmcOverviewList) || (null == tmcDetailList)!");
                try {
                    this.target.stateMain.transStateMain();
                }
                catch (Exception exception) {
                    if (!this.logger.isTraceEnabled()) break block3;
                    this.logger.makeTrace().append("dsiTmcOnRouteTmcMessage()").append(exception.toString()).log();
                }
            }
            return;
        }
        TmcListElement tmcListElement = this.target.createTmcListElementByEventText(tmcMessage);
        Object[] objectArray = new TrafficMessageCollector[]{new TrafficMessageCollector(tmcListElement, this.getTmcIcon(tmcListElement), 0)};
        boolean bl = TrafficTargetHSM.isMessageOnRoute(tmcMessage);
        this.trafficLists.updateTrafficMessageDetails(tmcListElement, this.getTmcIcon(tmcListElement), bl, (int)tmcMessage.messageID);
        genericASLList.setSize(1);
        genericASLList.updateListItems(0, objectArray);
        this.logger.trace("notify HMI");
        this.modelNotifier.notifyClickedObjectTmcTrue();
        this.modelNotifier.notifyClickedPoiOrTmcIcon();
        this.modelNotifier.notifyTmcMessageAllCount(1);
        this.modelNotifier.notifyTmcMessageIndex(1);
        this.notifyModelWithNewTmcMessageName(tmcMessage);
        this.aslNotifier.notifyMapViewerShowTmcMessageInMap(new TrafficMessageDetails(tmcMessage));
    }

    private void notifyModelWithNewTmcMessageName(TmcMessage tmcMessage) {
        if (tmcMessage != null && tmcMessage.eventText != null && tmcMessage.eventText.length > 0) {
            this.modelNotifier.notifyTmcMessageNameJP(tmcMessage.eventText[0]);
        } else {
            ServiceManager.logger.warn(16, "TmcMessage was null or evenText was empty or null!");
        }
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        this.logger.trace("fetchItems() - DO NOTHING ");
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.logger.trace("fetchNextPage() - DO NOTHING ");
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.logger.trace("fetchPreviousPage() - DO NOTHING ");
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        this.logger.trace("getDefaultIcon()");
        return new ResourceLocator();
    }

    public TrafficMessageIcon getTmcIcon(TmcListElement tmcListElement) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getTmcIcon() uID=").append(tmcListElement.uID).append(", streetSignId=").append(tmcListElement.streetSignId).log();
        }
        TrafficMessageIcon trafficMessageIcon = new TrafficMessageIcon(tmcListElement.uID, false);
        if (tmcListElement.message.iconListId != null && tmcListElement.message.iconListId.length > 0) {
            ResourceLocator resourceLocator = this.target.getResourceLocatorForTMCEventIcon(tmcListElement, trafficMessageIcon, this);
            trafficMessageIcon.iconDescriptor = new IconDescriptor(resourceLocator, new TextRenderingInfo());
        } else if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getTmcIcon() uID=").append(tmcListElement.uID).append(", invalid iconList").log();
        }
        return trafficMessageIcon;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry(eventGeneric);
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
            case 100106: {
                this.handleEvNavigationTmcTrafficTimerOutForRequestTmcMessage();
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
        this.logger.trace("handleDefault()");
    }

    private void handleEntry(EventGeneric eventGeneric) {
        this.logger.trace("handleEntry()");
        this.trafficDataPool.resetTrafficMessageInfoCurrent();
        GenericASLList genericASLList = this.trafficLists.getTmcOverviewList();
        if (genericASLList == null) {
            this.logger.error("tmcOverviewList == null !");
            return;
        }
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 1, 0);
        genericASLList.setMaxFetchTries(1);
        genericASLList.setFetchTimeout(0);
        genericASLList.setColumn4ObjectId(99);
    }

    private void handleEvNavigationTmcTrafficTimerOutForRequestTmcMessage() {
        this.logger.trace("handleEvNavigationTmcTrafficTimerOutForRequestTmcMessage()");
        this.target.stateMain.transStateMain();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.trafficLists.resetOverviewList();
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        TrafficMessageIcon trafficMessageIcon = (TrafficMessageIcon)object;
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleIconCacheUpdate() uID=").append(trafficMessageIcon.tmcElement_uID).append(", rLocator.url=").append(resourceLocator.url).append(", rLocator.id=").append(resourceLocator.id).log();
        }
        NavigationTrafficTMCMessageDetailCollector navigationTrafficTMCMessageDetailCollector = this.trafficLists.getTrafficMessageDetailCollector();
        navigationTrafficTMCMessageDetailCollector.navigation_traffic_tmc_message_detail_icon = resourceLocator;
        this.trafficLists.getTmcMessageDetailList().updateListItem(0, navigationTrafficTMCMessageDetailCollector);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        EventGeneric eventGeneric = this.target.getHsm().getExternalEvent();
        if (eventGeneric.getReceiverEventId() == 1138832128) {
            this.requestTmcMessageDetails(eventGeneric);
        } else {
            this.target.stateMain.transStateMain();
        }
    }

    private void requestTmcMessageDetails(EventGeneric eventGeneric) {
        try {
            long l = eventGeneric.getLong(0);
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("requestTmcMessageDetails() tmcId=").append(l).log();
            }
            if (l < Integer.MIN_VALUE || l > 0) {
                this.logger.makeError().append("messageId=").append(l).append(", out of range").log();
                this.target.stateMain.transStateMain();
            } else {
                this.dsiNotifier.notifyGetTmcMessage((int)l);
                this.target.startTimerForRequestTmcMessage();
            }
        }
        catch (GenericEventException genericEventException) {
            if (this.logger.isTraceEnabled()) {
                this.logger.makeError().append("requestTmcMessageDetails()").append(genericEventException.toString()).log();
            }
            this.target.stateMain.transStateMain();
        }
    }
}

