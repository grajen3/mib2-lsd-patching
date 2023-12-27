/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.journal;

import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.hmi.utils.Preconditions;
import de.vw.mib.sm.internal.ServiceManagerStatemachine;
import de.vw.mib.sm.internal.journal.NullSmJournal;
import de.vw.mib.sm.internal.journal.SmJournalEx;
import de.vw.mib.sm.internal.journal.SmJournalExChains;
import de.vw.mib.sm.journal.SmJournals$1;

public class SmJournals {
    public static SmJournalEx getNullSmJournalEx() {
        return new NullSmJournal();
    }

    public static void registerSmJournalEx(SmJournalEx smJournalEx) {
        Preconditions.checkArgument(smJournalEx != null, "Value null not allowed for registering journal");
        SmJournals.replaceJournal(SmJournalExChains.join(ServiceManagerStatemachine.journalEx, smJournalEx));
    }

    public static void unregisterSmJournalEx(SmJournalEx smJournalEx) {
        SmJournals.replaceJournal(SmJournalExChains.detach(ServiceManagerStatemachine.journalEx, smJournalEx));
    }

    private static void replaceJournal(SmJournalEx smJournalEx) {
        Preconditions.checkArgument(smJournalEx != null, "Value null not allowed for new journal");
        ServiceManagerCommon.hmiThreadInvoker.invoke(new SmJournals$1(smJournalEx));
    }
}

