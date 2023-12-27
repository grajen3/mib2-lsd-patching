/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.CurrentPositionInfo_Status;
import de.vw.mib.bap.mqbpq.navsd.api.stages.CurrentPositionInfoStage;

public class CurrentPositionInfo
extends CurrentPositionInfoStage {
    private void setCurrentPositionInfoStatusData(CurrentPositionInfo_Status currentPositionInfo_Status) {
        String string = this.getCurrentPositionInfo();
        if (string == null || this.getNavigationStatus() != 0) {
            currentPositionInfo_Status.positionInfo.setContent("");
        } else {
            currentPositionInfo_Status.positionInfo.setContent(string);
        }
    }

    private void sendCurrentPositionInfoStatus(CurrentPositionInfo_Status currentPositionInfo_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(currentPositionInfo_Status, this);
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return super.init(bAPStageInitializer);
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
        this.sendCurrentPositionInfoStatus(this.computeCurrentPositionInfoStatus());
    }

    protected CurrentPositionInfo_Status computeCurrentPositionInfoStatus() {
        CurrentPositionInfo_Status currentPositionInfo_Status = this.dequeueBAPEntity();
        this.setCurrentPositionInfoStatusData(currentPositionInfo_Status);
        return currentPositionInfo_Status;
    }
}

