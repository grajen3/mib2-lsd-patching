/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractSlider;
import de.vw.mib.widgets.SliderCalculator;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.models.ScrollbarModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class Scrollbar
extends AbstractSlider
implements ScrollbarModel {
    private Image[] imagesScrollbar;
    private Color[] colorsScrollbar;
    private StaticImageModel imageScrollbarRef;
    private int startTime;
    private int repeatTime;
    private int minScrollbarSize;
    private int stepValues;
    private int visibilityMode;
    private Adjustable adjustableWidgetRef;
    private int pageSize;
    private int currentValue;
    private int activeStepValue;
    private CowList adjustmentListeners;
    private int valuePointCentreOfSbButtonInPixels;
    private int adjustmentShadowCounter;
    private Dimension originalImageScrollbarRefSize = new Dimension();
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ScrollbarUI;

    @Override
    protected void reset() {
        super.reset();
        this.imagesScrollbar = null;
        this.imageScrollbarRef = null;
        this.adjustableWidgetRef = null;
        this.adjustmentListeners = CowList.EMPTY;
        this.adjustmentShadowCounter = 0;
        this.pageSize = 0;
    }

    public void init(boolean bl, Adjustable adjustable, int n, Image image, boolean bl2, boolean bl3, Color[] colorArray, Color[] colorArray2, Color[] colorArray3, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, Color[] colorArray4, int n2, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, StaticImageModel staticImageModel3, Image[] imageArray2, Image[] imageArray3, boolean bl5, boolean bl6, KeyframeAnimation[] keyframeAnimationArray, boolean bl7, LayoutAttribs layoutAttribs, int n3, String string, int n4, int n5, int n6, int n7, int n8, Image image2, int n9, boolean bl8, int n10, boolean bl9, int n11, int n12, int n13, int n14, int n15, Insets insets, int n16, int n17, int n18, int n19, boolean bl10, int n20, boolean bl11, int n21, int n22) {
        super.init(bl, n, image, bl2, bl3, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, colorArray4, n2, staticImageModel, staticImageModel2, imageArray, imageArray2, bl5, keyframeAnimationArray, bl7, layoutAttribs, string, n4, n5, n6, n8, image2, n9, bl8, bl9, n12, n13, n15, insets, n16, n17, n18, bl10, n20, bl11, n21, n22);
        this.imagesScrollbar = imageArray3;
        this.colorsScrollbar = colorArray3;
        this.imageScrollbarRef = staticImageModel3;
        this.startTime = n11;
        this.repeatTime = n10;
        this.adjustableWidgetRef = adjustable;
        this.minScrollbarSize = n3;
        this.stepValues = n14;
        this.activeStepValue = 0;
        this.pageSize = n7;
        this.visibilityMode = n19;
        this.setInternalStateFlag(22, bl6);
    }

    public void init(boolean bl, Adjustable adjustable, int n, Image image, boolean bl2, boolean bl3, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, Color[] colorArray3, int n2, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, StaticImageModel staticImageModel3, Image[] imageArray2, Image[] imageArray3, boolean bl5, boolean bl6, KeyframeAnimation[] keyframeAnimationArray, boolean bl7, LayoutAttribs layoutAttribs, int n3, String string, int n4, int n5, int n6, int n7, int n8, Image image2, int n9, boolean bl8, int n10, boolean bl9, boolean bl10, int n11, int n12, int n13, int n14, int n15, Insets insets, int n16, int n17, int n18, int n19, boolean bl11, int n20, boolean bl12, int n21, int n22) {
        this.init(bl, adjustable, n, image, bl2, bl3, colorArray, colorArray2, null, easingParamsArray, easingParamsArray2, bl4, colorArray3, n2, staticImageModel, staticImageModel2, imageArray, staticImageModel3, imageArray2, imageArray3, bl5, bl6, keyframeAnimationArray, bl7, layoutAttribs, n3, string, n4, n5, n6, n7, n8, image2, n9, bl8, n10, bl9, n11, n12, n13, n14, n15, insets, n16, n17, n18, n19, bl11, n20, bl12, n21, n22);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.updateEnableState();
        this.saveScrollbarRefDimension();
        this.positionOnScrollbarButton = 0;
        this.adjustableWidgetRefChanged(null);
        this.setScalePosition(SliderCalculator.calculateScrollbarPositionByValue(this, this.get_value()));
        this.disableAnimations();
        this.updateScrollbarImageGeometry();
        this.enableAnimations();
    }

    @Override
    public void deInit() {
        this.adjustmentListeners = CowList.EMPTY;
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ScrollbarUI == null ? (class$de$vw$mib$widgets$ui$ScrollbarUI = Scrollbar.class$("de.vw.mib.widgets.ui.ScrollbarUI")) : class$de$vw$mib$widgets$ui$ScrollbarUI};
    }

    @Override
    public final Image[] get_imagesScrollbar() {
        return this.imagesScrollbar;
    }

    @Override
    public final void set_imagesScrollbar(Image[] imageArray) {
        Object[] objectArray = this.imagesScrollbar;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesScrollbar = imageArray;
            this.imagesScrollbarChanged((Image[])objectArray);
            this.propertyChanged(43);
        }
    }

    @Override
    public Color[] get_colorsScrollbar() {
        return this.colorsScrollbar;
    }

    @Override
    public void set_colorsScrollbar(Color[] colorArray) {
        Object[] objectArray = this.colorsScrollbar;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.colorsScrollbar = colorArray;
            this.colorsScrollbarChanged((Color[])objectArray);
            this.propertyChanged(44);
        }
    }

    @Override
    public final StaticImageModel get_imageScrollbarRef() {
        return this.imageScrollbarRef;
    }

    @Override
    public final void set_imageScrollbarRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.imageScrollbarRef;
        if (staticImageModel2 != staticImageModel) {
            this.imageScrollbarRef = staticImageModel;
            this.imageScrollbarRefChanged(staticImageModel2);
            this.propertyChanged(45);
        }
    }

    @Override
    public void set_visibilityMode(int n) {
        int n2 = this.visibilityMode;
        if (n2 != n) {
            this.visibilityMode = n;
            this.visibilityModeChanged(n2);
            this.propertyChanged(53);
        }
    }

    @Override
    public int get_visibilityMode() {
        return this.visibilityMode;
    }

    @Override
    public final Adjustable get_adjustableWidgetRef() {
        return this.adjustableWidgetRef;
    }

    @Override
    public final void set_adjustableWidgetRef(Adjustable adjustable) {
        Adjustable adjustable2 = this.adjustableWidgetRef;
        if (adjustable2 != adjustable) {
            this.adjustableWidgetRef = adjustable;
            this.adjustableWidgetRefChanged(adjustable2);
            this.propertyChanged(46);
        }
    }

    @Override
    public final int get_repeatTime() {
        return this.repeatTime;
    }

    @Override
    public final void set_repeatTime(int n) {
        int n2 = this.repeatTime;
        if (n2 != n) {
            this.repeatTime = n;
            this.repeatTimeChanged(n2);
            this.propertyChanged(49);
        }
    }

    @Override
    public final int get_startTime() {
        return this.startTime;
    }

    @Override
    public final void set_startTime(int n) {
        int n2 = this.startTime;
        if (n2 != n) {
            this.startTime = n;
            this.startTimeChanged(n2);
            this.propertyChanged(48);
        }
    }

    @Override
    public final boolean is_jump() {
        return this.getInternalStateFlag(22);
    }

    @Override
    public final void set_jump(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(22);
        if (bl2 != bl) {
            this.setInternalStateFlag(22, bl);
            this.jumpChanged(bl2);
            this.propertyChanged(47);
        }
    }

    @Override
    public final int get_minScrollbarSize() {
        return this.minScrollbarSize;
    }

    @Override
    public final void set_minScrollbarSize(int n) {
        int n2 = this.minScrollbarSize;
        if (n2 != n) {
            this.minScrollbarSize = n;
            this.minScrollbarSizeChanged(n2);
            this.propertyChanged(50);
        }
    }

    @Override
    public final int get_stepValues() {
        return this.stepValues;
    }

    @Override
    public final void set_stepValues(int n) {
        int n2 = this.stepValues;
        if (n2 != n) {
            this.stepValues = n;
            this.stepValuesChanged(n2);
            this.propertyChanged(51);
        }
    }

    public final void setActiveStepValue(int n) {
        this.activeStepValue = n;
        if (this.stepValues < 2) {
            this.setScalePosition(this.valuePointCentreOfSbButtonInPixels);
            this.updateScrollbarImageGeometry();
        } else if (null != this.get_imageScrollbarRef()) {
            int n2;
            int n3;
            if (this.get_orientation() == 2 || this.get_orientation() == 3) {
                n3 = this.get_imageScrollbarRef().get_height();
                n2 = this.get_height();
            } else {
                n3 = this.get_imageScrollbarRef().get_width();
                n2 = this.get_width();
            }
            int n4 = (n2 - n3) / (this.stepValues - 1);
            int n5 = this.activeStepValue * n4 + this.valuePointCentreOfSbButtonInPixels;
            this.setScalePosition(n5);
            this.trace(new StringBuffer().append(".setActiveStepValue();; activeStepValue: ").append(this.activeStepValue).append(", stepWidth: ").append(n4).append(", scalePosition: ").append(n5).toString());
            this.updateScrollbarImageGeometry();
        }
    }

    @Override
    public void setCurrentValue(int n) {
        this.currentValue = n;
    }

    @Override
    public int getCurrentValue() {
        return this.currentValue;
    }

    @Override
    public int getPageSize() {
        return this.pageSize;
    }

    @Override
    public void setPageSize(int n) {
        if (n > 1) {
            if (this.pageSize != n) {
                this.pageSize = n;
                this.updateScrollbarImage();
            }
        } else {
            this.pageSize = 1;
        }
    }

    @Override
    public final int get_pageSize() {
        return this.getPageSize();
    }

    @Override
    public final void set_pageSize(int n) {
        int n2 = this.pageSize;
        if (n > 1) {
            if (n2 != n) {
                this.pageSize = n;
                this.pageSizeChanged(n2);
                this.propertyChanged(52);
            }
        } else if (n2 != 1) {
            this.pageSize = 1;
            this.pageSizeChanged(n2);
            this.propertyChanged(52);
        }
        this.calculateButtonSize();
    }

    @Override
    public void setPositionOnScrollbarButton(int n, int n2) {
        StaticImageModel staticImageModel = this.get_imageScrollbarRef();
        this.positionOnScrollbarButton = 0;
        if (staticImageModel != null) {
            this.positionOnScrollbarButton = SliderCalculator.getPositionOnScrollbarButton(this, n, n2, staticImageModel);
        }
    }

    @Override
    public int getValuePoint() {
        return this.valuePointCentreOfSbButtonInPixels;
    }

    @Override
    protected int getValueChangeTimer() {
        return 0;
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.calculateButtonSize();
        this.updateVisualScrollbarPosition();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.calculateButtonSize();
        this.updateVisualScrollbarPosition();
    }

    protected void imagesScrollbarChanged(Image[] imageArray) {
        this.updateScrollbarImage();
    }

    protected void colorsScrollbarChanged(Color[] colorArray) {
        this.updateScrollbarImage();
    }

    protected void imageScrollbarRefChanged(StaticImageModel staticImageModel) {
        if (staticImageModel != null) {
            staticImageModel.set_width(this.originalImageScrollbarRefSize.width);
            staticImageModel.set_height(this.originalImageScrollbarRefSize.height);
        }
        this.saveScrollbarRefDimension();
    }

    private void restoreScrollbarRefDimension() {
        if (this.imageScrollbarRef != null) {
            this.imageScrollbarRef.set_width(this.originalImageScrollbarRefSize.width);
            this.imageScrollbarRef.set_height(this.originalImageScrollbarRefSize.height);
        }
    }

    private void saveScrollbarRefDimension() {
        if (this.imageScrollbarRef != null) {
            this.originalImageScrollbarRefSize.width = this.imageScrollbarRef.get_width();
            this.originalImageScrollbarRefSize.height = this.imageScrollbarRef.get_height();
        }
    }

    protected void visibilityModeChanged(int n) {
        this.updateVisibility();
        this.updateScrollbarImage();
    }

    @Override
    protected void valueChanged(int n) {
        this.updateVisualScrollbarPosition();
    }

    private void updateVisualScrollbarPosition() {
        int n = this.get_valueMin();
        int n2 = this.get_valueMax();
        int n3 = Util.clamp(this.get_value(), n, n2);
        if (this.stepValues > 0) {
            int n4 = 0;
            if (n2 > 0) {
                n4 = n3 * this.stepValues / n2;
            }
            this.setActiveStepValue(n4);
        } else {
            int n5 = SliderCalculator.calculateScrollbarPositionByValue(this, n3);
            this.setScalePosition(n5);
            if (this.getCurrentValue() != n3) {
                this.setCurrentValue(n3);
            }
            if (!this.isPressed()) {
                this.updateScrollbarImageGeometry();
            }
        }
        if (this.adjustableWidgetRef != null) {
            this.notifyAdjustmentListener();
        }
        this.repaint();
    }

    @Override
    protected void valueMinChanged(int n) {
        this.updateScrollbarImage();
        this.calculateButtonSize();
        this.updateVisualScrollbarPosition();
        if (this.adjustableWidgetRef == null) {
            this.updateVisibility();
        }
    }

    @Override
    protected void valueMaxChanged(int n) {
        this.updateEnableState();
        this.updateScrollbarImage();
        this.calculateButtonSize();
        this.updateVisualScrollbarPosition();
        if (this.adjustableWidgetRef == null) {
            this.updateVisibility();
        }
    }

    private void adjustableWidgetRefChanged(Object object) {
        if (object != null) {
            if (object instanceof Adjustable) {
                ((Adjustable)object).removeAdjustmentListener(this);
            }
            if (object instanceof AdjustmentListener) {
                this.removeAdjustmentListener((AdjustmentListener)object);
            }
        }
        if (this.adjustableWidgetRef != null) {
            this.adjustableWidgetRef.addAdjustmentListener(this);
            if (this.adjustableWidgetRef instanceof AdjustmentListener) {
                this.addAdjustmentListener((AdjustmentListener)((Object)this.adjustableWidgetRef));
            }
        }
    }

    protected void startTimeChanged(int n) {
    }

    protected void repeatTimeChanged(int n) {
    }

    protected void jumpChanged(boolean bl) {
    }

    protected void minScrollbarSizeChanged(int n) {
        this.updateScrollbarImage();
    }

    protected void stepValuesChanged(int n) {
        if (this.stepValues != 0) {
            this.restoreScrollbarRefDimension();
        }
        this.calculateButtonSize();
        this.updateScrollbarImage();
        this.updateVisualScrollbarPosition();
        this.repaint();
    }

    protected void pageSizeChanged(int n) {
        this.setScrollbarBounds();
        this.updateScrollbarImage();
        if (this.stepValues == 0) {
            this.calculateButtonSize();
            this.updateVisualScrollbarPosition();
            if (this.adjustableWidgetRef == null) {
                this.updateVisibility();
            }
        }
    }

    @Override
    public boolean canConsumeHMIEvents() {
        switch (this.visibilityMode) {
            case 0: {
                return super.canConsumeHMIEvents();
            }
            case 1: {
                return true;
            }
            case 2: {
                return super.canConsumeHMIEvents();
            }
            case 3: {
                return true;
            }
        }
        return super.canConsumeHMIEvents();
    }

    private void updateEnableState() {
        boolean bl = this.get_valueMax() > this.get_valueMin();
        this.set_enabled(bl);
    }

    private void updateScrollbarImage() {
        StaticImageModel staticImageModel = this.get_imageScrollbarRef();
        if (staticImageModel != null) {
            Image[] imageArray = this.get_imagesScrollbar();
            int n = this.inferIndexFromState();
            if (imageArray != null && imageArray.length > n) {
                Image image = imageArray[n];
                staticImageModel.set_image(image);
            } else {
                staticImageModel.set_image(null);
            }
            if (this.colorsScrollbar != null && this.colorsScrollbar.length > n) {
                staticImageModel.set_color(this.colorsScrollbar[n]);
            } else {
                staticImageModel.set_color(Color.WHITE);
            }
        }
    }

    @Override
    protected void updateImages() {
        super.updateImages();
        this.updateScrollbarImage();
    }

    @Override
    public void updateStepValuePosition(int n, int n2) {
        if (this.stepValues > 1) {
            int n3 = SliderCalculator.getRelativePositionByOrientation(this, n, n2, true);
            int n4 = this.get_orientation() > 1 ? n3 * this.stepValues / this.get_height() : n3 * this.stepValues / this.get_width();
            this.setActiveStepValue(n4);
            this.trace(new StringBuffer().append(".updateStepValuePosition();; x: ").append(n).append(", y: ").append(n2).append(", scalePosition: ").append(n3).append(", segmentNumber: ").append(n4).toString());
            this.set_value(this.get_valueMin() + n4 * (this.get_valueMax() - this.get_valueMin()) / (this.stepValues - 1));
        }
    }

    @Override
    public int updatePosition(int n, int n2, boolean bl) {
        int n3 = 0;
        boolean bl2 = false;
        int n4 = SliderCalculator.getRelativePositionByOrientation(this, n, n2, true);
        int n5 = this.getScalePosition();
        if (this.positionOnScrollbarButton >= 0) {
            n5 = n4 - this.positionOnScrollbarButton + this.valuePointCentreOfSbButtonInPixels;
            bl2 = true;
        } else {
            n5 = n4;
            if (n4 < this.valuePointCentreOfSbButtonInPixels) {
                n5 = this.valuePointCentreOfSbButtonInPixels;
            }
            if ((this.get_orientation() == 2 || this.get_orientation() == 3) && n4 > this.get_height() - this.valuePointCentreOfSbButtonInPixels) {
                n5 = this.get_height() - this.valuePointCentreOfSbButtonInPixels;
            }
            if ((this.get_orientation() == 0 || this.get_orientation() == 1) && n4 > this.get_width() - this.valuePointCentreOfSbButtonInPixels) {
                n5 = this.get_width() - this.valuePointCentreOfSbButtonInPixels;
            }
            bl2 = true;
        }
        if (bl2) {
            if (n5 != this.getScalePosition()) {
                this.setScalePosition(n5);
                this.updateScrollbarImageGeometry();
                n3 = SliderCalculator.calculateScrollValueByTouchPoint(this, n5);
                if (this.getCurrentValue() != n3) {
                    this.setCurrentValue(n3);
                    if (!bl) {
                        this.set_value(n3);
                    }
                }
            } else {
                n3 = this.get_value();
            }
        } else {
            n3 = this.get_value();
        }
        return n3;
    }

    protected void updateScrollbarImageGeometry() {
        this.setScrollbarBounds();
        this.updateScrollbarImage();
        this.repaint();
    }

    private void updateVisibility() {
        boolean bl = true;
        boolean bl2 = true;
        switch (this.visibilityMode) {
            case 0: {
                bl = false;
                bl2 = false;
                break;
            }
            case 1: {
                bl = true;
                bl2 = true;
                break;
            }
            case 2: {
                bl = this.get_valueMax() > this.get_valueMin();
                bl2 = this.get_valueMax() > this.get_valueMin();
                break;
            }
            case 3: {
                bl = this.get_valueMax() > this.get_valueMin();
                bl2 = true;
                break;
            }
        }
        this.set_visible(bl2);
        StaticImageModel staticImageModel = this.get_imageScrollbarRef();
        if (staticImageModel != null) {
            staticImageModel.set_visible(bl);
        }
    }

    @Override
    public boolean isScrollbarIndicatorVisibile() {
        StaticImageModel staticImageModel = this.get_imageScrollbarRef();
        if (staticImageModel != null) {
            return staticImageModel.is_visible();
        }
        return false;
    }

    private void setScrollbarBounds() {
        StaticImageModel staticImageModel = this.get_imageScrollbarRef();
        if (staticImageModel != null) {
            int n = this.getScalePosition();
            if (this.get_orientation() == 0 || this.get_orientation() == 1) {
                int n2 = 0;
                n2 = n - this.valuePointCentreOfSbButtonInPixels;
                if (n2 < 0) {
                    n2 = 0;
                } else if (n2 > this.get_width() - staticImageModel.get_width()) {
                    n2 = this.get_width() - staticImageModel.get_width();
                }
                staticImageModel.set_x(n2);
            } else {
                int n3 = n - this.valuePointCentreOfSbButtonInPixels;
                if (n3 < 0) {
                    n3 = 0;
                } else if (n3 > this.get_height() - staticImageModel.get_height()) {
                    n3 = this.get_height() - staticImageModel.get_height();
                }
                staticImageModel.set_y(n3);
            }
        }
    }

    private void calculateButtonSize() {
        StaticImageModel staticImageModel = this.get_imageScrollbarRef();
        if (staticImageModel != null && this.stepValues == 0) {
            if (0 == this.get_orientation() || 1 == this.get_orientation()) {
                int n;
                float f2;
                float f3 = this.get_width();
                int n2 = Math.round(f3 * (f2 = (float)this.getPageSize()) / (float)(n = this.get_valueMax() + this.getPageSize()));
                if (n2 < this.minScrollbarSize) {
                    n2 = this.minScrollbarSize;
                }
                this.calculateScaleRatio(n2);
                staticImageModel.set_width(n2);
                this.valuePointCentreOfSbButtonInPixels = n2 >> 1;
            } else {
                int n;
                float f4;
                float f5 = this.get_height();
                int n3 = Math.round(f5 * (f4 = (float)this.getPageSize()) / (float)(n = this.get_valueMax() + this.getPageSize()));
                if (n3 < this.minScrollbarSize) {
                    n3 = this.minScrollbarSize;
                }
                this.calculateScaleRatio(n3);
                staticImageModel.set_height(n3);
                this.valuePointCentreOfSbButtonInPixels = n3 >> 1;
            }
        }
    }

    @Override
    public void addAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.addIfAbsent(adjustmentListener);
    }

    @Override
    public void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.remove(adjustmentListener);
    }

    private void notifyAdjustmentListener() {
        this.notifyAdjustmentListener(0);
    }

    @Override
    public void notifyAdjustmentListener(int n) {
        if (this.isAdjustmentEnabled()) {
            for (CowList cowList = this.adjustmentListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
                AdjustmentListener adjustmentListener = (AdjustmentListener)cowList.head();
                adjustmentListener.adjustmentValueChanged(this, n);
            }
        }
    }

    @Override
    public void scrollToNextPage() {
        this.notifyAdjustmentListener(3);
    }

    @Override
    public void scrollToPrevPage() {
        this.notifyAdjustmentListener(4);
    }

    @Override
    public int getMinimum() {
        return this.get_valueMin();
    }

    @Override
    public void setMinimum(int n) {
        this.set_valueMin(n);
    }

    @Override
    public int getMaximum() {
        return this.get_valueMax();
    }

    @Override
    public void setMaximum(int n) {
        this.set_valueMax(n);
    }

    @Override
    public int getBlockIncrement() {
        return this.getPageSize();
    }

    @Override
    public void setBlockIncrement(int n) {
        this.setPageSize(n);
    }

    @Override
    public int getValue() {
        return this.get_value();
    }

    @Override
    public void setValue(int n) {
        this.positionOnScrollbarButton = 0;
        this.set_value(n);
    }

    @Override
    public int getUnitIncrement() {
        return this.get_step();
    }

    @Override
    public void setUnitIncrement(int n) {
        this.set_step(n);
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

    @Override
    public void adjustmentValueChanged(Adjustable adjustable, int n) {
        if (!this.isPressed()) {
            this.disableAdjustmentChanged();
            this.setMinimum(adjustable.getMinimum());
            this.setMaximum(adjustable.getMaximum());
            this.setBlockIncrement(adjustable.getBlockIncrement());
            this.setUnitIncrement(adjustable.getUnitIncrement());
            this.setValue(adjustable.getValue());
            this.updateVisibility();
            this.trace(new StringBuffer().append(".adjustmentValueChanged();; minimum: ").append(this.getMinimum()).append(", maximum: ").append(this.getMaximum()).append(", blockInc: ").append(this.getBlockIncrement()).append(", unitInc: ").append(this.getUnitIncrement()).append(", value: ").append(this.get_value()).toString());
            this.enableAdjustmentChanged();
        }
        if (this.stepValues == 0) {
            this.calculateButtonSize();
        }
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

