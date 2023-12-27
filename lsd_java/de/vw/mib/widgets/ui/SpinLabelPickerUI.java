/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.AbstractTextModel;
import de.vw.mib.widgets.models.SpinLabelModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractTextUI;
import java.io.IOException;

public class SpinLabelPickerUI
extends AbstractTextUI {
    private TextDrawable[] textDrawables;
    private ScaleImageDrawable backgroundImageDrawable;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        super.deInit();
        if (this.textDrawables != null) {
            for (int i2 = 0; i2 < this.textDrawables.length; ++i2) {
                if (this.textDrawables[i2] == null) continue;
                this.textDrawables[i2].dispose();
                this.textDrawables[i2] = null;
            }
            if (this.backgroundImageDrawable != null) {
                this.backgroundImageDrawable.dispose();
                this.backgroundImageDrawable = null;
            }
        }
    }

    @Override
    protected void paintContent(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2, TextLayout textLayout, Color4b color4b, int n, int n2) {
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        SpinLabelModel spinLabelModel = (SpinLabelModel)widgetModel;
        int n = spinLabelModel.getItemHeight();
        int n2 = spinLabelModel.getLastIndex();
        int n3 = Util.divideAndCeil(spinLabelModel.get_height(), n) + 2;
        int n4 = (spinLabelModel.get_height() >> 1) - (n >> 1);
        Image image = spinLabelModel.get_backgroundImage();
        int n5 = spinLabelModel.getScrollPosition();
        int n6 = spinLabelModel.get_baselineOffset();
        n5 -= n4;
        int n7 = spinLabelModel.getLastIndex() * spinLabelModel.getItemHeight();
        if (n7 > 0) {
            int n8;
            Object object;
            if (spinLabelModel.is_cyclic()) {
                if (n5 < 0) {
                    n5 = n7 + n5 % n7;
                } else if (n5 >= n7) {
                    n5 %= n7;
                }
            }
            if (spinLabelModel.isInvalid() || this.backgroundImageDrawable == null) {
                try {
                    BufferImage bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(image);
                    if (this.backgroundImageDrawable == null) {
                        this.backgroundImageDrawable = graphics3D.getDrawableManager().createScaleImageDrawable();
                    }
                    this.backgroundImageDrawable.setImage(bufferImage);
                    this.backgroundImageDrawable.setScaleImage(image.getCurrentImage());
                    this.backgroundImageDrawable.setWidth(spinLabelModel.get_width());
                    this.backgroundImageDrawable.setHeight(n);
                }
                catch (IOException iOException) {
                    object = LOGGER.error(2);
                    object.append("Widget '").append(spinLabelModel.getQualifiedName()).append("': Unable to load image: ").append(iOException).log();
                }
            }
            int n9 = n5 / n;
            object = new Rectangle(0, 0, rectangle2.width, rectangle2.height);
            this.enableClipping(graphics3D, rectangle, (Rectangle)object, rectangle2);
            if (this.textDrawables == null || n3 != this.textDrawables.length) {
                if (this.textDrawables != null) {
                    for (n8 = 0; n8 < this.textDrawables.length; ++n8) {
                        if (this.textDrawables[n8] == null) continue;
                        this.textDrawables[n8].dispose();
                    }
                }
                this.textDrawables = new TextDrawable[n3];
            }
            n8 = n9 * n - n5;
            for (int i2 = 0; i2 < n3; ++i2) {
                int n10 = spinLabelModel.is_cyclic() ? (n9 + i2) % n2 : n9 + i2;
                if (n10 < 0 || n10 >= n2) continue;
                TextLayout textLayout = spinLabelModel.getTextLayout(n10);
                int n11 = n10 % n3;
                if (this.textDrawables[n11] == null) {
                    this.textDrawables[n11] = graphics3D.getDrawableManager().createTextDrawable();
                }
                SpinLabelPickerUI.updateDrawable(this.textDrawables[n11], textLayout, spinLabelModel.getTextStyles(), spinLabelModel.getFont(), 0, -129);
                if (this.backgroundImageDrawable != null) {
                    this.backgroundImageDrawable.draw(0.0f, i2 * n + n8);
                }
                int n12 = i2 * n + n8 + n6;
                if (spinLabelModel.get_bevelDepth() > 0) {
                    SpinLabelPickerUI.paintBeveledText(graphics3D, spinLabelModel, this.textDrawables[n11], n12);
                }
                this.textDrawables[n11].setColor(spinLabelModel.get_colorForeground().getCurrentColor());
                this.textDrawables[n11].draw(0.0f, n12);
            }
            this.disableClipping(graphics3D);
        }
    }

    private static void paintBeveledText(Graphics3D graphics3D, AbstractTextModel abstractTextModel, TextDrawable textDrawable, int n) {
        int n2 = abstractTextModel.get_bevelEnabled();
        if (abstractTextModel.get_colorLowerBevel() != null && abstractTextModel.get_colorUpperBevel() != null) {
            for (int i2 = abstractTextModel.get_bevelDepth(); i2 > 0; --i2) {
                if ((n2 & 4) != 0) {
                    textDrawable.setColor(abstractTextModel.get_colorLowerBevel().getCurrentColor());
                    textDrawable.draw(0.0f, i2 + n + 1);
                }
                if ((n2 & 1) != 0) {
                    textDrawable.setColor(abstractTextModel.get_colorUpperBevel().getCurrentColor());
                    textDrawable.draw(0.0f, -i2 + n);
                }
                if ((n2 & 2) != 0) {
                    textDrawable.setColor(abstractTextModel.get_colorUpperBevel().getCurrentColor());
                    textDrawable.draw(-i2, 0 + n);
                }
                if ((n2 & 8) == 0) continue;
                textDrawable.setColor(abstractTextModel.get_colorLowerBevel().getCurrentColor());
                textDrawable.draw(i2, 0 + n);
            }
        }
    }
}

