/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.ProximityEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Point;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.DefaultViewController$CancelEvent;
import de.vw.mib.widgets.controller.DefaultViewController$ViewChangedHandler;
import de.vw.mib.widgets.controller.ViewController;
import de.vw.mib.widgets.event.DefaultTouchDelegator;
import de.vw.mib.widgets.event.TouchDelegatable;
import de.vw.mib.widgets.event.TouchDelegator;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public class DefaultViewController
extends AbstractWidgetController
implements TouchDelegatable,
ViewController {
    private boolean viewActivatedInitially;
    protected DefaultViewController$ViewChangedHandler viewChangedHandler = null;
    static final DefaultViewController$CancelEvent DEFAULT_CANCEL_EVENT = new DefaultViewController$CancelEvent();
    private TouchDelegator touchDelegator;

    @Override
    protected void reset() {
        super.reset();
        this.viewChangedHandler = new DefaultViewController$ViewChangedHandler(this);
    }

    @Override
    public void init() {
        super.init();
        this.touchDelegator = new DefaultTouchDelegator(this, null);
        this.viewActivatedInitially = false;
        if (this.viewChangedHandler == null) {
            this.viewChangedHandler = new DefaultViewController$ViewChangedHandler(this);
        }
        this.registerViewChangedHandler(this.getWidget(), this.viewChangedHandler, true);
    }

    @Override
    public void deInit() {
        this.touchDelegator = null;
        this.deregisterViewChangedHandler(this.getWidget(), this.viewChangedHandler);
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        if (this.viewActivatedInitially) {
            this.fire_viewReEntered();
        } else {
            this.fire_viewEntered();
            this.viewActivatedInitially = true;
        }
    }

    @Override
    public void deActivate() {
        this.fire_viewLeft();
        super.deActivate();
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        return false;
    }

    @Override
    public boolean consumeProximityEvent(ProximityEvent proximityEvent) {
        ViewModel viewModel = (ViewModel)this.getWidget();
        CowList cowList = viewModel.getProximityConsumers();
        boolean bl = false;
        switch (proximityEvent.getType()) {
            case 3: {
                this.fireHMIEvent("swipeLeft");
                bl = true;
                break;
            }
            case 4: {
                this.fireHMIEvent("swipeRight");
                bl = true;
                break;
            }
        }
        for (CowList cowList2 = cowList; cowList2 != CowList.EMPTY; cowList2 = cowList2.tail()) {
            WidgetModel widgetModel = (WidgetModel)cowList2.head();
            bl |= widgetModel.consumeProximityEvent(proximityEvent);
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        ViewModel viewModel = (ViewModel)this.getWidget();
        boolean bl = false;
        if (viewModel.is_activated()) {
            bl = this.touchDelegator.forwardTouchEvent(touchEvent);
            switch (touchEvent.getType()) {
                case 1: 
                case 6: {
                    if (!AbstractList.isListSelectionEnabled()) break;
                    AbstractList.disableListSelection();
                    viewModel.repaint();
                    break;
                }
                case 99: {
                    viewModel.setPointerPosition(new Point(touchEvent.getX(), touchEvent.getY()));
                    viewModel.repaint();
                    break;
                }
            }
            if (bl && LOGGER.isTraceEnabled(1024)) {
                LogMessage logMessage = LOGGER.trace(1024);
                logMessage.append("View consumed touch event: ").append(touchEvent.toString()).log();
            }
        }
        return bl;
    }

    @Override
    public int getTouchForwardingMode() {
        ViewModel viewModel = (ViewModel)this.getWidget();
        return viewModel.get_touchForwardingMode();
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
    public void fire_viewEntered() {
        this.fireHMIEvent("ViewEntered");
    }

    @Override
    public void fire_viewReEntered() {
        this.fireHMIEvent("ViewReEntered");
    }

    @Override
    public void fire_viewLeft() {
        this.fireHMIEvent("ViewLeft");
    }

    @Override
    public void fire_swipeLeft() {
        this.fireHMIEvent("swipeLeft");
    }

    @Override
    public void fire_swipeRight() {
        this.fireHMIEvent("swipeRight");
    }
}

