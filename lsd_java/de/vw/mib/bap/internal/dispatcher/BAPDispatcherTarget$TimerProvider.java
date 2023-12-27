/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.internal.dispatcher;

import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.internal.dispatcher.BAPDispatcherTarget;
import de.vw.mib.genericevents.EventGeneric;

final class BAPDispatcherTarget$TimerProvider
implements Timer,
TimerNotifier {
    private static final int LSG_ID_BIT_SIZE;
    private static final int FCT_ID_BIT_SIZE;
    private static final int ID_BIT_MAKS;
    private final EventGeneric timerEvent;
    private long timeInterval;
    private TimerNotifier notifier;
    private boolean isRunning;
    private int userInfo;
    private final /* synthetic */ BAPDispatcherTarget this$0;

    BAPDispatcherTarget$TimerProvider(BAPDispatcherTarget bAPDispatcherTarget, int n, int n2, int n3, long l, TimerNotifier timerNotifier) {
        this.this$0 = bAPDispatcherTarget;
        this.timeInterval = l;
        this.notifier = timerNotifier;
        this.isRunning = false;
        this.timerEvent = bAPDispatcherTarget.genericEventFactory.newEvent(bAPDispatcherTarget.getTargetId(), bAPDispatcherTarget.getTargetId(), -1920335616, this.computeUniqueEventID(n, n2, n3));
        this.timerEvent.setInt(0, n);
        this.timerEvent.setInt(1, n2);
        this.timerEvent.setObject(2, this);
        this.userInfo = 0;
    }

    private int computeUniqueEventID(int n, int n2, int n3) {
        return (n << 8 | n2 & 0xFF) << 8 | n3 & 0xFF;
    }

    @Override
    public void retrigger(int n) {
        this.userInfo = n;
        this.this$0.retriggerOrStartTimer(this.this$0.genericEventFactory.newEvent(this.timerEvent), this.timeInterval, false);
        this.isRunning = true;
    }

    @Override
    public void stop() {
        if (this.isRunning) {
            this.isRunning = false;
            this.this$0.stopTimer(this.timerEvent.getReceiverEventId());
        }
    }

    @Override
    public boolean isRunning() {
        return this.isRunning;
    }

    @Override
    public void setUserInfo(int n) {
        this.userInfo = n;
    }

    @Override
    public void timerFired(int n) {
        if (this.isRunning) {
            this.isRunning = false;
            this.notifier.timerFired(this.userInfo);
        }
    }
}

