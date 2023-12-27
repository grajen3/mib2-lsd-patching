/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.AbstractWidget$WidgetInternalAnimation;
import de.vw.mib.widgets.WidgetList;

final class WidgetList$BrowsingAnimation
extends AbstractWidget$WidgetInternalAnimation {
    private int browsingPositionPrevContext;
    private int browsingPositionNextContext;
    private final WidgetList widgetList;
    private int offsetNextContext;
    boolean enabledSelectionFinally;
    private final /* synthetic */ WidgetList this$0;

    public WidgetList$BrowsingAnimation(WidgetList widgetList, WidgetList widgetList2) {
        this.this$0 = widgetList;
        super(widgetList, new EasingParams());
        this.widgetList = widgetList2;
    }

    public void reset() {
        this.browsingPositionPrevContext = 0;
        this.browsingPositionNextContext = this.offsetNextContext;
    }

    public void setAnimationParams(EasingParams easingParams, int n, int n2, boolean bl) {
        this.setEasingParams(easingParams);
        this.setStartValue(0.0f);
        this.enabledSelectionFinally = bl;
        if (n == 1) {
            this.offsetNextContext = n2;
            this.setDeltaValue(-n2);
        } else {
            this.offsetNextContext = -n2;
            this.setDeltaValue(n2);
        }
    }

    @Override
    public void animate(float f2, long l, long l2) {
        this.browsingPositionPrevContext = Math.round(f2);
        this.browsingPositionNextContext = Math.round((float)this.offsetNextContext + f2);
        this.this$0.repaint();
    }

    @Override
    public void start(long l) {
        super.start(l);
        this.this$0.set_enabled(false);
    }

    @Override
    public void stop() {
        super.stop();
        this.widgetList.setBrowsingTextureDrawingEnabled(false);
        if (this.enabledSelectionFinally) {
            AbstractList.enableListSelection();
        }
        this.this$0.set_enabled(true);
    }

    public int getBrowsingPositionPrevContext() {
        return this.browsingPositionPrevContext;
    }

    public int getBrowsingPositionNextContext() {
        return this.browsingPositionNextContext;
    }
}

