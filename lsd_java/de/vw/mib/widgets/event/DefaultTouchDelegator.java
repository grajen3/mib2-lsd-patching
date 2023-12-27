/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.event;

import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.DefaultTouchDelegator$TouchEventStub;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.event.TouchDelegatable;
import de.vw.mib.widgets.event.TouchDelegator;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;
import java.util.List;

public class DefaultTouchDelegator
implements TouchDelegator {
    private static final TouchEvent CANCEL_EVENT = new DefaultTouchDelegator$TouchEventStub(11, 0, 0);
    private static final int TOPMOST_ACTIVE_WIDGET;
    private List utilizedWidgets;
    private List activeWidgets;
    private TouchDelegatable touchDelegatable;
    private OutEventListener eventListener;

    public DefaultTouchDelegator(TouchDelegatable touchDelegatable, OutEventListener outEventListener) {
        this.touchDelegatable = touchDelegatable;
        this.eventListener = outEventListener;
        this.utilizedWidgets = new ArrayList();
        this.activeWidgets = new ArrayList();
    }

    public OutEventListener getEventListener() {
        return this.eventListener;
    }

    public void setEventListener(OutEventListener outEventListener) {
        this.eventListener = outEventListener;
    }

    @Override
    public WidgetModel getUtilizedWidget() {
        WidgetModel widgetModel = null;
        if (this.utilizedWidgets != null && this.utilizedWidgets.size() > 0) {
            widgetModel = (WidgetModel)this.utilizedWidgets.get(0);
        }
        return widgetModel;
    }

    @Override
    public final boolean forwardTouchEvent(TouchEvent touchEvent) {
        boolean bl = false;
        switch (touchEvent.getType()) {
            case 1: 
            case 6: {
                if (this.utilizedWidgets.isEmpty()) {
                    bl = this.forwardTouchEventInitially(touchEvent);
                    break;
                }
                bl = this.forwardTouchEventNormally(touchEvent);
                break;
            }
            case 0: 
            case 2: 
            case 11: {
                bl = this.forwardTouchEventFinally(touchEvent);
                break;
            }
            default: {
                bl = this.forwardTouchEventNormally(touchEvent);
            }
        }
        return bl;
    }

    public void cancelTouchInteraction() {
        this.cancelUtilizedWidgets();
        this.resetUtilizedWidgets();
    }

    protected boolean forwardTouchEventInitially(TouchEvent touchEvent) {
        this.resetActiveWidgets();
        this.resetUtilizedWidgets();
        this.touchDelegatable.findActiveWidgets(this.activeWidgets, touchEvent);
        int n = this.activeWidgets.size();
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = true;
        block5: for (int i2 = 0; i2 < n && bl3; ++i2) {
            WidgetModel widgetModel = (WidgetModel)this.activeWidgets.get(i2);
            WidgetController widgetController = widgetModel.getController();
            this.addUtilizedWidget(widgetModel);
            bl = this.forwardTouchEvent(widgetModel, touchEvent);
            bl2 |= bl;
            if (!bl) {
                this.removeUtilizedWidget(widgetModel);
            }
            switch (widgetController.getTouchForwardingMode()) {
                case 1: 
                case 3: {
                    bl3 = true;
                    continue block5;
                }
                case 2: {
                    bl3 = false;
                    continue block5;
                }
                case 0: {
                    bl3 = !bl;
                    continue block5;
                }
            }
            bl3 = false;
        }
        return bl2;
    }

    protected boolean forwardTouchEventNormally(TouchEvent touchEvent) {
        boolean bl = false;
        boolean bl2 = false;
        if (!this.utilizedWidgets.isEmpty()) {
            for (int i2 = this.utilizedWidgets.size() - 1; i2 >= 0; --i2) {
                WidgetModel widgetModel = (WidgetModel)this.utilizedWidgets.get(i2);
                WidgetController widgetController = widgetModel.getController();
                bl = this.forwardTouchEvent(widgetModel, touchEvent);
                bl2 |= bl;
                if (!bl || widgetController.getTouchForwardingMode() == 1) continue;
                this.removeUtilizedWidgetResidual(widgetModel);
                break;
            }
        }
        return bl2;
    }

    protected boolean forwardTouchEventFinally(TouchEvent touchEvent) {
        boolean bl = false;
        boolean bl2 = false;
        if (!this.utilizedWidgets.isEmpty()) {
            for (int i2 = this.utilizedWidgets.size() - 1; i2 >= 0; --i2) {
                WidgetModel widgetModel = (WidgetModel)this.utilizedWidgets.get(i2);
                WidgetController widgetController = widgetModel.getController();
                bl = this.forwardTouchEvent(widgetModel, touchEvent);
                bl2 |= bl;
                if (bl && widgetController.getTouchForwardingMode() != 1) {
                    this.removeUtilizedWidgetResidual(widgetModel);
                    this.removeUtilizedWidget(widgetModel);
                    break;
                }
                this.removeUtilizedWidget(widgetModel);
            }
        }
        return bl2;
    }

    private boolean forwardTouchEvent(WidgetModel widgetModel, TouchEvent touchEvent) {
        this.touchDelegatable.onTouchEventForward(touchEvent, widgetModel);
        return this.touchDelegatable.onTouchEventForwarded(touchEvent, widgetModel, widgetModel.consumeTouchEvent(touchEvent));
    }

    private void addUtilizedWidget(WidgetModel widgetModel) {
        this.utilizedWidgets.add(widgetModel);
        WidgetController widgetController = widgetModel.getController();
        if (this.eventListener != null && widgetController != null) {
            widgetModel.getController().addOutEventListener(this.eventListener);
        }
    }

    private void removeUtilizedWidget(WidgetModel widgetModel) {
        this.utilizedWidgets.remove(widgetModel);
        WidgetController widgetController = widgetModel.getController();
        if (this.eventListener != null && widgetController != null) {
            widgetController.removeOutEventListener(this.eventListener);
        }
    }

    private void removeUtilizedWidgetResidual(WidgetModel widgetModel) {
        for (int i2 = this.utilizedWidgets.size() - 1; i2 >= 0; --i2) {
            WidgetModel widgetModel2 = (WidgetModel)this.utilizedWidgets.get(i2);
            WidgetController widgetController = widgetModel2.getController();
            if (widgetModel2 == widgetModel || widgetController.getTouchForwardingMode() == 1) continue;
            this.forwardTouchEvent(widgetModel2, CANCEL_EVENT);
            this.removeUtilizedWidget(widgetModel2);
        }
    }

    private void resetUtilizedWidgets() {
        this.utilizedWidgets.clear();
    }

    private void cancelUtilizedWidgets() {
        for (int i2 = this.utilizedWidgets.size() - 1; i2 >= 0; --i2) {
            WidgetModel widgetModel = (WidgetModel)this.utilizedWidgets.get(i2);
            widgetModel.consumeTouchEvent(CANCEL_EVENT);
        }
    }

    private void resetActiveWidgets() {
        this.activeWidgets.clear();
    }
}

