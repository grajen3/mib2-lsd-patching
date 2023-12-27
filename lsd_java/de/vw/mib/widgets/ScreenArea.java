/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.ScreenArea$MoveInViewAnimation;
import de.vw.mib.widgets.ScreenArea$MoveOutViewAnimation;
import de.vw.mib.widgets.ScreenArea$ViewChangedHandler;
import de.vw.mib.widgets.TransformContainer;
import de.vw.mib.widgets.event.ViewChangedListener;
import de.vw.mib.widgets.models.ScreenAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.Arrays;
import java.util.List;

public final class ScreenArea
extends TransformContainer
implements ScreenAreaModel {
    private int scalemode;
    ScreenArea$MoveInViewAnimation moveInViewAnimation;
    ScreenArea$MoveOutViewAnimation moveOutViewAnimation;
    private int[] viewTypesAnimatable;
    private int[] viewTypesAlignment;
    private boolean alignmentBlocked;
    private ScreenArea$ViewChangedHandler viewChangedHandler;
    int viewAlignment;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ScreenAreaUI;

    public void init(boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl6, float f9, float f10, float f11, int n8, float f12, float f13, float f14, int n9, Insets insets, int n10, int[] nArray, int[] nArray2, boolean bl7, int n11, int n12, int n13, int n14) {
        super.init(bl, n, image, bl2, f2, bl3, n2, n3, easingParamsArray, bl4, n4, keyframeAnimationArray, bl5, layoutAttribs, string, f3, f4, f5, f6, f7, f8, n5, n6, image2, n7, bl6, f9, f10, f11, f12, f13, f14, n9, insets, bl7, n11, n12, n13, n14);
        this.viewAlignment = n10;
        this.viewTypesAlignment = nArray;
        this.viewTypesAnimatable = nArray2;
        this.scalemode = n8;
        this.setInternalStateFlag(17, true);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, int n4, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl6, float f9, float f10, float f11, float f12, float f13, float f14, int n8, Insets insets, int n9, int[] nArray, int[] nArray2, boolean bl7, int n10, int n11, int n12, int n13) {
        this.init(bl, n, image, bl2, f2, bl3, n2, n3, easingParamsArray, bl4, n4, keyframeAnimationArray, bl5, layoutAttribs, string, f3, f4, f5, f6, f7, f8, n5, n6, image2, n7, bl6, f9, f10, f11, 0, f12, f13, f14, n8, insets, n9, nArray, nArray2, bl7, n10, n11, n12, n13);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.alignmentBlocked = false;
    }

    @Override
    public void deInit() {
        super.deInit();
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
        return new Class[]{class$de$vw$mib$widgets$ui$ScreenAreaUI == null ? (class$de$vw$mib$widgets$ui$ScreenAreaUI = ScreenArea.class$("de.vw.mib.widgets.ui.ScreenAreaUI")) : class$de$vw$mib$widgets$ui$ScreenAreaUI};
    }

    @Override
    public void set_viewAlignment(int n) {
        int n2 = this.viewAlignment;
        if (n2 != n && !this.isAlignmentBlocked()) {
            this.viewAlignment = n;
            this.viewAlignmentChanged(n2);
            this.propertyChanged(40);
        }
    }

    @Override
    public int get_viewAlignment() {
        return this.viewAlignment;
    }

    @Override
    public int[] get_viewTypesAnimatable() {
        return this.viewTypesAnimatable;
    }

    @Override
    public void set_viewTypesAnimatable(int[] nArray) {
        int[] nArray2 = this.viewTypesAnimatable;
        if (!Arrays.equals(nArray2, nArray)) {
            this.viewTypesAnimatable = nArray;
            this.viewTypesAnimatableChanged(nArray2);
            this.propertyChanged(41);
        }
    }

    @Override
    public int[] get_viewTypesAlignment() {
        return this.viewTypesAlignment;
    }

    @Override
    public void set_viewTypesAlignment(int[] nArray) {
        int[] nArray2 = this.viewTypesAlignment;
        if (!Arrays.equals(nArray2, nArray)) {
            this.viewTypesAlignment = nArray;
            this.viewTypesAlignmentChanged(nArray2);
            this.propertyChanged(42);
        }
    }

    @Override
    public int get_scalemode() {
        return this.scalemode;
    }

    @Override
    public void set_scalemode(int n) {
        int n2 = this.scalemode;
        if (n2 != n) {
            this.scalemode = n;
            this.scalemodeChanged(n2);
            this.propertyChanged(43);
        }
    }

    private boolean isAlignmentBlocked() {
        return this.alignmentBlocked;
    }

    private ViewChangedListener getViewChangedHandler() {
        if (this.viewChangedHandler == null) {
            this.viewChangedHandler = new ScreenArea$ViewChangedHandler(this);
        }
        return this.viewChangedHandler;
    }

    private boolean isViewAnimatable(ViewModel viewModel) {
        if (this.viewTypesAnimatable != null && viewModel.get_viewTypes() != null) {
            for (int i2 = 0; i2 < this.viewTypesAnimatable.length; ++i2) {
                if (viewModel.getCurrentViewType() != this.viewTypesAnimatable[i2]) continue;
                return true;
            }
        }
        return false;
    }

    private boolean isViewAlignment(ViewModel viewModel) {
        if (this.viewTypesAlignment != null && viewModel.get_viewTypes() != null) {
            for (int i2 = 0; i2 < this.viewTypesAlignment.length; ++i2) {
                if (viewModel.getCurrentViewType() != this.viewTypesAlignment[i2]) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    protected void childrenChanged(WidgetModel[] widgetModelArray) {
        ViewModel viewModel;
        int n;
        super.childrenChanged(widgetModelArray);
        WidgetModel[] widgetModelArray2 = this.getChildren();
        boolean bl = false;
        this.alignmentBlocked = false;
        if (widgetModelArray != null) {
            for (n = widgetModelArray.length - 1; n >= 0; --n) {
                if (!(widgetModelArray[n] instanceof ViewModel)) continue;
                viewModel = (ViewModel)widgetModelArray[n];
                viewModel.removeViewChangedListener(this.getViewChangedHandler());
                if (this.scalemode == 0) continue;
                this.restoreViewScaling(viewModel);
            }
        }
        for (n = 0; n < widgetModelArray2.length; ++n) {
            viewModel = (ViewModel)widgetModelArray2[n];
            if (viewModel.get_width() != this.get_width()) continue;
            bl = true;
        }
        for (n = 0; n < widgetModelArray2.length; ++n) {
            if (widgetModelArray2[n] == null || !(widgetModelArray2[n] instanceof ViewModel)) continue;
            viewModel = (ViewModel)widgetModelArray2[n];
            if (viewModel.get_width() < this.get_width()) {
                if (bl && this.isViewAnimatable(viewModel)) {
                    viewModel.addViewChangedListener(this.getViewChangedHandler());
                }
                switch (this.get_viewAlignment()) {
                    case 1: {
                        viewModel.set_x(0);
                        break;
                    }
                    case 2: {
                        viewModel.set_x(this.get_width() - viewModel.get_width());
                        break;
                    }
                }
            }
            boolean bl2 = this.alignmentBlocked = this.alignmentBlocked || this.isViewAlignment(viewModel);
            if (this.scalemode == 0) continue;
            this.updateViewScaling(viewModel);
        }
    }

    private void updateViewScaling() {
        WidgetModel[] widgetModelArray = this.getChildren();
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            if (!(widgetModelArray[i2] instanceof ViewModel)) continue;
            this.updateViewScaling((ViewModel)widgetModelArray[i2]);
        }
    }

    private void restoreViewScaling(ViewModel viewModel) {
        viewModel.set_scalingX(1.0f);
        viewModel.set_scalingY(1.0f);
        viewModel.set_pivotX(0.0f);
        viewModel.set_pivotY(0.0f);
        viewModel.set_x(0);
        viewModel.set_y(0);
    }

    private void updateViewScaling(ViewModel viewModel) {
        float f2 = this.getScaleFactor(viewModel, this.scalemode);
        viewModel.set_scalingX(f2);
        viewModel.set_scalingY(f2);
        viewModel.set_pivotX(63);
        viewModel.set_pivotY(63);
        viewModel.set_x(this.get_width() - viewModel.get_width() >> 1);
        viewModel.set_y(this.get_height() - viewModel.get_height() >> 1);
    }

    public boolean isMoveInViewLeftAnimationRunning() {
        return this.moveInViewAnimation != null && this.moveInViewAnimation.isActive();
    }

    private void stopMoveInViewLeftAnimation() {
        if (this.moveInViewAnimation != null) {
            this.stopInternalAnimation(this.moveInViewAnimation);
            this.moveInViewAnimation = null;
        }
    }

    boolean startMoveInViewAnimation(int n, int n2, ViewModel viewModel) {
        if (this.moveInViewAnimation != null && this.moveInViewAnimation.isActive() && (float)n2 == this.moveInViewAnimation.getEndValue()) {
            return true;
        }
        EasingParams easingParams = this.getEasing(15);
        if (easingParams == null) {
            return false;
        }
        int n3 = n;
        this.stopMoveInViewLeftAnimation();
        this.moveInViewAnimation = new ScreenArea$MoveInViewAnimation(this, easingParams, n3, n2 - n3, viewModel);
        return this.startInternalAnimation(this.moveInViewAnimation);
    }

    public boolean isMoveOutViewLeftAnimationRunning() {
        return this.moveOutViewAnimation != null && this.moveOutViewAnimation.isActive();
    }

    private void stopMoveOutViewLeftAnimation() {
        if (this.moveOutViewAnimation != null) {
            this.stopInternalAnimation(this.moveOutViewAnimation);
            this.moveOutViewAnimation = null;
        }
    }

    boolean startMoveOutViewAnimation(int n, int n2, ViewModel viewModel) {
        if (this.moveOutViewAnimation != null && this.moveOutViewAnimation.isActive() && (float)n2 == this.moveOutViewAnimation.getEndValue()) {
            return true;
        }
        EasingParams easingParams = this.getEasing(16);
        if (easingParams == null) {
            return false;
        }
        int n3 = n;
        this.stopMoveOutViewLeftAnimation();
        this.moveOutViewAnimation = new ScreenArea$MoveOutViewAnimation(this, easingParams, n3, n2 - n3, viewModel);
        return this.startInternalAnimation(this.moveOutViewAnimation);
    }

    protected void viewAlignmentChanged(int n) {
        this.repaint();
    }

    protected void viewTypesAnimatableChanged(int[] nArray) {
        this.repaint();
    }

    protected void viewTypesAlignmentChanged(int[] nArray) {
        this.repaint();
    }

    protected void scalemodeChanged(int n) {
        this.updateViewScaling();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        if (this.scalemode != 0) {
            this.updateViewScaling();
        }
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        if (this.scalemode != 0) {
            this.updateViewScaling();
        }
    }

    protected void addAllChildren(Class clazz, List list) {
    }

    private float getScaleFactor(WidgetModel widgetModel, int n) {
        if (n == 0) {
            return 1.0f;
        }
        int n2 = this.get_width();
        int n3 = this.get_height();
        float f2 = (float)n3 / (float)widgetModel.get_height();
        float f3 = (float)n2 / (float)widgetModel.get_width();
        switch (n) {
            case 2: {
                return Math.max(f3, f2);
            }
            case 1: {
                return Math.min(f3, f2);
            }
        }
        return 1.0f;
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

