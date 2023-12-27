/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.widgets.models.StatisticsModel;
import de.vw.mib.widgets.ui.StatisticsBarUI;
import java.util.Arrays;

final class StatisticsBarUI$CalcHelper {
    public static final int DEFAULT_HEIGHT_X_TEXT;
    public static final int DEFAULT_WIDTH_Y_TEXT;
    private StatisticsModel model;
    private int widthTextYAxis;
    private float[][] scalesShifted;
    private int xAxisPosInPx;
    private int canvasHeight;
    private float yScale;
    private float xScale;
    private int maximalExceedMaxValueImageHeight;
    private int maximalExceedMinValueImageHeight;
    private float translationConstant;
    private int canvasWidth;
    private int barWidth;
    private float stepSize;
    private ScaleImageDrawable[] oldMaxDrawables;
    private ScaleImageDrawable[] oldMinDrawables;
    private final /* synthetic */ StatisticsBarUI this$0;

    public StatisticsBarUI$CalcHelper(StatisticsBarUI statisticsBarUI) {
        this.this$0 = statisticsBarUI;
    }

    public void reinit(StatisticsModel statisticsModel) {
        this.model = statisticsModel;
        float[][] fArray = statisticsModel.getScalesSeparated();
        if (this.scalesShifted != null && (this.scalesShifted.length != fArray.length || this.scalesShifted[0].length != fArray[0].length)) {
            this.scalesShifted = null;
        }
        this.performCalculation();
    }

    public int calcXPosition(int n) {
        int n2 = (int)(this.stepSize * (float)n + this.translationConstant + (float)this.widthTextYAxis);
        return n2;
    }

    public int calcHeightInPixel(float f2) {
        if ((f2 -= (float)this.model.get_yMin()) < 0.0f) {
            f2 = 0.0f;
        }
        int n = this.canvasHeight - (this.xAxisPosInPx - this.maximalExceedMaxValueImageHeight);
        int n2 = Math.abs(this.scale(f2) - n);
        return n2;
    }

    public int getYPosForTextAtXAxis(TextLayout textLayout) {
        return this.canvasHeight + textLayout.getHeight();
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public int getCanvasStartX() {
        return this.widthTextYAxis;
    }

    public int getCanvasStartY() {
        return this.maximalExceedMaxValueImageHeight;
    }

    public int getMaximalExceedMinValueImageHeight() {
        return this.maximalExceedMinValueImageHeight;
    }

    public int getXPosForTextAtXAxis(int n, TextLayout textLayout) {
        int n2 = Math.round((this.stepSize - (float)textLayout.getWidth()) / 2.0f);
        int n3 = Math.round((float)(n - 1) * this.stepSize);
        int n4 = this.widthTextYAxis + n3 + n2;
        if (n4 + textLayout.getWidth() >= this.model.get_width()) {
            n4 = this.model.get_width() - textLayout.getWidth();
        }
        return n4;
    }

    public int getYPosForTextAtYAxis(int n, TextLayout textLayout) {
        int n2 = n == this.model.get_yMax() ? textLayout.getHeight() : (n == this.model.get_yMin() ? this.canvasHeight : (n == 0 ? this.canvasHeight + Math.round((float)this.canvasHeight / (float)this.model.getYRange() * (float)this.model.get_yMin()) : 0));
        return n2;
    }

    public int getXAxisPos() {
        return this.xAxisPosInPx;
    }

    public int getBarWidth() {
        return this.barWidth;
    }

    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    private float[][] getScalesShifted() {
        if (this.model.isInvalid() || this.scalesShifted == null) {
            float[][] fArray = this.model.getScalesSeparated();
            if (this.scalesShifted == null) {
                this.scalesShifted = new float[fArray.length][fArray[0].length];
            }
            for (int i2 = 0; i2 < this.scalesShifted.length; ++i2) {
                this.scalesShifted[i2][0] = fArray[i2][0] - (float)this.model.get_yMin();
                this.scalesShifted[i2][1] = fArray[i2][1];
            }
        }
        return this.scalesShifted;
    }

    private int scale(float f2) {
        float[][] fArray = this.getScalesShifted();
        if (fArray == null) {
            return 0;
        }
        float f3 = this.yScale;
        float f4 = 0.0f;
        float f5 = 0.0f;
        for (int i2 = 0; i2 < fArray.length; ++i2) {
            if (f2 >= fArray[i2][0]) {
                f4 += (float)this.canvasHeight * fArray[i2][1];
                if (f2 == fArray[i2][0]) {
                    break;
                }
            } else {
                float f6 = fArray[i2][1] / ((fArray[i2][0] - f5) / (float)this.model.getYRange());
                f4 += (f2 - f5) * f6 * f3;
                break;
            }
            f5 = fArray[i2][0];
        }
        return Math.round(f4);
    }

    private void performCalculation() {
        int n = 0;
        this.widthTextYAxis = 0;
        if (this.model.get_textFonts() != null && this.model.get_textFonts().length > 0 && this.model.get_textPaddings().length > 0) {
            n = this.model.get_textFonts()[0].getSize() + this.model.get_textPaddings()[0];
            if (this.model.get_textFonts().length > 1 && this.model.get_textPaddings().length > 1) {
                this.widthTextYAxis = this.model.getTextLayoutYAxis()[0].getWidth() + this.model.get_textPaddings()[1];
            }
        }
        this.determineExceedMaxValueImageHeight();
        this.determineExceedMinValueImageHeight();
        this.canvasHeight = this.model.get_height() - n - this.maximalExceedMaxValueImageHeight;
        this.canvasWidth = this.model.get_width() - this.widthTextYAxis;
        this.yScale = (float)this.canvasHeight / (float)this.model.getYRange();
        this.xScale = (float)this.canvasWidth / (float)this.model.getXRange();
        this.stepSize = this.xScale * (float)this.model.get_stepSize();
        this.barWidth = Math.round(this.stepSize - (float)this.model.get_barPadding());
        this.translationConstant = (float)this.model.get_barPadding() / 2.0f;
        this.calcXAxisPos();
    }

    private void determineExceedMaxValueImageHeight() {
        Object[] objectArray = this.this$0.barExceedMaxHeightDrawables;
        if (Arrays.equals(objectArray, this.oldMaxDrawables)) {
            return;
        }
        if (objectArray == null) {
            return;
        }
        this.maximalExceedMaxValueImageHeight = 0;
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            if (objectArray[i2] == null) continue;
            this.maximalExceedMaxValueImageHeight = Math.max(objectArray[i2].getHeight(), this.maximalExceedMaxValueImageHeight);
        }
        this.oldMaxDrawables = objectArray;
    }

    private void determineExceedMinValueImageHeight() {
        Object[] objectArray = this.this$0.barExceedMinHeightDrawables;
        if (Arrays.equals(objectArray, this.oldMinDrawables)) {
            return;
        }
        if (objectArray == null) {
            return;
        }
        this.maximalExceedMinValueImageHeight = 0;
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            if (objectArray[i2] == null) continue;
            this.maximalExceedMinValueImageHeight = Math.max(objectArray[i2].getHeight(), this.maximalExceedMinValueImageHeight);
        }
        this.oldMinDrawables = objectArray;
    }

    private void calcXAxisPos() {
        this.xAxisPosInPx = this.model.get_yMin() >= 0 ? this.canvasHeight : this.canvasHeight - this.scale(-this.model.get_yMin());
        this.xAxisPosInPx += this.getCanvasStartY();
    }
}

