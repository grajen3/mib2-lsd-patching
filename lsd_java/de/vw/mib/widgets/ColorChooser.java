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
import de.vw.mib.widgets.AbstractButton;
import de.vw.mib.widgets.controller.ColorChooserController;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.ColorChooserModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import java.util.Arrays;

public class ColorChooser
extends AbstractButton
implements ColorChooserModel {
    private ButtonModel[] buttonRefs;
    private int[] colorBasePoints;
    private int colorIndex;
    private StaticImageModel imageIndicatorRef;
    private Image[] imagesIndicator;
    private int indicatorValuePointX;
    private int indicatorValuePointY;
    private int mode;
    private Insets paddings;
    private boolean snap;
    private int spacingHorizontal;
    private boolean wrapFlag;
    private int[] colorsHMI;
    private boolean updateColorRepresentation;
    private int[] colorsCoordinate;
    private Point positionOnIndicator;

    @Override
    public void reset() {
        super.reset();
        this.updateColorRepresentation = false;
        this.imagesIndicator = null;
        this.imageIndicatorRef = null;
        this.buttonRefs = null;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, ButtonModel[] buttonModelArray, int[] nArray, int n2, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, StaticImageModel staticImageModel3, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, int n4, int n5, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, int n6, String string, Insets insets, int n7, Image image2, int n8, boolean bl7, boolean bl8, boolean bl9, int n9, int n10, int n11, Insets insets2, boolean bl10, int n12, boolean bl11, int n13, int n14) {
        super.init(bl, n, image, bl2, bl3, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, bl5, keyframeAnimationArray, bl6, layoutAttribs, string, n7, image2, n8, bl7, bl8, n10, n11, insets2, bl10, n12, n13, n14);
        this.buttonRefs = buttonModelArray;
        this.colorBasePoints = nArray;
        this.colorIndex = n2;
        this.imageIndicatorRef = staticImageModel3;
        this.imagesIndicator = imageArray3;
        this.indicatorValuePointX = n4;
        this.indicatorValuePointY = n5;
        this.mode = n6;
        this.paddings = insets;
        this.snap = bl9;
        this.spacingHorizontal = n9;
        this.wrapFlag = bl11;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.updateColorRepresentation = true;
        this.updateHMIColors(new int[0]);
        this.setIndicatorColor();
        this.colorsCoordinate = new int[0];
        this.updateButtonRefsControllerListener(null);
        this.updateColorChooser();
        this.repaint();
    }

    @Override
    public ButtonModel[] get_buttonRefs() {
        return this.buttonRefs;
    }

    @Override
    public void set_buttonRefs(ButtonModel[] buttonModelArray) {
        Object[] objectArray = this.buttonRefs;
        if (!Arrays.equals(objectArray, buttonModelArray)) {
            this.buttonRefs = buttonModelArray;
            this.buttonRefsChanged((ButtonModel[])objectArray);
            this.propertyChanged(45);
        }
    }

    @Override
    public int[] get_colorBasePoints() {
        return this.colorBasePoints;
    }

    @Override
    public void set_colorBasePoints(int[] nArray) {
        int[] nArray2 = this.colorBasePoints;
        if (!Arrays.equals(nArray2, nArray)) {
            this.colorBasePoints = nArray;
            this.colorBasePointsChanged(nArray2);
            this.propertyChanged(35);
        }
    }

    @Override
    public int get_colorIndex() {
        return this.colorIndex;
    }

    @Override
    public void set_colorIndex(int n) {
        int n2 = this.colorIndex;
        if (n2 != n) {
            this.colorIndex = n;
            this.colorIndexChanged(n2);
            this.propertyChanged(36);
        }
    }

    @Override
    public Image[] get_imagesIndicator() {
        return this.imagesIndicator;
    }

    @Override
    public void set_imagesIndicator(Image[] imageArray) {
        Object[] objectArray = this.imagesIndicator;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesIndicator = imageArray;
            this.imagesIndicatorChanged((Image[])objectArray);
            this.propertyChanged(37);
        }
    }

    @Override
    public StaticImageModel get_imageIndicatorRef() {
        return this.imageIndicatorRef;
    }

    @Override
    public void set_imageIndicatorRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.imageIndicatorRef;
        if (staticImageModel2 != staticImageModel) {
            this.imageIndicatorRef = staticImageModel;
            this.imageIndicatorRefChanged(staticImageModel2);
            this.propertyChanged(38);
        }
    }

    @Override
    public int get_indicatorValuePointX() {
        return this.indicatorValuePointX;
    }

    @Override
    public void set_indicatorValuePointX(int n) {
        int n2 = this.indicatorValuePointX;
        if (n2 != n) {
            this.indicatorValuePointX = n;
            this.indicatorValuePointXChanged(n2);
            this.propertyChanged(39);
        }
    }

    @Override
    public int get_indicatorValuePointY() {
        return this.indicatorValuePointY;
    }

    @Override
    public void set_indicatorValuePointY(int n) {
        int n2 = this.indicatorValuePointY;
        if (n2 != n) {
            this.indicatorValuePointY = n;
            this.indicatorValuePointYChanged(n2);
            this.propertyChanged(40);
        }
    }

    @Override
    public int get_mode() {
        return this.mode;
    }

    @Override
    public void set_mode(int n) {
        int n2 = this.mode;
        if (n2 != n) {
            this.mode = n;
            this.modeChanged(n2);
            this.propertyChanged(41);
        }
    }

    @Override
    public Insets get_paddings() {
        return this.paddings;
    }

    @Override
    public void set_paddings(Insets insets) {
        Insets insets2 = this.paddings;
        if (insets2 != insets) {
            this.paddings = insets;
            this.paddingsChanged(insets2);
            this.propertyChanged(42);
        }
    }

    @Override
    public boolean is_snap() {
        return this.snap;
    }

    @Override
    public void set_snap(boolean bl) {
        boolean bl2 = this.snap;
        if (bl2 != bl) {
            this.snap = bl;
            this.snapChanged(bl2);
            this.propertyChanged(43);
        }
    }

    @Override
    public int get_spacingHorizontal() {
        return this.spacingHorizontal;
    }

    @Override
    public void set_spacingHorizontal(int n) {
        int n2 = this.spacingHorizontal;
        if (n2 != n) {
            this.spacingHorizontal = n;
            this.spacingHorizontalChanged(n2);
            this.propertyChanged(11);
        }
    }

    @Override
    public boolean is_wrapFlag() {
        return this.wrapFlag;
    }

    @Override
    public void set_wrapFlag(boolean bl) {
        boolean bl2 = this.wrapFlag;
        if (bl2 != bl) {
            this.wrapFlag = bl;
            this.wrapFlagChanged(bl2);
            this.propertyChanged(44);
        }
    }

    @Override
    public int getColorForIndex(int n) {
        if (this.colorBasePoints != null && n >= 0 && n < this.colorBasePoints.length) {
            return this.colorBasePoints[n];
        }
        return 128;
    }

    @Override
    public int[] getHMIColors() {
        return this.colorsHMI;
    }

    @Override
    public int getHMIColor() {
        return this.getHMIColorForIndex(this.colorIndex);
    }

    @Override
    public int getHMIColorForIndex(int n) {
        if (this.getHMIColors() != null && n >= 0 && n < this.getHMIColors().length) {
            return this.getHMIColors()[n];
        }
        return 128;
    }

    @Override
    public boolean isUpdateColorRepresentation() {
        return this.updateColorRepresentation;
    }

    @Override
    public void setUpdateColorRepresentation(boolean bl) {
        this.updateColorRepresentation = bl;
    }

    @Override
    public int[] getColorsCoordinate() {
        return this.colorsCoordinate;
    }

    @Override
    public Point getPositionOnIndicator() {
        return this.positionOnIndicator;
    }

    @Override
    public boolean setPositionOnIndicator(int n, int n2) {
        Point point = ColorChooser.getPositionOnIndicator(this, n, n2, this.imageIndicatorRef);
        if (point != null) {
            this.positionOnIndicator = point;
            return true;
        }
        this.positionOnIndicator = new Point(this.indicatorValuePointX, this.indicatorValuePointY);
        return false;
    }

    protected void buttonRefsChanged(ButtonModel[] buttonModelArray) {
        this.updateButtonRefsControllerListener(buttonModelArray);
        this.updateColorChooser();
    }

    protected void colorBasePointsChanged(int[] nArray) {
        this.updateHMIColors(nArray);
        this.updateColorChooser();
        this.setIndicatorColor();
        this.repaint();
    }

    protected void colorIndexChanged(int n) {
        if (!this.isPressed()) {
            this.updateIndicatorPosition();
            this.updateButtons();
        }
        this.setIndicatorColor();
        this.repaint();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.updateColorChooser();
        this.repaint();
    }

    protected void imagesIndicatorChanged(Image[] imageArray) {
        this.updateIndicatorImage();
        this.setIndicatorColor();
    }

    protected void imageIndicatorRefChanged(StaticImageModel staticImageModel) {
        this.updateIndicatorImage();
        this.setIndicatorColor();
    }

    protected void indicatorColorStripeBoundsChanged(Rectangle rectangle) {
    }

    protected void indicatorValuePointXChanged(int n) {
        this.updateIndicatorGeometry();
    }

    protected void indicatorValuePointYChanged(int n) {
        this.updateIndicatorGeometry();
    }

    protected void modeChanged(int n) {
        this.calculateColorsCoordinate();
        this.setUpdateColorRepresentation(true);
        this.repaint();
    }

    protected void paddingsChanged(Insets insets) {
        this.updateColorChooser();
        this.repaint();
    }

    protected void snapChanged(boolean bl) {
    }

    protected void spacingHorizontalChanged(int n) {
        this.setUpdateColorRepresentation(true);
        this.repaint();
    }

    @Override
    protected void visibleChanged(boolean bl) {
        super.visibleChanged(bl);
        this.updateColorChooser();
        this.repaint();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.updateColorChooser();
        this.repaint();
    }

    protected void wrapFlagChanged(boolean bl) {
    }

    private void updateHMIColors(int[] nArray) {
        int n;
        int[] nArray2 = null;
        if (ServiceManager.skinInformationService == null || this.colorBasePoints == null) {
            nArray2 = this.colorBasePoints;
            LOGGER.trace(512).append("ColorChooser, skinInformationService or incoming colors are null.Colors (e.g. BAP colors) will not be converted (e.g. to their HMI colors).").log();
        } else {
            nArray2 = new int[this.colorBasePoints.length];
            for (n = 0; n < this.colorBasePoints.length; ++n) {
                nArray2[n] = ServiceManager.skinInformationService.getAmbientColor(this.colorBasePoints[n]);
            }
            this.setUpdateColorRepresentation(true);
        }
        if (nArray2 != null) {
            for (n = 0; n < nArray2.length; ++n) {
                nArray2[n] = 0xFF | nArray2[n];
            }
        }
        this.colorsHMI = nArray2;
    }

    @Override
    protected void updateImages() {
        super.updateImages();
        this.updateIndicatorImage();
    }

    protected void updateColorChooser() {
        this.updateButtons();
        this.calculateColorsCoordinate();
        this.updateIndicatorGeometry();
        this.setUpdateColorRepresentation(true);
    }

    protected void updateButtonRefsControllerListener(ButtonModel[] buttonModelArray) {
        ColorChooserController colorChooserController = (ColorChooserController)this.getController();
        if (colorChooserController != null) {
            OutEventListener[] outEventListenerArray;
            if (buttonModelArray != null) {
                colorChooserController.deInitOutEventlisteners();
            }
            if (this.buttonRefs != null && (outEventListenerArray = colorChooserController.createButtonListeners(this.buttonRefs)) != null) {
                for (int i2 = 0; i2 < this.buttonRefs.length; ++i2) {
                    WidgetController widgetController = this.buttonRefs[i2].getController();
                    if (widgetController == null) continue;
                    widgetController.addOutEventListener(outEventListenerArray[i2]);
                }
            }
        }
    }

    protected void updateButtons() {
        if (this.buttonRefs != null && this.getHMIColors() != null) {
            for (int i2 = 0; i2 < this.buttonRefs.length; ++i2) {
                if (i2 < this.getHMIColors().length) {
                    Color color = new Color(this.getHMIColors()[i2]);
                    Color[] colorArray = new Color[18];
                    for (int i3 = 0; i3 < colorArray.length; ++i3) {
                        colorArray[i3] = color;
                    }
                    this.buttonRefs[i2].set_colorsForeground(colorArray);
                    this.buttonRefs[i2].set_visible(true);
                } else {
                    this.buttonRefs[i2].set_visible(false);
                    this.buttonRefs[i2].set_colorsForeground(new Color[0]);
                }
                if (i2 == this.colorIndex) {
                    this.buttonRefs[i2].set_activated(true);
                    continue;
                }
                this.buttonRefs[i2].set_activated(false);
            }
        }
    }

    protected void updateIndicatorGeometry() {
        this.updateIndicatorPosition();
        this.updateIndicatorImage();
    }

    @Override
    public int calculateColorIndexByPosition(int n, int n2) {
        int n3 = n - this.getAbsX();
        int n4 = n3 - this.getPositionOnIndicator().x + this.get_indicatorValuePointX();
        int n5 = -129;
        int n6 = 0;
        int n7 = -1;
        for (int i2 = 0; i2 < this.colorsCoordinate.length; ++i2) {
            n6 = Math.abs(this.colorsCoordinate[i2] - n4);
            if (n6 > n5) continue;
            n5 = n6;
            n7 = i2;
        }
        return n7;
    }

    @Override
    public void updateIndicatorPosition(int n) {
        int n2 = 0;
        if (this.is_snap()) {
            n2 = this.colorsCoordinate != null && n < this.colorsCoordinate.length ? this.colorsCoordinate[n] - this.indicatorValuePointX : (this.colorsCoordinate != null && this.colorIndex < this.colorsCoordinate.length ? this.colorsCoordinate[this.colorIndex] - this.indicatorValuePointX : this.get_paddings().getLeft() - this.indicatorValuePointX);
            this.setIndicatorPositionX(n2);
        }
    }

    @Override
    public void updateIndicatorPosition() {
        int n = 0;
        if (this.is_snap()) {
            n = this.colorsCoordinate != null && this.colorIndex >= 0 && this.colorIndex < this.colorsCoordinate.length ? this.colorsCoordinate[this.colorIndex] - this.indicatorValuePointX : this.get_paddings().getLeft() - this.indicatorValuePointX;
            this.setIndicatorPositionX(n);
        }
    }

    @Override
    public void updateIndicatorPosition(Point point) {
        if (point == null) {
            this.updateIndicatorPosition();
            return;
        }
        int n = 0;
        int n2 = point.x - this.getAbsX();
        n = Math.max(this.get_paddings().getLeft() - this.indicatorValuePointX, Math.min(this.get_width() - this.get_paddings().getRight() - this.indicatorValuePointX, n2 -= this.getPositionOnIndicator().x));
        switch (this.mode) {
            case 1: {
                int n3 = point.y - this.getAbsY();
                int n4 = Math.max(this.get_paddings().getTop() - this.indicatorValuePointY, Math.min(this.get_height() - this.get_paddings().getBottom() - this.indicatorValuePointY, n3 -= this.getPositionOnIndicator().y));
                this.setIndicatorPositions(n, n4);
                break;
            }
            default: {
                this.setIndicatorPositionX(n);
            }
        }
    }

    private void setIndicatorPositionX(int n) {
        StaticImageModel staticImageModel = this.get_imageIndicatorRef();
        if (staticImageModel != null) {
            this.disableAnimations();
            staticImageModel.set_x(n);
            this.enableAnimations();
        }
    }

    private void setIndicatorPositions(int n, int n2) {
        StaticImageModel staticImageModel = this.get_imageIndicatorRef();
        if (staticImageModel != null) {
            this.disableAnimations();
            staticImageModel.set_x(n);
            staticImageModel.set_y(n2);
            this.enableAnimations();
        }
    }

    protected void updateIndicatorImage() {
        StaticImageModel staticImageModel = this.get_imageIndicatorRef();
        if (staticImageModel != null) {
            Image[] imageArray = this.get_imagesIndicator();
            int n = this.inferIndexFromState();
            if (imageArray != null && n < imageArray.length) {
                staticImageModel.set_image(imageArray[n]);
            } else {
                staticImageModel.set_image(null);
            }
        }
    }

    private void setIndicatorColor() {
        StaticImageModel staticImageModel = this.get_imageIndicatorRef();
        if (staticImageModel != null) {
            Color color = new Color(this.getHMIColor());
            staticImageModel.set_color(color);
        }
    }

    private void calculateColorsCoordinate() {
        block2: {
            int n;
            int n2;
            block3: {
                if (this.colorBasePoints == null || this.colorBasePoints.length <= 1 || this.get_paddings() == null) break block2;
                n2 = this.colorBasePoints.length;
                n = this.get_width() - this.get_paddings().getLeft() - this.get_paddings().getRight();
                this.colorsCoordinate = new int[n2];
                if (this.mode != 0) break block3;
                float f2 = (float)n / (float)(n2 - 1);
                float f3 = this.get_paddings().getLeft();
                this.colorsCoordinate[0] = (int)f3;
                for (int i2 = 1; i2 < this.colorsCoordinate.length; ++i2) {
                    this.colorsCoordinate[i2] = (int)(f3 += f2);
                }
                break block2;
            }
            if (this.mode == 1 || this.mode != 2) break block2;
            float f4 = (float)n / (float)n2;
            float f5 = (float)this.get_paddings().getLeft() + f4 * 63;
            this.colorsCoordinate[0] = (int)f5;
            for (int i3 = 1; i3 < this.colorsCoordinate.length; ++i3) {
                this.colorsCoordinate[i3] = (int)(f5 += (float)((int)f4));
            }
        }
    }

    private static Point getPositionOnIndicator(WidgetModel widgetModel, int n, int n2, StaticImageModel staticImageModel) {
        if (staticImageModel == null) {
            return null;
        }
        int n3 = n - widgetModel.getAbsX();
        int n4 = n2 - widgetModel.getAbsY();
        Point point = null;
        int n5 = staticImageModel.get_x();
        int n6 = n5 + staticImageModel.get_width();
        int n7 = staticImageModel.get_y();
        int n8 = n7 + staticImageModel.get_height();
        if (n3 >= n5 && n3 <= n6 && n4 >= n7 && n4 <= n8) {
            point = new Point(n3 - n5, n4 - n7);
        }
        return point;
    }

    protected void trace(String string) {
        if (LOGGER.isTraceEnabled(512)) {
            String string2 = this.getQualifiedName();
            LOGGER.trace(512).append(string2).append(string).log();
        }
    }
}

