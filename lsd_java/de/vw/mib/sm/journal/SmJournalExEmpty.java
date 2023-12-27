/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.journal;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.sm.internal.journal.SmJournalEx;

public class SmJournalExEmpty
extends SmJournalEx {
    @Override
    public void managerStarted() {
    }

    @Override
    public void managerFinished() {
    }

    public void consumingEvent(HMIEvent hMIEvent) {
    }

    public void eventProcessing(int n) {
    }

    @Override
    public void eventProcessing(int n, short s) {
    }

    public void eventProcessed(boolean bl) {
    }

    @Override
    public void eventProcessed(int n, boolean bl) {
    }

    public void eventSkipped() {
    }

    @Override
    public void eventSkipped(int n) {
    }

    public void eventForwardingToSelectedStatemachine(int n) {
    }

    @Override
    public void eventForwardingToStatemachine(int n, int n2) {
    }

    @Override
    public void checkpoint(char c2) {
    }

    public void fatalError(int n, int n2, int n3, RuntimeException runtimeException) {
    }

    @Override
    public void fatalError(int n, int n2, short s, RuntimeException runtimeException) {
    }

    @Override
    public void activatorChecking(int n) {
    }

    public void activatorChecked() {
    }

    @Override
    public void activatorChecked(int n) {
    }

    @Override
    public void deactivatorChecking(int n) {
    }

    public void deactivatorChecked() {
    }

    @Override
    public void deactivatorChecked(int n) {
    }

    public void selectStatemachine(int n) {
    }

    public void statemachineActivating() {
    }

    public void statemachineActivated() {
    }

    public void statemachineDeactivating() {
    }

    public void statemachineDeactivated() {
    }

    @Override
    public void statemachineActivating(int n) {
    }

    @Override
    public void statemachineActivated(int n) {
    }

    @Override
    public void statemachineDeactivating(int n) {
    }

    @Override
    public void statemachineDeactivated(int n) {
    }

    public void internalTransitionPerforming(int n, int n2, int n3) {
    }

    @Override
    public void internalTransitionPerforming(int n, int n2, short s, short s2) {
    }

    public void internalTransitionActing() {
    }

    @Override
    public void internalTransitionActing(int n, int n2, short s, short s2) {
    }

    public void internalTransitionActed() {
    }

    @Override
    public void internalTransitionActed(int n, int n2, short s, short s2) {
    }

    public void internalTransitionPerformed(boolean bl) {
    }

    @Override
    public void internalTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
    }

    public void triggeredTransitionPerforming(int n, int n2, int n3) {
    }

    @Override
    public void triggeredTransitionPerforming(int n, int n2, short s, short s2) {
    }

    public void triggeredTransitionActing() {
    }

    @Override
    public void triggeredTransitionActing(int n, int n2, short s, short s2) {
    }

    public void triggeredTransitionActed() {
    }

    @Override
    public void triggeredTransitionActed(int n, int n2, short s, short s2) {
    }

    public void triggeredTransitionPerformed(boolean bl) {
    }

    @Override
    public void triggeredTransitionPerformed(int n, int n2, short s, short s2, boolean bl) {
    }

    public void untriggeredTransitionPerforming(int n, int n2, int n3) {
    }

    public void untriggeredTransitionActing() {
    }

    public void untriggeredTransitionActed() {
    }

    public void untriggeredTransitionPerformed() {
    }

    @Override
    public void untriggeredTransitionPerforming(int n, int n2, short s, short s2) {
    }

    @Override
    public void untriggeredTransitionActing(int n, int n2, short s, short s2) {
    }

    @Override
    public void untriggeredTransitionActed(int n, int n2, short s, short s2) {
    }

    @Override
    public void untriggeredTransitionPerformed(int n, int n2, short s, short s2) {
    }

    public void subStatemachineActivating(int n) {
    }

    public void subStatemachineActivated() {
    }

    public void subStatemachineDeactivating(int n) {
    }

    public void subStatemachineDeactivated() {
    }

    @Override
    public void subStatemachineActivating(int n, int n2) {
    }

    @Override
    public void subStatemachineActivated(int n, int n2) {
    }

    @Override
    public void subStatemachineDeactivating(int n, int n2) {
    }

    @Override
    public void subStatemachineDeactivated(int n, int n2) {
    }

    public void stateEntryActing(int n, int n2, boolean bl) {
    }

    public void stateEntryActed() {
    }

    public void stateExitActing(int n, int n2) {
    }

    public void stateExitActed() {
    }

    public void stateFocusGainedActing(int n, int n2) {
    }

    public void stateFocusGainedActed() {
    }

    public void stateFocusLostActing(int n, int n2) {
    }

    public void stateFocusLostActed() {
    }

    @Override
    public void stateEntryActing(int n, int n2, short s, boolean bl) {
    }

    @Override
    public void stateEntryActed(int n, int n2, short s) {
    }

    @Override
    public void stateExitActing(int n, int n2, short s) {
    }

    @Override
    public void stateExitActed(int n, int n2, short s) {
    }

    @Override
    public void stateFocusGainedActing(int n, int n2, short s) {
    }

    @Override
    public void stateFocusGainedActed(int n, int n2, short s) {
    }

    @Override
    public void stateFocusLostActing(int n, int n2, short s) {
    }

    @Override
    public void stateFocusLostActed(int n, int n2, short s) {
    }
}

