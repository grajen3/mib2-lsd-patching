/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

public interface StatemachineActivity {
    public static final boolean NO_GUARD_LOGICAL_VALUE;

    default public void performStateEntryAction(int n, boolean bl) {
    }

    default public void performStateExitAction(int n) {
    }

    default public void performStateFocusGainedAction(int n) {
    }

    default public void performStateFocusLostAction(int n) {
    }

    default public boolean evalInternalTransitionGuard(int n) {
    }

    default public void performInternalTransitionAction(int n) {
    }

    default public boolean evalTriggeredTransitionGuard(int n) {
    }

    default public void performTriggeredTransitionAction(int n) {
    }

    default public boolean evalUntriggeredTransitionGuard(int n) {
    }

    default public void performUntriggeredTransitionAction(int n) {
    }
}

