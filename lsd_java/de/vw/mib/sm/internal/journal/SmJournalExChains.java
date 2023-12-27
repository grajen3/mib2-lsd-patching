/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.sm.internal.journal.SmJournalEx;
import de.vw.mib.sm.internal.journal.SmJournalExChain;

public final class SmJournalExChains {
    private SmJournalExChains() {
    }

    public static SmJournalEx join(SmJournalEx smJournalEx, SmJournalEx smJournalEx2) {
        if (smJournalEx == null) {
            return smJournalEx2;
        }
        if (smJournalEx instanceof SmJournalExChain) {
            SmJournalEx[] smJournalExArray = ((SmJournalExChain)smJournalEx).chainLinks;
            return SmJournalExChains.join(smJournalExArray, smJournalEx2);
        }
        return new SmJournalExChain(new SmJournalEx[]{smJournalEx, smJournalEx2});
    }

    private static SmJournalExChain join(SmJournalEx[] smJournalExArray, SmJournalEx smJournalEx) {
        SmJournalEx[] smJournalExArray2 = new SmJournalEx[smJournalExArray.length + 1];
        System.arraycopy((Object)smJournalExArray, 0, (Object)smJournalExArray2, 0, smJournalExArray.length);
        smJournalExArray2[smJournalExArray.length] = smJournalEx;
        return new SmJournalExChain(smJournalExArray2);
    }

    public static SmJournalEx detach(SmJournalEx smJournalEx, SmJournalEx smJournalEx2) {
        if (smJournalEx instanceof SmJournalExChain) {
            SmJournalExChain smJournalExChain = (SmJournalExChain)smJournalEx;
            int n = SmJournalExChains.getIndexLastOf(smJournalExChain.chainLinks, smJournalEx2);
            return n < 0 ? smJournalExChain : SmJournalExChains.detach(smJournalExChain.chainLinks, n);
        }
        return smJournalEx == smJournalEx2 ? null : smJournalEx;
    }

    private static int getIndexLastOf(SmJournalEx[] smJournalExArray, SmJournalEx smJournalEx) {
        for (int i2 = smJournalExArray.length - 1; i2 >= 0; --i2) {
            if (smJournalExArray[i2] != smJournalEx) continue;
            return i2;
        }
        return -1;
    }

    private static SmJournalEx detach(SmJournalEx[] smJournalExArray, int n) {
        if (smJournalExArray.length == 2) {
            return n == 0 ? smJournalExArray[1] : smJournalExArray[0];
        }
        SmJournalEx[] smJournalExArray2 = new SmJournalEx[smJournalExArray.length - 1];
        System.arraycopy((Object)smJournalExArray, 0, (Object)smJournalExArray2, 0, n);
        System.arraycopy((Object)smJournalExArray, n + 1, (Object)smJournalExArray2, n, smJournalExArray2.length - n);
        return new SmJournalExChain(smJournalExArray2);
    }
}

