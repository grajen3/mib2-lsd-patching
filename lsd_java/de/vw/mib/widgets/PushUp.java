/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Dimension;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractBackgroundContainer;
import de.vw.mib.widgets.PushUp$ContentFadeInAnimation;
import de.vw.mib.widgets.PushUp$ContentFadeOutAnimation;
import de.vw.mib.widgets.PushUp$FadeInAnimation;
import de.vw.mib.widgets.PushUp$FadeOutAnimation;
import de.vw.mib.widgets.PushUp$ResizeAnimation;
import de.vw.mib.widgets.interfaces.PushUpHandler;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.ViewModel;

public class PushUp
extends AbstractBackgroundContainer
implements PushUpModel {
    private static final float CONTENT_ALPHA_VISIBLE;
    private static final float CONTENT_ALPHA_INVISIBLE;
    private static final float ALPHA_VISIBLE;
    private static final float ALPHA_INVISIBLE;
    private static final boolean INITIAL_HIDING;
    private int closeMode;
    private int scalingPivot;
    private PushUpHandler pushUpHandler;
    private PushUp$ResizeAnimation resizeAnimation;
    private PushUp$ContentFadeInAnimation contentFadeInAnimation;
    private PushUp$ContentFadeOutAnimation contentFadeOutAnimation;
    private PushUp$FadeInAnimation fadeInAnimation;
    private PushUp$FadeOutAnimation fadeOutAnimation;
    private float contentAlpha;
    private float backgroundAlpha;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$PushUpUI;

    @Override
    protected void reset() {
        super.reset();
        this.pushUpHandler = null;
        this.resizeAnimation = new PushUp$ResizeAnimation(this);
        this.contentFadeInAnimation = new PushUp$ContentFadeInAnimation(this);
        this.contentFadeOutAnimation = new PushUp$ContentFadeOutAnimation(this);
        this.fadeInAnimation = new PushUp$FadeInAnimation(this);
        this.fadeOutAnimation = new PushUp$FadeOutAnimation(this);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, int n4, Color[] colorArray, Image[] imageArray, int n5, EasingParams[] easingParamsArray, boolean bl4, int[] nArray, int[] nArray2, Image[] imageArray2, int n6, int n7, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n8, Image image2, int n9, boolean bl6, int n10, int n11, Insets insets, boolean bl7, int n12, int n13, int n14) {
        super.init(bl, n, image, bl2, bl3, n3, n4, colorArray, imageArray, n5, easingParamsArray, bl4, nArray, nArray2, imageArray2, n6, n7, keyframeAnimationArray, bl5, layoutAttribs, string, n8, image2, n9, bl6, n11, insets, bl7, n12, n13, n14);
        this.closeMode = n2;
        this.scalingPivot = n10;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, int n4, Color[] colorArray, Image[] imageArray, int n5, EasingParams[] easingParamsArray, boolean bl4, int n6, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n7, Image image2, int n8, boolean bl6, int n9, int n10, Insets insets, boolean bl7, int n11, int n12, int n13) {
        super.init(bl, n, image, bl2, bl3, n3, n4, colorArray, imageArray, n5, easingParamsArray, bl4, n6, keyframeAnimationArray, bl5, layoutAttribs, string, n7, image2, n8, bl6, n10, insets, bl7, n11, n12, n13);
        this.closeMode = n2;
        this.scalingPivot = n9;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, int n4, Image[] imageArray, int n5, EasingParams[] easingParamsArray, boolean bl4, int n6, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n7, Image image2, int n8, boolean bl6, int n9, int n10, Insets insets, boolean bl7, int n11, int n12, int n13) {
        this.init(bl, n, image, bl2, bl3, n2, n3, n4, null, imageArray, n5, easingParamsArray, bl4, n6, keyframeAnimationArray, bl5, layoutAttribs, string, n7, image2, n8, bl6, n9, n10, insets, bl7, n11, n12, n13);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_compositeBackgroundImages());
        if (INITIAL_HIDING) {
            this.setInternalStateFlag(2, false);
        }
        this.contentAlpha = this.is_visible() ? 1.0f : 0.0f;
        this.backgroundAlpha = this.is_visible() ? 1.0f : 0.0f;
        this.updateLayout();
        this.calculateBackground();
    }

    @Override
    public void activate() {
        super.activate();
    }

    @Override
    public void deActivate() {
        super.deActivate();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$PushUpUI == null ? (class$de$vw$mib$widgets$ui$PushUpUI = PushUp.class$("de.vw.mib.widgets.ui.PushUpUI")) : class$de$vw$mib$widgets$ui$PushUpUI};
    }

    @Override
    public final int get_closeMode() {
        return this.closeMode;
    }

    @Override
    public final void set_closeMode(int n) {
        int n2 = this.closeMode;
        if (n2 != n) {
            this.closeMode = n;
            this.propertyChanged(32);
            this.closeModeChanged(n2);
        }
    }

    @Override
    public final int get_scalingPivot() {
        return this.scalingPivot;
    }

    @Override
    public final void set_scalingPivot(int n) {
        int n2 = this.scalingPivot;
        if (n2 != n) {
            this.scalingPivot = n;
            this.scalingPivotChanged(n2);
            this.propertyChanged(37);
        }
    }

    @Override
    public float getContentAlpha() {
        return this.contentAlpha;
    }

    public void setContentAlpha(float f2) {
        if (this.contentAlpha != f2) {
            this.contentAlpha = f2;
            this.repaintParent();
        }
    }

    @Override
    public float getBackgroundAlpha() {
        return this.backgroundAlpha;
    }

    public void setBackgroundAlpha(float f2) {
        if (this.backgroundAlpha != f2) {
            this.backgroundAlpha = f2;
            this.repaintParent();
        }
    }

    @Override
    protected void visibleChanged(boolean bl) {
        if (!bl) {
            this.updateLayout();
            this.startResizeAnimation(false);
            if (!this.startFadeInAnimation()) {
                this.setBackgroundAlpha(1.0f);
            }
            if (!this.startContentFadeInAnimation()) {
                this.setContentAlpha(1.0f);
            }
        } else {
            this.startResizeAnimation(true);
            this.startFadeOutAnimation();
            if (!this.startContentFadeOutAnimation()) {
                this.setContentAlpha(0.0f);
            }
        }
        this.calculateArrowPosition();
        this.disableAnimations();
        super.visibleChanged(bl);
        this.enableAnimations();
    }

    protected void closeModeChanged(int n) {
    }

    protected void scalingPivotChanged(int n) {
    }

    @Override
    protected void xChanged(int n) {
        super.xChanged(n);
        if (!this.resizeAnimation.isAnimatedResizeActive()) {
            int n2 = this.get_x();
            this.stopResizeAnimation();
            this.set_x(n2);
        }
    }

    @Override
    protected void yChanged(int n) {
        super.yChanged(n);
        if (!this.resizeAnimation.isAnimatedResizeActive()) {
            int n2 = this.get_y();
            this.stopResizeAnimation();
            this.set_y(n2);
        }
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        if (!this.resizeAnimation.isAnimatedResizeActive()) {
            int n2 = this.get_width();
            this.stopResizeAnimation();
            this.set_width(n2);
        }
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        if (!this.resizeAnimation.isAnimatedResizeActive()) {
            int n2 = this.get_height();
            this.stopResizeAnimation();
            this.disableAnimations();
            this.set_height(n2);
            this.enableAnimations();
        }
    }

    @Override
    public final boolean isVisibleRelevantAnimationRunning() {
        return super.isVisibleRelevantAnimationRunning() || this.isFadeInAnimationRunning() || this.isFadeOutAnimationRunning() || this.isContentFadeInAnimationRunning() || this.isContentFadeOutAnimationRunning() || this.isResizeAnimationRunning();
    }

    protected final Dimension calculateDimension() {
        Point point = new Point(0, 0);
        Point point2 = new Point(128, 128);
        this.calculateBoundingBox(-this.get_x(), -this.get_y(), point, point2);
        LayoutAttribs layoutAttribs = this.get_layoutAttribs();
        int n = layoutAttribs != null ? layoutAttribs.getInsetBottom() + layoutAttribs.getInsetTop() : 0;
        int n2 = layoutAttribs != null ? layoutAttribs.getInsetLeft() + layoutAttribs.getInsetRight() : 0;
        int n3 = point2.y - point.y + n;
        int n4 = point2.x - point.x + n2;
        return new Dimension(n4, n3);
    }

    protected void updateLayout() {
        if ((this.scalingPivot & 0x100) != 0) {
            this.disableAnimations();
            Dimension dimension = this.calculateDimension();
            switch (this.scalingPivot ^ 0x100) {
                case 0: {
                    this.set_height(dimension.height);
                    break;
                }
                case 1: {
                    this.set_x(this.get_x() + this.get_width() - dimension.width);
                    this.set_width(dimension.width);
                    break;
                }
                case 2: {
                    this.set_y(this.get_y() + this.get_height() - dimension.height);
                    this.set_height(dimension.height);
                    break;
                }
                case 3: {
                    this.set_width(dimension.width);
                    break;
                }
                case 4: {
                    this.set_height(dimension.height);
                    this.set_x(this.get_x() + this.get_width() - dimension.width);
                    this.set_width(dimension.width);
                    break;
                }
                case 5: {
                    this.set_height(dimension.height);
                    this.set_width(dimension.width);
                    break;
                }
                case 6: {
                    this.set_y(this.get_y() + this.get_height() - dimension.height);
                    this.set_height(dimension.height);
                    this.set_x(this.get_x() + this.get_width() - dimension.width);
                    this.set_width(dimension.width);
                    break;
                }
                case 7: {
                    this.set_y(this.get_y() + this.get_height() - dimension.height);
                    this.set_height(dimension.height);
                    this.set_width(dimension.width);
                    break;
                }
                default: {
                    throw new IllegalArgumentException(new StringBuffer().append("Value: ").append(this.scalingPivot).append(" is not allowed as Scaling Pivot").toString());
                }
            }
            this.enableAnimations();
        }
    }

    protected Rectangle calculateAnimationParams(int n) {
        switch (n) {
            case 0: {
                return new Rectangle(this.get_x(), this.get_y(), this.get_width(), 0);
            }
            case 1: {
                return new Rectangle(this.get_x() + this.get_width(), this.get_y(), 0, this.get_height());
            }
            case 2: {
                return new Rectangle(this.get_x(), this.get_y() + this.get_height(), this.get_width(), 0);
            }
            case 3: {
                return new Rectangle(this.get_x(), this.get_y(), 0, this.get_height());
            }
            case 4: {
                return new Rectangle(this.get_x() + this.get_width(), this.get_y(), 0, 0);
            }
            case 5: {
                return new Rectangle(this.get_x(), this.get_y(), 0, 0);
            }
            case 6: {
                return new Rectangle(this.get_x() + this.get_width(), this.get_y() + this.get_height(), 0, 0);
            }
            case 7: {
                return new Rectangle(this.get_x(), this.get_y() + this.get_height(), 0, 0);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("Widget: ").append(this.toString()).append(" '").append(n).append("' is not a valid argument.").toString());
    }

    @Override
    protected void calculateBackgroundArea() {
        this.getBackgroundArea().setBounds(0, 0, this.get_width(), this.get_height());
    }

    @Override
    protected void calculateArrowPosition() {
        int n = 0;
        Point point = this.getArrowPosition();
        Rectangle rectangle = this.getArrowDestinationArea();
        switch (this.get_compositeBackgroundMode()) {
            case 2: {
                n = rectangle.x - this.getAbsX();
                point.setLocation(n, 0);
                break;
            }
            case 3: {
                n = rectangle.x - this.getAbsX();
                point.setLocation(n, this.get_height());
                break;
            }
            case 4: {
                n = rectangle.y - this.getAbsY();
                point.setLocation(0, n);
                break;
            }
            case 5: {
                n = rectangle.y - this.getAbsY();
                point.setLocation(this.get_width(), n);
                break;
            }
            case 7: {
                n = rectangle.x - this.getAbsX();
                point.setLocation(n += rectangle.width / 2, this.get_height());
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

    @Override
    public PushUpHandler getPushUpHandler() {
        return this.pushUpHandler;
    }

    @Override
    public void setPushUpHandler(PushUpHandler pushUpHandler) {
        this.pushUpHandler = pushUpHandler;
    }

    private boolean isFadeInAnimationRunning() {
        return this.fadeInAnimation != null && this.fadeInAnimation.isActive();
    }

    private boolean startFadeInAnimation() {
        this.stopFadeOutAnimation();
        this.stopFadeInAnimation();
        EasingParams easingParams = this.getEasing(11);
        if (easingParams == null) {
            return false;
        }
        this.setBackgroundAlpha(0.0f);
        this.fadeInAnimation.setAnimationParams(easingParams);
        return this.startInternalAnimation(this.fadeInAnimation);
    }

    private void stopFadeInAnimation() {
        this.stopInternalAnimation(this.fadeInAnimation);
    }

    private boolean isFadeOutAnimationRunning() {
        return this.fadeOutAnimation != null && this.fadeOutAnimation.isActive();
    }

    private boolean startFadeOutAnimation() {
        this.stopFadeInAnimation();
        this.stopFadeOutAnimation();
        EasingParams easingParams = this.getEasing(12);
        if (easingParams == null) {
            return false;
        }
        this.fadeOutAnimation.setAnimationParams(easingParams);
        return this.startInternalAnimation(this.fadeOutAnimation, true);
    }

    private void stopFadeOutAnimation() {
        this.stopInternalAnimation(this.fadeOutAnimation);
    }

    private boolean isContentFadeInAnimationRunning() {
        return this.contentFadeInAnimation != null && this.contentFadeInAnimation.isActive();
    }

    private boolean startContentFadeInAnimation() {
        this.stopContentFadeOutAnimation();
        this.stopContentFadeInAnimation();
        EasingParams easingParams = this.getEasing(9);
        if (easingParams == null) {
            return false;
        }
        this.setContentAlpha(0.0f);
        this.contentFadeInAnimation.setAnimationParams(easingParams);
        return this.startInternalAnimation(this.contentFadeInAnimation);
    }

    private void stopContentFadeInAnimation() {
        this.stopInternalAnimation(this.contentFadeInAnimation);
    }

    private boolean isContentFadeOutAnimationRunning() {
        return this.contentFadeOutAnimation != null && this.contentFadeOutAnimation.isActive();
    }

    private boolean startContentFadeOutAnimation() {
        this.stopContentFadeInAnimation();
        this.stopContentFadeOutAnimation();
        EasingParams easingParams = this.getEasing(10);
        if (easingParams == null) {
            return false;
        }
        this.contentFadeOutAnimation.setAnimationParams(easingParams);
        return this.startInternalAnimation(this.contentFadeOutAnimation, true);
    }

    private void stopContentFadeOutAnimation() {
        this.stopInternalAnimation(this.contentFadeOutAnimation);
    }

    private boolean isResizeAnimationRunning() {
        return this.resizeAnimation != null && this.resizeAnimation.isActive();
    }

    private boolean startResizeAnimation(boolean bl) {
        this.stopResizeAnimation();
        this.stopContentFadeOutAnimation();
        EasingParams easingParams = this.getEasing(bl ? 8 : 7);
        if (easingParams == null) {
            return false;
        }
        this.resizeAnimation.setAnimationParams(easingParams, this.calculateAnimationParams(this.scalingPivot & 0xFFFFFEFF), new Rectangle(this.get_x(), this.get_y(), this.get_width(), this.get_height()), bl);
        return this.startInternalAnimation(this.resizeAnimation, bl);
    }

    private void stopResizeAnimation() {
        this.stopInternalAnimation(this.resizeAnimation);
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopResizeAnimation();
        this.stopContentFadeInAnimation();
        this.stopContentFadeOutAnimation();
        this.stopFadeInAnimation();
        this.stopFadeOutAnimation();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        INITIAL_HIDING = System.getProperty("de.vw.mib.widgets.puhidingdisabled") == null;
    }
}

