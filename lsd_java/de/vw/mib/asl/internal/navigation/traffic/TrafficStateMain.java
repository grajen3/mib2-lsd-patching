/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navbap.ASLNavBAPFactory;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.list.impl.GenericASLList;
import de.vw.mib.asl.internal.navigation.traffic.TrafficDSINotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficDataPool;
import de.vw.mib.asl.internal.navigation.traffic.TrafficEvents;
import de.vw.mib.asl.internal.navigation.traffic.TrafficLists;
import de.vw.mib.asl.internal.navigation.traffic.TrafficMessageInfo;
import de.vw.mib.asl.internal.navigation.traffic.TrafficModelNotifier;
import de.vw.mib.asl.internal.navigation.traffic.TrafficStateMain$1;
import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.List;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TrafficStateMain
extends AbstractHsmState {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficStateMain]");
    final TrafficTargetHSM target;
    private final TrafficDSINotifier dsiNotifier;
    private final TrafficModelNotifier modelNotifier;
    private final TrafficLists trafficLists;
    final TrafficDataPool trafficDataPool;
    static /* synthetic */ Class class$de$vw$mib$asl$api$speechengine$PromptEngine;

    public TrafficStateMain(TrafficTargetHSM trafficTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = trafficTargetHSM;
        this.dsiNotifier = trafficTargetHSM.dsiNotifier;
        this.modelNotifier = trafficTargetHSM.modelNotifier;
        this.trafficLists = trafficTargetHSM.trafficLists;
        this.trafficDataPool = trafficTargetHSM.trafficDataPool;
    }

    public HsmState dsiNavigationUpdateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation, int n) {
        this.logger.trace("dsiNavigationUpdateRgRouteCostChangeInformation()");
        if (rgRouteCostChangeInformation == null) {
            return null;
        }
        if (rgRouteCostChangeInformation.tmcMsgIds == null || rgRouteCostChangeInformation.tmcMsgIds.length == 0) {
            return null;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiNavigationUpdateRgRouteCostChangeInformation() tmcMsgIds.length=").append(rgRouteCostChangeInformation.tmcMsgIds.length).log();
        }
        List list = this.trafficDataPool.getNavigationGuidanceReRouteTmcMessages();
        List list2 = this.trafficDataPool.getNavigationGuidanceReRouteTmcMessagesUIDs();
        list.clear();
        list2.clear();
        for (int i2 = 0; i2 < rgRouteCostChangeInformation.tmcMsgIds.length; ++i2) {
            int n2 = rgRouteCostChangeInformation.tmcMsgIds[i2];
            if (this.logger.isTraceEnabled()) {
                this.logger.makeTrace().append("dsiNavigationUpdateRgRouteCostChangeInformation() getTmcMessage(MsgID=").append(n2).append(")").log();
            }
            list2.add(new Integer(n2));
            this.dsiNotifier.notifyGetTmcMessage(n2);
        }
        return null;
    }

    public void dsiTmcAsyncException(int n, String string, int n2) {
        this.logger.makeError().append("dsiTmcAsyncException() - errorCode=").append(n).append(", errorMessage=").append(string).append(", requestType=").append(n2).log();
        if (n2 == 1004) {
            this.target.stateList.tmcListElementEmpty();
        }
    }

    public void dsiTmcOnRouteAsyncException(int n, String string, int n2) {
        this.logger.makeError().append("dsiTmcOnRouteAsyncException() - errorCode=").append(n).append(", errorMessage=").append(string).append(", requestType=").append(n2).log();
    }

    public HsmState dsiTmcOnRouteTmcMessage(TmcMessage tmcMessage) {
        Integer n;
        this.logger.trace("dsiTmcOnRouteTmcMessage()");
        if (tmcMessage == null) {
            return null;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiTmcOnRouteTmcMessage() MsgID=").append(tmcMessage.messageID).log();
        }
        List list = this.trafficDataPool.getNavigationGuidanceReRouteTmcMessages();
        List list2 = this.trafficDataPool.getNavigationGuidanceReRouteTmcMessagesUIDs();
        if (list2.contains(n = new Integer((int)tmcMessage.messageID))) {
            list.add(tmcMessage);
        }
        return null;
    }

    public HsmState dsiTmcOnRouteUpdateUrgentMessages(TmcMessage[] tmcMessageArray, int n) {
        if (tmcMessageArray == null) {
            return null;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiTmcOnRouteUpdateUrgentMessages() urgentMessages.length=").append(tmcMessageArray.length).log();
        }
        List list = this.trafficDataPool.getUrgentMessagesReadUIDs();
        for (int i2 = 0; i2 < tmcMessageArray.length; ++i2) {
            if (tmcMessageArray[i2] == null || list.contains(new Long(tmcMessageArray[i2].messageID))) continue;
            this.trafficDataPool.getUrgentMessages().add(tmcMessageArray[i2]);
        }
        this.urgentMessageShowNext();
        return null;
    }

    public void dsiTmcSetMessageFilterResult(int n, int n2) {
        this.logger.trace("dsiTmcSetMessageFilterResult()");
        this.modelNotifier.notifyTmcMessageFilterChanged(n, n2);
    }

    public void dsiTmcUpdateEventsTotal(int n, long l, long l2, int n2) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiTmcUpdateEventsTotal(), eventsTotal=").append(l).append(",eventsVisible=").append(l2).log();
        }
    }

    public void dsiTmcUpdateActiveTrafficSources(int[] nArray, int n) {
        if (nArray == null || nArray.length == 0) {
            this.logger.error("dsiTmcUpdateActiveTrafficSources() no active source!");
            return;
        }
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("dsiTmcUpdateActiveTrafficSources(), activeTrafficSources=").append(nArray[0]).log();
        }
        this.modelNotifier.notifyTmcMessageSource(nArray[0]);
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry(eventGeneric);
                break;
            }
            case 3: {
                this.handleStart(eventGeneric);
                break;
            }
            case 4: {
                this.handleExit(eventGeneric);
                break;
            }
            case 100107: {
                this.handleEvNavigationTmcTrafficTimeroutForOverviewListPopup();
                break;
            }
            case 1073742600: {
                this.handleASLNavigationTrafficServiceLeaveContext();
                break;
            }
            case 100105: {
                this.handleEvNavigationTmcTrafficTimerOutForRequestTmcWindow();
                break;
            }
            case 1073742611: {
                this.handleASLNavigationTrafficeServiceXUrgentTmcMessageRead();
                break;
            }
            case 1073742382: {
                this.handleASLNavigationMapServiceSetContent();
                break;
            }
            case 1073742608: {
                this.handleASLNavigationTrafficServiceSetTmcMessageListUpdate();
                break;
            }
            case 1073742607: {
                this.handleASLNavigationTrafficServiceSetTmcMessageListFilter(eventGeneric);
                break;
            }
            case 1073742605: {
                this.handleASLNavigationTrafficServiceSelectTmcMessageRouteChanged();
                break;
            }
            case 3400003: {
                this.handleASLNaviMapInputTmcMessage(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleASLNavigationMapServiceSetContent() {
        this.logger.trace("handleASLNavigationMapServiceSetContent() - no action");
    }

    private void handleASLNavigationTrafficeServiceXUrgentTmcMessageRead() {
        this.logger.trace("handleASLNavigationTrafficeServiceXUrgentTmcMessageRead()");
        this.trafficDataPool.getTrafficMessageInfoCurrent().setUrgentMessageDisplayed(false);
        List list = this.trafficDataPool.getUrgentMessages();
        List list2 = this.trafficDataPool.getUrgentMessagesReadUIDs();
        TmcMessage tmcMessage = (TmcMessage)list.remove(0);
        list2.add(new Long(tmcMessage.messageID));
        this.target.sendHMIEvent(73);
        this.urgentMessageShowNext();
    }

    private void handleASLNavigationTrafficServiceLeaveContext() {
        this.logger.trace("handleASLNavigationTrafficServiceLeaveContext()");
    }

    private void handleASLNavigationTrafficServiceSelectTmcMessageRouteChanged() {
        this.logger.trace("handleASLNavigationTrafficServiceSelectTmcMessageRouteChanged()");
        this.target.stateMain.transStateReRouteMessageDetails();
    }

    private void handleASLNavigationTrafficServiceSetTmcMessageListFilter(EventGeneric eventGeneric) {
        this.logger.trace("handleASLNavigationTrafficServiceSetTmcMessageListFilter()");
        this.target.setMessageFilter(eventGeneric);
    }

    private void handleASLNavigationTrafficServiceSetTmcMessageListUpdate() {
        this.logger.trace("handleASLNavigationTrafficServiceSetTmcMessageListUpdate()");
        this.modelNotifier.notifyTmcMessageAllCount(0);
        this.target.stateMain.transStateList();
    }

    private void handleASLNaviMapInputTmcMessage(EventGeneric eventGeneric) {
        int n = eventGeneric.getSenderTargetId();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleASLNaviMapInputTmcMessage(), senderId=").append(n).log();
        }
        switch (n) {
            case 1330031: 
            case 1330080: {
                this.transStateMapMessageDetails();
                break;
            }
            case 1330018: 
            case 1330055: 
            case 1330060: 
            case 1330074: {
                this.transStateMapInputMessageDetails();
                break;
            }
            default: {
                this.logger.warn("Event ASL_NAVI_MAP_INPUT_TMC_MESSAGE received from wrong source!");
            }
        }
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault() ").append(eventGeneric).log();
        }
    }

    private void handleEntry(EventGeneric eventGeneric) {
        this.logger.trace("handleEntry()");
        TrafficEvents.addObservers(this.target);
        this.trafficDataPool.getUrgentMessages().clear();
        this.trafficDataPool.getUrgentMessagesReadUIDs().clear();
        this.initSpeechEngine();
    }

    private void initSpeechEngine() {
        BundleContext bundleContext = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getBundleContext();
        ServiceTracker serviceTracker = new ServiceTracker(bundleContext, (class$de$vw$mib$asl$api$speechengine$PromptEngine == null ? (class$de$vw$mib$asl$api$speechengine$PromptEngine = TrafficStateMain.class$("de.vw.mib.asl.api.speechengine.PromptEngine")) : class$de$vw$mib$asl$api$speechengine$PromptEngine).getName(), (ServiceTrackerCustomizer)new TrafficStateMain$1(this, bundleContext));
        serviceTracker.open();
    }

    private void handleEvNavigationTmcTrafficTimerOutForRequestTmcWindow() {
        this.target.trace("handleEvNavigationTmcTrafficTimerOutForRequestTmcWindow()");
        this.modelNotifier.notifyNewTmcMessageListAvailableFalse();
        this.modelNotifier.notifyTmcMessageListFullyLoadedTrue();
    }

    private void handleExit(EventGeneric eventGeneric) {
        this.logger.trace("handleExit()");
        TrafficEvents.removeObservers(this.target);
        this.trafficDataPool.setTrafficMessageInfoCurrent(null);
        this.trafficDataPool.getUrgentMessages().clear();
        this.trafficDataPool.getUrgentMessagesReadUIDs().clear();
        this.trafficDataPool.getNavigationGuidanceReRouteTmcMessages().clear();
        this.trafficDataPool.getNavigationGuidanceReRouteTmcMessagesUIDs().clear();
    }

    private void handleStart(EventGeneric eventGeneric) {
        this.logger.trace("handleStart()");
        this.trafficDataPool.setTrafficMessageInfoCurrent(new TrafficMessageInfo());
    }

    private void urgentMessageShowNext() {
        this.logger.trace("urgentMessageShowNext()");
        this.trafficDataPool.urgentMessagesRemoveMessagesRead();
        List list = this.trafficDataPool.getUrgentMessages();
        if (list.isEmpty()) {
            this.logger.trace("urgentMessageShowNext() - list empty");
            return;
        }
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        if (trafficMessageInfo.isUrgentMessageDisplayed()) {
            return;
        }
        TmcMessage tmcMessage = (TmcMessage)list.get(0);
        if (tmcMessage == null || tmcMessage.eventText == null) {
            return;
        }
        TmcListElement tmcListElement = this.target.createTmcListElementByRoadName(tmcMessage);
        TmcListElement[] tmcListElementArray = new TmcListElement[]{tmcListElement};
        boolean bl = TrafficTargetHSM.isMessageOnRoute(tmcMessage);
        this.trafficLists.updateXUrgentMessageDetails(tmcListElementArray[0], bl, (int)tmcListElementArray[0].uID);
        GenericASLList genericASLList = this.trafficLists.getTmcInfoList();
        ASLNavBAPFactory.getNavBAPApi().updateBapTMCInfo((TmcMessage)list.get(0));
        if (genericASLList != null) {
            this.modelNotifier.notifyXUrgentMessageReceived();
            trafficMessageInfo.setUrgentMessageDisplayed(true);
        }
    }

    private void handleEvNavigationTmcTrafficTimeroutForOverviewListPopup() {
        this.logger.trace("handleEvNavigationTmcTrafficTimeroutForOverviewListPopup()");
        this.target.trafficDataPool.setPopUpTimerRunning(false);
        if (!this.target.trafficDataPool.isMessagesListLoading()) {
            this.target.modelNotifier.notifyTmcMessageListFullyLoadedTrue();
        }
    }

    protected void transStateList() {
        this.logger.trace("transStateList()");
        this.trans(this.target.stateList);
    }

    protected void transStateListReFetch() {
        this.logger.trace("transStateListReFetch()");
        this.trans(this.target.stateListReFetch);
    }

    protected void transStateMain() {
        this.logger.trace("transStateMain()");
        this.trans(this.target.stateMain);
    }

    protected void transStateMapInputMessageDetails() {
        this.logger.trace("transStateMapInputMessageDetails()");
        this.trans(this.target.stateMapInputMessageDetails);
    }

    protected void transStateMapMessageDetails() {
        this.logger.trace("transStateMapMessageDetails()");
        this.trans(this.target.stateMapMessageDetails);
    }

    protected void transStateMessageDetails() {
        this.logger.trace("transStateMessageDetails()");
        this.trans(this.target.stateMessageDetails);
    }

    protected void transStateReRouteMessageDetails() {
        this.logger.trace("transStateReRouteMessageDetails()");
        this.trans(this.target.stateReRouteMessageDetails);
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

