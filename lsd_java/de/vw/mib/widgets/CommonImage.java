/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.AbstractImage;
import de.vw.mib.widgets.models.CommonImageModel;
import de.vw.mib.widgets.models.ViewModel;

public class CommonImage
extends AbstractImage
implements CommonImageModel {
    private String imageFile;
    private int imageType;
    private int scaleMode;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$CommonImageUI;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, String string, int n4, boolean bl5, String string2, int n5, int n6, Insets insets, boolean bl6, int n7, int n8, int n9) {
        super.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, bl5, string2, n6, insets, bl6, n7, n8, n9);
        this.imageFile = string;
        this.imageType = n4;
        this.scaleMode = n5;
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, String string, int n4, boolean bl5, String string2, int n5, Insets insets, boolean bl6, int n6, int n7, int n8) {
        this.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, string, n4, bl5, string2, n4 == 1 ? 0 : 1, n5, insets, bl6, n6, n7, n8);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$CommonImageUI == null ? (class$de$vw$mib$widgets$ui$CommonImageUI = CommonImage.class$("de.vw.mib.widgets.ui.CommonImageUI")) : class$de$vw$mib$widgets$ui$CommonImageUI};
    }

    @Override
    public final void set_imageFile(String string) {
        String string2 = this.imageFile;
        if (string2 == null || !string2.equals(string)) {
            this.imageFile = string;
            this.imageFileChanged(string2);
            this.propertyChanged(21);
        }
    }

    @Override
    public final String get_imageFile() {
        return this.imageFile;
    }

    @Override
    public void set_imageType(int n) {
        int n2 = this.imageType;
        if (n2 != n) {
            this.imageType = n;
            this.imageTypeChanged(n2);
            this.propertyChanged(22);
        }
    }

    @Override
    public int get_imageType() {
        return this.imageType;
    }

    @Override
    public int get_scaleMode() {
        return this.scaleMode;
    }

    @Override
    public void set_scaleMode(int n) {
        int n2 = this.scaleMode;
        if (n2 != n) {
            this.scaleMode = n;
            this.scaleModeChanged(n2);
            this.propertyChanged(23);
        }
    }

    protected void imageFileChanged(String string) {
        this.repaint();
    }

    protected void imageTypeChanged(int n) {
        this.repaint();
    }

    protected void scaleModeChanged(int n) {
        this.repaint();
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

