/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.asg.complete;

import de.vw.mib.bap.array.asg.complete.ASGArrayListComplete;
import de.vw.mib.bap.array.asg.complete.ASGArrayPendingRequests$PendigRequestEnumerator;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.datatypes.ArrayHeader;

class ASGArrayListComplete$3
implements ASGArrayPendingRequests$PendigRequestEnumerator {
    private final /* synthetic */ ArrayHeader val$bapSetGetArrayHeader;
    private final /* synthetic */ ASGArrayListComplete this$0;

    ASGArrayListComplete$3(ASGArrayListComplete aSGArrayListComplete, ArrayHeader arrayHeader) {
        this.this$0 = aSGArrayListComplete;
        this.val$bapSetGetArrayHeader = arrayHeader;
    }

    @Override
    public boolean enumerate(BAPGetArray bAPGetArray, int n, Timer timer) {
        if (timer != null && bAPGetArray.getArrayHeader().equalTo(this.val$bapSetGetArrayHeader) && ASGArrayListComplete._isSetGetRequest(bAPGetArray)) {
            timer.stop();
        }
        return false;
    }
}

