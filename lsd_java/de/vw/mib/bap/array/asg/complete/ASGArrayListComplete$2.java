/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

import de.vw.mib.bap.array.asg.complete.ASGArrayListComplete;
import de.vw.mib.bap.array.asg.complete.ASGArrayPendingRequests$PendigRequestEnumerator;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.timer.Timer;

class ASGArrayListComplete$2
implements ASGArrayPendingRequests$PendigRequestEnumerator {
    private final /* synthetic */ ASGArrayListComplete this$0;

    ASGArrayListComplete$2(ASGArrayListComplete aSGArrayListComplete) {
        this.this$0 = aSGArrayListComplete;
    }

    @Override
    public boolean enumerate(BAPGetArray bAPGetArray, int n, Timer timer) {
        return n == 3;
    }
}

