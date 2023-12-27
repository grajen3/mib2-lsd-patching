/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractText;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;

final class AbstractText$ColorFadingAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private final AbstractText textArea;
    private final /* synthetic */ AbstractText this$0;

    public AbstractText$ColorFadingAnimation(AbstractText abstractText, EasingParams easingParams, AbstractText abstractText2, float f2, float f3) {
        this.this$0 = abstractText;
        super(abstractText, easingParams, f2, f3 - f2);
        this.textArea = abstractText2;
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.textArea.colorFadingProgress = f2;
    }
}

