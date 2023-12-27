/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.View;
import de.vw.mib.widgets.controller.DefaultScreenController;
import de.vw.mib.widgets.models.ScreenModel;

public final class Screen
extends View
implements ScreenModel {
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ScreenUI;

    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init(boolean bl, int n, Image image, boolean bl2, float f2, boolean bl3, Color color, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n4, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f3, float f4, float f5, float f6, float f7, float f8, int n5, int n6, Image image2, int n7, boolean bl7, boolean bl8, boolean bl9, float f9, float f10, float f11, float f12, float f13, float f14, int n8, int n9, Insets insets, int[] nArray, int n10, boolean bl10, int n11, int n12, int n13, int n14) {
        super.init(bl, n, image, bl2, f2, bl3, color, n2, n3, easingParamsArray, bl4, keyframeAnimationArray, n4, keyframeAnimationArray2, bl5, layoutAttribs, keyframeAnimationArray3, string, bl6, f3, f4, f5, f6, f7, f8, n5, n6, image2, n7, bl7, bl8, bl9, f9, f10, f11, f12, f13, f14, n8, n9, insets, nArray, n10, bl10, n11, n12, n13, n14);
    }

    @Override
    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Color color, int n2, int n3, EasingParams[] easingParamsArray, boolean bl4, KeyframeAnimation[] keyframeAnimationArray, int n4, KeyframeAnimation[] keyframeAnimationArray2, boolean bl5, LayoutAttribs layoutAttribs, KeyframeAnimation[] keyframeAnimationArray3, String string, boolean bl6, float f2, float f3, float f4, float f5, float f6, float f7, int n5, int n6, Image image2, int n7, boolean bl7, boolean bl8, boolean bl9, float f8, float f9, float f10, float f11, float f12, float f13, int n8, int n9, Insets insets, int[] nArray, int n10, boolean bl10, int n11, int n12, int n13, int n14) {
        this.init(bl, n, image, bl2, 0.0f, bl3, color, n2, n3, easingParamsArray, bl4, keyframeAnimationArray, n4, keyframeAnimationArray2, bl5, layoutAttribs, keyframeAnimationArray3, string, bl6, f2, f3, f4, f5, f6, f7, n5, n6, image2, n7, bl7, bl8, bl9, f8, f9, f10, f11, f12, f13, n8, n9, insets, nArray, n10, bl10, n11, n12, n13, n14);
    }

    @Override
    public void init() {
        super.init();
        DefaultScreenController defaultScreenController = new DefaultScreenController();
        defaultScreenController.setWidget(this);
        defaultScreenController.init();
        this.setController(defaultScreenController);
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ScreenUI == null ? (class$de$vw$mib$widgets$ui$ScreenUI = Screen.class$("de.vw.mib.widgets.ui.ScreenUI")) : class$de$vw$mib$widgets$ui$ScreenUI};
    }

    @Override
    public boolean isDrawBoundingBoxesEnabled() {
        return this.is_renderBoundingBoxes();
    }

    @Override
    public void setDrawBoundingBoxesEnabled(boolean bl) {
        this.set_renderBoundingBoxes(bl);
    }

    @Override
    public boolean isDrawDebugOverlayEnabled() {
        return this.is_renderInfo();
    }

    @Override
    public void setDrawDebugOverlayEnabled(boolean bl) {
        this.set_renderInfo(bl);
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

