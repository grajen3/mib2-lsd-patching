/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractList;
import de.vw.mib.widgets.Container;
import de.vw.mib.widgets.PopupView;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.layout.Layoutable;
import de.vw.mib.widgets.models.SpeechIndicatorModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class SpeechIndicator
extends Container
implements SpeechIndicatorModel,
PropertyChangedListener,
Layoutable {
    private Image[] indicatorImages;
    private int recognizerState;
    private int remainingRecognitionTime;
    private Color recognizerActiveColor;
    private Color recognizerInactiveColor;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$SpeechIndicatorUI;

    @Override
    protected void reset() {
        super.reset();
        this.indicatorImages = null;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n2, Image[] imageArray, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, Color color, Color color2, int n3, int n4, Image image2, int n5, boolean bl6, int n6, int n7, Insets insets, boolean bl7, int n8, int n9, int n10) {
        super.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, n2, keyframeAnimationArray, bl5, layoutAttribs, string, n4, image2, n5, bl6, n7, insets, bl7, n8, n9, n10);
        this.indicatorImages = imageArray;
        this.recognizerActiveColor = color;
        this.recognizerInactiveColor = color2;
        this.recognizerState = n3;
        this.remainingRecognitionTime = n6;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_indicatorImages());
        if (viewModel instanceof PopupView) {
            PopupView popupView = (PopupView)viewModel;
            Rectangle rectangle = popupView.get_visibleArea();
            this.set_x(rectangle.x);
            this.set_y(rectangle.y);
            this.set_width(rectangle.width);
            this.set_height(rectangle.height);
        }
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$SpeechIndicatorUI == null ? (class$de$vw$mib$widgets$ui$SpeechIndicatorUI = SpeechIndicator.class$("de.vw.mib.widgets.ui.SpeechIndicatorUI")) : class$de$vw$mib$widgets$ui$SpeechIndicatorUI};
    }

    @Override
    public final Image[] get_indicatorImages() {
        return this.indicatorImages;
    }

    @Override
    public final void set_indicatorImages(Image[] imageArray) {
        Object[] objectArray = this.indicatorImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.indicatorImages = imageArray;
            this.indicatorImagesChanged((Image[])objectArray);
            this.propertyChanged(23);
        }
    }

    @Override
    public final int get_recognizerState() {
        return this.recognizerState;
    }

    @Override
    public final Color get_recognizerActiveColor() {
        return this.recognizerActiveColor;
    }

    @Override
    public final Color get_recognizerInactiveColor() {
        return this.recognizerInactiveColor;
    }

    @Override
    public final int get_remainingRecognitionTime() {
        return this.remainingRecognitionTime;
    }

    @Override
    public final void set_recognizerActiveColor(Color color) {
        Color color2 = this.recognizerActiveColor;
        if (color2 == null || !color2.equals(color)) {
            this.recognizerActiveColor = color;
            this.recognizerActiveColorChanged(color2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final void set_recognizerInactiveColor(Color color) {
        Color color2 = this.recognizerInactiveColor;
        if (color2 == null || !color2.equals(color)) {
            this.recognizerInactiveColor = color;
            this.recognizerInactiveColorChanged(color2);
            this.propertyChanged(28);
        }
    }

    @Override
    public final void set_recognizerState(int n) {
        int n2 = this.recognizerState;
        if (n2 != n) {
            this.recognizerState = n;
            this.recognizerStateChanged(n2);
            this.propertyChanged(24);
        }
    }

    @Override
    public final void set_remainingRecognitionTime(int n) {
        int n2 = this.remainingRecognitionTime;
        if (n2 != n) {
            this.remainingRecognitionTime = n;
            this.remainingRecognitionTimeChanged(n2);
            this.propertyChanged(26);
        }
    }

    protected void indicatorImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_indicatorImages());
        this.updateIndicatorImages();
        this.repaint();
    }

    protected void recognizerActiveColorChanged(Color color) {
        this.updateIndicatorImages();
        this.repaint();
    }

    protected void recognizerInactiveColorChanged(Color color) {
        this.updateIndicatorImages();
        this.repaint();
    }

    protected void remainingRecognitionTimeChanged(int n) {
        this.updateIndicatorImages();
        this.repaint();
    }

    protected void recognizerStateChanged(int n) {
        if (this.get_recognizerState() == 0 && AbstractList.isListSelectionEnabled()) {
            AbstractList.disableListSelection();
        }
        this.updateIndicatorImages();
        this.repaint();
    }

    protected void updateIndicatorImages() {
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

