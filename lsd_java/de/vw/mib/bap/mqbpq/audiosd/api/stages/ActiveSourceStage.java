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
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ActiveSource_Status;

public abstract class ActiveSourceStage
implements Property,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    protected final int BAP_STAGE_UPDATE_ID_CURRENT_STATION_INDICES;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ActiveSource_Status;

    public ActiveSourceStage() {
        this.BAP_STAGE_UPDATE_ID_CURRENT_STATION_INDICES = 0;
    }

    protected final ActiveSource_Status dequeueBAPEntity() {
        return (ActiveSource_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ActiveSource_Status == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ActiveSource_Status = ActiveSourceStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ActiveSource_Status")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$ActiveSource_Status);
    }

    @Override
    public int getFunctionId() {
        return 16;
    }

    protected final int getDabRadioListState() {
        return this.context.getInteger(1341, 0);
    }

    protected final int getAmRadioGetListState() {
        return this.context.getInteger(1317, 0);
    }

    protected final int getCurrentAudioSource() {
        return this.context.getInteger(8, 0);
    }

    protected final int getCurrentStationInfoBand() {
        return this.context.getInteger(1324, 1);
    }

    protected final int getPresetBankActiveIndex() {
        return this.context.getIntegerListValue(2486, 0);
    }

    protected final int getCurrentTrackNumber() {
        return this.context.getIntegerListValue(58, 7);
    }

    protected final int getCurrentAudioComponent() {
        return this.context.getInteger(1470, 0);
    }

    protected final int getCDContentType() {
        return this.context.getInteger(3520, 0);
    }

    protected final int getMediumType() {
        return this.context.getInteger(6, 0);
    }

    protected final boolean getDabAvailable() {
        return this.context.getBoolean(335, false);
    }

    protected final int getCurrentSatChannelNumber() {
        return this.context.getIntegerListValue(1308, 6);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1341, 1317, 8, 1324, 1470, 3520, 6, 335};
        int[] nArray2 = new int[]{58, 1308};
        bAPStageInitializer.observeAslPropertiesAndLists(this, nArray, nArray2, -1);
        int[] nArray3 = new int[]{2486};
        bAPStageInitializer.observeAslPropertiesAndLists(this, null, nArray3, 0);
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
            case 22: {
                this.setReceptionList((BAPArrayList)object);
                break;
            }
        }
    }

    protected abstract void setReceptionList(BAPArrayList bAPArrayList) {
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

