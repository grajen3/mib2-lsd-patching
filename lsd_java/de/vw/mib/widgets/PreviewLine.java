/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractBackgroundContainer;
import de.vw.mib.widgets.Container;
import de.vw.mib.widgets.PreviewLine$ContentEvaluator;
import de.vw.mib.widgets.PreviewLine$ContentUpdateHandler;
import de.vw.mib.widgets.PreviewLine$InputFieldUpdateHandler;
import de.vw.mib.widgets.PreviewLine$ListSizeChangedNotifier;
import de.vw.mib.widgets.PreviewLine$ResizeBackgroundAnimation;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.InputFieldModel;
import de.vw.mib.widgets.models.PreviewLineModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.PreviewLineChangedListener;
import java.io.IOException;
import java.util.Arrays;

public class PreviewLine
extends AbstractBackgroundContainer
implements PreviewLineModel {
    private static final int[] CONTENT_BACKGROUND_MODES_DEFAULT = new int[]{1, 3, 1};
    private WidgetModel[] contentRefs;
    private int[] contentBackgroundModes;
    private InputFieldModel inputFieldRef;
    private InactiveAreaModel inactiveAreaRef;
    private int activeContent;
    private int arrowImageWidth;
    protected Rectangle cursorArea = new Rectangle();
    protected TemplateListModel historyList;
    protected TemplateListModel previewList;
    protected TemplateListModel resultList;
    private PreviewLine$ListSizeChangedNotifier listSizeChangedNotifier;
    private PreviewLine$ContentEvaluator previewLineContentEvaluator;
    private PreviewLineChangedListener previewLineChangedListener;
    private PreviewLine$ContentUpdateHandler contentUpdateHandler;
    private PreviewLine$InputFieldUpdateHandler inputFieldUpdateHandler;
    private PreviewLine$ResizeBackgroundAnimation resizeBackgroundAnimation;

    @Override
    protected void reset() {
        super.reset();
        this.contentRefs = null;
        this.inputFieldRef = null;
        this.historyList = null;
        this.previewList = null;
        this.resultList = null;
        this.arrowImageWidth = 0;
        this.cursorArea = new Rectangle();
        this.contentUpdateHandler = new PreviewLine$ContentUpdateHandler(this);
        this.inputFieldUpdateHandler = new PreviewLine$InputFieldUpdateHandler(this);
        this.resizeBackgroundAnimation = new PreviewLine$ResizeBackgroundAnimation(this);
        this.listSizeChangedNotifier = new PreviewLine$ListSizeChangedNotifier(this);
        this.previewLineContentEvaluator = new PreviewLine$ContentEvaluator(this);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, Color[] colorArray, Image[] imageArray, int n4, int[] nArray, WidgetModel[] widgetModelArray, EasingParams[] easingParamsArray, boolean bl4, int[] nArray2, int[] nArray3, Image[] imageArray2, int n5, int n6, boolean bl5, InactiveAreaModel inactiveAreaModel, InputFieldModel inputFieldModel, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n7, Image image2, int n8, boolean bl7, int n9, Insets insets, boolean bl8, int n10, int n11, int n12) {
        super.init(bl, n, image, bl2, bl3, n2, n3, colorArray, imageArray, n4, easingParamsArray, bl4, nArray2, nArray3, imageArray2, n5, n6, keyframeAnimationArray, bl6, layoutAttribs, string, n7, image2, n8, bl7, n9, insets, bl8, n10, n11, n12);
        this.contentRefs = widgetModelArray;
        this.inputFieldRef = inputFieldModel;
        this.inactiveAreaRef = inactiveAreaModel;
        this.contentBackgroundModes = nArray;
        this.setInternalStateFlag(18, bl5);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, Color[] colorArray, Image[] imageArray, int n4, int[] nArray, WidgetModel[] widgetModelArray, EasingParams[] easingParamsArray, boolean bl4, int n5, boolean bl5, InactiveAreaModel inactiveAreaModel, InputFieldModel inputFieldModel, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n6, Image image2, int n7, boolean bl7, int n8, Insets insets, boolean bl8, int n9, int n10, int n11) {
        super.init(bl, n, image, bl2, bl3, n2, n3, colorArray, imageArray, n4, easingParamsArray, bl4, n5, keyframeAnimationArray, bl6, layoutAttribs, string, n6, image2, n7, bl7, n8, insets, bl8, n9, n10, n11);
        this.contentRefs = widgetModelArray;
        this.inputFieldRef = inputFieldModel;
        this.inactiveAreaRef = inactiveAreaModel;
        this.contentBackgroundModes = nArray;
        this.setInternalStateFlag(18, bl5);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, Image[] imageArray, int n4, int[] nArray, WidgetModel[] widgetModelArray, EasingParams[] easingParamsArray, boolean bl4, int n5, boolean bl5, InactiveAreaModel inactiveAreaModel, InputFieldModel inputFieldModel, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n6, Image image2, int n7, boolean bl7, int n8, Insets insets, boolean bl8, int n9, int n10, int n11) {
        this.init(bl, n, image, bl2, bl3, n2, n3, null, imageArray, n4, nArray, widgetModelArray, easingParamsArray, bl4, n5, bl5, inactiveAreaModel, inputFieldModel, keyframeAnimationArray, bl6, layoutAttribs, string, n6, image2, n7, bl7, n8, insets, bl8, n9, n10, n11);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        if (this.contentBackgroundModes == null || this.contentBackgroundModes.length == 0) {
            this.contentBackgroundModes = CONTENT_BACKGROUND_MODES_DEFAULT;
        }
        this.registerPropertyChangedListener(this.contentUpdateHandler, this.get_contentRefs());
        this.initArrowSize();
        if (this.inputFieldRef != null) {
            this.inputFieldRef.addInputFieldChangedListener(this.inputFieldUpdateHandler);
            this.inputFieldRef.getAbsCursorArea(this.cursorArea);
            this.setArrowDestinationArea(this.cursorArea);
            if (this.inputFieldRef.get_spellerRef() != null) {
                this.previewLineChangedListener = this.inputFieldRef.get_spellerRef();
            }
        }
        this.showContent(-2);
        this.historyList = this.initContentListSizeHandler(0, this.listSizeChangedNotifier);
        this.previewList = this.initContentListSizeHandler(1, this.listSizeChangedNotifier);
        this.resultList = this.initContentListSizeHandler(2, this.listSizeChangedNotifier);
        this.evaluateContentImmediately();
    }

    @Override
    public void deInit() {
        if (this.inputFieldRef != null) {
            this.inputFieldRef.removeInputFieldChangedListener(this.inputFieldUpdateHandler);
        }
        if (this.historyList != null) {
            this.historyList.removePropertyChangedListener(this.listSizeChangedNotifier);
        }
        if (this.previewList != null) {
            this.previewList.removePropertyChangedListener(this.listSizeChangedNotifier);
        }
        if (this.resultList != null) {
            this.resultList.removePropertyChangedListener(this.listSizeChangedNotifier);
        }
        this.removePropertyChangedListener(this.contentUpdateHandler, this.get_contentRefs());
        super.deInit();
    }

    private TemplateListModel initContentListSizeHandler(int n, PropertyChangedListener propertyChangedListener) {
        WidgetModel widgetModel = this.getContentWidget(n);
        TemplateListModel templateListModel = null;
        if (widgetModel != null && widgetModel instanceof ContainerModel) {
            ContainerModel containerModel = (ContainerModel)widgetModel;
            WidgetModel[] widgetModelArray = containerModel.getChildren();
            for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
                if (!(widgetModelArray[i2] instanceof TemplateListModel)) continue;
                templateListModel = (TemplateListModel)widgetModelArray[i2];
                templateListModel.addPropertyChangedListener(propertyChangedListener);
                break;
            }
        }
        return templateListModel;
    }

    private void initArrowSize() {
        if (this.contentBackgroundModes != null) {
            boolean bl = false;
            for (int i2 = this.contentBackgroundModes.length - 1; i2 >= 0; --i2) {
                int n = this.contentBackgroundModes[i2];
                if (n == 1 || n == 0 || n == 6) continue;
                bl = true;
                break;
            }
            this.arrowImageWidth = bl ? this.calculateCompositeBackgroundImageWidth(4) : 0;
        }
    }

    @Override
    public float getBackgroundAlpha() {
        return 1.0f;
    }

    @Override
    public float getContentAlpha() {
        return 1.0f;
    }

    @Override
    public final WidgetModel[] get_contentRefs() {
        return this.contentRefs;
    }

    @Override
    public final void set_contentRefs(WidgetModel[] widgetModelArray) {
        WidgetModel[] widgetModelArray2 = this.contentRefs;
        if (widgetModelArray2 != widgetModelArray) {
            this.contentRefs = widgetModelArray;
            this.contentRefsChanged(widgetModelArray2);
            this.propertyChanged(32);
        }
    }

    @Override
    public int[] get_contentBackgroundModes() {
        return this.contentBackgroundModes;
    }

    @Override
    public final void set_contentBackgroundModes(int[] nArray) {
        int[] nArray2 = this.contentBackgroundModes;
        if (!Arrays.equals(nArray2, nArray)) {
            this.contentBackgroundModes = nArray;
            this.contentBackgroundModesChanged(nArray2);
            this.propertyChanged(33);
        }
    }

    @Override
    public boolean is_hideAutomatically() {
        return this.getInternalStateFlag(18);
    }

    @Override
    public void set_hideAutomatically(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(18);
        if (bl2 != bl) {
            this.setInternalStateFlag(18, bl);
            this.hideAutomaticallyChanged(bl2);
            this.propertyChanged(36);
        }
    }

    @Override
    public final InputFieldModel get_inputFieldRef() {
        return this.inputFieldRef;
    }

    @Override
    public final void set_inputFieldRef(InputFieldModel inputFieldModel) {
        InputFieldModel inputFieldModel2 = this.inputFieldRef;
        if (inputFieldModel2 != inputFieldModel) {
            this.inputFieldRef = inputFieldModel;
            this.inputFieldRefChanged(inputFieldModel2);
            this.propertyChanged(34);
        }
    }

    @Override
    public final InactiveAreaModel get_inactiveAreaRef() {
        return this.inactiveAreaRef;
    }

    @Override
    public final void set_inactiveAreaRef(InactiveAreaModel inactiveAreaModel) {
        InactiveAreaModel inactiveAreaModel2 = this.inactiveAreaRef;
        if (inactiveAreaModel2 != inactiveAreaModel) {
            this.inactiveAreaRef = inactiveAreaModel;
            this.inactiveAreaRefChanged(inactiveAreaModel2);
            this.propertyChanged(35);
        }
    }

    @Override
    public int getActiveContent() {
        return this.activeContent;
    }

    @Override
    protected void visibleChanged(boolean bl) {
        super.visibleChanged(bl);
        this.evaluateContentImmediately();
        this.calculateBackground();
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        super.parentVisibilityChanged(bl);
        this.evaluateContentImmediately();
    }

    protected void contentRefsChanged(WidgetModel[] widgetModelArray) {
        this.removePropertyChangedListener(this.contentUpdateHandler, widgetModelArray);
        this.registerPropertyChangedListener(this.contentUpdateHandler, this.get_contentRefs());
    }

    protected void contentBackgroundModesChanged(int[] nArray) {
        this.calculateBackground();
        this.initArrowSize();
    }

    protected void hideAutomaticallyChanged(boolean bl) {
        this.evaluateContent();
    }

    protected void inputFieldRefChanged(InputFieldModel inputFieldModel) {
        if (inputFieldModel != null) {
            inputFieldModel.removeInputFieldChangedListener(this.inputFieldUpdateHandler);
        }
        if (this.inputFieldRef != null) {
            this.inputFieldRef.addInputFieldChangedListener(this.inputFieldUpdateHandler);
            this.inputFieldRef.getAbsCursorArea(this.cursorArea);
            this.setArrowDestinationArea(this.cursorArea);
        }
    }

    @Override
    protected void compositeBackgroundImagesChanged(Image[] imageArray) {
        super.compositeBackgroundImagesChanged(imageArray);
        this.initArrowSize();
    }

    protected void inactiveAreaRefChanged(InactiveAreaModel inactiveAreaModel) {
    }

    @Override
    public void showContent(int n) {
        if (this.activeContent != n) {
            this.activeContent = n;
            boolean bl = false;
            if (this.previewLineChangedListener != null) {
                this.previewLineChangedListener.activeContentChanged(this.activeContent);
            }
            this.contentUpdateHandler.disableUpdates();
            switch (n) {
                case 0: {
                    this.setContentVisibility(0, true);
                    this.setContentVisibility(1, false);
                    this.setContentVisibility(2, false);
                    break;
                }
                case 1: {
                    this.setContentVisibility(0, false);
                    this.setContentVisibility(1, true);
                    this.setContentVisibility(2, false);
                    break;
                }
                case 2: {
                    this.setContentVisibility(0, false);
                    this.setContentVisibility(1, false);
                    this.setContentVisibility(2, true);
                    break;
                }
                case -2: 
                case -1: {
                    this.disableAnimations();
                    this.setContentVisibility(0, false);
                    this.setContentVisibility(1, false);
                    this.setContentVisibility(2, false);
                    this.enableAnimations();
                    break;
                }
            }
            bl = this.startResizeBackgroundAnimation();
            this.contentUpdateHandler.enableUpdates();
            if (!bl) {
                this.calculateBackgroundArea();
            }
        }
    }

    private void setContentVisibility(int n, boolean bl) {
        WidgetModel widgetModel = this.getContentWidget(n);
        if (widgetModel != null) {
            widgetModel.set_visible(bl);
        }
    }

    protected WidgetModel getContentWidget(int n) {
        WidgetModel widgetModel = null;
        if (this.contentRefs != null && this.contentRefs.length > n && n >= 0 && this.contentRefs[n] != null) {
            widgetModel = this.get_contentRefs()[n];
        }
        return widgetModel;
    }

    private int getBackgroundMode(int n) {
        int n2 = 1;
        if (this.contentBackgroundModes != null && this.contentBackgroundModes.length > n && n >= 0) {
            n2 = this.contentBackgroundModes[n];
        }
        return n2;
    }

    protected void evaluateContent() {
        this.previewLineContentEvaluator.evaluate();
    }

    protected void evaluateContentImmediately() {
        this.previewLineContentEvaluator.evaluteImmediately();
    }

    @Override
    protected void calculateBackgroundArea() {
        if (!this.isResizeBackgroundAnimationRunning()) {
            this.calculateBackgroundArea(this.getBackgroundArea());
        }
    }

    private void calculateBackgroundArea(Rectangle rectangle) {
        boolean bl;
        WidgetModel widgetModel = this.getContentWidget(this.activeContent);
        Point point = new Point(-129, -129);
        Point point2 = new Point(128, 128);
        this.calculateBoundingBox(-this.get_x(), -this.get_y(), point, point2);
        boolean bl2 = bl = point.x == -129 || point.y == -129 || point2.x == 128 || point2.y == 128;
        if (widgetModel != null && !bl) {
            ContainerModel containerModel;
            LayoutAttribs layoutAttribs;
            rectangle.setBounds(widgetModel.get_x(), widgetModel.get_y(), widgetModel.get_width(), widgetModel.get_height());
            if (this.activeContent == 2) {
                rectangle.height = point2.y - rectangle.y;
            }
            if (widgetModel instanceof Container && (layoutAttribs = (containerModel = (ContainerModel)widgetModel).get_layoutAttribs()) != null) {
                rectangle.x -= layoutAttribs.getInsetLeft();
                rectangle.y -= layoutAttribs.getInsetTop();
                rectangle.width += layoutAttribs.getInsetLeft() + layoutAttribs.getInsetRight();
                rectangle.height += layoutAttribs.getInsetTop() + layoutAttribs.getInsetBottom();
            }
        } else {
            rectangle.setBounds(0, 0, 0, 0);
        }
    }

    @Override
    protected void calculateArrowPosition() {
        Point point = this.getArrowPosition();
        Rectangle rectangle = this.getArrowDestinationArea();
        Rectangle rectangle2 = this.getBackgroundArea();
        int n = 0;
        switch (this.get_compositeBackgroundMode()) {
            case 2: {
                n = rectangle.x - this.getAbsX();
                point.setLocation(n, rectangle2.y);
                break;
            }
            case 3: {
                n = Util.clamp(rectangle.x - this.getAbsX(), 0, rectangle2.x + rectangle2.width - this.arrowImageWidth - this.get_compositeBackgroundArrowOffsetX());
                point.setLocation(n, rectangle2.y + rectangle2.height);
                break;
            }
            case 4: {
                n = rectangle.y - this.getAbsY();
                point.setLocation(rectangle2.x, n);
                break;
            }
            case 5: {
                n = rectangle.y - this.getAbsY();
                point.setLocation(rectangle2.x + rectangle2.width, n);
                break;
            }
            case 0: 
            case 1: 
            case 6: {
                break;
            }
            default: {
                LogMessage logMessage = LOGGER.warn(1);
                logMessage.append("PushUp: ").append(this.toString()).append(":").append(" Invalid Argument for compositeBackgroundMode <").append(this.get_compositeBackgroundMode()).append(">").log();
            }
        }
    }

    private int calculateCompositeBackgroundImageWidth(int n) {
        int n2 = 0;
        Image[] imageArray = this.get_compositeBackgroundImages();
        if (imageArray != null && imageArray.length > 0) {
            if (n >= 0 && n < imageArray.length) {
                Image image = imageArray[n];
                try {
                    BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(image);
                    n2 = bufferImage.getWidth();
                }
                catch (IOException iOException) {
                    LOGGER.error(1).append("Widget '").append(this.getQualifiedName()).append("': Unable to load composite background image at index [").append(n).append("].").attachThrowable(iOException).log();
                }
            } else {
                LOGGER.warn(1).append("Widget '").append(this.getQualifiedName()).append("': Unable to retrieve composite background image at index [").append(n).append("].").log();
            }
        }
        return n2;
    }

    private boolean startResizeBackgroundAnimation() {
        EasingParams easingParams = this.getEasing(7);
        int n = this.getBackgroundMode(this.activeContent);
        boolean bl = false;
        Rectangle rectangle = new Rectangle(this.get_x(), this.get_y(), this.get_width(), this.get_height());
        Rectangle rectangle2 = this.getBackgroundArea();
        Rectangle rectangle3 = new Rectangle();
        this.calculateBackgroundArea(rectangle3);
        if (easingParams != null && rectangle.intersects(rectangle2) && rectangle.intersects(rectangle3)) {
            this.resizeBackgroundAnimation.setAnimationParams(easingParams, rectangle3, n);
            bl = this.startInternalAnimation(this.resizeBackgroundAnimation);
        }
        if (!bl) {
            this.set_compositeBackgroundMode(n);
            this.stopResizeBackgroundAnimation();
        }
        return bl;
    }

    private void stopResizeBackgroundAnimation() {
        this.stopInternalAnimation(this.resizeBackgroundAnimation);
    }

    private boolean isResizeBackgroundAnimationRunning() {
        return this.resizeBackgroundAnimation != null && this.resizeBackgroundAnimation.isActive();
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopResizeBackgroundAnimation();
    }
}

