/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.Array;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationLaneGuidanceElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingRequestTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayMessageBlockingTracker;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LaneGuidance_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LaneGuidance_GetArray;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LaneGuidance_LaneGuidance;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LaneGuidance_StatusArray;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class LaneGuidance
extends Function
implements TimerNotifier,
Array,
ASLNavSDConstants,
NavigationServiceListener {
    private LaneGuidance_ChangedArray fullLaneGuidanceChangedArray = null;
    private LaneGuidance_ChangedArray actualLaneGuidanceList;
    private static final int CHANGE_ELEMENT_CHANGED;
    private static final int CHANGE_ELEMENT_ADDED;
    private static final int CHANGE_ELEMENT_REMOVED;
    private static final int MAX_CHANGE_FOR_CHANGE_ARRAY;
    private static final int INITIAL_FIND_CHANGED_DATA_ARRAY_SIZE;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_SEARCH_FOR_CHANGE;
    private static final int NOT_FOUND_INDEX;
    private static final int LIST_OFFSET;
    private static final int MAX_ELEMENTS;
    private static final int LANE_INVALID_DIRECTION;
    private static final int NUMBER_OF_MAX_LANES;
    private FsgArrayMessageBlockingTracker _arrayRequestTracker;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$LaneGuidance_ChangedArray;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.timer = this.getTimerService().createTimer(this, 1000);
        this.fullLaneGuidanceChangedArray = new LaneGuidance_ChangedArray();
        this.actualLaneGuidanceList = new LaneGuidance_ChangedArray();
        this.computeFullLaneGuidanceList(this.fullLaneGuidanceChangedArray);
        return this.getLaneGuidanceListFullRangeUpdate();
    }

    protected LaneGuidance_ChangedArray dequeueBAPEntity() {
        return (LaneGuidance_ChangedArray)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$LaneGuidance_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$LaneGuidance_ChangedArray = LaneGuidance.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.LaneGuidance_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$LaneGuidance_ChangedArray);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 24;
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
            this.actualLaneGuidanceList.reset();
            this.computeFullLaneGuidanceList(this.actualLaneGuidanceList);
            LaneGuidance_ChangedArray laneGuidance_ChangedArray = this.searchForChangeContent(this.actualLaneGuidanceList, this.fullLaneGuidanceChangedArray);
            if (laneGuidance_ChangedArray != null) {
                if (laneGuidance_ChangedArray.laneGuidanceOnOff == this.fullLaneGuidanceChangedArray.laneGuidanceOnOff) {
                    this.timer.retrigger(new Integer(0));
                }
                this.getArrayRequestTracker().reportChangedArray(laneGuidance_ChangedArray);
                LaneGuidance_ChangedArray laneGuidance_ChangedArray2 = this.fullLaneGuidanceChangedArray;
                this.fullLaneGuidanceChangedArray = this.actualLaneGuidanceList;
                this.actualLaneGuidanceList = laneGuidance_ChangedArray2;
            }
        }
    }

    @Override
    public void getArray(BAPEntity bAPEntity, ArrayListener arrayListener) {
        LaneGuidance_GetArray laneGuidance_GetArray = (LaneGuidance_GetArray)bAPEntity;
        if (this.getArrayRequestTracker().requestGetArray(laneGuidance_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(laneGuidance_GetArray.getArrayHeader(), this.fullLaneGuidanceChangedArray.getArrayData().size(), laneGuidance_GetArray.getArrayHeader().start - 0, 8);
            LaneGuidance_StatusArray laneGuidance_StatusArray = new LaneGuidance_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderData(laneGuidance_StatusArray, laneGuidance_GetArray, null);
            this.setHeaderForLaneElementsForCorrectSerialization(laneGuidance_StatusArray.getArrayHeader());
            laneGuidance_StatusArray.laneGuidanceOnOff = this.fullLaneGuidanceChangedArray.laneGuidanceOnOff;
            fsgArrayRequestData.fillRequestData((BAPStatusArray)laneGuidance_StatusArray, this.fullLaneGuidanceChangedArray);
            fsgArrayRequestData.setTransmissionPosForConsecutiveArray(laneGuidance_StatusArray);
            this.transmitStatus(arrayListener, laneGuidance_StatusArray);
        }
    }

    private void setHeaderForLaneElementsForCorrectSerialization(ArrayHeader arrayHeader) {
        Iterator iterator = this.fullLaneGuidanceChangedArray.getArrayData().getIterator();
        while (iterator.hasNext()) {
            ((LaneGuidance_LaneGuidance)iterator.next()).setArrayHeader(arrayHeader);
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

    private void transmitStatus(ArrayListener arrayListener, LaneGuidance_StatusArray laneGuidance_StatusArray) {
        this.getArrayRequestTracker().reportStatusArray(laneGuidance_StatusArray);
    }

    private LaneGuidance_ChangedArray getLaneGuidanceListFullRangeUpdate() {
        LaneGuidance_ChangedArray laneGuidance_ChangedArray = this.dequeueBAPEntity();
        laneGuidance_ChangedArray.laneGuidanceOnOff = this.fullLaneGuidanceChangedArray.laneGuidanceOnOff;
        laneGuidance_ChangedArray.getArrayHeader().setFullRangeUpdate(false);
        return laneGuidance_ChangedArray;
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

    private void computeFullLaneGuidanceList(LaneGuidance_ChangedArray laneGuidance_ChangedArray) {
        Object object;
        NavigationService navigationService = this.getNavigationService();
        BAPArrayData bAPArrayData = laneGuidance_ChangedArray.getArrayData();
        int n = 6;
        Iterator iterator = navigationService.getLaneGuidance();
        int n2 = 0;
        while (iterator.hasNext()) {
            iterator.next();
            ++n2;
        }
        int n3 = Math.max(n2 - 6, 0);
        boolean bl = false;
        boolean bl2 = false;
        int n4 = 0;
        int n5 = 0;
        iterator = navigationService.getLaneGuidance();
        while (iterator.hasNext()) {
            object = (NavigationLaneGuidanceElement)iterator.next();
            LaneGuidance_LaneGuidance laneGuidance_LaneGuidance = new LaneGuidance_LaneGuidance(laneGuidance_ChangedArray.getArrayHeader());
            laneGuidance_LaneGuidance.laneDirection = object.getDirection();
            laneGuidance_LaneGuidance.laneSidestreets.setContent(object.getSideStreets());
            laneGuidance_LaneGuidance.laneType = object.getLaneType();
            laneGuidance_LaneGuidance.laneMarking_left = object.getMarkingLeft();
            laneGuidance_LaneGuidance.laneMarking_right = object.getMarkingRight();
            laneGuidance_LaneGuidance.laneDescription = object.getLaneDescription();
            laneGuidance_LaneGuidance.guidanceInfo = object.getLaneGuidanceInfo();
            if (n4 == 0 && n3 > 0 && laneGuidance_LaneGuidance.guidanceInfo == 0) {
                bl = true;
                --n3;
                continue;
            }
            if (n5++ < 6) {
                laneGuidance_LaneGuidance.setPos(n4++);
                bAPArrayData.add(laneGuidance_LaneGuidance);
                continue;
            }
            bl2 = true;
        }
        if (n2 > 6) {
            if (bl) {
                object = (LaneGuidance_LaneGuidance)bAPArrayData.getFirst();
                ((LaneGuidance_LaneGuidance)object).laneType = 23;
            }
            if (bl2) {
                object = (LaneGuidance_LaneGuidance)bAPArrayData.getLast();
                ((LaneGuidance_LaneGuidance)object).laneType = 24;
            }
        }
        laneGuidance_ChangedArray.laneGuidanceOnOff = navigationService.getRouteGuidanceState() == 1 ? (navigationService.isSetupLaneGuidanceActive() ? 1 : 0) : 0;
    }

    private static boolean laneGuidanceElementsEqual(LaneGuidance_LaneGuidance laneGuidance_LaneGuidance, LaneGuidance_LaneGuidance laneGuidance_LaneGuidance2) {
        boolean bl;
        boolean bl2 = bl = laneGuidance_LaneGuidance.laneDirection == laneGuidance_LaneGuidance2.laneDirection && laneGuidance_LaneGuidance.laneType == laneGuidance_LaneGuidance2.laneType && laneGuidance_LaneGuidance.laneMarking_left == laneGuidance_LaneGuidance2.laneMarking_right && laneGuidance_LaneGuidance.laneDescription == laneGuidance_LaneGuidance2.laneDescription && laneGuidance_LaneGuidance.guidanceInfo == laneGuidance_LaneGuidance2.guidanceInfo;
        if (bl) {
            bl = laneGuidance_LaneGuidance.laneSidestreets.toString().compareTo(laneGuidance_LaneGuidance2.laneSidestreets.toString()) == 0;
        }
        return bl;
    }

    private List findChangedData(LaneGuidance_ChangedArray laneGuidance_ChangedArray, LaneGuidance_ChangedArray laneGuidance_ChangedArray2) {
        ArrayList arrayList = new ArrayList(4);
        int n = laneGuidance_ChangedArray.getArrayData().size() - laneGuidance_ChangedArray2.getArrayData().size();
        int n2 = Math.abs(n);
        int n3 = n < 0 ? -1 : (n == 0 ? 0 : 1);
        switch (n3) {
            case -1: 
            case 1: {
                int n4 = 0;
                int n5 = 0;
                int n6 = -1;
                int n7 = laneGuidance_ChangedArray2.getArrayData().size();
                int n8 = laneGuidance_ChangedArray.getArrayData().size();
                while (n5 < n7 && n4 < n8) {
                    LaneGuidance_LaneGuidance laneGuidance_LaneGuidance;
                    boolean bl;
                    LaneGuidance_LaneGuidance laneGuidance_LaneGuidance2 = (LaneGuidance_LaneGuidance)laneGuidance_ChangedArray.getArrayData().get(n4);
                    boolean bl2 = bl = !LaneGuidance.laneGuidanceElementsEqual(laneGuidance_LaneGuidance2, laneGuidance_LaneGuidance = (LaneGuidance_LaneGuidance)laneGuidance_ChangedArray2.getArrayData().get(n5));
                    if (bl) {
                        if (n6 != -1 && n6 + 1 != laneGuidance_LaneGuidance.getPos()) {
                            return null;
                        }
                        arrayList.add(laneGuidance_LaneGuidance);
                        n6 = laneGuidance_LaneGuidance.getPos();
                    }
                    if (n3 == -1) {
                        ++n5;
                        if (!bl) continue;
                        ++n4;
                        continue;
                    }
                    ++n4;
                    if (!bl) continue;
                    ++n5;
                }
                break;
            }
            default: {
                BAPArrayData bAPArrayData = laneGuidance_ChangedArray.getArrayData();
                BAPArrayData bAPArrayData2 = laneGuidance_ChangedArray2.getArrayData();
                int n9 = laneGuidance_ChangedArray.getArrayData().size();
                for (int i2 = 0; i2 < n9; ++i2) {
                    LaneGuidance_LaneGuidance laneGuidance_LaneGuidance;
                    LaneGuidance_LaneGuidance laneGuidance_LaneGuidance3 = (LaneGuidance_LaneGuidance)bAPArrayData.get(i2);
                    if (LaneGuidance.laneGuidanceElementsEqual(laneGuidance_LaneGuidance3, laneGuidance_LaneGuidance = (LaneGuidance_LaneGuidance)bAPArrayData2.get(i2))) continue;
                    arrayList.add(laneGuidance_LaneGuidance);
                }
            }
        }
        if (arrayList.size() != n2) {
            return null;
        }
        return arrayList;
    }

    private LaneGuidance_ChangedArray searchForChangeContent(LaneGuidance_ChangedArray laneGuidance_ChangedArray, LaneGuidance_ChangedArray laneGuidance_ChangedArray2) {
        LaneGuidance_ChangedArray laneGuidance_ChangedArray3 = null;
        int n = laneGuidance_ChangedArray.getArrayData().size() - laneGuidance_ChangedArray.getArrayData().size();
        int n2 = n < 0 ? -1 : (n == 0 ? 0 : 1);
        if ((n = Math.abs(n)) > 4 || laneGuidance_ChangedArray2.getArrayData().size() == 0 ^ laneGuidance_ChangedArray.getArrayData().size() == 0 || laneGuidance_ChangedArray.laneGuidanceOnOff != laneGuidance_ChangedArray2.laneGuidanceOnOff) {
            laneGuidance_ChangedArray3 = this.getLaneGuidanceListFullRangeUpdate();
        } else {
            List list = this.findChangedData(laneGuidance_ChangedArray, laneGuidance_ChangedArray2);
            if (list == null || list.size() != 0 && list.size() == laneGuidance_ChangedArray.getArrayData().size()) {
                laneGuidance_ChangedArray3 = this.getLaneGuidanceListFullRangeUpdate();
            } else if (list.size() != 0) {
                switch (n2) {
                    case 1: {
                        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance;
                        if (list.isEmpty()) break;
                        laneGuidance_ChangedArray3 = this.dequeueBAPEntity();
                        ArrayHeader arrayHeader = laneGuidance_ChangedArray3.getArrayHeader();
                        arrayHeader.mode.shift = true;
                        arrayHeader.mode.arrayDirectionIsBackward = false;
                        arrayHeader.mode.arrayPositionIsTransmitted = true;
                        arrayHeader.setRecordAddress(15);
                        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance2 = (LaneGuidance_LaneGuidance)list.get(0);
                        arrayHeader.start = laneGuidance_LaneGuidance2.getPos() != 0 ? laneGuidance_LaneGuidance2.getPos() - 0 : laneGuidance_LaneGuidance2.getPos();
                        arrayHeader.elements = list.size();
                        BAPArrayData bAPArrayData = laneGuidance_ChangedArray3.getArrayData();
                        int n3 = list.size();
                        for (int i2 = 0; i2 < n3; ++i2) {
                            laneGuidance_LaneGuidance = (LaneGuidance_LaneGuidance)list.get(i2);
                            bAPArrayData.add(laneGuidance_LaneGuidance);
                        }
                        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance3 = (LaneGuidance_LaneGuidance)list.get(list.size() - 1);
                        laneGuidance_LaneGuidance = new LaneGuidance_LaneGuidance(laneGuidance_ChangedArray3.getArrayHeader());
                        laneGuidance_LaneGuidance.setPos(laneGuidance_LaneGuidance3.getPos() % list.size());
                        laneGuidance_ChangedArray3.getArrayData().add(laneGuidance_LaneGuidance);
                        break;
                    }
                    case -1: {
                        if (list.isEmpty()) break;
                        laneGuidance_ChangedArray3 = this.dequeueBAPEntity();
                        ArrayHeader arrayHeader = laneGuidance_ChangedArray3.getArrayHeader();
                        arrayHeader.mode.shift = true;
                        arrayHeader.mode.arrayDirectionIsBackward = true;
                        arrayHeader.mode.arrayPositionIsTransmitted = false;
                        arrayHeader.start = ((LaneGuidance_LaneGuidance)list.get(list.size() - 1)).getPos();
                        arrayHeader.elements = list.size();
                        break;
                    }
                    default: {
                        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance;
                        laneGuidance_ChangedArray3 = this.dequeueBAPEntity();
                        ArrayHeader arrayHeader = laneGuidance_ChangedArray3.getArrayHeader();
                        arrayHeader.mode.shift = false;
                        arrayHeader.mode.arrayDirectionIsBackward = false;
                        arrayHeader.mode.arrayPositionIsTransmitted = true;
                        arrayHeader.setRecordAddress(15);
                        arrayHeader.setRecordAddress(0);
                        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance4 = (LaneGuidance_LaneGuidance)list.get(0);
                        arrayHeader.start = laneGuidance_LaneGuidance4.getPos() != 0 ? laneGuidance_LaneGuidance4.getPos() - 0 : laneGuidance_LaneGuidance4.getPos();
                        arrayHeader.elements = list.size();
                        BAPArrayData bAPArrayData = laneGuidance_ChangedArray3.getArrayData();
                        int n4 = list.size();
                        for (int i3 = 0; i3 < n4; ++i3) {
                            laneGuidance_LaneGuidance = (LaneGuidance_LaneGuidance)list.get(i3);
                            bAPArrayData.add(laneGuidance_LaneGuidance);
                        }
                        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance5 = (LaneGuidance_LaneGuidance)list.get(list.size() - 1);
                        laneGuidance_LaneGuidance = new LaneGuidance_LaneGuidance(laneGuidance_ChangedArray3.getArrayHeader());
                        laneGuidance_LaneGuidance.setPos(laneGuidance_LaneGuidance5.getPos() % list.size());
                        laneGuidance_ChangedArray3.getArrayData().add(laneGuidance_LaneGuidance);
                        break;
                    }
                }
            }
        }
        if (laneGuidance_ChangedArray3 != null) {
            laneGuidance_ChangedArray3.laneGuidanceOnOff = laneGuidance_ChangedArray.laneGuidanceOnOff;
        }
        return laneGuidance_ChangedArray3;
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
        NAVIGATION_LISTENER_IDS = new int[]{732, 731, 742};
    }
}

