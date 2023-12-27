/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.animations;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.animation.internal.ServiceManager;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.StringBuilder;

public abstract class AbstractAnimation
implements Animation {
    private static final int ANIMATION_STATUS_NONE;
    private static final int ANIMATION_STATUS_STARTED;
    private static final int ANIMATION_STATUS_STOPPED;
    private static final int ANIMATION_STATUS_RUNNING;
    protected static final Logger LOGGER;
    private boolean looped;
    private int interval;
    private int status;
    private long startTime;
    private long lastRunTime;
    private long nextRunTime;
    private CowList listeners;

    protected AbstractAnimation() {
        this(false);
    }

    protected AbstractAnimation(boolean bl) {
        this.looped = bl;
        this.status = 0;
        this.listeners = CowList.EMPTY;
    }

    public Object clone() {
        AbstractAnimation abstractAnimation = (AbstractAnimation)super.clone();
        abstractAnimation.listeners = CowList.EMPTY;
        return abstractAnimation;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getClass().getName());
        stringBuilder.append("[looped=").append(this.looped);
        stringBuilder.append(",interval=").append(this.interval);
        stringBuilder.append(",status=").append(this.status);
        stringBuilder.append(",startTime=").append(this.startTime);
        stringBuilder.append(",lastRunTime=").append(this.lastRunTime);
        stringBuilder.append(",nextRunTime=").append(this.nextRunTime);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public final boolean isLooped() {
        return this.looped;
    }

    @Override
    public final void setLooped(boolean bl) {
        this.looped = bl;
    }

    @Override
    public abstract int getDuration() {
    }

    @Override
    public final int getAnimationInterval() {
        return this.interval;
    }

    @Override
    public final void setAnimationInterval(int n) {
        this.interval = n;
    }

    private void setStatus(int n) {
        if (this.status != n) {
            this.status = n;
            this.notifyStatusChanged();
        }
    }

    @Override
    public final boolean isStarted() {
        return this.status == 1;
    }

    @Override
    public final boolean isStopped() {
        return this.status == 2;
    }

    @Override
    public final boolean isRunning() {
        return this.status == 3;
    }

    @Override
    public final boolean isActive() {
        return this.status == 1 || this.status == 3;
    }

    @Override
    public final long getStartTime() {
        return this.startTime;
    }

    protected final void setStartTime(long l) {
        this.startTime = l;
    }

    public final long getLastRunTime() {
        return this.lastRunTime;
    }

    protected final void setLastRunTime(long l) {
        this.lastRunTime = l;
    }

    @Override
    public final long getNextRunTime() {
        return this.nextRunTime;
    }

    protected final void setNextRunTime(long l) {
        this.nextRunTime = l;
    }

    @Override
    public void start(long l) {
        this.setStatus(1);
        this.setStartTime(l);
        if (LOGGER.isTraceEnabled(1)) {
            LogMessage logMessage = LOGGER.trace(1);
            logMessage.append("Starting animation ").append(this).log();
        }
        this.animate(l, this.getAnimationInterval());
        this.setLastRunTime(l);
        this.setNextRunTime(l + (long)this.getAnimationInterval());
    }

    @Override
    public void stop() {
        this.setStatus(2);
        if (LOGGER.isTraceEnabled(1)) {
            LogMessage logMessage = LOGGER.trace(1);
            logMessage.append("Stopped animation ").append(this).log();
        }
    }

    @Override
    public final void run(long l) {
        this.setStatus(3);
        if (LOGGER.isTraceEnabled(1)) {
            LogMessage logMessage = LOGGER.trace(1);
            logMessage.append("Animating ").append(this).log();
        }
        this.animate(l, l - this.getLastRunTime());
        this.setLastRunTime(l);
        this.setNextRunTime(l + (long)this.getAnimationInterval());
    }

    public abstract void animate(long l, long l2) {
    }

    @Override
    public final void addAnimationListener(AnimationListener animationListener) {
        this.listeners = this.listeners.addIfAbsent(animationListener);
    }

    @Override
    public final void removeAnimationListener(AnimationListener animationListener) {
        this.listeners = this.listeners.remove(animationListener);
    }

    protected final void notifyStatusChanged() {
        block5: for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AnimationListener animationListener = (AnimationListener)cowList.head();
            switch (this.status) {
                case 1: {
                    animationListener.animationStarted(this);
                    continue block5;
                }
                case 2: {
                    animationListener.animationStopped(this);
                    continue block5;
                }
                case 3: {
                    animationListener.animationRunning(this);
                    continue block5;
                }
            }
        }
    }

    protected final void notifyProgress(long l) {
        int n = (int)(l - this.startTime);
        for (CowList cowList = this.listeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AnimationListener animationListener = (AnimationListener)cowList.head();
            animationListener.animationProgress(this, n);
        }
    }

    static {
        LOGGER = ServiceManager.loggerFactory.getLogger(1);
    }
}

