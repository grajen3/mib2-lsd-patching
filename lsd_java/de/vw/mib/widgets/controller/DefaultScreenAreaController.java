/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.ScreenAreaController;
import de.vw.mib.widgets.models.ScreenAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;

public final class DefaultScreenAreaController
extends AbstractWidgetController
implements ScreenAreaController {
    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        boolean bl = false;
        ScreenAreaModel screenAreaModel = (ScreenAreaModel)this.getWidget();
        WidgetModel[] widgetModelArray = screenAreaModel.getChildren();
        int n = widgetModelArray.length;
        while (--n >= 0 && !bl) {
            ViewModel viewModel = (ViewModel)widgetModelArray[n];
            bl = viewModel.consumeTouchEvent(touchEvent);
        }
        return bl;
    }
}

