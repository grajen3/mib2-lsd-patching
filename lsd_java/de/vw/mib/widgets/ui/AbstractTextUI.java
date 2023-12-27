/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.shape.RectangleDrawable;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.widgets.interfaces.DecoratableUI;
import de.vw.mib.widgets.interfaces.Glowable$GlowDecoratonConfigurator;
import de.vw.mib.widgets.models.AbstractTextModel;
import de.vw.mib.widgets.models.AbstractTextModel$TextHighlight;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractTextUI$TextAttributeDrawableCreator;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.util.EffectDecorator;
import java.util.List;

public abstract class AbstractTextUI
extends AbstractWidgetUI
implements DecoratableUI {
    private RectangleDrawable backgroundDrawable;
    private EffectDecorator effectDecorator;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        if (this.backgroundDrawable != null) {
            this.backgroundDrawable.dispose();
            this.backgroundDrawable = null;
        }
        if (this.effectDecorator != null) {
            this.effectDecorator.dispose();
            this.effectDecorator = null;
        }
        super.deInit();
    }

    public void paintDecoratableWidgetContent(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        AbstractTextModel abstractTextModel = (AbstractTextModel)widgetModel;
        if (abstractTextModel.get_bevelDepth() > 0 && abstractTextModel.get_bevelEnabled() != 0) {
            this.paintBeveledText(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, f2);
        }
        if (abstractTextModel.getColorFadingProgress() > 0.0f) {
            this.paintColorFadedText(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, f2);
        } else {
            this.paintContentFadedText(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, abstractTextModel.get_colorForeground().getCurrentColor(), f2, 0, 0);
        }
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        AbstractTextModel abstractTextModel = (AbstractTextModel)widgetModel;
        boolean bl = abstractTextModel.isInvalid();
        if (bl) {
            Color4b color4b = abstractTextModel.get_colorBackground().getCurrentColor();
            if (!color4b.isFullyTransparent()) {
                if (this.backgroundDrawable == null) {
                    this.backgroundDrawable = graphics3D.getDrawableManager().createRectangleDrawable();
                }
                this.backgroundDrawable.set(0, 0, rectangle2.getWidth(), rectangle2.getHeight());
            }
            if (this.effectDecorator != null) {
                this.effectDecorator.invalidate();
            }
        }
        if (this.backgroundDrawable != null) {
            this.backgroundDrawable.setColor(abstractTextModel.get_colorBackground().getCurrentColor());
            this.backgroundDrawable.draw();
        }
        if (abstractTextModel.get_glowType() != 0 && abstractTextModel.getGlowAlpha() > 0.0f) {
            if (this.effectDecorator == null) {
                this.effectDecorator = new EffectDecorator(this);
                Glowable$GlowDecoratonConfigurator.configureGlowEffect(abstractTextModel.get_glowType(), this.effectDecorator, abstractTextModel.get_glowColor().getCurrentColor());
            }
            this.effectDecorator.draw(graphics3D, rectangle, rectangle2, f2 * abstractTextModel.getGlowAlpha());
        }
        this.paintDecoratableWidgetContent(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
    }

    protected abstract void paintContent(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2, TextLayout textLayout, Color4b color4b, int n, int n2) {
    }

    private void paintBeveledText(Graphics3D graphics3D, ViewModel viewModel, AbstractTextModel abstractTextModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        int n = abstractTextModel.get_bevelEnabled();
        if (abstractTextModel.get_colorLowerBevel() != null && abstractTextModel.get_colorUpperBevel() != null) {
            for (int i2 = abstractTextModel.get_bevelDepth(); i2 > 0; --i2) {
                if ((n & 4) != 0) {
                    this.paintContentFadedText(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, abstractTextModel.get_colorLowerBevel().getCurrentColor(), f2, 0, i2);
                }
                if ((n & 1) != 0) {
                    this.paintContentFadedText(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, abstractTextModel.get_colorUpperBevel().getCurrentColor(), f2, 0, -i2);
                }
                if ((n & 2) != 0) {
                    this.paintContentFadedText(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, abstractTextModel.get_colorUpperBevel().getCurrentColor(), f2, -i2, 0);
                }
                if ((n & 8) == 0) continue;
                this.paintContentFadedText(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, abstractTextModel.get_colorLowerBevel().getCurrentColor(), f2, i2, 0);
            }
        }
    }

    private void paintColorFadedText(Graphics3D graphics3D, ViewModel viewModel, AbstractTextModel abstractTextModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        float f3 = abstractTextModel.getColorFadingProgress();
        float f4 = f2 * f3;
        float f5 = f2 * (1.0f - f3);
        this.paintContentFadedText(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, abstractTextModel.get_colorForeground().getCurrentColor(), f5, 0, 0);
        this.paintContentFadedText(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, abstractTextModel.getLastColor().getCurrentColor(), f4, 0, 0);
    }

    private void paintContentFadedText(Graphics3D graphics3D, ViewModel viewModel, AbstractTextModel abstractTextModel, Rectangle rectangle, Rectangle rectangle2, Color4b color4b, float f2, int n, int n2) {
        float f3;
        TextLayout textLayout;
        if (abstractTextModel.isContentFadeOutAnimationActive()) {
            textLayout = abstractTextModel.getContentFadeOutTextLines();
            f3 = abstractTextModel.getContentFadeOutAlpha();
            if (textLayout != null) {
                this.paintContent(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, f2 * f3, textLayout, color4b, n, n2);
            }
        }
        if (abstractTextModel.isContentFadeInAnimationActive()) {
            textLayout = abstractTextModel.getContentFadeInTextLines();
            f3 = abstractTextModel.getContentFadeInAlpha();
            this.paintContent(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, f2 * f3, textLayout, color4b, n, n2);
        } else {
            textLayout = abstractTextModel.getTextLayout();
            this.paintContent(graphics3D, viewModel, abstractTextModel, rectangle, rectangle2, f2, textLayout, color4b, n, n2);
        }
    }

    protected static final void updateDrawable(TextDrawable textDrawable, TextLayout textLayout, TextStyle[] textStyleArray, Font font, int n, int n2) {
        textDrawable.setTextLayout(textLayout);
        textDrawable.setTextStyles(textStyleArray);
        textDrawable.setFont(font);
        textDrawable.setIntervalStart(n);
        textDrawable.setIntervalEnd(n2);
    }

    protected static final void addTextDrawable(Graphics3D graphics3D, List list, TextLayout textLayout, TextStyle[] textStyleArray, Font font, int n, int n2) {
        TextDrawable textDrawable = graphics3D.getDrawableManager().createTextDrawable();
        AbstractTextUI.updateDrawable(textDrawable, textLayout, textStyleArray, font, n, n2);
        list.add(textDrawable);
    }

    protected static final void removeObsoleteDisposables(List list, int n) {
        for (int i2 = list.size() - 1; i2 >= n; --i2) {
            Disposable disposable = (Disposable)list.remove(i2);
            disposable.dispose();
        }
    }

    protected static void createDrawables(Graphics3D graphics3D, List list, TextLayout textLayout, TextStyle[] textStyleArray, Font font, Color4b color4b, List list2, List list3) {
        AbstractTextUI.createDrawables(graphics3D, list, textLayout, textStyleArray, font, color4b, 0, -129, list2, list3);
    }

    protected static void createDrawables(Graphics3D graphics3D, List list, TextLayout textLayout, TextStyle[] textStyleArray, Font font, Color4b color4b, int n, int n2, List list2, List list3) {
        int n3 = n;
        int n4 = 0;
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                AbstractTextModel$TextHighlight abstractTextModel$TextHighlight = (AbstractTextModel$TextHighlight)list.get(i2);
                if (abstractTextModel$TextHighlight == null || abstractTextModel$TextHighlight.getColorForeground() == null || abstractTextModel$TextHighlight.getEndOffset() < n || abstractTextModel$TextHighlight.getStartOffset() > n2) continue;
                if (abstractTextModel$TextHighlight.getStartOffset() != n3) {
                    AbstractTextUI.addTextDrawable(graphics3D, list2, textLayout, textStyleArray, font, n3, abstractTextModel$TextHighlight.getStartOffset() - 1);
                    list3.add(color4b);
                    n4 = AbstractTextUI.addUnderlineStrikeoutDrawables(graphics3D, textLayout, textStyleArray, n4, color4b, n3, abstractTextModel$TextHighlight.getStartOffset(), list2, list3);
                }
                AbstractTextUI.addTextDrawable(graphics3D, list2, textLayout, textStyleArray, font, abstractTextModel$TextHighlight.getStartOffset(), abstractTextModel$TextHighlight.getEndOffset() - 1);
                list3.add(abstractTextModel$TextHighlight.getColorForeground().getCurrentColor());
                n4 = AbstractTextUI.addUnderlineStrikeoutDrawables(graphics3D, textLayout, textStyleArray, n4, abstractTextModel$TextHighlight.getColorForeground().getCurrentColor(), abstractTextModel$TextHighlight.getStartOffset(), abstractTextModel$TextHighlight.getEndOffset(), list2, list3);
                if (abstractTextModel$TextHighlight.getColorBackground() != null && !abstractTextModel$TextHighlight.getColorBackground().getCurrentColor().isFullyTransparent()) {
                    AbstractTextUI.addTextAttributeDrawables(graphics3D, AbstractTextUI$TextAttributeDrawableCreator.HIGHLIGHT_BACKGROUND_DRAWABLE_CREATOR, textLayout, abstractTextModel$TextHighlight.getStartOffset(), abstractTextModel$TextHighlight.getEndOffset(), abstractTextModel$TextHighlight.getColorBackground().getCurrentColor(), list2, list3);
                }
                n3 = abstractTextModel$TextHighlight.getEndOffset();
            }
        }
        if (n3 <= n2) {
            AbstractTextUI.addTextDrawable(graphics3D, list2, textLayout, textStyleArray, font, n3, n2);
            list3.add(color4b);
            AbstractTextUI.addUnderlineStrikeoutDrawables(graphics3D, textLayout, textStyleArray, n4, color4b, n3, -129, list2, list3);
        }
    }

    private static int addUnderlineStrikeoutDrawables(Graphics3D graphics3D, TextLayout textLayout, TextStyle[] textStyleArray, int n, Color4b color4b, int n2, int n3, List list, List list2) {
        while (n < textStyleArray.length && textStyleArray[n].getStartIndex() < n3) {
            TextStyle textStyle = textStyleArray[n];
            boolean bl = textStyle.getGlyphStyle().isUnderline();
            boolean bl2 = textStyle.getGlyphStyle().isStrikeOut();
            if (bl) {
                AbstractTextUI.addTextAttributeDrawables(graphics3D, AbstractTextUI$TextAttributeDrawableCreator.UNDERLINE_DRAWABLE_CREATOR, textLayout, Math.max(textStyle.getStartIndex(), n2), Math.min(textStyle.getEndIndex(), n3), color4b, list, list2);
            }
            if (bl2) {
                AbstractTextUI.addTextAttributeDrawables(graphics3D, AbstractTextUI$TextAttributeDrawableCreator.STRIKEOUT_DRAWABLE_CREATOR, textLayout, Math.max(textStyle.getStartIndex(), n2), Math.min(textStyle.getEndIndex(), n3), color4b, list, list2);
            }
            ++n;
        }
        return Math.max(0, n - 1);
    }

    private static void addTextLineAttributeDrawables(Graphics3D graphics3D, AbstractTextUI$TextAttributeDrawableCreator abstractTextUI$TextAttributeDrawableCreator, TextLayout textLayout, int n, int n2, int n3, Color4b color4b, List list, List list2) {
        int n4 = -1;
        TextLineLayout textLineLayout = textLayout.getTextLine(n);
        for (int i2 = 0; i2 < textLineLayout.getGlyphCount(); ++i2) {
            int n5 = textLineLayout.getGlyph(i2).getSourceIndex();
            if (n5 >= n2 && n5 < n3) {
                if (n4 != -1) continue;
                n4 = i2;
                continue;
            }
            if (n4 == -1) continue;
            list.add(abstractTextUI$TextAttributeDrawableCreator.createDrawable(graphics3D, textLineLayout, n4, i2 - 1));
            list2.add(color4b);
            n4 = -1;
        }
        if (n4 != -1) {
            list.add(abstractTextUI$TextAttributeDrawableCreator.createDrawable(graphics3D, textLineLayout, n4, textLineLayout.getGlyphCount() - 1));
            list2.add(color4b);
        }
    }

    private static void addTextAttributeDrawables(Graphics3D graphics3D, AbstractTextUI$TextAttributeDrawableCreator abstractTextUI$TextAttributeDrawableCreator, TextLayout textLayout, int n, int n2, Color4b color4b, List list, List list2) {
        int n3 = textLayout.findRowBySourceIndex(n);
        int n4 = textLayout.findRowBySourceIndex(n2);
        if (n3 < textLayout.getLineCount()) {
            if (n3 != -1) {
                AbstractTextUI.addTextLineAttributeDrawables(graphics3D, abstractTextUI$TextAttributeDrawableCreator, textLayout, n3, n, n2, color4b, list, list2);
            }
            if (n3 != n4 && n4 < textLayout.getLineCount()) {
                AbstractTextUI.addTextLineAttributeDrawables(graphics3D, abstractTextUI$TextAttributeDrawableCreator, textLayout, n4, n, n2, color4b, list, list2);
            }
            for (int i2 = n3 + 1; i2 < n4; ++i2) {
                TextLineLayout textLineLayout = textLayout.getTextLine(i2);
                list.add(abstractTextUI$TextAttributeDrawableCreator.createDrawable(graphics3D, textLineLayout, 0, textLineLayout.getGlyphCount() - 1));
                list2.add(color4b);
            }
        }
    }

    @Override
    public void drawDecoratableContent(Graphics3D graphics3D, Rectangle rectangle, Rectangle rectangle2) {
        WidgetModel widgetModel = this.getWidget();
        ViewModel viewModel = widgetModel.getView();
        this.paintDecoratableWidgetContent(graphics3D, viewModel, widgetModel, rectangle, rectangle2, 1.0f);
    }
}

