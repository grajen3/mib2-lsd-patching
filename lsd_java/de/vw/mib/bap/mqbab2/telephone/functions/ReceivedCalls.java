/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneReceivedCallsElement;
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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.ReceivedCalls_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.ReceivedCalls_Data;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.ReceivedCalls_GetArray;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.ReceivedCalls_StatusArray;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class ReceivedCalls
extends Function
implements TimerNotifier,
FsgArrayListElementComparator,
Array,
ASLTelephoneConstants,
PhoneServiceListener {
    private FsgArrayListComplete fullReceivedCalls = null;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int POS_OFFSET;
    private static final int INVALID_TIME_STAMP;
    private static final int YEAR_TWO_THOUSAND;
    private static final int YEAR_ONE_THOUSAND;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_PB_NAME_NUMBER_TYPE;
    private static final int MAX_ELEMENTS_TEL_NUMBER_DAY_MONTH_YEAR_HOUR_MINUTE_SECOND;
    private static final int MAX_ELEMENTS_POS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ReceivedCalls_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.timer = this.getTimerService().createTimer(this, 400);
        this.fullReceivedCalls = new FsgArrayListComplete(new FsgArrayListGenericIdGenerator(-65536, 1));
        return this.getReceivedCallsFullRangeUpdate();
    }

    protected ReceivedCalls_ChangedArray dequeueBAPEntity() {
        return (ReceivedCalls_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ReceivedCalls_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ReceivedCalls_ChangedArray = ReceivedCalls.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.ReceivedCalls_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ReceivedCalls_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 47;
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
            ReceivedCalls_ChangedArray receivedCalls_ChangedArray;
            if (this.fullReceivedCalls.numberOfMappedIDValues() > 200) {
                this.fullReceivedCalls.clear();
                this.computeFullReceivedCallsList();
                receivedCalls_ChangedArray = this.getReceivedCallsFullRangeUpdate();
            } else {
                FsgArrayDeltaContext fsgArrayDeltaContext = this.fullReceivedCalls.createNewDeltaContext(this);
                this.computeFullReceivedCallsList();
                receivedCalls_ChangedArray = this.searchForChangedContent(fsgArrayDeltaContext);
            }
            if (receivedCalls_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(receivedCalls_ChangedArray);
                this.timer.retrigger(new Integer(0));
            }
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        ReceivedCalls_GetArray receivedCalls_GetArray = (ReceivedCalls_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(receivedCalls_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(receivedCalls_GetArray.getArrayHeader(), this.fullReceivedCalls, ReceivedCalls.maximumElementsForRecordAddress(receivedCalls_GetArray.getArrayHeader().getRecordAddress()));
            ReceivedCalls_StatusArray receivedCalls_StatusArray = new ReceivedCalls_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(receivedCalls_StatusArray, receivedCalls_GetArray, this.fullReceivedCalls);
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(receivedCalls_StatusArray);
            this.transmitStatus(arrayListener, receivedCalls_StatusArray);
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(129, this);
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
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    private void transmitStatus(ArrayListener arrayListener, ReceivedCalls_StatusArray receivedCalls_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(receivedCalls_StatusArray);
    }

    private ReceivedCalls_ChangedArray getReceivedCallsFullRangeUpdate() {
        ReceivedCalls_ChangedArray receivedCalls_ChangedArray = this.dequeueBAPEntity();
        receivedCalls_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return receivedCalls_ChangedArray;
    }

    private int mapToBAPNumberType(int n) {
        int n2;
        if (n != -1) {
            int n3 = 4896;
            int n4 = n & 0xFFFFECDF;
            switch (n4) {
                case 8: 
                case 2112: {
                    n2 = 0;
                    break;
                }
                case 4: {
                    n2 = 4;
                    break;
                }
                case 64: 
                case 72: {
                    n2 = 2;
                    break;
                }
                case 10: 
                case 2050: {
                    n2 = 3;
                    break;
                }
                case 2: {
                    n2 = 3;
                    break;
                }
                case 16: {
                    n2 = 5;
                    break;
                }
                case 128: {
                    n2 = 6;
                    break;
                }
                case 1024: {
                    n2 = 7;
                    break;
                }
                case 12: 
                case 2052: {
                    n2 = 4;
                    break;
                }
                case 66: {
                    n2 = 0;
                    break;
                }
                case 68: {
                    n2 = 0;
                    break;
                }
                case 20: {
                    n2 = 14;
                    break;
                }
                case 18: {
                    n2 = 13;
                    break;
                }
                default: {
                    if ((n4 & 2) != 0) {
                        n2 = 3;
                        break;
                    }
                    if ((n4 & 4) != 0) {
                        n2 = 4;
                        break;
                    }
                    if ((n4 & 0x40) != 0) {
                        n2 = 2;
                        break;
                    }
                    n2 = 0;
                    break;
                }
            }
        } else {
            n2 = 0;
        }
        return n2;
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 5;
                break;
            }
            case 2: {
                n2 = 12;
                break;
            }
            case 15: {
                n2 = 300;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private int getTimeStampData(int n) {
        int n2 = n <= 0 ? 255 : n;
        return n2;
    }

    private int getTimeStampDataYear(int n) {
        return n < 2000 ? n % 1000 : n % 2000;
    }

    private void computeFullReceivedCallsList() {
        Iterator iterator = this.getPhoneService().getReceivedCalls();
        int n = 1;
        while (iterator.hasNext()) {
            PhoneReceivedCallsElement phoneReceivedCallsElement = (PhoneReceivedCallsElement)iterator.next();
            ReceivedCalls_Data receivedCalls_Data = new ReceivedCalls_Data(null);
            receivedCalls_Data.setPos(n++);
            receivedCalls_Data.numberType = this.mapToBAPNumberType(phoneReceivedCallsElement.getReceivedCallNumberType());
            receivedCalls_Data.telNumber.setContent(phoneReceivedCallsElement.getReceivedCallTelNumber());
            String string = phoneReceivedCallsElement.getReceivedCallContactName();
            if (string != null && string.length() != 0) {
                receivedCalls_Data.pbName.setContent(string);
            } else {
                receivedCalls_Data.pbName.setNullString();
            }
            receivedCalls_Data.day = this.getTimeStampData(phoneReceivedCallsElement.getReceivedCallDay());
            receivedCalls_Data.month = this.getTimeStampData(phoneReceivedCallsElement.getReceivedCallMonth());
            receivedCalls_Data.year = this.getTimeStampDataYear(phoneReceivedCallsElement.getReceivedCallYear());
            receivedCalls_Data.hour = phoneReceivedCallsElement.getReceivedCallHour();
            receivedCalls_Data.minute = phoneReceivedCallsElement.getReceivedCallMinute();
            receivedCalls_Data.second = phoneReceivedCallsElement.getReceivedCallSecond();
            if (receivedCalls_Data.day == 255) {
                receivedCalls_Data.year = 255;
                receivedCalls_Data.hour = 255;
                receivedCalls_Data.minute = 255;
                receivedCalls_Data.second = 255;
            }
            this.fullReceivedCalls.putElement(phoneReceivedCallsElement.getReceivedCallEntryId(), receivedCalls_Data, 0L);
        }
    }

    private ReceivedCalls_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        ReceivedCalls_ChangedArray receivedCalls_ChangedArray = this.dequeueBAPEntity();
        if (!FsgArrayRequestData.computeChangeArrayData(receivedCalls_ChangedArray, fsgArrayDeltaContext, this.fullReceivedCalls, true)) {
            receivedCalls_ChangedArray = null;
        }
        return receivedCalls_ChangedArray;
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

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        int n2;
        ReceivedCalls_Data receivedCalls_Data = (ReceivedCalls_Data)bAPArrayElement;
        ReceivedCalls_Data receivedCalls_Data2 = (ReceivedCalls_Data)bAPArrayElement2;
        boolean bl = receivedCalls_Data.pbName.toString().compareTo(receivedCalls_Data2.pbName.toString()) == 0;
        boolean bl2 = receivedCalls_Data.numberType == receivedCalls_Data2.numberType;
        boolean bl3 = receivedCalls_Data.telNumber.toString().compareTo(receivedCalls_Data2.telNumber.toString()) == 0;
        boolean bl4 = receivedCalls_Data.day == receivedCalls_Data2.day && receivedCalls_Data.month == receivedCalls_Data2.month && receivedCalls_Data.year == receivedCalls_Data2.year && receivedCalls_Data.hour == receivedCalls_Data2.hour && receivedCalls_Data.minute == receivedCalls_Data2.minute && receivedCalls_Data.second == receivedCalls_Data2.second;
        switch (n) {
            case -1: {
                if (!(bl3 && bl4 || bl && bl2)) {
                    n2 = 0;
                    break;
                }
                if (!bl || !bl2) {
                    n2 = 1;
                    break;
                }
                if (!bl3 || !bl4) {
                    n2 = 2;
                    break;
                }
                n2 = -1;
                break;
            }
            case 1: {
                if (!bl3 || !bl4) {
                    n2 = 0;
                    break;
                }
                if (!bl || !bl2) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            case 2: {
                if (!bl || !bl2) {
                    n2 = 0;
                    break;
                }
                if (!bl3 || !bl4) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = !bl || !bl2 || !bl3 || !bl4 ? n : -1;
            }
        }
        return n2;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
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
        PHONE_LISTENER_IDS = new int[]{1106};
    }
}

