/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Point;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.InputFieldController;
import de.vw.mib.widgets.models.InputFieldModel;

public final class DefaultInputFieldController
extends AbstractWidgetController
implements InputFieldController {
    private static final int MOVEMENT_TRESHOLD;
    private int viewPortPositionInitial;
    private Point touchPointInitial;

    @Override
    protected void reset() {
        super.reset();
        this.touchPointInitial = new Point();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        InputFieldModel inputFieldModel = (InputFieldModel)this.getWidget();
        boolean bl = false;
        switch (touchEvent.getType()) {
            case 1: {
                this.touchPointInitial.setLocation(touchEvent.getX(), touchEvent.getY());
                this.viewPortPositionInitial = inputFieldModel.getViewPortPosition();
                if (this.isCursorMovementEnabled(inputFieldModel, touchEvent)) {
                    this.updateCursorPosition(touchEvent.getX(), touchEvent.getY());
                    bl = true;
                }
                bl = true;
                break;
            }
            case 11: {
                break;
            }
            case 0: 
            case 2: 
            case 6: {
                if (bl) break;
                this.fire_released();
                break;
            }
            default: {
                if (inputFieldModel.isVertical()) {
                    int n = touchEvent.getY() - this.touchPointInitial.y;
                    inputFieldModel.setValue(this.viewPortPositionInitial - n);
                } else {
                    int n = touchEvent.getX() - this.touchPointInitial.x;
                    if (inputFieldModel.get_alignmentHorizontal() == 0) {
                        inputFieldModel.setValue(this.viewPortPositionInitial - n);
                    } else {
                        inputFieldModel.setValue(this.viewPortPositionInitial + n);
                    }
                }
                if (this.isCursorMovementEnabled(inputFieldModel, touchEvent)) {
                    this.updateCursorPosition(touchEvent.getX(), touchEvent.getY());
                    break;
                }
                bl = true;
            }
        }
        return bl;
    }

    private boolean isCursorMovementEnabled(InputFieldModel inputFieldModel, TouchEvent touchEvent) {
        int n = Math.abs(inputFieldModel.isVertical() ? this.viewPortPositionInitial - inputFieldModel.getViewPortPosition() : 0);
        return !inputFieldModel.isMatchTextVisible() && n < 5;
    }

    private void updateCursorPosition(int n, int n2) {
        InputFieldModel inputFieldModel = (InputFieldModel)this.getWidget();
        inputFieldModel.setCursorPosition(n - inputFieldModel.getAbsX(), n2 - inputFieldModel.getAbsY());
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

