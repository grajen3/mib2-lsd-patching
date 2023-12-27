/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioTrafficMessageElement;
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
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoList_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoList_Data;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoList_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoList_StatusArray;
import java.util.Iterator;

public final class TpMemoList
extends Function
implements TimerNotifier,
FsgArrayListElementComparator,
Array,
ASLAudioSDConstants,
RadioServiceListener {
    private FsgArrayListComplete fullTpMemoList = null;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_REDUCED_DATA;
    private static final int MAX_ELEMENTS_POS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    protected static final int[] RADIO_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$TpMemoList_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.timer = this.getTimerService().createTimer(this, 5000);
        this.fullTpMemoList = new FsgArrayListComplete(new FsgArrayListGenericIdGenerator(255, 1));
        this.setFullTPMemoList(this.fullTpMemoList);
        return null;
    }

    protected TpMemoList_ChangedArray dequeueBAPEntity() {
        return (TpMemoList_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$TpMemoList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$TpMemoList_ChangedArray = TpMemoList.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$TpMemoList_ChangedArray);
    }

    protected void setFullTPMemoList(FsgArrayListComplete fsgArrayListComplete) {
        int[] nArray = new int[]{24, 44};
        this.context.updateStages(this, nArray, fsgArrayListComplete);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 27;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    @Override
    public void process(int n) {
        if (this.timer.isRunning()) {
            this.timer.setUserInfo(new Integer(1));
        } else {
            TpMemoList_ChangedArray tpMemoList_ChangedArray;
            if (this.fullTpMemoList.numberOfMappedIDValues() > 100) {
                this.fullTpMemoList.clear();
                this.computeFullTpMemoList();
                tpMemoList_ChangedArray = this.getTpMemoListFullRangeUpdate();
            } else {
                FsgArrayDeltaContext fsgArrayDeltaContext = this.fullTpMemoList.createNewDeltaContext(this);
                this.computeFullTpMemoList();
                tpMemoList_ChangedArray = this.searchForChangedContent(fsgArrayDeltaContext);
            }
            if (tpMemoList_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(tpMemoList_ChangedArray);
                this.setFullTPMemoList(this.fullTpMemoList);
                this.timer.retrigger(new Integer(0));
            }
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        TpMemoList_GetArray tpMemoList_GetArray = (TpMemoList_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(tpMemoList_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(tpMemoList_GetArray.getArrayHeader(), this.fullTpMemoList, TpMemoList.maximumElementsForRecordAddress(tpMemoList_GetArray.getArrayHeader().getRecordAddress()));
            TpMemoList_StatusArray tpMemoList_StatusArray = new TpMemoList_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(tpMemoList_StatusArray, tpMemoList_GetArray, this.fullTpMemoList);
            fsgArrayRequestData.setTransmissionPosForConsecutiveArrayInterpretedAsArbitrary(tpMemoList_StatusArray);
            this.transmitStatus(arrayListener, tpMemoList_StatusArray);
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
        this.getArrayRequestTracker().requestAcknowledge();
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getArrayRequestTracker().reset();
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 1: {
                this.process(-1);
                break;
            }
        }
    }

    private void transmitStatus(ArrayListener arrayListener, TpMemoList_StatusArray tpMemoList_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(tpMemoList_StatusArray);
    }

    private TpMemoList_ChangedArray getTpMemoListFullRangeUpdate() {
        TpMemoList_ChangedArray tpMemoList_ChangedArray = this.dequeueBAPEntity();
        tpMemoList_ChangedArray.getArrayHeader().setFullRangeUpdate(false);
        return tpMemoList_ChangedArray;
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 3;
                break;
            }
            case 1: {
                n2 = 39;
                break;
            }
            case 15: {
                n2 = 156;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void computeFullTpMemoList() {
        Iterator iterator = this.getRadioService().getTrafficMessages();
        int n = 0;
        while (iterator.hasNext()) {
            RadioTrafficMessageElement radioTrafficMessageElement = (RadioTrafficMessageElement)iterator.next();
            TpMemoList_Data tpMemoList_Data = new TpMemoList_Data(null);
            tpMemoList_Data.messageTime_Hour = radioTrafficMessageElement.getTrafficMessageHour();
            tpMemoList_Data.messageTime_Minute = radioTrafficMessageElement.getTrafficMessageMinute();
            tpMemoList_Data.stationName.setContent(radioTrafficMessageElement.getTrafficMessageStationName());
            this.fullTpMemoList.putElement(radioTrafficMessageElement.getTrafficMessageID(), tpMemoList_Data, n++);
        }
    }

    private TpMemoList_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        TpMemoList_ChangedArray tpMemoList_ChangedArray = this.dequeueBAPEntity();
        if (!FsgArrayRequestData.computeChangeArrayData(tpMemoList_ChangedArray, fsgArrayDeltaContext, this.fullTpMemoList, false)) {
            tpMemoList_ChangedArray = null;
        }
        return tpMemoList_ChangedArray;
    }

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        int n2;
        TpMemoList_Data tpMemoList_Data = (TpMemoList_Data)bAPArrayElement;
        TpMemoList_Data tpMemoList_Data2 = (TpMemoList_Data)bAPArrayElement2;
        boolean bl = tpMemoList_Data.messageTime_Hour == tpMemoList_Data2.messageTime_Hour && tpMemoList_Data.messageTime_Minute == tpMemoList_Data2.messageTime_Minute;
        boolean bl2 = tpMemoList_Data.stationName.toString().compareTo(tpMemoList_Data2.stationName.toString()) == 0;
        switch (n) {
            case -1: {
                if (!bl2) {
                    n2 = 0;
                    break;
                }
                if (!bl) {
                    n2 = 1;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = !bl2 ? 0 : (!bl ? 1 : -1);
            }
        }
        return n2;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
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
        RADIO_LISTENER_IDS = new int[]{1466};
    }
}

