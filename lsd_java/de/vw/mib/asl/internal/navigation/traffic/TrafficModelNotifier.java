/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;

public class TrafficModelNotifier {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficModelNotifier]");
    private final TrafficTargetHSM target;

    TrafficModelNotifier(TrafficTargetHSM trafficTargetHSM) {
        this.target = trafficTargetHSM;
    }

    public void notifyTmcMessageFilterChanged(int n, int n2) {
        switch (n2) {
            case 0: {
                this.notifyTmcMessageFilterChangedToAll(n);
                break;
            }
            case 1: {
                this.notifyTmcMessageFilterChangedToOnRoad(n);
                break;
            }
            case 2: {
                this.notifyTmcMessageFilterChangedToUrgent(n);
                break;
            }
            default: {
                this.notifyTmcMessageFilterChangedToDefault(n);
            }
        }
    }

    private void notifyTmcMessageFilterChangedToAll(int n) {
        this.logger.trace("notifyTmcMessageFilterChangedToAll()");
        AbstractASLHsmTarget.writeIntegerToDatapool(1010, 0);
    }

    private void notifyTmcMessageFilterChangedToDefault(int n) {
        this.logger.trace("notifyTmcMessageFilterChangedToDefault() - no action");
    }

    private void notifyTmcMessageFilterChangedToOnRoad(int n) {
        this.logger.trace("notifyTmcMessageFilterChangedToOnRoad()");
        AbstractASLHsmTarget.writeIntegerToDatapool(1010, 1);
    }

    private void notifyTmcMessageFilterChangedToUrgent(int n) {
        this.logger.trace("notifyTmcMessageFilterChangedToOnRoad() - no action");
    }

    void notifyTmcMessageListFullyLoadedTrue() {
        this.logger.trace("notifyTmcMessageListFullyLoadedTrue()");
        this.target.trafficDataPool.setMessagesListLoading(false);
        if (!this.target.trafficDataPool.isPopUpTimerRunning()) {
            AbstractASLHsmTarget.writeBooleanToDatapool(1015, true);
        }
    }

    void notifyTmcMessageListFullyLoadedFalse() {
        this.logger.trace("notifyTmcMessageListFullyLoadedFalse()");
        this.target.trafficDataPool.setMessagesListLoading(true);
        AbstractASLHsmTarget.writeBooleanToDatapool(1015, false);
    }

    void notifyNewTmcMessageListAvailableTrue() {
        this.logger.trace("notifyNewTmcMessageListAvailableTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(1014, true);
    }

    void notifyNewTmcMessageListAvailableFalse() {
        this.logger.trace("notifyNewTmcMessageListAvailableFalse()");
        AbstractASLHsmTarget.writeBooleanToDatapool(1014, false);
    }

    void notifyTmcMessageAllCount(int n) {
        this.logger.trace(new StringBuffer().append("notifyTmcMessageAllCount() - count = ").append(n).toString());
        AbstractASLHsmTarget.writeIntegerToDatapool(1009, n);
    }

    void notifyXUrgentMessageReceived() {
        this.logger.trace("notifyXUrgentMessageReceived()");
        this.target.sendHMIEvent(112);
    }

    void notifyClickedObjectTmcTrue() {
        this.logger.trace("notifyClickedObjectTmcTrue()");
        AbstractASLHsmTarget.writeBooleanToDatapool(873, true);
    }

    void notifyObjectTypesOnMap(int n) {
        this.logger.trace("notifyObjectTypesOnMap()");
        AbstractASLHsmTarget.writeIntegerToDatapool(867, n);
    }

    void notifyClickedPoiOrTmcIcon() {
        this.logger.trace("notifyClickedPoiOrTmcIcon()");
        this.target.sendHMIEvent(94);
    }

    void notifyTmcMessageIndex(int n) {
        this.logger.trace("notifyTmcMessageIndex()");
        AbstractASLHsmTarget.writeIntegerToDatapool(1008, n);
    }

    void notifyTmcMessageSource(int n) {
        this.logger.trace("notifyTmcMessageSource()");
        AbstractASLHsmTarget.writeIntegerToDatapool(955256832, n);
    }

    void notifyTmcMessageNameJP(String string) {
        this.logger.trace("notifyTmcMessageIndex()");
        AbstractASLHsmTarget.writeStringToDatapool(-688910336, string);
    }
}

