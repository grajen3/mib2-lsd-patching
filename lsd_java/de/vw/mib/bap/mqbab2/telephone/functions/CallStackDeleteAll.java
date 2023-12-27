/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallStackDeleteAll_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallStackDeleteAll_StartResult;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class CallStackDeleteAll
extends Function
implements Method,
ASLTelephoneConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallStackDeleteAll_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected CallStackDeleteAll_Result dequeueBAPEntity() {
        return (CallStackDeleteAll_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallStackDeleteAll_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallStackDeleteAll_Result = CallStackDeleteAll.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallStackDeleteAll_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallStackDeleteAll_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 50;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        methodListener.requestError(80, this);
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        PhoneService phoneService = this.getPhoneService();
        CallStackDeleteAll_StartResult callStackDeleteAll_StartResult = (CallStackDeleteAll_StartResult)bAPEntity;
        boolean bl = false;
        if (callStackDeleteAll_StartResult.storage.deleteMissedCalls) {
            phoneService.clearCallStack(2);
            bl = true;
        }
        if (callStackDeleteAll_StartResult.storage.deleteReceivedCalls) {
            phoneService.clearCallStack(1);
            bl = true;
        }
        if (callStackDeleteAll_StartResult.storage.deleteDialedNumbers) {
            phoneService.clearCallStack(0);
            bl = true;
        }
        CallStackDeleteAll_Result callStackDeleteAll_Result = this.dequeueBAPEntity();
        callStackDeleteAll_Result.callStackDeleteAll_Result = bl ? 0 : 1;
        this.getDelegate().getMethodListener(this).result(callStackDeleteAll_Result, this);
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

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
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

