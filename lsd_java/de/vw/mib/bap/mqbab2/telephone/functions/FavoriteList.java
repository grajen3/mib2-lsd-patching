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
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhonePresetsElement;
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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FavoriteList_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FavoriteList_Data;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FavoriteList_GetArray;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FavoriteList_StatusArray;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class FavoriteList
extends Function
implements TimerNotifier,
FsgArrayListElementComparator,
Array,
ASLTelephoneConstants,
PhoneServiceListener {
    private FsgArrayListComplete _fullFavoriteList = null;
    private Timer _timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_NAME_NUMBER_TYPE;
    private static final int MAX_ELEMENTS_NAME_TELNUMBER;
    private static final int MAX_ELEMENTS_POS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FavoriteList_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this._timer = this.getTimerService().createTimer(this, 400);
        this._fullFavoriteList = new FsgArrayListComplete(new FsgArrayListGenericIdGenerator(-65536, 1));
        return this.getFavoriteListFullRangeUpdate();
    }

    protected FavoriteList_ChangedArray dequeueBAPEntity() {
        return (FavoriteList_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FavoriteList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FavoriteList_ChangedArray = FavoriteList.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.FavoriteList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FavoriteList_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 60;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getTimer().stop();
        this.getArrayRequestTracker().reset();
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        if (this.getTimer().isRunning()) {
            this.getTimer().setUserInfo(new Integer(1));
        } else {
            FavoriteList_ChangedArray favoriteList_ChangedArray;
            if (this.getFullFavoriteList().numberOfMappedIDValues() > 90) {
                this.getFullFavoriteList().clear();
                this.computeFullFavoriteList();
                favoriteList_ChangedArray = this.getFavoriteListFullRangeUpdate();
            } else {
                FsgArrayDeltaContext fsgArrayDeltaContext = this.getFullFavoriteList().createNewDeltaContext(this);
                this.computeFullFavoriteList();
                favoriteList_ChangedArray = this.searchForChangedContent(fsgArrayDeltaContext);
            }
            if (favoriteList_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(favoriteList_ChangedArray);
                this.getTimer().retrigger(new Integer(0));
            }
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        FavoriteList_GetArray favoriteList_GetArray = (FavoriteList_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(favoriteList_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(favoriteList_GetArray.getArrayHeader(), this.getFullFavoriteList(), FavoriteList.maximumElementsForRecordAddress(favoriteList_GetArray.getArrayHeader().getRecordAddress()));
            FavoriteList_StatusArray favoriteList_StatusArray = new FavoriteList_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(favoriteList_StatusArray, favoriteList_GetArray, this.getFullFavoriteList());
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(favoriteList_StatusArray);
            this.transmitStatus(arrayListener, favoriteList_StatusArray);
        }
    }

    @Override
    public void setGetArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        arrayListener.requestError(129, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    @Override
    public void requestAcknowledge() {
        this.getArrayRequestTracker().requestAcknowledge();
    }

    @Override
    public void errorAcknowledge() {
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
        FavoriteList_Data favoriteList_Data = (FavoriteList_Data)bAPArrayElement;
        FavoriteList_Data favoriteList_Data2 = (FavoriteList_Data)bAPArrayElement2;
        boolean bl = favoriteList_Data.name.toString().compareTo(favoriteList_Data2.name.toString()) == 0;
        boolean bl2 = favoriteList_Data.numberType == favoriteList_Data2.numberType;
        boolean bl3 = favoriteList_Data.name.toString().compareTo(favoriteList_Data2.name.toString()) == 0;
        switch (n) {
            case -1: {
                if (!(bl || bl2 || bl3)) {
                    n2 = 0;
                    break;
                }
                if (!bl && !bl2) {
                    n2 = 1;
                    break;
                }
                if (!bl && !bl3) {
                    n2 = 2;
                    break;
                }
                n2 = -1;
                break;
            }
            case 0: {
                if (!(bl || bl2 || bl3)) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            case 1: {
                if (!bl3) {
                    n2 = 0;
                    break;
                }
                if (!bl && !bl2) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            case 2: {
                if (!bl2) {
                    n2 = 0;
                    break;
                }
                if (!bl && !bl3) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = n;
            }
        }
        return n2;
    }

    private FavoriteList_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        FavoriteList_ChangedArray favoriteList_ChangedArray = this.dequeueBAPEntity();
        if (!FsgArrayRequestData.computeChangeArrayData(favoriteList_ChangedArray, fsgArrayDeltaContext, this.getFullFavoriteList(), true)) {
            favoriteList_ChangedArray = null;
        }
        return favoriteList_ChangedArray;
    }

    private void computeFullFavoriteList() {
        Iterator iterator = this.getPhoneService().getPhonePresets();
        FsgArrayListComplete fsgArrayListComplete = this.getFullFavoriteList();
        while (iterator.hasNext()) {
            PhonePresetsElement phonePresetsElement = (PhonePresetsElement)iterator.next();
            if (phonePresetsElement.isPhonePresetEmpty()) continue;
            FavoriteList_Data favoriteList_Data = new FavoriteList_Data(null);
            String string = phonePresetsElement.getPhonePresetName();
            if (string.length() == 0) {
                favoriteList_Data.name.setNullString();
            } else {
                favoriteList_Data.name.setContent(string);
            }
            favoriteList_Data.numberType = FavoriteList.getBapNumberType(phonePresetsElement.getPhonePresetNumberType());
            favoriteList_Data.telNumber.setContent(phonePresetsElement.getPhonePresetNumber());
            fsgArrayListComplete.putElement(phonePresetsElement.getPhonePresetEntryId(), favoriteList_Data, 0L);
        }
    }

    private FsgArrayListComplete getFullFavoriteList() {
        return this._fullFavoriteList;
    }

    private Timer getTimer() {
        return this._timer;
    }

    private void transmitStatus(ArrayListener arrayListener, FavoriteList_StatusArray favoriteList_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(favoriteList_StatusArray);
    }

    private FavoriteList_ChangedArray getFavoriteListFullRangeUpdate() {
        FavoriteList_ChangedArray favoriteList_ChangedArray = this.dequeueBAPEntity();
        favoriteList_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return favoriteList_ChangedArray;
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
                n2 = 4;
                break;
            }
            case 15: {
                n2 = 576;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static int getBapNumberType(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 5: {
                n2 = 12;
                break;
            }
            case 6: {
                n2 = 10;
                break;
            }
            case 7: {
                n2 = 14;
                break;
            }
            case 9: {
                n2 = 11;
                break;
            }
            case 10: {
                n2 = 9;
                break;
            }
            case 11: {
                n2 = 13;
                break;
            }
            case 8: {
                n2 = 3;
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
        PHONE_LISTENER_IDS = new int[]{1194};
    }
}

