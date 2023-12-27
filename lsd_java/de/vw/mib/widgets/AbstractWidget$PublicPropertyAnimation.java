/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$PropertyAnimation;
import de.vw.mib.widgets.AbstractWidget$ValueAccessor;

public final class AbstractWidget$PublicPropertyAnimation
extends AbstractWidget$PropertyAnimation {
    private final int pid;
    private final /* synthetic */ AbstractWidget this$0;

    public AbstractWidget$PublicPropertyAnimation(AbstractWidget abstractWidget, int n, int n2, AbstractWidget$ValueAccessor abstractWidget$ValueAccessor) {
        this.this$0 = abstractWidget;
        super(abstractWidget, n, abstractWidget$ValueAccessor);
        this.pid = n2;
    }

    @Override
    public void stop() {
        this.setValue(this.getStartValue() + this.getDeltaValue());
        super.stop();
        this.this$0.propertyChanged(this.pid);
    }
}

