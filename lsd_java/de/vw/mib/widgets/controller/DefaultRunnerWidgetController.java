/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.RunnerWidgetController;
import de.vw.mib.widgets.models.RunnerWidgetModel;

public final class DefaultRunnerWidgetController
extends AbstractWidgetController
implements RunnerWidgetController {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deActivate() {
        RunnerWidgetModel runnerWidgetModel = (RunnerWidgetModel)this.getWidget();
        runnerWidgetModel.setPropagateValueChange(true);
        if (runnerWidgetModel.isTimeRunning()) {
            runnerWidgetModel.stop();
        }
        this.fire_sendCurrentTime();
        this.fire_sendCurrentSystemTime();
        super.deActivate();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        if ("reset" == string) {
            this.fire_reset();
            return true;
        }
        if ("start" == string) {
            this.fire_start();
            return true;
        }
        if ("stop" == string) {
            this.fire_stop();
            return true;
        }
        if ("stopSplitTime" == string) {
            this.fire_stopSplitTime();
            return true;
        }
        if ("startPropagateValueChange" == string) {
            this.fire_startPropagateValueChange();
            return true;
        }
        if ("stopPropagateValueChange" == string) {
            this.fire_stopPropagateValueChange();
            return true;
        }
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        return false;
    }

    @Override
    public void fire_reset() {
        RunnerWidgetModel runnerWidgetModel = (RunnerWidgetModel)this.getWidget();
        runnerWidgetModel.resetValue();
        this.fire_sendCurrentTime();
    }

    @Override
    public void fire_start() {
        RunnerWidgetModel runnerWidgetModel = (RunnerWidgetModel)this.getWidget();
        runnerWidgetModel.start();
        this.fire_started();
    }

    @Override
    public void fire_stop() {
        RunnerWidgetModel runnerWidgetModel = (RunnerWidgetModel)this.getWidget();
        runnerWidgetModel.setPropagateValueChange(true);
        runnerWidgetModel.stop();
        this.fire_sendCurrentTime();
        this.fire_stopped();
    }

    @Override
    public void fire_stopSplitTime() {
        this.fire_sendSplitTime();
    }

    @Override
    public void fire_stopPropagateValueChange() {
        RunnerWidgetModel runnerWidgetModel = (RunnerWidgetModel)this.getWidget();
        runnerWidgetModel.setPropagateValueChange(false);
    }

    @Override
    public void fire_startPropagateValueChange() {
        RunnerWidgetModel runnerWidgetModel = (RunnerWidgetModel)this.getWidget();
        runnerWidgetModel.setPropagateValueChange(true);
    }

    @Override
    public void fire_sendSplitTime() {
        RunnerWidgetModel runnerWidgetModel = (RunnerWidgetModel)this.getWidget();
        this.fireIntegerEvent("sendSplitTime", runnerWidgetModel.getInternalTime());
    }

    @Override
    public void fire_sendCurrentTime() {
        RunnerWidgetModel runnerWidgetModel = (RunnerWidgetModel)this.getWidget();
        this.fireIntegerEvent("sendCurrentTime", runnerWidgetModel.getInternalTime());
    }

    @Override
    public void fire_sendCurrentSystemTime() {
        RunnerWidgetModel runnerWidgetModel = (RunnerWidgetModel)this.getWidget();
        this.fireIntegerEvent("sendCurrentSystemTime", runnerWidgetModel.getSystimeOnTimerStop());
    }

    @Override
    public void fire_stopped() {
        this.fireHMIEvent("stopped");
    }

    @Override
    public void fire_started() {
        this.fireHMIEvent("started");
    }
}

