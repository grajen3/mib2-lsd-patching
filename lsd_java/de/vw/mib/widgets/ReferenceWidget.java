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
import de.vw.mib.widgets.ReferenceWidget$ViewActivationChangedListener;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.ReferenceWidgetModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;

public final class ReferenceWidget
extends Container
implements ReferenceWidgetModel {
    private WidgetModel referencedWidget;
    private PropertyChangedListener viewActivatedChangedListener;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ReferenceWidgetUI;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, boolean bl5, int n2, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl7, int n5, Insets insets, boolean bl8, int n6, int n7, int n8) {
        super.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, n2, keyframeAnimationArray, bl6, layoutAttribs, string, n3, image2, n4, bl7, n5, insets, bl8, n6, n7, n8);
        this.setInternalStateFlag(19, bl5);
    }

    @Override
    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n2, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl6, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        super.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, n2, keyframeAnimationArray, bl5, layoutAttribs, string, n3, image2, n4, bl6, n5, insets, bl7, n6, n7, n8);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        WidgetModel[] widgetModelArray = this.getChildren();
        if (widgetModelArray != null && widgetModelArray.length > 0) {
            WidgetModel widgetModel = widgetModelArray[0];
            if (widgetModel.get_x() != 0 || widgetModel.get_y() != 0) {
                widgetModel.set_x(0);
                widgetModel.set_y(0);
            }
            if (this.is_forwardViewActivation()) {
                this.enableViewActivationChangedListener();
            }
        } else if (this.referencedWidget != null && this.is_forwardViewActivation()) {
            this.enableViewActivationChangedListener();
        }
    }

    @Override
    public void deInit() {
        super.deInit();
        if (this.viewActivatedChangedListener != null) {
            this.disableViewActivatedChangedListner();
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ReferenceWidgetUI == null ? (class$de$vw$mib$widgets$ui$ReferenceWidgetUI = ReferenceWidget.class$("de.vw.mib.widgets.ui.ReferenceWidgetUI")) : class$de$vw$mib$widgets$ui$ReferenceWidgetUI};
    }

    @Override
    public void set_forwardViewActivation(boolean bl) {
        boolean bl2 = this.is_forwardViewActivation();
        if (bl2 != bl) {
            this.setInternalStateFlag(19, bl);
            this.forwardViewActivationChanged(bl2);
            this.propertyChanged(24);
        }
    }

    @Override
    public boolean is_forwardViewActivation() {
        return this.getInternalStateFlag(19);
    }

    @Override
    public WidgetModel getReferencedWidget() {
        return this.referencedWidget;
    }

    @Override
    public void setReferencedWidget(WidgetModel widgetModel) {
        this.referencedWidget = widgetModel;
    }

    private WidgetModel getReferencedWidgetInternal() {
        WidgetModel[] widgetModelArray = this.getChildren();
        if (widgetModelArray != null && widgetModelArray.length > 0) {
            return widgetModelArray[0];
        }
        return this.referencedWidget;
    }

    protected void forwardViewActivationChanged(boolean bl) {
        if (!bl) {
            this.enableViewActivationChangedListener();
        } else {
            this.disableViewActivatedChangedListner();
        }
    }

    private void enableViewActivationChangedListener() {
        ViewModel viewModel = this.getView();
        if (viewModel != null) {
            this.viewActivatedChangedListener = new ReferenceWidget$ViewActivationChangedListener(this);
            viewModel.addPropertyChangedListener(this.viewActivatedChangedListener);
            this.forwardActivationState(viewModel.is_activated());
        }
    }

    private void disableViewActivatedChangedListner() {
        ViewModel viewModel;
        if (this.viewActivatedChangedListener != null && (viewModel = this.getView()) != null) {
            viewModel.removePropertyChangedListener(this.viewActivatedChangedListener);
            this.viewActivatedChangedListener = null;
        }
    }

    protected void forwardActivationState(boolean bl) {
        WidgetModel widgetModel = this.getReferencedWidgetInternal();
        if (widgetModel != null) {
            widgetModel.disablePropertyChanged();
            widgetModel.set_activated(bl);
            widgetModel.enablePropertyChanged();
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

