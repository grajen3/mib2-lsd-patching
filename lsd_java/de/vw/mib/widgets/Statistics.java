/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.Statistics$ValueUpdateAnimation;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.StatisticsModel;
import de.vw.mib.widgets.models.ViewModel;
import java.io.IOException;
import java.util.Arrays;

public final class Statistics
extends AbstractWidget
implements StatisticsModel {
    private static final int DEFAULT_TEXT_SIZE;
    private static final int DEFAULT_TEXT_STYLE;
    private static final int COUNT_SCALE_PARAMS;
    private static final int X_VAL_FACTOR;
    private static final float WIDTH_SIZE_RATIO;
    private int barPadding;
    private Image[] backgroundImages;
    private Image chartBackgroundImage;
    private Image[] exceedMaxHeightImages;
    private Image[] exceedMinHeightImages;
    private Image[] maskImages;
    private int numberOfSubValues;
    private Image[] outlineImages;
    private float[] scales;
    private int[] states;
    private int stepSize;
    private FontAttribs[] textFonts;
    private Color[] textColors;
    private int[] textPaddings;
    private int valueChangeType;
    private Color[] valueColors;
    private int[] valueColorRanges;
    private int[] values;
    private Image xAxisImage;
    private int[] xAxisImageOffset;
    private int xMax;
    private int xMin;
    private Image yAxisImage;
    private int[] yAxisImageOffset;
    private int yMax;
    private int yMin;
    private int[][] valuesSeparated;
    private float[][] scalesSeparated;
    private Font[] fonts;
    private int[][] statesSeparated;
    private Statistics$ValueUpdateAnimation valuesUpdateAnimation;
    private int[] statesCache;
    private int[] valueCache;
    private TextLayout[] textLayoutsXAxis;
    private TextStyle[] textStylesXAxis;
    private TextLayout[] textLayoutsYAxis;
    private TextStyle[] textStylesYAxis;
    private int[] labeledXValues;
    private int[] labeledYValues;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$StatisticsAreaUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$StatisticsBarUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$StatisticsCurveUI;

    @Override
    protected void reset() {
        super.reset();
        this.valuesUpdateAnimation = null;
        this.textLayoutsXAxis = null;
        this.textLayoutsYAxis = null;
        this.textStylesXAxis = null;
        this.textStylesYAxis = null;
        this.labeledXValues = null;
        this.labeledYValues = null;
    }

    public void init(boolean bl, int n, boolean bl2, Image[] imageArray, int n2, Image image, EasingParams[] easingParamsArray, boolean bl3, Image[] imageArray2, int n3, boolean bl4, Image[] imageArray3, String string, int n4, Image[] imageArray4, float[] fArray, int[] nArray, int n5, int n6, Color[] colorArray, FontAttribs[] fontAttribsArray, int[] nArray2, Insets insets, int n7, int[] nArray3, Color[] colorArray2, int[] nArray4, boolean bl5, int n8, int n9, Image image2, int[] nArray5, int n10, int n11, int n12, Image image3, int[] nArray6, int n13, int n14) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n3, bl4, string, n6, insets, bl5, n8, n9, n12);
        this.fonts = new Font[3];
        this.backgroundImages = imageArray;
        this.barPadding = n2;
        this.chartBackgroundImage = image;
        this.exceedMaxHeightImages = imageArray2;
        this.maskImages = imageArray3;
        this.numberOfSubValues = n4;
        this.outlineImages = imageArray4;
        this.textPaddings = nArray2;
        this.scales = fArray;
        this.states = nArray;
        this.stepSize = n5;
        this.textColors = colorArray;
        this.textFonts = fontAttribsArray;
        this.textPaddings = nArray2;
        this.valueChangeType = n7;
        this.valueColors = colorArray2;
        this.valueColorRanges = nArray3;
        this.values = nArray4;
        this.xAxisImage = image2;
        this.xAxisImageOffset = nArray5;
        this.xMax = n10;
        this.xMin = n11;
        this.yAxisImage = image3;
        this.yAxisImageOffset = nArray6;
        this.yMax = n13;
        this.yMin = n14;
    }

    public void init(boolean bl, int n, boolean bl2, Image[] imageArray, int n2, Image image, EasingParams[] easingParamsArray, boolean bl3, Image[] imageArray2, Image[] imageArray3, int n3, boolean bl4, Image[] imageArray4, String string, int n4, Image[] imageArray5, float[] fArray, int[] nArray, int n5, int n6, Color[] colorArray, FontAttribs[] fontAttribsArray, int[] nArray2, Insets insets, int n7, int[] nArray3, Color[] colorArray2, int[] nArray4, boolean bl5, int n8, int n9, Image image2, int[] nArray5, int n10, int n11, int n12, Image image3, int[] nArray6, int n13, int n14) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n3, bl4, string, n6, insets, bl5, n8, n9, n12);
        this.fonts = new Font[3];
        this.backgroundImages = imageArray;
        this.barPadding = n2;
        this.chartBackgroundImage = image;
        this.exceedMaxHeightImages = imageArray2;
        this.exceedMinHeightImages = imageArray3;
        this.maskImages = imageArray4;
        this.numberOfSubValues = n4;
        this.outlineImages = imageArray5;
        this.textPaddings = nArray2;
        this.scales = fArray;
        this.states = nArray;
        this.stepSize = n5;
        this.textColors = colorArray;
        this.textFonts = fontAttribsArray;
        this.textPaddings = nArray2;
        this.valueChangeType = n7;
        this.valueColors = colorArray2;
        this.valueColorRanges = nArray3;
        this.values = nArray4;
        this.xAxisImage = image2;
        this.xAxisImageOffset = nArray5;
        this.xMax = n10;
        this.xMin = n11;
        this.yAxisImage = image3;
        this.yAxisImageOffset = nArray6;
        this.yMax = n13;
        this.yMin = n14;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.backgroundImages);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.chartBackgroundImage);
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.exceedMaxHeightImages);
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.exceedMinHeightImages);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.xAxisImage);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.yAxisImage);
        this.updateValuesSeparated(true);
        this.updateStatesSeparated(true);
        this.updateScalesSeparated();
        this.checkIfStatesAreValid();
        this.checkIfImagesAreDefinedSynchronously();
    }

    @Override
    public void deInit() {
        this.stopValueUpdateAnimation();
        this.valuesSeparated = null;
        this.statesSeparated = null;
        this.scalesSeparated = null;
        if (this.fonts != null) {
            for (int i2 = this.fonts.length - 1; i2 >= 0; --i2) {
                this.fonts[i2] = null;
            }
        }
        this.statesCache = null;
        this.valueCache = null;
        this.backgroundImages = null;
        this.chartBackgroundImage = null;
        this.exceedMaxHeightImages = null;
        this.exceedMinHeightImages = null;
        this.maskImages = null;
        this.outlineImages = null;
        this.scales = null;
        this.states = null;
        this.textColors = null;
        this.textFonts = null;
        this.textPaddings = null;
        this.valueColors = null;
        this.valueColorRanges = null;
        this.values = null;
        this.xAxisImage = null;
        this.xAxisImageOffset = null;
        this.yAxisImage = null;
        this.yAxisImageOffset = null;
        this.setInternalStateFlag(9, false);
        this.clearTextLayouts();
        this.clearTextStyles();
        this.labeledXValues = null;
        this.labeledYValues = null;
        super.deInit();
    }

    @Override
    public Image[] get_backgroundImages() {
        return this.backgroundImages;
    }

    @Override
    public void set_backgroundImages(Image[] imageArray) {
        Object[] objectArray = this.backgroundImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.backgroundImages = imageArray;
            this.backgroundImagesChanged((Image[])objectArray);
            this.propertyChanged(16);
        }
    }

    @Override
    public int get_barPadding() {
        return this.barPadding;
    }

    @Override
    public void set_barPadding(int n) {
        int n2 = this.barPadding;
        if (n2 != n) {
            this.barPadding = n;
            this.barPaddingChanged(n2);
            this.propertyChanged(17);
        }
    }

    @Override
    public Image get_chartBackgroundImage() {
        return this.chartBackgroundImage;
    }

    @Override
    public void set_chartBackgroundImage(Image image) {
        Image image2 = this.chartBackgroundImage;
        if (image2 == null || !image2.equals(image)) {
            this.chartBackgroundImage = image;
            this.chartBackgroundImageChanged(image2);
            this.propertyChanged(18);
        }
    }

    @Override
    public Image[] get_exceedMaxHeightImages() {
        return this.exceedMaxHeightImages;
    }

    @Override
    public void set_exceedMaxHeightImages(Image[] imageArray) {
        Object[] objectArray = this.exceedMaxHeightImages;
        if (objectArray == null || !Arrays.equals(objectArray, imageArray)) {
            this.exceedMaxHeightImages = imageArray;
            this.exceedMaxHeightImagesChanged((Image[])objectArray);
            this.propertyChanged(19);
        }
    }

    @Override
    public Image[] get_exceedMinHeightImages() {
        return this.exceedMinHeightImages;
    }

    @Override
    public void set_exceedMinHeightImages(Image[] imageArray) {
        Object[] objectArray = this.exceedMinHeightImages;
        if (objectArray == null || !Arrays.equals(objectArray, imageArray)) {
            this.exceedMinHeightImages = imageArray;
            this.exceedMinHeightImagesChanged((Image[])objectArray);
            this.propertyChanged(20);
        }
    }

    @Override
    public Image[] get_maskImages() {
        return this.maskImages;
    }

    @Override
    public void set_maskImages(Image[] imageArray) {
        Object[] objectArray = this.maskImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.maskImages = imageArray;
            this.maskImagesChanged((Image[])objectArray);
            this.propertyChanged(21);
        }
    }

    @Override
    public int get_numberOfSubValues() {
        return this.numberOfSubValues;
    }

    @Override
    public void set_numberOfSubValues(int n) {
        int n2 = this.numberOfSubValues;
        if (n2 != n) {
            this.numberOfSubValues = n;
            this.numberOfSubValuesChanged(n2);
            this.propertyChanged(22);
        }
    }

    @Override
    public Image[] get_outlineImages() {
        return this.outlineImages;
    }

    @Override
    public void set_outlineImages(Image[] imageArray) {
        Object[] objectArray = this.outlineImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.outlineImages = imageArray;
            this.outlineImagesChanged((Image[])objectArray);
            this.propertyChanged(23);
        }
    }

    @Override
    public float[] get_scales() {
        return this.scales;
    }

    @Override
    public void set_scales(float[] fArray) {
        float[] fArray2 = this.scales;
        if (!Arrays.equals(fArray2, fArray)) {
            this.scales = fArray;
            this.scalesChanged(fArray2);
            this.propertyChanged(41);
        }
    }

    @Override
    public int[] get_states() {
        return this.states;
    }

    @Override
    public void set_states(int[] nArray) {
        int[] nArray2 = this.states;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.states = nArray;
            this.statesChanged(nArray2);
            this.propertyChanged(40);
        }
    }

    @Override
    public int get_stepSize() {
        return this.stepSize;
    }

    @Override
    public void set_stepSize(int n) {
        int n2 = this.stepSize;
        if (n2 != n) {
            this.stepSize = n;
            this.stepSizeChanged(n2);
            this.propertyChanged(24);
        }
    }

    @Override
    public Color[] get_textColors() {
        return this.textColors;
    }

    @Override
    public void set_textColors(Color[] colorArray) {
        Object[] objectArray = this.textColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.textColors = colorArray;
            this.textColorsChanged((Color[])objectArray);
            this.propertyChanged(25);
        }
    }

    @Override
    public FontAttribs[] get_textFonts() {
        return this.textFonts;
    }

    @Override
    public void set_textFonts(FontAttribs[] fontAttribsArray) {
        Object[] objectArray = this.textFonts;
        if (!Arrays.equals(objectArray, fontAttribsArray)) {
            this.textFonts = fontAttribsArray;
            this.textFontsChanged((FontAttribs[])objectArray);
            this.propertyChanged(26);
        }
    }

    @Override
    public int[] get_textPaddings() {
        return this.textPaddings;
    }

    @Override
    public void set_textPaddings(int[] nArray) {
        int[] nArray2 = this.textPaddings;
        if (!Arrays.equals(nArray2, nArray)) {
            this.textPaddings = nArray;
            this.textPaddingsChanged(nArray2);
            this.propertyChanged(27);
        }
    }

    @Override
    public int get_valueChangeType() {
        return this.valueChangeType;
    }

    @Override
    public void set_valueChangeType(int n) {
        int n2 = this.valueChangeType;
        if (n2 != n) {
            this.valueChangeType = n;
            this.valueChangeTypeChanged(n2);
            this.propertyChanged(28);
        }
    }

    @Override
    public Color[] get_valueColors() {
        return this.valueColors;
    }

    @Override
    public void set_valueColors(Color[] colorArray) {
        Object[] objectArray = this.valueColors;
        if (!Arrays.equals(objectArray, colorArray)) {
            this.valueColors = colorArray;
            this.valueColorsChanged((Color[])objectArray);
            this.propertyChanged(29);
        }
    }

    @Override
    public int[] get_valueColorRanges() {
        return this.valueColorRanges;
    }

    @Override
    public void set_valueColorRanges(int[] nArray) {
        int[] nArray2 = this.valueColorRanges;
        if (!Arrays.equals(nArray2, nArray)) {
            this.valueColorRanges = nArray;
            this.valueColorRangesChanged(nArray2);
            this.propertyChanged(30);
        }
    }

    @Override
    public int[] get_values() {
        return this.values;
    }

    @Override
    public void set_values(int[] nArray) {
        int[] nArray2 = this.values;
        if (nArray2 == null || !Arrays.equals(nArray2, nArray)) {
            this.values = nArray;
            this.valuesChanged(nArray2);
            this.propertyChanged(31);
        }
    }

    @Override
    public Image get_xAxisImage() {
        return this.xAxisImage;
    }

    @Override
    public void set_xAxisImage(Image image) {
        Image image2 = this.xAxisImage;
        if (image2 == null || !image2.equals(image)) {
            this.xAxisImage = image;
            this.xAxisImageChanged(image2);
            this.propertyChanged(32);
        }
    }

    @Override
    public int[] get_xAxisImageOffset() {
        return this.xAxisImageOffset;
    }

    @Override
    public void set_xAxisImageOffset(int[] nArray) {
        int[] nArray2 = this.xAxisImageOffset;
        if (!Arrays.equals(nArray2, nArray)) {
            this.xAxisImageOffset = nArray;
            this.xAxisImageOffsetChanged(nArray2);
            this.propertyChanged(31);
        }
    }

    @Override
    public int get_xMax() {
        return this.xMax;
    }

    @Override
    public void set_xMax(int n) {
        int n2 = this.xMax;
        if (n2 != n) {
            this.xMax = n;
            this.xMaxChanged(n2);
            this.propertyChanged(34);
        }
    }

    @Override
    public int get_xMin() {
        return this.xMin;
    }

    @Override
    public void set_xMin(int n) {
        int n2 = this.xMin;
        if (n2 != n) {
            this.xMin = n;
            this.xMinChanged(n2);
            this.propertyChanged(35);
        }
    }

    @Override
    public Image get_yAxisImage() {
        return this.yAxisImage;
    }

    @Override
    public void set_yAxisImage(Image image) {
        Image image2 = this.yAxisImage;
        if (image2 == null || !image2.equals(image)) {
            this.yAxisImage = image;
            this.yAxisImageChanged(image2);
            this.propertyChanged(36);
        }
    }

    @Override
    public int[] get_yAxisImageOffset() {
        return this.yAxisImageOffset;
    }

    @Override
    public void set_yAxisImageOffset(int[] nArray) {
        int[] nArray2 = this.yAxisImageOffset;
        if (!Arrays.equals(nArray2, nArray)) {
            this.yAxisImageOffset = nArray;
            this.yAxisImageOffsetChanged(nArray2);
            this.propertyChanged(31);
        }
    }

    @Override
    public int get_yMax() {
        return this.yMax;
    }

    @Override
    public void set_yMax(int n) {
        int n2 = this.yMax;
        if (n2 != n) {
            this.yMax = n;
            this.yMaxChanged(n2);
            this.propertyChanged(38);
        }
    }

    @Override
    public int get_yMin() {
        return this.yMin;
    }

    @Override
    public void set_yMin(int n) {
        int n2 = this.yMin;
        if (n2 != n) {
            this.yMin = n;
            this.yMinChanged(n2);
            this.propertyChanged(39);
        }
    }

    @Override
    public int[][] getValuesSeparated() {
        return this.valuesSeparated;
    }

    @Override
    public int[][] getStatesSeparated() {
        return this.statesSeparated;
    }

    @Override
    public int getXRange() {
        int n = this.xMax - this.xMin;
        return n > 0 ? n : 1;
    }

    @Override
    public int getYRange() {
        int n = this.yMax - this.yMin;
        return n > 0 ? n : 1;
    }

    @Override
    public Font getFont(int n) {
        if (this.fonts != null && n >= 0 && n < 3) {
            return this.fonts[n];
        }
        return null;
    }

    @Override
    public Color4b getTextColor(int n) {
        if (n >= 0 && n < 3 && n < this.textColors.length) {
            return this.textColors[n].getCurrentColor();
        }
        return null;
    }

    @Override
    public int getTextPadding(int n) {
        if (n >= 0 && n < 3 && n < this.textPaddings.length) {
            return this.textPaddings[n];
        }
        return 0;
    }

    @Override
    public int getTextSize(int n) {
        if (n >= 0 && n < 3 && n < this.textFonts.length) {
            return this.textFonts[n].getSize();
        }
        return 12;
    }

    @Override
    public int getTextStyle(int n) {
        if (n >= 0 && n < 3 && n < this.textFonts.length) {
            return this.textFonts[n].getStyle();
        }
        return 2;
    }

    public Font getFontCanvas() {
        return this.fonts[2];
    }

    @Override
    public float[][] getScalesSeparated() {
        return this.scalesSeparated;
    }

    @Override
    public Color4b getValueColor(int n) {
        if (this.valueColorRanges == null || this.valueColorRanges.length == 0) {
            return Color4b.WHITE;
        }
        if (this.valueColorRanges.length != this.valueColors.length) {
            return Color4b.WHITE;
        }
        Color4b color4b = Color4b.WHITE;
        boolean bl = false;
        for (int i2 = this.valueColorRanges.length - 1; i2 >= 0; --i2) {
            if (this.valueColorRanges[i2] < n) continue;
            color4b = this.valueColors[i2].getCurrentColor();
            bl = true;
        }
        if (!bl) {
            color4b = this.valueColors[this.valueColors.length - 1].getCurrentColor();
        }
        return color4b;
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$StatisticsAreaUI == null ? (class$de$vw$mib$widgets$ui$StatisticsAreaUI = Statistics.class$("de.vw.mib.widgets.ui.StatisticsAreaUI")) : class$de$vw$mib$widgets$ui$StatisticsAreaUI, class$de$vw$mib$widgets$ui$StatisticsBarUI == null ? (class$de$vw$mib$widgets$ui$StatisticsBarUI = Statistics.class$("de.vw.mib.widgets.ui.StatisticsBarUI")) : class$de$vw$mib$widgets$ui$StatisticsBarUI, class$de$vw$mib$widgets$ui$StatisticsCurveUI == null ? (class$de$vw$mib$widgets$ui$StatisticsCurveUI = Statistics.class$("de.vw.mib.widgets.ui.StatisticsCurveUI")) : class$de$vw$mib$widgets$ui$StatisticsCurveUI};
    }

    @Override
    public TextLayout[] getTextLayoutXAxis() {
        return this.textLayoutsXAxis;
    }

    @Override
    public TextLayout[] getTextLayoutYAxis() {
        return this.textLayoutsYAxis;
    }

    @Override
    public TextStyle[] getTextStylesXAxis() {
        return this.textStylesXAxis;
    }

    @Override
    public TextStyle[] getTextStylesYAxis() {
        return this.textStylesYAxis;
    }

    @Override
    public int[] getLabeledXValues() {
        return this.labeledXValues;
    }

    @Override
    public int[] getLabeledYValues() {
        return this.labeledYValues;
    }

    private void backgroundImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_backgroundImages());
        this.checkIfImagesAreDefinedSynchronously();
        this.checkIfStatesAreValid();
        this.repaint();
    }

    private void barPaddingChanged(int n) {
        this.repaint();
    }

    private void chartBackgroundImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_chartBackgroundImage());
        this.repaint();
    }

    private void maskImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_maskImages());
        this.checkIfImagesAreDefinedSynchronously();
        this.repaint();
    }

    private void exceedMaxHeightImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_exceedMaxHeightImages());
        this.checkIfImagesAreDefinedSynchronously();
        this.repaint();
    }

    private void exceedMinHeightImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_exceedMinHeightImages());
        this.checkIfImagesAreDefinedSynchronously();
        this.repaint();
    }

    public void numberOfSubValuesChanged(int n) {
        this.updateValuesSeparated(true);
        this.updateStatesSeparated(true);
        this.repaint();
    }

    private void outlineImagesChanged(Image[] imageArray) {
        ServiceManager.imageManager.preloadImagesFromCurrentSkin(this.get_outlineImages());
        this.checkIfImagesAreDefinedSynchronously();
        this.repaint();
    }

    private void statesChanged(int[] nArray) {
        if (this.valueChangeType == 2) {
            this.statesCache = nArray;
        } else {
            this.updateStatesSeparated(nArray == null || this.states == null || nArray.length != this.states.length);
            this.checkIfStatesAreValid();
            this.repaint();
        }
    }

    private void stepSizeChanged(int n) {
        this.repaint();
    }

    private void textColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    private void textPaddingsChanged(int[] nArray) {
        this.repaint();
    }

    private void valueColorRangesChanged(int[] nArray) {
        this.repaint();
    }

    private void valueColorsChanged(Color[] colorArray) {
        this.repaint();
    }

    private void valuesChanged(int[] nArray) {
        this.stopValueUpdateAnimation();
        if (this.valueChangeType == 2) {
            this.valueCache = nArray;
        } else {
            boolean bl = nArray == null || this.values == null || nArray.length != this.values.length;
            this.updateValuesSeparated(bl);
            if (this.valueChangeType == 1) {
                this.startValueUpdateAnimation(nArray);
            }
            this.checkIfStatesAreValid();
            this.repaint();
        }
    }

    private void valueChangeTypeChanged(int n) {
        if (this.valueCache != null) {
            this.valuesChanged(this.valueCache);
            this.valueCache = null;
            this.statesChanged(this.statesCache);
            this.statesCache = null;
        }
    }

    private void xAxisImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_xAxisImage());
        this.repaint();
    }

    private void xAxisImageOffsetChanged(int[] nArray) {
        this.repaint();
    }

    private void xMaxChanged(int n) {
        this.updateTextInfo();
        this.repaint();
    }

    private void xMinChanged(int n) {
        this.updateTextInfo();
        this.repaint();
    }

    private void yAxisImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_yAxisImage());
        this.repaint();
    }

    private void yAxisImageOffsetChanged(int[] nArray) {
        this.repaint();
    }

    private void yMaxChanged(int n) {
        this.updateScalesSeparated();
        this.updateTextInfo();
        this.repaint();
    }

    private void yMinChanged(int n) {
        this.updateScalesSeparated();
        this.updateTextInfo();
        this.repaint();
    }

    private void scalesChanged(float[] fArray) {
        this.updateScalesSeparated();
        this.repaint();
    }

    private void textFontsChanged(FontAttribs[] fontAttribsArray) {
        int n;
        if (this.fonts != null) {
            for (n = this.fonts.length - 1; n >= 0; --n) {
                if (this.fonts[n] == null) continue;
                this.fonts[n] = null;
            }
        }
        if (this.textFonts == null) {
            return;
        }
        if (this.fonts == null) {
            this.fonts = new Font[3];
        }
        n = Math.min(3, this.textFonts.length);
        for (int i2 = n - 1; i2 >= 0; --i2) {
            try {
                this.fonts[i2] = ServiceManager.fontManager.getFontFromCurrentSkin(this.textFonts[i2].getName());
                continue;
            }
            catch (IOException iOException) {
                LogMessage logMessage = LOGGER.error(1);
                logMessage.append("Error in Widget Statistics: Unable to load font: ").append(this.textFonts[i2].getName()).append(" Error: ").append(iOException).log();
                this.fonts[i2] = null;
            }
        }
        this.clearTextStyles();
        this.textStylesXAxis = new TextStyle[1];
        this.textStylesYAxis = new TextStyle[1];
        this.updateTextInfo();
    }

    private void clearTextStyles() {
        this.clearTextStyles(this.textStylesXAxis);
        this.textStylesXAxis = null;
        this.clearTextStyles(this.textStylesYAxis);
        this.textStylesYAxis = null;
    }

    private void clearTextStyles(TextStyle[] textStyleArray) {
        if (textStyleArray != null) {
            for (int i2 = textStyleArray.length - 1; i2 >= 0; --i2) {
                if (textStyleArray[i2] == null) continue;
                textStyleArray[i2].dispose();
            }
        }
    }

    private void clearTextLayouts() {
        this.clearTextLayouts(this.textLayoutsXAxis);
        this.textLayoutsXAxis = null;
        this.clearTextLayouts(this.textLayoutsYAxis);
        this.textLayoutsYAxis = null;
    }

    private void clearTextLayouts(TextLayout[] textLayoutArray) {
        if (textLayoutArray != null) {
            for (int i2 = textLayoutArray.length - 1; i2 >= 0; --i2) {
                if (textLayoutArray[i2] == null) continue;
                textLayoutArray[i2].dispose();
                textLayoutArray[i2] = null;
            }
        }
    }

    private void updateTextInfo() {
        if (this.textFonts != null && this.textFonts.length > 0) {
            this.updateXAxisTextInfo();
            this.updateYAxisTextInfo();
        }
    }

    private void updateYAxisTextInfo() {
        int n;
        GlyphStyle glyphStyle = ServiceManager.textLayoutManager.createGlyphStyle(this.fonts[1].getFontId(), this.textFonts[1].getSize(), this.textFonts[1].getStyle());
        int n2 = this.textFonts[0].getSize();
        int n3 = Math.round((float)this.textFonts[0].getSize() * 2.0f);
        int n4 = n = this.get_yMin() < 0 ? 3 : 2;
        if (this.textStylesYAxis[0] == null) {
            this.textStylesYAxis[0] = ServiceManager.textLayoutManager.createTextStyle(0, 2, 0, 0, -129, glyphStyle);
        }
        if (this.textLayoutsYAxis == null || this.textLayoutsYAxis.length != n) {
            this.textLayoutsYAxis = new TextLayout[n];
        }
        this.clearTextLayouts(this.textLayoutsYAxis);
        if (this.labeledYValues == null || this.labeledYValues.length != n) {
            this.labeledYValues = new int[n];
        }
        this.textLayoutsYAxis[0] = ServiceManager.textLayoutManager.performTextLayout(n3, n2, 1, false, '\u0000', false, '\u0000', this.textStylesYAxis, String.valueOf(this.get_yMax()), this.fonts[1]);
        this.labeledYValues[0] = this.get_yMax();
        if (this.get_yMin() < 0) {
            this.textLayoutsYAxis[1] = ServiceManager.textLayoutManager.performTextLayout(n3, n2, 1, false, '\u0000', false, '\u0000', this.textStylesYAxis, "0", this.fonts[1]);
            this.labeledYValues[1] = 0;
        }
        this.textLayoutsYAxis[this.textLayoutsYAxis.length - 1] = ServiceManager.textLayoutManager.performTextLayout(n3, n2, 1, false, '\u0000', false, '\u0000', this.textStylesYAxis, String.valueOf(this.get_yMin()), this.fonts[1]);
        this.labeledYValues[this.labeledYValues.length - 1] = this.get_yMin();
    }

    private void updateXAxisTextInfo() {
        GlyphStyle glyphStyle = ServiceManager.textLayoutManager.createGlyphStyle(this.fonts[0].getFontId(), this.textFonts[0].getSize(), this.textFonts[0].getStyle());
        int n = this.textFonts[0].getSize();
        int n2 = Math.round((float)this.textFonts[0].getSize() * 2.0f);
        boolean bl = this.isAdditionalXAxisLabelRequired();
        int n3 = this.getNumberOfXAxisLabels();
        int n4 = n3 + (bl ? 1 : 0);
        if (this.textStylesXAxis[0] == null) {
            this.textStylesXAxis[0] = ServiceManager.textLayoutManager.createTextStyle(0, 0, 0, 0, -129, glyphStyle);
        }
        if (this.textLayoutsXAxis == null || this.textLayoutsXAxis.length != n4) {
            this.textLayoutsXAxis = new TextLayout[n4];
        }
        this.clearTextLayouts(this.textLayoutsXAxis);
        if (this.labeledXValues == null || this.labeledXValues.length != n4) {
            this.labeledXValues = new int[n4];
        }
        int n5 = this.get_xMin() + this.get_stepSize();
        this.textLayoutsXAxis[0] = ServiceManager.textLayoutManager.performTextLayout(n2, n, 1, false, '\u0000', false, '\u0000', this.textStylesXAxis, String.valueOf(n5), this.fonts[0]);
        this.labeledXValues[0] = n5;
        for (int i2 = 1; i2 < n3; ++i2) {
            n5 = this.get_xMin() + i2 * 5 * this.get_stepSize();
            this.textLayoutsXAxis[i2] = ServiceManager.textLayoutManager.performTextLayout(n2, n, 1, false, '\u0000', false, '\u0000', this.textStylesXAxis, String.valueOf(n5), this.fonts[0]);
            this.labeledXValues[i2] = n5;
        }
        if (bl) {
            n5 = this.get_xMax();
            this.textLayoutsXAxis[this.textLayoutsXAxis.length - 1] = ServiceManager.textLayoutManager.performTextLayout(n2, n, 1, false, '\u0000', false, '\u0000', this.textStylesXAxis, String.valueOf(n5), this.fonts[0]);
            this.labeledXValues[this.labeledXValues.length - 1] = n5;
        }
    }

    private void updateValuesSeparated(boolean bl) {
        this.updateValuesSeparated(this.values, bl);
    }

    protected void updateValuesSeparated(int[] nArray, boolean bl) {
        if (this.numberOfSubValues == 0 || nArray == null || nArray.length % this.numberOfSubValues != 0) {
            this.valuesSeparated = null;
            return;
        }
        int n = nArray.length / this.numberOfSubValues;
        if (this.valuesSeparated == null || bl) {
            this.valuesSeparated = new int[n][this.numberOfSubValues];
        }
        for (int i2 = 0; i2 < n; ++i2) {
            for (int i3 = 0; i3 < this.numberOfSubValues; ++i3) {
                this.valuesSeparated[i2][i3] = nArray[i2 * this.numberOfSubValues + i3];
            }
        }
    }

    private void updateStatesSeparated(boolean bl) {
        if (this.numberOfSubValues == 0 || this.states == null || this.states.length % this.numberOfSubValues != 0) {
            this.statesSeparated = null;
            return;
        }
        int n = this.states.length / this.numberOfSubValues;
        if (this.statesSeparated == null || bl) {
            this.statesSeparated = new int[n][this.numberOfSubValues];
        }
        for (int i2 = 0; i2 < n; ++i2) {
            for (int i3 = 0; i3 < this.numberOfSubValues; ++i3) {
                this.statesSeparated[i2][i3] = this.states[i2 * this.numberOfSubValues + i3];
            }
        }
    }

    private void updateScalesSeparated() {
        if (this.scales == null || this.scales.length == 0) {
            this.scalesSeparated = new float[1][2];
            this.scalesSeparated[0][0] = this.yMax;
            this.scalesSeparated[0][1] = 1.0f;
            return;
        }
        if (this.scalesSeparated == null || this.scales.length != this.scalesSeparated.length) {
            this.scalesSeparated = new float[this.scales.length][2];
        }
        for (int i2 = this.scales.length - 1; i2 >= 0; --i2) {
            this.scalesSeparated[i2][0] = (int)this.scales[i2];
            this.scalesSeparated[i2][1] = this.scales[i2] - (float)((int)this.scales[i2]);
        }
    }

    private void checkIfImagesAreDefinedSynchronously() {
        if (this.outlineImages == null || this.maskImages == null || this.backgroundImages == null) {
            this.setInternalStateFlag(9, false);
            return;
        }
        if (this.outlineImages.length != this.maskImages.length || this.outlineImages.length != this.backgroundImages.length) {
            this.setInternalStateFlag(9, false);
            return;
        }
        this.setInternalStateFlag(9, true);
    }

    private void checkIfStatesAreValid() {
        if (this.backgroundImages == null) {
            return;
        }
        if (this.states == null) {
            this.setInternalStateFlag(10, false);
            return;
        }
        if (this.values == null || this.states.length != this.values.length) {
            this.setInternalStateFlag(10, false);
            return;
        }
        for (int i2 = this.states.length - 1; i2 >= 0; --i2) {
            if (this.states[i2] >= 0 && this.states[i2] < this.backgroundImages.length) continue;
            this.setInternalStateFlag(10, false);
            return;
        }
        this.setInternalStateFlag(10, true);
    }

    @Override
    public boolean areImagesDefinedSynchronously() {
        return this.getInternalStateFlag(9);
    }

    @Override
    public boolean areStatesValid() {
        return this.getInternalStateFlag(10);
    }

    private boolean startValueUpdateAnimation(int[] nArray) {
        EasingParams easingParams = this.getEasing(8);
        if (easingParams == null) {
            return false;
        }
        if (this.valuesUpdateAnimation == null) {
            this.valuesUpdateAnimation = new Statistics$ValueUpdateAnimation(this, easingParams, nArray, this.values);
            if (!this.startInternalAnimation(this.valuesUpdateAnimation)) {
                this.valuesUpdateAnimation = null;
                return false;
            }
        }
        return true;
    }

    private void stopValueUpdateAnimation() {
        if (this.valuesUpdateAnimation != null) {
            this.stopInternalAnimation(this.valuesUpdateAnimation);
            this.valuesUpdateAnimation = null;
        }
    }

    private int getNumberOfXAxisLabels() {
        if (this.get_stepSize() == 0) {
            return 0;
        }
        return this.getXRange() / this.get_stepSize() / 5 + 1;
    }

    private boolean isAdditionalXAxisLabelRequired() {
        if (this.get_stepSize() == 0) {
            return false;
        }
        return this.getXRange() / this.get_stepSize() % 5 != 0;
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

