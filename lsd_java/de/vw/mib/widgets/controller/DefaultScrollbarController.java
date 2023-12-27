/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.SliderCalculator;
import de.vw.mib.widgets.controller.AbstractSliderController;
import de.vw.mib.widgets.controller.DefaultScrollbarController$1;
import de.vw.mib.widgets.controller.DefaultScrollbarController$2;
import de.vw.mib.widgets.controller.DefaultScrollbarController$3;
import de.vw.mib.widgets.controller.ScrollbarController;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ScrollbarModel;

public final class DefaultScrollbarController
extends AbstractSliderController
implements ScrollbarController {
    private static final String REPEAT_TIMER_NAME;
    private static final String START_TIMER_NAME;
    protected Timer startTimer;
    protected boolean startTimerRunning;
    protected Timer repeatTimer;
    protected boolean repeatTimerRunning;

    @Override
    public void init() {
        super.init();
        this.valueRequested = 128;
    }

    @Override
    protected void reset() {
        super.reset();
        this.repeatTimer = null;
        this.startTimer = null;
        this.repeatTimerRunning = false;
        this.startTimerRunning = false;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        boolean bl = false;
        if (string == "selectNextPage" || string == "selectPreviousPage" || string == "selectLastPage" || string == "selectFirstPage") {
            ServiceManager.eventDispatcher.invoke(new DefaultScrollbarController$1(this, scrollbarModel, string));
            bl = true;
        }
        return bl;
    }

    private void initTimers() {
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        this.startTimer = ServiceManager.timerManager.createTimer("DefaultScrollbarController.StartTimer", scrollbarModel.get_startTime(), false, new DefaultScrollbarController$2(this), ServiceManager.eventDispatcher);
        this.repeatTimer = ServiceManager.timerManager.createTimer("DefaultScrollbarController.RepeatTimer", scrollbarModel.get_repeatTime(), true, new DefaultScrollbarController$3(this, scrollbarModel), ServiceManager.eventDispatcher);
    }

    private boolean scrollToFirstPage() {
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        if (scrollbarModel.get_value() > scrollbarModel.get_valueMin()) {
            scrollbarModel.set_value(scrollbarModel.get_valueMin());
            return true;
        }
        return false;
    }

    private boolean scrollToLastPage() {
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        if (scrollbarModel.get_value() < scrollbarModel.get_valueMax()) {
            scrollbarModel.set_value(scrollbarModel.get_valueMax());
            return true;
        }
        return false;
    }

    private boolean scrollToNextPage() {
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        if (scrollbarModel.get_value() == scrollbarModel.get_valueMax()) {
            return false;
        }
        scrollbarModel.scrollToNextPage();
        return true;
    }

    private boolean scrollToPreviousPage() {
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        if (scrollbarModel.get_value() == scrollbarModel.get_valueMin()) {
            return false;
        }
        scrollbarModel.scrollToPrevPage();
        return true;
    }

    void stopTimer() {
        if (this.startTimerRunning) {
            this.startTimer.stop();
            this.startTimerRunning = false;
        }
        if (this.repeatTimerRunning) {
            this.repeatTimer.stop();
            this.repeatTimerRunning = false;
        }
    }

    @Override
    public void fire_drag() {
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        if (scrollbarModel.get_stepValues() == 0 && (scrollbarModel.getPositionOnScrollbarButton() >= 0 || scrollbarModel.is_jump())) {
            this.controllerValueHelper = scrollbarModel.updatePosition(this.clickedX, this.clickedY, false);
            if (scrollbarModel.get_adjustableWidgetRef() == null) {
                this.fire_valueChanged();
            }
        }
    }

    @Override
    public void fire_press() {
        super.fire_press();
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        scrollbarModel.setPositionOnScrollbarButton(this.clickedX, this.clickedY);
        int n = scrollbarModel.getPositionOnScrollbarButton();
        if (scrollbarModel.get_stepValues() > 0) {
            if (n < 0) {
                scrollbarModel.updateStepValuePosition(this.clickedX, this.clickedY);
            }
        } else if (n < 0) {
            if (!scrollbarModel.is_jump()) {
                if (!this.startTimerRunning && !this.repeatTimerRunning) {
                    if (this.startTimer == null) {
                        this.initTimers();
                    }
                    this.startTimer.start();
                    this.startTimerRunning = true;
                }
                int n2 = scrollbarModel.getValue() + (n == -1 ? -1 : 1) * scrollbarModel.getPageSize();
                n2 = Util.clamp(n2, scrollbarModel.get_valueMin(), scrollbarModel.get_valueMax());
                int n3 = SliderCalculator.calculateScrollbarPositionByValue(scrollbarModel, n2);
                scrollbarModel.setScalePosition(n3);
                scrollbarModel.setCurrentValue(n2);
                scrollbarModel.set_value(n2);
                this.controllerValueHelper = n2;
            } else {
                this.controllerValueHelper = scrollbarModel.updatePosition(this.clickedX, this.clickedY, false);
            }
            if (scrollbarModel.get_adjustableWidgetRef() == null) {
                this.fire_valueChanged();
            }
        } else {
            this.stopTimer();
        }
    }

    @Override
    public void fire_release() {
        this.stopTimer();
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        scrollbarModel.setPositionOnScrollbarButton(0, 0);
        this.valueRequested = 128;
        super.fire_release();
    }

    @Override
    public void fire_stepDown() {
        super.fire_stepDown();
    }

    @Override
    public void fire_stepUp() {
        super.fire_stepUp();
    }

    @Override
    public void fire_selectNextPage() {
        if (this.scrollToNextPage()) {
            this.fire_nextPageSelected();
        } else {
            this.fire_nextPageSelectedFailed();
        }
    }

    @Override
    public void fire_selectPreviousPage() {
        if (this.scrollToPreviousPage()) {
            this.fire_previousPageSelected();
        } else {
            this.fire_previousPageSelectedFailed();
        }
    }

    @Override
    public void fire_selectLastPage() {
        if (this.scrollToLastPage()) {
            this.fire_lastPageSelected();
        } else {
            this.fire_lastPageSelectedFailed();
        }
    }

    @Override
    public void fire_selectFirstPage() {
        if (this.scrollToFirstPage()) {
            this.fire_firstPageSelected();
        } else {
            this.fire_firstPageSelectedFailed();
        }
    }

    @Override
    public void fire_pressed() {
        super.fire_pressed();
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        scrollbarModel.notifyAdjustmentListener(1);
    }

    @Override
    public void fire_released() {
        super.fire_released();
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        scrollbarModel.notifyAdjustmentListener(2);
    }

    @Override
    public void fire_cancelled() {
        this.stopTimer();
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        scrollbarModel.setPositionOnScrollbarButton(0, 0);
        this.valueRequested = 128;
        super.fire_cancelled();
    }

    @Override
    public void fire_valueChanged() {
        ScrollbarModel scrollbarModel = (ScrollbarModel)this.getWidget();
        if (this.controllerValueHelper != this.valueRequested) {
            this.fireIntegerEvent("valueChanged", this.controllerValueHelper);
            this.valueRequested = this.controllerValueHelper;
            scrollbarModel.set_value(this.controllerValueHelper);
        }
    }

    @Override
    public void fire_nextPageSelectedFailed() {
        this.fireHMIEvent("nextPageSelectedFailed");
    }

    @Override
    public void fire_nextPageSelected() {
        this.fireHMIEvent("nextPageSelected");
    }

    @Override
    public void fire_previousPageSelectedFailed() {
        this.fireHMIEvent("previousPageSelectedFailed");
    }

    @Override
    public void fire_previousPageSelected() {
        this.fireHMIEvent("previousPageSelected");
    }

    @Override
    public void fire_lastPageSelectedFailed() {
        this.fireHMIEvent("lastPageSelectedFailed");
    }

    @Override
    public void fire_lastPageSelected() {
        this.fireHMIEvent("lastPageSelected");
    }

    @Override
    public void fire_firstPageSelectedFailed() {
        this.fireHMIEvent("firstPageSelectedFailed");
    }

    @Override
    public void fire_firstPageSelected() {
        this.fireHMIEvent("firstPageSelected");
    }

    @Override
    public void fire_onlyOnePageAvailable() {
        this.fireHMIEvent("onlyOnePageAvailable");
    }
}

