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
import de.vw.mib.widgets.Container;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public abstract class AbstractButton
extends Container
implements AbstractButtonModel {
    private static final int DEFAULT_STATE_INDEX;
    private Image[] imagesBackground;
    private Color[] colorsBackground;
    private StaticImageModel imageBackgroundRef;
    private Image[] imagesForeground;
    private Color[] colorsForeground;
    private StaticImageModel imageForegroundRef;
    private int state;
    private Color[] glowColors;
    private EasingParams[] easingStates;
    protected boolean delayedPressedRequested;
    protected boolean delayedReleasedRequested;

    @Override
    protected void reset() {
        super.reset();
        this.imagesBackground = null;
        this.colorsBackground = null;
        this.imageBackgroundRef = null;
        this.imagesForeground = null;
        this.colorsForeground = null;
        this.imageForegroundRef = null;
        this.glowColors = null;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, Color[] colorArray3, int n2, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl7, boolean bl8, int n5, int n6, Insets insets, boolean bl9, int n7, int n8, int n9) {
        super.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, n2, keyframeAnimationArray, bl6, layoutAttribs, string, n3, image2, n4, bl7, n6, insets, bl9, n7, n8, n9);
        this.imagesBackground = imageArray;
        this.colorsBackground = colorArray;
        this.imageBackgroundRef = staticImageModel;
        this.imagesForeground = imageArray2;
        this.colorsForeground = colorArray2;
        this.imageForegroundRef = staticImageModel2;
        this.state = n5;
        this.glowColors = colorArray3;
        this.easingStates = easingParamsArray2;
        this.setInternalStateFlag(18, bl5);
        this.setInternalStateFlag(20, bl8);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, Color[] colorArray3, int n2, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string, int n3, Image image2, int n4, boolean bl7, boolean bl8, boolean bl9, int n5, int n6, Insets insets, boolean bl10, int n7, int n8, int n9) {
        this.init(bl, n, image, bl2, bl3, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, colorArray3, n2, staticImageModel, staticImageModel2, imageArray, imageArray2, bl5, keyframeAnimationArray, bl6, layoutAttribs, string, n3, image2, n4, bl7, bl8, n5, n6, insets, bl10, n7, n8, n9);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.disableAnimations();
        this.updateState();
        this.updateImages();
        this.updateGlows();
        this.enableAnimations();
    }

    @Override
    public void deInit() {
        this.setInternalStateFlag(19, false);
        super.deInit();
    }

    @Override
    public final boolean is_interactive() {
        if (this.getView() == null || !this.getView().is_activated()) {
            return true;
        }
        return this.getInternalStateFlag(18);
    }

    @Override
    public final void set_interactive(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(18);
        if (bl2 != bl) {
            this.setInternalStateFlag(18, bl);
            this.interactiveChanged(bl2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final boolean is_selected() {
        return this.getInternalStateFlag(20);
    }

    @Override
    public final void set_selected(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(20);
        if (bl2 != bl) {
            this.setInternalStateFlag(20, bl);
            this.selectedChanged(bl2);
            this.propertyChanged(24);
        }
    }

    @Override
    public final Image[] get_imagesBackground() {
        return this.imagesBackground;
    }

    @Override
    public final void set_imagesBackground(Image[] imageArray) {
        Object[] objectArray = this.imagesBackground;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesBackground = imageArray;
            this.imagesBackgroundChanged((Image[])objectArray);
            this.propertyChanged(25);
        }
    }

    @Override
    public Color[] get_colorsBackground() {
        return this.colorsBackground;
    }

    @Override
    public void set_colorsBackground(Color[] colorArray) {
        Object[] objectArray = this.colorsBackground;
        if (!Arrays.equals(colorArray, objectArray)) {
            this.colorsBackground = colorArray;
            this.colorsBackgroundChanged((Color[])objectArray);
            this.propertyChanged(26);
        }
    }

    @Override
    public final StaticImageModel get_imageBackgroundRef() {
        return this.imageBackgroundRef;
    }

    @Override
    public final void set_imageBackgroundRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.imageBackgroundRef;
        if (staticImageModel2 != staticImageModel) {
            this.imageBackgroundRef = staticImageModel;
            this.imageBackgroundRefChanged(staticImageModel2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final Image[] get_imagesForeground() {
        return this.imagesForeground;
    }

    @Override
    public final void set_imagesForeground(Image[] imageArray) {
        Object[] objectArray = this.imagesForeground;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesForeground = imageArray;
            this.imagesForegroundChanged((Image[])objectArray);
            this.propertyChanged(28);
        }
    }

    @Override
    public Color[] get_colorsForeground() {
        return this.colorsForeground;
    }

    @Override
    public void set_colorsForeground(Color[] colorArray) {
        Object[] objectArray = this.colorsForeground;
        if (!Arrays.equals(colorArray, objectArray)) {
            this.colorsForeground = colorArray;
            this.colorsForegroundChanged((Color[])objectArray);
            this.propertyChanged(29);
        }
    }

    @Override
    public final StaticImageModel get_imageForegroundRef() {
        return this.imageForegroundRef;
    }

    @Override
    public final void set_imageForegroundRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.imageForegroundRef;
        if (staticImageModel2 != staticImageModel) {
            this.imageForegroundRef = staticImageModel;
            this.imageForegroundRefChanged(staticImageModel2);
            this.propertyChanged(30);
        }
    }

    @Override
    public final int get_state() {
        return this.state;
    }

    @Override
    public final void set_state(int n) {
        int n2 = this.state;
        if (n2 != n) {
            this.state = n;
            this.stateChanged(n2);
            this.propertyChanged(31);
        }
    }

    @Override
    public final Color[] get_glowColors() {
        return this.glowColors;
    }

    @Override
    public final void set_glowColors(Color[] colorArray) {
        Object[] objectArray = this.glowColors;
        if (!Arrays.equals(colorArray, objectArray)) {
            this.glowColors = colorArray;
            this.glowColorsChanged((Color[])objectArray);
            this.propertyChanged(33);
        }
    }

    @Override
    public final EasingParams[] get_easingStates() {
        return this.easingStates;
    }

    @Override
    public final void set_easingStates(EasingParams[] easingParamsArray) {
        Object[] objectArray = this.easingStates;
        if (!Arrays.equals(easingParamsArray, objectArray)) {
            this.easingStates = easingParamsArray;
            this.easingStatesChanged((EasingParams[])objectArray);
            this.propertyChanged(34);
        }
    }

    @Override
    public final boolean isPressed() {
        return this.getInternalStateFlag(19);
    }

    @Override
    public final void setPressed(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(19);
        if (bl2 != bl) {
            this.setInternalStateFlag(19, bl);
            this.pressedChanged(bl2);
        }
    }

    @Override
    public boolean isActivatedInternal() {
        return this.is_activated();
    }

    @Override
    public void setActivatedInternal(boolean bl) {
        this.set_activated(bl);
    }

    @Override
    protected void activatedChanged(boolean bl) {
        super.activatedChanged(bl);
        this.updateState();
        this.repaint();
    }

    protected void easingStatesChanged(EasingParams[] easingParamsArray) {
    }

    @Override
    protected void enabledChanged(boolean bl) {
        super.enabledChanged(bl);
        if (!this.is_enabled()) {
            this.setPressed(false);
            this.set_selected(false);
        }
        this.updateState();
        this.repaint();
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        super.parentVisibilityChanged(bl);
        if (bl) {
            this.setPressed(false);
        }
    }

    @Override
    protected void visibleChanged(boolean bl) {
        super.visibleChanged(bl);
        if (!this.is_visible()) {
            this.setPressed(false);
            this.set_selected(false);
        }
    }

    protected void interactiveChanged(boolean bl) {
        this.updateState();
    }

    protected void pressedChanged(boolean bl) {
        this.updateState();
        this.updateGlows();
    }

    protected void updateGlows() {
        boolean bl = this.isPressed();
        int n = this.inferIndexFromState();
        Color[] colorArray = this.get_glowColors();
        Color color = colorArray != null && colorArray.length > n ? colorArray[n] : Color.WHITE;
        StaticImageModel staticImageModel = this.get_imageForegroundRef();
        StaticImageModel staticImageModel2 = this.get_imageBackgroundRef();
        if (bl) {
            if (staticImageModel != null) {
                staticImageModel.set_glowColor(color);
            }
            if (staticImageModel2 != null) {
                staticImageModel2.set_glowColor(color);
            }
        }
        if (staticImageModel != null) {
            staticImageModel.set_glowVisible(bl);
        }
        if (staticImageModel2 != null) {
            staticImageModel2.set_glowVisible(bl);
        }
    }

    protected void selectedChanged(boolean bl) {
        this.updateState();
    }

    protected void imagesBackgroundChanged(Image[] imageArray) {
        this.updateBackgroundImage();
    }

    protected void colorsBackgroundChanged(Color[] colorArray) {
        this.updateBackgroundImage();
    }

    protected void imageBackgroundRefChanged(StaticImageModel staticImageModel) {
        this.updateBackgroundImage();
    }

    protected void imagesForegroundChanged(Image[] imageArray) {
        this.updateForegroundImage();
    }

    protected void colorsForegroundChanged(Color[] colorArray) {
        this.updateForegroundImage();
    }

    protected void imageForegroundRefChanged(StaticImageModel staticImageModel) {
        this.updateForegroundImage();
    }

    protected void stateChanged(int n) {
        this.updateImages();
    }

    protected void speakableChanged(boolean bl) {
        this.updateState();
    }

    protected void glowColorsChanged(Color[] colorArray) {
    }

    @Override
    public void setDelayedPressed() {
        this.delayedPressedRequested = true;
    }

    @Override
    public void setDelayedReleased() {
        this.delayedReleasedRequested = true;
    }

    protected void updateImages() {
        this.updateForegroundImage();
        this.updateBackgroundImage();
    }

    protected void updateState() {
        this.set_state(this.inferIndexFromState());
    }

    protected void updateBackgroundImage() {
        if (this.imageBackgroundRef != null) {
            int n = this.inferIndexFromState();
            if (n != -1 && this.imagesBackground != null && this.imagesBackground.length > n) {
                if (null != this.easingStates && this.easingStates.length > n) {
                    this.imageBackgroundRef.setCrossfadeEasing(this.easingStates[n]);
                }
                this.imageBackgroundRef.set_image(this.imagesBackground[n]);
            } else {
                this.imageBackgroundRef.set_image(null);
            }
            if (n != -1 && this.colorsBackground != null && this.colorsBackground.length > n) {
                this.imageBackgroundRef.set_color(this.colorsBackground[n]);
            } else {
                this.imageBackgroundRef.set_color(Color.WHITE);
            }
        }
    }

    protected void updateForegroundImage() {
        if (this.imageForegroundRef != null) {
            int n = this.inferIndexFromState();
            if (n != -1 && this.imagesForeground != null && this.imagesForeground.length > n) {
                if (null != this.easingStates && this.easingStates.length > n) {
                    this.imageForegroundRef.setCrossfadeEasing(this.easingStates[n]);
                }
                this.imageForegroundRef.set_image(this.imagesForeground[n]);
            } else {
                this.imageForegroundRef.set_image(null);
            }
            if (n != -1 && this.colorsForeground != null && this.colorsForeground.length > n) {
                this.imageForegroundRef.set_color(this.colorsForeground[n]);
            } else {
                this.imageForegroundRef.set_color(Color.WHITE);
            }
        }
    }

    protected int getNumVisualStates() {
        return 18;
    }

    protected int inferIndexFromState() {
        int n = -1;
        boolean bl = this.is_enabled();
        boolean bl2 = this.isActivatedInternal();
        n = !bl ? (!this.is_interactive() ? (!bl2 ? 0 : 1) : (!bl2 ? 2 : 3)) : (!this.is_interactive() ? (!bl2 ? 4 : 5) : (!bl2 ? (!this.is_selected() ? (!this.isPressed() ? 6 : 7) : (!this.isPressed() ? 8 : 9)) : (!this.is_selected() ? (!this.isPressed() ? 10 : 11) : (!this.isPressed() ? 12 : 13))));
        if (n < 0) {
            throw new IllegalStateException("No suitable index could be derived from the current state");
        }
        return n;
    }

    protected int inferIndexFromStateNonSpeakable() {
        int n = this.inferIndexFromState();
        switch (n) {
            case 14: {
                n = 6;
                break;
            }
            case 15: {
                n = 8;
                break;
            }
            case 16: {
                n = 10;
                break;
            }
            case 17: {
                n = 12;
                break;
            }
        }
        return n;
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
    }
}

