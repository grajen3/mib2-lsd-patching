/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapFactory;
import de.vw.mib.asl.api.navigation.traffic.TrafficMessageDetails;
import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;

public class TrafficASLNotifier {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficASLNotifier]");

    public TrafficASLNotifier(TrafficTargetHSM trafficTargetHSM) {
    }

    public void notifyMapViewerShowTmcMessageInMap(TrafficMessageDetails trafficMessageDetails) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyMapViewerShowTmcMessageInMap() sending EV_MAP_MAIN_SHOW_TMC_MESSAGE TmcMsgUid=").append(trafficMessageDetails.messageID).append(" to IdTarget.ASL_NAVI_MAP_VIEWER").log();
        }
        ASLNavigationMapFactory.getNavigationMapApi().sendEvShowTMCMessageInMap(trafficMessageDetails);
    }
}

