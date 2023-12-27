/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ActiveSourceName_Status;

public abstract class ActiveSourceNameStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ActiveSourceName_Status;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$common$arrays$BAPArrayList;

    protected final ActiveSourceName_Status dequeueBAPEntity() {
        return (ActiveSourceName_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ActiveSourceName_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ActiveSourceName_Status = ActiveSourceNameStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ActiveSourceName_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ActiveSourceName_Status);
    }

    @Override
    public int getFunctionId() {
        return 17;
    }

    protected final int getCurrentAudioComponent() {
        return this.context.getInteger(1470, 0);
    }

    protected final int getCurrentAudioSource() {
        return this.context.getInteger(8, 0);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1470, 8};
        bAPStageInitializer.observeAslPropertiesAndLists(this, nArray, null, -1);
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
        switch (bAPStage.getFunctionId()) {
            case 32: {
                if (object.getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = ActiveSourceNameStage.class$("java.lang.Integer")) : class$java$lang$Integer)) {
                    this.setReportedSourceListReference((Integer)object);
                    break;
                }
                if (object.getClass() != (class$de$vw$mib$bap$mqbpq$common$arrays$BAPArrayList == null ? (class$de$vw$mib$bap$mqbpq$common$arrays$BAPArrayList = ActiveSourceNameStage.class$("de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList")) : class$de$vw$mib$bap$mqbpq$common$arrays$BAPArrayList)) break;
                this.setFullSourceList((BAPArrayList)object);
                break;
            }
        }
    }

    protected abstract void setReportedSourceListReference(Integer n) {
    }

    protected abstract void setFullSourceList(BAPArrayList bAPArrayList) {
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

