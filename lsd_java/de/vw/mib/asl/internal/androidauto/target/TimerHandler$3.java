/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.target.TimerHandler;
import de.vw.mib.genericevents.EventGeneric;

class TimerHandler$3
implements Runnable {
    private final /* synthetic */ TimerHandler this$0;

    TimerHandler$3(TimerHandler timerHandler) {
        this.this$0 = timerHandler;
    }

    @Override
    public void run() {
        if (this.this$0.target.isTraceEnabled()) {
            this.this$0.target.trace("<< AA_MICROPHONE_ANSWERING_DELAY_TIMER expired... >>");
        }
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1450835712);
        this.this$0.target.sendSafe(eventGeneric);
    }
}

