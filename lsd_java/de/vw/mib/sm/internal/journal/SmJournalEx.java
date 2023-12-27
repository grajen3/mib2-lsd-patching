/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

public abstract class SmJournalEx {
    public static final short EVENT_CAME_FROM_STATEMACHINE_EVENT_DISPATCHER;
    public static final short EVENT_CAME_FROM_POPUP_MANAGER;
    public static final short EVENT_IS_A_SPECIAL_EVENT;

    public abstract void managerStarted() {
    }

    public abstract void managerFinished() {
    }

    public abstract void eventProcessing(int n, short s) {
    }

    public abstract void eventProcessed(int n, boolean bl) {
    }

    public abstract void eventSkipped(int n) {
    }

    public abstract void eventForwardingToStatemachine(int n, int n2) {
    }

    public abstract void checkpoint(char c2) {
    }

    public abstract void fatalError(int n, int n2, short s, RuntimeException runtimeException) {
    }

    public abstract void activatorChecking(int n) {
    }

    public abstract void activatorChecked(int n) {
    }

    public abstract void deactivatorChecking(int n) {
    }

    public abstract void deactivatorChecked(int n) {
    }

    public abstract void statemachineActivating(int n) {
    }

    public abstract void statemachineActivated(int n) {
    }

    public abstract void statemachineDeactivating(int n) {
    }

    public abstract void statemachineDeactivated(int n) {
    }

    public abstract void subStatemachineActivating(int n, int n2) {
    }

    public abstract void subStatemachineActivated(int n, int n2) {
    }

    public abstract void subStatemachineDeactivating(int n, int n2) {
    }

    public abstract void subStatemachineDeactivated(int n, int n2) {
    }

    public abstract void internalTransitionPerforming(int n, int n2, short s, short s2) {
    }

    public abstract void internalTransitionActing(int n, int n2, short s, short s2) {
    }

    public abstract void internalTransitionActed(int n, int n2, short s, short s2) {
    }

    public abstract void internalTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
    }

    public abstract void triggeredTransitionPerforming(int n, int n2, short s, short s2) {
    }

    public abstract void triggeredTransitionActing(int n, int n2, short s, short s2) {
    }

    public abstract void triggeredTransitionActed(int n, int n2, short s, short s2) {
    }

    public abstract void triggeredTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
    }

    public abstract void untriggeredTransitionPerforming(int n, int n2, short s, short s2) {
    }

    public abstract void untriggeredTransitionActing(int n, int n2, short s, short s2) {
    }

    public abstract void untriggeredTransitionActed(int n, int n2, short s, short s2) {
    }

    public abstract void untriggeredTransitionPerformed(int n, int n2, short s, short s2) {
    }

    public abstract void stateEntryActing(int n, int n2, short s, boolean bl) {
    }

    public abstract void stateEntryActed(int n, int n2, short s) {
    }

    public abstract void stateExitActing(int n, int n2, short s) {
    }

    public abstract void stateExitActed(int n, int n2, short s) {
    }

    public abstract void stateFocusGainedActing(int n, int n2, short s) {
    }

    public abstract void stateFocusGainedActed(int n, int n2, short s) {
    }

    public abstract void stateFocusLostActing(int n, int n2, short s) {
    }

    public abstract void stateFocusLostActed(int n, int n2, short s) {
    }
}

