/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.Container;
import de.vw.mib.widgets.InactiveArea$FadeInAnimation;
import de.vw.mib.widgets.InactiveArea$FadeOutAnimation;
import de.vw.mib.widgets.interfaces.Focusable;
import de.vw.mib.widgets.interfaces.PushUpHandler;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public final class InactiveArea
extends Container
implements InactiveAreaModel {
    private static final int ALPHA_VALUE_HIDDEN;
    private static final int ALPHA_VALUE_SHOWN;
    private Rectangle exclusionArea;
    private Rectangle[] additionalExclusionAreas;
    private PushUpHandler closeHandler;
    private boolean eventForwarding;
    private InactiveArea$FadeInAnimation fadeInAnimation;
    private InactiveArea$FadeOutAnimation fadeOutAnimation;
    private Focusable focusedWidget;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$InactiveAreaUI;

    @Override
    protected void reset() {
        super.reset();
        this.fadeInAnimation = new InactiveArea$FadeInAnimation(this);
        this.fadeOutAnimation = new InactiveArea$FadeOutAnimation(this);
        this.additionalExclusionAreas = new Rectangle[0];
        this.closeHandler = null;
        this.focusedWidget = null;
        this.eventForwarding = false;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Rectangle rectangle, int n2, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl6, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        super.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, n2, keyframeAnimationArray, bl5, layoutAttribs, string, n3, image2, n4, bl6, n5, insets, bl7, n6, n7, n8);
        this.exclusionArea = rectangle;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.focusedWidget = null;
    }

    @Override
    public Rectangle get_exclusionArea() {
        return this.exclusionArea;
    }

    @Override
    public void set_exclusionArea(Rectangle rectangle) {
        Rectangle rectangle2 = this.exclusionArea;
        if (rectangle2 == null || !rectangle2.equals(rectangle)) {
            this.exclusionArea = rectangle;
            this.exclusionAreaChanged(rectangle2);
            this.propertyChanged(23);
        }
    }

    @Override
    public Rectangle[] getAdditionalExclusionAreas() {
        return this.additionalExclusionAreas;
    }

    @Override
    public void setAdditionalExclusionAreas(Rectangle[] rectangleArray) {
        Object[] objectArray = this.additionalExclusionAreas;
        if (!Arrays.equals(objectArray, rectangleArray)) {
            this.additionalExclusionAreas = rectangleArray;
            this.additionalExclusionAreasChanged((Rectangle[])objectArray);
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$InactiveAreaUI == null ? (class$de$vw$mib$widgets$ui$InactiveAreaUI = InactiveArea.class$("de.vw.mib.widgets.ui.InactiveAreaUI")) : class$de$vw$mib$widgets$ui$InactiveAreaUI};
    }

    @Override
    public PushUpHandler getControlBarRef() {
        return this.closeHandler;
    }

    @Override
    public void setControlBarRef(PushUpHandler pushUpHandler) {
        this.closeHandler = pushUpHandler;
    }

    @Override
    public Focusable getFocusedWidget() {
        return this.focusedWidget;
    }

    @Override
    public boolean isFocusActive() {
        return this.focusedWidget != null;
    }

    @Override
    public boolean isEventForwarding() {
        return this.eventForwarding;
    }

    @Override
    public boolean isVisibleRelevantAnimationRunning() {
        return super.isVisibleRelevantAnimationRunning() || this.isFadeInAnimationRunning() || this.isFadeOutAnimationRunning();
    }

    @Override
    public boolean isAbsPointInsideTouchableArea(int n, int n2) {
        return this.isAbsPointInside(n, n2) && !this.isAbsPointInsideExclusionAreas(n, n2);
    }

    private boolean isAbsPointInsideExclusionAreas(int n, int n2) {
        if (this.exclusionArea == null && (this.additionalExclusionAreas == null || this.additionalExclusionAreas.length <= 0)) {
            return false;
        }
        int n3 = this.getAbsX();
        int n4 = this.getAbsY();
        int n5 = n - n3;
        int n6 = n2 - n4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.exclusionArea);
        if (this.additionalExclusionAreas != null) {
            arrayList.addAll(Arrays.asList(this.additionalExclusionAreas));
        }
        boolean bl = false;
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Rectangle rectangle = (Rectangle)iterator.next();
            if (rectangle == null || !rectangle.contains(n5, n6)) continue;
            bl = true;
            break;
        }
        return bl;
    }

    protected void additionalExclusionAreasChanged(Rectangle[] rectangleArray) {
        this.repaint();
    }

    protected void exclusionAreaChanged(Rectangle rectangle) {
    }

    @Override
    protected void visibleChanged(boolean bl) {
        if (!bl) {
            if (!this.startFadeInAnimation()) {
                this.set_alpha(255);
            }
        } else if (!this.startFadeOutAnimation()) {
            this.set_alpha(1);
        }
        super.visibleChanged(bl);
    }

    @Override
    public void focus(Focusable focusable, boolean bl) {
        this.focusedWidget = focusable;
        this.eventForwarding = bl;
    }

    @Override
    public void unFocus() {
        this.focusedWidget = null;
    }

    private boolean isFadeInAnimationRunning() {
        return this.fadeInAnimation != null && this.fadeInAnimation.isActive();
    }

    private boolean startFadeInAnimation() {
        this.stopFadeInAnimation();
        EasingParams easingParams = this.getEasing(7);
        if (easingParams == null) {
            return false;
        }
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
        this.stopFadeOutAnimation();
        EasingParams easingParams = this.getEasing(8);
        if (easingParams == null) {
            return false;
        }
        this.fadeOutAnimation.setAnimationParams(easingParams);
        return this.startInternalAnimation(this.fadeOutAnimation, true);
    }

    private void stopFadeOutAnimation() {
        this.stopInternalAnimation(this.fadeOutAnimation);
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
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
}

