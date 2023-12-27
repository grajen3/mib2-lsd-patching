/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FunctionList_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class FunctionList
extends Function
implements Property,
ASLTelephoneConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FunctionList_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return FunctionList.usedFunctionList();
    }

    protected FunctionList_Status dequeueBAPEntity() {
        return (FunctionList_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FunctionList_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FunctionList_Status = FunctionList.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.FunctionList_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FunctionList_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 3;
    }

    private static FunctionList_Status usedFunctionList() {
        FunctionList_Status functionList_Status = new FunctionList_Status();
        functionList_Status.fctGetAllSupported = false;
        functionList_Status.fctBapConfigSupported = true;
        functionList_Status.fctFunctionListSupported = true;
        functionList_Status.fctHeartbeatSupported = true;
        functionList_Status.fctFsg_SetupSupported = true;
        functionList_Status.fctFsg_OperationStateSupported = true;
        functionList_Status.fctMobileServiceSupportAvailable = true;
        functionList_Status.fctActiveUserSupported = true;
        functionList_Status.fctRegisterStateSupported = true;
        functionList_Status.fctLockStateSupported = true;
        functionList_Status.fctNetworkProviderSupported = true;
        functionList_Status.fctSignalQualitySupported = true;
        functionList_Status.fctCallStateSupported = true;
        functionList_Status.fctCallInfoSupported = true;
        functionList_Status.fctCallDurationSyncSupported = true;
        functionList_Status.fctDisconnectReasonSupported = true;
        functionList_Status.fctDialNumberSupported = true;
        functionList_Status.fctDialServiceSupported = true;
        functionList_Status.fctConfirmEmergencyCallSupported = true;
        functionList_Status.fctHangupCallSupported = true;
        functionList_Status.fctAcceptCallSupported = true;
        functionList_Status.fctCallHoldSupported = true;
        functionList_Status.fctResumeCallSupported = true;
        functionList_Status.fctHandsFreeOnOffSupported = true;
        functionList_Status.fctMicroMuteOnOffSupported = true;
        functionList_Status.fctMpreleaseActiveCallAcceptWaitingCallSupported = true;
        functionList_Status.fctMpswapSupported = true;
        functionList_Status.fctMpcallHoldAcceptWaitingCallSupported = true;
        functionList_Status.fctMpreleaseAllCallsAcceptWaitingCallSupported = true;
        functionList_Status.fctMpsetWaitingCallOnHoldSupported = true;
        functionList_Status.fctCcjoinSupported = true;
        functionList_Status.fctCcsplitSupported = true;
        functionList_Status.fctKeypadSupported = false;
        functionList_Status.fctMobileBatteryLevelSupported = true;
        functionList_Status.fctDataConnectionIndicationSupported = true;
        functionList_Status.fctMissedCallIndicationSupported = true;
        functionList_Status.fctMissedCallsSupported = true;
        functionList_Status.fctReceivedCallsSupported = true;
        functionList_Status.fctDialedNumbersSupported = true;
        functionList_Status.fctCombinedNumbersSupported = true;
        functionList_Status.fctCallStackDeleteAllSupported = true;
        functionList_Status.fctPbStateSupported = true;
        functionList_Status.fctPhonebookSupported = true;
        functionList_Status.fctPbSpellerSupported = true;
        functionList_Status.fctGetNextListPosSupported = true;
        functionList_Status.fctSmsstateSupported = true;
        functionList_Status.fctRingToneMuteOnOffSupported = true;
        functionList_Status.fctAutomaticRedialSupported = true;
        functionList_Status.fctAutomaticRedialExtendedInfoSupported = false;
        functionList_Status.fctSupportedServiceNumbersSupported = true;
        functionList_Status.fctFavoriteListSupported = true;
        return functionList_Status;
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
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

