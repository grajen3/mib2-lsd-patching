/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.DefaultTimerWidgetController$1;
import de.vw.mib.widgets.controller.DefaultTimerWidgetController$2;
import de.vw.mib.widgets.controller.DefaultTimerWidgetController$ViewChangedHandler;
import de.vw.mib.widgets.controller.TimerWidgetController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.TimerWidgetModel;
import de.vw.mib.widgets.models.ViewModel;

public final class DefaultTimerWidgetController
extends AbstractWidgetController
implements TimerWidgetController {
    private static final int MINIMUM_DURATION_MS;
    private static final String DURATIONSTART_TIMER_NAME;
    private static final String DURATIONRESTART_TIMER_NAME;
    private Timer durationStartTimer;
    private Timer durationRestartTimer;
    protected boolean startTimerRunning;
    protected boolean restartTimerRunning;
    protected boolean timerSuspended;
    private DefaultTimerWidgetController$ViewChangedHandler viewChangedHandler;

    @Override
    protected void reset() {
        super.reset();
        this.viewChangedHandler = new DefaultTimerWidgetController$ViewChangedHandler(this);
        this.durationStartTimer = null;
        this.durationRestartTimer = null;
        this.startTimerRunning = false;
        this.restartTimerRunning = false;
        this.timerSuspended = false;
    }

    @Override
    public void init() {
        ViewModel viewModel;
        super.init();
        TimerWidgetModel timerWidgetModel = this.getTimerWidget();
        if (timerWidgetModel != null && (viewModel = timerWidgetModel.getView()) != null) {
            viewModel.addViewChangedListener(this.viewChangedHandler);
        }
    }

    @Override
    public void deInit() {
        ViewModel viewModel;
        TimerWidgetModel timerWidgetModel = this.getTimerWidget();
        if (timerWidgetModel != null && (viewModel = timerWidgetModel.getView()) != null) {
            viewModel.removeViewChangedListener(this.viewChangedHandler);
        }
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        TimerWidgetModel timerWidgetModel = this.getTimerWidget();
        if (timerWidgetModel != null && timerWidgetModel.is_autoStart()) {
            this.fire_startTimer();
        }
    }

    @Override
    public void deActivate() {
        this.fire_stopTimer();
        super.deActivate();
    }

    public TimerWidgetModel getTimerWidget() {
        if (this.getWidget() != null && this.getWidget() instanceof TimerWidgetModel) {
            return (TimerWidgetModel)this.getWidget();
        }
        return null;
    }

    private void initTimers() {
        TimerWidgetModel timerWidgetModel = (TimerWidgetModel)this.getWidget();
        int n = timerWidgetModel.get_durationStart();
        if (n < 100) {
            LogMessage logMessage = LOGGER.warn(1);
            logMessage.append("Timer start duration (").append(n).append("ms) of widget '").append(this.getWidget().getQualifiedName()).append("' is below minimum threshold of ").append(100).append("ms. Clamping to minimum.").log();
            n = 100;
        }
        this.durationStartTimer = ServiceManager.timerManager.createTimer("DefaultTimerWidgetController.StartTimer", n, false, new DefaultTimerWidgetController$1(this), ServiceManager.eventDispatcher);
        int n2 = timerWidgetModel.get_durationRestart();
        if (n2 < 100) {
            LogMessage logMessage = LOGGER.warn(1);
            logMessage.append("Timer restart duration (").append(n2).append("ms) of widget '").append(this.getWidget().getQualifiedName()).append("' is below minimum threshold of ").append(100).append("ms. Clamping to minimum.").log();
            n2 = 100;
        }
        this.durationRestartTimer = ServiceManager.timerManager.createTimer("DefaultSliderController.RestartTimer", n2, false, new DefaultTimerWidgetController$2(this), ServiceManager.eventDispatcher);
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        if ("startTimer" == string) {
            this.fire_startTimer();
            bl = true;
        } else if ("stopTimer" == string) {
            this.fire_stopTimer();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        return false;
    }

    @Override
    public void fire_startTimer() {
        TimerWidgetModel timerWidgetModel = (TimerWidgetModel)this.getWidget();
        timerWidgetModel.set_timerRunning(true);
        if (this.restartTimerRunning) {
            this.durationRestartTimer.stop();
            this.durationRestartTimer.start();
        } else if (this.startTimerRunning && timerWidgetModel.get_durationRestart() > 0) {
            this.durationStartTimer.stop();
            this.startTimerRunning = false;
            this.durationRestartTimer.start();
            this.restartTimerRunning = true;
        } else {
            this.initTimers();
            this.durationStartTimer.start();
            this.startTimerRunning = true;
        }
    }

    @Override
    public void fire_stopTimer() {
        TimerWidgetModel timerWidgetModel = (TimerWidgetModel)this.getWidget();
        timerWidgetModel.set_timerRunning(false);
        if (this.startTimerRunning) {
            this.durationStartTimer.stop();
            this.startTimerRunning = false;
        }
        if (this.restartTimerRunning) {
            this.durationRestartTimer.stop();
            this.restartTimerRunning = false;
        }
    }

    @Override
    public void fire_timerElapsed() {
        TimerWidgetModel timerWidgetModel = (TimerWidgetModel)this.getWidget();
        if (timerWidgetModel != null) {
            timerWidgetModel.set_timerRunning(false);
            this.fireHMIEvent("timerElapsed");
        }
    }
}

