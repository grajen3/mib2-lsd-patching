/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.StringUtil;
import de.vw.mib.widgets.AbstractText$ColorFadingAnimation;
import de.vw.mib.widgets.AbstractText$ContentFadingAnimation;
import de.vw.mib.widgets.AbstractText$GlowAnimation;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.AbstractTextModel;
import de.vw.mib.widgets.models.AbstractTextModel$TextHighlight;
import de.vw.mib.widgets.models.ViewModel;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractText
extends AbstractWidget
implements AbstractTextModel {
    protected static final String LINEBREAK_MARKER;
    protected static final String LINEBREAK_TAG;
    protected static final char TRUNCATION;
    public static final char HYPHENATION;
    private static final String EMPTY_STRING;
    private static final char ZERO_WIDTH_NON_JOINER;
    private static final float CONTENT_FADEOUT_START_VALUE;
    private static final float CONTENT_FADEOUT_END_VALUE;
    private static final float CONTENT_FADEIN_START_VALUE;
    private static final float CONTENT_FADEIN_END_VALUE;
    private static final float COLOR_FADING_START_VALUE;
    private static final float COLOR_FADING_END_VALUE;
    private static final int HIGHLIGHTS_INITIAL_CAPACITY;
    private Color colorBackground;
    private Color colorForeground;
    private int bevelDepth;
    private int bevelEnabled;
    private Color colorUpperBevel;
    private Color colorLowerBevel;
    private FontAttribs font;
    private int lineSpacing;
    private Insets padding;
    private String text;
    private Font fontInstance;
    private int baselineOffset;
    private int alignmentHorizontal;
    private int visualLineCount;
    private int glowType;
    private Color glowColor;
    private Color[] colorsHighlightForeground;
    private Color[] colorsHighlightBackground;
    private int[] fontStyles;
    private boolean textLayoutUpdatesEnabled;
    private String layoutableText;
    private TextStyle[] textStyles;
    private List textHighlights;
    protected TextLayout textLayout;
    protected TextLayout fadeInAnimationTextLayout;
    protected TextLayout fadeOutAnimationTextLayout;
    private Color lastColor;
    protected float colorFadingProgress;
    protected float contentFadeOutAlpha;
    protected float contentFadeInAlpha;
    private AbstractText$ColorFadingAnimation colorFadingAnimation;
    protected AbstractText$ContentFadingAnimation contentFadeOutAnimation;
    protected AbstractText$ContentFadingAnimation contentFadeInAnimation;
    protected AbstractText$GlowAnimation glowAnimation;
    protected float glowAlpha;

    @Override
    protected void reset() {
        super.reset();
        this.colorBackground = null;
        this.colorForeground = null;
        this.font = null;
        this.padding = null;
        this.text = null;
        this.layoutableText = null;
        this.glowAlpha = 0.0f;
        this.glowAnimation = null;
        this.fontInstance = null;
        this.colorFadingAnimation = null;
        this.colorLowerBevel = null;
        this.colorUpperBevel = null;
        this.colorFadingProgress = 0.0f;
        this.contentFadeOutAlpha = 0.0f;
        this.contentFadeInAlpha = 1.0f;
        this.setInternalStateFlag(9, false);
        this.textLayoutUpdatesEnabled = true;
    }

    public void init(boolean bl, int n, int n2, boolean bl2, int n3, int n4, int n5, Color color, Color color2, Color color3, Color[] colorArray, Color[] colorArray2, Color color4, EasingParams[] easingParamsArray, boolean bl3, FontAttribs fontAttribs, int[] nArray, Color color5, int n6, boolean bl4, int n7, boolean bl5, int n8, String string, Insets insets, int n9, String string2, boolean bl6, Insets insets2, boolean bl7, int n10, int n11, int n12, int n13) {
        super.init(bl, n2, bl2, easingParamsArray, bl3, n7, bl5, string, n9, insets2, bl7, n11, n12, n13);
        this.alignmentHorizontal = n;
        this.baselineOffset = n3;
        this.colorBackground = color;
        this.colorForeground = color2;
        this.colorsHighlightBackground = colorArray;
        this.colorsHighlightForeground = colorArray2;
        this.font = fontAttribs;
        this.lineSpacing = n8;
        this.padding = insets;
        this.text = string2;
        this.bevelDepth = n4;
        this.bevelEnabled = n5;
        this.colorLowerBevel = color3;
        this.colorUpperBevel = color4;
        this.glowColor = color5;
        this.glowType = n6;
        this.fontStyles = nArray;
        this.setInternalStateFlag(10, bl6);
        this.setInternalStateFlag(9, bl4);
    }

    public void init(boolean bl, int n, int n2, boolean bl2, int n3, int n4, int n5, Color color, Color color2, Color color3, Color color4, EasingParams[] easingParamsArray, boolean bl3, FontAttribs fontAttribs, Color color5, int n6, boolean bl4, int n7, boolean bl5, int n8, String string, Insets insets, int n9, String string2, Insets insets2, boolean bl6, int n10, int n11, int n12, int n13) {
        this.init(bl, n, n2, bl2, n3, n4, n5, color, color2, color3, null, null, color4, easingParamsArray, bl3, fontAttribs, null, color5, n6, bl4, n7, bl5, n8, string, insets, n9, string2, false, insets2, bl6, n10, n11, n12, n13);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.colorFadingProgress = 0.0f;
        this.contentFadeOutAlpha = 1.0f;
        this.contentFadeInAlpha = 0.0f;
        this.glowAlpha = this.is_glowVisible() ? 1.0f : 0.0f;
    }

    @Override
    public void deInit() {
        this.clearTextStyle();
        this.clearTextHighlights();
        this.clearLayoutableText();
        if (this.textLayout != null) {
            this.textLayout.dispose();
            this.textLayout = null;
        }
        if (this.fadeInAnimationTextLayout != null) {
            this.fadeInAnimationTextLayout.dispose();
            this.fadeInAnimationTextLayout = null;
        }
        if (this.fadeOutAnimationTextLayout != null) {
            this.fadeOutAnimationTextLayout.dispose();
            this.fadeOutAnimationTextLayout = null;
        }
        super.deInit();
    }

    @Override
    public final Color get_colorBackground() {
        return this.colorBackground;
    }

    @Override
    public final void set_colorBackground(Color color) {
        Color color2 = this.colorBackground;
        if (color2 == null || !color2.equals(color)) {
            this.colorBackground = color;
            this.colorBackgroundChanged(color2);
            this.propertyChanged(15);
        }
    }

    @Override
    public final Color get_colorForeground() {
        return this.colorForeground;
    }

    @Override
    public final void set_colorForeground(Color color) {
        Color color2 = this.colorForeground;
        if (color2 == null || !color2.equals(color)) {
            this.colorForeground = color;
            this.colorForegroundChanged(color2);
            this.propertyChanged(16);
        }
    }

    @Override
    public Color[] get_colorsHighlightBackground() {
        return this.colorsHighlightBackground;
    }

    @Override
    public void set_colorsHighlightBackground(Color[] colorArray) {
        Object[] objectArray = this.colorsHighlightBackground;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.colorsHighlightBackground = colorArray;
            this.colorsHighlightBackgroundChanged((Color[])objectArray);
            this.propertyChanged(32);
        }
    }

    @Override
    public Color[] get_colorsHighlightForeground() {
        return this.colorsHighlightForeground;
    }

    @Override
    public void set_colorsHighlightForeground(Color[] colorArray) {
        Object[] objectArray = this.colorsHighlightForeground;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.colorsHighlightForeground = colorArray;
            this.colorsHighlightForegroundChanged((Color[])objectArray);
            this.propertyChanged(33);
        }
    }

    @Override
    public final FontAttribs get_font() {
        return this.font;
    }

    @Override
    public final void set_font(FontAttribs fontAttribs) {
        FontAttribs fontAttribs2 = this.font;
        if (fontAttribs2 == null || !fontAttribs2.equals(fontAttribs)) {
            this.font = fontAttribs;
            this.fontChanged(fontAttribs2);
            this.propertyChanged(17);
        }
    }

    @Override
    public int[] get_fontStyles() {
        return this.fontStyles;
    }

    @Override
    public void set_fontStyles(int[] nArray) {
        int[] nArray2 = this.fontStyles;
        if (!Arrays.equals(nArray2, nArray)) {
            this.fontStyles = nArray;
            this.fontStylesChanged(nArray2);
            this.propertyChanged(34);
        }
    }

    @Override
    public final int get_lineSpacing() {
        return this.lineSpacing;
    }

    @Override
    public final void set_lineSpacing(int n) {
        int n2 = this.lineSpacing;
        if (n2 != n) {
            this.lineSpacing = n;
            this.lineSpacingChanged(n2);
            this.propertyChanged(18);
        }
    }

    @Override
    public final Insets get_padding() {
        return this.padding;
    }

    @Override
    public final void set_padding(Insets insets) {
        Insets insets2 = this.padding;
        if (insets2 == null || !insets2.equals(insets)) {
            this.padding = insets;
            this.paddingChanged(insets2);
            this.propertyChanged(19);
        }
    }

    @Override
    public final String get_text() {
        return this.text;
    }

    @Override
    public final void set_text(String string) {
        String string2 = this.text;
        if (string2 == null || !string2.equals(string)) {
            this.text = string;
            this.textChanged(string2);
            this.propertyChanged(20);
        }
    }

    @Override
    public boolean is_textStylingEnabled() {
        return this.getInternalStateFlag(10);
    }

    @Override
    public void set_textStylingEnabled(boolean bl) {
        boolean bl2 = this.is_textStylingEnabled();
        if (bl2 != bl) {
            this.setInternalStateFlag(10, bl);
            this.textStylingEnabledChanged(bl2);
            this.propertyChanged(31);
        }
    }

    @Override
    public final Font getFont() {
        if (this.fontInstance == null && this.font != null && !this.font.isEmpty()) {
            try {
                this.fontInstance = ServiceManager.fontManager.getFontFromCurrentSkin(this.font.getName());
            }
            catch (IOException iOException) {
                LogMessage logMessage = LOGGER.error(2);
                logMessage.append("Widget '").append(this.getQualifiedName()).append("': Unable to load font '").append(this.font.getName()).append("': ").attachThrowable(iOException).log();
            }
        }
        return this.fontInstance;
    }

    @Override
    public final int get_alignmentHorizontal() {
        return this.alignmentHorizontal;
    }

    @Override
    public final void set_alignmentHorizontal(int n) {
        int n2 = this.alignmentHorizontal;
        if (n2 != n) {
            this.alignmentHorizontal = n;
            this.alignmentHorizontalChanged(n2);
            this.propertyChanged(22);
        }
    }

    @Override
    public TextLayout getTextLayout() {
        if (this.textLayout == null) {
            this.updateTextlayout();
        }
        return this.textLayout;
    }

    protected final void updateTextlayout() {
        if (this.areTextLayoutUpdatesEnabled()) {
            if (this.textLayout != null) {
                this.textLayout.dispose();
                this.textLayout = null;
            }
            String string = this.is_textStylingEnabled() ? AbstractText.replaceAllMarkups(this.getLayoutableText()) : this.getLayoutableText();
            this.textLayout = this.createTextLayout(string);
            this.textLayoutChanged();
        }
    }

    @Override
    public TextStyle[] getTextStyles() {
        if (this.textStyles == null) {
            this.textStyles = this.createTextStyles(this.getLayoutableText());
        }
        return this.textStyles;
    }

    @Override
    public List getTextHighlights() {
        if (this.textHighlights == null && this.is_textStylingEnabled()) {
            this.textHighlights = this.createTextHighlights(this.text, this.getTextLayout());
        }
        return this.textHighlights;
    }

    @Override
    public final TextLayout getContentFadeInTextLines() {
        if (this.fadeInAnimationTextLayout == null) {
            String string = this.is_textStylingEnabled() ? AbstractText.replaceAllMarkups(this.getLayoutableText()) : this.getLayoutableText();
            this.fadeInAnimationTextLayout = this.createTextLayout(string);
        }
        return this.fadeInAnimationTextLayout;
    }

    @Override
    public final TextLayout getContentFadeOutTextLines() {
        return this.fadeOutAnimationTextLayout;
    }

    @Override
    public final void set_baselineOffset(int n) {
        int n2 = this.baselineOffset;
        if (n2 != n) {
            this.baselineOffset = n;
            this.baselineOffsetChanged(n2);
            this.propertyChanged(21);
        }
    }

    @Override
    public final int get_baselineOffset() {
        return this.baselineOffset;
    }

    @Override
    public float getColorFadingProgress() {
        return this.colorFadingProgress;
    }

    @Override
    public Color getLastColor() {
        return this.lastColor;
    }

    @Override
    public float getContentFadeOutAlpha() {
        return this.contentFadeOutAlpha;
    }

    @Override
    public float getContentFadeInAlpha() {
        return this.contentFadeInAlpha;
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
            this.propertyChanged(24);
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
            this.propertyChanged(23);
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
            this.propertyChanged(25);
        }
    }

    @Override
    public float getGlowAlpha() {
        return this.glowAlpha;
    }

    protected final void disableTextLayoutUpdates() {
        this.textLayoutUpdatesEnabled = false;
    }

    protected final void enableTextLayoutUpdates() {
        this.textLayoutUpdatesEnabled = true;
    }

    protected final boolean areTextLayoutUpdatesEnabled() {
        return this.textLayoutUpdatesEnabled;
    }

    protected void visualLineCountChanged(int n) {
    }

    protected void textLayoutChanged() {
        if (this.textLayout != null) {
            this.set_visualLineCount(this.textLayout.getLineCount());
        }
    }

    protected void alignmentHorizontalChanged(int n) {
        this.clearTextStyle();
        this.clearTextLayout();
        this.repaint();
    }

    protected void baselineOffsetChanged(int n) {
        this.repaint();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        this.clearTextLayout();
        this.clearTextHighlights();
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        this.clearTextLayout();
        this.clearTextHighlights();
    }

    protected void colorForegroundChanged(Color color) {
        if (!this.startColorFadingAnimation(color)) {
            this.colorFadingProgress = 0.0f;
            this.repaint();
        }
    }

    protected void colorsHighlightForegroundChanged(Color[] colorArray) {
        if (this.is_textStylingEnabled()) {
            this.clearTextHighlights();
            this.repaint();
        }
    }

    protected void colorsHighlightBackgroundChanged(Color[] colorArray) {
        if (this.is_textStylingEnabled()) {
            this.clearTextHighlights();
            this.repaint();
        }
    }

    protected void colorBackgroundChanged(Color color) {
        this.repaint();
    }

    protected void fontChanged(FontAttribs fontAttribs) {
        this.fontInstance = null;
        this.clearTextStyle();
        this.clearTextHighlights();
        this.clearTextLayout();
        this.repaint();
    }

    protected void fontStylesChanged(int[] nArray) {
        if (this.is_textStylingEnabled()) {
            this.clearTextStyle();
            this.repaint();
        }
    }

    protected void lineSpacingChanged(int n) {
        this.clearTextStyle();
        this.clearTextLayout();
        this.repaint();
    }

    protected void paddingChanged(Insets insets) {
        this.clearTextLayout();
        this.repaint();
    }

    protected void colorLowerBevelChanged(Color color) {
        this.repaint();
    }

    protected void colorUpperBevelChanged(Color color) {
        this.repaint();
    }

    protected void bevelDepthChanged(int n) {
        this.repaint();
    }

    protected void bevelEnabledChanged(int n) {
        this.repaint();
    }

    protected void textStylingEnabledChanged(boolean bl) {
        if (bl) {
            this.clearTextHighlights();
            this.clearTextStyle();
        }
        this.repaint();
    }

    protected void textChanged(String string) {
        this.clearLayoutableText();
        if (this.is_textStylingEnabled()) {
            this.clearTextHighlights();
            this.clearTextStyle();
        }
        this.stopContentFadeOutAnimation();
        this.stopContentFadeInAnimation();
        if (!this.startContentFadeOutAnimation()) {
            this.contentFadeOutAlpha = 1.0f;
        }
        if (!this.startContentFadeInAnimation()) {
            this.clearTextLayout();
            this.contentFadeInAlpha = 1.0f;
        }
        this.repaint();
    }

    protected void glowTypeChanged(int n) {
        this.repaint();
    }

    protected void glowColorChanged(Color color) {
        this.repaint();
    }

    protected void glowVisibleChanged(boolean bl) {
        if (this.glowType != 0) {
            if (!this.startGlowAnimation()) {
                this.glowAlpha = !bl ? 1.0f : 0.0f;
            }
            this.repaintParent();
        }
    }

    @Override
    public boolean isContentFadeOutAnimationActive() {
        return this.contentFadeOutAnimation != null && this.contentFadeOutAnimation.isActive();
    }

    @Override
    public boolean isContentFadeInAnimationActive() {
        return this.contentFadeInAnimation != null && this.contentFadeInAnimation.isActive();
    }

    protected void clearTextLayout() {
        if (this.textLayout != null) {
            this.textLayout.dispose();
            this.textLayout = null;
        }
    }

    protected void clearTextStyle() {
        if (this.textStyles != null) {
            for (int i2 = 0; i2 < this.textStyles.length; ++i2) {
                this.textStyles[i2].dispose();
            }
            this.textStyles = null;
        }
    }

    protected void clearTextHighlights() {
        if (this.textHighlights != null) {
            this.textHighlights = null;
        }
    }

    protected List createTextHighlights(String string, TextLayout textLayout) {
        ArrayList arrayList = null;
        int n = textLayout.isTruncated() && textLayout.getLineCount() > 0 ? textLayout.getLastSourceIndex(textLayout.getLineCount() - 1) + 1 : -129;
        if (string != null && string.length() > 0 && (this.colorsHighlightBackground != null || this.colorsHighlightForeground != null)) {
            int n2 = string.indexOf(134);
            int n3 = string.indexOf(135, n2 + 1);
            while (n2 != -1 && n3 != -1 && n2 < n) {
                Color color;
                int n4 = string.charAt(n2 + 1) <= '\u0014' && string.charAt(n2 + 1) >= '\u0011' ? string.charAt(n2 + 1) - 17 + 1 : 0;
                Color color2 = this.colorsHighlightForeground == null || this.colorsHighlightForeground.length <= n4 ? null : this.colorsHighlightForeground[Math.min(this.colorsHighlightForeground.length - 1, n4)];
                Color color3 = color = this.colorsHighlightBackground == null || this.colorsHighlightBackground.length <= n4 ? null : this.colorsHighlightBackground[Math.min(this.colorsHighlightBackground.length - 1, n4)];
                if (color2 != null || color != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(5);
                    }
                    AbstractTextModel$TextHighlight abstractTextModel$TextHighlight = new AbstractTextModel$TextHighlight(n2, Math.min(n3, n), color2, color);
                    arrayList.add(abstractTextModel$TextHighlight);
                }
                n2 = string.indexOf(134, n3 + 1);
                n3 = string.indexOf(135, n2 + 1);
            }
        }
        return arrayList;
    }

    protected final TextStyle[] createTextStyles(String string) {
        FontAttribs fontAttribs = this.get_font();
        Font font = this.getFont();
        if (fontAttribs != null && font != null) {
            int n = font.getFontId();
            int n2 = fontAttribs.getSize();
            int n3 = fontAttribs.getStyle();
            if (this.is_textStylingEnabled() && this.fontStyles != null && this.fontStyles.length > 0) {
                ArrayList arrayList = new ArrayList(1);
                int n4 = 0;
                int n5 = string.indexOf(134);
                int n6 = string.indexOf(135, n5 + 1);
                while (n5 != -1 && n6 != -1) {
                    int n7 = string.charAt(n5 + 1) <= '\u0014' && string.charAt(n5 + 1) >= '\u0011' ? string.charAt(n5 + 1) - 17 + 1 : 0;
                    if (this.fontStyles.length > 0) {
                        if (n5 - n4 > 0) {
                            arrayList.add(ServiceManager.textLayoutManager.createTextStyle(this.lineSpacing, this.alignmentHorizontal, this.getTextStyleLinebreakMode(), n4, n5, ServiceManager.textLayoutManager.createGlyphStyle(n, n2, n3)));
                        }
                        GlyphStyle glyphStyle = ServiceManager.textLayoutManager.createGlyphStyle(font.getFontId(), fontAttribs.getSize(), this.fontStyles[Math.min(this.fontStyles.length - 1, n7)]);
                        arrayList.add(ServiceManager.textLayoutManager.createTextStyle(this.lineSpacing, this.alignmentHorizontal, this.getTextStyleLinebreakMode(), n5, n6, glyphStyle));
                    }
                    n4 = n6;
                    n5 = string.indexOf(134, n6 + 1);
                    n6 = string.indexOf(135, n5 + 1);
                }
                if (n4 == 0 || n4 < string.length() - 1) {
                    arrayList.add(ServiceManager.textLayoutManager.createTextStyle(this.lineSpacing, this.alignmentHorizontal, this.getTextStyleLinebreakMode(), n4, -129, ServiceManager.textLayoutManager.createGlyphStyle(n, n2, n3)));
                }
                return (TextStyle[])arrayList.toArray(new TextStyle[arrayList.size()]);
            }
            TextStyle textStyle = ServiceManager.textLayoutManager.createTextStyle(this.lineSpacing, this.alignmentHorizontal, this.getTextStyleLinebreakMode(), 0, -129, ServiceManager.textLayoutManager.createGlyphStyle(n, n2, n3));
            return new TextStyle[]{textStyle};
        }
        return new TextStyle[0];
    }

    private String getLayoutableText() {
        if (this.layoutableText == null) {
            this.layoutableText = this.text == null ? "" : (this.getMaxLineCount() > 1 ? StringUtil.replaceAll(this.text, "\\n", "\n") : this.text);
        }
        return this.layoutableText;
    }

    private void clearLayoutableText() {
        this.layoutableText = null;
    }

    protected static final String replaceAllMarkups(String string) {
        string = StringUtil.replaceAll(string, "\u0086", "\u200c");
        string = StringUtil.replaceAll(string, "\u0087", "\u200c");
        for (char c2 = '\u0011'; c2 <= '\u0014'; c2 = (char)(c2 + '\u0001')) {
            string = StringUtil.replaceAll(string, new StringBuffer().append("").append(c2).toString(), "\u200c");
        }
        return string;
    }

    protected abstract TextLayout createTextLayout(String string) {
    }

    protected abstract int getTextStyleLinebreakMode() {
    }

    @Override
    public abstract int getMaxLineWidth() {
    }

    @Override
    public final int getMaxLineHeight() {
        return this.font == null ? -1 : this.getMaxLineHeight(this.font.getSize());
    }

    @Override
    public abstract int getMaxLineCount() {
    }

    protected final int getMaxLineHeight(int n) {
        return this.get_lineSpacing() > 0 ? this.get_lineSpacing() : (this.fontInstance == null ? -1 : this.fontInstance.getHeight(n) >> 6);
    }

    private boolean startContentFadeOutAnimation() {
        EasingParams easingParams = this.getEasing(8);
        if (this.textLayout == null || easingParams == null || !this.areAnimationsEnabled()) {
            return false;
        }
        if (this.fadeOutAnimationTextLayout != null) {
            this.fadeOutAnimationTextLayout.dispose();
            this.fadeOutAnimationTextLayout = null;
        }
        this.textLayout.reference();
        this.fadeOutAnimationTextLayout = this.textLayout;
        this.clearTextLayout();
        this.contentFadeOutAlpha = 1.0f;
        this.contentFadeOutAnimation = new AbstractText$ContentFadingAnimation(this, easingParams, 1.0f, 0.0f);
        return this.startInternalAnimation(this.contentFadeOutAnimation);
    }

    private boolean startContentFadeInAnimation() {
        EasingParams easingParams = this.getEasing(9);
        if (easingParams == null || !this.areAnimationsEnabled()) {
            return false;
        }
        if (this.fadeInAnimationTextLayout != null) {
            this.fadeInAnimationTextLayout.dispose();
            this.fadeInAnimationTextLayout = null;
        }
        this.contentFadeInAlpha = 0.0f;
        this.contentFadeInAnimation = new AbstractText$ContentFadingAnimation(this, easingParams, 0.0f, 1.0f);
        return this.startInternalAnimation(this.contentFadeInAnimation);
    }

    private void stopContentFadeOutAnimation() {
        if (this.contentFadeOutAnimation != null) {
            this.stopInternalAnimation(this.contentFadeOutAnimation);
            this.contentFadeOutAnimation = null;
            if (this.textLayout != null) {
                this.textLayout.dispose();
                this.textLayout = null;
            }
            if (this.fadeInAnimationTextLayout != null) {
                this.fadeInAnimationTextLayout.reference();
                this.textLayout = this.fadeInAnimationTextLayout;
            }
            this.contentFadeOutAlpha = 1.0f;
        }
    }

    private void stopContentFadeInAnimation() {
        if (this.contentFadeInAnimation != null) {
            this.stopInternalAnimation(this.contentFadeInAnimation);
            this.contentFadeInAnimation = null;
            this.contentFadeOutAlpha = 0.0f;
        }
    }

    private boolean startColorFadingAnimation(Color color) {
        this.stopColorFadingAnimation();
        EasingParams easingParams = this.getEasing(7);
        if (easingParams == null || !this.areAnimationsEnabled()) {
            return false;
        }
        this.lastColor = color;
        this.colorFadingProgress = 1.0f;
        this.colorFadingAnimation = new AbstractText$ColorFadingAnimation(this, easingParams, this, 1.0f, 0.0f);
        return this.startInternalAnimation(this.colorFadingAnimation);
    }

    private void stopColorFadingAnimation() {
        if (this.colorFadingAnimation != null) {
            this.stopInternalAnimation(this.colorFadingAnimation);
            this.colorFadingAnimation = null;
            this.colorFadingProgress = 0.0f;
        }
    }

    private boolean startGlowAnimation() {
        this.stopGlowAnimation();
        boolean bl = this.is_glowVisible();
        EasingParams easingParams = this.getEasing(bl ? 10 : 11);
        if (easingParams == null) {
            return false;
        }
        float f2 = this.glowAlpha;
        float f3 = bl ? 1.0f - f2 : -this.glowAlpha;
        this.glowAnimation = new AbstractText$GlowAnimation(this, easingParams, f2, f3);
        return this.startInternalAnimation(this.glowAnimation);
    }

    private void stopGlowAnimation() {
        if (this.glowAnimation != null) {
            this.stopInternalAnimation(this.glowAnimation);
            this.glowAnimation = null;
        }
    }

    @Override
    public void stopInternalAnimations() {
        super.stopInternalAnimations();
        this.stopContentFadeInAnimation();
        this.stopContentFadeOutAnimation();
        this.stopColorFadingAnimation();
        this.stopGlowAnimation();
    }

    @Override
    public final Color get_colorLowerBevel() {
        return this.colorLowerBevel;
    }

    @Override
    public final void set_colorLowerBevel(Color color) {
        Color color2 = this.colorForeground;
        if (color2 == null || !color2.equals(color)) {
            this.colorLowerBevel = color;
            this.colorLowerBevelChanged(color2);
            this.propertyChanged(28);
        }
    }

    @Override
    public final Color get_colorUpperBevel() {
        return this.colorUpperBevel;
    }

    @Override
    public final void set_colorUpperBevel(Color color) {
        Color color2 = this.colorForeground;
        if (color2 == null || !color2.equals(color)) {
            this.colorUpperBevel = color;
            this.colorUpperBevelChanged(color2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final int get_bevelDepth() {
        return this.bevelDepth;
    }

    @Override
    public final void set_bevelDepth(int n) {
        int n2 = this.bevelDepth;
        if (n2 != n) {
            this.bevelDepth = n;
            this.bevelDepthChanged(n2);
            this.propertyChanged(29);
        }
    }

    @Override
    public int get_bevelEnabled() {
        return this.bevelEnabled;
    }

    @Override
    public void set_bevelEnabled(int n) {
        int n2 = this.bevelEnabled;
        if (n2 != n) {
            this.bevelEnabled = n;
            this.bevelEnabledChanged(n2);
            this.propertyChanged(30);
        }
    }

    @Override
    public final void set_visualLineCount(int n) {
        int n2 = this.visualLineCount;
        if (n2 != n) {
            this.visualLineCount = n;
            this.visualLineCountChanged(n2);
            this.propertyChanged(26);
        }
    }

    @Override
    public final int get_visualLineCount() {
        return this.visualLineCount;
    }
}

