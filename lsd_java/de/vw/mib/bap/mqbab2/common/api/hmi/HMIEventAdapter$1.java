/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.hmi;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventAdapter;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import java.util.List;

class HMIEventAdapter$1
implements Runnable {
    private final /* synthetic */ List val$listenersForEvent;
    private final /* synthetic */ int val$eventID;
    private final /* synthetic */ HMIEventAdapter this$0;

    HMIEventAdapter$1(HMIEventAdapter hMIEventAdapter, List list, int n) {
        this.this$0 = hMIEventAdapter;
        this.val$listenersForEvent = list;
        this.val$eventID = n;
    }

    @Override
    public void run() {
        for (int i2 = 0; i2 < this.val$listenersForEvent.size(); ++i2) {
            HMIEventListener hMIEventListener = (HMIEventListener)this.val$listenersForEvent.get(i2);
            hMIEventListener.processHMIEvent(this.val$eventID);
        }
    }
}

