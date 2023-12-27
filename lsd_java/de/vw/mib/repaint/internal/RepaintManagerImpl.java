/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.repaint.internal;

import de.vw.mib.event.RepaintEvent;
import de.vw.mib.event.consumer.RepaintEventConsumer;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.log4mib.LoggerFactory;
import de.vw.mib.repaint.Paintable;
import de.vw.mib.repaint.RepaintManager;
import de.vw.mib.repaint.internal.RepaintManagerImpl$AnimationHandler;
import de.vw.mib.repaint.internal.RepaintManagerImpl$RepaintTimerHandler;
import de.vw.mib.repaint.internal.RepaintObserver;
import de.vw.mib.repaint.internal.ServiceManager;
import de.vw.mib.timer.Timer;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicBoolean;

public class RepaintManagerImpl
implements RepaintManager,
RepaintEventConsumer {
    private static final boolean REPAINT_ALWAYS = System.getProperty("de.vw.mib.repaint.always") != null;
    protected static final boolean IGNORE_ANIMATION_MODE = System.getProperty("de.vw.mib.repaint.ignoreanimationmode") != null;
    private static final int MINIMAL_REPAINT_FREQUENCY_HZ;
    private static final int MAXIMAL_REPAINT_FREQUENCY_HZ;
    private static final int DEFAULT_REPAINT_FREQUENCY_HZ;
    private static final int INITIAL_REPAINT_FREQUENCY_HZ;
    private static final String TIMER_NAME;
    protected static final int REPAINT_MODE_NORMAL;
    protected static final int REPAINT_MODE_ANIMATION;
    protected static final int REPAINT_MODE_DISABLED;
    protected final Logger logger;
    private static final int MS_PER_S;
    private int repaintFrequencyHz;
    private Paintable repaintHandler;
    private RepaintObserver repaintObserver;
    protected Timer repaintTimer;
    protected volatile int repaintMode;
    protected AtomicBoolean repaintRequested;
    protected AtomicBoolean repaintQueued;

    RepaintManagerImpl(LoggerFactory loggerFactory) {
        this.logger = loggerFactory.getLogger(2048);
        this.repaintFrequencyHz = RepaintManagerImpl.clamp(INITIAL_REPAINT_FREQUENCY_HZ, 1, 60);
        LogMessage logMessage = this.logger.normal(2048);
        logMessage.append("Repaint frequency ").append(this.getRefreshFrequency()).append("Hz (").append(this.getRefreshInterval()).append("ms)").log();
        this.repaintHandler = null;
        this.repaintObserver = null;
        this.repaintTimer = ServiceManager.timerManager.createTimer("RepaintManager.RepaintTimer", this.getRefreshInterval(), true, new RepaintManagerImpl$RepaintTimerHandler(this), Timer.TIMER_THREAD_INVOKER);
        ServiceManager.animationManager.addAnimationManagerListener(new RepaintManagerImpl$AnimationHandler(this));
        this.repaintMode = 0;
        this.repaintRequested = new AtomicBoolean(false);
        this.repaintQueued = new AtomicBoolean(false);
    }

    private static int clamp(int n, int n2, int n3) {
        return Math.min(Math.max(n, n2), n3);
    }

    @Override
    public int getRefreshInterval() {
        return 1000 / this.repaintFrequencyHz;
    }

    @Override
    public int getRefreshFrequency() {
        return this.repaintFrequencyHz;
    }

    @Override
    public void setRefreshFrequency(int n) {
        if (this.repaintFrequencyHz != n) {
            this.repaintFrequencyHz = n;
            this.repaintTimer.setDelay(this.getRefreshInterval());
            if (this.logger.isTraceEnabled(2048)) {
                LogMessage logMessage = this.logger.trace(2048);
                logMessage.append("Setting repaint interval to ").append(this.repaintFrequencyHz).append("Hz (").append(this.getRefreshInterval()).append("ms)").log();
            }
        }
    }

    @Override
    public boolean isRepaintAlwaysEnabled() {
        return REPAINT_ALWAYS;
    }

    @Override
    public void disableRepaints() {
        this.repaintMode = 2;
        this.logger.trace(2048, "Switched to Repaint-Mode: DISABLED");
    }

    @Override
    public void enableRepaints() {
        this.repaintMode = 0;
        this.logger.trace(2048, "Switched to Repaint-Mode: NORMAL");
    }

    @Override
    public synchronized void registerRepaintHandler(Paintable paintable) {
        if (this.logger.isTraceEnabled(2048)) {
            LogMessage logMessage = this.logger.trace(2048);
            logMessage.append("Paintable registered ").append(paintable).log();
        }
        this.repaintHandler = paintable;
    }

    public synchronized void registerRepaintObserver(RepaintObserver repaintObserver) {
        this.repaintObserver = repaintObserver;
    }

    @Override
    public void consumeEvent(RepaintEvent repaintEvent) {
        if (this.repaintHandler == null) {
            this.logger.warn(2048, "Repaint could not perform, because repaintHandler is 'null'");
            return;
        }
        this.logger.trace(2048, "Consuming RepaintEvent");
        this.repaintQueued.set(false);
        this.repaintHandler.repaint();
        if (this.repaintObserver != null) {
            this.repaintObserver.repaint();
        }
        if (REPAINT_ALWAYS) {
            this.repaint();
        }
    }

    @Override
    public void repaint() {
        if (this.repaintMode == 0) {
            if (!this.repaintQueued.get()) {
                this.logger.trace(2048, "RepaintManager.repaint() requested");
                if (this.repaintTimer.isStarted()) {
                    this.repaintRequested.set(true);
                    this.logger.trace(2048, "RepaintTimerHandler notified");
                } else {
                    this.repaintTimer.start();
                    this.logger.trace(2048, "Starting periodic repaint handler");
                    this.submitRepaintEvent();
                }
            } else {
                this.logger.trace(2048, "Discarding explicit RepaintManager.repaint() request due to pending RepaintEvent");
            }
        } else {
            this.logger.trace(2048, "Discarding explicit RepaintManager.repaint() request due to animation mode");
        }
    }

    protected void submitRepaintEvent() {
        if (this.repaintQueued.compareAndSet(false, true)) {
            ServiceManager.eventDispatcher.createAndSubmitRepaintEvent();
            this.logger.trace(2048, "Submitting RepaintEvent");
        }
    }

    @Override
    public void unregisterRepaintHandler(Paintable paintable) {
    }

    static {
        INITIAL_REPAINT_FREQUENCY_HZ = Integer.getInteger("de.vw.mib.repaint.frequency", 30);
    }
}

