/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaFileInfo_Result;

public final class MediaFileInfo
extends Function {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaFileInfo_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected MediaFileInfo_Result dequeueBAPEntity() {
        return (MediaFileInfo_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaFileInfo_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaFileInfo_Result = MediaFileInfo.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaFileInfo_Result")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaFileInfo_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 39;
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

    public void requestAcknowledge() {
    }

    public void errorAcknowledge() {
    }

    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
    }

    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
    }

    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
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

