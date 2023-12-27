/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.ThresholdNotifierController;
import de.vw.mib.widgets.models.ThresholdNotifierModel;
import de.vw.mib.widgets.models.WidgetModel;

public final class DefaultThresholdNotifierController
extends AbstractWidgetController
implements ThresholdNotifierController {
    @Override
    public void init() {
        super.init();
        this.getWidget().addPropertyChangedListener(this);
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        return false;
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 15: {
                this.valueChanged();
                break;
            }
        }
    }

    private void valueChanged() {
        ThresholdNotifierModel thresholdNotifierModel = (ThresholdNotifierModel)this.getWidget();
        int n = thresholdNotifierModel.get_value();
        int n2 = thresholdNotifierModel.getLastValue();
        if (n2 > thresholdNotifierModel.get_valueMin() && n <= thresholdNotifierModel.get_valueMin()) {
            this.fire_valueMinReached();
        } else if (n2 < thresholdNotifierModel.get_valueMax() && n >= thresholdNotifierModel.get_valueMax()) {
            this.fire_valueMaxReached();
        }
    }

    private void fire_valueMaxReached() {
        this.fireHMIEvent("valueMaxReached");
    }

    private void fire_valueMinReached() {
        this.fireHMIEvent("valueMinReached");
    }
}

