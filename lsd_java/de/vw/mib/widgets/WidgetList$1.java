/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget$ValueAccessor;
import de.vw.mib.widgets.WidgetList;

class WidgetList$1
implements AbstractWidget$ValueAccessor {
    private final /* synthetic */ WidgetList this$0;

    WidgetList$1(WidgetList widgetList) {
        this.this$0 = widgetList;
    }

    @Override
    public void valueChanged(float f2) {
        this.this$0.repaint();
    }

    @Override
    public void setValue(float f2) {
        this.this$0.proximityAnimationValue = f2;
    }

    @Override
    public float getValue() {
        return this.this$0.proximityAnimationValue;
    }
}

