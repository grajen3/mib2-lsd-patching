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
import de.vw.mib.widgets.AbstractText;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.ViewModel;

public class TextArea
extends AbstractText
implements TextAreaModel {
    private int alignmentVertical;
    private int lineBreakMode;
    private int dynamicResizeDirection;
    private int dynamicSize;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$TextAreaUI;

    @Override
    protected void reset() {
        super.reset();
        this.setInternalStateFlag(13, false);
    }

    public void init(boolean bl, int n, int n2, int n3, boolean bl2, int n4, int n5, int n6, Color color, Color color2, Color color3, Color[] colorArray, Color[] colorArray2, Color color4, int n7, int n8, EasingParams[] easingParamsArray, boolean bl3, FontAttribs fontAttribs, int[] nArray, Color color5, int n9, boolean bl4, int n10, boolean bl5, int n11, int n12, String string, Insets insets, boolean bl6, boolean bl7, int n13, String string2, boolean bl8, Insets insets2, boolean bl9, int n14, int n15, int n16, int n17) {
        super.init(bl, n, n3, bl2, n4, n5, n6, color, color2, color3, colorArray, colorArray2, color4, easingParamsArray, bl3, fontAttribs, nArray, color5, n9, bl4, n10, bl5, n12, string, insets, n13, string2, bl8, insets2, bl9, n14, n15, n16, n17);
        this.alignmentVertical = n2;
        this.lineBreakMode = n11;
        this.dynamicResizeDirection = n7;
        this.dynamicSize = n8;
        this.setInternalStateFlag(11, bl6);
        this.setInternalStateFlag(12, bl7);
    }

    public void init(boolean bl, int n, int n2, int n3, boolean bl2, int n4, int n5, int n6, Color color, Color color2, Color color3, Color color4, int n7, int n8, EasingParams[] easingParamsArray, boolean bl3, FontAttribs fontAttribs, Color color5, int n9, boolean bl4, int n10, boolean bl5, int n11, int n12, String string, Insets insets, boolean bl6, boolean bl7, int n13, String string2, Insets insets2, boolean bl8, int n14, int n15, int n16, int n17) {
        super.init(bl, n, n3, bl2, n4, n5, n6, color, color2, color3, color4, easingParamsArray, bl3, fontAttribs, color5, n9, bl4, n10, bl5, n12, string, insets, n13, string2, insets2, bl8, n14, n15, n16, n17);
        this.alignmentVertical = n2;
        this.lineBreakMode = n11;
        this.dynamicResizeDirection = n7;
        this.dynamicSize = n8;
        this.setInternalStateFlag(11, bl6);
        this.setInternalStateFlag(12, bl7);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        if (this.dynamicResizeDirection != 0) {
            this.updateTextlayout();
        }
    }

    @Override
    public void deInit() {
        super.deInit();
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$TextAreaUI == null ? (class$de$vw$mib$widgets$ui$TextAreaUI = TextArea.class$("de.vw.mib.widgets.ui.TextAreaUI")) : class$de$vw$mib$widgets$ui$TextAreaUI};
    }

    @Override
    public final int get_alignmentVertical() {
        return this.alignmentVertical;
    }

    @Override
    public final void set_alignmentVertical(int n) {
        int n2 = this.alignmentVertical;
        if (n2 != n) {
            this.alignmentVertical = n;
            this.alignmentVerticalChanged(n2);
            this.propertyChanged(35);
        }
    }

    @Override
    public final int get_lineBreakMode() {
        return this.lineBreakMode;
    }

    @Override
    public final void set_lineBreakMode(int n) {
        int n2 = this.lineBreakMode;
        if (n2 != n) {
            this.lineBreakMode = n;
            this.lineBreakModeChanged(n2);
            this.propertyChanged(36);
        }
    }

    @Override
    public final boolean is_shorten() {
        return this.getInternalStateFlag(11);
    }

    @Override
    public final void set_shorten(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(11);
        if (bl2 != bl) {
            this.setInternalStateFlag(11, bl);
            this.propertyChanged(38);
            this.shortenChanged(bl2);
        }
    }

    @Override
    public final boolean is_shortened() {
        return this.getInternalStateFlag(12);
    }

    @Override
    public final void set_shortened(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(12);
        if (bl2 != bl) {
            this.setInternalStateFlag(12, bl);
            this.shortenedChanged(bl2);
            this.propertyChanged(39);
        }
        this.propertyChanged(39);
    }

    @Override
    public final void set_dynamicResizeDirection(int n) {
        int n2 = this.dynamicResizeDirection;
        if (n2 != n) {
            this.dynamicResizeDirection = n;
            this.dynamicResizeDirectionChanged(n2);
            this.propertyChanged(40);
        }
    }

    @Override
    public final int get_dynamicResizeDirection() {
        return this.dynamicResizeDirection;
    }

    @Override
    public final void set_dynamicSize(int n) {
        int n2 = this.dynamicSize;
        if (n2 != n) {
            this.dynamicSize = n;
            this.dynamicSizeChanged(n2);
            this.propertyChanged(41);
        }
    }

    @Override
    public final int get_dynamicSize() {
        return this.dynamicSize;
    }

    private boolean isUpdateTextImmediately() {
        return this.get_dynamicResizeDirection() != 0 && this.isPaintable() && this.areParentsVisible();
    }

    @Override
    protected void widthChanged(int n) {
        super.widthChanged(n);
        if (this.isUpdateTextImmediately() && this.get_dynamicResizeDirection() != 1) {
            this.updateTextlayout();
        }
    }

    @Override
    protected void heightChanged(int n) {
        super.heightChanged(n);
        if (this.isUpdateTextImmediately() && this.get_dynamicResizeDirection() != 2) {
            this.updateTextlayout();
        }
    }

    protected void dynamicResizeDirectionChanged(int n) {
        this.clearTextLayout();
        if (this.isUpdateTextImmediately()) {
            this.updateTextlayout();
        }
        this.repaint();
    }

    protected void dynamicSizeChanged(int n) {
        this.clearTextLayout();
        if (this.isUpdateTextImmediately()) {
            this.updateTextlayout();
        }
        this.repaint();
    }

    protected void alignmentVerticalChanged(int n) {
        this.repaint();
    }

    protected void lineBreakModeChanged(int n) {
        this.clearTextStyle();
        this.clearTextLayout();
        if (this.isUpdateTextImmediately()) {
            this.updateTextlayout();
        }
        this.repaint();
    }

    protected void shortenChanged(boolean bl) {
        this.clearTextLayout();
        if (!this.is_shorten()) {
            this.set_shortened(false);
        }
        if (this.isUpdateTextImmediately()) {
            this.updateTextlayout();
        }
        this.repaint();
    }

    protected void shortenedChanged(boolean bl) {
    }

    @Override
    protected void alignmentHorizontalChanged(int n) {
        super.alignmentHorizontalChanged(n);
        if (this.isUpdateTextImmediately()) {
            this.updateTextlayout();
        }
    }

    @Override
    protected void fontChanged(FontAttribs fontAttribs) {
        super.fontChanged(fontAttribs);
        if (this.isUpdateTextImmediately()) {
            this.updateTextlayout();
        }
    }

    @Override
    protected void lineSpacingChanged(int n) {
        super.lineSpacingChanged(n);
        if (this.isUpdateTextImmediately()) {
            this.updateTextlayout();
        }
    }

    @Override
    protected void paddingChanged(Insets insets) {
        super.paddingChanged(insets);
        if (this.isUpdateTextImmediately()) {
            this.updateTextlayout();
        }
    }

    @Override
    protected void textChanged(String string) {
        super.textChanged(string);
        if (!this.isContentFadeInAnimationActive() && this.isUpdateTextImmediately()) {
            this.updateTextlayout();
        }
    }

    protected int getMaxTextLayoutWidth() {
        int n;
        Insets insets = this.get_padding();
        int n2 = n = insets != null ? insets.left + insets.right : 0;
        return this.dynamicResizeDirection != 1 ? this.get_width() - n : (this.dynamicSize > n ? this.dynamicSize - n : 0);
    }

    protected int getMaxTextLayoutHeight() {
        return this.getMaxTextHeight();
    }

    protected int getMaxTextLayoutLineCount() {
        return this.getMaxLineCount();
    }

    @Override
    public int getMaxLineWidth() {
        return this.getMaxTextLayoutWidth();
    }

    @Override
    public int getMaxLineCount() {
        FontAttribs fontAttribs = this.get_font();
        if (fontAttribs == null) {
            return -1;
        }
        int n = fontAttribs.getSize();
        int n2 = this.getMaxLineCount(n);
        int n3 = this.get_lineBreakMode() != 0 ? n2 : Math.min(n2, 1);
        return n3;
    }

    private int getMaxLineCount(int n) {
        Font font = this.getFont();
        int n2 = this.getMaxLineHeight(n);
        int n3 = this.getMaxTextHeight();
        int n4 = font != null ? font.getHeight(n) >> 6 : n2;
        return n4 > n3 ? 0 : 1 + (n3 - n4) / n2;
    }

    protected int getMaxTextHeight() {
        int n;
        Insets insets = this.get_padding();
        int n2 = n = insets != null ? insets.top + insets.bottom : 0;
        return this.dynamicResizeDirection != 2 ? this.get_height() - n : (this.dynamicSize > n ? this.dynamicSize - n : 0);
    }

    @Override
    protected void clearTextLayout() {
        super.clearTextLayout();
        if (this.get_dynamicResizeDirection() != 0 && this.get_font() != null) {
            this.getTextLayout();
        }
    }

    @Override
    protected int getTextStyleLinebreakMode() {
        switch (this.get_lineBreakMode()) {
            case 1: {
                return 1;
            }
            case 5: {
                return this.getInternalStateFlag(13) ? 1 : 0;
            }
        }
        return 0;
    }

    @Override
    protected TextLayout createTextLayout(String string) {
        TextLayout textLayout = ServiceManager.textLayoutManager.performTextLayout(this.getMaxTextLayoutWidth(), this.getMaxTextLayoutHeight(), this.getMaxTextLayoutLineCount(), this.is_shorten(), '\u2026', false, '-', this.getTextStyles(), string, this.getFont());
        if (this.lineBreakMode == 5 && textLayout.isTruncated()) {
            this.clearTextStyle();
            this.setInternalStateFlag(13, true);
            textLayout = ServiceManager.textLayoutManager.performTextLayout(this.getMaxTextLayoutWidth(), this.getMaxTextLayoutHeight(), this.getMaxTextLayoutLineCount(), this.is_shorten(), '\u2026', false, '-', this.getTextStyles(), string, this.getFont());
            this.setInternalStateFlag(13, false);
            this.clearTextStyle();
        }
        this.set_shortened(textLayout.isTruncated());
        if (this.get_dynamicResizeDirection() == 1) {
            Insets insets = this.get_padding();
            int n = textLayout.getWidth() + insets.left + insets.right;
            this.disableTextLayoutUpdates();
            this.set_width(n);
            this.enableTextLayoutUpdates();
        } else if (this.get_dynamicResizeDirection() == 2) {
            Insets insets = this.get_padding();
            int n = this.get_lineSpacing() != 0 ? textLayout.getLineCount() * this.get_lineSpacing() + insets.bottom + insets.top : textLayout.getHeight() + insets.bottom + insets.top;
            this.disableTextLayoutUpdates();
            this.set_height(n);
            this.enableTextLayoutUpdates();
        }
        return textLayout;
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

