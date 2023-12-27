/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.models;

import de.vw.mib.Disposable;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;

public interface DynamicImageModel$Picture
extends Disposable {
    public static final short IMAGE_RESOURCE_TYPE_DYNAMIC;
    public static final short IMAGE_RESOURCE_TYPE_DEFAULT;
    public static final short IMAGE_RESOURCE_TYPE_ERROR;

    default public Color getColor() {
    }

    default public float getAlpha() {
    }

    default public void setAlpha(float f2) {
    }

    default public BufferImage getDynamicImage() {
    }

    default public Image getStaticImage() {
    }

    default public boolean isDynamicResource() {
    }

    default public short getImageResourceType() {
    }

    default public float getCenterX() {
    }

    default public void setCenterX(float f2) {
    }

    default public float getCenterY() {
    }

    default public void setCenterY(float f2) {
    }

    default public float getCenterZ() {
    }

    default public void setCenterZ(float f2) {
    }

    default public float getZoomFactor() {
    }

    default public void setZoomFactor(float f2) {
    }

    default public int getZoomedBoundingBoxWidth() {
    }

    default public int getZoomedBoundingBoxHeight() {
    }

    default public int getBoundingBoxWidth() {
    }

    default public int getBoundingBoxHeight() {
    }

    default public int getScaledImageWidth() {
    }

    default public int getScaledImageHeight() {
    }

    default public float getRotationY() {
    }

    default public void setRotationY(float f2) {
    }

    default public float getRotationZ() {
    }

    default public int getDefaultRotation() {
    }

    default public boolean isFlipX() {
    }

    default public boolean isFlipY() {
    }

    default public void setRotationZ(float f2) {
    }
}

