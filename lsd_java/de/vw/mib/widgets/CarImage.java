/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.CommonImage;
import de.vw.mib.widgets.models.CarImageModel;
import de.vw.mib.widgets.models.ViewModel;

public final class CarImage
extends CommonImage
implements CarImageModel {
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$CarImageUI;

    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, String string, int n4, boolean bl5, String string2, int n5, int n6, Insets insets, boolean bl6, int n7, int n8, int n9) {
        super.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, string, n4, bl5, string2, n5, n6, insets, bl6, n7, n8, n9);
    }

    @Override
    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, String string, int n4, boolean bl5, String string2, int n5, Insets insets, boolean bl6, int n6, int n7, int n8) {
        super.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, string, n4, bl5, string2, n5, insets, bl6, n6, n7, n8);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$CarImageUI == null ? (class$de$vw$mib$widgets$ui$CarImageUI = CarImage.class$("de.vw.mib.widgets.ui.CarImageUI")) : class$de$vw$mib$widgets$ui$CarImageUI};
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

