/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.SequencedImage;

final class SequencedImage$ImageFadeAnimation
extends AbstractWidget$WidgetInternalAnimation {
    final int imageIndex;
    final float endValue;
    private final /* synthetic */ SequencedImage this$0;

    public SequencedImage$ImageFadeAnimation(SequencedImage sequencedImage, EasingParams easingParams, int n, float f2, float f3) {
        this.this$0 = sequencedImage;
        super(sequencedImage, easingParams, f2, f3 - f2);
        this.imageIndex = n;
        this.endValue = f3;
        this.setAnimationInterval(Math.max(easingParams.getDuration() / 30, 125));
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.updateAlphaForIndex(this.imageIndex, f2, true);
        if (AbstractWidget.LOGGER.isTraceEnabled(8192)) {
            LogMessage logMessage = AbstractWidget.LOGGER.trace(8192);
            logMessage.append(this.this$0.getQualifiedName()).append(" crossfadeAnimation step {currentTime=").append(l).append(" currentValue=").append(f2).append(" deltaTime=").append(l2).append("}").log();
        }
    }

    @Override
    public void stop() {
        this.this$0.updateAlphaForIndex(this.imageIndex, this.endValue, true);
        super.stop();
    }
}

