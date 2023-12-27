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
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.SourceState_Status;

public abstract class SourceStateStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$SourceState_Status;

    protected final SourceState_Status dequeueBAPEntity() {
        return (SourceState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$SourceState_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$SourceState_Status = SourceStateStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.SourceState_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$SourceState_Status);
    }

    @Override
    public int getFunctionId() {
        return 20;
    }

    protected final int getCurrentAudioComponent() {
        return this.context.getInteger(1470, 0);
    }

    protected final int getCurrentAudioSource() {
        return this.context.getInteger(8, 0);
    }

    protected final int getCDContentType() {
        return this.context.getInteger(3520, 0);
    }

    protected final boolean getMixActive() {
        return this.context.getBoolean(44, false);
    }

    protected final boolean getRepeatActive() {
        return this.context.getInteger(85, 0) != 0;
    }

    protected final boolean getIncludeSubfolders() {
        return this.context.getBoolean(41, true);
    }

    protected final int getRepeatMode() {
        return this.context.getInteger(85, 0);
    }

    protected final boolean getRadioScanning() {
        return this.context.getBoolean(1445, false);
    }

    protected final boolean getMixSupported() {
        return this.context.getBoolean(45, false);
    }

    protected final boolean getRepeatSupported() {
        return this.context.getBoolean(50, false);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1470, 8, 3520, 44, 49, 41, 85, 1445};
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

