/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.WindowWidgetController;
import de.vw.mib.widgets.event.DefaultTouchDelegator;
import de.vw.mib.widgets.event.TouchDelegatable;
import de.vw.mib.widgets.event.TouchDelegator;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.models.WindowWidgetModel;
import java.util.List;

public final class DefaultWindowWidgetController
extends AbstractWidgetController
implements TouchDelegatable,
WindowWidgetController {
    private int tempHeight;
    protected int X;
    protected int Y;
    protected int touchedX;
    protected int touchedY;
    private TouchDelegator touchDelegator;

    @Override
    protected void reset() {
        super.reset();
        this.X = -1;
        this.Y = -1;
        this.touchedX = -1;
        this.touchedY = -1;
    }

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
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        if ("collapse" == string) {
            this.fire_collapse();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        WindowWidgetModel windowWidgetModel = (WindowWidgetModel)this.getWidget();
        boolean bl = false;
        this.touchDelegator.forwardTouchEvent(touchEvent);
        switch (touchEvent.getType()) {
            case 1: {
                this.touchedX = touchEvent.getX() - windowWidgetModel.get_x();
                this.touchedY = touchEvent.getY() - windowWidgetModel.get_y();
                break;
            }
            case 3: 
            case 4: {
                this.X = touchEvent.getX();
                this.Y = touchEvent.getY();
                this.fire_drag();
                bl = true;
                break;
            }
        }
        return bl;
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
    public void fire_collapse() {
        WindowWidgetModel windowWidgetModel = (WindowWidgetModel)this.getWidget();
        if (null != windowWidgetModel && windowWidgetModel.is_enabled()) {
            if (!windowWidgetModel.is_windowCollapse()) {
                this.tempHeight = windowWidgetModel.get_height();
                windowWidgetModel.set_height(windowWidgetModel.get_headlineHeight());
                windowWidgetModel.set_windowCollapse(true);
            } else {
                windowWidgetModel.set_height(this.tempHeight);
                windowWidgetModel.set_windowCollapse(false);
            }
        }
    }

    public void fire_drag() {
        WindowWidgetModel windowWidgetModel = (WindowWidgetModel)this.getWidget();
        WidgetModel widgetModel = windowWidgetModel.getParent();
        int n = this.X - this.touchedX;
        int n2 = this.Y - this.touchedY;
        if (n >= 0 && n + windowWidgetModel.get_width() <= widgetModel.get_width()) {
            windowWidgetModel.set_x(n);
        }
        if (n2 >= 0 && n2 + windowWidgetModel.get_height() <= widgetModel.get_height()) {
            windowWidgetModel.set_y(n2);
        }
    }
}

