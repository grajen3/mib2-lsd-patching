/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.PreviewLine;

class PreviewLine$ResizeBackgroundAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private Rectangle boundsDest;
    private Rectangle boundsSource;
    private int compositeBackgroundMode;
    private final /* synthetic */ PreviewLine this$0;

    public PreviewLine$ResizeBackgroundAnimation(PreviewLine previewLine) {
        this.this$0 = previewLine;
        super(previewLine, null);
        this.setStartValue(0.0f);
        this.setDeltaValue(1.0f);
    }

    public void setAnimationParams(EasingParams easingParams, Rectangle rectangle, int n) {
        super.setEasingParams(easingParams);
        this.boundsDest = new Rectangle(rectangle);
        this.boundsSource = new Rectangle(this.this$0.getBackgroundArea());
        this.compositeBackgroundMode = n;
    }

    @Override
    public final void animate(float f2, long l, long l2) {
        int n = Math.round((float)this.boundsSource.x + (float)(this.boundsDest.x - this.boundsSource.x) * f2);
        int n2 = Math.round((float)this.boundsSource.y + (float)(this.boundsDest.y - this.boundsSource.y) * f2);
        int n3 = Math.round((float)this.boundsSource.width + (float)(this.boundsDest.width - this.boundsSource.width) * f2);
        int n4 = Math.round((float)this.boundsSource.height + (float)(this.boundsDest.height - this.boundsSource.height) * f2);
        this.this$0.getBackgroundArea().setBounds(n, n2, n3, n4);
        this.this$0.calculateArrowPosition();
    }

    @Override
    public void start(long l) {
        super.start(l);
        this.this$0.set_compositeBackgroundMode(1);
    }

    @Override
    public void stop() {
        super.stop();
        this.this$0.calculateBackground();
        this.this$0.set_compositeBackgroundMode(this.compositeBackgroundMode);
    }
}

