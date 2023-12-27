/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.InfoListStage;
import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDCommon;
import de.vw.mib.bap.mqbpq.common.api.adapter.LanguageUtil;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.LongIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.ArrayRequestData;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayElementComparator;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$DeltaContext;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayListGenericIDGenerator;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoList_ChangedArray;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoList_Data;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoList_GetArray;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoList_StatusArray;

public class InfoList
extends InfoListStage
implements TimerNotifier,
BAPArrayList$BAPArrayElementComparator {
    private BAPArrayList _infoList;
    private BAPStageInitializer _stageInitializer;
    protected LanguageUtil _languageUtil;
    private int _lastAslRadioBand = 1;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_TYPE_ATTRIBUTES;
    private static final int MAX_ELEMENTS_NAME;
    private static final int MAX_ELEMENTS_POS;
    private Timer _updateTimer;
    private Timer _timerAfterBandChange;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ASL_UPDATE_INSTANCE_ID;
    private static final int TIMER_AFTER_BAND_CHANGE_TIME;
    private static final int TIMER_AFTER_BAND_CHANGE_INSTANCE_ID;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        this.setStageInitializer(bAPStageInitializer);
        return this.getFullRangeReceptionListContent();
    }

    private BAPStageInitializer getStageInitializer() {
        return this._stageInitializer;
    }

    private void setStageInitializer(BAPStageInitializer bAPStageInitializer) {
        this._stageInitializer = bAPStageInitializer;
    }

    protected BAPArrayList getInfoList() {
        if (this._infoList == null) {
            this._infoList = new BAPArrayList(new BAPArrayListGenericIDGenerator(-65536, 1));
        }
        return this._infoList;
    }

    protected Timer getUpdateTimer() {
        if (this._updateTimer == null) {
            this._updateTimer = this.getStageInitializer().createTimer(this, this, 0, 0);
        }
        return this._updateTimer;
    }

    private Timer getTimerAfterBandChange() {
        if (this._timerAfterBandChange == null) {
            this._timerAfterBandChange = this.getStageInitializer().createTimer(this, this, 0, 1);
        }
        return this._timerAfterBandChange;
    }

    protected LanguageUtil getLanguageUtil() {
        if (this._languageUtil == null) {
            this._languageUtil = this.getStageInitializer().createLanguageUtil(this);
        }
        return this._languageUtil;
    }

    private int getLastAslRadioBand() {
        return this._lastAslRadioBand;
    }

    private void setLastAslRadioBand(int n) {
        this._lastAslRadioBand = n;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getLanguageUtil().uninitialize();
        this.getUpdateTimer().stop();
    }

    @Override
    public void process(int n) {
        int n2 = this.getCurrentStationInfoBand();
        if (this.getLastAslRadioBand() != n2 || !this.getUpdateTimer().isRunning() && !this.getTimerAfterBandChange().isRunning()) {
            if (this.getLastAslRadioBand() != n2) {
                this.setLastAslRadioBand(n2);
                this.getInfoList().clear();
                this.getDelegate().getArrayListener(this).changedArray(this.getFullRangeReceptionListContent(), this);
                this.setReceptionList(this.getInfoList());
                this.getTimerAfterBandChange().retrigger(1);
            } else {
                InfoList_ChangedArray infoList_ChangedArray;
                if (this.getInfoList().numberOfMappedIDValues() > 5000) {
                    this.getInfoList().clear();
                    this.computeFullInfoList();
                    infoList_ChangedArray = this.getFullRangeReceptionListContent();
                } else {
                    BAPArrayList.DeltaContext deltaContext = this.getInfoList().createNewDeltaContext(this);
                    this.computeFullInfoList();
                    infoList_ChangedArray = this.searchForChangedContent(deltaContext);
                }
                if (infoList_ChangedArray != null) {
                    this.getDelegate().getArrayListener(this).changedArray(infoList_ChangedArray, this);
                    this.setReceptionList(this.getInfoList());
                    this.getUpdateTimer().retrigger(0);
                }
            }
        } else {
            this.getUpdateTimer().setUserInfo(1);
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        InfoList_GetArray infoList_GetArray = (InfoList_GetArray)bAPEntity;
        ArrayRequestData arrayRequestData = ArrayRequestData.computeArrayRequestData(infoList_GetArray.getArrayHeader(), this.getInfoList(), InfoList.maximumElementsForRecordAddress(infoList_GetArray.getArrayHeader().getRecordAddress()));
        InfoList_StatusArray infoList_StatusArray = new InfoList_StatusArray();
        arrayRequestData.setStatusArrayHeaderData(infoList_StatusArray, infoList_GetArray.getArrayHeader(), this.getInfoList().getIDGenerator().isLongID());
        infoList_StatusArray.totalNumListElements = this.getInfoList().size();
        arrayRequestData.fillRequestData((BAPStatusArray)infoList_StatusArray, this.getInfoList());
        arrayRequestData.setTransmissionPosForArbitraryArray(infoList_StatusArray);
        arrayListener.statusArray(infoList_StatusArray, this);
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        int n2;
        InfoList_Data infoList_Data = (InfoList_Data)bAPArrayElement;
        InfoList_Data infoList_Data2 = (InfoList_Data)bAPArrayElement2;
        boolean bl = infoList_Data.name.toString().intern() == infoList_Data2.name.toString().intern();
        boolean bl2 = infoList_Data.attributes.selectable == infoList_Data2.attributes.selectable;
        boolean bl3 = infoList_Data.type == infoList_Data2.type;
        switch (n) {
            case -1: {
                if (!(bl || bl2 || bl3)) {
                    n2 = 0;
                }
                if (!(bl3 && bl2 || !bl)) {
                    n2 = 2;
                    break;
                }
                if (!bl) {
                    n2 = 1;
                    break;
                }
                n2 = -1;
                break;
            }
            case 0: {
                if (!(bl && bl2 && bl3)) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            case 1: {
                if (!bl2 || !bl3) {
                    n2 = 0;
                    break;
                }
                if (!bl) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = !bl ? 0 : (!bl2 || !bl3 ? n : -1);
            }
        }
        return n2;
    }

    @Override
    public void timerFired(int n) {
        switch (n) {
            case 1: {
                this.process(-1);
                break;
            }
        }
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 6;
                break;
            }
            case 1: {
                n2 = 6;
                break;
            }
            case 2: {
                n2 = 88;
                break;
            }
            case 15: {
                n2 = 176;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private InfoList_ChangedArray searchForChangedContent(BAPArrayList.DeltaContext deltaContext) {
        InfoList_ChangedArray infoList_ChangedArray = this.dequeueBAPEntity();
        if (!ArrayRequestData.computChangeArrayData(infoList_ChangedArray, deltaContext, this.getInfoList(), true)) {
            infoList_ChangedArray = null;
        }
        return infoList_ChangedArray;
    }

    private InfoList_ChangedArray getFullRangeReceptionListContent() {
        InfoList_ChangedArray infoList_ChangedArray = this.dequeueBAPEntity();
        infoList_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return infoList_ChangedArray;
    }

    protected String formatFrequency(int n, int n2, int n3) {
        String string = this.getFmFrequencyScale() == 1 ? this.getLanguageUtil().formatFrequencyNAR(n, n2, n3) : this.getLanguageUtil().formatFrequency(n, n2);
        return string;
    }

    protected String computeReceptionListName(int n, String string, String string2) {
        String string3 = n == 1 || string == null || string.length() == 0 || !this.getPiCodingActivated() ? string2 : string;
        return string3;
    }

    private void computeInfoListForAMFM(int n) {
        LongIterator longIterator = this.getReceptionListUniqueId();
        StringIterator stringIterator = this.getReceptionListName();
        IntegerIterator integerIterator = this.getReceptionListFrequency();
        IntegerIterator integerIterator2 = this.getReceptionListChannel();
        BAPArrayList bAPArrayList = this.getInfoList();
        while (longIterator.hasNext()) {
            InfoList_Data infoList_Data = new InfoList_Data(null);
            infoList_Data.type = 3;
            infoList_Data.attributes.selectable = true;
            int n2 = integerIterator.nextInteger();
            long l = longIterator.nextLong();
            String string = this.formatFrequency(n2, n, integerIterator2.nextInteger());
            String string2 = this.computeReceptionListName(n, stringIterator.nextString(), string);
            infoList_Data.name.setContent(string2);
            if (l == 0L) continue;
            if (n == 0) {
                long l2 = AudioSDCommon.filterOutPIFromUniqueID(l);
                bAPArrayList.putElement(l, l2, infoList_Data, l);
                continue;
            }
            bAPArrayList.putElement(l, infoList_Data, l);
        }
    }

    private void computeInfoListForDAB() {
        LongIterator longIterator = this.getReceptionListUniqueId();
        IntegerIterator integerIterator = this.getReceptionListType();
        StringIterator stringIterator = this.getReceptionListShortName();
        BAPArrayList bAPArrayList = this.getInfoList();
        int n = 0;
        while (longIterator.hasNext()) {
            int n2 = integerIterator.nextInteger();
            long l = longIterator.nextLong();
            boolean bl = n2 == 3;
            String string = stringIterator.nextString();
            if (bl) {
                InfoList_Data infoList_Data = new InfoList_Data(null);
                infoList_Data.type = 3;
                infoList_Data.attributes.selectable = true;
                infoList_Data.name.setContent(string);
                bAPArrayList.putElement(l, infoList_Data, n);
            }
            ++n;
        }
    }

    private void computeInfoListForSirius() {
        LongIterator longIterator = this.getReceptionListUniqueId();
        StringIterator stringIterator = this.getReceptionListShortName();
        IntegerIterator integerIterator = this.getReceptionListFrequency();
        BAPArrayList bAPArrayList = this.getInfoList();
        while (longIterator.hasNext()) {
            InfoList_Data infoList_Data = new InfoList_Data(null);
            int n = integerIterator.nextInteger();
            long l = longIterator.nextLong();
            l = l == 0L ? (long)n : l;
            infoList_Data.type = 3;
            infoList_Data.attributes.selectable = true;
            String string = stringIterator.nextString();
            String string2 = String.valueOf(n);
            if (string == null || string.length() == 0) {
                string = string2;
            }
            infoList_Data.name.setContent(string);
            if (l == 0L) continue;
            bAPArrayList.putElement(l, infoList_Data, l);
        }
    }

    private void computeInfoListForRadio(int n) {
        switch (n) {
            case 1: {
                this.computeInfoListForAMFM(0);
                break;
            }
            case 0: {
                this.computeInfoListForAMFM(1);
                break;
            }
            case 2: {
                this.computeInfoListForDAB();
                break;
            }
            case 3: {
                this.computeInfoListForSirius();
                break;
            }
        }
    }

    protected void computeFullInfoList() {
        this.computeInfoListForRadio(this.getCurrentStationInfoBand());
    }

    @Override
    protected void setBapInfoListType(Integer n) {
    }
}

