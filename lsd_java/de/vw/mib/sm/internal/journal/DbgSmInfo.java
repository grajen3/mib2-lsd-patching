/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgEvent;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgState;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgStatemachine;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgSubStatemachine;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgTransition;

public interface DbgSmInfo {
    default public DbgEvent getEvent(int n) {
    }

    default public DbgStatemachine getStatemachine(int n) {
    }

    default public DbgSubStatemachine getSubStatemachine(DbgStatemachine dbgStatemachine, int n) {
    }

    default public DbgState getState(DbgSubStatemachine dbgSubStatemachine, int n) {
    }

    default public DbgTransition getInternalTransition(DbgSubStatemachine dbgSubStatemachine, int n) {
    }

    default public DbgTransition getTriggeredTransition(DbgSubStatemachine dbgSubStatemachine, int n) {
    }

    default public DbgTransition getUntriggeredTransition(DbgSubStatemachine dbgSubStatemachine, int n) {
    }
}

