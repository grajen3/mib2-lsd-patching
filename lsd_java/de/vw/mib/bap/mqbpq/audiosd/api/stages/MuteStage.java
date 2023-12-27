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
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.Mute_Status;

public abstract class MuteStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$Mute_Status;

    protected final Mute_Status dequeueBAPEntity() {
        return (Mute_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$Mute_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$Mute_Status = MuteStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.Mute_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$Mute_Status);
    }

    @Override
    public int getFunctionId() {
        return 19;
    }

    protected final int getMuteActive() {
        return this.context.getInteger(1509, 0);
    }

    protected final int getHdRadioState() {
        return this.context.getInteger(1394, 3);
    }

    protected final int getCurrentFmHdChannelNumber() {
        return this.context.getIntegerListValue(1456, 6);
    }

    protected final int getDabEnsembleState() {
        return this.context.getInteger(1339, 0);
    }

    protected final int getDabServiceState() {
        return this.context.getInteger(1356, 0);
    }

    protected final int getCurrentAudioComponent() {
        return this.context.getInteger(1470, 0);
    }

    protected final int getCurrentStationInfoBand() {
        return this.context.getInteger(1324, 1);
    }

    protected final int getComponentProtectionActive() {
        return this.context.getInteger(1652, 0);
    }

    protected final int getSatTunerState() {
        return this.context.getInteger(1291, 1);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1509, 1394, 1339, 1356, 1470, 1324, 1652, 1291};
        int[] nArray2 = new int[]{1456};
        bAPStageInitializer.observeAslPropertiesAndLists(this, nArray, nArray2, -1);
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

