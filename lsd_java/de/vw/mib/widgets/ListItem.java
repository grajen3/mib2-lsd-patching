/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.list.ListItemControl;
import de.vw.mib.list.StringIndex;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.TransformContainer;
import de.vw.mib.widgets.interfaces.WidgetCloneData;
import de.vw.mib.widgets.list.ListItemChangedListener;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.SliderModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListItem
extends TransformContainer
implements ListItemModel {
    private static final int DEFAULT_ITEM_COUNT;
    private static final String ITEM_NUMBER_EMPTY_TEXT;
    private int dynamicIndex;
    private int activatedIndex;
    private boolean[] existenceFlags;
    private long objectID;
    private int dropDownIndex;
    private ListItemModel[] subItemRefs;
    private AbstractButtonModel[] selectedButtonRefs;
    private AbstractButtonModel[] activatedButtonRefs;
    private ContainerModel numberContainerRef;
    private TextAreaModel numberTextRef;
    private WidgetModel dummyContentRef;
    private WidgetModel[] effectWidgetRefs;
    private Insets dragInsets;
    private Insets cursorInsets;
    private int dynamicResizeDirection;
    private Insets dynamicResizePadding;
    private WidgetModel dynamicResizeWidgetRef;
    private int limitation;
    private int activatedIndexAPI;
    private int absoluteIndex;
    private int activatedIndexPrev;
    private int actionIndex;
    private int dropIndex;
    private int itemCount;
    private boolean subItem;
    private WidgetCloneData cloneData;
    private List itemClones;
    private ListItemModel dragItemClone;
    private ListItemModel helperItemClone;
    private int transferShadowCounter;
    private ListItemControl listItemControl;
    private ListItemChangedListener listItemChangedListener;
    private SliderModel subSlider;
    private int listItemChangedShadow;
    private int itemNumber;
    private int listViewFirstIndex;
    private int listViewCount;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ListItemUI;

    @Override
    protected void reset() {
        super.reset();
        this.itemCount = 1;
        this.existenceFlags = null;
        this.cloneData = null;
        this.itemClones = null;
        this.dragItemClone = null;
        this.listItemChangedListener = null;
        this.listItemControl = null;
        this.numberContainerRef = null;
        this.numberTextRef = null;
        this.subSlider = null;
        this.subItem = false;
        this.transferShadowCounter = 0;
    }

    public void init(boolean bl, AbstractButtonModel[] abstractButtonModelArray, int n, int n2, Image image, boolean bl2, float f2, boolean bl3, Insets insets, int n3, int n4, boolean bl4, Insets insets2, int n5, WidgetModel widgetModel, int n6, int n7, Insets insets3, WidgetModel widgetModel2, EasingParams[] easingParamsArray, WidgetModel[] widgetModelArray, boolean bl5, boolean[] blArray, int n8, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, int n9, boolean bl7, String string, ContainerModel containerModel, TextAreaModel textAreaModel, long l, float f3, float f4, float f5, float f6, float f7, float f8, int n10, int n11, Image image2, int n12, boolean bl8, float f9, float f10, float f11, float f12, float f13, float f14, boolean bl9, AbstractButtonModel[] abstractButtonModelArray2, ListItemModel[] listItemModelArray, int n13, Insets insets4, boolean bl10, int n14, int n15, int n16, int n17) {
        super.init(bl, n2, image, bl2, f2, bl3, n3, n4, easingParamsArray, bl5, n8, keyframeAnimationArray, bl6, layoutAttribs, string, f3, f4, f5, f6, f7, f8, n10, n11, image2, n12, bl8, f9, f10, f11, f12, f13, f14, n13, insets4, bl10, n14, n15, n16, n17);
        this.cursorInsets = insets;
        this.dragInsets = insets2;
        this.effectWidgetRefs = widgetModelArray;
        this.dummyContentRef = widgetModel;
        this.dynamicIndex = n6;
        this.existenceFlags = blArray;
        this.dropDownIndex = n5;
        this.dynamicResizeDirection = n7;
        this.dynamicResizePadding = insets3;
        this.dynamicResizeWidgetRef = widgetModel2;
        this.limitation = n9;
        this.objectID = l;
        this.subItemRefs = listItemModelArray;
        this.selectedButtonRefs = abstractButtonModelArray2;
        this.activatedButtonRefs = abstractButtonModelArray;
        this.activatedIndex = n;
        this.numberContainerRef = containerModel;
        this.numberTextRef = textAreaModel;
        this.setInternalStateFlag(21, bl4);
        this.setInternalStateFlag(23, bl7);
        this.setInternalStateFlag(24, bl9);
    }

    public void init(boolean bl, AbstractButtonModel[] abstractButtonModelArray, int n, int n2, Image image, boolean bl2, boolean bl3, Insets insets, int n3, int n4, boolean bl4, Insets insets2, int n5, WidgetModel widgetModel, int n6, int n7, Insets insets3, WidgetModel widgetModel2, EasingParams[] easingParamsArray, WidgetModel[] widgetModelArray, boolean bl5, boolean[] blArray, int n8, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, int n9, boolean bl7, String string, ContainerModel containerModel, TextAreaModel textAreaModel, long l, float f2, float f3, float f4, float f5, float f6, float f7, int n10, int n11, Image image2, int n12, boolean bl8, float f8, float f9, float f10, float f11, float f12, float f13, boolean bl9, AbstractButtonModel[] abstractButtonModelArray2, ListItemModel[] listItemModelArray, int n13, Insets insets4, boolean bl10, int n14, int n15, int n16, int n17) {
        this.init(bl, abstractButtonModelArray, n, n2, image, bl2, 0.0f, bl3, insets, n3, n4, bl4, insets2, n5, widgetModel, n6, n7, insets3, widgetModel2, easingParamsArray, widgetModelArray, bl5, blArray, n8, keyframeAnimationArray, bl6, layoutAttribs, n9, bl7, string, containerModel, textAreaModel, l, f2, f3, f4, f5, f6, f7, n10, n11, image2, n12, bl8, f8, f9, f10, f11, f12, f13, bl9, abstractButtonModelArray2, listItemModelArray, n13, insets4, bl10, n14, n15, n16, n17);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.absoluteIndex = -1;
        this.activatedIndexPrev = -1;
        this.dragItemClone = this;
        this.helperItemClone = this;
        this.listItemChangedShadow = 0;
        this.transferShadowCounter = 0;
        this.listViewCount = 0;
        this.listViewFirstIndex = -1;
        this.delegateSelected(false);
        this.delegateActivated(false);
        this.updateSubItemRefs(null, this.get_subItemRefs());
        this.selectedButtonRefsChanged(null);
        this.setActive(false);
        this.setAssigned(false);
        this.setDataInvalid(true);
    }

    @Override
    public void deInit() {
        if (this.listItemControl != null) {
            this.listItemControl.removeListItemControlListener(this);
        }
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ListItemUI == null ? (class$de$vw$mib$widgets$ui$ListItemUI = ListItem.class$("de.vw.mib.widgets.ui.ListItemUI")) : class$de$vw$mib$widgets$ui$ListItemUI};
    }

    @Override
    public final int get_dynamicIndex() {
        return this.dynamicIndex;
    }

    protected void updateRenderOffscreenStatus() {
    }

    @Override
    public final void set_dynamicIndex(int n) {
        int n2 = this.dynamicIndex;
        this.dynamicIndex = n;
        this.propertyChanged(40);
        this.dynamicIndexChanged(n2);
    }

    @Override
    public int getActionIndex() {
        return this.actionIndex;
    }

    @Override
    public void setActionIndex(int n) {
        this.actionIndex = n;
    }

    @Override
    public final boolean[] get_existenceFlags() {
        return this.existenceFlags;
    }

    @Override
    public final void set_existenceFlags(boolean[] blArray) {
        boolean[] blArray2 = this.existenceFlags;
        if (!Arrays.equals(blArray2, blArray)) {
            this.existenceFlags = blArray;
            this.existenceFlagsChanged(blArray2);
            this.propertyChanged(42);
        }
    }

    @Override
    public final int get_dropDownIndex() {
        return this.dropDownIndex;
    }

    @Override
    public final void set_dropDownIndex(int n) {
        int n2 = this.dropDownIndex;
        if (n2 != n) {
            this.dropDownIndex = n;
            this.dropDownIndexChanged(n2);
            this.propertyChanged(43);
        }
    }

    @Override
    public final long get_objectID() {
        return this.objectID;
    }

    @Override
    public final void set_objectID(long l) {
        long l2 = this.objectID;
        if (l2 != l) {
            this.objectID = l;
            this.objectIDChanged(l2);
            this.propertyChanged(41);
        }
    }

    @Override
    public final ListItemModel[] get_subItemRefs() {
        return this.subItemRefs;
    }

    @Override
    public final void set_subItemRefs(ListItemModel[] listItemModelArray) {
        ListItemModel[] listItemModelArray2 = this.subItemRefs;
        if (listItemModelArray2 != listItemModelArray) {
            this.subItemRefs = listItemModelArray;
            this.subItemRefsChanged(listItemModelArray2);
            this.propertyChanged(44);
        }
    }

    @Override
    public final ContainerModel get_numberContainerRef() {
        return this.numberContainerRef;
    }

    @Override
    public final void set_numberContainerRef(ContainerModel containerModel) {
        ContainerModel containerModel2 = this.numberContainerRef;
        if (containerModel2 != containerModel) {
            this.numberContainerRef = containerModel;
            this.numberContainerRefChanged(containerModel2);
            this.propertyChanged(49);
        }
    }

    @Override
    public final TextAreaModel get_numberTextRef() {
        return this.numberTextRef;
    }

    @Override
    public final void set_numberTextRef(TextAreaModel textAreaModel) {
        TextAreaModel textAreaModel2 = this.numberTextRef;
        if (textAreaModel2 != textAreaModel) {
            this.numberTextRef = textAreaModel;
            this.numberTextRefChanged(textAreaModel2);
            this.propertyChanged(50);
        }
    }

    @Override
    public final WidgetModel get_dummyContentRef() {
        return this.dummyContentRef;
    }

    @Override
    public final void set_dummyContentRef(WidgetModel widgetModel) {
        WidgetModel widgetModel2 = this.dummyContentRef;
        if (widgetModel2 != widgetModel) {
            this.dummyContentRef = widgetModel;
            this.dummyContentRefChanged(widgetModel2);
            this.propertyChanged(51);
        }
    }

    @Override
    public boolean isSubItem() {
        return this.subItem;
    }

    @Override
    public void setSubItem(boolean bl) {
        this.subItem = bl;
    }

    @Override
    public final int get_activatedIndex() {
        return this.activatedIndex;
    }

    @Override
    public final void set_activatedIndex(int n) {
        int n2 = this.activatedIndex;
        if (n2 != n) {
            this.setActivatedIndexPrev(n2);
            this.activatedIndex = n;
            this.activatedIndexHMIChanged(n2);
            this.propertyChanged(47);
        }
    }

    @Override
    public final boolean is_selectable() {
        return this.getInternalStateFlag(24);
    }

    @Override
    public final void set_selectable(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(24);
        if (bl2 != bl) {
            this.setInternalStateFlag(24, bl);
            this.selectableChanged(bl2);
            this.propertyChanged(52);
        }
    }

    @Override
    public final boolean is_draggable() {
        return this.getInternalStateFlag(21);
    }

    @Override
    public final void set_draggable(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(21);
        if (bl2 != bl) {
            this.setInternalStateFlag(21, bl);
            this.draggableChanged(bl2);
            this.propertyChanged(53);
        }
    }

    @Override
    public final boolean is_lockable() {
        return this.getInternalStateFlag(23);
    }

    @Override
    public final void set_lockable(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(23);
        if (bl2 != bl) {
            this.setInternalStateFlag(23, bl);
            this.lockableChanged(bl2);
            this.propertyChanged(54);
        }
    }

    @Override
    public final Insets get_dragInsets() {
        return this.dragInsets;
    }

    @Override
    public final void set_dragInsets(Insets insets) {
        Insets insets2 = this.dragInsets;
        if (insets2 == null || !insets2.equals(insets)) {
            this.dragInsets = insets;
            this.dragInsetsChanged(insets2);
            this.propertyChanged(55);
        }
    }

    @Override
    public final Insets get_cursorInsets() {
        return this.cursorInsets;
    }

    @Override
    public final void set_cursorInsets(Insets insets) {
        Insets insets2 = this.cursorInsets;
        if (insets2 == null || !insets2.equals(insets)) {
            this.cursorInsets = insets;
            this.cursorInsetsChanged(insets2);
            this.propertyChanged(57);
        }
    }

    @Override
    public int get_limitation() {
        return this.limitation;
    }

    @Override
    public void set_limitation(int n) {
        int n2 = this.limitation;
        if (n2 != n) {
            this.limitation = n;
            this.limitationChanged(n2);
            this.propertyChanged(61);
        }
    }

    @Override
    public boolean hasSubItem() {
        return this.subItemRefs != null && this.subItemRefs.length > 0;
    }

    @Override
    public boolean hasActivatedSubItem() {
        return this.hasSubItem() && (this.activatedIndex != -1 || this.activatedIndexPrev != -1);
    }

    @Override
    public int getSubItemCount() {
        int n = 0;
        if (this.hasActivatedSubItem()) {
            for (int i2 = 0; i2 < this.subItemRefs.length; ++i2) {
                ListItemModel listItemModel = this.subItemRefs[i2];
                if (listItemModel == null) continue;
                n += listItemModel.getExistenceItemCount();
            }
        }
        return n;
    }

    @Override
    public final AbstractButtonModel[] get_selectedButtonRefs() {
        return this.selectedButtonRefs;
    }

    @Override
    public final void set_selectedButtonRefs(AbstractButtonModel[] abstractButtonModelArray) {
        AbstractButtonModel[] abstractButtonModelArray2 = this.selectedButtonRefs;
        if (abstractButtonModelArray2 != abstractButtonModelArray) {
            this.selectedButtonRefs = abstractButtonModelArray;
            this.selectedButtonRefsChanged(abstractButtonModelArray2);
            this.propertyChanged(45);
        }
    }

    @Override
    public final AbstractButtonModel[] get_activatedButtonRefs() {
        return this.activatedButtonRefs;
    }

    @Override
    public final void set_activatedButtonRefs(AbstractButtonModel[] abstractButtonModelArray) {
        AbstractButtonModel[] abstractButtonModelArray2 = this.activatedButtonRefs;
        if (abstractButtonModelArray2 != abstractButtonModelArray) {
            this.activatedButtonRefs = abstractButtonModelArray;
            this.activatedButtonRefsChanged(abstractButtonModelArray2);
            this.propertyChanged(46);
        }
    }

    @Override
    public final WidgetModel[] get_effectWidgetRefs() {
        return this.effectWidgetRefs;
    }

    @Override
    public final void set_effectWidgetRefs(WidgetModel[] widgetModelArray) {
        WidgetModel[] widgetModelArray2 = this.effectWidgetRefs;
        if (widgetModelArray2 != widgetModelArray) {
            this.effectWidgetRefs = widgetModelArray;
            this.propertyEffectWidgetRefsChanged(widgetModelArray2);
            this.propertyChanged(56);
        }
    }

    @Override
    public int get_dynamicResizeDirection() {
        return this.dynamicResizeDirection;
    }

    @Override
    public void set_dynamicResizeDirection(int n) {
        int n2 = this.dynamicResizeDirection;
        if (n2 != n) {
            this.dynamicResizeDirection = n;
            this.dynamicResizeDirectionChanged(n2);
            this.propertyChanged(58);
        }
    }

    @Override
    public Insets get_dynamicResizePadding() {
        return this.dynamicResizePadding;
    }

    @Override
    public void set_dynamicResizePadding(Insets insets) {
        Insets insets2 = this.dynamicResizePadding;
        if (insets2 == null || !insets2.equals(insets)) {
            this.dynamicResizePadding = insets;
            this.dynamicResizePaddingChanged(insets2);
            this.propertyChanged(59);
        }
    }

    @Override
    public WidgetModel get_dynamicResizeWidgetRef() {
        return this.dynamicResizeWidgetRef;
    }

    @Override
    public void set_dynamicResizeWidgetRef(WidgetModel widgetModel) {
        WidgetModel widgetModel2 = this.dynamicResizeWidgetRef;
        if (widgetModel2 != widgetModel) {
            this.dynamicResizeWidgetRef = widgetModel;
            this.dynamicResizeWidgetRefChanged(widgetModel2);
            this.propertyChanged(60);
        }
    }

    @Override
    public List getItemClones() {
        if (this.itemClones == null) {
            this.itemClones = new ArrayList();
        }
        return this.itemClones;
    }

    @Override
    public ListItemModel getDragItemClone() {
        return this.dragItemClone;
    }

    @Override
    public void setDragItemClone(ListItemModel listItemModel) {
        this.dragItemClone = listItemModel;
    }

    @Override
    public ListItemModel getHelperItemClone() {
        return this.helperItemClone;
    }

    @Override
    public void setHelperItemClone(ListItemModel listItemModel) {
        this.helperItemClone = listItemModel;
    }

    @Override
    public int getAbsoluteIndex() {
        return this.absoluteIndex;
    }

    @Override
    public void setAbsoluteIndex(int n) {
        this.absoluteIndex = n;
    }

    @Override
    public int getDropIndex() {
        return this.dropIndex;
    }

    @Override
    public void setDropIndex(int n) {
        this.dropIndex = n;
    }

    @Override
    public int getActivatedIndexAPI() {
        return this.activatedIndexAPI;
    }

    @Override
    public int getItemCount() {
        return this.itemCount;
    }

    protected void setItemCount(int n) {
        this.itemCount = this.limitation < 0 ? n : Math.min(n, this.limitation);
    }

    @Override
    public ListItemControl getListItemControl() {
        return this.listItemControl;
    }

    @Override
    public boolean hasSubSlider() {
        return this.subSlider != null;
    }

    @Override
    public boolean isDynamic() {
        return this.listItemControl != null && this.listItemControl.getASLList() != null;
    }

    @Override
    public void setListItemControl(ListItemControl listItemControl) {
        if (this.listItemControl != null) {
            this.listItemControl.removeListItemControlListener(this);
        }
        this.listItemControl = listItemControl;
        if (this.listItemControl != null) {
            this.listItemControl.addListItemControlListener(this);
            this.setItemCount(this.listItemControl.getItemCount());
        } else {
            this.setItemCount(1);
        }
        this.notifyListItemChangedListener(0);
    }

    @Override
    public void setListItemChangedListener(ListItemChangedListener listItemChangedListener) {
        this.listItemChangedListener = listItemChangedListener;
    }

    @Override
    public boolean isTransferEnabled() {
        return this.transferShadowCounter == 0;
    }

    @Override
    public boolean isStringIndexSupported() {
        return this.listItemControl != null && this.listItemControl.getStringIndex() != null && this.listItemControl.getStringIndex().getStatus() == 2;
    }

    @Override
    public StringIndex getStringIndex() {
        return this.listItemControl != null ? this.listItemControl.getStringIndex() : null;
    }

    public void activatedIndexHMIChanged(int n) {
        this.notifyListItemChangedListener(3);
    }

    protected void activatedButtonRefsChanged(AbstractButtonModel[] abstractButtonModelArray) {
        this.notifyListItemChangedListener(0);
    }

    protected void propertyEffectWidgetRefsChanged(WidgetModel[] widgetModelArray) {
        this.notifyListItemChangedListener(0);
    }

    @Override
    protected void availableInVariantChanged(boolean bl) {
        super.availableInVariantChanged(bl);
        this.notifyListItemChangedListener(0);
    }

    protected void dynamicIndexChanged(int n) {
    }

    protected void dropDownIndexChanged(int n) {
    }

    protected void existenceFlagsChanged(boolean[] blArray) {
        this.notifyListItemChangedListener(1);
    }

    protected void objectIDChanged(long l) {
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.notifyListItemChangedListener(9);
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.notifyListItemChangedListener(10);
    }

    protected void selectedButtonRefsChanged(AbstractButtonModel[] abstractButtonModelArray) {
        if (this.selectedButtonRefs != null) {
            for (int i2 = 0; i2 < this.selectedButtonRefs.length; ++i2) {
                if (this.selectedButtonRefs[i2] == null || !(this.selectedButtonRefs[i2] instanceof SliderModel)) continue;
                this.subSlider = (SliderModel)this.selectedButtonRefs[i2];
            }
        }
    }

    protected void subItemRefsChanged(ListItemModel[] listItemModelArray) {
        this.updateSubItemRefs(listItemModelArray, this.get_subItemRefs());
        this.notifyListItemChangedListener(0);
    }

    @Override
    protected void visibleChanged(boolean bl) {
        super.visibleChanged(bl);
        this.notifyListItemChangedListener(0);
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        super.parentVisibilityChanged(bl);
        for (int i2 = this.getItemClones().size() - 1; i2 >= 0; --i2) {
            ListItem listItem = (ListItem)this.getItemClones().get(i2);
            if (!listItem.is_visible() || listItem == this) continue;
            listItem.parentVisibilityChanged(bl);
        }
    }

    @Override
    protected void enabledChanged(boolean bl) {
        super.enabledChanged(bl);
        this.notifyListItemChangedListener(0);
    }

    protected void numberContainerRefChanged(ContainerModel containerModel) {
        this.notifyListItemChangedListener(0);
    }

    protected void numberTextRefChanged(TextAreaModel textAreaModel) {
        this.notifyListItemChangedListener(0);
    }

    protected void dummyContentRefChanged(WidgetModel widgetModel) {
        this.notifyListItemChangedListener(0);
    }

    protected void selectableChanged(boolean bl) {
        this.notifyListItemChangedListener(0);
    }

    protected void draggableChanged(boolean bl) {
        this.notifyListItemChangedListener(0);
    }

    protected void lockableChanged(boolean bl) {
        this.notifyListItemChangedListener(0);
    }

    protected void dragInsetsChanged(Insets insets) {
    }

    protected void cursorInsetsChanged(Insets insets) {
        this.notifyListItemChangedListener(0);
    }

    protected void dynamicResizeDirectionChanged(int n) {
        this.notifyListItemChangedListener(0);
    }

    protected void dynamicResizePaddingChanged(Insets insets) {
        this.notifyListItemChangedListener(0);
    }

    protected void dynamicResizeWidgetRefChanged(WidgetModel widgetModel) {
        this.notifyListItemChangedListener(0);
    }

    protected void limitationChanged(int n) {
        this.validateItemCount();
    }

    @Override
    public void setActive(boolean bl) {
        this.setInternalStateFlag(18, bl);
    }

    @Override
    public boolean isActive() {
        return this.getInternalStateFlag(18);
    }

    @Override
    public boolean isAssigned() {
        return this.getInternalStateFlag(19);
    }

    @Override
    public void setAssigned(boolean bl) {
        this.setInternalStateFlag(19, bl);
    }

    @Override
    public void setAssignedAll(boolean bl) {
        this.setAssigned(bl);
        if (this.itemClones != null) {
            Iterator iterator = this.itemClones.iterator();
            while (iterator.hasNext()) {
                ListItemModel listItemModel = (ListItemModel)iterator.next();
                listItemModel.setAssigned(bl);
            }
        }
    }

    @Override
    public boolean isDataInvalid() {
        return this.getInternalStateFlag(20);
    }

    @Override
    public void setDataInvalid(boolean bl) {
        this.setInternalStateFlag(20, bl);
    }

    @Override
    public void setDataInvalidAll(boolean bl) {
        this.setDataInvalid(true);
        if (this.itemClones != null) {
            Iterator iterator = this.itemClones.iterator();
            while (iterator.hasNext()) {
                ListItemModel listItemModel = (ListItemModel)iterator.next();
                listItemModel.setDataInvalid(bl);
            }
        }
    }

    @Override
    public boolean isDummy() {
        return this.getInternalStateFlag(22);
    }

    @Override
    public void setDummy(boolean bl) {
        if (bl != this.isDummy()) {
            this.setInternalStateFlag(22, bl);
            this.repaint();
        }
    }

    @Override
    public boolean canConsumeHMIEvents() {
        return super.canConsumeHMIEvents() && this.isAssigned();
    }

    @Override
    public int getExistenceItemIndex(int n) {
        int n2 = n;
        int n3 = -1;
        if (this.existenceFlags != null && this.existenceFlags.length >= this.itemCount) {
            for (int i2 = 0; i2 < this.itemCount; ++i2) {
                if (this.existenceFlags[i2]) {
                    ++n3;
                }
                if (n3 != n) continue;
                n2 = i2;
                break;
            }
        }
        if (this.getListItemControl() != null && (this.getListItemControl().getItemCount() != this.itemCount || n2 >= this.getListItemControl().getItemCount())) {
            LogMessage logMessage = LOGGER.warn(32);
            logMessage.append("Requested index out of bounds or itemCount expired: Index=").append(n2).append(" ListItem.itemCount=").append(this.itemCount).append(" ListItemControl.itemCount=").append(this.getListItemControl().getItemCount());
        }
        return n2;
    }

    @Override
    public int getRelativeItemIndex(int n) {
        int n2 = n;
        int n3 = -1;
        if (this.existenceFlags != null && this.existenceFlags.length >= this.itemCount && this.existenceFlags.length > n) {
            for (int i2 = 0; i2 <= n; ++i2) {
                if (!this.existenceFlags[i2]) continue;
                ++n3;
            }
            n2 = n3;
        }
        return n2;
    }

    @Override
    public int getExistenceItemCount() {
        int n = this.itemCount;
        if (this.existenceFlags != null && this.existenceFlags.length >= this.itemCount) {
            n = 0;
            for (int i2 = 0; i2 < this.itemCount; ++i2) {
                if (!this.existenceFlags[i2]) continue;
                ++n;
            }
        }
        return n;
    }

    @Override
    public int getActivatedIndexPrev() {
        return this.activatedIndexPrev;
    }

    @Override
    public void setActivatedIndexPrev(int n) {
        this.activatedIndexPrev = n;
    }

    @Override
    public WidgetCloneData getCloneData() {
        return this.cloneData;
    }

    @Override
    public void setCloneData(WidgetCloneData widgetCloneData) {
        this.cloneData = widgetCloneData;
    }

    @Override
    public int getItemNumber() {
        return this.itemNumber;
    }

    @Override
    public void setItemNumber(int n) {
        this.itemNumber = n;
        if (this.numberTextRef != null && this.numberContainerRef != null) {
            switch (this.itemNumber) {
                case -2: {
                    this.numberContainerRef.set_visible(false);
                    break;
                }
                case -1: {
                    this.numberTextRef.set_text("");
                    this.numberContainerRef.set_visible(true);
                    break;
                }
                default: {
                    this.numberTextRef.set_text(Integer.toString(this.itemNumber));
                    this.numberContainerRef.set_visible(true);
                }
            }
        }
    }

    @Override
    public void disableListItemChanged() {
        ++this.listItemChangedShadow;
    }

    @Override
    public void enableListItemChanged() {
        --this.listItemChangedShadow;
    }

    private void notifyListItemChangedListener(int n, int n2, int n3) {
        if (this.listItemChangedListener != null && this.listItemChangedShadow == 0) {
            this.listItemChangedListener.listItemChanged(this, n, n2, n3);
        }
    }

    private void notifyListItemChangedListener(int n) {
        this.notifyListItemChangedListener(n, -1, -1);
    }

    @Override
    public void freeze() {
        if (this.listItemControl != null) {
            this.listItemControl.freeze();
            if (this.isDynamic()) {
                this.validateItemCount();
            }
        }
    }

    @Override
    public void unfreeze() {
        if (this.listItemControl != null) {
            this.listItemControl.unfreeze();
        }
    }

    @Override
    public void forceUnfreeze() {
        if (this.listItemControl != null) {
            this.listItemControl.forceUnfreeze();
        }
    }

    @Override
    public void disableTransfer() {
        ++this.transferShadowCounter;
    }

    @Override
    public void enableTransfer() {
        --this.transferShadowCounter;
    }

    private void updateSubItemRefs(ListItemModel[] listItemModelArray, ListItemModel[] listItemModelArray2) {
        int n;
        if (listItemModelArray != null) {
            for (n = 0; n < listItemModelArray.length; ++n) {
                if (listItemModelArray[n] == null) continue;
                listItemModelArray[n].setSubItem(false);
            }
        }
        if (listItemModelArray2 != null) {
            for (n = 0; n < listItemModelArray2.length; ++n) {
                if (listItemModelArray2[n] == null) continue;
                listItemModelArray2[n].setSubItem(true);
            }
        }
    }

    @Override
    public void delegateSelected(boolean bl) {
        if (this.selectedButtonRefs != null) {
            for (int i2 = 0; i2 < this.selectedButtonRefs.length; ++i2) {
                AbstractButtonModel abstractButtonModel = this.selectedButtonRefs[i2];
                if (abstractButtonModel == null) continue;
                abstractButtonModel.set_selected(bl);
            }
        }
    }

    @Override
    public void delegateActivated(boolean bl) {
        if (this.activatedButtonRefs != null) {
            for (int i2 = 0; i2 < this.activatedButtonRefs.length; ++i2) {
                AbstractButtonModel abstractButtonModel = this.activatedButtonRefs[i2];
                if (abstractButtonModel == null) continue;
                abstractButtonModel.set_activated(bl);
            }
        }
    }

    @Override
    public AbstractButtonModel findFirstSelectedButton() {
        AbstractButtonModel abstractButtonModel = null;
        if (this.selectedButtonRefs.length > 0) {
            for (int i2 = 0; i2 < this.selectedButtonRefs.length; ++i2) {
                AbstractButtonModel abstractButtonModel2 = this.selectedButtonRefs[i2];
                if (abstractButtonModel2 == null || !abstractButtonModel2.is_visible() || !abstractButtonModel2.is_enabled() || !abstractButtonModel2.areParentsVisible()) continue;
                abstractButtonModel = abstractButtonModel2;
                break;
            }
        }
        return abstractButtonModel;
    }

    @Override
    public void updateListView(int n, int n2) {
        if (this.listItemControl != null && (this.listViewFirstIndex != n || this.listViewCount != n2)) {
            if (LOGGER.isTraceEnabled(32)) {
                LogMessage logMessage = LOGGER.trace(32);
                logMessage.append("ListItem: '").append(this).append("': updateListView (").append(n).append(", ").append(n2).append(" )").log();
            }
            this.listItemControl.updateListView(n, n2);
            this.listViewFirstIndex = n;
            this.listViewCount = n2;
        }
    }

    @Override
    public void performDynamicResize() {
        if (this.dynamicResizeDirection != 0) {
            Point point = new Point(-129, -129);
            Point point2 = new Point(128, 128);
            WidgetModel widgetModel = this.dynamicResizeWidgetRef != null ? this.dynamicResizeWidgetRef : this;
            widgetModel.calculateBoundingBox(-this.get_x(), -this.get_y(), point, point2);
            this.disableListItemChanged();
            this.disableAnimations();
            switch (this.dynamicResizeDirection) {
                case 1: {
                    this.set_width(point2.x - point.x + this.dynamicResizePadding.left + this.dynamicResizePadding.right);
                    break;
                }
                case 2: {
                    this.set_height(point2.y - point.y + this.dynamicResizePadding.top + this.dynamicResizePadding.bottom);
                    break;
                }
            }
            this.enableAnimations();
            this.enableListItemChanged();
        }
    }

    @Override
    public void performDynamicResizeAll() {
        this.performDynamicResize();
        if (this.itemClones != null) {
            Iterator iterator = this.itemClones.iterator();
            while (iterator.hasNext()) {
                ListItemModel listItemModel = (ListItemModel)iterator.next();
                listItemModel.performDynamicResize();
            }
        }
    }

    private void validateItemCount() {
        if (this.listItemControl != null) {
            int n;
            int n2 = this.listItemControl.getItemCount();
            int n3 = n = this.limitation < 0 ? n2 : Math.min(this.limitation, n2);
            if (this.itemCount != n) {
                this.listChanged(n);
            }
        }
    }

    @Override
    public void activatedIndexChanged(int n) {
        this.activatedIndexAPI = n;
        this.notifyListItemChangedListener(4);
    }

    @Override
    public void itemsInserted(int n, int n2, int n3) {
        if (this.itemCount != n3) {
            this.setItemCount(n3);
            this.notifyListItemChangedListener(5, n, n2);
        }
    }

    @Override
    public void itemsRemoved(int n, int n2, int n3) {
        if (this.itemCount != n3) {
            this.setItemCount(n3);
            this.notifyListItemChangedListener(6, n, n2);
        }
    }

    @Override
    public void itemsChanged(int n, int n2) {
        this.notifyListItemChangedListener(7, n, n2);
    }

    @Override
    public void listChanged(int n) {
        if (n == 0) {
            this.setItemCount(0);
            this.updateListView(-1, 0);
            this.notifyListItemChangedListener(0, -1, 0);
        } else {
            this.setItemCount(this.listItemControl != null ? this.listItemControl.getItemCount() : 0);
            this.notifyListItemChangedListener(0);
        }
    }

    @Override
    public void listContentChanged() {
        this.notifyListItemChangedListener(2);
    }

    @Override
    public void stringIndexChanged() {
        this.notifyListItemChangedListener(8);
    }

    public static LogMessage appendListItemTexts(LogMessage logMessage, ListItemModel listItemModel) {
        AbstractButtonModel[] abstractButtonModelArray;
        if (listItemModel != null && (abstractButtonModelArray = listItemModel.get_selectedButtonRefs()) != null) {
            for (int i2 = 0; i2 < abstractButtonModelArray.length; ++i2) {
                ButtonModel buttonModel;
                TextAreaModel[] textAreaModelArray;
                AbstractButtonModel abstractButtonModel = abstractButtonModelArray[i2];
                if (!(abstractButtonModel instanceof ButtonModel) || (textAreaModelArray = (buttonModel = (ButtonModel)abstractButtonModel).get_textAreaRefs()) == null) continue;
                for (int i3 = 0; i3 < textAreaModelArray.length; ++i3) {
                    TextAreaModel textAreaModel = textAreaModelArray[i3];
                    String string = textAreaModel.get_text();
                    logMessage.append(" ");
                    logMessage.append(string);
                }
            }
        }
        return logMessage;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

