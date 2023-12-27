/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.BackgroundContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.ContainerUI;
import de.vw.mib.widgets.ui.util.BackgroundCompositor;

public abstract class AbstractBackgroundContainerUI
extends ContainerUI
implements PropertyChangedListener {
    private BackgroundCompositor backgroundCompositor;

    protected AbstractBackgroundContainerUI() {
    }

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
        this.disposeBackgroundCompositor();
        super.deInit();
    }

    protected final void disposeBackgroundCompositor() {
        if (this.backgroundCompositor != null) {
            this.backgroundCompositor.dispose();
            this.backgroundCompositor = null;
        }
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        BackgroundContainerModel backgroundContainerModel = (BackgroundContainerModel)widgetModel;
        this.paintCompositeBackground(graphics3D, backgroundContainerModel, rectangle, rectangle2, f2);
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2 * backgroundContainerModel.getBackgroundAlpha() * backgroundContainerModel.getContentAlpha());
    }

    protected final void paintCompositeBackground(Graphics3D graphics3D, BackgroundContainerModel backgroundContainerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        if ((backgroundContainerModel.isInvalid() || this.backgroundCompositor == null) && this.backgroundCompositor == null) {
            this.backgroundCompositor = new BackgroundCompositor();
        }
        this.backgroundCompositor.paintCompositeBackground(graphics3D, backgroundContainerModel, rectangle, rectangle2, f2 * backgroundContainerModel.getBackgroundAlpha());
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 23: {
                this.disposeBackgroundCompositor();
                break;
            }
        }
    }
}

