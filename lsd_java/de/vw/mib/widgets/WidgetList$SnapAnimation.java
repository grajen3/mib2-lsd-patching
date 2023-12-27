/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.WidgetList;

final class WidgetList$SnapAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private int startX;
    private int startY;
    private int deltaX;
    private int deltaY;
    private int destX;
    private int destY;
    private boolean adjustmentNotification;
    private boolean pageNotification;
    private boolean stoppableByUser;
    private final /* synthetic */ WidgetList this$0;

    public WidgetList$SnapAnimation(WidgetList widgetList) {
        this.this$0 = widgetList;
        super(widgetList, new EasingParams());
    }

    public void setAnimationParams(EasingParams easingParams, int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        this.setEasingParams(easingParams);
        this.setStartValue(0.0f);
        this.setDeltaValue(1.0f);
        Rectangle rectangle = this.this$0.getViewport();
        this.startX = rectangle.x;
        this.startY = rectangle.y;
        this.destX = n;
        this.destY = n2;
        this.deltaX = this.destX - this.startX;
        this.deltaY = this.destY - this.startY;
        this.adjustmentNotification = bl;
        this.pageNotification = true;
        this.stoppableByUser = bl3;
    }

    public void disablePageNotification() {
        this.pageNotification = false;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        if (!this.adjustmentNotification) {
            this.this$0.disableAdjustmentChanged();
        }
        int n = Math.round((float)this.startX + f2 * (float)this.deltaX);
        int n2 = Math.round((float)this.startY + f2 * (float)this.deltaY);
        this.this$0.setViewportPosition(n, n2);
        if (!this.adjustmentNotification) {
            this.this$0.enableAdjustmentChanged();
        }
        if (this.destX == n && this.destY == n2) {
            this.this$0.stopInternalAnimation(this);
        }
        this.this$0.repaint();
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.invalidateList(10752);
        this.this$0.notifyAdjustmentListeners();
        if (this.pageNotification) {
            this.this$0.notifyPageChanged();
        }
    }

    public boolean isStoppableByUser() {
        return this.stoppableByUser;
    }

    public boolean isForwardDirection() {
        return this.deltaX > 0 || this.deltaY > 0;
    }

    public int getDestX() {
        return this.destX;
    }

    public int getDestY() {
        return this.destY;
    }
}

