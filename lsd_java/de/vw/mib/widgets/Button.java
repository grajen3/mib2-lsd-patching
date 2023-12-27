/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Polygon;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.widgets.AbstractButton;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class Button
extends AbstractButton
implements ButtonModel {
    private int buttonMode;
    private Image[] imagesState;
    private StaticImageModel imageStateRef;
    private Image[] imagesStateSecondary;
    private StaticImageModel imageStateSecondaryRef;
    private Color[] imageStateColors;
    private int startTimePrimary;
    private int repeatTimePrimary;
    private int startTimeSecondary;
    private int repeatTimeSecondary;
    private Color[] textColors;
    private TextAreaModel[] textAreaRefs;
    private TextAreaModel[] textAreaNonSpeakableRefs;
    private Color[] textGlowColors;
    private String eventSender;
    private Point[] vertices;
    private boolean timerChanged;
    private Polygon polygon;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ButtonUI;

    @Override
    protected void reset() {
        super.reset();
        this.imagesState = null;
        this.imagesStateSecondary = null;
        this.imageStateRef = null;
        this.imageStateSecondaryRef = null;
        this.imageStateColors = null;
        this.textColors = null;
        this.textGlowColors = null;
        this.textAreaRefs = null;
        this.textAreaNonSpeakableRefs = null;
        this.eventSender = null;
        this.vertices = null;
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, String string, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, Image[] imageArray4, Color[] colorArray4, StaticImageModel staticImageModel3, StaticImageModel staticImageModel4, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string2, boolean bl7, int n4, Image image2, int n5, boolean bl8, int n6, int n7, boolean bl9, int n8, int n9, int n10, int n11, TextAreaModel[] textAreaModelArray, TextAreaModel[] textAreaModelArray2, Color[] colorArray5, Color[] colorArray6, Insets insets, Point[] pointArray, boolean bl10, int n12, int n13, int n14) {
        super.init(bl, n, image, bl2, bl3, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, bl5, keyframeAnimationArray, bl6, layoutAttribs, string2, n4, image2, n5, bl8, bl9, n10, n11, insets, bl10, n12, n13, n14);
        this.buttonMode = n2;
        this.imagesState = imageArray3;
        this.imagesStateSecondary = imageArray4;
        this.imageStateRef = staticImageModel3;
        this.imageStateSecondaryRef = staticImageModel4;
        this.imageStateColors = colorArray4;
        this.startTimePrimary = n8;
        this.repeatTimePrimary = n6;
        this.startTimeSecondary = n9;
        this.repeatTimeSecondary = n7;
        this.textColors = colorArray5;
        this.textGlowColors = colorArray6;
        this.textAreaNonSpeakableRefs = textAreaModelArray;
        this.textAreaRefs = textAreaModelArray2;
        this.eventSender = string;
        this.vertices = pointArray;
        this.setInternalStateFlag(22, bl7);
        this.setInternalStateFlag(23, bl);
    }

    public void init(boolean bl, int n, Image image, boolean bl2, boolean bl3, int n2, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl4, String string, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, Image[] imageArray4, Color[] colorArray4, StaticImageModel staticImageModel3, StaticImageModel staticImageModel4, boolean bl5, KeyframeAnimation[] keyframeAnimationArray, boolean bl6, LayoutAttribs layoutAttribs, String string2, boolean bl7, int n4, Image image2, int n5, boolean bl8, int n6, int n7, boolean bl9, boolean bl10, int n8, int n9, int n10, int n11, int n12, int n13, TextAreaModel[] textAreaModelArray, TextAreaModel[] textAreaModelArray2, Color[] colorArray5, Color[] colorArray6, Insets insets, Point[] pointArray, boolean bl11, int n14, int n15, int n16) {
        this.init(bl, n, image, bl2, bl3, n2, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl4, string, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, imageArray3, imageArray4, colorArray4, staticImageModel3, staticImageModel4, bl5, keyframeAnimationArray, bl6, layoutAttribs, string2, bl7, n4, image2, n5, bl8, n6, n7, bl9, n10, n11, n12, n13, textAreaModelArray, textAreaModelArray2, colorArray5, colorArray6, insets, pointArray, bl11, n14, n15, n16);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.timerChanged = true;
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$ButtonUI == null ? (class$de$vw$mib$widgets$ui$ButtonUI = Button.class$("de.vw.mib.widgets.ui.ButtonUI")) : class$de$vw$mib$widgets$ui$ButtonUI};
    }

    @Override
    public final Color[] get_textColors() {
        return this.textColors;
    }

    @Override
    public final void set_textColors(Color[] colorArray) {
        Object[] objectArray = this.textColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.textColors = colorArray;
            this.textColorsChanged((Color[])objectArray);
            this.propertyChanged(44);
        }
    }

    @Override
    public final Color[] get_textGlowColors() {
        return this.textGlowColors;
    }

    @Override
    public final void set_textGlowColors(Color[] colorArray) {
        Object[] objectArray = this.textGlowColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.textGlowColors = colorArray;
            this.textGlowColorsChanged((Color[])objectArray);
            this.propertyChanged(45);
        }
    }

    @Override
    public final TextAreaModel[] get_textAreaRefs() {
        return this.textAreaRefs;
    }

    @Override
    public final void set_textAreaRefs(TextAreaModel[] textAreaModelArray) {
        TextAreaModel[] textAreaModelArray2 = this.textAreaRefs;
        if (textAreaModelArray2 != textAreaModelArray) {
            this.textAreaRefs = textAreaModelArray;
            this.textAreaRefsChanged(textAreaModelArray2);
            this.propertyChanged(46);
        }
    }

    @Override
    public TextAreaModel[] get_textAreaNonSpeakableRefs() {
        return this.textAreaNonSpeakableRefs;
    }

    @Override
    public void set_textAreaNonSpeakableRefs(TextAreaModel[] textAreaModelArray) {
        Object[] objectArray = this.textAreaNonSpeakableRefs;
        if (objectArray == null || !Arrays.equals(objectArray, textAreaModelArray)) {
            this.textAreaNonSpeakableRefs = textAreaModelArray;
            this.textAreaNonSpeakableRefsChanged((TextAreaModel[])objectArray);
            this.propertyChanged(52);
        }
    }

    @Override
    public final int get_buttonMode() {
        return this.buttonMode;
    }

    @Override
    public final void set_buttonMode(int n) {
        int n2 = this.buttonMode;
        if (n2 != n) {
            this.buttonMode = n;
            this.buttonModeChanged(n2);
            this.propertyChanged(35);
        }
    }

    @Override
    public final Image[] get_imagesState() {
        return this.imagesState;
    }

    @Override
    public final void set_imagesState(Image[] imageArray) {
        Object[] objectArray = this.imagesState;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesState = imageArray;
            this.imagesStateChanged((Image[])objectArray);
            this.propertyChanged(36);
        }
    }

    @Override
    public final Image[] get_imagesStateSecondary() {
        return this.imagesStateSecondary;
    }

    @Override
    public final void set_imagesStateSecondary(Image[] imageArray) {
        Object[] objectArray = this.imagesStateSecondary;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesStateSecondary = imageArray;
            this.imagesStateSecondaryChanged((Image[])objectArray);
            this.propertyChanged(38);
        }
    }

    @Override
    public final StaticImageModel get_imageStateRef() {
        return this.imageStateRef;
    }

    @Override
    public final void set_imageStateRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.imageStateRef;
        if (staticImageModel2 != staticImageModel) {
            this.imageStateRef = staticImageModel;
            this.imageStateRefChanged(staticImageModel2);
            this.propertyChanged(37);
        }
    }

    @Override
    public final StaticImageModel get_imageStateSecondaryRef() {
        return this.imageStateSecondaryRef;
    }

    @Override
    public final void set_imageStateSecondaryRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.imageStateSecondaryRef;
        if (staticImageModel2 != staticImageModel) {
            this.imageStateSecondaryRef = staticImageModel;
            this.imageStateSecondaryRefChanged(staticImageModel2);
            this.propertyChanged(39);
        }
    }

    @Override
    public final Color[] get_imageStateColors() {
        return this.imageStateColors;
    }

    @Override
    public final void set_imageStateColors(Color[] colorArray) {
        Object[] objectArray = this.imageStateColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.imageStateColors = colorArray;
            this.imageStateColorsChanged((Color[])objectArray);
            this.propertyChanged(40);
        }
    }

    @Override
    public final String get_eventSender() {
        return this.eventSender;
    }

    @Override
    public final void set_eventSender(String string) {
        String string2 = this.eventSender;
        if (string2 != string) {
            this.eventSender = string;
            this.eventSenderChanged(string2);
            this.propertyChanged(48);
        }
    }

    @Override
    public final int get_startTimePrimary() {
        return this.startTimePrimary;
    }

    @Override
    public final void set_startTimePrimary(int n) {
        int n2 = this.startTimePrimary;
        if (n2 != n) {
            this.startTimePrimary = n;
            this.startTimePrimaryChanged(n2);
            this.propertyChanged(41);
        }
    }

    @Override
    public final int get_repeatTimePrimary() {
        return this.repeatTimePrimary;
    }

    @Override
    public final void set_repeatTimePrimary(int n) {
        int n2 = this.repeatTimePrimary;
        if (n2 != n) {
            this.repeatTimePrimary = n;
            this.repeatTimePrimaryChanged(n2);
            this.propertyChanged(42);
        }
    }

    @Override
    public final int get_startTimeSecondary() {
        return this.startTimeSecondary;
    }

    @Override
    public final void set_startTimeSecondary(int n) {
        int n2 = this.startTimeSecondary;
        if (n2 != n) {
            this.startTimeSecondary = n;
            this.startTimeSecondaryChanged(n2);
            this.propertyChanged(43);
        }
    }

    @Override
    public final int get_repeatTimeSecondary() {
        return this.repeatTimeSecondary;
    }

    @Override
    public final void set_repeatTimeSecondary(int n) {
        int n2 = this.repeatTimeSecondary;
        if (n2 != n) {
            this.repeatTimeSecondary = n;
            this.repeatTimeSecondaryChanged(n2);
            this.propertyChanged(47);
        }
    }

    @Override
    public final Point[] get_vertices() {
        return this.vertices;
    }

    @Override
    public final void set_vertices(Point[] pointArray) {
        Object[] objectArray = this.vertices;
        if (!Arrays.equals(objectArray, pointArray)) {
            this.vertices = pointArray;
            this.propertyChanged(51);
            this.verticesChanged((Point[])objectArray);
        }
    }

    @Override
    public boolean is_predictiveActivation() {
        return this.getInternalStateFlag(22);
    }

    @Override
    public void set_predictiveActivation(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(22);
        if (bl2 != bl) {
            this.setInternalStateFlag(22, bl);
            this.predictiveActivationChanged();
            this.propertyChanged(53);
        }
    }

    @Override
    public final boolean hasVertices() {
        return this.vertices != null && this.vertices.length >= 3;
    }

    @Override
    public final boolean isTimerChanged() {
        return this.timerChanged;
    }

    @Override
    public final void setTimerChanged(boolean bl) {
        this.timerChanged = bl;
    }

    @Override
    public boolean isActivatedInternal() {
        return this.getInternalStateFlag(23);
    }

    @Override
    public void setActivatedInternal(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(23);
        if (bl2 != bl) {
            this.setInternalStateFlag(23, bl);
            this.activatedInternalChanged(bl2);
        }
    }

    protected void startTimePrimaryChanged(int n) {
        this.timerChanged = true;
    }

    @Override
    protected void activatedChanged(boolean bl) {
        this.setActivatedInternal(!bl);
        if (LOGGER.isTraceEnabled(8)) {
            LogMessage logMessage = LOGGER.trace(8);
            logMessage.append(this.getQualifiedName()).append(".activated changed to '").append(!bl).append("'").log();
        }
        super.activatedChanged(bl);
    }

    protected void activatedInternalChanged(boolean bl) {
        this.updateState();
        this.repaint();
    }

    protected void repeatTimePrimaryChanged(int n) {
        this.timerChanged = true;
    }

    protected void startTimeSecondaryChanged(int n) {
        this.timerChanged = true;
    }

    protected void repeatTimeSecondaryChanged(int n) {
        this.timerChanged = true;
    }

    protected void imagesStateChanged(Image[] imageArray) {
        this.updateStateImage();
    }

    protected void imagesStateSecondaryChanged(Image[] imageArray) {
        this.updateStateImageSecondary();
    }

    protected void imageStateRefChanged(StaticImageModel staticImageModel) {
        this.updateStateImageColor();
        this.updateStateImage();
    }

    protected void imageStateSecondaryRefChanged(StaticImageModel staticImageModel) {
        this.updateStateImageSecondaryColor();
        this.updateStateImageSecondary();
    }

    protected void imageStateColorsChanged(Color[] colorArray) {
        this.updateStateImageColor();
        this.updateStateImageSecondaryColor();
    }

    protected void buttonModeChanged(int n) {
        this.timerChanged = true;
    }

    protected void eventSenderChanged(String string) {
    }

    protected void textColorsChanged(Color[] colorArray) {
        this.updateTextAreaRefsColor();
        this.updateTextAreaNonSpeakableRefsColor();
    }

    protected void textGlowColorsChanged(Color[] colorArray) {
    }

    @Override
    protected void glowColorsChanged(Color[] colorArray) {
        super.glowColorsChanged(colorArray);
        this.updateTextAreaRefsColor();
        this.updateTextAreaNonSpeakableRefsColor();
    }

    protected void textAreaRefsChanged(TextAreaModel[] textAreaModelArray) {
        this.updateTextAreaRefsColor();
    }

    private void textAreaNonSpeakableRefsChanged(TextAreaModel[] textAreaModelArray) {
        this.updateTextAreaNonSpeakableRefsColor();
    }

    @Override
    protected void enabledChanged(boolean bl) {
        super.enabledChanged(bl);
        if (!this.is_enabled()) {
            this.setPressed(false);
        }
    }

    protected void verticesChanged(Point[] pointArray) {
        if (this.polygon == null) {
            this.polygon = new Polygon();
        } else {
            this.polygon.reset();
        }
        if (this.hasVertices()) {
            for (int i2 = 0; i2 < this.vertices.length; ++i2) {
                this.polygon.addPoint(this.vertices[i2].x, this.vertices[i2].y);
            }
            this.setBounds(this.polygon.getBounds());
            this.repaint();
        }
    }

    private void predictiveActivationChanged() {
    }

    @Override
    protected void updateGlows() {
        super.updateGlows();
        boolean bl = this.isPressed();
        TextAreaModel[] textAreaModelArray = this.get_textAreaRefs();
        TextAreaModel[] textAreaModelArray2 = this.get_textAreaNonSpeakableRefs();
        StaticImageModel staticImageModel = this.get_imageStateRef();
        StaticImageModel staticImageModel2 = this.get_imageStateSecondaryRef();
        int n = this.inferIndexFromState();
        Color[] colorArray = this.get_textGlowColors();
        Color color = colorArray != null && colorArray.length > n ? colorArray[n] : Color.WHITE;
        this.updateTextAreaGlow(bl, textAreaModelArray, color);
        this.updateTextAreaGlow(bl, textAreaModelArray2, color);
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

    private void updateTextAreaGlow(boolean bl, TextAreaModel[] textAreaModelArray, Color color) {
        if (textAreaModelArray != null) {
            for (int i2 = 0; i2 < textAreaModelArray.length; ++i2) {
                if (null == textAreaModelArray[i2]) continue;
                if (bl) {
                    textAreaModelArray[i2].set_glowColor(color);
                }
                textAreaModelArray[i2].set_glowVisible(bl);
            }
        }
    }

    @Override
    protected void updateImages() {
        super.updateImages();
        this.updateStateImage();
        this.updateStateImageSecondary();
        this.updateStateImageColor();
        this.updateStateImageSecondaryColor();
        this.updateTextAreaRefsColor();
        this.updateTextAreaNonSpeakableRefsColor();
    }

    protected void updateStateImage() {
        StaticImageModel staticImageModel = this.get_imageStateRef();
        if (staticImageModel != null) {
            Image[] imageArray = this.get_imagesState();
            int n = this.inferIndexFromState();
            if (imageArray != null && n != -1 && imageArray.length > n) {
                this.setEasingStateForCrossfadeEasing();
                staticImageModel.set_image(imageArray[n]);
            } else {
                staticImageModel.set_image(null);
            }
        }
    }

    protected void setEasingStateForCrossfadeEasing() {
        EasingParams[] easingParamsArray = this.get_easingStates();
        int n = this.inferIndexFromState();
        if (easingParamsArray != null && easingParamsArray.length > n) {
            this.get_imageStateRef().setCrossfadeEasing(easingParamsArray[n]);
        }
    }

    protected void updateStateImageSecondary() {
        StaticImageModel staticImageModel = this.get_imageStateSecondaryRef();
        if (staticImageModel != null) {
            Image[] imageArray = this.get_imagesStateSecondary();
            int n = this.inferIndexFromState();
            if (imageArray != null && n != -1 && imageArray.length > n) {
                staticImageModel.set_image(imageArray[n]);
            } else {
                staticImageModel.set_image(null);
            }
        }
    }

    protected void updateStateImageColor() {
        StaticImageModel staticImageModel = this.get_imageStateRef();
        if (staticImageModel != null) {
            Color[] colorArray = this.get_imageStateColors();
            int n = this.inferIndexFromState();
            if (colorArray != null && n != -1 && colorArray.length > n) {
                staticImageModel.set_color(colorArray[n]);
            } else {
                staticImageModel.set_color(Color.WHITE);
            }
        }
    }

    protected void updateStateImageSecondaryColor() {
        StaticImageModel staticImageModel = this.get_imageStateSecondaryRef();
        if (staticImageModel != null) {
            Color[] colorArray = this.get_imageStateColors();
            int n = this.inferIndexFromState();
            if (colorArray != null && n != -1 && colorArray.length > n) {
                staticImageModel.set_color(colorArray[n]);
            } else {
                staticImageModel.set_color(Color.WHITE);
            }
        }
    }

    private void updateTextAreaRefsColor() {
        TextAreaModel[] textAreaModelArray = this.get_textAreaRefs();
        if (textAreaModelArray != null) {
            Color[] colorArray = this.get_textColors();
            int n = this.inferIndexFromState();
            if (colorArray != null && n != -1 && colorArray.length > n) {
                Color color = colorArray[n];
                for (int i2 = 0; i2 < textAreaModelArray.length; ++i2) {
                    if (null == textAreaModelArray[i2]) continue;
                    textAreaModelArray[i2].set_colorForeground(color);
                }
            }
        }
    }

    private void updateTextAreaNonSpeakableRefsColor() {
        TextAreaModel[] textAreaModelArray = this.get_textAreaNonSpeakableRefs();
        if (textAreaModelArray != null) {
            Color[] colorArray = this.get_textColors();
            int n = this.inferIndexFromStateNonSpeakable();
            if (colorArray != null && n != -1 && colorArray.length > n) {
                Color color = colorArray[n];
                for (int i2 = 0; i2 < textAreaModelArray.length; ++i2) {
                    if (null == textAreaModelArray[i2]) continue;
                    textAreaModelArray[i2].set_colorForeground(color);
                }
            }
        }
    }

    @Override
    public boolean isAbsPointInside(int n, int n2, int n3) {
        if (!this.hasVertices()) {
            return super.isAbsPointInside(n, n2, n3);
        }
        return this.polygon != null ? this.polygon.contains(n - this.getParent().getAbsX(), n2 - this.getParent().getAbsY()) : false;
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

