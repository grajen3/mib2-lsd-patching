/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

import de.vw.mib.bap.array.asg.ASGArrayList;
import de.vw.mib.bap.array.asg.ASGArrayListChangeNotifier;
import de.vw.mib.bap.array.asg.ASGArrayListDelegate;
import de.vw.mib.bap.array.asg.ASGArrayListFactory;
import de.vw.mib.bap.array.asg.complete.ASGArrayListComplete;

public class ArrayListFactory {
    private static final int HIGH_LEVEL_RETRY_A_NUMBER_OF_RETRIES;
    private static final int HIGH_LEVEL_RETRY_A_RETRY_TIME;

    public ASGArrayList createCompleteArrayList(ASGArrayListDelegate aSGArrayListDelegate, ASGArrayListChangeNotifier aSGArrayListChangeNotifier, ASGArrayListFactory aSGArrayListFactory, int n, int n2) {
        return this.createCompleteArrayList(aSGArrayListDelegate, aSGArrayListChangeNotifier, aSGArrayListFactory, n, n2, false, 2, 0);
    }

    public ASGArrayList createCompleteArrayList(ASGArrayListDelegate aSGArrayListDelegate, ASGArrayListChangeNotifier aSGArrayListChangeNotifier, ASGArrayListFactory aSGArrayListFactory, int n, int n2, boolean bl, int n3, long l) {
        ASGArrayListComplete aSGArrayListComplete = new ASGArrayListComplete(n, n2);
        if (bl) {
            aSGArrayListComplete.setHighLevelRetryType(1);
            aSGArrayListComplete.setHighLevelRetryNumberOfRetries(n3);
            aSGArrayListComplete.setHighLevelRetryTime(l);
        } else {
            aSGArrayListComplete.setHighLevelRetryType(0);
            aSGArrayListComplete.setHighLevelRetryNumberOfRetries(n3);
            aSGArrayListComplete.setHighLevelRetryTime(l);
        }
        aSGArrayListComplete.setDelegate(aSGArrayListDelegate);
        aSGArrayListComplete.setChangeNotifier(aSGArrayListChangeNotifier);
        aSGArrayListComplete.setFactory(aSGArrayListFactory);
        return aSGArrayListComplete;
    }
}

