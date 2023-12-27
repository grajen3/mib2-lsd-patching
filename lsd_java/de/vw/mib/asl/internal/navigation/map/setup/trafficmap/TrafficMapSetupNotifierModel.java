/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map.setup.trafficmap;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;

public class TrafficMapSetupNotifierModel {
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[TrafficMapSetupNotifierModel]");

    TrafficMapSetupNotifierModel() {
    }

    void notifyOnlineTrafficInvisible() {
        this.logger.trace("notifyOnlineTrafficInvisible()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3838, false);
    }

    void notifyOnlineTrafficVisible() {
        this.logger.trace("notifyOnlineTrafficVisible()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3838, true);
    }

    void notifyShowTrafficCongestions(boolean bl) {
        this.logger.trace("notifyShowTrafficCongestions()");
        AbstractASLHsmTarget.writeBooleanToDatapool(4171, bl);
    }

    void notifyShowTrafficFreeFlow(boolean bl) {
        this.logger.trace("notifyShowTrafficFreeFlow()");
        AbstractASLHsmTarget.writeBooleanToDatapool(4170, bl);
    }

    void notifyShowTrafficIncidents(boolean bl) {
        this.logger.trace("notifyShowTrafficIncidents()");
        AbstractASLHsmTarget.writeBooleanToDatapool(4172, bl);
    }

    void notifySpeedAndFlowButtonDisabled() {
        this.logger.trace("notifySpeedAndFlowButtonDisabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3876, false);
    }

    void notifySpeedAndFlowButtonEnabled() {
        this.logger.trace("notifySpeedAndFlowButtonEnabled()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3876, true);
    }

    void notifyTrafficSDARSAvailable(boolean bl) {
        this.logger.trace("notifyTrafficSDARSAvailable()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3576, bl);
    }

    void notifyTrafficSDARSInvisible() {
        this.logger.trace("notifyTrafficSDARSInvisible()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3567, false);
    }

    void notifyTrafficSDARSSubscribed(boolean bl) {
        this.logger.trace("notifyTrafficSDARSSubscribed()");
        AbstractASLHsmTarget.writeBooleanToDatapool(-2064642048, bl);
    }

    void notifyTrafficSDARSVisible() {
        this.logger.trace("notifyTrafficSDARSVisible()");
        AbstractASLHsmTarget.writeBooleanToDatapool(3567, true);
    }

    void notifyVicsTrafficFlowTypeAllRoads() {
        this.logger.trace("notifyVicsTrafficFlowTypeAllRoads()");
        AbstractASLHsmTarget.writeIntegerToDatapool(-1108340736, 0);
    }

    void notifyVicsTrafficFlowTypeAutomatic() {
        this.logger.trace("notifyVicsTrafficFlowTypeAutomatic()");
        AbstractASLHsmTarget.writeIntegerToDatapool(-1108340736, 3);
    }

    void notifyVicsTrafficFlowTypeHighways() {
        this.logger.trace("notifyVicsTrafficFlowTypeHighways()");
        AbstractASLHsmTarget.writeIntegerToDatapool(-1108340736, 1);
    }

    void notifyVicsTrafficFlowTypeNormalRoads() {
        this.logger.trace("notifyVicsTrafficFlowTypeNormalRoads()");
        AbstractASLHsmTarget.writeIntegerToDatapool(-1108340736, 2);
    }

    public void notifySpeedAndFlowRoadClass(int n) {
        AbstractASLHsmTarget.writeIntegerToDatapool(-1108340736, n);
    }
}

