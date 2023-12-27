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
import de.vw.mib.widgets.controller.ListController;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.ListModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;

public abstract class AbstractList
extends Container
implements ListModel {
    private int selectedIndex;
    private StaticImageModel cursorImageRef;
    private static boolean listSelectionEnabled = false;

    @Override
    protected void reset() {
        super.reset();
        this.cursorImageRef = null;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, StaticImageModel staticImageModel, boolean bl4, EasingParams[] easingParamsArray, boolean bl5, int n2, boolean bl6, KeyframeAnimation[] keyframeAnimationArray, boolean bl7, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl8, int n5, int n6, Insets insets, boolean bl9, int n7, int n8, int n9) {
        super.init(bl, n, image, bl2, bl3, easingParamsArray, bl5, n2, keyframeAnimationArray, bl7, layoutAttribs, string, n3, image2, n4, bl8, n6, insets, bl9, n7, n8, n9);
        this.selectedIndex = n5;
        this.cursorImageRef = staticImageModel;
        this.setInternalStateFlag(18, bl4);
        this.setInternalStateFlag(19, bl6);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, StaticImageModel staticImageModel, boolean bl4, EasingParams[] easingParamsArray, boolean bl5, int n2, boolean bl6, KeyframeAnimation[] keyframeAnimationArray, boolean bl7, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl8, int n5, boolean bl9, int n6, Insets insets, boolean bl10, int n7, int n8, int n9) {
        this.init(bl, n, image, bl2, bl3, staticImageModel, bl4, easingParamsArray, bl5, n2, bl6, keyframeAnimationArray, bl7, layoutAttribs, string, n3, image2, n4, bl8, n5, n6, insets, bl10, n7, n8, n9);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.updateCursor();
    }

    @Override
    public final int get_selectedIndex() {
        return this.selectedIndex;
    }

    @Override
    public final void set_selectedIndex(int n) {
        int n2 = this.selectedIndex;
        if (n2 != n) {
            this.selectedIndex = n;
            this.selectedIndexChanged(n2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final StaticImageModel get_cursorImageRef() {
        return this.cursorImageRef;
    }

    @Override
    public final void set_cursorImageRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.cursorImageRef;
        if (staticImageModel2 != staticImageModel) {
            this.cursorImageRef = staticImageModel;
            this.cursorImageRefChanged(staticImageModel2);
            this.propertyChanged(24);
        }
    }

    @Override
    public final boolean is_cyclicScrolling() {
        return this.getInternalStateFlag(18);
    }

    @Override
    public final void set_cyclicScrolling(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(18);
        if (bl2 != bl) {
            this.setInternalStateFlag(18, bl);
            this.cyclicScrollingChanged(bl2);
            this.propertyChanged(25);
        }
    }

    @Override
    public final boolean is_interactive() {
        return this.getInternalStateFlag(19);
    }

    @Override
    public final void set_interactive(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(19);
        if (bl2 != bl) {
            this.setInternalStateFlag(19, bl);
            this.interactiveChanged(bl2);
            this.propertyChanged(26);
        }
    }

    public static final void disableListSelection() {
        listSelectionEnabled = false;
    }

    public static final void enableListSelection() {
        listSelectionEnabled = true;
    }

    public static final boolean isListSelectionEnabled() {
        return listSelectionEnabled;
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        super.propertyChanged(widgetModel, n);
        int n2 = this.indexOf(this.getChildren(), widgetModel);
        if (n2 == -1) {
            return;
        }
        if (4 == n) {
            this.childEnabledStateChanged(n2, widgetModel.is_enabled(), true);
        } else if (5 == n) {
            this.childVisibleStateChanged(n2, widgetModel.is_visible(), true);
        }
    }

    public void isSingleActivationChanged(boolean bl) {
    }

    protected void childEnabledStateChanged(int n, boolean bl, boolean bl2) {
        ListController listController;
        if (!bl && bl2 && (listController = (ListController)this.getController()) != null) {
            listController.revalidateSelectedIndex();
        }
    }

    protected void childVisibleStateChanged(int n, boolean bl, boolean bl2) {
        this.childEnabledStateChanged(n, bl, bl2);
    }

    protected void childSelectionStateChanged(int n, boolean bl, boolean bl2) {
        if (bl && !bl2) {
            this.set_selectedIndex(n);
        }
    }

    protected void selectedIndexChanged(int n) {
        WidgetModel widgetModel;
        int n2;
        WidgetModel widgetModel2;
        if (n >= 0 && n < this.getChildCount() && (widgetModel2 = this.getChildren()[n]) != null && widgetModel2 instanceof ButtonModel) {
            ((ButtonModel)widgetModel2).set_selected(false);
        }
        if ((n2 = this.get_selectedIndex()) >= 0 && n2 < this.getChildCount() && (widgetModel = this.getChildren()[n2]) != null && widgetModel instanceof ButtonModel) {
            ((ButtonModel)widgetModel).set_selected(true);
        }
        this.updateCursor();
    }

    protected void cursorImageRefChanged(Object object) {
    }

    protected void cyclicScrollingChanged(boolean bl) {
    }

    protected void interactiveChanged(boolean bl) {
    }

    protected int indexOf(WidgetModel[] widgetModelArray, WidgetModel widgetModel) {
        int n = -1;
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            if (widgetModelArray[i2] != widgetModel) continue;
            n = i2;
            break;
        }
        return n;
    }

    protected abstract void updateCursor() {
    }
}

