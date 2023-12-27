/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.journal;

import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.journal.SmJournalEx;

final class SmJournals$1
implements Runnable {
    private final /* synthetic */ SmJournalEx val$journal;

    SmJournals$1(SmJournalEx smJournalEx) {
        this.val$journal = smJournalEx;
    }

    @Override
    public void run() {
        ServiceManagerStatemachine.journalEx = this.val$journal;
    }
}

