/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.Container;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.BackgroundContainerModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public abstract class AbstractBackgroundContainer
extends Container
implements BackgroundContainerModel {
    private Image[] compositeBackgroundImages;
    private Color[] compositeBackgroundColors;
    private int compositeBackgroundMode;
    private int compositeBackgroundArrowOffsetX;
    private int compositeBackgroundArrowOffsetY;
    private int flyingWindowMode;
    private Image[] flyingWindowImages;
    private int[] flyingWindowArrowsOffsetX;
    private int[] flyingWindowArrowsOffsetY;
    private Point arrowPosition;
    private Rectangle arrowDestinationArea;
    private Rectangle backgroundArea;

    @Override
    protected void reset() {
        super.reset();
        this.arrowPosition = new Point();
        this.arrowDestinationArea = new Rectangle();
        this.backgroundArea = new Rectangle();
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, Color[] colorArray, Image[] imageArray, int n4, EasingParams[] easingParamsArray, boolean bl4, int[] nArray, int[] nArray2, Image[] imageArray2, int n5, int n6, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n7, Image image2, int n8, boolean bl6, int n9, Insets insets, boolean bl7, int n10, int n11, int n12) {
        super.init(bl, n, image, bl2, bl3, easingParamsArray, bl4, n6, keyframeAnimationArray, bl5, layoutAttribs, string, n7, image2, n8, bl6, n9, insets, bl7, n10, n11, n12);
        this.compositeBackgroundArrowOffsetX = n2;
        this.compositeBackgroundArrowOffsetY = n3;
        this.compositeBackgroundImages = imageArray;
        this.compositeBackgroundColors = colorArray;
        this.compositeBackgroundMode = n4;
        this.flyingWindowArrowsOffsetX = nArray;
        this.flyingWindowArrowsOffsetY = nArray2;
        this.flyingWindowImages = imageArray2;
        this.flyingWindowMode = n5;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, Color[] colorArray, Image[] imageArray, int n4, EasingParams[] easingParamsArray, boolean bl4, int n5, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n6, Image image2, int n7, boolean bl6, int n8, Insets insets, boolean bl7, int n9, int n10, int n11) {
        this.init(bl, n, image, bl2, bl3, n2, n3, colorArray, imageArray, n4, easingParamsArray, bl4, this.flyingWindowArrowsOffsetX, this.flyingWindowArrowsOffsetY, this.flyingWindowImages, this.flyingWindowMode, n5, keyframeAnimationArray, bl5, layoutAttribs, string, n6, image2, n7, bl6, n8, insets, bl7, n9, n10, n11);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, int n3, Image[] imageArray, int n4, EasingParams[] easingParamsArray, boolean bl4, int n5, KeyframeAnimation[] keyframeAnimationArray, boolean bl5, LayoutAttribs layoutAttribs, String string, int n6, Image image2, int n7, boolean bl6, int n8, Insets insets, boolean bl7, int n9, int n10, int n11) {
        this.init(bl, n, image, bl2, bl3, n2, n3, this.compositeBackgroundColors, imageArray, n4, easingParamsArray, bl4, n5, keyframeAnimationArray, bl5, layoutAttribs, string, n6, image2, n7, bl6, n8, insets, bl7, n9, n10, n11);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_compositeBackgroundImages());
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_flyingWindowImages());
        this.calculateBackground();
    }

    @Override
    public final void set_compositeBackgroundImages(Image[] imageArray) {
        Object[] objectArray = this.compositeBackgroundImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.compositeBackgroundImages = imageArray;
            this.compositeBackgroundImagesChanged((Image[])objectArray);
            this.propertyChanged(23);
        }
    }

    @Override
    public final Image[] get_compositeBackgroundImages() {
        return this.compositeBackgroundImages;
    }

    @Override
    public final void set_compositeBackgroundColors(Color[] colorArray) {
        Object[] objectArray = this.compositeBackgroundColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.compositeBackgroundColors = colorArray;
            this.compositeBackgroundColorsChanged((Color[])objectArray);
            this.propertyChanged(24);
        }
    }

    @Override
    public final Color[] get_compositeBackgroundColors() {
        return this.compositeBackgroundColors;
    }

    @Override
    public final int get_compositeBackgroundMode() {
        return this.compositeBackgroundMode;
    }

    @Override
    public final void set_compositeBackgroundMode(int n) {
        int n2 = this.compositeBackgroundMode;
        if (n2 != n) {
            this.compositeBackgroundMode = n;
            this.compositeBackgroundModeChanged(n2);
            this.propertyChanged(25);
        }
    }

    @Override
    public final int get_compositeBackgroundArrowOffsetX() {
        return this.compositeBackgroundArrowOffsetX;
    }

    @Override
    public final void set_compositeBackgroundArrowOffsetX(int n) {
        int n2 = this.compositeBackgroundArrowOffsetX;
        if (n2 != n) {
            this.compositeBackgroundArrowOffsetX = n;
            this.compositeBackgroundArrowOffsetXChanged(n2);
            this.propertyChanged(26);
        }
    }

    @Override
    public final int get_compositeBackgroundArrowOffsetY() {
        return this.compositeBackgroundArrowOffsetY;
    }

    @Override
    public final void set_compositeBackgroundArrowOffsetY(int n) {
        int n2 = this.compositeBackgroundArrowOffsetY;
        if (n2 != n) {
            this.compositeBackgroundArrowOffsetY = n;
            this.compositeBackgroundArrowOffsetYChanged(n2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final int get_flyingWindowMode() {
        return this.flyingWindowMode;
    }

    @Override
    public final void set_flyingWindowMode(int n) {
        int n2 = this.flyingWindowMode;
        if (n2 != n) {
            this.flyingWindowMode = n;
            this.flyingWindowModeChanged(n2);
            this.propertyChanged(28);
        }
    }

    @Override
    public final Image[] get_flyingWindowImages() {
        return this.flyingWindowImages;
    }

    @Override
    public final void set_flyingWindowImages(Image[] imageArray) {
        Object[] objectArray = this.flyingWindowImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.flyingWindowImages = imageArray;
            this.flyingWindowImagesChanged((Image[])objectArray);
            this.propertyChanged(29);
        }
    }

    @Override
    public final int[] get_flyingWindowArrowsOffsetX() {
        return this.flyingWindowArrowsOffsetX;
    }

    @Override
    public final void set_flyingWindowArrowsOffsetX(int[] nArray) {
        int[] nArray2 = this.flyingWindowArrowsOffsetX;
        if (!Arrays.equals(nArray2, nArray)) {
            this.flyingWindowArrowsOffsetX = nArray;
            this.flyingWindowArrowsOffsetXChanged(nArray2);
            this.propertyChanged(30);
        }
    }

    @Override
    public final int[] get_flyingWindowArrowsOffsetY() {
        return this.flyingWindowArrowsOffsetY;
    }

    @Override
    public final void set_flyingWindowArrowsOffsetY(int[] nArray) {
        int[] nArray2 = this.flyingWindowArrowsOffsetY;
        if (!Arrays.equals(nArray2, nArray)) {
            this.flyingWindowArrowsOffsetY = nArray;
            this.flyingWindowArrowsOffsetYChanged(nArray2);
            this.propertyChanged(31);
        }
    }

    protected void compositeBackgroundImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_compositeBackgroundImages());
        this.calculateBackground();
        this.repaint();
    }

    protected void compositeBackgroundColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    protected void compositeBackgroundModeChanged(int n) {
        this.calculateBackground();
        this.repaint();
    }

    protected void compositeBackgroundArrowOffsetXChanged(int n) {
        this.calculateBackground();
        this.repaint();
    }

    protected void compositeBackgroundArrowOffsetYChanged(int n) {
        this.calculateBackground();
        this.repaint();
    }

    protected void flyingWindowModeChanged(int n) {
    }

    protected void flyingWindowImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_flyingWindowImages());
    }

    protected void flyingWindowArrowsOffsetXChanged(int[] nArray) {
    }

    protected void flyingWindowArrowsOffsetYChanged(int[] nArray) {
    }

    @Override
    protected void xChanged(int n) {
        super.xChanged(n);
        this.calculateBackground();
    }

    @Override
    protected void yChanged(int n) {
        super.yChanged(n);
        this.calculateBackground();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.calculateBackground();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.calculateBackground();
    }

    @Override
    public Rectangle getBackgroundArea() {
        return this.backgroundArea;
    }

    @Override
    public Point getArrowPosition() {
        return this.arrowPosition;
    }

    @Override
    public void setArrowDestinationArea(Rectangle rectangle) {
        this.arrowDestinationArea = rectangle;
        this.calculateArrowPosition();
    }

    public Rectangle getArrowDestinationArea() {
        return this.arrowDestinationArea;
    }

    private Image[] getImages(int n) {
        Image[] imageArray = this.get_compositeBackgroundImages();
        if (this.get_flyingWindowImages() != null && this.get_flyingWindowImages().length >= (n + 1) * 5 - 1) {
            imageArray = new Image[5];
            for (int i2 = 0; i2 < 5; ++i2) {
                imageArray[i2] = this.get_flyingWindowImages()[n * 5 + i2];
            }
        }
        return imageArray;
    }

    private int getArrowOffsetX(int n) {
        if (this.get_flyingWindowArrowsOffsetX().length > n) {
            return this.get_flyingWindowArrowsOffsetX()[n];
        }
        return this.get_compositeBackgroundArrowOffsetX();
    }

    private int getArrowOffsetY(int n) {
        if (this.get_flyingWindowArrowsOffsetY().length > n) {
            return this.get_flyingWindowArrowsOffsetY()[n];
        }
        return this.get_compositeBackgroundArrowOffsetY();
    }

    private int getIndexByMode() {
        switch (this.get_compositeBackgroundMode()) {
            case 2: {
                if (this.get_flyingWindowMode() == 3) {
                    return 2;
                }
                return 0;
            }
            case 5: {
                return 1;
            }
            case 3: {
                if (this.get_flyingWindowMode() == 3) {
                    return 3;
                }
                return 1;
            }
            case 4: {
                return 0;
            }
        }
        return 0;
    }

    protected final void setCompositeBackgroundImagesByMode(int n) {
        this.set_compositeBackgroundMode(n);
        int n2 = this.getIndexByMode();
        this.set_compositeBackgroundImages(this.getImages(n2));
        this.set_compositeBackgroundArrowOffsetX(this.getArrowOffsetX(n2));
        this.set_compositeBackgroundArrowOffsetY(this.getArrowOffsetY(n2));
    }

    protected final void calculateBackground() {
        this.calculateBackgroundArea();
        this.calculateArrowPosition();
    }

    protected abstract void calculateBackgroundArea() {
    }

    protected abstract void calculateArrowPosition() {
    }
}

