/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.ReferenceWidget;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.WidgetModel;

final class ReferenceWidget$ViewActivationChangedListener
implements PropertyChangedListener {
    private final /* synthetic */ ReferenceWidget this$0;

    public ReferenceWidget$ViewActivationChangedListener(ReferenceWidget referenceWidget) {
        this.this$0 = referenceWidget;
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        if (n == 3) {
            this.this$0.forwardActivationState(widgetModel.is_activated());
        }
    }
}

