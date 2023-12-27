/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.SequencedImage;

final class SequencedImage$ImageValueChangeAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final /* synthetic */ SequencedImage this$0;

    public SequencedImage$ImageValueChangeAnimation(SequencedImage sequencedImage, EasingParams easingParams, boolean bl, int n, int n2) {
        this.this$0 = sequencedImage;
        super(sequencedImage, bl, easingParams);
        this.setStartValue(n);
        this.setDeltaValue(n2 - n);
        this.setAnimationInterval(Math.max(easingParams.getDuration() / (Math.abs(n2 - n) * 3), 125));
    }

    @Override
    public void animate(float f2, long l, long l2) {
        int n = Math.round(f2);
        this.this$0.setActiveImageIndex(n, true);
        if (AbstractWidget.LOGGER.isTraceEnabled(8192)) {
            LogMessage logMessage = AbstractWidget.LOGGER.trace(8192);
            logMessage.append(this.this$0.getQualifiedName()).append(" valueChangeAnimation step {currentTime=").append(l).append(" currentValue=").append(f2).append(" deltaTime=").append(l2).append(" index=").append(n).append("}").log();
        }
    }

    @Override
    public void stop() {
        super.stop();
    }
}

