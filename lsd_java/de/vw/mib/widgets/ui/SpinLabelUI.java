/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.offscreen.OffscreenDrawable;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.SpinLabelModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractTextUI;
import java.io.IOException;

public final class SpinLabelUI
extends AbstractTextUI {
    private static final int DRAW_MODE_OLD;
    private static final int DRAW_MODE_NEW;
    private static final int PART_UPPER;
    private static final int PART_LOWER;
    private TextDrawable oldTextDrawable;
    private TextDrawable textDrawable;
    private ScaleImageDrawable separatorImage;
    private ScaleImageDrawable backgroundImage;
    private int indexOld;
    private int indexNew;
    private final OffscreenDrawable[][] offscreenDrawables = new OffscreenDrawable[2][2];

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        for (int i2 = 0; i2 < this.offscreenDrawables.length; ++i2) {
            for (int i3 = 0; i3 < this.offscreenDrawables[i2].length; ++i3) {
                if (this.offscreenDrawables[i2][i3] == null) continue;
                this.offscreenDrawables[i2][i3].dispose();
                this.offscreenDrawables[i2][i3] = null;
            }
        }
        if (this.textDrawable != null) {
            this.textDrawable.dispose();
            this.textDrawable = null;
        }
        if (this.oldTextDrawable != null) {
            this.oldTextDrawable.dispose();
            this.oldTextDrawable = null;
        }
        if (this.separatorImage != null) {
            this.separatorImage.dispose();
            this.separatorImage = null;
        }
        if (this.backgroundImage != null) {
            this.backgroundImage.dispose();
            this.backgroundImage = null;
        }
        super.deInit();
    }

    @Override
    public void paintContent(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2, TextLayout textLayout, Color4b color4b, int n, int n2) {
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        SpinLabelModel spinLabelModel = (SpinLabelModel)widgetModel;
        if (spinLabelModel.isInvalid() || this.separatorImage == null) {
            this.separatorImage = SpinLabelUI.updateScaleImageDrawable(graphics3D, spinLabelModel, spinLabelModel.get_separatorImage(), this.separatorImage);
        }
        if (spinLabelModel.isInvalid() || this.backgroundImage == null) {
            this.backgroundImage = SpinLabelUI.updateScaleImageDrawable(graphics3D, spinLabelModel, spinLabelModel.get_backgroundImage(), this.backgroundImage);
        }
        int n = SpinLabelUI.getTextIndex(spinLabelModel, 1);
        int n2 = SpinLabelUI.getTextIndex(spinLabelModel, 0);
        boolean bl = spinLabelModel.isInvalid() || this.indexOld != n2 || this.indexNew != n;
        this.paintLeaves(graphics3D, spinLabelModel, rectangle2, f2, bl);
        if (this.separatorImage != null) {
            this.separatorImage.draw();
        }
    }

    private void paintLeaves(Graphics3D graphics3D, SpinLabelModel spinLabelModel, Rectangle rectangle, float f2, boolean bl) {
        int n = SpinLabelUI.getTextIndex(spinLabelModel, 1);
        int n2 = SpinLabelUI.getTextIndex(spinLabelModel, 0);
        float f3 = spinLabelModel.getScrollPosition();
        float f4 = (f3 / (float)spinLabelModel.getItemHeight() - (float)Math.floor(f3 / (float)spinLabelModel.getItemHeight())) * 13379;
        graphics3D.pushMatrix(0);
        if (spinLabelModel.get_mode() != 0 || spinLabelModel.is_spinDirectionUp()) {
            this.updateAndPaintTexture(graphics3D, spinLabelModel, rectangle, 0, 0, n2, bl, 0, f2);
            this.updateAndPaintTexture(graphics3D, spinLabelModel, rectangle, 1, 1, n, bl, spinLabelModel.get_height() >> 1, f2);
            if (f4 <= 46146) {
                SpinLabelUI.rotate(graphics3D, spinLabelModel.get_height() >> 1, f4);
                this.updateAndPaintTexture(graphics3D, spinLabelModel, rectangle, 0, 1, n2, bl, 0, f2);
            } else {
                SpinLabelUI.rotate(graphics3D, spinLabelModel.get_height() >> 1, 13379 + f4);
                this.updateAndPaintTexture(graphics3D, spinLabelModel, rectangle, 1, 0, n, bl, -(spinLabelModel.get_height() >> 1), f2);
            }
        } else {
            this.updateAndPaintTexture(graphics3D, spinLabelModel, rectangle, 1, 0, n, bl, 0, f2);
            this.updateAndPaintTexture(graphics3D, spinLabelModel, rectangle, 0, 1, n2, bl, spinLabelModel.get_height() >> 1, f2);
            if (f4 <= 46146) {
                SpinLabelUI.rotate(graphics3D, spinLabelModel.get_height() >> 1, -f4);
                this.updateAndPaintTexture(graphics3D, spinLabelModel, rectangle, 0, 0, n2, bl, -(spinLabelModel.get_height() >> 1), f2);
            } else {
                SpinLabelUI.rotate(graphics3D, spinLabelModel.get_height() >> 1, 13379 - f4);
                this.updateAndPaintTexture(graphics3D, spinLabelModel, rectangle, 1, 1, n, bl, 0, f2);
            }
        }
        graphics3D.popMatrix(0);
    }

    private void updateAndPaintTexture(Graphics3D graphics3D, SpinLabelModel spinLabelModel, Rectangle rectangle, int n, int n2, int n3, boolean bl, int n4, float f2) {
        if (this.offscreenDrawables[n][n2] == null || !this.offscreenDrawables[n][n2].isValid()) {
            this.offscreenDrawables[n][n2] = this.createOffscreenDrawable(graphics3D, this.offscreenDrawables[n][n2], spinLabelModel.get_width(), spinLabelModel.get_height() >> 1);
            bl = true;
        }
        if (bl) {
            this.updateOffscreenDrawable(graphics3D, spinLabelModel, rectangle, this.offscreenDrawables[n][n2], n, n2, n3);
        }
        if (this.offscreenDrawables[n][n2] != null) {
            this.offscreenDrawables[n][n2].setAlpha(f2);
            this.offscreenDrawables[n][n2].draw(0.0f, n4);
        }
    }

    private static void rotate(Graphics3D graphics3D, int n, float f2) {
        graphics3D.translateMatrix(0, 0.0f, n, 0.0f);
        graphics3D.rotateMatrix(0, f2, 1.0f, 0.0f, 0.0f);
    }

    private static ScaleImageDrawable updateScaleImageDrawable(Graphics3D graphics3D, SpinLabelModel spinLabelModel, Image image, ScaleImageDrawable scaleImageDrawable) {
        ScaleImage scaleImage = image.getCurrentImage();
        try {
            BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage);
            if (scaleImageDrawable == null) {
                scaleImageDrawable = graphics3D.getDrawableManager().createScaleImageDrawable();
            }
            scaleImageDrawable.setImage(bufferImage);
            scaleImageDrawable.setScaleImage(scaleImage);
            scaleImageDrawable.setWidth(spinLabelModel.get_width());
            scaleImageDrawable.setHeight(bufferImage.getHeight());
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(2);
            logMessage.append("Widget '").append(spinLabelModel.getQualifiedName()).append("': Unable to load image: ").append(iOException).log();
        }
        return scaleImageDrawable;
    }

    private static int getTextIndex(SpinLabelModel spinLabelModel, int n) {
        if (spinLabelModel.getItemHeight() == 0 || spinLabelModel.getLastIndex() == 0) {
            return 0;
        }
        if (spinLabelModel.get_mode() == 0) {
            return n == 0 ? 1 : 0;
        }
        if (n == 0) {
            return (int)((float)spinLabelModel.getScrollPosition() / (float)spinLabelModel.getItemHeight()) % spinLabelModel.getLastIndex();
        }
        return (int)Math.ceil((float)spinLabelModel.getScrollPosition() / (float)spinLabelModel.getItemHeight()) % spinLabelModel.getLastIndex();
    }

    private void drawText(Graphics3D graphics3D, SpinLabelModel spinLabelModel, int n, int n2) {
        TextDrawable textDrawable;
        Font font = spinLabelModel.getFont();
        if (n == 0) {
            if (this.oldTextDrawable == null) {
                this.oldTextDrawable = graphics3D.getDrawableManager().createTextDrawable();
            }
            textDrawable = this.oldTextDrawable;
        } else {
            if (this.textDrawable == null) {
                this.textDrawable = graphics3D.getDrawableManager().createTextDrawable();
            }
            textDrawable = this.textDrawable;
        }
        TextLayout textLayout = spinLabelModel.getTextLayout(n2);
        SpinLabelUI.updateDrawable(textDrawable, textLayout, spinLabelModel.getTextStyles(), font, 0, -129);
        if (font != null) {
            Insets insets = spinLabelModel.get_padding();
            TextStyle textStyle = spinLabelModel.getTextStyles()[0];
            int n3 = insets.top + (spinLabelModel.get_height() - (font.getHeight(textStyle.getGlyphStyle().getFontSize()) >> 6) >> 1);
            textDrawable.setColor(spinLabelModel.get_colorForeground().getCurrentColor());
            textDrawable.draw(0.0f, n3);
        }
    }

    private void updateOffscreenDrawable(Graphics3D graphics3D, SpinLabelModel spinLabelModel, Rectangle rectangle, OffscreenDrawable offscreenDrawable, int n, int n2, int n3) {
        int n4 = spinLabelModel.get_height() >> 1;
        int n5 = n2 == 1 ? n4 : 0;
        offscreenDrawable.prepareGraphics(graphics3D, rectangle, 0);
        this.backgroundImage.draw(0.0f, -n5);
        if (1 == n2) {
            graphics3D.translateMatrix(0, 0.0f, -n4, 0.0f);
        }
        this.drawText(graphics3D, spinLabelModel, n, n3);
        offscreenDrawable.restoreGraphics(graphics3D, rectangle);
    }

    private OffscreenDrawable createOffscreenDrawable(Graphics3D graphics3D, OffscreenDrawable offscreenDrawable, int n, int n2) {
        if (offscreenDrawable == null || offscreenDrawable.getWidth() != n || offscreenDrawable.getHeight() != n2) {
            if (offscreenDrawable != null) {
                offscreenDrawable.dispose();
                offscreenDrawable = null;
            }
            offscreenDrawable = graphics3D.getDrawableManager().createOffscreenDrawable(n, n2, false);
        }
        return offscreenDrawable;
    }
}

