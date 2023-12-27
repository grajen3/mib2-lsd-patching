/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.Iris;

final class Iris$ChangeActiveSegmentAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final int newActiveSegment;
    private final /* synthetic */ Iris this$0;

    public Iris$ChangeActiveSegmentAnimation(Iris iris, EasingParams easingParams, float f2, float f3, int n) {
        this.this$0 = iris;
        super(iris, easingParams, f2, f3 - f2);
        this.newActiveSegment = n;
        this.setAnimationInterval(83);
    }

    public int getNewActiveSegment() {
        return this.newActiveSegment;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.this$0.updateScaledActiveSegmentSize(Math.round(f2));
        this.this$0.setActiveSegmentInvalid(true);
        this.this$0.repaint();
    }

    @Override
    public void stop() {
        super.stop();
        if (this.newActiveSegment != this.this$0.get_activeSegment()) {
            this.this$0.disableAnimations();
            this.this$0.set_activeSegment(this.newActiveSegment);
            this.this$0.enableAnimations();
            if (AbstractWidget.LOGGER.isTraceEnabled(128)) {
                AbstractWidget.LOGGER.trace(128).append("Iris '").append(this.this$0.getQualifiedName()).append("': ChangeSegmentAnimation - part one stopped").log();
            }
            this.this$0.startChangeActiveSegmentAnimationPartTwo(this.newActiveSegment);
        } else if (AbstractWidget.LOGGER.isTraceEnabled(128)) {
            AbstractWidget.LOGGER.trace(128).append("Iris '").append(this.this$0.getQualifiedName()).append("': ChangeSegmentAnimation - part two stopped").log();
        }
    }
}

