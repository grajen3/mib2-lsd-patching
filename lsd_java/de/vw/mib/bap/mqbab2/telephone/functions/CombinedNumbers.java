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
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneMixedCallsElement;
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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CombinedNumbers_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CombinedNumbers_Data;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CombinedNumbers_GetArray;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CombinedNumbers_StatusArray;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public class CombinedNumbers
extends Function
implements TimerNotifier,
FsgArrayListElementComparator,
Array,
ASLTelephoneConstants,
PhoneServiceListener {
    private FsgArrayListComplete fullCombinedNumbers = null;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int INVALID_TIME_STAMP;
    private static final int YEAR_TWO_THOUSAND;
    private static final int YEAR_ONE_THOUSAND;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_PB_NAME_CALL_MODE;
    private static final int MAX_ELEMENTS_TEL_NUMBER_DAY_MONTH_YEAR_HOUR_MINUTE_SECOND;
    private static final int MAX_ELEMENTS_POS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CombinedNumbers_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.timer = this.getTimerService().createTimer(this, 400);
        this.fullCombinedNumbers = new FsgArrayListComplete(new FsgArrayListGenericIdGenerator(-65536, 1));
        return this.getCombinedNumbersFullRangeUpdate();
    }

    protected CombinedNumbers_ChangedArray dequeueBAPEntity() {
        return (CombinedNumbers_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CombinedNumbers_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CombinedNumbers_ChangedArray = CombinedNumbers.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CombinedNumbers_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CombinedNumbers_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 49;
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
            CombinedNumbers_ChangedArray combinedNumbers_ChangedArray;
            if (this.fullCombinedNumbers.numberOfMappedIDValues() > 200) {
                this.fullCombinedNumbers.clear();
                this.computeFullMixedCallsList();
                combinedNumbers_ChangedArray = this.getCombinedNumbersFullRangeUpdate();
            } else {
                FsgArrayDeltaContext fsgArrayDeltaContext = this.fullCombinedNumbers.createNewDeltaContext(this);
                this.computeFullMixedCallsList();
                combinedNumbers_ChangedArray = this.searchForChangedContent(fsgArrayDeltaContext);
            }
            if (combinedNumbers_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(combinedNumbers_ChangedArray);
                this.timer.retrigger(new Integer(0));
            }
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        CombinedNumbers_GetArray combinedNumbers_GetArray = (CombinedNumbers_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(combinedNumbers_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(combinedNumbers_GetArray.getArrayHeader(), this.fullCombinedNumbers, CombinedNumbers.maximumElementsForRecordAddress(combinedNumbers_GetArray.getArrayHeader().getRecordAddress()));
            CombinedNumbers_StatusArray combinedNumbers_StatusArray = new CombinedNumbers_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(combinedNumbers_StatusArray, combinedNumbers_GetArray, this.fullCombinedNumbers);
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(combinedNumbers_StatusArray);
            this.transmitStatus(arrayListener, combinedNumbers_StatusArray);
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

    private void transmitStatus(ArrayListener arrayListener, CombinedNumbers_StatusArray combinedNumbers_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(combinedNumbers_StatusArray);
    }

    private CombinedNumbers_ChangedArray getCombinedNumbersFullRangeUpdate() {
        CombinedNumbers_ChangedArray combinedNumbers_ChangedArray = this.dequeueBAPEntity();
        combinedNumbers_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return combinedNumbers_ChangedArray;
    }

    private int getTimeStampData(int n) {
        int n2 = n <= 0 ? 255 : n;
        return n2;
    }

    private int getTimeStampDataYear(int n) {
        return n < 2000 ? n % 1000 : n % 2000;
    }

    protected void setTelNumberAndPbName(CombinedNumbers_Data combinedNumbers_Data, String string, String string2) {
        combinedNumbers_Data.telNumber.setContent(string);
        if (string2 != null && string2.length() != 0) {
            combinedNumbers_Data.pbName.setContent(string2);
        } else {
            combinedNumbers_Data.pbName.setNullString();
        }
    }

    private void computeFullMixedCallsList() {
        Iterator iterator = this.getPhoneService().getMixedCalls();
        while (iterator.hasNext()) {
            PhoneMixedCallsElement phoneMixedCallsElement = (PhoneMixedCallsElement)iterator.next();
            CombinedNumbers_Data combinedNumbers_Data = new CombinedNumbers_Data(null);
            this.setTelNumberAndPbName(combinedNumbers_Data, phoneMixedCallsElement.getMixedCallTelNumber(), phoneMixedCallsElement.getMixedCallContactName());
            combinedNumbers_Data.numberType = this.mapToBAPNumberType(phoneMixedCallsElement.getMixedCallNumberType());
            combinedNumbers_Data.callMode = phoneMixedCallsElement.getMixedCallCallType();
            combinedNumbers_Data.day = this.getTimeStampData(phoneMixedCallsElement.getMixedCallDay());
            combinedNumbers_Data.month = this.getTimeStampData(phoneMixedCallsElement.getMixedCallMonth());
            combinedNumbers_Data.year = this.getTimeStampDataYear(phoneMixedCallsElement.getMixedCallYear());
            combinedNumbers_Data.hour = phoneMixedCallsElement.getMixedCallHour();
            combinedNumbers_Data.minute = phoneMixedCallsElement.getMixedCallMinute();
            combinedNumbers_Data.second = phoneMixedCallsElement.getMixedCallSecond();
            if (combinedNumbers_Data.day == 255) {
                combinedNumbers_Data.year = 255;
                combinedNumbers_Data.hour = 255;
                combinedNumbers_Data.minute = 255;
                combinedNumbers_Data.second = 255;
            }
            this.fullCombinedNumbers.putElement(phoneMixedCallsElement.getMixedCallEntryId(), combinedNumbers_Data, 0L);
        }
    }

    private CombinedNumbers_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        CombinedNumbers_ChangedArray combinedNumbers_ChangedArray = this.dequeueBAPEntity();
        if (!FsgArrayRequestData.computeChangeArrayData(combinedNumbers_ChangedArray, fsgArrayDeltaContext, this.fullCombinedNumbers, true)) {
            combinedNumbers_ChangedArray = null;
        }
        return combinedNumbers_ChangedArray;
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
        CombinedNumbers_Data combinedNumbers_Data = (CombinedNumbers_Data)bAPArrayElement;
        CombinedNumbers_Data combinedNumbers_Data2 = (CombinedNumbers_Data)bAPArrayElement2;
        boolean bl = combinedNumbers_Data.pbName.toString().compareTo(combinedNumbers_Data2.pbName.toString()) == 0;
        boolean bl2 = combinedNumbers_Data.numberType == combinedNumbers_Data2.numberType;
        boolean bl3 = combinedNumbers_Data.callMode == combinedNumbers_Data2.callMode;
        boolean bl4 = combinedNumbers_Data.telNumber.toString().compareTo(combinedNumbers_Data2.telNumber.toString()) == 0;
        boolean bl5 = combinedNumbers_Data.day == combinedNumbers_Data2.day && combinedNumbers_Data.month == combinedNumbers_Data2.month && combinedNumbers_Data.year == combinedNumbers_Data2.year && combinedNumbers_Data.hour == combinedNumbers_Data2.hour && combinedNumbers_Data.minute == combinedNumbers_Data2.minute && combinedNumbers_Data.second == combinedNumbers_Data2.second;
        switch (n) {
            case -1: {
                if (!(bl4 && bl5 || bl && bl3)) {
                    n2 = 0;
                    break;
                }
                if (!(bl && bl3 && bl2)) {
                    n2 = 1;
                    break;
                }
                if (!bl4 || !bl5) {
                    n2 = 2;
                    break;
                }
                n2 = -1;
                break;
            }
            case 1: {
                if (!bl4 || !bl5) {
                    n2 = 0;
                    break;
                }
                if (!(bl && bl3 && bl2)) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            case 2: {
                if (!(bl && bl3 && bl2)) {
                    n2 = 0;
                    break;
                }
                if (!bl4 || !bl5) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = !bl || !bl3 || !bl4 || !bl5 || !bl2 ? n : -1;
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
        PHONE_LISTENER_IDS = new int[]{1107};
    }
}

