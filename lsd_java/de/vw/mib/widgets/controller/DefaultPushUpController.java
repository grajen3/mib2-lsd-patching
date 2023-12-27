/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.Event;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.DefaultPushUpController$ButtonEventHandler;
import de.vw.mib.widgets.controller.PushUpController;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.DefaultTouchDelegator;
import de.vw.mib.widgets.event.TouchDelegatable;
import de.vw.mib.widgets.event.TouchDelegator;
import de.vw.mib.widgets.interfaces.PushUpHandler;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public final class DefaultPushUpController
extends AbstractWidgetController
implements PushUpController,
TouchDelegatable {
    private DefaultPushUpController$ButtonEventHandler buttonEventHandler;
    private TouchDelegator touchDelegator;

    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
        this.buttonEventHandler = new DefaultPushUpController$ButtonEventHandler(this);
        this.touchDelegator = new DefaultTouchDelegator(this, this.buttonEventHandler);
    }

    @Override
    public void deInit() {
        this.buttonEventHandler = null;
        this.touchDelegator = null;
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        this.registerSelfAsOutEventFiredListener(((ContainerModel)this.getWidget()).getChildren());
    }

    @Override
    public void deActivate() {
        super.deActivate();
        this.removeSelfAsOutEventFiredListener(((ContainerModel)this.getWidget()).getChildren());
    }

    @Override
    public int getTouchForwardingMode() {
        return 2;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        if ("open" == string) {
            return this.fire_open();
        }
        if ("close" == string) {
            return this.fire_close();
        }
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        this.touchDelegator.forwardTouchEvent(touchEvent);
        return true;
    }

    private void registerSelfAsOutEventFiredListener(WidgetModel[] widgetModelArray) {
        if (widgetModelArray != null) {
            for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
                if (widgetModelArray[i2].getController() == null) continue;
                widgetModelArray[i2].getController().addOutEventListener(this.buttonEventHandler);
            }
        }
    }

    private void removeSelfAsOutEventFiredListener(WidgetModel[] widgetModelArray) {
        if (widgetModelArray != null) {
            for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
                if (widgetModelArray[i2].getController() == null) continue;
                widgetModelArray[i2].getController().removeOutEventListener(this.buttonEventHandler);
            }
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
    public boolean fire_open() {
        PushUpHandler pushUpHandler;
        PushUpModel pushUpModel = (PushUpModel)this.getWidget();
        boolean bl = false;
        if (null != pushUpModel && pushUpModel.is_enabled() && null != (pushUpHandler = pushUpModel.getPushUpHandler())) {
            pushUpHandler.open(pushUpModel);
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean fire_close() {
        PushUpHandler pushUpHandler;
        PushUpModel pushUpModel = (PushUpModel)this.getWidget();
        boolean bl = false;
        if (null != pushUpModel && pushUpModel.is_visible() && pushUpModel.is_enabled() && null != (pushUpHandler = pushUpModel.getPushUpHandler())) {
            pushUpHandler.close(pushUpModel);
            bl = true;
        }
        return bl;
    }

    public void outEventFired(WidgetController widgetController, String string, Event event) {
    }
}

