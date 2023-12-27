/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.widgets.controller.AbstractWidgetController;
import de.vw.mib.widgets.controller.DefaultListItemController$ListItemEventHandler;
import de.vw.mib.widgets.controller.DefaultListItemController$QueuedOutEvent;
import de.vw.mib.widgets.controller.ListItemController;
import de.vw.mib.widgets.event.DefaultTouchDelegator;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.event.TouchDelegatable;
import de.vw.mib.widgets.event.TouchDelegator;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;
import java.util.List;

public final class DefaultListItemController
extends AbstractWidgetController
implements ListItemController,
TouchDelegatable {
    private static final String EVENT_SENDER_NONE;
    private static final int DROP_DOWN_INDEX_NONE;
    protected int absoluteIndex;
    protected int actionIndex;
    protected int dropDownIndex;
    protected int destinationIndex;
    protected long objectID;
    protected String eventSender;
    private boolean queueOutEvents;
    private List queuedOutEvents;
    private DefaultListItemController$ListItemEventHandler listItemEventHandler;
    private TouchDelegator touchDelegator;

    @Override
    protected void reset() {
        super.reset();
        this.eventSender = "";
        this.queuedOutEvents = new ArrayList();
        this.listItemEventHandler = new DefaultListItemController$ListItemEventHandler(this);
    }

    @Override
    public void init() {
        super.init();
        this.queueOutEvents = false;
        this.touchDelegator = new DefaultTouchDelegator(this, this.listItemEventHandler);
    }

    @Override
    public void deInit() {
        this.touchDelegator = null;
        super.deInit();
    }

    @Override
    public OutEventListener getListItemEventHandler() {
        return this.listItemEventHandler;
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        ListItemModel listItemModel = (ListItemModel)this.getWidget();
        boolean bl = false;
        if (listItemModel == null || listItemModel.isDummy()) {
            return bl;
        }
        AbstractButtonModel abstractButtonModel = listItemModel.findFirstSelectedButton();
        if (abstractButtonModel != null) {
            this.prepareEventParameter(abstractButtonModel);
            if (string == "press") {
                abstractButtonModel.getController().addOutEventListener(this.listItemEventHandler);
            }
            bl = abstractButtonModel.consumeHMIEvent(hMIEvent, string);
            if (string == "release") {
                abstractButtonModel.getController().removeOutEventListener(this.listItemEventHandler);
            }
        }
        if (bl) {
            listItemModel.setDataInvalid(true);
        }
        return bl;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        ListItemModel listItemModel = (ListItemModel)this.getWidget();
        boolean bl = false;
        if (listItemModel == null || listItemModel.isDummy()) {
            return bl;
        }
        if (this.touchDelegator.getUtilizedWidget() == null) {
            this.prepareEventParameter(-1, "");
            if (listItemModel.is_draggable()) {
                bl = this.consumeDragDrop(touchEvent);
            }
            if (!bl) {
                bl = this.touchDelegator.forwardTouchEvent(touchEvent);
            }
        } else {
            bl = this.touchDelegator.forwardTouchEvent(touchEvent);
        }
        return bl;
    }

    private boolean consumeDragDrop(TouchEvent touchEvent) {
        boolean bl = false;
        switch (touchEvent.getType()) {
            case 1: 
            case 6: {
                if (!this.isInsideDragArea(touchEvent)) break;
                this.fire_itemDragged();
                bl = true;
                break;
            }
            case 3: 
            case 4: {
                bl = true;
                break;
            }
            case 0: 
            case 2: 
            case 11: {
                this.fire_itemDropped();
                bl = true;
                break;
            }
        }
        return bl;
    }

    private boolean isInsideDragArea(TouchEvent touchEvent) {
        ListItemModel listItemModel = (ListItemModel)this.getWidget();
        Insets insets = listItemModel.get_dragInsets();
        int n = listItemModel.getAbsX();
        int n2 = listItemModel.getAbsY();
        int n3 = listItemModel.get_width();
        int n4 = listItemModel.get_height();
        if (insets != null) {
            n += insets.left;
            n2 += insets.top;
            n3 -= insets.left + insets.right;
            n4 -= insets.top + insets.bottom;
        }
        Rectangle rectangle = new Rectangle(n, n2, n3, n4);
        return rectangle.contains(touchEvent.getX(), touchEvent.getY());
    }

    @Override
    public void setQueueOutEventsEnabled(boolean bl) {
        if (bl != this.queueOutEvents) {
            this.queueOutEvents = bl;
            this.discardQueuedOutEvents();
        }
    }

    @Override
    public void dispatchQueuedOutEvents() {
        ListItemModel listItemModel = (ListItemModel)this.getWidget();
        int n = listItemModel.getActionIndex();
        for (int i2 = 0; i2 < this.queuedOutEvents.size(); ++i2) {
            DefaultListItemController$QueuedOutEvent defaultListItemController$QueuedOutEvent = (DefaultListItemController$QueuedOutEvent)this.queuedOutEvents.get(i2);
            listItemModel.setActionIndex(defaultListItemController$QueuedOutEvent.actionIndex);
            this.fireListItemEvent(defaultListItemController$QueuedOutEvent.eventName, defaultListItemController$QueuedOutEvent.absoluteIndex, defaultListItemController$QueuedOutEvent.actionIndex, defaultListItemController$QueuedOutEvent.destinationIndex, defaultListItemController$QueuedOutEvent.dropDownIndex, defaultListItemController$QueuedOutEvent.eventSender, defaultListItemController$QueuedOutEvent.objectID);
        }
        this.discardQueuedOutEvents();
        listItemModel.setActionIndex(n);
    }

    @Override
    public void discardQueuedOutEvents() {
        this.queuedOutEvents.clear();
    }

    private void queueOutEvent(String string) {
        this.queuedOutEvents.add(new DefaultListItemController$QueuedOutEvent(string, this.absoluteIndex, this.actionIndex, this.destinationIndex, this.dropDownIndex, this.eventSender, this.objectID));
    }

    protected void prepareEventParameter(WidgetModel widgetModel) {
        if (widgetModel != null && widgetModel instanceof ButtonModel) {
            this.prepareEventParameter(-1, ((ButtonModel)widgetModel).get_eventSender());
        } else {
            this.prepareEventParameter(-1, "");
        }
    }

    protected void prepareEventParameter(int n, String string) {
        ListItemModel listItemModel = (ListItemModel)this.getWidget();
        this.actionIndex = listItemModel.getActionIndex();
        this.objectID = listItemModel.get_objectID();
        this.absoluteIndex = listItemModel.getAbsoluteIndex();
        this.destinationIndex = listItemModel.getDropIndex();
        this.dropDownIndex = n < 0 ? listItemModel.get_dropDownIndex() : n;
        this.eventSender = string == null ? "" : string;
    }

    @Override
    public void findActiveWidgets(List list, TouchEvent touchEvent) {
        this.getWidget().findTouchEventConsumingWidgets(list, touchEvent);
    }

    @Override
    public void onTouchEventForward(TouchEvent touchEvent, WidgetModel widgetModel) {
        this.prepareEventParameter(widgetModel);
    }

    @Override
    public boolean onTouchEventForwarded(TouchEvent touchEvent, WidgetModel widgetModel, boolean bl) {
        return bl;
    }

    @Override
    public void fire_buttonPressed() {
        if (this.queueOutEvents) {
            this.queueOutEvent("buttonPressed");
        } else {
            this.fireListItemEvent("buttonPressed", this.absoluteIndex, this.actionIndex, this.destinationIndex, this.dropDownIndex, this.eventSender, this.objectID);
        }
    }

    @Override
    public void fire_buttonReleased() {
        if (this.queueOutEvents) {
            this.queueOutEvent("buttonReleased");
        } else {
            this.fireListItemEvent("buttonReleased", this.absoluteIndex, this.actionIndex, this.destinationIndex, this.dropDownIndex, this.eventSender, this.objectID);
        }
    }

    @Override
    public void fire_buttonLongPressed() {
        if (this.queueOutEvents) {
            this.queueOutEvent("buttonLongPressed");
        } else {
            this.fireListItemEvent("buttonLongPressed", this.absoluteIndex, this.actionIndex, this.destinationIndex, this.dropDownIndex, this.eventSender, this.objectID);
        }
    }

    @Override
    public void fire_buttonLongReleased() {
        if (this.queueOutEvents) {
            this.queueOutEvent("buttonLongReleased");
        } else {
            this.fireListItemEvent("buttonLongReleased", this.absoluteIndex, this.actionIndex, this.destinationIndex, this.dropDownIndex, this.eventSender, this.objectID);
        }
    }

    @Override
    public void fire_buttonCancelled() {
        if (this.queueOutEvents) {
            this.queueOutEvent("buttonCancelled");
        } else {
            this.fireListItemEvent("buttonCancelled", this.absoluteIndex, this.actionIndex, this.destinationIndex, this.dropDownIndex, this.eventSender, this.objectID);
        }
    }

    @Override
    public void fire_itemDragged() {
        if (this.queueOutEvents) {
            this.queueOutEvent("itemDragged");
        } else {
            this.fireListItemEvent("itemDragged", this.absoluteIndex, this.actionIndex, this.destinationIndex, this.dropDownIndex, this.eventSender, this.objectID);
        }
    }

    @Override
    public void fire_itemDropped() {
        if (this.queueOutEvents) {
            this.queueOutEvent("itemDropped");
        } else {
            this.fireListItemEvent("itemDropped", this.absoluteIndex, this.actionIndex, this.destinationIndex, this.dropDownIndex, this.eventSender, this.objectID);
        }
    }

    @Override
    public void fire_itemTriggerFailed() {
        this.prepareEventParameter(-1, "");
        if (this.queueOutEvents) {
            this.queueOutEvent("itemTriggerFailed");
        } else {
            this.fireListItemEvent("itemTriggerFailed", this.absoluteIndex, this.actionIndex, this.destinationIndex, this.dropDownIndex, this.eventSender, this.objectID);
        }
    }
}

