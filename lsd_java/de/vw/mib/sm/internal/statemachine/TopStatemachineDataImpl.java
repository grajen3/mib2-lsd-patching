/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.sm.AppHmiEnvironment;
import de.vw.mib.sm.internal.CurrentHMIEvent;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.statemachine.FoundLocation;
import de.vw.mib.sm.internal.statemachine.StatemachineException;
import de.vw.mib.sm.internal.statemachine.StatemachinesResDataAccess;
import de.vw.mib.sm.internal.statemachine.SubStatemachine;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import de.vw.mib.sm.internal.waitaphore.Waitaphore;

public class TopStatemachineDataImpl
implements TopStatemachine {
    private static final boolean DEEP_HISTORY;
    private static final boolean SHALLOW_HISTORY;
    private static final int LOOPCOUNT_LIMIT;
    private static final boolean CHECKPOINT_FT;
    private static final char CP_FT_INTERNAL_APPLY;
    private static final char CP_FT_INTERNAL_APPLING;
    private static final char CP_FT_INTERNAL_NOT_APPLIED;
    private static final char CP_FT_TRIGGERED_APPLY;
    private static final char CP_FT_TRIGGERED_APPLING;
    private static final char CP_FT_TRIGGERED_NOT_APPLIED;
    private final int ID;
    private final short POPUP_INFO;
    private final short SPEECH_INDEX;
    private final short SPEECH_CLIENT_ID;
    private final byte KIND;
    private static final short SSM_PATH_NIL;
    private final short SSM_PATH_ROOT;
    private final short[] SSM_PATHS_PARENT;
    private final short[] SSM_PATHS_SLOT_STATE_ID;
    private final short[] SSM_PATHS_SUB_IDX;
    private final short[] SUB_IDS;
    private final short[] POPUP_INFOS_IDS;
    private final short[] POPUP_INFOS_VIEWSTATES;
    private final int SUB_BEGIN;
    private final int SUB_END;
    private final SubStatemachine[] subStatemachines;
    private final IntArrayList includedDdpGroupIds;
    private Waitaphore waitaphore;
    private AppHmiEnvironment environment;
    private SubStatemachine currentSubStatemachine;
    private short currentSsmPathIdx;
    private int liveCycle = 1;
    private long receiverIds = 0L;
    private int receiverOut = 0;
    private boolean emergency = false;
    private final FoundLocation found = new FoundLocation();
    private static final String FATAL_FULL_STOP_MSG;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$sm$internal$statemachine$TopStatemachineDataImpl;

    @Override
    public AppHmiEnvironment getEnvironment() {
        Preconditions.checkState(this.environment != null, "Statemachine was not started before access environment.");
        return this.environment;
    }

    @Override
    public final int getId() {
        return this.ID;
    }

    @Override
    public String getLayerLabel() {
        return "Main";
    }

    @Override
    public int getPopupInfoId() {
        return this.getPopupInfoId(-1, -1);
    }

    @Override
    public int getPopupInfoId(int n, int n2) {
        short s = this.POPUP_INFO;
        while (this.POPUP_INFOS_VIEWSTATES[s] != -1 && this.POPUP_INFOS_VIEWSTATES[s] != n2) {
            s = (short)(s - 1);
        }
        return this.POPUP_INFOS_IDS[s];
    }

    @Override
    public final short getSpeechIndex() {
        return this.SPEECH_INDEX;
    }

    @Override
    public short getSpeechClientId() {
        return this.SPEECH_CLIENT_ID;
    }

    @Override
    public final byte getKind() {
        return this.KIND;
    }

    public TopStatemachineDataImpl(int n, StatemachinesResDataAccess statemachinesResDataAccess, short s, boolean bl) {
        this.ID = n;
        this.POPUP_INFO = statemachinesResDataAccess.getTopStatemachines_PopupInfo()[n];
        this.SPEECH_INDEX = s;
        this.SPEECH_CLIENT_ID = statemachinesResDataAccess.getTopStatemachines_SpeechClientId()[n];
        this.KIND = statemachinesResDataAccess.getTopStatemachines_Kind()[n];
        this.SUB_IDS = statemachinesResDataAccess.getSubIds();
        this.SSM_PATHS_PARENT = statemachinesResDataAccess.getSsmPaths_Parent();
        this.SSM_PATHS_SLOT_STATE_ID = statemachinesResDataAccess.getSsmPaths_SlotStateId();
        this.SSM_PATHS_SUB_IDX = statemachinesResDataAccess.getSsmPaths_SubIdx();
        this.SSM_PATH_ROOT = statemachinesResDataAccess.getTopStatemachines_SsmPathRoot()[n];
        this.POPUP_INFOS_IDS = statemachinesResDataAccess.getPopupInfos_PopupInfoId();
        this.POPUP_INFOS_VIEWSTATES = statemachinesResDataAccess.getPopupInfos_ViewStateId();
        int[] nArray = this.getSubRange();
        this.SUB_BEGIN = nArray[0];
        this.SUB_END = nArray[1];
        this.subStatemachines = new SubStatemachine[this.SUB_END - this.SUB_BEGIN];
        if (!bl) {
            for (int i2 = 0; i2 < this.subStatemachines.length; ++i2) {
                this.subStatemachines[i2] = this.createSubStatemachine(i2);
            }
        }
        this.includedDdpGroupIds = new IntArrayList(0);
    }

    private int[] getSubRange() {
        int n;
        int n2 = n = this.SSM_PATHS_SUB_IDX[this.SSM_PATH_ROOT];
        int n3 = this.SSM_PATH_ROOT + 1;
        while (this.SSM_PATHS_PARENT[n3] != -1) {
            int n4 = this.SSM_PATHS_SUB_IDX[n3];
            n = n < n4 ? n : n4;
            n2 = n2 > n4 ? n2 : n4;
            ++n3;
        }
        return new int[]{n, n2 + 1};
    }

    private static void checkpoint(char c2) {
        if (CHECKPOINT_FT) {
            ServiceManagerStatemachine.journalEx.checkpoint(c2);
        }
    }

    @Override
    public final void start(AppHmiEnvironment appHmiEnvironment) {
        this.environment = appHmiEnvironment;
        this.waitaphore = new Waitaphore(this.environment.getAppInstance());
        this.activateSubStatemachine(this.SSM_PATH_ROOT);
        this.enterCurrentSubstatemachine();
        this.liveCycle = 2;
        this.gotoStableState();
    }

    @Override
    public final void finish() {
        while (this.currentSubStatemachine != null) {
            this.leaveCurrentSubStatemachine();
            this.deactivateCurrentSubStatemachine();
        }
        this.waitaphore.closeWaitPopup();
        this.waitaphore = null;
        this.liveCycle = 1;
    }

    @Override
    public final void suspend() {
        short s = this.currentSsmPathIdx;
        while (s != -1) {
            int n = this.SSM_PATHS_SUB_IDX[s] - this.SUB_BEGIN;
            SubStatemachine subStatemachine = this.subStatemachines[n];
            this.deregisterSubStatemachineReceiver(subStatemachine);
            s = this.SSM_PATHS_PARENT[s];
        }
        this.liveCycle = 4;
    }

    @Override
    public final void resume() {
        short s = this.currentSsmPathIdx;
        while (s != -1) {
            int n = this.SSM_PATHS_SUB_IDX[s] - this.SUB_BEGIN;
            SubStatemachine subStatemachine = this.subStatemachines[n];
            this.registerSubStatemachineReceiver(subStatemachine);
            s = this.SSM_PATHS_PARENT[s];
        }
        this.liveCycle = 2;
    }

    @Override
    public final void focusGained() {
        short s = this.currentSsmPathIdx;
        while (s != -1) {
            int n = this.SSM_PATHS_SUB_IDX[s] - this.SUB_BEGIN;
            SubStatemachine subStatemachine = this.subStatemachines[n];
            subStatemachine.performFocusGainedAction();
            s = this.SSM_PATHS_PARENT[s];
        }
    }

    @Override
    public final void focusLost() {
        short s = this.currentSsmPathIdx;
        while (s != -1) {
            int n = this.SSM_PATHS_SUB_IDX[s] - this.SUB_BEGIN;
            SubStatemachine subStatemachine = this.subStatemachines[n];
            subStatemachine.performFocusLostAction();
            s = this.SSM_PATHS_PARENT[s];
        }
    }

    @Override
    public boolean livesIn(int n) {
        return (this.liveCycle & n) != 0;
    }

    @Override
    public boolean canResponseToHMIEvent() {
        return this.isCurrentEventForAppInstance() && this.canResponseToCurrentEventId();
    }

    private boolean isCurrentEventForAppInstance() {
        return CurrentHMIEvent.isForAppInstance(this.getEnvironment().getAppInstance());
    }

    private boolean canResponseToCurrentEventId() {
        return this.receiverOut > 0 || ServiceManagerStatemachine.eventReceiverTable.canResponseToCurrentEvent(this.receiverIds);
    }

    @Override
    public final boolean handleHMIEvent() {
        ServiceManagerStatemachine.journalEx.eventForwardingToStatemachine(this.ID, CurrentHMIEvent.publicId());
        boolean bl = false;
        try {
            if (!$assertionsDisabled && !this.isCurrentStateStableOrEmergency()) {
                throw new AssertionError((Object)new StringBuffer().append("Invariant: SM has to be in a stable state: ").append(this.getCurrentStateTrace()).toString());
            }
            boolean bl2 = false;
            if (!bl && this.hasApplicableInternalTransition()) {
                bl = this.performInternalTransition();
                bl2 = true;
            }
            if (!bl && this.hasApplicableTriggeredTransition()) {
                bl = this.performTriggeredTransition();
                bl2 = true;
            }
            if (bl2) {
                this.storeHistory();
            }
            if (bl) {
                CurrentHMIEvent.consume();
            }
            this.emergency = false;
            if (!$assertionsDisabled && !this.isCurrentStateStableOrCloseStatemachine()) {
                throw new AssertionError((Object)new StringBuffer().append("Invariant: SM has to be in a stable state: ").append(this.getCurrentStateTrace()).toString());
            }
        }
        catch (StatemachineException statemachineException) {
            this.emergency = true;
            ServiceManagerStatemachine.errorHandler.handleStatemachineError(statemachineException, true);
        }
        catch (RuntimeException runtimeException) {
            this.emergency = true;
            this.fatalEmergencyInHandleCurrentEvent(runtimeException);
            ServiceManagerStatemachine.errorHandler.handleStatemachineError(runtimeException, true);
        }
        return bl;
    }

    private boolean isCurrentStateStableOrEmergency() {
        byte by = this.currentSubStatemachine.getKindOf(this.currentSubStatemachine.getCurrentState());
        return by == 9 || by == 10 || this.emergency;
    }

    private boolean isCurrentStateStableOrCloseStatemachine() {
        byte by = this.currentSubStatemachine.getKindOf(this.currentSubStatemachine.getCurrentState());
        return by == 9 || by == 10 || by == 3;
    }

    private String getCurrentStateTrace() {
        return new StringBuffer().append("(Id ").append(this.getId()).append("/").append(this.currentSubStatemachine.getSubId()).append("/").append(this.currentSubStatemachine.getCurrentState()).append(")").toString();
    }

    private void storeHistory() {
        short s = this.currentSubStatemachine.getCurrentState();
        short s2 = this.currentSsmPathIdx;
        short s3 = this.currentSsmPathIdx;
        while (s3 != -1) {
            int n = this.SSM_PATHS_SUB_IDX[s3] - this.SUB_BEGIN;
            SubStatemachine subStatemachine = this.subStatemachines[n];
            subStatemachine.storeHistory(s2, s);
            s3 = this.SSM_PATHS_PARENT[s3];
        }
    }

    @Override
    public final short getCurrentSubStatemachinePath() {
        return this.currentSsmPathIdx;
    }

    @Override
    public final int getCurrentSubStatemachine() {
        if (this.currentSubStatemachine == null) {
            return -1;
        }
        return this.currentSubStatemachine.getSubId();
    }

    @Override
    public final short getCurrentState() {
        if (this.currentSubStatemachine == null) {
            return -1;
        }
        return this.currentSubStatemachine.getCurrentState();
    }

    @Override
    public final void restoreState(short s, short s2) {
        try {
            if (!$assertionsDisabled && !this.isCurrentStateStableOrEmergency()) {
                throw new AssertionError((Object)new StringBuffer().append("Invariant: SM has to be in a stable state: ").append(this.getCurrentStateTrace()).toString());
            }
            if (this.currentSsmPathIdx != s || this.currentSubStatemachine.getCurrentState() != s2) {
                short s3 = this.calculateSharedPathOfSourceAndTarget(this.currentSsmPathIdx, s);
                this.performVirtualTransition(s3, s, s2);
                this.gotoStableState();
                this.storeHistory();
            }
            this.emergency = false;
            if (!$assertionsDisabled && !this.isCurrentStateStableOrCloseStatemachine()) {
                throw new AssertionError((Object)new StringBuffer().append("Invariant: SM has to be in a stable state: ").append(this.getCurrentStateTrace()).toString());
            }
        }
        catch (StatemachineException statemachineException) {
            this.emergency = true;
            ServiceManagerStatemachine.errorHandler.handleStatemachineError(statemachineException, true);
        }
        catch (RuntimeException runtimeException) {
            this.emergency = true;
            this.fatalEmergencyInRestoreState(runtimeException);
            ServiceManagerStatemachine.errorHandler.handleStatemachineError(runtimeException, true);
        }
    }

    private short calculateSharedPathOfSourceAndTarget(short s, short s2) {
        short s3;
        short s4 = s2;
        short s5 = s;
        short s6 = this.depthOf(s4);
        for (s3 = this.depthOf(s5); s3 > s6; s3 = (short)(s3 - 1)) {
            s5 = this.SSM_PATHS_PARENT[s5];
        }
        while (s6 > s3) {
            s4 = this.SSM_PATHS_PARENT[s4];
            s6 = (short)(s6 - 1);
        }
        while (s5 != s4) {
            s5 = this.SSM_PATHS_PARENT[s5];
            s4 = this.SSM_PATHS_PARENT[s4];
        }
        if (!$assertionsDisabled && s5 != s4) {
            throw new AssertionError();
        }
        return s5;
    }

    private short depthOf(short s) {
        short s2 = 0;
        short s3 = s;
        while (s3 != -1) {
            s2 = (short)(s2 + 1);
            s3 = this.SSM_PATHS_PARENT[s3];
        }
        return s2;
    }

    private boolean hasApplicableInternalTransition() {
        TopStatemachineDataImpl.checkpoint('A');
        short s = this.currentSsmPathIdx;
        while (s != -1) {
            int n = this.SSM_PATHS_SUB_IDX[s] - this.SUB_BEGIN;
            SubStatemachine subStatemachine = this.subStatemachines[n];
            if (subStatemachine.canResponseToEvent() && subStatemachine.findApplicableInternalTransition(this.found)) {
                TopStatemachineDataImpl.checkpoint('B');
                return true;
            }
            s = this.SSM_PATHS_PARENT[s];
        }
        TopStatemachineDataImpl.checkpoint('C');
        return false;
    }

    private boolean performInternalTransition() {
        ServiceManagerStatemachine.journalEx.internalTransitionPerforming(this.ID, this.found.subStatemachine.getSubId(), this.found.stateId, this.found.transitionId);
        boolean bl = this.found.subStatemachine.performInternalTransition(this.found.transitionId, this.found.stateId);
        ServiceManagerStatemachine.journalEx.internalTransitionPerformed(this.ID, this.found.subStatemachine.getSubId(), this.found.stateId, this.found.transitionId, bl);
        return bl;
    }

    private boolean hasApplicableTriggeredTransition() {
        TopStatemachineDataImpl.checkpoint('M');
        short s = this.currentSsmPathIdx;
        while (s != -1) {
            int n = this.SSM_PATHS_SUB_IDX[s] - this.SUB_BEGIN;
            SubStatemachine subStatemachine = this.subStatemachines[n];
            if (subStatemachine.canResponseToEvent() && subStatemachine.findApplicableTriggeredTransition(this.found)) {
                TopStatemachineDataImpl.checkpoint('N');
                return true;
            }
            s = this.SSM_PATHS_PARENT[s];
        }
        TopStatemachineDataImpl.checkpoint('O');
        return false;
    }

    private boolean performTriggeredTransition() {
        ServiceManagerStatemachine.journalEx.triggeredTransitionPerforming(this.ID, this.found.subStatemachine.getSubId(), this.found.stateId, this.found.transitionId);
        this.gotoFoundTransitionSource();
        boolean bl = this.found.subStatemachine.performTriggeredTransition(this.found.transitionId);
        ServiceManagerStatemachine.journalEx.triggeredTransitionPerformed(this.ID, this.found.subStatemachine.getSubId(), this.found.stateId, this.found.transitionId, bl);
        this.gotoStableState();
        return bl;
    }

    private void performNextUntriggeredTransition() {
        if (this.currentSubStatemachine.findApplicableUntriggeredTransition(this.found)) {
            ServiceManagerStatemachine.journalEx.untriggeredTransitionPerforming(this.ID, this.found.subStatemachine.getSubId(), this.found.stateId, this.found.transitionId);
            if (!$assertionsDisabled && !this.isFoundSubStatemachineCurrent()) {
                throw new AssertionError((Object)"Post-Condition: Found SSM == Current SSM");
            }
            if (!$assertionsDisabled && !this.isFoundStateCurrent()) {
                throw new AssertionError((Object)"Post-Condition: Found Source == Current State");
            }
        } else {
            throw this.fatalErrorUntriggeredTransitionExpected();
        }
        this.currentSubStatemachine.performUntriggeredTransition(this.found.transitionId);
        ServiceManagerStatemachine.journalEx.untriggeredTransitionPerformed(this.ID, this.found.subStatemachine.getSubId(), this.found.stateId, this.found.transitionId);
    }

    private void performStoredHistoryTransition(short s, boolean bl) {
        short s2 = this.currentSubStatemachine.getHistoryStoreSsmPath(s);
        short s3 = this.currentSubStatemachine.getHistoryStoreState(s);
        if (bl) {
            s3 = this.convertStateFromDeepToShallow(s2, s3);
            s2 = this.currentSsmPathIdx;
        }
        this.performVirtualTransition(this.currentSsmPathIdx, s2, s3);
    }

    private void performVirtualTransition(short s, short s2, short s3) {
        this.goVirtualDownTo(s);
        this.goVirtualUpTo(s2, s3);
    }

    private void goVirtualDownTo(short s) {
        while (this.currentSsmPathIdx != s) {
            this.leaveCurrentSubStatemachine();
            this.deactivateCurrentSubStatemachine();
        }
    }

    private void goVirtualUpTo(short s, short s2) {
        int n = this.SSM_PATHS_SUB_IDX[s] - this.SUB_BEGIN;
        if (this.currentSubStatemachine != this.subStatemachines[n]) {
            this.goVirtualUpTo(this.SSM_PATHS_PARENT[s], this.SSM_PATHS_SLOT_STATE_ID[s]);
            short s3 = this.getSubSsmPathIdx(this.currentSubStatemachine.getCurrentState());
            this.activateSubStatemachine(s3);
            this.enterCurrentSubstatemachineAt(this.getVirtualState(s2));
        } else {
            this.currentSubStatemachine.performVirtualTransition(this.getVirtualState(s2));
        }
    }

    private short getVirtualState(short s) {
        return this.isContainer(s) ? this.getInitialStateOf(s) : s;
    }

    private void gotoFoundTransitionSource() {
        this.gotoFoundSubStatemachine();
        this.currentSubStatemachine.leaveCurrentStateTo(this.found.stateId);
        if (!$assertionsDisabled && !this.isFoundStateCurrent()) {
            throw new AssertionError((Object)"Post-Condition: Found Source == Current State");
        }
    }

    private boolean isFoundStateCurrent() {
        return this.currentSubStatemachine.getCurrentState() == this.found.stateId;
    }

    private void gotoFoundSubStatemachine() {
        while (!this.isFoundSubStatemachineCurrent()) {
            this.leaveCurrentSubStatemachine();
            this.deactivateCurrentSubStatemachine();
        }
        if (!$assertionsDisabled && !this.isFoundSubStatemachineCurrent()) {
            throw new AssertionError((Object)"Post-Condition: Found SSM == Current SSM");
        }
    }

    private boolean isFoundSubStatemachineCurrent() {
        return this.found.subStatemachine == this.currentSubStatemachine;
    }

    private void gotoStableState() {
        int n = LOOPCOUNT_LIMIT;
        boolean bl = true;
        while (true) {
            short s = this.currentSubStatemachine.getCurrentState();
            byte by = this.currentSubStatemachine.getKindOf(s);
            switch (by) {
                case 1: {
                    this.handleOpenInclude();
                    break;
                }
                case 2: {
                    this.handleCloseInclude();
                    break;
                }
                case 3: {
                    this.handleCloseStatemachine();
                    return;
                }
                case 4: {
                    this.handleDeepHistoryState();
                    break;
                }
                case 5: {
                    this.handleShallowHistoryState();
                    break;
                }
                case 6: {
                    throw this.fatalErrorForbiddenTransitionTarget();
                }
                case 7: {
                    throw this.fatalErrorForbiddenTransitionTarget();
                }
                case 8: {
                    this.handleInitialState();
                    break;
                }
                case 9: {
                    this.handleStableState();
                    return;
                }
                case 10: {
                    this.handleWaitState();
                    return;
                }
                case 0: {
                    this.handleUnstableState();
                    break;
                }
                default: {
                    throw this.fatalErrorUnknownKindOfState();
                }
            }
            if (--n >= 0) continue;
            this.errorCountExperied(n);
        }
    }

    private void handleOpenInclude() {
        short s = this.getSubSsmPathIdx(this.currentSubStatemachine.getCurrentState());
        this.activateSubStatemachine(s);
        this.enterCurrentSubstatemachine();
    }

    private short getSubSsmPathIdx(short s) {
        short s2 = (short)(this.SSM_PATH_ROOT + 1);
        while (this.SSM_PATHS_PARENT[s2] != -1) {
            if (this.SSM_PATHS_PARENT[s2] == this.currentSsmPathIdx && this.SSM_PATHS_SLOT_STATE_ID[s2] == s) {
                return s2;
            }
            s2 = (short)(s2 + 1);
        }
        throw this.fatalErrorUnknownSsmPath();
    }

    private void handleCloseInclude() {
        this.leaveCurrentSubStatemachine();
        this.deactivateCurrentSubStatemachine();
        this.performNextUntriggeredTransition();
    }

    private void handleCloseStatemachine() {
        this.liveCycle = 8;
    }

    private void handleDeepHistoryState() {
        this.handleHistoryState(false);
    }

    private void handleShallowHistoryState() {
        this.handleHistoryState(true);
    }

    private void handleHistoryState(boolean bl) {
        short s = this.currentSubStatemachine.getCurrentState();
        short s2 = this.currentSubStatemachine.getKindSpecificExtensionDataOf(s);
        if (this.isHistoryStoreFilled(s2)) {
            this.performStoredHistoryTransition(s2, bl);
        } else {
            this.performNextUntriggeredTransition();
        }
    }

    private boolean isHistoryStoreFilled(short s) {
        boolean bl = this.currentSubStatemachine.isHistoryStoreFilled(s);
        return bl;
    }

    private void handleInitialState() {
        this.performNextUntriggeredTransition();
    }

    private void handleStableState() {
        this.waitaphore.closeWaitPopup();
    }

    private void handleWaitState() {
    }

    private void handleUnstableState() {
        this.performNextUntriggeredTransition();
    }

    private void activateSubStatemachine(short s) {
        int n = this.SSM_PATHS_SUB_IDX[s] - this.SUB_BEGIN;
        this.currentSsmPathIdx = s;
        this.currentSubStatemachine = this.subStatemachines[n];
        if (this.currentSubStatemachine == null) {
            this.currentSubStatemachine = this.createSubStatemachine(n);
        }
        ServiceManagerStatemachine.journalEx.subStatemachineActivating(this.ID, this.currentSubStatemachine.getSubId());
        this.registerSubStatemachineReceiver(this.currentSubStatemachine);
        this.currentSubStatemachine.activate();
        ServiceManagerStatemachine.journalEx.subStatemachineActivated(this.ID, this.currentSubStatemachine.getSubId());
    }

    private SubStatemachine createSubStatemachine(int n) {
        short s = this.SUB_IDS[n + this.SUB_BEGIN];
        SubStatemachine subStatemachine = ServiceManagerStatemachine.subStatemachineFactory.createSubStatemachine(s, this);
        if (subStatemachine == null) {
            throw this.fatalErrorUnknownSubStatemachine(s);
        }
        this.subStatemachines[n] = subStatemachine;
        return subStatemachine;
    }

    private void enterCurrentSubstatemachine() {
        short s = this.currentSubStatemachine.getEntryState();
        this.enterCurrentSubstatemachineAt(s);
    }

    private void enterCurrentSubstatemachineAt(short s) {
        this.currentSubStatemachine.enterState(s);
    }

    private void leaveCurrentSubStatemachine() {
        this.currentSubStatemachine.leaveCurrentStateTo((short)-1);
    }

    private void deactivateCurrentSubStatemachine() {
        int n = this.currentSubStatemachine.getSubId();
        ServiceManagerStatemachine.journalEx.subStatemachineDeactivating(this.ID, n);
        this.currentSubStatemachine.deactivate();
        if (!this.livesIn(4)) {
            this.deregisterSubStatemachineReceiver(this.currentSubStatemachine);
        }
        this.currentSsmPathIdx = this.SSM_PATHS_PARENT[this.currentSsmPathIdx];
        this.currentSubStatemachine = this.currentSsmPathIdx == -1 ? null : this.subStatemachines[this.SSM_PATHS_SUB_IDX[this.currentSsmPathIdx] - this.SUB_BEGIN];
        ServiceManagerStatemachine.journalEx.subStatemachineDeactivated(this.ID, n);
    }

    private void registerSubStatemachineReceiver(SubStatemachine subStatemachine) {
        long l = subStatemachine.registerReceiver();
        if (l == -1L) {
            ++this.receiverOut;
        } else {
            this.receiverIds |= l;
        }
    }

    private void deregisterSubStatemachineReceiver(SubStatemachine subStatemachine) {
        long l = subStatemachine.deregisterReceiver();
        if (l == -1L) {
            --this.receiverOut;
        } else {
            this.receiverIds &= l ^ 0xFFFFFFFFFFFFFFFFL;
        }
    }

    private short convertStateFromDeepToShallow(short s, short s2) {
        short s3 = s2;
        s3 = this.shortParentChildLineToCurrentSubStatemachine(s, s3);
        s3 = this.shortParentChildLineToOne(s3);
        return s3;
    }

    private short shortParentChildLineToCurrentSubStatemachine(short s, short s2) {
        short s3 = s2;
        short s4 = s;
        while (this.currentSubStatemachine != this.subStatemachines[this.SSM_PATHS_SUB_IDX[s4] - this.SUB_BEGIN]) {
            s3 = this.SSM_PATHS_SLOT_STATE_ID[s4];
            s4 = this.SSM_PATHS_PARENT[s4];
        }
        return s3;
    }

    private short shortParentChildLineToOne(short s) {
        short s2 = this.currentSubStatemachine.getParentOf(this.currentSubStatemachine.getCurrentState());
        short s3 = s;
        while (s2 != this.currentSubStatemachine.getParentOf(s3)) {
            s3 = this.currentSubStatemachine.getParentOf(s3);
        }
        return s3;
    }

    private boolean isContainer(short s) {
        byte by = this.currentSubStatemachine.getKindOf(s);
        return by == 7 || by == 6;
    }

    private short getInitialStateOf(short s) {
        short s2 = this.currentSubStatemachine.getInitialStateOf(s);
        if (s2 != -1) {
            return s2;
        }
        throw this.fatalErrorMissingInitialState();
    }

    @Override
    public void enterIncludeDdpGroup(int n) {
        this.includedDdpGroupIds.add(n);
    }

    @Override
    public void leaveIncludeDdpGroup() {
        this.includedDdpGroupIds.removeLast();
    }

    @Override
    public int getIncludeDdpGroupId() {
        return this.includedDdpGroupIds.isEmpty() ? -1 : this.includedDdpGroupIds.last();
    }

    @Override
    public void enterWaitaphoreForProperty(int n, int n2, int n3, int n4, int n5) {
        this.waitaphore.enterForProperty(n, n2, n3, n4, n5);
    }

    @Override
    public void enterWaitaphoreForAslList(int n, int n2, int n3, int n4, int n5) {
        this.waitaphore.enterForAslList(n, n2, n3, n4, n5);
    }

    @Override
    public void enterWaitaphoreForAppAdapterList(int n, int n2, int n3, int n4, int n5) {
        this.waitaphore.enterForAppAdapterList(n, n2, n3, n4, n5);
    }

    @Override
    public void enterWaitaphoreForNothing(int n) {
        this.waitaphore.enterForNothing(n);
    }

    @Override
    public void leaveWaitaphore() {
        this.waitaphore.leave();
    }

    private StatemachineException fatalErrorUnknownKindOfState() {
        int n = this.getId();
        int n2 = this.currentSubStatemachine.getSubId();
        short s = this.currentSubStatemachine.getCurrentState();
        String string = "Kind of state unknown. Statemachine is unaware of the next step and stops in a unstable state.";
        StatemachineException statemachineException = new StatemachineException(string);
        ServiceManagerStatemachine.journalEx.fatalError(n, n2, s, statemachineException);
        return statemachineException;
    }

    private StatemachineException fatalErrorForbiddenTransitionTarget() {
        int n = this.getId();
        int n2 = this.currentSubStatemachine.getSubId();
        short s = this.currentSubStatemachine.getCurrentState();
        String string = "State must not be a target of a transition. Statemachine is unaware of the next step and stops in a unstable state.";
        StatemachineException statemachineException = new StatemachineException(string);
        ServiceManagerStatemachine.journalEx.fatalError(n, n2, s, statemachineException);
        return statemachineException;
    }

    private StatemachineException fatalErrorUntriggeredTransitionExpected() {
        int n = this.getId();
        int n2 = this.currentSubStatemachine.getSubId();
        short s = this.currentSubStatemachine.getCurrentState();
        String string = "Missing untriggered transition of unstable state. Statemachine is unaware of the next step and stops in a unstable state.";
        StatemachineException statemachineException = new StatemachineException(string);
        ServiceManagerStatemachine.journalEx.fatalError(n, n2, s, statemachineException);
        return statemachineException;
    }

    private StatemachineException fatalErrorUnknownSubStatemachine(int n) {
        int n2 = this.getId();
        String string = "Sub statemachine is unknown. Statemachine is unaware of the next step and stops in a unstable state.";
        StatemachineException statemachineException = new StatemachineException(string);
        ServiceManagerStatemachine.journalEx.fatalError(n2, n, (short)0, statemachineException);
        return statemachineException;
    }

    private StatemachineException fatalErrorUnknownSsmPath() {
        int n = this.getId();
        int n2 = this.currentSubStatemachine.getSubId();
        short s = this.currentSubStatemachine.getCurrentState();
        String string = "Include Path is unknown. Statemachine is unaware of the next step and stops in a unstable state.";
        StatemachineException statemachineException = new StatemachineException(string);
        ServiceManagerStatemachine.journalEx.fatalError(n, n2, s, statemachineException);
        return statemachineException;
    }

    private StatemachineException fatalErrorMissingInitialState() {
        int n = this.getId();
        int n2 = this.currentSubStatemachine.getSubId();
        short s = this.currentSubStatemachine.getCurrentState();
        String string = "Missing initial state to leave container state. Statemachine is unaware of the next step and stops in a unstable state.";
        StatemachineException statemachineException = new StatemachineException(string);
        ServiceManagerStatemachine.journalEx.fatalError(n, n2, s, statemachineException);
        return statemachineException;
    }

    private void fatalEmergencyInHandleCurrentEvent(RuntimeException runtimeException) {
        int n = this.getId();
        int n2 = this.currentSubStatemachine == null ? -1 : this.currentSubStatemachine.getSubId();
        short s = this.currentSubStatemachine == null ? (short)-1 : (short)this.currentSubStatemachine.getCurrentState();
        int n3 = CurrentHMIEvent.publicId();
        short s2 = CurrentHMIEvent.compactId;
        String string = new StringBuffer().append("Handle current event EID=").append(n3).append(" (compact ").append(s2).append(") failed with a runtime exception '").append(runtimeException.getMessage()).append("'. ").append("Statemachine is unaware of the next step and stops in a unstable state.").toString();
        StatemachineException statemachineException = new StatemachineException(string);
        statemachineException.setStackTrace(runtimeException.getStackTrace());
        statemachineException.initCause(runtimeException);
        ServiceManagerStatemachine.journalEx.fatalError(n, n2, s, statemachineException);
    }

    private void fatalEmergencyInRestoreState(RuntimeException runtimeException) {
        int n = this.getId();
        int n2 = this.currentSubStatemachine.getSubId();
        short s = this.currentSubStatemachine.getCurrentState();
        String string = new StringBuffer().append("Restore state failed with a runtime exception '").append(runtimeException.getMessage()).append("'. ").append("Statemachine is unaware of the next step and stops in a unstable state.").toString();
        StatemachineException statemachineException = new StatemachineException(string);
        statemachineException.setStackTrace(runtimeException.getStackTrace());
        statemachineException.initCause(runtimeException);
        ServiceManagerStatemachine.journalEx.fatalError(n, n2, s, statemachineException);
    }

    private void errorCountExperied(int n) {
        Logger logger = ServiceManagerCommon.loggerFactory.getLogger(0x800000);
        LogMessage logMessage = logger.error(1);
        logMessage.append("Cycle detected: Too long path of untriggered transitions found (");
        logMessage.append(LOOPCOUNT_LIMIT - n).append('>').append(LOOPCOUNT_LIMIT).append(") to reach stable state.\n");
        this.appendToLog(logMessage);
        logMessage.log();
    }

    @Override
    public void appendToLog(LogMessage logMessage) {
        if (this.currentSubStatemachine != null) {
            int n = this.currentSubStatemachine.getSubId();
            short s = this.currentSsmPathIdx;
            logMessage.append(" - State: ").append(this.ID).append(':').append(n).append(':').append(this.currentSubStatemachine.getCurrentState());
            logMessage.append(" path ").append(s).append("\n");
        } else {
            logMessage.append("No current substatemachine!");
        }
    }

    public String toString() {
        int n = this.getId();
        int n2 = this.currentSubStatemachine == null ? -1 : this.currentSubStatemachine.getSubId();
        int n3 = this.currentSubStatemachine == null ? -1 : (int)this.currentSubStatemachine.getCurrentState();
        char c2 = this.liveCycle < 0 || this.liveCycle > 8 ? (char)'?' : (char)"?IA?S???F".charAt(this.liveCycle);
        int n4 = CurrentHMIEvent.publicId();
        short s = CurrentHMIEvent.compactId;
        return new StringBuffer().append("SM: SMID=").append(n).append(" SSMID=").append(n2).append(" SID=").append(n3).append(" LC=").append(c2).append("=").append(this.liveCycle).append(" EV=").append(n4).append(" CEV=").append(s).toString();
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
        $assertionsDisabled = !(class$de$vw$mib$sm$internal$statemachine$TopStatemachineDataImpl == null ? (class$de$vw$mib$sm$internal$statemachine$TopStatemachineDataImpl = TopStatemachineDataImpl.class$("de.vw.mib.sm.internal.statemachine.TopStatemachineDataImpl")) : class$de$vw$mib$sm$internal$statemachine$TopStatemachineDataImpl).desiredAssertionStatus();
        LOOPCOUNT_LIMIT = Integer.getInteger("statemachine.loopcount.limit", 100);
        CHECKPOINT_FT = Boolean.getBoolean("smjournal.checkpoint") || Boolean.getBoolean("smjournal.checkpoint.ft");
    }
}

