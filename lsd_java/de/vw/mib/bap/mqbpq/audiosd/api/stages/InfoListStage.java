/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.api.stages;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.LongIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.ASLAudioSDConstants;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoList_ChangedArray;

public abstract class InfoListStage
implements Array,
BAPStage,
ASLAudioSDConstants {
    private BAPStageContext context;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$InfoList_ChangedArray;

    protected void setReceptionList(BAPArrayList bAPArrayList) {
        int[] nArray = new int[]{21, 16, 23};
        this.context.updateStages(this, nArray, bAPArrayList);
    }

    protected final InfoList_ChangedArray dequeueBAPEntity() {
        return (InfoList_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$InfoList_ChangedArray == null ? (class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$InfoList_ChangedArray = InfoListStage.class$("de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoList_ChangedArray")) : class$de$vw$mib$bap$mqbpq$generated$audiosd$serializer$InfoList_ChangedArray);
    }

    @Override
    public int getFunctionId() {
        return 22;
    }

    protected final LongIterator getReceptionListUniqueId() {
        return this.context.getLongListIterator(1270, 0);
    }

    protected final StringIterator getReceptionListDABFrequency() {
        return this.context.getStringListIterator(1270, 10);
    }

    protected final StringIterator getReceptionListShortName() {
        return this.context.getStringListIterator(1270, 8);
    }

    protected final LongIterator getReceptionListParentUniqueId() {
        return this.context.getLongListIterator(1270, 1);
    }

    protected final IntegerIterator getReceptionListType() {
        return this.context.getIntegerListIterator(1270, 2);
    }

    protected final IntegerIterator getReceptionListAttributes() {
        return this.context.getIntegerListIterator(1270, 3);
    }

    protected final IntegerIterator getReceptionListPresetId() {
        return this.context.getIntegerListIterator(1270, 4);
    }

    protected final IntegerIterator getReceptionListFmRegCode() {
        return this.context.getIntegerListIterator(1270, 5);
    }

    protected final IntegerIterator getReceptionListCategory() {
        return this.context.getIntegerListIterator(1270, 6);
    }

    protected final StringIterator getReceptionListName() {
        return this.context.getStringListIterator(1270, 7);
    }

    protected final IntegerIterator getReceptionListFrequency() {
        return this.context.getIntegerListIterator(1270, 9);
    }

    protected final IntegerIterator getReceptionListChannel() {
        return this.context.getIntegerListIterator(1270, 11);
    }

    protected final int getFmFrequencyScale() {
        return this.context.getInteger(1366, 0);
    }

    protected final boolean getPiCodingActivated() {
        return this.context.getBoolean(1426, true);
    }

    protected final int getCurrentStationInfoBand() {
        return this.context.getInteger(1324, 1);
    }

    protected final int getArrowKeyScopeMode() {
        return this.context.getInteger(1412, 1);
    }

    protected final IntegerIterator getAmPresetListInfoFrequence() {
        return this.context.getIntegerListIterator(1451, 0);
    }

    protected final IntegerIterator getAmPresetListInfoHDStationNumber() {
        return this.context.getIntegerListIterator(1451, 2);
    }

    protected final StringIterator getDabPresetListInfoName() {
        return this.context.getStringListIterator(1458, 5);
    }

    protected final StringIterator getFmPresetListInfoName() {
        return this.context.getStringListIterator(1461, 8);
    }

    protected final IntegerIterator getFmPresetListInfoFrequencies() {
        return this.context.getIntegerListIterator(1461, 1);
    }

    protected final IntegerIterator getFmPresetListInfoHDStationNumber() {
        return this.context.getIntegerListIterator(1461, 3);
    }

    protected final StringIterator getSiriusPresetListInfoName() {
        return this.context.getStringListIterator(1313, 3);
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    private void customInitialization(BAPStageInitializer bAPStageInitializer) {
        int[] nArray = new int[]{1366, 1426, 1324, 1412};
        int[] nArray2 = new int[]{1270, 1313, 1461, 1451, 1458};
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
        switch (bAPStage.getFunctionId()) {
            case 29: {
                this.setBapInfoListType((Integer)object);
                break;
            }
        }
    }

    protected abstract void setBapInfoListType(Integer n) {
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

