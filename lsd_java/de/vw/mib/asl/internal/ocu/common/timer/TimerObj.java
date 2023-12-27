/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.common.timer;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.timer.TimerManager;

public class TimerObj
implements Timer,
Runnable {
    private de.vw.mib.timer.Timer _mibTimer;
    private TimerNotifier _notifier;
    private long _delay;
    private boolean _running;
    private Object _userInfo;

    public TimerObj(TimerNotifier timerNotifier, long l) {
        this._notifier = timerNotifier;
        this._delay = l;
    }

    @Override
    public void retrigger(Object object) {
        this.setUserInfo(object);
        if (this.isRunning()) {
            this.getMibTimer().stop();
        }
        this.getMibTimer().start();
        this.setRunning(true);
    }

    @Override
    public void stop() {
        if (this.isRunning()) {
            this.setRunning(false);
            this.getMibTimer().stop();
        }
    }

    @Override
    public boolean isRunning() {
        return this._running;
    }

    private void setRunning(boolean bl) {
        this._running = bl;
    }

    @Override
    public void setUserInfo(Object object) {
        this._userInfo = object;
    }

    @Override
    public Object getUserInfo() {
        return this._userInfo;
    }

    @Override
    public void run() {
        if (this.isRunning()) {
            this.setRunning(false);
            this.getNotifier().timerFired(this);
        }
    }

    private de.vw.mib.timer.Timer getMibTimer() {
        if (this._mibTimer == null) {
            this._mibTimer = this.getTimeManager().createTimer(super.getClass().getName(), this.getDelay(), false, this, this.getThreadSwitchingTarget());
        }
        return this._mibTimer;
    }

    private ThreadSwitchingTarget getThreadSwitchingTarget() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLThreadSwitch();
    }

    private TimerManager getTimeManager() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getServices().getTimerManager();
    }

    private long getDelay() {
        return this._delay;
    }

    private TimerNotifier getNotifier() {
        return this._notifier;
    }
}

