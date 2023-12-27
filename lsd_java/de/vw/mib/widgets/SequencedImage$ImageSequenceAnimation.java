/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.SequencedImage;

final class SequencedImage$ImageSequenceAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final int maxAnimationValue;
    private final /* synthetic */ SequencedImage this$0;

    public SequencedImage$ImageSequenceAnimation(SequencedImage sequencedImage, EasingParams easingParams, int n, int n2, boolean bl) {
        this.this$0 = sequencedImage;
        super(sequencedImage, easingParams, n, (float)(n2 - n) + 1.0f);
        this.maxAnimationValue = n2;
        this.setLooped(bl);
        this.setAnimationInterval(Math.max(easingParams.getDuration() / Math.abs(n2 - n + 1), 125));
    }

    @Override
    public void animate(float f2, long l, long l2) {
        int n = Math.min((int)Math.floor(f2), this.maxAnimationValue);
        this.this$0.setActiveImageIndex(n, true);
        if (AbstractWidget.LOGGER.isTraceEnabled(8192)) {
            LogMessage logMessage = AbstractWidget.LOGGER.trace(8192);
            logMessage.append(this.this$0.getQualifiedName()).append(" sequence animation step {currentTime=").append(l).append(" currentValue=").append(f2).append(" deltaTime=").append(l2).append(" index=").append(n).append("}").log();
        }
    }
}

