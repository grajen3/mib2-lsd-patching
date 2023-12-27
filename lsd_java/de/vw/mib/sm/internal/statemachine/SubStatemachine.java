/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.statemachine;

import de.vw.mib.sm.internal.statemachine.FoundLocation;

public interface SubStatemachine {
    public static final short NOT_A_STATE;
    public static final int NO_EXTENSION_DATA;
    public static final byte STATE_IS_;
    public static final byte STATE_IS_OPENINCLUDE;
    public static final byte STATE_IS_CLOSEINCLUDE;
    public static final byte STATE_IS_CLOSESTATEMACHINE;
    public static final byte STATE_IS_DEEPHISTORY;
    public static final byte STATE_IS_SHALLOWHISTORY;
    public static final byte STATE_IS_HISTORY_CONTAINER;
    public static final byte STATE_IS_CONTAINER;
    public static final byte STATE_IS_INITIAL;
    public static final byte STATE_IS_STABLE;
    public static final byte STATE_IS_WAIT;
    public static final byte STATE_IS_UNSTABLE;

    default public int getSubId() {
    }

    default public short getEntryState() {
    }

    default public void activate() {
    }

    default public void deactivate() {
    }

    default public long registerReceiver() {
    }

    default public long deregisterReceiver() {
    }

    default public boolean canResponseToEvent() {
    }

    default public short getCurrentState() {
    }

    default public short getParentOf(short s) {
    }

    default public short getInitialStateOf(short s) {
    }

    default public void enterState(short s) {
    }

    default public void leaveCurrentStateTo(short s) {
    }

    default public boolean findApplicableInternalTransition(FoundLocation foundLocation) {
    }

    default public boolean findApplicableTriggeredTransition(FoundLocation foundLocation) {
    }

    default public boolean findApplicableUntriggeredTransition(FoundLocation foundLocation) {
    }

    default public byte getKindOf(short s) {
    }

    default public short getKindSpecificExtensionDataOf(short s) {
    }

    default public void performFocusGainedAction() {
    }

    default public void performFocusLostAction() {
    }

    default public boolean performInternalTransition(short s, short s2) {
    }

    default public boolean performTriggeredTransition(short s) {
    }

    default public void performUntriggeredTransition(short s) {
    }

    default public void performVirtualTransition(short s) {
    }

    default public boolean isHistoryStoreFilled(short s) {
    }

    default public void setHistoryStore(short s, short s2, short s3) {
    }

    default public void storeHistory(short s, short s2) {
    }

    default public short getHistoryStoreSsmPath(short s) {
    }

    default public short getHistoryStoreState(short s) {
    }
}

