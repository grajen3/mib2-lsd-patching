/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.RouteGuidance_Status_Status;
import de.vw.mib.bap.mqbpq.navsd.api.stages.RouteGuidanceStatusStage;

public final class RouteGuidanceStatus
extends RouteGuidanceStatusStage {
    private Boolean instrumentClusterActionStatus = null;

    private void setRouteGuidanceStatus(RouteGuidance_Status_Status routeGuidance_Status_Status) {
        routeGuidance_Status_Status.rg_Status = this.getNavigationStatus() != 0 ? 0 : (this.instrumentClusterActionStatus != null ? (this.instrumentClusterActionStatus != false ? 1 : 0) : (this.getRouteGuidanceState() == 0 ? 0 : 1));
    }

    private void sendRouteGuidanceStatus(RouteGuidance_Status_Status routeGuidance_Status_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(routeGuidance_Status_Status, this);
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.computeRGStatusStatus();
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
        this.process(-1);
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendRouteGuidanceStatus(this.computeRGStatusStatus());
    }

    private RouteGuidance_Status_Status computeRGStatusStatus() {
        RouteGuidance_Status_Status routeGuidance_Status_Status = this.dequeueBAPEntity();
        this.setRouteGuidanceStatus(routeGuidance_Status_Status);
        return routeGuidance_Status_Status;
    }

    protected void setActionStateRunning(Boolean bl) {
        this.instrumentClusterActionStatus = bl;
        this.process(-1);
    }
}

