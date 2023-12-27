/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ExifInfo;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LabeledIconValue;
import de.vw.mib.widgets.DynamicImage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.LabeledIconModel;
import de.vw.mib.widgets.models.ViewModel;
import java.io.IOException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public final class LabeledIcon
extends DynamicImage
implements LabeledIconModel {
    private static final boolean DISPLAY_ID_ON_ERROR = System.getProperty("de.vw.mib.widgets.LabeledIcon.DisplayIdOnError") != null;
    private LabeledIconValue labeledIconValue;
    private FontAttribs font;
    private int lineSpacing;
    private Color textFallbackColor;
    private Font fontRenderer;
    private Color4b textColor;
    private Point textPosition;
    private TextLayout textLayout;
    private TextStyle[] textStyles;
    private TextStyle[] fallbackTextStyles;
    private boolean fallbackMode;
    private int fallbackSize;
    private boolean textDisplayEnabled;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$LabeledIconUI;

    @Override
    protected void reset() {
        super.reset();
        this.fallbackMode = false;
        this.textLayout = null;
        this.textDisplayEnabled = false;
        this.textPosition = new Point();
        this.textStyles = new TextStyle[1];
        this.fallbackTextStyles = new TextStyle[1];
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Image image, Color color2, int n3, Insets insets, Color color3, Color color4, boolean bl3, Color color5, Color color6, EasingParams[] easingParamsArray, boolean bl4, FontAttribs fontAttribs, int n4, Image image2, Image image3, Image image4, ResourceLocator resourceLocator, LabeledIconValue labeledIconValue, boolean bl5, int n5, String string, boolean bl6, int n6, Image image5, int n7, boolean bl7, int n8, Color color7, boolean bl8, Insets insets2, int n9, int n10, boolean bl9, boolean bl10, int n11, int n12, int n13, int n14) {
        super.init(bl, n, bl2, color, n2, image, color2, n3, insets, color3, color4, bl3, color5, color6, easingParamsArray, bl4, n4, image2, image3, image4, resourceLocator, bl5, string, bl6, n6, image5, n7, bl7, n8, bl8, insets2, n9, n10, bl9, bl10, n11, n12, n13, n14);
        this.labeledIconValue = labeledIconValue;
        this.font = new FontAttribs(fontAttribs);
        this.fallbackSize = this.font.getSize();
        this.lineSpacing = n5;
        this.textFallbackColor = color7;
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Image image, int n3, Insets insets, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, FontAttribs fontAttribs, int n4, Image image2, Image image3, Image image4, ResourceLocator resourceLocator, LabeledIconValue labeledIconValue, boolean bl5, int n5, String string, boolean bl6, int n6, Image image5, int n7, boolean bl7, int n8, Color color3, boolean bl8, Insets insets2, int n9, int n10, boolean bl9, boolean bl10, int n11, int n12, int n13, int n14) {
        this.init(bl, n, bl2, color, n2, image, Color.WHITE, n3, insets, color, Color.WHITE, bl3, Color.WHITE, Color.WHITE, easingParamsArray, bl4, fontAttribs, n4, image2, image3, image4, resourceLocator, labeledIconValue, bl5, n5, string, bl6, n6, image5, n7, bl7, n8, color3, bl8, insets2, n9, n10, bl9, bl10, n11, n12, n13, n14);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.updateLayout();
    }

    @Override
    public void deInit() {
        this.fallbackMode = false;
        this.clearTextLayout();
        this.clearTextStyles();
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$LabeledIconUI == null ? (class$de$vw$mib$widgets$ui$LabeledIconUI = LabeledIcon.class$("de.vw.mib.widgets.ui.LabeledIconUI")) : class$de$vw$mib$widgets$ui$LabeledIconUI};
    }

    @Override
    public LabeledIconValue get_labeledIconValue() {
        return this.labeledIconValue;
    }

    @Override
    public void set_labeledIconValue(LabeledIconValue labeledIconValue) {
        LabeledIconValue labeledIconValue2 = this.labeledIconValue;
        if (labeledIconValue2 == null || !labeledIconValue2.equals(labeledIconValue)) {
            this.labeledIconValue = labeledIconValue;
            this.labeledIconValueChanged(labeledIconValue2);
            this.propertyChanged(42);
        }
    }

    @Override
    public FontAttribs get_font() {
        return this.font;
    }

    @Override
    public void set_font(FontAttribs fontAttribs) {
        FontAttribs fontAttribs2 = this.font;
        if (fontAttribs2 == null || !fontAttribs2.equals(fontAttribs)) {
            this.font = new FontAttribs(fontAttribs);
            this.fallbackSize = this.font.getSize();
            this.fontChanged(fontAttribs2);
            this.propertyChanged(43);
        }
    }

    @Override
    public Font getFontRenderer() {
        return this.fontRenderer;
    }

    @Override
    public String getText() {
        return this.labeledIconValue == null ? null : this.labeledIconValue.getText();
    }

    @Override
    public int get_lineSpacing() {
        return this.lineSpacing;
    }

    @Override
    public void set_lineSpacing(int n) {
        int n2 = this.lineSpacing;
        if (n2 != n) {
            this.lineSpacing = n;
            this.linespacingChanged(n2);
            this.propertyChanged(44);
        }
    }

    @Override
    public Color get_textFallbackColor() {
        return this.textFallbackColor;
    }

    @Override
    public void set_textFallbackColor(Color color) {
        Color color2 = this.textFallbackColor;
        if (color2 != color) {
            this.textFallbackColor = color;
            this.textFallbackColorChanged(color2);
            this.propertyChanged(45);
        }
    }

    @Override
    public Point getTextPosition() {
        return this.textPosition;
    }

    @Override
    public TextLayout getTextLayout() {
        return this.textLayout;
    }

    @Override
    public TextStyle[] getTextStyles() {
        return this.textStyles;
    }

    @Override
    public Color4b getTextColor() {
        return this.fallbackMode ? this.textFallbackColor.getCurrentColor() : this.textColor;
    }

    @Override
    public int getFontSize() {
        if (this.fallbackMode) {
            return this.fallbackSize;
        }
        if (this.labeledIconValue != null && this.labeledIconValue.getTextRenderingInfo() != null) {
            return this.labeledIconValue.getTextRenderingInfo().fontSize;
        }
        return 0;
    }

    @Override
    public boolean isTextDisplayEnabled() {
        return this.textDisplayEnabled;
    }

    @Override
    public boolean isFallbackMode() {
        return this.fallbackMode;
    }

    protected void labeledIconValueChanged(LabeledIconValue labeledIconValue) {
        this.updateLayout();
        this.repaint();
    }

    protected void linespacingChanged(int n) {
        this.repaint();
    }

    protected void textFallbackColorChanged(Color color) {
        this.repaint();
    }

    @Override
    protected void imageLoadingSuccess(BufferImage bufferImage, ExifInfo exifInfo, int n) {
        super.imageLoadingSuccess(bufferImage, exifInfo, n);
        if (LOGGER.isTraceEnabled(4)) {
            if (this.labeledIconValue.getText() == null) {
                LogMessage logMessage = LOGGER.warn(4);
                logMessage.append("LabeledIcon ").append(this.toString()).append(": image loading ready. No text specified. Displaying image without text. ").log();
            } else {
                LogMessage logMessage = LOGGER.trace(4);
                logMessage.append("LabeledIcon ").append(this.toString()).append(" image loading ready. Enable text display with text:").append(this.labeledIconValue.getText()).log();
            }
        }
        this.textDisplayEnabled = true;
    }

    @Override
    protected void imageLoadingFailure() {
        ResourceLocator resourceLocator;
        super.imageLoadingFailure();
        LogMessage logMessage = LOGGER.warn(4);
        logMessage.append("LabeledIcon ").append(this.toString()).append(" Error while loading image: '").append(this.get_imageResource()).append("'.");
        if (DISPLAY_ID_ON_ERROR && this.labeledIconValue != null && (resourceLocator = this.labeledIconValue.getResourceLocator()) != null && this.fontRenderer != null) {
            this.setText(resourceLocator.isIntResource() ? new StringBuffer().append("Int#:").append(resourceLocator.id).toString() : new StringBuffer().append("Url#:").append(resourceLocator.url).toString(), 0, 0);
            this.textDisplayEnabled = true;
        }
    }

    @Override
    protected void imageResourceChanged(ResourceLocator resourceLocator) {
        this.textDisplayEnabled = false;
        super.imageResourceChanged(resourceLocator);
    }

    protected void fontChanged(FontAttribs fontAttribs) {
        this.updateLayout();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.updateLayout();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.updateLayout();
    }

    private void updateLayout() {
        this.clearTextLayout();
        this.clearTextStyles();
        if (this.labeledIconValue == null) {
            if (LOGGER.isTraceEnabled(4)) {
                LogMessage logMessage = LOGGER.trace(4);
                logMessage.append("LabeledIcon ").append(this.toString()).append(" display disabled: LabeledIconValue==null").log();
            }
            this.set_imageResource(null);
        } else if (!LabeledIcon.resourceIsValid(this.labeledIconValue.getResourceLocator())) {
            if (LOGGER.isTraceEnabled(4)) {
                LogMessage logMessage = LOGGER.trace(4);
                logMessage.append("LabeledIcon ").append(this.toString()).append(" display disabled: ResourceLocator invalid").log();
            }
            this.set_imageResource(null);
        } else {
            this.set_imageResource(this.labeledIconValue.getResourceLocator());
            TextRenderingInfo textRenderingInfo = this.labeledIconValue.getTextRenderingInfo();
            if (textRenderingInfo == null) {
                if (LOGGER.isTraceEnabled(4)) {
                    LogMessage logMessage = LOGGER.trace(4);
                    logMessage.append("LabeledIcon ").append(this.toString()).append(" text display disabled: LabeledIconValue.TextRenderingInfo==null").log();
                }
            } else {
                int n = textRenderingInfo.getFontColor();
                this.textColor = new Color4b(n >> 24 & 0xFF, n >> 16 & 0xFF, n >> 8 & 0xFF, n >> 0 & 0xFF);
                if (this.font != null) {
                    if (textRenderingInfo.getFontSize() < 1) {
                        if (LOGGER.isTraceEnabled(4)) {
                            LogMessage logMessage = LOGGER.warn(4);
                            logMessage.append("LabeledIcon ").append(this.toString()).append(" Using fallback font size: Invalid font size: ").append(textRenderingInfo.getFontSize()).log();
                        }
                        this.font.setSize(this.fallbackSize);
                    } else {
                        this.font.setSize(textRenderingInfo.fontSize);
                    }
                    if (!this.font.isEmpty()) {
                        try {
                            this.fontRenderer = ServiceManager.fontManager.getFontFromCurrentSkin(this.font.getName());
                        }
                        catch (IOException iOException) {
                            LogMessage logMessage = LOGGER.error(4);
                            logMessage.append("Widget '").append(this.getQualifiedName()).append("': Unable to load font '").append(this.font.getName()).append("': ").append(iOException).log();
                        }
                    }
                }
                if (this.fontRenderer != null) {
                    this.setText(this.labeledIconValue.getText(), textRenderingInfo.deltaX, textRenderingInfo.deltaY);
                }
            }
        }
    }

    private void clearTextStyles() {
        if (this.textStyles[0] != null) {
            this.textStyles[0].dispose();
        }
        this.textStyles = new TextStyle[1];
        if (this.fallbackTextStyles[0] != null) {
            this.fallbackTextStyles[0].dispose();
        }
        this.fallbackTextStyles = new TextStyle[1];
    }

    private void clearTextLayout() {
        if (this.textLayout != null) {
            this.textLayout.dispose();
            this.textLayout = null;
        }
    }

    private void setText(String string, int n, int n2) {
        Object object;
        this.fallbackMode = false;
        int n3 = this.font.getSize();
        int n4 = this.font.getStyle();
        if (this.textStyles[0] == null) {
            object = ServiceManager.textLayoutManager.createGlyphStyle(this.fontRenderer.getFontId(), this.font.getSize(), n4);
            this.textStyles[0] = ServiceManager.textLayoutManager.createTextStyle(this.get_lineSpacing(), 1, 0, 0, -129, (GlyphStyle)object);
        }
        this.textLayout = ServiceManager.textLayoutManager.performTextLayout(this.get_width(), this.get_height(), -129, false, '\u0000', false, '\u0000', this.textStyles, string, this.fontRenderer);
        if (this.textLayout.isTruncated()) {
            if (LOGGER.isTraceEnabled(4)) {
                object = LOGGER.warn(4);
                object.append("LabeledIcon ").append(this.toString()).append(" text does not fit into the widget:'").append(string);
                object.append("'. Widget will go into a fallback mode where the text will be displayed without image in the predefined fallback size.");
                object.append("Please verify the 'textRenderingInfo' parameters are correct. ");
                object.append(this.labeledIconValue);
                object.log();
            }
            this.fallbackMode = true;
            n3 = this.fallbackSize;
            if (this.fallbackTextStyles[0] == null) {
                object = ServiceManager.textLayoutManager.createGlyphStyle(this.fontRenderer.getFontId(), this.fallbackSize, n4);
                this.textStyles[0] = ServiceManager.textLayoutManager.createTextStyle(this.get_lineSpacing(), 1, 0, 0, -129, (GlyphStyle)object);
            }
            this.textLayout = ServiceManager.textLayoutManager.performTextLayout(this.get_width(), this.get_height(), -129, false, '\u0000', false, '\u0000', this.textStyles, string, this.fontRenderer);
        }
        int n5 = this.textLayout.getLineCount() == 1 ? n2 + Math.round((float)(this.get_height() - (this.fontRenderer.getHeight(n3) >> 6)) / 2.0f) : n2 + (this.get_height() - this.textLayout.getHeight() >> 1);
        this.textPosition.setLocation(n, n5);
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

