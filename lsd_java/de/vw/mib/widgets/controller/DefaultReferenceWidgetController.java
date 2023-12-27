/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.ReferenceWidget;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.event.DefaultTouchDelegator;
import de.vw.mib.widgets.event.TouchDelegatable;
import de.vw.mib.widgets.event.TouchDelegator;
import de.vw.mib.widgets.models.ReferenceWidgetModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public final class DefaultReferenceWidgetController
extends AbstractWidgetController
implements TouchDelegatable {
    private TouchDelegator touchDelegator;

    @Override
    public void init() {
        super.init();
        this.touchDelegator = new DefaultTouchDelegator(this, null);
    }

    @Override
    public void deInit() {
        this.touchDelegator = null;
        super.deInit();
    }

    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        return ((ReferenceWidget)this.getWidget()).getReferencedWidget().getView().consumeHMIEvent(hMIEvent, string);
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        ReferenceWidgetModel referenceWidgetModel = (ReferenceWidgetModel)this.getWidget();
        WidgetModel widgetModel = referenceWidgetModel.getReferencedWidget();
        int n = touchEvent.getX();
        int n2 = touchEvent.getY();
        boolean bl = false;
        if (widgetModel != null) {
            touchEvent.setCoordinates(n - referenceWidgetModel.getAbsX() + widgetModel.getAbsX(), n2 - referenceWidgetModel.getAbsY() + widgetModel.getAbsY());
        }
        bl = this.touchDelegator.forwardTouchEvent(touchEvent);
        if (widgetModel != null) {
            touchEvent.setCoordinates(n, n2);
        }
        return bl;
    }

    @Override
    public void findActiveWidgets(List list, TouchEvent touchEvent) {
        ReferenceWidgetModel referenceWidgetModel = (ReferenceWidgetModel)this.getWidget();
        WidgetModel widgetModel = referenceWidgetModel.getReferencedWidget();
        if (widgetModel == null) {
            referenceWidgetModel.findTouchEventConsumingWidgets(list, touchEvent);
        } else {
            widgetModel.findTouchEventConsumingWidgets(list, touchEvent);
        }
    }

    @Override
    public void onTouchEventForward(TouchEvent touchEvent, WidgetModel widgetModel) {
    }

    @Override
    public boolean onTouchEventForwarded(TouchEvent touchEvent, WidgetModel widgetModel, boolean bl) {
        return bl;
    }
}

