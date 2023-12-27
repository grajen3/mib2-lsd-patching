/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Insets;
import de.vw.mib.list.ListItemControl;
import de.vw.mib.list.ListItemControlListener;
import de.vw.mib.list.StringIndex;
import de.vw.mib.widgets.interfaces.WidgetCloneData;
import de.vw.mib.widgets.interfaces.WidgetCloneable;
import de.vw.mib.widgets.list.ListItemChangedListener;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.TransformContainerModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.List;

public interface ListItemModel
extends TransformContainerModel,
WidgetCloneable,
ListItemControlListener {
    public static final int PID_BASE;
    public static final int PID_DYNAMIC_INDEX;
    public static final int PID_OBJECT_ID;
    public static final int PID_EXISTENCE_FLAGS;
    public static final int PID_DROP_DOWN_INDEX;
    public static final int PID_SUB_ITEM_REFS;
    public static final int PID_SELECTED_BUTTON_REFS;
    public static final int PID_ACTIVATED_BUTTON_REFS;
    public static final int PID_ACTIVATED_INDEX;
    public static final int PID_NUMBER_CONTAINER_REF;
    public static final int PID_NUMBER_TEXT_REF;
    public static final int PID_DUMMY_CONTENT_REF;
    public static final int PID_SELECTABLE;
    public static final int PID_DRAGGABLE;
    public static final int PID_LOCKABLE;
    public static final int PID_DRAG_INSETS;
    public static final int PID_EFFECT_WIDGET_REFS;
    public static final int PID_CURSOR_INSETS;
    public static final int PID_DYNAMIC_RESIZE_DIRECTION;
    public static final int PID_DYNAMIC_RESIZE_PADDING;
    public static final int PID_DYNAMIC_RESIZE_WIDGET_REF;
    public static final int PID_LIMITATION;
    public static final int PID_COUNT_LISTITEM;
    public static final int SID_BASE;
    public static final int SID_ACTIVE;
    public static final int SID_ASSIGNED;
    public static final int SID_DATA_INVALID;
    public static final int SID_DRAGGABLE;
    public static final int SID_DUMMY;
    public static final int SID_LOCKABLE;
    public static final int SID_SELECTABLE;
    public static final int SID_COUNT_LISTITEM;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_COUNT_LISTITEM;
    public static final int ACTIVATED_INDEX_NONE;
    public static final int ABSOLUTE_INDEX_NONE;
    public static final int ACTION_INDEX_NONE;
    public static final int LIST_VIEW_INDEX_NONE;
    public static final int DROPDOWN_INDEX_NONE;
    public static final int DRAGGED_INDEX_NONE;
    public static final long OBJECT_ID_NONE;
    public static final int DYNAMICRESIZEDIRECTION_NONE;
    public static final int DYNAMICRESIZEDIRECTION_HORIZONTAL;
    public static final int DYNAMICRESIZEDIRECTION_VERTICAL;
    public static final int ITEM_NUMBER_OFF;
    public static final int ITEM_NUMBER_NONE;
    public static final int ITEM_NUMBER_START;
    public static final int LIMITATION_DEFAULT;
    public static final int LIMITATION_DYNAMIC_SIZE;

    default public int get_dynamicIndex() {
    }

    default public void set_dynamicIndex(int n) {
    }

    default public int getActionIndex() {
    }

    default public void setActionIndex(int n) {
    }

    default public boolean[] get_existenceFlags() {
    }

    default public void set_existenceFlags(boolean[] blArray) {
    }

    default public int get_dropDownIndex() {
    }

    default public void set_dropDownIndex(int n) {
    }

    default public void set_objectID(long l) {
    }

    default public long get_objectID() {
    }

    default public void set_subItemRefs(ListItemModel[] listItemModelArray) {
    }

    default public ListItemModel[] get_subItemRefs() {
    }

    default public void set_selectedButtonRefs(AbstractButtonModel[] abstractButtonModelArray) {
    }

    default public AbstractButtonModel[] get_selectedButtonRefs() {
    }

    default public void set_activatedButtonRefs(AbstractButtonModel[] abstractButtonModelArray) {
    }

    default public AbstractButtonModel[] get_activatedButtonRefs() {
    }

    default public int get_activatedIndex() {
    }

    default public void set_activatedIndex(int n) {
    }

    default public ContainerModel get_numberContainerRef() {
    }

    default public void set_numberContainerRef(ContainerModel containerModel) {
    }

    default public TextAreaModel get_numberTextRef() {
    }

    default public void set_numberTextRef(TextAreaModel textAreaModel) {
    }

    default public void set_dummyContentRef(WidgetModel widgetModel) {
    }

    default public WidgetModel get_dummyContentRef() {
    }

    default public boolean is_selectable() {
    }

    default public void set_selectable(boolean bl) {
    }

    default public boolean is_draggable() {
    }

    default public void set_draggable(boolean bl) {
    }

    default public boolean is_lockable() {
    }

    default public void set_lockable(boolean bl) {
    }

    default public Insets get_dragInsets() {
    }

    default public void set_dragInsets(Insets insets) {
    }

    default public WidgetModel[] get_effectWidgetRefs() {
    }

    default public void set_effectWidgetRefs(WidgetModel[] widgetModelArray) {
    }

    default public Insets get_cursorInsets() {
    }

    default public void set_cursorInsets(Insets insets) {
    }

    default public void set_dynamicResizeDirection(int n) {
    }

    default public int get_dynamicResizeDirection() {
    }

    default public void set_dynamicResizePadding(Insets insets) {
    }

    default public Insets get_dynamicResizePadding() {
    }

    default public WidgetModel get_dynamicResizeWidgetRef() {
    }

    default public void set_dynamicResizeWidgetRef(WidgetModel widgetModel) {
    }

    default public int get_limitation() {
    }

    default public void set_limitation(int n) {
    }

    default public void setAbsoluteIndex(int n) {
    }

    default public int getAbsoluteIndex() {
    }

    default public void setDropIndex(int n) {
    }

    default public int getDropIndex() {
    }

    default public void setActivatedIndexPrev(int n) {
    }

    default public int getActivatedIndexPrev() {
    }

    default public int getActivatedIndexAPI() {
    }

    default public int getExistenceItemCount() {
    }

    default public int getExistenceItemIndex(int n) {
    }

    default public int getRelativeItemIndex(int n) {
    }

    default public int getItemCount() {
    }

    default public void setSubItem(boolean bl) {
    }

    default public boolean isSubItem() {
    }

    default public boolean hasSubItem() {
    }

    default public boolean hasActivatedSubItem() {
    }

    default public int getSubItemCount() {
    }

    default public void delegateActivated(boolean bl) {
    }

    default public void delegateSelected(boolean bl) {
    }

    default public void setItemNumber(int n) {
    }

    default public int getItemNumber() {
    }

    default public AbstractButtonModel findFirstSelectedButton() {
    }

    @Override
    default public WidgetCloneData getCloneData() {
    }

    @Override
    default public void setCloneData(WidgetCloneData widgetCloneData) {
    }

    default public List getItemClones() {
    }

    default public void setDragItemClone(ListItemModel listItemModel) {
    }

    default public ListItemModel getDragItemClone() {
    }

    default public void setHelperItemClone(ListItemModel listItemModel) {
    }

    default public ListItemModel getHelperItemClone() {
    }

    default public boolean isDataInvalid() {
    }

    default public void setDataInvalid(boolean bl) {
    }

    default public void setDataInvalidAll(boolean bl) {
    }

    default public ListItemControl getListItemControl() {
    }

    default public void setListItemControl(ListItemControl listItemControl) {
    }

    default public void setListItemChangedListener(ListItemChangedListener listItemChangedListener) {
    }

    default public void disableListItemChanged() {
    }

    default public void enableListItemChanged() {
    }

    default public void disableTransfer() {
    }

    default public void enableTransfer() {
    }

    default public boolean isTransferEnabled() {
    }

    default public boolean isDummy() {
    }

    default public void setDummy(boolean bl) {
    }

    default public boolean isActive() {
    }

    default public void setActive(boolean bl) {
    }

    default public boolean isAssigned() {
    }

    default public void setAssigned(boolean bl) {
    }

    default public void setAssignedAll(boolean bl) {
    }

    default public boolean hasSubSlider() {
    }

    default public boolean isDynamic() {
    }

    default public void freeze() {
    }

    default public void unfreeze() {
    }

    default public void forceUnfreeze() {
    }

    default public boolean isStringIndexSupported() {
    }

    default public StringIndex getStringIndex() {
    }

    default public void updateListView(int n, int n2) {
    }

    default public void performDynamicResize() {
    }

    default public void performDynamicResizeAll() {
    }
}

