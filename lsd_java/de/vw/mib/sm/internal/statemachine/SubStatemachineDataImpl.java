/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

import de.vw.mib.sm.internal.CurrentHMIEvent;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.activity.EventReceiverTable$ReceiverColumn;
import de.vw.mib.sm.internal.statemachine.FoundLocation;
import de.vw.mib.sm.internal.statemachine.StatemachineActivity;
import de.vw.mib.sm.internal.statemachine.StatemachinesResDataAccess;
import de.vw.mib.sm.internal.statemachine.SubStatemachine;
import de.vw.mib.sm.internal.statemachine.TopStatemachine;
import java.util.Arrays;

public class SubStatemachineDataImpl
implements SubStatemachine {
    protected static final short[] NO_TRIGGERS;
    protected static final char FOUNDCACHE_UNKNOWN;
    protected static final char FOUNDCACHE_NOTFOUND;
    private static final boolean CHECKPOINT_FT;
    private static final char CP_FT_CACHE_REFILL;
    private static final char CP_FT_CACHE_REUSED;
    private static final char CP_FT_INTERNAL_FIND;
    private static final char CP_FT_INTERNAL_FILL_CACHE;
    private static final char CP_FT_INTERNAL_FIND_LOOP;
    private static final char CP_FT_INTERNAL_FOUND;
    private static final char CP_FT_INTERNAL_NOT_FOUND;
    private static final char CP_FT_TRIGGERED_FIND;
    private static final char CP_FT_TRIGGERED_FILL_CACHE;
    private static final char CP_FT_TRIGGERED_FIND_LOOP;
    private static final char CP_FT_TRIGGERED_FOUND;
    private static final char CP_FT_TRIGGERED_NOT_FOUND;
    private static final short[] EMPTY_STORE;
    private static final int TRANSITION_FLAG_CONSUMING_TRIGGER;
    private static final int TRANSITION_FLAG_DOWN_TRANSITION;
    private final int SUBID;
    private final int TOPID;
    private final StatemachineActivity ACTIVITY;
    private final short CACHE_CAPACITY;
    private final short GSTATE_ENTRY;
    private final short S_OFFSET;
    private final byte[] S_KIND;
    private final short[] S_PARENT;
    private final short[] S_ITSTART;
    private final short[] S_ITEND;
    private final short[] S_TTSTART;
    private final short[] S_TTEND;
    private final short[] S_UTSTART;
    private final short[] S_UTEND;
    private final short[] S_EXTENSION;
    private final short IT_OFFSET;
    private final short[] IT_TRIGGER;
    private final byte[] IT_FLAGS;
    private final short TT_OFFSET;
    private final short[] TT_TRIGGER;
    private final short[] TT_TARGET;
    private final byte[] TT_FLAGS;
    private final short UT_OFFSET;
    private final short[] UT_TARGET;
    private final byte[] UT_FLAGS;
    private short gCurrentState;
    private final short[] historyStoreSsmPaths;
    private final short[] historyStoreStates;
    private short[] triggers;
    private long receiverId;
    private static int CACHE_NULLCHECK;
    private static int CACHE_NOT_FILLED;
    private static int CACHE_NO_VALUE;
    private int[] cacheChecks;
    private int[] cacheInternals;
    private int[] cacheTriggereds;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$sm$internal$statemachine$SubStatemachineDataImpl;

    public SubStatemachineDataImpl(int n, StatemachinesResDataAccess statemachinesResDataAccess, TopStatemachine topStatemachine) {
        this.S_OFFSET = statemachinesResDataAccess.getSubStatemachines_SOffset()[n];
        this.S_KIND = statemachinesResDataAccess.getStates_Kind();
        this.S_PARENT = statemachinesResDataAccess.getStates_Parent();
        this.S_ITSTART = statemachinesResDataAccess.getStates_ITstart();
        this.S_ITEND = statemachinesResDataAccess.getStates_ITend();
        this.S_TTSTART = statemachinesResDataAccess.getStates_TTstart();
        this.S_TTEND = statemachinesResDataAccess.getStates_TTend();
        this.S_UTSTART = statemachinesResDataAccess.getStates_UTstart();
        this.S_UTEND = statemachinesResDataAccess.getStates_UTend();
        this.S_EXTENSION = statemachinesResDataAccess.getStates_Extension();
        this.IT_OFFSET = statemachinesResDataAccess.getSubStatemachines_ItOffset()[n];
        this.IT_TRIGGER = statemachinesResDataAccess.getInternals_Trigger();
        this.IT_FLAGS = statemachinesResDataAccess.getInternals_Flags();
        this.TT_OFFSET = statemachinesResDataAccess.getSubStatemachines_TtOffset()[n];
        this.TT_TRIGGER = statemachinesResDataAccess.getTriggereds_Trigger();
        this.TT_TARGET = statemachinesResDataAccess.getTriggereds_Target();
        this.TT_FLAGS = statemachinesResDataAccess.getTriggereds_Flags();
        this.UT_OFFSET = statemachinesResDataAccess.getSubStatemachines_UtOffset()[n];
        this.UT_TARGET = statemachinesResDataAccess.getUntriggereds_Target();
        this.UT_FLAGS = statemachinesResDataAccess.getUntriggereds_Flags();
        this.SUBID = n;
        this.TOPID = topStatemachine.getId();
        this.ACTIVITY = ServiceManagerStatemachine.activityFactory.createActivity(topStatemachine, statemachinesResDataAccess.getSubStatemachines_Activity()[n], this.S_OFFSET, this.IT_OFFSET, this.TT_OFFSET, this.UT_OFFSET);
        this.GSTATE_ENTRY = statemachinesResDataAccess.getSubStatemachines_EntryState()[n];
        this.CACHE_CAPACITY = (short)10;
        short s = statemachinesResDataAccess.getSubStatemachines_HistoryCount()[n];
        this.historyStoreSsmPaths = this.createHistoryStore(s);
        this.historyStoreStates = this.initHistoryStore(s);
        this.triggers = null;
        this.receiverId = -1L;
        this.initCache();
    }

    private static void checkpoint(char c2) {
        if (CHECKPOINT_FT) {
            ServiceManagerStatemachine.journalEx.checkpoint(c2);
        }
    }

    @Override
    public final int getSubId() {
        return this.SUBID;
    }

    @Override
    public final short getEntryState() {
        return this.sG2Id(this.GSTATE_ENTRY);
    }

    @Override
    public final void activate() {
        this.gCurrentState = (short)-1;
    }

    @Override
    public final void deactivate() {
    }

    @Override
    public long registerReceiver() {
        if (this.triggers == null) {
            this.receiverId = ServiceManagerStatemachine.eventReceiverTable.allocReceiverId();
            this.triggers = this.calculateTriggerIds(ServiceManagerStatemachine.eventReceiverTable.getReceiverColumn(this.receiverId));
            if (this.triggers.length == 0) {
                ServiceManagerStatemachine.eventReceiverTable.freeReceiverId(this.receiverId);
                this.receiverId = 0L;
            }
        } else if (this.triggers.length == 0) {
            this.receiverId = 0L;
        } else {
            this.receiverId = ServiceManagerStatemachine.eventReceiverTable.allocReceiverId();
            ServiceManagerStatemachine.eventReceiverTable.setColumn(this.receiverId, this.triggers);
        }
        return this.receiverId;
    }

    @Override
    public long deregisterReceiver() {
        if (this.triggers.length != 0) {
            ServiceManagerStatemachine.eventReceiverTable.unsetColumn(this.receiverId, this.triggers);
            ServiceManagerStatemachine.eventReceiverTable.freeReceiverId(this.receiverId);
        }
        long l = this.receiverId;
        this.receiverId = -1L;
        return l;
    }

    private short[] calculateTriggerIds(EventReceiverTable$ReceiverColumn eventReceiverTable$ReceiverColumn) {
        short s;
        int n;
        short s2 = this.S_ITEND[this.S_OFFSET];
        short s3 = this.S_TTEND[this.S_OFFSET];
        for (n = this.S_OFFSET + 1; n < this.S_PARENT.length && this.S_PARENT[n] != -1; ++n) {
            s2 = this.max(s2, this.S_ITEND[n]);
            s3 = this.max(s3, this.S_TTEND[n]);
        }
        if (eventReceiverTable$ReceiverColumn != null) {
            for (n = (int)this.IT_OFFSET; n < s2; ++n) {
                eventReceiverTable$ReceiverColumn.setCompactEventId(this.IT_TRIGGER[n]);
            }
            for (n = (int)this.TT_OFFSET; n < s3; ++n) {
                eventReceiverTable$ReceiverColumn.setCompactEventId(this.TT_TRIGGER[n]);
            }
            return eventReceiverTable$ReceiverColumn.getCompactEventIds();
        }
        if (s2 == this.IT_OFFSET && s3 == this.TT_OFFSET) {
            return NO_TRIGGERS;
        }
        short[] sArray = new short[s2 - this.IT_OFFSET + s3 - this.TT_OFFSET];
        int n2 = 0;
        for (s = this.IT_OFFSET; s < s2; s = (short)(s + 1)) {
            int n3 = n2;
            n2 = (short)(n2 + 1);
            sArray[n3] = this.IT_TRIGGER[s];
        }
        for (s = this.TT_OFFSET; s < s3; s = (short)(s + 1)) {
            int n4 = n2;
            n2 = (short)(n2 + 1);
            sArray[n4] = this.TT_TRIGGER[s];
        }
        if (!$assertionsDisabled && sArray.length != n2) {
            throw new AssertionError();
        }
        Arrays.sort(sArray);
        s = 1;
        for (int n5 = 1; n5 < sArray.length; n5 = (int)((short)(n5 + 1))) {
            if (sArray[n5 - 1] == sArray[n5]) continue;
            short s4 = s;
            s = (short)(s + 1);
            sArray[s4] = sArray[n5];
        }
        return s == sArray.length ? sArray : edu.emory.mathcs.backport.java.util.Arrays.copyOf(sArray, (int)s);
    }

    @Override
    public boolean canResponseToEvent() {
        if (this.receiverId != -1L) {
            return this.receiverId != 0L && ServiceManagerStatemachine.eventReceiverTable.canResponseToCurrentEvent(this.receiverId);
        }
        return Arrays.binarySearch(this.triggers, CurrentHMIEvent.compactId) >= 0;
    }

    @Override
    public final short getCurrentState() {
        return this.sG2Id(this.gCurrentState);
    }

    @Override
    public final short getParentOf(short s) {
        if (s == -1) {
            return -1;
        }
        short s2 = this.sId2G(s);
        short s3 = this.S_PARENT[s2];
        return s3 == -1 ? (short)-1 : this.sG2Id(s3);
    }

    @Override
    public final short getInitialStateOf(short s) {
        short s2 = this.sId2G(s);
        short s3 = (short)this.S_PARENT.length;
        for (short s4 = (short)(s2 + 1); s4 < s3; s4 = (short)(s4 + 1)) {
            if (!this.isInitialGStateOf(s2, s4)) continue;
            return this.sG2Id(s4);
        }
        return -1;
    }

    private boolean isInitialGStateOf(short s, short s2) {
        if (this.S_PARENT[s2] != s) {
            return false;
        }
        return 8 == this.S_KIND[s2];
    }

    @Override
    public final void enterState(short s) {
        short s2 = this.sId2G(s);
        this.goDownTo(s2, false);
        if (!$assertionsDisabled && this.gCurrentState != s2) {
            throw new AssertionError((Object)"Post-Condition");
        }
    }

    @Override
    public final void leaveCurrentStateTo(short s) {
        short s2 = this.sId2G(s);
        this.goUpTo(s2);
    }

    @Override
    public final byte getKindOf(short s) {
        short s2 = this.sId2G(s);
        return this.S_KIND[s2];
    }

    @Override
    public final short getKindSpecificExtensionDataOf(short s) {
        short s2 = this.sId2G(s);
        return this.S_EXTENSION[s2];
    }

    @Override
    public void performFocusGainedAction() {
        ServiceManagerStatemachine.journalEx.stateFocusGainedActing(this.TOPID, this.SUBID, this.sG2Id(this.gCurrentState));
        short s = this.gCurrentState;
        while (s != -1) {
            this.ACTIVITY.performStateFocusGainedAction(s);
            s = this.S_PARENT[s];
        }
        ServiceManagerStatemachine.journalEx.stateFocusGainedActed(this.TOPID, this.SUBID, this.sG2Id(this.gCurrentState));
    }

    @Override
    public void performFocusLostAction() {
        ServiceManagerStatemachine.journalEx.stateFocusLostActing(this.TOPID, this.SUBID, this.sG2Id(this.gCurrentState));
        short s = this.gCurrentState;
        while (s != -1) {
            this.ACTIVITY.performStateFocusLostAction(s);
            s = this.S_PARENT[s];
        }
        ServiceManagerStatemachine.journalEx.stateFocusLostActed(this.TOPID, this.SUBID, this.sG2Id(this.gCurrentState));
    }

    @Override
    public boolean findApplicableInternalTransition(FoundLocation foundLocation) {
        boolean bl;
        short s;
        short s2;
        SubStatemachineDataImpl.checkpoint('a');
        short s3 = CurrentHMIEvent.compactId;
        int n = this.getCheckedIndex(s3);
        int n2 = this.cacheInternals[n];
        if (n2 == CACHE_NOT_FILLED) {
            SubStatemachineDataImpl.checkpoint('b');
            this.cacheInternals[n] = n2 = this.findFirstInternalTransition(s3);
        }
        if (n2 == CACHE_NO_VALUE) {
            SubStatemachineDataImpl.checkpoint('e');
            return false;
        }
        short s4 = (short)((n2 >> 16) + this.S_OFFSET);
        short s5 = (short)((n2 & 0xFFFF0000) + this.IT_OFFSET);
        short s6 = this.S_ITEND[s4];
        SubStatemachineDataImpl.checkpoint('c');
        for (s2 = s5; s2 < s6; s2 = (short)(s2 + 1)) {
            s = this.IT_TRIGGER[s2];
            if (s != s3 || !(bl = this.ACTIVITY.evalInternalTransitionGuard(s2))) continue;
            foundLocation.set(this, this.sG2Id(s4), this.itG2Id(s2));
            SubStatemachineDataImpl.checkpoint('d');
            return true;
        }
        s4 = this.S_PARENT[s4];
        while (s4 != -1) {
            s5 = this.S_ITSTART[s4];
            s6 = this.S_ITEND[s4];
            SubStatemachineDataImpl.checkpoint('c');
            for (s2 = s5; s2 < s6; s2 = (short)(s2 + 1)) {
                s = this.IT_TRIGGER[s2];
                if (s != s3 || !(bl = this.ACTIVITY.evalInternalTransitionGuard(s2))) continue;
                foundLocation.set(this, this.sG2Id(s4), this.itG2Id(s2));
                SubStatemachineDataImpl.checkpoint('d');
                return true;
            }
            s4 = this.S_PARENT[s4];
        }
        SubStatemachineDataImpl.checkpoint('e');
        return false;
    }

    private int findFirstInternalTransition(short s) {
        short s2 = this.gCurrentState;
        while (s2 != -1) {
            short s3 = this.S_ITSTART[s2];
            short s4 = this.S_ITEND[s2];
            for (short s5 = s3; s5 < s4; s5 = (short)(s5 + 1)) {
                short s6 = this.IT_TRIGGER[s5];
                if (s6 != s) continue;
                return s2 - this.S_OFFSET << 16 | s5 - this.IT_OFFSET;
            }
            s2 = this.S_PARENT[s2];
        }
        return CACHE_NO_VALUE;
    }

    @Override
    public boolean findApplicableTriggeredTransition(FoundLocation foundLocation) {
        boolean bl;
        short s;
        short s2;
        SubStatemachineDataImpl.checkpoint('m');
        short s3 = CurrentHMIEvent.compactId;
        int n = this.getCheckedIndex(s3);
        int n2 = this.cacheTriggereds[n];
        if (n2 == CACHE_NOT_FILLED) {
            SubStatemachineDataImpl.checkpoint('n');
            this.cacheTriggereds[n] = n2 = this.findFirstTriggeredTransition(s3);
        }
        if (n2 == CACHE_NO_VALUE) {
            SubStatemachineDataImpl.checkpoint('q');
            return false;
        }
        short s4 = (short)((n2 >> 16) + this.S_OFFSET);
        short s5 = (short)((n2 & 0xFFFF0000) + this.TT_OFFSET);
        short s6 = this.S_TTEND[s4];
        SubStatemachineDataImpl.checkpoint('o');
        for (s2 = s5; s2 < s6; s2 = (short)(s2 + 1)) {
            s = this.TT_TRIGGER[s2];
            if (s != s3 || !(bl = this.ACTIVITY.evalTriggeredTransitionGuard(s2))) continue;
            foundLocation.set(this, this.sG2Id(s4), this.ttG2Id(s2));
            SubStatemachineDataImpl.checkpoint('p');
            return true;
        }
        s4 = this.S_PARENT[s4];
        while (s4 != -1) {
            s5 = this.S_TTSTART[s4];
            s6 = this.S_TTEND[s4];
            SubStatemachineDataImpl.checkpoint('o');
            for (s2 = s5; s2 < s6; s2 = (short)(s2 + 1)) {
                s = this.TT_TRIGGER[s2];
                if (s != s3 || !(bl = this.ACTIVITY.evalTriggeredTransitionGuard(s2))) continue;
                foundLocation.set(this, this.sG2Id(s4), this.ttG2Id(s2));
                SubStatemachineDataImpl.checkpoint('p');
                return true;
            }
            s4 = this.S_PARENT[s4];
        }
        SubStatemachineDataImpl.checkpoint('q');
        return false;
    }

    private int findFirstTriggeredTransition(short s) {
        short s2 = this.gCurrentState;
        while (s2 != -1) {
            short s3 = this.S_TTSTART[s2];
            short s4 = this.S_TTEND[s2];
            for (short s5 = s3; s5 < s4; s5 = (short)(s5 + 1)) {
                short s6 = this.TT_TRIGGER[s5];
                if (s != s6) continue;
                return s2 - this.S_OFFSET << 16 | s5 - this.TT_OFFSET;
            }
            s2 = this.S_PARENT[s2];
        }
        return CACHE_NO_VALUE;
    }

    @Override
    public final boolean findApplicableUntriggeredTransition(FoundLocation foundLocation) {
        short s = this.S_UTSTART[this.gCurrentState];
        short s2 = this.S_UTEND[this.gCurrentState];
        for (short s3 = s; s3 < s2; s3 = (short)(s3 + 1)) {
            boolean bl = this.ACTIVITY.evalUntriggeredTransitionGuard(s3);
            if (!bl) continue;
            foundLocation.set(this, this.sG2Id(this.gCurrentState), this.utG2Id(s3));
            return true;
        }
        return false;
    }

    @Override
    public final boolean performInternalTransition(short s, short s2) {
        short s3 = this.itId2G(s);
        short s4 = this.IT_FLAGS[s3];
        ServiceManagerStatemachine.journalEx.internalTransitionActing(this.TOPID, this.SUBID, s2, s);
        this.ACTIVITY.performInternalTransitionAction(s3);
        ServiceManagerStatemachine.journalEx.internalTransitionActed(this.TOPID, this.SUBID, s2, s);
        return (s4 & 1) != 0;
    }

    @Override
    public final boolean performTriggeredTransition(short s) {
        short s2 = this.ttId2G(s);
        short s3 = this.TT_FLAGS[s2];
        short s4 = this.gCurrentState;
        short s5 = this.TT_TARGET[s2];
        short s6 = this.calculateJoinStateOfUpAndDownPath(s4, s5);
        this.goUpTo(s6);
        ServiceManagerStatemachine.journalEx.triggeredTransitionActing(this.TOPID, this.SUBID, this.sG2Id(s4), this.ttG2Id(s2));
        this.ACTIVITY.performTriggeredTransitionAction(s2);
        ServiceManagerStatemachine.journalEx.triggeredTransitionActed(this.TOPID, this.SUBID, this.sG2Id(s4), this.ttG2Id(s2));
        this.goDownTo(s5, (s3 & 2) != 0);
        return (s3 & 1) != 0;
    }

    @Override
    public final void performUntriggeredTransition(short s) {
        short s2 = this.utId2G(s);
        short s3 = this.UT_FLAGS[s2];
        short s4 = this.gCurrentState;
        short s5 = this.UT_TARGET[s2];
        short s6 = this.calculateJoinStateOfUpAndDownPath(s4, s5);
        this.goUpTo(s6);
        ServiceManagerStatemachine.journalEx.untriggeredTransitionActing(this.TOPID, this.SUBID, this.sG2Id(s4), this.utG2Id(s2));
        this.ACTIVITY.performUntriggeredTransitionAction(s2);
        ServiceManagerStatemachine.journalEx.untriggeredTransitionActed(this.TOPID, this.SUBID, this.sG2Id(s4), this.utG2Id(s2));
        this.goDownTo(s5, (s3 & 2) != 0);
    }

    @Override
    public void performVirtualTransition(short s) {
        short s2 = this.gCurrentState;
        short s3 = this.sId2G(s);
        short s4 = this.calculateJoinStateOfUpAndDownPath(s2, s3);
        this.goUpTo(s4);
        this.goDownTo(s3, false);
    }

    private void goUpTo(int n) {
        while (this.gCurrentState != n) {
            this.goOneStepUp();
        }
    }

    private void goOneStepUp() {
        if (!$assertionsDisabled && this.gCurrentState == -1) {
            throw new AssertionError();
        }
        short s = this.S_PARENT[this.gCurrentState];
        ServiceManagerStatemachine.journalEx.stateExitActing(this.TOPID, this.SUBID, this.sG2Id(this.gCurrentState));
        this.ACTIVITY.performStateExitAction(this.gCurrentState);
        ServiceManagerStatemachine.journalEx.stateExitActed(this.TOPID, this.SUBID, this.sG2Id(this.gCurrentState));
        this.gCurrentState = s;
    }

    private void goDownTo(short s, boolean bl) {
        this.goDownToRescursivly(s, bl);
    }

    private void goDownToRescursivly(short s, boolean bl) {
        short s2 = this.S_PARENT[s];
        if (s2 != this.gCurrentState) {
            this.goDownToRescursivly(s2, bl);
        }
        this.goOneStepDown(s, bl);
    }

    private void goOneStepDown(short s, boolean bl) {
        if (!$assertionsDisabled && this.S_PARENT[s] != this.gCurrentState) {
            throw new AssertionError();
        }
        ServiceManagerStatemachine.journalEx.stateEntryActing(this.TOPID, this.SUBID, this.sG2Id(s), bl);
        this.ACTIVITY.performStateEntryAction(s, bl);
        ServiceManagerStatemachine.journalEx.stateEntryActed(this.TOPID, this.SUBID, this.sG2Id(s));
        this.gCurrentState = s;
    }

    private short calculateJoinStateOfUpAndDownPath(short s, short s2) {
        if (s == s2) {
            return this.calculateJoinStateOfEqualSourceAndTarget(s);
        }
        return this.calculateJoinStateOfDifferentSourceAndTarget(s, s2);
    }

    private short calculateJoinStateOfEqualSourceAndTarget(short s) {
        return this.S_PARENT[s];
    }

    private short calculateJoinStateOfDifferentSourceAndTarget(short s, short s2) {
        short s3;
        short s4 = s;
        short s5 = s2;
        short s6 = this.depthOf(s5);
        for (s3 = this.depthOf(s4); s3 > s6; s3 = (short)(s3 - 1)) {
            s4 = this.S_PARENT[s4];
        }
        while (s6 > s3) {
            s5 = this.S_PARENT[s5];
            s6 = (short)(s6 - 1);
        }
        while (s4 != s5) {
            s4 = this.S_PARENT[s4];
            s5 = this.S_PARENT[s5];
        }
        if (!$assertionsDisabled && s4 != s5) {
            throw new AssertionError();
        }
        return s4;
    }

    private short depthOf(short s) {
        short s2 = 0;
        short s3 = s;
        while (s3 != -1) {
            s2 = (short)(s2 + 1);
            s3 = this.S_PARENT[s3];
        }
        return s2;
    }

    private short[] createHistoryStore(short s) {
        return s > 0 ? new short[s] : EMPTY_STORE;
    }

    private short[] initHistoryStore(short s) {
        short[] sArray = this.createHistoryStore(s);
        Arrays.fill(sArray, (short)-1);
        return sArray;
    }

    @Override
    public boolean isHistoryStoreFilled(short s) {
        return -1 != this.historyStoreStates[s];
    }

    @Override
    public void setHistoryStore(short s, short s2, short s3) {
        this.historyStoreSsmPaths[s] = s2;
        this.historyStoreStates[s] = s3;
    }

    @Override
    public void storeHistory(short s, short s2) {
        if (s2 == -1) {
            return;
        }
        short s3 = this.S_PARENT[this.gCurrentState];
        while (s3 != -1) {
            if (6 == this.S_KIND[s3]) {
                short s4 = this.S_EXTENSION[s3];
                this.setHistoryStore(s4, s, s2);
            }
            s3 = this.S_PARENT[s3];
        }
    }

    @Override
    public short getHistoryStoreSsmPath(short s) {
        return this.historyStoreSsmPaths[s];
    }

    @Override
    public short getHistoryStoreState(short s) {
        return this.historyStoreStates[s];
    }

    private int getCheckedIndex(short s) {
        int n = (s ^ this.gCurrentState & Short.MAX_VALUE) % this.CACHE_CAPACITY;
        int n2 = s << 16 | this.gCurrentState;
        if (this.cacheChecks[n] != n2) {
            this.cacheChecks[n] = n2;
            this.cacheInternals[n] = CACHE_NOT_FILLED;
            this.cacheTriggereds[n] = CACHE_NOT_FILLED;
            SubStatemachineDataImpl.checkpoint('$');
        } else {
            SubStatemachineDataImpl.checkpoint('#');
        }
        return n;
    }

    private void initCache() {
        this.cacheChecks = new int[this.CACHE_CAPACITY];
        this.cacheInternals = new int[this.CACHE_CAPACITY];
        this.cacheTriggereds = new int[this.CACHE_CAPACITY];
        Arrays.fill(this.cacheChecks, CACHE_NULLCHECK);
    }

    private short max(short s, short s2) {
        return s > s2 ? s : s2;
    }

    protected short sG2Id(short s) {
        return (short)(s != -1 ? s - this.S_OFFSET : -1);
    }

    private short utG2Id(short s) {
        return (short)(s - this.UT_OFFSET);
    }

    private short ttG2Id(short s) {
        return (short)(s - this.TT_OFFSET);
    }

    private short itG2Id(short s) {
        return (short)(s - this.IT_OFFSET);
    }

    protected short sId2G(short s) {
        return (short)(s != -1 ? s + this.S_OFFSET : -1);
    }

    private short utId2G(short s) {
        return (short)(s + this.UT_OFFSET);
    }

    private short ttId2G(short s) {
        return (short)(s + this.TT_OFFSET);
    }

    private short itId2G(short s) {
        return (short)(s + this.IT_OFFSET);
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
        $assertionsDisabled = !(class$de$vw$mib$sm$internal$statemachine$SubStatemachineDataImpl == null ? (class$de$vw$mib$sm$internal$statemachine$SubStatemachineDataImpl = SubStatemachineDataImpl.class$("de.vw.mib.sm.internal.statemachine.SubStatemachineDataImpl")) : class$de$vw$mib$sm$internal$statemachine$SubStatemachineDataImpl).desiredAssertionStatus();
        NO_TRIGGERS = new short[0];
        CHECKPOINT_FT = Boolean.getBoolean("smjournal.checkpoint") || Boolean.getBoolean("smjournal.checkpoint.ft");
        EMPTY_STORE = new short[0];
        CACHE_NULLCHECK = -1;
        CACHE_NOT_FILLED = -2;
        CACHE_NO_VALUE = -1;
    }
}

