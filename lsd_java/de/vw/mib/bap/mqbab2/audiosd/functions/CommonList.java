/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CommonList_ChangedArray;

public class CommonList
extends Function {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CommonList_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return null;
    }

    protected CommonList_ChangedArray dequeueBAPEntity() {
        return (CommonList_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CommonList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CommonList_ChangedArray = CommonList.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CommonList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CommonList_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 50;
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

    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
    }

    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
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

