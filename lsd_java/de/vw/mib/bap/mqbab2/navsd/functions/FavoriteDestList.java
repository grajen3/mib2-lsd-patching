/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationFavoriteDestinationElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed$BAPArrayListDelegate;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayPosIdIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.FavoriteDest_List_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.FavoriteDest_List_Data;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.FavoriteDest_List_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.FavoriteDest_List_StatusArray;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;
import java.util.Iterator;

public final class FavoriteDestList
extends Function
implements TimerNotifier,
FsgArrayListWindowed$BAPArrayListDelegate,
Array,
ASLNavSDConstants {
    private FsgArrayListWindowed _windowedArrayList;
    private int lastWindowedArrayListSize = 0;
    private Timer aslRequestTimer = null;
    private static final int TIMER_ASL_UPDATE_TIME;
    private static final int TIMER_ASL_ACTION_NOTHING;
    private static final int TIMER_ASL_ACTION_WAIT_FOR_VIEW_CHANGE;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int TRANSMIT_LONG_POS_THRESHOLD;
    private static final int POS_OFFSET;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_DESCRIPTION;
    private static final int MAX_ELEMENTS_POI_TYPE;
    private static final int MAX_ELEMENTS_POS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    private FavoriteDest_List_GetArray lastFavoriteDestListGetArray;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FavoriteDest_List_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.aslRequestTimer = this.getTimerService().createTimer(this, 2000);
        this.timer = this.getTimerService().createTimer(this, 1000);
        this._windowedArrayList = new FsgArrayListWindowed(740, this);
        this._windowedArrayList.initialize();
        return this.getFavoriteDestListFullRangeUpdate();
    }

    protected FavoriteDest_List_ChangedArray dequeueBAPEntity() {
        return (FavoriteDest_List_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FavoriteDest_List_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FavoriteDest_List_ChangedArray = FavoriteDestList.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.FavoriteDest_List_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FavoriteDest_List_ChangedArray);
    }

    protected void setFavoriteDestViewWindow(FavoriteDest_List_ChangedArray favoriteDest_List_ChangedArray) {
        int[] nArray = new int[]{34};
        this.context.updateStages(this, nArray, favoriteDest_List_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 30;
    }

    private FsgArrayMessageBlockingTracker getArrayRequestTracker() {
        if (this._arrayRequestTracker == null) {
            this._arrayRequestTracker = new FsgArrayMessageBlockingRequestTracker(this, this.getDelegate().getArrayListener(this));
        }
        return this._arrayRequestTracker;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        FavoriteDest_List_GetArray favoriteDest_List_GetArray = (FavoriteDest_List_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(favoriteDest_List_GetArray)) {
            int n = FavoriteDestList.maximumElementsForRecordAddress(favoriteDest_List_GetArray.getArrayHeader().getRecordAddress());
            if (favoriteDest_List_GetArray.getArrayHeader().getNumberOfElements() > n) {
                arrayListener.requestError(67, this);
            } else if (!this.aslRequestTimer.isRunning()) {
                this.aslRequestTimer.retrigger(new Integer(1));
                this.lastFavoriteDestListGetArray = favoriteDest_List_GetArray;
                this._windowedArrayList.processGetArray(favoriteDest_List_GetArray);
            }
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
        this.aslRequestTimer.stop();
        this.timer.stop();
        this.getArrayRequestTracker().reset();
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 129: {
                this.aslFavoriteDestListChanged();
                break;
            }
            case 1: {
                if (this.lastFavoriteDestListGetArray != null) {
                    FavoriteDest_List_StatusArray favoriteDest_List_StatusArray = FavoriteDestList.getEmptyArray(this.lastFavoriteDestListGetArray);
                    favoriteDest_List_StatusArray.totalNumListElements = this._windowedArrayList.getSize();
                    this.transmitStatus(favoriteDest_List_StatusArray);
                    break;
                }
                this.getDelegate().getArrayListener(this).requestError(66, this);
                break;
            }
        }
    }

    private static FavoriteDest_List_StatusArray getEmptyArray(FavoriteDest_List_GetArray favoriteDest_List_GetArray) {
        FavoriteDest_List_StatusArray favoriteDest_List_StatusArray = new FavoriteDest_List_StatusArray();
        favoriteDest_List_StatusArray.setArrayHeader(favoriteDest_List_GetArray.getArrayHeader());
        favoriteDest_List_StatusArray.asg_Id = favoriteDest_List_GetArray.asg_Id;
        favoriteDest_List_StatusArray.taid = favoriteDest_List_GetArray.taid;
        favoriteDest_List_StatusArray.totalNumListElements = 0;
        favoriteDest_List_StatusArray.getArrayHeader().elements = 0;
        return favoriteDest_List_StatusArray;
    }

    private FavoriteDest_List_ChangedArray searchForChangeContent() {
        if (this._windowedArrayList.getSize() != 0 || this.lastWindowedArrayListSize != 0) {
            this.lastWindowedArrayListSize = this._windowedArrayList.getSize();
            return this.getFavoriteDestListFullRangeUpdate();
        }
        return null;
    }

    private void transmitStatus(FavoriteDest_List_StatusArray favoriteDest_List_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(favoriteDest_List_StatusArray);
    }

    private FavoriteDest_List_ChangedArray getFavoriteDestListFullRangeUpdate() {
        FavoriteDest_List_ChangedArray favoriteDest_List_ChangedArray = this.dequeueBAPEntity();
        favoriteDest_List_ChangedArray.getArrayHeader().setFullRangeUpdate(false);
        return favoriteDest_List_ChangedArray;
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 4;
                break;
            }
            case 2: {
                n2 = 148;
                break;
            }
            case 15: {
                n2 = 296;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void aslFavoriteDestListChanged() {
        if (this.timer.isRunning()) {
            this.timer.setUserInfo(new Integer(129));
        } else {
            FavoriteDest_List_ChangedArray favoriteDest_List_ChangedArray = this.searchForChangeContent();
            if (favoriteDest_List_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(favoriteDest_List_ChangedArray);
                this.timer.retrigger(new Integer(128));
            }
        }
    }

    @Override
    public void getArrayAnswer(FsgArrayListWindowed fsgArrayListWindowed, FsgArrayPosIdIterator fsgArrayPosIdIterator, FsgArrayRequestData fsgArrayRequestData, int[] nArray, BAPGetArray bAPGetArray) {
        FavoriteDest_List_StatusArray favoriteDest_List_StatusArray = new FavoriteDest_List_StatusArray();
        FavoriteDest_List_GetArray favoriteDest_List_GetArray = (FavoriteDest_List_GetArray)bAPGetArray;
        fsgArrayRequestData.setStatusArrayHeaderData(favoriteDest_List_StatusArray, favoriteDest_List_GetArray, fsgArrayListWindowed);
        Iterator iterator = this.getNavigationService().getWindowedFavoriteDestinations(nArray);
        BAPArrayData bAPArrayData = favoriteDest_List_StatusArray.getArrayData();
        while (iterator.hasNext() && fsgArrayPosIdIterator.hasNext()) {
            NavigationFavoriteDestinationElement navigationFavoriteDestinationElement = (NavigationFavoriteDestinationElement)iterator.next();
            int n = fsgArrayPosIdIterator.next() + 1;
            FavoriteDest_List_Data favoriteDest_List_Data = (FavoriteDest_List_Data)favoriteDest_List_StatusArray.createArrayElement();
            favoriteDest_List_Data.setPos(n);
            favoriteDest_List_Data.poi_Type = navigationFavoriteDestinationElement.getPoiType();
            favoriteDest_List_Data.description.setContent(navigationFavoriteDestinationElement.getDescription());
            bAPArrayData.add(favoriteDest_List_Data);
        }
        fsgArrayRequestData.setTransmissionPosForArbitraryArray(favoriteDest_List_StatusArray);
        this.transmitStatus(favoriteDest_List_StatusArray);
        this.aslRequestTimer.stop();
    }

    @Override
    public FsgArrayRequestData computeArrayRequestData(FsgArrayListWindowed fsgArrayListWindowed, BAPGetArray bAPGetArray) {
        int n = FavoriteDestList.maximumElementsForRecordAddress(bAPGetArray.getArrayHeader().getRecordAddress());
        return FsgArrayRequestData.computeArrayRequestData(bAPGetArray.getArrayHeader(), fsgArrayListWindowed.getSize(), bAPGetArray.getArrayHeader().start - 1, n);
    }

    @Override
    public void listWasChanged(FsgArrayListWindowed fsgArrayListWindowed) {
        this.aslFavoriteDestListChanged();
    }

    @Override
    public void listCacheCleared(FsgArrayListWindowed fsgArrayListWindowed) {
        this.aslFavoriteDestListChanged();
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

