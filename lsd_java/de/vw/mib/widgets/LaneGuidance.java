/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ImageManager;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.widgets.AbstractImage;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.LaneGuidanceModel;
import de.vw.mib.widgets.models.ViewModel;
import java.io.IOException;
import java.util.Arrays;

public class LaneGuidance
extends AbstractImage
implements LaneGuidanceModel {
    private int[] laneDirection;
    private int[] laneInfo;
    private int[] laneMarkingLeft;
    private int[] laneMarkingRight;
    private Image[] laneImages;
    private Image[] laneMarkingImages;
    private Image laneSeparatorImage;
    private int numberOfVisibleLanes;
    private int steeringWheelSide;
    private static final ImageManager IM = ServiceManager.imageManager;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$LaneGuidanceUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$CustomImageLaneGuidanceUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ETCGuidanceUI;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$ETC2GuidanceUI;

    @Override
    protected void reset() {
        super.reset();
    }

    public void init(boolean bl, int n, boolean bl2, Color color, int n2, Color color2, boolean bl3, EasingParams[] easingParamsArray, boolean bl4, int n3, int[] nArray, Image[] imageArray, int[] nArray2, Image[] imageArray2, int[] nArray3, int[] nArray4, Image image, boolean bl5, String string, int n4, int n5, int n6, Insets insets, boolean bl6, int n7, int n8, int n9) {
        super.init(bl, n, bl2, color, n2, color2, bl3, easingParamsArray, bl4, n3, bl5, string, n6, insets, bl6, n7, n8, n9);
        this.laneDirection = nArray;
        this.laneImages = imageArray;
        this.laneInfo = nArray2;
        this.laneMarkingLeft = nArray3;
        this.laneMarkingImages = imageArray2;
        this.laneMarkingRight = nArray4;
        this.laneSeparatorImage = image;
        this.numberOfVisibleLanes = n4;
        this.steeringWheelSide = n5;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.laneSeparatorImage);
        this.calculateDimension();
    }

    @Override
    public final int[] get_laneDirection() {
        return this.laneDirection;
    }

    @Override
    public final void set_laneDirection(int[] nArray) {
        int[] nArray2 = this.laneDirection;
        if (!Arrays.equals(nArray2, nArray)) {
            this.laneDirection = nArray;
            this.laneDirectionChanged(nArray2);
            this.propertyChanged(20);
        }
    }

    @Override
    public final int[] get_laneInfo() {
        return this.laneInfo;
    }

    @Override
    public final void set_laneInfo(int[] nArray) {
        int[] nArray2 = this.laneInfo;
        if (!Arrays.equals(nArray2, nArray)) {
            this.laneInfo = nArray;
            this.laneInfoChanged(nArray2);
            this.propertyChanged(22);
        }
    }

    @Override
    public final int[] get_laneMarkingLeft() {
        return this.laneMarkingLeft;
    }

    @Override
    public final void set_laneMarkingLeft(int[] nArray) {
        int[] nArray2 = this.laneMarkingLeft;
        if (!Arrays.equals(nArray2, nArray)) {
            this.laneMarkingLeft = nArray;
            this.laneMarkingLeftChanged(nArray2);
            this.propertyChanged(23);
        }
    }

    @Override
    public final int[] get_laneMarkingRight() {
        return this.laneMarkingRight;
    }

    @Override
    public final void set_laneMarkingRight(int[] nArray) {
        int[] nArray2 = this.laneMarkingRight;
        if (!Arrays.equals(nArray2, nArray)) {
            this.laneMarkingRight = nArray;
            this.laneMarkingRightChanged(nArray2);
            this.propertyChanged(25);
        }
    }

    @Override
    public final Image[] get_laneImages() {
        return this.laneImages;
    }

    @Override
    public final void set_laneImages(Image[] imageArray) {
        Object[] objectArray = this.laneImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.laneImages = imageArray;
            this.laneImagesChanged((Image[])objectArray);
            this.propertyChanged(21);
        }
    }

    @Override
    public final Image[] get_laneMarkingImages() {
        return this.laneMarkingImages;
    }

    @Override
    public final void set_laneMarkingImages(Image[] imageArray) {
        Object[] objectArray = this.laneMarkingImages;
        if (!Arrays.equals(objectArray, imageArray)) {
            this.laneMarkingImages = imageArray;
            this.laneMarkingImagesChanged((Image[])objectArray);
            this.propertyChanged(24);
        }
    }

    @Override
    public final Image get_laneSeparatorImage() {
        return this.laneSeparatorImage;
    }

    @Override
    public final void set_laneSeparatorImage(Image image) {
        Image image2 = this.laneSeparatorImage;
        if (image2 == null || !image2.equals(image)) {
            this.laneSeparatorImage = image;
            this.laneSeparatorImageChanged(image2);
            this.propertyChanged(26);
        }
    }

    @Override
    public final int get_numberOfVisibleLanes() {
        return this.numberOfVisibleLanes;
    }

    @Override
    public final void set_numberOfVisibleLanes(int n) {
        int n2 = this.numberOfVisibleLanes;
        if (n2 != n) {
            this.numberOfVisibleLanes = n;
            this.numberOfVisibleLanesChanged(n2);
            this.propertyChanged(27);
        }
    }

    @Override
    public final int get_steeringWheelSide() {
        return this.steeringWheelSide;
    }

    @Override
    public final void set_steeringWheelSide(int n) {
        int n2 = this.steeringWheelSide;
        if (n2 != n) {
            this.steeringWheelSide = n;
            this.steeringWheelSideChanged(n2);
            this.propertyChanged(28);
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$LaneGuidanceUI == null ? (class$de$vw$mib$widgets$ui$LaneGuidanceUI = LaneGuidance.class$("de.vw.mib.widgets.ui.LaneGuidanceUI")) : class$de$vw$mib$widgets$ui$LaneGuidanceUI, class$de$vw$mib$widgets$ui$CustomImageLaneGuidanceUI == null ? (class$de$vw$mib$widgets$ui$CustomImageLaneGuidanceUI = LaneGuidance.class$("de.vw.mib.widgets.ui.CustomImageLaneGuidanceUI")) : class$de$vw$mib$widgets$ui$CustomImageLaneGuidanceUI, class$de$vw$mib$widgets$ui$ETCGuidanceUI == null ? (class$de$vw$mib$widgets$ui$ETCGuidanceUI = LaneGuidance.class$("de.vw.mib.widgets.ui.ETCGuidanceUI")) : class$de$vw$mib$widgets$ui$ETCGuidanceUI, class$de$vw$mib$widgets$ui$ETC2GuidanceUI == null ? (class$de$vw$mib$widgets$ui$ETC2GuidanceUI = LaneGuidance.class$("de.vw.mib.widgets.ui.ETC2GuidanceUI")) : class$de$vw$mib$widgets$ui$ETC2GuidanceUI};
    }

    protected void laneDirectionChanged(int[] nArray) {
        this.calculateDimension();
    }

    protected void laneInfoChanged(int[] nArray) {
        this.calculateDimension();
    }

    protected void laneMarkingLeftChanged(int[] nArray) {
        this.calculateDimension();
    }

    protected void laneMarkingRightChanged(int[] nArray) {
        this.calculateDimension();
    }

    protected void laneImagesChanged(Image[] imageArray) {
        this.calculateDimension();
    }

    protected void laneMarkingImagesChanged(Image[] imageArray) {
        this.calculateDimension();
    }

    protected void laneSeparatorImageChanged(Image image) {
        this.calculateDimension();
    }

    private void numberOfVisibleLanesChanged(int n) {
        this.calculateDimension();
    }

    private void steeringWheelSideChanged(int n) {
    }

    private void calculateDimension() {
        if (this.laneDirection != null && this.laneDirection.length > 0 && this.laneInfo != null && this.laneInfo.length > 0) {
            try {
                BufferImage bufferImage;
                ScaleImage scaleImage;
                int n = Math.min(this.laneDirection.length, this.numberOfVisibleLanes);
                int n2 = 0;
                int n3 = 0;
                if (this.laneImages != null && this.laneImages.length > 0) {
                    scaleImage = this.laneImages[0].getCurrentImage();
                    bufferImage = IM.getImageFromCurrentSkin(scaleImage);
                    n2 += n * bufferImage.getWidth();
                    n3 = Math.max(n3, bufferImage.getHeight());
                }
                if (this.laneSeparatorImage != null) {
                    scaleImage = this.laneSeparatorImage.getCurrentImage();
                    bufferImage = IM.getImageFromCurrentSkin(scaleImage);
                    n2 += (n - 1) * bufferImage.getWidth();
                    n3 = Math.max(n3, bufferImage.getHeight());
                }
                if (this.laneMarkingImages != null && this.laneMarkingImages.length > 0) {
                    scaleImage = this.laneMarkingImages[0].getCurrentImage();
                    bufferImage = IM.getImageFromCurrentSkin(scaleImage);
                    n2 += 2 * bufferImage.getWidth();
                    n3 = Math.max(n3, bufferImage.getHeight());
                }
                this.set_width(n2);
                this.set_height(n3);
            }
            catch (IOException iOException) {
                LOGGER.error(256).append("Widget '").append(this.getQualifiedName()).append("': Unable to load lane image. '").append(iOException).log();
            }
        }
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

