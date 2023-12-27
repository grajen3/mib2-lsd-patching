/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.map.TrafficDualListViewConfiguration;
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
import de.vw.mib.asl.internal.navigation.traffic.ModelFetchRequestItem;
import de.vw.mib.asl.internal.navigation.traffic.TrafficDSINotifier;
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
import java.util.LinkedList;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;
import org.dsi.ifc.tmc.TmcListElement;

public class TrafficStateList
extends AbstractHsmState
implements ASLListElementFetcher,
CacheClient {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficStateList]");
    private final LinkedList queueFetchRequestFromModel;
    private final TrafficTargetHSM target;
    private final TrafficDSINotifier dsiNotifier;
    private final TrafficModelNotifier modelNotifier;
    private final TrafficDataPool trafficDataPool;
    private final TrafficLists trafficLists;

    public TrafficStateList(TrafficTargetHSM trafficTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = trafficTargetHSM;
        this.dsiNotifier = trafficTargetHSM.dsiNotifier;
        this.modelNotifier = trafficTargetHSM.modelNotifier;
        this.trafficDataPool = trafficTargetHSM.trafficDataPool;
        this.trafficLists = trafficTargetHSM.trafficLists;
        this.queueFetchRequestFromModel = new LinkedList();
    }

    private void addTmcMsgUiDToArrayList(TmcListElement[] tmcListElementArray, ModelFetchRequestItem modelFetchRequestItem) {
        this.logger.trace("addTmcMsgUiDToArrayList()");
        if (tmcListElementArray == null || tmcListElementArray.length <= 0 || modelFetchRequestItem == null) {
            return;
        }
        List list = this.trafficDataPool.getOverviewListMessageUIDs();
        for (int i2 = 0; i2 < tmcListElementArray.length; ++i2) {
            int n = modelFetchRequestItem.getIndex() + i2;
            if (n < list.size()) {
                list.set(n, new Long(tmcListElementArray[i2].uID));
                continue;
            }
            list.add(new Long(tmcListElementArray[i2].uID));
        }
    }

    public void dsiTmcSetMessageFilterResult(int n, int n2) {
        block2: {
            this.logger.trace("dsiTmcSetMessageFilterResult()");
            this.modelNotifier.notifyTmcMessageFilterChanged(n, n2);
            try {
                this.handleSetTMCMessageListUpdate();
            }
            catch (Exception exception) {
                if (!this.logger.isTraceEnabled()) break block2;
                this.logger.warn("Error while transiting to State ListReFetch");
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public void dsiTmcTmcWindowResult(int n, int n2, TmcListElement[] tmcListElementArray) {
        int n3;
        this.stopTimerForRequestTmcWindow();
        if (tmcListElementArray == null || tmcListElementArray.length == 0) {
            this.tmcListElementEmpty();
            return;
        }
        if (this.queueFetchRequestFromModel.isEmpty()) {
            this.logger.trace("dsiTmcTmcWindowResult() Fetch Queue empty! No windows result is expected");
            this.updateTmcMsgInModelOverviewList(null, null);
            this.modelNotifier.notifyTmcMessageListFullyLoadedTrue();
            this.notifyModelUpdateListFinish();
            return;
        }
        ModelFetchRequestItem modelFetchRequestItem = (ModelFetchRequestItem)this.queueFetchRequestFromModel.getFirst();
        if (!modelFetchRequestItem.isItemWaitingForDsiAnswer()) {
            this.logger.error("dsiTmcTmcWindowResult() No Response From DSI expected!");
            this.updateTmcMsgInModelOverviewList(null, null);
            this.notifyModelUpdateListFinish();
            this.modelNotifier.notifyTmcMessageListFullyLoadedTrue();
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiTmcTmcWindowResult() before filter allready fetched elements, TmcListElement[].length=").append(tmcListElementArray.length).log();
        }
        tmcListElementArray = this.filterTmcListElement(tmcListElementArray);
        this.addTmcMsgUiDToArrayList(tmcListElementArray, modelFetchRequestItem);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiTmcTmcWindowResult() after filter allready fetched elements, TmcListElement[].length=").append(tmcListElementArray.length).log();
        }
        if (tmcListElementArray == null) {
            this.logger.trace("dsiTmcTmcWindowResult() ALL ITEMS RECEIVED");
            n3 = 0;
        } else {
            n3 = tmcListElementArray.length;
        }
        List list = this.trafficDataPool.getOverviewListMessageUIDs();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiTmcTmcWindowResult() noOfTmcEventFiltered=").append(n3).append(", arraylist.size=").append(list.size()).append(", usedAnchorID=").append(n2).log();
        }
        if (n3 <= 0) {
            this.updateTmcMsgInModelOverviewList(null, null);
            this.notifyModelUpdateListFinish();
            this.queueFetchRequestFromModel.clear();
        } else {
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("dsiTmcTmcWindowResult->new fetchItems(index=").append(list.size()).append(", count=").append(10).append(")").log();
            }
            this.queueFetchRequestFromModel.add(new ModelFetchRequestItem(list.size(), 10, false));
            this.setPositionInCompleteListForOverviewList(tmcListElementArray);
            TrafficMessageCollector[] trafficMessageCollectorArray = new TrafficMessageCollector[n3];
            if (tmcListElementArray == null) {
                this.logger.trace("notifyRequestTmcWindow triggered via DSITmcTmcWindowResult");
                this.startNextModelFetchItemsRequest();
                return;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                TrafficMessageIcon trafficMessageIcon;
                if (tmcListElementArray[i2] == null) continue;
                if (this.logger.isTraceEnabled()) {
                    int n4 = list.size() - n3 + i2;
                    if (this.logger.isTraceEnabled()) {
                        this.logger.makeTrace().append("dsiTmcTmcWindowResult(), TmcListElement[").append(n4).append("] uID=").append(tmcListElementArray[i2].uID).log();
                    }
                }
                trafficMessageCollectorArray[i2] = new TrafficMessageCollector(tmcListElementArray[i2], i2 + modelFetchRequestItem.getIndex());
                trafficMessageCollectorArray[i2].trafficMessageIcon = trafficMessageIcon = this.getTmcIcon(tmcListElementArray[i2], trafficMessageCollectorArray[i2]);
            }
            TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
            trafficMessageInfo.setOverviewTmcListMessageSize(trafficMessageInfo.getOverviewTmcListMessageSize() + n3);
            this.trafficDataPool.setTrafficMessageInfoCurrent(trafficMessageInfo);
            this.updateTmcMsgInModelOverviewList(modelFetchRequestItem, trafficMessageCollectorArray);
            this.queueFetchRequestFromModel.removeFirst();
        }
        this.startNextModelFetchItemsRequest();
    }

    public void dsiTmcWindowChange(int n) {
        this.logger.trace("dsiTmcWindowChange()");
        this.modelNotifier.notifyNewTmcMessageListAvailableTrue();
    }

    void tmcListElementEmpty() {
        this.logger.trace("tmcListElementEmpty()");
        this.queueFetchRequestFromModel.clear();
        this.updateTmcMsgInModelOverviewList(null, null);
        this.workAroundForCcpSymbolIsNotCentered();
        this.modelNotifier.notifyTmcMessageListFullyLoadedTrue();
        this.notifyModelUpdateListFinish();
    }

    private void workAroundForCcpSymbolIsNotCentered() {
        TrafficDualListViewConfiguration trafficDualListViewConfiguration = new TrafficDualListViewConfiguration(new long[0], true, true);
        ASLNavigationMapFactory.getNavigationMapApi().sendEvMapShowTMCDualList(trafficDualListViewConfiguration);
    }

    @Override
    public void fetchItems(ASLCachedWindowList aSLCachedWindowList, int n, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("fetchItems(index=").append(n).append(", count=").append(10).append(")").log();
        }
        ModelFetchRequestItem modelFetchRequestItem = new ModelFetchRequestItem(n, 10, false);
        this.queueFetchRequestFromModel.add(modelFetchRequestItem);
        try {
            this.logger.trace("notifyRequestTmcWindow triggered via FETCH ITEMS");
            this.startNextModelFetchItemsRequest();
        }
        catch (Exception exception) {
            this.logger.trace(exception.toString());
        }
    }

    @Override
    public void fetchNextPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.logger.trace("TrafficStateList.fetchNextPage was called");
    }

    @Override
    public void fetchPreviousPage(ASLCachedWindowList aSLCachedWindowList, Object object, int n, int n2) {
        this.logger.trace("TrafficStateList.fetchPreviousPage was called");
    }

    private TmcListElement[] filterTmcListElement(TmcListElement[] tmcListElementArray) {
        if (tmcListElementArray == null || tmcListElementArray.length == 0) {
            return null;
        }
        this.logger.trace("filterTmcListElement()");
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        List list = this.trafficDataPool.getOverviewListMessageUIDs();
        block0: for (n = 0; n < tmcListElementArray.length; ++n) {
            for (n2 = 0; n2 < list.size(); ++n2) {
                if (tmcListElementArray[n] != null) {
                    if (tmcListElementArray[n].uID != (Long)list.get(n2)) continue;
                    tmcListElementArray[n] = null;
                    ++n3;
                    continue block0;
                }
                ++n3;
            }
        }
        for (n = 0; n < tmcListElementArray.length; ++n) {
            if (tmcListElementArray[n] == null || tmcListElementArray[n].message != null) continue;
            this.logger.makeTrace().append("filterTmcListElement() INVALID TMC! Remove uID=").append(tmcListElementArray[n].uID).log();
            tmcListElementArray[n] = null;
            ++n4;
        }
        if (n3 + n4 > 0) {
            n2 = 0;
            TmcListElement[] tmcListElementArray2 = new TmcListElement[tmcListElementArray.length - (n3 + n4)];
            for (n = 0; n < tmcListElementArray.length; ++n) {
                if (tmcListElementArray[n] == null) continue;
                tmcListElementArray2[n2++] = tmcListElementArray[n];
            }
            tmcListElementArray = tmcListElementArray2;
        }
        return tmcListElementArray;
    }

    private int[] getAnchorIDFromIndex(ModelFetchRequestItem modelFetchRequestItem) {
        int n;
        this.logger.trace("getAnchorIDFromIndex()");
        if (modelFetchRequestItem == null) {
            this.logger.trace("fetchItem == null - stopping execution");
            return null;
        }
        List list = this.trafficDataPool.getOverviewListMessageUIDs();
        if (!list.isEmpty() && modelFetchRequestItem.getIndex() < list.size()) {
            n = modelFetchRequestItem.getIndex() + modelFetchRequestItem.getCount();
            for (int i2 = modelFetchRequestItem.getIndex(); i2 < n && i2 < list.size(); ++i2) {
                list.set(i2, new Long(-1L));
            }
        }
        if (list.isEmpty() || modelFetchRequestItem.getIndex() <= 0) {
            return new int[]{-1};
        }
        modelFetchRequestItem.setCount(modelFetchRequestItem.getCount() + 1);
        n = modelFetchRequestItem.getIndex() > 10 ? 10 : modelFetchRequestItem.getIndex();
        int[] nArray = new int[n];
        for (int i3 = 0; i3 < n; ++i3) {
            nArray[i3] = (int)((Long)list.get(modelFetchRequestItem.getIndex() - i3 - 1)).longValue();
        }
        return nArray;
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        this.logger.trace("getDefaultIcon()");
        return new ResourceLocator();
    }

    private TrafficMessageIcon getTmcIcon(TmcListElement tmcListElement, TrafficMessageCollector trafficMessageCollector) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getTmcIcon() uID=").append(tmcListElement.uID).log();
        }
        TrafficMessageIcon trafficMessageIcon = new TrafficMessageIcon(tmcListElement.uID, true);
        TrafficMessageIcon trafficMessageIcon2 = new TrafficMessageIcon(tmcListElement.uID, false);
        trafficMessageIcon.roadIconDescriptor = ASLNavigationUtilFactory.getNavigationUtilApi().getCacheHandler().resourceIdForRoadIcon((int)tmcListElement.streetSignId, tmcListElement.message.roadNumber.length(), 1, this, trafficMessageIcon);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getTmcIcon() RoadIconItemRL=").append(trafficMessageIcon.roadIconDescriptor.getResourceLocator().toString()).log();
        }
        if (tmcListElement.message != null && tmcListElement.message.iconListId != null && tmcListElement.message.iconListId.length > 0) {
            ResourceLocator resourceLocator = this.target.getResourceLocatorForTMCEventIcon(tmcListElement, trafficMessageIcon2, this);
            trafficMessageIcon2.iconDescriptor = new IconDescriptor(resourceLocator, new TextRenderingInfo());
        } else if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("getTmcIcon() uID=").append(tmcListElement.uID).append(", no msg or iconList").log();
        }
        trafficMessageIcon2.roadIconDescriptor = trafficMessageIcon.roadIconDescriptor;
        return trafficMessageIcon2;
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
            case 1073742600: {
                this.handleLeaveContext();
                break;
            }
            case 1073742382: {
                this.handleSetContent(eventGeneric);
                break;
            }
            case 1073742604: {
                this.handleSelectTMCMessageListId(eventGeneric);
                break;
            }
            case 1073742606: {
                this.logger.warn("Deprecated SELECT_TMC_MESSAGE_SUB_LIST_ID was received!");
                break;
            }
            case 1073742601: {
                this.handleSelectNextTMCMessageCurrent();
                break;
            }
            case 1073742608: {
                this.handleSetTMCMessageListUpdate();
                break;
            }
            case 1073742607: {
                this.handleSetTMCMessageListFilter(eventGeneric);
                break;
            }
            case 100105: {
                this.handleEvNavigationTMCTrafficTimerOutForRequestTMCWindow();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        this.trafficDataPool.resetTrafficMessageInfoCurrent();
        this.trafficDataPool.getOverviewListMessageUIDs().clear();
        this.queueFetchRequestFromModel.clear();
        GenericASLList genericASLList = this.trafficLists.getTmcOverviewList();
        if (genericASLList == null) {
            this.logger.trace("tmcOverviewList == null - stopping execution");
            return;
        }
        genericASLList.enableWindowing(new ASLListItemSoftCacheImpl(), this, 10, 0);
        genericASLList.setMaxFetchTries(1);
        genericASLList.setFetchTimeout(0);
        genericASLList.setColumn4ObjectId(99);
        genericASLList.setSize(0);
        genericASLList.setActiveIndex(0);
        genericASLList.setSize(1);
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
    }

    private void handleEvNavigationTMCTrafficTimerOutForRequestTMCWindow() {
        this.logger.trace("handleEvNavigationTMCTrafficTimerOutForRequestTMCWindow()");
        this.notifyModelUpdateListFinish();
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        this.logger.trace("handleIconCacheUpdate()");
        this.target.handleIconUpdate(iconKey, resourceLocator, object);
    }

    private void handleLeaveContext() {
        this.logger.trace("handleLeaveContext()");
        this.target.stateMain.transStateMain();
    }

    private void handleSelectNextTMCMessageCurrent() {
        this.target.trace("handleSelectNextTMCMessageCurrent()");
        this.target.stateMain.transStateMessageDetails();
    }

    private void handleSelectTMCMessageListId(EventGeneric eventGeneric) {
        this.logger.trace("handleSelectTMCMessageListId()");
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        trafficMessageInfo.setOverviewTmcListMessageIndex(eventGeneric.getInt(0));
        trafficMessageInfo.setMessageFromOverviewList(true);
        this.showMessageDetails(eventGeneric);
    }

    private void handleSetContent(EventGeneric eventGeneric) {
        this.logger.trace("handleSetContent()");
        int n = eventGeneric.getInt(0);
        if (23 == n) {
            this.target.stateMain.transStateMain();
        }
    }

    private void handleSetTMCMessageListFilter(EventGeneric eventGeneric) {
        this.logger.trace("handleSetTMCMessageListFilter()");
        this.logger.trace(new StringBuffer().append("isPopupTimerRunning: ").append(this.trafficDataPool.isPopUpTimerRunning()).toString());
        this.target.setMessageFilter(eventGeneric);
    }

    private void handleSetTMCMessageListUpdate() {
        this.logger.trace("handleSetTMCMessageListUpdate()");
        this.notifyModelUpdateListStart();
        this.target.stateMain.transStateListReFetch();
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        this.queueFetchRequestFromModel.clear();
        this.trafficLists.resetOverviewList();
        this.modelNotifier.notifyNewTmcMessageListAvailableFalse();
        this.trafficDataPool.getOverviewListMessageUIDs().clear();
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    private void notifyModelUpdateListStart() {
        this.logger.trace("notifyModelUpdateListStart()");
        this.target.startTimerForListLoadPopUp();
        this.modelNotifier.notifyNewTmcMessageListAvailableTrue();
        this.modelNotifier.notifyTmcMessageListFullyLoadedFalse();
    }

    private void notifyModelUpdateListFinish() {
        this.logger.trace("notifyModelUpdateListFinish()");
        GenericASLList genericASLList = this.trafficLists.getTmcOverviewList();
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        genericASLList.setSize(trafficMessageInfo.getOverviewTmcListMessageSize());
        this.modelNotifier.notifyNewTmcMessageListAvailableFalse();
    }

    private void setPositionInCompleteListForOverviewList(TmcListElement[] tmcListElementArray) {
        this.logger.trace("setPositionInCompleteListForOverviewList()");
        if (tmcListElementArray == null) {
            this.logger.trace("tmcListElements is null!");
            return;
        }
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        for (int i2 = 0; i2 < tmcListElementArray.length; ++i2) {
            trafficMessageInfo.nextOffsetPosition();
            tmcListElementArray[i2].positionInCompleteList = trafficMessageInfo.getOffsetPosition();
        }
    }

    private void showMessageDetails(EventGeneric eventGeneric) {
        TrafficMessageCollector trafficMessageCollector;
        this.logger.trace("showMessageDetails()");
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("OverviewListMsgIndex=").append(trafficMessageInfo.getOverviewTmcListMessageIndex()).log();
        }
        if ((trafficMessageCollector = this.trafficLists.getCollectorOfOverviewListMessageIndex(trafficMessageInfo.getOverviewTmcListMessageIndex())) == null) {
            this.logger.error("showMessageDetails() collector is null!");
            return;
        }
        trafficMessageInfo.setSelectedMessageUID((int)trafficMessageCollector.tmcListElement.uID);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("showMessageDetails() OverviewListMsgIndex=").append(trafficMessageInfo.getOverviewTmcListMessageIndex()).append(", iSelectedMessageUid=").append(trafficMessageCollector.tmcListElement.uID).append(", hasChild=").append(trafficMessageCollector.tmcListElement.hasChild).log();
        }
        this.logger.trace("trans(stateTrafficMsgDetails)");
        this.target.stateMain.transStateMessageDetails();
    }

    private void startNextModelFetchItemsRequest() {
        this.logger.trace("startNextModelFetchItemsRequest()");
        if (this.queueFetchRequestFromModel.isEmpty()) {
            this.logger.trace("queueFetchRequestFromModel is Empty -> OK");
            this.notifyModelUpdateListFinish();
            this.modelNotifier.notifyTmcMessageListFullyLoadedTrue();
            return;
        }
        ModelFetchRequestItem modelFetchRequestItem = (ModelFetchRequestItem)this.queueFetchRequestFromModel.getFirst();
        if (modelFetchRequestItem == null) {
            this.logger.error("startNextModelFetchItemsRequest() (null == fetchItem)");
            return;
        }
        if (modelFetchRequestItem.isItemWaitingForDsiAnswer()) {
            this.logger.trace("Target is Already waiting for DSI answer!");
            return;
        }
        List list = this.trafficDataPool.getOverviewListMessageUIDs();
        for (int i2 = 0; i2 < list.size(); ++i2) {
            Long l = (Long)list.get(i2);
            this.logger.trace(new StringBuffer().append("Item").append(i2).append(" UID=").append(l).toString());
        }
        modelFetchRequestItem.setRequestItemToWaintingForDsiAnswer();
        if (modelFetchRequestItem.getIndex() > list.size()) {
            modelFetchRequestItem.setCount(modelFetchRequestItem.getCount() + 1 + (modelFetchRequestItem.getIndex() - list.size()));
            modelFetchRequestItem.setIndex(list.size());
        }
        int[] nArray = this.getAnchorIDFromIndex(modelFetchRequestItem);
        this.dsiNotifier.notifyRequestTmcWindow(modelFetchRequestItem.getCount(), nArray);
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("requestTmcWindow(index=").append(modelFetchRequestItem.getIndex()).append(", windowSize=").append(modelFetchRequestItem.getCount()).append(")").log();
        }
        this.startTimerForRequestTmcWindow();
    }

    private void startTimerForRequestTmcWindow() {
        this.logger.trace("startTimerForRequestTmcWindow()");
        if (this.target.getTimerServer().isTimerActive(this.target.getTargetId(), 159842560)) {
            this.target.stopTimer(159842560);
        }
        this.target.startTimer(159842560, (long)0, false);
    }

    private void stopTimerForRequestTmcWindow() {
        this.logger.trace("stopTimerForRequestTmcWindow()");
        this.target.stopTimer(159842560);
    }

    private void updateTmcMsgInModelOverviewList(ModelFetchRequestItem modelFetchRequestItem, TrafficMessageCollector[] trafficMessageCollectorArray) {
        GenericASLList genericASLList = this.trafficLists.getTmcOverviewList();
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("updateTmcMsgInModelOverviewList() getTotalOverviewTmcMsgSize=").append(trafficMessageInfo.getOverviewTmcListMessageSize()).append(", getTotalSubTmcMsgSize=").log();
        }
        int n = trafficMessageInfo.getOverviewTmcListMessageSize();
        this.modelNotifier.notifyTmcMessageAllCount(n);
        if (modelFetchRequestItem != null && trafficMessageCollectorArray != null) {
            genericASLList.updateListItems(modelFetchRequestItem.getIndex(), trafficMessageCollectorArray);
            genericASLList.setSize(trafficMessageInfo.getOverviewTmcListMessageSize());
            if (modelFetchRequestItem.getIndex() == 0) {
                this.notifyModelUpdateListFinish();
            }
        }
    }
}

