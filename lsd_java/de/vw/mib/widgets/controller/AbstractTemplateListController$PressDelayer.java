/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.controller.AbstractTemplateListController;
import de.vw.mib.widgets.controller.AbstractTemplateListController$ListTouchEvent;
import de.vw.mib.widgets.internal.ServiceManager;

final class AbstractTemplateListController$PressDelayer
implements Runnable {
    private static final String TIMER_NAME;
    private final AbstractTemplateListController controller;
    private final AbstractTemplateListController$ListTouchEvent pressEvent = new AbstractTemplateListController$ListTouchEvent(1);
    private Timer delayTimer;
    private boolean pressDelayed = false;

    public AbstractTemplateListController$PressDelayer(AbstractTemplateListController abstractTemplateListController) {
        this.controller = abstractTemplateListController;
    }

    private Timer getDelayTimer() {
        if (this.delayTimer == null) {
            this.delayTimer = ServiceManager.timerManager.createTimer("AbstractTemplateListController.PressDelayer", 0L, false, this, ServiceManager.eventDispatcher);
        }
        return this.delayTimer;
    }

    public void sendDelayedPress(int n, int n2, int n3) {
        this.pressDelayed = true;
        this.pressEvent.setCoordinates(n2, n3);
        this.getDelayTimer().setDelay(n);
        if (n > 0 && this.controller.isDelayedForwardingAllowed(this.pressEvent)) {
            this.getDelayTimer().start();
        } else {
            this.sendImmediately();
        }
    }

    public void abortSend() {
        this.pressDelayed = false;
        this.getDelayTimer().stop();
    }

    public boolean isPressDelayed() {
        return this.pressDelayed;
    }

    public void sendImmediately() {
        this.getDelayTimer().stop();
        this.sendEvent();
    }

    private void sendEvent() {
        if (this.pressDelayed) {
            this.pressDelayed = false;
            this.controller.forwardTouchEventToListItem(this.pressEvent);
        }
    }

    @Override
    public void run() {
        this.sendEvent();
    }
}

