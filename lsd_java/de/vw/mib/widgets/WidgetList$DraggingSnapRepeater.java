/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.WidgetList;
import de.vw.mib.widgets.internal.ServiceManager;

final class WidgetList$DraggingSnapRepeater
implements Runnable {
    private static final String TIMER_NAME;
    private static final int DURATION_MIN_REPEAT;
    private Timer repeatTimer;
    private final /* synthetic */ WidgetList this$0;

    public WidgetList$DraggingSnapRepeater(WidgetList widgetList) {
        this.this$0 = widgetList;
    }

    public void start() {
        if (this.repeatTimer == null) {
            this.initRepeatTimer();
        }
        this.repeatTimer.start();
    }

    public void stop() {
        if (this.repeatTimer != null) {
            this.repeatTimer.stop();
        }
    }

    private void initRepeatTimer() {
        EasingParams[] easingParamsArray = this.this$0.get_easing();
        int n = easingParamsArray != null && easingParamsArray.length > 7 ? easingParamsArray[7].getDuration() : 0;
        this.repeatTimer = ServiceManager.timerManager.createTimer("WidgetList.DraggingSnapRepeater.DelayTimer", Math.max(300, n), true, this, ServiceManager.eventDispatcher);
    }

    @Override
    public void run() {
        int n = this.this$0.getFirstMostlyVisibleIndex();
        int n2 = this.this$0.getLastMostlyVisibleIndex();
        if (this.this$0.isVertical()) {
            if (this.this$0.dragPosition.y < 0 && n > 0) {
                this.this$0.snap(n - 1, 0);
            } else if (this.this$0.dragPosition.y + this.this$0.getItemHeight(this.this$0.getDragIndex()) > this.this$0.get_height() && n2 < this.this$0.get_itemCount() - 1) {
                this.this$0.snap(n2 + 1, 1);
            }
        } else if (this.this$0.dragPosition.x < 0 && n > 0) {
            this.this$0.snap(n - 1, 0);
        } else if (this.this$0.dragPosition.x + this.this$0.getItemWidth(this.this$0.getDragIndex()) > this.this$0.get_width() && n2 < this.this$0.get_itemCount() - 1) {
            this.this$0.snap(n2 + 1, 1);
        }
        this.this$0.moveItem();
    }
}

