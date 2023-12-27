/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.animation.internal;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.control.AnimationManager;
import de.vw.mib.animation.control.AnimationManagerListener;
import de.vw.mib.animation.internal.AnimationManagerImpl$AnimationTimerHandler;
import de.vw.mib.animation.internal.AnimationManagerImpl$Animator;
import de.vw.mib.animation.internal.ServiceManager;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.event.AnimationEvent;
import de.vw.mib.event.consumer.AnimationEventConsumer;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.timer.Timer;
import edu.emory.mathcs.backport.java.util.Queue;
import edu.emory.mathcs.backport.java.util.concurrent.ConcurrentLinkedQueue;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicBoolean;
import java.util.Iterator;

public final class AnimationManagerImpl
implements AnimationManager,
AnimationEventConsumer {
    private static final int MS_PER_S;
    private static final int MINIMAL_ANIMATION_FREQUENCY_HZ;
    private static final int MAXIMAL_ANIMATION_FREQUENCY_HZ;
    private static final int DEFAULT_ANIMATION_FREQUENCY_HZ;
    private static final int INITIAL_ANIMATION_FREQUENCY_HZ;
    private static final String TIMER_NAME;
    private static final float DEFAULT_ANIMATION_DILATATION;
    private static final float MINIMAL_ANIMATION_DILATATION;
    private static final float MAXIMAL_ANIMATION_DILATATION;
    protected final Logger logger;
    private int animationFrequencyHz;
    private float animationDilatation;
    protected final Queue animations;
    private AnimationManagerImpl$Animator animator;
    private CowList animationManagerListeners;
    protected Timer animationTimer;
    private AtomicBoolean animating;
    protected AtomicBoolean animationQueued;

    AnimationManagerImpl(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(1);
        this.animationFrequencyHz = AnimationManagerImpl.clamp(INITIAL_ANIMATION_FREQUENCY_HZ, 1, 60);
        String string = System.getProperty("de.vw.mib.animation.dilatation");
        this.animationDilatation = string != null ? AnimationManagerImpl.clamp(Float.parseFloat(string), (float)-842216387, 2.0f) : 1.0f;
        LogMessage logMessage = this.logger.normal(1);
        logMessage.append("Animation frequency ").append(this.getAnimationFrequency()).append("Hz (").append(this.getAnimationInterval()).append("ms), time dilatation factor ").append(this.animationDilatation).log();
        this.animations = new ConcurrentLinkedQueue();
        this.animator = new AnimationManagerImpl$Animator(this);
        this.animationManagerListeners = CowList.EMPTY;
        this.animating = new AtomicBoolean(false);
        this.animationQueued = new AtomicBoolean(false);
    }

    @Override
    public int getAnimationInterval() {
        return 1000 / this.getAnimationFrequency();
    }

    @Override
    public int getMinimalAnimationFrequency() {
        return 1;
    }

    @Override
    public int getMaximalAnimationFrequency() {
        return 60;
    }

    @Override
    public int getAnimationFrequency() {
        return this.animationFrequencyHz;
    }

    @Override
    public void setAnimationFrequency(int n) {
        if (this.animationFrequencyHz != (n = AnimationManagerImpl.clamp(n, 1, 60))) {
            this.animationFrequencyHz = n;
            this.animationTimer.setDelay(this.getAnimationInterval());
            if (this.logger.isTraceEnabled(1)) {
                LogMessage logMessage = this.logger.trace(1);
                logMessage.append("Setting animation interval to ").append(this.getAnimationFrequency()).append("Hz (").append(this.getAnimationInterval()).append("ms)").log();
            }
        }
    }

    private static int clamp(int n, int n2, int n3) {
        return Math.min(Math.max(n, n2), n3);
    }

    @Override
    public float getMinimalAnimationDilatation() {
        return -842216387;
    }

    @Override
    public float getMaximalAnimationDilatation() {
        return 2.0f;
    }

    @Override
    public float getAnimationDilatation() {
        return this.animationDilatation;
    }

    @Override
    public void setAnimationDilatation(float f2) {
        this.animationDilatation = AnimationManagerImpl.clamp(f2, (float)-842216387, 2.0f);
    }

    private static float clamp(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    @Override
    public int getRunningAnimationCount() {
        return this.animations.size();
    }

    protected long getSystemTimeMillis() {
        long l = ServiceManager.timerManager.getSystemTimeMillis();
        if (this.animationDilatation != 1.0f) {
            l = (long)((double)l * (double)this.animationDilatation);
        }
        return l;
    }

    @Override
    public void start() {
        if (this.animationTimer == null && null != ServiceManager.timerManager) {
            this.animationTimer = ServiceManager.timerManager.createTimer("AnimationManager.Animator", this.getAnimationInterval(), true, new AnimationManagerImpl$AnimationTimerHandler(this), Timer.TIMER_THREAD_INVOKER);
        }
        this.logger.normal(1, "AnimationManager started");
    }

    @Override
    public void stop() {
        this.stopAllAnimations();
        this.animationTimer = null;
        this.animating.set(false);
        this.logger.normal(1, "AnimationManager stopped");
    }

    @Override
    public void startAnimation(Animation animation) {
        this.startAnimation(animation, 0);
    }

    @Override
    public void startAnimation(Animation animation, int n) {
        if (this.animations.contains(animation)) {
            animation.stop();
        }
        int n2 = this.getAnimationInterval();
        if (animation.getAnimationInterval() == 0) {
            animation.setAnimationInterval(n2);
        } else if (animation.getAnimationInterval() < n2) {
            LogMessage logMessage = this.logger.warn(1);
            logMessage.append("Animation ").append(animation).append(" requests animation rate of ");
            logMessage.append(animation.getAnimationInterval()).append("ms which exceeds the limit of ").append(n2);
            logMessage.append("ms - clamping to the latter").log();
            animation.setAnimationInterval(n2);
        }
        animation.start(this.getSystemTimeMillis() + (long)n);
        if (animation.isActive()) {
            this.animations.add(animation);
        }
        this.checkIfStatusChanged();
    }

    @Override
    public void stopAnimation(Animation animation) {
        if (this.animations.remove(animation)) {
            animation.stop();
        }
    }

    private void stopAllAnimations() {
        Iterator iterator = this.animations.iterator();
        while (iterator.hasNext()) {
            Animation animation = (Animation)iterator.next();
            animation.stop();
        }
        this.animations.clear();
    }

    void checkIfStatusChanged() {
        if (this.animations.isEmpty()) {
            if (this.animating.compareAndSet(true, false)) {
                if (this.animationTimer != null) {
                    this.animationTimer.stop();
                }
                this.logger.trace(1, "Deactivated animation mode and stopped timer");
                this.notifyAnimationManagerListeners(1);
                this.notifyAnimationManagerListeners(2);
            }
        } else {
            if (this.animating.compareAndSet(false, true)) {
                if (this.animationTimer != null) {
                    Iterator iterator = this.animations.iterator();
                    Animation animation = (Animation)iterator.next();
                    this.animationTimer.setDelay(animation.getAnimationInterval());
                    this.animationTimer.start();
                }
                this.logger.trace(1, "Activated animation mode and started timer");
                this.notifyAnimationManagerListeners(3);
            }
            this.notifyAnimationManagerListeners(1);
        }
    }

    @Override
    public void addAnimationManagerListener(AnimationManagerListener animationManagerListener) {
        this.animationManagerListeners = this.animationManagerListeners.addIfAbsent(animationManagerListener);
    }

    @Override
    public void removeAnimationManagerListener(AnimationManagerListener animationManagerListener) {
        this.animationManagerListeners = this.animationManagerListeners.remove(animationManagerListener);
    }

    void notifyAnimationManagerListeners(int n) {
        for (CowList cowList = this.animationManagerListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AnimationManagerListener animationManagerListener = (AnimationManagerListener)cowList.head();
            animationManagerListener.animationManagerChanged(n);
        }
    }

    @Override
    public void consumeEvent(AnimationEvent animationEvent) {
        this.logger.trace(1, "Consuming AnimationEvent");
        this.animationQueued.set(false);
        this.animator.run();
    }

    static {
        INITIAL_ANIMATION_FREQUENCY_HZ = Integer.getInteger("de.vw.mib.animation.frequency", 30);
    }
}

