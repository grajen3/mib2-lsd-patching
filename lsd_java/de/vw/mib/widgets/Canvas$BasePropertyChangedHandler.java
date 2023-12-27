/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.Canvas;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.WidgetModel;

final class Canvas$BasePropertyChangedHandler
implements PropertyChangedListener {
    private final /* synthetic */ Canvas this$0;

    public Canvas$BasePropertyChangedHandler(Canvas canvas) {
        this.this$0 = canvas;
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        if (n == 8 || n == 9) {
            this.this$0.invalidateDisplayable();
        } else if (n == 5 && this.this$0.isVisibleRelevant(widgetModel)) {
            this.this$0.validateVisibility();
        }
    }
}

