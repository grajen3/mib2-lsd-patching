/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.pictureviewertiles;

import de.vw.mib.appadapter.pictureviewertiles.PictureViewerTileSAdapter;
import de.vw.mib.asl.api.pictureviewer.services.PictureViewerControlService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;

class PictureViewerTileSAdapter$1
implements ASLComponentAPICallback {
    private final /* synthetic */ PictureViewerTileSAdapter this$0;

    PictureViewerTileSAdapter$1(PictureViewerTileSAdapter pictureViewerTileSAdapter) {
        this.this$0 = pictureViewerTileSAdapter;
    }

    @Override
    public void registered(Class clazz, Object object) {
        this.this$0.pictureViewerControlService = (PictureViewerControlService)object;
    }
}

