/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.ButtonModel;
import de.vw.mib.widgets.models.StaticImageModel;

public interface ColorChooserModel
extends AbstractButtonModel {
    public static final int PID_BASE;
    public static final int PID_COLOR_BASE_POINTS;
    public static final int PID_COLOR_INDEX;
    public static final int PID_IMAGES_INDICATOR;
    public static final int PID_IMAGE_INDICATOR_REF;
    public static final int PID_INDICATOR_VALUE_POINT_X;
    public static final int PID_INDICATOR_VALUE_POINT_Y;
    public static final int PID_MODE;
    public static final int PID_PADDINGS;
    public static final int PID_SNAP;
    public static final int PID_WRAP_FLAG;
    public static final int PID_BUTTON_REFS;
    public static final int PID_SPACING_HORIZONTAL;
    public static final int PID_COUNT_COLORCHOOSER;
    public static final int MODE_LINEAR;
    public static final int MODE_RADIAL;
    public static final int MODE_RECTANGLES;

    default public ButtonModel[] get_buttonRefs() {
    }

    default public void set_buttonRefs(ButtonModel[] buttonModelArray) {
    }

    default public int[] get_colorBasePoints() {
    }

    default public void set_colorBasePoints(int[] nArray) {
    }

    default public int get_colorIndex() {
    }

    default public void set_colorIndex(int n) {
    }

    default public Image[] get_imagesIndicator() {
    }

    default public void set_imagesIndicator(Image[] imageArray) {
    }

    default public StaticImageModel get_imageIndicatorRef() {
    }

    default public void set_imageIndicatorRef(StaticImageModel staticImageModel) {
    }

    default public int get_indicatorValuePointX() {
    }

    default public void set_indicatorValuePointX(int n) {
    }

    default public int get_indicatorValuePointY() {
    }

    default public void set_indicatorValuePointY(int n) {
    }

    default public int get_mode() {
    }

    default public void set_mode(int n) {
    }

    default public Insets get_paddings() {
    }

    default public void set_paddings(Insets insets) {
    }

    default public boolean is_snap() {
    }

    default public void set_snap(boolean bl) {
    }

    default public int get_spacingHorizontal() {
    }

    default public void set_spacingHorizontal(int n) {
    }

    default public boolean is_wrapFlag() {
    }

    default public void set_wrapFlag(boolean bl) {
    }

    default public int getColorForIndex(int n) {
    }

    default public int[] getHMIColors() {
    }

    default public int getHMIColor() {
    }

    default public int getHMIColorForIndex(int n) {
    }

    default public boolean isUpdateColorRepresentation() {
    }

    default public void setUpdateColorRepresentation(boolean bl) {
    }

    default public int[] getColorsCoordinate() {
    }

    default public Point getPositionOnIndicator() {
    }

    default public boolean setPositionOnIndicator(int n, int n2) {
    }

    default public void updateIndicatorPosition(Point point) {
    }

    default public void updateIndicatorPosition(int n) {
    }

    default public void updateIndicatorPosition() {
    }

    default public int calculateColorIndexByPosition(int n, int n2) {
    }
}

