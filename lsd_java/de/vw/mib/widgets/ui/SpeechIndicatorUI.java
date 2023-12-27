/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.models.SpeechIndicatorModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.ContainerUI;
import java.io.IOException;

public final class SpeechIndicatorUI
extends ContainerUI {
    private static final Color4b DEFAULT_COLOR = new Color4b(0, 255, 255, 0);
    private static final int BORDER_IMAGE_TOP;
    private static final int BORDER_IMAGE_BOTTOM;
    private static final int BORDER_IMAGE_LEFT;
    private static final int BORDER_IMAGE_RIGHT;
    private ScaleImageDrawable[] indicatorDrawables;

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deInit() {
        SpeechIndicatorUI.disposeDrawables(this.indicatorDrawables);
        this.indicatorDrawables = null;
        super.deInit();
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        super.paint(graphics3D, viewModel, widgetModel, rectangle, rectangle2, f2);
        this.paintIndicatorImages(widgetModel, graphics3D);
    }

    protected void paintIndicatorImages(WidgetModel widgetModel, Graphics3D graphics3D) {
        SpeechIndicatorModel speechIndicatorModel = (SpeechIndicatorModel)widgetModel;
        try {
            this.updateSpeechIndicatorImages(graphics3D, speechIndicatorModel);
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(512);
            logMessage.append("Widget '").append(speechIndicatorModel.getQualifiedName()).append("': Unable to load image: ").append(iOException).log();
            this.paintUnavailable(graphics3D, widgetModel);
            return;
        }
        if (speechIndicatorModel.get_recognizerState() != 1 && this.indicatorDrawables.length > 0) {
            Color4b color4b = this.getIndicatorColor(speechIndicatorModel);
            for (int i2 = this.indicatorDrawables.length - 1; i2 >= 0; --i2) {
                this.indicatorDrawables[i2].setColor(color4b);
                this.indicatorDrawables[i2].draw();
            }
        }
    }

    private Color4b getIndicatorColor(SpeechIndicatorModel speechIndicatorModel) {
        switch (speechIndicatorModel.get_recognizerState()) {
            case 0: {
                return speechIndicatorModel.get_recognizerActiveColor().getCurrentColor();
            }
            case 1: {
                return speechIndicatorModel.get_recognizerInactiveColor().getCurrentColor();
            }
            case 2: {
                return speechIndicatorModel.get_recognizerInactiveColor().getCurrentColor();
            }
        }
        return DEFAULT_COLOR;
    }

    private void updateSpeechIndicatorImages(Graphics3D graphics3D, SpeechIndicatorModel speechIndicatorModel) {
        Image[] imageArray = speechIndicatorModel.get_indicatorImages();
        this.indicatorDrawables = SpeechIndicatorUI.updateScaleImageDrawables(graphics3D, speechIndicatorModel, this.indicatorDrawables, imageArray);
        this.adjustSpeechIndicatorDrawables(speechIndicatorModel);
    }

    private void adjustSpeechIndicatorDrawables(SpeechIndicatorModel speechIndicatorModel) {
        if (speechIndicatorModel.isInvalid()) {
            block6: for (int i2 = this.indicatorDrawables.length - 1; i2 >= 0; --i2) {
                switch (i2) {
                    case 0: {
                        this.indicatorDrawables[i2].setWidth(speechIndicatorModel.get_width());
                        continue block6;
                    }
                    case 1: {
                        this.indicatorDrawables[i2].setWidth(speechIndicatorModel.get_width());
                        continue block6;
                    }
                    case 2: {
                        this.indicatorDrawables[i2].setHeight(speechIndicatorModel.get_height());
                        continue block6;
                    }
                    case 3: {
                        this.indicatorDrawables[i2].setHeight(speechIndicatorModel.get_height());
                        continue block6;
                    }
                }
            }
        }
    }
}

