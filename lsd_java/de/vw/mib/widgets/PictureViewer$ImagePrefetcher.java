/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.DynamicImage$ImageLoadingHandler;
import de.vw.mib.widgets.PictureViewer;
import de.vw.mib.widgets.internal.ServiceManager;
import org.dsi.ifc.global.ResourceLocator;

public final class PictureViewer$ImagePrefetcher
extends DynamicImage$ImageLoadingHandler {
    private final /* synthetic */ PictureViewer this$0;

    protected PictureViewer$ImagePrefetcher(PictureViewer pictureViewer) {
        this.this$0 = pictureViewer;
        super(pictureViewer);
    }

    public void prefetchImage(ResourceLocator resourceLocator, boolean bl) {
        if (bl) {
            ServiceManager.imageManager.getImageInfoFromResource(resourceLocator, this);
        } else {
            boolean bl2 = false;
            ServiceManager.imageManager.getImageFromResource(resourceLocator, this, false);
        }
    }

    @Override
    protected void checkLoadingComplete() {
    }

    @Override
    protected boolean isResourceRelevant(ResourceLocator resourceLocator) {
        return true;
    }
}

