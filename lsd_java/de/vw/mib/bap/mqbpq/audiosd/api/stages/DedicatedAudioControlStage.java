/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.LongIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.DedicatedAudioControl_Result;

public abstract class DedicatedAudioControlStage
implements Method,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$DedicatedAudioControl_Result;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Integer;

    protected final DedicatedAudioControl_Result dequeueBAPEntity() {
        return (DedicatedAudioControl_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$DedicatedAudioControl_Result == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$DedicatedAudioControl_Result = DedicatedAudioControlStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.DedicatedAudioControl_Result")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$DedicatedAudioControl_Result);
    }

    @Override
    public int getFunctionId() {
        return 23;
    }

    protected final int getCurrentAudioComponent() {
        return this.context.getInteger(1470, 0);
    }

    protected final boolean getRadioScanning() {
        return this.context.getBoolean(1445, false);
    }

    protected final int getCurrentStationInfoBand() {
        return this.context.getInteger(1324, 1);
    }

    protected final boolean getRadioSeekActive() {
        return this.context.getBoolean(1446, false);
    }

    protected final boolean getManualModeActive() {
        return this.context.getBoolean(1438, false);
    }

    protected final LongIterator getReceptionListUniqueId() {
        return this.context.getLongListIterator(1270, 0);
    }

    protected final long getStationListActiveIndex() {
        return this.context.getLongListValue(2486, 1);
    }

    protected final int getPresetBankActiveIndex() {
        return this.context.getIntegerListValue(2486, 0);
    }

    protected final int getCDContentType() {
        return this.context.getInteger(3520, 0);
    }

    protected final int getCurrentAudioSource() {
        return this.context.getInteger(8, 0);
    }

    protected final int getDvdChapterCount() {
        return this.context.getInteger(125, 0);
    }

    protected final boolean getSkipForwardSupported() {
        return this.context.getBoolean(55, false);
    }

    protected final boolean getSkipBackwardSupported() {
        return this.context.getBoolean(54, false);
    }

    protected final boolean getAvdcRepeatActive() {
        return this.context.getBoolean(49, false);
    }

    protected final int getAvdcRepeatMode() {
        return this.context.getInteger(85, 0);
    }

    protected final int getCurrentMainContext() {
        return this.context.getInteger(1612, 0);
    }

    protected final int getArrawKeyScopeMode() {
        return this.context.getInteger(1412, 1);
    }

    protected abstract void videoDvdUserActionBlocked() {
    }

    protected abstract void tunerInitialAutoStoreStarted() {
    }

    @Override
    public boolean hmiEvent(int n) {
        switch (n) {
            case 430: {
                this.videoDvdUserActionBlocked();
                break;
            }
            case 201: {
                this.tunerInitialAutoStoreStarted();
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{430, 201};
        bAPStageInitializer.observeHMIEvents(this, nArray);
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
            case 29: {
                this.setBapInfoListType((Integer)object);
                break;
            }
            case 21: {
                if (object.getClass() == (class$java$lang$Boolean == null ? (class$java$lang$Boolean = DedicatedAudioControlStage.class$("java.lang.Boolean")) : class$java$lang$Boolean)) {
                    this.setCurrentStationHandleRequested((Boolean)object);
                    break;
                }
                if (object.getClass() != (class$java$lang$Integer == null ? (class$java$lang$Integer = DedicatedAudioControlStage.class$("java.lang.Integer")) : class$java$lang$Integer)) break;
                this.setCurrentFsgHandle((Integer)object);
                break;
            }
        }
    }

    protected abstract void setReceptionList(BAPArrayList bAPArrayList) {
    }

    protected abstract void setBapInfoListType(Integer n) {
    }

    protected abstract void setCurrentFsgHandle(Integer n) {
    }

    protected abstract void setCurrentStationHandleRequested(Boolean bl) {
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

