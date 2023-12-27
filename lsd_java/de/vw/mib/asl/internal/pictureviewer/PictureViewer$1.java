/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.pictureviewer;

import de.vw.mib.asl.internal.pictureviewer.PictureViewer;
import de.vw.mib.asl.internal.pictureviewer.PictureViewerExifGpsData;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.ExifInfo;
import de.vw.mib.graphics.image.ImageInfo;
import de.vw.mib.graphics.image.ImageLoadingListener;
import org.dsi.ifc.global.ResourceLocator;

class PictureViewer$1
implements ImageLoadingListener {
    private final /* synthetic */ PictureViewer this$0;

    PictureViewer$1(PictureViewer pictureViewer) {
        this.this$0 = pictureViewer;
    }

    @Override
    public void exifInfoAvailable(ResourceLocator resourceLocator, int n, int[] nArray, ExifInfo exifInfo) {
        PictureViewerExifGpsData pictureViewerExifGpsData = new PictureViewerExifGpsData(exifInfo);
        this.this$0.updateGPSInformation(pictureViewerExifGpsData.containsGpsData());
    }

    @Override
    public void exifInfoError(ResourceLocator resourceLocator, int n, int[] nArray, Exception exception) {
        this.this$0.updateGPSInformation(false);
    }

    @Override
    public void thumbnailImageError(ResourceLocator resourceLocator, Exception exception) {
    }

    @Override
    public void thumbnailImageAvailable(ResourceLocator resourceLocator, BufferImage bufferImage) {
    }

    @Override
    public void imageLoadingProgress(ResourceLocator resourceLocator, int n) {
    }

    @Override
    public void imageInfoError(ResourceLocator resourceLocator, Exception exception) {
    }

    @Override
    public void imageInfoAvailable(ResourceLocator resourceLocator, ImageInfo imageInfo) {
    }

    @Override
    public void imageError(ResourceLocator resourceLocator, Exception exception) {
    }

    @Override
    public void imageAvailable(ResourceLocator resourceLocator, BufferImage bufferImage) {
    }
}

