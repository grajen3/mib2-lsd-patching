/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.PopupViewModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.ViewUI;
import de.vw.mib.widgets.ui.util.BackgroundCompositor;

public final class PopupViewUI
extends ViewUI
implements PropertyChangedListener {
    private BackgroundCompositor backgroundCompositor;

    @Override
    public void init() {
        super.init();
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.addPropertyChangedListener(this);
        }
    }

    @Override
    public void deInit() {
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.removePropertyChangedListener(this);
        }
        if (this.backgroundCompositor != null) {
            this.backgroundCompositor.dispose();
            this.backgroundCompositor = null;
        }
        super.deInit();
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, ContainerModel containerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        if ((viewModel.isInvalid() || this.backgroundCompositor == null) && this.backgroundCompositor == null) {
            this.backgroundCompositor = new BackgroundCompositor();
        }
        this.backgroundCompositor.paintCompositeBackground(graphics3D, (PopupViewModel)containerModel, rectangle, rectangle2, f2);
        super.paintContent(graphics3D, viewModel, containerModel, rectangle, rectangle2, f2);
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 51: {
                if (this.backgroundCompositor != null) {
                    this.backgroundCompositor.dispose();
                    this.backgroundCompositor = null;
                }
                this.backgroundCompositor = new BackgroundCompositor();
                break;
            }
        }
    }
}

