/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.WidgetList;
import de.vw.mib.widgets.internal.ServiceManager;

final class WidgetList$BrowsingAnimationDelayer
implements Runnable {
    private static final String TIMER_NAME;
    private static final int DELAY_TIMEOUT;
    private Timer delayTimer;
    private final WidgetList widgetList;
    private boolean animStarted;
    private boolean enableListSelectionFinally;
    private final /* synthetic */ WidgetList this$0;

    public WidgetList$BrowsingAnimationDelayer(WidgetList widgetList, WidgetList widgetList2) {
        this.this$0 = widgetList;
        this.widgetList = widgetList2;
        this.animStarted = false;
    }

    public void requestBrowsing() {
        this.animStarted = false;
        this.enableListSelectionFinally = AbstractList.isListSelectionEnabled();
        this.widgetList.resetBrowsingAnimation();
        this.widgetList.set_enabled(false);
        this.initDelayTimer();
        this.delayTimer.start();
        AbstractList.disableListSelection();
    }

    private void resetTimer() {
        if (this.delayTimer != null && this.delayTimer.isStarted()) {
            this.delayTimer.stop();
        }
    }

    private void initDelayTimer() {
        if (this.delayTimer == null) {
            this.delayTimer = ServiceManager.timerManager.createTimer("WidgetList.BrowsingAnimationDelayer.DelayTimer", 0, false, this, ServiceManager.eventDispatcher);
        }
    }

    public void executeBrowsing() {
        if (this.animStarted) {
            return;
        }
        this.resetTimer();
        this.animStarted = true;
        this.this$0.set_enabled(true);
        this.widgetList.startBrowsingAnimation(this.enableListSelectionFinally);
    }

    @Override
    public void run() {
        this.executeBrowsing();
    }
}

