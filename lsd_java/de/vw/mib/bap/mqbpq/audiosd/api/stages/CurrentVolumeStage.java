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
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentVolume_Status;

public abstract class CurrentVolumeStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$CurrentVolume_Status;

    protected final CurrentVolume_Status dequeueBAPEntity() {
        return (CurrentVolume_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$CurrentVolume_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$CurrentVolume_Status = CurrentVolumeStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentVolume_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$CurrentVolume_Status);
    }

    @Override
    public int getFunctionId() {
        return 18;
    }

    protected final int getVolumeEntertainment() {
        return this.context.getInteger(1493, 0);
    }

    protected final int getCurrentDdsVolumeFocus() {
        return this.context.getInteger(1472, 0);
    }

    protected final int getVolumeNavi() {
        return this.context.getInteger(1496, 0);
    }

    protected final int getVolumeTA() {
        return this.context.getInteger(1503, 0);
    }

    protected final int getVolumePhone() {
        return this.context.getInteger(1500, 0);
    }

    protected final int getVolumeSDS() {
        return this.context.getInteger(1502, 0);
    }

    protected final int getCurrentDabEnsembleState() {
        return this.context.getInteger(1339, 0);
    }

    protected abstract void mflVolumeChange() {
    }

    @Override
    public boolean hmiEvent(int n) {
        switch (n) {
            case 232: {
                this.mflVolumeChange();
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1493, 1496, 1503, 1500, 1502, 1472, 1339};
        bAPStageInitializer.observeAslPropertiesAndLists(this, nArray, null, -1);
        int[] nArray2 = new int[]{232};
        bAPStageInitializer.observeHMIEvents(this, nArray2);
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

