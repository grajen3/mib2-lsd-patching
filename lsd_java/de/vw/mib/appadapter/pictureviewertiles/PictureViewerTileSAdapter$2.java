/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.pictureviewertiles;

import de.vw.mib.appadapter.pictureviewertiles.PictureViewerTileSAdapter;
import de.vw.mib.asl.api.pictureviewer.services.PictureViewerCurrentPictureService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

class PictureViewerTileSAdapter$2
implements ASLComponentAPICallback {
    private final /* synthetic */ PictureViewerTileSAdapter this$0;

    PictureViewerTileSAdapter$2(PictureViewerTileSAdapter pictureViewerTileSAdapter) {
        this.this$0 = pictureViewerTileSAdapter;
    }

    @Override
    public void registered(Class clazz, Object object) {
        this.this$0.pictureViewerCurrentPictureService = (PictureViewerCurrentPictureService)object;
        this.this$0.pictureViewerCurrentPictureService.register(this.this$0);
    }
}

