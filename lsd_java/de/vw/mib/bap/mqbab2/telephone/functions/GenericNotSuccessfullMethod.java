/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.HangupCall_Result;

public class GenericNotSuccessfullMethod
extends Function
implements Method {
    private int functionId;
    private int notSuccessfullResultIdentifier;
    private Class resultClass;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result;

    public GenericNotSuccessfullMethod(int n, int n2, Class clazz) {
        this.functionId = n;
        this.notSuccessfullResultIdentifier = n2;
        this.resultClass = clazz;
    }

    protected HangupCall_Result dequeueBAPEntity() {
        return (HangupCall_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result = GenericNotSuccessfullMethod.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.HangupCall_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result);
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return this.functionId;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        HangupCall_Result hangupCall_Result = this.dequeueBAPEntity();
        hangupCall_Result.hangupCall_Result = this.notSuccessfullResultIdentifier;
        this.getDelegate().getMethodListener(this).result(hangupCall_Result, this);
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        HangupCall_Result hangupCall_Result = this.dequeueBAPEntity();
        hangupCall_Result.hangupCall_Result = this.notSuccessfullResultIdentifier;
        this.getDelegate().getMethodListener(this).result(hangupCall_Result, this);
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

