/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$ValueAccessor;

class AbstractWidget$2
implements AbstractWidget$ValueAccessor {
    private final /* synthetic */ AbstractWidget this$0;

    AbstractWidget$2(AbstractWidget abstractWidget) {
        this.this$0 = abstractWidget;
    }

    @Override
    public void valueChanged(float f2) {
        this.this$0.yChanged(Math.round(f2));
    }

    @Override
    public void setValue(float f2) {
        this.this$0.y = (short)Math.round(f2);
    }

    @Override
    public float getValue() {
        return this.this$0.y;
    }
}

