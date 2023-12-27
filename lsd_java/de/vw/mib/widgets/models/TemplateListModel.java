/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Point;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.interfaces.Draggable;
import de.vw.mib.widgets.interfaces.WidgetCloneFactoryRegister;
import de.vw.mib.widgets.list.ListItemTransfer;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.ListModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.WidgetModel;

public interface TemplateListModel
extends ListModel,
Adjustable,
AdjustmentListener,
WidgetCloneFactoryRegister,
Draggable {
    public static final int PID_BASE;
    public static final int PID_FIRST_ITEM_INDEX;
    public static final int PID_FIRST_ITEM_INDEX_POSITION;
    public static final int PID_SCROLL_TYPE_TOUCH;
    public static final int PID_SCROLL_TYPE_ROTARY;
    public static final int PID_ITEM_COUNT;
    public static final int PID_FOLLOW_MODE;
    public static final int PID_FOLLOW_MODE_DELAY;
    public static final int PID_FOLLOW_ITEM_REF;
    public static final int PID_FOLLOW_ITEM_REFS;
    public static final int PID_FOLLOW_ITEM_POSITION;
    public static final int PID_FORWARD_PRESS_DELAY;
    public static final int PID_LIST_CONTROL_ENABLED;
    public static final int PID_DYNAMIC_ITEM_SIZE;
    public static final int PID_READ_OUT_ENABLED;
    public static final int PID_SPELLING_ENABLED;
    public static final int PID_DRAG_DROP_ENABLED;
    public static final int PID_LETTER_SCROLLING_ENABLED;
    public static final int PID_LETTER_SCROLLING_SUPPORTED;
    public static final int PID_LETTER_SCROLLING_INDICATOR_MODE;
    public static final int PID_LETTER_SCROLLING_INDICATOR_REF;
    public static final int PID_LETTER_SCROLLING_TEXT_REF;
    public static final int PID_LIST_VIEW_OBSERVER_ENABLED;
    public static final int PID_LIST_VIEW_OBSERVER_DELAY;
    public static final int PID_ORDER_INVERTED;
    public static final int PID_ALIGNMENT;
    public static final int PID_ITEM_POINTS;
    public static final int PID_ITEM_NUMBERING_ENABLED;
    public static final int PID_COUNT_TEMPLATE_LIST;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_TEMPLATE_LIST;
    public static final int SID_BASE;
    public static final int SID_FOLLOW_MODE;
    public static final int SID_LISTCONTROL_ENABLED;
    public static final int SID_DYNAMIC_ITEM_SIZE;
    public static final int SID_READOUT_ENABLED;
    public static final int SID_SPELLING_ENABLED;
    public static final int SID_DRAG_DROP_ENABLED;
    public static final int SID_LETTER_SCROLLING_ENABLED;
    public static final int SID_LETTER_SCROLLING_SUPPORTED;
    public static final int SID_LETTER_SCROLLING_INDICATOR_ACTIVE;
    public static final int SID_LIST_VIEW_OBSERVER_ENABLED;
    public static final int SID_ORDER_INVERTED;
    public static final int SID_ITEM_NUMBERING_ENABLED;
    public static final int SID_COUNT_TEMPLATE_LIST;
    public static final int SCROLLTYPEROTARY_NONE;
    public static final int SCROLLTYPEROTARY_LAST_ELEMENT;
    public static final int SCROLLTYPEROTARY_PRELAST_ELEMENT;
    public static final int SCROLLTYPEROTARY_PAGEWISE;
    public static final int SCROLLTYPETOUCH_NONE;
    public static final int SCROLLTYPETOUCH_ITEMWISE;
    public static final int SCROLLTYPETOUCH_PAGEWISE;
    public static final int SCROLLTYPETOUCH_STEPLESS;
    public static final int SCROLLTYPETOUCH_TWOFINGER;
    public static final int LETTER_SCROLLING_INDICATOR_MODE_STATIC;
    public static final int LETTER_SCROLLING_INDICATOR_MODE_VERTICAL;
    public static final int LETTER_SCROLLING_INDICATOR_MODE_HORIZONTAL;
    public static final int ALIGNMENT_TOP_LEFT;
    public static final int ALIGNMENT_BOTTOM_RIGHT;
    public static final int ALIGNMENT_CENTER;
    public static final int SNAP_POSITION_FIRST;
    public static final int SNAP_POSITION_LAST;
    public static final int VISIBLE_INDEX_NONE;
    public static final int FOCUSED_INDEX_NONE;
    public static final int DRAG_INDEX_NONE;
    public static final int DROP_INDEX_NONE;
    public static final int ACTIVATED_INDEX_NONE;
    public static final int PRESSED_INDEX_NONE;
    public static final int INDEX_NONE;
    public static final int INITIAL_SELECTION_MODE_ACTIVE_INDEX;
    public static final int INITIAL_SELECTION_MODE_ACTIVE_INDEX_STATE;

    default public int get_firstItemIndex() {
    }

    default public void set_firstItemIndex(int n) {
    }

    default public int get_firstItemIndexPosition() {
    }

    default public void set_firstItemIndexPosition(int n) {
    }

    default public int get_scrollTypeTouch() {
    }

    default public void set_scrollTypeTouch(int n) {
    }

    default public int get_scrollTypeRotary() {
    }

    default public void set_scrollTypeRotary(int n) {
    }

    default public int get_itemCount() {
    }

    default public void set_itemCount(int n) {
    }

    default public boolean is_followMode() {
    }

    default public void set_followMode(boolean bl) {
    }

    default public ListItemModel[] get_followItemRefs() {
    }

    default public void set_followItemRefs(ListItemModel[] listItemModelArray) {
    }

    default public int get_followItemPosition() {
    }

    default public void set_followItemPosition(int n) {
    }

    default public int get_forwardPressDelay() {
    }

    default public void set_forwardPressDelay(int n) {
    }

    default public void set_listControlEnabled(boolean bl) {
    }

    default public boolean is_listControlEnabled() {
    }

    default public void set_followModeDelay(int n) {
    }

    default public int get_followModeDelay() {
    }

    default public boolean is_dynamicItemSize() {
    }

    default public void set_dynamicItemSize(boolean bl) {
    }

    default public boolean is_dragDropEnabled() {
    }

    default public void set_dragDropEnabled(boolean bl) {
    }

    default public boolean is_letterScrollingEnabled() {
    }

    default public void set_letterScrollingEnabled(boolean bl) {
    }

    default public boolean is_letterScrollingSupported() {
    }

    default public void set_letterScrollingSupported(boolean bl) {
    }

    default public int get_letterScrollingIndicatorMode() {
    }

    default public void set_letterScrollingIndicatorMode(int n) {
    }

    default public WidgetModel get_letterScrollingIndicatorRef() {
    }

    default public void set_letterScrollingIndicatorRef(WidgetModel widgetModel) {
    }

    default public TextAreaModel get_letterScrollingTextRef() {
    }

    default public void set_letterScrollingTextRef(TextAreaModel textAreaModel) {
    }

    default public boolean is_listViewObserverEnabled() {
    }

    default public void set_listViewObserverEnabled(boolean bl) {
    }

    default public int get_listViewObserverDelay() {
    }

    default public void set_listViewObserverDelay(int n) {
    }

    default public boolean is_orderInverted() {
    }

    default public void set_orderInverted(boolean bl) {
    }

    default public int get_alignment() {
    }

    default public void set_alignment(int n) {
    }

    default public Point[] get_itemPoints() {
    }

    default public void set_itemPoints(Point[] pointArray) {
    }

    default public boolean is_itemNumberingEnabled() {
    }

    default public void set_itemNumberingEnabled(boolean bl) {
    }

    default public ListItemTransfer getListItemTransfer() {
    }

    default public void setListItemTransfer(ListItemTransfer listItemTransfer) {
    }

    default public void transferData(ListItemModel listItemModel, int n, int n2) {
    }

    default public void transferStates(ListItemModel listItemModel, int n, int n2) {
    }

    default public int getAbsIndexByListItemDynamicIndex(ListItemModel listItemModel, int n) {
    }

    default public ListItemModel getItem(int n) {
    }

    default public ListItemModel getItemMaster(int n) {
    }

    default public boolean isItemSelectable(int n) {
    }

    default public ListItemModel[] getListItems() {
    }

    default public int getItemIndex(int n) {
    }

    default public void setFocusedIndex(int n) {
    }

    default public int getFocusedIndex() {
    }

    default public void setPressedIndex(int n) {
    }

    default public int getPressedIndex() {
    }

    default public void setActivatedIndex(int n) {
    }

    default public int getActivatedIndex() {
    }

    default public int getFirstVisibleIndex() {
    }

    default public int getFirstMostlyVisibleIndex() {
    }

    default public int getFirstFullyVisibleIndex() {
    }

    default public int getLastVisibleIndex() {
    }

    default public int getLastMostlyVisibleIndex() {
    }

    default public int getLastFullyVisibleIndex() {
    }

    default public void validateItemClones() {
    }

    default public void freeze() {
    }

    default public boolean isDynamic() {
    }

    default public void validateList() {
    }

    default public void unfreeze() {
    }

    default public void forceUnfreeze() {
    }

    default public void disableFollowMode() {
    }

    default public void lockSelection() {
    }

    default public void unlockSelection() {
    }

    default public boolean isSelectionLocked() {
    }

    default public int getDragIndex() {
    }

    default public int getDropIndex() {
    }

    default public void dragItem(int n) {
    }

    default public void moveItem(int n, int n2) {
    }

    default public void dropItem() {
    }

    default public int getChildIndexFirstItem() {
    }

    default public int getChildIndexLastItem() {
    }

    default public String getLetterScrollingText() {
    }

    default public boolean isLetterScrollingIndicatorActive() {
    }

    default public void setLetterScrollingIndicatorActive(boolean bl) {
    }

    default public void snap(int n, int n2) {
    }

    default public void snapPage(int n, boolean bl) {
    }

    default public boolean isPaging() {
    }

    default public boolean isVertical() {
    }

    default public boolean isMultiColumn() {
    }

    default public boolean isFastScrollingSupported() {
    }

    default public void performIndexedAdjustment(int n, int n2) {
    }

    default public void performDefaultAdjustment(int n, int n2) {
    }

    default public void performPagingAdjustment(int n, int n2) {
    }

    default public void setInitialSelectionMode(int n) {
    }

    default public int getInitialSelectionMode() {
    }

    default public void resetListView() {
    }

    default public boolean isSubItemExpandCollapsePending() {
    }
}

