/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.PreviewLine;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.WidgetModel;

final class PreviewLine$ListSizeChangedNotifier
implements PropertyChangedListener {
    private final /* synthetic */ PreviewLine this$0;

    public PreviewLine$ListSizeChangedNotifier(PreviewLine previewLine) {
        this.this$0 = previewLine;
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        if (this.this$0.getActiveContent() != 2) {
            if (this.this$0.is_visible() && this.this$0.areParentsVisible() && n == 31) {
                this.this$0.evaluateContent();
            }
        } else {
            this.this$0.calculateBackground();
        }
    }
}

