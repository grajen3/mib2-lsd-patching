/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.Container;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WindowWidgetModel;

public class WindowWidget
extends Container
implements WindowWidgetModel {
    private int headlineHeight;
    private boolean windowCollapse;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$WindowWidgetUI;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n2, int n3, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n4, Image image2, int n5, boolean bl6, int n6, Insets insets, boolean bl7, int n7, boolean bl8, int n8, int n9) {
        super.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, n3, keyframeAnimationArray, bl5, layoutAttribs, string, n4, image2, n5, bl6, n6, insets, bl7, n7, n8, n9);
        this.windowCollapse = bl8;
        this.headlineHeight = n2;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$WindowWidgetUI == null ? (class$de$vw$mib$widgets$ui$WindowWidgetUI = WindowWidget.class$("de.vw.mib.widgets.ui.WindowWidgetUI")) : class$de$vw$mib$widgets$ui$WindowWidgetUI};
    }

    @Override
    public final int get_headlineHeight() {
        return this.headlineHeight;
    }

    @Override
    public final void set_headlineHeight(int n) {
        int n2 = this.headlineHeight;
        if (n2 != n) {
            this.headlineHeight = n;
            this.headlineHeightChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final boolean is_windowCollapse() {
        return this.windowCollapse;
    }

    @Override
    public final void set_windowCollapse(boolean bl) {
        boolean bl2 = this.windowCollapse;
        if (bl2 != bl) {
            this.windowCollapse = bl;
            this.windowCollapseChanged(bl2);
            this.propertyChanged(24);
        }
    }

    protected void headlineHeightChanged(int n) {
    }

    protected void windowCollapseChanged(boolean bl) {
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

