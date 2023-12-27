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
import de.vw.mib.widgets.Button;
import de.vw.mib.widgets.interfaces.WidgetCloneData;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.speller.SpellerElement;
import java.util.Arrays;

public class SpellerButton
extends Button
implements SpellerButtonModel {
    private Image[] imagesSubspellerIndicator;
    private StaticImageModel imageSubspellerIndicatorRef;
    private int stateOffset;
    private String templateName;
    private WidgetCloneData cloneData;
    private Rectangle oldBounds;
    private SpellerElement spellerElement;
    private boolean subSpellerEnabled;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$SpellerButtonUI;

    @Override
    protected void reset() {
        super.reset();
        this.imagesSubspellerIndicator = null;
        this.imageSubspellerIndicatorRef = null;
        this.templateName = null;
        this.cloneData = null;
        this.oldBounds = new Rectangle();
        this.spellerElement = null;
        this.subSpellerEnabled = false;
    }

    public void init(boolean bl, boolean bl2, int n, Image image, boolean bl3, boolean bl4, int n2, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl5, String string, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, Image[] imageArray4, Image[] imageArray5, Color[] colorArray4, StaticImageModel staticImageModel3, StaticImageModel staticImageModel4, StaticImageModel staticImageModel5, boolean bl6, KeyframeAnimation[] keyframeAnimationArray, boolean bl7, LayoutAttribs layoutAttribs, String string2, boolean bl8, int n4, Image image2, int n5, boolean bl9, int n6, int n7, boolean bl10, int n8, int n9, int n10, int n11, int n12, String string3, TextAreaModel[] textAreaModelArray, TextAreaModel[] textAreaModelArray2, Color[] colorArray5, boolean bl11, Color[] colorArray6, Insets insets, Point[] pointArray, boolean bl12, int n13, int n14, int n15) {
        super.init(bl, n, image, bl3, bl4, n2, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl5, string, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, imageArray3, imageArray4, colorArray4, staticImageModel3, staticImageModel4, bl6, keyframeAnimationArray, bl7, layoutAttribs, string2, bl8, n4, image2, n5, bl9, n6, n7, bl10, n8, n9, n10, n12, textAreaModelArray, textAreaModelArray2, colorArray5, colorArray6, insets, pointArray, bl12, n13, n14, n15);
        this.templateName = string3;
        this.imagesSubspellerIndicator = imageArray5;
        this.imageSubspellerIndicatorRef = staticImageModel5;
        this.stateOffset = n11;
        this.setInternalStateFlag(24, bl2);
        this.setInternalStateFlag(25, bl11);
    }

    public void init(boolean bl, boolean bl2, int n, Image image, boolean bl3, boolean bl4, int n2, Color[] colorArray, Color[] colorArray2, EasingParams[] easingParamsArray, EasingParams[] easingParamsArray2, boolean bl5, String string, Color[] colorArray3, int n3, StaticImageModel staticImageModel, StaticImageModel staticImageModel2, Image[] imageArray, Image[] imageArray2, Image[] imageArray3, Image[] imageArray4, Image[] imageArray5, Color[] colorArray4, StaticImageModel staticImageModel3, StaticImageModel staticImageModel4, StaticImageModel staticImageModel5, boolean bl6, KeyframeAnimation[] keyframeAnimationArray, boolean bl7, LayoutAttribs layoutAttribs, String string2, boolean bl8, int n4, Image image2, int n5, boolean bl9, int n6, int n7, boolean bl10, int n8, int n9, int n10, int n11, int n12, String string3, TextAreaModel[] textAreaModelArray, TextAreaModel[] textAreaModelArray2, Color[] colorArray5, Color[] colorArray6, Insets insets, Point[] pointArray, boolean bl11, int n13, int n14, int n15) {
        this.init(bl, bl2, n, image, bl3, bl4, n2, colorArray, colorArray2, easingParamsArray, easingParamsArray2, bl3, string, colorArray3, n3, staticImageModel, staticImageModel2, imageArray, imageArray2, imageArray3, imageArray4, imageArray5, colorArray4, staticImageModel3, staticImageModel4, staticImageModel5, bl6, keyframeAnimationArray, bl7, layoutAttribs, string2, bl8, n4, image2, n5, bl9, n6, n7, bl10, n8, n9, n10, n11, n12, string3, textAreaModelArray, textAreaModelArray2, colorArray5, true, colorArray6, insets, pointArray, bl11, n13, n14, n15);
    }

    @Override
    public void deInit() {
        this.setSpellerElement(null);
        super.deInit();
    }

    @Override
    public final boolean is_activateKeyLongPressedOnLongPressed() {
        return this.getInternalStateFlag(24);
    }

    @Override
    public final void set_activateKeyLongPressedOnLongPressed(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(24);
        if (bl2 != bl) {
            this.setInternalStateFlag(24, bl);
            this.activateKeyLongPressedOnLongPressedChanged(bl2);
            this.propertyChanged(54);
        }
    }

    @Override
    public final StaticImageModel get_imageSubspellerIndicatorRef() {
        return this.imageSubspellerIndicatorRef;
    }

    @Override
    public final void set_imageSubspellerIndicatorRef(StaticImageModel staticImageModel) {
        StaticImageModel staticImageModel2 = this.imageSubspellerIndicatorRef;
        if (staticImageModel2 != staticImageModel) {
            this.imageSubspellerIndicatorRef = staticImageModel;
            this.imageSubspellerIndicatorRefChanged(staticImageModel2);
            this.propertyChanged(55);
        }
    }

    @Override
    public final Image[] get_imagesSubspellerIndicator() {
        return this.imagesSubspellerIndicator;
    }

    @Override
    public final void set_imagesSubspellerIndicator(Image[] imageArray) {
        Object[] objectArray = this.imagesSubspellerIndicator;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.imagesSubspellerIndicator = imageArray;
            this.imagesSubspellerIndicatorChanged((Image[])objectArray);
            this.propertyChanged(56);
        }
    }

    @Override
    public final int get_stateOffset() {
        return this.stateOffset;
    }

    @Override
    public final void set_stateOffset(int n) {
        int n2 = this.stateOffset;
        if (n2 != n && this.get_imagesState() != null && this.get_imagesState().length > n * 18) {
            this.stateOffset = n;
            this.stateOffsetChanged(n2);
            this.propertyChanged(59);
        }
    }

    @Override
    public final String get_templateName() {
        return this.templateName;
    }

    @Override
    public final void set_templateName(String string) {
        String string2 = this.templateName;
        if (string2 == null || !string2.equals(string)) {
            this.templateName = string;
            this.templateNameChanged(string2);
            this.propertyChanged(57);
        }
    }

    @Override
    public final boolean is_textFromAlphabetEnabled() {
        return this.getInternalStateFlag(25);
    }

    @Override
    public final void set_textFromAlphabetEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(25);
        if (bl2 != bl) {
            this.setInternalStateFlag(25, bl);
            this.textFromAlphabetEnabledChanged(bl2);
            this.propertyChanged(58);
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$SpellerButtonUI == null ? (class$de$vw$mib$widgets$ui$SpellerButtonUI = SpellerButton.class$("de.vw.mib.widgets.ui.SpellerButtonUI")) : class$de$vw$mib$widgets$ui$SpellerButtonUI};
    }

    @Override
    public WidgetCloneData getCloneData() {
        return this.cloneData;
    }

    @Override
    public void setCloneData(WidgetCloneData widgetCloneData) {
        this.cloneData = widgetCloneData;
    }

    @Override
    public boolean isSubspellerEnabled() {
        return this.subSpellerEnabled;
    }

    @Override
    public void setSubspellerEnabled(boolean bl) {
        this.subSpellerEnabled = bl;
        if (this.imageSubspellerIndicatorRef != null) {
            this.disableAnimations();
            this.imageSubspellerIndicatorRef.set_visible(this.subSpellerEnabled);
            this.enableAnimations();
        }
    }

    @Override
    public SpellerElement getSpellerElement() {
        return this.spellerElement;
    }

    @Override
    public void setSpellerElement(SpellerElement spellerElement) {
        SpellerElement spellerElement2 = this.spellerElement;
        if (spellerElement2 == null && spellerElement != null || spellerElement2 != null && !spellerElement2.equals(spellerElement)) {
            this.spellerElement = spellerElement;
            this.spellerElementChanged(this.spellerElement, spellerElement2);
        }
    }

    protected void activateKeyLongPressedOnLongPressedChanged(boolean bl) {
    }

    protected void imageSubspellerIndicatorRefChanged(StaticImageModel staticImageModel) {
        this.updateSubspellerIndicatorImage();
    }

    protected void imagesSubspellerIndicatorChanged(Image[] imageArray) {
        this.updateSubspellerIndicatorImage();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void spellerElementChanged(SpellerElement spellerElement, SpellerElement spellerElement2) {
        if (spellerElement == null) {
            this.setBounds(this.oldBounds);
            if (this.is_textFromAlphabetEnabled() && !this.transferText(this.get_textAreaRefs(), null)) {
                this.transferText(this.get_textAreaNonSpeakableRefs(), null);
            }
            return;
        }
        if (spellerElement2 == null) {
            this.oldBounds.setBounds(this.get_x(), this.get_y(), this.get_width(), this.get_height());
        }
        this.disableAnimations();
        try {
            this.set_x(spellerElement.getAbsX());
            this.set_y(spellerElement.getAbsY());
            this.set_width(spellerElement.getWidth());
            this.set_height(spellerElement.getHeight());
        }
        finally {
            this.enableAnimations();
        }
        if (this.is_textFromAlphabetEnabled() && !this.transferText(this.get_textAreaRefs(), spellerElement)) {
            this.transferText(this.get_textAreaNonSpeakableRefs(), spellerElement);
        }
    }

    protected void stateOffsetChanged(int n) {
        this.updateImages();
    }

    protected void templateNameChanged(String string) {
    }

    protected void textFromAlphabetEnabledChanged(boolean bl) {
    }

    private boolean transferText(TextAreaModel[] textAreaModelArray, SpellerElement spellerElement) {
        boolean bl = false;
        if (textAreaModelArray != null && textAreaModelArray.length > 0) {
            String string;
            SpellerElement spellerElement2 = spellerElement;
            if (spellerElement != null && spellerElement.getSubSpellerElement() != null) {
                spellerElement2 = spellerElement.getSubSpellerElement();
            }
            String string2 = string = spellerElement2 != null ? spellerElement2.getGraphRep() : "";
            if (textAreaModelArray[0] != null) {
                textAreaModelArray[0].set_text(string);
                bl = true;
            }
            String string3 = string = spellerElement2 != null ? spellerElement2.getGraphRep2() : "";
            if (textAreaModelArray.length > 1 && textAreaModelArray[1] != null) {
                textAreaModelArray[1].set_text(string);
                bl = true;
            }
        }
        return bl;
    }

    @Override
    protected void updateImages() {
        super.updateImages();
        this.updateSubspellerIndicatorImage();
    }

    @Override
    protected void updateStateImage() {
        StaticImageModel staticImageModel = this.get_imageStateRef();
        if (staticImageModel != null) {
            Image[] imageArray = this.get_imagesState();
            int n = this.inferIndexFromState() + this.get_stateOffset() * 18;
            if (imageArray != null && n != -1 && imageArray.length > n) {
                this.setEasingStateForCrossfadeEasing();
                staticImageModel.set_image(imageArray[n]);
            } else {
                staticImageModel.set_image(null);
            }
        }
    }

    protected void updateSubspellerIndicatorImage() {
        if (this.imageSubspellerIndicatorRef != null) {
            Image[] imageArray = this.get_imagesSubspellerIndicator();
            int n = this.inferIndexFromState();
            if (imageArray != null && n != -1 && imageArray.length > n) {
                Image image = imageArray[n];
                this.imageSubspellerIndicatorRef.set_image(image);
            } else {
                this.imageSubspellerIndicatorRef.set_image(null);
            }
        }
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

