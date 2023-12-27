/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.traffic.TrafficMessageDetails;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.list.ASLCachedWindowList;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
import de.vw.mib.asl.internal.navigation.caching.IconDescriptor;
import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.traffic.TrafficASLNotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficDataPool;
import de.vw.mib.asl.internal.navigation.traffic.TrafficLists;
import de.vw.mib.asl.internal.navigation.traffic.TrafficMessageInfo;
import de.vw.mib.asl.internal.navigation.traffic.TrafficModelNotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageCollector;
import de.vw.mib.asl.internal.navigation.traffic.transformer.TrafficMessageIcon;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class TrafficStateReRouteMessageDetails
extends AbstractHsmState
implements ASLListElementFetcher,
CacheClient {
    private final IExtLogger logger;
    private final TrafficTargetHSM target;
    private final TrafficLists trafficLists;
    private final TrafficModelNotifier modelNotifier;
    private final TrafficASLNotifier aslNotifier;
    private final TrafficDataPool trafficDataPool;

    public TrafficStateReRouteMessageDetails(TrafficTargetHSM trafficTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = trafficTargetHSM;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficStateReRouteMessageDetails]");
        this.trafficLists = trafficTargetHSM.trafficLists;
        this.modelNotifier = trafficTargetHSM.modelNotifier;
        this.aslNotifier = trafficTargetHSM.aslNotifier;
        this.trafficDataPool = trafficTargetHSM.trafficDataPool;
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        this.logger.trace("fetchItems() - Do nothing");
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.logger.trace("fetchNextPage() - Do nothing");
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.logger.trace("fetchPreviousPage() - Do nothing");
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        this.logger.trace("getDefaultIcon()");
        return new ResourceLocator();
    }

    private TrafficMessageIcon getTmcIcon(TmcListElement tmcListElement) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getTmcIcon() uID=").append(tmcListElement.uID).append(", streetSignId=").append(tmcListElement.streetSignId).log();
        }
        TrafficMessageIcon trafficMessageIcon = new TrafficMessageIcon(tmcListElement.uID, false);
        if (tmcListElement.message != null && tmcListElement.message.iconListId != null && tmcListElement.message.iconListId.length > 0) {
            ResourceLocator resourceLocator = this.target.getResourceLocatorForTMCEventIcon(tmcListElement, trafficMessageIcon, this);
            trafficMessageIcon.iconDescriptor = new IconDescriptor(resourceLocator, new TextRenderingInfo());
        } else if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getTmcIcon() uID=").append(tmcListElement.uID).append(", invalid iconListId!").log();
        }
        return trafficMessageIcon;
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
            case 1073742601: {
                this.handleSelectNextTmcMessageCurrent();
                break;
            }
            case 1073742602: {
                this.handleSelectPrevTmcMessageCurrent();
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

    private void handleEntry() {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.trafficDataPool.getTrafficMessageInfoCurrent().resetValue();
        this.trafficDataPool.getNavigationGuidanceReRouteTmcMessages().clear();
        this.trafficLists.resetOverviewList();
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.logger.trace("handleIconCacheUpdate()");
        this.target.handleIconUpdate(iconKey, resourceLocator, object);
    }

    private void handleSelectNextTmcMessageCurrent() {
        this.logger.trace("handleSelectNextTmcMessageCurrent()");
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        if (trafficMessageInfo.overviewTmcListMessageIndexNextAvailable()) {
            this.showMessageDetails();
        }
    }

    private void handleSelectPrevTmcMessageCurrent() {
        this.logger.trace("handleSelectPrevTmcMessageCurrent()");
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        if (trafficMessageInfo.overviewTmcListMessageIndexPreviousAvailable()) {
            this.showMessageDetails();
        }
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        List list = this.trafficDataPool.getNavigationGuidanceReRouteTmcMessages();
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        if (trafficMessageInfo == null) {
            return;
        }
        if (list.size() > 0) {
            TrafficMessageCollector[] trafficMessageCollectorArray = new TrafficMessageCollector[list.size()];
            TmcListElement[] tmcListElementArray = new TmcListElement[list.size()];
            int n = 0;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                TmcMessage tmcMessage = (TmcMessage)iterator.next();
                tmcListElementArray[n] = this.target.createTmcListElementByRoadNamenAndIndex(tmcMessage, n);
                trafficMessageCollectorArray[n] = new TrafficMessageCollector(tmcListElementArray[n], this.getTmcIcon(tmcListElementArray[n]), 0);
                ++n;
            }
            this.updateTmcMsgInModelOverviewList(trafficMessageCollectorArray);
            trafficMessageInfo.resetValue();
            trafficMessageInfo.setOverviewTmcListMessageSize(list.size());
            trafficMessageInfo.setOverviewTmcListMessageIndex(0);
            this.showMessageDetails();
        }
    }

    private void showMessageDetails() {
        block3: {
            this.logger.trace("showMessageDetails()");
            try {
                TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
                TrafficMessageCollector trafficMessageCollector = this.trafficLists.getCollectorOfOverviewListMessageIndex(trafficMessageInfo.getOverviewTmcListMessageIndex());
                if (trafficMessageCollector == null) {
                    return;
                }
                this.modelNotifier.notifyTmcMessageIndex(trafficMessageInfo.getOverviewTmcListMessageIndex() + 1);
                this.aslNotifier.notifyMapViewerShowTmcMessageInMap(new TrafficMessageDetails(trafficMessageCollector.tmcListElement.message));
                boolean bl = TrafficTargetHSM.isMessageOnRoute(trafficMessageCollector.tmcListElement.message);
                this.trafficLists.updateTrafficMessageDetails(trafficMessageCollector.tmcListElement, trafficMessageCollector.trafficMessageIcon, bl, (int)trafficMessageCollector.tmcListElement.uID);
            }
            catch (Exception exception) {
                if (!this.logger.isTraceEnabled()) break block3;
                this.logger.makeTrace().append("showMessageDetails()").append(exception.toString()).log();
            }
        }
    }

    private void updateTmcMsgInModelOverviewList(TrafficMessageCollector[] trafficMessageCollectorArray) {
        this.logger.trace("updateTmcMsgInModelOverviewList()");
        if (trafficMessageCollectorArray == null) {
            return;
        }
        GenericASLList genericASLList = this.trafficLists.getTmcOverviewList();
        if (genericASLList == null) {
            return;
        }
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, trafficMessageCollectorArray.length, 0);
        genericASLList.setMaxFetchTries(1);
        genericASLList.setFetchTimeout(0);
        genericASLList.setColumn4ObjectId(99);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateTmcMsgInModelOverviewList() tmcMsgInfo.getTotalOverviewTmcMsg()=").append(trafficMessageCollectorArray.length).log();
        }
        this.modelNotifier.notifyTmcMessageAllCount(trafficMessageCollectorArray.length);
        genericASLList.setSize(trafficMessageCollectorArray.length);
        genericASLList.updateListItems(0, trafficMessageCollectorArray);
    }
}

