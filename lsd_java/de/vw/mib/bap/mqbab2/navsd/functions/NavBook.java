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
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookNavBookElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed$BAPArrayListDelegate;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayPosIdIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.NavBook_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.NavBook_Data;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.NavBook_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.NavBook_StatusArray;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;
import java.util.Iterator;

public class NavBook
extends Function
implements TimerNotifier,
FsgArrayListWindowed$BAPArrayListDelegate,
Array,
ASLNavSDConstants {
    private Timer aslRequestTimer = null;
    private static final int TIMER_ASL_UPDATE_TIME;
    private static final int TIMER_ASL_ACTION_NOTHING;
    private static final int TIMER_ASL_ACTION_WAIT_FOR_VIEW_CHANGE;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private FsgArrayListWindowed _windowedArrayList = null;
    private static final int TRANSMIT_LONG_POS_THRESHOLD;
    private static final int POS_OFFSET;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_LAST_NAME;
    private static final int MAX_ELEMENTS_FIRST_NAME;
    private static final int MAX_ELEMENTS_POS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    private NavBook_GetArray lastNavBookGetArray;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$NavBook_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.aslRequestTimer = this.getTimerService().createTimer(this, 2000);
        this.timer = this.getTimerService().createTimer(this, 1000);
        this._windowedArrayList = new FsgArrayListWindowed(746, this);
        this._windowedArrayList.initialize();
        return this.getNavBookFullRangeUpdate();
    }

    protected NavBook_ChangedArray dequeueBAPEntity() {
        return (NavBook_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$NavBook_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$NavBook_ChangedArray = NavBook.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.NavBook_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$NavBook_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 32;
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
        this.aslRequestTimer.stop();
        this.timer.stop();
        this.getArrayRequestTracker().reset();
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        NavBook_GetArray navBook_GetArray = (NavBook_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(navBook_GetArray)) {
            int n = NavBook.maximumElementsForRecordAddress(navBook_GetArray.getArrayHeader().getRecordAddress());
            if (navBook_GetArray.getArrayHeader().getNumberOfElements() > n) {
                arrayListener.requestError(67, this);
            } else if (!this.aslRequestTimer.isRunning()) {
                this.aslRequestTimer.retrigger(new Integer(1));
                this.lastNavBookGetArray = navBook_GetArray;
                this._windowedArrayList.processGetArray(navBook_GetArray);
            }
        }
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
        this.getArrayRequestTracker().requestAcknowledge();
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 129: {
                this.aslNavBookListChanged();
                break;
            }
            case 1: {
                if (this.lastNavBookGetArray != null) {
                    NavBook_StatusArray navBook_StatusArray = NavBook.getEmptyArray(this.lastNavBookGetArray);
                    navBook_StatusArray.totalNumListElements = this._windowedArrayList.getSize();
                    this.transmitStatus(navBook_StatusArray);
                    break;
                }
                this.getDelegate().getArrayListener(this).requestError(66, this);
                break;
            }
        }
    }

    private static NavBook_StatusArray getEmptyArray(NavBook_GetArray navBook_GetArray) {
        NavBook_StatusArray navBook_StatusArray = new NavBook_StatusArray();
        navBook_StatusArray.setArrayHeader(navBook_GetArray.getArrayHeader());
        navBook_StatusArray.asg_Id = navBook_GetArray.asg_Id;
        navBook_StatusArray.taid = navBook_GetArray.taid;
        navBook_StatusArray.totalNumListElements = 0;
        navBook_StatusArray.getArrayHeader().elements = 0;
        return navBook_StatusArray;
    }

    private NavBook_ChangedArray getNavBookFullRangeUpdate() {
        NavBook_ChangedArray navBook_ChangedArray = this.dequeueBAPEntity();
        navBook_ChangedArray.getArrayHeader().setFullRangeUpdate(true);
        return navBook_ChangedArray;
    }

    private static int maximumElementsForRecordAddress(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 4;
                break;
            }
            case 1: {
                n2 = 7;
                break;
            }
            case 2: {
                n2 = 7;
                break;
            }
            case 15: {
                n2 = 248;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void transmitStatus(NavBook_StatusArray navBook_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(navBook_StatusArray);
    }

    private void aslNavBookListChanged() {
        if (this.timer.isRunning()) {
            this.timer.setUserInfo(new Integer(129));
        } else {
            NavBook_ChangedArray navBook_ChangedArray = this.searchForChangeContent();
            if (navBook_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(navBook_ChangedArray);
                this.timer.retrigger(new Integer(128));
            }
        }
    }

    private NavBook_ChangedArray searchForChangeContent() {
        return this.getNavBookFullRangeUpdate();
    }

    @Override
    public void getArrayAnswer(FsgArrayListWindowed fsgArrayListWindowed, FsgArrayPosIdIterator fsgArrayPosIdIterator, FsgArrayRequestData fsgArrayRequestData, int[] nArray, BAPGetArray bAPGetArray) {
        NavBook_StatusArray navBook_StatusArray = new NavBook_StatusArray();
        NavBook_GetArray navBook_GetArray = (NavBook_GetArray)bAPGetArray;
        fsgArrayRequestData.setStatusArrayHeaderData(navBook_StatusArray, navBook_GetArray, fsgArrayListWindowed);
        Iterator iterator = this.getAddressbookService().getWindowedNavBook(nArray);
        BAPArrayData bAPArrayData = navBook_StatusArray.getArrayData();
        while (iterator.hasNext() && fsgArrayPosIdIterator.hasNext()) {
            int n = fsgArrayPosIdIterator.next() + 1;
            AddressbookNavBookElement addressbookNavBookElement = (AddressbookNavBookElement)iterator.next();
            NavBook_Data navBook_Data = (NavBook_Data)navBook_StatusArray.createArrayElement();
            navBook_Data.setPos(n);
            navBook_Data.firstName.setContent(addressbookNavBookElement.getFirstName());
            navBook_Data.lastName.setContent(addressbookNavBookElement.getLastName());
            bAPArrayData.add(navBook_Data);
        }
        fsgArrayRequestData.setTransmissionPosForArbitraryArray(navBook_StatusArray);
        this.transmitStatus(navBook_StatusArray);
        this.aslRequestTimer.stop();
    }

    @Override
    public FsgArrayRequestData computeArrayRequestData(FsgArrayListWindowed fsgArrayListWindowed, BAPGetArray bAPGetArray) {
        int n = NavBook.maximumElementsForRecordAddress(bAPGetArray.getArrayHeader().getRecordAddress());
        return FsgArrayRequestData.computeArrayRequestData(bAPGetArray.getArrayHeader(), fsgArrayListWindowed.getSize(), bAPGetArray.getArrayHeader().start - 1, n);
    }

    @Override
    public void listWasChanged(FsgArrayListWindowed fsgArrayListWindowed) {
        this.aslNavBookListChanged();
    }

    @Override
    public void listCacheCleared(FsgArrayListWindowed fsgArrayListWindowed) {
        this.aslNavBookListChanged();
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

