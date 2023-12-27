/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.PushUp;

class PushUp$ResizeAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private Rectangle small;
    private Rectangle large;
    private boolean animatedResizeActive;
    private final /* synthetic */ PushUp this$0;

    public PushUp$ResizeAnimation(PushUp pushUp) {
        this.this$0 = pushUp;
        super(pushUp, null);
        this.animatedResizeActive = false;
    }

    public void setAnimationParams(EasingParams easingParams, Rectangle rectangle, Rectangle rectangle2, boolean bl) {
        super.setEasingParams(easingParams);
        if (bl) {
            this.setStartValue(1.0f);
            this.setDeltaValue(32959);
        } else {
            this.setStartValue(0.0f);
            this.setDeltaValue(1.0f);
        }
        this.small = rectangle;
        this.large = rectangle2;
    }

    private void updateSize(float f2) {
        this.this$0.disableAnimations();
        this.animatedResizeActive = true;
        this.this$0.set_x(this.small.x + Math.round((float)(this.large.x - this.small.x) * f2));
        this.this$0.set_y(this.small.y + Math.round((float)(this.large.y - this.small.y) * f2));
        this.this$0.set_width(this.small.width + Math.round((float)(this.large.width - this.small.width) * f2));
        this.this$0.set_height(this.small.height + Math.round((float)(this.large.height - this.small.height) * f2));
        this.animatedResizeActive = false;
        this.this$0.enableAnimations();
        this.this$0.repaint();
    }

    protected final boolean isAnimatedResizeActive() {
        return this.animatedResizeActive;
    }

    @Override
    public final void animate(float f2, long l, long l2) {
        this.updateSize(f2);
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.disableAnimations();
        this.this$0.set_x(this.large.x);
        this.this$0.set_y(this.large.y);
        this.this$0.set_width(this.large.width);
        this.this$0.set_height(this.large.height);
        this.this$0.enableAnimations();
    }
}

