/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.graphics.math.algebra.Vector2f;
import de.vw.mib.graphics.math.function.Function1f;
import de.vw.mib.graphics.math.geometry.Point2f;
import de.vw.mib.graphics.math.geometry.Point3f;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractTemplateList;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.AbstractWidget$PublicPropertyAnimation;
import de.vw.mib.widgets.FlowList$1;
import de.vw.mib.widgets.FlowList$2;
import de.vw.mib.widgets.FlowList$3;
import de.vw.mib.widgets.FlowList$AnimatedFlowPositionProperty;
import de.vw.mib.widgets.FlowList$OutlineChangedAnimation;
import de.vw.mib.widgets.controller.FlowListController;
import de.vw.mib.widgets.controller.ListController;
import de.vw.mib.widgets.interfaces.Draggable$DragDataStorage;
import de.vw.mib.widgets.list.FlowListOutlineDefinition;
import de.vw.mib.widgets.list.FlowListOutlineEffectDefinition;
import de.vw.mib.widgets.models.FlowListModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import edu.emory.mathcs.backport.java.util.Arrays;

public class FlowList
extends AbstractTemplateList
implements FlowListModel {
    private static final int DEFAULT_OUTLINE_DEFINITION;
    public static final int Z_PRECISION;
    private static final int TOUCH_SUPPORT_POINTS;
    private static final int FLOW_LAYOUT_VALUE_X;
    private static final int FLOW_LAYOUT_VALUE_Y;
    private static final int FLOW_LAYOUT_VALUE_Z;
    private static final int FLOW_LAYOUT_VALUE_ALPHA;
    private static final int FLOW_LAYOUT_VALUE_ROTATION;
    private static final int FLOW_LAYOUT_CHILD_IDX;
    private static final int FLOW_LAYOUT_REAL_IDX;
    private static final int FLOW_LAYOUT_LUT_VALUE_COUNT;
    private static final int LAYOUT_IDX_MAP_ENABLED_TO_ABS;
    private static final int LAYOUT_IDX_MAP_ABS_TO_ENABLED;
    private static final int LAYOUT_VALUE_COUNT;
    private final AbstractWidget$PublicPropertyAnimation radiusAnimation;
    float radius;
    private final AbstractWidget$PublicPropertyAnimation distanceAnimation;
    float distance;
    private final AbstractWidget$PublicPropertyAnimation elevationAngleAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 10, 68, new FlowList$1(this));
    float elevationAngle;
    private int visibleItemCount;
    private int outline;
    private int outlineEffect;
    private float[] outlinePointX;
    private float[] outlinePointY;
    private float[] outlineRotationY;
    private float outlineCenterPosition;
    private float outlineOffset;
    private float outlineAcceleration;
    private float outlineDebounce;
    private boolean outlineSnapToGrid;
    private int outlineScrollShortcutSize;
    private int outlineScrollingDirection;
    private Point[] projectedOutline;
    private int enabledItemCount;
    private int absSelectedIndex;
    float flowPosition;
    private final FlowList$AnimatedFlowPositionProperty animatedFlowPosition;
    private int currentlyVisibleItemCount;
    private boolean projectedOutlineValid;
    private FlowList$OutlineChangedAnimation outlineChangedAnimation;
    private FlowList$OutlineChangedAnimation outlineEffectChangedAnimation;
    private boolean snappingEnabled;
    private int[][] layoutLUT;
    private float itemDistance;
    private int targetSelectedIndex;
    private FlowListOutlineDefinition outlineDefinition;
    protected int snapShortcutIndexOffset;
    private int snapShortcutStartIndex;
    private int snapShortcutEndIndex;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$FlowListUI;

    public FlowList() {
        this.radiusAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 11, 66, new FlowList$2(this));
        this.distanceAnimation = new AbstractWidget$PublicPropertyAnimation((AbstractWidget)this, 12, 67, new FlowList$3(this));
        this.animatedFlowPosition = new FlowList$AnimatedFlowPositionProperty(this, 7);
        this.outlineDefinition = FlowListOutlineDefinition.getOutline(0);
    }

    public void init(int n, boolean bl, int n2, int n3, Image image, boolean bl2, boolean bl3, StaticImageModel staticImageModel, boolean bl4, int n4, boolean bl5, boolean bl6, EasingParams[] easingParamsArray, int n5, boolean bl7, int n6, int n7, int n8, ListItemModel[] listItemModelArray, boolean bl8, int n9, int n10, int n11, boolean bl9, int n12, boolean bl10, Point[] pointArray, KeyframeAnimation[] keyframeAnimationArray, boolean bl11, LayoutAttribs layoutAttribs, boolean bl12, int n13, WidgetModel widgetModel, boolean bl13, TextAreaModel textAreaModel, boolean bl14, int n14, boolean bl15, String string, boolean bl16, int n15, float f2, float f3, float f4, int n16, float f5, float[] fArray, float[] fArray2, float[] fArray3, int n17, int n18, boolean bl17, int n19, int n20, Image image2, int n21, boolean bl18, int n22, int n23, int n24, int n25, Insets insets, boolean bl19, int n26, int n27, int n28, int n29) {
        super.init(bl, n2, n3, image, bl2, bl3, staticImageModel, bl4, bl5, bl6, easingParamsArray, bl7, n6, n7, n8, listItemModelArray, bl8, n9, n10, n11, bl9, n12, bl10, pointArray, keyframeAnimationArray, bl11, layoutAttribs, bl12, n13, widgetModel, bl13, textAreaModel, bl14, n14, bl15, string, bl16, n20, image2, n21, bl18, n22, n23, n24, n25, insets, bl19, n27, n28, n29);
        this.elevationAngle = n5;
        this.distance = n4;
        this.radius = n19;
        this.visibleItemCount = n26;
        this.outline = n15;
        this.outlineEffect = n16;
        this.outlinePointX = fArray;
        this.outlinePointY = fArray2;
        this.outlineRotationY = fArray3;
        this.outlineCenterPosition = f3;
        this.outlineOffset = f5;
        this.outlineAcceleration = f2;
        this.outlineDebounce = f4;
        this.outlineSnapToGrid = bl17;
        this.outlineScrollShortcutSize = n18;
        this.outlineScrollingDirection = n17;
        this.absSelectedIndex = n;
    }

    public void init(int n, boolean bl, int n2, int n3, Image image, boolean bl2, boolean bl3, StaticImageModel staticImageModel, boolean bl4, int n4, boolean bl5, boolean bl6, EasingParams[] easingParamsArray, int n5, boolean bl7, int n6, int n7, int n8, ListItemModel[] listItemModelArray, boolean bl8, int n9, int n10, int n11, boolean bl9, int n12, Point[] pointArray, KeyframeAnimation[] keyframeAnimationArray, boolean bl10, LayoutAttribs layoutAttribs, boolean bl11, int n13, WidgetModel widgetModel, boolean bl12, TextAreaModel textAreaModel, boolean bl13, int n14, boolean bl14, String string, boolean bl15, int n15, float f2, float f3, float f4, int n16, float f5, float[] fArray, float[] fArray2, float[] fArray3, int n17, int n18, boolean bl16, int n19, boolean bl17, int n20, Image image2, int n21, boolean bl18, int n22, int n23, int n24, boolean bl19, boolean bl20, int n25, Insets insets, boolean bl21, int n26, int n27, int n28, int n29) {
        this.init(n, bl, n2, n3, image, bl2, bl3, staticImageModel, bl4, n4, bl5, bl6, easingParamsArray, n5, bl7, n6, n7, n8, listItemModelArray, bl8, n9, n10, n11, bl9, n12, false, pointArray, keyframeAnimationArray, bl10, layoutAttribs, bl11, n13, widgetModel, bl12, textAreaModel, bl13, n14, bl14, string, bl15, n15, f2, f3, f4, n16, f5, fArray, fArray2, fArray3, n17, n18, bl16, n19, n20, image2, n21, bl18, n22, n23, n24, n25, insets, bl21, n26, n27, n28, n29);
    }

    @Override
    public void init(ViewModel viewModel) {
        this.outlineDefinition = FlowListOutlineDefinition.getOutline(this.outline);
        super.init(viewModel);
        this.initChildren();
        this.projectedOutlineValid = false;
        this.snappingEnabled = true;
        this.targetSelectedIndex = -1;
        this.snapShortcutIndexOffset = 0;
        if (!this.is_listControlEnabled()) {
            this.set_absSelectedIndex(this.absSelectedIndex);
            this.setTargetSelectedIndex(this.get_selectedIndex());
        } else {
            this.updateSelectedIndex();
        }
        this.updateEffectWidgets();
        this.outlineXYZChanged();
    }

    @Override
    public void deInit() {
        this.projectedOutline = null;
        this.layoutLUT = null;
        this.absSelectedIndex = 0;
        this.currentlyVisibleItemCount = 0;
        this.targetSelectedIndex = 0;
        this.animatedFlowPosition.setValue(0.0f);
        this.itemDistance = 0.0f;
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        FlowListController flowListController = (FlowListController)this.getController();
        if (flowListController != null) {
            if (this.outline == 7) {
                flowListController.fireAbsSelectionChanged();
            } else {
                flowListController.fire_selectionChanged();
            }
        }
    }

    @Override
    protected void initListLUT() {
        super.initListLUT();
        this.listLUT.setLayoutValueCount(2);
    }

    private void validateLayoutLUT() {
        if (this.layoutLUT == null || this.layoutLUT.length != this.getMaxVisibleItemCount()) {
            this.layoutLUT = new int[this.getMaxVisibleItemCount()][7];
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$FlowListUI == null ? (class$de$vw$mib$widgets$ui$FlowListUI = FlowList.class$("de.vw.mib.widgets.ui.FlowListUI")) : class$de$vw$mib$widgets$ui$FlowListUI};
    }

    @Override
    public int get_elevationAngle() {
        return (int)this.elevationAngle;
    }

    @Override
    public void set_elevationAngle(int n) {
        int n2 = (int)this.elevationAngle;
        if (!this.elevationAngleAnimation.startAnimation(n) && n2 != n) {
            this.elevationAngle = n;
            this.elevationAngleChanged(n2);
            this.propertyChanged(68);
        }
    }

    @Override
    public int get_distance() {
        return (int)this.distance;
    }

    @Override
    public void set_distance(int n) {
        int n2 = (int)this.distance;
        if (!this.distanceAnimation.startAnimation(n) && n2 != n) {
            this.distance = n;
            this.distanceChanged(n2);
            this.propertyChanged(67);
        }
    }

    @Override
    public void set_radius(int n) {
        int n2 = (int)this.radius;
        if (!this.radiusAnimation.startAnimation(n) && n2 != n) {
            this.radius = n;
            this.radiusChanged(n2);
            this.propertyChanged(66);
        }
    }

    @Override
    public int get_radius() {
        return (int)this.radius;
    }

    @Override
    public void set_visibleItemCount(int n) {
        int n2 = this.get_visibleItemCount();
        if (n2 != n) {
            this.visibleItemCount = n;
            this.visibleItemCountChanged(n2);
            this.propertyChanged(70);
        }
    }

    @Override
    public int get_visibleItemCount() {
        return this.visibleItemCount;
    }

    @Override
    public void set_outline(int n) {
        int n2 = this.outline;
        if (n2 != n) {
            this.outline = n;
            this.outlineChanged(n2);
            this.propertyChanged(54);
        }
    }

    @Override
    public int get_outline() {
        return this.outline;
    }

    @Override
    public void set_outlineEffect(int n) {
        int n2 = this.outlineEffect;
        if (n2 != n) {
            this.outlineEffect = n;
            this.outlineEffectChanged(n2);
            this.propertyChanged(55);
        }
    }

    @Override
    public int get_outlineEffect() {
        return this.outlineEffect;
    }

    @Override
    public void set_outlinePointX(float[] fArray) {
        float[] fArray2 = this.outlinePointX;
        if (!Arrays.equals(fArray2, fArray)) {
            this.outlinePointX = fArray;
            this.outlineXYZChanged();
            this.propertyChanged(56);
        }
    }

    @Override
    public float[] get_outlinePointX() {
        return this.outlinePointX;
    }

    @Override
    public void set_outlinePointY(float[] fArray) {
        float[] fArray2 = this.outlinePointY;
        if (!Arrays.equals(fArray2, fArray)) {
            this.outlinePointY = fArray;
            this.outlineXYZChanged();
            this.propertyChanged(57);
        }
    }

    @Override
    public float[] get_outlinePointY() {
        return this.outlinePointY;
    }

    @Override
    public void set_outlineRotationY(float[] fArray) {
        float[] fArray2 = this.outlineRotationY;
        if (!Arrays.equals(fArray2, fArray)) {
            this.outlineRotationY = fArray;
            this.outlineXYZChanged();
            this.propertyChanged(58);
        }
    }

    @Override
    public float[] get_outlineRotationY() {
        return this.outlineRotationY;
    }

    @Override
    public void set_outlineCenterPosition(float f2) {
        float f3 = this.outlineCenterPosition;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.outlineCenterPosition = f2;
            this.outlineXYZChanged();
            this.propertyChanged(59);
        }
    }

    @Override
    public float get_outlineCenterPosition() {
        return this.outlineCenterPosition;
    }

    @Override
    public void set_outlineOffset(float f2) {
        float f3 = this.outlineOffset;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.outlineOffset = f2;
            this.outlineXYZChanged();
            this.propertyChanged(60);
        }
    }

    @Override
    public float get_outlineOffset() {
        return FlowListOutlineDefinition.getOutlineCustom().getOffset();
    }

    @Override
    public void set_outlineAcceleration(float f2) {
        float f3 = this.outlineAcceleration;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.outlineAcceleration = f2;
            this.outlineXYZChanged();
            this.propertyChanged(61);
        }
    }

    @Override
    public float get_outlineAcceleration() {
        return this.outlineAcceleration;
    }

    @Override
    public void set_outlineDebounce(float f2) {
        float f3 = this.outlineDebounce;
        if (!Util.equalsEpsilon(f3, f2)) {
            this.outlineDebounce = f2;
            this.outlineXYZChanged();
            this.propertyChanged(62);
        }
    }

    @Override
    public float get_outlineDebounce() {
        return this.outlineDebounce;
    }

    @Override
    public void set_outlineSnapToGrid(boolean bl) {
        boolean bl2 = this.outlineSnapToGrid;
        if (bl2 != bl) {
            this.outlineSnapToGrid = bl;
            this.outlineXYZChanged();
            this.propertyChanged(63);
        }
    }

    @Override
    public boolean is_outlineSnapToGrid() {
        return this.outlineSnapToGrid;
    }

    @Override
    public void set_outlineScrollShortcutSize(int n) {
        int n2 = this.outlineScrollShortcutSize;
        if (n2 != n) {
            this.outlineScrollShortcutSize = n;
            this.outlineXYZChanged();
            this.propertyChanged(64);
        }
    }

    @Override
    public int get_outlineScrollShortcutSize() {
        return this.outlineScrollShortcutSize;
    }

    @Override
    public void set_outlineScrollingDirection(int n) {
        int n2 = this.outlineScrollingDirection;
        if (n2 != n) {
            this.outlineScrollingDirection = n;
            this.outlineXYZChanged();
            this.propertyChanged(65);
        }
    }

    @Override
    public int get_outlineScrollingDirection() {
        return this.outlineScrollingDirection;
    }

    @Override
    public void set_absSelectedIndex(int n) {
        this.absSelectedIndex = n;
        this.set_selectedIndex(this.getEnabledIndexByAbsIndex(n));
    }

    @Override
    public int get_absSelectedIndex() {
        return this.getAbsIndexByEnabledIndex(this.get_selectedIndex());
    }

    @Override
    public int getVisibleItemCount() {
        return this.currentlyVisibleItemCount;
    }

    protected void invalidateFlowLayout() {
        this.invalidateList(1024);
    }

    @Override
    public int getEnabledItemCount() {
        return this.enabledItemCount;
    }

    @Override
    public int getTargetSelectedIndex() {
        return this.targetSelectedIndex != -1 ? this.targetSelectedIndex : this.get_selectedIndex();
    }

    @Override
    public void getViewPort(Rectangle rectangle) {
        rectangle.x = (int)(this.flowPosition * 5292871);
        rectangle.y = 0;
        rectangle.width = (int)((float)this.getMaxVisibleItemCount() * this.itemDistance * 5292871);
        rectangle.height = 0;
    }

    @Override
    public void setTargetSelectedIndex(int n, int n2) {
        this.setTargetSelectedIndex(n);
        this.snap(n, n2, true);
    }

    protected void setTargetSelectedIndex(int n) {
        if (n != this.targetSelectedIndex) {
            FlowListController flowListController;
            this.targetSelectedIndex = n;
            if (this.outline == 7 && (flowListController = (FlowListController)this.getController()) != null) {
                flowListController.fireAbsSelectionChanged();
            }
        }
    }

    private float getFlowPosition() {
        return this.flowPosition;
    }

    @Override
    public float getFlowPositionByScreenCoordinates(int n, int n2) {
        Point[] pointArray = this.getOutlineScreenCoordinates();
        if (pointArray != null) {
            float f2 = 1.0f / (float)(pointArray.length - 1);
            int n3 = 0;
            int n4 = -32897;
            float f3 = 0.0f;
            Vector2f vector2f = new Vector2f();
            Vector2f vector2f2 = new Vector2f();
            Vector2f vector2f3 = new Vector2f();
            for (int i2 = 0; i2 < pointArray.length - 1; ++i2) {
                float f4;
                float f5;
                vector2f.set((float)pointArray[i2 + 1].x - (float)pointArray[i2].x, (float)pointArray[i2 + 1].y - (float)pointArray[i2].y);
                vector2f2.set((float)pointArray[i2 + 1].x - (float)n, (float)pointArray[i2 + 1].y - (float)n2);
                vector2f3.set((float)n - (float)pointArray[i2].x, (float)n2 - (float)pointArray[i2].y);
                float f6 = vector2f.getAngle(vector2f3);
                float f7 = vector2f.getAngle(vector2f2);
                if ((double)f6 > 1.5707963267948966) {
                    f5 = vector2f3.getLength();
                    f4 = 0.0f;
                } else if ((double)f7 > 1.5707963267948966) {
                    f5 = vector2f2.getLength();
                    f4 = 1.0f;
                } else {
                    f5 = (float)Math.sin(f6) * vector2f3.getLength();
                    f4 = (float)Math.cos(f6) * vector2f3.getLength() / vector2f.getLength();
                }
                if (!(f5 < n4)) continue;
                n3 = i2;
                n4 = (int)f5;
                f3 = f4;
            }
            return (float)n3 * f2 + f3 * f2;
        }
        return 0.0f;
    }

    private void setFlowPosition(float f2) {
        float f3 = this.clampFlowPosition(f2);
        if (this.outlineDefinition.isSnapToGridEnabled()) {
            int n = this.getItemIndexByFlowPosition(f3);
            this.snap(n, 0);
        } else {
            float f4 = this.flowPosition;
            if (f3 != f4) {
                this.animatedFlowPosition.setValue(f3);
                this.setSnappingEnabled(false);
                this.updateSelectedIndex();
                this.setTargetSelectedIndex(this.get_selectedIndex());
                this.setSnappingEnabled(true);
                this.invalidateList(1024);
                this.invalidateFlowLayout();
                this.repaint();
            }
        }
    }

    @Override
    public boolean isSnapAnimationActive() {
        return this.animatedFlowPosition.isActive();
    }

    @Override
    public void stopSnapAnimation() {
        this.stopInternalAnimation(this.animatedFlowPosition);
    }

    @Override
    public boolean isDragActive() {
        return this.getDragDataStorage().dragActive;
    }

    @Override
    public boolean isPaging() {
        return false;
    }

    @Override
    public boolean isVertical() {
        switch (this.outline) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return false;
            }
            case 7: {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isMultiColumn() {
        return false;
    }

    @Override
    public float getDragAcceleration() {
        return this.outlineDefinition.getAcceleration();
    }

    @Override
    public float getDebounceValue() {
        return this.outlineDefinition.getDebounce();
    }

    private boolean isHideEffectWidgets() {
        return this.outline == 3 && !this.isSelectedItemInFront() || this.outline == 1 && (!this.isSelectedItemInFront() || this.isDragActive());
    }

    @Override
    protected void showFollowedItem() {
        if (this.isFollowModeEnabled()) {
            LogMessage logMessage;
            ListItemModel listItemModel = this.getFollowItem();
            int n = this.listLUT.getAbsIndexByListItemDynamicIndex(listItemModel, listItemModel.get_activatedIndex());
            this.set_selectedIndex(n);
            if (LOGGER.isTraceEnabled(32)) {
                logMessage = LOGGER.trace(32);
                logMessage.append("FlowList '").append(this.getQualifiedName()).append(": Follow mode - item shown with absolute index: ").append(n).log();
            }
            if (n == -1) {
                this.initViewport();
                logMessage = LOGGER.warn(32);
                logMessage.append("FlowList '").append(this.getQualifiedName()).append("': Follow mode - Item to follow is not available.");
            }
        }
    }

    @Override
    protected void manageListBrowsing() {
    }

    @Override
    protected void notifyPageChanged() {
    }

    @Override
    public int getChildIndex(int n) {
        return this.layoutLUT[n][5];
    }

    @Override
    public int getRealIndex(int n) {
        return this.layoutLUT[n][6];
    }

    @Override
    public int getItemX(int n) {
        return this.layoutLUT[n][0];
    }

    @Override
    public int getItemY(int n) {
        return this.layoutLUT[n][1];
    }

    @Override
    public int getItemAlpha(int n) {
        return this.layoutLUT[n][3];
    }

    @Override
    public int getItemRotation(int n) {
        return this.layoutLUT[n][4];
    }

    @Override
    public int getItemZ(int n) {
        return this.layoutLUT[n][2];
    }

    @Override
    public int getVisIndex(int n) {
        int n2 = this.getMaxVisibleItemCount();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.layoutLUT[i2][5] != n) continue;
            return i2;
        }
        return -1;
    }

    @Override
    public int getMaxVisibleItemCount() {
        return this.visibleItemCount == 0 ? this.enabledItemCount : this.visibleItemCount;
    }

    @Override
    protected void selectedIndexChanged(int n) {
        FlowListController flowListController;
        super.selectedIndexChanged(n);
        this.propertyChanged(71);
        if (this.snappingEnabled) {
            this.setTargetSelectedIndex(this.get_selectedIndex());
            this.snap(this.get_selectedIndex(), 0, true);
        }
        this.notifyAdjustmentListeners();
        if (this.outline != 7 && (flowListController = (FlowListController)this.getController()) != null) {
            flowListController.fire_selectionChanged();
        }
    }

    protected void elevationAngleChanged(float f2) {
        this.invalidateFlowLayout();
        this.projectedOutlineValid = false;
        this.repaint();
    }

    protected void distanceChanged(float f2) {
        this.invalidateFlowLayout();
        this.projectedOutlineValid = false;
        this.repaint();
    }

    protected void radiusChanged(float f2) {
        this.invalidateFlowLayout();
        this.projectedOutlineValid = false;
        this.repaint();
    }

    protected void outlineChanged(int n) {
        this.outlineDefinition = FlowListOutlineDefinition.getOutline(this.outline);
        this.startOutlineChangedAnimation(n);
        this.invalidateFlowLayout();
        this.projectedOutlineValid = false;
        this.repaint();
    }

    protected void outlineEffectChanged(int n) {
        this.startOutlineEffectChangedAnimation(n);
        this.invalidateFlowLayout();
        this.repaint();
    }

    protected void outlineXYZChanged() {
        if (this.get_outline() == 13) {
            FlowListOutlineDefinition.createOutlineCustom(this.get_outlinePointX(), this.get_outlinePointY(), this.get_outlineRotationY(), this.get_outlineCenterPosition(), this.get_outlineOffset(), this.get_outlineAcceleration(), this.get_outlineDebounce(), this.is_outlineSnapToGrid(), this.get_outlineScrollShortcutSize(), this.get_outlineScrollingDirection());
            this.outlineChanged(this.get_outline());
        }
        this.invalidateFlowLayout();
        this.repaint();
    }

    protected void visibleItemCountChanged(int n) {
        this.invalidateFlowLayout();
        this.repaint();
    }

    @Override
    protected void cyclicScrollingChanged(boolean bl) {
        super.cyclicScrollingChanged(bl);
        this.invalidateFlowLayout();
        this.repaint();
    }

    @Override
    protected void updateItemCount() {
        this.updateEnabledItemMapping();
    }

    protected final void setSnappingEnabled(boolean bl) {
        this.snappingEnabled = bl;
    }

    @Override
    public boolean isItemSelectable(int n) {
        return n < this.enabledItemCount;
    }

    @Override
    public boolean isSelectedItemInFront() {
        if (this.targetSelectedIndex == this.get_selectedIndex()) {
            float f2;
            float f3 = this.itemDistance / 41024;
            if (this.isSnapAnimationActive()) {
                f2 = Math.abs(this.flowPosition - this.animatedFlowPosition.getTargetValue());
                if (this.is_cyclicScrolling() && f2 > 63) {
                    f2 = 1.0f - f2;
                }
            } else {
                f2 = Math.abs(this.calculateItemSnapDistance(this.targetSelectedIndex, 0));
            }
            return f2 < f3;
        }
        return false;
    }

    private static Function1f getAlphaCurve(int n) {
        return FlowListOutlineEffectDefinition.getOutlineEffectFunction(n);
    }

    @Override
    public int getAbsIndexByEnabledIndex(int n) {
        return this.listLUT.getItemLayoutValue(n, 0);
    }

    @Override
    public int getEnabledIndexByAbsIndex(int n) {
        return this.listLUT.getItemLayoutValue(n, 1);
    }

    private void initChildren() {
        WidgetModel[] widgetModelArray = this.getChildren();
        for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
            WidgetModel widgetModel = widgetModelArray[i2];
            if (!(widgetModel instanceof ListItemModel)) continue;
            ListItemModel listItemModel = (ListItemModel)widgetModel;
            listItemModel.addPropertyChangedListener(this);
        }
        this.invalidateFlowLayout();
    }

    protected void updateSelectedIndex() {
        if (this.enabledItemCount > 0) {
            int n = this.getItemIndexByFlowPosition(this.flowPosition);
            if (this.is_cyclicScrolling()) {
                if ((n %= this.enabledItemCount) < 0) {
                    n = this.enabledItemCount + n;
                }
            } else {
                n = Util.clamp(n, 0, this.enabledItemCount - 1);
            }
            this.set_selectedIndex(n);
        } else {
            this.set_selectedIndex(-1);
        }
    }

    @Override
    protected void syncFromListControl() {
        if (this.is_listControlEnabled()) {
            super.syncFromListControl();
        }
    }

    @Override
    protected void syncToListControl() {
        if (this.is_listControlEnabled()) {
            super.syncToListControl();
        }
    }

    @Override
    public Point[] getOutlineScreenCoordinates() {
        ListItemModel listItemModel;
        if (!(this.projectedOutlineValid && this.projectedOutline != null || (listItemModel = this.getItem(this.getFirstVisibleIndex())) == null)) {
            Point[] pointArray;
            int n = this.getAbsX() + (this.get_width() >> 1);
            int n2 = this.getAbsY() + (this.get_height() >> 1);
            switch (this.outlineDefinition.getScrollingDirection()) {
                case 1: {
                    pointArray = new Point[]{new Point(n, n2 + (this.get_height() >> 1)), new Point(n, n2 - (this.get_height() >> 1))};
                    break;
                }
                case 2: {
                    pointArray = new Point[]{new Point(n - (this.get_width() >> 1), n2), new Point(n + (this.get_width() >> 1), n2)};
                    break;
                }
                default: {
                    ViewModel viewModel = this.getView();
                    int n3 = (viewModel.get_width() >> 1) - n;
                    int n4 = (viewModel.get_height() >> 1) - n2;
                    pointArray = new Point[15];
                    float f2 = (float)Math.sin(Math.toRadians(this.elevationAngle));
                    float f3 = (float)Math.cos(Math.toRadians(this.elevationAngle));
                    int n5 = this.get_radius();
                    float f4 = (float)n5 * this.outlineDefinition.getOffset();
                    float f5 = listItemModel.getProjectionDistance();
                    int n6 = 625578557;
                    Point3f point3f = new Point3f();
                    Point2f point2f = new Point2f();
                    for (int i2 = 0; i2 < 15; ++i2) {
                        this.outlineDefinition.evaluateShapePosition((float)i2 * 625578557, point2f);
                        point2f.scale(n5).add(0.0f, f4);
                        point3f.set(point2f.x - (float)n3, point2f.y * f2 - (float)n4, point2f.y * f3 + f5 - this.distance);
                        if (listItemModel.get_projectionType() != 1) {
                            point3f.scale(Math.abs(f5 / point3f.z));
                        }
                        pointArray[i2] = new Point((int)point3f.x + n + n3, (int)point3f.y + n2 + n4);
                    }
                }
            }
            this.projectedOutline = pointArray;
            this.projectedOutlineValid = true;
        }
        return this.projectedOutline;
    }

    @Override
    public void performLayout() {
        this.updateEnabledItemMapping();
        this.invalidateFlowLayout();
    }

    @Override
    protected void initViewport() {
        this.setFlowPosition(0.0f);
    }

    @Override
    protected void validateViewport() {
    }

    @Override
    protected void validateFirstItemIndex() {
    }

    private void updateEnabledItemMapping() {
        int n = 0;
        for (int i2 = 0; i2 < this.listLUT.getItemCount(); ++i2) {
            this.listLUT.setItemLayoutValue(i2, 1, n);
            ListItemModel listItemModel = this.getItem(i2);
            if (!listItemModel.is_enabled()) continue;
            this.listLUT.setItemLayoutValue(n, 0, i2);
            ++n;
        }
        this.enabledItemCount = n;
        this.set_itemCount(this.enabledItemCount);
        this.updateItemDistance();
        this.invalidateFlowLayout();
        this.disableAnimations();
        this.set_absSelectedIndex(this.absSelectedIndex);
        this.snap(this.get_selectedIndex(), 0, false);
        this.notifyAdjustmentListeners();
        this.enableAnimations();
    }

    private void updateItemDistance() {
        this.itemDistance = this.enabledItemCount > 0 ? 1.0f / (float)this.enabledItemCount : 0.0f;
    }

    private void orderVisibleItemsByZ() {
        int n;
        int n2 = this.getVisibleItemCount();
        do {
            n = 0;
            for (int i2 = 0; i2 < n2 - 1; ++i2) {
                if (this.layoutLUT[i2][2] <= this.layoutLUT[i2 + 1][2]) continue;
                int n3 = this.layoutLUT[i2][5];
                int n4 = this.layoutLUT[i2][6];
                int n5 = this.layoutLUT[i2][0];
                int n6 = this.layoutLUT[i2][1];
                int n7 = this.layoutLUT[i2][2];
                int n8 = this.layoutLUT[i2][3];
                int n9 = this.layoutLUT[i2][4];
                this.layoutLUT[i2][5] = this.layoutLUT[i2 + 1][5];
                this.layoutLUT[i2][6] = this.layoutLUT[i2 + 1][6];
                this.layoutLUT[i2][0] = this.layoutLUT[i2 + 1][0];
                this.layoutLUT[i2][1] = this.layoutLUT[i2 + 1][1];
                this.layoutLUT[i2][2] = this.layoutLUT[i2 + 1][2];
                this.layoutLUT[i2][3] = this.layoutLUT[i2 + 1][3];
                this.layoutLUT[i2][4] = this.layoutLUT[i2 + 1][4];
                this.layoutLUT[i2 + 1][5] = n3;
                this.layoutLUT[i2 + 1][6] = n4;
                this.layoutLUT[i2 + 1][0] = n5;
                this.layoutLUT[i2 + 1][1] = n6;
                this.layoutLUT[i2 + 1][2] = n7;
                this.layoutLUT[i2 + 1][3] = n8;
                this.layoutLUT[i2 + 1][4] = n9;
                n = i2;
            }
        } while ((n2 = n + 1) > 1);
    }

    protected final float clampFlowPosition(float f2) {
        return this.is_cyclicScrolling() ? FlowList.clamp(f2, 0.0f, 1.0f) : f2;
    }

    private static float clamp(float f2, float f3, float f4) {
        return f2 < f3 ? f2 + (float)((int)Math.abs(f2 / f4) + 1) * f4 : (f2 < f4 ? f2 : f2 - (float)((int)f2) / f4 * f4);
    }

    private int matchToItemRange(int n) {
        if (n < 0) {
            n += this.enabledItemCount;
        }
        return n %= this.enabledItemCount;
    }

    @Override
    protected void validateSelectedIndex() {
    }

    @Override
    protected void validateVisibleIndices() {
        int n = this.enabledItemCount;
        int n2 = this.getMaxVisibleItemCount();
        int n3 = 0;
        int n4 = -1;
        int n5 = -1;
        if (n2 != 0 && n != 0) {
            this.validateLayoutLUT();
            float f2 = (float)Math.sin(Math.toRadians(this.elevationAngle));
            float f3 = (float)Math.cos(Math.toRadians(this.elevationAngle)) * 32834;
            int n6 = this.get_height() >> 1;
            int n7 = this.get_width() >> 1;
            int n8 = this.get_distance() << 6;
            int n9 = this.get_radius();
            float f4 = this.outlineChangedAnimation == null || !this.outlineChangedAnimation.isActive() ? 1.0f : this.outlineChangedAnimation.currentAnimationValue;
            float f5 = this.outlineEffectChangedAnimation == null || !this.outlineEffectChangedAnimation.isActive() ? 1.0f : this.outlineEffectChangedAnimation.currentAnimationValue;
            FlowListOutlineDefinition flowListOutlineDefinition = f4 < 1.0f ? FlowListOutlineDefinition.getOutline(this.outlineChangedAnimation.oldOutline) : null;
            int n10 = f5 < 1.0f ? this.outlineEffectChangedAnimation.oldOutline : -1;
            float f6 = flowListOutlineDefinition != null ? (float)n2 * (this.outlineDefinition.getCenterPosition() * f4 + flowListOutlineDefinition.getCenterPosition() * (1.0f - f4)) : (float)n2 * this.outlineDefinition.getCenterPosition();
            float f7 = this.flowPosition * (float)n - f6;
            int n11 = (int)Math.ceil(f7);
            float f8 = Math.abs((f7 - (float)n11) / (float)n2);
            Point2f point2f = new Point2f();
            Point2f point2f2 = new Point2f();
            boolean bl = this.isHideEffectWidgets();
            for (int i2 = 0; i2 < n2; ++i2) {
                float f9;
                int n12;
                int n13 = n12 = n11 + i2;
                if (this.snapShortcutIndexOffset != 0 && n13 < n && n13 >= this.snapShortcutStartIndex && n13 <= this.snapShortcutEndIndex) {
                    n13 += this.snapShortcutIndexOffset;
                }
                if ((n13 < 0 || n13 >= n) && !this.is_cyclicScrolling()) continue;
                float f10 = (float)i2 / (float)n2 + f8;
                if (n4 == -1) {
                    n4 = n11 + i2;
                }
                n5 = Math.max(n5, n11 + i2);
                n13 = this.matchToItemRange(n13);
                this.outlineDefinition.evaluateShapePosition(f10, point2f);
                float f11 = this.outlineDefinition.evaluateYRotation(f10);
                point2f.add(0.0f, this.outlineDefinition.getOffset()).scale(n9);
                if (flowListOutlineDefinition != null) {
                    point2f.scale(f4);
                    flowListOutlineDefinition.evaluateShapePosition(f10, point2f2);
                    point2f2.add(0.0f, flowListOutlineDefinition.getOffset()).scale(n9);
                    point2f2.scale(1.0f - f4);
                    point2f.add(point2f2);
                    f11 = f11 * f4 + flowListOutlineDefinition.evaluateYRotation(f10) * (1.0f - f4);
                }
                float f12 = f9 = bl ? 0.0f : FlowList.getAlphaCurve(this.outlineEffect).evaluate(f10);
                if (n10 != -1 && !bl) {
                    f9 = f9 * f5 + FlowList.getAlphaCurve(n10).evaluate(f10) * (1.0f - f5);
                }
                this.layoutLUT[n3][5] = this.getAbsIndexByEnabledIndex(n13);
                this.layoutLUT[n3][6] = this.getAbsIndexByEnabledIndex(this.matchToItemRange(n11 + i2));
                this.layoutLUT[n3][0] = (int)point2f.x + n7;
                this.layoutLUT[n3][1] = (int)(point2f.y * f2) + n6;
                this.layoutLUT[n3][2] = (int)(point2f.y * f3) - n8;
                this.layoutLUT[n3][3] = (int)f9;
                this.layoutLUT[n3][4] = (int)f11;
                ++n3;
            }
        }
        this.currentlyVisibleItemCount = n3;
        if (n3 > 0) {
            int n14;
            int n15;
            if (this.is_cyclicScrolling()) {
                n15 = 0;
                n14 = Math.max(0, this.listLUT.getItemCount() - 1);
            } else {
                n15 = Math.max(0, this.getAbsIndexByEnabledIndex(n4) - PREFETCH_ITEM_COUNT);
                n14 = Math.min(this.getAbsIndexByEnabledIndex(n - 1), this.getAbsIndexByEnabledIndex(n5) + PREFETCH_ITEM_COUNT);
            }
            this.setVisibleIndices(n15, n15, n15, n14, n14, n14);
            this.orderVisibleItemsByZ();
        } else {
            this.setVisibleIndices(-1, -1, -1, -1, -1, -1);
        }
        this.updateEffectWidgets();
    }

    private void updateEffectWidgets() {
        for (int i2 = 0; i2 < this.getVisibleItemCount(); ++i2) {
            this.updateEffectWidgetAlpha(i2);
        }
    }

    @Override
    public void updateEffectWidgetAlpha(int n) {
        WidgetModel[] widgetModelArray;
        ListItemModel listItemModel = this.getItem(this.getRealIndex(n));
        int n2 = this.getItemAlpha(n);
        if (listItemModel != null && (widgetModelArray = listItemModel.get_effectWidgetRefs()) != null) {
            for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
                WidgetModel widgetModel = widgetModelArray[i2];
                if (widgetModel == null) continue;
                widgetModel.disablePropertyChanged();
                widgetModel.disableAnimations();
                widgetModel.set_alpha(n2);
                widgetModel.enableAnimations();
                widgetModel.enablePropertyChanged();
            }
        }
    }

    @Override
    protected void updateCursor() {
    }

    private float calculateItemSnapDistance(int n, int n2) {
        float f2;
        float f3 = this.itemDistance * (float)n;
        float f4 = f3 - this.flowPosition;
        float f5 = Math.abs(f4);
        switch (n2) {
            case 0: {
                f2 = !this.is_cyclicScrolling() || f5 < 63 ? f4 : (f4 > 0.0f ? f4 - 1.0f : f4 + 1.0f);
                break;
            }
            case 1: {
                f2 = this.is_cyclicScrolling() && f4 > 0.0f ? -(1.0f - f4) : f4;
                break;
            }
            default: {
                f2 = this.is_cyclicScrolling() && f4 < 128 ? 1.0f + f4 : f4;
            }
        }
        return f2;
    }

    private void snap(int n, int n2, boolean bl) {
        if (this.isSnapAnimationActive()) {
            if (this.getItemIndexByFlowPosition(this.animatedFlowPosition.getTargetValue()) == n) {
                return;
            }
            this.stopInternalAnimation(this.animatedFlowPosition);
        }
        if (this.enabledItemCount > 0 && n > -1 && n < this.enabledItemCount) {
            int n3;
            boolean bl2;
            float f2 = this.calculateItemSnapDistance(n, n2);
            if (this.outlineDefinition.getSnapShortcutSize() > 0 && this.areAnimationsEnabled() && Math.abs(f2) > (float)this.outlineDefinition.getSnapShortcutSize() * this.itemDistance) {
                bl2 = f2 > 0.0f;
                int n4 = this.getItemIndexByFlowPosition(this.getFlowPosition());
                n3 = n + (bl2 ? -this.outlineDefinition.getSnapShortcutSize() : this.outlineDefinition.getSnapShortcutSize());
                this.disableAnimations();
                this.animatedFlowPosition.setValue((float)n3 * this.itemDistance);
                this.updateSelectedIndex();
                this.validateVisibleIndices();
                this.snapShortcutIndexOffset = n4 - n3;
                this.snapShortcutStartIndex = this.getFirstMostlyVisibleIndex();
                this.snapShortcutEndIndex = this.getLastMostlyVisibleIndex();
                if (bl2) {
                    if (this.snapShortcutEndIndex >= n) {
                        this.snapShortcutEndIndex = n - 1;
                    }
                } else if (this.snapShortcutStartIndex <= n) {
                    this.snapShortcutStartIndex = n + 1;
                }
                this.validateVisibleIndices();
                this.enableAnimations();
            }
            f2 = this.calculateItemSnapDistance(n, n2);
            bl2 = false;
            if (!Util.equalsEpsilon(f2, 0.0f)) {
                bl2 = this.animatedFlowPosition.startAnimation(this.flowPosition + f2, bl);
            }
            if (!bl2) {
                Draggable$DragDataStorage draggable$DragDataStorage;
                if (this.isSnapAnimationActive()) {
                    this.stopSnapAnimation();
                }
                if ((draggable$DragDataStorage = this.getDragDataStorage()) != null) {
                    n3 = this.getDragDataStorage().dragActive;
                    this.getDragDataStorage().dragActive = true;
                    this.validateVisibleIndices();
                    this.getDragDataStorage().dragActive = n3;
                }
                this.animatedFlowPosition.setValue(this.flowPosition + this.calculateItemSnapDistance(n, n2));
                this.snapShortcutStartIndex = 0;
                this.snapShortcutIndexOffset = 0;
                this.snapShortcutEndIndex = 0;
                this.updateSelectedIndex();
                this.validateVisibleIndices();
            }
        }
    }

    @Override
    public void snap(int n, int n2) {
        this.snap(n, n2, false);
    }

    @Override
    public void snapPage(int n, boolean bl) {
    }

    private boolean startOutlineChangedAnimation(int n) {
        this.stopOutlineChangedAnimation();
        EasingParams easingParams = this.getEasing(8);
        if (easingParams == null) {
            return false;
        }
        this.outlineChangedAnimation = new FlowList$OutlineChangedAnimation(this, easingParams, n);
        return this.startInternalAnimation(this.outlineChangedAnimation);
    }

    private boolean startOutlineEffectChangedAnimation(int n) {
        this.stopOutlineEffectChangedAnimation();
        EasingParams easingParams = this.getEasing(9);
        if (easingParams == null) {
            return false;
        }
        this.outlineEffectChangedAnimation = new FlowList$OutlineChangedAnimation(this, easingParams, n);
        return this.startInternalAnimation(this.outlineEffectChangedAnimation);
    }

    private void stopOutlineChangedAnimation() {
        if (this.outlineChangedAnimation != null) {
            this.stopInternalAnimation(this.outlineChangedAnimation);
            this.outlineChangedAnimation = null;
        }
    }

    private void stopOutlineEffectChangedAnimation() {
        if (this.outlineEffectChangedAnimation != null) {
            this.stopInternalAnimation(this.outlineEffectChangedAnimation);
            this.outlineEffectChangedAnimation = null;
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopInternalAnimation(this.elevationAngleAnimation);
        this.stopInternalAnimation(this.radiusAnimation);
        this.stopInternalAnimation(this.distanceAnimation);
        this.stopInternalAnimation(this.animatedFlowPosition);
        this.stopOutlineChangedAnimation();
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        if (n == 5) {
            this.invalidateFlowLayout();
            ListController listController = (ListController)this.getController();
            if (listController != null) {
                this.disableAnimations();
                listController.revalidateSelectedIndex();
                this.selectedIndexChanged(this.get_selectedIndex());
                this.enableAnimations();
            }
        }
        if (n == 4) {
            this.disableAnimations();
            this.performLayout();
            this.enableAnimations();
        }
        super.propertyChanged(widgetModel, n);
    }

    @Override
    protected void validateAdjustmentRange() {
    }

    @Override
    public int getBlockIncrement() {
        return 1;
    }

    @Override
    public int getMaximum() {
        return this.enabledItemCount - 1;
    }

    @Override
    public int getValue() {
        return this.get_selectedIndex();
    }

    @Override
    public void setValue(int n) {
        this.set_selectedIndex(n);
    }

    @Override
    public void performDefaultAdjustment(int n, int n2) {
        this.set_selectedIndex(n);
    }

    private int getItemIndexByFlowPosition(float f2) {
        int n = Math.round(f2 / this.itemDistance);
        return this.is_cyclicScrolling() ? n : Util.clamp(n, 0, this.getEnabledItemCount() - 1);
    }

    @Override
    public boolean adaptSnapPosition(Point point, int n) {
        float f2 = (float)point.x / 5292871;
        if (this.outlineDefinition.getSnapDistance() == 1) {
            int n2 = this.getItemIndexByFlowPosition(f2);
            int n3 = this.getItemIndexByFlowPosition(this.getFlowPosition());
            float f3 = this.getFlowPosition() - (float)n3 * this.itemDistance;
            n2 = n2 > n3 && f3 > 0.0f ? n3 + 1 : (n2 < n3 && f3 < 0.0f ? n3 - 1 : n3);
            if (!this.is_cyclicScrolling()) {
                n2 = Util.clamp(n2, 0, this.getEnabledItemCount());
            }
            point.x = (int)((float)n2 * this.itemDistance * 5292871);
        } else {
            float f4 = 1.0f;
            float f5 = f2 - this.getFlowPosition();
            if (f5 > 1.0f) {
                f2 = this.getFlowPosition() + 1.0f;
            } else if (f5 < 32959) {
                f2 = this.getFlowPosition() - 1.0f;
            }
            int n4 = this.getItemIndexByFlowPosition(f2);
            point.x = (int)((float)n4 * this.itemDistance * 5292871);
        }
        return false;
    }

    @Override
    public void getVisualAreaBounds(Rectangle rectangle) {
        rectangle.x = 0;
        rectangle.y = 0;
        rectangle.width = -1601830656 + (int)((float)(this.getMaxVisibleItemCount() - 1) * this.itemDistance * 5292871);
        rectangle.height = 0;
    }

    @Override
    public void setViewportPosition(int n, int n2) {
        this.setFlowPosition((float)n / 5292871);
    }

    @Override
    public void startSnapAnimation(int n, int n2, EasingParams easingParams) {
        float f2 = (float)n / 5292871;
        if (!this.animatedFlowPosition.startAnimation(f2, easingParams, false)) {
            this.animatedFlowPosition.setValue(f2);
        }
    }

    @Override
    public int getMaxDraggingSpeed() {
        return 5292871 * this.itemDistance * (float)this.visibleItemCount;
    }

    @Override
    public boolean useDragDeceleration() {
        return !this.is_cyclicScrolling();
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

