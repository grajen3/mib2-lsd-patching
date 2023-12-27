/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Color4b;
import de.vw.mib.graphics.font.Font;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.WidgetModel;

public interface StatisticsModel
extends WidgetModel {
    public static final int PID_BASE;
    public static final int PID_BACKGROUND_IMAGES;
    public static final int PID_BAR_PADDING;
    public static final int PID_CHART_BACKGROUND_IMAGE;
    public static final int PID_EXCEED_MAX_HEIGHT_IMAGES;
    public static final int PID_EXCEED_MIN_HEIGHT_IMAGES;
    public static final int PID_MASK_IMAGES;
    public static final int PID_NUMBER_OF_SUB_VALUES;
    public static final int PID_OUTLINE_IMAGES;
    public static final int PID_STEP_SIZE;
    public static final int PID_TEXT_COLORS;
    public static final int PID_TEXT_FONTS;
    public static final int PID_TEXT_PADDINGS;
    public static final int PID_VALUE_CHANGE_TYPE;
    public static final int PID_VALUE_COLORS;
    public static final int PID_VALUE_COLOR_RANGES;
    public static final int PID_VALUES;
    public static final int PID_X_AXIS_IMAGE;
    public static final int PID_X_AXIS_IMAGE_OFFSET;
    public static final int PID_X_MAX;
    public static final int PID_X_MIN;
    public static final int PID_Y_AXIS_IMAGE;
    public static final int PID_Y_AXIS_IMAGE_OFFSET;
    public static final int PID_Y_MAX;
    public static final int PID_Y_MIN;
    public static final int PID_STATES;
    public static final int PID_SCALES;
    public static final int PID_COUNT_STATISTICS;
    public static final int EASING_INDEX_BASE_STATISTICS;
    public static final int EASING_INDEX_SET;
    public static final int EASING_INDEX_UPDATE;
    public static final int EASING_INDEX_COUNT_STATISTICS;
    public static final int SID_BASE;
    public static final int SID_IMAGES_DEFINED_SYNCHRONOUSLY;
    public static final int SID_STATES_VALID;
    public static final int SID_COUNT_STATISTICS;
    public static final int VALUE_CHANGE_TYPE_SET;
    public static final int VALUE_CHANGE_TYPE_UPDATE;
    public static final int VALUE_CHANGE_TYPE_DELAYED;
    public static final int FONT_X;
    public static final int FONT_Y;
    public static final int FONT_CANVAS;
    public static final int FONT_COUNT;
    public static final int SCALE_VALUE;
    public static final int SCALE_PERCENT;

    default public Image[] get_backgroundImages() {
    }

    default public void set_backgroundImages(Image[] imageArray) {
    }

    default public int get_barPadding() {
    }

    default public void set_barPadding(int n) {
    }

    default public Image get_chartBackgroundImage() {
    }

    default public void set_chartBackgroundImage(Image image) {
    }

    default public Image[] get_exceedMaxHeightImages() {
    }

    default public void set_exceedMaxHeightImages(Image[] imageArray) {
    }

    default public Image[] get_exceedMinHeightImages() {
    }

    default public void set_exceedMinHeightImages(Image[] imageArray) {
    }

    default public Image[] get_maskImages() {
    }

    default public void set_maskImages(Image[] imageArray) {
    }

    default public int get_numberOfSubValues() {
    }

    default public void set_numberOfSubValues(int n) {
    }

    default public Image[] get_outlineImages() {
    }

    default public void set_outlineImages(Image[] imageArray) {
    }

    default public float[] get_scales() {
    }

    default public void set_scales(float[] fArray) {
    }

    default public int[] get_states() {
    }

    default public void set_states(int[] nArray) {
    }

    default public int get_stepSize() {
    }

    default public void set_stepSize(int n) {
    }

    default public Color[] get_textColors() {
    }

    default public void set_textColors(Color[] colorArray) {
    }

    default public FontAttribs[] get_textFonts() {
    }

    default public void set_textFonts(FontAttribs[] fontAttribsArray) {
    }

    default public int[] get_textPaddings() {
    }

    default public void set_textPaddings(int[] nArray) {
    }

    default public int get_valueChangeType() {
    }

    default public void set_valueChangeType(int n) {
    }

    default public Color[] get_valueColors() {
    }

    default public void set_valueColors(Color[] colorArray) {
    }

    default public int[] get_valueColorRanges() {
    }

    default public void set_valueColorRanges(int[] nArray) {
    }

    default public int[] get_values() {
    }

    default public void set_values(int[] nArray) {
    }

    default public Image get_xAxisImage() {
    }

    default public void set_xAxisImage(Image image) {
    }

    default public int[] get_xAxisImageOffset() {
    }

    default public void set_xAxisImageOffset(int[] nArray) {
    }

    default public int get_xMax() {
    }

    default public void set_xMax(int n) {
    }

    default public int get_xMin() {
    }

    default public void set_xMin(int n) {
    }

    default public Image get_yAxisImage() {
    }

    default public void set_yAxisImage(Image image) {
    }

    default public int[] get_yAxisImageOffset() {
    }

    default public void set_yAxisImageOffset(int[] nArray) {
    }

    default public int get_yMax() {
    }

    default public void set_yMax(int n) {
    }

    default public int get_yMin() {
    }

    default public void set_yMin(int n) {
    }

    default public int[][] getValuesSeparated() {
    }

    default public int[][] getStatesSeparated() {
    }

    default public int getXRange() {
    }

    default public int getYRange() {
    }

    default public float[][] getScalesSeparated() {
    }

    default public Font getFont(int n) {
    }

    default public Color4b getTextColor(int n) {
    }

    default public int getTextPadding(int n) {
    }

    default public int getTextSize(int n) {
    }

    default public int getTextStyle(int n) {
    }

    default public Color4b getValueColor(int n) {
    }

    default public boolean areStatesValid() {
    }

    default public TextLayout[] getTextLayoutXAxis() {
    }

    default public TextStyle[] getTextStylesXAxis() {
    }

    default public TextLayout[] getTextLayoutYAxis() {
    }

    default public TextStyle[] getTextStylesYAxis() {
    }

    default public int[] getLabeledXValues() {
    }

    default public int[] getLabeledYValues() {
    }

    default public boolean areImagesDefinedSynchronously() {
    }
}

