/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.AbstractTemplateList$1;
import de.vw.mib.widgets.AbstractTemplateList$ListItemExpandDelayer;
import de.vw.mib.widgets.AbstractTemplateList$ListViewObserver;
import de.vw.mib.widgets.ListItem;
import de.vw.mib.widgets.controller.TemplateListController;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.interfaces.Draggable$DragDataStorage;
import de.vw.mib.widgets.interfaces.WidgetCloneFactory;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.list.DefaultListLUT;
import de.vw.mib.widgets.list.DefaultTemplateListSelectionStrategy;
import de.vw.mib.widgets.list.ListControl;
import de.vw.mib.widgets.list.ListItemChangedHandler;
import de.vw.mib.widgets.list.ListItemChangedListener;
import de.vw.mib.widgets.list.ListItemTransfer;
import de.vw.mib.widgets.list.ListLUT;
import de.vw.mib.widgets.list.ListValidationControl;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTemplateList
extends AbstractList
implements TemplateListModel,
ListValidationControl {
    private static final int FAST_SCROLLING_PAGES;
    private static final String LETTER_SCROLLING_EMPTY_TEXT;
    private static boolean LETTER_SCROLLING_DEBUG;
    private static final int ADJUSTMENT_DIRECTION_NONE;
    private static final int ADJUSTMENT_DIRECTION_FORWARD;
    private static final int ADJUSTMENT_DIRECTION_BACKWARD;
    private static final String TIMER_NAME;
    private static final int FOLLOW_MODE_TIMER_MINIMUM_DURATION;
    private int firstItemIndex;
    private int firstItemIndexPosition;
    private int itemCount;
    private int followItemPosition;
    private ListItemModel[] followItemRefs;
    private int followModeDelay;
    private int scrollTypeRotary;
    private int scrollTypeTouch;
    private int forwardPressDelay;
    private int letterScrollingIndicatorMode;
    private WidgetModel letterScrollingIndicatorRef;
    private TextAreaModel letterScrollingTextRef;
    private int listViewObserverDelay;
    private Point[] itemPoints;
    protected ListItemChangedListener listItemChangedHandler;
    private int listInvalidState;
    private ListItemModel listInvalidItem;
    private int listInvalidIndex;
    private int listInvalidCount;
    private Draggable$DragDataStorage dragDataStorage;
    private CowList adjustmentListeners;
    private int focusedIndex;
    private int firstVisibleIndex;
    private int lastVisibleIndex;
    private int firstFullyVisibleIndex;
    private int lastFullyVisibleIndex;
    private int firstMostlyVisibleIndex;
    private int lastMostlyVisibleIndex;
    private ListItemTransfer listItemTransfer;
    private WidgetCloneFactory widgetCloneFactory;
    private ListItemModel[] listItems;
    private ListItemModel[] listItemsAll;
    private ListControl listControl;
    protected ListLUT listLUT;
    private ListItemModel selectedItem;
    private int selectedItemIndex;
    private ListItemModel focusedItem;
    private int focusedItemIndex;
    private boolean adjusting;
    private int adjustmentShadowCounter;
    private Timer followModeTimer;
    protected boolean followModeTimerRunning;
    private boolean selectionLocked;
    private int dragIndex;
    private int dropIndex;
    private int pressedIndex;
    private int activatedIndex;
    private int childIndexFirstItem;
    private int childIndexLastItem;
    private AbstractTemplateList$ListItemExpandDelayer expandDelayer;
    private int letterScrollingIndex;
    private int adjustmentDirection;
    private boolean fastScrollingSupported;
    private AbstractTemplateList$ListViewObserver listViewObserver;
    private int alignment;
    private boolean dynamic;
    private int initialSelectionMode;

    @Override
    protected void reset() {
        super.reset();
        this.initListLUT();
        this.adjustmentListeners = null;
        this.listItems = null;
        this.listItemsAll = null;
        this.listControl = null;
        this.widgetCloneFactory = null;
        this.listItemTransfer = null;
        this.followModeTimer = null;
        this.selectedItem = null;
        this.focusedItem = null;
        this.listViewObserver = null;
        this.firstVisibleIndex = -1;
        this.lastVisibleIndex = -1;
        this.firstMostlyVisibleIndex = -1;
        this.lastMostlyVisibleIndex = -1;
        this.firstFullyVisibleIndex = -1;
        this.lastFullyVisibleIndex = -1;
        this.selectedItemIndex = -1;
        this.focusedItemIndex = -1;
        this.dragIndex = -1;
        this.dropIndex = -1;
        this.adjustmentListeners = CowList.EMPTY;
        this.dragDataStorage = new Draggable$DragDataStorage();
    }

    public void init(boolean bl, int n, int n2, Image image, boolean bl2, boolean bl3, StaticImageModel staticImageModel, boolean bl4, boolean bl5, boolean bl6, EasingParams[] easingParamsArray, boolean bl7, int n3, int n4, int n5, ListItemModel[] listItemModelArray, boolean bl8, int n6, int n7, int n8, boolean bl9, int n9, boolean bl10, Point[] pointArray, KeyframeAnimation[] keyframeAnimationArray, boolean bl11, LayoutAttribs layoutAttribs, boolean bl12, int n10, WidgetModel widgetModel, boolean bl13, TextAreaModel textAreaModel, boolean bl14, int n11, boolean bl15, String string, boolean bl16, int n12, Image image2, int n13, boolean bl17, int n14, int n15, int n16, int n17, Insets insets, boolean bl18, int n18, int n19, int n20) {
        super.init(bl, n2, image, bl2, bl3, staticImageModel, bl4, easingParamsArray, bl7, n8, bl9, keyframeAnimationArray, bl11, layoutAttribs, string, n12, image2, n13, bl17, n16, n17, insets, bl18, n18, n19, n20);
        this.alignment = n;
        this.firstItemIndex = n3;
        this.firstItemIndexPosition = n4;
        this.scrollTypeTouch = n15;
        this.scrollTypeRotary = n14;
        this.itemCount = n9;
        this.itemPoints = pointArray;
        this.forwardPressDelay = n7;
        this.followModeDelay = n6;
        this.followItemRefs = listItemModelArray;
        this.followItemPosition = n5;
        this.letterScrollingIndicatorMode = n10;
        this.letterScrollingIndicatorRef = widgetModel;
        this.letterScrollingTextRef = textAreaModel;
        this.listViewObserverDelay = n11;
        this.setInternalStateFlag(20, bl8);
        this.setInternalStateFlag(21, bl14);
        this.setInternalStateFlag(22, bl6);
        this.setInternalStateFlag(25, bl5);
        this.setInternalStateFlag(26, bl12);
        this.setInternalStateFlag(27, bl13);
        this.setInternalStateFlag(29, bl15);
        this.setInternalStateFlag(30, bl16);
        this.setInternalStateFlag(31, bl10);
    }

    public void init(boolean bl, int n, int n2, Image image, boolean bl2, boolean bl3, StaticImageModel staticImageModel, boolean bl4, boolean bl5, boolean bl6, EasingParams[] easingParamsArray, boolean bl7, int n3, int n4, int n5, ListItemModel[] listItemModelArray, boolean bl8, int n6, int n7, int n8, boolean bl9, int n9, Point[] pointArray, KeyframeAnimation[] keyframeAnimationArray, boolean bl10, LayoutAttribs layoutAttribs, boolean bl11, int n10, WidgetModel widgetModel, boolean bl12, TextAreaModel textAreaModel, boolean bl13, int n11, boolean bl14, String string, boolean bl15, boolean bl16, int n12, Image image2, int n13, boolean bl17, int n14, int n15, int n16, boolean bl18, boolean bl19, int n17, Insets insets, boolean bl20, int n18, int n19, int n20) {
        this.init(bl, n, n2, image, bl2, bl3, staticImageModel, bl4, bl5, bl6, easingParamsArray, bl7, n3, n4, n5, listItemModelArray, bl8, n6, n7, n8, bl9, n9, false, pointArray, keyframeAnimationArray, bl10, layoutAttribs, bl11, n10, widgetModel, bl12, textAreaModel, bl13, n11, bl14, string, bl15, n12, image2, n13, bl17, n14, n15, n16, n17, insets, bl20, n18, n19, n20);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.expandDelayer = new AbstractTemplateList$ListItemExpandDelayer(this, this);
        this.listItemChangedHandler = new ListItemChangedHandler(this, this);
        this.childIndexFirstItem = -1;
        this.childIndexLastItem = -1;
        this.focusedIndex = -1;
        this.firstVisibleIndex = -1;
        this.lastVisibleIndex = -1;
        this.firstMostlyVisibleIndex = -1;
        this.lastMostlyVisibleIndex = -1;
        this.firstFullyVisibleIndex = -1;
        this.lastFullyVisibleIndex = -1;
        this.selectedItemIndex = -1;
        this.dragIndex = -1;
        this.dropIndex = -1;
        this.pressedIndex = -1;
        this.activatedIndex = -1;
        this.initialSelectionMode = 0;
        this.adjusting = false;
        this.selectionLocked = false;
        this.setInternalStateFlag(28, false);
        this.initViewport();
        this.registerListItemChangedHandler(this.getChildren());
        this.initListLUT();
        this.validateListImmediately(8194);
        this.invalidateList(1049233408);
    }

    @Override
    public void deInit() {
        this.forceUnfreeze();
        this.firstVisibleIndex = -1;
        this.lastVisibleIndex = -1;
        this.firstMostlyVisibleIndex = -1;
        this.lastMostlyVisibleIndex = -1;
        this.firstFullyVisibleIndex = -1;
        this.lastFullyVisibleIndex = -1;
        this.validateListImmediately(8192);
        this.syncToListControl();
        this.removeListItemChangedHandler(this.getChildren());
        this.stopFollowModeTimer();
        this.followModeTimer = null;
        this.listLUT.destroyClones(this.widgetCloneFactory, this.listItemsAll);
        this.adjustmentListeners = CowList.EMPTY;
        this.invalidateList();
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        this.forceUnfreeze();
    }

    @Override
    public void deActivate() {
        super.deActivate();
        this.freeze();
    }

    protected void initListLUT() {
        this.listLUT = new DefaultListLUT();
        this.listLUT.setLayoutable(this);
    }

    private void initFollowModeTimer() {
        this.followModeTimer = this.is_followMode() && this.followModeDelay >= 100 ? ServiceManager.timerManager.createTimer("AbstractTemplateList.FollowModeTimer", this.followModeDelay, false, new AbstractTemplateList$1(this), ServiceManager.eventDispatcher) : null;
    }

    @Override
    public final int get_itemCount() {
        return this.itemCount;
    }

    @Override
    public final void set_itemCount(int n) {
        int n2 = this.itemCount;
        if (n2 != n) {
            this.itemCount = n;
            this.itemCountChanged(n2);
            this.propertyChanged(31);
        }
    }

    @Override
    public final int get_firstItemIndex() {
        return this.firstItemIndex;
    }

    @Override
    public final void set_firstItemIndex(int n) {
        int n2 = this.firstItemIndex;
        if (n2 != n) {
            this.firstItemIndex = n;
            this.firstItemIndexChanged(n2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final int get_firstItemIndexPosition() {
        return this.firstItemIndexPosition;
    }

    @Override
    public final void set_firstItemIndexPosition(int n) {
        int n2 = this.firstItemIndexPosition;
        if (n2 != n) {
            this.firstItemIndexPosition = n;
            this.firstItemIndexPositionChanged(n2);
            this.propertyChanged(28);
        }
    }

    @Override
    public final boolean is_followMode() {
        return this.getInternalStateFlag(20);
    }

    @Override
    public final void set_followMode(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(20);
        if (bl2 != bl) {
            this.setInternalStateFlag(20, bl);
            this.followModeChanged(bl2);
            this.propertyChanged(32);
        }
    }

    @Override
    public final void set_followModeDelay(int n) {
        int n2 = this.get_followModeDelay();
        if (n2 != n) {
            this.followModeDelay = n;
            this.followModeDelayChanged(n2);
            this.propertyChanged(33);
        }
    }

    @Override
    public final int get_followModeDelay() {
        return this.followModeDelay;
    }

    @Override
    public final int get_scrollTypeTouch() {
        return this.scrollTypeTouch;
    }

    @Override
    public final void set_scrollTypeTouch(int n) {
        int n2 = this.scrollTypeTouch;
        if (n2 != n) {
            this.scrollTypeTouch = n;
            this.scrollTypeTouchChanged(n2);
            this.propertyChanged(29);
        }
    }

    @Override
    public final int get_scrollTypeRotary() {
        return this.scrollTypeRotary;
    }

    @Override
    public final void set_scrollTypeRotary(int n) {
        int n2 = this.scrollTypeRotary;
        if (n2 != n) {
            this.scrollTypeRotary = n;
            this.scrollTypeRotaryChanged(n2);
            this.propertyChanged(30);
        }
    }

    @Override
    public ListItemModel[] get_followItemRefs() {
        return this.followItemRefs;
    }

    @Override
    public void set_followItemRefs(ListItemModel[] listItemModelArray) {
        ListItemModel[] listItemModelArray2 = this.followItemRefs;
        if (listItemModelArray2 != listItemModelArray) {
            this.followItemRefs = listItemModelArray;
            this.followItemRefsChanged(listItemModelArray2);
            this.propertyChanged(35);
        }
    }

    @Override
    public final void set_followItemPosition(int n) {
        int n2 = this.followItemPosition;
        if (n2 != n) {
            this.followItemPosition = n;
            this.followItemPositionChanged(n2);
            this.propertyChanged(36);
        }
    }

    @Override
    public final int get_followItemPosition() {
        return this.followItemPosition;
    }

    @Override
    public final void set_forwardPressDelay(int n) {
        int n2 = this.forwardPressDelay;
        if (n2 != n) {
            this.forwardPressDelay = n;
            this.forwardPressDelayChanged(n2);
            this.propertyChanged(37);
        }
    }

    @Override
    public int get_forwardPressDelay() {
        return this.forwardPressDelay;
    }

    @Override
    public void set_dynamicItemSize(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(22);
        if (bl2 != bl) {
            this.setInternalStateFlag(22, bl);
            this.dynamicItemSizeChanged(bl2);
            this.propertyChanged(39);
        }
    }

    @Override
    public boolean is_dynamicItemSize() {
        return this.getInternalStateFlag(22);
    }

    @Override
    public boolean is_dragDropEnabled() {
        return this.getInternalStateFlag(25);
    }

    @Override
    public void set_dragDropEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(25);
        if (bl2 != bl) {
            this.setInternalStateFlag(25, bl);
            this.dragDropEnabledChanged(bl2);
            this.propertyChanged(42);
        }
    }

    @Override
    public boolean is_letterScrollingEnabled() {
        return this.getInternalStateFlag(26) || LETTER_SCROLLING_DEBUG;
    }

    @Override
    public void set_letterScrollingEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(26);
        if (bl2 != bl) {
            this.setInternalStateFlag(26, bl);
            this.letterScrollingEnabledChanged(bl2);
            this.propertyChanged(43);
        }
    }

    @Override
    public boolean is_letterScrollingSupported() {
        return this.getInternalStateFlag(27);
    }

    @Override
    public void set_letterScrollingSupported(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(27);
        if (bl2 != bl) {
            this.setInternalStateFlag(27, bl);
            this.letterScrollingSupportedChanged(bl2);
            this.propertyChanged(44);
        }
    }

    @Override
    public int get_letterScrollingIndicatorMode() {
        return this.letterScrollingIndicatorMode;
    }

    @Override
    public void set_letterScrollingIndicatorMode(int n) {
        int n2 = this.letterScrollingIndicatorMode;
        if (n2 != n) {
            this.letterScrollingIndicatorMode = n;
            this.letterScrollingIndicatorModeChanged(n2);
            this.propertyChanged(18);
        }
    }

    @Override
    public WidgetModel get_letterScrollingIndicatorRef() {
        return this.letterScrollingIndicatorRef;
    }

    @Override
    public void set_letterScrollingIndicatorRef(WidgetModel widgetModel) {
        WidgetModel widgetModel2 = this.letterScrollingIndicatorRef;
        if (widgetModel2 != widgetModel) {
            this.letterScrollingIndicatorRef = widgetModel;
            this.letterScrollingIndicatorRefChanged(widgetModel2);
            this.propertyChanged(46);
        }
    }

    @Override
    public TextAreaModel get_letterScrollingTextRef() {
        return this.letterScrollingTextRef;
    }

    @Override
    public void set_letterScrollingTextRef(TextAreaModel textAreaModel) {
        TextAreaModel textAreaModel2 = this.letterScrollingTextRef;
        if (textAreaModel2 != textAreaModel) {
            this.letterScrollingTextRef = textAreaModel;
            this.letterScrollingTextRefChanged(textAreaModel2);
            this.propertyChanged(47);
        }
    }

    @Override
    public boolean is_listViewObserverEnabled() {
        return this.getInternalStateFlag(29);
    }

    @Override
    public void set_listViewObserverEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(29);
        if (bl2 != bl) {
            this.setInternalStateFlag(29, bl);
            this.listViewObserverEnabledChanged(bl2);
            this.propertyChanged(48);
        }
    }

    @Override
    public int get_listViewObserverDelay() {
        return this.listViewObserverDelay;
    }

    @Override
    public void set_listViewObserverDelay(int n) {
        int n2 = this.listViewObserverDelay;
        if (n2 != n) {
            this.listViewObserverDelay = n;
            this.listViewObserverDelayChanged(n2);
            this.propertyChanged(49);
        }
    }

    @Override
    public boolean isLetterScrollingIndicatorActive() {
        return this.getInternalStateFlag(28);
    }

    @Override
    public boolean is_orderInverted() {
        return this.getInternalStateFlag(30);
    }

    @Override
    public void set_orderInverted(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(30);
        if (bl2 != bl) {
            this.setInternalStateFlag(30, bl);
            this.orderInvertedChanged(bl2);
            this.propertyChanged(50);
        }
    }

    @Override
    public int get_alignment() {
        return this.alignment;
    }

    @Override
    public void set_alignment(int n) {
        int n2 = this.alignment;
        if (n2 != n) {
            this.alignment = n;
            this.alignmentChanged(n2);
            this.propertyChanged(51);
        }
    }

    @Override
    public Point[] get_itemPoints() {
        return this.itemPoints;
    }

    @Override
    public void set_itemPoints(Point[] pointArray) {
        Object[] objectArray = this.itemPoints;
        if (objectArray == null || !Arrays.equals(objectArray, pointArray)) {
            this.itemPoints = pointArray;
            this.itemPointsChanged((Point[])objectArray);
            this.propertyChanged(52);
        }
    }

    @Override
    public final boolean is_listControlEnabled() {
        return this.getInternalStateFlag(21);
    }

    @Override
    public boolean is_itemNumberingEnabled() {
        return this.getInternalStateFlag(31);
    }

    @Override
    public void set_itemNumberingEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(31);
        if (bl2 != bl) {
            this.setInternalStateFlag(31, bl);
            this.itemNumberingEnabledChanged(bl2);
            this.propertyChanged(53);
        }
    }

    @Override
    public final void set_listControlEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(21);
        if (bl2 != bl) {
            this.setInternalStateFlag(21, bl);
            this.listControlEnabledChanged(bl2);
            this.propertyChanged(38);
        }
    }

    @Override
    public void setLetterScrollingIndicatorActive(boolean bl) {
        this.setInternalStateFlag(28, bl);
        this.invalidateList(2048);
    }

    @Override
    public void setListItemTransfer(ListItemTransfer listItemTransfer) {
        this.listItemTransfer = listItemTransfer;
    }

    @Override
    public ListItemTransfer getListItemTransfer() {
        return this.listItemTransfer;
    }

    public void setListControl(ListControl listControl) {
        this.listControl = listControl;
    }

    public ListControl getListControl() {
        return this.listControl;
    }

    @Override
    public void setWidgetCloneFactory(WidgetCloneFactory widgetCloneFactory) {
        this.widgetCloneFactory = widgetCloneFactory;
    }

    @Override
    public WidgetCloneFactory getWidgetCloneFactory() {
        return this.widgetCloneFactory;
    }

    @Override
    public int getFocusedIndex() {
        return this.focusedIndex;
    }

    @Override
    public void setFocusedIndex(int n) {
        this.focusedIndex = n;
        if (this.focusedIndex == -1) {
            this.focusedItem = null;
            this.focusedItemIndex = -1;
        } else {
            this.focusedItem = this.getItem(this.focusedIndex);
            this.focusedItemIndex = this.focusedItem != null ? this.focusedItem.getRelativeItemIndex(this.getItemIndex(this.focusedIndex)) : -1;
        }
    }

    @Override
    public int getDragIndex() {
        return this.dragIndex;
    }

    @Override
    public int getDropIndex() {
        return this.dropIndex;
    }

    public void setDropIndex(int n) {
        this.dropIndex = n;
    }

    protected void setLetterScrollingIndex(int n) {
        this.letterScrollingIndex = n;
    }

    protected int getLetterScrollingIndex() {
        return this.letterScrollingIndex;
    }

    protected int getLetterScrollingAbsIndex() {
        return this.listLUT.getLetterScrollingAbsIndex(this.letterScrollingIndex);
    }

    @Override
    public String getLetterScrollingText() {
        return this.listLUT.getLetterScrollingText(this.letterScrollingIndex);
    }

    public int getPageSize() {
        return this.lastVisibleIndex - this.firstVisibleIndex;
    }

    @Override
    public ListItemModel[] getListItems() {
        return this.listItems;
    }

    @Override
    public ListItemModel getItem(int n) {
        int n2;
        ListItemModel listItemModel = this.getItemMaster(n);
        if (listItemModel != null && (n2 = this.listLUT.getCloneID(n)) != -1) {
            listItemModel = (ListItem)listItemModel.getItemClones().get(n2);
        }
        return listItemModel;
    }

    @Override
    public ListItemModel getItemMaster(int n) {
        ListItem listItem = null;
        int n2 = this.listLUT.getItemID(n);
        if (n2 != -1) {
            listItem = (ListItem)this.listItems[n2];
        }
        return listItem;
    }

    @Override
    public int getItemIndex(int n) {
        return this.listLUT.getItemIndex(n);
    }

    @Override
    public boolean isItemSelectable(int n) {
        ListItemModel listItemModel = this.getItemMaster(n);
        boolean bl = false;
        if (listItemModel != null && listItemModel.getHelperItemClone() != null && n >= 0 && n < this.itemCount) {
            ListItemModel listItemModel2 = listItemModel.getHelperItemClone();
            listItemModel2.setDataInvalid(true);
            this.transferData(listItemModel2, n, this.getItemIndex(n));
            bl = listItemModel2.is_enabled() && listItemModel2.is_selectable();
        }
        return bl;
    }

    @Override
    public int getAbsIndexByListItemDynamicIndex(ListItemModel listItemModel, int n) {
        return this.listLUT.getAbsIndexByListItemDynamicIndex(listItemModel, n);
    }

    @Override
    public int getFirstVisibleIndex() {
        return this.firstVisibleIndex;
    }

    protected void setVisibleIndices(int n, int n2, int n3, int n4, int n5, int n6) {
        boolean bl = false;
        if (this.firstVisibleIndex != n) {
            this.firstVisibleIndex = n;
            bl = true;
        }
        if (this.firstFullyVisibleIndex != n2) {
            this.firstFullyVisibleIndex = n2;
            bl = true;
        }
        if (this.firstMostlyVisibleIndex != n3) {
            this.firstMostlyVisibleIndex = n3;
            bl = true;
        }
        if (this.lastVisibleIndex != n4) {
            this.lastVisibleIndex = n4;
            bl = true;
        }
        if (this.lastFullyVisibleIndex != n5) {
            this.lastFullyVisibleIndex = n5;
            bl = true;
        }
        if (this.lastMostlyVisibleIndex != n6) {
            this.lastMostlyVisibleIndex = n6;
            bl = true;
        }
        if (bl) {
            this.validateListImmediately(11008);
        }
    }

    @Override
    public int getLastVisibleIndex() {
        return this.lastVisibleIndex;
    }

    @Override
    public int getFirstMostlyVisibleIndex() {
        return this.firstMostlyVisibleIndex;
    }

    @Override
    public int getFirstFullyVisibleIndex() {
        return this.firstFullyVisibleIndex;
    }

    @Override
    public int getLastMostlyVisibleIndex() {
        return this.lastMostlyVisibleIndex;
    }

    @Override
    public int getLastFullyVisibleIndex() {
        return this.lastFullyVisibleIndex;
    }

    @Override
    public void setPressedIndex(int n) {
        if (n != this.pressedIndex) {
            this.pressedIndex = n;
            this.pressedIndexChanged();
        }
    }

    @Override
    public int getPressedIndex() {
        return this.pressedIndex;
    }

    @Override
    public void setActivatedIndex(int n) {
        if (n != this.activatedIndex) {
            this.activatedIndex = n;
            this.activatedIndexChanged();
        }
    }

    @Override
    public int getActivatedIndex() {
        return this.activatedIndex;
    }

    @Override
    public int getChildIndexFirstItem() {
        return this.childIndexFirstItem;
    }

    @Override
    public int getChildIndexLastItem() {
        return this.childIndexLastItem;
    }

    protected ListItemModel getFollowItem() {
        ListItemModel listItemModel = null;
        if (this.followItemRefs != null) {
            for (int i2 = this.followItemRefs.length - 1; i2 >= 0; --i2) {
                boolean bl;
                ListItemModel listItemModel2 = this.followItemRefs[i2];
                if (listItemModel2 == null) continue;
                boolean bl2 = listItemModel2.getItemCount() > 0;
                boolean bl3 = listItemModel2.get_activatedIndex() > -1;
                boolean bl4 = listItemModel2.getActivatedIndexAPI() > -1;
                boolean bl5 = bl = bl3 || bl4;
                if (listItemModel2 == null || !listItemModel2.is_visible() || !bl2 || !bl) continue;
                listItemModel = listItemModel2;
                break;
            }
        }
        return listItemModel;
    }

    protected int getLetterScrollingCount() {
        return this.listLUT.getLetterScrollingCount();
    }

    protected int getLetterScrollingAbsIndex(int n) {
        return this.listLUT.getLetterScrollingAbsIndex(n);
    }

    protected String getLetterScrollingText(int n) {
        return this.listLUT.getLetterScrollingText(n);
    }

    @Override
    public void lockSelection() {
        this.selectionLocked = true;
    }

    @Override
    public void unlockSelection() {
        this.selectionLocked = false;
    }

    @Override
    public boolean isSelectionLocked() {
        return this.selectionLocked;
    }

    @Override
    public final boolean isDynamic() {
        return this.dynamic;
    }

    @Override
    public boolean isFastScrollingSupported() {
        return this.fastScrollingSupported;
    }

    boolean isFollowModeEnabled() {
        return this.is_followMode() && this.getFollowItem() != null && !this.followModeTimerRunning;
    }

    @Override
    public boolean isSubItemExpandCollapsePending() {
        return this.expandDelayer != null && this.expandDelayer.isSubItemExpandCollapsePending();
    }

    protected final void registerListItemChangedHandler(WidgetModel[] widgetModelArray) {
        boolean bl = false;
        this.childIndexFirstItem = -1;
        this.childIndexLastItem = -1;
        List list = null;
        if (widgetModelArray != null) {
            list = new ArrayList(widgetModelArray.length);
            for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
                if (!(widgetModelArray[i2] instanceof ListItemModel)) continue;
                ListItemModel listItemModel = (ListItemModel)widgetModelArray[i2];
                listItemModel.setListItemChangedListener(this.listItemChangedHandler);
                listItemModel.setAssigned(true);
                if (list.isEmpty()) {
                    this.childIndexFirstItem = i2;
                    this.childIndexLastItem = i2;
                } else {
                    this.childIndexLastItem = i2;
                }
                list.add(listItemModel);
                if (listItemModel.isDynamic()) {
                    bl = true;
                }
                if (!this.is_dynamicItemSize()) continue;
                int n = listItemModel.get_limitation();
                listItemModel.set_limitation(n < 0 ? 30 : Math.min(n, 30));
            }
        }
        if (list != null && list.size() > 0) {
            this.listItemsAll = new ListItemModel[list.size()];
            list.toArray(this.listItemsAll);
        } else {
            this.listItemsAll = new ListItemModel[0];
        }
        this.dynamic = bl && this.adjustmentListeners.size() > 0;
    }

    protected final void removeListItemChangedHandler(WidgetModel[] widgetModelArray) {
        for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
            if (!(widgetModelArray[i2] instanceof ListItemModel)) continue;
            ((ListItemModel)widgetModelArray[i2]).setListItemChangedListener(null);
        }
    }

    protected void syncFromListControl() {
        int n = -1;
        if (this.is_listControlEnabled() && this.listControl != null) {
            n = this.listControl.getSelectedIndex();
            int n2 = this.listControl.getSelectionDelta();
            if (AbstractTemplateList.isListSelectionEnabled() && n2 != 0) {
                n = n2 > 0 ? DefaultTemplateListSelectionStrategy.getPrevSelectedIndex(this, -n2) : DefaultTemplateListSelectionStrategy.getNextSelectedIndex(this, n2);
            }
            if (LOGGER.isTraceEnabled(32)) {
                LogMessage logMessage = LOGGER.trace(32);
                logMessage.append(new StringBuffer().append("AbstractTemplateList '").append(this).append("': Synchronize from ListControl - Selected Index: ").toString()).append(n).log();
            }
        }
        this.set_selectedIndex(n);
    }

    protected void syncToListControl() {
        int n = this.get_selectedIndex();
        if (this.is_listControlEnabled() && this.listControl != null) {
            if (LOGGER.isTraceEnabled(32)) {
                LogMessage logMessage = LOGGER.trace(32);
                logMessage.append(new StringBuffer().append("AbstractTemplateList '").append(this).append("': Synchronize to ListControl - Selected Index: ").toString()).append(n).log();
            }
            this.listControl.setSelectedIndex(n);
        }
    }

    @Override
    public void disableFollowMode() {
        if (this.is_followMode() && this.followModeDelay > 0) {
            this.startFollowModeTimer();
        } else {
            this.set_followMode(false);
        }
    }

    private void stopFollowModeTimer() {
        if (this.followModeTimer != null && this.followModeTimerRunning) {
            this.followModeTimer.stop();
            this.followModeTimerRunning = false;
        }
    }

    private void startFollowModeTimer() {
        if (this.getFollowModeTimer() != null) {
            this.getFollowModeTimer().start();
            this.followModeTimerRunning = true;
        }
    }

    private Timer getFollowModeTimer() {
        if (this.followModeTimer == null) {
            this.initFollowModeTimer();
        }
        return this.followModeTimer;
    }

    protected abstract void showFollowedItem() {
    }

    protected abstract void initViewport() {
    }

    @Override
    public void resetListView() {
        this.initViewport();
        this.syncToListControl();
    }

    @Override
    public final void freeze() {
        if (this.listItemsAll != null) {
            for (int i2 = 0; i2 < this.listItemsAll.length; ++i2) {
                ListItemModel listItemModel = this.listItemsAll[i2];
                listItemModel.freeze();
            }
        }
    }

    @Override
    public final void unfreeze() {
        if (this.listItemsAll != null) {
            for (int i2 = 0; i2 < this.listItemsAll.length; ++i2) {
                this.listItemsAll[i2].unfreeze();
            }
        }
    }

    @Override
    public final void forceUnfreeze() {
        if (this.listItemsAll != null) {
            for (int i2 = this.listItemsAll.length - 1; i2 >= 0; --i2) {
                this.listItemsAll[i2].forceUnfreeze();
            }
        }
    }

    protected void updateItemCount() {
        this.set_itemCount(this.listLUT.getItemCount());
    }

    private void updateLetterScrolling() {
        this.set_letterScrollingSupported(this.listLUT.isLetterScrollingSupported());
    }

    private void updateFastScrolling() {
        boolean bl = this.isVertical() ? this.getMaximum() > 4 * this.get_height() : this.getMaximum() > 4 * this.get_width();
        boolean bl2 = this.is_letterScrollingEnabled() && this.is_letterScrollingSupported() && this.getMaximum() > 0;
        this.fastScrollingSupported = this.isDynamic() && (bl2 || bl);
    }

    private void updateListViewObserver() {
        if (this.is_listViewObserverEnabled()) {
            if (this.listViewObserver == null) {
                this.listViewObserver = new AbstractTemplateList$ListViewObserver(this, this);
            }
        } else {
            this.listViewObserver = null;
        }
    }

    private void updateVisibility(boolean bl) {
        if (bl) {
            this.syncToListControl();
        } else {
            if (!this.is_listControlEnabled() && !this.isPaging()) {
                this.initViewport();
            }
            this.validateListImmediately(1006766080);
        }
    }

    protected void manageListExpansion(ListItemModel listItemModel) {
        this.validateListImmediately(2);
    }

    protected abstract void manageListBrowsing() {
    }

    protected void manageSelectiveItemUpdate(ListItemModel listItemModel, int n, int n2) {
        this.invalidateList();
    }

    @Override
    public void dragItem(int n) {
        this.freeze();
        this.dragIndex = n;
        this.dropIndex = n;
        ListItemModel listItemModel = this.getItemMaster(n).getDragItemClone();
        listItemModel.setDataInvalid(true);
    }

    @Override
    public void moveItem(int n, int n2) {
    }

    @Override
    public void dropItem() {
        this.dragIndex = -1;
        this.dropIndex = -1;
        this.forceUnfreeze();
    }

    private void updateListItems() {
        if (this.listItemsAll != null) {
            ArrayList arrayList = new ArrayList(this.listItemsAll.length);
            for (int i2 = 0; i2 < this.listItemsAll.length; ++i2) {
                ListItemModel listItemModel = this.listItemsAll[i2];
                if (!listItemModel.is_visible() || !listItemModel.is_availableInVariant()) continue;
                arrayList.add(listItemModel);
            }
            this.listItems = new ListItemModel[arrayList.size()];
            if (arrayList.size() > 0) {
                arrayList.toArray(this.listItems);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void transferData(ListItemModel listItemModel, int n, int n2) {
        boolean bl;
        boolean bl2 = bl = this.widgetCloneFactory != null;
        if (this.listItemTransfer != null && listItemModel != null && listItemModel.isDataInvalid() && listItemModel.isTransferEnabled() && n2 >= 0) {
            boolean bl3 = n != listItemModel.getAbsoluteIndex();
            boolean bl4 = listItemModel.isDummy() || !bl || bl3 && n != this.focusedIndex;
            try {
                long l;
                boolean bl5;
                if (bl4) {
                    this.disableAnimations();
                    listItemModel.stopInternalAnimations();
                }
                listItemModel.disableListItemChanged();
                listItemModel.set_dynamicIndex(n2);
                listItemModel.setAbsoluteIndex(n);
                boolean bl6 = bl5 = LOGGER.isTraceEnabled(32) && LOGGER.isTraceEnabled(1);
                if (bl5) {
                    LogMessage logMessage = LOGGER.trace(32);
                    logMessage.append("AbstractTemplateList '").append(this).append("' : Starting data transfer: listItem=").append(listItemModel).append(" dynamicIndex=").append(n2).log();
                }
                boolean bl7 = bl5 && LOGGER.isTraceEnabled(128);
                long l2 = bl7 ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                listItemModel.setDummy(!this.listItemTransfer.transferData(listItemModel, 0, n2));
                if (this.is_dynamicItemSize()) {
                    listItemModel.performDynamicResize();
                }
                long l3 = l = bl7 ? ServiceManager.timerManager.getSystemTimeMicros() : 0L;
                if (bl7) {
                    LogMessage logMessage = LOGGER.trace(32);
                    logMessage.append("AbstractTemplateList.transferData(): ").append(l - l2).append("\u00b5s").log();
                }
                listItemModel.setDataInvalid(!bl);
            }
            catch (Exception exception) {
                LogMessage logMessage = LOGGER.error(32);
                logMessage.append("AbstractTemplateList '").append(this).append("': Exception while data transfer: ").attachThrowable(exception).log();
            }
            finally {
                if (bl4) {
                    this.enableAnimations();
                }
                listItemModel.enableListItemChanged();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void transferStates(ListItemModel listItemModel, int n, int n2) {
        try {
            this.disableAnimations();
            listItemModel.delegateActivated(n2 == listItemModel.get_activatedIndex());
            listItemModel.delegateSelected(this.get_selectedIndex() == n);
        }
        catch (Exception exception) {
            LogMessage logMessage = LOGGER.error(32);
            logMessage.append(new StringBuffer().append("AbstractTemplateList '").append(this).append("': Exception while state transfer: ").toString()).append(exception).log();
        }
        finally {
            this.enableAnimations();
        }
    }

    @Override
    public final void invalidateList() {
        this.invalidateList(6);
    }

    @Override
    public final void invalidateList(int n) {
        this.listInvalidState |= n;
        this.repaint();
    }

    @Override
    public final void validateListImmediately(int n) {
        this.invalidateList(n);
        this.freeze();
        this.validateList();
        this.unfreeze();
        this.repaint();
    }

    @Override
    public final void validateListImmediately(int n, ListItemModel listItemModel) {
        this.listInvalidItem = listItemModel;
        this.validateListImmediately(n);
    }

    @Override
    public void validateListImmediately(int n, ListItemModel listItemModel, int n2, int n3) {
        this.listInvalidIndex = n2;
        this.listInvalidCount = n3;
        this.validateListImmediately(n, listItemModel);
    }

    @Override
    public final void resetListInvalidation() {
        this.listInvalidState = 0;
    }

    @Override
    public void validateList() {
        if (this.listInvalidState != 0) {
            boolean bl;
            int n = this.listInvalidState;
            this.listInvalidState = 0;
            boolean bl2 = bl = (n & 0x800) != 0;
            if (bl) {
                this.disableAnimations();
            }
            if ((n & 0x20) != 0) {
                this.validateActivatedIndex();
            }
            if ((n & 2) != 0) {
                this.validateListLUT();
            }
            if ((n & 0x4002) != 0) {
                this.validateAdjustmentRange();
            }
            if ((n & 0x1002) != 0) {
                this.updateFastScrolling();
            }
            if ((n & 0x800000) != 0) {
                this.validateFirstItemIndex();
            }
            if ((n & 8) != 0) {
                this.syncFromListControl();
            }
            if ((n & 0x10) != 0) {
                this.showFollowedItem();
            }
            if ((n & 4) != 0) {
                this.validateViewport();
            }
            if ((n & 0x402) != 0) {
                this.validateVisibleIndices();
            }
            if ((n & 0x40) != 0) {
                this.validateSelectedIndex();
            }
            if ((n & 0x80) != 0) {
                this.validateFocusedIndex();
            }
            if ((n & 0x102) != 0) {
                this.validateItemClones();
            }
            if ((n & 0x202) != 0) {
                this.validateItemNumbering();
            }
            if ((n & 0x802) != 0) {
                this.validateLetterScrollingIndicator();
            }
            if ((n & 0x2402) != 0) {
                this.validateListViewObserver();
            }
            if ((n & 0x400) != 0) {
                this.expandDelayer.requestExpansion(this.listInvalidItem);
            }
            if ((n & 0x200) != 0) {
                this.manageListBrowsing();
            }
            if ((n & 0x100) != 0) {
                this.manageSelectiveItemUpdate(this.listInvalidItem, this.listInvalidIndex, this.listInvalidCount);
            }
            if (bl) {
                this.enableAnimations();
            }
        }
    }

    private void validateListLUT() {
        if (this.listLUT != null) {
            this.updateListItems();
            this.listLUT.update(this.listItems, this.is_letterScrollingEnabled(), this.is_orderInverted());
            this.updateItemCount();
            this.updateLetterScrolling();
            this.updateListViewObserver();
            this.notifyAdjustmentListeners();
        }
    }

    private void validateActivatedIndex() {
        if (this.listItemsAll != null && this.listItemsAll.length > 0) {
            for (int i2 = this.listItemsAll.length - 1; i2 >= 0; --i2) {
                ListItemModel listItemModel = this.listItemsAll[i2];
                if (listItemModel.get_activatedIndex() <= listItemModel.getItemCount() - 1) continue;
                listItemModel.disableListItemChanged();
                listItemModel.set_activatedIndex(-1);
                listItemModel.setActivatedIndexPrev(-1);
                listItemModel.enableListItemChanged();
            }
            this.setActivatedIndex(this.listItemsAll[0].get_activatedIndex());
        }
    }

    protected void validateSelectedIndex() {
        int n = this.get_selectedIndex();
        if (this.selectedItem == null) {
            n = -1;
        } else {
            int n2 = this.getAbsIndexByListItemDynamicIndex(this.selectedItem, this.selectedItemIndex);
            if (n2 != -1) {
                n = n2;
            }
        }
        if (!this.isItemSelectable(n)) {
            n = -1;
        }
        if (n != -1) {
            n = Util.clamp(n, this.getFirstMostlyVisibleIndex(), this.getLastMostlyVisibleIndex());
        }
        this.set_selectedIndex(n);
        if (this.isSelectionLocked() && this.selectedItem != null && this.selectedItem.get_activatedIndex() == -1) {
            this.unlockSelection();
        }
    }

    protected void validateFocusedIndex() {
        int n = this.getFocusedIndex();
        if (this.focusedItem == null) {
            n = -1;
        } else {
            n = this.getAbsIndexByListItemDynamicIndex(this.focusedItem, this.focusedItemIndex);
            if (n < this.firstVisibleIndex || n > this.lastVisibleIndex) {
                n = -1;
            }
        }
        if (!this.isItemSelectable(n)) {
            n = -1;
        }
        this.setFocusedIndex(n);
    }

    protected abstract void validateAdjustmentRange() {
    }

    protected abstract void validateFirstItemIndex() {
    }

    protected abstract void validateViewport() {
    }

    protected abstract void validateVisibleIndices() {
    }

    @Override
    public void validateItemClones() {
        if (this.widgetCloneFactory != null) {
            this.listLUT.validateClones(this.widgetCloneFactory, this.firstVisibleIndex, this.lastVisibleIndex, this.is_dragDropEnabled());
        }
    }

    private void validateItemNumbering() {
        int n = 1;
        boolean bl = this.is_itemNumberingEnabled();
        for (int i2 = this.firstMostlyVisibleIndex; i2 <= this.lastMostlyVisibleIndex; ++i2) {
            boolean bl2;
            ListItemModel listItemModel = this.getItem(i2);
            if (listItemModel == null) continue;
            if (bl) {
                this.transferData(listItemModel, i2, this.getItemIndex(i2));
            }
            boolean bl3 = bl2 = bl && listItemModel.is_enabled() && listItemModel.get_numberTextRef() != null;
            if (bl2) {
                if (this.isAdjusting()) {
                    listItemModel.setItemNumber(-1);
                    continue;
                }
                listItemModel.setItemNumber(n);
                ++n;
                continue;
            }
            listItemModel.setItemNumber(-2);
        }
    }

    protected void validateListViewObserver() {
        if (this.listViewObserver != null) {
            this.listViewObserver.updateListView();
        }
    }

    private void validateLetterScrollingIndicator() {
        if (this.is_letterScrollingEnabled() && this.is_letterScrollingSupported()) {
            if (this.letterScrollingIndicatorRef != null) {
                this.letterScrollingIndicatorRef.disablePropertyChanged();
                this.letterScrollingIndicatorRef.set_visible(this.isLetterScrollingIndicatorActive());
                this.letterScrollingIndicatorRef.enablePropertyChanged();
                String string = this.getLetterScrollingText();
                this.letterScrollingTextRef.set_text(string == null ? "" : string);
            }
            if (!this.isLetterScrollingIndicatorActive()) {
                this.setLetterScrollingIndex(this.listLUT.getLetterScrollingIndexByAbsIndex(this.getValue() < this.getMaximum() ? this.firstVisibleIndex : this.lastVisibleIndex));
                this.notifyAdjustmentListeners();
            }
        }
    }

    @Override
    protected void enabledChanged(boolean bl) {
        TemplateListController templateListController;
        super.enabledChanged(bl);
        if (bl && (templateListController = (TemplateListController)this.getController()) != null) {
            templateListController.abortTouchActions();
        }
    }

    protected void itemCountChanged(int n) {
    }

    protected void firstItemIndexChanged(int n) {
    }

    protected void firstItemIndexPositionChanged(int n) {
    }

    protected void followModeChanged(boolean bl) {
        if (LOGGER.isTraceEnabled(32)) {
            LogMessage logMessage = LOGGER.trace(32);
            logMessage.append("AbstractTemplateList '").append(this.getQualifiedName()).append("': Follow mode changed: ").append(this.is_followMode()).log();
        }
        this.stopFollowModeTimer();
        if (this.is_followMode() && this.pressedIndex == -1) {
            this.invalidateList(16);
            AbstractTemplateList.disableListSelection();
        }
    }

    protected void followModeDelayChanged(int n) {
        this.initFollowModeTimer();
    }

    protected void followItemRefChanged(ListItemModel listItemModel) {
        this.invalidateList(16);
    }

    protected void followItemRefsChanged(ListItemModel[] listItemModelArray) {
        this.invalidateList(16);
    }

    protected void followItemPositionChanged(int n) {
        this.invalidateList(16);
    }

    protected void forwardPressDelayChanged(int n) {
    }

    protected void listControlEnabledChanged(boolean bl) {
    }

    protected void scrollTypeTouchChanged(int n) {
    }

    protected void scrollTypeRotaryChanged(int n) {
    }

    protected void scrollFactorAccelerationChanged(float f2) {
    }

    protected void scrollFactorElasticChanged(float f2) {
    }

    @Override
    protected void selectedIndexChanged(int n) {
        int n2 = this.get_selectedIndex();
        if (n2 == -1) {
            this.selectedItem = null;
            this.selectedItemIndex = -1;
            this.unlockSelection();
        } else {
            this.selectedItem = this.getItemMaster(n2);
            this.selectedItemIndex = this.selectedItem != null ? this.selectedItem.getRelativeItemIndex(this.getItemIndex(n2)) : -1;
        }
        this.updateCursor();
        this.repaint();
    }

    protected void pressedIndexChanged() {
    }

    protected void activatedIndexChanged() {
    }

    protected void dynamicItemSizeChanged(boolean bl) {
        this.invalidateList();
    }

    protected void readOutEnabledChanged(boolean bl) {
    }

    protected void spellingEnabledChanged(boolean bl) {
    }

    protected void dragDropEnabledChanged(boolean bl) {
        this.invalidateList();
    }

    protected void letterScrollingEnabledChanged(boolean bl) {
        this.invalidateList();
    }

    protected void letterScrollingSupportedChanged(boolean bl) {
        this.invalidateList();
    }

    protected void letterScrollingIndicatorModeChanged(int n) {
        this.invalidateList();
    }

    protected void letterScrollingIndicatorRefChanged(WidgetModel widgetModel) {
        this.invalidateList();
    }

    protected void letterScrollingTextRefChanged(TextAreaModel textAreaModel) {
        this.invalidateList();
    }

    @Override
    protected void visibleChanged(boolean bl) {
        TemplateListController templateListController;
        super.visibleChanged(bl);
        this.updateVisibility(bl);
        if (bl && (templateListController = (TemplateListController)this.getController()) != null) {
            templateListController.abortTouchActions();
        }
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        super.parentVisibilityChanged(bl);
        this.updateVisibility(bl);
    }

    protected void listViewObserverEnabledChanged(boolean bl) {
        this.invalidateList();
    }

    protected void listViewObserverDelayChanged(int n) {
        this.invalidateList();
    }

    protected void orderInvertedChanged(boolean bl) {
        this.invalidateList();
    }

    protected void itemNumberingEnabledChanged(boolean bl) {
        this.invalidateList(512);
    }

    protected void alignmentChanged(int n) {
        this.resetListView();
        this.invalidateList();
    }

    protected void itemPointsChanged(Point[] pointArray) {
        this.invalidateList();
    }

    @Override
    public Draggable$DragDataStorage getDragDataStorage() {
        return this.dragDataStorage;
    }

    @Override
    public boolean useDragDeceleration() {
        return true;
    }

    @Override
    public void startDragging() {
        this.invalidateList(8192);
        this.notifyAdjustmentStarted();
    }

    @Override
    public void stopDragging() {
        this.invalidateList(8192);
        this.notifyAdjustmentStopped();
    }

    @Override
    public int getMinimum() {
        return 0;
    }

    @Override
    public void setMinimum(int n) {
    }

    @Override
    public void setMaximum(int n) {
    }

    @Override
    public void setBlockIncrement(int n) {
    }

    @Override
    public int getUnitIncrement() {
        return 1;
    }

    @Override
    public void setUnitIncrement(int n) {
    }

    public boolean isAdjusting() {
        return this.adjusting;
    }

    @Override
    public void addAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.addIfAbsent(adjustmentListener);
        adjustmentListener.adjustmentValueChanged(this, 0);
    }

    @Override
    public void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.remove(adjustmentListener);
    }

    public void notifyAdjustmentListeners() {
        this.notifyAdjustmentListeners(0);
    }

    public void notifyAdjustmentListeners(int n) {
        if (this.isAdjustmentEnabled()) {
            for (CowList cowList = this.adjustmentListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
                AdjustmentListener adjustmentListener = (AdjustmentListener)cowList.head();
                adjustmentListener.adjustmentValueChanged(this, n);
            }
        }
    }

    @Override
    public void adjustmentValueChanged(Adjustable adjustable, int n) {
        this.disableAdjustmentChanged();
        switch (n) {
            case 1: {
                this.adjusting = true;
                this.invalidateList(8704);
                this.notifyAdjustmentStarted();
                break;
            }
            case 2: {
                this.adjusting = false;
                this.invalidateList(8704);
                this.notifyAdjustmentStopped();
                break;
            }
            case 3: {
                AbstractTemplateList.disableListSelection();
                this.snap(Util.clamp(this.getLastMostlyVisibleIndex() + 1, 0, this.get_itemCount() - 1), 0);
                break;
            }
            case 4: {
                AbstractTemplateList.disableListSelection();
                this.snap(Util.clamp(this.getFirstMostlyVisibleIndex() - 1, 0, this.get_itemCount() - 1), 1);
                break;
            }
        }
        if (this.is_letterScrollingSupported()) {
            this.performIndexedAdjustment(adjustable.getValue(), n);
        } else if (this.isPaging()) {
            this.performPagingAdjustment(adjustable.getValue(), n);
        } else {
            this.performDefaultAdjustment(adjustable.getValue(), n);
        }
        this.enableAdjustmentChanged();
        this.disableFollowMode();
    }

    @Override
    public void performDefaultAdjustment(int n, int n2) {
        block0 : switch (n2) {
            case 1: {
                this.stopInternalAnimations();
                this.adjustmentDirection = 0;
                break;
            }
            case 2: {
                if (this.get_scrollTypeTouch() == 2) break;
                switch (this.adjustmentDirection) {
                    case 1: {
                        this.snap(this.getLastVisibleIndex(), 1);
                        break block0;
                    }
                    case 2: {
                        this.snap(this.getFirstVisibleIndex(), 0);
                        break block0;
                    }
                }
                this.snap(this.getFirstMostlyVisibleIndex(), 0);
                break;
            }
            default: {
                if (!this.fastScrollingSupported) {
                    this.adjustmentDirection = this.getValue() <= n ? 1 : 2;
                }
                this.setValue(n);
                if (!this.fastScrollingSupported || this.get_scrollTypeTouch() == 2) break;
                this.validateList();
                this.disableAnimations();
                this.snap(this.getFirstMostlyVisibleIndex(), 0);
                this.enableAnimations();
            }
        }
    }

    @Override
    public final void performIndexedAdjustment(int n, int n2) {
        switch (n2) {
            case 1: {
                this.stopInternalAnimations();
                this.setLetterScrollingIndicatorActive(true);
                break;
            }
            case 2: {
                this.setLetterScrollingIndicatorActive(false);
                break;
            }
        }
        this.letterScrollingIndex = this.listLUT.getLetterScrollingIndexByLayoutValue(n);
        this.invalidateList(2048);
        this.disableAnimations();
        this.snap(this.getLetterScrollingAbsIndex(), 0);
        this.enableAnimations();
        this.notifyAdjustmentListeners();
    }

    @Override
    public final void performPagingAdjustment(int n, int n2) {
        switch (n2) {
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            default: {
                this.adjustmentDirection = this.getValue() <= n ? 1 : 2;
                this.snapPage(n, this.adjustmentDirection == 1);
            }
        }
    }

    @Override
    public void disableAdjustmentChanged() {
        ++this.adjustmentShadowCounter;
    }

    @Override
    public void enableAdjustmentChanged() {
        --this.adjustmentShadowCounter;
    }

    @Override
    public boolean isAdjustmentEnabled() {
        return this.adjustmentShadowCounter == 0;
    }

    public boolean isIndexAdjustmentSupported() {
        return this.is_letterScrollingSupported();
    }

    @Override
    public void setInitialSelectionMode(int n) {
        this.initialSelectionMode = n;
    }

    @Override
    public int getInitialSelectionMode() {
        return this.initialSelectionMode;
    }

    protected void notifyAdjustmentStarted() {
        TemplateListController templateListController = (TemplateListController)this.getController();
        templateListController.fire_adjustmentStarted();
    }

    protected void notifyAdjustmentStopped() {
        TemplateListController templateListController = (TemplateListController)this.getController();
        templateListController.fire_adjustmentStopped();
    }

    protected abstract void notifyPageChanged() {
    }

    static {
        LETTER_SCROLLING_DEBUG = System.getProperty("de.vw.mib.widgets.letterscrollingdebug") != null;
    }
}

