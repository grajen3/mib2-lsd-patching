/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.control.AnimatedPropertiesAccessor;
import de.vw.mib.animation.control.AnimationListener;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.PopupViewModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public final class PopupView
extends View
implements PopupViewModel {
    private Rectangle visibleArea;
    private int visibleAreaAlignment;
    private Image[] compositeBackgroundImages;
    private Color[] compositeBackgroundColors;
    private int compositeBackgroundMode;
    private int compositeBackgroundArrowOffsetX;
    private int compositeBackgroundArrowOffsetY;
    private int restrictionMode;
    private Rectangle backgroundArea;
    private Point arrowPosition;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$PopupViewUI;

    @Override
    protected void reset() {
        super.reset();
        this.arrowPosition = new Point();
        this.backgroundArea = new Rectangle();
        this.animationBlockingEnabled = false;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, Color color, int n2, int n3, Color[] colorArray, Image[] imageArray, int n4, int n5, int n6, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n7, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f3, float f4, float f5, float f6, float f7, float f8, int n8, int n9, Image image2, int n10, boolean bl7, boolean bl8, boolean bl9, int n11, float f9, float f10, float f11, float f12, float f13, float f14, int n12, int n13, Insets insets, int[] nArray, int n14, boolean bl10, Rectangle rectangle, int n15, int n16, int n17, int n18, int n19) {
        super.init(bl, n, image, bl2, f2, bl3, color, n5, n6, easingParamsArray, bl4, keyframeAnimationArray, n7, keyframeAnimationArray2, bl5, layoutAttribs, keyframeAnimationArray3, string, bl6, f3, f4, f5, f6, f7, f8, n8, n9, image2, n10, bl7, bl8, bl9, f9, f10, f11, f12, f13, f14, n12, n13, insets, nArray, n14, bl10, n16, n17, n18, n19);
        this.visibleArea = rectangle;
        this.visibleAreaAlignment = n15;
        this.restrictionMode = n11;
        this.compositeBackgroundArrowOffsetX = n2;
        this.compositeBackgroundArrowOffsetY = n3;
        this.compositeBackgroundImages = imageArray;
        this.compositeBackgroundColors = colorArray;
        this.compositeBackgroundMode = n4;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Color color, int n2, int n3, Color[] colorArray, Image[] imageArray, int n4, int n5, int n6, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n7, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f2, float f3, float f4, float f5, float f6, float f7, int n8, int n9, Image image2, int n10, boolean bl7, boolean bl8, boolean bl9, int n11, float f8, float f9, float f10, float f11, float f12, float f13, int n12, int n13, Insets insets, int[] nArray, int n14, boolean bl10, Rectangle rectangle, int n15, int n16, int n17, int n18, int n19) {
        this.init(bl, n, image, bl2, 0.0f, bl3, color, n2, n3, colorArray, imageArray, n4, n5, n6, easingParamsArray, bl4, keyframeAnimationArray, n7, keyframeAnimationArray2, bl5, layoutAttribs, keyframeAnimationArray3, string, bl6, f2, f3, f4, f5, f6, f7, n8, n9, image2, n10, bl7, bl8, bl9, n11, f8, f9, f10, f11, f12, f13, n12, n13, insets, nArray, n14, bl10, rectangle, n15, n16, n17, n18, n19);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_compositeBackgroundImages());
        if (this.visibleArea != null) {
            this.backgroundArea.setBounds(0, 0, this.visibleArea.width, this.visibleArea.height);
        }
    }

    @Override
    public void set_compositeBackgroundImages(Image[] imageArray) {
        Object[] objectArray = this.compositeBackgroundImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.compositeBackgroundImages = imageArray;
            this.compositeBackgroundImagesChanged((Image[])objectArray);
            this.propertyChanged(51);
        }
    }

    @Override
    public Image[] get_compositeBackgroundImages() {
        return this.compositeBackgroundImages;
    }

    @Override
    public void set_compositeBackgroundColors(Color[] colorArray) {
        Object[] objectArray = this.compositeBackgroundColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.compositeBackgroundColors = colorArray;
            this.compositeBackgroundColorsChanged((Color[])objectArray);
            this.propertyChanged(52);
        }
    }

    @Override
    public Color[] get_compositeBackgroundColors() {
        return this.compositeBackgroundColors;
    }

    @Override
    public int get_compositeBackgroundMode() {
        return this.compositeBackgroundMode;
    }

    @Override
    public void set_compositeBackgroundMode(int n) {
        int n2 = this.compositeBackgroundMode;
        if (n2 != n) {
            this.compositeBackgroundMode = n;
            this.compositeBackgroundModeChanged(n2);
            this.propertyChanged(53);
        }
    }

    @Override
    public int get_compositeBackgroundArrowOffsetX() {
        return this.compositeBackgroundArrowOffsetX;
    }

    @Override
    public void set_compositeBackgroundArrowOffsetX(int n) {
        int n2 = this.compositeBackgroundArrowOffsetX;
        if (n2 != n) {
            this.compositeBackgroundArrowOffsetX = n;
            this.compositeBackgroundArrowOffsetXChanged(n2);
            this.propertyChanged(54);
        }
    }

    @Override
    public int get_compositeBackgroundArrowOffsetY() {
        return this.compositeBackgroundArrowOffsetY;
    }

    @Override
    public void set_compositeBackgroundArrowOffsetY(int n) {
        int n2 = this.compositeBackgroundArrowOffsetY;
        if (n2 != n) {
            this.compositeBackgroundArrowOffsetY = n;
            this.compositeBackgroundArrowOffsetYChanged(n2);
            this.propertyChanged(55);
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$PopupViewUI == null ? (class$de$vw$mib$widgets$ui$PopupViewUI = PopupView.class$("de.vw.mib.widgets.ui.PopupViewUI")) : class$de$vw$mib$widgets$ui$PopupViewUI};
    }

    @Override
    public Rectangle get_visibleArea() {
        return this.visibleArea;
    }

    @Override
    public void set_visibleArea(Rectangle rectangle) {
        Rectangle rectangle2 = this.visibleArea;
        if (rectangle2 == null || !rectangle2.equals(rectangle)) {
            this.visibleArea = rectangle;
            this.visibleAreaChanged(rectangle2);
            this.propertyChanged(49);
        }
    }

    @Override
    public int get_visibleAreaAlignment() {
        return this.visibleAreaAlignment;
    }

    @Override
    public void set_visibleAreaAlignment(int n) {
        int n2 = this.visibleAreaAlignment;
        if (n2 != n) {
            this.visibleAreaAlignment = n;
            this.visibleAreaAlignmentChanged(n2);
            this.propertyChanged(50);
        }
    }

    @Override
    public int get_restrictionMode() {
        return this.restrictionMode;
    }

    @Override
    public void set_restrictionMode(int n) {
        int n2 = this.restrictionMode;
        if (n2 != n) {
            this.restrictionMode = n;
            this.restrictionModeChanged(n2);
            this.propertyChanged(56);
        }
    }

    @Override
    public void setArrowDestinationArea(Rectangle rectangle) {
    }

    @Override
    public Point getArrowPosition() {
        return this.arrowPosition;
    }

    @Override
    public Rectangle getBackgroundArea() {
        return this.backgroundArea;
    }

    public int getVisibleAreaAlignment() {
        return this.visibleAreaAlignment;
    }

    protected void compositeBackgroundImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_compositeBackgroundImages());
        this.repaint();
    }

    protected void compositeBackgroundColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    protected void compositeBackgroundModeChanged(int n) {
        this.repaint();
    }

    protected void compositeBackgroundArrowOffsetXChanged(int n) {
        this.repaint();
    }

    protected void compositeBackgroundArrowOffsetYChanged(int n) {
        this.repaint();
    }

    protected void visibleAreaChanged(Rectangle rectangle) {
        this.repaint();
    }

    protected void visibleAreaAlignmentChanged(int n) {
        this.repaint();
    }

    protected void restrictionModeChanged(int n) {
        this.repaint();
    }

    @Override
    public boolean startEnterAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        if (this.animationBlockingEnabled) {
            return false;
        }
        int n3 = this.get_viewTypeSelection();
        int n4 = n;
        KeyframeAnimation[] keyframeAnimationArray = this.get_enterAnimations();
        if (keyframeAnimationArray != null && n3 != 0) {
            n4 = Util.clamp(n + n3, 0, keyframeAnimationArray.length - 1);
        }
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("PopupView ").append(this.getQualifiedName()).append(" start enter animation: ").append(" enterAnimationIndex = ").append(n).append(", viewTypeSelection offset: ").append(n3).append(", available animations:").append(keyframeAnimationArray == null ? 0 : keyframeAnimationArray.length).append(", index with offset=").append(n4);
            logMessage.log();
        }
        return super.startEnterAnimation(animatedPropertiesAccessor, n4, n2, animationListener);
    }

    @Override
    public boolean startLeaveAnimation(AnimatedPropertiesAccessor animatedPropertiesAccessor, int n, int n2, AnimationListener animationListener) {
        if (this.animationBlockingEnabled) {
            return false;
        }
        int n3 = this.get_viewTypeSelection();
        int n4 = n;
        KeyframeAnimation[] keyframeAnimationArray = this.get_leaveAnimations();
        if (keyframeAnimationArray != null && n3 != 0) {
            n4 = Util.clamp(n + n3, 0, keyframeAnimationArray.length - 1);
        }
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("PopupView ").append(this.getQualifiedName()).append(" start leave animation: ").append(" leaveAnimationIndex = ").append(n).append(", viewTypeSelection offset: ").append(n3).append(", available animations:").append(keyframeAnimationArray == null ? 0 : keyframeAnimationArray.length).append(", index with offset=").append(n4);
            logMessage.log();
        }
        return super.startLeaveAnimation(animatedPropertiesAccessor, n4, n2, animationListener);
    }

    private void calculateArrowPosition() {
        int n;
        int n2;
        switch (this.compositeBackgroundMode) {
            case 2: 
            case 4: {
                n2 = this.backgroundArea.x;
                n = this.backgroundArea.y;
                break;
            }
            case 3: {
                n2 = this.backgroundArea.x;
                n = this.visibleArea.y + this.visibleArea.height;
                break;
            }
            case 5: {
                n2 = this.backgroundArea.x + this.visibleArea.width;
                n = this.visibleArea.y;
                break;
            }
            case 0: 
            case 1: 
            case 6: {
                n2 = 0;
                n = 0;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Invalid enumeration for compositeBackgroundMode:").append(this.compositeBackgroundMode).toString());
            }
        }
        this.arrowPosition.setLocation(n2 + this.get_x(), n + this.get_y());
    }

    @Override
    public void performLayout() {
        super.performLayout();
        this.updateBackgroundLayout();
    }

    private void updateBackgroundLayout() {
        int n;
        int n2;
        int n3;
        int n4;
        int n5 = this.get_visibleAreaAlignment();
        Point point = new Point(-129, -129);
        Point point2 = new Point(128, 128);
        LayoutAttribs layoutAttribs = this.get_layoutAttribs();
        switch (n5) {
            case 0: {
                n4 = this.visibleArea.x;
                n3 = this.visibleArea.y;
                n2 = this.visibleArea.width;
                n = this.visibleArea.height;
                break;
            }
            case 1: {
                n3 = this.visibleArea.y;
                n = this.visibleArea.height;
                this.calculateBoundingBox(0, 0, point, point2);
                if (layoutAttribs == null) {
                    n4 = point.x - this.get_x();
                    n2 = point2.x - point.x;
                    break;
                }
                n4 = point.x - layoutAttribs.getInsetLeft() - this.get_x();
                n2 = point2.x - point.x + layoutAttribs.getInsetLeft() + layoutAttribs.getInsetRight();
                break;
            }
            case 2: {
                n4 = this.visibleArea.x;
                n2 = this.visibleArea.width;
                this.calculateBoundingBox(0, 0, point, point2);
                if (layoutAttribs == null) {
                    n3 = point.y - this.get_y();
                    n = point2.y - point.y;
                    break;
                }
                n3 = point.y - layoutAttribs.getInsetTop() - this.get_y();
                n = point2.y - point.y + layoutAttribs.getInsetBottom() + layoutAttribs.getInsetTop();
                break;
            }
            case 3: {
                this.calculateBoundingBox(0, 0, point, point2);
                if (layoutAttribs == null) {
                    n4 = point.x - this.get_x();
                    n2 = point2.x - point.x;
                    n3 = point.y - this.get_y();
                    n = point2.y - point.y;
                    break;
                }
                n4 = point.x - layoutAttribs.getInsetLeft() - this.get_x();
                n2 = point2.x - point.x + layoutAttribs.getInsetLeft() + layoutAttribs.getInsetRight();
                n3 = point.y - layoutAttribs.getInsetTop() - this.get_y();
                n = point2.y - point.y + layoutAttribs.getInsetBottom() + layoutAttribs.getInsetTop();
                break;
            }
            default: {
                throw new IllegalArgumentException("Invalid enumeration for visibleAreaAlignment");
            }
        }
        if (LOGGER.isTraceEnabled(1024)) {
            LogMessage logMessage = LOGGER.trace(1024);
            logMessage.append("PopupView ").append(this.getQualifiedName()).append(" updated background layout ");
            logMessage.append("[x= ").append(n4).append(" y= ").append(n3).append(" width=").append(n2).append(" height=").append(n).append("]").log();
        }
        this.backgroundArea.setBounds(n4, n3, n2, n);
        this.calculateArrowPosition();
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

