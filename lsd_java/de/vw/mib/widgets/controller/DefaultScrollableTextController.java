/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.widgets.animation.DragCalculator;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.ScrollableTextController;
import de.vw.mib.widgets.models.ScrollableTextModel;

public final class DefaultScrollableTextController
extends AbstractWidgetController
implements ScrollableTextController {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        if ("scrollUp" == string) {
            this.fire_scrollUp();
            bl = true;
        } else if ("scrollDown" == string) {
            this.fire_scrollDown();
            bl = true;
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        ScrollableTextModel scrollableTextModel = (ScrollableTextModel)this.getWidget();
        boolean bl = false;
        switch (touchEvent.getType()) {
            case 1: {
                scrollableTextModel.stopInternalAnimations();
                DragCalculator.startDrag(scrollableTextModel, touchEvent.getX(), touchEvent.getY(), 1.0f);
                bl = true;
                break;
            }
            case 3: 
            case 4: {
                DragCalculator.drag(scrollableTextModel, touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp());
                bl = true;
                break;
            }
            case 11: {
                bl = true;
                break;
            }
            case 0: 
            case 2: {
                DragCalculator.snap(scrollableTextModel, touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp());
                bl = true;
                break;
            }
        }
        return bl;
    }

    @Override
    public void fire_scrollUp() {
        ScrollableTextModel scrollableTextModel = (ScrollableTextModel)this.getWidget();
        scrollableTextModel.set_firstLineIndex(scrollableTextModel.getFirstVisibleLineIndex() - 1);
    }

    @Override
    public void fire_scrollDown() {
        ScrollableTextModel scrollableTextModel = (ScrollableTextModel)this.getWidget();
        scrollableTextModel.set_firstLineIndex(scrollableTextModel.getFirstVisibleLineIndex() + 1);
    }
}

