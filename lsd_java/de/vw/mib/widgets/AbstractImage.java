/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.models.AbstractImageModel;
import de.vw.mib.widgets.models.ViewModel;

public abstract class AbstractImage
extends AbstractWidget
implements AbstractImageModel {
    private Color color;
    private Color blendColor;
    private int blendMode;
    private boolean colorEnabled;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, boolean bl5, String string, int n4, Insets insets, boolean bl6, int n5, int n6, int n7) {
        super.init(bl, n, bl2, easingParamsArray, bl4, n3, bl5, string, n4, insets, bl6, n5, n6, n7);
        this.blendMode = n2;
        this.blendColor = color;
        this.colorEnabled = bl3;
        this.color = color2;
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, int n4, boolean bl5, String string, int n5, Insets insets, boolean bl6, int n6, int n7, int n8) {
        this.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n4, bl5, string, n5, insets, bl6, n6, n7, n8);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
    }

    @Override
    public final int get_blendMode() {
        return this.blendMode;
    }

    @Override
    public final void set_blendMode(int n) {
        int n2 = this.blendMode;
        if (n2 != n) {
            this.blendMode = n;
            this.blendModeChanged(n2);
            this.propertyChanged(16);
        }
    }

    @Override
    public final Color get_blendColor() {
        return this.blendColor;
    }

    @Override
    public final void set_blendColor(Color color) {
        Color color2 = this.blendColor;
        if (color2 == null || !color2.equals(color)) {
            this.blendColor = color;
            this.blendColorChanged(color2);
            this.propertyChanged(18);
        }
    }

    @Override
    public final Color get_color() {
        return this.color;
    }

    @Override
    public final void set_color(Color color) {
        Color color2 = this.color;
        if (color2 == null || !color2.equals(color)) {
            this.color = color;
            this.colorChanged(color2);
            this.propertyChanged(17);
        }
    }

    @Override
    public final boolean is_colorEnabled() {
        return this.colorEnabled;
    }

    @Override
    public final void set_colorEnabled(boolean bl) {
        boolean bl2 = this.colorEnabled;
        if (bl2 != bl) {
            this.colorEnabled = bl;
            this.colorEnabledChanged(bl2);
            this.propertyChanged(19);
        }
    }

    protected void blendModeChanged(int n) {
        this.repaint();
    }

    protected void blendColorChanged(Color color) {
        this.repaint();
    }

    protected void colorChanged(Color color) {
        this.repaint();
    }

    protected void colorEnabledChanged(boolean bl) {
        this.repaint();
    }
}

