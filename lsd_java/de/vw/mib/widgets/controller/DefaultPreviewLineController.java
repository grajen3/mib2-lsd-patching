/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Point;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.DefaultPreviewLineController$InactiveAreaClosedHandler;
import de.vw.mib.widgets.controller.PreviewLineController;
import de.vw.mib.widgets.event.DefaultTouchDelegator;
import de.vw.mib.widgets.event.TouchDelegatable;
import de.vw.mib.widgets.event.TouchDelegator;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.PreviewLineModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public final class DefaultPreviewLineController
extends AbstractWidgetController
implements PreviewLineController,
TouchDelegatable {
    DefaultPreviewLineController$InactiveAreaClosedHandler inactiveAreaClosedHandler;
    private TouchDelegator touchDelegator;

    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
        this.inactiveAreaClosedHandler = new DefaultPreviewLineController$InactiveAreaClosedHandler(this);
        this.touchDelegator = new DefaultTouchDelegator(this, null);
    }

    @Override
    public void deInit() {
        this.inactiveAreaClosedHandler = null;
        this.touchDelegator = null;
        super.deInit();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        if ("showHistory" == string) {
            this.fire_showHistory();
        } else if ("showPreview" == string) {
            this.fire_showPreview();
        } else if ("showResult" == string) {
            this.fire_showResult();
        }
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        PreviewLineModel previewLineModel = (PreviewLineModel)this.getWidget();
        Point point = new Point(touchEvent.getX() - previewLineModel.getAbsX(), touchEvent.getY() - previewLineModel.getAbsY());
        boolean bl = this.touchDelegator.forwardTouchEvent(touchEvent);
        return previewLineModel.getBackgroundArea().contains(point) || bl;
    }

    protected void showInactiveArea() {
        PreviewLineModel previewLineModel = (PreviewLineModel)this.getWidget();
        InactiveAreaModel inactiveAreaModel = previewLineModel.get_inactiveAreaRef();
        if (inactiveAreaModel != null && !inactiveAreaModel.is_visible()) {
            inactiveAreaModel.set_visible(true);
            this.inactiveAreaClosedHandler.setPreviewLineContent(previewLineModel.getActiveContent());
            inactiveAreaModel.getController().addOutEventListener(this.inactiveAreaClosedHandler);
        }
    }

    protected void hideInactiveArea() {
        PreviewLineModel previewLineModel = (PreviewLineModel)this.getWidget();
        InactiveAreaModel inactiveAreaModel = previewLineModel.get_inactiveAreaRef();
        if (inactiveAreaModel != null) {
            inactiveAreaModel.set_visible(false);
            inactiveAreaModel.getController().removeOutEventListener(this.inactiveAreaClosedHandler);
        }
    }

    @Override
    public void findActiveWidgets(List list, TouchEvent touchEvent) {
        this.getWidget().findTouchEventConsumingWidgets(list, touchEvent);
    }

    @Override
    public void onTouchEventForward(TouchEvent touchEvent, WidgetModel widgetModel) {
    }

    @Override
    public boolean onTouchEventForwarded(TouchEvent touchEvent, WidgetModel widgetModel, boolean bl) {
        return bl;
    }

    @Override
    public void fire_hideAll() {
        this.hideInactiveArea();
        PreviewLineModel previewLineModel = (PreviewLineModel)this.getWidget();
        previewLineModel.showContent(-1);
    }

    @Override
    public void fire_showHistory() {
        this.hideInactiveArea();
        PreviewLineModel previewLineModel = (PreviewLineModel)this.getWidget();
        previewLineModel.showContent(0);
    }

    @Override
    public void fire_showPreview() {
        this.hideInactiveArea();
        PreviewLineModel previewLineModel = (PreviewLineModel)this.getWidget();
        previewLineModel.showContent(1);
    }

    @Override
    public void fire_showResult() {
        this.showInactiveArea();
        PreviewLineModel previewLineModel = (PreviewLineModel)this.getWidget();
        previewLineModel.showContent(2);
    }
}

