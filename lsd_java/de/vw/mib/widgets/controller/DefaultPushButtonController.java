/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.controller.AbstractButtonController;
import de.vw.mib.widgets.controller.DefaultPushButtonController$1;
import de.vw.mib.widgets.controller.DefaultPushButtonController$2;
import de.vw.mib.widgets.controller.DefaultPushButtonController$3;
import de.vw.mib.widgets.controller.DefaultPushButtonController$4;
import de.vw.mib.widgets.controller.DefaultPushButtonController$5;
import de.vw.mib.widgets.controller.DefaultPushButtonController$6;
import de.vw.mib.widgets.controller.PushButtonController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ButtonModel;

public class DefaultPushButtonController
extends AbstractButtonController
implements PushButtonController {
    private static final String PRIMARY_TIMER_NAME;
    private static final String PRIMARY_REPEAT_TIMER_NAME;
    private static final String SECONDARY_TIMER_NAME;
    private static final String SECONDARY_REPEAT_TIMER_NAME;
    private static final String PREDICTIVE_ACTIVATION_TIMER_NAME;
    private static final int PREDICTIVE_ACTIVION_TIMEOUT;
    private Timer primaryTimer;
    private Timer primaryRepeatTimer;
    private Timer secondaryTimer;
    private Timer secondaryRepeatTimer;
    private boolean longPressedFired;
    private Timer predicitiveActivationTimer;

    @Override
    protected void reset() {
        super.reset();
        this.releaseTimers();
        this.longPressedFired = false;
    }

    @Override
    public void deInit() {
        this.releaseTimers();
        this.longPressedFired = false;
        super.deInit();
    }

    private void performPredictiveActivation() {
        ButtonModel buttonModel;
        this.initPredictiveActivationTimer();
        if (this.predicitiveActivationTimer.isStarted()) {
            this.predicitiveActivationTimer.stop();
        }
        buttonModel.setActivatedInternal(!(buttonModel = (ButtonModel)this.getWidget()).isActivatedInternal());
        this.predicitiveActivationTimer.start();
        if (LOGGER.isTraceEnabled(8)) {
            LogMessage logMessage = LOGGER.trace(8);
            logMessage.append(buttonModel.getQualifiedName()).append(" set internal activation flag predictively on '").append(buttonModel.isActivatedInternal()).append("' and timer started").log();
        }
    }

    private void initPredictiveActivationTimer() {
        if (this.predicitiveActivationTimer == null) {
            this.predicitiveActivationTimer = this.createTimer("DefaultPushButtonController.predictiveActivationTimer", 1000);
            DefaultPushButtonController$1 defaultPushButtonController$1 = new DefaultPushButtonController$1(this);
            this.setTimerRunnable(this.predicitiveActivationTimer, defaultPushButtonController$1);
        }
    }

    @Override
    public void fire_press() {
        ButtonModel buttonModel = (ButtonModel)this.getWidget();
        buttonModel.setPressed(true);
        if (buttonModel.isTimerChanged()) {
            this.stopPressTimers();
            this.initTimers();
            buttonModel.setTimerChanged(false);
        }
        switch (buttonModel.get_buttonMode()) {
            case 2: {
                if (this.longPressedFired) {
                    this.longPressedFired = false;
                }
                if (this.primaryTimer != null && !this.primaryTimer.isStarted()) {
                    this.primaryTimer.start();
                }
                this.fire_pressed();
                break;
            }
            case 1: {
                if (this.primaryTimer != null && !this.primaryTimer.isStarted() && this.secondaryTimer != null && !this.secondaryTimer.isStarted() && this.checkButtonTimes()) {
                    this.primaryTimer.start();
                    this.secondaryTimer.start();
                }
                this.fire_pressed();
                break;
            }
            default: {
                this.fire_pressed();
            }
        }
    }

    @Override
    public void fire_release() {
        ButtonModel buttonModel = (ButtonModel)this.getWidget();
        if (buttonModel.is_predictiveActivation() && !this.longPressedFired) {
            this.performPredictiveActivation();
        }
        buttonModel.setPressed(false);
        switch (buttonModel.get_buttonMode()) {
            case 2: {
                if (this.primaryTimer != null && this.primaryTimer.isStarted()) {
                    this.primaryTimer.stop();
                }
                if (this.longPressedFired) {
                    this.fire_longReleased();
                    break;
                }
                this.fire_released();
                break;
            }
            case 1: {
                this.stopPressTimers();
                this.fire_released();
                break;
            }
            default: {
                this.fire_released();
            }
        }
    }

    @Override
    public void fire_longPressed() {
        this.fireHMIEvent("longPressed");
        if (!this.longPressedFired) {
            this.longPressedFired = true;
        }
        if (this.primaryTimer != null && this.primaryTimer.isStarted()) {
            this.primaryTimer.stop();
        }
    }

    @Override
    public void fire_longReleased() {
        this.fireHMIEvent("longReleased");
        if (this.longPressedFired) {
            this.longPressedFired = false;
        }
    }

    @Override
    public void fire_cancelled() {
        this.stopPressTimers();
        if (this.longPressedFired) {
            this.fire_cancelledLongpress();
            return;
        }
        super.fire_cancelled();
    }

    @Override
    public void fire_cancelledLongpress() {
        this.fireHMIEvent("cancelledLongpress");
        if (this.longPressedFired) {
            this.longPressedFired = false;
        }
    }

    private boolean checkButtonTimes() {
        ButtonModel buttonModel = (ButtonModel)this.getWidget();
        boolean bl = true;
        if (buttonModel.get_startTimePrimary() + buttonModel.get_repeatTimePrimary() > buttonModel.get_startTimeSecondary()) {
            bl = false;
        }
        return bl;
    }

    private Timer createTimer(String string, int n) {
        return this.createTimer(string, n, false);
    }

    private Timer createTimer(String string, int n, boolean bl) {
        Timer timer = ServiceManager.timerManager.createTimer(string);
        timer.setDelay(n);
        timer.setRepeat(bl);
        return timer;
    }

    private void setTimerRunnable(Timer timer, Runnable runnable) {
        timer.setRunnable(runnable, ServiceManager.eventDispatcher);
    }

    private void initTimers() {
        ButtonModel buttonModel = (ButtonModel)this.getWidget();
        switch (buttonModel.get_buttonMode()) {
            case 2: {
                Timer timer = this.primaryTimer = this.createTimer("DefaultPushButtonController.primaryTimer", buttonModel.get_startTimePrimary());
                DefaultPushButtonController$2 defaultPushButtonController$2 = new DefaultPushButtonController$2(this, timer);
                this.setTimerRunnable(timer, defaultPushButtonController$2);
                break;
            }
            case 1: {
                Timer timer = this.primaryTimer = this.createTimer("DefaultPushButtonController.primaryTimer", buttonModel.get_startTimePrimary());
                Timer timer2 = this.primaryRepeatTimer = this.createTimer("DefaultPushButtonController.primaryRepeatTimer", buttonModel.get_repeatTimePrimary(), true);
                Timer timer3 = this.secondaryTimer = this.createTimer("DefaultPushButtonController.secondaryTimer", buttonModel.get_startTimeSecondary());
                Timer timer4 = this.secondaryRepeatTimer = this.createTimer("DefaultPushButtonController.secondaryRepeatTimer", buttonModel.get_repeatTimeSecondary(), true);
                DefaultPushButtonController$3 defaultPushButtonController$3 = new DefaultPushButtonController$3(this, timer, timer2);
                this.setTimerRunnable(timer, defaultPushButtonController$3);
                DefaultPushButtonController$4 defaultPushButtonController$4 = new DefaultPushButtonController$4(this, timer2, buttonModel);
                this.setTimerRunnable(timer2, defaultPushButtonController$4);
                DefaultPushButtonController$5 defaultPushButtonController$5 = new DefaultPushButtonController$5(this, timer, timer2, timer4);
                this.setTimerRunnable(timer3, defaultPushButtonController$5);
                DefaultPushButtonController$6 defaultPushButtonController$6 = new DefaultPushButtonController$6(this, timer4, buttonModel);
                this.setTimerRunnable(timer4, defaultPushButtonController$6);
                break;
            }
        }
    }

    private void releaseTimers() {
        this.releaseTimers(true);
    }

    private void releaseTimers(boolean bl) {
        if (bl) {
            this.stopPressTimers();
            this.stopPredictiveActivationTimer();
        }
        this.primaryTimer = null;
        this.secondaryTimer = null;
        this.primaryRepeatTimer = null;
        this.secondaryRepeatTimer = null;
        this.predicitiveActivationTimer = null;
    }

    private void stopPressTimers() {
        if (this.primaryTimer != null && this.primaryTimer.isStarted()) {
            this.primaryTimer.stop();
        }
        if (this.secondaryTimer != null && this.secondaryTimer.isStarted()) {
            this.secondaryTimer.stop();
        }
        if (this.primaryRepeatTimer != null && this.primaryRepeatTimer.isStarted()) {
            this.primaryRepeatTimer.stop();
        }
        if (this.secondaryRepeatTimer != null && this.secondaryRepeatTimer.isStarted()) {
            this.secondaryRepeatTimer.stop();
        }
    }

    private void stopPredictiveActivationTimer() {
        if (this.predicitiveActivationTimer != null && this.predicitiveActivationTimer.isStarted()) {
            this.predicitiveActivationTimer.stop();
        }
    }
}

