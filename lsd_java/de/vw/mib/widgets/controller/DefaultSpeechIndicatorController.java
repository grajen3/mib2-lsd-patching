/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.SpeechIndicatorController;
import de.vw.mib.widgets.models.SpeechIndicatorModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;

public final class DefaultSpeechIndicatorController
extends AbstractWidgetController
implements SpeechIndicatorController {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
    }

    @Override
    public void deActivate() {
        super.deActivate();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        ArrayList arrayList = new ArrayList();
        SpeechIndicatorModel speechIndicatorModel = (SpeechIndicatorModel)this.getWidget();
        speechIndicatorModel.findTouchEventConsumingWidgets(arrayList, touchEvent);
        boolean bl = false;
        if (arrayList.size() > 0) {
            WidgetModel widgetModel = (WidgetModel)arrayList.get(0);
            bl = widgetModel.consumeTouchEvent(touchEvent);
        }
        if (!bl) {
            switch (touchEvent.getType()) {
                case 1: 
                case 6: {
                    this.fire_pressed();
                    break;
                }
                case 0: 
                case 2: {
                    this.fire_released();
                    break;
                }
                case 11: {
                    break;
                }
            }
        }
        return bl;
    }

    @Override
    public void fire_pressed() {
        this.fireHMIEvent("pressed");
    }

    @Override
    public void fire_released() {
        this.fireHMIEvent("released");
    }
}

