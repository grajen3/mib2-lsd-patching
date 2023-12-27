/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.PreviewLine;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.WidgetModel;

final class PreviewLine$ContentUpdateHandler
implements PropertyChangedListener {
    private int updateShadowCounter = 0;
    private final /* synthetic */ PreviewLine this$0;

    public PreviewLine$ContentUpdateHandler(PreviewLine previewLine) {
        this.this$0 = previewLine;
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        if (this.updateShadowCounter == 0 && (n == 5 || n == 8 || n == 9 || n == 10 || n == 11)) {
            if (widgetModel.is_visible()) {
                this.activateContent(widgetModel);
            }
            this.this$0.calculateBackgroundArea();
        }
    }

    public void disableUpdates() {
        ++this.updateShadowCounter;
    }

    public void enableUpdates() {
        --this.updateShadowCounter;
    }

    private void activateContent(WidgetModel widgetModel) {
        for (int i2 = 0; i2 < 3; ++i2) {
            if (widgetModel != this.this$0.getContentWidget(i2)) continue;
            this.this$0.showContent(i2);
        }
    }
}

