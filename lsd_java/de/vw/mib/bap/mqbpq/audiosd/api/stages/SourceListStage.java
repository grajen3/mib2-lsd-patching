/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.BooleanIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;

public abstract class SourceListStage
implements BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;

    protected final boolean setSourceListChanged(BAPEntity bAPEntity) {
        return false;
    }

    protected void setFullSourceList(BAPArrayList bAPArrayList) {
        int[] nArray = new int[]{17};
        this.context.updateStages(this, nArray, bAPArrayList);
    }

    protected void setReportedSourceListReference(Integer n) {
        int[] nArray = new int[]{17};
        this.context.updateStages(this, nArray, n);
    }

    @Override
    public int getFunctionId() {
        return 32;
    }

    protected final boolean getDabAvailable() {
        return this.context.getBoolean(335, false);
    }

    protected final boolean getAmAvailable() {
        return this.context.getBoolean(334, false);
    }

    protected final boolean getSecondUsbSocketAvailable() {
        return this.context.getBoolean(3678, false);
    }

    protected final boolean getMetaInfoRequestSupported() {
        return this.context.getBoolean(2781, false);
    }

    protected final IntegerIterator getAvailableAudioSources() {
        return this.context.getIntegerListIterator(56, 0);
    }

    protected final BooleanIterator getAvailableAudioSourcesIsActive() {
        return this.context.getBooleanListIterator(56, 1);
    }

    protected final BooleanIterator getAvailableAudioSourcesEnabled() {
        return this.context.getBooleanListIterator(56, 2);
    }

    protected final StringIterator getAvailableAudioSourcesSourceName() {
        return this.context.getStringListIterator(56, 3);
    }

    protected final IntegerIterator getAvailableAudioSourcesMediaType() {
        return this.context.getIntegerListIterator(56, 4);
    }

    protected final IntegerIterator getAvailableAudioSourcesMediaFlag() {
        return this.context.getIntegerListIterator(56, 5);
    }

    protected final int getCurrentAudioComponent() {
        return this.context.getInteger(1470, 0);
    }

    protected final int getCurrentStationInfoBand() {
        return this.context.getInteger(1324, 1);
    }

    protected final int getCurrentAudioSource() {
        return this.context.getInteger(8, 0);
    }

    protected abstract void nextAudioSource() {
    }

    protected abstract void nextAudioComponent() {
    }

    @Override
    public boolean hmiEvent(int n) {
        switch (n) {
            case 203: {
                this.nextAudioSource();
                break;
            }
            case 204: {
                this.nextAudioComponent();
                break;
            }
            default: {
                return false;
            }
        }
        return true;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{335, 334, 2781, 3678, 1470, 1324, 8};
        int[] nArray2 = new int[]{56};
        bAPStageInitializer.observeAslPropertiesAndLists(this, nArray, nArray2, -1);
        int[] nArray3 = new int[]{203, 204};
        bAPStageInitializer.observeHMIEvents(this, nArray3);
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
}

