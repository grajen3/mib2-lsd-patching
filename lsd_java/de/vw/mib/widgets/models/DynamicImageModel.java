/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.widgets.models.AbstractImageModel;
import de.vw.mib.widgets.models.DynamicImageModel$Picture;
import org.dsi.ifc.global.ResourceLocator;

public interface DynamicImageModel
extends AbstractImageModel {
    public static final int PID_BASE;
    public static final int PID_IMAGE_DEFAULT;
    public static final int PID_COLOR_DEFAULT;
    public static final int PID_IMAGE_ERROR;
    public static final int PID_COLOR_ERROR;
    public static final int PID_IMAGE_RESOURCE;
    public static final int PID_IMAGE_FOREGROUND;
    public static final int PID_COLOR_FOREGROUND;
    public static final int PID_THUMBNAIL;
    public static final int PID_USE_EXIF_ORIENTATION;
    public static final int PID_TRANSITION_NEXT_IMAGE_IN;
    public static final int PID_TRANSITION_NEXT_IMAGE_OUT;
    public static final int PID_REFLECTION_ENABLED;
    public static final int PID_REFLECTION_ALPHA;
    public static final int PID_REFLECTION_ALPHA_IMAGE;
    public static final int PID_REFLECTION_DISTANCE;
    public static final int PID_BORDER_IMAGE;
    public static final int PID_BORDER_IMAGE_MODE;
    public static final int PID_BORDER_IMAGE_PADDING;
    public static final int PID_BORDER_IMAGE_COLOR;
    public static final int PID_PRESCALE_RESOURCE;
    public static final int PID_ZOOM_TYPE;
    public static final int PID_COUNT_DYNAMIC_IMAGE;
    public static final int EASING_INDEX_BASE;
    public static final int EASING_INDEX_IMAGE_TRANSITION_IN;
    public static final int EASING_INDEX_IMAGE_TRANSITION_OUT;
    public static final int EASING_INDEX_COUNT_DYNAMIC_IMAGE;
    public static final int SID_BASE;
    public static final int SID_THUMBNAIL;
    public static final int SID_USE_EXIF_ORIENTATION;
    public static final int SID_REFLECTION_ENABLED;
    public static final int SID_PRESCALE_RESOURCE;
    public static final int SID_LIMIT_MAX_RESOURCE_SIZE;
    public static final int SID_IMMEDIATE_ANIMATIONS;
    public static final int SID_INVOKE_VALIDATE_PENDING;
    public static final int SID_COUNT_DYNAMIC_IMAGE;
    public static final int TRANSITION_DISABLED;
    public static final int TRANSITION_IN_FLYIN_EAST;
    public static final int TRANSITION_IN_FLYIN_WEST;
    public static final int TRANSITION_IN_FADE;
    public static final int TRANSITION_IN_FLAP;
    public static final int TRANSITION_OUT_FLYOUT_EAST;
    public static final int TRANSITION_OUT_FLYOUT_WEST;
    public static final int TRANSITION_OUT_FADE;
    public static final int TRANSITION_OUT_FLAP;
    public static final int EXIF_ORIENTATION_DEFAULT;
    public static final int EXIF_ORIENTATION_FLIPED_VERTICAL;
    public static final int EXIF_ORIENTATION_FLIPED_BOTH;
    public static final int EXIF_ORIENTATION_FLIPED_HORIZONTAL;
    public static final int EXIF_ORIENTATION_FLIPED_VERTICAL_ROTATED_LEFT;
    public static final int EXIF_ORIENTATION_ROTATED_LEFT;
    public static final int EXIF_ORIENTATION_FLIPED_HORIZONTAL_ROTATED_RIGHT;
    public static final int EXIF_ORIENTATION_ROTATED_RIGHT;
    public static final int BORDER_IMAGE_MODE_OFF;
    public static final int BORDER_IMAGE_MODE_WIDGET;
    public static final int BORDER_IMAGE_MODE_IMAGE;
    public static final int ZOOM_TYPE_DOWNSCALE;
    public static final int ZOOM_TYPE_DOWNSCALE_CROP;
    public static final int ZOOM_TYPE_SCALE;
    public static final int ZOOM_TYPE_SCALE_CROP;
    public static final int ZOOM_TYPE_SCALE_INTEGER;
    public static final int ZOOM_TYPE_SCALE_MAX_DOUBLE;

    default public Image get_imageDefault() {
    }

    default public void set_imageDefault(Image image) {
    }

    default public Color get_colorDefault() {
    }

    default public void set_colorDefault(Color color) {
    }

    default public Image get_imageError() {
    }

    default public void set_imageError(Image image) {
    }

    default public Color get_colorError() {
    }

    default public void set_colorError(Color color) {
    }

    default public Image get_imageForeground() {
    }

    default public void set_imageForeground(Image image) {
    }

    default public Color get_colorForeground() {
    }

    default public void set_colorForeground(Color color) {
    }

    default public ResourceLocator get_imageResource() {
    }

    default public void set_imageResource(ResourceLocator resourceLocator) {
    }

    default public boolean is_thumbnail() {
    }

    default public void set_thumbnail(boolean bl) {
    }

    default public boolean is_useExifOrientation() {
    }

    default public void set_useExifOrientation(boolean bl) {
    }

    default public boolean is_prescaleResource() {
    }

    default public void set_prescaleResource(boolean bl) {
    }

    default public void set_transitionNextImageIn(int n) {
    }

    default public int get_transitionNextImageIn() {
    }

    default public void set_transitionNextImageOut(int n) {
    }

    default public int get_transitionNextImageOut() {
    }

    default public void set_reflectionEnabled(boolean bl) {
    }

    default public boolean is_reflectionEnabled() {
    }

    default public void set_reflectionAlpha(int n) {
    }

    default public int get_reflectionAlpha() {
    }

    default public void set_reflectionAlphaImage(Image image) {
    }

    default public Image get_reflectionAlphaImage() {
    }

    default public void set_reflectionDistance(int n) {
    }

    default public int get_reflectionDistance() {
    }

    default public void set_borderImage(Image image) {
    }

    default public Image get_borderImage() {
    }

    default public void set_borderImageMode(int n) {
    }

    default public int get_borderImageMode() {
    }

    default public void set_borderImagePadding(Insets insets) {
    }

    default public Color get_borderImageColor() {
    }

    default public void set_borderImageColor(Color color) {
    }

    default public void set_zoomType(int n) {
    }

    default public int get_zoomType() {
    }

    default public Insets get_borderImagePadding() {
    }

    default public DynamicImageModel$Picture getCurrentPicture() {
    }

    default public DynamicImageModel$Picture getNewPicture() {
    }
}

