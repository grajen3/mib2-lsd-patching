/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationLastDestinationElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayDeltaContext;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayList;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListElementComparator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListGenericIdGenerator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LastDest_List_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LastDest_List_Data;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LastDest_List_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LastDest_List_StatusArray;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;
import java.util.Iterator;

public class LastDestList
extends Function
implements TimerNotifier,
FsgArrayListElementComparator,
Array,
ASLNavSDConstants,
NavigationServiceListener {
    private FsgArrayListComplete fullLastDestList = new FsgArrayListComplete(new FsgArrayListGenericIdGenerator(255, 1));
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int MAX_NUMBER_IN_MAPPING_LIST;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;
    private static final int MAX_ELEMENTS_FULL_STRUCTURE;
    private static final int MAX_ELEMENTS_DESCRIPTION;
    private static final int MAX_ELEMENTS_POI_TYPE;
    private static final int MAX_ELEMENTS_POS;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$LastDest_List_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.timer = this.getTimerService().createTimer(this, 1000);
        this.computeFullLastDestList();
        this.setFullLastDestList(this.fullLastDestList);
        return this.getLastDestListFullRangeUpdate();
    }

    protected LastDest_List_ChangedArray dequeueBAPEntity() {
        return (LastDest_List_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$LastDest_List_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$LastDest_List_ChangedArray = LastDestList.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.LastDest_List_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$LastDest_List_ChangedArray);
    }

    protected void setFullLastDestList(FsgArrayList fsgArrayList) {
        int[] nArray = new int[]{33, 34, 31};
        this.context.updateStages(this, nArray, fsgArrayList);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 29;
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
            LastDest_List_ChangedArray lastDest_List_ChangedArray;
            if (this.fullLastDestList.numberOfMappedIDValues() > 50) {
                this.fullLastDestList.clear();
                this.computeFullLastDestList();
                lastDest_List_ChangedArray = this.getLastDestListFullRangeUpdate();
            } else {
                FsgArrayDeltaContext fsgArrayDeltaContext = this.fullLastDestList.createNewDeltaContext(this);
                this.computeFullLastDestList();
                lastDest_List_ChangedArray = this.searchForChangedContent(fsgArrayDeltaContext);
            }
            if (lastDest_List_ChangedArray != null) {
                this.getArrayRequestTracker().reportChangedArray(lastDest_List_ChangedArray);
                this.setFullLastDestList(this.fullLastDestList);
                this.timer.retrigger(new Integer(0));
            }
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        LastDest_List_GetArray lastDest_List_GetArray = (LastDest_List_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(lastDest_List_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(lastDest_List_GetArray.getArrayHeader(), this.fullLastDestList, LastDestList.maximumElementsForRecordAddress(lastDest_List_GetArray.getArrayHeader().getRecordAddress()));
            LastDest_List_StatusArray lastDest_List_StatusArray = new LastDest_List_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(lastDest_List_StatusArray, lastDest_List_GetArray, this.fullLastDestList);
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(lastDest_List_StatusArray);
            this.transmitStatus(arrayListener, lastDest_List_StatusArray);
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
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
        this.getArrayRequestTracker().indicationError(n);
    }

    private void transmitStatus(ArrayListener arrayListener, LastDest_List_StatusArray lastDest_List_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(lastDest_List_StatusArray);
    }

    private LastDest_List_ChangedArray getLastDestListFullRangeUpdate() {
        LastDest_List_ChangedArray lastDest_List_ChangedArray = this.dequeueBAPEntity();
        lastDest_List_ChangedArray.getArrayHeader().setFullRangeUpdate(false);
        return lastDest_List_ChangedArray;
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
                n2 = 198;
                break;
            }
            case 15: {
                n2 = 396;
                break;
            }
            default: {
                n2 = 0;
            }
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

    protected boolean isLastDestEntryDataValid(String string, int n) {
        return string.length() != 0;
    }

    private void computeFullLastDestList() {
        Iterator iterator = this.getNavigationService().getLastDestinations();
        int n = 0;
        while (iterator.hasNext()) {
            NavigationLastDestinationElement navigationLastDestinationElement = (NavigationLastDestinationElement)iterator.next();
            int n2 = navigationLastDestinationElement.getPoiType();
            String string = navigationLastDestinationElement.getDescription();
            if (this.isLastDestEntryDataValid(string, n2)) {
                LastDest_List_Data lastDest_List_Data = new LastDest_List_Data(null);
                lastDest_List_Data.poi_Type = n2;
                lastDest_List_Data.description.setContent(string);
                this.fullLastDestList.putElement(navigationLastDestinationElement.getContactEntryId(), lastDest_List_Data, n);
            }
            ++n;
        }
    }

    private LastDest_List_ChangedArray searchForChangedContent(FsgArrayDeltaContext fsgArrayDeltaContext) {
        LastDest_List_ChangedArray lastDest_List_ChangedArray = this.dequeueBAPEntity();
        if (!FsgArrayRequestData.computeChangeArrayData(lastDest_List_ChangedArray, fsgArrayDeltaContext, this.fullLastDestList, false)) {
            lastDest_List_ChangedArray = null;
        }
        return lastDest_List_ChangedArray;
    }

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        int n2;
        LastDest_List_Data lastDest_List_Data = (LastDest_List_Data)bAPArrayElement;
        LastDest_List_Data lastDest_List_Data2 = (LastDest_List_Data)bAPArrayElement2;
        boolean bl = lastDest_List_Data.poi_Type == lastDest_List_Data2.poi_Type;
        boolean bl2 = lastDest_List_Data.description.toString().compareTo(lastDest_List_Data2.description.toString()) == 0;
        switch (n) {
            case -1: {
                if (!bl2 && !bl) {
                    n2 = 0;
                    break;
                }
                if (!bl2) {
                    n2 = 1;
                    break;
                }
                if (!bl) {
                    n2 = 2;
                    break;
                }
                n2 = -1;
                break;
            }
            case 1: {
                if (!bl) {
                    n2 = 0;
                    break;
                }
                if (!bl2) {
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
                if (!bl) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                n2 = !bl2 || !bl ? n : -1;
            }
        }
        return n2;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
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
        NAVIGATION_LISTENER_IDS = new int[]{745};
    }
}

