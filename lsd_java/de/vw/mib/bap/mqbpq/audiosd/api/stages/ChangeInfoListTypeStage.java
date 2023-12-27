/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ChangeInfoListType_Result;

public abstract class ChangeInfoListTypeStage
implements Method,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ChangeInfoListType_Result;

    protected final ChangeInfoListType_Result dequeueBAPEntity() {
        return (ChangeInfoListType_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ChangeInfoListType_Result == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ChangeInfoListType_Result = ChangeInfoListTypeStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ChangeInfoListType_Result")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ChangeInfoListType_Result);
    }

    @Override
    public int getFunctionId() {
        return 31;
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
    }

    @Override
    public final void setDelegate(BAPStageContext bAPStageContext) {
        this.context = bAPStageContext;
    }

    protected final BAPFunctionControllerDelegate getDelegate() {
        return this.context;
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.customInitialization(bAPStageInitializer);
        return null;
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
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

