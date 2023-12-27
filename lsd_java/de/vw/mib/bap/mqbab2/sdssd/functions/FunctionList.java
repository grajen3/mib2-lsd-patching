/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.FunctionList_Status;

public final class FunctionList
extends Function
implements Property {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FunctionList_Status;

    protected FunctionList_Status dequeueBAPEntity() {
        return (FunctionList_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FunctionList_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FunctionList_Status = FunctionList.class$("de.vw.mib.bap.mqbab2.generated.sdssd.serializer.FunctionList_Status")) : class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FunctionList_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 3;
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.usedFunctionList();
    }

    private FunctionList_Status usedFunctionList() {
        FunctionList_Status functionList_Status = this.dequeueBAPEntity();
        functionList_Status.functionGetAllAvailable = false;
        functionList_Status.functionBap_ConfigAvailable = true;
        functionList_Status.functionFunctionListAvailable = true;
        functionList_Status.functionHeartbeatAvailable = true;
        functionList_Status.functionFsg_SetupAvailable = true;
        functionList_Status.functionFsg_OperationStateAvailable = true;
        functionList_Status.functionAsg_CapabilitiesAvailable = true;
        functionList_Status.functionSds_ContextStateAvailable = true;
        functionList_Status.functionCommandListAvailable = true;
        functionList_Status.functionResultListAvailable = true;
        functionList_Status.functionInfoStatesAvailable = true;
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
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
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
    public void process(int n) {
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

