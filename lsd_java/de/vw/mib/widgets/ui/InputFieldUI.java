/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.spi.layout.TextLineLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.InputFieldModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.TextAreaUI;
import java.io.IOException;

public final class InputFieldUI
extends TextAreaUI {
    private final Rectangle clipRect = new Rectangle();
    private final Rectangle cursorRect = new Rectangle();
    private TextDrawable shortenDrawable;
    private TextDrawable[] matchFinalizerDrawables;
    private ScaleImageDrawable cursorDrawable;

    @Override
    public void deInit() {
        if (this.shortenDrawable != null) {
            this.shortenDrawable.dispose();
            this.shortenDrawable = null;
        }
        this.disposeMatchTextDrawables();
        if (this.cursorDrawable != null) {
            this.cursorDrawable.dispose();
            this.cursorDrawable = null;
        }
        super.deInit();
    }

    private void disposeMatchTextDrawables() {
        if (this.matchFinalizerDrawables != null) {
            for (int i2 = 0; i2 < this.matchFinalizerDrawables.length; ++i2) {
                if (this.matchFinalizerDrawables[i2] == null) continue;
                this.matchFinalizerDrawables[i2].dispose();
            }
            this.matchFinalizerDrawables = null;
        }
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        int n;
        int n2;
        InputFieldModel inputFieldModel = (InputFieldModel)widgetModel;
        int n3 = inputFieldModel.getViewPortPosition();
        TextLayout textLayout = inputFieldModel.getTextLayout();
        TextStyle[] textStyleArray = inputFieldModel.getTextStyles();
        boolean bl = inputFieldModel.get_alignmentHorizontal() == 2;
        int n4 = inputFieldModel.getMaxLineWidth();
        int n5 = inputFieldModel.get_width();
        TextLayout textLayout2 = inputFieldModel.getTruncationTextlayout();
        if (!bl && n3 > 0 || bl && n3 < inputFieldModel.getMaximum()) {
            n2 = textLayout2.getWidth() + (bl ? n4 - n3 - n5 : n3);
            n = InputFieldUI.getFirstCompletlyVisibleGlyphPosition(textLayout, n2) - n2 + textLayout2.getWidth();
            this.shortenDrawable = InputFieldUI.updateAndPaintDrawable(graphics3D, inputFieldModel, textLayout2, textStyleArray, f2, n - (bl ? n4 : textLayout2.getWidth()), inputFieldModel.get_colorForeground(), this.shortenDrawable);
        } else {
            n = 0;
        }
        if (bl && n3 > 0 || !bl && n3 < inputFieldModel.getMaximum()) {
            int n6 = (bl ? n4 - n3 : n3 + n5) - textLayout2.getWidth();
            n2 = InputFieldUI.getLastCompletelyVisibleGlyphPosition(textLayout, n6) - n6 + n5 - textLayout2.getWidth();
            this.shortenDrawable = InputFieldUI.updateAndPaintDrawable(graphics3D, inputFieldModel, textLayout2, textStyleArray, f2, n2 - (bl ? n4 - textLayout2.getWidth() : 0), inputFieldModel.get_colorForeground(), this.shortenDrawable);
        } else {
            n2 = n5;
        }
        this.clipRect.setBounds(n, 0, n2 - n + 1, inputFieldModel.get_height() + inputFieldModel.get_baselineOffset());
        super.paint(graphics3D, viewModel, inputFieldModel, rectangle, rectangle2, f2);
        if (inputFieldModel.isMatchTextVisible()) {
            TextLayout[] textLayoutArray = inputFieldModel.getMatchTextLayouts();
            int n7 = n;
            n7 = !bl ? (n7 += textLayout.getWidth() + 50) : (n7 -= textLayout.getWidth() + 50 - inputFieldModel.getMaxLineWidth());
            if (this.matchFinalizerDrawables == null || this.matchFinalizerDrawables.length != textLayoutArray.length) {
                this.disposeMatchTextDrawables();
                this.matchFinalizerDrawables = new TextDrawable[textLayoutArray.length];
            }
            for (int i2 = 0; i2 < textLayoutArray.length; ++i2) {
                int n8;
                if (bl) {
                    n8 = textLayoutArray.length - i2 - 1;
                    n7 -= textLayoutArray[n8].getWidth();
                } else {
                    n8 = i2;
                }
                this.matchFinalizerDrawables[n8] = InputFieldUI.updateAndPaintDrawable(graphics3D, inputFieldModel, textLayoutArray[n8], inputFieldModel.getMatchTextStyle(), f2, n7, inputFieldModel.getMatchColorForeground(), this.matchFinalizerDrawables[n8]);
                if (bl) continue;
                n7 += textLayoutArray[n8].getWidth();
            }
        }
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2, TextLayout textLayout, Color4b color4b, int n, int n2) {
        InputFieldModel inputFieldModel = (InputFieldModel)widgetModel;
        boolean bl = inputFieldModel.isVertical();
        int n3 = bl || inputFieldModel.isMatchTextVisible() ? n : (inputFieldModel.get_alignmentHorizontal() == 2 ? n - Short.MAX_VALUE + inputFieldModel.getViewPortPosition() + inputFieldModel.get_width() : n - inputFieldModel.getViewPortPosition());
        int n4 = bl ? n2 - inputFieldModel.getViewPortPosition() : n2;
        this.enableClipping(graphics3D, rectangle, this.clipRect, rectangle2);
        super.paintContent(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2, textLayout, color4b, n3, n4);
        this.disableClipping(graphics3D);
        if (inputFieldModel.isCursorVisible()) {
            this.paintCursor(graphics3D, inputFieldModel, n3, n4);
        }
    }

    private static TextDrawable updateAndPaintDrawable(Graphics3D graphics3D, InputFieldModel inputFieldModel, TextLayout textLayout, TextStyle[] textStyleArray, float f2, int n, Color color, TextDrawable textDrawable) {
        int n2;
        Insets insets = inputFieldModel.get_padding();
        switch (inputFieldModel.get_alignmentVertical()) {
            case 1: {
                n2 = (inputFieldModel.get_height() >> 1) - (textLayout.getHeight() >> 1) + inputFieldModel.get_baselineOffset();
                break;
            }
            case 2: {
                n2 = inputFieldModel.get_height() - textLayout.getHeight() - insets.bottom + inputFieldModel.get_baselineOffset();
                break;
            }
            default: {
                n2 = insets.top + inputFieldModel.get_baselineOffset();
            }
        }
        if (inputFieldModel.isDirty()) {
            if (textDrawable == null) {
                textDrawable = graphics3D.getDrawableManager().createTextDrawable();
            }
            InputFieldUI.updateDrawable(textDrawable, textLayout, textStyleArray, inputFieldModel.getFont(), 0, -129);
        }
        textDrawable.setColor(color.getCurrentColor());
        textDrawable.setAlpha(f2);
        textDrawable.draw(n, n2);
        return textDrawable;
    }

    private static int getFirstCompletlyVisibleGlyphPosition(TextLayout textLayout, int n) {
        int n2;
        if (textLayout.getLineCount() == 0) {
            return 0;
        }
        TextLineLayout textLineLayout = textLayout.getTextLine(0);
        n -= textLineLayout.getLeft();
        for (n2 = 0; n2 < textLineLayout.getGlyphCount() - 1 && textLineLayout.getGlyph(n2).getCaretX() >> 6 < n; ++n2) {
        }
        int n3 = textLineLayout.getGlyph(n2).getX();
        return textLineLayout.getLeft() + n3;
    }

    private static int getLastCompletelyVisibleGlyphPosition(TextLayout textLayout, int n) {
        int n2;
        if (textLayout.getLineCount() == 0) {
            return 0;
        }
        TextLineLayout textLineLayout = textLayout.getTextLine(0);
        n -= textLineLayout.getLeft();
        for (n2 = textLineLayout.getGlyphCount() - 1; n2 > 0 && textLineLayout.getGlyph(n2).getX() + textLineLayout.getGlyph(n2).getWidth() > n; --n2) {
        }
        int n3 = textLineLayout.getLeft() + textLineLayout.getGlyph(n2).getX() + textLineLayout.getGlyph(n2).getWidth();
        return n3;
    }

    private void paintCursor(Graphics3D graphics3D, InputFieldModel inputFieldModel, int n, int n2) {
        ScaleImage scaleImage;
        Image image;
        Rectangle rectangle = inputFieldModel.getCursorArea();
        if (rectangle != null && (image = inputFieldModel.get_cursorImage()) != null && !(scaleImage = image.getCurrentImage()).isEmpty()) {
            boolean bl = inputFieldModel.isInvalid();
            if (this.cursorDrawable == null) {
                this.cursorDrawable = graphics3D.getDrawableManager().createScaleImageDrawable();
                bl = true;
            }
            if (bl) {
                try {
                    BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage);
                    this.cursorDrawable.setImage(bufferImage);
                    this.cursorDrawable.setScaleImage(scaleImage);
                    this.cursorDrawable.setWidth(bufferImage.getWidth());
                    this.cursorDrawable.setHeight(bufferImage.getHeight());
                    this.cursorRect.setWidth(bufferImage.getWidth());
                    this.cursorRect.setHeight(bufferImage.getHeight());
                }
                catch (IOException iOException) {
                    LogMessage logMessage = LOGGER.error(2);
                    logMessage.append("InputField '").append(inputFieldModel.getQualifiedName()).append("': Unable to paint cursor image: ").append(iOException).log();
                }
            }
            this.cursorRect.setX(n + rectangle.x - (this.cursorDrawable.getWidth() >> 1));
            this.cursorRect.setY(n2 + rectangle.y + inputFieldModel.get_cursorOffset());
            if (this.clipRect.intersects(this.cursorRect)) {
                this.cursorDrawable.draw(this.cursorRect.getX(), this.cursorRect.getY());
            }
        }
    }
}

