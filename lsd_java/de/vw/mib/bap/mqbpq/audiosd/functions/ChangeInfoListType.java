/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.ChangeInfoListTypeStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ChangeInfoListType_Result;

public final class ChangeInfoListType
extends ChangeInfoListTypeStage {
    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return null;
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
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.sendResult(1, methodListener);
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.sendResult(3, methodListener);
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

    private void sendResult(int n, MethodListener methodListener) {
        ChangeInfoListType_Result changeInfoListType_Result = this.dequeueBAPEntity();
        changeInfoListType_Result.changeInfoListTypeResult = n;
        methodListener.result(changeInfoListType_Result, this);
    }
}

