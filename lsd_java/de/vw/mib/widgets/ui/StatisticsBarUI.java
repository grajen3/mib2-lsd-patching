/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.Drawable;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.drawable.text.TextDrawable;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.models.StatisticsModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.ui.AbstractWidgetUI;
import de.vw.mib.widgets.ui.StatisticsBarUI$CalcHelper;
import de.vw.mib.widgets.ui.StatisticsBarUI$ErrorLogHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class StatisticsBarUI
extends AbstractWidgetUI
implements PropertyChangedListener {
    private static final float ALPHA_MASK_THRESHOLD;
    private static final boolean DEBUG;
    private static final int LOG_ID_IMAGE_MISMATCH;
    private static final int LOG_ID_INVALID_STATE;
    private static final int LOG_ID_NO_VALUES;
    private static final int LOG_ID_IMAGE_LOADING;
    private static final int LOG_ID_IMAGE_PRELOAD;
    private static final int LOG_ID_IMAGE_UPDATE;
    private static final int LOG_ID_COUNT;
    private boolean oldAlphaTestEnabled;
    private boolean oldStencilTestEnabled;
    private boolean oldDepthTestEnabled;
    private StatisticsBarUI$CalcHelper calcHelper;
    private Rectangle clippingArea;
    private TextDrawable[] textDrawablesXAxis;
    private TextDrawable[] textDrawablesYAxis;
    private ScaleImageDrawable xAxisDrawable;
    private ScaleImageDrawable yAxisDrawable;
    private ScaleImageDrawable chartBackgroundDrawable;
    ScaleImageDrawable[] barExceedMaxHeightDrawables;
    ScaleImageDrawable[] barExceedMinHeightDrawables;
    private ScaleImageDrawable[] barBackgroundDrawables;
    private ScaleImageDrawable[][][] barOutlineDrawables;
    private ScaleImageDrawable[][][] barMaskDrawables;
    private int[] xPositions;
    private StatisticsBarUI$ErrorLogHelper errorLogHelper;

    @Override
    public void init() {
        super.init();
        this.calcHelper = new StatisticsBarUI$CalcHelper(this);
        StatisticsModel statisticsModel = (StatisticsModel)this.getWidget();
        statisticsModel.addPropertyChangedListener(this);
    }

    @Override
    public void deInit() {
        this.calcHelper = null;
        this.xPositions = null;
        StatisticsBarUI.disposeDrawables(this.textDrawablesXAxis);
        this.textDrawablesXAxis = null;
        StatisticsBarUI.disposeDrawable(this.chartBackgroundDrawable);
        this.chartBackgroundDrawable = null;
        StatisticsBarUI.disposeDrawable(this.xAxisDrawable);
        this.xAxisDrawable = null;
        StatisticsBarUI.disposeDrawable(this.yAxisDrawable);
        this.yAxisDrawable = null;
        this.disposeBarDrawables();
        StatisticsModel statisticsModel = (StatisticsModel)this.getWidget();
        statisticsModel.removePropertyChangedListener(this);
        super.deInit();
    }

    private void disposeDrawables(Drawable[][][] drawableArray) {
        if (drawableArray != null) {
            for (int i2 = drawableArray.length - 1; i2 >= 0; --i2) {
                StatisticsBarUI.disposeDrawables(drawableArray[i2]);
            }
        }
    }

    private void updateAxisDrawables(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Image image = statisticsModel.get_xAxisImage();
        this.xAxisDrawable = StatisticsBarUI.updateScaleImageDrawable(graphics3D, statisticsModel, this.xAxisDrawable, image);
        if (statisticsModel.isInvalid() && this.xAxisDrawable != null) {
            this.xAxisDrawable.setWidth(this.calcHelper.getCanvasWidth());
        }
        image = statisticsModel.get_yAxisImage();
        this.yAxisDrawable = StatisticsBarUI.updateScaleImageDrawable(graphics3D, statisticsModel, this.yAxisDrawable, image);
        if (statisticsModel.isInvalid() && this.yAxisDrawable != null) {
            this.yAxisDrawable.setHeight(this.calcHelper.getCanvasHeight());
        }
    }

    private void updateChartBackgroundDrawable(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Image image = statisticsModel.get_chartBackgroundImage();
        this.chartBackgroundDrawable = StatisticsBarUI.updateScaleImageDrawable(graphics3D, statisticsModel, this.chartBackgroundDrawable, image);
    }

    private void preloadBarExceedMaxHeightDrawables(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Image[] imageArray = statisticsModel.get_exceedMaxHeightImages();
        if (imageArray != null) {
            try {
                this.barExceedMaxHeightDrawables = StatisticsBarUI.updateScaleImageDrawables(graphics3D, statisticsModel, this.barExceedMaxHeightDrawables, imageArray);
            }
            catch (IOException iOException) {
                this.logError(4, new StringBuffer().append("Drawable could not be preloaded: ").append(iOException.getLocalizedMessage()).toString());
            }
        }
    }

    private void preloadBarExceedMinHeightDrawables(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Image[] imageArray = statisticsModel.get_exceedMinHeightImages();
        if (imageArray != null) {
            try {
                this.barExceedMinHeightDrawables = StatisticsBarUI.updateScaleImageDrawables(graphics3D, statisticsModel, this.barExceedMinHeightDrawables, imageArray);
            }
            catch (IOException iOException) {
                this.logError(4, new StringBuffer().append("Drawable could not be preloaded: ").append(iOException.getLocalizedMessage()).toString());
            }
        }
    }

    private void updateBarExceedMaxHeightDrawables(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Image[] imageArray = statisticsModel.get_exceedMaxHeightImages();
        this.barExceedMaxHeightDrawables = StatisticsBarUI.updateScaleImageDrawables(graphics3D, statisticsModel, this.barExceedMaxHeightDrawables, imageArray);
        if (statisticsModel.isInvalid()) {
            for (int i2 = this.barExceedMaxHeightDrawables.length - 1; i2 >= 0; --i2) {
                try {
                    this.barExceedMaxHeightDrawables[i2].setWidth(this.calcHelper.getBarWidth());
                    continue;
                }
                catch (NullPointerException nullPointerException) {
                    this.logError(5, new StringBuffer().append("Drawable could not be updated: ").append(nullPointerException.getLocalizedMessage()).toString());
                }
            }
        }
    }

    private void updateBarExceedMinHeightDrawables(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Image[] imageArray = statisticsModel.get_exceedMinHeightImages();
        this.barExceedMinHeightDrawables = StatisticsBarUI.updateScaleImageDrawables(graphics3D, statisticsModel, this.barExceedMinHeightDrawables, imageArray);
        if (statisticsModel.isInvalid()) {
            for (int i2 = this.barExceedMinHeightDrawables.length - 1; i2 >= 0; --i2) {
                try {
                    this.barExceedMaxHeightDrawables[i2].setWidth(this.calcHelper.getBarWidth());
                    continue;
                }
                catch (NullPointerException nullPointerException) {
                    this.logError(5, new StringBuffer().append("Drawable could not be updated: ").append(nullPointerException.getLocalizedMessage()).toString());
                }
            }
        }
    }

    private void updateBarBackgroundDrawables(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Image[] imageArray = statisticsModel.get_backgroundImages();
        this.barBackgroundDrawables = StatisticsBarUI.updateScaleImageDrawables(graphics3D, statisticsModel, this.barBackgroundDrawables, imageArray);
        if (statisticsModel.isInvalid()) {
            for (int i2 = this.barBackgroundDrawables.length - 1; i2 >= 0; --i2) {
                if (this.barBackgroundDrawables[i2] == null) continue;
                this.barBackgroundDrawables[i2].setWidth(this.calcHelper.getBarWidth());
                this.barBackgroundDrawables[i2].setHeight(this.calcHelper.calcHeightInPixel(statisticsModel.get_yMax()));
            }
        }
    }

    private void updateBarOutlineDrawables(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Image[] imageArray = statisticsModel.get_outlineImages();
        int[][] nArray = statisticsModel.getValuesSeparated();
        if (this.barOutlineDrawables == null) {
            this.barOutlineDrawables = new ScaleImageDrawable[nArray.length][imageArray.length][];
        }
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            for (int i3 = imageArray.length - 1; i3 >= 0; --i3) {
                this.barOutlineDrawables[i2][i3] = this.updateValueScaleImageDrawables(graphics3D, statisticsModel, this.barOutlineDrawables[i2][i3], imageArray[i3], nArray[i2]);
            }
        }
    }

    private void updateBarMaskDrawables(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Image[] imageArray = statisticsModel.get_maskImages();
        int[][] nArray = statisticsModel.getValuesSeparated();
        if (this.barMaskDrawables == null) {
            this.barMaskDrawables = new ScaleImageDrawable[nArray.length][imageArray.length][];
        }
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            for (int i3 = imageArray.length - 1; i3 >= 0; --i3) {
                this.barMaskDrawables[i2][i3] = this.updateValueScaleImageDrawables(graphics3D, statisticsModel, this.barMaskDrawables[i2][i3], imageArray[i3], nArray[i2]);
            }
        }
    }

    private ScaleImageDrawable[] updateValueScaleImageDrawables(Graphics3D graphics3D, StatisticsModel statisticsModel, ScaleImageDrawable[] scaleImageDrawableArray, Image image, int[] nArray) {
        if (scaleImageDrawableArray == null) {
            scaleImageDrawableArray = new ScaleImageDrawable[nArray.length];
        }
        if (statisticsModel.isInvalid()) {
            for (int i2 = scaleImageDrawableArray.length - 1; i2 >= 0; --i2) {
                scaleImageDrawableArray[i2] = StatisticsBarUI.updateScaleImageDrawable(graphics3D, statisticsModel, scaleImageDrawableArray[i2], image);
                if (scaleImageDrawableArray[i2] == null) continue;
                scaleImageDrawableArray[i2].setWidth(this.calcHelper.getBarWidth());
                this.setAtLeastMinimumHeight(nArray[i2], scaleImageDrawableArray[i2]);
            }
        }
        return scaleImageDrawableArray;
    }

    private void setAtLeastMinimumHeight(int n, ScaleImageDrawable scaleImageDrawable) {
        int n2 = this.calcHelper.calcHeightInPixel(n);
        Insets insets = scaleImageDrawable.getScaleImage().getInsets();
        if (Math.abs(n2) <= insets.top + insets.bottom) {
            n2 = insets.top + insets.bottom + 1;
        }
        scaleImageDrawable.setHeight(n2);
    }

    private void updateXPositions(StatisticsModel statisticsModel) {
        if (this.xPositions == null) {
            this.xPositions = new int[statisticsModel.get_numberOfSubValues()];
        }
        if (statisticsModel.isInvalid()) {
            for (int i2 = this.xPositions.length - 1; i2 >= 0; --i2) {
                this.xPositions[i2] = this.calcHelper.calcXPosition(i2);
            }
        }
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        StatisticsModel statisticsModel = (StatisticsModel)widgetModel;
        this.preloadBarExceedMaxHeightDrawables(graphics3D, statisticsModel);
        this.preloadBarExceedMinHeightDrawables(graphics3D, statisticsModel);
        this.calcHelper.reinit(statisticsModel);
        this.drawBackGround(graphics3D, statisticsModel);
        this.drawTexts(graphics3D, statisticsModel);
        this.drawValues(graphics3D, statisticsModel, rectangle, rectangle2, f2);
        this.drawAxisImages(graphics3D, statisticsModel);
    }

    private void drawBackGround(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        try {
            this.updateChartBackgroundDrawable(graphics3D, statisticsModel);
            if (this.chartBackgroundDrawable != null) {
                this.chartBackgroundDrawable.draw();
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(1);
            logMessage.append("Widget 'Statistics': Unable to load chart background image").append(iOException.getLocalizedMessage()).log();
        }
    }

    private void drawValues(Graphics3D graphics3D, StatisticsModel statisticsModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        int[][] nArray = statisticsModel.getValuesSeparated();
        int[][] nArray2 = statisticsModel.getStatesSeparated();
        if (nArray == null || nArray2 == null || nArray.length != nArray2.length || this.calcHelper.getBarWidth() < 1) {
            this.logError(2, "No values and/or states available or number of values does not suit number of states!");
            return;
        }
        if (!statisticsModel.areImagesDefinedSynchronously()) {
            this.logError(0, "Configuration mismatch! No background images specified or number of background images does not fit number of mask or outline images!");
            return;
        }
        if (!statisticsModel.areStatesValid()) {
            this.logError(1, "Invalid state found! No values are drawn!");
            return;
        }
        try {
            this.updateBarBackgroundDrawables(graphics3D, statisticsModel);
            this.updateBarMaskDrawables(graphics3D, statisticsModel);
            this.updateBarOutlineDrawables(graphics3D, statisticsModel);
            this.updateXPositions(statisticsModel);
        }
        catch (IOException iOException) {
            this.logError(3, new StringBuffer().append("Unable to load image: ").append(iOException.getLocalizedMessage()).toString());
            return;
        }
        this.updateClippingArea(rectangle2);
        this.enableClipping(graphics3D, rectangle, this.clippingArea, rectangle2);
        this.saveBufferTestsAndValues(graphics3D);
        for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
            int[] nArray3 = nArray2[i2];
            int[] nArray4 = nArray[i2];
            this.drawBarOutlines(graphics3D, this.barOutlineDrawables[i2], nArray3, nArray4, Color4b.WHITE, f2);
            graphics3D.setColorBufferEnabled(false, false, false, false);
            graphics3D.setStencilBufferEnabled(1);
            graphics3D.clearStencilBuffer(0);
            graphics3D.setStencilTestEnabled(true);
            graphics3D.setStencilTest(7, 1, 1);
            graphics3D.setStencilOperation(2, 2, 2);
            graphics3D.setAlphaTestEnabled(true);
            graphics3D.setAlphaTest(4, -1701209794);
            this.drawBarMasks(graphics3D, this.barMaskDrawables[i2], nArray3, nArray4, Color4b.WHITE, 1.0f);
            graphics3D.setAlphaTestEnabled(false);
            graphics3D.setColorBufferEnabled(true, true, true, true);
            graphics3D.setStencilBufferEnabled(0);
            graphics3D.setStencilTest(2, 1, 1);
            this.drawBarBackgrounds(graphics3D, statisticsModel, nArray3, nArray4, f2);
        }
        this.restoreOldBufferTestAndValues(graphics3D);
        this.drawExceedMaxHeightImage(graphics3D, statisticsModel, nArray);
        this.drawExceedMinHeightImage(graphics3D, statisticsModel, nArray);
        this.disableClipping(graphics3D);
    }

    private void drawBarOutlines(Graphics3D graphics3D, ScaleImageDrawable[][] scaleImageDrawableArray, int[] nArray, int[] nArray2, Color4b color4b, float f2) {
        for (int i2 = nArray2.length - 1; i2 >= 0; --i2) {
            if (nArray2[i2] == 0) continue;
            int n = nArray[i2];
            ScaleImageDrawable scaleImageDrawable = scaleImageDrawableArray[n][i2];
            this.drawBarElement(graphics3D, scaleImageDrawable, nArray2[i2], this.xPositions[i2], color4b, f2);
        }
    }

    private void drawBarMasks(Graphics3D graphics3D, ScaleImageDrawable[][] scaleImageDrawableArray, int[] nArray, int[] nArray2, Color4b color4b, float f2) {
        for (int i2 = nArray2.length - 1; i2 >= 0; --i2) {
            int n = nArray[i2];
            ScaleImageDrawable scaleImageDrawable = scaleImageDrawableArray[n][i2];
            this.drawBarElement(graphics3D, scaleImageDrawable, nArray2[i2], this.xPositions[i2], color4b, f2);
        }
    }

    private void drawBarBackgrounds(Graphics3D graphics3D, StatisticsModel statisticsModel, int[] nArray, int[] nArray2, float f2) {
        for (int i2 = nArray2.length - 1; i2 >= 0; --i2) {
            int n = nArray[i2];
            ScaleImageDrawable scaleImageDrawable = this.barBackgroundDrawables[n];
            this.drawBarElement(graphics3D, scaleImageDrawable, nArray2[i2], this.xPositions[i2], statisticsModel.getValueColor(nArray2[i2]), f2);
        }
    }

    protected void drawBarElement(Graphics3D graphics3D, ScaleImageDrawable scaleImageDrawable, int n, int n2, Color4b color4b, float f2) {
        if (scaleImageDrawable != null) {
            int n3 = n2;
            int n4 = -scaleImageDrawable.getHeight();
            StatisticsModel statisticsModel = (StatisticsModel)this.getWidget();
            if (n < 0 && statisticsModel.get_yMin() < 0) {
                this.drawNegativeBarElement(graphics3D, scaleImageDrawable, n3, n4, color4b, f2);
            } else {
                this.drawPositiveBarElement(scaleImageDrawable, n3, n4, color4b, f2);
            }
        }
    }

    private void drawPositiveBarElement(ScaleImageDrawable scaleImageDrawable, int n, int n2, Color4b color4b, float f2) {
        scaleImageDrawable.setColor(color4b);
        scaleImageDrawable.setAlpha(f2);
        scaleImageDrawable.draw(n, this.calcHelper.getXAxisPos() - scaleImageDrawable.getHeight());
    }

    private void drawNegativeBarElement(Graphics3D graphics3D, ScaleImageDrawable scaleImageDrawable, int n, int n2, Color4b color4b, float f2) {
        scaleImageDrawable.setColor(color4b);
        scaleImageDrawable.setAlpha(f2);
        graphics3D.pushMatrix(0);
        graphics3D.translateMatrix(0, 0.0f, this.calcHelper.getXAxisPos(), 0.0f);
        graphics3D.scaleMatrix(0, 1.0f, 32959, 1.0f);
        scaleImageDrawable.draw(n, n2);
        graphics3D.popMatrix(0);
    }

    private void updateClippingArea(Rectangle rectangle) {
        if (this.clippingArea == null) {
            this.clippingArea = new Rectangle();
        }
        this.clippingArea.x = this.calcHelper.getCanvasStartX();
        this.clippingArea.y = 0;
        this.clippingArea.width = this.calcHelper.getCanvasWidth();
        this.clippingArea.height = this.calcHelper.getCanvasHeight() + this.calcHelper.getCanvasStartY() + this.calcHelper.getMaximalExceedMinValueImageHeight();
        if (this.calcHelper.getCanvasHeight() < 0) {
            this.clippingArea.y = 0;
            this.clippingArea.height = this.calcHelper.getCanvasHeight() + this.calcHelper.getCanvasStartY();
        }
    }

    private void drawAxisImages(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        try {
            this.updateAxisDrawables(graphics3D, statisticsModel);
            int n = this.calcHelper.getCanvasStartX();
            int n2 = this.calcHelper.getCanvasStartY();
            this.drawAxis(this.yAxisDrawable, statisticsModel.get_yAxisImageOffset(), n, n2);
            n2 = this.calcHelper.getXAxisPos();
            this.drawAxis(this.xAxisDrawable, statisticsModel.get_xAxisImageOffset(), n, n2);
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(1);
            logMessage.append("Widget 'Statistics': Unable to load axis images: ").append(iOException.getLocalizedMessage()).log();
        }
    }

    private void drawAxis(ScaleImageDrawable scaleImageDrawable, int[] nArray, int n, int n2) {
        if (scaleImageDrawable != null) {
            if (nArray != null && nArray.length == 2) {
                n += nArray[0];
                n2 += nArray[1];
            }
            scaleImageDrawable.draw(n, n2);
        }
    }

    private void drawExceedMaxHeightImage(Graphics3D graphics3D, StatisticsModel statisticsModel, int[][] nArray) {
        try {
            this.updateBarExceedMaxHeightDrawables(graphics3D, statisticsModel);
            for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                for (int i3 = nArray[i2].length - 1; i3 >= 0; --i3) {
                    int n;
                    if (nArray[i2][i3] <= statisticsModel.get_yMax() || this.barExceedMaxHeightDrawables.length <= (n = statisticsModel.getStatesSeparated()[i2][i3])) continue;
                    ScaleImageDrawable scaleImageDrawable = this.barExceedMaxHeightDrawables[n];
                    int n2 = this.calcHelper.calcXPosition(i3);
                    int n3 = this.calcHelper.getCanvasStartY() - scaleImageDrawable.getHeight();
                    scaleImageDrawable.draw(n2, n3);
                }
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(1);
            logMessage.append("Widget 'Statistics': Unable to load exceed max height images: ").append(iOException.getLocalizedMessage()).log();
        }
    }

    private void drawExceedMinHeightImage(Graphics3D graphics3D, StatisticsModel statisticsModel, int[][] nArray) {
        try {
            this.updateBarExceedMinHeightDrawables(graphics3D, statisticsModel);
            for (int i2 = nArray.length - 1; i2 >= 0; --i2) {
                for (int i3 = nArray[i2].length - 1; i3 >= 0; --i3) {
                    int n;
                    if (nArray[i2][i3] >= statisticsModel.get_yMin() || this.barExceedMinHeightDrawables.length <= (n = statisticsModel.getStatesSeparated()[i2][i3])) continue;
                    ScaleImageDrawable scaleImageDrawable = this.barExceedMinHeightDrawables[n];
                    int n2 = this.calcHelper.calcXPosition(i3);
                    int n3 = this.calcHelper.getCanvasHeight() + scaleImageDrawable.getHeight();
                    scaleImageDrawable.draw(n2, n3);
                }
            }
        }
        catch (IOException iOException) {
            LogMessage logMessage = LOGGER.error(1);
            logMessage.append("Widget 'Statistics': Unable to load exceed min height images: ").append(iOException.getLocalizedMessage()).log();
        }
    }

    private void drawBoundingBoxes(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        int[][] nArray = statisticsModel.getValuesSeparated();
        if (nArray == null || nArray.length == 0) {
            return;
        }
        float f2 = this.calcHelper.getStepSize();
        graphics3D.pushMatrix(0);
        graphics3D.translateMatrix(0, this.calcHelper.getCanvasStartX(), this.calcHelper.getXAxisPos() - 1, 0.0f);
        graphics3D.scaleMatrix(0, 1.0f, 32959, 1.0f);
        int n = 0;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            for (int i3 = 0; i3 < nArray[i2].length; ++i3) {
                n = this.calcHelper.calcHeightInPixel(nArray[i2][i3]);
                this.drawDebugLine(graphics3D, (float)i3 * f2, n, (float)(i3 + 1) * f2, n, Color4f.RED);
                this.drawDebugLine(graphics3D, (float)(i3 + 1) * f2, n, (float)(i3 + 1) * f2, 0.0f, Color4f.RED);
                this.drawDebugLine(graphics3D, (float)(i3 + 1) * f2, 0.0f, (float)i3 * f2, 0.0f, Color4f.RED);
                this.drawDebugLine(graphics3D, (float)i3 * f2, 0.0f, (float)i3 * f2, n, Color4f.RED);
            }
        }
        graphics3D.popMatrix(0);
    }

    private void restoreOldBufferTestAndValues(Graphics3D graphics3D) {
        graphics3D.setAlphaTestEnabled(this.oldAlphaTestEnabled);
        graphics3D.setStencilTestEnabled(this.oldStencilTestEnabled);
        graphics3D.setDepthTestEnabled(this.oldDepthTestEnabled);
    }

    private void saveBufferTestsAndValues(Graphics3D graphics3D) {
        this.oldAlphaTestEnabled = graphics3D.isAlphaTestEnabled();
        this.oldDepthTestEnabled = graphics3D.isDepthTestEnabled();
    }

    private void drawTexts(Graphics3D graphics3D, StatisticsModel statisticsModel) {
        Font font = statisticsModel.getFont(0);
        Font font2 = statisticsModel.getFont(1);
        if (font == null && font2 == null) {
            return;
        }
        int n = statisticsModel.getTextPadding(0);
        Color4b color4b = statisticsModel.getTextColor(0);
        Color4b color4b2 = statisticsModel.getTextColor(1);
        try {
            this.drawXAxisText(graphics3D, statisticsModel, n, color4b, font);
            this.drawYAxisText(graphics3D, statisticsModel, color4b2, font2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            LogMessage logMessage = LOGGER.error(1);
            logMessage.append("Widget 'Statistics': Unsupported Encoding!").append(unsupportedEncodingException).log();
        }
    }

    private void drawYAxisText(Graphics3D graphics3D, StatisticsModel statisticsModel, Color4b color4b, Font font) {
        int n;
        if (font == null || color4b == null) {
            return;
        }
        TextLayout[] textLayoutArray = statisticsModel.getTextLayoutYAxis();
        TextStyle[] textStyleArray = statisticsModel.getTextStylesYAxis();
        int[] nArray = statisticsModel.getLabeledYValues();
        if (this.textDrawablesYAxis == null || this.textDrawablesYAxis.length != textLayoutArray.length) {
            StatisticsBarUI.disposeDrawables(this.textDrawablesYAxis);
            this.textDrawablesYAxis = new TextDrawable[textLayoutArray.length];
            for (n = this.textDrawablesYAxis.length - 1; n >= 0; --n) {
                this.textDrawablesYAxis[n] = graphics3D.getDrawableManager().createTextDrawable();
            }
        }
        for (n = textLayoutArray.length - 1; n >= 0; --n) {
            int n2 = this.calcHelper.getYPosForTextAtYAxis(nArray[n], textLayoutArray[n]);
            this.updateTextDrawable(this.textDrawablesYAxis[n], textLayoutArray[n], textStyleArray, font);
            this.textDrawablesYAxis[n].setColor(color4b);
            this.textDrawablesYAxis[n].draw(0.0f, n2);
        }
    }

    private void drawXAxisText(Graphics3D graphics3D, StatisticsModel statisticsModel, int n, Color4b color4b, Font font) {
        int n2;
        if (font == null || color4b == null) {
            return;
        }
        TextLayout[] textLayoutArray = statisticsModel.getTextLayoutXAxis();
        int[] nArray = statisticsModel.getLabeledXValues();
        int n3 = this.calcHelper.getYPosForTextAtXAxis(textLayoutArray[0]) + n;
        TextStyle[] textStyleArray = statisticsModel.getTextStylesXAxis();
        if (this.textDrawablesXAxis == null || this.textDrawablesXAxis.length != textLayoutArray.length) {
            StatisticsBarUI.disposeDrawables(this.textDrawablesXAxis);
            this.textDrawablesXAxis = new TextDrawable[textLayoutArray.length];
            for (n2 = this.textDrawablesXAxis.length - 1; n2 >= 0; --n2) {
                this.textDrawablesXAxis[n2] = graphics3D.getDrawableManager().createTextDrawable();
            }
        }
        for (n2 = textLayoutArray.length - 1; n2 >= 0; --n2) {
            int n4 = this.calcHelper.getXPosForTextAtXAxis(nArray[n2], textLayoutArray[n2]);
            this.updateTextDrawable(this.textDrawablesXAxis[n2], textLayoutArray[n2], textStyleArray, font);
            this.textDrawablesXAxis[n2].setColor(color4b);
            this.textDrawablesXAxis[n2].draw(n4, n3);
        }
    }

    private void updateTextDrawable(TextDrawable textDrawable, TextLayout textLayout, TextStyle[] textStyleArray, Font font) {
        textDrawable.setTextLayout(textLayout);
        textDrawable.setTextStyles(textStyleArray);
        textDrawable.setFont(font);
        textDrawable.setIntervalStart(0);
        textDrawable.setIntervalEnd(-129);
    }

    private void logError(int n, String string) {
        if (this.errorLogHelper == null) {
            this.errorLogHelper = new StatisticsBarUI$ErrorLogHelper(6);
        }
        if (!this.errorLogHelper.isAlreadyLogged(n)) {
            LogMessage logMessage = LOGGER.error(1);
            logMessage.append("Widget 'Statistics': ").append(string).log();
            this.errorLogHelper.markAlreadyLogged(n);
        }
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 19: {
                this.exceedMaxHeightImagesChanged();
                break;
            }
            case 20: {
                this.exceedMinHeightImagesChanged();
                break;
            }
            case 16: {
                this.backgroundImagesChanged();
                break;
            }
            case 23: {
                this.outlineImagesChanged();
                break;
            }
            case 21: {
                this.maskImagesChanged();
                break;
            }
            case 32: {
                this.xAxisImageChanged();
                break;
            }
            case 36: {
                this.yAxisImageChanged();
                break;
            }
            case 18: {
                this.chartBackgroundImageChanged();
                break;
            }
            case 22: {
                this.numberOfSubValuesChanged();
                break;
            }
            case 31: {
                this.valuesChanged(widgetModel);
                break;
            }
        }
        if (this.errorLogHelper != null) {
            this.errorLogHelper.clear();
        }
    }

    private void chartBackgroundImageChanged() {
        StatisticsBarUI.disposeDrawable(this.chartBackgroundDrawable);
        this.chartBackgroundDrawable = null;
    }

    private void yAxisImageChanged() {
        StatisticsBarUI.disposeDrawable(this.yAxisDrawable);
        this.yAxisDrawable = null;
    }

    private void xAxisImageChanged() {
        StatisticsBarUI.disposeDrawable(this.xAxisDrawable);
        this.xAxisDrawable = null;
    }

    private void exceedMaxHeightImagesChanged() {
        StatisticsBarUI.disposeDrawables(this.barExceedMaxHeightDrawables);
        this.barExceedMaxHeightDrawables = null;
    }

    private void exceedMinHeightImagesChanged() {
        StatisticsBarUI.disposeDrawables(this.barExceedMinHeightDrawables);
        this.barExceedMinHeightDrawables = null;
    }

    private void backgroundImagesChanged() {
        StatisticsBarUI.disposeDrawables(this.barBackgroundDrawables);
        this.barBackgroundDrawables = null;
    }

    private void outlineImagesChanged() {
        this.disposeDrawables(this.barOutlineDrawables);
        this.barOutlineDrawables = null;
    }

    private void maskImagesChanged() {
        this.disposeDrawables(this.barMaskDrawables);
        this.barMaskDrawables = null;
    }

    private void numberOfSubValuesChanged() {
        this.disposeBarDrawables();
        this.xPositions = null;
    }

    private void valuesChanged(WidgetModel widgetModel) {
        StatisticsModel statisticsModel = (StatisticsModel)widgetModel;
        if (statisticsModel.get_values() != null && this.barOutlineDrawables != null && statisticsModel.get_values().length != this.barOutlineDrawables.length) {
            this.disposeBarDrawables();
            this.xPositions = null;
        }
    }

    private void disposeBarDrawables() {
        StatisticsBarUI.disposeDrawables(this.barBackgroundDrawables);
        this.barBackgroundDrawables = null;
        this.disposeDrawables(this.barOutlineDrawables);
        this.barOutlineDrawables = null;
        this.disposeDrawables(this.barMaskDrawables);
        this.barMaskDrawables = null;
        StatisticsBarUI.disposeDrawables(this.barExceedMaxHeightDrawables);
        this.barExceedMaxHeightDrawables = null;
        StatisticsBarUI.disposeDrawables(this.barExceedMinHeightDrawables);
        this.barExceedMinHeightDrawables = null;
    }
}

