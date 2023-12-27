/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.AbstractTemplateList;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$PropertyAnimation;
import de.vw.mib.widgets.WidgetList$1;
import de.vw.mib.widgets.WidgetList$2;
import de.vw.mib.widgets.WidgetList$3;
import de.vw.mib.widgets.WidgetList$BrowsingAnimation;
import de.vw.mib.widgets.WidgetList$BrowsingAnimationDelayer;
import de.vw.mib.widgets.WidgetList$CollapseAnimation;
import de.vw.mib.widgets.WidgetList$DraggingSnapRepeater;
import de.vw.mib.widgets.WidgetList$ExpandAnimation;
import de.vw.mib.widgets.WidgetList$SnapAnimation;
import de.vw.mib.widgets.controller.WidgetListController;
import de.vw.mib.widgets.interfaces.Focusable;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.layout.ListLayout;
import de.vw.mib.widgets.list.DefaultListLUT;
import de.vw.mib.widgets.list.DefaultTemplateListSelectionStrategy;
import de.vw.mib.widgets.list.ListControl;
import de.vw.mib.widgets.list.OptimizedListLUT;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetListModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.WidgetListUI;
import java.util.Arrays;

public class WidgetList
extends AbstractTemplateList
implements WidgetListModel,
Focusable {
    public static final long serialVersionUID;
    private static final int LAYOUT_VALUE_X;
    private static final int LAYOUT_VALUE_Y;
    private static final int LAYOUT_VALUE_PAGE;
    private static final int LAYOUT_VALUE_COUNT;
    private static final int DYNAMIC_ITEM_SIZE_CACHE_MAX;
    private static final int DYNAMIC_ITEM_SIZE_CACHE_MASK_HEIGHT;
    private static final float PROXIMITY_IN_END_VALUE;
    private static final float PROXIMITY_OUT_END_VALUE;
    private static final float MOSTLY_VISIBLE_THRESHOLD;
    private int orientation;
    private Insets padding;
    private Image[] separatorImages;
    private Insets[] separatorInsets;
    private int separatorOffset;
    private int spacingHorizontal;
    private int spacingVertical;
    private int spacingPage;
    private int browsingDirection;
    private Image dropIndicatorImage;
    private Insets dropIndicatorInsets;
    private int alphaDragItem;
    private int alphaDragItemSource;
    private int separatorMode;
    private int itemExtent;
    private int alignmentPage;
    private IntIntOptHashMap dynamicItemSizeCache;
    private WidgetList$SnapAnimation snapAnimation;
    private WidgetList$ExpandAnimation expandAnimation;
    private WidgetList$CollapseAnimation collapseAnimation;
    private AbstractWidget$PropertyAnimation proximityAnimation;
    float proximityAnimationValue;
    private AbstractWidget$PropertyAnimation pressedAnimation;
    float pressedAnimationValue;
    private AbstractWidget$PropertyAnimation activatedAnimation;
    float activatedAnimationValue;
    private WidgetList$BrowsingAnimation browsingAnimation;
    private Rectangle viewport;
    private Rectangle listItemRect;
    private Rectangle cursorArea;
    protected Point dragPosition;
    private Point dragPositionInitial;
    private int animatedLayoutShadow;
    protected boolean browsingActivated;
    private boolean browsingTextureInvalid;
    private boolean browsingTextureDrawingEnabled;
    private WidgetList$BrowsingAnimationDelayer browsingDelayer;
    private WidgetList$DraggingSnapRepeater draggingSnapRepeater;
    private int minimum;
    private int maximum;
    private int pageIndex;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$WidgetListUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$RadioListUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$RadioListRotatedUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$RadioListScalingUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$PhonePlateListUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$MotorWayInfoListUI;

    @Override
    protected void reset() {
        super.reset();
        this.viewport = new Rectangle();
        this.cursorArea = new Rectangle();
        this.listItemRect = new Rectangle();
        this.padding = new Insets(0, 0, 0, 0);
        this.dragPosition = new Point(0, 0);
        this.dragPositionInitial = new Point(0, 0);
        this.expandAnimation = new WidgetList$ExpandAnimation(this);
        this.collapseAnimation = new WidgetList$CollapseAnimation(this);
        this.browsingAnimation = null;
        this.snapAnimation = new WidgetList$SnapAnimation(this);
        this.proximityAnimation = null;
        this.dynamicItemSizeCache = null;
    }

    public void init(boolean bl, int n, int n2, int n3, int n4, int n5, Image image, boolean bl2, boolean bl3, int n6, boolean bl4, StaticImageModel staticImageModel, boolean bl5, boolean bl6, Image image2, Insets insets, boolean bl7, EasingParams[] easingParamsArray, boolean bl8, int n7, int n8, int n9, ListItemModel[] listItemModelArray, boolean bl9, int n10, int n11, int n12, boolean bl10, int n13, int n14, boolean bl11, Point[] pointArray, KeyframeAnimation[] keyframeAnimationArray, boolean bl12, LayoutAttribs layoutAttribs, boolean bl13, int n15, WidgetModel widgetModel, boolean bl14, TextAreaModel textAreaModel, boolean bl15, int n16, boolean bl16, String string, boolean bl17, int n17, Insets insets2, int n18, Image image3, int n19, boolean bl18, int n20, int n21, int n22, Image[] imageArray, Insets[] insetsArray, int n23, int n24, int n25, int n26, int n27, int n28, Insets insets3, boolean bl19, int n29, int n30, int n31) {
        super.init(bl, n, n3, image, bl2, bl3, staticImageModel, bl5, bl6, bl7, easingParamsArray, bl8, n7, n8, n9, listItemModelArray, bl9, n10, n11, n12, bl10, n13, bl11, pointArray, keyframeAnimationArray, bl12, layoutAttribs, bl13, n15, widgetModel, bl14, textAreaModel, bl15, n16, bl16, string, bl17, n18, image3, n19, bl18, n20, n21, n22, n28, insets3, bl19, n29, n30, n31);
        this.alignmentPage = n2;
        this.alphaDragItem = n4;
        this.alphaDragItemSource = n5;
        this.browsingDirection = n6;
        this.dropIndicatorImage = image2;
        this.dropIndicatorInsets = insets;
        this.itemExtent = n14;
        this.orientation = n17;
        this.padding = insets2;
        this.separatorImages = imageArray;
        this.separatorInsets = insetsArray;
        this.separatorOffset = n24;
        this.spacingHorizontal = n25;
        this.spacingPage = n26;
        this.spacingVertical = n27;
        this.separatorMode = n23;
        this.setInternalStateFlag(32, bl4);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.browsingDelayer = new WidgetList$BrowsingAnimationDelayer(this, this);
        this.draggingSnapRepeater = new WidgetList$DraggingSnapRepeater(this);
        this.browsingTextureDrawingEnabled = false;
        this.browsingTextureInvalid = false;
        this.animatedLayoutShadow = 0;
        this.pageIndex = -1;
        this.proximityAnimationValue = this.is_interactive() ? 0.0f : 1.0f;
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_dropIndicatorImage());
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        this.startActivatedAnimation();
    }

    @Override
    protected void initListLUT() {
        this.listLUT = !this.is_dynamicItemSize() && (this.orientation == 1 || this.orientation == 0) ? new OptimizedListLUT() : new DefaultListLUT();
        this.listLUT.setLayoutable(this);
        this.listLUT.setLayoutValueCount(3);
        this.listLUT.setLetterScrollingLayoutValueNumber(this.isVertical() ? 1 : 0);
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$WidgetListUI == null ? (class$de$vw$mib$widgets$ui$WidgetListUI = WidgetList.class$("de.vw.mib.widgets.ui.WidgetListUI")) : class$de$vw$mib$widgets$ui$WidgetListUI, class$de$vw$mib$widgets$ui$RadioListUI == null ? (class$de$vw$mib$widgets$ui$RadioListUI = WidgetList.class$("de.vw.mib.widgets.ui.RadioListUI")) : class$de$vw$mib$widgets$ui$RadioListUI, class$de$vw$mib$widgets$ui$RadioListRotatedUI == null ? (class$de$vw$mib$widgets$ui$RadioListRotatedUI = WidgetList.class$("de.vw.mib.widgets.ui.RadioListRotatedUI")) : class$de$vw$mib$widgets$ui$RadioListRotatedUI, class$de$vw$mib$widgets$ui$RadioListScalingUI == null ? (class$de$vw$mib$widgets$ui$RadioListScalingUI = WidgetList.class$("de.vw.mib.widgets.ui.RadioListScalingUI")) : class$de$vw$mib$widgets$ui$RadioListScalingUI, class$de$vw$mib$widgets$ui$PhonePlateListUI == null ? (class$de$vw$mib$widgets$ui$PhonePlateListUI = WidgetList.class$("de.vw.mib.widgets.ui.PhonePlateListUI")) : class$de$vw$mib$widgets$ui$PhonePlateListUI, class$de$vw$mib$widgets$ui$MotorWayInfoListUI == null ? (class$de$vw$mib$widgets$ui$MotorWayInfoListUI = WidgetList.class$("de.vw.mib.widgets.ui.MotorWayInfoListUI")) : class$de$vw$mib$widgets$ui$MotorWayInfoListUI};
    }

    @Override
    public final int get_browsingDirection() {
        return this.browsingDirection;
    }

    @Override
    public final void set_browsingDirection(int n) {
        int n2 = this.browsingDirection;
        if (n2 != n) {
            this.browsingDirection = n;
            this.browsingDirectionChanged(n2);
            this.propertyChanged(67);
        }
    }

    @Override
    public final Insets get_padding() {
        return this.padding;
    }

    @Override
    public final void set_padding(Insets insets) {
        Insets insets2 = this.padding;
        if (insets2 == null || !insets2.equals(insets)) {
            this.padding = insets;
            this.paddingChanged(insets2);
            this.propertyChanged(66);
        }
    }

    @Override
    public int get_separatorMode() {
        return this.separatorMode;
    }

    @Override
    public void set_separatorMode(int n) {
        int n2 = this.separatorMode;
        if (n2 != n) {
            this.separatorMode = n;
            this.separatorModeChanged(n2);
            this.propertyChanged(58);
        }
    }

    @Override
    public Image[] get_separatorImages() {
        return this.separatorImages;
    }

    @Override
    public void set_separatorImages(Image[] imageArray) {
        Object[] objectArray = this.separatorImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.separatorImages = imageArray;
            this.separatorImagesChanged((Image[])objectArray);
            this.propertyChanged(59);
        }
    }

    @Override
    public Insets[] get_separatorInsets() {
        return this.separatorInsets;
    }

    @Override
    public void set_separatorInsets(Insets[] insetsArray) {
        Object[] objectArray = this.separatorInsets;
        if (!Arrays.equals(objectArray, insetsArray)) {
            this.separatorInsets = insetsArray;
            this.separatorInsetsChanged((Insets[])objectArray);
            this.propertyChanged(60);
        }
    }

    @Override
    public final int get_separatorOffset() {
        return this.separatorOffset;
    }

    @Override
    public final void set_separatorOffset(int n) {
        int n2 = this.separatorOffset;
        if (n2 != n) {
            this.separatorOffset = n;
            this.separatorOffsetChanged(n2);
            this.propertyChanged(65);
        }
    }

    @Override
    public final int get_orientation() {
        return this.orientation;
    }

    @Override
    public final void set_orientation(int n) {
        int n2 = this.orientation;
        if (n2 != n) {
            this.orientation = n;
            this.orientationChanged(n2);
            this.propertyChanged(54);
        }
    }

    @Override
    public final int get_spacingVertical() {
        return this.spacingVertical;
    }

    @Override
    public final void set_spacingVertical(int n) {
        int n2 = this.spacingVertical;
        if (n2 != n) {
            this.spacingVertical = n;
            this.spacingVerticalChanged(n2);
            this.propertyChanged(55);
        }
    }

    @Override
    public final int get_spacingHorizontal() {
        return this.spacingHorizontal;
    }

    @Override
    public final void set_spacingHorizontal(int n) {
        int n2 = this.spacingVertical;
        if (n2 != n) {
            this.spacingHorizontal = n;
            this.spacingHorizontalChanged(n2);
            this.propertyChanged(55);
        }
    }

    @Override
    public final int get_spacingPage() {
        return this.spacingPage;
    }

    @Override
    public final void set_spacingPage(int n) {
        int n2 = this.spacingPage;
        if (n2 != n) {
            this.spacingPage = n;
            this.spacingPageChanged(n2);
            this.propertyChanged(56);
        }
    }

    @Override
    public final Image get_dropIndicatorImage() {
        return this.dropIndicatorImage;
    }

    @Override
    public final void set_dropIndicatorImage(Image image) {
        Image image2 = this.dropIndicatorImage;
        if (image2 == null || !image2.equals(image)) {
            this.dropIndicatorImage = image;
            this.dropIndicatorImageChanged(image2);
            this.propertyChanged(68);
        }
    }

    @Override
    public final Insets get_dropIndicatorInsets() {
        return this.dropIndicatorInsets;
    }

    @Override
    public final void set_dropIndicatorInsets(Insets insets) {
        Insets insets2 = this.dropIndicatorInsets;
        if (insets2 == null || !insets2.equals(insets)) {
            this.dropIndicatorInsets = insets;
            this.dropIndicatorInsetsChanged(insets2);
            this.propertyChanged(69);
        }
    }

    @Override
    public final int get_alphaDragItem() {
        return this.alphaDragItem;
    }

    @Override
    public final void set_alphaDragItem(int n) {
        int n2 = this.alphaDragItem;
        if (n2 != n) {
            this.alphaDragItem = n;
            this.alphaDragItemChanged(n2);
            this.propertyChanged(70);
        }
    }

    @Override
    public final int get_alphaDragItemSource() {
        return this.alphaDragItemSource;
    }

    @Override
    public final void set_alphaDragItemSource(int n) {
        int n2 = this.alphaDragItemSource;
        if (n2 != n) {
            this.alphaDragItemSource = n;
            this.alphaDragItemSourceChanged(n2);
            this.propertyChanged(71);
        }
    }

    @Override
    public int get_itemExtent() {
        return this.itemExtent;
    }

    @Override
    public void set_itemExtent(int n) {
        int n2 = this.itemExtent;
        if (n2 != n) {
            this.itemExtent = n;
            this.itemExtentChanged(n2);
            this.propertyChanged(72);
        }
    }

    @Override
    public boolean is_browsingHideScrollBar() {
        return this.getInternalStateFlag(32);
    }

    @Override
    public void set_browsingHideScrollBar(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(32);
        if (bl2 != bl) {
            this.setInternalStateFlag(32, bl);
            this.browsingHideScrollBarChanged(bl2);
            this.propertyChanged(74);
        }
    }

    @Override
    public int get_alignmentPage() {
        return this.alignmentPage;
    }

    @Override
    public void set_alignmentPage(int n) {
        int n2 = this.alignmentPage;
        if (n2 != n) {
            this.alignmentPage = n;
            this.alignmentPageChanged(n2);
            this.propertyChanged(75);
        }
    }

    @Override
    public int getItemX(int n) {
        if (n >= 0 && n < this.listLUT.getItemCount()) {
            return this.listLUT.getItemLayoutValue(n, 0);
        }
        return 0;
    }

    @Override
    public void setItemX(int n, int n2) {
        if (n >= 0 && n < this.listLUT.getItemCount()) {
            this.listLUT.setItemLayoutValue(n, 0, n2);
        }
    }

    @Override
    public int getItemY(int n) {
        int n2 = 0;
        if (n >= 0 && n < this.listLUT.getItemCount()) {
            n2 = this.listLUT.getItemLayoutValue(n, 1);
            if (this.animatedLayoutShadow == 0) {
                if (this.isExpandAnimationRunning() && n >= this.getExpandIndexFirst()) {
                    n2 = n <= this.getExpandIndexLast() ? (n2 += this.expandAnimation.getOffsetSub(n, true)) : (n2 += this.expandAnimation.getOffsetMain());
                    n2 = Math.max(n2, this.listLUT.getItemLayoutValue(this.expandAnimation.getIndexMain(), 1));
                }
                if (this.isCollapseAnimationRunning() && n >= this.getCollapseIndexFirst()) {
                    n2 = n <= this.getCollapseIndexLast() ? (n2 += this.collapseAnimation.getOffsetSub(n, false)) : (n2 += this.collapseAnimation.getOffsetMain());
                    n2 = Math.max(n2, this.listLUT.getItemLayoutValue(this.collapseAnimation.getIndexMain(), 1));
                }
            }
        }
        return n2;
    }

    @Override
    public void setItemY(int n, int n2) {
        if (n >= 0 && n < this.listLUT.getItemCount()) {
            this.listLUT.setItemLayoutValue(n, 1, n2);
        }
    }

    @Override
    public int getItemPage(int n) {
        if (n >= 0 && n < this.listLUT.getItemCount()) {
            return this.listLUT.getItemLayoutValue(n, 2);
        }
        return 0;
    }

    @Override
    public void setItemPage(int n, int n2) {
        if (n >= 0 && n < this.listLUT.getItemCount()) {
            this.listLUT.setItemLayoutValue(n, 2, n2);
        }
    }

    @Override
    public int getItemWidth(int n) {
        ListItemModel listItemModel = this.getItem(n);
        int n2 = 0;
        if (listItemModel != null) {
            n2 = this.is_dynamicItemSize() ? this.getDynamicItemSizeValue(n, false) : listItemModel.get_width();
        }
        return n2;
    }

    @Override
    public int getItemHeight(int n) {
        ListItemModel listItemModel = this.getItem(n);
        int n2 = 0;
        if (listItemModel != null) {
            n2 = this.is_dynamicItemSize() ? this.getDynamicItemSizeValue(n, true) : listItemModel.get_height();
        }
        return n2;
    }

    private int getDynamicItemSizeValue(int n, boolean bl) {
        int n2 = 0;
        if (this.dynamicItemSizeCache == null) {
            this.dynamicItemSizeCache = new IntIntOptHashMap();
        }
        if (n >= 0 && n < this.listLUT.getItemCount()) {
            if (!this.dynamicItemSizeCache.containsKey(n)) {
                ListItemModel listItemModel;
                if (this.dynamicItemSizeCache.size() > 20) {
                    this.clearDynamicItemSizeCache();
                }
                if ((listItemModel = this.getItemMaster(n)).getHelperItemClone() != null) {
                    listItemModel = listItemModel.getHelperItemClone();
                }
                listItemModel.setDataInvalid(true);
                this.disableAnimations();
                listItemModel.stopInternalAnimations();
                this.transferData(listItemModel, n, this.getItemIndex(n));
                listItemModel.validateLayout();
                listItemModel.performDynamicResize();
                this.enableAnimations();
                n2 = listItemModel.get_height() << 16 | listItemModel.get_width();
                this.dynamicItemSizeCache.put(n, n2);
            } else {
                n2 = this.dynamicItemSizeCache.get(n);
            }
            n2 = bl ? (n2 & 0xFFFF) >> 16 : n2 & 0xFFFF0000;
        }
        return n2;
    }

    protected void clearDynamicItemSizeCache() {
        if (this.dynamicItemSizeCache != null) {
            this.dynamicItemSizeCache.clear();
        }
    }

    @Override
    public int getLayoutIndexFirst() {
        return this.listLUT.getLayoutIndexFirst();
    }

    @Override
    public int getLayoutIndexLast() {
        return this.listLUT.getLayoutIndexLast();
    }

    @Override
    public Rectangle getViewport() {
        return this.viewport;
    }

    protected void setViewport(int n, int n2, int n3, int n4) {
        this.viewport.x = n;
        this.viewport.y = n2;
        this.viewport.width = n3;
        this.viewport.height = n4;
        this.validateListImmediately(1024);
        this.notifyAdjustmentListeners();
        this.disableAnimations();
        this.updateCursor();
        this.enableAnimations();
        this.repaint();
    }

    @Override
    public void setViewport(int n, int n2) {
        this.setViewport(n, n2, this.viewport.width, this.viewport.height);
    }

    @Override
    public void setViewportX(int n) {
        this.setViewport(n, this.viewport.y, this.viewport.width, this.viewport.height);
    }

    @Override
    public void setViewportY(int n) {
        this.setViewport(this.viewport.x, n, this.viewport.width, this.viewport.height);
    }

    @Override
    public boolean isViewportOutsideLower() {
        if (this.isVertical()) {
            return this.viewport.y < 0;
        }
        return this.viewport.x < 0;
    }

    @Override
    public boolean isViewportOutsideUpper() {
        int n = this.get_itemCount() - 1;
        if (this.isVertical()) {
            return this.viewport.y + this.viewport.height > this.getItemY(n) + this.getItemHeight(n);
        }
        return this.viewport.x + this.viewport.width > this.getItemX(n) + this.getItemWidth(n);
    }

    @Override
    public int locationToIndex(Point point, int n) {
        Rectangle rectangle = new Rectangle();
        point.translate(this.viewport.x, this.viewport.y);
        for (int i2 = Math.max(n, this.getFirstVisibleIndex()); i2 <= this.getLastVisibleIndex(); ++i2) {
            Insets insets = this.getItem(i2).get_touchInsets();
            rectangle.setLocation(this.getItemX(i2) + insets.left, this.getItemY(i2) + insets.top);
            rectangle.setSize(this.getItemWidth(i2) - insets.left - insets.right, this.getItemHeight(i2) - insets.top - insets.bottom);
            if (!rectangle.contains(point)) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public int locationToIndex(int n, int n2, int n3) {
        return this.locationToIndex(new Point(n, n2), n3);
    }

    @Override
    public void setListControl(ListControl listControl) {
        super.setListControl(listControl);
    }

    @Override
    public int getCollapseIndexFirst() {
        if (this.collapseAnimation != null) {
            return this.collapseAnimation.getIndexFirst();
        }
        return -1;
    }

    @Override
    public int getCollapseIndexLast() {
        if (this.collapseAnimation != null) {
            return this.collapseAnimation.getIndexLast();
        }
        return -1;
    }

    @Override
    public int getExpandIndexFirst() {
        if (this.expandAnimation != null) {
            return this.expandAnimation.getIndexFirst();
        }
        return -1;
    }

    @Override
    public int getExpandIndexLast() {
        if (this.expandAnimation != null) {
            return this.expandAnimation.getIndexLast();
        }
        return -1;
    }

    @Override
    public float getExpandAlpha() {
        if (this.expandAnimation != null) {
            return this.expandAnimation.getAlpha();
        }
        return 1.0f;
    }

    @Override
    public float getCollapseAlpha() {
        if (this.collapseAnimation != null) {
            return this.collapseAnimation.getAlpha();
        }
        return 1.0f;
    }

    @Override
    public boolean isProximityAnimationRunning() {
        return this.proximityAnimation != null && (this.proximityAnimation.isActive() || this.proximityAnimation.isStarted());
    }

    @Override
    public float getProximityAnimationValue() {
        return this.proximityAnimationValue;
    }

    @Override
    public float getPressedAnimationValue() {
        return this.pressedAnimationValue;
    }

    @Override
    public float getActivatedAnimationValue() {
        return this.activatedAnimationValue;
    }

    @Override
    public int getBrowsingPositionPrevContext() {
        return this.isBrowsingAnimationRunning() ? this.browsingAnimation.getBrowsingPositionPrevContext() : 0;
    }

    @Override
    public int getBrowsingPositionNextContext() {
        return this.isBrowsingAnimationRunning() ? this.browsingAnimation.getBrowsingPositionNextContext() : this.get_width();
    }

    @Override
    public boolean isExpandAnimationRunning() {
        return this.expandAnimation != null && this.expandAnimation.isActive();
    }

    @Override
    public boolean isCollapseAnimationRunning() {
        return this.collapseAnimation != null && this.collapseAnimation.isActive();
    }

    @Override
    public boolean isSnapAnimationRunning() {
        return this.snapAnimation != null && this.snapAnimation.isActive();
    }

    @Override
    public boolean isSnapAnimationStoppableByUser() {
        return this.snapAnimation != null && this.snapAnimation.isActive() && this.snapAnimation.isStoppableByUser();
    }

    @Override
    public boolean isBrowsingAnimationRunning() {
        return this.browsingAnimation != null && this.browsingAnimation.isActive();
    }

    private int getFirstPageIndex(int n) {
        int n2 = this.getItemPage(n);
        int n3 = n;
        for (int i2 = 0; i2 < this.get_itemCount(); ++i2) {
            if (this.getItemPage(i2) != n2) continue;
            n3 = i2;
            break;
        }
        return n3;
    }

    private int getLastPageIndex(int n) {
        int n2 = this.getItemPage(n);
        int n3 = n;
        for (int i2 = this.get_itemCount() - 1; i2 >= 0; --i2) {
            if (this.getItemPage(i2) != n2) continue;
            n3 = i2;
            break;
        }
        return n3;
    }

    private int getSnapCoordinate(int n, int n2) {
        int n3;
        boolean bl = this.isPaging();
        boolean bl2 = this.isVertical();
        int n4 = Util.clamp(n, 0, this.get_itemCount() - 1);
        if (bl) {
            int n5 = n4 = n2 == 0 ? this.getFirstPageIndex(n4) : this.getLastPageIndex(n4);
            n3 = bl2 ? this.getItemPage(n4) * (this.get_height() + this.spacingPage) - this.padding.top : this.getItemPage(n4) * (this.get_width() + this.spacingPage) - this.padding.left;
        } else {
            n3 = bl2 ? (n2 == 0 ? this.getItemY(n4) : this.getItemY(n4) + this.getItemHeight(n4) - this.viewport.height) : (n2 == 0 ? this.getItemX(n4) : this.getItemX(n4) + this.getItemWidth(n4) - this.viewport.width);
        }
        if (n3 > this.maximum) {
            n3 = this.maximum;
        } else if (n3 < this.minimum || n4 == 0) {
            n3 = this.minimum;
        }
        return n3;
    }

    @Override
    public boolean isVertical() {
        return this.orientation == 0 || this.orientation == 2 || this.orientation == 4 || this.orientation == 6;
    }

    @Override
    public boolean isMultiColumn() {
        return this.orientation == 3 || this.orientation == 7 || this.orientation == 2 || this.orientation == 6;
    }

    @Override
    public boolean isPaging() {
        return this.orientation == 4 || this.orientation == 5 || this.orientation == 6 || this.orientation == 7;
    }

    @Override
    public Point getDragPosition() {
        return this.dragPosition;
    }

    protected void browsingDirectionChanged(int n) {
    }

    @Override
    protected void firstItemIndexChanged(int n) {
        if (this.get_firstItemIndex() >= 0) {
            this.invalidateList(0x800000);
            if (this.browsingDelayer != null) {
                this.browsingDelayer.executeBrowsing();
            }
        }
    }

    @Override
    protected void selectedIndexChanged(int n) {
        super.selectedIndexChanged(n);
        int n2 = this.get_selectedIndex();
        int n3 = this.get_itemCount();
        int n4 = n2;
        if (n2 != -1 && n2 < n3) {
            int n5;
            if (n != -1) {
                n5 = n2 < n ? 0 : 1;
                switch (this.get_scrollTypeRotary()) {
                    case 0: 
                    case 2: {
                        int n6 = this.getLastMostlyVisibleIndex() - this.getFirstMostlyVisibleIndex();
                        int n7 = n2;
                        if (n5 == 0) {
                            n7 = DefaultTemplateListSelectionStrategy.getPrevSelectedIndex(this);
                            n4 = n7 == n2 ? Math.max(0, n2 - n6) : n2;
                            break;
                        }
                        n7 = DefaultTemplateListSelectionStrategy.getNextSelectedIndex(this);
                        n4 = n7 == n2 ? Math.min(this.get_itemCount() - 1, n2 + n6) : n2;
                        break;
                    }
                    case 1: {
                        n4 = n5 == 0 ? n4 - 1 : n4 + 1;
                        break;
                    }
                }
            } else {
                ListItemModel listItemModel;
                int n8 = n5 = Math.abs(this.getFirstVisibleIndex() - n2) < Math.abs(this.getLastVisibleIndex() - n2) ? 0 : 1;
                if (this.isSnapAnimationRunning()) {
                    this.stopSnapAnimationFastForward();
                    this.disableAnimations();
                    this.snap(n5 == 0 ? this.getFirstMostlyVisibleIndex() : this.getLastMostlyVisibleIndex(), n5);
                    this.enableAnimations();
                }
                if ((listItemModel = this.getItemMaster(n2)) != null && listItemModel.hasActivatedSubItem() && listItemModel.get_subItemRefs()[0].hasSubSlider() && this.getAbsIndexByListItemDynamicIndex(listItemModel, listItemModel.getRelativeItemIndex(listItemModel.get_activatedIndex())) == n2) {
                    this.lockSelection();
                }
            }
            if (!this.isViewportContainsItem(n4)) {
                n4 = Util.clamp(n4, 0, n3 - 1);
                this.snap(n4, n5);
                this.notifyAdjustmentStarted();
                this.notifyAdjustmentStopped();
            }
        }
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.initViewport(false);
        if (this.isPaging()) {
            this.performLayout();
        }
        this.validateListImmediately(21504);
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.initViewport(false);
        if (this.isPaging()) {
            this.performLayout();
        }
        this.validateListImmediately(21504);
    }

    protected void orientationChanged(int n) {
        this.initListLUT();
        this.invalidateList();
        this.initViewport();
        this.notifyAdjustmentListeners();
    }

    protected void paddingChanged(Insets insets) {
        this.invalidateList();
        this.initViewport();
        this.notifyAdjustmentListeners();
    }

    protected void spacingVerticalChanged(int n) {
        this.invalidateList();
        this.notifyAdjustmentListeners();
    }

    protected void spacingHorizontalChanged(int n) {
        this.invalidateList();
        this.notifyAdjustmentListeners();
    }

    protected void spacingPageChanged(int n) {
        this.invalidateList();
        this.notifyAdjustmentListeners();
    }

    protected void separatorEnabledChanged(boolean bl) {
        this.repaint();
    }

    protected void separatorModeChanged(int n) {
        this.repaint();
    }

    protected void separatorImagesChanged(Image[] imageArray) {
        this.repaint();
    }

    protected void separatorInsetsChanged(Insets[] insetsArray) {
        this.repaint();
    }

    protected void separatorOffsetChanged(int n) {
        this.repaint();
    }

    protected void dropIndicatorImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_dropIndicatorImage());
        this.repaint();
    }

    protected void dropIndicatorInsetsChanged(Insets insets) {
        this.repaint();
    }

    protected void alphaDragItemChanged(int n) {
        this.repaint();
    }

    protected void alphaDragItemSourceChanged(int n) {
        this.repaint();
    }

    protected void itemExtentChanged(int n) {
    }

    @Override
    protected void pressedIndexChanged() {
        super.pressedIndexChanged();
        if (!this.startPressedAnimation()) {
            this.pressedAnimationValue = this.getPressedIndex() != -1 ? 1.0f : 0.0f;
        }
    }

    @Override
    protected void activatedIndexChanged() {
        super.activatedIndexChanged();
        if (!this.startActivatedAnimation()) {
            this.activatedAnimationValue = 1.0f;
        }
    }

    private void browsingHideScrollBarChanged(boolean bl) {
    }

    protected void alignmentPageChanged(int n) {
        this.resetListView();
        this.invalidateList();
    }

    @Override
    public void validateList() {
        boolean bl;
        super.validateList();
        int n = this.get_selectedIndex();
        boolean bl2 = n == -1;
        boolean bl3 = bl = WidgetList.isListSelectionEnabled() && bl2 || !WidgetList.isListSelectionEnabled() && !bl2;
        if (bl) {
            int n2 = this.getFocusedIndex();
            if (WidgetList.isListSelectionEnabled()) {
                if (bl2) {
                    n = n2 == -1 ? DefaultTemplateListSelectionStrategy.getNextSelectedIndex(this, 1) : n2;
                }
            } else {
                n = -1;
            }
            this.set_selectedIndex(n);
        }
    }

    @Override
    public void validateBrowsing() {
        if (this.browsingTextureInvalid) {
            this.browsingTextureInvalid = false;
            this.browsingTextureDrawingEnabled = true;
        }
    }

    @Override
    public void validateLayout() {
    }

    @Override
    public void performLayout() {
        ++this.animatedLayoutShadow;
        this.freeze();
        this.clearDynamicItemSizeCache();
        ListLayout.performLayout(this);
        this.invalidateList(17412);
        this.unfreeze();
        --this.animatedLayoutShadow;
    }

    @Override
    protected void validateFirstItemIndex() {
        int n = this.get_firstItemIndex();
        if (!this.isFollowModeEnabled() && !this.isAdjusting() && n >= 0) {
            boolean bl = this.isPaging();
            if (n < this.get_itemCount() || this.getMaximum() > 0) {
                if (!bl) {
                    this.disableAnimations();
                }
                this.stopSnapAnimation();
                this.snap(n - this.get_firstItemIndexPosition(), 0);
                this.invalidateList(68);
                this.set_firstItemIndex(-1);
                if (!bl) {
                    this.enableAnimations();
                }
            }
        } else {
            this.set_firstItemIndex(-1);
        }
    }

    @Override
    public final boolean isBrowsingTextureInvalid() {
        return this.browsingTextureInvalid;
    }

    @Override
    public boolean isBrowsingTextureDrawingEnabled() {
        return this.browsingTextureDrawingEnabled;
    }

    public void setBrowsingTextureDrawingEnabled(boolean bl) {
        this.browsingTextureDrawingEnabled = bl;
    }

    @Override
    public final void activateBrowsing() {
        if (this.getEasing(19) != null) {
            this.browsingTextureInvalid = true;
            this.browsingActivated = true;
            this.repaint();
        }
    }

    @Override
    protected void initViewport() {
        this.initViewport(true);
    }

    private void initViewport(boolean bl) {
        this.viewport.width = this.get_width();
        this.viewport.height = this.get_height();
        if (bl) {
            this.stopInternalAnimations();
            int n = 0;
            switch (this.get_alignment()) {
                case 0: {
                    n = this.getMinimum();
                    break;
                }
                case 1: {
                    n = this.getMaximum();
                    break;
                }
                case 2: {
                    n = this.getMaximum() - this.getMinimum() >> 1;
                    break;
                }
            }
            if (this.isVertical()) {
                this.setViewport(0, n);
            } else {
                this.setViewport(n, 0);
            }
        }
    }

    @Override
    protected void validateViewport() {
        int n = this.getValue();
        boolean bl = this.isVertical();
        boolean bl2 = this.isSnapAnimationRunning();
        if (!this.isExpandAnimationRunning() && !this.isCollapseAnimationRunning()) {
            int n2;
            if (bl2) {
                n = bl ? this.snapAnimation.getDestY() : this.snapAnimation.getDestX();
            }
            if (n != (n2 = Util.clamp(n, this.getMinimum(), this.getMaximum()))) {
                if (bl2) {
                    this.stopSnapAnimation();
                }
                if (bl) {
                    this.setViewportY(n2);
                } else {
                    this.setViewportX(n2);
                }
            }
        }
        if (this.is_listViewObserverEnabled()) {
            this.pageIndex = -1;
        }
    }

    @Override
    public void interactiveChanged(boolean bl) {
        super.interactiveChanged(bl);
        if (!this.startProximityAnimation()) {
            this.proximityAnimationValue = bl ? 1.0f : 0.0f;
        }
    }

    @Override
    protected void manageSelectiveItemUpdate(ListItemModel listItemModel, int n, int n2) {
        int n3 = this.getAbsIndexByListItemDynamicIndex(listItemModel, n);
        if (n3 != -1 && n3 < this.getLastVisibleIndex()) {
            this.stopSnapAnimationFastForward();
            int n4 = this.get_selectedIndex();
            int n5 = this.getFirstMostlyVisibleIndex();
            this.validateListImmediately(2);
            this.disableAnimations();
            this.snap(n5 + n2, 0);
            if (n4 != -1) {
                this.set_selectedIndex(n4 + n2);
            }
            this.enableAnimations();
        } else {
            super.manageSelectiveItemUpdate(listItemModel, n, n2);
        }
    }

    @Override
    protected void manageListBrowsing() {
        if (this.browsingActivated && this.browsingDirection != 0) {
            this.stopSnapAnimation();
            this.invalidateList();
            this.browsingDelayer.requestBrowsing();
            this.browsingActivated = false;
        }
    }

    @Override
    protected void manageListExpansion(ListItemModel listItemModel) {
        ++this.animatedLayoutShadow;
        this.freeze();
        int n = this.getAbsIndexByListItemDynamicIndex(listItemModel, listItemModel.getRelativeItemIndex(listItemModel.get_activatedIndex()));
        boolean bl = this.isViewportContainsItem(n);
        int n2 = this.getItemY(n);
        super.manageListExpansion(listItemModel);
        if (this.isExpandAnimationRunning() && this.expandAnimation.listItem == listItemModel) {
            this.stopExpandAnimation();
        }
        if (this.isCollapseAnimationRunning() && this.collapseAnimation.listItem == listItemModel) {
            this.stopCollapseAnimation();
        }
        if (this.isSnapAnimationRunning()) {
            this.stopSnapAnimation();
        }
        if (listItemModel.hasActivatedSubItem()) {
            if (listItemModel.get_activatedIndex() == -1) {
                this.startCollapseAnimation(listItemModel);
            } else {
                boolean bl2;
                ListItemModel[] listItemModelArray = listItemModel.get_subItemRefs();
                boolean bl3 = listItemModel.hasSubItem() && listItemModelArray[0].hasSubSlider();
                boolean bl4 = bl2 = listItemModel.hasSubItem() && listItemModelArray[0].isDynamic();
                if (listItemModel.getSubItemCount() == 1 && (bl3 || !bl2)) {
                    if (listItemModel.getActivatedIndexPrev() != -1) {
                        this.startCollapseAnimation(listItemModel);
                    }
                } else {
                    if (this.isCollapseAnimationRunning()) {
                        this.stopCollapseAnimation();
                    } else {
                        listItemModel.setActivatedIndexPrev(-1);
                        this.validateListImmediately(2);
                    }
                    n = this.getAbsIndexByListItemDynamicIndex(listItemModel, listItemModel.getRelativeItemIndex(listItemModel.get_activatedIndex()));
                    if (bl) {
                        int n3 = this.getItemY(n);
                        this.setViewportY(Util.clamp(this.getViewport().y + (n3 - n2), this.getMinimum(), this.getMaximum()));
                    }
                    this.validateListImmediately(64);
                }
                if (this.isFollowModeEnabled()) {
                    this.disableAnimations();
                    this.startExpandAnimation(listItemModel);
                    this.enableAnimations();
                } else {
                    this.startExpandAnimation(listItemModel);
                }
            }
        }
        this.unfreeze();
        --this.animatedLayoutShadow;
    }

    protected void enableSubItemLimitation(ListItemModel listItemModel) {
        this.validateListImmediately(1024);
        int n = this.getLastVisibleIndex() - this.getFirstVisibleIndex();
        ListItemModel[] listItemModelArray = listItemModel.get_subItemRefs();
        for (int i2 = listItemModelArray.length - 1; i2 >= 0; --i2) {
            ListItemModel listItemModel2 = listItemModelArray[i2];
            int n2 = listItemModel2.getItemCount();
            if (n2 <= n) continue;
            boolean[] blArray = new boolean[n2];
            for (int i3 = 0; i3 < n; ++i3) {
                blArray[i3] = true;
            }
            listItemModel2.set_existenceFlags(blArray);
        }
        this.validateListImmediately(2);
    }

    protected void disableSubItemLimitation(ListItemModel listItemModel) {
        ListItemModel[] listItemModelArray = listItemModel.get_subItemRefs();
        for (int i2 = listItemModelArray.length - 1; i2 >= 0; --i2) {
            ListItemModel listItemModel2 = listItemModelArray[i2];
            listItemModel2.set_existenceFlags(null);
        }
        this.validateListImmediately(2);
    }

    @Override
    public void dragItem(int n) {
        super.dragItem(n);
        this.dragPosition.setLocation(this.getItemX(n) - this.viewport.x, this.getItemY(n) - this.viewport.y);
        this.dragPositionInitial.setLocation(this.dragPosition);
        this.draggingSnapRepeater.start();
        this.repaint();
    }

    @Override
    public void moveItem(int n, int n2) {
        super.moveItem(n, n2);
        this.validateList();
        int n3 = this.getFirstMostlyVisibleIndex();
        int n4 = this.getLastMostlyVisibleIndex();
        this.dragPosition.x = this.dragPositionInitial.x + n;
        this.dragPosition.y = this.dragPositionInitial.y + n2;
        Rectangle rectangle = new Rectangle(this.dragPosition.x, this.dragPosition.y, this.getItemWidth(this.getDragIndex()), this.getItemHeight(this.getDragIndex()));
        Rectangle rectangle2 = new Rectangle();
        n3 = this.getFirstVisibleIndex();
        n4 = this.getLastVisibleIndex();
        int n5 = 0;
        int n6 = this.getDropIndex();
        for (int i2 = n3; i2 <= n4; ++i2) {
            ListItemModel listItemModel = this.getItem(i2);
            if (listItemModel == null || !listItemModel.is_enabled() || !listItemModel.is_draggable()) continue;
            rectangle2.setBounds(this.getItemX(i2) - this.viewport.x, this.getItemY(i2) - this.viewport.y, this.getItemWidth(i2), this.getItemHeight(i2));
            Rectangle rectangle3 = rectangle.intersection(rectangle2);
            if (rectangle3.width * rectangle3.height <= n5) continue;
            n5 = rectangle3.width * rectangle3.height;
            n6 = i2;
        }
        this.setDropIndex(n6);
        this.repaint();
    }

    protected void moveItem() {
        this.moveItem(this.dragPosition.x - this.dragPositionInitial.x, this.dragPosition.y - this.dragPositionInitial.y);
    }

    @Override
    public void dropItem() {
        super.dropItem();
        this.draggingSnapRepeater.stop();
        this.repaint();
    }

    @Override
    protected void showFollowedItem() {
        int n;
        ListItemModel listItemModel;
        int n2;
        if (this.isFollowModeEnabled() && (n2 = this.getAbsIndexByListItemDynamicIndex(listItemModel, n = (listItemModel = this.getFollowItem()).get_activatedIndex() != -1 ? listItemModel.get_activatedIndex() : listItemModel.getActivatedIndexAPI())) != -1) {
            int n3 = n2 - this.get_followItemPosition();
            this.snap(n3, 0);
            if (LOGGER.isTraceEnabled(32)) {
                LogMessage logMessage = LOGGER.trace(32);
                logMessage.append("WidgetList '").append(this.getQualifiedName()).append("': Follow mode - Item shown with absolute index: ").append(n2).append(" - New first item index: ").append(n3).log();
            }
        }
    }

    @Override
    boolean isFollowModeEnabled() {
        return super.isFollowModeEnabled() && !this.isExpandAnimationRunning() && !this.isCollapseAnimationRunning();
    }

    @Override
    protected void notifyPageChanged() {
        int n;
        if (this.isPaging() && this.getController() != null && this.pageIndex != (n = this.getItemPage(this.getFirstMostlyVisibleIndex()))) {
            this.pageIndex = n;
            WidgetListController widgetListController = (WidgetListController)this.getController();
            widgetListController.fire_pageChanged(n);
        }
        this.startActivatedAnimation();
    }

    void notifyItemExpanded() {
        WidgetListController widgetListController = (WidgetListController)this.getController();
        widgetListController.fire_itemExpanded();
    }

    void notifyItemCollapsed() {
        WidgetListController widgetListController = (WidgetListController)this.getController();
        widgetListController.fire_itemCollapsed();
    }

    @Override
    protected void validateVisibleIndices() {
        int n;
        int n2;
        int n3;
        boolean bl = this.isVertical();
        int n4 = this.get_itemCount();
        int n5 = this.getFirstVisibleIndex();
        int n6 = this.getLastVisibleIndex();
        int n7 = -1;
        n7 = n5 != -1 && this.isViewportIntersectsItem(n5) ? n5 : (n6 != -1 && this.isViewportIntersectsItem(n6) ? n6 : this.findVisibleIndexBinary(0, n4 - 1, bl));
        if (n7 != -1) {
            n5 = this.findVisibleIndexLinear(n7, 0, false, false);
            n5 = n5 == -1 ? 0 : n5 + 1;
            n6 = this.findVisibleIndexLinear(n7, n4 - 1, true, false);
            n6 = n6 == -1 ? n4 - 1 : n6 - 1;
        } else {
            n5 = -1;
            n6 = -1;
        }
        int n8 = n6;
        for (n3 = n5; !this.isViewportContainsItem(n3) && n3 < this.get_itemCount() - 1; ++n3) {
        }
        while (!this.isViewportContainsItem(n8) && n8 > 0) {
            --n8;
        }
        for (n2 = n5; !this.isViewportIntersecsItem(n2, -1701242561) && n2 < n3; ++n2) {
        }
        for (n = n6; !this.isViewportIntersecsItem(n, -1701242561) && n > n8; --n) {
        }
        this.setVisibleIndices(n5, n3, n2, n6, n8, n);
    }

    private boolean isViewportIntersecsItem(int n, float f2) {
        int n2 = (int)((float)this.getItemWidth(n) * (1.0f - f2));
        int n3 = (int)((float)this.getItemHeight(n) * (1.0f - f2));
        this.viewport.grow(n2, n3);
        boolean bl = this.isViewportContainsItem(n);
        this.viewport.grow(-n2, -n3);
        return bl;
    }

    private boolean isViewportIntersectsItem(int n) {
        this.listItemRect.setBounds(this.getItemX(n), this.getItemY(n), this.getItemWidth(n), this.getItemHeight(n));
        return this.viewport.intersects(this.listItemRect);
    }

    private boolean isViewportContainsItem(int n) {
        int n2;
        int n3;
        int n4;
        int n5 = 0;
        if (this.isVertical()) {
            n4 = Util.clamp(this.getItemX(n), 0, this.get_width());
            n3 = this.getItemY(n) - this.padding.top;
            n2 = Util.clamp(this.getItemWidth(n), 0, this.get_width() - n4);
            n5 = this.getItemHeight(n);
        } else {
            n4 = this.getItemX(n) - this.padding.left;
            n3 = Util.clamp(this.getItemY(n), 0, this.get_height());
            n2 = this.getItemWidth(n);
            n5 = Util.clamp(this.getItemHeight(n), 0, this.get_height() - n3);
        }
        this.listItemRect.setBounds(n4, n3, n2, n5);
        return this.viewport.contains(this.listItemRect);
    }

    private int findVisibleIndexLinear(int n, int n2, boolean bl, boolean bl2) {
        int n3 = -1;
        if (bl) {
            for (int i2 = n; i2 <= n2; ++i2) {
                boolean bl3 = this.isViewportIntersectsItem(i2);
                if ((!bl2 || !bl3) && (bl2 || bl3)) continue;
                return i2;
            }
        } else {
            for (int i3 = n; i3 >= n2; --i3) {
                boolean bl4 = this.isViewportIntersectsItem(i3);
                if ((!bl2 || !bl4) && (bl2 || bl4)) continue;
                return i3;
            }
        }
        return -1;
    }

    private int findVisibleIndexBinary(int n, int n2, boolean bl) {
        int n3;
        int n4 = n;
        int n5 = n2;
        int n6 = -1;
        int n7 = bl ? this.viewport.y : this.viewport.x;
        int n8 = n3 = bl ? this.viewport.height : this.viewport.width;
        while (n4 <= n5 && n6 == -1) {
            int n9;
            int n10 = n4 + (n5 - n4 >> 1);
            int n11 = bl ? this.getItemY(n10) : this.getItemX(n10);
            int n12 = n9 = bl ? this.getItemHeight(n10) : this.getItemWidth(n10);
            if (n11 + n9 < n7 + 1) {
                n4 = n10 + 1;
                continue;
            }
            if (n11 > n7 + n3 - 1) {
                n5 = n10 - 1;
                continue;
            }
            n6 = n10;
        }
        return n6;
    }

    @Override
    protected void updateCursor() {
        StaticImageModel staticImageModel = this.get_cursorImageRef();
        if (staticImageModel != null) {
            int n = this.get_selectedIndex();
            boolean bl = AbstractList.isListSelectionEnabled() && n != -1;
            ListItemModel listItemModel = this.getItem(n);
            if (bl && listItemModel != null) {
                boolean bl2 = this.isVertical();
                Insets insets = listItemModel.get_cursorInsets();
                int n2 = this.getItemWidth(n) - insets.right - insets.left;
                int n3 = this.getItemHeight(n) - insets.bottom - insets.top;
                int n4 = this.getItemX(n) + insets.left - this.viewport.x;
                int n5 = this.getItemY(n) + insets.top - this.viewport.y;
                this.updateCursorArea();
                n4 = bl2 ? n4 : Util.clamp(n4, this.cursorArea.x, this.cursorArea.width - n2);
                n5 = bl2 ? Util.clamp(n5, this.cursorArea.y, this.cursorArea.height - n3) : n5;
                staticImageModel.stopInternalAnimations();
                staticImageModel.set_x(n4);
                staticImageModel.set_y(n5);
                staticImageModel.set_height(n3);
                staticImageModel.set_width(n2);
            }
            staticImageModel.set_visible(bl);
        }
    }

    private void updateCursorArea() {
        switch (this.get_scrollTypeRotary()) {
            case 0: 
            case 2: {
                this.cursorArea.setBounds(0, 0, this.get_width(), this.get_height());
                break;
            }
            case 1: {
                int n = this.getFirstVisibleIndex();
                int n2 = this.getLastVisibleIndex();
                int n3 = this.get_itemCount();
                int n4 = n == 0 ? 0 : this.getItemWidth(n) + this.get_spacingHorizontal();
                int n5 = n == 0 ? 0 : this.getItemHeight(n) + this.get_spacingVertical();
                int n6 = n2 == n3 - 1 ? this.get_width() : this.get_width() - this.getItemWidth(n2) - this.get_spacingHorizontal();
                int n7 = n2 == n3 - 1 ? this.get_height() : this.get_height() - this.getItemHeight(n2) - this.get_spacingVertical();
                this.cursorArea.setBounds(n4, n5, n6, n7);
                break;
            }
            default: {
                this.cursorArea.setBounds(0, 0, this.get_width(), this.get_height());
            }
        }
    }

    @Override
    protected void syncFromListControl() {
        super.syncFromListControl();
        ListControl listControl = this.getListControl();
        int n = 0;
        if (this.is_listControlEnabled() && listControl != null) {
            n = listControl.getViewPortPosition();
            if (LOGGER.isTraceEnabled(32)) {
                LogMessage logMessage = LOGGER.trace(32);
                logMessage.append(new StringBuffer().append("AbstractTemplateList '").append(this).append("': Synchronize from ListControl - Viewport Position: ").toString()).append(n).log();
            }
            if (this.isVertical()) {
                this.setViewportY(n);
            } else {
                this.setViewportX(n);
            }
            this.validateViewport();
        }
    }

    @Override
    protected void syncToListControl() {
        int n;
        super.syncToListControl();
        ListControl listControl = this.getListControl();
        Rectangle rectangle = this.getViewport();
        int n2 = n = this.isVertical() ? rectangle.y : rectangle.x;
        if (this.is_listControlEnabled() && listControl != null) {
            if (LOGGER.isTraceEnabled(32)) {
                LogMessage logMessage = LOGGER.trace(32);
                logMessage.append(new StringBuffer().append("AbstractTemplateList '").append(this).append("': Synchronize to ListControl - Viewport Position: ").toString()).append(n).log();
            }
            listControl.setViewPortPosition(n);
        }
    }

    @Override
    public void paintFocused(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetListUI widgetListUI;
        if (this.is_visible() && this.is_availableInVariant() && (widgetListUI = (WidgetListUI)this.getUI()) != null) {
            widgetListUI.paintFocused(graphics3D, viewModel, this, rectangle, rectangle2, f2);
        }
    }

    private void startExpandAnimation(ListItemModel listItemModel) {
        this.enableSubItemLimitation(listItemModel);
        int n = listItemModel.getSubItemCount();
        EasingParams[] easingParamsArray = this.get_easing();
        boolean bl = false;
        if (n > 0 && this.areAnimationsEnabled() && easingParamsArray != null && easingParamsArray.length > 11 && easingParamsArray.length > 12) {
            this.stopExpandAnimation();
            int n2 = this.getAbsIndexByListItemDynamicIndex(listItemModel, listItemModel.getRelativeItemIndex(listItemModel.get_activatedIndex()));
            int n3 = n2 + 1;
            int n4 = n3 + n - 1;
            int n5 = this.getItemY(n4) + this.getItemHeight(n3) - this.getItemY(n3) + this.get_spacingVertical();
            int n6 = -n5;
            boolean bl2 = false;
            this.expandAnimation = new WidgetList$ExpandAnimation(this);
            this.expandAnimation.setStartValue(n6);
            this.expandAnimation.setDeltaValue(0 - n6);
            this.expandAnimation.setAnimationParams(listItemModel, easingParamsArray[11], easingParamsArray[12], easingParamsArray[15]);
            bl = this.startInternalAnimation(this.expandAnimation);
            ListItemModel listItemModel2 = this.getItem(n3);
            if (listItemModel2 != null && (listItemModel2.hasSubSlider() || !listItemModel2.isDynamic())) {
                if (!this.isViewportContainsItem(n4) && !this.isCollapseAnimationRunning()) {
                    int n7 = listItemModel.getActivatedIndexPrev();
                    int n8 = listItemModel.get_activatedIndex();
                    int n9 = n7 == -1 || n7 > n8 ? n4 : n2;
                    this.snap(n9, 1, this.getEasing(11), true, false);
                }
            } else {
                this.snap(n2, 0, this.getEasing(11), true, false);
            }
        }
        if (!bl) {
            this.disableSubItemLimitation(listItemModel);
            listItemModel.setActivatedIndexPrev(-1);
            this.validateListImmediately(18);
            this.notifyItemExpanded();
        }
    }

    @Override
    public final void stopExpandAnimation() {
        if (this.expandAnimation != null && this.isExpandAnimationRunning()) {
            this.stopInternalAnimation(this.expandAnimation);
            this.expandAnimation = null;
        }
    }

    private void startCollapseAnimation(ListItemModel listItemModel) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        this.enableSubItemLimitation(listItemModel);
        int n6 = listItemModel.getSubItemCount();
        EasingParams[] easingParamsArray = this.get_easing();
        boolean bl = false;
        if (n6 > 0 && this.areAnimationsEnabled() && easingParamsArray != null && easingParamsArray.length > 13 && easingParamsArray.length > 14) {
            this.stopCollapseAnimation();
            n5 = this.getAbsIndexByListItemDynamicIndex(listItemModel, listItemModel.getRelativeItemIndex(listItemModel.getActivatedIndexPrev()));
            int n7 = n5 + 1;
            n4 = n7 + n6 - 1;
            if (n5 <= this.getLastVisibleIndex() && n4 >= this.getFirstFullyVisibleIndex()) {
                int n8;
                n3 = this.getItemY(n4) + this.getItemHeight(n7) - this.getItemY(n7) + this.get_spacingVertical();
                n2 = 0;
                n = -n3;
                this.collapseAnimation = new WidgetList$CollapseAnimation(this);
                this.collapseAnimation.setStartValue(0.0f);
                this.collapseAnimation.setDeltaValue(n - 0);
                this.collapseAnimation.setAnimationParams(listItemModel, easingParamsArray[13], easingParamsArray[14], easingParamsArray[16]);
                if (this.getValue() > this.getMaximum() - n3) {
                    this.snap(this.get_itemCount() - 1 - (n4 - n7 + 1), 1, this.getEasing(13), true, false);
                }
                if ((n8 = this.getFocusedIndex()) != -1 && n8 > n5) {
                    this.snap(n5, 0, this.getEasing(13), true, false);
                }
                bl = this.startInternalAnimation(this.collapseAnimation);
            }
        }
        if (!bl) {
            this.disableSubItemLimitation(listItemModel);
            n5 = this.getFirstFullyVisibleIndex();
            ListItemModel listItemModel2 = this.getItemMaster(n5);
            n4 = this.getItemIndex(n5);
            n3 = this.getItemY(n5);
            listItemModel.setActivatedIndexPrev(-1);
            this.validateListImmediately(2);
            if (listItemModel2 != null) {
                n2 = this.getAbsIndexByListItemDynamicIndex(listItemModel2, listItemModel2.getRelativeItemIndex(n4));
                n = this.getItemY(n2);
                this.setViewportY(Util.clamp(this.getViewport().y + (n - n3), this.getMinimum(), this.getMaximum()));
            }
            this.notifyItemCollapsed();
        }
    }

    @Override
    public final void stopCollapseAnimation() {
        if (this.collapseAnimation != null && this.isCollapseAnimationRunning()) {
            this.stopInternalAnimation(this.collapseAnimation);
            this.collapseAnimation = null;
        }
    }

    private boolean startProximityAnimation() {
        int n;
        boolean bl = this.is_interactive();
        int n2 = n = bl ? 17 : 18;
        if (this.proximityAnimation != null) {
            if (this.proximityAnimation.isActive()) {
                this.stopInternalAnimation(this.proximityAnimation);
            }
            this.proximityAnimation = null;
        }
        if (this.isEasingAvailable(n)) {
            this.proximityAnimation = new AbstractWidget$PropertyAnimation((AbstractWidget)this, n, new WidgetList$1(this));
        }
        return this.startPropertyAnimation(this.proximityAnimation, bl ? 0.0f : 1.0f);
    }

    @Override
    public boolean isPressedAnimationRunning() {
        return this.pressedAnimation != null && this.pressedAnimation.isActive();
    }

    private boolean startPressedAnimation() {
        if (this.pressedAnimation == null && this.isEasingAvailable(21)) {
            this.pressedAnimation = new AbstractWidget$PropertyAnimation((AbstractWidget)this, 21, new WidgetList$2(this));
        }
        return this.startPropertyAnimation(this.pressedAnimation, this.getPressedIndex() == -1 ? 0.0f : 1.0f);
    }

    @Override
    public boolean isActivatedAnimationRunning() {
        return this.activatedAnimation != null && this.activatedAnimation.isActive();
    }

    private boolean startActivatedAnimation() {
        if (this.activatedAnimation == null && this.isEasingAvailable(20)) {
            this.activatedAnimation = new AbstractWidget$PropertyAnimation((AbstractWidget)this, 20, new WidgetList$3(this));
        }
        this.stopInternalAnimation(this.activatedAnimation);
        return this.startPropertyAnimation(this.activatedAnimation, 0.0f, this.getActivatedIndex() == -1 ? 0.0f : 1.0f, false);
    }

    protected boolean startBrowsingAnimation(boolean bl) {
        EasingParams easingParams = this.getEasing(19);
        if (easingParams != null) {
            this.stopBrowsingAnimation();
            this.browsingAnimation = new WidgetList$BrowsingAnimation(this, this);
            this.browsingAnimation.setAnimationParams(easingParams, this.browsingDirection, this.get_width(), bl);
            return this.startInternalAnimation(this.browsingAnimation);
        }
        if (bl) {
            AbstractList.enableListSelection();
        }
        return false;
    }

    private void stopBrowsingAnimation() {
        if (this.browsingAnimation != null) {
            this.stopInternalAnimation(this.browsingAnimation);
            this.browsingAnimation = null;
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopSnapAnimationFastForward();
        this.stopBrowsingAnimation();
        this.stopExpandAnimation();
        this.stopCollapseAnimation();
        this.stopInternalAnimation(this.proximityAnimation);
        this.stopInternalAnimation(this.pressedAnimation);
        this.stopInternalAnimation(this.activatedAnimation);
    }

    @Override
    public void stopExpandAndCollapseAnimation() {
        this.stopExpandAnimation();
        this.stopCollapseAnimation();
    }

    @Override
    public void snap(int n, int n2) {
        this.snap(n, n2, this.getEasing(7), true, true);
    }

    protected void snap(int n, int n2, EasingParams easingParams, boolean bl, boolean bl2) {
        int n3;
        boolean bl3 = this.isVertical();
        int n4 = this.getSnapCoordinate(n, n2);
        int n5 = n3 = bl3 ? this.viewport.y : this.viewport.x;
        if (n3 != n4) {
            if (bl3) {
                this.startSnapAnimation(this.viewport.x, n4, easingParams, bl, false, bl2);
            } else {
                this.startSnapAnimation(n4, this.viewport.y, easingParams, bl, false, bl2);
            }
        }
    }

    @Override
    public void snapPage(int n, boolean bl) {
        int n2 = bl ? this.getFirstVisibleIndex() : this.getLastVisibleIndex();
        int n3 = this.isVertical() ? 1 : 0;
        int n4 = this.listLUT.findLayoutValueItemIndex(n + this.spacingPage, n3, n2, bl);
        this.snap(n4, 0, this.getEasing(7), false, true);
    }

    @Override
    public void calculateBoundingBox(int n, int n2, Point point, Point point2) {
        if (this.is_visible()) {
            int n3;
            this.validateListImmediately(6);
            int n4 = n + this.get_x();
            int n5 = n2 + this.get_y();
            int n6 = this.getLastVisibleIndex();
            if (n3 != -1 && n6 != -1) {
                for (n3 = this.getFirstVisibleIndex(); n3 <= n6; ++n3) {
                    point.x = Math.min(n4 + Math.min(this.viewport.x, this.getItemX(n3) - this.viewport.x), point.x);
                    point.y = Math.min(n5 + Math.min(this.viewport.y, this.getItemY(n3) - this.viewport.y), point.y);
                    point2.x = Math.max(n4 + Math.min(this.getItemX(n3) + this.getItemWidth(n3) - this.viewport.x, this.viewport.width), point2.x);
                    point2.y = Math.max(n5 + Math.min(this.getItemY(n3) + this.getItemHeight(n3) - this.viewport.y, this.viewport.height), point2.y);
                }
            } else {
                point.x = Math.min(n4, point.x);
                point.y = Math.min(n5, point.y);
                point2.x = Math.max(n4 + this.viewport.width, point2.x);
                point2.y = Math.max(n5 + this.viewport.height, point2.y);
            }
        }
    }

    private int getPageIndex(int n) {
        int n2 = this.getFirstVisibleIndex();
        int n3 = this.getFirstPageIndex(n2);
        int n4 = this.getLastPageIndex(n2);
        if (this.isVertical()) {
            int n5 = this.getItemY(n4) + this.getItemHeight(n4) - this.getItemY(n3);
            int n6 = this.getItemY(n) + (this.getItemHeight(n) >> 1) - this.getItemY(n3);
            return n6 > n5 ? n4 + 1 : n3;
        }
        int n7 = this.getItemX(n4) + this.getItemWidth(n4) - this.getItemX(n3);
        int n8 = this.getItemX(n) + (this.getItemWidth(n) >> 1) - this.getItemX(n3);
        return n8 > n7 ? n4 + 1 : n3;
    }

    private void startSnapAnimation(int n, int n2, EasingParams easingParams, boolean bl, boolean bl2, boolean bl3) {
        boolean bl4 = this.isSnapAnimationRunning();
        if (easingParams != null) {
            if (this.isPaging()) {
                this.snapAnimation.disablePageNotification();
                this.stopSnapAnimation();
            } else {
                this.stopSnapAnimationFastForward();
            }
            this.snapAnimation.setAnimationParams(easingParams, n, n2, bl, bl2, bl3);
            bl4 = this.startInternalAnimation(this.snapAnimation);
        }
        if (!bl4) {
            if (this.isVertical()) {
                this.setViewportY(n2);
            } else {
                this.setViewportX(n);
            }
            this.repaint();
        }
    }

    @Override
    public void startSnapAnimation(int n, int n2, EasingParams easingParams) {
        this.startSnapAnimation(n, n2, easingParams, true, true, true);
    }

    @Override
    public void stopSnapAnimation() {
        if (this.isSnapAnimationRunning()) {
            this.stopInternalAnimation(this.snapAnimation);
        }
    }

    private void stopSnapAnimationFastForward() {
        if (this.isSnapAnimationRunning()) {
            int n = this.snapAnimation.getDestX();
            int n2 = this.snapAnimation.getDestY();
            this.stopSnapAnimation();
            this.setViewportPosition(n, n2);
            this.validateListImmediately(9216);
        }
    }

    public void resetBrowsingAnimation() {
        if (this.browsingAnimation != null) {
            this.browsingAnimation.reset();
        }
    }

    @Override
    public int getMaxDraggingSpeed() {
        ViewModel viewModel = this.getView();
        return Math.max(viewModel.get_width(), viewModel.get_height());
    }

    @Override
    public void getViewPort(Rectangle rectangle) {
        rectangle.setBounds(this.viewport);
    }

    @Override
    public void getVisualAreaBounds(Rectangle rectangle) {
        if (this.isVertical()) {
            rectangle.setBounds(0, this.getMinimum(), 0, this.getMaximum() + this.viewport.height);
        } else {
            rectangle.setBounds(this.getMinimum(), 0, this.getMaximum() + this.viewport.width, 0);
        }
    }

    @Override
    public void setViewportPosition(int n, int n2) {
        this.setViewport(n, n2, this.viewport.width, this.viewport.height);
    }

    @Override
    public boolean adaptSnapPosition(Point point, int n) {
        int n2;
        boolean bl;
        boolean bl2 = bl = n == 1 || n == 0 && this.snapAnimation.isForwardDirection();
        if (this.get_scrollTypeTouch() != 2) {
            if (this.isVertical()) {
                n2 = bl ? this.getLastFullyVisibleIndex() : this.getFirstFullyVisibleIndex();
                int n3 = bl ? point.y + this.viewport.height - this.getItemHeight(n2) : point.y;
                int n4 = this.listLUT.findLayoutValueItemIndex(n3, 1, n2, bl);
                if (this.isPaging()) {
                    n4 = this.getPageIndex(n4);
                }
                point.y = this.getSnapCoordinate(n4, bl ? 1 : 0);
            } else {
                n2 = bl ? this.getLastVisibleIndex() : this.getFirstVisibleIndex();
                int n5 = bl ? point.x + this.viewport.width - this.getItemWidth(n2) : point.x;
                int n6 = this.listLUT.findLayoutValueItemIndex(n5, 0, n2, bl);
                if (this.isPaging()) {
                    n6 = this.getPageIndex(n6);
                }
                point.x = this.getSnapCoordinate(n6, bl ? 1 : 0);
            }
        }
        if ((n2 = this.get_orientation()) == 1 || n2 == 5 || n2 == 3) {
            return this.getItemWidth(this.getFirstVisibleIndex()) > Math.abs(point.x - this.viewport.x);
        }
        return this.getItemHeight(this.getFirstVisibleIndex()) > Math.abs(point.y - this.viewport.y) || this.viewport.y > this.getMaximum() || this.viewport.y < this.getMinimum();
    }

    @Override
    protected void validateAdjustmentRange() {
        boolean bl = this.isVertical();
        boolean bl2 = this.isPaging();
        int n = 0;
        int n2 = 0;
        int n3 = bl2 ? this.getFirstPageIndex(this.get_itemCount() - 1) : this.get_itemCount() - 1;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        if (bl) {
            n4 = this.getItemY(n3);
            n5 = this.getItemHeight(n3);
            n6 = this.viewport.height + this.padding.bottom;
            n7 = Math.min(n4 + n5, this.viewport.height);
        } else {
            n4 = this.getItemX(n3);
            n5 = this.getItemWidth(n3);
            n6 = this.viewport.width + this.padding.right;
            n7 = Math.min(n4 + n5, this.viewport.width);
        }
        this.set_itemExtent(n7);
        n2 = bl2 ? n4 - (bl ? this.padding.top : this.padding.left) : n4 + n5 - n6;
        switch (this.get_alignment()) {
            case 0: {
                n2 = Math.max(n, n2);
                break;
            }
            case 1: {
                n = Math.min(n, n2);
                break;
            }
            case 2: {
                n2 = n2 < 0 ? n2 >> 1 : Math.max(n, n2);
                n = Math.min(n, n2);
                break;
            }
        }
        this.maximum = n2;
        this.minimum = n;
        this.notifyAdjustmentListeners();
    }

    @Override
    public int getMaximum() {
        return this.maximum;
    }

    @Override
    public int getMinimum() {
        return this.minimum;
    }

    @Override
    public int getBlockIncrement() {
        if (this.isVertical()) {
            return this.viewport.height;
        }
        return this.viewport.width;
    }

    @Override
    public int getValue() {
        if (this.isVertical()) {
            return this.viewport.y;
        }
        return this.viewport.x;
    }

    @Override
    public void setValue(int n) {
        if (this.isVertical()) {
            this.setViewport(this.getViewport().x, n);
        } else {
            this.setViewport(n, this.getViewport().y);
        }
    }

    @Override
    public boolean isAdjusting() {
        return super.isAdjusting() || this.isSnapAnimationRunning() || this.isCollapseAnimationRunning() || this.isExpandAnimationRunning();
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

