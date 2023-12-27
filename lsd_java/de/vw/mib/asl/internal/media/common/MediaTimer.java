/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.common;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.timer.Timer;

public class MediaTimer
implements Runnable {
    private final String mTimerId;
    private int mTimeout = -1;
    protected final Runnable mRunnable;
    protected Timer mTimer = null;
    boolean mTimerActive = false;
    private static ThreadSwitchingTarget threadSwitchingTarget = null;

    public MediaTimer(Runnable runnable, int n, String string) {
        this.mRunnable = runnable;
        this.mTimeout = n;
        this.mTimerId = string;
        if (threadSwitchingTarget == null) {
            threadSwitchingTarget = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLThreadSwitch();
        }
    }

    public MediaTimer(Runnable runnable, String string) {
        this.mRunnable = runnable;
        this.mTimerId = string;
        if (threadSwitchingTarget == null) {
            threadSwitchingTarget = ASLFrameworkFactory.getASLFrameworkAPI().getServices().getASLThreadSwitch();
        }
    }

    private void startInternal(int n) {
        if (n == -1) {
            this.error("timeout never set for");
            return;
        }
        if (n == 0) {
            return;
        }
        if (this.mTimer == null) {
            this.mTimer = ServiceManager.timerManager.createTimer(this.mTimerId, n, false, this, threadSwitchingTarget);
        } else {
            this.mTimer.setDelay(n);
        }
        this.mTimer.stop();
        this.mTimer.start();
        this.trace(this.mTimerActive ? "restarting" : "starting");
        this.mTimerActive = true;
    }

    public void start(int n) {
        this.mTimeout = n;
        this.startInternal(this.mTimeout);
    }

    public void start() {
        this.startInternal(this.mTimeout);
    }

    public void restart() {
        if (!this.mTimerActive) {
            this.start();
        } else {
            this.mTimer.setDelayFromNow(this.mTimeout);
        }
    }

    public void resume() {
        this.start();
    }

    public void stop() {
        if (this.mTimerActive) {
            this.mTimer.stop();
            this.mTimerActive = false;
            this.trace("stopped");
        }
    }

    public void pause() {
        this.stop();
    }

    public boolean isRunning() {
        return this.mTimerActive;
    }

    @Override
    public void run() {
        if (this.mTimerActive) {
            this.trace("timeout hit for");
            this.mTimerActive = false;
            this.mRunnable.run();
        }
    }

    public int getTimeout() {
        return this.mTimeout;
    }

    public void setTimeout(int n) {
        this.mTimeout = n;
    }

    private void trace(String string) {
        if (ServiceManager.logger.isTraceEnabled(1024)) {
            ServiceManager.logger.trace(1024).append("MEDIA TIMER: ").append(string).append(" \"").append(this.mTimerId).append('\"').log();
        }
    }

    private void error(String string) {
        ServiceManager.logger.error(1024).append("MEDIA TIMER: ").append(string).append(" \"").append(this.mTimerId).append('\"').log();
    }
}

