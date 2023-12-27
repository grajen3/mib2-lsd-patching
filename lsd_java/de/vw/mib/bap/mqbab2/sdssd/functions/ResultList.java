/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.functions;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayDeltaContext;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListElementComparator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListGenericIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ResultList_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ResultList_Data;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ResultList_GetArray;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ResultList_StatusArray;

public class ResultList
extends Function
implements FsgArrayListElementComparator,
Array,
SpeechServiceListener {
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MAX_ELEMENTS__RESULT_TEXT;
    private static final int MAX_ELEMENTS__RESULT_TYPE_RESULT_TEXT;
    private static final int MAX_ELEMENTS__POS;
    public static final int RESULT_LIST__CHANGED_ARRAY_ACK_RECEIVED;
    protected FsgArrayListComplete resultList;
    protected static final int[] SPEECH_LISTENER_IDS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    private boolean internalBocked;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$ResultList_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.resultList = new FsgArrayListComplete(new FsgArrayListGenericIdGenerator(255, 1));
        this.getSpeechService().addSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        return this.getResultListFullRangeUpdate();
    }

    protected ResultList_ChangedArray dequeueBAPEntity() {
        return (ResultList_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$ResultList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$ResultList_ChangedArray = ResultList.class$("de.vw.mib.bap.mqbab2.generated.sdssd.serializer.ResultList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$ResultList_ChangedArray);
    }

    protected void updateReceivedAcknowledgment() {
        int[] nArray = new int[]{17};
        this.context.updateStages(this, nArray, new Integer(1));
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 17: {
                this.setBlocked((Boolean)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 19;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    private ResultList_ChangedArray getResultListFullRangeUpdate() {
        ResultList_ChangedArray resultList_ChangedArray = this.dequeueBAPEntity();
        resultList_ChangedArray.getArrayHeader().setFullRangeUpdate(false);
        return resultList_ChangedArray;
    }

    private void transmitStatus(ArrayListener arrayListener, ResultList_StatusArray resultList_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(resultList_StatusArray);
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        ResultList_GetArray resultList_GetArray = (ResultList_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(resultList_GetArray)) {
            if (!this.getSpeechService().isSdsSdInMenuActive()) {
                this.transmitStatus(arrayListener, this.getEmptyResultListArray(resultList_GetArray));
            } else {
                FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(resultList_GetArray.getArrayHeader(), this.resultList, ResultList.maximumElementsForRecordAddress(resultList_GetArray.getArrayHeader().getRecordAddress()));
                ResultList_StatusArray resultList_StatusArray = new ResultList_StatusArray();
                fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(resultList_StatusArray, resultList_GetArray, this.resultList);
                fsgArrayRequestData.setTransmissionPosForArbitraryArray(resultList_StatusArray);
                this.transmitStatus(arrayListener, resultList_StatusArray);
            }
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(65, this);
    }

    public ResultList_StatusArray getEmptyResultListArray(ResultList_GetArray resultList_GetArray) {
        ResultList_StatusArray resultList_StatusArray = new ResultList_StatusArray();
        resultList_StatusArray.setAsgId(resultList_GetArray.getAsgId());
        resultList_StatusArray.setTransactionId(resultList_GetArray.getTransactionId());
        resultList_StatusArray.setArrayHeader(resultList_GetArray.getArrayHeader());
        return resultList_StatusArray;
    }

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        int n2;
        ResultList_Data resultList_Data = (ResultList_Data)bAPArrayElement;
        ResultList_Data resultList_Data2 = (ResultList_Data)bAPArrayElement2;
        switch (n) {
            case -1: {
                if (resultList_Data.resultType != resultList_Data2.resultType && !resultList_Data.resultText.equalTo(resultList_Data2.resultText)) {
                    n2 = 1;
                    break;
                }
                if (resultList_Data.resultText.equalTo(resultList_Data2.resultText)) {
                    n2 = 2;
                    break;
                }
                n2 = -1;
                break;
            }
            case 2: {
                if (resultList_Data.resultType != resultList_Data2.resultType) {
                    n2 = 1;
                    break;
                }
                if (!resultList_Data.resultText.equalTo(resultList_Data2.resultText)) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = resultList_Data.resultType != resultList_Data2.resultType || !resultList_Data.resultText.equalTo(resultList_Data2.resultText) ? n : -1;
            }
        }
        return n2;
    }

    @Override
    public void requestAcknowledge() {
        if (this.getLogger().isTraceEnabled(1024)) {
            this.getLogger().trace(1024).append("ResultList: Acknowledgement received.").log();
        }
        this.getArrayRequestTracker().requestAcknowledge();
        this.updateReceivedAcknowledgment();
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
        this.getArrayRequestTracker().reset();
    }

    @Override
    public void uninitialize() {
        this.getSpeechService().removeSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        this.getArrayRequestTracker().reset();
    }

    private void reportResultListChangedContent(boolean bl) {
        ResultList_ChangedArray resultList_ChangedArray;
        if (!this.getSpeechService().isSdsSdInMenuActive()) {
            if (this.resultList.getSize() > 0) {
                this.resultList.clear();
                resultList_ChangedArray = this.getResultListFullRangeUpdate();
            } else {
                resultList_ChangedArray = null;
            }
        } else if (this.resultList.numberOfMappedIDValues() > 200) {
            this.resultList.clear();
            this.computeFullResultList();
            resultList_ChangedArray = this.getResultListFullRangeUpdate();
        } else {
            FsgArrayDeltaContext fsgArrayDeltaContext = this.resultList.createNewDeltaContext(this);
            this.computeFullResultList();
            resultList_ChangedArray = this.searchForChangedContent(fsgArrayDeltaContext);
        }
        if (bl && resultList_ChangedArray == null) {
            resultList_ChangedArray = this.getResultListFullRangeUpdate();
        }
        if (resultList_ChangedArray != null) {
            if (this.getLogger().isTraceEnabled(1024)) {
                this.getLogger().trace(1024).append("ResultList: Results changed: ").append(this.getSpeechService().getHeadline()).log();
                this.getLogger().trace(1024).append("ResultList: Report ChangedArray. ").log();
            }
            this.getArrayRequestTracker().reportChangedArray(resultList_ChangedArray);
        }
    }

    @Override
    public void process(int n) {
        this.reportResultListChangedContent(false);
    }

    private void computeFullResultList() {
        this.resultList.clear();
        SpeechService speechService = this.getSpeechService();
        if (speechService.isHeadlineDynamic()) {
            ResultList_Data resultList_Data = new ResultList_Data(null);
            resultList_Data.resultType = 0;
            resultList_Data.resultText.setContent(speechService.getHeadline());
            this.resultList.putElement(resultList_Data.hashCode(), resultList_Data, -1L);
        }
    }

    private ResultList_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        ResultList_ChangedArray resultList_ChangedArray = this.dequeueBAPEntity();
        if (!FsgArrayRequestData.computeChangeArrayData(resultList_ChangedArray, fsgArrayDeltaContext, this.resultList, false)) {
            resultList_ChangedArray = null;
        }
        return resultList_ChangedArray;
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 4;
                break;
            }
            case 15: {
                n2 = 10;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSpeechData(SpeechService speechService, int n) {
        if (n == -352124800 && this.getLogger().isTraceEnabled(1024)) {
            this.getLogger().trace(1024).append("ResultList: TeleprompterData changed.").log();
        }
        if (!this.isBlocked()) {
            this.process(-1);
        }
    }

    public boolean isBlocked() {
        return this.internalBocked;
    }

    public void setBlocked(boolean bl) {
        if (this.internalBocked != bl) {
            if (!bl) {
                this.reportResultListChangedContent(true);
            }
            this.internalBocked = bl;
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        SPEECH_LISTENER_IDS = new int[]{-352124800};
    }
}

