/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.Animation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Gradient;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.AbstractImage;
import de.vw.mib.widgets.StaticImage$CrossfadingAnimation;
import de.vw.mib.widgets.StaticImage$GlowAnimation;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class StaticImage
extends AbstractImage
implements StaticImageModel {
    private Image image;
    private Image previousImage;
    private float blendAlpha;
    private StaticImage$CrossfadingAnimation crossfadingAnimation;
    private EasingParams crossfadeEasing;
    private int glowType;
    private Gradient gradient;
    private Color[] gradientColors;
    protected float glowAlpha;
    private Color glowColor;
    protected StaticImage$GlowAnimation glowAnimation;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$StaticImageUI;

    @Override
    protected void reset() {
        super.reset();
        this.image = null;
        this.previousImage = null;
        this.crossfadeEasing = null;
        this.setInternalStateFlag(9, false);
        this.glowAlpha = 0.0f;
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Color color3, int n3, boolean bl5, Gradient gradient, Color[] colorArray, int n4, Image image, boolean bl6, String string, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        super.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n4, bl6, string, n5, insets, bl7, n6, n7, n8);
        this.image = image;
        this.glowType = n3;
        this.glowColor = color3;
        this.gradient = gradient;
        this.gradientColors = colorArray;
        this.setInternalStateFlag(9, bl5);
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Color color3, int n3, boolean bl5, Color[] colorArray, int n4, Image image, boolean bl6, String string, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        this.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, color3, n3, bl5, new Gradient(), colorArray, n4, image, bl6, string, n5, insets, bl7, n6, n7, n8);
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, Color color3, int n3, boolean bl5, int n4, Image image, boolean bl6, String string, int n5, Insets insets, boolean bl7, int n6, int n7, int n8) {
        this.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, color3, n3, bl5, new Color[0], n4, image, bl6, string, n5, insets, bl7, n6, n7, n8);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.image);
    }

    @Override
    public void deInit() {
        this.setInternalStateFlag(9, false);
        this.glowAlpha = 0.0f;
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$StaticImageUI == null ? (class$de$vw$mib$widgets$ui$StaticImageUI = StaticImage.class$("de.vw.mib.widgets.ui.StaticImageUI")) : class$de$vw$mib$widgets$ui$StaticImageUI};
    }

    @Override
    public final Image get_image() {
        return this.image;
    }

    @Override
    public final void set_image(Image image) {
        Image image2 = this.image;
        if (image2 == null || !image2.equals(image)) {
            this.image = image;
            this.imageChanged(image2);
            this.propertyChanged(20);
        }
    }

    @Override
    public Gradient get_gradient() {
        return this.gradient;
    }

    @Override
    public void set_gradient(Gradient gradient) {
        Gradient gradient2 = this.gradient;
        if (gradient2 == null || !gradient2.equals(gradient)) {
            this.gradient = gradient;
            this.gradientChanged(gradient2);
            this.propertyChanged(24);
        }
    }

    @Override
    public Color[] get_gradientColors() {
        return this.gradientColors;
    }

    @Override
    public void set_gradientColors(Color[] colorArray) {
        Object[] objectArray = this.gradientColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.gradientColors = colorArray;
            this.gradientColorsChanged((Color[])objectArray);
            this.propertyChanged(25);
        }
    }

    @Override
    public final Color get_glowColor() {
        return this.glowColor;
    }

    @Override
    public final void set_glowColor(Color color) {
        Color color2 = this.glowColor;
        if (color2 == null || !color2.equals(color)) {
            this.glowColor = color;
            this.glowColorChanged(color2);
            this.propertyChanged(22);
        }
    }

    @Override
    public int get_glowType() {
        return this.glowType;
    }

    @Override
    public void set_glowType(int n) {
        int n2 = this.glowType;
        if (n2 != n) {
            this.glowType = n;
            this.glowTypeChanged(n2);
            this.propertyChanged(21);
        }
    }

    @Override
    public boolean is_glowVisible() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public void set_glowVisible(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(9);
        if (bl2 != bl) {
            this.setInternalStateFlag(9, bl);
            this.glowVisibleChanged(bl2);
            this.propertyChanged(23);
        }
    }

    @Override
    public void setCrossfadeEasing(EasingParams easingParams) {
        this.crossfadeEasing = easingParams;
    }

    @Override
    public Image getPreviousImage() {
        return this.previousImage;
    }

    protected void setPreviousImage(Image image) {
        this.previousImage = image;
    }

    @Override
    public float getGlowAlpha() {
        return this.glowAlpha;
    }

    protected void setGlowAlpha(float f2) {
        if (!Util.equalsEpsilon(this.glowAlpha, f2)) {
            this.glowAlpha = f2;
            this.repaintParent();
        }
    }

    @Override
    public float getBlendAlpha() {
        return this.blendAlpha;
    }

    protected void setBlendAlpha(float f2) {
        if (!Util.equalsEpsilon(this.blendAlpha, f2)) {
            this.blendAlpha = f2;
            this.repaint();
        }
    }

    protected void imageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_image());
        if (!this.startCrossfadingAnimation(image)) {
            this.setPreviousImage(null);
            this.repaint();
        }
    }

    @Override
    protected void xChanged(int n) {
        if (this.gradient != null && this.gradient.getGradientType() != 0 && this.gradient.getCenterPositionType() == 2) {
            this.repaint();
        }
        super.xChanged(n);
    }

    @Override
    protected void yChanged(int n) {
        if (this.gradient != null && this.gradient.getGradientType() != 0 && this.gradient.getCenterPositionType() == 2) {
            this.repaint();
        }
        super.yChanged(n);
    }

    @Override
    protected void widthChanged(int n) {
        if (this.gradient != null && this.gradient.getGradientType() != 0 && this.gradient.getCenterPositionType() == 2) {
            this.repaint();
        }
        super.widthChanged(n);
    }

    @Override
    protected void heightChanged(int n) {
        if (this.gradient != null && this.gradient.getGradientType() != 0 && this.gradient.getCenterPositionType() == 2) {
            this.repaint();
        }
        super.heightChanged(n);
    }

    protected void gradientChanged(Gradient gradient) {
        this.repaint();
    }

    protected void gradientColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    protected void glowTypeChanged(int n) {
    }

    protected void glowColorChanged(Color color) {
        this.repaintParent();
    }

    protected void glowVisibleChanged(boolean bl) {
        if (this.glowType != 0) {
            if (!this.startGlowAnimation()) {
                this.glowAlpha = !bl ? 1.0f : 0.0f;
            }
            this.repaintParent();
        }
    }

    private boolean startCrossfadingAnimation(Image image) {
        EasingParams easingParams;
        this.stopCrossfadingAnimation();
        if (this.crossfadeEasing == null) {
            easingParams = this.getEasing(7);
        } else {
            EasingParams easingParams2 = easingParams = this.areAnimationsEnabled() && StaticImage.isEasingValid(this.crossfadeEasing) ? this.crossfadeEasing : null;
        }
        if (image == null || easingParams == null) {
            return false;
        }
        this.setPreviousImage(image);
        this.crossfadingAnimation = new StaticImage$CrossfadingAnimation(this, easingParams, this);
        return this.startInternalAnimation(this.crossfadingAnimation);
    }

    private boolean startGlowAnimation() {
        this.stopGlowAnimation();
        boolean bl = this.is_glowVisible();
        EasingParams easingParams = this.getEasing(bl ? 8 : 9);
        if (easingParams == null) {
            return false;
        }
        float f2 = this.glowAlpha;
        float f3 = bl ? 1.0f - f2 : -this.glowAlpha;
        this.glowAnimation = new StaticImage$GlowAnimation(this, easingParams, f2, f3);
        return this.startInternalAnimation(this.glowAnimation);
    }

    private void stopGlowAnimation() {
        if (this.glowAnimation != null) {
            this.stopInternalAnimation(this.glowAnimation);
            this.glowAnimation = null;
        }
    }

    private void stopCrossfadingAnimation() {
        if (this.crossfadingAnimation != null) {
            this.stopInternalAnimation(this.crossfadingAnimation);
            this.crossfadingAnimation = null;
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopGlowAnimation();
        this.stopCrossfadingAnimation();
    }

    public void animationRunning(Animation animation) {
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

