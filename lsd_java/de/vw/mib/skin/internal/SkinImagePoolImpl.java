/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.skin.internal;

import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.hmi.internal.ServiceManagerCommon;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.skin.SkinImagePool;

public final class SkinImagePoolImpl
implements SkinImagePool {
    private static final ScaleImage NULL_SCALEIMAGE = new ScaleImage();
    private static final Image NULL_IMAGE = new Image();
    private static final Image[] NULL_IMAGE_ARRAY = new Image[0];
    private Insets[] insetsCache = null;
    private ScaleImage[] scaleImageCache = null;
    private Image[] imageCache = null;
    private Image[][] imageArrayCache = null;
    private boolean supportsSecondScaleImageBitmap = false;
    private static final int INSETS_DATA_OFFSET_TOP;
    private static final int INSETS_DATA_OFFSET_LEFT;
    private static final int INSETS_DATA_OFFSET_BOTTOM;
    private static final int INSETS_DATA_OFFSET_RIGHT;
    private static final int INSETS_DATA_SLICE;
    private int[] scaleImageData = null;
    private static final int SCALE_IMAGE_DATA_OFFSET_MIFID;
    private static final int SCALE_IMAGE_DATA_OFFSET_INSETSID;
    private static final int SCALE_IMAGE_DATA_OFFSET_SCALEMODE;
    private static final int SCALE_IMAGE_DATA_SLICE;
    private static final int IMAGE_OFFSET_DAY;
    private static final int IMAGE_OFFSET_NIGHT;
    private static final int IMAGE_SLICE;
    private int[] imageArrayData = null;
    private static final int IMAGE_ARRAY_DATA_OFFSET_FIRSTIMAGEINDEX;
    private static final int IMAGE_ARRAY_DATA_OFFSET_IMAGECOUNT;
    private static final int IMAGE_ARRAY_DATA_SLICE;
    private int[] imageArrayReferenceData = null;

    @Override
    public Image[] getImageArray(int n) {
        if (n == -1) {
            return NULL_IMAGE_ARRAY;
        }
        if (this.imageArrayCache[n] == null) {
            this.imageArrayCache[n] = this.createImageArray(n);
        }
        return this.imageArrayCache[n];
    }

    private Image[] createImageArray(int n) {
        int n2 = n * 2;
        int n3 = this.imageArrayData[n2 + 0];
        int n4 = this.imageArrayData[n2 + 1];
        Image[] imageArray = new Image[n4];
        this.fillImageArray(imageArray, n3, n4);
        return imageArray;
    }

    private void fillImageArray(Image[] imageArray, int n, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = this.imageArrayReferenceData[n + i2];
            imageArray[i2] = this.getImage(n3);
        }
    }

    @Override
    public Image getImage(int n) {
        if (n == -1) {
            return NULL_IMAGE;
        }
        if (this.imageCache[n] == null) {
            this.imageCache[n] = this.createImage(n);
        }
        return this.imageCache[n];
    }

    private Image createImage(int n) {
        int n2 = n * 2;
        ScaleImage scaleImage = this.getScaleImage(n2 + 0, n, "day");
        ScaleImage scaleImage2 = this.getScaleImage(n2 + 1, n, "night");
        Image image = new Image(scaleImage, scaleImage2);
        return image;
    }

    private ScaleImage getScaleImage(int n, int n2, String string) {
        if (this.scaleImageCache[n] == null) {
            this.scaleImageCache[n] = this.createScaleImage(n, n2, string);
        }
        return this.scaleImageCache[n];
    }

    private ScaleImage createScaleImage(int n, int n2, String string) {
        int n3;
        int n4 = n * 3;
        int n5 = this.scaleImageData[n4 + 0];
        if (n5 == -1) {
            this.logImageLoadingWarning(n2, string, "missing image (bitmap 1)");
            return NULL_SCALEIMAGE;
        }
        int n6 = -1;
        if (this.supportsSecondScaleImageBitmap) {
            n3 = this.scaleImageData.length / 2;
            n6 = this.scaleImageData[n3 + n4 + 0];
        }
        n3 = this.scaleImageData[n4 + 1];
        Insets insets = this.insetsCache[n3];
        int n7 = this.scaleImageData[n4 + 2];
        return new ScaleImage(n5, n6, insets, n7);
    }

    private void logImageLoadingWarning(int n, String string, String string2) {
        LogMessage logMessage = ServiceManagerCommon.loggerFactory.getLogger(8).warn(4);
        logMessage.append("Unable to access generated ");
        logMessage.append(string);
        logMessage.append("-image id=");
        logMessage.append(n);
        logMessage.append(" (");
        logMessage.append(string2);
        logMessage.append(") - setting to default empty image.");
        logMessage.log();
    }

    void detectFormat(int[] nArray, int[] nArray2) {
        this.supportsSecondScaleImageBitmap = SkinImagePoolImpl.supportsSecondScaleImageBitmap(nArray, nArray2);
        String string = this.supportsSecondScaleImageBitmap ? "new" : "legacy";
        LogMessage logMessage = ServiceManagerCommon.loggerFactory.getLogger(8).info(4);
        logMessage.append("Skin image pool has detected ").append(string).append(" format.").log();
    }

    private static boolean supportsSecondScaleImageBitmap(int[] nArray, int[] nArray2) {
        int n;
        int n2 = nArray.length / 3 / 2;
        int n3 = n2 * 3;
        boolean bl = nArray.length == n3 * 2;
        for (n = 0; bl && n < nArray2.length; ++n) {
            bl = nArray2[n] < n2;
        }
        for (n = 0; bl && n < n3; n += 3) {
            bl = nArray[n + 2] == nArray[n3 + n + 2];
        }
        return bl;
    }

    void setInsetsData(int[] nArray) {
        int n = nArray.length / 4;
        this.insetsCache = new Insets[n];
        int n2 = 0;
        int n3 = 0;
        while (n3 < n) {
            int n4 = nArray[n2 + 0];
            int n5 = nArray[n2 + 1];
            int n6 = nArray[n2 + 2];
            int n7 = nArray[n2 + 3];
            this.insetsCache[n3] = new Insets(n4, n5, n6, n7);
            ++n3;
            n2 += 4;
        }
    }

    void setScaleImageData(int[] nArray) {
        this.scaleImageData = nArray;
        int n = (this.supportsSecondScaleImageBitmap ? nArray.length / 2 : nArray.length) / 3;
        int n2 = n / 2;
        this.scaleImageCache = new ScaleImage[n];
        this.imageCache = new Image[n2];
    }

    void setImageArrayData(int[] nArray, int[] nArray2) {
        this.imageArrayData = nArray;
        this.imageArrayReferenceData = nArray2;
        int n = nArray.length / 2;
        this.imageArrayCache = new Image[n][];
    }
}

