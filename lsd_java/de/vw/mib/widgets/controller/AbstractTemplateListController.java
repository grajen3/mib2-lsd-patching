/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.IntegerValueEvent;
import de.vw.mib.event.RotationEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.ListItem;
import de.vw.mib.widgets.controller.AbstractListController;
import de.vw.mib.widgets.controller.AbstractTemplateListController$ListHMIEvent;
import de.vw.mib.widgets.controller.AbstractTemplateListController$ListItemEventHandler;
import de.vw.mib.widgets.controller.AbstractTemplateListController$ListTouchEvent;
import de.vw.mib.widgets.controller.AbstractTemplateListController$PressDelayer;
import de.vw.mib.widgets.controller.AbstractTemplateListController$ViewChangedHandler;
import de.vw.mib.widgets.controller.RotationAccelerator;
import de.vw.mib.widgets.controller.TemplateListController;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.list.DefaultTemplateListSelectionStrategy;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.WidgetModel;

public abstract class AbstractTemplateListController
extends AbstractListController
implements TemplateListController {
    private static final int DEFAULT_ROTATION_TICKS;
    private static final AbstractTemplateListController$ListTouchEvent CANCEL_EVENT_DUMMY;
    private static final HMIEvent HMI_EVENT_DUMMY;
    private static final int FAST_SCROLLING_MODE_NONE;
    private static final int FAST_SCROLLING_MODE_SIMPLE;
    private static final int FAST_SCROLLING_NODE_LETTER;
    private static final int FAST_SCROLLING_ADJUSTMENT_PADDING;
    protected static final int TOUCHED_INDEX_NONE;
    protected AbstractTemplateListController$PressDelayer pressDelayer;
    private RotationAccelerator rotationAccelerator;
    protected int rotationTicks;
    protected Point touchPointInitial;
    private boolean pressed;
    private int fastScrollingMode;
    protected boolean touchActive;
    private WidgetModel touchedWidget;
    private int touchIndex;
    protected OutEventListener listItemEventHandler;
    private AbstractTemplateListController$ViewChangedHandler viewChangedHandler;

    @Override
    protected void reset() {
        super.reset();
        this.listItemEventHandler = new AbstractTemplateListController$ListItemEventHandler(this);
        this.viewChangedHandler = new AbstractTemplateListController$ViewChangedHandler(this);
        this.touchPointInitial = new Point();
    }

    @Override
    public void init() {
        super.init();
        this.rotationTicks = 1;
        this.rotationAccelerator = new RotationAccelerator();
        this.pressDelayer = new AbstractTemplateListController$PressDelayer(this);
        this.pressed = false;
        this.touchActive = false;
        this.registerViewChangedHandler(this.getWidget(), this.viewChangedHandler, true);
    }

    @Override
    public void deInit() {
        this.deregisterViewChangedHandler(this.getWidget(), this.viewChangedHandler);
        super.deInit();
        this.touchedWidget = null;
    }

    protected TemplateListModel getTemplateList() {
        return (TemplateListModel)this.getList();
    }

    protected WidgetModel getTouchedWidget() {
        return this.touchedWidget;
    }

    protected void setTouchedWidget(WidgetModel widgetModel) {
        if (this.touchedWidget != null) {
            this.touchedWidget.getController().removeOutEventListener(this.listItemEventHandler);
        }
        if (widgetModel != null) {
            widgetModel.getController().addOutEventListener(this.listItemEventHandler);
        }
        this.touchedWidget = widgetModel;
    }

    protected int getTouchedIndex() {
        return this.touchIndex;
    }

    protected void setTouchedIndex(int n) {
        this.touchIndex = n;
    }

    protected final boolean sendDelayedPressImmediately() {
        if (!this.pressDelayer.isPressDelayed()) {
            return false;
        }
        this.pressDelayer.sendImmediately();
        return true;
    }

    @Override
    public boolean consumeTouchEvent(TouchEvent touchEvent) {
        TemplateListModel templateListModel = this.getTemplateList();
        boolean bl = false;
        if (!this.pressed) {
            switch (touchEvent.getType()) {
                case 1: {
                    if (!this.touchActive) {
                        if (this.touchedWidget != null) {
                            if (this.touchedWidget instanceof ListItem) {
                                this.prepareListItem((ListItem)this.touchedWidget, this.touchIndex);
                            }
                            bl = this.touchedWidget.consumeTouchEvent(touchEvent);
                        }
                        if (this.touchedWidget == null) {
                            bl = this.forwardTouchEventToScrollbar(touchEvent);
                            if (!bl) {
                                this.touchPointInitial.setLocation(touchEvent.getX(), touchEvent.getY());
                                bl = this.forwardTouchEventToListImplementation(touchEvent);
                                if (!bl) {
                                    this.pressDelayer.sendDelayedPress(templateListModel.get_forwardPressDelay(), touchEvent.getX(), touchEvent.getY());
                                    bl = true;
                                }
                            }
                            templateListModel.disableFollowMode();
                        }
                        this.touchActive = true;
                        break;
                    }
                    if (templateListModel.getDragIndex() == -1 || this.touchedWidget == null || !(this.touchedWidget instanceof ListItem)) break;
                    ListItem listItem = (ListItem)this.touchedWidget;
                    listItem.setDropIndex(listItem.getActionIndex());
                    templateListModel.dropItem();
                    break;
                }
                case 6: {
                    if (templateListModel.get_scrollTypeTouch() == 3) {
                        this.forwardTouchEventToListImplementation(touchEvent);
                    } else {
                        this.startFastScrolling();
                        this.performFastScrolling(touchEvent.getX(), touchEvent.getY());
                    }
                    if (this.pressDelayer.isPressDelayed()) {
                        this.pressDelayer.abortSend();
                    }
                    if (this.touchedWidget != null) {
                        this.touchedWidget.consumeTouchEvent(CANCEL_EVENT_DUMMY);
                        this.setTouchedWidget(null);
                    }
                    this.touchActive = true;
                    bl = true;
                    break;
                }
                case 11: {
                    bl = this.touchedWidget != null ? this.touchedWidget.consumeTouchEvent(touchEvent) : true;
                    this.abortTouchActions();
                    break;
                }
                case 0: 
                case 2: {
                    this.sendDelayedPressImmediately();
                    if (this.touchedWidget != null) {
                        if (this.touchedWidget instanceof ListItem) {
                            ListItem listItem = (ListItem)this.touchedWidget;
                            this.prepareListItem(listItem, this.touchIndex);
                            if (templateListModel.getDragIndex() != -1) {
                                listItem.setDropIndex(this.getRelativeDropIndex());
                            }
                        }
                        bl = this.touchedWidget.consumeTouchEvent(touchEvent);
                    }
                    if (this.fastScrollingMode == 0 && !bl) {
                        bl = this.forwardTouchEventToListImplementation(touchEvent);
                    } else {
                        this.stopFastScrolling();
                    }
                    this.setTouchedIndex(-1);
                    this.setTouchedWidget(null);
                    this.touchActive = false;
                    break;
                }
                default: {
                    if (this.touchedWidget != null) {
                        if (this.touchedWidget instanceof ListItem) {
                            ListItem listItem = (ListItem)this.touchedWidget;
                            this.prepareListItem(listItem, this.touchIndex);
                            if (templateListModel.getDragIndex() != -1) {
                                templateListModel.moveItem(touchEvent.getX() - this.touchPointInitial.x, touchEvent.getY() - this.touchPointInitial.y);
                                listItem.setDropIndex(this.getRelativeDropIndex());
                            }
                        }
                        if ((bl = this.touchedWidget.consumeTouchEvent(touchEvent)) || !(bl = this.forwardTouchEventToListImplementation(touchEvent))) break;
                        this.touchedWidget.consumeTouchEvent(CANCEL_EVENT_DUMMY);
                        this.setTouchedWidget(null);
                        break;
                    }
                    if (this.fastScrollingMode == 0) {
                        bl = this.forwardTouchEventToListImplementation(touchEvent);
                        if (!bl || !this.pressDelayer.isPressDelayed()) break;
                        this.pressDelayer.abortSend();
                        break;
                    }
                    this.performFastScrolling(touchEvent.getX(), touchEvent.getY());
                    bl = true;
                }
            }
            this.updateLetterScrollingIndicatorPosition(touchEvent.getX(), touchEvent.getY());
        }
        return bl;
    }

    @Override
    public void abortTouchActions() {
        if (this.touchActive) {
            TemplateListModel templateListModel = (TemplateListModel)this.getWidget();
            templateListModel.dropItem();
            this.pressDelayer.abortSend();
            this.fire_release();
            this.setTouchedWidget(null);
            this.touchActive = false;
            templateListModel.snap(templateListModel.getFirstFullyVisibleIndex(), 0);
        }
    }

    @Override
    public boolean consumeHMIEvent(HMIEvent hMIEvent, String string) {
        boolean bl = false;
        TemplateListModel templateListModel = this.getTemplateList();
        int n = templateListModel.get_selectedIndex();
        if (this.pressed && string == "release" || templateListModel.is_visible() && templateListModel.areParentsVisible()) {
            templateListModel.disableFollowMode();
            if (!this.pressed && this.touchedWidget == null) {
                if ("selectNext" == string) {
                    if (null != hMIEvent && hMIEvent.getType() == 16) {
                        this.rotationTicks = this.rotationAccelerator.getAcceleratedTicks(templateListModel.get_itemCount(), ((RotationEvent)hMIEvent).getTicks(), true);
                    }
                    if (!templateListModel.isSelectionLocked()) {
                        this.fire_selectNext();
                    } else {
                        this.forwardHMIEventToListItem(hMIEvent, "stepUp", n, false);
                    }
                } else if ("selectPrevious" == string) {
                    if (null != hMIEvent && hMIEvent.getType() == 16) {
                        this.rotationTicks = this.rotationAccelerator.getAcceleratedTicks(templateListModel.get_itemCount(), ((RotationEvent)hMIEvent).getTicks(), false);
                    }
                    if (!templateListModel.isSelectionLocked()) {
                        this.fire_selectPrevious();
                    } else {
                        this.forwardHMIEventToListItem(hMIEvent, "stepDown", n, false);
                    }
                } else if ("press" == string && templateListModel.get_scrollTypeRotary() != -1) {
                    if (!this.forwardHMIEventToListImplementation(hMIEvent, string)) {
                        templateListModel.freeze();
                        this.forwardHMIEventToListItem(hMIEvent, string, n, false);
                    }
                    this.fire_press();
                } else if ("triggerIndexAbsolute" == string) {
                    if (null != hMIEvent && hMIEvent.getType() == 4) {
                        int n2 = ((IntegerValueEvent)hMIEvent).getValue();
                        this.fire_triggerIndexAbsolute(n2);
                    }
                } else if ("triggerIndexRelative" == string && null != hMIEvent && hMIEvent.getType() == 4) {
                    int n3 = ((IntegerValueEvent)hMIEvent).getValue();
                    this.fire_triggerIndexRelative(n3);
                }
            } else if ("release" == string && templateListModel.get_scrollTypeRotary() != -1) {
                if (!this.forwardHMIEventToListImplementation(hMIEvent, string)) {
                    this.forwardHMIEventToListItem(hMIEvent, string, n, false);
                    templateListModel.unfreeze();
                }
                this.fire_release();
            }
            bl = true;
        }
        this.rotationTicks = 1;
        return bl;
    }

    protected abstract boolean forwardTouchEventToListImplementation(TouchEvent touchEvent) {
    }

    protected abstract boolean forwardHMIEventToListImplementation(HMIEvent hMIEvent, String string) {
    }

    protected abstract boolean forwardHMIEventToListItem(HMIEvent hMIEvent, String string, int n, boolean bl) {
    }

    protected abstract boolean forwardTouchEventToListItem(TouchEvent touchEvent) {
    }

    protected abstract boolean forwardTouchEventToScrollbar(TouchEvent touchEvent) {
    }

    protected abstract boolean isDelayedForwardingAllowed(TouchEvent touchEvent) {
    }

    protected abstract void prepareListItem(ListItemModel listItemModel, int n) {
    }

    private int getRelativeDropIndex() {
        TemplateListModel templateListModel = this.getTemplateList();
        int n = templateListModel.getDropIndex();
        int n2 = templateListModel.getDragIndex();
        ListItemModel listItemModel = templateListModel.getItemMaster(n2);
        int n3 = templateListModel.getAbsIndexByListItemDynamicIndex(listItemModel, 0);
        int n4 = templateListModel.getAbsIndexByListItemDynamicIndex(listItemModel, listItemModel.getItemCount() - 1);
        int n5 = n > n4 ? listItemModel.getItemCount() : (n < n3 ? -1 : templateListModel.getItemIndex(n));
        return n5;
    }

    private void updateLetterScrollingIndicatorPosition(int n, int n2) {
        TemplateListModel templateListModel = this.getTemplateList();
        WidgetModel widgetModel = templateListModel.get_letterScrollingIndicatorRef();
        int n3 = templateListModel.get_letterScrollingIndicatorMode();
        boolean bl = templateListModel.isLetterScrollingIndicatorActive();
        if (bl && widgetModel != null) {
            widgetModel.disableAnimations();
            switch (n3) {
                case 2: {
                    int n4 = widgetModel.get_width();
                    int n5 = Util.clamp(n - templateListModel.getAbsX() - (n4 >> 1), 0, templateListModel.get_width() - n4);
                    widgetModel.set_x(n5);
                    break;
                }
                case 1: {
                    int n6 = widgetModel.get_height();
                    int n7 = Util.clamp(n2 - templateListModel.getAbsY() - (n6 >> 1), 0, templateListModel.get_height() - n6);
                    widgetModel.set_y(n7);
                    break;
                }
            }
            widgetModel.enableAnimations();
        }
    }

    private void startFastScrolling() {
        TemplateListModel templateListModel = this.getTemplateList();
        if (templateListModel.isFastScrollingSupported()) {
            this.fastScrollingMode = templateListModel.is_letterScrollingEnabled() && templateListModel.is_letterScrollingSupported() ? 2 : 1;
            templateListModel.adjustmentValueChanged(templateListModel, 1);
        }
    }

    private void stopFastScrolling() {
        TemplateListModel templateListModel = this.getTemplateList();
        if (this.fastScrollingMode != 0) {
            templateListModel.getDragDataStorage().dragActive = false;
            templateListModel.adjustmentValueChanged(templateListModel, 2);
            this.fastScrollingMode = 0;
        }
    }

    private void performFastScrolling(int n, int n2) {
        TemplateListModel templateListModel = this.getTemplateList();
        boolean bl = templateListModel.isVertical();
        int n3 = 30;
        int n4 = (bl ? templateListModel.get_height() : templateListModel.get_width()) - 30 - 30;
        int n5 = n4 - 30;
        int n6 = Util.clamp(bl ? n2 - templateListModel.getAbsY() : n - templateListModel.getAbsX(), 30, n4);
        float f2 = (float)(n6 - 30) / (float)n5;
        int n7 = Math.round((float)templateListModel.getMaximum() * f2);
        switch (this.fastScrollingMode) {
            case 1: {
                templateListModel.performDefaultAdjustment(n7, 0);
                break;
            }
            case 2: {
                templateListModel.performIndexedAdjustment(n7, 0);
                break;
            }
        }
    }

    @Override
    public void fire_selectNext() {
        TemplateListModel templateListModel = this.getTemplateList();
        if (templateListModel == null || templateListModel.get_scrollTypeRotary() == -1) {
            return;
        }
        AbstractList.enableListSelection();
        boolean bl = this.rotationAccelerator.isAccelerated();
        int n = DefaultTemplateListSelectionStrategy.getNextSelectedIndex(templateListModel, this.rotationTicks);
        if (n != templateListModel.get_selectedIndex()) {
            if (bl) {
                templateListModel.stopInternalAnimations();
                templateListModel.disableAnimations();
            }
            templateListModel.set_selectedIndex(n);
            if (bl) {
                templateListModel.enableAnimations();
            }
            this.fire_selectionChanged();
            this.fire_adjustmentStarted();
            this.fire_adjustmentStopped();
        }
    }

    @Override
    public void fire_selectPrevious() {
        TemplateListModel templateListModel = this.getTemplateList();
        if (templateListModel == null || templateListModel.get_scrollTypeRotary() == -1) {
            return;
        }
        AbstractList.enableListSelection();
        boolean bl = this.rotationAccelerator.isAccelerated();
        int n = DefaultTemplateListSelectionStrategy.getPrevSelectedIndex(templateListModel, this.rotationTicks);
        if (n != templateListModel.get_selectedIndex()) {
            if (bl) {
                templateListModel.stopInternalAnimations();
                templateListModel.disableAnimations();
            }
            templateListModel.set_selectedIndex(n);
            if (bl) {
                templateListModel.enableAnimations();
            }
            this.fire_selectionChanged();
        }
    }

    @Override
    public void fire_press() {
        this.pressed = true;
    }

    @Override
    public void fire_release() {
        this.pressed = false;
    }

    public void fire_startReadOut() {
    }

    public void fire_stopReadOut() {
    }

    @Override
    public void fire_restartFollowMode() {
        this.getTemplateList().set_followMode(true);
    }

    @Override
    public void fire_triggerIndexAbsolute(int n) {
        TemplateListModel templateListModel = this.getTemplateList();
        if (n >= 0 && n < templateListModel.get_itemCount()) {
            this.forwardHMIEventToListItem(HMI_EVENT_DUMMY, "press", n, false);
            this.forwardHMIEventToListItem(HMI_EVENT_DUMMY, "release", n, true);
        } else {
            this.fire_triggerIndexAbsoluteFailed();
        }
    }

    @Override
    public void fire_triggerIndexRelative(int n) {
        TemplateListModel templateListModel = this.getTemplateList();
        int n2 = templateListModel.getFirstMostlyVisibleIndex();
        int n3 = templateListModel.getLastMostlyVisibleIndex();
        int n4 = n2 + n;
        if (n4 >= n2 && n4 <= n3) {
            this.forwardHMIEventToListItem(HMI_EVENT_DUMMY, "press", n4, false);
            this.forwardHMIEventToListItem(HMI_EVENT_DUMMY, "release", n4, true);
        } else {
            this.fire_triggerIndexRelativeFailed();
        }
    }

    @Override
    public void fire_adjustmentStarted() {
        this.fireHMIEvent("adjustmentStarted");
    }

    @Override
    public void fire_adjustmentStopped() {
        this.fireHMIEvent("adjustmentStopped");
    }

    @Override
    public void fire_triggerIndexAbsoluteFailed() {
        this.fireHMIEvent("triggerIndexAbsoluteFailed");
    }

    @Override
    public void fire_triggerIndexRelativeFailed() {
        this.fireHMIEvent("triggerIndexRelativeFailed");
    }

    static {
        CANCEL_EVENT_DUMMY = new AbstractTemplateListController$ListTouchEvent(11, 0, 0);
        HMI_EVENT_DUMMY = new AbstractTemplateListController$ListHMIEvent();
    }
}

