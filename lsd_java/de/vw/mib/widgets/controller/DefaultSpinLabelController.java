/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.animation.DragCalculator;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.SpinLabelController;
import de.vw.mib.widgets.models.SpinLabelModel;

public class DefaultSpinLabelController
extends AbstractWidgetController
implements SpinLabelController {
    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        if (string == "selectNextIndex") {
            SpinLabelModel spinLabelModel = (SpinLabelModel)this.getWidget();
            int n = spinLabelModel.get_selectedIndex() + 1;
            if (spinLabelModel.is_cyclic() || n < spinLabelModel.getLastIndex()) {
                spinLabelModel.set_spinDirectionUp(true);
                spinLabelModel.set_selectedIndex(n % spinLabelModel.getLastIndex());
                this.fire_selectionChanged();
            }
            return true;
        }
        if (string == "selectPreviousIndex") {
            SpinLabelModel spinLabelModel = (SpinLabelModel)this.getWidget();
            int n = spinLabelModel.get_selectedIndex() - 1;
            if (spinLabelModel.is_cyclic() || n >= 0) {
                spinLabelModel.set_spinDirectionUp(false);
                spinLabelModel.set_selectedIndex(n >= 0 ? n : spinLabelModel.getLastIndex() + n);
                this.fire_selectionChanged();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        SpinLabelModel spinLabelModel = (SpinLabelModel)this.getWidget();
        boolean bl = false;
        if (spinLabelModel.get_mode() != 0) {
            switch (touchEvent.getType()) {
                case 1: {
                    spinLabelModel.stopInternalAnimations();
                    DragCalculator.startDrag(spinLabelModel, 0, touchEvent.getY(), 1.0f);
                    bl = true;
                    break;
                }
                case 3: 
                case 4: {
                    DragCalculator.drag(spinLabelModel, 0, touchEvent.getY(), touchEvent.getTimestamp());
                    bl = true;
                    break;
                }
                case 11: {
                    bl = true;
                    break;
                }
                case 0: {
                    DragCalculator.snap(spinLabelModel, 0, touchEvent.getY(), touchEvent.getTimestamp());
                    bl = true;
                    break;
                }
            }
        }
        return bl;
    }

    @Override
    public void fire_selectionChanged() {
        SpinLabelModel spinLabelModel = (SpinLabelModel)this.getWidget();
        this.fireIntegerEvent("selectionChanged", spinLabelModel.getSelectionValue());
    }
}

