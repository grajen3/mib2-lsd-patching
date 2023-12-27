/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.traffic;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.traffic.TrafficTargetHSM;
import org.dsi.ifc.tmc.DSITmc;
import org.dsi.ifc.tmc.DSITmcOnRoute;

public class TrafficDSINotifier {
    protected DSITmc dsiTmc;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16, "[TrafficDSINotifier]");
    protected DSITmcOnRoute dsiTmcOnRoute;

    TrafficDSINotifier(TrafficTargetHSM trafficTargetHSM) {
    }

    void notifySetMessageFilterAll() {
        this.logger.trace("notifySetMessageFilterAll()");
        this.dsiTmc.setMessageFilter(0, 0);
    }

    void notifySetMessageFilterOnRoad() {
        this.logger.trace("notifySetMessageFilterOnRoad()");
        this.dsiTmc.setMessageFilter(0, 1);
    }

    void notifyGetTmcMessage(int n) {
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("notifyGetTmcMessage(), msgID=").append(n).log();
        }
        this.dsiTmcOnRoute.getTmcMessage(n);
    }

    void notifyRequestTmcWindow(int n, int[] nArray) {
        this.logger.trace("notifyRequestTmcWindow()");
        this.dsiTmc.requestTmcWindow(0, n, 0, nArray, -3);
    }
}

