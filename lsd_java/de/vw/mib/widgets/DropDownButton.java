/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.Button;
import de.vw.mib.widgets.controller.DropDownButtonController;
import de.vw.mib.widgets.interfaces.Focusable;
import de.vw.mib.widgets.models.DropDownButtonModel;
import de.vw.mib.widgets.models.DropDownModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.PushUpModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ViewModel;

public class DropDownButton
extends Button
implements DropDownButtonModel,
Focusable {
    private boolean[] dropDownExistenceFlags;
    private DropDownModel dropDownRef;
    private InactiveAreaModel inactiveAreaRef;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$DropDownButtonUI;

    @Override
    protected void reset() {
        super.reset();
        this.dropDownRef = null;
        this.inactiveAreaRef = null;
        this.dropDownExistenceFlags = null;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, Color[] colorArray, Color[] colorArray2, boolean[] blArray, DropDownModel dropDownModel, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, String string, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, Image[] imageArray4, Color[] colorArray4, StaticImageModel staticImageModel3, StaticImageModel staticImageModel4, InactiveAreaModel inactiveAreaModel, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string2, boolean bl7, boolean bl8, int n4, Image image2, int n5, boolean bl9, int n6, int n7, boolean bl10, int n8, int n9, int n10, int n11, TextAreaModel[] textAreaModelArray, TextAreaModel[] textAreaModelArray2, Color[] colorArray5, Color[] colorArray6, Insets insets, Point[] pointArray, boolean bl11, int n12, int n13, int n14) {
        super.init(bl, n, image, bl2, bl3, n2, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, string, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, imageArray3, imageArray4, colorArray4, staticImageModel3, staticImageModel4, bl5, keyframeAnimationArray, bl6, layoutAttribs, string2, bl8, n4, image2, n5, bl9, n6, n7, bl10, n8, n9, n10, n11, textAreaModelArray, textAreaModelArray2, colorArray5, colorArray6, insets, pointArray, bl11, n12, n13, n14);
        this.dropDownRef = dropDownModel;
        this.inactiveAreaRef = inactiveAreaModel;
        this.dropDownExistenceFlags = blArray;
        this.setInternalStateFlag(24, bl7);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, Color[] colorArray, Color[] colorArray2, boolean[] blArray, DropDownModel dropDownModel, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, String string, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, Image[] imageArray4, Color[] colorArray4, StaticImageModel staticImageModel3, StaticImageModel staticImageModel4, InactiveAreaModel inactiveAreaModel, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string2, boolean bl7, boolean bl8, int n4, Image image2, int n5, boolean bl9, int n6, int n7, boolean bl10, boolean bl11, int n8, int n9, int n10, int n11, int n12, int n13, TextAreaModel[] textAreaModelArray, TextAreaModel[] textAreaModelArray2, Color[] colorArray5, Color[] colorArray6, Insets insets, Point[] pointArray, boolean bl12, int n14, int n15, int n16) {
        this.init(bl, n, image, bl2, bl3, n2, colorArray, colorArray2, blArray, dropDownModel, easingParamsArray, easingParamsArray2, bl4, string, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, imageArray3, imageArray4, colorArray4, staticImageModel3, staticImageModel4, inactiveAreaModel, bl5, keyframeAnimationArray, bl6, layoutAttribs, string2, bl7, bl8, n4, image2, n5, bl9, n6, n7, bl10, n10, n11, n12, n13, textAreaModelArray, textAreaModelArray2, colorArray5, colorArray6, insets, pointArray, bl12, n14, n15, n16);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$DropDownButtonUI == null ? (class$de$vw$mib$widgets$ui$DropDownButtonUI = DropDownButton.class$("de.vw.mib.widgets.ui.DropDownButtonUI")) : class$de$vw$mib$widgets$ui$DropDownButtonUI};
    }

    @Override
    public final DropDownModel get_dropDownRef() {
        return this.dropDownRef;
    }

    @Override
    public final void set_dropDownRef(DropDownModel dropDownModel) {
        DropDownModel dropDownModel2 = this.dropDownRef;
        if (dropDownModel2 != dropDownModel) {
            this.dropDownRef = dropDownModel;
            this.dropDownRefChanged(dropDownModel2);
            this.propertyChanged(54);
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
            this.propertyChanged(56);
        }
    }

    @Override
    public final boolean[] get_dropDownExistenceFlags() {
        return this.dropDownExistenceFlags;
    }

    @Override
    public final void set_dropDownExistenceFlags(boolean[] blArray) {
        boolean[] blArray2 = this.dropDownExistenceFlags;
        if (blArray2 != blArray) {
            this.dropDownExistenceFlags = blArray;
            this.dropDownExistenceFlagsChanged(blArray2);
            this.propertyChanged(55);
        }
    }

    @Override
    public final boolean is_openDropDown() {
        return this.getInternalStateFlag(24);
    }

    @Override
    public final void set_openDropDown(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(24);
        if (bl2 != bl) {
            this.setInternalStateFlag(24, bl);
            this.openDropDownChanged(bl2);
            this.propertyChanged(57);
        }
    }

    @Override
    public void paintFocused(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        if (this.isPaintable()) {
            this.paint(graphics3D, viewModel, rectangle, rectangle2, f2);
        }
    }

    @Override
    protected void enabledChanged(boolean bl) {
        DropDownButtonController dropDownButtonController;
        super.enabledChanged(bl);
        if (bl && (dropDownButtonController = (DropDownButtonController)this.getController()) != null) {
            dropDownButtonController.fire_closeDropDown();
        }
    }

    protected void dropDownRefChanged(PushUpModel pushUpModel) {
    }

    protected void inactiveAreaRefChanged(InactiveAreaModel inactiveAreaModel) {
    }

    protected void dropDownExistenceFlagsChanged(boolean[] blArray) {
    }

    protected void openDropDownChanged(boolean bl) {
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

