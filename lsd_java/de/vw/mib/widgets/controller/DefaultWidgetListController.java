/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.controller;

import de.vw.mib.event.HMIEvent;
import de.vw.mib.event.TouchEvent;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.animation.DragCalculator;
import de.vw.mib.widgets.controller.AbstractTemplateListController;
import de.vw.mib.widgets.controller.ListItemController;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.controller.WidgetListController;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.ScrollbarModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;

public final class DefaultWidgetListController
extends AbstractTemplateListController
implements WidgetListController {
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
        boolean bl = super.consumeHMIEvent(hMIEvent, string);
        if ("selectNextPage" == string) {
            this.fire_selectNextPage();
            bl = true;
        } else if ("selectPreviousPage" == string) {
            this.fire_selectPreviousPage();
            bl = true;
        } else if ("activateBrowsing" == string) {
            this.fire_activateBrowsing();
            bl = true;
        }
        return bl;
    }

    @Override
    protected boolean forwardTouchEventToListImplementation(TouchEvent touchEvent) {
        boolean bl;
        block15: {
            WidgetListModel widgetListModel;
            block14: {
                widgetListModel = (WidgetListModel)this.getWidget();
                bl = false;
                if (widgetListModel.getMaximum() - widgetListModel.getMinimum() <= 0 || widgetListModel.get_scrollTypeTouch() == -1) {
                    return false;
                }
                if (widgetListModel.get_scrollTypeTouch() != 3) break block14;
                switch (touchEvent.getType()) {
                    case 6: {
                        DragCalculator.startDrag(widgetListModel, touchEvent.getX(), touchEvent.getY(), 1.0f);
                        if (widgetListModel.isSnapAnimationRunning() && widgetListModel.isSnapAnimationStoppableByUser()) {
                            widgetListModel.stopSnapAnimation();
                            widgetListModel.repaint();
                            bl = true;
                            break;
                        }
                        break block15;
                    }
                    case 1: 
                    case 3: 
                    case 4: {
                        break;
                    }
                    case 7: 
                    case 8: {
                        bl = DragCalculator.drag(widgetListModel, touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp());
                        break;
                    }
                    case 0: {
                        DragCalculator.snap(widgetListModel, touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp());
                        bl = widgetListModel.getDragDataStorage().dragActive;
                        break;
                    }
                }
                break block15;
            }
            switch (touchEvent.getType()) {
                case 1: {
                    DragCalculator.startDrag(widgetListModel, touchEvent.getX(), touchEvent.getY(), 1.0f);
                    if (!widgetListModel.isSnapAnimationRunning() || !widgetListModel.isSnapAnimationStoppableByUser()) break;
                    widgetListModel.stopSnapAnimation();
                    widgetListModel.repaint();
                    bl = true;
                    break;
                }
                case 7: 
                case 8: {
                    DragCalculator.startDrag(widgetListModel, touchEvent.getX(), touchEvent.getY(), 1.0f);
                    break;
                }
                case 3: 
                case 4: {
                    bl = DragCalculator.drag(widgetListModel, touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp());
                    break;
                }
                case 0: 
                case 2: {
                    DragCalculator.snap(widgetListModel, touchEvent.getX(), touchEvent.getY(), touchEvent.getTimestamp());
                    bl = widgetListModel.getDragDataStorage().dragActive;
                    break;
                }
            }
        }
        return bl;
    }

    @Override
    public boolean forwardTouchEventToListItem(TouchEvent touchEvent) {
        WidgetListModel widgetListModel = this.getWidgetList();
        boolean bl = false;
        int n = -1;
        do {
            if ((n = widgetListModel.locationToIndex(touchEvent.getX() - widgetListModel.getAbsX(), touchEvent.getY() - widgetListModel.getAbsY(), n + 1)) == -1) continue;
            ListItemModel listItemModel = widgetListModel.getItem(n);
            if (listItemModel != null) {
                this.prepareListItem(listItemModel, n);
                listItemModel.getController().addOutEventListener(this.listItemEventHandler);
                bl = listItemModel.consumeTouchEvent(touchEvent);
                listItemModel.getController().removeOutEventListener(this.listItemEventHandler);
            }
            if (!bl) continue;
            this.setTouchedWidget(listItemModel);
            this.setTouchedIndex(n);
            widgetListModel.setFocusedIndex(n);
        } while (n != -1 && !bl);
        return bl;
    }

    @Override
    protected boolean isDelayedForwardingAllowed(TouchEvent touchEvent) {
        boolean bl = true;
        WidgetListModel widgetListModel = this.getWidgetList();
        int n = widgetListModel.locationToIndex(touchEvent.getX() - widgetListModel.getAbsX(), touchEvent.getY() - widgetListModel.getAbsY(), 0);
        if (n != -1 && widgetListModel.getItem(n) != null) {
            ListItemModel listItemModel = widgetListModel.getItem(n);
            bl = !listItemModel.hasSubSlider();
        }
        return bl && widgetListModel.get_scrollTypeTouch() != 3;
    }

    @Override
    protected void prepareListItem(ListItemModel listItemModel, int n) {
        WidgetListModel widgetListModel = this.getWidgetList();
        widgetListModel.disableAnimations();
        listItemModel.disablePropertyChanged();
        listItemModel.set_x(widgetListModel.getItemX(n) - widgetListModel.getViewport().x);
        listItemModel.set_y(widgetListModel.getItemY(n) - widgetListModel.getViewport().y);
        listItemModel.setActionIndex(widgetListModel.getItemIndex(n));
        listItemModel.set_draggable(listItemModel.is_draggable() && widgetListModel.is_dragDropEnabled());
        widgetListModel.transferData(listItemModel, n, widgetListModel.getItemIndex(n));
        listItemModel.enablePropertyChanged();
        widgetListModel.enableAnimations();
    }

    @Override
    protected boolean forwardTouchEventToScrollbar(TouchEvent touchEvent) {
        WidgetModel widgetModel;
        WidgetListModel widgetListModel = this.getWidgetList();
        boolean bl = false;
        if (widgetListModel == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        widgetListModel.findTouchEventConsumingWidgets(arrayList, touchEvent);
        if (arrayList.size() > 0 && (widgetModel = (WidgetModel)arrayList.get(0)) instanceof ScrollbarModel && (bl = widgetModel.consumeTouchEvent(touchEvent))) {
            this.setTouchedWidget(widgetModel);
        }
        return bl;
    }

    @Override
    protected boolean forwardHMIEventToListImplementation(HMIEvent hMIEvent, String string) {
        WidgetListModel widgetListModel = this.getWidgetList();
        boolean bl = false;
        if (widgetListModel == null) {
            return bl;
        }
        int n = widgetListModel.get_selectedIndex();
        int n2 = widgetListModel.getFirstVisibleIndex();
        int n3 = widgetListModel.getLastVisibleIndex();
        if (n != -1) {
            if (string == "press") {
                if (widgetListModel.isSnapAnimationRunning() && widgetListModel.isSnapAnimationStoppableByUser() && (n < n2 || n > n3)) {
                    widgetListModel.stopInternalAnimations();
                    bl = true;
                }
                bl |= this.validateSelectionLocking();
            } else if (string == "release") {
                if (n < n2) {
                    widgetListModel.set_selectedIndex(-1);
                    widgetListModel.snap(n2, 0);
                    widgetListModel.set_selectedIndex(n2);
                } else if (n > n3) {
                    widgetListModel.set_selectedIndex(-1);
                    widgetListModel.snap(n3, 1);
                    widgetListModel.set_selectedIndex(n3);
                }
            }
        }
        return bl;
    }

    private boolean validateSelectionLocking() {
        int n;
        boolean bl = false;
        WidgetListModel widgetListModel = this.getWidgetList();
        ListItemModel listItemModel = widgetListModel.getItem(n = widgetListModel.get_selectedIndex());
        if (listItemModel != null && listItemModel.is_lockable() && listItemModel.hasSubItem() && listItemModel.get_subItemRefs()[0].hasSubSlider()) {
            widgetListModel.stopExpandAndCollapseAnimation();
            int n2 = listItemModel.get_activatedIndex();
            int n3 = listItemModel.getRelativeItemIndex(n2);
            int n4 = widgetListModel.getAbsIndexByListItemDynamicIndex(listItemModel, n3);
            ListItemModel listItemModel2 = listItemModel.get_subItemRefs()[0];
            widgetListModel.transferData(listItemModel2, n + 1, 0);
            if (widgetListModel.isSelectionLocked()) {
                widgetListModel.unlockSelection();
            } else if (listItemModel2.is_enabled()) {
                if (n2 != -1 && n4 == n) {
                    bl = true;
                }
                widgetListModel.lockSelection();
                int n5 = widgetListModel.getAbsIndexByListItemDynamicIndex(listItemModel.get_subItemRefs()[0], 0);
                if (n5 > widgetListModel.getLastFullyVisibleIndex()) {
                    widgetListModel.snap(n5, 1);
                }
            }
        } else {
            widgetListModel.unlockSelection();
        }
        return bl;
    }

    @Override
    protected boolean forwardHMIEventToListItem(HMIEvent hMIEvent, String string, int n, boolean bl) {
        WidgetListModel widgetListModel = this.getWidgetList();
        boolean bl2 = false;
        if (widgetListModel != null && n >= 0 && n < widgetListModel.get_itemCount()) {
            ListItemModel listItemModel;
            boolean bl3 = string != "press" && string != "release";
            ListItemModel listItemModel2 = widgetListModel.getItem(n);
            ListItemModel listItemModel3 = listItemModel2 != null && listItemModel2.hasActivatedSubItem() ? widgetListModel.getItem(n + 1) : null;
            ListItemModel listItemModel4 = listItemModel = widgetListModel.isSelectionLocked() && bl3 ? listItemModel3 : listItemModel2;
            if (listItemModel != null) {
                WidgetController widgetController = listItemModel.getController();
                widgetListModel.setFocusedIndex(n);
                this.prepareListItem(listItemModel, n);
                widgetController.addOutEventListener(this.listItemEventHandler);
                bl2 = listItemModel.consumeHMIEvent(hMIEvent, string);
                widgetController.removeOutEventListener(this.listItemEventHandler);
                if (bl && !bl2) {
                    ((ListItemController)widgetController).fire_itemTriggerFailed();
                }
            }
        }
        return bl2;
    }

    private WidgetListModel getWidgetList() {
        return (WidgetListModel)this.getList();
    }

    private void selectNewPage(boolean bl) {
        int n;
        WidgetListModel widgetListModel = (WidgetListModel)this.getWidget();
        Rectangle rectangle = widgetListModel.getViewport();
        int n2 = rectangle.x;
        int n3 = rectangle.y;
        int n4 = n = bl ? widgetListModel.getBlockIncrement() : -widgetListModel.getBlockIncrement();
        if (widgetListModel.isVertical()) {
            n3 = Util.clamp(n3 + n, widgetListModel.getMinimum(), widgetListModel.getMaximum());
        } else {
            n2 = Util.clamp(n2 + n, widgetListModel.getMinimum(), widgetListModel.getMaximum());
        }
        AbstractList.disableListSelection();
        if (rectangle.x != n2 || rectangle.y != n3) {
            widgetListModel.startSnapAnimation(n2, n3, widgetListModel.get_easing()[10]);
        }
    }

    @Override
    public void fire_selectNext() {
        WidgetListModel widgetListModel = this.getWidgetList();
        if (widgetListModel.isExpandAnimationRunning() || widgetListModel.isCollapseAnimationRunning()) {
            widgetListModel.stopCollapseAnimation();
            widgetListModel.stopExpandAnimation();
        }
        if (!widgetListModel.isSubItemExpandCollapsePending()) {
            super.fire_selectNext();
        }
    }

    @Override
    public void fire_selectPrevious() {
        WidgetListModel widgetListModel = this.getWidgetList();
        if (widgetListModel.isExpandAnimationRunning() || widgetListModel.isCollapseAnimationRunning()) {
            widgetListModel.stopCollapseAnimation();
            widgetListModel.stopExpandAnimation();
        }
        if (!widgetListModel.isSubItemExpandCollapsePending()) {
            super.fire_selectPrevious();
        }
    }

    @Override
    public void fire_selectNextPage() {
        WidgetListModel widgetListModel = (WidgetListModel)this.getWidget();
        if (widgetListModel.get_scrollTypeTouch() == 2) {
            this.selectNewPage(true);
        } else {
            AbstractList.disableListSelection();
            widgetListModel.snap(Util.clamp(widgetListModel.getLastFullyVisibleIndex() + 1, 0, widgetListModel.get_itemCount() - 1), 0);
        }
    }

    @Override
    public void fire_selectPreviousPage() {
        WidgetListModel widgetListModel = (WidgetListModel)this.getWidget();
        if (widgetListModel.get_scrollTypeTouch() == 2) {
            this.selectNewPage(false);
        } else {
            AbstractList.disableListSelection();
            widgetListModel.snap(Util.clamp(widgetListModel.getFirstFullyVisibleIndex() - 1, 0, widgetListModel.get_itemCount() - 1), 1);
        }
    }

    @Override
    public void fire_activateBrowsing() {
        this.getWidgetList().activateBrowsing();
    }

    @Override
    public void fire_pageChanged(int n) {
        this.fireIntegerEvent("pageChanged", n);
    }

    @Override
    public void fire_itemExpanded() {
        this.fireHMIEvent("itemExpanded");
    }

    @Override
    public void fire_itemCollapsed() {
        this.fireHMIEvent("itemCollapsed");
    }
}

