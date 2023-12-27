/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.AbstractText;
import de.vw.mib.widgets.SpinLabel$SpinLabelFlippingAnimation;
import de.vw.mib.widgets.controller.SpinLabelController;
import de.vw.mib.widgets.interfaces.Draggable$DragDataStorage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.SpinLabelModel;
import de.vw.mib.widgets.models.ViewModel;
import java.util.Arrays;

public class SpinLabel
extends AbstractText
implements SpinLabelModel {
    private Image separatorImage;
    private Image backgroundImage;
    private String[] values;
    private int mode;
    private int selectedIndex;
    private int characterOffset;
    private SpinLabel$SpinLabelFlippingAnimation flippingAnimation;
    private int scrollPosition;
    private Draggable$DragDataStorage dragData;
    protected TextLayout[] textLayouts;
    private int maxValue;
    private int startOffset;
    private int digitCount;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$SpinLabelUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$SpinLabelPickerUI;

    @Override
    protected void reset() {
        super.reset();
        this.dragData = new Draggable$DragDataStorage();
        this.dragData.useThreshold = false;
        this.separatorImage = null;
        this.backgroundImage = null;
        this.scrollPosition = 0;
    }

    public void init(boolean bl, int n, int n2, boolean bl2, Image image, int n3, int n4, int n5, int n6, Color color, Color color2, Color color3, Color[] colorArray, Color[] colorArray2, Color color4, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, FontAttribs fontAttribs, int[] nArray, Color color5, int n7, boolean bl5, int n8, boolean bl6, int n9, int n10, String string, Insets insets, int n11, Image image2, boolean bl7, int n12, String string2, boolean bl8, Insets insets2, String[] stringArray, boolean bl9, int n13, int n14, int n15, int n16) {
        super.init(bl, n, n2, bl2, n3, n4, n5, color, color2, color3, colorArray, colorArray2, color4, easingParamsArray, bl4, fontAttribs, nArray, color5, n7, bl5, n8, bl6, n9, string, insets, n12, string2, bl8, insets2, bl9, n13, n14, n15, n16);
        this.selectedIndex = n11;
        this.mode = n10;
        this.values = stringArray;
        this.characterOffset = n6;
        this.separatorImage = image2;
        this.backgroundImage = image;
        this.setInternalStateFlag(11, bl7);
        this.setInternalStateFlag(12, bl3);
    }

    public void init(boolean bl, int n, int n2, boolean bl2, Image image, int n3, int n4, int n5, int n6, Color color, Color color2, Color color3, Color color4, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, FontAttribs fontAttribs, Color color5, int n7, boolean bl5, int n8, boolean bl6, int n9, int n10, String string, Insets insets, int n11, Image image2, boolean bl7, int n12, String string2, Insets insets2, String[] stringArray, boolean bl8, int n13, int n14, int n15, int n16) {
        this.init(bl, n, n2, bl2, image, n3, n4, n5, n6, color, color2, color3, null, null, color4, bl3, easingParamsArray, bl4, fontAttribs, null, color5, n7, bl5, n8, bl6, n9, n10, string, insets, n11, image2, bl7, n12, string2, false, insets2, stringArray, bl8, n13, n14, n15, n16);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_separatorImage());
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_backgroundImage());
        this.updateSpinLabel();
    }

    @Override
    public void deInit() {
        this.clearTextLayouts();
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$SpinLabelUI == null ? (class$de$vw$mib$widgets$ui$SpinLabelUI = SpinLabel.class$("de.vw.mib.widgets.ui.SpinLabelUI")) : class$de$vw$mib$widgets$ui$SpinLabelUI, class$de$vw$mib$widgets$ui$SpinLabelPickerUI == null ? (class$de$vw$mib$widgets$ui$SpinLabelPickerUI = SpinLabel.class$("de.vw.mib.widgets.ui.SpinLabelPickerUI")) : class$de$vw$mib$widgets$ui$SpinLabelPickerUI};
    }

    @Override
    public final Image get_separatorImage() {
        return this.separatorImage;
    }

    @Override
    public final void set_separatorImage(Image image) {
        Image image2 = this.separatorImage;
        if (image2 == null || !image2.equals(image)) {
            this.separatorImage = image;
            this.separatorImageChanged(image2);
            this.propertyChanged(35);
        }
    }

    @Override
    public final Image get_backgroundImage() {
        return this.backgroundImage;
    }

    @Override
    public final void set_backgroundImage(Image image) {
        Image image2 = this.backgroundImage;
        if (image2 == null || !image2.equals(image)) {
            this.backgroundImage = image;
            this.backgroundImageChanged(image2);
            this.propertyChanged(36);
        }
    }

    @Override
    public final boolean is_spinDirectionUp() {
        return this.getInternalStateFlag(11);
    }

    @Override
    public final void set_spinDirectionUp(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(11);
        if (bl2 != bl) {
            this.setInternalStateFlag(11, bl);
            this.spinDirectionUpChanged(bl2);
            this.propertyChanged(37);
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
            this.propertyChanged(39);
        }
    }

    @Override
    public String[] get_values() {
        return this.values;
    }

    @Override
    public void set_values(String[] stringArray) {
        Object[] objectArray = this.values;
        if (!Arrays.equals(objectArray, stringArray)) {
            this.values = stringArray;
            this.valuesChanged((String[])objectArray);
            this.propertyChanged(38);
        }
    }

    @Override
    public int get_selectedIndex() {
        return this.selectedIndex;
    }

    @Override
    public void set_selectedIndex(int n) {
        int n2 = this.selectedIndex;
        if (n2 != n) {
            this.selectedIndex = n;
            this.selectedIndexChanged(n2);
            this.propertyChanged(40);
        }
    }

    @Override
    public boolean is_cyclic() {
        return this.getInternalStateFlag(12);
    }

    @Override
    public void set_cyclic(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(12);
        if (bl2 != bl) {
            this.setInternalStateFlag(12, bl);
            this.cyclicChanged(bl2);
            this.propertyChanged(41);
        }
    }

    @Override
    public int get_characterOffset() {
        return this.characterOffset;
    }

    @Override
    public void set_characterOffset(int n) {
        int n2 = this.characterOffset;
        if (n2 != n) {
            this.characterOffset = n;
            this.characterOffsetChanged(n2);
            this.propertyChanged(42);
        }
    }

    @Override
    public int getSelectionValue() {
        switch (this.mode) {
            case 0: {
                return 0;
            }
            case 1: {
                return this.get_selectedIndex();
            }
            case 2: {
                return this.get_selectedIndex() + this.startOffset;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append(this).append(": Invalid mode given (").append(this.mode).append(")").toString());
    }

    @Override
    public int getLastIndex() {
        return this.maxValue;
    }

    private void updateSpinLabel() {
        this.clearTextLayouts();
        switch (this.mode) {
            case 0: {
                this.textLayouts = new TextLayout[2];
                this.digitCount = 0;
                this.maxValue = 2;
                this.startOffset = 0;
                break;
            }
            case 1: {
                if (this.values != null) {
                    this.textLayouts = new TextLayout[this.values.length];
                }
                this.digitCount = 0;
                this.maxValue = this.values != null ? this.values.length : 0;
                this.startOffset = 0;
                break;
            }
            case 2: {
                this.textLayouts = new TextLayout[1];
                if (this.values != null && this.values.length > 1) {
                    try {
                        this.startOffset = Integer.parseInt(this.values[0]);
                        this.maxValue = Integer.parseInt(this.values[1]) - this.startOffset + 1;
                        this.digitCount = this.values.length > 2 ? this.values[2].length() : -1;
                    }
                    catch (NumberFormatException numberFormatException) {
                        LogMessage logMessage = LOGGER.warn(512);
                        logMessage.append(this.toString()).append(": Error setting spinlabel configuration: ").append(numberFormatException).log();
                        this.maxValue = 0;
                    }
                    break;
                }
                this.digitCount = 0;
                this.maxValue = 0;
                this.startOffset = 0;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append(this).append(": Invalid mode given (").append(this.mode).append(")").toString());
            }
        }
    }

    private void clearTextLayouts() {
        if (this.textLayouts != null) {
            for (int i2 = 0; i2 < this.textLayouts.length; ++i2) {
                if (this.textLayouts[i2] == null) continue;
                this.textLayouts[i2].dispose();
            }
            this.textLayouts = null;
        }
    }

    @Override
    public int getItemHeight() {
        return this.getMaxLineHeight();
    }

    @Override
    public int getScrollPosition() {
        return this.scrollPosition;
    }

    @Override
    public TextLayout getTextLayout(int n) {
        if (this.get_mode() == 2) {
            StringBuilder stringBuilder;
            if (this.digitCount > 0) {
                stringBuilder = new StringBuilder(Math.max(this.digitCount, 0));
                int n2 = n + this.startOffset;
                String string = Integer.toString(Math.abs(n2));
                int n3 = this.digitCount - string.length() - (n2 < 0 ? 1 : 0);
                if (n3 < 0) {
                    string = string.substring(0, string.length() + n3);
                }
                if (n2 < 0) {
                    stringBuilder.append('-');
                }
                for (int i2 = 0; i2 < n3; ++i2) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(string);
            } else {
                stringBuilder = this.digitCount < 0 ? new StringBuilder(Integer.toString(n + this.startOffset)) : new StringBuilder(" ");
            }
            if (this.textLayouts[0] != null) {
                this.textLayouts[0].dispose();
                this.textLayouts[0] = null;
            }
            this.textLayouts[0] = this.createTextLayout(stringBuilder.toString());
            return this.textLayouts[0];
        }
        if (this.textLayouts[n = Util.clamp(n, 0, this.getLastIndex() - 1)] == null) {
            this.textLayouts[n] = this.createTextLayout(this.mode != 0 ? this.values[n] : this.get_text());
        }
        return this.textLayouts[n];
    }

    protected void separatorImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_separatorImage());
        this.repaint();
    }

    protected void backgroundImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_backgroundImage());
        this.repaint();
    }

    @Override
    protected void alignmentHorizontalChanged(int n) {
        super.alignmentHorizontalChanged(n);
        this.updateSpinLabel();
    }

    protected void spinDirectionUpChanged(boolean bl) {
    }

    @Override
    protected void textChanged(String string) {
        if (this.mode == 0 && this.textLayouts != null) {
            if (string != null && this.startFlippingAnimation(0, this.getItemHeight(), this.getEasing(12))) {
                if (this.textLayouts[0] != null) {
                    this.textLayouts[0].dispose();
                    this.textLayouts[0] = null;
                }
            } else {
                if (this.textLayouts[0] != null) {
                    this.textLayouts[0].dispose();
                    this.textLayouts[0] = null;
                }
                if (this.textLayouts[1] != null) {
                    this.textLayouts[1].dispose();
                    this.textLayouts[1] = null;
                }
            }
            this.repaint();
        }
    }

    protected final void selectedIndexChanged(int n) {
        if (!this.getInternalStateFlag(13)) {
            int n2 = this.selectedIndex * this.getItemHeight();
            if (this.is_cyclic()) {
                if (this.is_spinDirectionUp()) {
                    if (n2 < this.scrollPosition) {
                        n2 += this.getMaxScrollPosition();
                    }
                } else if (n2 > this.scrollPosition) {
                    n2 -= this.getMaxScrollPosition();
                }
            }
            if (!this.startFlippingAnimation(this.scrollPosition, n2, this.getEasing(12))) {
                this.scrollPosition = n2;
                this.repaint();
            }
        }
    }

    protected final void cyclicChanged(boolean bl) {
        this.repaint();
    }

    protected final void modeChanged(int n) {
        this.scrollPosition = this.selectedIndex * this.getItemHeight();
        this.updateSpinLabel();
    }

    protected final void characterOffsetChanged(int n) {
    }

    protected final void valuesChanged(String[] stringArray) {
        this.updateSpinLabel();
        this.repaint();
    }

    @Override
    protected TextLayout createTextLayout(String string) {
        Object object;
        if (this.characterOffset != 0 && string != null && string.length() > 0) {
            object = new StringBuilder(string.length());
            int n = string.length();
            for (int i2 = 0; i2 < n; ++i2) {
                ((StringBuilder)object).append((char)(string.charAt(i2) + this.characterOffset));
            }
            string = ((StringBuilder)object).toString();
        }
        object = ServiceManager.textLayoutManager.performTextLayout(this.getMaxLineWidth(), -129, this.getMaxLineCount(), false, '\u2026', false, '-', this.getTextStyles(), string, this.getFont());
        return object;
    }

    @Override
    protected int getTextStyleLinebreakMode() {
        return 0;
    }

    @Override
    protected void fontChanged(FontAttribs fontAttribs) {
        super.fontChanged(fontAttribs);
        this.updateSpinLabel();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.updateSpinLabel();
    }

    @Override
    protected void heightChanged(int n) {
        this.updateSpinLabel();
        if (n != 0) {
            int n2 = this.scrollPosition / n;
            this.scrollPosition = n2 * this.getItemHeight();
        }
        super.heightChanged(n);
    }

    private boolean startFlippingAnimation(int n, int n2, EasingParams easingParams) {
        this.stopFlippingAnimation();
        if (easingParams == null) {
            return false;
        }
        this.flippingAnimation = new SpinLabel$SpinLabelFlippingAnimation(this, this, easingParams, n, n2 - n);
        return this.startInternalAnimation(this.flippingAnimation);
    }

    @Override
    public void stopInternalAnimations() {
        this.stopFlippingAnimation();
        super.stopInternalAnimations();
    }

    private void stopFlippingAnimation() {
        if (this.flippingAnimation != null) {
            this.stopInternalAnimation(this.flippingAnimation);
            this.flippingAnimation = null;
        }
    }

    @Override
    public int getMaxLineCount() {
        return 1;
    }

    @Override
    public int getMaxLineWidth() {
        Insets insets = this.get_padding();
        int n = insets.left + insets.right;
        return this.get_width() - n;
    }

    @Override
    public void getVisualAreaBounds(Rectangle rectangle) {
        rectangle.x = 0;
        rectangle.y = 0;
        rectangle.width = 0;
        rectangle.height = this.getMaxScrollPosition();
    }

    @Override
    public void getViewPort(Rectangle rectangle) {
        rectangle.x = 0;
        rectangle.y = this.scrollPosition;
        rectangle.width = 0;
        rectangle.height = 0;
    }

    @Override
    public Draggable$DragDataStorage getDragDataStorage() {
        this.dragData.useThreshold = false;
        return this.dragData;
    }

    @Override
    public boolean adaptSnapPosition(Point point, int n) {
        int n2 = point.y - this.scrollPosition;
        if (Math.abs(n2) > this.getMaxScrollPosition()) {
            point.y = n2 > 0 ? this.scrollPosition + this.getMaxScrollPosition() : this.scrollPosition - this.getMaxScrollPosition();
        }
        int n3 = Math.round((float)point.y / (float)this.getItemHeight());
        if (!this.is_cyclic()) {
            n3 = Util.clamp(n3, 0, this.getLastIndex() - 1);
        }
        point.y = n3 * this.getItemHeight();
        return false;
    }

    @Override
    public void startSnapAnimation(int n, int n2, EasingParams easingParams) {
        if (!this.startFlippingAnimation(this.scrollPosition, n2, easingParams)) {
            this.setViewportPosition(n, n2);
        }
        this.setInternalStateFlag(13, true);
        int n3 = n2 / this.getItemHeight();
        if (Math.abs(n3) >= this.getLastIndex()) {
            n3 %= this.getLastIndex();
        }
        if (n3 < 0) {
            n3 += this.getLastIndex();
        }
        this.set_selectedIndex(n3);
        SpinLabelController spinLabelController = (SpinLabelController)this.getController();
        if (spinLabelController != null) {
            spinLabelController.fire_selectionChanged();
        }
        this.setInternalStateFlag(13, false);
    }

    @Override
    public int getMaxScrollPosition() {
        return (this.is_cyclic() ? this.getLastIndex() : this.getLastIndex() - 1) * this.getItemHeight();
    }

    protected final void setScrollPosition(int n) {
        int n2 = this.getMaxScrollPosition();
        this.scrollPosition = this.is_cyclic() ? (n < 0 ? n2 + n % n2 : (n >= n2 ? n % n2 : n)) : n;
        this.repaintParent();
    }

    @Override
    public void setViewportPosition(int n, int n2) {
        this.setScrollPosition(n2);
    }

    @Override
    public boolean useDragDeceleration() {
        return !this.is_cyclic();
    }

    @Override
    public int getMaxDraggingSpeed() {
        return 0;
    }

    @Override
    public void startDragging() {
    }

    @Override
    public void stopDragging() {
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

