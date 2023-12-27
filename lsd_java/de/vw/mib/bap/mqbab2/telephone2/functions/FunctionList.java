/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.FunctionList_Status;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;

public class FunctionList
extends Function
implements Property,
ASLTelephone2Constants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$FunctionList_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return FunctionList.usedFunctionList();
    }

    protected FunctionList_Status dequeueBAPEntity() {
        return (FunctionList_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$FunctionList_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$FunctionList_Status = FunctionList.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.FunctionList_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$FunctionList_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 3;
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
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    private static FunctionList_Status usedFunctionList() {
        FunctionList_Status functionList_Status = new FunctionList_Status();
        functionList_Status.fctGetAllSupported = false;
        functionList_Status.fctBapConfigSupported = true;
        functionList_Status.fctFunctionListSupported = true;
        functionList_Status.fctHeartbeatSupported = true;
        functionList_Status.fctFsg_SetupSupported = true;
        functionList_Status.fctFsg_OperationStateSupported = true;
        functionList_Status.fctMobileServiceSupportSupported = true;
        functionList_Status.fctRegisterState2Supported = true;
        functionList_Status.fctLockState2Supported = true;
        functionList_Status.fctNetworkProvider2Supported = true;
        functionList_Status.fctSignalQuality2Supported = true;
        functionList_Status.fctDataConnectionIndication2Supported = true;
        functionList_Status.fctEmailStateSupported = true;
        functionList_Status.fctPhoneModuleStateSupported = true;
        functionList_Status.fctConnectionStateSupported = true;
        functionList_Status.fctAutomaticCallForwardingSupported = true;
        return functionList_Status;
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

