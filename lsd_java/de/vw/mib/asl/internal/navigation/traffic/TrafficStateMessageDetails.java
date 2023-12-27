/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.traffic.TrafficMessageDetails;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.caching.CacheClient;
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
import org.dsi.ifc.global.ResourceLocator;

public class TrafficStateMessageDetails
extends AbstractHsmState
implements CacheClient {
    private final IExtLogger logger;
    private final TrafficTargetHSM target;
    private final TrafficModelNotifier modelNotifier;
    private final TrafficLists trafficLists;
    private final TrafficASLNotifier aslNotifier;
    private final TrafficDataPool trafficDataPool;

    public TrafficStateMessageDetails(TrafficTargetHSM trafficTargetHSM, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.target = trafficTargetHSM;
        this.logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficStateMessageDetails]");
        this.modelNotifier = trafficTargetHSM.modelNotifier;
        this.trafficLists = trafficTargetHSM.trafficLists;
        this.aslNotifier = trafficTargetHSM.aslNotifier;
        this.trafficDataPool = trafficTargetHSM.trafficDataPool;
    }

    @Override
    public ResourceLocator getDefaultIcon() {
        this.logger.trace("getDefaultIcon()");
        return new ResourceLocator();
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
            case 1073742601: {
                this.handleSelectNextTmcMessageCurrent();
                break;
            }
            case 1073742602: {
                this.handleSelectPrevTmcMessageCurrent();
                break;
            }
            case 1073742609: {
                this.handleSyncReenteringTrafficListFromDetailView();
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleEntry(EventGeneric eventGeneric) {
        this.logger.trace("handleEntry()");
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
    }

    private void handleDefault(EventGeneric eventGeneric) {
        this.logger.trace("handleDefault()");
    }

    @Override
    public void handleIconCacheUpdate(IconKey iconKey, ResourceLocator resourceLocator, Object object) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("handleIconCacheUpdate() uID=").append(((TrafficMessageIcon)object).tmcElement_uID).append(", rLocator.url=").append(resourceLocator.url).append(", rLocator.id=").append(resourceLocator.id).log();
        }
    }

    private void handleSelectNextTmcMessageCurrent() {
        this.logger.trace("handleSelectNextTmcMessageCurrent()");
        this.showNextMessageDetails();
    }

    private void handleSelectPrevTmcMessageCurrent() {
        this.logger.trace("handleSelectPrevTmcMessageCurrent()");
        this.showPrevMessageDetails();
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        EventGeneric eventGeneric = this.target.getHsm().getExternalEvent();
        if (eventGeneric == null) {
            return;
        }
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        switch (eventGeneric.getReceiverEventId()) {
            case 1073742604: 
            case 1073742606: {
                int n = trafficMessageInfo.getOverviewTmcListMessageSize();
                this.modelNotifier.notifyTmcMessageAllCount(n);
                this.showMessageDetails();
                break;
            }
            default: {
                if (!this.logger.isTraceEnabled()) break;
                this.logger.makeTrace().append("startStateTrafficMsgDetails() entered DEFAULT event with ID=").append(eventGeneric.getReceiverEventId()).append(" NOK").log();
            }
        }
    }

    private void handleSyncReenteringTrafficListFromDetailView() {
        this.logger.trace("handleSyncReenteringTrafficListFromDetailView()");
        TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
        int n = trafficMessageInfo.getLastReceivedFolderIndex();
        if (n < 0 || n > trafficMessageInfo.getOverviewTmcListMessageSize() - 1) {
            return;
        }
        TrafficMessageCollector trafficMessageCollector = (TrafficMessageCollector)this.trafficLists.getTmcOverviewList().getRowItem(n);
        if (trafficMessageCollector == null) {
            this.logger.error("collector == null, stopping execution");
            return;
        }
        trafficMessageInfo.setMessageFromOverviewList(false);
        this.target.stateMain.transStateList();
    }

    private void showMessageDetails() {
        block4: {
            this.logger.trace("showMessageDetails()");
            try {
                TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
                TrafficMessageCollector trafficMessageCollector = this.trafficLists.getCollectorOfOverviewListMessageIndex(trafficMessageInfo.getOverviewTmcListMessageIndex());
                if (trafficMessageCollector == null) {
                    this.logger.error("showMessageDetails() collector is null");
                    return;
                }
                this.modelNotifier.notifyTmcMessageIndex(trafficMessageCollector.tmcListElement.positionInCompleteList);
                if (this.logger.isTraceEnabled()) {
                    ASLNavigationUtilFactory.getNavigationUtilApi().getExtLoggerHelper().appendTmcListElement(this.logger.makeTrace(), trafficMessageCollector.tmcListElement).log();
                }
                this.aslNotifier.notifyMapViewerShowTmcMessageInMap(new TrafficMessageDetails(trafficMessageCollector.tmcListElement.message));
                boolean bl = TrafficTargetHSM.isMessageOnRoute(trafficMessageCollector.tmcListElement.message);
                this.trafficLists.updateTrafficMessageDetails(trafficMessageCollector.tmcListElement, trafficMessageCollector.trafficMessageIcon, bl, (int)trafficMessageCollector.tmcListElement.uID);
            }
            catch (Exception exception) {
                if (!this.logger.isTraceEnabled()) break block4;
                this.logger.makeError().append("showMessageDetails() exception=").append(exception.toString()).log();
            }
        }
    }

    private void showNextMessageDetails() {
        block8: {
            this.logger.trace("showNextMessageDetails() ");
            try {
                TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
                if (trafficMessageInfo.isMessageFromOverviewList()) {
                    if (!trafficMessageInfo.overviewTmcListMessageIndexNextAvailable()) {
                        return;
                    }
                    TrafficMessageCollector trafficMessageCollector = this.trafficLists.getCollectorOfOverviewListMessageIndex(trafficMessageInfo.getOverviewTmcListMessageIndex());
                    if (trafficMessageCollector == null) {
                        this.logger.error("showNextMessageDetails() collector is null!");
                        return;
                    }
                    if (trafficMessageCollector.tmcListElement.hasChild) {
                        if (this.logger.isTraceEnabled()) {
                            this.logger.makeTrace().append("showNextMessageDetails() folder uID=").append(trafficMessageCollector.tmcListElement.uID).log();
                        }
                        trafficMessageInfo.setMessageFromOverviewList(false);
                    }
                    this.showMessageDetails();
                } else {
                    trafficMessageInfo.setMessageFromOverviewList(true);
                    this.showNextMessageDetails();
                }
            }
            catch (Exception exception) {
                if (!this.logger.isTraceEnabled()) break block8;
                this.logger.makeError().append("showNextMessageDetails() exception ").append(exception.toString()).log();
            }
        }
    }

    private void showPrevMessageDetails() {
        block8: {
            this.logger.trace("showPrevMessageDetails() ");
            try {
                TrafficMessageInfo trafficMessageInfo = this.trafficDataPool.getTrafficMessageInfoCurrent();
                if (trafficMessageInfo.isMessageFromOverviewList()) {
                    if (!trafficMessageInfo.overviewTmcListMessageIndexPreviousAvailable()) {
                        return;
                    }
                    TrafficMessageCollector trafficMessageCollector = this.trafficLists.getCollectorOfOverviewListMessageIndex(trafficMessageInfo.getOverviewTmcListMessageIndex());
                    if (trafficMessageCollector == null) {
                        return;
                    }
                    if (trafficMessageCollector.tmcListElement.hasChild) {
                        if (this.logger.isTraceEnabled()) {
                            this.logger.makeTrace().append("showPrevMessageDetails() Folder uID=").append(trafficMessageCollector.tmcListElement.uID).log();
                        }
                        trafficMessageInfo.setMessageFromOverviewList(false);
                    }
                    this.showMessageDetails();
                } else {
                    trafficMessageInfo.setMessageFromOverviewList(true);
                    this.showPrevMessageDetails();
                }
            }
            catch (Exception exception) {
                if (!this.logger.isTraceEnabled()) break block8;
                this.logger.makeError().append("showPrevMessageDetails() exception: ").append(exception.toString()).log();
            }
        }
    }
}

