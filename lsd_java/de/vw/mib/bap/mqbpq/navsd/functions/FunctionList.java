/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.FunctionList_Status;
import de.vw.mib.bap.mqbpq.navsd.api.stages.FunctionListStage;

public class FunctionList
extends FunctionListStage {
    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return FunctionList.usedFunctionList();
    }

    private static FunctionList_Status usedFunctionList() {
        FunctionList_Status functionList_Status = new FunctionList_Status();
        functionList_Status.fctIdGetAllSupported = false;
        functionList_Status.fctIdBapConfigSupported = true;
        functionList_Status.fctIdFunctionListSupported = true;
        functionList_Status.fctIdHeartbeatSupported = true;
        functionList_Status.fctIdFsgControlSupported = false;
        functionList_Status.fctIdFsgSetupSupported = false;
        functionList_Status.fctIdFsgOperationStateSupported = true;
        functionList_Status.fctIdCompassInfoSupported = true;
        functionList_Status.fctIdRouteGuidance_StatusSupported = true;
        functionList_Status.fctIdDistanceToNextManeuverSupported = true;
        functionList_Status.fctIdCurrentPositionInfoSupported = true;
        functionList_Status.fctIdTurnToInfoSupported = true;
        functionList_Status.fctIdDistanceTimeToDestinationSupported = true;
        functionList_Status.fctIdManeuverDescriptorSupported = true;
        return functionList_Status;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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
    public void process(int n) {
    }
}

